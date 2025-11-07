package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.tron.common.zksnark.IncrementalMerkleTreeContainer;
import org.tron.common.zksnark.IncrementalMerkleVoucherContainer;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.ShieldContract;

public class IncrementalMerkleTreeCapsuleDiffblueTest {
  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#getLeft()}
   */
  @Test
  public void testGetLeft() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    ShieldContract.PedersenHash left = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.setLeft(left);

    // Act and Assert
    assertSame(left, incrementalMerkleTreeCapsule.getLeft());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#leftIsEmpty()}
   */
  @Test
  public void testLeftIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new IncrementalMerkleTreeCapsule()).leftIsEmpty());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#leftIsEmpty()}
   */
  @Test
  public void testLeftIsEmpty2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertTrue(incrementalMerkleTreeCapsule.leftIsEmpty());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearLeft()}
   */
  @Test
  public void testClearLeft() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();

    // Act
    incrementalMerkleTreeCapsule.clearLeft();

    // Assert
    ShieldContract.IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, incrementalMerkleTreeCapsule.getData().length);
    IncrementalMerkleVoucherCapsule voucherCapsule = incrementalMerkleTreeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    assertEquals(0, voucherCapsule.getTree().getData().length);
    byte[] data = voucherCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    assertEquals(2, instance2.getSerializedSize());
    assertEquals(2, data.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertFalse(instance.hasLeft());
    Map<Descriptors.FieldDescriptor, Object> allFields = instance.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(incrementalMerkleTreeCapsule.getLeft().getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(allFields, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(allFields, file.toProto().getDefaultInstanceForType().getAllFields());
    assertEquals(allFields, voucherCapsule.getOutputPoint().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertEquals(allFields, options2.getAllFields());
    assertEquals(allFields, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(allFields, features.getAllFieldsRaw());
    assertEquals(allFields, options2.getAllFieldsRaw());
    ShieldContract.IncrementalMerkleTree defaultInstanceForType2 = instance.getDefaultInstanceForType();
    assertEquals(instance, defaultInstanceForType2);
    assertSame(defaultInstanceForType2, voucherCapsule.getCursor().getInstance());
    assertSame(defaultInstanceForType2, instance2.getCursor());
    assertSame(defaultInstanceForType2, instance2.getCursorOrBuilder());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearLeft()}
   */
  @Test
  public void testClearLeft2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    ShieldContract.PedersenHash parents = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.addParents(parents);

    // Act
    incrementalMerkleTreeCapsule.clearLeft();

    // Assert
    ShieldContract.IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    ShieldContract.IncrementalMerkleTree defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getParentsCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    byte[] data = incrementalMerkleTreeCapsule.getData();
    assertEquals(2, data.length);
    IncrementalMerkleVoucherCapsule voucherCapsule = incrementalMerkleTreeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    byte[] data2 = voucherCapsule.getTree().getData();
    assertEquals(2, data2.length);
    assertEquals((byte) 26, data[0]);
    assertEquals((byte) 26, data2[0]);
    byte[] data3 = voucherCapsule.getData();
    assertEquals((byte) 26, data3[2]);
    assertEquals((byte) 2, data3[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    assertEquals(4, instance2.getSerializedSize());
    assertEquals(4, data3.length);
    assertFalse(instance.hasLeft());
    assertFalse(defaultInstanceForType.hasLeft());
    assertFalse(defaultInstanceForType.hasRight());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    List<ShieldContract.PedersenHash> parentsList = defaultInstanceForType.getParentsList();
    assertTrue(parentsList.isEmpty());
    ShieldContract.PedersenHash left = incrementalMerkleTreeCapsule.getLeft();
    Map<Descriptors.FieldDescriptor, Object> allFields = left.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(allFields, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(allFields, file.toProto().getDefaultInstanceForType().getAllFields());
    assertEquals(allFields, voucherCapsule.getOutputPoint().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertEquals(allFields, options2.getAllFields());
    assertEquals(allFields, defaultInstanceForType2.getAllFieldsRaw());
    assertEquals(allFields, features.getAllFieldsRaw());
    assertEquals(allFields, options2.getAllFieldsRaw());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleTree defaultInstanceForType3 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3, voucherCapsule.getCursor().getInstance());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    assertSame(defaultInstanceForType3, instance2.getCursor());
    assertSame(defaultInstanceForType3, instance2.getCursorOrBuilder());
    assertSame(parentsList, defaultInstanceForType.getParentsOrBuilderList());
    assertSame(parents, left);
    assertSame(parents, defaultInstanceForType.getLeft());
    assertSame(parents, defaultInstanceForType.getLeftOrBuilder());
    assertSame(parents, defaultInstanceForType.getRight());
    assertSame(parents, defaultInstanceForType.getRightOrBuilder());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearLeft()}
   */
  @Test
  public void testClearLeft3() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());
    ShieldContract.PedersenHash parents = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.addParents(parents);

    // Act
    incrementalMerkleTreeCapsule.clearLeft();

    // Assert
    ShieldContract.IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    ShieldContract.IncrementalMerkleTree defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getParentsCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    byte[] data = incrementalMerkleTreeCapsule.getData();
    assertEquals(2, data.length);
    IncrementalMerkleVoucherCapsule voucherCapsule = incrementalMerkleTreeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    byte[] data2 = voucherCapsule.getTree().getData();
    assertEquals(2, data2.length);
    assertEquals((byte) 26, data[0]);
    assertEquals((byte) 26, data2[0]);
    byte[] data3 = voucherCapsule.getData();
    assertEquals((byte) 26, data3[2]);
    assertEquals((byte) 2, data3[1]);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    assertEquals(4, instance2.getSerializedSize());
    assertEquals(4, data3.length);
    assertFalse(instance.hasLeft());
    assertFalse(defaultInstanceForType.hasLeft());
    assertFalse(defaultInstanceForType.hasRight());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    List<ShieldContract.PedersenHash> parentsList = defaultInstanceForType.getParentsList();
    assertTrue(parentsList.isEmpty());
    ShieldContract.PedersenHash left = incrementalMerkleTreeCapsule.getLeft();
    Map<Descriptors.FieldDescriptor, Object> allFields = left.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(allFields, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(allFields, file.toProto().getDefaultInstanceForType().getAllFields());
    assertEquals(allFields, voucherCapsule.getOutputPoint().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertEquals(allFields, options2.getAllFields());
    assertEquals(allFields, defaultInstanceForType2.getAllFieldsRaw());
    assertEquals(allFields, features.getAllFieldsRaw());
    assertEquals(allFields, options2.getAllFieldsRaw());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleTree defaultInstanceForType3 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3, voucherCapsule.getCursor().getInstance());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    assertSame(defaultInstanceForType3, instance2.getCursor());
    assertSame(defaultInstanceForType3, instance2.getCursorOrBuilder());
    assertSame(parentsList, defaultInstanceForType.getParentsOrBuilderList());
    assertSame(parents, left);
    assertSame(parents, defaultInstanceForType.getLeft());
    assertSame(parents, defaultInstanceForType.getLeftOrBuilder());
    assertSame(parents, defaultInstanceForType.getRight());
    assertSame(parents, defaultInstanceForType.getRightOrBuilder());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearLeft()}
   */
  @Test
  public void testClearLeft4() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());
    ShieldContract.PedersenHash parents = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.addParents(parents);

    // Act
    incrementalMerkleTreeCapsule.clearLeft();

    // Assert
    ShieldContract.IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    ShieldContract.IncrementalMerkleTree defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getParentsCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    byte[] data = incrementalMerkleTreeCapsule.getData();
    assertEquals((byte) 18, data[0]);
    IncrementalMerkleVoucherCapsule voucherCapsule = incrementalMerkleTreeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    byte[] data2 = voucherCapsule.getTree().getData();
    assertEquals((byte) 18, data2[0]);
    byte[] data3 = voucherCapsule.getData();
    assertEquals((byte) 18, data3[2]);
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, data.length);
    assertEquals(4, data2.length);
    assertEquals((byte) 4, data3[1]);
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    assertEquals(6, instance2.getSerializedSize());
    assertEquals(6, data3.length);
    assertFalse(instance.hasLeft());
    assertFalse(defaultInstanceForType.hasLeft());
    assertFalse(defaultInstanceForType.hasRight());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    List<ShieldContract.PedersenHash> parentsList = defaultInstanceForType.getParentsList();
    assertTrue(parentsList.isEmpty());
    ShieldContract.PedersenHash left = incrementalMerkleTreeCapsule.getLeft();
    Map<Descriptors.FieldDescriptor, Object> allFields = left.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(allFields, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(allFields, file.toProto().getDefaultInstanceForType().getAllFields());
    assertEquals(allFields, voucherCapsule.getOutputPoint().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertEquals(allFields, options2.getAllFields());
    assertEquals(allFields, defaultInstanceForType2.getAllFieldsRaw());
    assertEquals(allFields, features.getAllFieldsRaw());
    assertEquals(allFields, options2.getAllFieldsRaw());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleTree defaultInstanceForType3 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3, voucherCapsule.getCursor().getInstance());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    assertSame(defaultInstanceForType3, instance2.getCursor());
    assertSame(defaultInstanceForType3, instance2.getCursorOrBuilder());
    assertSame(parentsList, defaultInstanceForType.getParentsOrBuilderList());
    assertSame(parents, left);
    assertSame(parents, defaultInstanceForType.getLeft());
    assertSame(parents, defaultInstanceForType.getLeftOrBuilder());
    assertSame(parents, defaultInstanceForType.getRight());
    assertSame(parents, defaultInstanceForType.getRightOrBuilder());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearLeft()}
   */
  @Test
  public void testClearLeft5() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    ShieldContract.PedersenHash left = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.setLeft(left);

    // Act
    incrementalMerkleTreeCapsule.clearLeft();

    // Assert
    ShieldContract.IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, incrementalMerkleTreeCapsule.getData().length);
    IncrementalMerkleVoucherCapsule voucherCapsule = incrementalMerkleTreeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    assertEquals(0, voucherCapsule.getTree().getData().length);
    byte[] data = voucherCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    assertEquals(2, instance2.getSerializedSize());
    assertEquals(2, data.length);
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertFalse(instance.hasLeft());
    Map<Descriptors.FieldDescriptor, Object> allFields = instance.getAllFields();
    assertTrue(allFields.isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertEquals(allFields, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(allFields, file.toProto().getDefaultInstanceForType().getAllFields());
    assertEquals(allFields, voucherCapsule.getOutputPoint().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertEquals(allFields, options2.getAllFields());
    assertEquals(allFields, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(allFields, features.getAllFieldsRaw());
    assertEquals(allFields, options2.getAllFieldsRaw());
    ShieldContract.IncrementalMerkleTree defaultInstanceForType2 = instance.getDefaultInstanceForType();
    assertEquals(instance, defaultInstanceForType2);
    assertSame(defaultInstanceForType2, voucherCapsule.getCursor().getInstance());
    assertSame(defaultInstanceForType2, instance2.getCursor());
    assertSame(defaultInstanceForType2, instance2.getCursorOrBuilder());
    assertSame(left, incrementalMerkleTreeCapsule.getLeft());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#getRight()}
   */
  @Test
  public void testGetRight() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    ShieldContract.PedersenHash right = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.setRight(right);

    // Act and Assert
    assertSame(right, incrementalMerkleTreeCapsule.getRight());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#rightIsEmpty()}
   */
  @Test
  public void testRightIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new IncrementalMerkleTreeCapsule()).rightIsEmpty());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#rightIsEmpty()}
   */
  @Test
  public void testRightIsEmpty2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertTrue(incrementalMerkleTreeCapsule.rightIsEmpty());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearRight()}
   */
  @Test
  public void testClearRight() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();

    // Act
    incrementalMerkleTreeCapsule.clearRight();

    // Assert
    ShieldContract.IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, incrementalMerkleTreeCapsule.getData().length);
    IncrementalMerkleVoucherCapsule voucherCapsule = incrementalMerkleTreeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    assertEquals(0, voucherCapsule.getTree().getData().length);
    byte[] data = voucherCapsule.getData();
    assertEquals((byte) 0, data[1]);
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    assertEquals(2, instance2.getSerializedSize());
    assertEquals(2, data.length);
    assertFalse(instance.hasRight());
    assertTrue(instance.getAllFields().isEmpty());
    ShieldContract.IncrementalMerkleTree defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, defaultInstanceForType);
    assertSame(defaultInstanceForType, voucherCapsule.getCursor().getInstance());
    assertSame(defaultInstanceForType, instance2.getCursor());
    assertSame(defaultInstanceForType, instance2.getCursorOrBuilder());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearRight()}
   */
  @Test
  public void testClearRight2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    ShieldContract.PedersenHash parents = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.addParents(parents);

    // Act
    incrementalMerkleTreeCapsule.clearRight();

    // Assert
    ShieldContract.IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    ShieldContract.IncrementalMerkleTree defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getParentsCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    byte[] data = incrementalMerkleTreeCapsule.getData();
    assertEquals(2, data.length);
    IncrementalMerkleVoucherCapsule voucherCapsule = incrementalMerkleTreeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    byte[] data2 = voucherCapsule.getTree().getData();
    assertEquals(2, data2.length);
    assertEquals((byte) 26, data[0]);
    assertEquals((byte) 26, data2[0]);
    byte[] data3 = voucherCapsule.getData();
    assertEquals((byte) 26, data3[2]);
    assertEquals((byte) 2, data3[1]);
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    assertEquals(4, instance2.getSerializedSize());
    assertEquals(4, data3.length);
    assertFalse(defaultInstanceForType.hasLeft());
    assertFalse(instance.hasRight());
    assertFalse(defaultInstanceForType.hasRight());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    List<ShieldContract.PedersenHash> parentsList = defaultInstanceForType.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleTree defaultInstanceForType2 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, voucherCapsule.getCursor().getInstance());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(defaultInstanceForType2, instance2.getCursor());
    assertSame(defaultInstanceForType2, instance2.getCursorOrBuilder());
    assertSame(parentsList, defaultInstanceForType.getParentsOrBuilderList());
    assertSame(parents, defaultInstanceForType.getLeft());
    assertSame(parents, defaultInstanceForType.getLeftOrBuilder());
    assertSame(parents, defaultInstanceForType.getRight());
    assertSame(parents, defaultInstanceForType.getRightOrBuilder());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearRight()}
   */
  @Test
  public void testClearRight3() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());
    ShieldContract.PedersenHash parents = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.addParents(parents);

    // Act
    incrementalMerkleTreeCapsule.clearRight();

    // Assert
    ShieldContract.IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    ShieldContract.IncrementalMerkleTree defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getParentsCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    byte[] data = incrementalMerkleTreeCapsule.getData();
    assertEquals(4, data.length);
    IncrementalMerkleVoucherCapsule voucherCapsule = incrementalMerkleTreeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    byte[] data2 = voucherCapsule.getTree().getData();
    assertEquals(4, data2.length);
    byte[] data3 = voucherCapsule.getData();
    assertEquals((byte) 4, data3[1]);
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    assertEquals(6, instance2.getSerializedSize());
    assertEquals(6, data3.length);
    assertFalse(defaultInstanceForType.hasLeft());
    assertFalse(instance.hasRight());
    assertFalse(defaultInstanceForType.hasRight());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    List<ShieldContract.PedersenHash> parentsList = defaultInstanceForType.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals('\n', data[0]);
    assertEquals('\n', data2[0]);
    assertEquals('\n', data3[2]);
    ShieldContract.IncrementalMerkleTree defaultInstanceForType2 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, voucherCapsule.getCursor().getInstance());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(defaultInstanceForType2, instance2.getCursor());
    assertSame(defaultInstanceForType2, instance2.getCursorOrBuilder());
    assertSame(parentsList, defaultInstanceForType.getParentsOrBuilderList());
    assertSame(parents, defaultInstanceForType.getLeft());
    assertSame(parents, defaultInstanceForType.getLeftOrBuilder());
    assertSame(parents, defaultInstanceForType.getRight());
    assertSame(parents, defaultInstanceForType.getRightOrBuilder());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearRight()}
   */
  @Test
  public void testClearRight4() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());
    ShieldContract.PedersenHash parents = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.addParents(parents);

    // Act
    incrementalMerkleTreeCapsule.clearRight();

    // Assert
    ShieldContract.IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    ShieldContract.IncrementalMerkleTree defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getParentsCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    byte[] data = incrementalMerkleTreeCapsule.getData();
    assertEquals(2, data.length);
    IncrementalMerkleVoucherCapsule voucherCapsule = incrementalMerkleTreeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    byte[] data2 = voucherCapsule.getTree().getData();
    assertEquals(2, data2.length);
    assertEquals((byte) 26, data[0]);
    assertEquals((byte) 26, data2[0]);
    byte[] data3 = voucherCapsule.getData();
    assertEquals((byte) 26, data3[2]);
    assertEquals((byte) 2, data3[1]);
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    assertEquals(4, instance2.getSerializedSize());
    assertEquals(4, data3.length);
    assertFalse(defaultInstanceForType.hasLeft());
    assertFalse(instance.hasRight());
    assertFalse(defaultInstanceForType.hasRight());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    List<ShieldContract.PedersenHash> parentsList = defaultInstanceForType.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleTree defaultInstanceForType2 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, voucherCapsule.getCursor().getInstance());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(defaultInstanceForType2, instance2.getCursor());
    assertSame(defaultInstanceForType2, instance2.getCursorOrBuilder());
    assertSame(parentsList, defaultInstanceForType.getParentsOrBuilderList());
    assertSame(parents, defaultInstanceForType.getLeft());
    assertSame(parents, defaultInstanceForType.getLeftOrBuilder());
    assertSame(parents, defaultInstanceForType.getRight());
    assertSame(parents, defaultInstanceForType.getRightOrBuilder());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearRight()}
   */
  @Test
  public void testClearRight5() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    ShieldContract.PedersenHash left = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.setLeft(left);

    // Act
    incrementalMerkleTreeCapsule.clearRight();

    // Assert
    ShieldContract.IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    ShieldContract.IncrementalMerkleTree defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getParentsCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    byte[] data = incrementalMerkleTreeCapsule.getData();
    assertEquals(2, data.length);
    IncrementalMerkleVoucherCapsule voucherCapsule = incrementalMerkleTreeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    byte[] data2 = voucherCapsule.getTree().getData();
    assertEquals(2, data2.length);
    byte[] data3 = voucherCapsule.getData();
    assertEquals((byte) 2, data3[1]);
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    assertEquals(4, instance2.getSerializedSize());
    assertEquals(4, data3.length);
    assertFalse(defaultInstanceForType.hasLeft());
    assertFalse(instance.hasRight());
    assertFalse(defaultInstanceForType.hasRight());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals('\n', data[0]);
    assertEquals('\n', data2[0]);
    assertEquals('\n', data3[2]);
    ShieldContract.IncrementalMerkleTree defaultInstanceForType2 = defaultInstanceForType.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, voucherCapsule.getCursor().getInstance());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(defaultInstanceForType2, instance2.getCursor());
    assertSame(defaultInstanceForType2, instance2.getCursorOrBuilder());
    assertSame(left, defaultInstanceForType.getLeft());
    assertSame(left, defaultInstanceForType.getLeftOrBuilder());
    assertSame(left, defaultInstanceForType.getRight());
    assertSame(left, defaultInstanceForType.getRightOrBuilder());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#getParents()}
   */
  @Test
  public void testGetParents() {
    // Arrange, Act and Assert
    assertTrue((new IncrementalMerkleTreeCapsule()).getParents().isEmpty());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#parentsIsEmpty()}
   */
  @Test
  public void testParentsIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new IncrementalMerkleTreeCapsule()).parentsIsEmpty());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#parentsIsEmpty()}
   */
  @Test
  public void testParentsIsEmpty2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertFalse(incrementalMerkleTreeCapsule.parentsIsEmpty());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearParents(int)}
   */
  @Test
  public void testClearParents() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());
    ShieldContract.PedersenHash parents = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.addParents(parents);

    // Act
    incrementalMerkleTreeCapsule.clearParents(1);

    // Assert
    List<ShieldContract.PedersenHash> parents2 = incrementalMerkleTreeCapsule.getParents();
    assertEquals(2, parents2.size());
    assertEquals(parents, parents2.get(1));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearParents(int)}
   */
  @Test
  public void testClearParents2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());
    incrementalMerkleTreeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());
    ShieldContract.PedersenHash parents = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.addParents(parents);

    // Act
    incrementalMerkleTreeCapsule.clearParents(1);

    // Assert
    List<ShieldContract.PedersenHash> parents2 = incrementalMerkleTreeCapsule.getParents();
    assertEquals(2, parents2.size());
    assertEquals(parents, parents2.get(1));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#clearParents(int)}
   */
  @Test
  public void testClearParents3() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());
    incrementalMerkleTreeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());
    ShieldContract.PedersenHash parents = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.addParents(parents);

    // Act
    incrementalMerkleTreeCapsule.clearParents(1);

    // Assert
    List<ShieldContract.PedersenHash> parents2 = incrementalMerkleTreeCapsule.getParents();
    assertEquals(2, parents2.size());
    assertEquals(parents, parents2.get(1));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#isEmptyTree()}
   */
  @Test
  public void testIsEmptyTree() {
    // Arrange, Act and Assert
    assertTrue((new IncrementalMerkleTreeCapsule()).isEmptyTree());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#isEmptyTree()}
   */
  @Test
  public void testIsEmptyTree2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertFalse(incrementalMerkleTreeCapsule.isEmptyTree());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#isEmptyTree()}
   */
  @Test
  public void testIsEmptyTree3() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertTrue(incrementalMerkleTreeCapsule.isEmptyTree());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#isEmptyTree()}
   */
  @Test
  public void testIsEmptyTree4() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertTrue(incrementalMerkleTreeCapsule.isEmptyTree());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#notEmptyTree()}
   */
  @Test
  public void testNotEmptyTree() {
    // Arrange, Act and Assert
    assertFalse((new IncrementalMerkleTreeCapsule()).notEmptyTree());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#notEmptyTree()}
   */
  @Test
  public void testNotEmptyTree2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertTrue(incrementalMerkleTreeCapsule.notEmptyTree());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#notEmptyTree()}
   */
  @Test
  public void testNotEmptyTree3() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertFalse(incrementalMerkleTreeCapsule.notEmptyTree());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#notEmptyTree()}
   */
  @Test
  public void testNotEmptyTree4() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertFalse(incrementalMerkleTreeCapsule.notEmptyTree());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new IncrementalMerkleTreeCapsule()).getData().length);
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        (new IncrementalMerkleTreeCapsule(
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}))
                .getData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'},
        (new IncrementalMerkleTreeCapsule(
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'})).getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{26, 0}, incrementalMerkleTreeCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());
    incrementalMerkleTreeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', 0, 26, 0}, incrementalMerkleTreeCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());
    incrementalMerkleTreeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{18, 0, 26, 0}, incrementalMerkleTreeCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeCapsule#getData()}
   */
  @Test
  public void testGetData5() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualData = (new IncrementalMerkleTreeCapsule("AXAXAXAXAXAXAXAAAXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    assertArrayEquals("AXAXAXAXAAAXAXAXAXXAXAXA".getBytes("UTF-8"), actualData);
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#toMerkleTreeContainer()}
   */
  @Test
  public void testToMerkleTreeContainer() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();

    // Act
    IncrementalMerkleTreeContainer actualToMerkleTreeContainerResult = incrementalMerkleTreeCapsule
        .toMerkleTreeContainer();

    // Assert
    IncrementalMerkleVoucherContainer toVoucherResult = actualToMerkleTreeContainerResult.toVoucher();
    IncrementalMerkleVoucherCapsule voucherCapsule = toVoucherResult.getVoucherCapsule();
    ShieldContract.IncrementalMerkleVoucher instance = voucherCapsule.getInstance();
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    ShieldContract.OutputPoint outputPoint = voucherCapsule.getOutputPoint();
    Descriptors.Descriptor descriptorForType2 = outputPoint.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", instance.getInitializationErrorString());
    assertEquals("", outputPoint.getInitializationErrorString());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("IncrementalMerkleVoucher", toProtoResult.getName());
    assertEquals("IncrementalMerkleVoucher", descriptorForType.getName());
    assertEquals("OutputPoint", toProtoResult2.getName());
    assertEquals("OutputPoint", descriptorForType2.getName());
    assertEquals("protocol.IncrementalMerkleVoucher", descriptorForType.getFullName());
    assertEquals("protocol.OutputPoint", descriptorForType2.getFullName());
    assertNull(descriptorForType.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult2.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult2.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult2.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult2.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult2.getReservedRangeCount());
    assertEquals(0, actualToMerkleTreeContainerResult.size());
    assertEquals(0, toVoucherResult.size());
    IncrementalMerkleVoucherContainer toMerkleVoucherContainerResult = voucherCapsule.toMerkleVoucherContainer();
    assertEquals(0, toMerkleVoucherContainerResult.size());
    assertEquals(0, instance.getFilledCount());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, outputPoint.getIndex());
    assertEquals(0, outputPoint.getSerializedSize());
    assertEquals(0, voucherCapsule.getCursor().getData().length);
    assertEquals(0, voucherCapsule.getTree().getData().length);
    assertEquals(0L, voucherCapsule.getCursorDepth());
    assertEquals(0L, instance.getCursorDepth());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, toProtoResult2.getFieldCount());
    assertEquals(2, descriptorForType2.getIndex());
    assertEquals(2, descriptorForType2.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(241, toProtoResult.getSerializedSize());
    assertEquals(42, toProtoResult2.getSerializedSize());
    assertEquals(6, toProtoResult.getFieldCount());
    assertEquals(6, descriptorForType.getIndex());
    assertEquals(6, descriptorForType.getFields().size());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(instance.hasCursor());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(instance.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(outputPoint.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(outputPoint.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(instance.hasTree());
    assertTrue(instance.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(outputPoint.isInitialized());
    assertSame(incrementalMerkleTreeCapsule, actualToMerkleTreeContainerResult.getTreeCapsule());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(voucherCapsule, toMerkleVoucherContainerResult.getVoucherCapsule());
    assertSame(outputPoint, instance.getOutputPoint());
    assertSame(outputPoint, defaultInstanceForType.getOutputPoint());
    assertSame(outputPoint, instance.getOutputPointOrBuilder());
    assertSame(outputPoint, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(outputPoint, outputPoint.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\n', 0}, voucherCapsule.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualToMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualToMerkleTreeContainerResult.getRootArray());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(ShieldContract.IncrementalMerkleTree)}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule() {
    // Arrange
    ShieldContract.IncrementalMerkleTree merkleTree = ShieldContract.IncrementalMerkleTree.getDefaultInstance();

    // Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(merkleTree);

    // Assert
    assertSame(merkleTree, actualIncrementalMerkleTreeCapsule.getInstance());
    IncrementalMerkleVoucherCapsule voucherCapsule = actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    assertSame(merkleTree, voucherCapsule.getCursor().getInstance());
    assertSame(merkleTree, voucherCapsule.getTree().getInstance());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule2() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule3() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule4() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        "\nXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule5() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule6() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule7() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule8() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        "XXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule9() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(new byte[]{});

    // Assert
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule10() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule11() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule12() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule13() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{26, 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule14() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule15() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{'\n', 2, 2, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule16() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{'\n', 2, '\n', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule17() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{'\n', 2, 'X', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule18() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{'\n', 0, '\n', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule19() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{'\n', 0, 18, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleTreeCapsule20() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule(
        new byte[]{18, 0, 18, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }
}
