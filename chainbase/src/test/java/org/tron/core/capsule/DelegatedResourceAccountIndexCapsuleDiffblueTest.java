package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.protos.Protocol;

public class DelegatedResourceAccountIndexCapsuleDiffblueTest {
  /**
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getAccount()}
   */
  @Test
  public void testGetAccount() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));

    // Act
    ByteString actualAccount = delegatedResourceAccountIndexCapsule.getAccount();

    // Assert
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualAccount.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getAccount());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}
   */
  @Test
  public void testSetAccount() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    ByteString address = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.setAccount(address);

    // Assert
    assertSame(address, delegatedResourceAccountIndexCapsule.getAccount());
    assertSame(address, delegatedResourceAccountIndexCapsule.getInstance().getAccount());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}
   */
  @Test
  public void testSetAccount2() {
    // Arrange
    Protocol.DelegatedResourceAccountIndex delegatedResourceAccountIndex = Protocol.DelegatedResourceAccountIndex
        .getDefaultInstance();
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        delegatedResourceAccountIndex);
    ByteString address = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.setAccount(address);

    // Assert
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResourceAccountIndex, instance.getDefaultInstanceForType());
    ByteString expectedDefaultValue = address.EMPTY;
    assertSame(expectedDefaultValue, fields.get(0).getDefaultValue());
    assertSame(address, delegatedResourceAccountIndexCapsule.getAccount());
    assertSame(address, instance.getAccount());
    assertArrayEquals(new byte[]{'\n', 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}
   */
  @Test
  public void testSetAccount3() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);
    ByteString address = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.setAccount(address);

    // Assert
    assertSame(address, delegatedResourceAccountIndexCapsule.getAccount());
    assertSame(address, delegatedResourceAccountIndexCapsule.getInstance().getAccount());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}
   */
  @Test
  public void testSetAccount4() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});
    ByteString address = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.setAccount(address);

    // Assert
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getAccount());
    assertSame(address, delegatedResourceAccountIndexCapsule.getAccount());
    assertSame(address, instance.getAccount());
    assertArrayEquals(new byte[]{'\n', 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}
   */
  @Test
  public void testSetAccount5() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});
    ByteString address = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.setAccount(address);

    // Assert
    byte[] data = delegatedResourceAccountIndexCapsule.getData();
    assertEquals((byte) 0, data[1]);
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(18, data.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
    assertEquals('\n', data[0]);
    ByteString byteString = address.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getAccount());
    assertSame(address, delegatedResourceAccountIndexCapsule.getAccount());
    assertSame(address, instance.getAccount());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#getFromAccountsList()}
   */
  @Test
  public void testGetFromAccountsList() {
    // Arrange, Act and Assert
    assertTrue((new DelegatedResourceAccountIndexCapsule(mock(ByteString.class))).getFromAccountsList().isEmpty());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}
   */
  @Test
  public void testSetAllFromAccounts() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));

    // Act
    delegatedResourceAccountIndexCapsule.setAllFromAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    Protocol.DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(toAccountsList, defaultInstanceForType.getFromAccountsList());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccountsList, defaultInstanceForType.getToAccountsList());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}
   */
  @Test
  public void testSetAllFromAccounts2() {
    // Arrange
    Protocol.DelegatedResourceAccountIndex delegatedResourceAccountIndex = Protocol.DelegatedResourceAccountIndex
        .getDefaultInstance();
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        delegatedResourceAccountIndex);

    // Act
    delegatedResourceAccountIndexCapsule.setAllFromAccounts(new ArrayList<>());

    // Assert
    assertTrue(delegatedResourceAccountIndexCapsule.getToAccountsList().isEmpty());
    assertEquals(delegatedResourceAccountIndex, delegatedResourceAccountIndexCapsule.getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}
   */
  @Test
  public void testSetAllFromAccounts3() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Act
    delegatedResourceAccountIndexCapsule.setAllFromAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    Protocol.DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(toAccountsList, defaultInstanceForType.getFromAccountsList());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccountsList, defaultInstanceForType.getToAccountsList());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}
   */
  @Test
  public void testSetAllFromAccounts4() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});

    // Act
    delegatedResourceAccountIndexCapsule.setAllFromAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertSame(toAccountsList, instance.getToAccountsList());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}
   */
  @Test
  public void testSetAllFromAccounts5() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    delegatedResourceAccountIndexCapsule.setAllFromAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    Protocol.DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(toAccountsList, defaultInstanceForType.getFromAccountsList());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccountsList, defaultInstanceForType.getToAccountsList());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}
   */
  @Test
  public void testAddFromAccount() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    ByteString fromAccount = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.addFromAccount(fromAccount);

    // Assert
    byte[] data = delegatedResourceAccountIndexCapsule.getData();
    assertEquals((byte) 0, data[3]);
    List<ByteString> fromAccountsList = delegatedResourceAccountIndexCapsule.getFromAccountsList();
    assertEquals(1, fromAccountsList.size());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getFromAccountsCount());
    assertEquals((byte) 18, data[2]);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    Protocol.DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
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
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertEquals(toAccountsList, toProtoResult.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, toProtoResult2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, toProtoResult2.getSourceCodeInfo().findInitializationErrors());
    assertEquals(toAccountsList, options2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, options.getFeatures().findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(toAccountsList, options3.findInitializationErrors());
    assertEquals(toAccountsList, getResult.toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(1).toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(2).toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(3).toProto().findInitializationErrors());
    assertEquals(toAccountsList, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertEquals(toAccountsList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(toAccountsList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(43);
    assertEquals(toAccountsList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(44);
    assertEquals(toAccountsList, getResult5.getEnumTypes());
    assertEquals(toAccountsList, descriptorForType3.getExtensions());
    Descriptors.Descriptor descriptorForType5 = options2.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType5.getExtensions());
    assertEquals(toAccountsList, descriptorForType4.getExtensions());
    assertEquals(toAccountsList, getResult2.getExtensions());
    assertEquals(toAccountsList, getResult3.getExtensions());
    assertEquals(toAccountsList, getResult4.getExtensions());
    assertEquals(toAccountsList, getResult5.getExtensions());
    assertEquals(toAccountsList, descriptorForType5.getNestedTypes());
    assertEquals(toAccountsList, descriptorForType4.getNestedTypes());
    assertEquals(toAccountsList, getResult2.getNestedTypes());
    assertEquals(toAccountsList, getResult3.getNestedTypes());
    assertEquals(toAccountsList, getResult4.getNestedTypes());
    assertEquals(toAccountsList, getResult5.getNestedTypes());
    assertEquals(toAccountsList, descriptorForType3.getOneofs());
    assertEquals(toAccountsList, descriptorForType5.getOneofs());
    assertEquals(toAccountsList, descriptorForType4.getOneofs());
    assertEquals(toAccountsList, getResult2.getOneofs());
    assertEquals(toAccountsList, getResult3.getOneofs());
    assertEquals(toAccountsList, getResult4.getOneofs());
    assertEquals(toAccountsList, getResult5.getOneofs());
    assertEquals(toAccountsList, descriptorForType3.getRealOneofs());
    assertEquals(toAccountsList, descriptorForType5.getRealOneofs());
    assertEquals(toAccountsList, descriptorForType4.getRealOneofs());
    assertEquals(toAccountsList, getResult2.getRealOneofs());
    assertEquals(toAccountsList, getResult3.getRealOneofs());
    assertEquals(toAccountsList, getResult4.getRealOneofs());
    assertEquals(toAccountsList, getResult5.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(toAccountsList, file2.getDependencies());
    Descriptors.FileDescriptor getResult6 = dependencies.get(0);
    assertEquals(toAccountsList, getResult6.getDependencies());
    Descriptors.FileDescriptor getResult7 = dependencies.get(1);
    assertEquals(toAccountsList, getResult7.getDependencies());
    Descriptors.FileDescriptor getResult8 = dependencies.get(2);
    assertEquals(toAccountsList, getResult8.getDependencies());
    assertEquals(toAccountsList, getResult6.getEnumTypes());
    assertEquals(toAccountsList, getResult7.getEnumTypes());
    assertEquals(toAccountsList, file2.getExtensions());
    assertEquals(toAccountsList, getResult6.getExtensions());
    assertEquals(toAccountsList, getResult7.getExtensions());
    assertEquals(toAccountsList, getResult8.getExtensions());
    assertEquals(toAccountsList, getResult8.getMessageTypes());
    assertEquals(toAccountsList, file2.getPublicDependencies());
    assertEquals(toAccountsList, getResult6.getPublicDependencies());
    assertEquals(toAccountsList, getResult7.getPublicDependencies());
    assertEquals(toAccountsList, getResult8.getPublicDependencies());
    assertEquals(toAccountsList, file2.getServices());
    assertEquals(toAccountsList, getResult6.getServices());
    assertEquals(toAccountsList, getResult7.getServices());
    assertEquals(toAccountsList, getResult8.getServices());
    assertSame(toAccountsList, defaultInstanceForType.getFromAccountsList());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccountsList, defaultInstanceForType.getToAccountsList());
    assertSame(fromAccount, fromAccountsList.get(0));
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}
   */
  @Test
  public void testAddFromAccount2() {
    // Arrange
    Protocol.DelegatedResourceAccountIndex delegatedResourceAccountIndex = Protocol.DelegatedResourceAccountIndex
        .getDefaultInstance();
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        delegatedResourceAccountIndex);
    ByteString fromAccount = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.addFromAccount(fromAccount);

    // Assert
    List<ByteString> fromAccountsList = delegatedResourceAccountIndexCapsule.getFromAccountsList();
    assertEquals(1, fromAccountsList.size());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFromAccountsCount());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
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
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(toAccountsList, toProtoResult.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, toProtoResult2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, toProtoResult2.getSourceCodeInfo().findInitializationErrors());
    assertEquals(toAccountsList, options2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, options.getFeatures().findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(toAccountsList, options3.findInitializationErrors());
    assertEquals(toAccountsList, getResult.toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(1).toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(2).toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(3).toProto().findInitializationErrors());
    assertEquals(toAccountsList, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertEquals(toAccountsList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(toAccountsList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(43);
    assertEquals(toAccountsList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(44);
    assertEquals(toAccountsList, getResult5.getEnumTypes());
    assertEquals(toAccountsList, descriptorForType3.getExtensions());
    Descriptors.Descriptor descriptorForType5 = options2.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType5.getExtensions());
    assertEquals(toAccountsList, descriptorForType4.getExtensions());
    assertEquals(toAccountsList, getResult2.getExtensions());
    assertEquals(toAccountsList, getResult3.getExtensions());
    assertEquals(toAccountsList, getResult4.getExtensions());
    assertEquals(toAccountsList, getResult5.getExtensions());
    assertEquals(toAccountsList, descriptorForType5.getNestedTypes());
    assertEquals(toAccountsList, descriptorForType4.getNestedTypes());
    assertEquals(toAccountsList, getResult2.getNestedTypes());
    assertEquals(toAccountsList, getResult3.getNestedTypes());
    assertEquals(toAccountsList, getResult4.getNestedTypes());
    assertEquals(toAccountsList, getResult5.getNestedTypes());
    assertEquals(toAccountsList, descriptorForType3.getOneofs());
    assertEquals(toAccountsList, descriptorForType5.getOneofs());
    assertEquals(toAccountsList, descriptorForType4.getOneofs());
    assertEquals(toAccountsList, getResult2.getOneofs());
    assertEquals(toAccountsList, getResult3.getOneofs());
    assertEquals(toAccountsList, getResult4.getOneofs());
    assertEquals(toAccountsList, getResult5.getOneofs());
    assertEquals(toAccountsList, descriptorForType3.getRealOneofs());
    assertEquals(toAccountsList, descriptorForType5.getRealOneofs());
    assertEquals(toAccountsList, descriptorForType4.getRealOneofs());
    assertEquals(toAccountsList, getResult2.getRealOneofs());
    assertEquals(toAccountsList, getResult3.getRealOneofs());
    assertEquals(toAccountsList, getResult4.getRealOneofs());
    assertEquals(toAccountsList, getResult5.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(toAccountsList, file2.getDependencies());
    Descriptors.FileDescriptor getResult6 = dependencies.get(0);
    assertEquals(toAccountsList, getResult6.getDependencies());
    Descriptors.FileDescriptor getResult7 = dependencies.get(1);
    assertEquals(toAccountsList, getResult7.getDependencies());
    Descriptors.FileDescriptor getResult8 = dependencies.get(2);
    assertEquals(toAccountsList, getResult8.getDependencies());
    assertEquals(toAccountsList, getResult6.getEnumTypes());
    assertEquals(toAccountsList, getResult7.getEnumTypes());
    assertEquals(toAccountsList, file2.getExtensions());
    assertEquals(toAccountsList, getResult6.getExtensions());
    assertEquals(toAccountsList, getResult7.getExtensions());
    assertEquals(toAccountsList, getResult8.getExtensions());
    assertEquals(toAccountsList, getResult8.getMessageTypes());
    assertEquals(toAccountsList, file2.getPublicDependencies());
    assertEquals(toAccountsList, getResult6.getPublicDependencies());
    assertEquals(toAccountsList, getResult7.getPublicDependencies());
    assertEquals(toAccountsList, getResult8.getPublicDependencies());
    assertEquals(toAccountsList, file2.getServices());
    assertEquals(toAccountsList, getResult6.getServices());
    assertEquals(toAccountsList, getResult7.getServices());
    assertEquals(toAccountsList, getResult8.getServices());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(delegatedResourceAccountIndex, instance.getDefaultInstanceForType());
    assertSame(fromAccount, fromAccountsList.get(0));
    assertArrayEquals(new byte[]{18, 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}
   */
  @Test
  public void testAddFromAccount3() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);
    ByteString fromAccount = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.addFromAccount(fromAccount);

    // Assert
    byte[] data = delegatedResourceAccountIndexCapsule.getData();
    assertEquals((byte) 0, data[3]);
    List<ByteString> fromAccountsList = delegatedResourceAccountIndexCapsule.getFromAccountsList();
    assertEquals(1, fromAccountsList.size());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getFromAccountsCount());
    assertEquals((byte) 18, data[2]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    assertEquals(3, instance.getAllFields().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    Protocol.DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
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
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertEquals(toAccountsList, toProtoResult.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, toProtoResult2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, toProtoResult2.getSourceCodeInfo().findInitializationErrors());
    assertEquals(toAccountsList, options2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, options.getFeatures().findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(toAccountsList, options3.findInitializationErrors());
    assertEquals(toAccountsList, getResult.toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(1).toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(2).toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(3).toProto().findInitializationErrors());
    assertEquals(toAccountsList, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertEquals(toAccountsList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(toAccountsList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(43);
    assertEquals(toAccountsList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(44);
    assertEquals(toAccountsList, getResult5.getEnumTypes());
    assertEquals(toAccountsList, descriptorForType3.getExtensions());
    Descriptors.Descriptor descriptorForType5 = options2.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType5.getExtensions());
    assertEquals(toAccountsList, descriptorForType4.getExtensions());
    assertEquals(toAccountsList, getResult2.getExtensions());
    assertEquals(toAccountsList, getResult3.getExtensions());
    assertEquals(toAccountsList, getResult4.getExtensions());
    assertEquals(toAccountsList, getResult5.getExtensions());
    assertEquals(toAccountsList, descriptorForType5.getNestedTypes());
    assertEquals(toAccountsList, descriptorForType4.getNestedTypes());
    assertEquals(toAccountsList, getResult2.getNestedTypes());
    assertEquals(toAccountsList, getResult3.getNestedTypes());
    assertEquals(toAccountsList, getResult4.getNestedTypes());
    assertEquals(toAccountsList, getResult5.getNestedTypes());
    assertEquals(toAccountsList, descriptorForType3.getOneofs());
    assertEquals(toAccountsList, descriptorForType5.getOneofs());
    assertEquals(toAccountsList, descriptorForType4.getOneofs());
    assertEquals(toAccountsList, getResult2.getOneofs());
    assertEquals(toAccountsList, getResult3.getOneofs());
    assertEquals(toAccountsList, getResult4.getOneofs());
    assertEquals(toAccountsList, getResult5.getOneofs());
    assertEquals(toAccountsList, descriptorForType3.getRealOneofs());
    assertEquals(toAccountsList, descriptorForType5.getRealOneofs());
    assertEquals(toAccountsList, descriptorForType4.getRealOneofs());
    assertEquals(toAccountsList, getResult2.getRealOneofs());
    assertEquals(toAccountsList, getResult3.getRealOneofs());
    assertEquals(toAccountsList, getResult4.getRealOneofs());
    assertEquals(toAccountsList, getResult5.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(toAccountsList, file2.getDependencies());
    Descriptors.FileDescriptor getResult6 = dependencies.get(0);
    assertEquals(toAccountsList, getResult6.getDependencies());
    Descriptors.FileDescriptor getResult7 = dependencies.get(1);
    assertEquals(toAccountsList, getResult7.getDependencies());
    Descriptors.FileDescriptor getResult8 = dependencies.get(2);
    assertEquals(toAccountsList, getResult8.getDependencies());
    assertEquals(toAccountsList, getResult6.getEnumTypes());
    assertEquals(toAccountsList, getResult7.getEnumTypes());
    assertEquals(toAccountsList, file2.getExtensions());
    assertEquals(toAccountsList, getResult6.getExtensions());
    assertEquals(toAccountsList, getResult7.getExtensions());
    assertEquals(toAccountsList, getResult8.getExtensions());
    assertEquals(toAccountsList, getResult8.getMessageTypes());
    assertEquals(toAccountsList, file2.getPublicDependencies());
    assertEquals(toAccountsList, getResult6.getPublicDependencies());
    assertEquals(toAccountsList, getResult7.getPublicDependencies());
    assertEquals(toAccountsList, getResult8.getPublicDependencies());
    assertEquals(toAccountsList, file2.getServices());
    assertEquals(toAccountsList, getResult6.getServices());
    assertEquals(toAccountsList, getResult7.getServices());
    assertEquals(toAccountsList, getResult8.getServices());
    assertEquals(' ', data[4]);
    assertEquals('\n', data[5]);
    assertSame(toAccountsList, defaultInstanceForType.getFromAccountsList());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccountsList, defaultInstanceForType.getToAccountsList());
    assertSame(fromAccount, fromAccountsList.get(0));
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}
   */
  @Test
  public void testAddFromAccount4() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});
    ByteString fromAccount = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.addFromAccount(fromAccount);

    // Assert
    List<ByteString> fromAccountsList = delegatedResourceAccountIndexCapsule.getFromAccountsList();
    assertEquals(1, fromAccountsList.size());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFromAccountsCount());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    Protocol.DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
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
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(toAccountsList, toProtoResult.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, toProtoResult2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, toProtoResult2.getSourceCodeInfo().findInitializationErrors());
    assertEquals(toAccountsList, options2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, options.getFeatures().findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(toAccountsList, options3.findInitializationErrors());
    assertEquals(toAccountsList, getResult.toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(1).toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(2).toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(3).toProto().findInitializationErrors());
    assertEquals(toAccountsList, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertEquals(toAccountsList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(toAccountsList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(43);
    assertEquals(toAccountsList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(44);
    assertEquals(toAccountsList, getResult5.getEnumTypes());
    assertEquals(toAccountsList, descriptorForType3.getExtensions());
    Descriptors.Descriptor descriptorForType5 = options2.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType5.getExtensions());
    assertEquals(toAccountsList, descriptorForType4.getExtensions());
    assertEquals(toAccountsList, getResult2.getExtensions());
    assertEquals(toAccountsList, getResult3.getExtensions());
    assertEquals(toAccountsList, getResult4.getExtensions());
    assertEquals(toAccountsList, getResult5.getExtensions());
    assertEquals(toAccountsList, descriptorForType5.getNestedTypes());
    assertEquals(toAccountsList, descriptorForType4.getNestedTypes());
    assertEquals(toAccountsList, getResult2.getNestedTypes());
    assertEquals(toAccountsList, getResult3.getNestedTypes());
    assertEquals(toAccountsList, getResult4.getNestedTypes());
    assertEquals(toAccountsList, getResult5.getNestedTypes());
    assertEquals(toAccountsList, descriptorForType3.getOneofs());
    assertEquals(toAccountsList, descriptorForType5.getOneofs());
    assertEquals(toAccountsList, descriptorForType4.getOneofs());
    assertEquals(toAccountsList, getResult2.getOneofs());
    assertEquals(toAccountsList, getResult3.getOneofs());
    assertEquals(toAccountsList, getResult4.getOneofs());
    assertEquals(toAccountsList, getResult5.getOneofs());
    assertEquals(toAccountsList, descriptorForType3.getRealOneofs());
    assertEquals(toAccountsList, descriptorForType5.getRealOneofs());
    assertEquals(toAccountsList, descriptorForType4.getRealOneofs());
    assertEquals(toAccountsList, getResult2.getRealOneofs());
    assertEquals(toAccountsList, getResult3.getRealOneofs());
    assertEquals(toAccountsList, getResult4.getRealOneofs());
    assertEquals(toAccountsList, getResult5.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(toAccountsList, file2.getDependencies());
    Descriptors.FileDescriptor getResult6 = dependencies.get(0);
    assertEquals(toAccountsList, getResult6.getDependencies());
    Descriptors.FileDescriptor getResult7 = dependencies.get(1);
    assertEquals(toAccountsList, getResult7.getDependencies());
    Descriptors.FileDescriptor getResult8 = dependencies.get(2);
    assertEquals(toAccountsList, getResult8.getDependencies());
    assertEquals(toAccountsList, getResult6.getEnumTypes());
    assertEquals(toAccountsList, getResult7.getEnumTypes());
    assertEquals(toAccountsList, file2.getExtensions());
    assertEquals(toAccountsList, getResult6.getExtensions());
    assertEquals(toAccountsList, getResult7.getExtensions());
    assertEquals(toAccountsList, getResult8.getExtensions());
    assertEquals(toAccountsList, getResult8.getMessageTypes());
    assertEquals(toAccountsList, file2.getPublicDependencies());
    assertEquals(toAccountsList, getResult6.getPublicDependencies());
    assertEquals(toAccountsList, getResult7.getPublicDependencies());
    assertEquals(toAccountsList, getResult8.getPublicDependencies());
    assertEquals(toAccountsList, file2.getServices());
    assertEquals(toAccountsList, getResult6.getServices());
    assertEquals(toAccountsList, getResult7.getServices());
    assertEquals(toAccountsList, getResult8.getServices());
    assertSame(toAccountsList, defaultInstanceForType.getFromAccountsList());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccountsList, defaultInstanceForType.getToAccountsList());
    assertSame(fromAccount, fromAccountsList.get(0));
    assertArrayEquals(new byte[]{18, 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}
   */
  @Test
  public void testAddFromAccount5() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});
    ByteString fromAccount = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.addFromAccount(fromAccount);

    // Assert
    byte[] data = delegatedResourceAccountIndexCapsule.getData();
    assertEquals((byte) 0, data[1]);
    List<ByteString> fromAccountsList = delegatedResourceAccountIndexCapsule.getFromAccountsList();
    assertEquals(1, fromAccountsList.size());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getFromAccountsCount());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(18, data.length);
    assertEquals((byte) 18, data[0]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(3, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(45, messageTypes.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    Protocol.DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.getReservedNameList().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
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
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(toAccountsList, toProtoResult.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, toProtoResult2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, toProtoResult2.getSourceCodeInfo().findInitializationErrors());
    assertEquals(toAccountsList, options2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(toAccountsList, options.getFeatures().findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(toAccountsList, options3.findInitializationErrors());
    assertEquals(toAccountsList, getResult.toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(1).toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(2).toProto().findInitializationErrors());
    assertEquals(toAccountsList, fields.get(3).toProto().findInitializationErrors());
    assertEquals(toAccountsList, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertEquals(toAccountsList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(toAccountsList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(43);
    assertEquals(toAccountsList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(44);
    assertEquals(toAccountsList, getResult5.getEnumTypes());
    assertEquals(toAccountsList, descriptorForType3.getExtensions());
    Descriptors.Descriptor descriptorForType5 = options2.getDescriptorForType();
    assertEquals(toAccountsList, descriptorForType5.getExtensions());
    assertEquals(toAccountsList, descriptorForType4.getExtensions());
    assertEquals(toAccountsList, getResult2.getExtensions());
    assertEquals(toAccountsList, getResult3.getExtensions());
    assertEquals(toAccountsList, getResult4.getExtensions());
    assertEquals(toAccountsList, getResult5.getExtensions());
    assertEquals(toAccountsList, descriptorForType2.getNestedTypes());
    assertEquals(toAccountsList, descriptorForType5.getNestedTypes());
    assertEquals(toAccountsList, descriptorForType4.getNestedTypes());
    assertEquals(toAccountsList, getResult2.getNestedTypes());
    assertEquals(toAccountsList, getResult3.getNestedTypes());
    assertEquals(toAccountsList, getResult4.getNestedTypes());
    assertEquals(toAccountsList, getResult5.getNestedTypes());
    assertEquals(toAccountsList, descriptorForType2.getOneofs());
    assertEquals(toAccountsList, descriptorForType3.getOneofs());
    assertEquals(toAccountsList, descriptorForType5.getOneofs());
    assertEquals(toAccountsList, descriptorForType4.getOneofs());
    assertEquals(toAccountsList, getResult2.getOneofs());
    assertEquals(toAccountsList, getResult3.getOneofs());
    assertEquals(toAccountsList, getResult4.getOneofs());
    assertEquals(toAccountsList, getResult5.getOneofs());
    assertEquals(toAccountsList, descriptorForType2.getRealOneofs());
    assertEquals(toAccountsList, descriptorForType3.getRealOneofs());
    assertEquals(toAccountsList, descriptorForType5.getRealOneofs());
    assertEquals(toAccountsList, descriptorForType4.getRealOneofs());
    assertEquals(toAccountsList, getResult2.getRealOneofs());
    assertEquals(toAccountsList, getResult3.getRealOneofs());
    assertEquals(toAccountsList, getResult4.getRealOneofs());
    assertEquals(toAccountsList, getResult5.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(toAccountsList, file2.getDependencies());
    Descriptors.FileDescriptor getResult6 = dependencies.get(0);
    assertEquals(toAccountsList, getResult6.getDependencies());
    Descriptors.FileDescriptor getResult7 = dependencies.get(1);
    assertEquals(toAccountsList, getResult7.getDependencies());
    Descriptors.FileDescriptor getResult8 = dependencies.get(2);
    assertEquals(toAccountsList, getResult8.getDependencies());
    assertEquals(toAccountsList, getResult6.getEnumTypes());
    assertEquals(toAccountsList, getResult7.getEnumTypes());
    assertEquals(toAccountsList, file2.getExtensions());
    assertEquals(toAccountsList, getResult6.getExtensions());
    assertEquals(toAccountsList, getResult7.getExtensions());
    assertEquals(toAccountsList, getResult8.getExtensions());
    assertEquals(toAccountsList, getResult8.getMessageTypes());
    assertEquals(toAccountsList, file2.getPublicDependencies());
    assertEquals(toAccountsList, getResult6.getPublicDependencies());
    assertEquals(toAccountsList, getResult7.getPublicDependencies());
    assertEquals(toAccountsList, getResult8.getPublicDependencies());
    assertEquals(toAccountsList, file2.getServices());
    assertEquals(toAccountsList, getResult6.getServices());
    assertEquals(toAccountsList, getResult7.getServices());
    assertEquals(toAccountsList, getResult8.getServices());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
    assertSame(toAccountsList, defaultInstanceForType.getFromAccountsList());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccountsList, defaultInstanceForType.getToAccountsList());
    assertSame(fromAccount, fromAccountsList.get(0));
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#getToAccountsList()}
   */
  @Test
  public void testGetToAccountsList() {
    // Arrange, Act and Assert
    assertTrue((new DelegatedResourceAccountIndexCapsule(mock(ByteString.class))).getToAccountsList().isEmpty());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}
   */
  @Test
  public void testSetAllToAccounts() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));

    // Act
    delegatedResourceAccountIndexCapsule.setAllToAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertSame(toAccountsList, delegatedResourceAccountIndexCapsule.getInstance().getToAccountsList());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}
   */
  @Test
  public void testSetAllToAccounts2() {
    // Arrange
    Protocol.DelegatedResourceAccountIndex delegatedResourceAccountIndex = Protocol.DelegatedResourceAccountIndex
        .getDefaultInstance();
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        delegatedResourceAccountIndex);

    // Act
    delegatedResourceAccountIndexCapsule.setAllToAccounts(new ArrayList<>());

    // Assert
    assertTrue(delegatedResourceAccountIndexCapsule.getToAccountsList().isEmpty());
    assertEquals(delegatedResourceAccountIndex, delegatedResourceAccountIndexCapsule.getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}
   */
  @Test
  public void testSetAllToAccounts3() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Act
    delegatedResourceAccountIndexCapsule.setAllToAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertSame(toAccountsList, delegatedResourceAccountIndexCapsule.getInstance().getToAccountsList());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}
   */
  @Test
  public void testSetAllToAccounts4() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});

    // Act
    delegatedResourceAccountIndexCapsule.setAllToAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertSame(toAccountsList, delegatedResourceAccountIndexCapsule.getInstance().getToAccountsList());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}
   */
  @Test
  public void testSetAllToAccounts5() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    delegatedResourceAccountIndexCapsule.setAllToAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertSame(toAccountsList, delegatedResourceAccountIndexCapsule.getInstance().getToAccountsList());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}
   */
  @Test
  public void testAddToAccount() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    ByteString toAccount = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.addToAccount(toAccount);

    // Assert
    byte[] data = delegatedResourceAccountIndexCapsule.getData();
    assertEquals((byte) 0, data[3]);
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertEquals(1, toAccountsList.size());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getToAccountsCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[2]);
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccount, toAccountsList.get(0));
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}
   */
  @Test
  public void testAddToAccount2() {
    // Arrange
    Protocol.DelegatedResourceAccountIndex delegatedResourceAccountIndex = Protocol.DelegatedResourceAccountIndex
        .getDefaultInstance();
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        delegatedResourceAccountIndex);
    ByteString toAccount = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.addToAccount(toAccount);

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertEquals(1, toAccountsList.size());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getToAccountsCount());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(delegatedResourceAccountIndex, instance.getDefaultInstanceForType());
    assertSame(toAccount, toAccountsList.get(0));
    assertArrayEquals(new byte[]{26, 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}
   */
  @Test
  public void testAddToAccount3() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);
    ByteString toAccount = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.addToAccount(toAccount);

    // Assert
    byte[] data = delegatedResourceAccountIndexCapsule.getData();
    assertEquals((byte) 0, data[3]);
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertEquals(1, toAccountsList.size());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getToAccountsCount());
    assertEquals((byte) 26, data[2]);
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(6, data.length);
    assertEquals(' ', data[4]);
    assertEquals('\n', data[5]);
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccount, toAccountsList.get(0));
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}
   */
  @Test
  public void testAddToAccount4() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});
    ByteString toAccount = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.addToAccount(toAccount);

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertEquals(1, toAccountsList.size());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getToAccountsCount());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccount, toAccountsList.get(0));
    assertArrayEquals(new byte[]{26, 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}
   */
  @Test
  public void testAddToAccount5() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});
    ByteString toAccount = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.addToAccount(toAccount);

    // Assert
    byte[] data = delegatedResourceAccountIndexCapsule.getData();
    assertEquals((byte) 0, data[1]);
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertEquals(1, toAccountsList.size());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getToAccountsCount());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(18, data.length);
    assertEquals((byte) 26, data[0]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccount, toAccountsList.get(0));
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setTimestamp(long)}
   */
  @Test
  public void testSetTimestamp() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));

    // Act
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Assert
    assertEquals(10L, delegatedResourceAccountIndexCapsule.getTimestamp());
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(10L, instance.getTimestamp());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    byte[] data = delegatedResourceAccountIndexCapsule.getData();
    assertEquals(4, data.length);
    assertEquals(' ', data[2]);
    assertEquals('\n', data[3]);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setTimestamp(long)}
   */
  @Test
  public void testSetTimestamp2() {
    // Arrange
    Protocol.DelegatedResourceAccountIndex delegatedResourceAccountIndex = Protocol.DelegatedResourceAccountIndex
        .getDefaultInstance();
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        delegatedResourceAccountIndex);

    // Act
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Assert
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, delegatedResourceAccountIndexCapsule.getTimestamp());
    assertEquals(10L, instance.getTimestamp());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(delegatedResourceAccountIndex, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{' ', '\n'}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setTimestamp(long)}
   */
  @Test
  public void testSetTimestamp3() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});

    // Act
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Assert
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, delegatedResourceAccountIndexCapsule.getTimestamp());
    assertEquals(10L, instance.getTimestamp());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{' ', '\n'}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#setTimestamp(long)}
   */
  @Test
  public void testSetTimestamp4() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Assert
    Protocol.DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, delegatedResourceAccountIndexCapsule.getTimestamp());
    assertEquals(10L, instance.getTimestamp());
    assertEquals(18, instance.getSerializedSize());
    byte[] data = delegatedResourceAccountIndexCapsule.getData();
    assertEquals(18, data.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(4, descriptorForType.getFields().size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(Byte.MIN_VALUE, data[15]);
    assertEquals(' ', data[0]);
    assertEquals('A', data[Short.SIZE]);
    assertEquals('X', data[13]);
    assertEquals('X', data[17]);
    assertEquals('\n', data[1]);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#getTimestamp()}
   */
  @Test
  public void testGetTimestamp() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DelegatedResourceAccountIndexCapsule(mock(ByteString.class))).getTimestamp());
  }

  /**
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = (new DelegatedResourceAccountIndexCapsule(address)).createDbKey();

    // Assert
    verify(address).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#createDbKey()}
   */
  @Test
  public void testCreateDbKey2() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new DelegatedResourceAccountIndexCapsule(Protocol.DelegatedResourceAccountIndex.getDefaultInstance()))
            .createDbKey().length);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#createReadableString()}
   */
  @Test
  public void testCreateReadableString() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualCreateReadableStringResult = (new DelegatedResourceAccountIndexCapsule(address))
        .createReadableString();

    // Assert
    verify(address).toByteArray();
    assertEquals("4158415841584158", actualCreateReadableStringResult);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#createReadableString()}
   */
  @Test
  public void testCreateReadableString2() {
    // Arrange, Act and Assert
    assertEquals("",
        (new DelegatedResourceAccountIndexCapsule(Protocol.DelegatedResourceAccountIndex.getDefaultInstance()))
            .createReadableString());
  }

  /**
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new DelegatedResourceAccountIndexCapsule(address)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new DelegatedResourceAccountIndexCapsule(Protocol.DelegatedResourceAccountIndex.getDefaultInstance()))
            .getData().length);
  }

  /**
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        address);
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Act
    byte[] actualData = delegatedResourceAccountIndexCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{' ', '\n'}, actualData);
  }

  /**
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        address);
    delegatedResourceAccountIndexCapsule.setTimestamp(-1L);

    // Act
    byte[] actualData = delegatedResourceAccountIndexCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{' ', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  public void testGetData5() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        address);
    delegatedResourceAccountIndexCapsule.setTimestamp(Long.MAX_VALUE);

    // Act
    byte[] actualData = delegatedResourceAccountIndexCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{' ', -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  public void testGetData6() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        Protocol.DelegatedResourceAccountIndex.getDefaultInstance());
    delegatedResourceAccountIndexCapsule.setAllFromAccounts(new ArrayList<>());

    // Act and Assert
    assertEquals(0, delegatedResourceAccountIndexCapsule.getData().length);
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(Protocol.DelegatedResourceAccountIndex)}
   */
  @Test
  public void testNewDelegatedResourceAccountIndexCapsule() {
    // Arrange
    Protocol.DelegatedResourceAccountIndex delegatedResourceAccountIndex = Protocol.DelegatedResourceAccountIndex
        .getDefaultInstance();

    // Act and Assert
    assertSame(delegatedResourceAccountIndex,
        (new DelegatedResourceAccountIndexCapsule(delegatedResourceAccountIndex)).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceAccountIndexCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceAccountIndexCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceAccountIndexCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceAccountIndexCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceAccountIndexCapsule4() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceAccountIndexCapsule5() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceAccountIndexCapsule6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceAccountIndexCapsule(" XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceAccountIndexCapsule7() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceAccountIndexCapsule8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceAccountIndexCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceAccountIndexCapsule9() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceAccountIndexCapsule10() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceAccountIndexCapsule11() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  public void testNewDelegatedResourceAccountIndexCapsule12() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }
}
