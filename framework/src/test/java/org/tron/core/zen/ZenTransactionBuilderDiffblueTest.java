package org.tron.core.zen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.Edition;
import com.google.protobuf.DescriptorProtos.FeatureSet;
import com.google.protobuf.DescriptorProtos.FeatureSet.EnumType;
import com.google.protobuf.DescriptorProtos.FeatureSet.FieldPresence;
import com.google.protobuf.DescriptorProtos.FeatureSet.JsonFormat;
import com.google.protobuf.DescriptorProtos.FeatureSet.MessageEncoding;
import com.google.protobuf.DescriptorProtos.FeatureSet.RepeatedFieldEncoding;
import com.google.protobuf.DescriptorProtos.FeatureSet.Utf8Validation;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type;
import com.google.protobuf.DescriptorProtos.FieldOptions;
import com.google.protobuf.DescriptorProtos.FieldOptions.CType;
import com.google.protobuf.DescriptorProtos.FieldOptions.JSType;
import com.google.protobuf.DescriptorProtos.FieldOptions.OptionRetention;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.DescriptorProtos.FileOptions.OptimizeMode;
import com.google.protobuf.DescriptorProtos.MessageOptions;
import com.google.protobuf.DescriptorProtos.SourceCodeInfo;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.Syntax;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat.FieldType;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.Wallet;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.ShieldedTransferContract;
import org.tron.protos.contract.ShieldContract.ShieldedTransferContract.Builder;

