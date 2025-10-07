package org.tron.core.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.ResourceReceipt;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Result;
import org.tron.protos.Protocol.Transaction.Result.contractResult;

public class ReceiptCapsuleDiffblueTest {
  /**
   * Test {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ReceiptAddress is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiptCapsule.<init>(Sha256Hash)"})
  public void testNewReceiptCapsule_whenNull_thenReturnReceiptAddressIsNull() {
    // Arrange and Act
    ReceiptCapsule actualReceiptCapsule = new ReceiptCapsule(null);

    // Assert
    assertNull(actualReceiptCapsule.getReceiptAddress());
    ResourceReceipt receipt = actualReceiptCapsule.getReceipt();
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
    ResourceReceipt actualDefaultInstanceForType = receipt.getDefaultInstanceForType();
    assertEquals(receipt, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = receipt.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
  }

  /**
   * Test {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)}.
   *
   * <ul>
   *   <li>When {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then return ReceiptAddress is {@link Sha256Hash#ZERO_HASH}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiptCapsule#ReceiptCapsule(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiptCapsule.<init>(Sha256Hash)"})
  public void testNewReceiptCapsule_whenZero_hash_thenReturnReceiptAddressIsZero_hash() {
    // Arrange and Act
    ReceiptCapsule actualReceiptCapsule = new ReceiptCapsule(Sha256Hash.ZERO_HASH);

    // Assert
    ResourceReceipt receipt = actualReceiptCapsule.getReceipt();
    ResourceReceipt actualDefaultInstanceForType = receipt.getDefaultInstanceForType();
    assertEquals(receipt, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = receipt.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    assertSame(Sha256Hash.ZERO_HASH, actualReceiptCapsule.getReceiptAddress());
  }

  /**
   * Test {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ReceiptCapsule#copyReceipt(ReceiptCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceReceipt ReceiptCapsule.copyReceipt(ReceiptCapsule)"})
  public void testCopyReceipt_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    ResourceReceipt actualCopyReceiptResult =
        ReceiptCapsule.copyReceipt(new ReceiptCapsule(Sha256Hash.ZERO_HASH));

    // Assert
    assertEquals("", actualCopyReceiptResult.getInitializationErrorString());
    assertEquals(0, actualCopyReceiptResult.getResultValue());
    assertEquals(0, actualCopyReceiptResult.getSerializedSize());
    assertEquals(0L, actualCopyReceiptResult.getEnergyFee());
    assertEquals(0L, actualCopyReceiptResult.getEnergyPenaltyTotal());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsage());
    assertEquals(0L, actualCopyReceiptResult.getEnergyUsageTotal());
    assertEquals(0L, actualCopyReceiptResult.getNetFee());
    assertEquals(0L, actualCopyReceiptResult.getNetUsage());
    assertEquals(0L, actualCopyReceiptResult.getOriginEnergyUsage());
    assertEquals(contractResult.DEFAULT, actualCopyReceiptResult.getResult());
    assertTrue(actualCopyReceiptResult.findInitializationErrors().isEmpty());
    assertTrue(actualCopyReceiptResult.getAllFields().isEmpty());
    assertTrue(actualCopyReceiptResult.isInitialized());
    ResourceReceipt actualDefaultInstanceForType =
        actualCopyReceiptResult.getDefaultInstanceForType();
    assertEquals(actualCopyReceiptResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link ReceiptCapsule#checkForEnergyLimit(DynamicPropertiesStore)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiptCapsule#checkForEnergyLimit(DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiptCapsule#checkForEnergyLimit(DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link ReceiptCapsule#addNetFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiptCapsule.addNetFee(long)"})
  public void testAddNetFee() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(Sha256Hash.ZERO_HASH);

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
   *
   * <p>Method under test: {@link ReceiptCapsule#getEnergyUsage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReceiptCapsule.getEnergyUsage()"})
  public void testGetEnergyUsage() {
    // Arrange, Act and Assert
    assertEquals(0L, new ReceiptCapsule(Sha256Hash.ZERO_HASH).getEnergyUsage());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsage(long)}.
   *
   * <p>Method under test: {@link ReceiptCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(Sha256Hash.ZERO_HASH);

    // Act
    receiptCapsule.setEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getEnergyUsage());
    assertEquals(1L, receipt.getEnergyUsage());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getEnergyFee()}.
   *
   * <p>Method under test: {@link ReceiptCapsule#getEnergyFee()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReceiptCapsule.getEnergyFee()"})
  public void testGetEnergyFee() {
    // Arrange, Act and Assert
    assertEquals(0L, new ReceiptCapsule(Sha256Hash.ZERO_HASH).getEnergyFee());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyFee(long)}.
   *
   * <p>Method under test: {@link ReceiptCapsule#setEnergyFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyFee(long)"})
  public void testSetEnergyFee() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(Sha256Hash.ZERO_HASH);

    // Act
    receiptCapsule.setEnergyFee(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getEnergyFee());
    assertEquals(1L, receipt.getEnergyFee());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getOriginEnergyUsage()}.
   *
   * <p>Method under test: {@link ReceiptCapsule#getOriginEnergyUsage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReceiptCapsule.getOriginEnergyUsage()"})
  public void testGetOriginEnergyUsage() {
    // Arrange, Act and Assert
    assertEquals(0L, new ReceiptCapsule(Sha256Hash.ZERO_HASH).getOriginEnergyUsage());
  }

  /**
   * Test {@link ReceiptCapsule#setOriginEnergyUsage(long)}.
   *
   * <p>Method under test: {@link ReceiptCapsule#setOriginEnergyUsage(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiptCapsule.setOriginEnergyUsage(long)"})
  public void testSetOriginEnergyUsage() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(Sha256Hash.ZERO_HASH);

    // Act
    receiptCapsule.setOriginEnergyUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getOriginEnergyUsage());
    assertEquals(1L, receipt.getOriginEnergyUsage());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getEnergyUsageTotal()}.
   *
   * <p>Method under test: {@link ReceiptCapsule#getEnergyUsageTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReceiptCapsule.getEnergyUsageTotal()"})
  public void testGetEnergyUsageTotal() {
    // Arrange, Act and Assert
    assertEquals(0L, new ReceiptCapsule(Sha256Hash.ZERO_HASH).getEnergyUsageTotal());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyUsageTotal(long)}.
   *
   * <p>Method under test: {@link ReceiptCapsule#setEnergyUsageTotal(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyUsageTotal(long)"})
  public void testSetEnergyUsageTotal() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(Sha256Hash.ZERO_HASH);

    // Act
    receiptCapsule.setEnergyUsageTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getEnergyUsageTotal());
    assertEquals(1L, receipt.getEnergyUsageTotal());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getEnergyPenaltyTotal()}.
   *
   * <p>Method under test: {@link ReceiptCapsule#getEnergyPenaltyTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReceiptCapsule.getEnergyPenaltyTotal()"})
  public void testGetEnergyPenaltyTotal() {
    // Arrange, Act and Assert
    assertEquals(0L, new ReceiptCapsule(Sha256Hash.ZERO_HASH).getEnergyPenaltyTotal());
  }

  /**
   * Test {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}.
   *
   * <p>Method under test: {@link ReceiptCapsule#setEnergyPenaltyTotal(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiptCapsule.setEnergyPenaltyTotal(long)"})
  public void testSetEnergyPenaltyTotal() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(Sha256Hash.ZERO_HASH);

    // Act
    receiptCapsule.setEnergyPenaltyTotal(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getEnergyPenaltyTotal());
    assertEquals(1L, receipt.getEnergyPenaltyTotal());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getNetUsage()}.
   *
   * <p>Method under test: {@link ReceiptCapsule#getNetUsage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReceiptCapsule.getNetUsage()"})
  public void testGetNetUsage() {
    // Arrange, Act and Assert
    assertEquals(0L, new ReceiptCapsule(Sha256Hash.ZERO_HASH).getNetUsage());
  }

  /**
   * Test {@link ReceiptCapsule#setNetUsage(long)}.
   *
   * <p>Method under test: {@link ReceiptCapsule#setNetUsage(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiptCapsule.setNetUsage(long)"})
  public void testSetNetUsage() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(Sha256Hash.ZERO_HASH);

    // Act
    receiptCapsule.setNetUsage(1L);

    // Assert
    ResourceReceipt receipt = receiptCapsule.getReceipt();
    assertEquals(1, receipt.getAllFields().size());
    assertEquals(1L, receiptCapsule.getNetUsage());
    assertEquals(1L, receipt.getNetUsage());
    assertEquals(2, receipt.getSerializedSize());
    assertEquals(8, receipt.getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link ReceiptCapsule#getNetFee()}.
   *
   * <p>Method under test: {@link ReceiptCapsule#getNetFee()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReceiptCapsule.getNetFee()"})
  public void testGetNetFee() {
    // Arrange, Act and Assert
    assertEquals(0L, new ReceiptCapsule(Sha256Hash.ZERO_HASH).getNetFee());
  }

  /**
   * Test {@link ReceiptCapsule#setNetFee(long)}.
   *
   * <p>Method under test: {@link ReceiptCapsule#setNetFee(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiptCapsule.setNetFee(long)"})
  public void testSetNetFee() {
    // Arrange
    ReceiptCapsule receiptCapsule = new ReceiptCapsule(Sha256Hash.ZERO_HASH);

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
   * Test {@link ReceiptCapsule#getResult()}.
   *
   * <p>Method under test: {@link ReceiptCapsule#getResult()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"contractResult ReceiptCapsule.getResult()"})
  public void testGetResult() {
    // Arrange, Act and Assert
    assertEquals(contractResult.DEFAULT, new ReceiptCapsule(Sha256Hash.ZERO_HASH).getResult());
  }
}
