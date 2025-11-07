package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.capsule.IncrementalMerkleTreeCapsule;
import org.tron.core.capsule.IncrementalMerkleVoucherCapsule;
import org.tron.core.exception.ZksnarkException;
import org.tron.core.store.IncrementalMerkleTreeStore;
import org.tron.core.store.TreeBlockIndexStore;
import org.tron.protos.contract.ShieldContract;

public class MerkleContainerDiffblueTest {
  /**
   * Method under test: {@link MerkleContainer#getCurrentMerkle()}
   */
  @Test
  public void testGetCurrentMerkle() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(incrementalMerkleTreeCapsule);

    // Act
    IncrementalMerkleTreeContainer actualCurrentMerkle = MerkleContainer
        .createInstance(incrementalMerkleTreeStore, null)
        .getCurrentMerkle();

    // Assert
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    IncrementalMerkleVoucherContainer toVoucherResult = actualCurrentMerkle.toVoucher();
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
    assertEquals(0, actualCurrentMerkle.size());
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = cursor.toMerkleTreeContainer();
    assertEquals(0, toMerkleTreeContainerResult.size());
    IncrementalMerkleTreeCapsule tree = voucherCapsule.getTree();
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult2 = tree.toMerkleTreeContainer();
    assertEquals(0, toMerkleTreeContainerResult2.size());
    assertEquals(0, toVoucherResult.size());
    assertEquals(0, toMerkleTreeContainerResult.toVoucher().size());
    assertEquals(0, toMerkleTreeContainerResult2.toVoucher().size());
    IncrementalMerkleVoucherContainer toMerkleVoucherContainerResult = voucherCapsule.toMerkleVoucherContainer();
    assertEquals(0, toMerkleVoucherContainerResult.size());
    assertEquals(0, instance.getFilledCount());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, outputPoint.getIndex());
    assertEquals(0, outputPoint.getSerializedSize());
    assertEquals(0, cursor.getData().length);
    assertEquals(0, tree.getData().length);
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
    assertSame(incrementalMerkleTreeCapsule, actualCurrentMerkle.getTreeCapsule());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(voucherCapsule, toMerkleVoucherContainerResult.getVoucherCapsule());
    assertSame(cursor, toMerkleTreeContainerResult.getTreeCapsule());
    assertSame(outputPoint, instance.getOutputPoint());
    assertSame(outputPoint, defaultInstanceForType.getOutputPoint());
    assertSame(outputPoint, instance.getOutputPointOrBuilder());
    assertSame(outputPoint, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(outputPoint, outputPoint.getDefaultInstanceForType());
    assertSame(tree, toMerkleTreeContainerResult2.getTreeCapsule());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\n', 0}, voucherCapsule.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCurrentMerkle.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult2.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCurrentMerkle.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult2.getRootArray());
  }

  /**
   * Method under test: {@link MerkleContainer#getCurrentMerkle()}
   */
  @Test
  public void testGetCurrentMerkle2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(incrementalMerkleTreeCapsule);

    // Act
    IncrementalMerkleTreeContainer actualCurrentMerkle = MerkleContainer
        .createInstance(incrementalMerkleTreeStore, null)
        .getCurrentMerkle();

    // Assert
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    assertSame(incrementalMerkleTreeContainer, actualCurrentMerkle);
  }

  /**
   * Method under test:
   * {@link MerkleContainer#setCurrentMerkle(IncrementalMerkleTreeContainer)}
   */
  @Test
  public void testSetCurrentMerkle() {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    doNothing().when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    merkleContainer.setCurrentMerkle(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));

    // Assert that nothing has changed
    verify(incrementalMerkleTreeStore).put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
  }

  /**
   * Method under test: {@link MerkleContainer#getBestMerkle()}
   */
  @Test
  public void testGetBestMerkle() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(incrementalMerkleTreeCapsule);

    // Act
    IncrementalMerkleTreeContainer actualBestMerkle = MerkleContainer.createInstance(incrementalMerkleTreeStore, null)
        .getBestMerkle();

    // Assert
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    IncrementalMerkleVoucherContainer toVoucherResult = actualBestMerkle.toVoucher();
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
    assertEquals(0, actualBestMerkle.size());
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = cursor.toMerkleTreeContainer();
    assertEquals(0, toMerkleTreeContainerResult.size());
    IncrementalMerkleTreeCapsule tree = voucherCapsule.getTree();
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult2 = tree.toMerkleTreeContainer();
    assertEquals(0, toMerkleTreeContainerResult2.size());
    assertEquals(0, toVoucherResult.size());
    assertEquals(0, toMerkleTreeContainerResult.toVoucher().size());
    assertEquals(0, toMerkleTreeContainerResult2.toVoucher().size());
    IncrementalMerkleVoucherContainer toMerkleVoucherContainerResult = voucherCapsule.toMerkleVoucherContainer();
    assertEquals(0, toMerkleVoucherContainerResult.size());
    assertEquals(0, instance.getFilledCount());
    assertEquals(0, defaultInstanceForType.getFilledCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, outputPoint.getIndex());
    assertEquals(0, outputPoint.getSerializedSize());
    assertEquals(0, cursor.getData().length);
    assertEquals(0, tree.getData().length);
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
    assertSame(incrementalMerkleTreeCapsule, actualBestMerkle.getTreeCapsule());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(voucherCapsule, toMerkleVoucherContainerResult.getVoucherCapsule());
    assertSame(cursor, toMerkleTreeContainerResult.getTreeCapsule());
    assertSame(outputPoint, instance.getOutputPoint());
    assertSame(outputPoint, defaultInstanceForType.getOutputPoint());
    assertSame(outputPoint, instance.getOutputPointOrBuilder());
    assertSame(outputPoint, defaultInstanceForType.getOutputPointOrBuilder());
    assertSame(outputPoint, outputPoint.getDefaultInstanceForType());
    assertSame(tree, toMerkleTreeContainerResult2.getTreeCapsule());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\n', 0}, voucherCapsule.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualBestMerkle.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult2.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualBestMerkle.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult2.getRootArray());
  }

  /**
   * Method under test: {@link MerkleContainer#getBestMerkle()}
   */
  @Test
  public void testGetBestMerkle2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(incrementalMerkleTreeCapsule);

    // Act
    IncrementalMerkleTreeContainer actualBestMerkle = MerkleContainer.createInstance(incrementalMerkleTreeStore, null)
        .getBestMerkle();

    // Assert
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    assertSame(incrementalMerkleTreeContainer, actualBestMerkle);
  }

  /**
   * Method under test: {@link MerkleContainer#resetCurrentMerkleTree()}
   */
  @Test
  public void testResetCurrentMerkleTree() {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(new IncrementalMerkleTreeCapsule());
    doNothing().when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    // Act
    MerkleContainer.createInstance(incrementalMerkleTreeStore, null).resetCurrentMerkleTree();

    // Assert
    verify(incrementalMerkleTreeStore).put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
  }

  /**
   * Method under test: {@link MerkleContainer#resetCurrentMerkleTree()}
   */
  @Test
  public void testResetCurrentMerkleTree2() {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(null);
    doNothing().when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    // Act
    MerkleContainer.createInstance(incrementalMerkleTreeStore, null).resetCurrentMerkleTree();

    // Assert
    verify(incrementalMerkleTreeStore).put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
  }

  /**
   * Method under test: {@link MerkleContainer#resetCurrentMerkleTree()}
   */
  @Test
  public void testResetCurrentMerkleTree3() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(incrementalMerkleTreeCapsule);
    doNothing().when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    // Act
    MerkleContainer.createInstance(incrementalMerkleTreeStore, null).resetCurrentMerkleTree();

    // Assert that nothing has changed
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(incrementalMerkleTreeStore).put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link MerkleContainer#saveCurrentMerkleTreeAsBestMerkleTree(long)}
   */
  @Test
  public void testSaveCurrentMerkleTreeAsBestMerkleTree() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = mock(IncrementalMerkleTreeContainer.class);
    when(incrementalMerkleTreeContainer.getMerkleTreeKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(incrementalMerkleTreeContainer.getTreeCapsule()).thenReturn(new IncrementalMerkleTreeCapsule());
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(incrementalMerkleTreeCapsule);
    doNothing().when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());
    TreeBlockIndexStore merkleTreeIndexStore = mock(TreeBlockIndexStore.class);
    doNothing().when(merkleTreeIndexStore).put(anyLong(), Mockito.<byte[]>any());

    // Act
    MerkleContainer.createInstance(incrementalMerkleTreeStore, merkleTreeIndexStore)
        .saveCurrentMerkleTreeAsBestMerkleTree(1L);

    // Assert that nothing has changed
    verify(incrementalMerkleTreeContainer, atLeast(1)).getMerkleTreeKey();
    verify(incrementalMerkleTreeContainer, atLeast(1)).getTreeCapsule();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(incrementalMerkleTreeStore, atLeast(1)).put(Mockito.<byte[]>any(), isA(IncrementalMerkleTreeCapsule.class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    verify(merkleTreeIndexStore).put(eq(1L), isA(byte[].class));
  }

  /**
   * Method under test: {@link MerkleContainer#merkleRootExist(byte[])}
   */
  @Test
  public void testMerkleRootExist() throws UnsupportedEncodingException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.contain(Mockito.<byte[]>any())).thenReturn(true);
    MerkleContainer createInstanceResult = MerkleContainer.createInstance(incrementalMerkleTreeStore, null);

    // Act
    boolean actualMerkleRootExistResult = createInstanceResult.merkleRootExist("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(incrementalMerkleTreeStore).contain(isA(byte[].class));
    assertTrue(actualMerkleRootExistResult);
  }

  /**
   * Method under test: {@link MerkleContainer#merkleRootExist(byte[])}
   */
  @Test
  public void testMerkleRootExist2() throws UnsupportedEncodingException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.contain(Mockito.<byte[]>any())).thenReturn(false);
    MerkleContainer createInstanceResult = MerkleContainer.createInstance(incrementalMerkleTreeStore, null);

    // Act
    boolean actualMerkleRootExistResult = createInstanceResult.merkleRootExist("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(incrementalMerkleTreeStore).contain(isA(byte[].class));
    assertFalse(actualMerkleRootExistResult);
  }

  /**
   * Method under test: {@link MerkleContainer#getMerkleTree(byte[])}
   */
  @Test
  public void testGetMerkleTree() throws UnsupportedEncodingException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(incrementalMerkleTreeCapsule);
    MerkleContainer createInstanceResult = MerkleContainer.createInstance(incrementalMerkleTreeStore, null);

    // Act
    IncrementalMerkleTreeCapsule actualMerkleTree = createInstanceResult.getMerkleTree("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    assertSame(incrementalMerkleTreeCapsule, actualMerkleTree);
  }

  /**
   * Method under test:
   * {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}
   */
  @Test
  public void testSaveCmIntoMerkleTree() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    MerkleContainer merkleContainer = new MerkleContainer();
    IncrementalMerkleTreeContainer tree = new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());

    // Act and Assert
    assertSame(tree, merkleContainer.saveCmIntoMerkleTree(tree, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}
   */
  @Test
  public void testSaveCmIntoMerkleTree2() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    MerkleContainer merkleContainer = new MerkleContainer();

    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());
    IncrementalMerkleTreeContainer tree = new IncrementalMerkleTreeContainer(treeCapsule);

    // Act and Assert
    assertSame(tree, merkleContainer.saveCmIntoMerkleTree(tree, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}
   */
  @Test
  public void testSaveCmIntoMerkleTree3() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    MerkleContainer merkleContainer = new MerkleContainer();

    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());
    IncrementalMerkleTreeContainer tree = new IncrementalMerkleTreeContainer(treeCapsule);

    // Act and Assert
    assertSame(tree, merkleContainer.saveCmIntoMerkleTree(tree, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}
   */
  @Test
  public void testSaveCmIntoMerkleTree4() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    MerkleContainer merkleContainer = new MerkleContainer();

    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());
    IncrementalMerkleTreeContainer tree = new IncrementalMerkleTreeContainer(treeCapsule);

    // Act and Assert
    assertSame(tree, merkleContainer.saveCmIntoMerkleTree(tree, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}
   */
  @Test
  public void testSaveCmIntoMerkleTree5() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    MerkleContainer merkleContainer = new MerkleContainer();

    IncrementalMerkleTreeContainer tree = new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    tree.append(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertSame(tree, merkleContainer.saveCmIntoMerkleTree(tree, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link MerkleContainer#merklePath(byte[])}
   */
  @Test
  public void testMerklePath() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = mock(IncrementalMerkleTreeContainer.class);
    ArrayList<List<Boolean>> authenticationPath = new ArrayList<>();
    MerklePath merklePath = new MerklePath(authenticationPath, new ArrayList<>());

    when(incrementalMerkleTreeContainer.path()).thenReturn(merklePath);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(incrementalMerkleTreeCapsule);
    when(incrementalMerkleTreeStore.contain(Mockito.<byte[]>any())).thenReturn(true);
    MerkleContainer createInstanceResult = MerkleContainer.createInstance(incrementalMerkleTreeStore, null);

    // Act
    MerklePath actualMerklePathResult = createInstanceResult.merklePath("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(incrementalMerkleTreeContainer).path();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(incrementalMerkleTreeStore).contain(isA(byte[].class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    assertSame(merklePath, actualMerklePathResult);
  }

  /**
   * Method under test: {@link MerkleContainer#merklePath(byte[])}
   */
  @Test
  public void testMerklePath2() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.contain(Mockito.<byte[]>any())).thenReturn(false);
    MerkleContainer createInstanceResult = MerkleContainer.createInstance(incrementalMerkleTreeStore, null);

    // Act
    MerklePath actualMerklePathResult = createInstanceResult.merklePath("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(incrementalMerkleTreeStore).contain(isA(byte[].class));
    assertNull(actualMerklePathResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MerkleContainer}
   *   <li>{@link MerkleContainer#getIncrementalMerkleTreeStore()}
   *   <li>{@link MerkleContainer#getMerkleTreeIndexStore()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MerkleContainer actualMerkleContainer = new MerkleContainer();
    IncrementalMerkleTreeStore actualIncrementalMerkleTreeStore = actualMerkleContainer.getIncrementalMerkleTreeStore();

    // Assert
    assertNull(actualIncrementalMerkleTreeStore);
    assertNull(actualMerkleContainer.getMerkleTreeIndexStore());
  }
}
