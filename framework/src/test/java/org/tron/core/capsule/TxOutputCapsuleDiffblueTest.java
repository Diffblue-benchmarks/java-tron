package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.TXOutput;

public class TxOutputCapsuleDiffblueTest {
  /**
   * Test {@link TxOutputCapsule#TxOutputCapsule(long, String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link TxOutputCapsule#TxOutputCapsule(long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TxOutputCapsule.<init>(long, String)"})
  public void testNewTxOutputCapsule_when0x() {
    // Arrange and Act
    TxOutputCapsule actualTxOutputCapsule = new TxOutputCapsule(42L, "0x");

    // Assert
    TXOutput instance = actualTxOutputCapsule.getInstance();
    UnknownFieldSet unknownFields = instance.getUnknownFields();
    TXOutput defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(instance, actualTxOutputCapsule.getTxOutput());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals(new byte[] {}, actualTxOutputCapsule.getData());
  }

  /**
   * Test {@link TxOutputCapsule#TxOutputCapsule(long, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TxOutputCapsule#TxOutputCapsule(long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TxOutputCapsule.<init>(long, String)"})
  public void testNewTxOutputCapsule_whenNull() {
    // Arrange and Act
    TxOutputCapsule actualTxOutputCapsule = new TxOutputCapsule(42L, null);

    // Assert
    TXOutput instance = actualTxOutputCapsule.getInstance();
    UnknownFieldSet unknownFields = instance.getUnknownFields();
    TXOutput defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(instance, actualTxOutputCapsule.getTxOutput());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals(new byte[] {}, actualTxOutputCapsule.getData());
  }

  /**
   * Test {@link TxOutputCapsule#validate()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TxOutputCapsule#validate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TxOutputCapsule.validate()"})
  public void testValidate_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new TxOutputCapsule(42L, "42").validate());
  }

  /**
   * Test {@link TxOutputCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TxOutputCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TxOutputCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new TxOutputCapsule(42L, "42").getData());
  }

  /**
   * Test {@link TxOutputCapsule#getInstance()}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TxOutputCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TXOutput TxOutputCapsule.getInstance()"})
  public void testGetInstance_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    TXOutput actualInstance = new TxOutputCapsule(42L, "42").getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(2, actualInstance.getAllFields().size());
    assertEquals(42L, actualInstance.getValue());
    assertEquals(5, actualInstance.getSerializedSize());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.isInitialized());
  }
}
