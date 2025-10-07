package org.tron.core.net.message.adv;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.Syntax;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat.FieldType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transactions;

public class TransactionsMessageDiffblueTest {
  /**
   * Test {@link TransactionsMessage#TransactionsMessage(List)}.
   *
   * <ul>
   *   <li>Then return Transactions SerializedSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link TransactionsMessage#TransactionsMessage(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionsMessage.<init>(List)"})
  public void testNewTransactionsMessage_thenReturnTransactionsSerializedSizeIsZero() {
    // Arrange and Act
    TransactionsMessage actualTransactionsMessage = new TransactionsMessage(new ArrayList<>());

    // Assert
    ByteBuf sendData = actualTransactionsMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Transactions transactions = actualTransactionsMessage.getTransactions();
    assertEquals(0, transactions.getSerializedSize());
    assertEquals(0, transactions.getTransactionsCount());
    assertEquals(1, sendData.capacity());
    assertEquals(1, sendData.maxCapacity());
    assertEquals(1, sendData.writerIndex());
    assertTrue(transactions.getTransactionsList().isEmpty());
    assertTrue(transactions.getAllFields().isEmpty());
    Transactions actualDefaultInstanceForType = transactions.getDefaultInstanceForType();
    assertEquals(transactions, actualDefaultInstanceForType);
    assertArrayEquals(new byte[] {}, actualTransactionsMessage.getData());
    assertArrayEquals(new byte[] {3}, actualTransactionsMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        actualTransactionsMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link TransactionsMessage#TransactionsMessage(List)}.
   *
   * <ul>
   *   <li>Then return Transactions TransactionsList size is one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionsMessage#TransactionsMessage(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionsMessage.<init>(List)"})
  public void testNewTransactionsMessage_thenReturnTransactionsTransactionsListSizeIsOne() {
    // Arrange
    ArrayList<Transaction> trxs = new ArrayList<>();
    trxs.add(Transaction.getDefaultInstance());

    // Act
    TransactionsMessage actualTransactionsMessage = new TransactionsMessage(trxs);

    // Assert
    ByteBuf sendData = actualTransactionsMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Transactions transactions = actualTransactionsMessage.getTransactions();
    assertEquals(1, transactions.getTransactionsList().size());
    assertEquals(1, transactions.getTransactionsCount());
    assertEquals(2, transactions.getSerializedSize());
    assertEquals(3, sendData.capacity());
    assertEquals(3, sendData.maxCapacity());
    assertEquals(3, sendData.writerIndex());
    assertArrayEquals(new byte[] {'\n', 0}, actualTransactionsMessage.getData());
    assertArrayEquals(new byte[] {3, '\n', 0}, actualTransactionsMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          16, '+', 'Q', -71, 'v', 'Z', 'V', -93, -24, -103, -9, -49, 14, -29, -114, 'R', 'Q', -7,
          -59, 3, -77, 'W', -77, '0', -92, -111, -125, -21, '{', 21, 'V', 4
        },
        actualTransactionsMessage.getMessageId().getBytes());
  }

  /**
   * Test {@link TransactionsMessage#TransactionsMessage(List)}.
   *
   * <ul>
   *   <li>Then return Transactions TransactionsList size is two.
   * </ul>
   *
   * <p>Method under test: {@link TransactionsMessage#TransactionsMessage(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransactionsMessage.<init>(List)"})
  public void testNewTransactionsMessage_thenReturnTransactionsTransactionsListSizeIsTwo() {
    // Arrange
    ArrayList<Transaction> trxs = new ArrayList<>();
    trxs.add(Transaction.getDefaultInstance());
    trxs.add(Transaction.getDefaultInstance());

    // Act
    TransactionsMessage actualTransactionsMessage = new TransactionsMessage(trxs);

    // Assert
    ByteBuf sendData = actualTransactionsMessage.getSendData();
    assertTrue(sendData instanceof UnpooledHeapByteBuf);
    Transactions transactions = actualTransactionsMessage.getTransactions();
    assertEquals(2, transactions.getTransactionsList().size());
    assertEquals(2, transactions.getTransactionsCount());
    assertEquals(4, transactions.getSerializedSize());
    assertEquals(5, sendData.capacity());
    assertEquals(5, sendData.maxCapacity());
    assertEquals(5, sendData.writerIndex());
    assertArrayEquals(new byte[] {'\n', 0, '\n', 0}, actualTransactionsMessage.getData());
    assertArrayEquals(new byte[] {3, '\n', 0, '\n', 0}, actualTransactionsMessage.getSendBytes());
    assertArrayEquals(
        new byte[] {
          '\r', -103, 21, -82, 21, 2, -112, -79, 0, -32, 'C', -26, '%', -116, -46, -124, '1', -92,
          -108, '\r', -14, -79, 'U', 'y', -110, 0, -94, 'E', '\t', 'Y', -40, -19
        },
        actualTransactionsMessage.getMessageId().getBytes());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TransactionsMessage#toString()}
   *   <li>{@link TransactionsMessage#getAnswerMessage()}
   *   <li>{@link TransactionsMessage#getTransactions()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class TransactionsMessage.getAnswerMessage()",
    "Transactions TransactionsMessage.getTransactions()",
    "String TransactionsMessage.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    TransactionsMessage transactionsMessage = new TransactionsMessage(new ArrayList<>());

    // Act
    String actualToStringResult = transactionsMessage.toString();
    Class<?> actualAnswerMessage = transactionsMessage.getAnswerMessage();
    Transactions actualTransactions = transactionsMessage.getTransactions();

    // Assert
    Descriptor descriptorForType = actualTransactions.getDescriptorForType();
    DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    FieldDescriptor getResult = fields.get(0);
    FieldDescriptorProto toProtoResult2 = getResult.toProto();
    FieldDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult3 = file.toProto();
    FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    FileOptions options = file.getOptions();
    FileOptions defaultInstanceForType4 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    MessageOptions options2 = descriptorForType.getOptions();
    FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptor messageType = getResult.getMessageType();
    DescriptorProto toProtoResult4 = messageType.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProto toProtoResult5 = descriptorForType2.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProto toProtoResult6 = descriptorForType3.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", actualTransactions.getInitializationErrorString());
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
    FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    FileDescriptor getResult2 = dependencies.get(0);
    assertEquals("", getResult2.getEditionName());
    FileDescriptor getResult3 = dependencies.get(1);
    assertEquals("", getResult3.getEditionName());
    FileDescriptor getResult4 = dependencies.get(2);
    assertEquals("", getResult4.getEditionName());
    assertEquals(".protocol.Transaction", toProtoResult2.getTypeName());
    List<Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    Descriptor getResult5 = messageTypes.get(0);
    assertEquals("AccountId", getResult5.getName());
    List<EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(2, enumTypes.size());
    EnumDescriptor getResult6 = enumTypes.get(0);
    assertEquals("AccountType", getResult6.getName());
    assertEquals("DescriptorProto", toProtoResult6.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptor descriptorForType5 = options3.getDescriptorForType();
    assertEquals("FieldOptions", descriptorForType5.getName());
    Descriptor descriptorForType6 = toProtoResult3.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType6.getName());
    Descriptor descriptorForType7 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType7.getName());
    assertEquals("MessageOptions", toProtoResult5.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptor getResult7 = messageTypes.get(43);
    assertEquals("PBFTCommitResult", getResult7.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("Protocol", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("Protocol", options.getJavaOuterClassname());
    EnumDescriptor getResult8 = enumTypes.get(1);
    assertEquals("ReasonCode", getResult8.getName());
    Descriptor getResult9 = messageTypes.get(44);
    assertEquals("SRL", getResult9.getName());
    assertEquals("Transaction", toProtoResult4.getName());
    assertEquals("Transaction", messageType.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("Transactions", nameBytes.toStringUtf8());
    assertEquals("Transactions", toProtoResult.getName());
    assertEquals("Transactions", descriptorForType.getName());
    Descriptor getResult10 = messageTypes.get(1);
    assertEquals("Vote", getResult10.getName());
    assertEquals("core/Discover.proto", getResult3.getFullName());
    assertEquals("core/Discover.proto", getResult3.getName());
    ByteString nameBytes2 = toProtoResult3.getNameBytes();
    assertEquals("core/Tron.proto", nameBytes2.toStringUtf8());
    assertEquals("core/Tron.proto", toProtoResult3.getName());
    assertEquals("core/Tron.proto", file.getFullName());
    assertEquals("core/Tron.proto", file.getName());
    assertEquals("core/contract/common.proto", getResult4.getFullName());
    assertEquals("core/contract/common.proto", getResult4.getName());
    ByteString goPackageBytes = options.getGoPackageBytes();
    assertEquals("github.com/tronprotocol/grpc-gateway/core", goPackageBytes.toStringUtf8());
    assertEquals("github.com/tronprotocol/grpc-gateway/core", options.getGoPackage());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf", getResult2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FieldOptions", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType6.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType7.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/any.proto", getResult2.getFullName());
    assertEquals("google/protobuf/any.proto", getResult2.getName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.tron.protos", javaPackageBytes.toStringUtf8());
    assertEquals("org.tron.protos", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult3.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult3.getSyntax());
    ByteString packageBytes = toProtoResult3.getPackageBytes();
    assertEquals("protocol", packageBytes.toStringUtf8());
    assertEquals("protocol", toProtoResult3.getPackage());
    assertEquals("protocol", file.getPackage());
    assertEquals("protocol", getResult3.getPackage());
    assertEquals("protocol", getResult4.getPackage());
    assertEquals("protocol.AccountId", getResult5.getFullName());
    assertEquals("protocol.AccountType", getResult6.getFullName());
    assertEquals("protocol.PBFTCommitResult", getResult7.getFullName());
    assertEquals("protocol.ReasonCode", getResult8.getFullName());
    assertEquals("protocol.SRL", getResult9.getFullName());
    assertEquals("protocol.Transaction", messageType.getFullName());
    assertEquals("protocol.Transactions", descriptorForType.getFullName());
    assertEquals("protocol.Transactions.transactions", getResult.getFullName());
    assertEquals("protocol.Vote", getResult10.getFullName());
    assertEquals("transactions", toProtoResult2.getName());
    assertEquals("transactions", getResult.getJsonName());
    assertEquals("transactions", getResult.getName());
    assertEquals("type: TRXS\ntrx size: 0", actualToStringResult);
    assertNull(messageType.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult10.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult9.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult8.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(actualAnswerMessage);
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
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult6.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult5.getNestedTypeCount());
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
    assertEquals(0, toProtoResult4.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
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
    assertEquals(0, defaultInstanceForType3.getEnumTypeCount());
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
    assertEquals(0, getResult6.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualTransactions.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualTransactions.getSerializedSize());
    assertEquals(0, actualTransactions.getTransactionsCount());
    assertEquals(1, toProtoResult5.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getFieldCount());
    assertEquals(1, toProtoResult2.getNumber());
    assertEquals(1, descriptorForType6.getIndex());
    assertEquals(1, getResult10.getIndex());
    assertEquals(1, getResult8.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(1, toProtoResult.getFieldList().size());
    assertEquals(10, toProtoResult6.getFieldCount());
    assertEquals(10, descriptorForType7.getIndex());
    assertEquals(10, descriptorForType3.getFields().size());
    assertEquals(11, descriptorForType2.getIndex());
    assertEquals(12, descriptorForType5.getIndex());
    assertEquals(17305, toProtoResult3.getSerializedSize());
    assertEquals(19, descriptorForType4.getIndex());
    assertEquals(2, toProtoResult6.getNestedTypeCount());
    assertEquals(2, toProtoResult3.getEnumTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, toProtoResult3.getEnumTypeList().size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(25, messageType.getIndex());
    assertEquals(2708, toProtoResult4.getSerializedSize());
    assertEquals(28, descriptorForType.getIndex());
    assertEquals(3, toProtoResult4.getFieldCount());
    assertEquals(3, toProtoResult4.getNestedTypeCount());
    assertEquals(3, toProtoResult3.getDependencyCount());
    assertEquals(3, messageType.getFields().size());
    assertEquals(3, messageType.getNestedTypes().size());
    assertEquals(3, options.getAllFields().size());
    assertEquals(3, options.getAllFieldsRaw().size());
    assertEquals(43, toProtoResult2.getSerializedSize());
    assertEquals(43, getResult7.getIndex());
    assertEquals(44, getResult9.getIndex());
    assertEquals(45, toProtoResult3.getMessageTypeCount());
    assertEquals(45, toProtoResult3.getMessageTypeList().size());
    assertEquals(5, toProtoResult5.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult5.getSerializedSize());
    assertEquals(59, toProtoResult.getSerializedSize());
    assertEquals(7, toProtoResult5.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(7, toProtoResult3.getAllFields().size());
    assertEquals(70, options.getSerializedSize());
    assertEquals(825, toProtoResult6.getSerializedSize());
    assertEquals(Edition.EDITION_UNKNOWN, defaultInstanceForType3.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, toProtoResult3.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, getResult2.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, getResult3.getEdition());
    assertEquals(Edition.EDITION_UNKNOWN, getResult4.getEdition());
    assertEquals(EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(
        RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN, features.getRepeatedFieldEncoding());
    assertEquals(Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(Label.LABEL_OPTIONAL, defaultInstanceForType2.getLabel());
    assertEquals(Label.LABEL_REPEATED, toProtoResult2.getLabel());
    assertEquals(Type.TYPE_DOUBLE, defaultInstanceForType2.getType());
    assertEquals(Type.TYPE_MESSAGE, toProtoResult2.getType());
    assertEquals(CType.STRING, options3.getCtype());
    assertEquals(JSType.JS_NORMAL, options3.getJstype());
    assertEquals(OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(OptimizeMode.SPEED, defaultInstanceForType4.getOptimizeFor());
    assertEquals(OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(JavaType.MESSAGE, getResult.getJavaType());
    assertEquals(FieldDescriptor.Type.MESSAGE, getResult.getType());
    assertEquals(Syntax.PROTO2, file2.getSyntax());
    assertEquals(Syntax.PROTO3, file.getSyntax());
    assertEquals(Syntax.PROTO3, getResult2.getSyntax());
    assertEquals(Syntax.PROTO3, getResult3.getSyntax());
    assertEquals(Syntax.PROTO3, getResult4.getSyntax());
    assertEquals(FieldType.MESSAGE, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.MESSAGE, getResult.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
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
    assertFalse(toProtoResult2.hasProto3Optional());
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
    assertFalse(messageType.isExtendable());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType6.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult10.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult9.isExtendable());
    assertFalse(getResult6.isClosed());
    assertFalse(getResult8.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isOptional());
    assertFalse(getResult.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult.isRequired());
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
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasNumber());
    assertTrue(toProtoResult2.hasType());
    assertTrue(toProtoResult2.hasTypeName());
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
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType5.isExtendable());
    assertTrue(descriptorForType7.isExtendable());
    assertTrue(getResult.isRepeated());
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
    ByteIterator iteratorResult6 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    ByteIterator iteratorResult7 = javaPackageBytes.iterator();
    assertTrue(iteratorResult7.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options3.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    assertTrue(actualTransactions.findInitializationErrors().isEmpty());
    assertTrue(options3.getTargetsList().isEmpty());
    assertTrue(toProtoResult3.getPublicDependencyList().isEmpty());
    assertTrue(messageType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(messageType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(messageType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(messageType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualTransactions.getTransactionsList().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(actualTransactions.getAllFields().isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options3.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(options3.getAllFieldsRaw().isEmpty());
    assertTrue(actualTransactions.isInitialized());
    assertEquals('P', iteratorResult6.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('c', iteratorResult2.next().byteValue());
    assertEquals('g', iteratorResult5.next().byteValue());
    assertEquals('o', iteratorResult7.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertSame(toProtoResult.getReservedNameList(), defaultInstanceForType.getReservedNameList());
    assertSame(toProtoResult.getReservedNameList(), toProtoResult4.getReservedNameList());
    assertSame(toProtoResult.getReservedNameList(), toProtoResult5.getReservedNameList());
    assertSame(toProtoResult.getReservedNameList(), defaultInstanceForType3.getDependencyList());
  }
}
