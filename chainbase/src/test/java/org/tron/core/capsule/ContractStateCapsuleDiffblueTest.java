package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.ContractState;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ContractStateCapsuleDiffblueTest {
  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(long)}.
   *
   * <p>Method under test: {@link ContractStateCapsule#ContractStateCapsule(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.<init>(long)"})
  public void testNewContractStateCapsule() {
    // Arrange and Act
    ContractStateCapsule actualContractStateCapsule = new ContractStateCapsule(1L);

    // Assert
    ContractState instance = actualContractStateCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0L, actualContractStateCapsule.getEnergyFactor());
    assertEquals(0L, actualContractStateCapsule.getEnergyUsage());
    assertEquals(0L, instance.getEnergyFactor());
    assertEquals(0L, instance.getEnergyUsage());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, actualContractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertArrayEquals(new byte[] {24, 1}, actualContractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   *
   * <p>Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule2() {
    // Arrange and Act
    ContractStateCapsule actualContractStateCapsule = new ContractStateCapsule(new byte[] {});

    // Assert
    ContractState instance = actualContractStateCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0L, actualContractStateCapsule.getEnergyFactor());
    assertEquals(0L, actualContractStateCapsule.getEnergyUsage());
    assertEquals(0L, actualContractStateCapsule.getUpdateCycle());
    assertEquals(0L, instance.getEnergyFactor());
    assertEquals(0L, instance.getEnergyUsage());
    assertEquals(0L, instance.getUpdateCycle());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    ContractState actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertArrayEquals(new byte[] {}, actualContractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   *
   * <p>Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new ContractStateCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    ContractStateCapsule actualContractStateCapsule =
        new ContractStateCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualContractStateCapsule.getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenArrayOfByteWithSixteenAndX() {
    // Arrange and Act
    ContractStateCapsule actualContractStateCapsule =
        new ContractStateCapsule(new byte[] {16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualContractStateCapsule.getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenArrayOfByteWithTwentyFourAndX() {
    // Arrange and Act
    ContractStateCapsule actualContractStateCapsule =
        new ContractStateCapsule(new byte[] {24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualContractStateCapsule.getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    ContractStateCapsule actualContractStateCapsule =
        new ContractStateCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualContractStateCapsule.getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ContractStateCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenBackspace_thenReturnInstanceIsNull() {
    // Arrange and Act
    ContractStateCapsule actualContractStateCapsule =
        new ContractStateCapsule(
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', 16
            });

    // Assert
    assertNull(actualContractStateCapsule.getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenBackspace_thenReturnInstanceIsNull2() {
    // Arrange and Act
    ContractStateCapsule actualContractStateCapsule =
        new ContractStateCapsule(
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', 24
            });

    // Assert
    assertNull(actualContractStateCapsule.getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenBackspace_thenReturnInstanceIsNull3() {
    // Arrange and Act
    ContractStateCapsule actualContractStateCapsule =
        new ContractStateCapsule(
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', -1
            });

    // Assert
    assertNull(actualContractStateCapsule.getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ContractStateCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#getData()}.
   *
   * <p>Method under test: {@link ContractStateCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractStateCapsule.getData()"})
  public void testGetData() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {24, 1}, new ContractStateCapsule(1L).getData());
  }

  /**
   * Test {@link ContractStateCapsule#getInstance()}.
   *
   * <p>Method under test: {@link ContractStateCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ContractState ContractStateCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    ContractState actualInstance = new ContractStateCapsule(1L).getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0L, actualInstance.getEnergyFactor());
    assertEquals(0L, actualInstance.getEnergyUsage());
    assertEquals(1, actualInstance.getAllFields().size());
    assertEquals(1L, actualInstance.getUpdateCycle());
    assertEquals(2, actualInstance.getSerializedSize());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
  }

  /**
   * Test {@link ContractStateCapsule#getEnergyUsage()}.
   *
   * <p>Method under test: {@link ContractStateCapsule#getEnergyUsage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractStateCapsule.getEnergyUsage()"})
  public void testGetEnergyUsage() {
    // Arrange, Act and Assert
    assertEquals(0L, new ContractStateCapsule(1L).getEnergyUsage());
  }

  /**
   * Test {@link ContractStateCapsule#setEnergyUsage(long)}.
   *
   * <p>Method under test: {@link ContractStateCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.setEnergyUsage(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, contractStateCapsule.getEnergyUsage());
    assertEquals(42L, instance.getEnergyUsage());
    assertArrayEquals(new byte[] {'\b', '*', 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#addEnergyUsage(long)}.
   *
   * <p>Method under test: {@link ContractStateCapsule#addEnergyUsage(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.addEnergyUsage(long)"})
  public void testAddEnergyUsage() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.addEnergyUsage(1L);

    // Assert
    assertEquals(1L, contractStateCapsule.getEnergyUsage());
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1L, instance.getEnergyUsage());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#getEnergyFactor()}.
   *
   * <p>Method under test: {@link ContractStateCapsule#getEnergyFactor()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractStateCapsule.getEnergyFactor()"})
  public void testGetEnergyFactor() {
    // Arrange, Act and Assert
    assertEquals(0L, new ContractStateCapsule(1L).getEnergyFactor());
  }

  /**
   * Test {@link ContractStateCapsule#setEnergyFactor(long)}.
   *
   * <p>Method under test: {@link ContractStateCapsule#setEnergyFactor(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.setEnergyFactor(long)"})
  public void testSetEnergyFactor() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.setEnergyFactor(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(42L, contractStateCapsule.getEnergyFactor());
    assertEquals(42L, instance.getEnergyFactor());
    assertArrayEquals(new byte[] {16, '*', 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#getUpdateCycle()}.
   *
   * <p>Method under test: {@link ContractStateCapsule#getUpdateCycle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractStateCapsule.getUpdateCycle()"})
  public void testGetUpdateCycle() {
    // Arrange, Act and Assert
    assertEquals(1L, new ContractStateCapsule(1L).getUpdateCycle());
  }

  /**
   * Test {@link ContractStateCapsule#setUpdateCycle(long)}.
   *
   * <p>Method under test: {@link ContractStateCapsule#setUpdateCycle(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.setUpdateCycle(long)"})
  public void testSetUpdateCycle() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.setUpdateCycle(42L);

    // Assert
    assertEquals(42L, contractStateCapsule.getUpdateCycle());
    assertEquals(42L, contractStateCapsule.getInstance().getUpdateCycle());
    assertArrayEquals(new byte[] {24, '*'}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#addUpdateCycle(long)}.
   *
   * <p>Method under test: {@link ContractStateCapsule#addUpdateCycle(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractStateCapsule.addUpdateCycle(long)"})
  public void testAddUpdateCycle() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.addUpdateCycle(1L);

    // Assert
    assertEquals(2L, contractStateCapsule.getUpdateCycle());
    assertEquals(2L, contractStateCapsule.getInstance().getUpdateCycle());
    assertArrayEquals(new byte[] {24, 2}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   *
   * <p>Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addUpdateCycle(13L);

    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   *
   * <p>Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    assertEquals(3, contractStateCapsule.getInstance().getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   *
   * <p>Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps3() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);

    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   *
   * <p>Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps4() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(Long.MIN_VALUE);

    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    contractStateCapsule.catchUpToCycle(dps);

    // Assert that nothing has changed
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(11, instance.getSerializedSize());
    assertEquals(Long.MIN_VALUE, contractStateCapsule.getUpdateCycle());
    assertEquals(Long.MIN_VALUE, instance.getUpdateCycle());
    assertArrayEquals(
        new byte[] {
          24,
          Byte.MIN_VALUE,
          Byte.MIN_VALUE,
          Byte.MIN_VALUE,
          Byte.MIN_VALUE,
          Byte.MIN_VALUE,
          Byte.MIN_VALUE,
          Byte.MIN_VALUE,
          Byte.MIN_VALUE,
          Byte.MIN_VALUE,
          1
        },
        contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   *
   * <p>Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps5() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);
    contractStateCapsule.addEnergyUsage(10000L);

    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    assertEquals(0L, contractStateCapsule.getEnergyUsage());
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(0L, instance.getEnergyUsage());
    assertEquals(1, instance.getAllFields().size());
    assertArrayEquals(new byte[] {24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps_givenFalse() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);

    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(false);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps_thenReturnFalse() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(1L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, contractStateCapsule.getInstance().getUpdateCycle());
    assertFalse(actualCatchUpToCycleResult);
    assertArrayEquals(new byte[] {24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)} with {@code
   * newCycle}, {@code threshold}, {@code increaseFactor}, {@code maxFactor}, {@code useStrictMath}.
   *
   * <p>Method under test: {@link ContractStateCapsule#catchUpToCycle(long, long, long, long,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ContractStateCapsule.catchUpToCycle(long, long, long, long, boolean)"
  })
  public void testCatchUpToCycleWithNewCycleThresholdIncreaseFactorMaxFactorUseStrictMath() {
    // Arrange, Act and Assert
    assertFalse(new ContractStateCapsule(1L).catchUpToCycle(1L, 1L, 1L, 1L, true));
  }
}
