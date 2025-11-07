package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import java.util.List;
import org.junit.Test;
import org.tron.protos.contract.ShieldContract;

public class SpendDescriptionCapsuleDiffblueTest {
  /**
   * Method under test: {@link SpendDescriptionCapsule#getValueCommitment()}
   */
  @Test
  public void testGetValueCommitment() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualValueCommitment = spendDescriptionCapsule.getValueCommitment();

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(instance, instance.getDefaultInstanceForType());
    ByteString byteString = actualValueCommitment.EMPTY;
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult3.toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult4 = fields.get(5);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, getResult2.getDefaultValue());
    assertSame(byteString, getResult3.getDefaultValue());
    assertSame(byteString, getResult4.getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, actualValueCommitment);
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getValueCommitment()}
   */
  @Test
  public void testGetValueCommitment2() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Act
    ByteString actualValueCommitment = spendDescriptionCapsule.getValueCommitment();

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    List<Descriptors.FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualValueCommitment.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getAnchor());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType.getZkproof());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  public void testSetValueCommitment() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(bytes, spendDescriptionCapsule.getValueCommitment());
    assertSame(bytes, instance.getValueCommitment());
    assertArrayEquals(new byte[]{'\n', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  public void testSetValueCommitment2() {
    // Arrange
    ShieldContract.SpendDescription spendDescription = ShieldContract.SpendDescription.getDefaultInstance();
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule(spendDescription);
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(spendDescription, instance.getDefaultInstanceForType());
    assertSame(bytes, spendDescriptionCapsule.getValueCommitment());
    assertSame(bytes, instance.getValueCommitment());
    assertArrayEquals(new byte[]{'\n', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  public void testSetValueCommitment3() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 18, data[2]);
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[10]);
    assertEquals('\b', data[3]);
    assertEquals('\n', data[0]);
    assertSame(bytes, spendDescriptionCapsule.getValueCommitment());
    assertSame(bytes, instance.getValueCommitment());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  public void testSetValueCommitment4() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[2]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[10]);
    assertEquals('\b', data[3]);
    assertEquals('\n', data[0]);
    assertSame(bytes, spendDescriptionCapsule.getValueCommitment());
    assertSame(bytes, instance.getValueCommitment());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  public void testSetValueCommitment5() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[10]);
    assertEquals('"', data[2]);
    assertEquals('\b', data[3]);
    assertEquals('\n', data[0]);
    assertSame(bytes, spendDescriptionCapsule.getValueCommitment());
    assertSame(bytes, instance.getValueCommitment());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  public void testSetValueCommitment6() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 1, data[11]);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('*', data[2]);
    assertEquals('A', data[10]);
    assertEquals('\b', data[3]);
    assertEquals('\n', data[0]);
    assertSame(bytes, spendDescriptionCapsule.getValueCommitment());
    assertSame(bytes, instance.getValueCommitment());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  public void testSetValueCommitment7() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(bytes, spendDescriptionCapsule.getValueCommitment());
    assertSame(bytes, instance.getValueCommitment());
    assertArrayEquals(new byte[]{'\n', 0, '2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getAnchor()}
   */
  @Test
  public void testGetAnchor() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualAnchor = spendDescriptionCapsule.getAnchor();

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(instance, instance.getDefaultInstanceForType());
    ByteString byteString = actualAnchor.EMPTY;
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult3.toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult4 = fields.get(5);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, getResult2.getDefaultValue());
    assertSame(byteString, getResult3.getDefaultValue());
    assertSame(byteString, getResult4.getDefaultValue());
    assertSame(byteString, actualAnchor);
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getAnchor()}
   */
  @Test
  public void testGetAnchor2() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Act
    ByteString actualAnchor = spendDescriptionCapsule.getAnchor();

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualAnchor.EMPTY;
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult3.toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult4 = fields.get(5);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, getResult2.getDefaultValue());
    assertSame(byteString, getResult3.getDefaultValue());
    assertSame(byteString, getResult4.getDefaultValue());
    assertSame(byteString, actualAnchor);
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getAnchor());
    ShieldContract.SpendDescription defaultInstanceForType3 = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType3.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, defaultInstanceForType3.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType3.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType3.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType3.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType3.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  public void testSetAnchor() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setAnchor(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getAnchor());
    assertSame(bytes, instance.getAnchor());
    assertArrayEquals(new byte[]{18, 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  public void testSetAnchor2() {
    // Arrange
    ShieldContract.SpendDescription spendDescription = ShieldContract.SpendDescription.getDefaultInstance();
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule(spendDescription);
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setAnchor(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(spendDescription, instance.getDefaultInstanceForType());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getAnchor());
    assertSame(bytes, instance.getAnchor());
    assertArrayEquals(new byte[]{18, 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  public void testSetAnchor3() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setAnchor(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 18, data[10]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 2, data[3]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[2]);
    assertEquals('\b', data[1]);
    assertEquals('\n', data[0]);
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getAnchor());
    assertSame(bytes, instance.getAnchor());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  public void testSetAnchor4() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setAnchor(bytes);

    // Assert
    ByteString nullifier = spendDescriptionCapsule.getNullifier();
    assertEquals("A\u0002A\u0002A\u0002A\u0002", nullifier.toStringUtf8());
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 18, data[0]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[2]);
    assertEquals((byte) 2, data[11]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertFalse(nullifier.isEmpty());
    assertTrue(nullifier.iterator().hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[10]);
    assertEquals('\b', data[3]);
    assertSame(nullifier, instance.getNullifier());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getAnchor());
    assertSame(bytes, instance.getAnchor());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  public void testSetAnchor5() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setAnchor(bytes);

    // Assert
    ByteString rk = spendDescriptionCapsule.getRk();
    assertEquals("A\u0002A\u0002A\u0002A\u0002", rk.toStringUtf8());
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 18, data[0]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 2, data[11]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertFalse(rk.isEmpty());
    assertTrue(rk.iterator().hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[10]);
    assertEquals('"', data[2]);
    assertEquals('\b', data[3]);
    assertSame(rk, instance.getRk());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getAnchor());
    assertSame(bytes, instance.getAnchor());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  public void testSetAnchor6() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setAnchor(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 18, data[0]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 2, data[11]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('*', data[2]);
    assertEquals('A', data[10]);
    assertEquals('\b', data[3]);
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, defaultInstanceForType.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getAnchor());
    assertSame(bytes, instance.getAnchor());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  public void testSetAnchor7() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setAnchor(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getAnchor());
    assertSame(bytes, instance.getAnchor());
    assertArrayEquals(new byte[]{18, 0, '2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getNullifier()}
   */
  @Test
  public void testGetNullifier() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualNullifier = spendDescriptionCapsule.getNullifier();

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(instance, instance.getDefaultInstanceForType());
    ByteString byteString = actualNullifier.EMPTY;
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult3.toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult4 = fields.get(5);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, getResult2.getDefaultValue());
    assertSame(byteString, getResult3.getDefaultValue());
    assertSame(byteString, getResult4.getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, actualNullifier);
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getNullifier()}
   */
  @Test
  public void testGetNullifier2() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Act
    ByteString actualNullifier = spendDescriptionCapsule.getNullifier();

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualNullifier.EMPTY;
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult3.toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult4 = fields.get(5);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, getResult2.getDefaultValue());
    assertSame(byteString, getResult3.getDefaultValue());
    assertSame(byteString, getResult4.getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, actualNullifier);
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getAnchor());
    ShieldContract.SpendDescription defaultInstanceForType3 = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType3.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, defaultInstanceForType3.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType3.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType3.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType3.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType3.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  public void testSetNullifier() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getNullifier());
    assertSame(bytes, instance.getNullifier());
    assertArrayEquals(new byte[]{26, 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  public void testSetNullifier2() {
    // Arrange
    ShieldContract.SpendDescription spendDescription = ShieldContract.SpendDescription.getDefaultInstance();
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule(spendDescription);
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(spendDescription, instance.getDefaultInstanceForType());
    assertSame(bytes, spendDescriptionCapsule.getNullifier());
    assertSame(bytes, instance.getNullifier());
    assertArrayEquals(new byte[]{26, 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  public void testSetNullifier3() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[10]);
    assertEquals((byte) 4, data[3]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[2]);
    assertEquals('\b', data[1]);
    assertEquals('\n', data[0]);
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getNullifier());
    assertSame(bytes, instance.getNullifier());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  public void testSetNullifier4() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 18, data[0]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[10]);
    assertEquals((byte) 4, data[3]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[2]);
    assertEquals('\b', data[1]);
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getNullifier());
    assertSame(bytes, instance.getNullifier());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  public void testSetNullifier5() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    ByteString rk = spendDescriptionCapsule.getRk();
    assertEquals("A\u0004A\u0004A\u0004A\u0004", rk.toStringUtf8());
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[0]);
    assertEquals((byte) 4, data[11]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertFalse(rk.isEmpty());
    assertTrue(rk.iterator().hasNext());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[10]);
    assertEquals('"', data[2]);
    assertEquals('\b', data[3]);
    assertSame(rk, instance.getRk());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getNullifier());
    assertSame(bytes, instance.getNullifier());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  public void testSetNullifier6() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[0]);
    assertEquals((byte) 4, data[11]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('*', data[2]);
    assertEquals('A', data[10]);
    assertEquals('\b', data[3]);
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, defaultInstanceForType.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getNullifier());
    assertSame(bytes, instance.getNullifier());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  public void testSetNullifier7() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    ShieldContract.SpendDescription defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAnchor());
    assertSame(byteString, defaultInstanceForType.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType.getRk());
    assertSame(byteString, defaultInstanceForType.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, defaultInstanceForType.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getNullifier());
    assertSame(bytes, instance.getNullifier());
    assertArrayEquals(new byte[]{26, 0, '2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getRk()}
   */
  @Test
  public void testGetRk() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualRk = spendDescriptionCapsule.getRk();

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(instance, instance.getDefaultInstanceForType());
    ByteString byteString = actualRk.EMPTY;
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult3.toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult4 = fields.get(5);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, getResult2.getDefaultValue());
    assertSame(byteString, getResult3.getDefaultValue());
    assertSame(byteString, getResult4.getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, actualRk);
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getRk()}
   */
  @Test
  public void testGetRk2() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Act
    ByteString actualRk = spendDescriptionCapsule.getRk();

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualRk.EMPTY;
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult3.toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult4 = fields.get(5);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, getResult2.getDefaultValue());
    assertSame(byteString, getResult3.getDefaultValue());
    assertSame(byteString, getResult4.getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, actualRk);
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getAnchor());
    ShieldContract.SpendDescription defaultInstanceForType3 = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType3.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, defaultInstanceForType3.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType3.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType3.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType3.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType3.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  public void testSetRk() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setRk(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(bytes, spendDescriptionCapsule.getRk());
    assertSame(bytes, instance.getRk());
    assertArrayEquals(new byte[]{'"', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  public void testSetRk2() {
    // Arrange
    ShieldContract.SpendDescription spendDescription = ShieldContract.SpendDescription.getDefaultInstance();
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule(spendDescription);
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setRk(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(spendDescription, instance.getDefaultInstanceForType());
    assertSame(bytes, spendDescriptionCapsule.getRk());
    assertSame(bytes, instance.getRk());
    assertArrayEquals(new byte[]{'"', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  public void testSetRk3() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment("A\bA\bA\bA\b".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setRk(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[2]);
    assertEquals('"', data[10]);
    assertEquals('\b', data[1]);
    assertEquals('\b', data[3]);
    assertEquals('\n', data[0]);
    assertSame(bytes, spendDescriptionCapsule.getRk());
    assertSame(bytes, instance.getRk());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  public void testSetRk4() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor("A\bA\bA\bA\b".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setRk(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 18, data[0]);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[2]);
    assertEquals('"', data[10]);
    assertEquals('\b', data[1]);
    assertEquals('\b', data[3]);
    assertSame(bytes, spendDescriptionCapsule.getRk());
    assertSame(bytes, instance.getRk());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  public void testSetRk5() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier("A\bA\bA\bA\b".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setRk(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[0]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('A', data[2]);
    assertEquals('"', data[10]);
    assertEquals('\b', data[1]);
    assertEquals('\b', data[3]);
    assertSame(bytes, spendDescriptionCapsule.getRk());
    assertSame(bytes, instance.getRk());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  public void testSetRk6() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof("A\bA\bA\bA\b".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setRk(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('*', data[2]);
    assertEquals('A', data[10]);
    assertEquals('"', data[0]);
    assertEquals('\b', data[11]);
    assertEquals('\b', data[3]);
    assertSame(bytes, spendDescriptionCapsule.getRk());
    assertSame(bytes, instance.getRk());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  public void testSetRk7() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setRk(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(bytes, spendDescriptionCapsule.getRk());
    assertSame(bytes, instance.getRk());
    assertArrayEquals(new byte[]{'"', 0, '2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getZkproof()}
   */
  @Test
  public void testGetZkproof() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualZkproof = spendDescriptionCapsule.getZkproof();

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(instance, instance.getDefaultInstanceForType());
    ByteString byteString = actualZkproof.EMPTY;
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult3.toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult4 = fields.get(5);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, getResult2.getDefaultValue());
    assertSame(byteString, getResult3.getDefaultValue());
    assertSame(byteString, getResult4.getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, actualZkproof);
    assertSame(byteString, instance.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getZkproof()}
   */
  @Test
  public void testGetZkproof2() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Act
    ByteString actualZkproof = spendDescriptionCapsule.getZkproof();

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualZkproof.EMPTY;
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult3.toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult4 = fields.get(5);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, getResult2.getDefaultValue());
    assertSame(byteString, getResult3.getDefaultValue());
    assertSame(byteString, getResult4.getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, actualZkproof);
    assertSame(byteString, instance.getAnchor());
    ShieldContract.SpendDescription defaultInstanceForType3 = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType3.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, defaultInstanceForType3.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType3.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType3.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType3.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType3.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  public void testSetZkproof() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    ByteString proof = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setZkproof(proof);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(proof, spendDescriptionCapsule.getZkproof());
    assertSame(proof, instance.getZkproof());
    assertArrayEquals(new byte[]{'*', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  public void testSetZkproof2() {
    // Arrange
    ShieldContract.SpendDescription spendDescription = ShieldContract.SpendDescription.getDefaultInstance();
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule(spendDescription);
    ByteString proof = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setZkproof(proof);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(spendDescription, instance.getDefaultInstanceForType());
    assertSame(proof, spendDescriptionCapsule.getZkproof());
    assertSame(proof, instance.getZkproof());
    assertArrayEquals(new byte[]{'*', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  public void testSetZkproof3() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});
    ByteString proof = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setZkproof(proof);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 16, data[3]);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('*', data[10]);
    assertEquals('A', data[2]);
    assertEquals('\b', data[1]);
    assertEquals('\n', data[0]);
    assertSame(proof, spendDescriptionCapsule.getZkproof());
    assertSame(proof, instance.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  public void testSetZkproof4() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});
    ByteString proof = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setZkproof(proof);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 16, data[3]);
    assertEquals((byte) 18, data[0]);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('*', data[10]);
    assertEquals('A', data[2]);
    assertEquals('\b', data[1]);
    assertSame(proof, spendDescriptionCapsule.getZkproof());
    assertSame(proof, instance.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  public void testSetZkproof5() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});
    ByteString proof = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setZkproof(proof);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 16, data[3]);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[0]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('*', data[10]);
    assertEquals('A', data[2]);
    assertEquals('\b', data[1]);
    assertSame(proof, spendDescriptionCapsule.getZkproof());
    assertSame(proof, instance.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  public void testSetZkproof6() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});
    ByteString proof = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setZkproof(proof);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 16, data[3]);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('*', data[10]);
    assertEquals('A', data[2]);
    assertEquals('"', data[0]);
    assertEquals('\b', data[1]);
    assertSame(proof, spendDescriptionCapsule.getZkproof());
    assertSame(proof, instance.getZkproof());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  public void testSetZkproof7() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));
    ByteString proof = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setZkproof(proof);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(proof, spendDescriptionCapsule.getZkproof());
    assertSame(proof, instance.getZkproof());
    assertArrayEquals(new byte[]{'*', 0, '2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#getSpendAuthoritySignature()}
   */
  @Test
  public void testGetSpendAuthoritySignature() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualSpendAuthoritySignature = spendDescriptionCapsule.getSpendAuthoritySignature();

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(instance, instance.getDefaultInstanceForType());
    ByteString byteString = actualSpendAuthoritySignature.EMPTY;
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult3.toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult4 = fields.get(5);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, getResult2.getDefaultValue());
    assertSame(byteString, getResult3.getDefaultValue());
    assertSame(byteString, getResult4.getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, actualSpendAuthoritySignature);
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#getSpendAuthoritySignature()}
   */
  @Test
  public void testGetSpendAuthoritySignature2() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Act
    ByteString actualSpendAuthoritySignature = spendDescriptionCapsule.getSpendAuthoritySignature();

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualSpendAuthoritySignature.EMPTY;
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult2.toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult3.toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult4 = fields.get(5);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertSame(byteString, getResult.getDefaultValue());
    assertSame(byteString, getResult2.getDefaultValue());
    assertSame(byteString, getResult3.getDefaultValue());
    assertSame(byteString, getResult4.getDefaultValue());
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, actualSpendAuthoritySignature);
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getAnchor());
    ShieldContract.SpendDescription defaultInstanceForType3 = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType3.getAnchor());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, defaultInstanceForType3.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, defaultInstanceForType3.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType3.getSpendAuthoritySignature());
    assertSame(byteString, defaultInstanceForType3.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(byteString, defaultInstanceForType3.getZkproof());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  public void testSetSpendAuthoritySignature() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(bytes, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(bytes, instance.getSpendAuthoritySignature());
    assertArrayEquals(new byte[]{'2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  public void testSetSpendAuthoritySignature2() {
    // Arrange
    ShieldContract.SpendDescription spendDescription = ShieldContract.SpendDescription.getDefaultInstance();
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule(spendDescription);
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(bytes);

    // Assert
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertSame(spendDescription, instance.getDefaultInstanceForType());
    assertSame(bytes, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(bytes, instance.getSpendAuthoritySignature());
    assertArrayEquals(new byte[]{'2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  public void testSetSpendAuthoritySignature3() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment("A A A A ".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('2', data[10]);
    assertEquals('\b', data[1]);
    assertEquals('\n', data[0]);
    assertSame(bytes, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(bytes, instance.getSpendAuthoritySignature());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  public void testSetSpendAuthoritySignature4() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor("A A A A ".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals((byte) 18, data[0]);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('2', data[10]);
    assertEquals('\b', data[1]);
    assertSame(bytes, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(bytes, instance.getSpendAuthoritySignature());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  public void testSetSpendAuthoritySignature5() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier("A A A A ".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    assertEquals((byte) 26, data[0]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('2', data[10]);
    assertEquals('\b', data[1]);
    assertSame(bytes, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(bytes, instance.getSpendAuthoritySignature());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  public void testSetSpendAuthoritySignature6() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk("A A A A ".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('2', data[10]);
    assertEquals('"', data[0]);
    assertEquals('\b', data[1]);
    assertSame(bytes, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(bytes, instance.getSpendAuthoritySignature());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  public void testSetSpendAuthoritySignature7() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof("A A A A ".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(bytes);

    // Assert
    byte[] data = spendDescriptionCapsule.getData();
    assertEquals((byte) 0, data[11]);
    ShieldContract.SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(12, data.length);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertTrue(descriptorForType.toProto().getDefaultInstanceForType().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals('*', data[0]);
    assertEquals('2', data[10]);
    assertEquals('\b', data[1]);
    assertSame(bytes, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(bytes, instance.getSpendAuthoritySignature());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new SpendDescriptionCapsule()).getData().length);
    assertEquals(0,
        (new SpendDescriptionCapsule(ShieldContract.SpendDescription.getDefaultInstance())).getData().length);
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, spendDescriptionCapsule.getData());
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  public void testGetData5() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  public void testGetData6() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{26, '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  public void testGetData7() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier(bytes3);
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  public void testGetData8() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    spendDescriptionCapsule.setNullifier(bytes3);
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'"', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  public void testGetData9() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(bytes4);
    spendDescriptionCapsule.setNullifier(bytes3);
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  public void testGetData10() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    spendDescriptionCapsule.setRk(bytes4);
    spendDescriptionCapsule.setNullifier(bytes3);
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'*', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  public void testGetData11() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);
    ByteString proof = mock(ByteString.class);
    when(proof.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(proof);
    spendDescriptionCapsule.setRk(bytes4);
    spendDescriptionCapsule.setNullifier(bytes3);
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(proof, atLeast(1)).isEmpty();
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  public void testGetData12() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);
    ByteString proof = mock(ByteString.class);
    when(proof.isEmpty()).thenReturn(true);
    ByteString bytes5 = mock(ByteString.class);
    when(bytes5.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(bytes5);
    spendDescriptionCapsule.setZkproof(proof);
    spendDescriptionCapsule.setRk(bytes4);
    spendDescriptionCapsule.setNullifier(bytes3);
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes5, atLeast(1)).isEmpty();
    verify(proof, atLeast(1)).isEmpty();
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(ShieldContract.SpendDescription)}
   */
  @Test
  public void testNewSpendDescriptionCapsule() {
    // Arrange
    ShieldContract.SpendDescription spendDescription = ShieldContract.SpendDescription.getDefaultInstance();

    // Act and Assert
    assertSame(spendDescription, (new SpendDescriptionCapsule(spendDescription)).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule4() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule5() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule("\"XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule7() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule("*XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule9() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule10() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule("2XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule11() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule12() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule13() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule14() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule15() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule16() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Method under test:
   * {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  public void testNewSpendDescriptionCapsule17() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }
}
