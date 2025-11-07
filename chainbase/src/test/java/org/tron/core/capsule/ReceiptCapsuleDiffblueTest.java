package org.tron.core.capsule;

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
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class ReceiptCapsuleDiffblueTest {
  @InjectMocks
  private ReceiptCapsule receiptCapsule;

  /**
   * Method under test: {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}
   */
  @Test
  public void testCopyReceipt() {
    // Arrange and Act
    Protocol.ResourceReceipt actualCopyReceiptResult = ReceiptCapsule.copyReceipt(new ReceiptCapsule(null));

    // Assert
    Descriptors.Descriptor descriptorForType = actualCopyReceiptResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(6);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(7);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualCopyReceiptResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult3.getDefaultValue());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult3.getExtendee());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult3.getJsonName());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult3.getTypeName());
    assertEquals("", toProtoResult4.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    Descriptors.FileDescriptor getResult6 = dependencies.get(1);
    assertEquals("", getResult6.getEditionName());
    Descriptors.FileDescriptor getResult7 = dependencies.get(2);
    assertEquals("", getResult7.getEditionName());
    assertEquals(".protocol.Transaction.Result.contractResult", toProtoResult5.getTypeName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    Descriptors.Descriptor getResult8 = messageTypes.get(0);
    assertEquals("AccountId", getResult8.getName());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(2, enumTypes.size());
    Descriptors.EnumDescriptor getResult9 = enumTypes.get(0);
    assertEquals("AccountType", getResult9.getName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType5.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult10 = messageTypes.get(43);
    assertEquals("PBFTCommitResult", getResult10.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Protocol", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Protocol", options.getJavaOuterClassname());
    Descriptors.EnumDescriptor getResult11 = enumTypes.get(1);
    assertEquals("ReasonCode", getResult11.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ResourceReceipt", nameBytes.toStringUtf8());
    assertEquals("ResourceReceipt", toProtoResult.getName());
    assertEquals("ResourceReceipt", descriptorForType.getName());
    Descriptors.Descriptor getResult12 = messageTypes.get(44);
    assertEquals("SRL", getResult12.getName());
    Descriptors.Descriptor getResult13 = messageTypes.get(1);
    assertEquals("Vote", getResult13.getName());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertEquals("contractResult", enumType.getName());
    assertEquals("core/Discover.proto", getResult6.getFullName());
    assertEquals("core/Discover.proto", getResult6.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(3, dependencyList.size());
    assertEquals("core/Discover.proto", dependencyList.get(1));
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("core/Tron.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Tron.proto", toProtoResult2.getName());
    assertEquals("core/Tron.proto", file.getFullName());
    assertEquals("core/Tron.proto", file.getName());
    assertEquals("core/contract/common.proto", getResult7.getFullName());
    assertEquals("core/contract/common.proto", getResult7.getName());
    assertEquals("core/contract/common.proto", dependencyList.get(2));
    assertEquals("energyFee", getResult3.getJsonName());
    assertEquals("energyPenaltyTotal", getResult4.getJsonName());
    assertEquals("energyUsage", getResult2.getJsonName());
    assertEquals("energy_fee", toProtoResult4.getName());
    assertEquals("energy_fee", getResult3.getName());
    assertEquals("energy_penalty_total", toProtoResult6.getName());
    assertEquals("energy_penalty_total", getResult4.getName());
    assertEquals("energy_usage", toProtoResult3.getName());
    assertEquals("energy_usage", getResult2.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf", getResult5.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType5.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/any.proto", getResult5.getFullName());
    assertEquals("google/protobuf/any.proto", getResult5.getName());
    assertEquals("google/protobuf/any.proto", dependencyList.get(0));
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult2.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol", getResult6.getPackage());
    assertEquals("protocol", getResult7.getPackage());
    assertEquals("protocol.AccountId", getResult8.getFullName());
    assertEquals("protocol.AccountType", getResult9.getFullName());
    assertEquals("protocol.PBFTCommitResult", getResult10.getFullName());
    assertEquals("protocol.ReasonCode", getResult11.getFullName());
    assertEquals("protocol.ResourceReceipt", descriptorForType.getFullName());
    assertEquals("protocol.ResourceReceipt.energy_fee", getResult3.getFullName());
    assertEquals("protocol.ResourceReceipt.energy_penalty_total", getResult4.getFullName());
    assertEquals("protocol.ResourceReceipt.energy_usage", getResult2.getFullName());
    assertEquals("protocol.ResourceReceipt.result", getResult.getFullName());
    assertEquals("protocol.SRL", getResult12.getFullName());
    assertEquals("protocol.Transaction.Result.contractResult", enumType.getFullName());
    assertEquals("protocol.Vote", getResult13.getFullName());
    assertEquals("result", toProtoResult5.getName());
    assertEquals("result", getResult.getJsonName());
    assertEquals("result", getResult.getName());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult8.getContainingType());
    assertNull(getResult13.getContainingType());
    assertNull(getResult10.getContainingType());
    assertNull(getResult12.getContainingType());
    assertNull(getResult9.getContainingType());
    assertNull(getResult11.getContainingType());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult3.getOneofIndex());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult8.getIndex());
    assertEquals(0, getResult9.getIndex());
    assertEquals(0, getResult2.getIndex());
    UnknownFieldSet unknownFields = actualCopyReceiptResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualCopyReceiptResult.getResultValue());
    assertEquals(0, actualCopyReceiptResult.getSerializedSize());
    assertEquals(0L, actualCopyReceiptResult.getEnergyFee());
    assertEquals(0L, actualCopyReceiptResult.getEnergyPenaltyTotal());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsage());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsageTotal());
    assertEquals(0L, actualCopyReceiptResult.getNetFee());
    assertEquals(0L, actualCopyReceiptResult.getNetUsage());
    assertEquals(0L, actualCopyReceiptResult.getOriginEnergyUsage());
    assertEquals(1, toProtoResult3.getNumber());
    assertEquals(1, descriptorForType4.getIndex());
    assertEquals(1, getResult13.getIndex());
    assertEquals(1, enumType.getIndex());
    assertEquals(1, getResult11.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult2.getNumber());
    assertEquals(10, descriptorForType5.getIndex());
    assertEquals(11, descriptorForType2.getIndex());
    assertEquals(17305, toProtoResult2.getSerializedSize());
    assertEquals(18, toProtoResult4.getSerializedSize());
    assertEquals(2, toProtoResult4.getNumber());
    assertEquals(2, toProtoResult2.getEnumTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(2, enumTypeList.size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(20, toProtoResult3.getSerializedSize());
    assertEquals(23, descriptorForType.getIndex());
    assertEquals(243, toProtoResult.getSerializedSize());
    assertEquals(28, toProtoResult6.getSerializedSize());
    assertEquals(3, toProtoResult2.getDependencyCount());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(43, getResult10.getIndex());
    assertEquals(44, getResult12.getIndex());
    assertEquals(45, toProtoResult2.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(45, messageTypeList.size());
    assertEquals(59, toProtoResult5.getSerializedSize());
    assertEquals(6, getResult.getIndex());
    assertEquals(7, toProtoResult5.getNumber());
    assertEquals(7, getResult4.getIndex());
    assertEquals(7, getResult.getNumber());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, toProtoResult2.getAllFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(8, toProtoResult.getFieldCount());
    assertEquals(8, toProtoResult6.getNumber());
    assertEquals(8, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(8, fieldList.size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult6.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult7.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult3.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult3.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult6.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult7.getSyntax());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertEquals(Protocol.Transaction.Result.contractResult.DEFAULT, actualCopyReceiptResult.getResult());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult3.getProto3Optional());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult3.hasDefaultValue());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult3.hasExtendee());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult3.hasJsonName());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult3.hasOneofIndex());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult3.hasProto3Optional());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult3.hasTypeName());
    assertFalse(toProtoResult4.hasTypeName());
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
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
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
    assertFalse(descriptorForType4.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult8.isExtendable());
    assertFalse(getResult13.isExtendable());
    assertFalse(getResult10.isExtendable());
    assertFalse(getResult12.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult9.isClosed());
    assertFalse(getResult11.isClosed());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult3.hasLabel());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult3.hasNumber());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult3.hasType());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult5.hasTypeName());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType5.isExtendable());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult.isOptional());
    assertTrue(getResult4.isOptional());
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
    ByteString.ByteIterator iteratorResult6 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteString.ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualCopyReceiptResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualCopyReceiptResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualCopyReceiptResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, features.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult8.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult13.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult10.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult12.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult8.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult13.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult10.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult12.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult13.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult10.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult12.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult8.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult13.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult10.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult12.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult13.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult10.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult12.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult6.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult7.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getMessageTypes());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult6.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult7.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult5.getServices());
    assertEquals(findInitializationErrorsResult, getResult6.getServices());
    assertEquals(findInitializationErrorsResult, getResult7.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult3.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, features.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, features.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualCopyReceiptResult, actualCopyReceiptResult.getDefaultInstanceForType());
    assertEquals('P', iteratorResult6.next().byteValue());
    assertEquals('R', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult2.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals('g', iteratorResult5.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult13.getFile());
    assertSame(file, getResult10.getFile());
    assertSame(file, getResult12.getFile());
    assertSame(file, enumType.getFile());
    assertSame(file, getResult9.getFile());
    assertSame(file, getResult11.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, getResult8.getOptions());
    assertSame(options4, getResult13.getOptions());
    assertSame(options4, getResult10.getOptions());
    assertSame(options4, getResult12.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Method under test:
   * {@link ReceiptCapsule#checkForEnergyLimit(DynamicPropertiesStore)}
   */
  @Test
  public void testCheckForEnergyLimit() {
    // Arrange
    DynamicPropertiesStore ds = mock(DynamicPropertiesStore.class);
    when(ds.getLatestBlockHeaderNumber()).thenReturn(1L);

    // Act
    boolean actualCheckForEnergyLimitResult = ReceiptCapsule.checkForEnergyLimit(ds);

    // Assert
    verify(ds).getLatestBlockHeaderNumber();
    assertTrue(actualCheckForEnergyLimitResult);
  }

  /**
   * Method under test:
   * {@link ReceiptCapsule#checkForEnergyLimit(DynamicPropertiesStore)}
   */
  @Test
  public void testCheckForEnergyLimit2() {
    // Arrange
    DynamicPropertiesStore ds = mock(DynamicPropertiesStore.class);
    when(ds.getLatestBlockHeaderNumber()).thenReturn(-1L);

    // Act
    boolean actualCheckForEnergyLimitResult = ReceiptCapsule.checkForEnergyLimit(ds);

    // Assert
    verify(ds).getLatestBlockHeaderNumber();
    assertFalse(actualCheckForEnergyLimitResult);
  }

  /**
   * Method under test: {@link ReceiptCapsule#addNetFee(long)}
   */
  @Test
  public void testAddNetFee() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.addNetFee(1L);

    // Assert
    Protocol.ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getNetFee());
    assertEquals(1L, receipt.getNetFee());
    assertEquals(2, receipt.getSerializedSize());
    Descriptors.Descriptor descriptorForType = receipt.getDescriptorForType();
    assertEquals(8, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
  }

  /**
   * Method under test: {@link ReceiptCapsule#getEnergyUsage()}
   */
  @Test
  public void testGetEnergyUsage() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getEnergyUsage());
  }

  /**
   * Method under test: {@link ReceiptCapsule#setEnergyUsage(long)}
   */
  @Test
  public void testSetEnergyUsage() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setEnergyUsage(1L);

    // Assert
    Protocol.ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getEnergyUsage());
    assertEquals(1L, receipt.getEnergyUsage());
    assertEquals(2, receipt.getSerializedSize());
    Descriptors.Descriptor descriptorForType = receipt.getDescriptorForType();
    assertEquals(8, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
  }

  /**
   * Method under test: {@link ReceiptCapsule#getEnergyFee()}
   */
  @Test
  public void testGetEnergyFee() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getEnergyFee());
  }

  /**
   * Method under test: {@link ReceiptCapsule#setEnergyFee(long)}
   */
  @Test
  public void testSetEnergyFee() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setEnergyFee(1L);

    // Assert
    Protocol.ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getEnergyFee());
    assertEquals(1L, receipt.getEnergyFee());
    assertEquals(2, receipt.getSerializedSize());
    Descriptors.Descriptor descriptorForType = receipt.getDescriptorForType();
    assertEquals(8, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
  }

  /**
   * Method under test: {@link ReceiptCapsule#getOriginEnergyUsage()}
   */
  @Test
  public void testGetOriginEnergyUsage() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getOriginEnergyUsage());
  }

  /**
   * Method under test: {@link ReceiptCapsule#setOriginEnergyUsage(long)}
   */
  @Test
  public void testSetOriginEnergyUsage() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setOriginEnergyUsage(1L);

    // Assert
    Protocol.ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getOriginEnergyUsage());
    assertEquals(1L, receipt.getOriginEnergyUsage());
    assertEquals(2, receipt.getSerializedSize());
    Descriptors.Descriptor descriptorForType = receipt.getDescriptorForType();
    assertEquals(8, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
  }

  /**
   * Method under test: {@link ReceiptCapsule#getEnergyUsageTotal()}
   */
  @Test
  public void testGetEnergyUsageTotal() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getEnergyUsageTotal());
  }

  /**
   * Method under test: {@link ReceiptCapsule#setEnergyUsageTotal(long)}
   */
  @Test
  public void testSetEnergyUsageTotal() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setEnergyUsageTotal(1L);

    // Assert
    Protocol.ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getEnergyUsageTotal());
    assertEquals(1L, receipt.getEnergyUsageTotal());
    assertEquals(2, receipt.getSerializedSize());
    Descriptors.Descriptor descriptorForType = receipt.getDescriptorForType();
    assertEquals(8, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
  }

  /**
   * Method under test: {@link ReceiptCapsule#getEnergyPenaltyTotal()}
   */
  @Test
  public void testGetEnergyPenaltyTotal() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getEnergyPenaltyTotal());
  }

  /**
   * Method under test: {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}
   */
  @Test
  public void testSetEnergyPenaltyTotal() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setEnergyPenaltyTotal(1L);

    // Assert
    Protocol.ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getEnergyPenaltyTotal());
    assertEquals(1L, receipt.getEnergyPenaltyTotal());
    assertEquals(2, receipt.getSerializedSize());
    Descriptors.Descriptor descriptorForType = receipt.getDescriptorForType();
    assertEquals(8, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
  }

  /**
   * Method under test: {@link ReceiptCapsule#getNetUsage()}
   */
  @Test
  public void testGetNetUsage() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getNetUsage());
  }

  /**
   * Method under test: {@link ReceiptCapsule#setNetUsage(long)}
   */
  @Test
  public void testSetNetUsage() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setNetUsage(1L);

    // Assert
    Protocol.ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getNetUsage());
    assertEquals(1L, receipt.getNetUsage());
    assertEquals(2, receipt.getSerializedSize());
    Descriptors.Descriptor descriptorForType = receipt.getDescriptorForType();
    assertEquals(8, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
  }

  /**
   * Method under test: {@link ReceiptCapsule#getNetFee()}
   */
  @Test
  public void testGetNetFee() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getNetFee());
  }

  /**
   * Method under test: {@link ReceiptCapsule#setNetFee(long)}
   */
  @Test
  public void testSetNetFee() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setNetFee(1L);

    // Assert
    Protocol.ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getNetFee());
    assertEquals(1L, receipt.getNetFee());
    assertEquals(2, receipt.getSerializedSize());
    Descriptors.Descriptor descriptorForType = receipt.getDescriptorForType();
    assertEquals(8, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
  }

  /**
   * Method under test: {@link ReceiptCapsule#getResult()}
   */
  @Test
  public void testGetResult() {
    // Arrange, Act and Assert
    assertEquals(Protocol.Transaction.Result.contractResult.DEFAULT, (new ReceiptCapsule(null)).getResult());
  }

  /**
   * Method under test:
   * {@link ReceiptCapsule#setResult(Protocol.Transaction.Result.contractResult)}
   */
  @Test
  public void testSetResult() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setResult(Protocol.Transaction.Result.contractResult.DEFAULT);

    // Assert
    Protocol.ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(receipt, receipt.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ReceiptCapsule#setResult(Protocol.Transaction.Result.contractResult)}
   */
  @Test
  public void testSetResult2() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setResult(Protocol.Transaction.Result.contractResult.DEFAULT);

    // Assert
    Protocol.ResourceReceipt defaultInstanceForType = receiptCapsule.getReceipt().getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getResultValue());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getEnergyFee());
    assertEquals(0L, defaultInstanceForType.getEnergyPenaltyTotal());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyUsageTotal());
    assertEquals(0L, defaultInstanceForType.getNetFee());
    assertEquals(0L, defaultInstanceForType.getNetUsage());
    assertEquals(0L, defaultInstanceForType.getOriginEnergyUsage());
    assertEquals(Protocol.Transaction.Result.contractResult.DEFAULT, defaultInstanceForType.getResult());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ReceiptCapsule#setResult(Protocol.Transaction.Result.contractResult)}
   */
  @Test
  public void testSetResult3() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setResult(Protocol.Transaction.Result.contractResult.DEFAULT);

    // Assert
    Protocol.ResourceReceipt defaultInstanceForType = receiptCapsule.getReceipt().getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getResultValue());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getEnergyFee());
    assertEquals(0L, defaultInstanceForType.getEnergyPenaltyTotal());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyUsageTotal());
    assertEquals(0L, defaultInstanceForType.getNetFee());
    assertEquals(0L, defaultInstanceForType.getNetUsage());
    assertEquals(0L, defaultInstanceForType.getOriginEnergyUsage());
    assertEquals(Protocol.Transaction.Result.contractResult.DEFAULT, defaultInstanceForType.getResult());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ReceiptCapsule#setResult(Protocol.Transaction.Result.contractResult)}
   */
  @Test
  public void testSetResult4() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyFee(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setResult(Protocol.Transaction.Result.contractResult.DEFAULT);

    // Assert
    Protocol.ResourceReceipt defaultInstanceForType = receiptCapsule.getReceipt().getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getResultValue());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getEnergyFee());
    assertEquals(0L, defaultInstanceForType.getEnergyPenaltyTotal());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyUsageTotal());
    assertEquals(0L, defaultInstanceForType.getNetFee());
    assertEquals(0L, defaultInstanceForType.getNetUsage());
    assertEquals(0L, defaultInstanceForType.getOriginEnergyUsage());
    assertEquals(Protocol.Transaction.Result.contractResult.DEFAULT, defaultInstanceForType.getResult());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ReceiptCapsule#setResult(Protocol.Transaction.Result.contractResult)}
   */
  @Test
  public void testSetResult5() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setOriginEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setResult(Protocol.Transaction.Result.contractResult.DEFAULT);

    // Assert
    Protocol.ResourceReceipt defaultInstanceForType = receiptCapsule.getReceipt().getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getResultValue());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getEnergyFee());
    assertEquals(0L, defaultInstanceForType.getEnergyPenaltyTotal());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyUsageTotal());
    assertEquals(0L, defaultInstanceForType.getNetFee());
    assertEquals(0L, defaultInstanceForType.getNetUsage());
    assertEquals(0L, defaultInstanceForType.getOriginEnergyUsage());
    assertEquals(Protocol.Transaction.Result.contractResult.DEFAULT, defaultInstanceForType.getResult());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ReceiptCapsule#setResult(Protocol.Transaction.Result.contractResult)}
   */
  @Test
  public void testSetResult6() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsageTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setResult(Protocol.Transaction.Result.contractResult.DEFAULT);

    // Assert
    Protocol.ResourceReceipt defaultInstanceForType = receiptCapsule.getReceipt().getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getResultValue());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getEnergyFee());
    assertEquals(0L, defaultInstanceForType.getEnergyPenaltyTotal());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyUsageTotal());
    assertEquals(0L, defaultInstanceForType.getNetFee());
    assertEquals(0L, defaultInstanceForType.getNetUsage());
    assertEquals(0L, defaultInstanceForType.getOriginEnergyUsage());
    assertEquals(Protocol.Transaction.Result.contractResult.DEFAULT, defaultInstanceForType.getResult());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ReceiptCapsule#setResult(Protocol.Transaction.Result.contractResult)}
   */
  @Test
  public void testSetResult7() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyPenaltyTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setResult(Protocol.Transaction.Result.contractResult.DEFAULT);

    // Assert
    Protocol.ResourceReceipt defaultInstanceForType = receiptCapsule.getReceipt().getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getResultValue());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getEnergyFee());
    assertEquals(0L, defaultInstanceForType.getEnergyPenaltyTotal());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyUsageTotal());
    assertEquals(0L, defaultInstanceForType.getNetFee());
    assertEquals(0L, defaultInstanceForType.getNetUsage());
    assertEquals(0L, defaultInstanceForType.getOriginEnergyUsage());
    assertEquals(Protocol.Transaction.Result.contractResult.DEFAULT, defaultInstanceForType.getResult());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ReceiptCapsule#setResult(Protocol.Transaction.Result.contractResult)}
   */
  @Test
  public void testSetResult8() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setNetUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setResult(Protocol.Transaction.Result.contractResult.DEFAULT);

    // Assert
    Protocol.ResourceReceipt defaultInstanceForType = receiptCapsule.getReceipt().getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getResultValue());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getEnergyFee());
    assertEquals(0L, defaultInstanceForType.getEnergyPenaltyTotal());
    assertEquals(0L, defaultInstanceForType.getEnergyUsage());
    assertEquals(0L, defaultInstanceForType.getEnergyUsageTotal());
    assertEquals(0L, defaultInstanceForType.getNetFee());
    assertEquals(0L, defaultInstanceForType.getNetUsage());
    assertEquals(0L, defaultInstanceForType.getOriginEnergyUsage());
    assertEquals(Protocol.Transaction.Result.contractResult.DEFAULT, defaultInstanceForType.getResult());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link ReceiptCapsule#setResult(Protocol.Transaction.Result.contractResult)}
   */
  @Test
  public void testSetResult9() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    Protocol.ResourceReceipt receipt = Protocol.ResourceReceipt.getDefaultInstance();
    receiptCapsule.setReceipt(receipt);

    // Act
    receiptCapsule.setResult(Protocol.Transaction.Result.contractResult.DEFAULT);

    // Assert
    assertEquals(receipt, receiptCapsule.getReceipt());
  }

  /**
   * Method under test: {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)}
   */
  @Test
  public void testNewReceiptCapsule() {
    // Arrange and Act
    ReceiptCapsule actualReceiptCapsule = new ReceiptCapsule(null);

    // Assert
    Protocol.ResourceReceipt receipt = actualReceiptCapsule.getReceipt();
    Descriptors.Descriptor descriptorForType = receipt.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(6);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(7);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", receipt.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult3.getDefaultValue());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult3.getExtendee());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult3.getJsonName());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult3.getTypeName());
    assertEquals("", toProtoResult4.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    Descriptors.FileDescriptor getResult6 = dependencies.get(1);
    assertEquals("", getResult6.getEditionName());
    Descriptors.FileDescriptor getResult7 = dependencies.get(2);
    assertEquals("", getResult7.getEditionName());
    assertEquals(".protocol.Transaction.Result.contractResult", toProtoResult5.getTypeName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    Descriptors.Descriptor getResult8 = messageTypes.get(0);
    assertEquals("AccountId", getResult8.getName());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(2, enumTypes.size());
    Descriptors.EnumDescriptor getResult9 = enumTypes.get(0);
    assertEquals("AccountType", getResult9.getName());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType2.getName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = options2.getDescriptorForType();
    assertEquals("MessageOptions", descriptorForType5.getName());
    Descriptors.Descriptor getResult10 = messageTypes.get(43);
    assertEquals("PBFTCommitResult", getResult10.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Protocol", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Protocol", options.getJavaOuterClassname());
    Descriptors.EnumDescriptor getResult11 = enumTypes.get(1);
    assertEquals("ReasonCode", getResult11.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ResourceReceipt", nameBytes.toStringUtf8());
    assertEquals("ResourceReceipt", toProtoResult.getName());
    assertEquals("ResourceReceipt", descriptorForType.getName());
    Descriptors.Descriptor getResult12 = messageTypes.get(44);
    assertEquals("SRL", getResult12.getName());
    Descriptors.Descriptor getResult13 = messageTypes.get(1);
    assertEquals("Vote", getResult13.getName());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertEquals("contractResult", enumType.getName());
    assertEquals("core/Discover.proto", getResult6.getFullName());
    assertEquals("core/Discover.proto", getResult6.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(3, dependencyList.size());
    assertEquals("core/Discover.proto", dependencyList.get(1));
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("core/Tron.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Tron.proto", toProtoResult2.getName());
    assertEquals("core/Tron.proto", file.getFullName());
    assertEquals("core/Tron.proto", file.getName());
    assertEquals("core/contract/common.proto", getResult7.getFullName());
    assertEquals("core/contract/common.proto", getResult7.getName());
    assertEquals("core/contract/common.proto", dependencyList.get(2));
    assertEquals("energyFee", getResult3.getJsonName());
    assertEquals("energyPenaltyTotal", getResult4.getJsonName());
    assertEquals("energyUsage", getResult2.getJsonName());
    assertEquals("energy_fee", toProtoResult4.getName());
    assertEquals("energy_fee", getResult3.getName());
    assertEquals("energy_penalty_total", toProtoResult6.getName());
    assertEquals("energy_penalty_total", getResult4.getName());
    assertEquals("energy_usage", toProtoResult3.getName());
    assertEquals("energy_usage", getResult2.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", getResult5.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType2.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType4.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType5.getFullName());
    assertEquals("google/protobuf/any.proto", getResult5.getFullName());
    assertEquals("google/protobuf/any.proto", getResult5.getName());
    assertEquals("google/protobuf/any.proto", dependencyList.get(0));
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    assertEquals("proto3", toProtoResult2.getSyntax());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult2.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol", getResult6.getPackage());
    assertEquals("protocol", getResult7.getPackage());
    assertEquals("protocol.AccountId", getResult8.getFullName());
    assertEquals("protocol.AccountType", getResult9.getFullName());
    assertEquals("protocol.PBFTCommitResult", getResult10.getFullName());
    assertEquals("protocol.ReasonCode", getResult11.getFullName());
    assertEquals("protocol.ResourceReceipt", descriptorForType.getFullName());
    assertEquals("protocol.ResourceReceipt.energy_fee", getResult3.getFullName());
    assertEquals("protocol.ResourceReceipt.energy_penalty_total", getResult4.getFullName());
    assertEquals("protocol.ResourceReceipt.energy_usage", getResult2.getFullName());
    assertEquals("protocol.ResourceReceipt.result", getResult.getFullName());
    assertEquals("protocol.SRL", getResult12.getFullName());
    assertEquals("protocol.Transaction.Result.contractResult", enumType.getFullName());
    assertEquals("protocol.Vote", getResult13.getFullName());
    assertEquals("result", toProtoResult5.getName());
    assertEquals("result", getResult.getJsonName());
    assertEquals("result", getResult.getName());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult8.getContainingType());
    assertNull(getResult13.getContainingType());
    assertNull(getResult10.getContainingType());
    assertNull(getResult12.getContainingType());
    assertNull(getResult9.getContainingType());
    assertNull(getResult11.getContainingType());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(actualReceiptCapsule.getReceiptAddress());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult3.getOneofIndex());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult8.getIndex());
    assertEquals(0, getResult9.getIndex());
    assertEquals(0, getResult2.getIndex());
    UnknownFieldSet unknownFields = receipt.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, receipt.getResultValue());
    assertEquals(0, receipt.getSerializedSize());
    assertEquals(0L, actualReceiptCapsule.getCallerEnergyMergedUsage());
    assertEquals(0L, actualReceiptCapsule.getCallerEnergyMergedWindowSize());
    assertEquals(0L, actualReceiptCapsule.getCallerEnergyUsage());
    assertEquals(0L, actualReceiptCapsule.getCallerEnergyWindowSize());
    assertEquals(0L, actualReceiptCapsule.getCallerEnergyWindowSizeV2());
    assertEquals(0L, actualReceiptCapsule.getEnergyFee());
    assertEquals(0L, actualReceiptCapsule.getEnergyPenaltyTotal());
    assertEquals(0L, actualReceiptCapsule.getEnergyUsage());
    assertEquals(0L, actualReceiptCapsule.getEnergyUsageTotal());
    assertEquals(0L, actualReceiptCapsule.getMemoFee());
    assertEquals(0L, actualReceiptCapsule.getMultiSignFee());
    assertEquals(0L, actualReceiptCapsule.getNetFee());
    assertEquals(0L, actualReceiptCapsule.getNetUsage());
    assertEquals(0L, actualReceiptCapsule.getOriginEnergyMergedUsage());
    assertEquals(0L, actualReceiptCapsule.getOriginEnergyMergedWindowSize());
    assertEquals(0L, actualReceiptCapsule.getOriginEnergyUsage());
    assertEquals(0L, actualReceiptCapsule.getOriginEnergyWindowSize());
    assertEquals(0L, actualReceiptCapsule.getOriginEnergyWindowSizeV2());
    assertEquals(0L, receipt.getEnergyFee());
    assertEquals(0L, receipt.getEnergyPenaltyTotal());
    assertEquals(0L, receipt.getEnergyUsage());
    assertEquals(0L, receipt.getEnergyUsageTotal());
    assertEquals(0L, receipt.getNetFee());
    assertEquals(0L, receipt.getNetUsage());
    assertEquals(0L, receipt.getOriginEnergyUsage());
    assertEquals(1, toProtoResult3.getNumber());
    assertEquals(1, descriptorForType3.getIndex());
    assertEquals(1, getResult13.getIndex());
    assertEquals(1, enumType.getIndex());
    assertEquals(1, getResult11.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult2.getNumber());
    assertEquals(10, descriptorForType4.getIndex());
    assertEquals(11, descriptorForType5.getIndex());
    assertEquals(17305, toProtoResult2.getSerializedSize());
    assertEquals(18, toProtoResult4.getSerializedSize());
    assertEquals(2, toProtoResult4.getNumber());
    assertEquals(2, toProtoResult2.getEnumTypeCount());
    assertEquals(2, descriptorForType2.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(2, enumTypeList.size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(20, toProtoResult3.getSerializedSize());
    assertEquals(23, descriptorForType.getIndex());
    assertEquals(243, toProtoResult.getSerializedSize());
    assertEquals(28, toProtoResult6.getSerializedSize());
    assertEquals(3, toProtoResult2.getDependencyCount());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(43, getResult10.getIndex());
    assertEquals(44, getResult12.getIndex());
    assertEquals(45, toProtoResult2.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(45, messageTypeList.size());
    assertEquals(59, toProtoResult5.getSerializedSize());
    assertEquals(6, getResult.getIndex());
    assertEquals(7, toProtoResult5.getNumber());
    assertEquals(7, getResult4.getIndex());
    assertEquals(7, getResult.getNumber());
    assertEquals(7, toProtoResult2.getAllFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(8, toProtoResult.getFieldCount());
    assertEquals(8, toProtoResult6.getNumber());
    assertEquals(8, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(8, fieldList.size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult6.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult7.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult3.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult3.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult6.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult7.getSyntax());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertEquals(Protocol.Transaction.Result.contractResult.DEFAULT, actualReceiptCapsule.getResult());
    assertEquals(Protocol.Transaction.Result.contractResult.DEFAULT, receipt.getResult());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult3.getProto3Optional());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult3.hasDefaultValue());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult3.hasExtendee());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult3.hasJsonName());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult3.hasOneofIndex());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult3.hasProto3Optional());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult3.hasTypeName());
    assertFalse(toProtoResult4.hasTypeName());
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
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
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
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult8.isExtendable());
    assertFalse(getResult13.isExtendable());
    assertFalse(getResult10.isExtendable());
    assertFalse(getResult12.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult9.isClosed());
    assertFalse(getResult11.isClosed());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult3.hasLabel());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult3.hasNumber());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult3.hasType());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult5.hasTypeName());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(descriptorForType5.isExtendable());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = goPackageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = receipt.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = receipt.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(receipt.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, features.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult8.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult13.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult10.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult12.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult8.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult13.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult10.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult12.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult13.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult10.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult12.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult8.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult13.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult10.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult12.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult13.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult10.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult12.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult6.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult7.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getMessageTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult6.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult7.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getServices());
    assertEquals(findInitializationErrorsResult, getResult6.getServices());
    assertEquals(findInitializationErrorsResult, getResult7.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult3.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, features.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, features.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(receipt, receipt.getDefaultInstanceForType());
    assertEquals('P', iteratorResult5.next().byteValue());
    assertEquals('R', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult4.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult13.getFile());
    assertSame(file, getResult10.getFile());
    assertSame(file, getResult12.getFile());
    assertSame(file, enumType.getFile());
    assertSame(file, getResult9.getFile());
    assertSame(file, getResult11.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType5.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, getResult8.getOptions());
    assertSame(options4, getResult13.getOptions());
    assertSame(options4, getResult10.getOptions());
    assertSame(options4, getResult12.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
  }
}
