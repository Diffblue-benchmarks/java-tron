package org.tron.core.zen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
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
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.Syntax;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat.FieldType;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.api.GrpcAPI;
import org.tron.api.GrpcAPI.ShieldedTRC20Parameters;
import org.tron.api.GrpcAPI.ShieldedTRC20Parameters.Builder;
import org.tron.core.exception.ZksnarkException;
import org.tron.core.zen.ShieldedTRC20ParametersBuilder.ShieldedTRC20ParametersType;

public class ShieldedTRC20ParametersBuilderDiffblueTest {
  /**
   * Test {@link ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder()}.
   *
   * <p>Method under test: {@link ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ShieldedTRC20ParametersBuilder.<init>()"})
  public void testNewShieldedTRC20ParametersBuilder2() {
    // Arrange and Act
    ShieldedTRC20ParametersBuilder actualShieldedTRC20ParametersBuilder =
        new ShieldedTRC20ParametersBuilder();

    // Assert
    Builder builder = actualShieldedTRC20ParametersBuilder.getBuilder();
    assertEquals("", builder.getInitializationErrorString());
    assertEquals("", builder.getParameterType());
    assertEquals("", builder.getTriggerContractInput());
    assertNull(actualShieldedTRC20ParametersBuilder.getShieldedTRC20ParametersType());
    assertEquals(0, builder.getReceiveDescriptionCount());
    assertEquals(0, builder.getSpendDescriptionCount());
    assertEquals(0L, actualShieldedTRC20ParametersBuilder.getValueBalance());
    assertTrue(builder.findInitializationErrors().isEmpty());
    assertTrue(builder.getReceiveDescriptionBuilderList().isEmpty());
    assertTrue(builder.getReceiveDescriptionList().isEmpty());
    assertTrue(builder.getReceiveDescriptionOrBuilderList().isEmpty());
    assertTrue(builder.getSpendDescriptionBuilderList().isEmpty());
    assertTrue(builder.getSpendDescriptionList().isEmpty());
    assertTrue(builder.getSpendDescriptionOrBuilderList().isEmpty());
    assertTrue(builder.getAllFields().isEmpty());
    assertTrue(builder.isInitialized());
  }

  /**
   * Test {@link ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder(String)}.
   *
   * <p>Method under test: {@link
   * ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ShieldedTRC20ParametersBuilder.<init>(String)"})
  public void testNewShieldedTRC20ParametersBuilder3() throws ZksnarkException {
    // Arrange and Act
    ShieldedTRC20ParametersBuilder actualShieldedTRC20ParametersBuilder =
        new ShieldedTRC20ParametersBuilder("mint");

    // Assert
    assertEquals(
        ShieldedTRC20ParametersType.MINT,
        actualShieldedTRC20ParametersBuilder.getShieldedTRC20ParametersType());
    Builder builder = actualShieldedTRC20ParametersBuilder.getBuilder();
    UnknownFieldSet unknownFields = builder.getUnknownFields();
    ShieldedTRC20Parameters defaultInstanceForType = builder.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    ShieldedTRC20Parameters actualDefaultInstanceForType2 =
        defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType, actualDefaultInstanceForType2);
  }

  /**
   * Test {@link ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder(String)}.
   *
   * <p>Method under test: {@link
   * ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ShieldedTRC20ParametersBuilder.<init>(String)"})
  public void testNewShieldedTRC20ParametersBuilder4() throws ZksnarkException {
    // Arrange and Act
    ShieldedTRC20ParametersBuilder actualShieldedTRC20ParametersBuilder =
        new ShieldedTRC20ParametersBuilder("transfer");

    // Assert
    assertEquals(
        ShieldedTRC20ParametersType.TRANSFER,
        actualShieldedTRC20ParametersBuilder.getShieldedTRC20ParametersType());
    Builder builder = actualShieldedTRC20ParametersBuilder.getBuilder();
    UnknownFieldSet unknownFields = builder.getUnknownFields();
    ShieldedTRC20Parameters defaultInstanceForType = builder.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    ShieldedTRC20Parameters actualDefaultInstanceForType2 =
        defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType, actualDefaultInstanceForType2);
  }

  /**
   * Test {@link ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder(String)}.
   *
   * <p>Method under test: {@link
   * ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ShieldedTRC20ParametersBuilder.<init>(String)"})
  public void testNewShieldedTRC20ParametersBuilder5() throws ZksnarkException {
    // Arrange and Act
    ShieldedTRC20ParametersBuilder actualShieldedTRC20ParametersBuilder =
        new ShieldedTRC20ParametersBuilder("burn");

    // Assert
    assertEquals(
        ShieldedTRC20ParametersType.BURN,
        actualShieldedTRC20ParametersBuilder.getShieldedTRC20ParametersType());
    Builder builder = actualShieldedTRC20ParametersBuilder.getBuilder();
    UnknownFieldSet unknownFields = builder.getUnknownFields();
    ShieldedTRC20Parameters defaultInstanceForType = builder.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    ShieldedTRC20Parameters actualDefaultInstanceForType2 =
        defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType, actualDefaultInstanceForType2);
  }

  /**
   * Test {@link ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ShieldedTRC20ParametersBuilder.<init>(String)"})
  public void testNewShieldedTRC20ParametersBuilder_whenType_thenThrowZksnarkException()
      throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> new ShieldedTRC20ParametersBuilder("Type"));
  }

  /**
   * Test {@link ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder()}
   *   <li>{@link ShieldedTRC20ParametersBuilder#getBuilder()}
   *   <li>{@link ShieldedTRC20ParametersBuilder#getShieldedTRC20ParametersType()}
   *   <li>{@link ShieldedTRC20ParametersBuilder#getValueBalance()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ShieldedTRC20Parameters ShieldedTRC20ParametersBuilder.build(boolean)",
    "Builder ShieldedTRC20ParametersBuilder.getBuilder()",
    "ShieldedTRC20ParametersType ShieldedTRC20ParametersBuilder.getShieldedTRC20ParametersType()",
    "long ShieldedTRC20ParametersBuilder.getValueBalance()",
    "void ShieldedTRC20ParametersBuilder.setBurnCiphertext(byte[])",
    "void ShieldedTRC20ParametersBuilder.setReceives(List)",
    "void ShieldedTRC20ParametersBuilder.setShieldedTRC20Address(byte[])",
    "void ShieldedTRC20ParametersBuilder.setShieldedTRC20ParametersType(ShieldedTRC20ParametersType)",
    "void ShieldedTRC20ParametersBuilder.setSpends(List)",
    "void ShieldedTRC20ParametersBuilder.setTransparentFromAmount(BigInteger)",
    "void ShieldedTRC20ParametersBuilder.setTransparentToAddress(byte[])",
    "void ShieldedTRC20ParametersBuilder.setTransparentToAmount(BigInteger)"
  })
  public void testNewShieldedTRC20ParametersBuilder() {
    // Arrange and Act
    ShieldedTRC20ParametersBuilder actualShieldedTRC20ParametersBuilder =
        new ShieldedTRC20ParametersBuilder();

    // Assert
    Builder builder = actualShieldedTRC20ParametersBuilder.getBuilder();
    Descriptor descriptorForType = builder.getDescriptorForType();
    DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult2 = file.toProto();
    FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    FileOptions options = file.getOptions();
    FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    MessageOptions options2 = descriptorForType.getOptions();
    FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    FieldDescriptor getResult = fields.get(0);
    FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    FieldDescriptor getResult2 = fields.get(1);
    FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    FieldDescriptor getResult3 = fields.get(4);
    FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    FieldDescriptor getResult4 = fields.get(5);
    FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    ShieldedTRC20Parameters defaultInstanceForType4 = builder.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    assertEquals("", builder.getInitializationErrorString());
    ByteString bindingSignature = builder.getBindingSignature();
    assertEquals("", bindingSignature.toStringUtf8());
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
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
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
    List<FileDescriptor> dependencies = file.getDependencies();
    assertEquals(12, dependencies.size());
    FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    FileDescriptor getResult6 = dependencies.get(1);
    assertEquals("", getResult6.getEditionName());
    FileDescriptor getResult7 = dependencies.get(10);
    assertEquals("", getResult7.getEditionName());
    FileDescriptor getResult8 = dependencies.get(11);
    assertEquals("", getResult8.getEditionName());
    assertEquals("", defaultInstanceForType4.getParameterType());
    assertEquals("", defaultInstanceForType4.getTriggerContractInput());
    assertEquals("", builder.getParameterType());
    assertEquals("", builder.getTriggerContractInput());
    assertEquals("", getResult3.getDefaultValue());
    assertEquals("", getResult4.getDefaultValue());
    assertEquals(".protocol.ReceiveDescription", toProtoResult4.getTypeName());
    assertEquals(".protocol.SpendDescription", toProtoResult3.getTypeName());
    List<Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(73, messageTypes.size());
    Descriptor getResult9 = messageTypes.get(1);
    assertEquals("BlockReference", getResult9.getName());
    Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType2.getName());
    Descriptor descriptorForType3 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType3.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("GrpcAPI", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("GrpcAPI", options.getJavaOuterClassname());
    Descriptor descriptorForType4 = options2.getDescriptorForType();
    assertEquals("MessageOptions", descriptorForType4.getName());
    List<ServiceDescriptor> services = file.getServices();
    assertEquals(6, services.size());
    ServiceDescriptor getResult10 = services.get(4);
    assertEquals("Monitor", getResult10.getName());
    ServiceDescriptor getResult11 = services.get(5);
    assertEquals("Network", getResult11.getName());
    Descriptor getResult12 = messageTypes.get(71);
    assertEquals("NullifierResult", getResult12.getName());
    Descriptor messageType = getResult2.getMessageType();
    assertEquals("ReceiveDescription", messageType.getName());
    Descriptor getResult13 = messageTypes.get(0);
    assertEquals("Return", getResult13.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ShieldedTRC20Parameters", nameBytes.toStringUtf8());
    assertEquals("ShieldedTRC20Parameters", toProtoResult.getName());
    assertEquals("ShieldedTRC20Parameters", descriptorForType.getName());
    Descriptor getResult14 = messageTypes.get(72);
    assertEquals("ShieldedTRC20TriggerContractParameters", getResult14.getName());
    Descriptor messageType2 = getResult.getMessageType();
    assertEquals("SpendDescription", messageType2.getName());
    ServiceDescriptor getResult15 = services.get(0);
    assertEquals("Wallet", getResult15.getName());
    ServiceDescriptor getResult16 = services.get(1);
    assertEquals("WalletSolidity", getResult16.getName());
    assertEquals("api/api.proto", toProtoResult2.getName());
    assertEquals("api/api.proto", file.getFullName());
    assertEquals("api/api.proto", file.getName());
    assertEquals("core/Tron.proto", getResult5.getFullName());
    assertEquals("core/Tron.proto", getResult5.getName());
    assertEquals("core/contract/shield_contract.proto", getResult8.getFullName());
    assertEquals("core/contract/shield_contract.proto", getResult8.getName());
    assertEquals("core/contract/smart_contract.proto", getResult7.getFullName());
    assertEquals("core/contract/smart_contract.proto", getResult7.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/api", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/api", options.getGoPackage());
    assertEquals("google.api", getResult6.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType2.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType3.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType4.getFullName());
    assertEquals("google/api/annotations.proto", getResult6.getFullName());
    assertEquals("google/api/annotations.proto", getResult6.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.api", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.api", options.getJavaPackage());
    assertEquals("parameterType", getResult4.getJsonName());
    assertEquals("parameter_type", toProtoResult6.getName());
    assertEquals("parameter_type", getResult4.getName());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("protocol", toProtoResult2.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol", getResult5.getPackage());
    assertEquals("protocol", getResult7.getPackage());
    assertEquals("protocol", getResult8.getPackage());
    assertEquals("protocol.BlockReference", getResult9.getFullName());
    assertEquals("protocol.Monitor", getResult10.getFullName());
    assertEquals("protocol.Network", getResult11.getFullName());
    assertEquals("protocol.NullifierResult", getResult12.getFullName());
    assertEquals("protocol.ReceiveDescription", messageType.getFullName());
    assertEquals("protocol.Return", getResult13.getFullName());
    assertEquals("protocol.ShieldedTRC20Parameters", descriptorForType.getFullName());
    assertEquals("protocol.ShieldedTRC20Parameters.parameter_type", getResult4.getFullName());
    assertEquals("protocol.ShieldedTRC20Parameters.receive_description", getResult2.getFullName());
    assertEquals("protocol.ShieldedTRC20Parameters.spend_description", getResult.getFullName());
    assertEquals(
        "protocol.ShieldedTRC20Parameters.trigger_contract_input", getResult3.getFullName());
    assertEquals("protocol.ShieldedTRC20TriggerContractParameters", getResult14.getFullName());
    assertEquals("protocol.SpendDescription", messageType2.getFullName());
    assertEquals("protocol.Wallet", getResult15.getFullName());
    assertEquals("protocol.WalletSolidity", getResult16.getFullName());
    assertEquals("receiveDescription", getResult2.getJsonName());
    assertEquals("receive_description", toProtoResult4.getName());
    assertEquals("receive_description", getResult2.getName());
    assertEquals("spendDescription", getResult.getJsonName());
    assertEquals("spend_description", toProtoResult3.getName());
    assertEquals("spend_description", getResult.getName());
    assertEquals("triggerContractInput", getResult3.getJsonName());
    assertEquals("trigger_contract_input", toProtoResult5.getName());
    assertEquals("trigger_contract_input", getResult3.getName());
    assertNull(messageType2.getContainingType());
    assertNull(messageType.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(getResult13.getContainingType());
    assertNull(getResult9.getContainingType());
    assertNull(getResult12.getContainingType());
    assertNull(getResult14.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(actualShieldedTRC20ParametersBuilder.getShieldedTRC20ParametersType());
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
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, getResult13.getIndex());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult15.getIndex());
    UnknownFieldSet unknownFields = builder.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, defaultInstanceForType4.getReceiveDescriptionCount());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getSpendDescriptionCount());
    assertEquals(0, builder.getReceiveDescriptionCount());
    assertEquals(0, builder.getSpendDescriptionCount());
    assertEquals(0L, actualShieldedTRC20ParametersBuilder.getValueBalance());
    assertEquals(1, toProtoResult3.getNumber());
    assertEquals(1, getResult9.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(1, getResult16.getIndex());
    assertEquals(10, descriptorForType3.getIndex());
    assertEquals(11, descriptorForType4.getIndex());
    assertEquals(12, toProtoResult2.getDependencyCount());
    assertEquals(2, toProtoResult4.getNumber());
    assertEquals(2, descriptorForType2.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(22, toProtoResult6.getSerializedSize());
    assertEquals(244, toProtoResult.getSerializedSize());
    assertEquals(29951, toProtoResult2.getSerializedSize());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(30, toProtoResult5.getSerializedSize());
    assertEquals(4, getResult3.getIndex());
    assertEquals(4, getResult10.getIndex());
    assertEquals(5, toProtoResult5.getNumber());
    assertEquals(5, getResult4.getIndex());
    assertEquals(5, getResult3.getNumber());
    assertEquals(5, getResult11.getIndex());
    assertEquals(53, toProtoResult3.getSerializedSize());
    assertEquals(57, toProtoResult4.getSerializedSize());
    assertEquals(6, toProtoResult.getFieldCount());
    assertEquals(6, toProtoResult6.getNumber());
    assertEquals(6, toProtoResult2.getServiceCount());
    assertEquals(6, getResult4.getNumber());
    assertEquals(6, toProtoResult.getFieldList().size());
    assertEquals(65, options.getSerializedSize());
    assertEquals(66, descriptorForType.getIndex());
    assertEquals(7, toProtoResult2.getAllFields().size());
    assertEquals(71, getResult12.getIndex());
    assertEquals(72, getResult14.getIndex());
    assertEquals(73, toProtoResult2.getMessageTypeCount());
    assertEquals(8, messageType2.getIndex());
    assertEquals(9, messageType.getIndex());
    assertEquals(Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, getResult6.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, getResult7.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, getResult8.getEdition());
    assertEquals(EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(
        RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN, features.getRepeatedFieldEncoding());
    assertEquals(Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(Label.LABEL_REPEATED, toProtoResult3.getLabel());
    assertEquals(Label.LABEL_REPEATED, toProtoResult4.getLabel());
    assertEquals(Type.TYPE_MESSAGE, toProtoResult3.getType());
    assertEquals(Type.TYPE_MESSAGE, toProtoResult4.getType());
    assertEquals(Type.TYPE_STRING, toProtoResult5.getType());
    assertEquals(Type.TYPE_STRING, toProtoResult6.getType());
    assertEquals(CType.STRING, options3.getCtype());
    assertEquals(JSType.JS_NORMAL, options3.getJstype());
    assertEquals(OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(JavaType.MESSAGE, getResult.getJavaType());
    assertEquals(JavaType.MESSAGE, getResult2.getJavaType());
    assertEquals(JavaType.STRING, getResult3.getJavaType());
    assertEquals(JavaType.STRING, getResult4.getJavaType());
    assertEquals(FieldDescriptor.Type.MESSAGE, getResult.getType());
    assertEquals(FieldDescriptor.Type.MESSAGE, getResult2.getType());
    assertEquals(FieldDescriptor.Type.STRING, getResult3.getType());
    assertEquals(FieldDescriptor.Type.STRING, getResult4.getType());
    assertEquals(Syntax.PROTO3, file.getSyntax());
    assertEquals(Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(Syntax.PROTO3, getResult6.getSyntax());
    assertEquals(Syntax.PROTO3, getResult7.getSyntax());
    assertEquals(Syntax.PROTO3, getResult8.getSyntax());
    assertEquals(FieldType.MESSAGE, getResult.getLiteType());
    assertEquals(FieldType.MESSAGE, getResult2.getLiteType());
    assertEquals(FieldType.STRING, getResult3.getLiteType());
    assertEquals(FieldType.STRING, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.MESSAGE, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.MESSAGE, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.STRING, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.STRING, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
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
    assertFalse(toProtoResult5.hasTypeName());
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
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
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
    assertFalse(messageType2.isExtendable());
    assertFalse(messageType.isExtendable());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(getResult13.isExtendable());
    assertFalse(getResult9.isExtendable());
    assertFalse(getResult12.isExtendable());
    assertFalse(getResult14.isExtendable());
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
    assertFalse(getResult.isOptional());
    assertFalse(getResult2.isOptional());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(bindingSignature.iterator().hasNext());
    assertTrue(bindingSignature.isEmpty());
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
    assertTrue(toProtoResult3.hasTypeName());
    assertTrue(toProtoResult4.hasTypeName());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasGoPackage());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType3.isExtendable());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(getResult.isRepeated());
    assertTrue(getResult2.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteIterator iteratorResult2 = goPackageBytes.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteIterator iteratorResult3 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteIterator iteratorResult4 = javaPackageBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType4.findInitializationErrors().isEmpty());
    assertTrue(builder.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(defaultInstanceForType4.getReceiveDescriptionList().isEmpty());
    assertTrue(builder.getReceiveDescriptionBuilderList().isEmpty());
    assertTrue(builder.getReceiveDescriptionList().isEmpty());
    assertTrue(builder.getReceiveDescriptionOrBuilderList().isEmpty());
    assertTrue(builder.getSpendDescriptionBuilderList().isEmpty());
    assertTrue(builder.getSpendDescriptionList().isEmpty());
    assertTrue(builder.getSpendDescriptionOrBuilderList().isEmpty());
    assertTrue(defaultInstanceForType4.getAllFields().isEmpty());
    assertTrue(builder.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(builder.isInitialized());
    assertEquals('G', iteratorResult3.next().byteValue());
    assertEquals('S', iteratorResult.next().byteValue());
    assertEquals('g', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult4.next().byteValue());
    assertSame(toProtoResult.getReservedNameList(), defaultInstanceForType.getReservedNameList());
    assertSame(toProtoResult.getReservedNameList(), defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test {@link ShieldedTRC20ParametersBuilder#getTriggerContractInput(ShieldedTRC20Parameters,
   * List, BigInteger, boolean, byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ShieldedTRC20ParametersBuilder#getTriggerContractInput(ShieldedTRC20Parameters, List,
   * BigInteger, boolean, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "String ShieldedTRC20ParametersBuilder.getTriggerContractInput(ShieldedTRC20Parameters, List, BigInteger, boolean, byte[])"
  })
  public void testGetTriggerContractInput_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    ShieldedTRC20ParametersBuilder shieldedTRC20ParametersBuilder =
        new ShieldedTRC20ParametersBuilder();
    shieldedTRC20ParametersBuilder.setShieldedTRC20ParametersType(
        ShieldedTRC20ParametersType.TRANSFER);
    ShieldedTRC20Parameters shieldedTRC20Parameters = ShieldedTRC20Parameters.getDefaultInstance();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            shieldedTRC20ParametersBuilder.getTriggerContractInput(
                shieldedTRC20Parameters,
                new ArrayList<>(),
                BigInteger.valueOf(1L),
                true,
                "AXAXAXAX".getBytes("UTF-8")));
  }
}
