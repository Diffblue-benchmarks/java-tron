package org.tron.core.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSet;
import com.google.protobuf.DescriptorProtos.FieldOptions;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ResourceReceipt;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Result;
import org.tron.protos.Protocol.Transaction.Result.contractResult;

public class ReceiptCapsuleDiffblueTest {
  /**
   * Test {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)}.
   * <ul>
   *   <li>When {@link BlockId#BlockId()}.</li>
   *   <li>Then return ReceiptAddress is {@link BlockId#BlockId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.<init>(Sha256Hash)"})
  public void testNewReceiptCapsule_whenBlockId_thenReturnReceiptAddressIsBlockId() {
    // Arrange
    BlockId receiptAddress = new BlockId();

    // Act
    ReceiptCapsule actualReceiptCapsule = new ReceiptCapsule(receiptAddress);

    // Assert
    ResourceReceipt receipt = actualReceiptCapsule.getReceipt();
    assertEquals(receipt, receipt.getDefaultInstanceForType());
    assertSame(receiptAddress, actualReceiptCapsule.getReceiptAddress());
    UnknownFieldSet unknownFields = receipt.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ReceiptAddress is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.<init>(Sha256Hash)"})
  public void testNewReceiptCapsule_whenNull_thenReturnReceiptAddressIsNull() {
    // Arrange and Act
    ReceiptCapsule actualReceiptCapsule = new ReceiptCapsule(null);

    // Assert
    assertNull(actualReceiptCapsule.getReceiptAddress());
    ResourceReceipt receipt = actualReceiptCapsule.getReceipt();
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
    assertEquals(receipt, receipt.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = receipt.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}.
   * <ul>
   *   <li>Then return EnergyFee is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceReceipt ReceiptCapsule.copyReceipt(ReceiptCapsule)"})
  public void testCopyReceipt_thenReturnEnergyFeeIsOne() {
    // Arrange
    ReceiptCapsule origin = new ReceiptCapsule(null);
    origin.setEnergyFee(1L);

    // Act
    ResourceReceipt actualCopyReceiptResult = ReceiptCapsule.copyReceipt(origin);

    // Assert
    assertEquals(0L, actualCopyReceiptResult.getEnergyPenaltyTotal());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsage());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsageTotal());
    assertEquals(0L, actualCopyReceiptResult.getNetFee());
    assertEquals(0L, actualCopyReceiptResult.getNetUsage());
    assertEquals(0L, actualCopyReceiptResult.getOriginEnergyUsage());
    assertEquals(1L, actualCopyReceiptResult.getEnergyFee());
  }

  /**
   * Test {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}.
   * <ul>
   *   <li>Then return EnergyPenaltyTotal is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceReceipt ReceiptCapsule.copyReceipt(ReceiptCapsule)"})
  public void testCopyReceipt_thenReturnEnergyPenaltyTotalIsOne() {
    // Arrange
    ReceiptCapsule origin = new ReceiptCapsule(null);
    origin.setEnergyPenaltyTotal(1L);

    // Act
    ResourceReceipt actualCopyReceiptResult = ReceiptCapsule.copyReceipt(origin);

    // Assert
    assertEquals(0L, actualCopyReceiptResult.getEnergyFee());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsage());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsageTotal());
    assertEquals(0L, actualCopyReceiptResult.getNetFee());
    assertEquals(0L, actualCopyReceiptResult.getNetUsage());
    assertEquals(0L, actualCopyReceiptResult.getOriginEnergyUsage());
    assertEquals(1L, actualCopyReceiptResult.getEnergyPenaltyTotal());
  }

  /**
   * Test {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}.
   * <ul>
   *   <li>Then return EnergyUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceReceipt ReceiptCapsule.copyReceipt(ReceiptCapsule)"})
  public void testCopyReceipt_thenReturnEnergyUsageIsOne() {
    // Arrange
    ReceiptCapsule origin = new ReceiptCapsule(null);
    origin.setEnergyUsage(1L);

    // Act
    ResourceReceipt actualCopyReceiptResult = ReceiptCapsule.copyReceipt(origin);

    // Assert
    assertEquals(0L, actualCopyReceiptResult.getEnergyFee());
    assertEquals(0L, actualCopyReceiptResult.getEnergyPenaltyTotal());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsageTotal());
    assertEquals(0L, actualCopyReceiptResult.getNetFee());
    assertEquals(0L, actualCopyReceiptResult.getNetUsage());
    assertEquals(0L, actualCopyReceiptResult.getOriginEnergyUsage());
    assertEquals(1L, actualCopyReceiptResult.getEnergyUsage());
  }

  /**
   * Test {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}.
   * <ul>
   *   <li>Then return EnergyUsageTotal is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceReceipt ReceiptCapsule.copyReceipt(ReceiptCapsule)"})
  public void testCopyReceipt_thenReturnEnergyUsageTotalIsOne() {
    // Arrange
    ReceiptCapsule origin = new ReceiptCapsule(null);
    origin.setEnergyUsageTotal(1L);

    // Act
    ResourceReceipt actualCopyReceiptResult = ReceiptCapsule.copyReceipt(origin);

    // Assert
    assertEquals(0L, actualCopyReceiptResult.getEnergyFee());
    assertEquals(0L, actualCopyReceiptResult.getEnergyPenaltyTotal());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsage());
    assertEquals(0L, actualCopyReceiptResult.getNetFee());
    assertEquals(0L, actualCopyReceiptResult.getNetUsage());
    assertEquals(0L, actualCopyReceiptResult.getOriginEnergyUsage());
    assertEquals(1L, actualCopyReceiptResult.getEnergyUsageTotal());
  }

  /**
   * Test {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}.
   * <ul>
   *   <li>Then return NetFee is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceReceipt ReceiptCapsule.copyReceipt(ReceiptCapsule)"})
  public void testCopyReceipt_thenReturnNetFeeIsOne() {
    // Arrange
    ReceiptCapsule origin = new ReceiptCapsule(null);
    origin.addNetFee(1L);

    // Act
    ResourceReceipt actualCopyReceiptResult = ReceiptCapsule.copyReceipt(origin);

    // Assert
    assertEquals(0L, actualCopyReceiptResult.getEnergyFee());
    assertEquals(0L, actualCopyReceiptResult.getEnergyPenaltyTotal());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsage());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsageTotal());
    assertEquals(0L, actualCopyReceiptResult.getNetUsage());
    assertEquals(0L, actualCopyReceiptResult.getOriginEnergyUsage());
    assertEquals(1L, actualCopyReceiptResult.getNetFee());
  }

  /**
   * Test {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}.
   * <ul>
   *   <li>Then return NetUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceReceipt ReceiptCapsule.copyReceipt(ReceiptCapsule)"})
  public void testCopyReceipt_thenReturnNetUsageIsOne() {
    // Arrange
    ReceiptCapsule origin = new ReceiptCapsule(null);
    origin.setNetUsage(1L);

    // Act
    ResourceReceipt actualCopyReceiptResult = ReceiptCapsule.copyReceipt(origin);

    // Assert
    assertEquals(0L, actualCopyReceiptResult.getEnergyFee());
    assertEquals(0L, actualCopyReceiptResult.getEnergyPenaltyTotal());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsage());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsageTotal());
    assertEquals(0L, actualCopyReceiptResult.getNetFee());
    assertEquals(0L, actualCopyReceiptResult.getOriginEnergyUsage());
    assertEquals(1L, actualCopyReceiptResult.getNetUsage());
  }

  /**
   * Test {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}.
   * <ul>
   *   <li>Then return OriginEnergyUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceReceipt ReceiptCapsule.copyReceipt(ReceiptCapsule)"})
  public void testCopyReceipt_thenReturnOriginEnergyUsageIsOne() {
    // Arrange
    ReceiptCapsule origin = new ReceiptCapsule(null);
    origin.setOriginEnergyUsage(1L);

    // Act
    ResourceReceipt actualCopyReceiptResult = ReceiptCapsule.copyReceipt(origin);

    // Assert
    assertEquals(0L, actualCopyReceiptResult.getEnergyFee());
    assertEquals(0L, actualCopyReceiptResult.getEnergyPenaltyTotal());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsage());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsageTotal());
    assertEquals(0L, actualCopyReceiptResult.getNetFee());
    assertEquals(0L, actualCopyReceiptResult.getNetUsage());
    assertEquals(1L, actualCopyReceiptResult.getOriginEnergyUsage());
  }

  /**
   * Test {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceReceipt ReceiptCapsule.copyReceipt(ReceiptCapsule)"})
  public void testCopyReceipt_thenReturnSerializedSizeIsZero() {
    // Arrange and Act
    ResourceReceipt actualCopyReceiptResult = ReceiptCapsule.copyReceipt(new ReceiptCapsule(null));

    // Assert
    assertEquals(0, actualCopyReceiptResult.getSerializedSize());
    Descriptor descriptorForType = actualCopyReceiptResult.getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    Map<FieldDescriptor, Object> allFields = actualCopyReceiptResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertEquals(allFields, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(allFields, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(allFields, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(allFields, features.getAllFields());
    FieldOptions options = fields.get(0).getOptions();
    assertEquals(allFields, options.getAllFields());
    assertEquals(allFields, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(allFields, features.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualCopyReceiptResult, actualCopyReceiptResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ReceiptCapsule#checkForEnergyLimit(DynamicPropertiesStore)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#checkForEnergyLimit(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReceiptCapsule.checkForEnergyLimit(DynamicPropertiesStore)"})
  public void testCheckForEnergyLimit_givenMinusOne_thenReturnFalse() {
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
   * Test {@link ReceiptCapsule#checkForEnergyLimit(DynamicPropertiesStore)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#checkForEnergyLimit(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReceiptCapsule.checkForEnergyLimit(DynamicPropertiesStore)"})
  public void testCheckForEnergyLimit_givenOne_thenReturnTrue() {
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
   * Test {@link ReceiptCapsule#addNetFee(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#addNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.addNetFee(long)"})
  public void testAddNetFee() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.addNetFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(2L, receiptCapsule.getNetFee());
    assertEquals(2L, receipt.getNetFee());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#addNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyFee is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#addNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.addNetFee(long)"})
  public void testAddNetFee_givenReceiptCapsuleWithReceiptAddressIsNullEnergyFeeIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyFee(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.addNetFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(2L, receiptCapsule.getNetFee());
    assertEquals(2L, receipt.getNetFee());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#addNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyPenaltyTotal is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#addNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.addNetFee(long)"})
  public void testAddNetFee_givenReceiptCapsuleWithReceiptAddressIsNullEnergyPenaltyTotalIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyPenaltyTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.addNetFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(2L, receiptCapsule.getNetFee());
    assertEquals(2L, receipt.getNetFee());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#addNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#addNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.addNetFee(long)"})
  public void testAddNetFee_givenReceiptCapsuleWithReceiptAddressIsNullEnergyUsageIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.addNetFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(2L, receiptCapsule.getNetFee());
    assertEquals(2L, receipt.getNetFee());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#addNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyUsageTotal is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#addNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.addNetFee(long)"})
  public void testAddNetFee_givenReceiptCapsuleWithReceiptAddressIsNullEnergyUsageTotalIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsageTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.addNetFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(2L, receiptCapsule.getNetFee());
    assertEquals(2L, receipt.getNetFee());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#addNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} NetUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#addNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.addNetFee(long)"})
  public void testAddNetFee_givenReceiptCapsuleWithReceiptAddressIsNullNetUsageIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setNetUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.addNetFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(2L, receiptCapsule.getNetFee());
    assertEquals(2L, receipt.getNetFee());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#addNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} OriginEnergyUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#addNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.addNetFee(long)"})
  public void testAddNetFee_givenReceiptCapsuleWithReceiptAddressIsNullOriginEnergyUsageIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setOriginEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.addNetFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(2L, receiptCapsule.getNetFee());
    assertEquals(2L, receipt.getNetFee());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#addNetFee(long)}.
   * <ul>
   *   <li>Then {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} NetFee is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#addNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.addNetFee(long)"})
  public void testAddNetFee_thenReceiptCapsuleWithReceiptAddressIsNullNetFeeIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.addNetFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getNetFee());
    assertEquals(1L, receipt.getNetFee());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getEnergyUsage()}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#getEnergyUsage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ReceiptCapsule.getEnergyUsage()"})
  public void testGetEnergyUsage_givenReceiptCapsuleWithReceiptAddressIsNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getEnergyUsage());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage2() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setOriginEnergyUsage(1L);

    // Act
    receiptCapsule.setEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage3() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsageTotal(1L);

    // Act
    receiptCapsule.setEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage4() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyPenaltyTotal(1L);

    // Act
    receiptCapsule.setEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsage(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} addNetFee one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage_givenReceiptCapsuleWithReceiptAddressIsNullAddNetFeeOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsage(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyFee is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage_givenReceiptCapsuleWithReceiptAddressIsNullEnergyFeeIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyFee(1L);

    // Act
    receiptCapsule.setEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsage(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} NetUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage_givenReceiptCapsuleWithReceiptAddressIsNullNetUsageIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setNetUsage(1L);

    // Act
    receiptCapsule.setEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getEnergyFee()}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#getEnergyFee()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ReceiptCapsule.getEnergyFee()"})
  public void testGetEnergyFee_givenReceiptCapsuleWithReceiptAddressIsNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getEnergyFee());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyFee(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyFee(long)"})
  public void testSetEnergyFee() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setEnergyFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyFee(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyFee(long)"})
  public void testSetEnergyFee2() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyFee(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyFee(long)"})
  public void testSetEnergyFee3() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setOriginEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyFee(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyFee(long)"})
  public void testSetEnergyFee4() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsageTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyFee(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyFee(long)"})
  public void testSetEnergyFee5() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyPenaltyTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyFee(long)"})
  public void testSetEnergyFee_givenReceiptCapsuleWithReceiptAddressIsNullEnergyUsageIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} NetUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyFee(long)"})
  public void testSetEnergyFee_givenReceiptCapsuleWithReceiptAddressIsNullNetUsageIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setNetUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getOriginEnergyUsage()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#getOriginEnergyUsage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ReceiptCapsule.getOriginEnergyUsage()"})
  public void testGetOriginEnergyUsage_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getOriginEnergyUsage());
  }

  /**
   * Test {@link ReceiptCapsule#setOriginEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setOriginEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setOriginEnergyUsage(long)"})
  public void testSetOriginEnergyUsage() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setOriginEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setOriginEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setOriginEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setOriginEnergyUsage(long)"})
  public void testSetOriginEnergyUsage2() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setOriginEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setOriginEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setOriginEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setOriginEnergyUsage(long)"})
  public void testSetOriginEnergyUsage3() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setOriginEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setOriginEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setOriginEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setOriginEnergyUsage(long)"})
  public void testSetOriginEnergyUsage4() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyFee(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setOriginEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setOriginEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setOriginEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setOriginEnergyUsage(long)"})
  public void testSetOriginEnergyUsage5() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsageTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setOriginEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setOriginEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setOriginEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setOriginEnergyUsage(long)"})
  public void testSetOriginEnergyUsage6() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyPenaltyTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setOriginEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setOriginEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setOriginEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setOriginEnergyUsage(long)"})
  public void testSetOriginEnergyUsage7() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setNetUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setOriginEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getEnergyUsageTotal()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#getEnergyUsageTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ReceiptCapsule.getEnergyUsageTotal()"})
  public void testGetEnergyUsageTotal_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getEnergyUsageTotal());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsageTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsageTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsageTotal(long)"})
  public void testSetEnergyUsageTotal() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setEnergyUsageTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsageTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsageTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsageTotal(long)"})
  public void testSetEnergyUsageTotal2() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyUsageTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsageTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsageTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsageTotal(long)"})
  public void testSetEnergyUsageTotal3() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyUsageTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsageTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsageTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsageTotal(long)"})
  public void testSetEnergyUsageTotal4() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyFee(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyUsageTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsageTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsageTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsageTotal(long)"})
  public void testSetEnergyUsageTotal5() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setOriginEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyUsageTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsageTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsageTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsageTotal(long)"})
  public void testSetEnergyUsageTotal6() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyPenaltyTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyUsageTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsageTotal(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} NetUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyUsageTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsageTotal(long)"})
  public void testSetEnergyUsageTotal_givenReceiptCapsuleWithReceiptAddressIsNullNetUsageIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setNetUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyUsageTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getEnergyPenaltyTotal()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#getEnergyPenaltyTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ReceiptCapsule.getEnergyPenaltyTotal()"})
  public void testGetEnergyPenaltyTotal_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getEnergyPenaltyTotal());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyPenaltyTotal(long)"})
  public void testSetEnergyPenaltyTotal() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setEnergyPenaltyTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyPenaltyTotal(long)"})
  public void testSetEnergyPenaltyTotal2() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyPenaltyTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyPenaltyTotal(long)"})
  public void testSetEnergyPenaltyTotal3() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyPenaltyTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyPenaltyTotal(long)"})
  public void testSetEnergyPenaltyTotal4() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyFee(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyPenaltyTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyPenaltyTotal(long)"})
  public void testSetEnergyPenaltyTotal5() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setOriginEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyPenaltyTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyPenaltyTotal(long)"})
  public void testSetEnergyPenaltyTotal6() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsageTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyPenaltyTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyPenaltyTotal(long)"})
  public void testSetEnergyPenaltyTotal7() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setNetUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setEnergyPenaltyTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getNetUsage()}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#getNetUsage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ReceiptCapsule.getNetUsage()"})
  public void testGetNetUsage_givenReceiptCapsuleWithReceiptAddressIsNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getNetUsage());
  }

  /**
   * Test {@link ReceiptCapsule#setNetUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetUsage(long)"})
  public void testSetNetUsage() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setNetUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetUsage(long)"})
  public void testSetNetUsage2() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetUsage(long)"})
  public void testSetNetUsage3() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setOriginEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetUsage(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetUsage(long)"})
  public void testSetNetUsage4() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyPenaltyTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetUsage(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyFee is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetUsage(long)"})
  public void testSetNetUsage_givenReceiptCapsuleWithReceiptAddressIsNullEnergyFeeIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyFee(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetUsage(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetUsage(long)"})
  public void testSetNetUsage_givenReceiptCapsuleWithReceiptAddressIsNullEnergyUsageIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetUsage(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyUsageTotal is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetUsage(long)"})
  public void testSetNetUsage_givenReceiptCapsuleWithReceiptAddressIsNullEnergyUsageTotalIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsageTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(3, receipt.getAllFields().size());
    assertEquals(6, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getNetFee()}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#getNetFee()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ReceiptCapsule.getNetFee()"})
  public void testGetNetFee_givenReceiptCapsuleWithReceiptAddressIsNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ReceiptCapsule(null)).getNetFee());
  }

  /**
   * Test {@link ReceiptCapsule#setNetFee(long)}.
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetFee(long)"})
  public void testSetNetFee() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetFee(1L);

    // Assert that nothing has changed
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getNetFee());
    assertEquals(1L, receipt.getNetFee());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetFee(long)"})
  public void testSetNetFee_givenReceiptCapsuleWithReceiptAddressIsNull() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);

    // Act
    receiptCapsule.setNetFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getNetFee());
    assertEquals(1L, receipt.getNetFee());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyFee is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetFee(long)"})
  public void testSetNetFee_givenReceiptCapsuleWithReceiptAddressIsNullEnergyFeeIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyFee(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetFee(1L);

    // Assert that nothing has changed
    assertEquals(1L, receiptCapsule.getNetFee());
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1L, receipt.getNetFee());
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyPenaltyTotal is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetFee(long)"})
  public void testSetNetFee_givenReceiptCapsuleWithReceiptAddressIsNullEnergyPenaltyTotalIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyPenaltyTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetFee(1L);

    // Assert that nothing has changed
    assertEquals(1L, receiptCapsule.getNetFee());
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1L, receipt.getNetFee());
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetFee(long)"})
  public void testSetNetFee_givenReceiptCapsuleWithReceiptAddressIsNullEnergyUsageIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetFee(1L);

    // Assert that nothing has changed
    assertEquals(1L, receiptCapsule.getNetFee());
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1L, receipt.getNetFee());
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} EnergyUsageTotal is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetFee(long)"})
  public void testSetNetFee_givenReceiptCapsuleWithReceiptAddressIsNullEnergyUsageTotalIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setEnergyUsageTotal(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetFee(1L);

    // Assert that nothing has changed
    assertEquals(1L, receiptCapsule.getNetFee());
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1L, receipt.getNetFee());
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} NetUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetFee(long)"})
  public void testSetNetFee_givenReceiptCapsuleWithReceiptAddressIsNullNetUsageIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setNetUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetFee(1L);

    // Assert that nothing has changed
    assertEquals(1L, receiptCapsule.getNetFee());
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1L, receipt.getNetFee());
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#setNetFee(long)}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null} OriginEnergyUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#setNetFee(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiptCapsule.setNetFee(long)"})
  public void testSetNetFee_givenReceiptCapsuleWithReceiptAddressIsNullOriginEnergyUsageIsOne() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(null);
    receiptCapsule.setOriginEnergyUsage(1L);
    receiptCapsule.addNetFee(1L);

    // Act
    receiptCapsule.setNetFee(1L);

    // Assert that nothing has changed
    assertEquals(1L, receiptCapsule.getNetFee());
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1L, receipt.getNetFee());
    assertEquals(2, receipt.getAllFields().size());
    assertEquals(4, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getResult()}.
   * <ul>
   *   <li>Given {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)} with receiptAddress is {@code null}.</li>
   *   <li>Then return {@code DEFAULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiptCapsule#getResult()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"contractResult ReceiptCapsule.getResult()"})
  public void testGetResult_givenReceiptCapsuleWithReceiptAddressIsNull_thenReturnDefault() {
    // Arrange, Act and Assert
    assertEquals(contractResult.DEFAULT, (new ReceiptCapsule(null)).getResult());
  }
}
