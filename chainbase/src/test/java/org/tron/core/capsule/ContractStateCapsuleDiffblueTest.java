package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.contract.SmartContractOuterClass;

public class ContractStateCapsuleDiffblueTest {
  /**
   * Method under test: {@link ContractStateCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{24, 1}, (new ContractStateCapsule(1L)).getData());
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, (new ContractStateCapsule(-1L)).getData());
    assertEquals(0, (new ContractStateCapsule(0L)).getData().length);
    assertArrayEquals(new byte[]{24, -112, 'N'}, (new ContractStateCapsule(10000L)).getData());
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE},
        (new ContractStateCapsule(Long.MAX_VALUE)).getData());
    assertEquals(0,
        (new ContractStateCapsule(SmartContractOuterClass.ContractState.getDefaultInstance())).getData().length);
  }

  /**
   * Method under test: {@link ContractStateCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addEnergyUsage(-1L);

    // Act and Assert
    assertArrayEquals(new byte[]{'\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.setEnergyFactor(42L);
    contractStateCapsule.addEnergyUsage(-1L);

    // Act and Assert
    assertArrayEquals(new byte[]{'\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 16, '*', 24, 1},
        contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#getInstance()}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    SmartContractOuterClass.ContractState actualInstance = (new ContractStateCapsule(1L)).getInstance();

    // Assert
    Descriptors.Descriptor descriptorForType = actualInstance.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
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
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualInstance.getInitializationErrorString());
    SmartContractOuterClass.ContractState defaultInstanceForType5 = actualInstance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType5.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
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
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult4 = dependencies.get(0);
    assertEquals("", getResult4.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ContractState", nameBytes.toStringUtf8());
    assertEquals("ContractState", toProtoResult.getName());
    assertEquals("ContractState", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType7.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("SmartContract", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(7);
    assertEquals("SmartContractDataWrapper", getResult6.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(6);
    assertEquals("UpdateEnergyLimitContract", getResult7.getName());
    assertEquals("core/Tron.proto", getResult4.getFullName());
    assertEquals("core/Tron.proto", getResult4.getName());
    ProtocolStringList dependencyList = toProtoResult3.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("core/Tron.proto", dependencyList.get(0));
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/smart_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/smart_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/smart_contract.proto", file.getFullName());
    assertEquals("core/contract/smart_contract.proto", file.getName());
    assertEquals("energyFactor", getResult2.getJsonName());
    assertEquals("energyUsage", getResult.getJsonName());
    assertEquals("energy_factor", toProtoResult6.getName());
    assertEquals("energy_factor", getResult2.getName());
    assertEquals("energy_usage", toProtoResult2.getName());
    assertEquals("energy_usage", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType7.getFullName());
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
    assertEquals("protocol", getResult4.getPackage());
    assertEquals("protocol.ContractState", descriptorForType.getFullName());
    assertEquals("protocol.ContractState.energy_factor", getResult2.getFullName());
    assertEquals("protocol.ContractState.energy_usage", getResult.getFullName());
    assertEquals("protocol.ContractState.update_cycle", getResult3.getFullName());
    assertEquals("protocol.SmartContract", getResult5.getFullName());
    assertEquals("protocol.SmartContractDataWrapper", getResult6.getFullName());
    assertEquals("protocol.UpdateEnergyLimitContract", getResult7.getFullName());
    assertEquals("updateCycle", getResult3.getJsonName());
    assertEquals("update_cycle", toProtoResult7.getName());
    assertEquals("update_cycle", getResult3.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
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
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
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
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualInstance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, defaultInstanceForType5.getSerializedSize());
    assertEquals(0L, actualInstance.getEnergyFactor());
    assertEquals(0L, defaultInstanceForType5.getEnergyFactor());
    assertEquals(0L, actualInstance.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType5.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType5.getUpdateCycle());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, toProtoResult3.getDependencyCount());
    assertEquals(1, descriptorForType6.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(1, actualInstance.getAllFields().size());
    assertEquals(10, toProtoResult5.getFieldCount());
    assertEquals(10, descriptorForType7.getIndex());
    assertEquals(10, descriptorForType3.getFields().size());
    assertEquals(11, descriptorForType2.getIndex());
    assertEquals(12, descriptorForType5.getIndex());
    assertEquals(1896, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(1L, actualInstance.getUpdateCycle());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(2, actualInstance.getSerializedSize());
    assertEquals(20, toProtoResult2.getSerializedSize());
    assertEquals(20, toProtoResult7.getSerializedSize());
    assertEquals(21, toProtoResult6.getSerializedSize());
    assertEquals(3, toProtoResult.getFieldCount());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult3.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, getResult7.getIndex());
    assertEquals(6, toProtoResult3.getAllFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, getResult6.getIndex());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(8, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    assertEquals(82, toProtoResult.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult4.getEdition());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult4.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
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
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.getProto3Optional());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
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
    assertFalse(descriptorForType6.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
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
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType5.isExtendable());
    assertTrue(descriptorForType7.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = goPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualInstance.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    assertTrue(defaultInstanceForType5.findInitializationErrors().isEmpty());
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
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = defaultInstanceForType5.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualInstance.isInitialized());
    assertTrue(defaultInstanceForType5.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult4.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult4.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
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
    assertEquals('C', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult5.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType6 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType6, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType6, defaultInstanceForType6);
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
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
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
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
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
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(toProtoResult2, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType5.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
  }

  /**
   * Method under test: {@link ContractStateCapsule#getEnergyUsage()}
   */
  @Test
  public void testGetEnergyUsage() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ContractStateCapsule(1L)).getEnergyUsage());
  }

  /**
   * Method under test: {@link ContractStateCapsule#setEnergyUsage(long)}
   */
  @Test
  public void testSetEnergyUsage() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.setEnergyUsage(42L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, contractStateCapsule.getEnergyUsage());
    assertEquals(42L, instance.getEnergyUsage());
    assertArrayEquals(new byte[]{'\b', '*', 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#setEnergyUsage(long)}
   */
  @Test
  public void testSetEnergyUsage2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    // Act
    contractStateCapsule.setEnergyUsage(42L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(42L, contractStateCapsule.getEnergyUsage());
    assertEquals(42L, instance.getEnergyUsage());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{'\b', '*'}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#setEnergyUsage(long)}
   */
  @Test
  public void testSetEnergyUsage3() {
    // Arrange
    SmartContractOuterClass.ContractState contractState = SmartContractOuterClass.ContractState.getDefaultInstance();
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(contractState);

    // Act
    contractStateCapsule.setEnergyUsage(42L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(42L, contractStateCapsule.getEnergyUsage());
    assertEquals(42L, instance.getEnergyUsage());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertSame(contractState, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', '*'}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#setEnergyUsage(long)}
   */
  @Test
  public void testSetEnergyUsage4() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.setEnergyUsage(42L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, contractStateCapsule.getEnergyUsage());
    assertEquals(42L, instance.getEnergyUsage());
    assertArrayEquals(new byte[]{'\b', '*', 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#setEnergyUsage(long)}
   */
  @Test
  public void testSetEnergyUsage5() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.setEnergyFactor(42L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.setEnergyUsage(42L);

    // Assert
    byte[] data = contractStateCapsule.getData();
    assertEquals((byte) 16, data[2]);
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(42L, contractStateCapsule.getEnergyUsage());
    assertEquals(42L, instance.getEnergyUsage());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('*', data[1]);
    assertEquals('*', data[3]);
    assertEquals('\b', data[0]);
  }

  /**
   * Method under test: {@link ContractStateCapsule#addEnergyUsage(long)}
   */
  @Test
  public void testAddEnergyUsage() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.addEnergyUsage(1L);

    // Assert
    assertEquals(1L, contractStateCapsule.getEnergyUsage());
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1L, instance.getEnergyUsage());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#addEnergyUsage(long)}
   */
  @Test
  public void testAddEnergyUsage2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    // Act
    contractStateCapsule.addEnergyUsage(1L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getEnergyUsage());
    assertEquals(1L, instance.getEnergyUsage());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{'\b', 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#addEnergyUsage(long)}
   */
  @Test
  public void testAddEnergyUsage3() {
    // Arrange
    SmartContractOuterClass.ContractState contractState = SmartContractOuterClass.ContractState.getDefaultInstance();
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(contractState);

    // Act
    contractStateCapsule.addEnergyUsage(1L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getEnergyUsage());
    assertEquals(1L, instance.getEnergyUsage());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertSame(contractState, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\b', 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#addEnergyUsage(long)}
   */
  @Test
  public void testAddEnergyUsage4() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.addEnergyUsage(1L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(2L, contractStateCapsule.getEnergyUsage());
    assertEquals(2L, instance.getEnergyUsage());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 2, 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#addEnergyUsage(long)}
   */
  @Test
  public void testAddEnergyUsage5() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.setEnergyFactor(42L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.addEnergyUsage(1L);

    // Assert
    byte[] data = contractStateCapsule.getData();
    assertEquals((byte) 16, data[2]);
    assertEquals(2L, contractStateCapsule.getEnergyUsage());
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2L, instance.getEnergyUsage());
    assertEquals((byte) 2, data[1]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals('*', data[3]);
    assertEquals('\b', data[0]);
  }

  /**
   * Method under test: {@link ContractStateCapsule#getEnergyFactor()}
   */
  @Test
  public void testGetEnergyFactor() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ContractStateCapsule(1L)).getEnergyFactor());
  }

  /**
   * Method under test: {@link ContractStateCapsule#setEnergyFactor(long)}
   */
  @Test
  public void testSetEnergyFactor() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.setEnergyFactor(42L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, contractStateCapsule.getEnergyFactor());
    assertEquals(42L, instance.getEnergyFactor());
    assertArrayEquals(new byte[]{16, '*', 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#setEnergyFactor(long)}
   */
  @Test
  public void testSetEnergyFactor2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    // Act
    contractStateCapsule.setEnergyFactor(42L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(42L, contractStateCapsule.getEnergyFactor());
    assertEquals(42L, instance.getEnergyFactor());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{16, '*'}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#setEnergyFactor(long)}
   */
  @Test
  public void testSetEnergyFactor3() {
    // Arrange
    SmartContractOuterClass.ContractState contractState = SmartContractOuterClass.ContractState.getDefaultInstance();
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(contractState);

    // Act
    contractStateCapsule.setEnergyFactor(42L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(42L, contractStateCapsule.getEnergyFactor());
    assertEquals(42L, instance.getEnergyFactor());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertSame(contractState, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{16, '*'}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#setEnergyFactor(long)}
   */
  @Test
  public void testSetEnergyFactor4() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.setEnergyFactor(42L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(42L, contractStateCapsule.getEnergyFactor());
    assertEquals(42L, instance.getEnergyFactor());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 16, '*', 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#getUpdateCycle()}
   */
  @Test
  public void testGetUpdateCycle() {
    // Arrange, Act and Assert
    assertEquals(1L, (new ContractStateCapsule(1L)).getUpdateCycle());
  }

  /**
   * Method under test: {@link ContractStateCapsule#setUpdateCycle(long)}
   */
  @Test
  public void testSetUpdateCycle() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.setUpdateCycle(42L);

    // Assert
    byte[] data = contractStateCapsule.getData();
    assertEquals(2, data.length);
    assertEquals(42L, contractStateCapsule.getUpdateCycle());
    assertEquals(42L, contractStateCapsule.getInstance().getUpdateCycle());
    assertEquals('*', data[1]);
  }

  /**
   * Method under test: {@link ContractStateCapsule#setUpdateCycle(long)}
   */
  @Test
  public void testSetUpdateCycle2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    // Act
    contractStateCapsule.setUpdateCycle(42L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(42L, contractStateCapsule.getUpdateCycle());
    assertEquals(42L, instance.getUpdateCycle());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{24, '*'}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#setUpdateCycle(long)}
   */
  @Test
  public void testSetUpdateCycle3() {
    // Arrange
    SmartContractOuterClass.ContractState contractState = SmartContractOuterClass.ContractState.getDefaultInstance();
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(contractState);

    // Act
    contractStateCapsule.setUpdateCycle(42L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(42L, contractStateCapsule.getUpdateCycle());
    assertEquals(42L, instance.getUpdateCycle());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertSame(contractState, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, '*'}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#setUpdateCycle(long)}
   */
  @Test
  public void testSetUpdateCycle4() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.setUpdateCycle(42L);

    // Assert
    byte[] data = contractStateCapsule.getData();
    assertEquals((byte) 1, data[1]);
    assertEquals(4, data.length);
    assertEquals(42L, contractStateCapsule.getUpdateCycle());
    assertEquals(42L, contractStateCapsule.getInstance().getUpdateCycle());
    assertEquals('*', data[3]);
  }

  /**
   * Method under test: {@link ContractStateCapsule#setUpdateCycle(long)}
   */
  @Test
  public void testSetUpdateCycle5() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.setEnergyFactor(42L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.setUpdateCycle(42L);

    // Assert
    byte[] data = contractStateCapsule.getData();
    assertEquals((byte) 1, data[1]);
    assertEquals(42L, contractStateCapsule.getUpdateCycle());
    assertEquals(42L, contractStateCapsule.getInstance().getUpdateCycle());
    assertEquals(6, data.length);
    assertEquals('*', data[3]);
    assertEquals('*', data[5]);
  }

  /**
   * Method under test: {@link ContractStateCapsule#addUpdateCycle(long)}
   */
  @Test
  public void testAddUpdateCycle() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.addUpdateCycle(1L);

    // Assert
    byte[] data = contractStateCapsule.getData();
    assertEquals(2, data.length);
    assertEquals(2L, contractStateCapsule.getUpdateCycle());
    assertEquals(2L, contractStateCapsule.getInstance().getUpdateCycle());
    assertEquals((byte) 2, data[1]);
  }

  /**
   * Method under test: {@link ContractStateCapsule#addUpdateCycle(long)}
   */
  @Test
  public void testAddUpdateCycle2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    // Act
    contractStateCapsule.addUpdateCycle(1L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#addUpdateCycle(long)}
   */
  @Test
  public void testAddUpdateCycle3() {
    // Arrange
    SmartContractOuterClass.ContractState contractState = SmartContractOuterClass.ContractState.getDefaultInstance();
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(contractState);

    // Act
    contractStateCapsule.addUpdateCycle(1L);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertSame(contractState, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#addUpdateCycle(long)}
   */
  @Test
  public void testAddUpdateCycle4() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.addUpdateCycle(1L);

    // Assert
    byte[] data = contractStateCapsule.getData();
    assertEquals((byte) 1, data[1]);
    assertEquals(2L, contractStateCapsule.getUpdateCycle());
    assertEquals(2L, contractStateCapsule.getInstance().getUpdateCycle());
    assertEquals((byte) 2, data[3]);
    assertEquals(4, data.length);
  }

  /**
   * Method under test: {@link ContractStateCapsule#addUpdateCycle(long)}
   */
  @Test
  public void testAddUpdateCycle5() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.setEnergyFactor(42L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.addUpdateCycle(1L);

    // Assert
    byte[] data = contractStateCapsule.getData();
    assertEquals((byte) 1, data[1]);
    assertEquals(2L, contractStateCapsule.getUpdateCycle());
    assertEquals(2L, contractStateCapsule.getInstance().getUpdateCycle());
    assertEquals((byte) 2, data[5]);
    assertEquals(6, data.length);
    assertEquals('*', data[3]);
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  public void testCatchUpToCycle() {
    // Arrange, Act and Assert
    assertFalse((new ContractStateCapsule(1L)).catchUpToCycle(1L, 1L, 1L, 1L, true));
    assertTrue((new ContractStateCapsule(Long.MIN_VALUE)).catchUpToCycle(1L, 1L, 1L, 1L, true));
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  public void testCatchUpToCycle2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(1L, 1L, 1L, 1L, true);

    // Assert
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualCatchUpToCycleResult);
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  public void testCatchUpToCycle3() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(1L, 1L, 1L, 1L, true);

    // Assert
    assertEquals(0L, contractStateCapsule.getEnergyUsage());
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(0L, instance.getEnergyUsage());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(actualCatchUpToCycleResult);
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  public void testCatchUpToCycle4() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(10000L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(1L, 1L, 1L, 1L, true);

    // Assert
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1L, instance.getUpdateCycle());
    byte[] data = contractStateCapsule.getData();
    assertEquals((byte) 1, data[1]);
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, data.length);
    assertTrue(actualCatchUpToCycleResult);
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  public void testCatchUpToCycle5() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);
    contractStateCapsule.addEnergyUsage(10000L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(1L, 1L, 1L, 1L, true);

    // Assert
    assertEquals(0L, contractStateCapsule.getEnergyUsage());
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(0L, instance.getEnergyUsage());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(actualCatchUpToCycleResult);
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  public void testCatchUpToCycle6() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(1L, 1L, 1L, 1L, false);

    // Assert
    assertEquals(0L, contractStateCapsule.getEnergyUsage());
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(0L, instance.getEnergyUsage());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(actualCatchUpToCycleResult);
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  public void testCatchUpToCycle7() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    assertFalse(actualCatchUpToCycleResult);
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  public void testCatchUpToCycle8() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(13L);
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, contractStateCapsule.getInstance().getUpdateCycle());
    byte[] data = contractStateCapsule.getData();
    assertEquals((byte) 1, data[1]);
    assertEquals(2, data.length);
    assertTrue(actualCatchUpToCycleResult);
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  public void testCatchUpToCycle9() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualCatchUpToCycleResult);
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  public void testCatchUpToCycle10() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1L, instance.getUpdateCycle());
    byte[] data = contractStateCapsule.getData();
    assertEquals((byte) 1, data[1]);
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, data.length);
    assertTrue(actualCatchUpToCycleResult);
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  public void testCatchUpToCycle11() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(Long.MIN_VALUE);
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    assertTrue(actualCatchUpToCycleResult);
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  public void testCatchUpToCycle12() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(false);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1L, instance.getUpdateCycle());
    byte[] data = contractStateCapsule.getData();
    assertEquals((byte) 1, data[1]);
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, data.length);
    assertTrue(actualCatchUpToCycleResult);
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  public void testCatchUpToCycle13() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(-1L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    SmartContractOuterClass.ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1L, instance.getUpdateCycle());
    byte[] data = contractStateCapsule.getData();
    assertEquals((byte) 1, data[1]);
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, data.length);
    assertTrue(actualCatchUpToCycleResult);
  }

  /**
   * Method under test:
   * {@link ContractStateCapsule#ContractStateCapsule(SmartContractOuterClass.ContractState)}
   */
  @Test
  public void testNewContractStateCapsule() {
    // Arrange
    SmartContractOuterClass.ContractState contractState = SmartContractOuterClass.ContractState.getDefaultInstance();

    // Act and Assert
    assertSame(contractState, (new ContractStateCapsule(contractState)).getInstance());
  }

  /**
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(long)}
   */
  @Test
  public void testNewContractStateCapsule2() {
    // Arrange and Act
    ContractStateCapsule actualContractStateCapsule = new ContractStateCapsule(1L);

    // Assert
    SmartContractOuterClass.ContractState instance = actualContractStateCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
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
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", instance.getInitializationErrorString());
    SmartContractOuterClass.ContractState defaultInstanceForType5 = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType5.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getDefaultValue());
    assertEquals("", toProtoResult2.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", defaultInstanceForType2.getExtendee());
    assertEquals("", toProtoResult2.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", defaultInstanceForType2.getJsonName());
    assertEquals("", toProtoResult2.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", toProtoResult2.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
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
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult4 = dependencies.get(0);
    assertEquals("", getResult4.getEditionName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ContractState", nameBytes.toStringUtf8());
    assertEquals("ContractState", toProtoResult.getName());
    assertEquals("ContractState", descriptorForType.getName());
    assertEquals("DescriptorProto", toProtoResult5.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType7.getName());
    assertEquals("MessageOptions", toProtoResult4.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("SmartContract", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(7);
    assertEquals("SmartContractDataWrapper", getResult6.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(6);
    assertEquals("UpdateEnergyLimitContract", getResult7.getName());
    assertEquals("core/Tron.proto", getResult4.getFullName());
    assertEquals("core/Tron.proto", getResult4.getName());
    ProtocolStringList dependencyList = toProtoResult3.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("core/Tron.proto", dependencyList.get(0));
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/contract/smart_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/smart_contract.proto", toProtoResult3.getName());
    assertEquals("core/contract/smart_contract.proto", file.getFullName());
    assertEquals("core/contract/smart_contract.proto", file.getName());
    assertEquals("energyFactor", getResult2.getJsonName());
    assertEquals("energyUsage", getResult.getJsonName());
    assertEquals("energy_factor", toProtoResult6.getName());
    assertEquals("energy_factor", getResult2.getName());
    assertEquals("energy_usage", toProtoResult2.getName());
    assertEquals("energy_usage", getResult.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType7.getFullName());
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
    assertEquals("protocol", getResult4.getPackage());
    assertEquals("protocol.ContractState", descriptorForType.getFullName());
    assertEquals("protocol.ContractState.energy_factor", getResult2.getFullName());
    assertEquals("protocol.ContractState.energy_usage", getResult.getFullName());
    assertEquals("protocol.ContractState.update_cycle", getResult3.getFullName());
    assertEquals("protocol.SmartContract", getResult5.getFullName());
    assertEquals("protocol.SmartContractDataWrapper", getResult6.getFullName());
    assertEquals("protocol.UpdateEnergyLimitContract", getResult7.getFullName());
    assertEquals("updateCycle", getResult3.getJsonName());
    assertEquals("update_cycle", toProtoResult7.getName());
    assertEquals("update_cycle", getResult3.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult5.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult5.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult5.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
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
    assertEquals(0, toProtoResult2.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType3.getDependencyCount());
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
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = instance.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, defaultInstanceForType5.getSerializedSize());
    assertEquals(0L, actualContractStateCapsule.getEnergyFactor());
    assertEquals(0L, actualContractStateCapsule.getEnergyUsage());
    assertEquals(0L, instance.getEnergyFactor());
    assertEquals(0L, defaultInstanceForType5.getEnergyFactor());
    assertEquals(0L, instance.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType5.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType5.getUpdateCycle());
    assertEquals(1, toProtoResult4.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, toProtoResult3.getDependencyCount());
    assertEquals(1, descriptorForType6.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, toProtoResult5.getFieldCount());
    assertEquals(10, descriptorForType7.getIndex());
    assertEquals(10, descriptorForType3.getFields().size());
    assertEquals(11, descriptorForType2.getIndex());
    assertEquals(12, descriptorForType5.getIndex());
    assertEquals(1896, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(1L, actualContractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, toProtoResult5.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(20, toProtoResult2.getSerializedSize());
    assertEquals(20, toProtoResult7.getSerializedSize());
    assertEquals(21, toProtoResult6.getSerializedSize());
    assertEquals(3, toProtoResult.getFieldCount());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult3.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    assertEquals(4, toProtoResult2.getAllFields().size());
    assertEquals(5, toProtoResult4.getReservedRangeCount());
    assertEquals(500, toProtoResult4.getSerializedSize());
    assertEquals(6, getResult7.getIndex());
    assertEquals(6, toProtoResult3.getAllFields().size());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult4.getFieldCount());
    assertEquals(7, getResult6.getIndex());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(8, toProtoResult3.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    assertEquals(82, toProtoResult.getSerializedSize());
    assertEquals(825, toProtoResult5.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult4.getEdition());
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
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult2.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult4.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
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
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult2.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult2.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult2.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult2.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult2.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult2.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult2.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
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
    assertFalse(descriptorForType6.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
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
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType5.isExtendable());
    assertTrue(descriptorForType7.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = goPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = instance.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    assertTrue(defaultInstanceForType5.findInitializationErrors().isEmpty());
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
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = defaultInstanceForType5.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(instance.isInitialized());
    assertTrue(defaultInstanceForType5.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult4.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult4.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
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
    assertEquals('C', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult5.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType6 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType6, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType6, defaultInstanceForType6);
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
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
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
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
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
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType7.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(toProtoResult2, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType5.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
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
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertArrayEquals(new byte[]{24, 1}, actualContractStateCapsule.getData());
  }

  /**
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  public void testNewContractStateCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  public void testNewContractStateCapsule4() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule("\bXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  public void testNewContractStateCapsule5() {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  public void testNewContractStateCapsule6() {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  public void testNewContractStateCapsule7() {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  public void testNewContractStateCapsule8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  public void testNewContractStateCapsule9() {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  public void testNewContractStateCapsule10() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"))).getInstance());
  }
}