public class ZenTransactionBuilderDiffblueTest {
  /**
   * Test {@link ZenTransactionBuilder#ZenTransactionBuilder()}.
   *
   * <p>Method under test: {@link ZenTransactionBuilder#ZenTransactionBuilder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZenTransactionBuilder.<init>()"})
  public void testNewZenTransactionBuilder2() {
    // Arrange and Act
    ZenTransactionBuilder actualZenTransactionBuilder = new ZenTransactionBuilder();

    // Assert
    assertNull(actualZenTransactionBuilder.getFrom());
    assertEquals(0L, actualZenTransactionBuilder.getTimeout());
    assertEquals(0L, actualZenTransactionBuilder.getValueBalance());
    assertTrue(actualZenTransactionBuilder.getReceives().isEmpty());
    assertTrue(actualZenTransactionBuilder.getSpends().isEmpty());
  }

  /**
   * Test {@link ZenTransactionBuilder#ZenTransactionBuilder(Wallet)}.
   *
   * <p>Method under test: {@link ZenTransactionBuilder#ZenTransactionBuilder(Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZenTransactionBuilder.<init>(Wallet)"})
  public void testNewZenTransactionBuilder3() {
    // Arrange and Act
    ZenTransactionBuilder actualZenTransactionBuilder = new ZenTransactionBuilder(new Wallet());

    // Assert
    assertNull(actualZenTransactionBuilder.getFrom());
    assertEquals(0L, actualZenTransactionBuilder.getTimeout());
    assertEquals(0L, actualZenTransactionBuilder.getValueBalance());
    assertTrue(actualZenTransactionBuilder.getReceives().isEmpty());
    assertTrue(actualZenTransactionBuilder.getSpends().isEmpty());
  }

  /**
   * Test {@link ZenTransactionBuilder#setTransparentInput(byte[], long)}.
   *
   * <p>Method under test: {@link ZenTransactionBuilder#setTransparentInput(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZenTransactionBuilder.setTransparentInput(byte[], long)"})
  public void testSetTransparentInput() throws UnsupportedEncodingException {
    // Arrange
    ZenTransactionBuilder zenTransactionBuilder = new ZenTransactionBuilder();

    // Act
    zenTransactionBuilder.setTransparentInput("AXAXAXAX".getBytes("UTF-8"), 42L);

    // Assert
    Builder contractBuilder = zenTransactionBuilder.getContractBuilder();
    ByteString transparentFromAddress = contractBuilder.getTransparentFromAddress();
    assertEquals("AXAXAXAX", transparentFromAddress.toStringUtf8());
    assertEquals(2, contractBuilder.getAllFields().size());
    assertEquals(42L, contractBuilder.getFromAmount());
    assertEquals(7, contractBuilder.getDescriptorForType().getFields().size());
    assertFalse(transparentFromAddress.isEmpty());
    ByteIterator iteratorResult = transparentFromAddress.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link ZenTransactionBuilder#setTransparentOutput(byte[], long)}.
   *
   * <p>Method under test: {@link ZenTransactionBuilder#setTransparentOutput(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZenTransactionBuilder.setTransparentOutput(byte[], long)"})
  public void testSetTransparentOutput() throws UnsupportedEncodingException {
    // Arrange
    ZenTransactionBuilder zenTransactionBuilder = new ZenTransactionBuilder();

    // Act
    zenTransactionBuilder.setTransparentOutput("AXAXAXAX".getBytes("UTF-8"), 42L);

    // Assert
    Builder contractBuilder = zenTransactionBuilder.getContractBuilder();
    ByteString transparentToAddress = contractBuilder.getTransparentToAddress();
    assertEquals("AXAXAXAX", transparentToAddress.toStringUtf8());
    assertEquals(2, contractBuilder.getAllFields().size());
    assertEquals(42L, contractBuilder.getToAmount());
    assertEquals(7, contractBuilder.getDescriptorForType().getFields().size());
    assertFalse(transparentToAddress.isEmpty());
    ByteIterator iteratorResult = transparentToAddress.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link ZenTransactionBuilder#ZenTransactionBuilder()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ZenTransactionBuilder#ZenTransactionBuilder()}
   *   <li>{@link ZenTransactionBuilder#getContractBuilder()}
   *   <li>{@link ZenTransactionBuilder#getFrom()}
   *   <li>{@link ZenTransactionBuilder#getTimeout()}
   *   <li>{@link ZenTransactionBuilder#getValueBalance()}
   *   <li>{@link ZenTransactionBuilder#getReceives()}
   *   <li>{@link ZenTransactionBuilder#getSpends()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "org.tron.core.capsule.TransactionCapsule ZenTransactionBuilder.build()",
    "org.tron.core.capsule.TransactionCapsule ZenTransactionBuilder.build(boolean)",
    "Builder ZenTransactionBuilder.getContractBuilder()",
    "java.lang.String ZenTransactionBuilder.getFrom()",
    "List ZenTransactionBuilder.getReceives()",
    "List ZenTransactionBuilder.getSpends()",
    "long ZenTransactionBuilder.getTimeout()",
    "long ZenTransactionBuilder.getValueBalance()",
    "void ZenTransactionBuilder.setFrom(java.lang.String)",
    "void ZenTransactionBuilder.setReceives(List)",
    "void ZenTransactionBuilder.setSpends(List)",
    "void ZenTransactionBuilder.setTimeout(long)"
  })
  public void testNewZenTransactionBuilder() {
    // Arrange and Act
    ZenTransactionBuilder actualZenTransactionBuilder = new ZenTransactionBuilder();

    // Assert
    Builder contractBuilder = actualZenTransactionBuilder.getContractBuilder();
    Descriptor descriptorForType = contractBuilder.getDescriptorForType();
    DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult2 = file.toProto();
    FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    FileOptions options = file.getOptions();
    FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    MessageOptions options2 = descriptorForType.getOptions();
    FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    FieldDescriptor getResult = fields.get(0);
    FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    FieldDescriptor getResult2 = fields.get(1);
    FieldDescriptorProto toProtoResult5 = getResult2.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    FieldDescriptor getResult3 = fields.get(5);
    FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    FieldDescriptor getResult4 = fields.get(6);
    FieldDescriptorProto toProtoResult7 = getResult4.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    ShieldedTransferContract defaultInstanceForType4 = contractBuilder.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    assertEquals("", contractBuilder.getInitializationErrorString());
    ByteString bindingSignature = contractBuilder.getBindingSignature();
    assertEquals("", bindingSignature.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult4.getTypeName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", options.getJavaOuterClassname());
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
    FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(11, messageTypes.size());
    Descriptor getResult5 = messageTypes.get(0);
    assertEquals("AuthenticationPath", getResult5.getName());
    Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    Descriptor getResult6 = messageTypes.get(1);
    assertEquals("MerklePath", getResult6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptor getResult7 = messageTypes.get(9);
    assertEquals("ReceiveDescription", getResult7.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ShieldedTransferContract", nameBytes.toStringUtf8());
    assertEquals("ShieldedTransferContract", toProtoResult.getName());
    assertEquals("ShieldedTransferContract", descriptorForType.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("core/contract/shield_contract.proto", nameBytes2.toStringUtf8());
    assertEquals("core/contract/shield_contract.proto", toProtoResult2.getName());
    assertEquals("core/contract/shield_contract.proto", file.getFullName());
    assertEquals("core/contract/shield_contract.proto", file.getName());
    assertEquals("fromAmount", getResult2.getJsonName());
    assertEquals("from_amount", toProtoResult5.getName());
    assertEquals("from_amount", getResult2.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos.contract", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos.contract", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult2.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol.AuthenticationPath", getResult5.getFullName());
    assertEquals("protocol.MerklePath", getResult6.getFullName());
    assertEquals("protocol.ReceiveDescription", getResult7.getFullName());
    assertEquals("protocol.ShieldedTransferContract", descriptorForType.getFullName());
    assertEquals("protocol.ShieldedTransferContract.from_amount", getResult2.getFullName());
    assertEquals("protocol.ShieldedTransferContract.to_amount", getResult4.getFullName());
    assertEquals(
        "protocol.ShieldedTransferContract.transparent_from_address", getResult.getFullName());
    assertEquals(
        "protocol.ShieldedTransferContract.transparent_to_address", getResult3.getFullName());
    assertEquals("toAmount", getResult4.getJsonName());
    assertEquals("to_amount", toProtoResult7.getName());
    assertEquals("to_amount", getResult4.getName());
    assertEquals("transparentFromAddress", getResult.getJsonName());
    assertEquals("transparentToAddress", getResult3.getJsonName());
    assertEquals("transparent_from_address", toProtoResult4.getName());
    assertEquals("transparent_from_address", getResult.getName());
    assertEquals("transparent_to_address", toProtoResult6.getName());
    assertEquals("transparent_to_address", getResult3.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(actualZenTransactionBuilder.getFrom());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
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
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = contractBuilder.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, defaultInstanceForType4.getReceiveDescriptionCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getSpendDescriptionCount());
    assertEquals(0, contractBuilder.getReceiveDescriptionCount());
    assertEquals(0, contractBuilder.getSpendDescriptionCount());
    assertEquals(0L, actualZenTransactionBuilder.getTimeout());
    assertEquals(0L, actualZenTransactionBuilder.getValueBalance());
    assertEquals(0L, defaultInstanceForType4.getFromAmount());
    assertEquals(0L, defaultInstanceForType4.getToAmount());
    assertEquals(0L, contractBuilder.getFromAmount());
    assertEquals(0L, contractBuilder.getToAmount());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult6.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(10, descriptorForType6.getIndex());
    assertEquals(10, descriptorForType.getIndex());
    assertEquals(11, toProtoResult2.getMessageTypeCount());
    assertEquals(11, descriptorForType2.getIndex());
    assertEquals(11, toProtoResult2.getMessageTypeList().size());
    assertEquals(1467, toProtoResult2.getSerializedSize());
    assertEquals(17, toProtoResult7.getSerializedSize());
    assertEquals(19, toProtoResult5.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult5.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(273, toProtoResult.getSerializedSize());
    assertEquals(30, toProtoResult6.getSerializedSize());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, getResult3.getIndex());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(6, toProtoResult6.getNumber());
    assertEquals(6, getResult4.getIndex());
    assertEquals(6, getResult3.getNumber());
    assertEquals(69, options.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, toProtoResult.getFieldCount());
    assertEquals(7, toProtoResult7.getNumber());
    assertEquals(7, getResult4.getNumber());
    assertEquals(7, toProtoResult.getFieldList().size());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(9, getResult7.getIndex());
    assertEquals(Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(
        RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN, features.getRepeatedFieldEncoding());
    assertEquals(Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(Type.TYPE_BYTES, toProtoResult4.getType());
    assertEquals(Type.TYPE_BYTES, toProtoResult6.getType());
    assertEquals(Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(CType.STRING, options3.getCtype());
    assertEquals(JSType.JS_NORMAL, options3.getJstype());
    assertEquals(OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(JavaType.BYTE_STRING, getResult.getJavaType());
    assertEquals(JavaType.BYTE_STRING, getResult3.getJavaType());
    assertEquals(JavaType.LONG, getResult2.getJavaType());
    assertEquals(JavaType.LONG, getResult4.getJavaType());
    assertEquals(FieldDescriptor.Type.BYTES, getResult.getType());
    assertEquals(FieldDescriptor.Type.BYTES, getResult3.getType());
    assertEquals(FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Syntax.PROTO2, file2.getSyntax());
    assertEquals(Syntax.PROTO3, file.getSyntax());
    assertEquals(FieldType.BYTES, getResult.getLiteType());
    assertEquals(FieldType.BYTES, getResult3.getLiteType());
    assertEquals(FieldType.INT64, getResult2.getLiteType());
    assertEquals(FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.BYTE_STRING, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.BYTE_STRING, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(goPackageBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult4.hasTypeName());
    assertFalse(toProtoResult5.hasTypeName());
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
    assertFalse(options.hasJavaOuterClassname());
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
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(bindingSignature.iterator().hasNext());
    assertTrue(bindingSignature.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
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
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteIterator iteratorResult5 = goPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType4.findInitializationErrors().isEmpty());
    assertTrue(contractBuilder.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualZenTransactionBuilder.getReceives().isEmpty());
    assertTrue(actualZenTransactionBuilder.getSpends().isEmpty());
    assertTrue(defaultInstanceForType4.getReceiveDescriptionList().isEmpty());
    assertTrue(contractBuilder.getReceiveDescriptionBuilderList().isEmpty());
    assertTrue(contractBuilder.getReceiveDescriptionList().isEmpty());
    assertTrue(contractBuilder.getReceiveDescriptionOrBuilderList().isEmpty());
    assertTrue(contractBuilder.getSpendDescriptionBuilderList().isEmpty());
    assertTrue(contractBuilder.getSpendDescriptionList().isEmpty());
    assertTrue(contractBuilder.getSpendDescriptionOrBuilderList().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType4.getAllFields().isEmpty());
    assertTrue(contractBuilder.getAllFields().isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(contractBuilder.isInitialized());
    assertEquals(Integer.SIZE, toProtoResult4.getSerializedSize());
    assertEquals('S', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult5.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertSame(toProtoResult.getReservedNameList(), defaultInstanceForType.getReservedNameList());
    assertSame(toProtoResult.getReservedNameList(), toProtoResult3.getReservedNameList());
    assertSame(toProtoResult.getReservedNameList(), defaultInstanceForType2.getDependencyList());
    assertSame(toProtoResult.getReservedNameList(), toProtoResult2.getDependencyList());
  }
}
