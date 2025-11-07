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
import java.util.Map;
import org.junit.Test;
import org.tron.common.zksnark.IncrementalMerkleVoucherContainer;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.ShieldContract;

public class IncrementalMerkleVoucherCapsuleDiffblueTest {
  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setTree(IncrementalMerkleTreeCapsule)}
   */
  @Test
  public void testSetTree() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    IncrementalMerkleTreeCapsule merkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    ShieldContract.IncrementalMerkleTree defaultInstance = ShieldContract.IncrementalMerkleTree.getDefaultInstance();
    when(merkleTreeCapsule.getInstance()).thenReturn(defaultInstance);

    // Act
    incrementalMerkleVoucherCapsule.setTree(merkleTreeCapsule);

    // Assert
    verify(merkleTreeCapsule).getInstance();
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    assertTrue(cursor.getLeft().getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasTree());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(instance, cursor.toMerkleTreeContainer().toVoucher().getVoucherCapsule().getInstance());
    assertEquals(instance,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(defaultInstance, cursor.getInstance());
    assertSame(defaultInstance, defaultInstanceForType.getCursor());
    assertSame(defaultInstance, defaultInstanceForType.getCursorOrBuilder());
    assertSame(defaultInstance, defaultInstanceForType.getTree());
    assertSame(defaultInstance, defaultInstanceForType.getTreeOrBuilder());
    assertArrayEquals(new byte[]{'\n', 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setTree(IncrementalMerkleTreeCapsule)}
   */
  @Test
  public void testSetTree2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());
    IncrementalMerkleTreeCapsule merkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    ShieldContract.IncrementalMerkleTree defaultInstance = ShieldContract.IncrementalMerkleTree.getDefaultInstance();
    when(merkleTreeCapsule.getInstance()).thenReturn(defaultInstance);

    // Act
    incrementalMerkleVoucherCapsule.setTree(merkleTreeCapsule);

    // Assert
    verify(merkleTreeCapsule).getInstance();
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    assertTrue(cursor.getLeft().getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasTree());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance2 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance2,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(defaultInstance, cursor.getInstance());
    assertSame(defaultInstance, defaultInstanceForType.getCursor());
    assertSame(defaultInstance, defaultInstanceForType.getCursorOrBuilder());
    assertSame(defaultInstance, defaultInstanceForType.getTree());
    assertSame(defaultInstance, defaultInstanceForType.getTreeOrBuilder());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setTree(IncrementalMerkleTreeCapsule)}
   */
  @Test
  public void testSetTree3() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);
    IncrementalMerkleTreeCapsule merkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    ShieldContract.IncrementalMerkleTree defaultInstance = ShieldContract.IncrementalMerkleTree.getDefaultInstance();
    when(merkleTreeCapsule.getInstance()).thenReturn(defaultInstance);

    // Act
    incrementalMerkleVoucherCapsule.setTree(merkleTreeCapsule);

    // Assert
    verify(merkleTreeCapsule).getInstance();
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    Map<Descriptors.FieldDescriptor, Object> allFields = instance2.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(cursor.getLeft().getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasTree());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(allFields, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    assertEquals(allFields, features.getAllFieldsRaw());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(defaultInstance, instance2);
    assertSame(defaultInstance, defaultInstanceForType.getCursor());
    assertSame(defaultInstance, defaultInstanceForType.getCursorOrBuilder());
    assertSame(defaultInstance, defaultInstanceForType.getTree());
    assertSame(defaultInstance, defaultInstanceForType.getTreeOrBuilder());
    assertArrayEquals(new byte[]{'\n', 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getFilled()}
   */
  @Test
  public void testGetFilled() {
    // Arrange, Act and Assert
    assertTrue((new IncrementalMerkleVoucherCapsule()).getFilled().isEmpty());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getFilled()}
   */
  @Test
  public void testGetFilled2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Act and Assert
    assertTrue(incrementalMerkleVoucherCapsule.getFilled().isEmpty());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#addFilled(ShieldContract.PedersenHash)}
   */
  @Test
  public void testAddFilled() {
    // Arrange
    IncrementalMerkleTreeCapsule merkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(merkleTreeCapsule.getInstance()).thenReturn(ShieldContract.IncrementalMerkleTree.getDefaultInstance());

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(merkleTreeCapsule);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Assert
    verify(merkleTreeCapsule).getInstance();
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#addFilled(ShieldContract.PedersenHash)}
   */
  @Test
  public void testAddFilled2() {
    // Arrange
    IncrementalMerkleTreeCapsule merkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(merkleTreeCapsule.getInstance()).thenReturn(ShieldContract.IncrementalMerkleTree.getDefaultInstance());

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);
    incrementalMerkleVoucherCapsule.setTree(merkleTreeCapsule);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Assert
    verify(merkleTreeCapsule).getInstance();
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setCursor(IncrementalMerkleTreeCapsule)}
   */
  @Test
  public void testSetCursor() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    IncrementalMerkleTreeCapsule cursor = mock(IncrementalMerkleTreeCapsule.class);
    ShieldContract.IncrementalMerkleTree defaultInstance = ShieldContract.IncrementalMerkleTree.getDefaultInstance();
    when(cursor.getInstance()).thenReturn(defaultInstance);

    // Act
    incrementalMerkleVoucherCapsule.setCursor(cursor);

    // Assert
    verify(cursor).getInstance();
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor2 = incrementalMerkleVoucherCapsule.getCursor();
    assertTrue(cursor2.getLeft().getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasCursor());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance2 = cursor2.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance2,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(defaultInstance, cursor2.getInstance());
    assertSame(defaultInstance, defaultInstanceForType.getCursor());
    assertSame(defaultInstance, defaultInstanceForType.getCursorOrBuilder());
    assertSame(defaultInstance, defaultInstanceForType.getTree());
    assertSame(defaultInstance, defaultInstanceForType.getTreeOrBuilder());
    assertArrayEquals(new byte[]{26, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setCursor(IncrementalMerkleTreeCapsule)}
   */
  @Test
  public void testSetCursor2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());
    IncrementalMerkleTreeCapsule cursor = mock(IncrementalMerkleTreeCapsule.class);
    ShieldContract.IncrementalMerkleTree defaultInstance = ShieldContract.IncrementalMerkleTree.getDefaultInstance();
    when(cursor.getInstance()).thenReturn(defaultInstance);

    // Act
    incrementalMerkleVoucherCapsule.setCursor(cursor);

    // Assert
    verify(cursor).getInstance();
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor2 = incrementalMerkleVoucherCapsule.getCursor();
    assertTrue(cursor2.getLeft().getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasCursor());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance2 = cursor2.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance2,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(defaultInstance, cursor2.getInstance());
    assertSame(defaultInstance, defaultInstanceForType.getCursor());
    assertSame(defaultInstance, defaultInstanceForType.getCursorOrBuilder());
    assertSame(defaultInstance, defaultInstanceForType.getTree());
    assertSame(defaultInstance, defaultInstanceForType.getTreeOrBuilder());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setCursor(IncrementalMerkleTreeCapsule)}
   */
  @Test
  public void testSetCursor3() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);
    IncrementalMerkleTreeCapsule cursor = mock(IncrementalMerkleTreeCapsule.class);
    ShieldContract.IncrementalMerkleTree defaultInstance = ShieldContract.IncrementalMerkleTree.getDefaultInstance();
    when(cursor.getInstance()).thenReturn(defaultInstance);

    // Act
    incrementalMerkleVoucherCapsule.setCursor(cursor);

    // Assert
    verify(cursor).getInstance();
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(2, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor2 = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.IncrementalMerkleTree instance2 = cursor2.getInstance();
    Map<Descriptors.FieldDescriptor, Object> allFields = instance2.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(cursor2.getLeft().getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasCursor());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(allFields, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    assertEquals(allFields, features.getAllFieldsRaw());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor2.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(defaultInstance, instance2);
    assertSame(defaultInstance, defaultInstanceForType.getCursor());
    assertSame(defaultInstance, defaultInstanceForType.getCursorOrBuilder());
    assertSame(defaultInstance, defaultInstanceForType.getTree());
    assertSame(defaultInstance, defaultInstanceForType.getTreeOrBuilder());
    assertArrayEquals(new byte[]{26, 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  public void testClearCursor() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, incrementalMerkleVoucherCapsule.getData().length);
    assertFalse(instance.hasCursor());
    assertTrue(instance.getAllFields().isEmpty());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, defaultInstanceForType);
    assertSame(defaultInstanceForType,
        incrementalMerkleVoucherCapsule.getCursor()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance()
            .getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  public void testClearCursor2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, incrementalMerkleVoucherCapsule.getData().length);
    assertFalse(instance.hasCursor());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2,
        incrementalMerkleVoucherCapsule.getCursor()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance()
            .getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  public void testClearCursor3() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, incrementalMerkleVoucherCapsule.getData().length);
    assertFalse(instance.hasCursor());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2,
        incrementalMerkleVoucherCapsule.getCursor()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance()
            .getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  public void testClearCursor4() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, incrementalMerkleVoucherCapsule.getData().length);
    assertFalse(instance.hasCursor());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2,
        incrementalMerkleVoucherCapsule.getCursor()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance()
            .getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  public void testClearCursor5() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(2L);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(4, incrementalMerkleVoucherCapsule.getData().length);
    assertFalse(instance.hasCursor());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2,
        incrementalMerkleVoucherCapsule.getCursor()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance()
            .getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  public void testClearCursor6() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(8, incrementalMerkleVoucherCapsule.getData().length);
    assertFalse(instance.hasCursor());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2,
        incrementalMerkleVoucherCapsule.getCursor()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance()
            .getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  public void testClearCursor7() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, incrementalMerkleVoucherCapsule.getData().length);
    assertFalse(instance.hasCursor());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance2 = incrementalMerkleVoucherCapsule.getCursor()
        .toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance, instance2);
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getCursorDepth()}
   */
  @Test
  public void testGetCursorDepth() {
    // Arrange, Act and Assert
    assertEquals(0L, (new IncrementalMerkleVoucherCapsule()).getCursorDepth());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getCursorDepth()}
   */
  @Test
  public void testGetCursorDepth2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Act and Assert
    assertEquals(0L, incrementalMerkleVoucherCapsule.getCursorDepth());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  public void testSetCursorDepth() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, incrementalMerkleVoucherCapsule.getCursorDepth());
    assertEquals(1L, instance.getCursorDepth());
    assertEquals(2, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    assertTrue(instance2.getAllFields().isEmpty());
    assertTrue(cursor.getLeft().getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(instance2, defaultInstanceForType.getCursor());
    assertSame(instance2, defaultInstanceForType.getCursorOrBuilder());
    assertSame(instance2, defaultInstanceForType.getTree());
    assertSame(instance2, defaultInstanceForType.getTreeOrBuilder());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertArrayEquals(new byte[]{' ', 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  public void testSetCursorDepth2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    ShieldContract.PedersenHash value = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleVoucherCapsule.addFilled(value);

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1L, incrementalMerkleVoucherCapsule.getCursorDepth());
    assertEquals(1L, instance.getCursorDepth());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    assertTrue(instance2.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(instance2, defaultInstanceForType.getCursor());
    assertSame(instance2, defaultInstanceForType.getCursorOrBuilder());
    assertSame(instance2, defaultInstanceForType.getTree());
    assertSame(instance2, defaultInstanceForType.getTreeOrBuilder());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(value, cursor.getLeft());
    assertArrayEquals(new byte[]{18, 0, ' ', 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  public void testSetCursorDepth3() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());
    ShieldContract.PedersenHash value = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleVoucherCapsule.addFilled(value);

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1L, incrementalMerkleVoucherCapsule.getCursorDepth());
    assertEquals(1L, instance.getCursorDepth());
    assertEquals(3, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    assertTrue(instance2.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(instance2, defaultInstanceForType.getCursor());
    assertSame(instance2, defaultInstanceForType.getCursorOrBuilder());
    assertSame(instance2, defaultInstanceForType.getTree());
    assertSame(instance2, defaultInstanceForType.getTreeOrBuilder());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(value, cursor.getLeft());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, ' ', 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  public void testSetCursorDepth4() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());
    ShieldContract.PedersenHash value = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleVoucherCapsule.addFilled(value);

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1L, incrementalMerkleVoucherCapsule.getCursorDepth());
    assertEquals(1L, instance.getCursorDepth());
    assertEquals(3, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    assertTrue(instance2.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(instance2, defaultInstanceForType.getCursor());
    assertSame(instance2, defaultInstanceForType.getCursorOrBuilder());
    assertSame(instance2, defaultInstanceForType.getTree());
    assertSame(instance2, defaultInstanceForType.getTreeOrBuilder());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(value, cursor.getLeft());
    assertArrayEquals(new byte[]{18, 0, 26, 0, ' ', 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  public void testSetCursorDepth5() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);
    ShieldContract.PedersenHash value = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleVoucherCapsule.addFilled(value);

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(1L, incrementalMerkleVoucherCapsule.getCursorDepth());
    assertEquals(1L, instance.getCursorDepth());
    assertEquals(3, instance.getAllFields().size());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    Map<Descriptors.FieldDescriptor, Object> allFields = instance2.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(allFields, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    assertEquals(allFields, features.getAllFieldsRaw());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(instance2, defaultInstanceForType.getCursor());
    assertSame(instance2, defaultInstanceForType.getCursorOrBuilder());
    assertSame(instance2, defaultInstanceForType.getTree());
    assertSame(instance2, defaultInstanceForType.getTreeOrBuilder());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(value, cursor.getLeft());
    assertArrayEquals(new byte[]{18, 0, ' ', 1, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  public void testSetCursorDepth6() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1L, incrementalMerkleVoucherCapsule.getCursorDepth());
    assertEquals(1L, instance.getCursorDepth());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(6, descriptorForType.getFields().size());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    assertTrue(instance2.getAllFields().isEmpty());
    assertTrue(cursor.getLeft().getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(instance2, defaultInstanceForType.getCursor());
    assertSame(instance2, defaultInstanceForType.getCursorOrBuilder());
    assertSame(instance2, defaultInstanceForType.getTree());
    assertSame(instance2, defaultInstanceForType.getTreeOrBuilder());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertArrayEquals(new byte[]{'\n', 0, ' ', 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#resetRt()}
   */
  @Test
  public void testResetRt() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();

    // Act
    incrementalMerkleVoucherCapsule.resetRt();

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    ShieldContract.OutputPoint outputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();
    ByteString hash = outputPoint.getHash();
    assertEquals("", hash.toStringUtf8());
    ByteString rt = instance.getRt();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        rt.toStringUtf8());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    ByteString.ByteIterator iteratorResult = rt.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.PedersenHash left = cursor.getLeft();
    List<Descriptors.FieldDescriptor> fields = left.getDescriptorForType().getFields();
    assertEquals(1, fields.size());
    assertEquals(1, instance.getAllFields().size());
    List<Descriptors.FieldDescriptor> fields2 = outputPoint.getDescriptorForType().getFields();
    assertEquals(2, fields2.size());
    assertEquals(34, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(6, fields3.size());
    assertFalse(rt.isEmpty());
    assertFalse(hash.iterator().hasNext());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(hash.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    assertTrue(instance2.getAllFields().isEmpty());
    assertTrue(left.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertEquals(hash, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FileOptions options2 = descriptorForType.getFile().getOptions();
    assertEquals(hash, options2.getCsharpNamespaceBytes());
    assertEquals(hash, options2.getJavaOuterClassnameBytes());
    assertEquals(hash, options2.getObjcClassPrefixBytes());
    assertEquals(hash, options2.getPhpClassPrefixBytes());
    assertEquals(hash, options2.getPhpMetadataNamespaceBytes());
    assertEquals(hash, options2.getPhpNamespaceBytes());
    assertEquals(hash, options2.getRubyPackageBytes());
    assertEquals(hash, options2.getSwiftPrefixBytes());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(instance2, defaultInstanceForType.getCursor());
    assertSame(instance2, defaultInstanceForType.getCursorOrBuilder());
    assertSame(instance2, defaultInstanceForType.getTree());
    assertSame(instance2, defaultInstanceForType.getTreeOrBuilder());
    assertSame(outputPoint, defaultInstanceForType.getOutputPoint());
    assertSame(outputPoint, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(outputPoint, outputPoint.getDefaultInstanceForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(hash, fields.get(0).getDefaultValue());
    assertSame(hash, fields3.get(4).getDefaultValue());
    assertSame(hash, fields2.get(0).getDefaultValue());
    assertSame(hash, instance3.getRt());
    assertSame(hash, defaultInstanceForType.getRt());
    assertSame(hash, left.getContent());
    assertArrayEquals(new byte[]{'*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#resetRt()}
   */
  @Test
  public void testResetRt2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());

    // Act
    incrementalMerkleVoucherCapsule.resetRt();

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    ShieldContract.OutputPoint outputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();
    ByteString hash = outputPoint.getHash();
    assertEquals("", hash.toStringUtf8());
    ByteString rt = instance.getRt();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        rt.toStringUtf8());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    ByteString.ByteIterator iteratorResult = rt.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.PedersenHash left = cursor.getLeft();
    List<Descriptors.FieldDescriptor> fields = left.getDescriptorForType().getFields();
    assertEquals(1, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = outputPoint.getDescriptorForType().getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(36, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(6, fields3.size());
    assertFalse(rt.isEmpty());
    assertFalse(hash.iterator().hasNext());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(hash.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    assertTrue(instance2.getAllFields().isEmpty());
    assertTrue(left.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertEquals(hash, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FileOptions options2 = descriptorForType.getFile().getOptions();
    assertEquals(hash, options2.getCsharpNamespaceBytes());
    assertEquals(hash, options2.getJavaOuterClassnameBytes());
    assertEquals(hash, options2.getObjcClassPrefixBytes());
    assertEquals(hash, options2.getPhpClassPrefixBytes());
    assertEquals(hash, options2.getPhpMetadataNamespaceBytes());
    assertEquals(hash, options2.getPhpNamespaceBytes());
    assertEquals(hash, options2.getRubyPackageBytes());
    assertEquals(hash, options2.getSwiftPrefixBytes());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(instance2, defaultInstanceForType.getCursor());
    assertSame(instance2, defaultInstanceForType.getCursorOrBuilder());
    assertSame(instance2, defaultInstanceForType.getTree());
    assertSame(instance2, defaultInstanceForType.getTreeOrBuilder());
    assertSame(outputPoint, defaultInstanceForType.getOutputPoint());
    assertSame(outputPoint, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(outputPoint, outputPoint.getDefaultInstanceForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(hash, fields.get(0).getDefaultValue());
    assertSame(hash, fields3.get(4).getDefaultValue());
    assertSame(hash, fields2.get(0).getDefaultValue());
    assertSame(hash, instance3.getRt());
    assertSame(hash, defaultInstanceForType.getRt());
    assertSame(hash, left.getContent());
    assertArrayEquals(new byte[]{'\n', 0, '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#resetRt()}
   */
  @Test
  public void testResetRt3() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());

    // Act
    incrementalMerkleVoucherCapsule.resetRt();

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    ShieldContract.OutputPoint outputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();
    ByteString hash = outputPoint.getHash();
    assertEquals("", hash.toStringUtf8());
    ByteString rt = instance.getRt();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        rt.toStringUtf8());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    ByteString.ByteIterator iteratorResult = rt.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.PedersenHash left = cursor.getLeft();
    List<Descriptors.FieldDescriptor> fields = left.getDescriptorForType().getFields();
    assertEquals(1, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = outputPoint.getDescriptorForType().getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(36, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(6, fields3.size());
    assertFalse(rt.isEmpty());
    assertFalse(hash.iterator().hasNext());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(hash.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    assertTrue(instance2.getAllFields().isEmpty());
    assertTrue(left.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertEquals(hash, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FileOptions options2 = descriptorForType.getFile().getOptions();
    assertEquals(hash, options2.getCsharpNamespaceBytes());
    assertEquals(hash, options2.getJavaOuterClassnameBytes());
    assertEquals(hash, options2.getObjcClassPrefixBytes());
    assertEquals(hash, options2.getPhpClassPrefixBytes());
    assertEquals(hash, options2.getPhpMetadataNamespaceBytes());
    assertEquals(hash, options2.getPhpNamespaceBytes());
    assertEquals(hash, options2.getRubyPackageBytes());
    assertEquals(hash, options2.getSwiftPrefixBytes());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(instance2, defaultInstanceForType.getCursor());
    assertSame(instance2, defaultInstanceForType.getCursorOrBuilder());
    assertSame(instance2, defaultInstanceForType.getTree());
    assertSame(instance2, defaultInstanceForType.getTreeOrBuilder());
    assertSame(outputPoint, defaultInstanceForType.getOutputPoint());
    assertSame(outputPoint, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(outputPoint, outputPoint.getDefaultInstanceForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(hash, fields.get(0).getDefaultValue());
    assertSame(hash, fields3.get(4).getDefaultValue());
    assertSame(hash, fields2.get(0).getDefaultValue());
    assertSame(hash, instance3.getRt());
    assertSame(hash, defaultInstanceForType.getRt());
    assertSame(hash, left.getContent());
    assertArrayEquals(new byte[]{26, 0, '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#resetRt()}
   */
  @Test
  public void testResetRt4() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(2L);

    // Act
    incrementalMerkleVoucherCapsule.resetRt();

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    ShieldContract.OutputPoint outputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();
    ByteString hash = outputPoint.getHash();
    assertEquals("", hash.toStringUtf8());
    ByteString rt = instance.getRt();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        rt.toStringUtf8());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    ByteString.ByteIterator iteratorResult = rt.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.PedersenHash left = cursor.getLeft();
    List<Descriptors.FieldDescriptor> fields = left.getDescriptorForType().getFields();
    assertEquals(1, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = outputPoint.getDescriptorForType().getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(36, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(6, fields3.size());
    assertFalse(rt.isEmpty());
    assertFalse(hash.iterator().hasNext());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(hash.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    assertTrue(instance2.getAllFields().isEmpty());
    assertTrue(left.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertEquals(hash, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FileOptions options2 = descriptorForType.getFile().getOptions();
    assertEquals(hash, options2.getCsharpNamespaceBytes());
    assertEquals(hash, options2.getJavaOuterClassnameBytes());
    assertEquals(hash, options2.getObjcClassPrefixBytes());
    assertEquals(hash, options2.getPhpClassPrefixBytes());
    assertEquals(hash, options2.getPhpMetadataNamespaceBytes());
    assertEquals(hash, options2.getPhpNamespaceBytes());
    assertEquals(hash, options2.getRubyPackageBytes());
    assertEquals(hash, options2.getSwiftPrefixBytes());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(instance2, defaultInstanceForType.getCursor());
    assertSame(instance2, defaultInstanceForType.getCursorOrBuilder());
    assertSame(instance2, defaultInstanceForType.getTree());
    assertSame(instance2, defaultInstanceForType.getTreeOrBuilder());
    assertSame(outputPoint, defaultInstanceForType.getOutputPoint());
    assertSame(outputPoint, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(outputPoint, outputPoint.getDefaultInstanceForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType2 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(hash, fields.get(0).getDefaultValue());
    assertSame(hash, fields3.get(4).getDefaultValue());
    assertSame(hash, fields2.get(0).getDefaultValue());
    assertSame(hash, instance3.getRt());
    assertSame(hash, defaultInstanceForType.getRt());
    assertSame(hash, left.getContent());
    assertArrayEquals(new byte[]{' ', 2, '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#resetRt()}
   */
  @Test
  public void testResetRt5() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Act
    incrementalMerkleVoucherCapsule.resetRt();

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.PedersenHash left = cursor.getLeft();
    ByteString content = left.getContent();
    assertEquals("", content.toStringUtf8());
    ByteString rt = instance.getRt();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        rt.toStringUtf8());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    ByteString.ByteIterator iteratorResult = rt.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    List<Descriptors.FieldDescriptor> fields = left.getDescriptorForType().getFields();
    assertEquals(1, fields.size());
    ShieldContract.OutputPoint outputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();
    List<Descriptors.FieldDescriptor> fields2 = outputPoint.getDescriptorForType().getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(40, instance.getSerializedSize());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(6, fields3.size());
    assertFalse(rt.isEmpty());
    assertFalse(content.iterator().hasNext());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(content.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    Map<Descriptors.FieldDescriptor, Object> allFields = instance2.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(left.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = descriptorForType.toProto().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    assertEquals(allFields, features.getAllFieldsRaw());
    ShieldContract.IncrementalMerkleVoucher instance3 = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals(instance3,
        incrementalMerkleVoucherCapsule.getTree()
            .toMerkleTreeContainer()
            .toVoucher()
            .getVoucherCapsule()
            .getInstance());
    assertEquals(content, defaultInstanceForType2.getNameBytes());
    DescriptorProtos.FileOptions options2 = descriptorForType.getFile().getOptions();
    assertEquals(content, options2.getCsharpNamespaceBytes());
    assertEquals(content, options2.getJavaOuterClassnameBytes());
    assertEquals(content, options2.getObjcClassPrefixBytes());
    assertEquals(content, options2.getPhpClassPrefixBytes());
    assertEquals(content, options2.getPhpMetadataNamespaceBytes());
    assertEquals(content, options2.getPhpNamespaceBytes());
    assertEquals(content, options2.getRubyPackageBytes());
    assertEquals(content, options2.getSwiftPrefixBytes());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(instance2, defaultInstanceForType.getCursor());
    assertSame(instance2, defaultInstanceForType.getCursorOrBuilder());
    assertSame(instance2, defaultInstanceForType.getTree());
    assertSame(instance2, defaultInstanceForType.getTreeOrBuilder());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType3 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType3, instance3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    ShieldContract.OutputPoint defaultInstanceForType4 = outputPoint.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPoint());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(content, fields.get(0).getDefaultValue());
    assertSame(content, fields3.get(4).getDefaultValue());
    assertSame(content, fields2.get(0).getDefaultValue());
    assertSame(content, instance3.getRt());
    assertSame(content, defaultInstanceForType.getRt());
    assertSame(content, defaultInstanceForType4.getHash());
    assertArrayEquals(new byte[]{'*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  public void testSetOutputPoint() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    ByteString hash = mock(ByteString.class);

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    ShieldContract.OutputPoint outputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();
    ShieldContract.OutputPoint defaultInstanceForType2 = outputPoint.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, outputPoint.getIndex());
    assertEquals(2, outputPoint.getAllFields().size());
    assertEquals(4, outputPoint.getSerializedSize());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType2.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    assertTrue(cursor.getLeft().getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType2.getAllFields().isEmpty());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasOutputPoint());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(defaultInstanceForType2.isInitialized());
    IncrementalMerkleVoucherCapsule voucherCapsule = cursor.toMerkleTreeContainer().toVoucher().getVoucherCapsule();
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    IncrementalMerkleVoucherCapsule voucherCapsule2 = incrementalMerkleVoucherCapsule.getTree()
        .toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    assertEquals(instance2, voucherCapsule2.getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType3 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType3, instance2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    ShieldContract.OutputPoint defaultInstanceForType4 = defaultInstanceForType2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, voucherCapsule.getOutputPoint());
    assertSame(defaultInstanceForType4, voucherCapsule2.getOutputPoint());
    assertSame(defaultInstanceForType4, instance2.getOutputPoint());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPoint());
    assertSame(defaultInstanceForType4, instance2.getOutputPointOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    ByteString byteString = hash.EMPTY;
    assertSame(byteString, defaultInstanceForType.getRt());
    assertSame(byteString, defaultInstanceForType2.getHash());
    assertSame(hash, outputPoint.getHash());
    assertArrayEquals(new byte[]{'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  public void testSetOutputPoint2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    ShieldContract.PedersenHash value = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleVoucherCapsule.addFilled(value);
    ByteString hash = mock(ByteString.class);

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    ShieldContract.OutputPoint outputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();
    ShieldContract.OutputPoint defaultInstanceForType2 = outputPoint.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, outputPoint.getIndex());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(2, outputPoint.getAllFields().size());
    assertEquals(4, outputPoint.getSerializedSize());
    assertEquals(8, instance.getSerializedSize());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType2.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType2.getAllFields().isEmpty());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasOutputPoint());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(defaultInstanceForType2.isInitialized());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    IncrementalMerkleVoucherCapsule voucherCapsule = cursor.toMerkleTreeContainer().toVoucher().getVoucherCapsule();
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    IncrementalMerkleVoucherCapsule voucherCapsule2 = incrementalMerkleVoucherCapsule.getTree()
        .toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    assertEquals(instance2, voucherCapsule2.getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType3 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType3, instance2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    ShieldContract.OutputPoint defaultInstanceForType4 = defaultInstanceForType2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, voucherCapsule.getOutputPoint());
    assertSame(defaultInstanceForType4, voucherCapsule2.getOutputPoint());
    assertSame(defaultInstanceForType4, instance2.getOutputPoint());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPoint());
    assertSame(defaultInstanceForType4, instance2.getOutputPointOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(value, cursor.getLeft());
    ByteString byteString = hash.EMPTY;
    assertSame(byteString, defaultInstanceForType.getRt());
    assertSame(byteString, defaultInstanceForType2.getHash());
    assertSame(hash, outputPoint.getHash());
    assertArrayEquals(new byte[]{18, 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  public void testSetOutputPoint3() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());
    ShieldContract.PedersenHash value = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleVoucherCapsule.addFilled(value);
    ByteString hash = mock(ByteString.class);

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    ShieldContract.OutputPoint outputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();
    ShieldContract.OutputPoint defaultInstanceForType2 = outputPoint.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, outputPoint.getIndex());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(2, outputPoint.getAllFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, outputPoint.getSerializedSize());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType2.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType2.getAllFields().isEmpty());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasOutputPoint());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(defaultInstanceForType2.isInitialized());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    IncrementalMerkleVoucherCapsule voucherCapsule = cursor.toMerkleTreeContainer().toVoucher().getVoucherCapsule();
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    IncrementalMerkleVoucherCapsule voucherCapsule2 = incrementalMerkleVoucherCapsule.getTree()
        .toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    assertEquals(instance2, voucherCapsule2.getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType3 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType3, instance2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    ShieldContract.OutputPoint defaultInstanceForType4 = defaultInstanceForType2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, voucherCapsule.getOutputPoint());
    assertSame(defaultInstanceForType4, voucherCapsule2.getOutputPoint());
    assertSame(defaultInstanceForType4, instance2.getOutputPoint());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPoint());
    assertSame(defaultInstanceForType4, instance2.getOutputPointOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(value, cursor.getLeft());
    ByteString byteString = hash.EMPTY;
    assertSame(byteString, defaultInstanceForType.getRt());
    assertSame(byteString, defaultInstanceForType2.getHash());
    assertSame(hash, outputPoint.getHash());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  public void testSetOutputPoint4() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());
    ShieldContract.PedersenHash value = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleVoucherCapsule.addFilled(value);
    ByteString hash = mock(ByteString.class);

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    ShieldContract.OutputPoint outputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();
    ShieldContract.OutputPoint defaultInstanceForType2 = outputPoint.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, outputPoint.getIndex());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(2, outputPoint.getAllFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, outputPoint.getSerializedSize());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType2.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType2.getAllFields().isEmpty());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasOutputPoint());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(defaultInstanceForType2.isInitialized());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    IncrementalMerkleVoucherCapsule voucherCapsule = cursor.toMerkleTreeContainer().toVoucher().getVoucherCapsule();
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    IncrementalMerkleVoucherCapsule voucherCapsule2 = incrementalMerkleVoucherCapsule.getTree()
        .toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    assertEquals(instance2, voucherCapsule2.getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType3 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType3, instance2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    ShieldContract.OutputPoint defaultInstanceForType4 = defaultInstanceForType2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, voucherCapsule.getOutputPoint());
    assertSame(defaultInstanceForType4, voucherCapsule2.getOutputPoint());
    assertSame(defaultInstanceForType4, instance2.getOutputPoint());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPoint());
    assertSame(defaultInstanceForType4, instance2.getOutputPointOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(value, cursor.getLeft());
    ByteString byteString = hash.EMPTY;
    assertSame(byteString, defaultInstanceForType.getRt());
    assertSame(byteString, defaultInstanceForType2.getHash());
    assertSame(hash, outputPoint.getHash());
    assertArrayEquals(new byte[]{18, 0, 26, 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  public void testSetOutputPoint5() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(2L);
    ShieldContract.PedersenHash value = ShieldContract.PedersenHash.getDefaultInstance();
    incrementalMerkleVoucherCapsule.addFilled(value);
    ByteString hash = mock(ByteString.class);

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    ShieldContract.OutputPoint outputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();
    ShieldContract.OutputPoint defaultInstanceForType2 = outputPoint.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, outputPoint.getIndex());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(2, outputPoint.getAllFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, outputPoint.getSerializedSize());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType2.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType2.getAllFields().isEmpty());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasOutputPoint());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(defaultInstanceForType2.isInitialized());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    IncrementalMerkleVoucherCapsule voucherCapsule = cursor.toMerkleTreeContainer().toVoucher().getVoucherCapsule();
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    IncrementalMerkleVoucherCapsule voucherCapsule2 = incrementalMerkleVoucherCapsule.getTree()
        .toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    assertEquals(instance2, voucherCapsule2.getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType3 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType3, instance2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    ShieldContract.OutputPoint defaultInstanceForType4 = defaultInstanceForType2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, voucherCapsule.getOutputPoint());
    assertSame(defaultInstanceForType4, voucherCapsule2.getOutputPoint());
    assertSame(defaultInstanceForType4, instance2.getOutputPoint());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPoint());
    assertSame(defaultInstanceForType4, instance2.getOutputPointOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(value, cursor.getLeft());
    ByteString byteString = hash.EMPTY;
    assertSame(byteString, defaultInstanceForType.getRt());
    assertSame(byteString, defaultInstanceForType2.getHash());
    assertSame(hash, outputPoint.getHash());
    assertArrayEquals(new byte[]{18, 0, ' ', 2, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  public void testSetOutputPoint6() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());
    ByteString hash = mock(ByteString.class);

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);

    // Assert
    ShieldContract.IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    ShieldContract.OutputPoint outputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();
    ShieldContract.OutputPoint defaultInstanceForType2 = outputPoint.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getIndex());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getCursorDepth());
    assertEquals(1, outputPoint.getIndex());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(2, outputPoint.getAllFields().size());
    assertEquals(4, outputPoint.getSerializedSize());
    assertEquals(8, instance.getSerializedSize());
    assertFalse(defaultInstanceForType.hasCursor());
    assertFalse(defaultInstanceForType.hasOutputPoint());
    assertFalse(defaultInstanceForType.hasTree());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType2.findInitializationErrors().isEmpty());
    IncrementalMerkleTreeCapsule cursor = incrementalMerkleVoucherCapsule.getCursor();
    assertTrue(cursor.getLeft().getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType2.getAllFields().isEmpty());
    Descriptors.Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.getAllFields().isEmpty());
    assertTrue(options.getAllFieldsRaw().isEmpty());
    assertTrue(instance.hasOutputPoint());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(defaultInstanceForType2.isInitialized());
    IncrementalMerkleVoucherCapsule voucherCapsule = cursor.toMerkleTreeContainer().toVoucher().getVoucherCapsule();
    ShieldContract.IncrementalMerkleVoucher instance2 = voucherCapsule.getInstance();
    IncrementalMerkleVoucherCapsule voucherCapsule2 = incrementalMerkleVoucherCapsule.getTree()
        .toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    assertEquals(instance2, voucherCapsule2.getInstance());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    ShieldContract.IncrementalMerkleVoucher defaultInstanceForType3 = defaultInstanceForType
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType3, instance2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    ShieldContract.OutputPoint defaultInstanceForType4 = defaultInstanceForType2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, voucherCapsule.getOutputPoint());
    assertSame(defaultInstanceForType4, voucherCapsule2.getOutputPoint());
    assertSame(defaultInstanceForType4, instance2.getOutputPoint());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPoint());
    assertSame(defaultInstanceForType4, instance2.getOutputPointOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    ByteString byteString = hash.EMPTY;
    assertSame(byteString, defaultInstanceForType.getRt());
    assertSame(byteString, defaultInstanceForType2.getHash());
    assertSame(hash, outputPoint.getHash());
    assertArrayEquals(new byte[]{'\n', 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new IncrementalMerkleVoucherCapsule()).getData().length);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{18, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData3() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData4() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{18, 0, 26, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData5() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(-1L);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{18, 0, ' ', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData6() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, 0, 'R', 2, 16, 1}, actualData);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData7() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, -1);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, 0, 'R', 11, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData8() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 0);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, 0, 'R', 0}, actualData);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData9() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, 0, 18, 0, ' ', 1, 'R', 2, 16, 1}, actualData);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData10() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(Long.MAX_VALUE);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, 0, 18, 0, ' ', -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE, 'R', 2, 16, 1},
        actualData);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData11() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleTreeCapsule merkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    merkleTreeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(merkleTreeCapsule);
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\n', 2, 26, 0, 18, 0, 'R', 2, 16, 1}, actualData);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData12() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleTreeCapsule merkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    merkleTreeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());
    merkleTreeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(merkleTreeCapsule);
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\n', 4, '\n', 0, 26, 0, 18, 0, 'R', 2, 16, 1}, actualData);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  public void testGetData13() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleTreeCapsule merkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    merkleTreeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());
    merkleTreeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(merkleTreeCapsule);
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);
    incrementalMerkleVoucherCapsule.addFilled(ShieldContract.PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\n', 4, 18, 0, 26, 0, 18, 0, 'R', 2, 16, 1}, actualData);
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#toMerkleVoucherContainer()}
   */
  @Test
  public void testToMerkleVoucherContainer() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();

    // Act
    IncrementalMerkleVoucherContainer actualToMerkleVoucherContainerResult = incrementalMerkleVoucherCapsule
        .toMerkleVoucherContainer();

    // Assert
    assertEquals(0, actualToMerkleVoucherContainerResult.size());
    assertSame(incrementalMerkleVoucherCapsule, actualToMerkleVoucherContainerResult.getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#toMerkleVoucherContainer()}
   */
  @Test
  public void testToMerkleVoucherContainer2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Act
    IncrementalMerkleVoucherContainer actualToMerkleVoucherContainerResult = incrementalMerkleVoucherCapsule
        .toMerkleVoucherContainer();

    // Assert
    assertEquals(0, actualToMerkleVoucherContainerResult.size());
    assertSame(incrementalMerkleVoucherCapsule, actualToMerkleVoucherContainerResult.getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(ShieldContract.IncrementalMerkleVoucher)}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule() {
    // Arrange
    ShieldContract.IncrementalMerkleVoucher voucher = ShieldContract.IncrementalMerkleVoucher.getDefaultInstance();

    // Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        voucher);

    // Assert
    IncrementalMerkleTreeCapsule cursor = actualIncrementalMerkleVoucherCapsule.getCursor();
    ShieldContract.IncrementalMerkleVoucher instance = cursor.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule()
        .getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getFilledCount());
    assertEquals(0L, instance.getCursorDepth());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(instance.hasCursor());
    assertFalse(instance.hasOutputPoint());
    assertTrue(instance.hasTree());
    assertTrue(instance.isInitialized());
    ShieldContract.IncrementalMerkleTree instance2 = cursor.getInstance();
    assertSame(instance2, instance.getCursor());
    assertSame(instance2, instance.getCursorOrBuilder());
    assertSame(instance2, instance.getTree());
    assertSame(instance2, instance.getTreeOrBuilder());
    List<ShieldContract.PedersenHash> filled = actualIncrementalMerkleVoucherCapsule.getFilled();
    assertSame(filled, instance.getFilledList());
    assertSame(filled, instance.getFilledOrBuilderList());
    ShieldContract.OutputPoint outputPoint = actualIncrementalMerkleVoucherCapsule.getOutputPoint();
    assertSame(outputPoint, instance.getOutputPoint());
    assertSame(outputPoint, instance.getOutputPointOrBuilder());
    assertSame(voucher, actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(voucher, instance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule2() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule3() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule4() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        "\nXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule5() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule6() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule7() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        " XAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule8() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        "XXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule9() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        "*XAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule10() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule11() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        "RXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule12() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{});

    // Assert
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule13() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule14() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule15() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{18, 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule16() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule17() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule18() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'*', 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule19() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule20() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'R', 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  public void testNewIncrementalMerkleVoucherCapsule21() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'R', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }
}
