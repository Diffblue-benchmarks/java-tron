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

public class ShieldContractDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.AuthenticationPath#equals(Object)}
   *   <li>{@link ShieldContract.AuthenticationPath#hashCode()}
   * </ul>
   */
  @Test
  public void testAuthenticationPathEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShieldContract.AuthenticationPath defaultInstance = ShieldContract.AuthenticationPath.getDefaultInstance();
    ShieldContract.AuthenticationPath defaultInstance2 = ShieldContract.AuthenticationPath.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.AuthenticationPath#equals(Object)}
   *   <li>{@link ShieldContract.AuthenticationPath#hashCode()}
   * </ul>
   */
  @Test
  public void testAuthenticationPathEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShieldContract.AuthenticationPath defaultInstance = ShieldContract.AuthenticationPath.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link ShieldContract.AuthenticationPath#equals(Object)}
   */
  @Test
  public void testAuthenticationPathEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.AuthenticationPath.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link ShieldContract.AuthenticationPath#equals(Object)}
   */
  @Test
  public void testAuthenticationPathEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.AuthenticationPath.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link ShieldContract.AuthenticationPath#equals(Object)}
   */
  @Test
  public void testAuthenticationPathEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.AuthenticationPath.getDefaultInstance(), "Different type to AuthenticationPath");
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#getDefaultInstanceForType()}
   */
  @Test
  public void testAuthenticationPathGetDefaultInstanceForType() {
    // Arrange
    ShieldContract.AuthenticationPath defaultInstance = ShieldContract.AuthenticationPath.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ShieldContract.AuthenticationPath#getDescriptor()}
   */
  @Test
  public void testAuthenticationPathGetDescriptor() {
    // Arrange and Act
    Descriptors.Descriptor actualDescriptor = ShieldContract.AuthenticationPath.getDescriptor();

    // Assert
    DescriptorProtos.DescriptorProto toProtoResult = actualDescriptor.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = actualDescriptor.getFields();
    assertEquals(1, fields.size());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", actualDescriptor.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType2.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType.getName());
    assertEquals("ReceiveDescription", toProtoResult8.getName());
    assertEquals("ReceiveDescription", getResult4.getName());
    assertEquals("ShieldedTransferContract", toProtoResult7.getName());
    assertEquals("ShieldedTransferContract", getResult3.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", actualDescriptor.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult4.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult3.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(actualDescriptor.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, toProtoResult8.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, toProtoResult8.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, toProtoResult8.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, toProtoResult8.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, toProtoResult8.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = options2.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType6.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult8.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType3.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType2.getIndex());
    assertEquals(2, descriptorForType2.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(273, toProtoResult7.getSerializedSize());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType4.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult8.getFieldCount());
    assertEquals(6, getResult4.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, toProtoResult7.getFieldCount());
    assertEquals(7, descriptorForType.getFields().size());
    assertEquals(7, getResult3.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(actualDescriptor.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType3.isExtendable());
    assertTrue(descriptorForType.isExtendable());
    assertTrue(descriptorForType5.isExtendable());
    assertTrue(descriptorForType7.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    List<Descriptors.EnumDescriptor> enumTypes = actualDescriptor.getEnumTypes();
    assertTrue(enumTypes.isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
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
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(enumTypes, toProtoResult7.findInitializationErrors());
    assertEquals(enumTypes, toProtoResult8.findInitializationErrors());
    assertEquals(enumTypes, descriptorForType6.getEnumTypes());
    assertEquals(enumTypes, descriptorForType3.getExtensions());
    assertEquals(enumTypes, descriptorForType5.getExtensions());
    assertEquals(enumTypes, descriptorForType4.getExtensions());
    assertEquals(enumTypes, descriptorForType7.getExtensions());
    assertEquals(enumTypes, descriptorForType6.getExtensions());
    assertEquals(enumTypes, descriptorForType3.getNestedTypes());
    assertEquals(enumTypes, descriptorForType4.getNestedTypes());
    assertEquals(enumTypes, descriptorForType7.getNestedTypes());
    assertEquals(enumTypes, descriptorForType6.getNestedTypes());
    assertEquals(enumTypes, descriptorForType3.getOneofs());
    assertEquals(enumTypes, descriptorForType5.getOneofs());
    assertEquals(enumTypes, descriptorForType4.getOneofs());
    assertEquals(enumTypes, descriptorForType7.getOneofs());
    assertEquals(enumTypes, descriptorForType6.getOneofs());
    assertEquals(enumTypes, descriptorForType3.getRealOneofs());
    assertEquals(enumTypes, descriptorForType5.getRealOneofs());
    assertEquals(enumTypes, descriptorForType4.getRealOneofs());
    assertEquals(enumTypes, descriptorForType7.getRealOneofs());
    assertEquals(enumTypes, descriptorForType6.getRealOneofs());
    assertEquals(enumTypes, file2.getDependencies());
    assertEquals(enumTypes, file2.getExtensions());
    assertEquals(enumTypes, file2.getPublicDependencies());
    assertEquals(enumTypes, file2.getServices());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType7.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType2.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType5.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('i', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('r', iteratorResult4.next().byteValue());
    assertEquals('r', iteratorResult5.next().byteValue());
    assertEquals('r', iteratorResult7.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult5.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
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
    DescriptorProtos.FileOptions defaultInstanceForType6 = defaultInstanceForType4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType6, defaultInstanceForType3.getOptions());
    assertSame(defaultInstanceForType6, defaultInstanceForType3.getOptionsOrBuilder());
    assertSame(defaultInstanceForType6, defaultInstanceForType6);
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
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult8.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult8.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file2, descriptorForType3.getFile());
    assertSame(file2, descriptorForType2.getFile());
    assertSame(file2, descriptorForType5.getFile());
    assertSame(file2, descriptorForType4.getFile());
    assertSame(file2, descriptorForType7.getFile());
    assertSame(file2, descriptorForType6.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(options2, defaultInstanceForType.getOptions());
    assertSame(options2, toProtoResult4.getOptions());
    assertSame(options2, toProtoResult5.getOptions());
    assertSame(options2, toProtoResult6.getOptions());
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult8.getOptions());
    assertSame(options2, toProtoResult.getOptions());
    assertSame(options2, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
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
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult6, messageTypeList.get(1));
    assertSame(toProtoResult7,
        messageTypeList.get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER));
    assertSame(toProtoResult8,
        messageTypeList.get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER));
    assertSame(toProtoResult, messageTypeList.get(0));
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(toProtoResult2, fieldList.get(0));
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    Descriptors.Descriptor descriptorForType8 = toProtoResult5.getDescriptorForType();
    assertSame(descriptorForType8, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType8, toProtoResult4.getDescriptorForType());
    assertSame(descriptorForType8, descriptorForType8);
    assertSame(descriptorForType8, toProtoResult6.getDescriptorForType());
    assertSame(descriptorForType8, toProtoResult7.getDescriptorForType());
    assertSame(descriptorForType8, toProtoResult8.getDescriptorForType());
    assertSame(descriptorForType4, defaultInstanceForType2.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(actualDescriptor, getResult.getContainingType());
    assertSame(actualDescriptor, messageTypes.get(0));
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, toProtoResult8.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#getSerializedSize()}
   */
  @Test
  public void testAuthenticationPathGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.AuthenticationPath.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link ShieldContract.AuthenticationPath#getValueCount()}
   */
  @Test
  public void testAuthenticationPathGetValueCount() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.AuthenticationPath.getDefaultInstance().getValueCount());
  }

  /**
   * Method under test: {@link ShieldContract.AuthenticationPath#isInitialized()}
   */
  @Test
  public void testAuthenticationPathIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ShieldContract.AuthenticationPath.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testAuthenticationPathNewInstance() {
    // Arrange
    ShieldContract.AuthenticationPath defaultInstance = ShieldContract.AuthenticationPath.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ShieldContract.AuthenticationPath);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAuthenticationPathParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ShieldContract.AuthenticationPath actualParseDelimitedFromResult = ShieldContract.AuthenticationPath
        .parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAuthenticationPathParseDelimitedFrom2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.AuthenticationPath.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAuthenticationPathParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.AuthenticationPath.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testAuthenticationPathParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.AuthenticationPath.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAuthenticationPathParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ShieldContract.AuthenticationPath actualParseDelimitedFromResult = ShieldContract.AuthenticationPath
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAuthenticationPathParseDelimitedFrom6() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.AuthenticationPath.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAuthenticationPathParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.AuthenticationPath.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAuthenticationPathParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.AuthenticationPath.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(ByteString)}
   */
  @Test
  public void testAuthenticationPathParseFrom() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ShieldContract.AuthenticationPath actualParseFromResult = ShieldContract.AuthenticationPath.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
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
    assertEquals(byteString, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, defaultInstanceForType3.getNameBytes());
    assertEquals(byteString, defaultInstanceForType3.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(byteString, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(byteString, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  public void testAuthenticationPathParseFrom2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ShieldContract.AuthenticationPath actualParseFromResult = ShieldContract.AuthenticationPath.parseFrom(data,
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
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
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
    assertEquals(byteString, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, defaultInstanceForType3.getNameBytes());
    assertEquals(byteString, defaultInstanceForType3.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(byteString, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(byteString, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(CodedInputStream)}
   */
  @Test
  public void testAuthenticationPathParseFrom3() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ShieldContract.AuthenticationPath actualParseFromResult = ShieldContract.AuthenticationPath.parseFrom(input);

    // Assert
    verify(input).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAuthenticationPathParseFrom4() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ShieldContract.AuthenticationPath actualParseFromResult = ShieldContract.AuthenticationPath.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(InputStream)}
   */
  @Test
  public void testAuthenticationPathParseFrom5() throws IOException {
    // Arrange and Act
    ShieldContract.AuthenticationPath actualParseFromResult = ShieldContract.AuthenticationPath
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(InputStream)}
   */
  @Test
  public void testAuthenticationPathParseFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.AuthenticationPath.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(InputStream)}
   */
  @Test
  public void testAuthenticationPathParseFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.AuthenticationPath.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(InputStream)}
   */
  @Test
  public void testAuthenticationPathParseFrom8() throws IOException {
    // Arrange and Act
    ShieldContract.AuthenticationPath actualParseFromResult = ShieldContract.AuthenticationPath
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAuthenticationPathParseFrom9() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ShieldContract.AuthenticationPath actualParseFromResult = ShieldContract.AuthenticationPath.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAuthenticationPathParseFrom10() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.AuthenticationPath.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testAuthenticationPathParseFrom11() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.AuthenticationPath.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(ByteBuffer)}
   */
  @Test
  public void testAuthenticationPathParseFrom12() throws InvalidProtocolBufferException {
    // Arrange and Act
    ShieldContract.AuthenticationPath actualParseFromResult = ShieldContract.AuthenticationPath
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  public void testAuthenticationPathParseFrom13() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ShieldContract.AuthenticationPath actualParseFromResult = ShieldContract.AuthenticationPath.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(byte[])}
   */
  @Test
  public void testAuthenticationPathParseFrom14() throws InvalidProtocolBufferException {
    // Arrange and Act
    ShieldContract.AuthenticationPath actualParseFromResult = ShieldContract.AuthenticationPath.parseFrom(new byte[]{});

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  public void testAuthenticationPathParseFrom15() throws InvalidProtocolBufferException {
    // Arrange and Act
    ShieldContract.AuthenticationPath actualParseFromResult = ShieldContract.AuthenticationPath.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    assertEquals("ReceiveDescription", toProtoResult7.getName());
    assertEquals("ReceiveDescription", getResult3.getName());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    assertEquals("ShieldedTransferContract", getResult4.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", descriptorForType.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult3.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult4.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValueCount());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType7.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult7.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType5.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult7.getFieldCount());
    assertEquals(6, getResult3.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, getResult4.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult2.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(descriptorForType8.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult2.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualParseFromResult.getValueList().isEmpty());
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
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType8.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType3.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType2.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
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
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType8.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ShieldContract.AuthenticationPath.Builder#getDescriptor()}
   */
  @Test
  public void testAuthenticationPath_BuilderGetDescriptor() {
    // Arrange and Act
    Descriptors.Descriptor actualDescriptor = ShieldContract.AuthenticationPath.Builder.getDescriptor();

    // Assert
    DescriptorProtos.DescriptorProto toProtoResult = actualDescriptor.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = actualDescriptor.getFields();
    assertEquals(1, fields.size());
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
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    DescriptorProtos.DescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.Descriptor getResult3 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER);
    DescriptorProtos.DescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getTypeName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", defaultInstanceForType3.getName());
    assertEquals("", defaultInstanceForType3.getPackage());
    assertEquals("", defaultInstanceForType3.getSyntax());
    assertEquals("", defaultInstanceForType4.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType4.getGoPackage());
    assertEquals("", defaultInstanceForType4.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    assertEquals("AuthenticationPath", nameBytes.toStringUtf8());
    assertEquals("AuthenticationPath", toProtoResult.getName());
    assertEquals("AuthenticationPath", actualDescriptor.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType2.getName());
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
    assertEquals("MerklePath", toProtoResult6.getName());
    assertEquals("MerklePath", getResult2.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType.getName());
    assertEquals("ReceiveDescription", toProtoResult8.getName());
    assertEquals("ReceiveDescription", getResult4.getName());
    assertEquals("ShieldedTransferContract", toProtoResult7.getName());
    assertEquals("ShieldedTransferContract", getResult3.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
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
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", actualDescriptor.getFullName());
    assertEquals("protocol.AuthenticationPath.value", getResult.getFullName());
    assertEquals("protocol.MerklePath", getResult2.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult4.getFullName());
    assertEquals("protocol.ShieldedTransferContract", getResult3.getFullName());
    ByteString nameBytes3 = toProtoResult2.getNameBytes();
    assertEquals("value", nameBytes3.toStringUtf8());
    assertEquals("value", toProtoResult2.getName());
    assertEquals("value", getResult.getJsonName());
    assertEquals("value", getResult.getName());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult4.getContainingType());
    assertNull(actualDescriptor.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult6.getEnumTypeCount());
    assertEquals(0, toProtoResult7.getEnumTypeCount());
    assertEquals(0, toProtoResult8.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult6.getExtensionCount());
    assertEquals(0, toProtoResult7.getExtensionCount());
    assertEquals(0, toProtoResult8.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult7.getExtensionRangeCount());
    assertEquals(0, toProtoResult8.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult4.getNestedTypeCount());
    assertEquals(0, toProtoResult6.getNestedTypeCount());
    assertEquals(0, toProtoResult7.getNestedTypeCount());
    assertEquals(0, toProtoResult8.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult5.getOneofDeclCount());
    assertEquals(0, toProtoResult6.getOneofDeclCount());
    assertEquals(0, toProtoResult7.getOneofDeclCount());
    assertEquals(0, toProtoResult8.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, toProtoResult8.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, toProtoResult8.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getNumber());
    assertEquals(0, defaultInstanceForType2.getOneofIndex());
    assertEquals(0, toProtoResult2.getOneofIndex());
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
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = options2.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType6.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    assertEquals(13, toProtoResult2.getSerializedSize());
    assertEquals(131, toProtoResult8.getSerializedSize());
    assertEquals(1467, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType3.getIndex());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, descriptorForType2.getIndex());
    assertEquals(2, descriptorForType2.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(273, toProtoResult7.getSerializedSize());
    assertEquals(3, toProtoResult6.getFieldCount());
    assertEquals(3, getResult2.getFields().size());
    assertEquals(35, toProtoResult.getSerializedSize());
    assertEquals(4, descriptorForType4.getIndex());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(5, toProtoResult3.getAllFields().size());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult8.getFieldCount());
    assertEquals(6, getResult4.getFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, toProtoResult7.getFieldCount());
    assertEquals(7, descriptorForType.getFields().size());
    assertEquals(7, getResult3.getFields().size());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes3.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(defaultInstanceForType2.hasDefaultValue());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(defaultInstanceForType2.hasExtendee());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(defaultInstanceForType2.hasJsonName());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(defaultInstanceForType2.hasLabel());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasNumber());
    assertFalse(defaultInstanceForType2.hasOneofIndex());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(defaultInstanceForType2.hasProto3Optional());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(defaultInstanceForType2.hasType());
    assertFalse(defaultInstanceForType2.hasTypeName());
    assertFalse(toProtoResult2.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(getResult3.isExtendable());
    assertFalse(getResult4.isExtendable());
    assertFalse(actualDescriptor.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType3.isExtendable());
    assertTrue(descriptorForType.isExtendable());
    assertTrue(descriptorForType5.isExtendable());
    assertTrue(descriptorForType7.isExtendable());
    assertTrue(getResult.isPackable());
    assertTrue(getResult.isPacked());
    assertTrue(getResult.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes3.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = nameBytes2.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = packageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = syntaxBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = goPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
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
    assertTrue(getResult3.getEnumTypes().isEmpty());
    assertTrue(getResult4.getEnumTypes().isEmpty());
    List<Descriptors.EnumDescriptor> enumTypes = actualDescriptor.getEnumTypes();
    assertTrue(enumTypes.isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(getResult2.getExtensions().isEmpty());
    assertTrue(getResult3.getExtensions().isEmpty());
    assertTrue(getResult4.getExtensions().isEmpty());
    assertTrue(actualDescriptor.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(getResult2.getNestedTypes().isEmpty());
    assertTrue(getResult3.getNestedTypes().isEmpty());
    assertTrue(getResult4.getNestedTypes().isEmpty());
    assertTrue(actualDescriptor.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(getResult2.getOneofs().isEmpty());
    assertTrue(getResult3.getOneofs().isEmpty());
    assertTrue(getResult4.getOneofs().isEmpty());
    assertTrue(actualDescriptor.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(getResult2.getRealOneofs().isEmpty());
    assertTrue(getResult3.getRealOneofs().isEmpty());
    assertTrue(getResult4.getRealOneofs().isEmpty());
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
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType4.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, options.getJavaOuterClassnameBytes());
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
    assertEquals(enumTypes, toProtoResult7.findInitializationErrors());
    assertEquals(enumTypes, toProtoResult8.findInitializationErrors());
    assertEquals(enumTypes, descriptorForType6.getEnumTypes());
    assertEquals(enumTypes, descriptorForType3.getExtensions());
    assertEquals(enumTypes, descriptorForType5.getExtensions());
    assertEquals(enumTypes, descriptorForType4.getExtensions());
    assertEquals(enumTypes, descriptorForType7.getExtensions());
    assertEquals(enumTypes, descriptorForType6.getExtensions());
    assertEquals(enumTypes, descriptorForType3.getNestedTypes());
    assertEquals(enumTypes, descriptorForType4.getNestedTypes());
    assertEquals(enumTypes, descriptorForType7.getNestedTypes());
    assertEquals(enumTypes, descriptorForType6.getNestedTypes());
    assertEquals(enumTypes, descriptorForType3.getOneofs());
    assertEquals(enumTypes, descriptorForType5.getOneofs());
    assertEquals(enumTypes, descriptorForType4.getOneofs());
    assertEquals(enumTypes, descriptorForType7.getOneofs());
    assertEquals(enumTypes, descriptorForType6.getOneofs());
    assertEquals(enumTypes, descriptorForType3.getRealOneofs());
    assertEquals(enumTypes, descriptorForType5.getRealOneofs());
    assertEquals(enumTypes, descriptorForType4.getRealOneofs());
    assertEquals(enumTypes, descriptorForType7.getRealOneofs());
    assertEquals(enumTypes, descriptorForType6.getRealOneofs());
    assertEquals(enumTypes, file2.getDependencies());
    assertEquals(enumTypes, file2.getExtensions());
    assertEquals(enumTypes, file2.getPublicDependencies());
    assertEquals(enumTypes, file2.getServices());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFields());
    assertEquals(allFields, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, toProtoResult5.getFieldCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, descriptorForType7.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER, getResult3.getIndex());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER,
        descriptorForType2.getFields().size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER,
        toProtoResult3.getMessageTypeCount());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, descriptorForType.getIndex());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.ORDER_FIELD_NUMBER, messageTypeList.size());
    assertEquals(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER, getResult4.getIndex());
    assertEquals(BalanceContract.AccountTrace.PLACEHOLDER_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(WitnessContract.WitnessUpdateContract.UPDATE_URL_FIELD_NUMBER, descriptorForType5.getIndex());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult3.next().byteValue());
    assertEquals('g', iteratorResult6.next().byteValue());
    assertEquals('i', iteratorResult6.next().byteValue());
    assertEquals('o', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('p', iteratorResult5.next().byteValue());
    assertEquals('r', iteratorResult4.next().byteValue());
    assertEquals('r', iteratorResult5.next().byteValue());
    assertEquals('r', iteratorResult7.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('v', iteratorResult2.next().byteValue());
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(defaultInstanceForType5, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult5.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult7.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, toProtoResult8.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
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
    DescriptorProtos.FileOptions defaultInstanceForType6 = defaultInstanceForType4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType6, defaultInstanceForType3.getOptions());
    assertSame(defaultInstanceForType6, defaultInstanceForType3.getOptionsOrBuilder());
    assertSame(defaultInstanceForType6, defaultInstanceForType6);
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
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult8.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult8.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getReservedRangeOrBuilderList());
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
    assertSame(uninterpretedOptionList, getResult.getDefaultValue());
    assertSame(file2, descriptorForType3.getFile());
    assertSame(file2, descriptorForType2.getFile());
    assertSame(file2, descriptorForType5.getFile());
    assertSame(file2, descriptorForType4.getFile());
    assertSame(file2, descriptorForType7.getFile());
    assertSame(file2, descriptorForType6.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(options2, defaultInstanceForType.getOptions());
    assertSame(options2, toProtoResult4.getOptions());
    assertSame(options2, toProtoResult5.getOptions());
    assertSame(options2, toProtoResult6.getOptions());
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult8.getOptions());
    assertSame(options2, toProtoResult.getOptions());
    assertSame(options2, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
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
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult6, messageTypeList.get(1));
    assertSame(toProtoResult7,
        messageTypeList.get(AssetIssueContractOuterClass.AssetIssueContract.END_TIME_FIELD_NUMBER));
    assertSame(toProtoResult8,
        messageTypeList.get(AssetIssueContractOuterClass.AssetIssueContract.START_TIME_FIELD_NUMBER));
    assertSame(toProtoResult, messageTypeList.get(0));
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(toProtoResult2, fieldList.get(0));
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    Descriptors.Descriptor descriptorForType8 = toProtoResult5.getDescriptorForType();
    assertSame(descriptorForType8, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType8, toProtoResult4.getDescriptorForType());
    assertSame(descriptorForType8, descriptorForType8);
    assertSame(descriptorForType8, toProtoResult6.getDescriptorForType());
    assertSame(descriptorForType8, toProtoResult7.getDescriptorForType());
    assertSame(descriptorForType8, toProtoResult8.getDescriptorForType());
    assertSame(descriptorForType4, defaultInstanceForType2.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(actualDescriptor, getResult.getContainingType());
    assertSame(actualDescriptor, messageTypes.get(0));
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, toProtoResult8.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.IncrementalMerkleTree#equals(Object)}
   *   <li>{@link ShieldContract.IncrementalMerkleTree#hashCode()}
   * </ul>
   */
  @Test
  public void testIncrementalMerkleTreeEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShieldContract.IncrementalMerkleTree defaultInstance = ShieldContract.IncrementalMerkleTree.getDefaultInstance();
    ShieldContract.IncrementalMerkleTree defaultInstance2 = ShieldContract.IncrementalMerkleTree.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.IncrementalMerkleTree#equals(Object)}
   *   <li>{@link ShieldContract.IncrementalMerkleTree#hashCode()}
   * </ul>
   */
  @Test
  public void testIncrementalMerkleTreeEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShieldContract.IncrementalMerkleTree defaultInstance = ShieldContract.IncrementalMerkleTree.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#equals(Object)}
   */
  @Test
  public void testIncrementalMerkleTreeEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.IncrementalMerkleTree.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#equals(Object)}
   */
  @Test
  public void testIncrementalMerkleTreeEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.IncrementalMerkleTree.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#equals(Object)}
   */
  @Test
  public void testIncrementalMerkleTreeEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.IncrementalMerkleTree.getDefaultInstance(),
        "Different type to IncrementalMerkleTree");
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#getDefaultInstanceForType()}
   */
  @Test
  public void testIncrementalMerkleTreeGetDefaultInstanceForType() {
    // Arrange
    ShieldContract.IncrementalMerkleTree defaultInstance = ShieldContract.IncrementalMerkleTree.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#getParentsCount()}
   */
  @Test
  public void testIncrementalMerkleTreeGetParentsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.IncrementalMerkleTree.getDefaultInstance().getParentsCount());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#getSerializedSize()}
   */
  @Test
  public void testIncrementalMerkleTreeGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.IncrementalMerkleTree.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link ShieldContract.IncrementalMerkleTree#hasLeft()}
   */
  @Test
  public void testIncrementalMerkleTreeHasLeft() {
    // Arrange, Act and Assert
    assertFalse(ShieldContract.IncrementalMerkleTree.getDefaultInstance().hasLeft());
  }

  /**
   * Method under test: {@link ShieldContract.IncrementalMerkleTree#hasRight()}
   */
  @Test
  public void testIncrementalMerkleTreeHasRight() {
    // Arrange, Act and Assert
    assertFalse(ShieldContract.IncrementalMerkleTree.getDefaultInstance().hasRight());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#isInitialized()}
   */
  @Test
  public void testIncrementalMerkleTreeIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ShieldContract.IncrementalMerkleTree.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testIncrementalMerkleTreeNewInstance() {
    // Arrange
    ShieldContract.IncrementalMerkleTree defaultInstance = ShieldContract.IncrementalMerkleTree.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ShieldContract.IncrementalMerkleTree);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleTreeParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.IncrementalMerkleTree.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleTreeParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.IncrementalMerkleTree.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleTreeParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.IncrementalMerkleTree.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleTreeParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        ShieldContract.IncrementalMerkleTree.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleTreeParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.IncrementalMerkleTree.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleTreeParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.IncrementalMerkleTree.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#parseFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleTreeParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.IncrementalMerkleTree.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#parseFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleTreeParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.IncrementalMerkleTree.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleTreeParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.IncrementalMerkleTree.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleTree#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleTreeParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.IncrementalMerkleTree.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.IncrementalMerkleVoucher#equals(Object)}
   *   <li>{@link ShieldContract.IncrementalMerkleVoucher#hashCode()}
   * </ul>
   */
  @Test
  public void testIncrementalMerkleVoucherEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShieldContract.IncrementalMerkleVoucher defaultInstance = ShieldContract.IncrementalMerkleVoucher
        .getDefaultInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstance2 = ShieldContract.IncrementalMerkleVoucher
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.IncrementalMerkleVoucher#equals(Object)}
   *   <li>{@link ShieldContract.IncrementalMerkleVoucher#hashCode()}
   * </ul>
   */
  @Test
  public void testIncrementalMerkleVoucherEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShieldContract.IncrementalMerkleVoucher defaultInstance = ShieldContract.IncrementalMerkleVoucher
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#equals(Object)}
   */
  @Test
  public void testIncrementalMerkleVoucherEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.IncrementalMerkleVoucher.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#equals(Object)}
   */
  @Test
  public void testIncrementalMerkleVoucherEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.IncrementalMerkleVoucher.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#equals(Object)}
   */
  @Test
  public void testIncrementalMerkleVoucherEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.IncrementalMerkleVoucher.getDefaultInstance(),
        "Different type to IncrementalMerkleVoucher");
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#getDefaultInstanceForType()}
   */
  @Test
  public void testIncrementalMerkleVoucherGetDefaultInstanceForType() {
    // Arrange
    ShieldContract.IncrementalMerkleVoucher defaultInstance = ShieldContract.IncrementalMerkleVoucher
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#getFilledCount()}
   */
  @Test
  public void testIncrementalMerkleVoucherGetFilledCount() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.IncrementalMerkleVoucher.getDefaultInstance().getFilledCount());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#getSerializedSize()}
   */
  @Test
  public void testIncrementalMerkleVoucherGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.IncrementalMerkleVoucher.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#hasCursor()}
   */
  @Test
  public void testIncrementalMerkleVoucherHasCursor() {
    // Arrange, Act and Assert
    assertFalse(ShieldContract.IncrementalMerkleVoucher.getDefaultInstance().hasCursor());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#hasOutputPoint()}
   */
  @Test
  public void testIncrementalMerkleVoucherHasOutputPoint() {
    // Arrange, Act and Assert
    assertFalse(ShieldContract.IncrementalMerkleVoucher.getDefaultInstance().hasOutputPoint());
  }

  /**
   * Method under test: {@link ShieldContract.IncrementalMerkleVoucher#hasTree()}
   */
  @Test
  public void testIncrementalMerkleVoucherHasTree() {
    // Arrange, Act and Assert
    assertFalse(ShieldContract.IncrementalMerkleVoucher.getDefaultInstance().hasTree());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.IncrementalMerkleVoucherInfo#equals(Object)}
   *   <li>{@link ShieldContract.IncrementalMerkleVoucherInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testIncrementalMerkleVoucherInfoEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    ShieldContract.IncrementalMerkleVoucherInfo defaultInstance = ShieldContract.IncrementalMerkleVoucherInfo
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.IncrementalMerkleVoucherInfo#equals(Object)}
   *   <li>{@link ShieldContract.IncrementalMerkleVoucherInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testIncrementalMerkleVoucherInfoEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    ShieldContract.IncrementalMerkleVoucherInfo defaultInstance = ShieldContract.IncrementalMerkleVoucherInfo
        .getDefaultInstance();
    ShieldContract.IncrementalMerkleVoucherInfo defaultInstance2 = ShieldContract.IncrementalMerkleVoucherInfo
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#equals(Object)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.IncrementalMerkleVoucherInfo.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#equals(Object)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.IncrementalMerkleVoucherInfo.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#equals(Object)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.IncrementalMerkleVoucherInfo.getDefaultInstance(),
        "Different type to IncrementalMerkleVoucherInfo");
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#getDefaultInstanceForType()}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoGetDefaultInstanceForType() {
    // Arrange
    ShieldContract.IncrementalMerkleVoucherInfo defaultInstance = ShieldContract.IncrementalMerkleVoucherInfo
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#getPathsCount()}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoGetPathsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.IncrementalMerkleVoucherInfo.getDefaultInstance().getPathsCount());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#getSerializedSize()}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.IncrementalMerkleVoucherInfo.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#getVouchersCount()}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoGetVouchersCount() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.IncrementalMerkleVoucherInfo.getDefaultInstance().getVouchersCount());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#isInitialized()}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ShieldContract.IncrementalMerkleVoucherInfo.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoNewInstance() {
    // Arrange
    ShieldContract.IncrementalMerkleVoucherInfo defaultInstance = ShieldContract.IncrementalMerkleVoucherInfo
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ShieldContract.IncrementalMerkleVoucherInfo);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.IncrementalMerkleVoucherInfo.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.IncrementalMerkleVoucherInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.IncrementalMerkleVoucherInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.IncrementalMerkleVoucherInfo.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.IncrementalMerkleVoucherInfo.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.IncrementalMerkleVoucherInfo
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#parseFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.IncrementalMerkleVoucherInfo.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#parseFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.IncrementalMerkleVoucherInfo.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.IncrementalMerkleVoucherInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucherInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleVoucherInfoParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.IncrementalMerkleVoucherInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#isInitialized()}
   */
  @Test
  public void testIncrementalMerkleVoucherIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ShieldContract.IncrementalMerkleVoucher.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testIncrementalMerkleVoucherNewInstance() {
    // Arrange
    ShieldContract.IncrementalMerkleVoucher defaultInstance = ShieldContract.IncrementalMerkleVoucher
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ShieldContract.IncrementalMerkleVoucher);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleVoucherParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.IncrementalMerkleVoucher.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleVoucherParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.IncrementalMerkleVoucher.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleVoucherParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.IncrementalMerkleVoucher.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleVoucherParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        ShieldContract.IncrementalMerkleVoucher.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleVoucherParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.IncrementalMerkleVoucher.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleVoucherParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.IncrementalMerkleVoucher
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#parseFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleVoucherParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.IncrementalMerkleVoucher.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#parseFrom(InputStream)}
   */
  @Test
  public void testIncrementalMerkleVoucherParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.IncrementalMerkleVoucher.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleVoucherParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.IncrementalMerkleVoucher.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.IncrementalMerkleVoucher#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testIncrementalMerkleVoucherParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.IncrementalMerkleVoucher.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.MerklePath#equals(Object)}
   *   <li>{@link ShieldContract.MerklePath#hashCode()}
   * </ul>
   */
  @Test
  public void testMerklePathEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShieldContract.MerklePath defaultInstance = ShieldContract.MerklePath.getDefaultInstance();
    ShieldContract.MerklePath defaultInstance2 = ShieldContract.MerklePath.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.MerklePath#equals(Object)}
   *   <li>{@link ShieldContract.MerklePath#hashCode()}
   * </ul>
   */
  @Test
  public void testMerklePathEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShieldContract.MerklePath defaultInstance = ShieldContract.MerklePath.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link ShieldContract.MerklePath#equals(Object)}
   */
  @Test
  public void testMerklePathEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.MerklePath.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link ShieldContract.MerklePath#equals(Object)}
   */
  @Test
  public void testMerklePathEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.MerklePath.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link ShieldContract.MerklePath#equals(Object)}
   */
  @Test
  public void testMerklePathEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.MerklePath.getDefaultInstance(), "Different type to MerklePath");
  }

  /**
   * Method under test:
   * {@link ShieldContract.MerklePath#getAuthenticationPathsCount()}
   */
  @Test
  public void testMerklePathGetAuthenticationPathsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.MerklePath.getDefaultInstance().getAuthenticationPathsCount());
  }

  /**
   * Method under test:
   * {@link ShieldContract.MerklePath#getDefaultInstanceForType()}
   */
  @Test
  public void testMerklePathGetDefaultInstanceForType() {
    // Arrange
    ShieldContract.MerklePath defaultInstance = ShieldContract.MerklePath.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ShieldContract.MerklePath#getIndexCount()}
   */
  @Test
  public void testMerklePathGetIndexCount() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.MerklePath.getDefaultInstance().getIndexCount());
  }

  /**
   * Method under test: {@link ShieldContract.MerklePath#getSerializedSize()}
   */
  @Test
  public void testMerklePathGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.MerklePath.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link ShieldContract.MerklePath#isInitialized()}
   */
  @Test
  public void testMerklePathIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ShieldContract.MerklePath.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ShieldContract.MerklePath#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testMerklePathNewInstance() {
    // Arrange
    ShieldContract.MerklePath defaultInstance = ShieldContract.MerklePath.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ShieldContract.MerklePath);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ShieldContract.MerklePath#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testMerklePathParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.MerklePath.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.MerklePath#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testMerklePathParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.MerklePath.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.MerklePath#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testMerklePathParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.MerklePath.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.MerklePath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMerklePathParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.MerklePath.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.MerklePath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMerklePathParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.MerklePath.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.MerklePath#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMerklePathParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.MerklePath.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link ShieldContract.MerklePath#parseFrom(InputStream)}
   */
  @Test
  public void testMerklePathParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.MerklePath.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link ShieldContract.MerklePath#parseFrom(InputStream)}
   */
  @Test
  public void testMerklePathParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.MerklePath.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.MerklePath#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMerklePathParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.MerklePath.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.MerklePath#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testMerklePathParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.MerklePath.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.OutputPoint#equals(Object)}
   *   <li>{@link ShieldContract.OutputPoint#hashCode()}
   * </ul>
   */
  @Test
  public void testOutputPointEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShieldContract.OutputPoint defaultInstance = ShieldContract.OutputPoint.getDefaultInstance();
    ShieldContract.OutputPoint defaultInstance2 = ShieldContract.OutputPoint.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.OutputPoint#equals(Object)}
   *   <li>{@link ShieldContract.OutputPoint#hashCode()}
   * </ul>
   */
  @Test
  public void testOutputPointEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShieldContract.OutputPoint defaultInstance = ShieldContract.OutputPoint.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link ShieldContract.OutputPoint#equals(Object)}
   */
  @Test
  public void testOutputPointEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.OutputPoint.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link ShieldContract.OutputPoint#equals(Object)}
   */
  @Test
  public void testOutputPointEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.OutputPoint.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link ShieldContract.OutputPoint#equals(Object)}
   */
  @Test
  public void testOutputPointEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.OutputPoint.getDefaultInstance(), "Different type to OutputPoint");
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPoint#getDefaultInstanceForType()}
   */
  @Test
  public void testOutputPointGetDefaultInstanceForType() {
    // Arrange
    ShieldContract.OutputPoint defaultInstance = ShieldContract.OutputPoint.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ShieldContract.OutputPoint#getSerializedSize()}
   */
  @Test
  public void testOutputPointGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.OutputPoint.getDefaultInstance().getSerializedSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.OutputPointInfo#equals(Object)}
   *   <li>{@link ShieldContract.OutputPointInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testOutputPointInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShieldContract.OutputPointInfo defaultInstance = ShieldContract.OutputPointInfo.getDefaultInstance();
    ShieldContract.OutputPointInfo defaultInstance2 = ShieldContract.OutputPointInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.OutputPointInfo#equals(Object)}
   *   <li>{@link ShieldContract.OutputPointInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testOutputPointInfoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShieldContract.OutputPointInfo defaultInstance = ShieldContract.OutputPointInfo.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link ShieldContract.OutputPointInfo#equals(Object)}
   */
  @Test
  public void testOutputPointInfoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.OutputPointInfo.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link ShieldContract.OutputPointInfo#equals(Object)}
   */
  @Test
  public void testOutputPointInfoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.OutputPointInfo.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link ShieldContract.OutputPointInfo#equals(Object)}
   */
  @Test
  public void testOutputPointInfoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.OutputPointInfo.getDefaultInstance(), "Different type to OutputPointInfo");
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPointInfo#getDefaultInstanceForType()}
   */
  @Test
  public void testOutputPointInfoGetDefaultInstanceForType() {
    // Arrange
    ShieldContract.OutputPointInfo defaultInstance = ShieldContract.OutputPointInfo.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ShieldContract.OutputPointInfo#getOutPointsCount()}
   */
  @Test
  public void testOutputPointInfoGetOutPointsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.OutputPointInfo.getDefaultInstance().getOutPointsCount());
  }

  /**
   * Method under test: {@link ShieldContract.OutputPointInfo#getSerializedSize()}
   */
  @Test
  public void testOutputPointInfoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.OutputPointInfo.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link ShieldContract.OutputPointInfo#isInitialized()}
   */
  @Test
  public void testOutputPointInfoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ShieldContract.OutputPointInfo.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPointInfo#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testOutputPointInfoNewInstance() {
    // Arrange
    ShieldContract.OutputPointInfo defaultInstance = ShieldContract.OutputPointInfo.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ShieldContract.OutputPointInfo);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPointInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testOutputPointInfoParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.OutputPointInfo.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPointInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testOutputPointInfoParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.OutputPointInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPointInfo#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testOutputPointInfoParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.OutputPointInfo.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPointInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testOutputPointInfoParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.OutputPointInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPointInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testOutputPointInfoParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.OutputPointInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPointInfo#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testOutputPointInfoParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.OutputPointInfo.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPointInfo#parseFrom(InputStream)}
   */
  @Test
  public void testOutputPointInfoParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.OutputPointInfo.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPointInfo#parseFrom(InputStream)}
   */
  @Test
  public void testOutputPointInfoParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.OutputPointInfo.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPointInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testOutputPointInfoParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.OutputPointInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPointInfo#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testOutputPointInfoParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.OutputPointInfo.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link ShieldContract.OutputPoint#isInitialized()}
   */
  @Test
  public void testOutputPointIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ShieldContract.OutputPoint.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPoint#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testOutputPointNewInstance() {
    // Arrange
    ShieldContract.OutputPoint defaultInstance = ShieldContract.OutputPoint.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ShieldContract.OutputPoint);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPoint#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testOutputPointParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.OutputPoint.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPoint#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testOutputPointParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.OutputPoint.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPoint#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testOutputPointParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.OutputPoint.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testOutputPointParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.OutputPoint.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testOutputPointParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.OutputPoint.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPoint#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testOutputPointParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.OutputPoint.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link ShieldContract.OutputPoint#parseFrom(InputStream)}
   */
  @Test
  public void testOutputPointParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.OutputPoint.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link ShieldContract.OutputPoint#parseFrom(InputStream)}
   */
  @Test
  public void testOutputPointParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.OutputPoint.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPoint#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testOutputPointParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.OutputPoint.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.OutputPoint#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testOutputPointParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.OutputPoint.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.PedersenHash#equals(Object)}
   *   <li>{@link ShieldContract.PedersenHash#hashCode()}
   * </ul>
   */
  @Test
  public void testPedersenHashEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShieldContract.PedersenHash defaultInstance = ShieldContract.PedersenHash.getDefaultInstance();
    ShieldContract.PedersenHash defaultInstance2 = ShieldContract.PedersenHash.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.PedersenHash#equals(Object)}
   *   <li>{@link ShieldContract.PedersenHash#hashCode()}
   * </ul>
   */
  @Test
  public void testPedersenHashEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShieldContract.PedersenHash defaultInstance = ShieldContract.PedersenHash.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link ShieldContract.PedersenHash#equals(Object)}
   */
  @Test
  public void testPedersenHashEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.PedersenHash.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link ShieldContract.PedersenHash#equals(Object)}
   */
  @Test
  public void testPedersenHashEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.PedersenHash.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link ShieldContract.PedersenHash#equals(Object)}
   */
  @Test
  public void testPedersenHashEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.PedersenHash.getDefaultInstance(), "Different type to PedersenHash");
  }

  /**
   * Method under test:
   * {@link ShieldContract.PedersenHash#getDefaultInstanceForType()}
   */
  @Test
  public void testPedersenHashGetDefaultInstanceForType() {
    // Arrange
    ShieldContract.PedersenHash defaultInstance = ShieldContract.PedersenHash.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link ShieldContract.PedersenHash#getSerializedSize()}
   */
  @Test
  public void testPedersenHashGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.PedersenHash.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link ShieldContract.PedersenHash#isInitialized()}
   */
  @Test
  public void testPedersenHashIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ShieldContract.PedersenHash.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ShieldContract.PedersenHash#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testPedersenHashNewInstance() {
    // Arrange
    ShieldContract.PedersenHash defaultInstance = ShieldContract.PedersenHash.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ShieldContract.PedersenHash);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ShieldContract.PedersenHash#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testPedersenHashParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.PedersenHash.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.PedersenHash#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testPedersenHashParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.PedersenHash.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.PedersenHash#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testPedersenHashParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.PedersenHash.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.PedersenHash#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPedersenHashParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.PedersenHash.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.PedersenHash#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPedersenHashParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.PedersenHash.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.PedersenHash#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPedersenHashParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.PedersenHash.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link ShieldContract.PedersenHash#parseFrom(InputStream)}
   */
  @Test
  public void testPedersenHashParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.PedersenHash.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link ShieldContract.PedersenHash#parseFrom(InputStream)}
   */
  @Test
  public void testPedersenHashParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.PedersenHash.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.PedersenHash#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPedersenHashParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.PedersenHash.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.PedersenHash#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testPedersenHashParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.PedersenHash.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.ReceiveDescription#equals(Object)}
   *   <li>{@link ShieldContract.ReceiveDescription#hashCode()}
   * </ul>
   */
  @Test
  public void testReceiveDescriptionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShieldContract.ReceiveDescription defaultInstance = ShieldContract.ReceiveDescription.getDefaultInstance();
    ShieldContract.ReceiveDescription defaultInstance2 = ShieldContract.ReceiveDescription.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.ReceiveDescription#equals(Object)}
   *   <li>{@link ShieldContract.ReceiveDescription#hashCode()}
   * </ul>
   */
  @Test
  public void testReceiveDescriptionEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShieldContract.ReceiveDescription defaultInstance = ShieldContract.ReceiveDescription.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link ShieldContract.ReceiveDescription#equals(Object)}
   */
  @Test
  public void testReceiveDescriptionEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.ReceiveDescription.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link ShieldContract.ReceiveDescription#equals(Object)}
   */
  @Test
  public void testReceiveDescriptionEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.ReceiveDescription.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link ShieldContract.ReceiveDescription#equals(Object)}
   */
  @Test
  public void testReceiveDescriptionEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.ReceiveDescription.getDefaultInstance(), "Different type to ReceiveDescription");
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#getDefaultInstanceForType()}
   */
  @Test
  public void testReceiveDescriptionGetDefaultInstanceForType() {
    // Arrange
    ShieldContract.ReceiveDescription defaultInstance = ShieldContract.ReceiveDescription.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#getSerializedSize()}
   */
  @Test
  public void testReceiveDescriptionGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.ReceiveDescription.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link ShieldContract.ReceiveDescription#isInitialized()}
   */
  @Test
  public void testReceiveDescriptionIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ShieldContract.ReceiveDescription.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testReceiveDescriptionNewInstance() {
    // Arrange
    ShieldContract.ReceiveDescription defaultInstance = ShieldContract.ReceiveDescription.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ShieldContract.ReceiveDescription);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testReceiveDescriptionParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.ReceiveDescription.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testReceiveDescriptionParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.ReceiveDescription.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testReceiveDescriptionParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.ReceiveDescription.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testReceiveDescriptionParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.ReceiveDescription.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testReceiveDescriptionParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.ReceiveDescription.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testReceiveDescriptionParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.ReceiveDescription.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#parseFrom(InputStream)}
   */
  @Test
  public void testReceiveDescriptionParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.ReceiveDescription.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#parseFrom(InputStream)}
   */
  @Test
  public void testReceiveDescriptionParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.ReceiveDescription.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testReceiveDescriptionParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.ReceiveDescription.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.ReceiveDescription#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testReceiveDescriptionParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.ReceiveDescription.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.ShieldedTransferContract#equals(Object)}
   *   <li>{@link ShieldContract.ShieldedTransferContract#hashCode()}
   * </ul>
   */
  @Test
  public void testShieldedTransferContractEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShieldContract.ShieldedTransferContract defaultInstance = ShieldContract.ShieldedTransferContract
        .getDefaultInstance();
    ShieldContract.ShieldedTransferContract defaultInstance2 = ShieldContract.ShieldedTransferContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.ShieldedTransferContract#equals(Object)}
   *   <li>{@link ShieldContract.ShieldedTransferContract#hashCode()}
   * </ul>
   */
  @Test
  public void testShieldedTransferContractEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShieldContract.ShieldedTransferContract defaultInstance = ShieldContract.ShieldedTransferContract
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#equals(Object)}
   */
  @Test
  public void testShieldedTransferContractEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.ShieldedTransferContract.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#equals(Object)}
   */
  @Test
  public void testShieldedTransferContractEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.ShieldedTransferContract.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#equals(Object)}
   */
  @Test
  public void testShieldedTransferContractEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.ShieldedTransferContract.getDefaultInstance(),
        "Different type to ShieldedTransferContract");
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#getDefaultInstanceForType()}
   */
  @Test
  public void testShieldedTransferContractGetDefaultInstanceForType() {
    // Arrange
    ShieldContract.ShieldedTransferContract defaultInstance = ShieldContract.ShieldedTransferContract
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#getReceiveDescriptionCount()}
   */
  @Test
  public void testShieldedTransferContractGetReceiveDescriptionCount() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.ShieldedTransferContract.getDefaultInstance().getReceiveDescriptionCount());
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#getSerializedSize()}
   */
  @Test
  public void testShieldedTransferContractGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.ShieldedTransferContract.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#getSpendDescriptionCount()}
   */
  @Test
  public void testShieldedTransferContractGetSpendDescriptionCount() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.ShieldedTransferContract.getDefaultInstance().getSpendDescriptionCount());
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#isInitialized()}
   */
  @Test
  public void testShieldedTransferContractIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ShieldContract.ShieldedTransferContract.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testShieldedTransferContractNewInstance() {
    // Arrange
    ShieldContract.ShieldedTransferContract defaultInstance = ShieldContract.ShieldedTransferContract
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ShieldContract.ShieldedTransferContract);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testShieldedTransferContractParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.ShieldedTransferContract.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testShieldedTransferContractParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.ShieldedTransferContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testShieldedTransferContractParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.ShieldedTransferContract.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testShieldedTransferContractParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        ShieldContract.ShieldedTransferContract.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testShieldedTransferContractParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.ShieldedTransferContract.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testShieldedTransferContractParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.ShieldedTransferContract
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#parseFrom(InputStream)}
   */
  @Test
  public void testShieldedTransferContractParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.ShieldedTransferContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#parseFrom(InputStream)}
   */
  @Test
  public void testShieldedTransferContractParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.ShieldedTransferContract.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testShieldedTransferContractParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.ShieldedTransferContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.ShieldedTransferContract#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testShieldedTransferContractParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.ShieldedTransferContract.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.SpendDescription#equals(Object)}
   *   <li>{@link ShieldContract.SpendDescription#hashCode()}
   * </ul>
   */
  @Test
  public void testSpendDescriptionEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShieldContract.SpendDescription defaultInstance = ShieldContract.SpendDescription.getDefaultInstance();
    ShieldContract.SpendDescription defaultInstance2 = ShieldContract.SpendDescription.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShieldContract.SpendDescription#equals(Object)}
   *   <li>{@link ShieldContract.SpendDescription#hashCode()}
   * </ul>
   */
  @Test
  public void testSpendDescriptionEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShieldContract.SpendDescription defaultInstance = ShieldContract.SpendDescription.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link ShieldContract.SpendDescription#equals(Object)}
   */
  @Test
  public void testSpendDescriptionEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.SpendDescription.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link ShieldContract.SpendDescription#equals(Object)}
   */
  @Test
  public void testSpendDescriptionEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.SpendDescription.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link ShieldContract.SpendDescription#equals(Object)}
   */
  @Test
  public void testSpendDescriptionEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShieldContract.SpendDescription.getDefaultInstance(), "Different type to SpendDescription");
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#getDefaultInstanceForType()}
   */
  @Test
  public void testSpendDescriptionGetDefaultInstanceForType() {
    // Arrange
    ShieldContract.SpendDescription defaultInstance = ShieldContract.SpendDescription.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#getSerializedSize()}
   */
  @Test
  public void testSpendDescriptionGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ShieldContract.SpendDescription.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link ShieldContract.SpendDescription#isInitialized()}
   */
  @Test
  public void testSpendDescriptionIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ShieldContract.SpendDescription.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  public void testSpendDescriptionNewInstance() {
    // Arrange
    ShieldContract.SpendDescription defaultInstance = ShieldContract.SpendDescription.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ShieldContract.SpendDescription);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testSpendDescriptionParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.SpendDescription.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testSpendDescriptionParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.SpendDescription.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#parseDelimitedFrom(InputStream)}
   */
  @Test
  public void testSpendDescriptionParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.SpendDescription.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSpendDescriptionParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ShieldContract.SpendDescription.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSpendDescriptionParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.SpendDescription.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSpendDescriptionParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.SpendDescription.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#parseFrom(InputStream)}
   */
  @Test
  public void testSpendDescriptionParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ShieldContract.SpendDescription.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#parseFrom(InputStream)}
   */
  @Test
  public void testSpendDescriptionParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ShieldContract.SpendDescription.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSpendDescriptionParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ShieldContract.SpendDescription.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link ShieldContract.SpendDescription#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  public void testSpendDescriptionParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ShieldContract.SpendDescription.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
