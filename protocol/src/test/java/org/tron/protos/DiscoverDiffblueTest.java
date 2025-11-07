package org.tron.protos;

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
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;

public class DiscoverDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Discover.BackupMessage#equals(Object)}
   *   <li>{@link Discover.BackupMessage#hashCode()}
   * </ul>
   */
  @Test
  public void testBackupMessageEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Discover.BackupMessage defaultInstance = Discover.BackupMessage.getDefaultInstance();
    Discover.BackupMessage defaultInstance2 = Discover.BackupMessage.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Discover.BackupMessage#equals(Object)}
   *   <li>{@link Discover.BackupMessage#hashCode()}
   * </ul>
   */
  @Test
  public void testBackupMessageEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Discover.BackupMessage defaultInstance = Discover.BackupMessage.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link Discover.BackupMessage#equals(Object)}
   */
  @Test
  public void testBackupMessageEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.BackupMessage.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link Discover.BackupMessage#equals(Object)}
   */
  @Test
  public void testBackupMessageEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.BackupMessage.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link Discover.BackupMessage#equals(Object)}
   */
  @Test
  public void testBackupMessageEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.BackupMessage.getDefaultInstance(), "Different type to BackupMessage");
  }

  /**
   * Method under test: {@link Discover.BackupMessage#getDefaultInstanceForType()}
   */
  @Test
  public void testBackupMessageGetDefaultInstanceForType() {
    // Arrange
    Discover.BackupMessage defaultInstance = Discover.BackupMessage.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link Discover.BackupMessage#getDescriptor()}
   */
  @Test
  public void testBackupMessageGetDescriptor() {
    // Arrange and Act
    Descriptors.Descriptor actualDescriptor = Discover.BackupMessage.getDescriptor();

    // Assert
    DescriptorProtos.DescriptorProto toProtoResult = actualDescriptor.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = actualDescriptor.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = actualDescriptor.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = actualDescriptor.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", actualDescriptor.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    assertEquals("Endpoint", toProtoResult6.getName());
    assertEquals("Endpoint", getResult2.getName());
    Descriptors.Descriptor descriptorForType3 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType7.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType2.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType7.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult7.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult7.getName());
    assertEquals("priority", getResult3.getJsonName());
    assertEquals("priority", getResult3.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", actualDescriptor.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult3.getFullName());
    assertEquals("protocol.Endpoint", getResult2.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(actualDescriptor.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult2.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = options2.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType6.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult7.getNumber());
    assertEquals(2, descriptorForType2.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType2.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult6.getFieldCount());
    assertEquals(4, descriptorForType4.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult2.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult7.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, actualDescriptor.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(78, toProtoResult6.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult3.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult3.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult3.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(descriptorForType4.isExtendable());
    assertFalse(descriptorForType6.isExtendable());
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(actualDescriptor.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType3.isExtendable());
    assertTrue(descriptorForType.isExtendable());
    assertTrue(descriptorForType5.isExtendable());
    assertTrue(descriptorForType7.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult7.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult5.getEnumTypes().isEmpty());
    List<Descriptors.EnumDescriptor> enumTypes = actualDescriptor.getEnumTypes();
    assertTrue(enumTypes.isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult5.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = options2.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(enumTypes, defaultInstanceForType2.findInitializationErrors());
    assertEquals(enumTypes, defaultInstanceForType3.findInitializationErrors());
    assertEquals(enumTypes, sourceCodeInfo.findInitializationErrors());
    assertEquals(enumTypes, defaultInstanceForType4.findInitializationErrors());
    assertEquals(enumTypes, toProtoResult4.findInitializationErrors());
    assertEquals(enumTypes, toProtoResult5.findInitializationErrors());
    assertEquals(enumTypes, toProtoResult6.findInitializationErrors());
    assertEquals(enumTypes, descriptorForType6.getEnumTypes());
    assertEquals(enumTypes, getResult4.getEnumTypes());
    assertEquals(enumTypes, descriptorForType3.getExtensions());
    assertEquals(enumTypes, descriptorForType5.getExtensions());
    assertEquals(enumTypes, descriptorForType4.getExtensions());
    assertEquals(enumTypes, descriptorForType7.getExtensions());
    assertEquals(enumTypes, descriptorForType6.getExtensions());
    assertEquals(enumTypes, getResult4.getExtensions());
    assertEquals(enumTypes, descriptorForType3.getNestedTypes());
    assertEquals(enumTypes, descriptorForType4.getNestedTypes());
    assertEquals(enumTypes, descriptorForType7.getNestedTypes());
    assertEquals(enumTypes, descriptorForType6.getNestedTypes());
    assertEquals(enumTypes, getResult5.getNestedTypes());
    assertEquals(enumTypes, getResult4.getNestedTypes());
    assertEquals(enumTypes, descriptorForType3.getOneofs());
    assertEquals(enumTypes, descriptorForType5.getOneofs());
    assertEquals(enumTypes, descriptorForType4.getOneofs());
    assertEquals(enumTypes, descriptorForType7.getOneofs());
    assertEquals(enumTypes, descriptorForType6.getOneofs());
    assertEquals(enumTypes, getResult5.getOneofs());
    assertEquals(enumTypes, getResult4.getOneofs());
    assertEquals(enumTypes, descriptorForType3.getRealOneofs());
    assertEquals(enumTypes, descriptorForType5.getRealOneofs());
    assertEquals(enumTypes, descriptorForType4.getRealOneofs());
    assertEquals(enumTypes, descriptorForType7.getRealOneofs());
    assertEquals(enumTypes, descriptorForType6.getRealOneofs());
    assertEquals(enumTypes, getResult5.getRealOneofs());
    assertEquals(enumTypes, getResult4.getRealOneofs());
    assertEquals(enumTypes, file2.getDependencies());
    assertEquals(enumTypes, file2.getExtensions());
    assertEquals(enumTypes, file2.getPublicDependencies());
    assertEquals(enumTypes, file2.getServices());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType3.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType7.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType2.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType5.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('i', iteratorResult7.next().byteValue());
    assertEquals('i', iteratorResult8.next().byteValue());
    assertEquals('o', iteratorResult4.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertEquals('r', iteratorResult5.next().byteValue());
    assertEquals('r', iteratorResult6.next().byteValue());
    assertEquals('r', iteratorResult9.next().byteValue());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult5.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType6 = defaultInstanceForType2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType6, defaultInstanceForType6);
    assertSame(defaultInstanceForType6, toProtoResult7.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions defaultInstanceForType7 = defaultInstanceForType4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType7, defaultInstanceForType3.getOptions());
    assertSame(defaultInstanceForType7, defaultInstanceForType3.getOptionsOrBuilder());
    assertSame(defaultInstanceForType7, defaultInstanceForType7);
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType4.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file2, descriptorForType3.getFile());
    assertSame(file2, descriptorForType2.getFile());
    assertSame(file2, descriptorForType5.getFile());
    assertSame(file2, descriptorForType4.getFile());
    assertSame(file2, descriptorForType7.getFile());
    assertSame(file2, descriptorForType6.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(options2, defaultInstanceForType.getOptions());
    assertSame(options2, toProtoResult4.getOptions());
    assertSame(options2, toProtoResult5.getOptions());
    assertSame(options2, toProtoResult6.getOptions());
    assertSame(options2, toProtoResult.getOptions());
    assertSame(options2, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, descriptorForType3.getOptions());
    assertSame(options2, descriptorForType.getOptions());
    assertSame(options2, descriptorForType2.getOptions());
    assertSame(options2, descriptorForType5.getOptions());
    assertSame(options2, descriptorForType4.getOptions());
    assertSame(options2, descriptorForType7.getOptions());
    assertSame(options2, descriptorForType6.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult6, messageTypeList.get(0));
    assertSame(toProtoResult, messageTypeList.get(5));
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(toProtoResult2, fieldList.get(0));
    assertSame(toProtoResult7, fieldList.get(1));
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    Descriptors.Descriptor descriptorForType8 = toProtoResult5.getDescriptorForType();
    assertSame(descriptorForType8, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType8, toProtoResult4.getDescriptorForType());
    assertSame(descriptorForType8, descriptorForType8);
    assertSame(descriptorForType8, toProtoResult6.getDescriptorForType());
    assertSame(descriptorForType4, defaultInstanceForType2.getDescriptorForType());
    assertSame(descriptorForType4, toProtoResult7.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(actualDescriptor, getResult.getContainingType());
    assertSame(actualDescriptor, getResult3.getContainingType());
    assertSame(actualDescriptor, messageTypes.get(5));
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test: {@link Discover.BackupMessage#getSerializedSize()}
   */
  @Test
  public void testBackupMessageGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Discover.BackupMessage.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link Discover.BackupMessage#isInitialized()}
   */
  @Test
  public void testBackupMessageIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Discover.BackupMessage.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testBackupMessageNewInstance() {
    // Arrange
    Discover.BackupMessage defaultInstance = Discover.BackupMessage.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof Discover.BackupMessage);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testBackupMessageParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Discover.BackupMessage actualParseDelimitedFromResult = Discover.BackupMessage.parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseDelimitedFromResult.getPriority());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertFalse(actualParseDelimitedFromResult.getFlag());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseDelimitedFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseDelimitedFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testBackupMessageParseDelimitedFrom2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Discover.BackupMessage.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testBackupMessageParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.BackupMessage.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testBackupMessageParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Discover.BackupMessage.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBackupMessageParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Discover.BackupMessage actualParseDelimitedFromResult = Discover.BackupMessage.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseDelimitedFromResult.getPriority());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertFalse(actualParseDelimitedFromResult.getFlag());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseDelimitedFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseDelimitedFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBackupMessageParseDelimitedFrom6() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Discover.BackupMessage.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBackupMessageParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> Discover.BackupMessage.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBackupMessageParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Discover.BackupMessage.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link Discover.BackupMessage#parseFrom(ByteString)}
   */
  @Test
  public void testBackupMessageParseFrom() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Discover.BackupMessage actualParseFromResult = Discover.BackupMessage.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getPriority());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(actualParseFromResult.getFlag());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult6.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult6.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult6.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult6.getTypeNameBytes());
    assertEquals(byteString, defaultInstanceForType3.getNameBytes());
    assertEquals(byteString, defaultInstanceForType3.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(byteString, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  public void testBackupMessageParseFrom2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Discover.BackupMessage actualParseFromResult = Discover.BackupMessage.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getPriority());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(actualParseFromResult.getFlag());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult6.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult6.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult6.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult6.getTypeNameBytes());
    assertEquals(byteString, defaultInstanceForType3.getNameBytes());
    assertEquals(byteString, defaultInstanceForType3.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(byteString, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test: {@link Discover.BackupMessage#parseFrom(CodedInputStream)}
   */
  @Test
  public void testBackupMessageParseFrom3() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Discover.BackupMessage actualParseFromResult = Discover.BackupMessage.parseFrom(input);

    // Assert
    verify(input).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getPriority());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertFalse(actualParseFromResult.getFlag());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBackupMessageParseFrom4() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Discover.BackupMessage actualParseFromResult = Discover.BackupMessage.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getPriority());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertFalse(actualParseFromResult.getFlag());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test: {@link Discover.BackupMessage#parseFrom(InputStream)}
   */
  @Test
  public void testBackupMessageParseFrom5() throws IOException {
    // Arrange and Act
    Discover.BackupMessage actualParseFromResult = Discover.BackupMessage
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getPriority());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertFalse(actualParseFromResult.getFlag());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test: {@link Discover.BackupMessage#parseFrom(InputStream)}
   */
  @Test
  public void testBackupMessageParseFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.BackupMessage.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link Discover.BackupMessage#parseFrom(InputStream)}
   */
  @Test
  public void testBackupMessageParseFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Discover.BackupMessage.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link Discover.BackupMessage#parseFrom(InputStream)}
   */
  @Test
  public void testBackupMessageParseFrom8() throws IOException {
    // Arrange and Act
    Discover.BackupMessage actualParseFromResult = Discover.BackupMessage.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getPriority());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertFalse(actualParseFromResult.getFlag());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBackupMessageParseFrom9() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Discover.BackupMessage actualParseFromResult = Discover.BackupMessage.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getPriority());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertFalse(actualParseFromResult.getFlag());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBackupMessageParseFrom10() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> Discover.BackupMessage.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testBackupMessageParseFrom11() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Discover.BackupMessage.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link Discover.BackupMessage#parseFrom(ByteBuffer)}
   */
  @Test
  public void testBackupMessageParseFrom12() throws InvalidProtocolBufferException {
    // Arrange and Act
    Discover.BackupMessage actualParseFromResult = Discover.BackupMessage.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getPriority());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertFalse(actualParseFromResult.getFlag());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  public void testBackupMessageParseFrom13() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Discover.BackupMessage actualParseFromResult = Discover.BackupMessage.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getPriority());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertFalse(actualParseFromResult.getFlag());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test: {@link Discover.BackupMessage#parseFrom(byte[])}
   */
  @Test
  public void testBackupMessageParseFrom14() throws InvalidProtocolBufferException {
    // Arrange and Act
    Discover.BackupMessage actualParseFromResult = Discover.BackupMessage.parseFrom(new byte[]{});

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getPriority());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertFalse(actualParseFromResult.getFlag());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link Discover.BackupMessage#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  public void testBackupMessageParseFrom15() throws InvalidProtocolBufferException {
    // Arrange and Act
    Discover.BackupMessage actualParseFromResult = Discover.BackupMessage.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertEquals("Endpoint", getResult3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType7.getName());
    Descriptors.Descriptor descriptorForType8 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType8.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType7.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType8.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult6.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult6.getName());
    assertEquals("priority", getResult2.getJsonName());
    assertEquals("priority", getResult2.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", descriptorForType.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult2.getFullName());
    assertEquals("protocol.Endpoint", getResult3.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getPriority());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult7.getFieldCount());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult3.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult6.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, descriptorForType.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertFalse(actualParseFromResult.getFlag());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult6.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(5));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test: {@link Discover.BackupMessage.Builder#getDescriptor()}
   */
  @Test
  public void testBackupMessage_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptors.Descriptor actualDescriptor = Discover.BackupMessage.Builder.getDescriptor();

    // Assert
    DescriptorProtos.DescriptorProto toProtoResult = actualDescriptor.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = actualDescriptor.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    Descriptors.FileDescriptor file = actualDescriptor.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = actualDescriptor.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType2.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(6, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType4.getJavaPackage());
    assertEquals("", defaultInstanceForType4.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType4.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType4.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType4.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType4.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("BackupMessage", nameBytes.toStringUtf8());
    assertEquals("BackupMessage", toProtoResult.getName());
    assertEquals("BackupMessage", actualDescriptor.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Discover", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Discover", options.getJavaOuterClassname());
    assertEquals("Endpoint", toProtoResult6.getName());
    assertEquals("Endpoint", getResult2.getName());
    Descriptors.Descriptor descriptorForType3 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType7.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType.getName());
    Descriptors.Descriptor getResult4 = messageTypes.get(4);
    assertEquals("Neighbours", getResult4.getName());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals("PingMessage", getResult5.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Discover.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Discover.proto", toProtoResult3.getName());
    assertEquals("core/Discover.proto", file.getFullName());
    assertEquals("core/Discover.proto", file.getName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("flag", nameBytes3.toStringUtf8());
    assertEquals("flag", toProtoResult2.getName());
    assertEquals("flag", getResult.getJsonName());
    assertEquals("flag", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType2.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType7.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString nameBytes4 = toProtoResult7.getNameBytes();
    assertEquals("priority", nameBytes4.toStringUtf8());
    assertEquals("priority", toProtoResult7.getName());
    assertEquals("priority", getResult3.getJsonName());
    assertEquals("priority", getResult3.getName());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.BackupMessage", actualDescriptor.getFullName());
    assertEquals("protocol.BackupMessage.flag", getResult.getFullName());
    assertEquals("protocol.BackupMessage.priority", getResult3.getFullName());
    assertEquals("protocol.Endpoint", getResult2.getFullName());
    assertEquals("protocol.Neighbours", getResult4.getFullName());
    assertEquals("protocol.PingMessage", getResult5.getFullName());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(actualDescriptor.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
    assertEquals(0, toProtoResult3.getDependencyCount());
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType3.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, defaultInstanceForType3.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType3.getPublicDependencyCount());
    assertEquals(0, toProtoResult3.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getServiceCount());
    assertEquals(0, toProtoResult3.getServiceCount());
    assertEquals(0, defaultInstanceForType3.getWeakDependencyCount());
    assertEquals(0, toProtoResult3.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult2.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = options2.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType6.getIndex());
    assertEquals(1, getResult5.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult7.getNumber());
    assertEquals(2, descriptorForType2.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType2.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(4, toProtoResult6.getFieldCount());
    assertEquals(4, descriptorForType4.getIndex());
    assertEquals(4, getResult4.getIndex());
    assertEquals(4, getResult2.getFields().size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(4, toProtoResult7.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, actualDescriptor.getIndex());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(6, messageTypeList.size());
    assertEquals(635, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType.getFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(78, toProtoResult6.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult3.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult3.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult3.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes4.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType3.hasEdition());
    assertFalse(toProtoResult3.hasEdition());
    assertFalse(defaultInstanceForType3.hasName());
    assertFalse(defaultInstanceForType3.hasOptions());
    assertFalse(defaultInstanceForType3.hasPackage());
    assertFalse(defaultInstanceForType3.hasSourceCodeInfo());
    assertFalse(toProtoResult3.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType3.hasSyntax());
    assertFalse(defaultInstanceForType4.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType4.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType4.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType4.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType4.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType4.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType4.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType4.hasGoPackage());
    assertFalse(defaultInstanceForType4.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType4.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType4.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType4.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType4.hasJavaPackage());
    assertFalse(defaultInstanceForType4.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType4.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType4.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType4.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType4.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType4.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType4.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType4.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType4.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType4.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(descriptorForType4.isExtendable());
    assertFalse(descriptorForType6.isExtendable());
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(actualDescriptor.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult3.hasOptions());
    assertTrue(toProtoResult3.hasPackage());
    assertTrue(toProtoResult3.hasSyntax());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(defaultInstanceForType4.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType3.isExtendable());
    assertTrue(descriptorForType.isExtendable());
    assertTrue(descriptorForType5.isExtendable());
    assertTrue(descriptorForType7.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes4.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = nameBytes2.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = packageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = syntaxBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = goPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    ByteString.ByteIterator iteratorResult8 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult8.hasNext());
    ByteString.ByteIterator iteratorResult9 = javaPackageBytes.iterator();
    assertTrue(iteratorResult9.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult7.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    List<Integer> publicDependencyList = toProtoResult3.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult5.getEnumTypes().isEmpty());
    List<Descriptors.EnumDescriptor> enumTypes = actualDescriptor.getEnumTypes();
    assertTrue(enumTypes.isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult5.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(actualDescriptor.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = options2.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(enumTypes, defaultInstanceForType2.findInitializationErrors());
    assertEquals(enumTypes, defaultInstanceForType3.findInitializationErrors());
    assertEquals(enumTypes, sourceCodeInfo.findInitializationErrors());
    assertEquals(enumTypes, defaultInstanceForType4.findInitializationErrors());
    assertEquals(enumTypes, toProtoResult4.findInitializationErrors());
    assertEquals(enumTypes, toProtoResult5.findInitializationErrors());
    assertEquals(enumTypes, toProtoResult6.findInitializationErrors());
    assertEquals(enumTypes, descriptorForType6.getEnumTypes());
    assertEquals(enumTypes, getResult4.getEnumTypes());
    assertEquals(enumTypes, descriptorForType3.getExtensions());
    assertEquals(enumTypes, descriptorForType5.getExtensions());
    assertEquals(enumTypes, descriptorForType4.getExtensions());
    assertEquals(enumTypes, descriptorForType7.getExtensions());
    assertEquals(enumTypes, descriptorForType6.getExtensions());
    assertEquals(enumTypes, getResult4.getExtensions());
    assertEquals(enumTypes, descriptorForType3.getNestedTypes());
    assertEquals(enumTypes, descriptorForType4.getNestedTypes());
    assertEquals(enumTypes, descriptorForType7.getNestedTypes());
    assertEquals(enumTypes, descriptorForType6.getNestedTypes());
    assertEquals(enumTypes, getResult5.getNestedTypes());
    assertEquals(enumTypes, getResult4.getNestedTypes());
    assertEquals(enumTypes, descriptorForType3.getOneofs());
    assertEquals(enumTypes, descriptorForType5.getOneofs());
    assertEquals(enumTypes, descriptorForType4.getOneofs());
    assertEquals(enumTypes, descriptorForType7.getOneofs());
    assertEquals(enumTypes, descriptorForType6.getOneofs());
    assertEquals(enumTypes, getResult5.getOneofs());
    assertEquals(enumTypes, getResult4.getOneofs());
    assertEquals(enumTypes, descriptorForType3.getRealOneofs());
    assertEquals(enumTypes, descriptorForType5.getRealOneofs());
    assertEquals(enumTypes, descriptorForType4.getRealOneofs());
    assertEquals(enumTypes, descriptorForType7.getRealOneofs());
    assertEquals(enumTypes, descriptorForType6.getRealOneofs());
    assertEquals(enumTypes, getResult5.getRealOneofs());
    assertEquals(enumTypes, getResult4.getRealOneofs());
    assertEquals(enumTypes, file2.getDependencies());
    assertEquals(enumTypes, file2.getExtensions());
    assertEquals(enumTypes, file2.getPublicDependencies());
    assertEquals(enumTypes, file2.getServices());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(Protocol.Account.ALLOWANCE_FIELD_NUMBER, descriptorForType.getIndex());
    assertEquals(Protocol.Account.FREE_NET_USAGE_FIELD_NUMBER, descriptorForType3.getIndex());
    assertEquals(Protocol.Account.FROZEN_SUPPLY_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType7.getIndex());
    assertEquals(Protocol.Account.LATEST_OPRATION_TIME_FIELD_NUMBER, descriptorForType2.getFields().size());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, toProtoResult2.getSerializedSize());
    assertEquals(Protocol.Account.LATEST_WITHDRAW_TIME_FIELD_NUMBER, descriptorForType5.getIndex());
    assertEquals(Protocol.Account.TRON_POWER_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals('B', iteratorResult.next().byteValue());
    assertEquals('D', iteratorResult8.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult4.next().byteValue());
    assertEquals('f', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult7.next().byteValue());
    assertEquals('i', iteratorResult7.next().byteValue());
    assertEquals('i', iteratorResult8.next().byteValue());
    assertEquals('o', iteratorResult4.next().byteValue());
    assertEquals('o', iteratorResult9.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult6.next().byteValue());
    assertEquals('r', iteratorResult5.next().byteValue());
    assertEquals('r', iteratorResult6.next().byteValue());
    assertEquals('r', iteratorResult9.next().byteValue());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult5.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType6 = defaultInstanceForType2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType6, defaultInstanceForType6);
    assertSame(defaultInstanceForType6, toProtoResult7.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType3.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType3.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions defaultInstanceForType7 = defaultInstanceForType4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType7, defaultInstanceForType3.getOptions());
    assertSame(defaultInstanceForType7, defaultInstanceForType3.getOptionsOrBuilder());
    assertSame(defaultInstanceForType7, defaultInstanceForType7);
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType4.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file2, descriptorForType3.getFile());
    assertSame(file2, descriptorForType2.getFile());
    assertSame(file2, descriptorForType5.getFile());
    assertSame(file2, descriptorForType4.getFile());
    assertSame(file2, descriptorForType7.getFile());
    assertSame(file2, descriptorForType6.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(options2, defaultInstanceForType.getOptions());
    assertSame(options2, toProtoResult4.getOptions());
    assertSame(options2, toProtoResult5.getOptions());
    assertSame(options2, toProtoResult6.getOptions());
    assertSame(options2, toProtoResult.getOptions());
    assertSame(options2, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, descriptorForType3.getOptions());
    assertSame(options2, descriptorForType.getOptions());
    assertSame(options2, descriptorForType2.getOptions());
    assertSame(options2, descriptorForType5.getOptions());
    assertSame(options2, descriptorForType4.getOptions());
    assertSame(options2, descriptorForType7.getOptions());
    assertSame(options2, descriptorForType6.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult6, messageTypeList.get(0));
    assertSame(toProtoResult, messageTypeList.get(5));
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(toProtoResult2, fieldList.get(0));
    assertSame(toProtoResult7, fieldList.get(1));
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    Descriptors.Descriptor descriptorForType8 = toProtoResult5.getDescriptorForType();
    assertSame(descriptorForType8, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType8, toProtoResult4.getDescriptorForType());
    assertSame(descriptorForType8, descriptorForType8);
    assertSame(descriptorForType8, toProtoResult6.getDescriptorForType());
    assertSame(descriptorForType4, defaultInstanceForType2.getDescriptorForType());
    assertSame(descriptorForType4, toProtoResult7.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(actualDescriptor, getResult.getContainingType());
    assertSame(actualDescriptor, getResult3.getContainingType());
    assertSame(actualDescriptor, messageTypes.get(5));
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Discover.Endpoint#equals(Object)}
   *   <li>{@link Discover.Endpoint#hashCode()}
   * </ul>
   */
  @Test
  public void testEndpointEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Discover.Endpoint defaultInstance = Discover.Endpoint.getDefaultInstance();
    Discover.Endpoint defaultInstance2 = Discover.Endpoint.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Discover.Endpoint#equals(Object)}
   *   <li>{@link Discover.Endpoint#hashCode()}
   * </ul>
   */
  @Test
  public void testEndpointEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Discover.Endpoint defaultInstance = Discover.Endpoint.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link Discover.Endpoint#equals(Object)}
   */
  @Test
  public void testEndpointEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.Endpoint.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link Discover.Endpoint#equals(Object)}
   */
  @Test
  public void testEndpointEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.Endpoint.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link Discover.Endpoint#equals(Object)}
   */
  @Test
  public void testEndpointEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.Endpoint.getDefaultInstance(), "Different type to Endpoint");
  }

  /**
   * Method under test: {@link Discover.Endpoint#getDefaultInstanceForType()}
   */
  @Test
  public void testEndpointGetDefaultInstanceForType() {
    // Arrange
    Discover.Endpoint defaultInstance = Discover.Endpoint.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link Discover.Endpoint#getSerializedSize()}
   */
  @Test
  public void testEndpointGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Discover.Endpoint.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link Discover.Endpoint#isInitialized()}
   */
  @Test
  public void testEndpointIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Discover.Endpoint.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link Discover.Endpoint#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testEndpointNewInstance() {
    // Arrange
    Discover.Endpoint defaultInstance = Discover.Endpoint.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof Discover.Endpoint);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test: {@link Discover.Endpoint#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testEndpointParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Discover.Endpoint.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link Discover.Endpoint#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testEndpointParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.Endpoint.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link Discover.Endpoint#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testEndpointParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Discover.Endpoint.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.Endpoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testEndpointParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Discover.Endpoint.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Discover.Endpoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testEndpointParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> Discover.Endpoint.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.Endpoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testEndpointParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Discover.Endpoint.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link Discover.Endpoint#parseFrom(InputStream)}
   */
  @Test
  public void testEndpointParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.Endpoint.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link Discover.Endpoint#parseFrom(InputStream)}
   */
  @Test
  public void testEndpointParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Discover.Endpoint.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Discover.Endpoint#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testEndpointParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.Endpoint.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Discover.Endpoint#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testEndpointParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Discover.Endpoint.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Discover.FindNeighbours#equals(Object)}
   *   <li>{@link Discover.FindNeighbours#hashCode()}
   * </ul>
   */
  @Test
  public void testFindNeighboursEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Discover.FindNeighbours defaultInstance = Discover.FindNeighbours.getDefaultInstance();
    Discover.FindNeighbours defaultInstance2 = Discover.FindNeighbours.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Discover.FindNeighbours#equals(Object)}
   *   <li>{@link Discover.FindNeighbours#hashCode()}
   * </ul>
   */
  @Test
  public void testFindNeighboursEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Discover.FindNeighbours defaultInstance = Discover.FindNeighbours.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link Discover.FindNeighbours#equals(Object)}
   */
  @Test
  public void testFindNeighboursEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.FindNeighbours.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link Discover.FindNeighbours#equals(Object)}
   */
  @Test
  public void testFindNeighboursEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.FindNeighbours.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link Discover.FindNeighbours#equals(Object)}
   */
  @Test
  public void testFindNeighboursEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.FindNeighbours.getDefaultInstance(), "Different type to FindNeighbours");
  }

  /**
   * Method under test:
   * {@link Discover.FindNeighbours#getDefaultInstanceForType()}
   */
  @Test
  public void testFindNeighboursGetDefaultInstanceForType() {
    // Arrange
    Discover.FindNeighbours defaultInstance = Discover.FindNeighbours.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link Discover.FindNeighbours#getSerializedSize()}
   */
  @Test
  public void testFindNeighboursGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Discover.FindNeighbours.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link Discover.FindNeighbours#hasFrom()}
   */
  @Test
  public void testFindNeighboursHasFrom() {
    // Arrange, Act and Assert
    assertFalse(Discover.FindNeighbours.getDefaultInstance().hasFrom());
  }

  /**
   * Method under test: {@link Discover.FindNeighbours#isInitialized()}
   */
  @Test
  public void testFindNeighboursIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Discover.FindNeighbours.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link Discover.FindNeighbours#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testFindNeighboursNewInstance() {
    // Arrange
    Discover.FindNeighbours defaultInstance = Discover.FindNeighbours.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof Discover.FindNeighbours);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link Discover.FindNeighbours#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testFindNeighboursParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Discover.FindNeighbours.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Discover.FindNeighbours#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testFindNeighboursParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.FindNeighbours.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.FindNeighbours#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testFindNeighboursParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Discover.FindNeighbours.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.FindNeighbours#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testFindNeighboursParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Discover.FindNeighbours.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Discover.FindNeighbours#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testFindNeighboursParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> Discover.FindNeighbours.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.FindNeighbours#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testFindNeighboursParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Discover.FindNeighbours.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link Discover.FindNeighbours#parseFrom(InputStream)}
   */
  @Test
  public void testFindNeighboursParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.FindNeighbours.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link Discover.FindNeighbours#parseFrom(InputStream)}
   */
  @Test
  public void testFindNeighboursParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Discover.FindNeighbours.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Discover.FindNeighbours#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testFindNeighboursParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> Discover.FindNeighbours.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Discover.FindNeighbours#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testFindNeighboursParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Discover.FindNeighbours.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Discover.Neighbours#equals(Object)}
   *   <li>{@link Discover.Neighbours#hashCode()}
   * </ul>
   */
  @Test
  public void testNeighboursEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Discover.Neighbours defaultInstance = Discover.Neighbours.getDefaultInstance();
    Discover.Neighbours defaultInstance2 = Discover.Neighbours.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Discover.Neighbours#equals(Object)}
   *   <li>{@link Discover.Neighbours#hashCode()}
   * </ul>
   */
  @Test
  public void testNeighboursEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Discover.Neighbours defaultInstance = Discover.Neighbours.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link Discover.Neighbours#equals(Object)}
   */
  @Test
  public void testNeighboursEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.Neighbours.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link Discover.Neighbours#equals(Object)}
   */
  @Test
  public void testNeighboursEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.Neighbours.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link Discover.Neighbours#equals(Object)}
   */
  @Test
  public void testNeighboursEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.Neighbours.getDefaultInstance(), "Different type to Neighbours");
  }

  /**
   * Method under test: {@link Discover.Neighbours#getDefaultInstanceForType()}
   */
  @Test
  public void testNeighboursGetDefaultInstanceForType() {
    // Arrange
    Discover.Neighbours defaultInstance = Discover.Neighbours.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link Discover.Neighbours#getNeighboursCount()}
   */
  @Test
  public void testNeighboursGetNeighboursCount() {
    // Arrange, Act and Assert
    assertEquals(0, Discover.Neighbours.getDefaultInstance().getNeighboursCount());
  }

  /**
   * Method under test: {@link Discover.Neighbours#getSerializedSize()}
   */
  @Test
  public void testNeighboursGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Discover.Neighbours.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link Discover.Neighbours#hasFrom()}
   */
  @Test
  public void testNeighboursHasFrom() {
    // Arrange, Act and Assert
    assertFalse(Discover.Neighbours.getDefaultInstance().hasFrom());
  }

  /**
   * Method under test: {@link Discover.Neighbours#isInitialized()}
   */
  @Test
  public void testNeighboursIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Discover.Neighbours.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link Discover.Neighbours#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testNeighboursNewInstance() {
    // Arrange
    Discover.Neighbours defaultInstance = Discover.Neighbours.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof Discover.Neighbours);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link Discover.Neighbours#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testNeighboursParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Discover.Neighbours.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Discover.Neighbours#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testNeighboursParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.Neighbours.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.Neighbours#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testNeighboursParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Discover.Neighbours.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.Neighbours#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testNeighboursParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Discover.Neighbours.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Discover.Neighbours#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testNeighboursParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> Discover.Neighbours.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.Neighbours#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testNeighboursParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Discover.Neighbours.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link Discover.Neighbours#parseFrom(InputStream)}
   */
  @Test
  public void testNeighboursParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.Neighbours.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link Discover.Neighbours#parseFrom(InputStream)}
   */
  @Test
  public void testNeighboursParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Discover.Neighbours.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Discover.Neighbours#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testNeighboursParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> Discover.Neighbours.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Discover.Neighbours#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testNeighboursParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Discover.Neighbours.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Discover.PingMessage#equals(Object)}
   *   <li>{@link Discover.PingMessage#hashCode()}
   * </ul>
   */
  @Test
  public void testPingMessageEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Discover.PingMessage defaultInstance = Discover.PingMessage.getDefaultInstance();
    Discover.PingMessage defaultInstance2 = Discover.PingMessage.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Discover.PingMessage#equals(Object)}
   *   <li>{@link Discover.PingMessage#hashCode()}
   * </ul>
   */
  @Test
  public void testPingMessageEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Discover.PingMessage defaultInstance = Discover.PingMessage.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link Discover.PingMessage#equals(Object)}
   */
  @Test
  public void testPingMessageEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.PingMessage.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link Discover.PingMessage#equals(Object)}
   */
  @Test
  public void testPingMessageEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.PingMessage.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link Discover.PingMessage#equals(Object)}
   */
  @Test
  public void testPingMessageEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.PingMessage.getDefaultInstance(), "Different type to PingMessage");
  }

  /**
   * Method under test: {@link Discover.PingMessage#getDefaultInstanceForType()}
   */
  @Test
  public void testPingMessageGetDefaultInstanceForType() {
    // Arrange
    Discover.PingMessage defaultInstance = Discover.PingMessage.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link Discover.PingMessage#getSerializedSize()}
   */
  @Test
  public void testPingMessageGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Discover.PingMessage.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link Discover.PingMessage#hasFrom()}
   */
  @Test
  public void testPingMessageHasFrom() {
    // Arrange, Act and Assert
    assertFalse(Discover.PingMessage.getDefaultInstance().hasFrom());
  }

  /**
   * Method under test: {@link Discover.PingMessage#hasTo()}
   */
  @Test
  public void testPingMessageHasTo() {
    // Arrange, Act and Assert
    assertFalse(Discover.PingMessage.getDefaultInstance().hasTo());
  }

  /**
   * Method under test: {@link Discover.PingMessage#isInitialized()}
   */
  @Test
  public void testPingMessageIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Discover.PingMessage.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link Discover.PingMessage#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testPingMessageNewInstance() {
    // Arrange
    Discover.PingMessage defaultInstance = Discover.PingMessage.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof Discover.PingMessage);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link Discover.PingMessage#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testPingMessageParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Discover.PingMessage.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Discover.PingMessage#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testPingMessageParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.PingMessage.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.PingMessage#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testPingMessageParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Discover.PingMessage.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.PingMessage#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPingMessageParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Discover.PingMessage.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Discover.PingMessage#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPingMessageParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> Discover.PingMessage.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.PingMessage#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPingMessageParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Discover.PingMessage.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link Discover.PingMessage#parseFrom(InputStream)}
   */
  @Test
  public void testPingMessageParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.PingMessage.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link Discover.PingMessage#parseFrom(InputStream)}
   */
  @Test
  public void testPingMessageParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Discover.PingMessage.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Discover.PingMessage#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPingMessageParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> Discover.PingMessage.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Discover.PingMessage#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPingMessageParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Discover.PingMessage.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Discover.PongMessage#equals(Object)}
   *   <li>{@link Discover.PongMessage#hashCode()}
   * </ul>
   */
  @Test
  public void testPongMessageEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Discover.PongMessage defaultInstance = Discover.PongMessage.getDefaultInstance();
    Discover.PongMessage defaultInstance2 = Discover.PongMessage.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Discover.PongMessage#equals(Object)}
   *   <li>{@link Discover.PongMessage#hashCode()}
   * </ul>
   */
  @Test
  public void testPongMessageEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Discover.PongMessage defaultInstance = Discover.PongMessage.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link Discover.PongMessage#equals(Object)}
   */
  @Test
  public void testPongMessageEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.PongMessage.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link Discover.PongMessage#equals(Object)}
   */
  @Test
  public void testPongMessageEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.PongMessage.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link Discover.PongMessage#equals(Object)}
   */
  @Test
  public void testPongMessageEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Discover.PongMessage.getDefaultInstance(), "Different type to PongMessage");
  }

  /**
   * Method under test: {@link Discover.PongMessage#getDefaultInstanceForType()}
   */
  @Test
  public void testPongMessageGetDefaultInstanceForType() {
    // Arrange
    Discover.PongMessage defaultInstance = Discover.PongMessage.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link Discover.PongMessage#getSerializedSize()}
   */
  @Test
  public void testPongMessageGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Discover.PongMessage.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link Discover.PongMessage#hasFrom()}
   */
  @Test
  public void testPongMessageHasFrom() {
    // Arrange, Act and Assert
    assertFalse(Discover.PongMessage.getDefaultInstance().hasFrom());
  }

  /**
   * Method under test: {@link Discover.PongMessage#isInitialized()}
   */
  @Test
  public void testPongMessageIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Discover.PongMessage.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link Discover.PongMessage#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testPongMessageNewInstance() {
    // Arrange
    Discover.PongMessage defaultInstance = Discover.PongMessage.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof Discover.PongMessage);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link Discover.PongMessage#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testPongMessageParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Discover.PongMessage.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Discover.PongMessage#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testPongMessageParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.PongMessage.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.PongMessage#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testPongMessageParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Discover.PongMessage.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.PongMessage#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPongMessageParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Discover.PongMessage.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link Discover.PongMessage#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPongMessageParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> Discover.PongMessage.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link Discover.PongMessage#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPongMessageParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Discover.PongMessage.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link Discover.PongMessage#parseFrom(InputStream)}
   */
  @Test
  public void testPongMessageParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Discover.PongMessage.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link Discover.PongMessage#parseFrom(InputStream)}
   */
  @Test
  public void testPongMessageParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Discover.PongMessage.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Discover.PongMessage#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPongMessageParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> Discover.PongMessage.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link Discover.PongMessage#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPongMessageParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Discover.PongMessage.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
