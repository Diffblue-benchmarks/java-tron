package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.ContractState;

public class ContractStateCapsuleDiffblueTest {
  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    assertTrue(instance.isInitialized());
    assertArrayEquals(new byte[]{24, 1}, actualContractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   * <p>
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule2() {
    // Arrange and Act
    ContractStateCapsule actualContractStateCapsule = new ContractStateCapsule(new byte[]{});

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
    assertTrue(instance.isInitialized());
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{}, actualContractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   * <p>
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenArrayOfByteWithSixteenAndX() {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenArrayOfByteWithTwentyFourAndX() {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule("\bXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#ContractStateCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#ContractStateCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.<init>(byte[])"})
  public void testNewContractStateCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ContractStateCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ContractStateCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ContractStateCapsule#ContractStateCapsule(long)} with currentCycle is {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractStateCapsule.getData()"})
  public void testGetData_givenContractStateCapsuleWithCurrentCycleIsMax_value() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE},
        (new ContractStateCapsule(Long.MAX_VALUE)).getData());
  }

  /**
   * Test {@link ContractStateCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ContractStateCapsule#ContractStateCapsule(long)} with currentCycle is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractStateCapsule.getData()"})
  public void testGetData_givenContractStateCapsuleWithCurrentCycleIsMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, (new ContractStateCapsule(-1L)).getData());
  }

  /**
   * Test {@link ContractStateCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ContractStateCapsule#ContractStateCapsule(long)} with currentCycle is one EnergyFactor is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractStateCapsule.getData()"})
  public void testGetData_givenContractStateCapsuleWithCurrentCycleIsOneEnergyFactorIsFortyTwo() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.setEnergyFactor(42L);
    contractStateCapsule.addEnergyUsage(-1L);

    // Act and Assert
    assertArrayEquals(new byte[]{'\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 16, '*', 24, 1},
        contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractStateCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithBackspaceAndMinusOne() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addEnergyUsage(-1L);

    // Act and Assert
    assertArrayEquals(new byte[]{'\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and minus one hundred twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractStateCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndMinusOneHundredTwelve() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{24, -112, 'N'}, (new ContractStateCapsule(10000L)).getData());
  }

  /**
   * Test {@link ContractStateCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractStateCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{24, 1}, (new ContractStateCapsule(1L)).getData());
  }

  /**
   * Test {@link ContractStateCapsule#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ContractStateCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new ContractStateCapsule(0L)).getData());
  }

  /**
   * Test {@link ContractStateCapsule#getInstance()}.
   * <p>
   * Method under test: {@link ContractStateCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractState ContractStateCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    ContractState actualInstance = (new ContractStateCapsule(1L)).getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0L, actualInstance.getEnergyFactor());
    assertEquals(0L, actualInstance.getEnergyUsage());
    assertEquals(1, actualInstance.getAllFields().size());
    assertEquals(1L, actualInstance.getUpdateCycle());
    assertEquals(2, actualInstance.getSerializedSize());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.isInitialized());
  }

  /**
   * Test {@link ContractStateCapsule#getEnergyUsage()}.
   * <ul>
   *   <li>Given {@link ContractStateCapsule#ContractStateCapsule(long)} with currentCycle is one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#getEnergyUsage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractStateCapsule.getEnergyUsage()"})
  public void testGetEnergyUsage_givenContractStateCapsuleWithCurrentCycleIsOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ContractStateCapsule(1L)).getEnergyUsage());
  }

  /**
   * Test {@link ContractStateCapsule#setEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    // Act
    contractStateCapsule.setEnergyUsage(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\b', '*'}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#setEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.setEnergyUsage(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', '*', 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#setEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage3() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.setEnergyFactor(42L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.setEnergyUsage(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', '*', 16, '*', 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#setEnergyUsage(long)}.
   * <ul>
   *   <li>Given {@link ContractStateCapsule#ContractStateCapsule(long)} with currentCycle is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#setEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.setEnergyUsage(long)"})
  public void testSetEnergyUsage_givenContractStateCapsuleWithCurrentCycleIsOne() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.setEnergyUsage(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', '*', 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#addEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#addEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.addEnergyUsage(long)"})
  public void testAddEnergyUsage() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    // Act
    contractStateCapsule.addEnergyUsage(1L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\b', 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#addEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#addEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.addEnergyUsage(long)"})
  public void testAddEnergyUsage2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.addEnergyUsage(1L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(2L, contractStateCapsule.getEnergyUsage());
    assertEquals(2L, instance.getEnergyUsage());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 2, 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#addEnergyUsage(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#addEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.addEnergyUsage(long)"})
  public void testAddEnergyUsage3() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.setEnergyFactor(42L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.addEnergyUsage(1L);

    // Assert
    assertEquals(2L, contractStateCapsule.getEnergyUsage());
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2L, instance.getEnergyUsage());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 2, 16, '*', 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#addEnergyUsage(long)}.
   * <ul>
   *   <li>Then {@link ContractStateCapsule#ContractStateCapsule(long)} with currentCycle is one EnergyUsage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#addEnergyUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.addEnergyUsage(long)"})
  public void testAddEnergyUsage_thenContractStateCapsuleWithCurrentCycleIsOneEnergyUsageIsOne() {
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
    assertArrayEquals(new byte[]{'\b', 1, 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#getEnergyFactor()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#getEnergyFactor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractStateCapsule.getEnergyFactor()"})
  public void testGetEnergyFactor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ContractStateCapsule(1L)).getEnergyFactor());
  }

  /**
   * Test {@link ContractStateCapsule#setEnergyFactor(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#setEnergyFactor(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.setEnergyFactor(long)"})
  public void testSetEnergyFactor() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.setEnergyFactor(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{16, '*', 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#setEnergyFactor(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#setEnergyFactor(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.setEnergyFactor(long)"})
  public void testSetEnergyFactor2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    // Act
    contractStateCapsule.setEnergyFactor(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{16, '*'}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#setEnergyFactor(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#setEnergyFactor(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.setEnergyFactor(long)"})
  public void testSetEnergyFactor3() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.setEnergyFactor(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 16, '*', 24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#getUpdateCycle()}.
   * <ul>
   *   <li>Given {@link ContractStateCapsule#ContractStateCapsule(long)} with currentCycle is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#getUpdateCycle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ContractStateCapsule.getUpdateCycle()"})
  public void testGetUpdateCycle_givenContractStateCapsuleWithCurrentCycleIsOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1L, (new ContractStateCapsule(1L)).getUpdateCycle());
  }

  /**
   * Test {@link ContractStateCapsule#setUpdateCycle(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#setUpdateCycle(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.setUpdateCycle(long)"})
  public void testSetUpdateCycle() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.setUpdateCycle(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, '*'}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#setUpdateCycle(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#setUpdateCycle(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.setUpdateCycle(long)"})
  public void testSetUpdateCycle2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    // Act
    contractStateCapsule.setUpdateCycle(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, '*'}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#setUpdateCycle(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#setUpdateCycle(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.setUpdateCycle(long)"})
  public void testSetUpdateCycle3() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.setUpdateCycle(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 24, '*'}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#setUpdateCycle(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#setUpdateCycle(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.setUpdateCycle(long)"})
  public void testSetUpdateCycle4() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.setEnergyFactor(42L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.setUpdateCycle(42L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 16, '*', 24, '*'}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#addUpdateCycle(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#addUpdateCycle(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.addUpdateCycle(long)"})
  public void testAddUpdateCycle() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    contractStateCapsule.addUpdateCycle(1L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2L, contractStateCapsule.getUpdateCycle());
    assertEquals(2L, instance.getUpdateCycle());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, 2}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#addUpdateCycle(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#addUpdateCycle(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.addUpdateCycle(long)"})
  public void testAddUpdateCycle2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    // Act
    contractStateCapsule.addUpdateCycle(1L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#addUpdateCycle(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#addUpdateCycle(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.addUpdateCycle(long)"})
  public void testAddUpdateCycle3() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.addUpdateCycle(1L);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(2L, contractStateCapsule.getUpdateCycle());
    assertEquals(2L, instance.getUpdateCycle());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 24, 2}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#addUpdateCycle(long)}.
   * <p>
   * Method under test: {@link ContractStateCapsule#addUpdateCycle(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ContractStateCapsule.addUpdateCycle(long)"})
  public void testAddUpdateCycle4() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);
    contractStateCapsule.setEnergyFactor(42L);
    contractStateCapsule.addEnergyUsage(1L);

    // Act
    contractStateCapsule.addUpdateCycle(1L);

    // Assert
    assertEquals(2L, contractStateCapsule.getUpdateCycle());
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(2L, instance.getUpdateCycle());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1, 16, '*', 24, 2}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps() {
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
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(13L);
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
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps3() {
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
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps4() {
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
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps5() {
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
    assertArrayEquals(new byte[]{24, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE,
        Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)} with {@code dps}.
   * <ul>
   *   <li>Given minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(DynamicPropertiesStore)"})
  public void testCatchUpToCycleWithDps_givenMinusOne() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.allowStrictMath()).thenReturn(true);
    when(dps.getCurrentCycleNumber()).thenReturn(1L);
    when(dps.getDynamicEnergyIncreaseFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyMaxFactor()).thenReturn(1L);
    when(dps.getDynamicEnergyThreshold()).thenReturn(-1L);

    // Act
    contractStateCapsule.catchUpToCycle(dps);

    // Assert
    verify(dps).allowStrictMath();
    verify(dps).getCurrentCycleNumber();
    verify(dps).getDynamicEnergyIncreaseFactor();
    verify(dps).getDynamicEnergyMaxFactor();
    verify(dps).getDynamicEnergyThreshold();
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)} with {@code newCycle}, {@code threshold}, {@code increaseFactor}, {@code maxFactor}, {@code useStrictMath}.
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(long, long, long, long, boolean)"})
  public void testCatchUpToCycleWithNewCycleThresholdIncreaseFactorMaxFactorUseStrictMath() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(1L);

    // Act
    boolean actualCatchUpToCycleResult = contractStateCapsule.catchUpToCycle(1L, 1L, 1L, 1L, true);

    // Assert
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(actualCatchUpToCycleResult);
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)} with {@code newCycle}, {@code threshold}, {@code increaseFactor}, {@code maxFactor}, {@code useStrictMath}.
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(long, long, long, long, boolean)"})
  public void testCatchUpToCycleWithNewCycleThresholdIncreaseFactorMaxFactorUseStrictMath2() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(0L);

    // Act
    contractStateCapsule.catchUpToCycle(1L, 1L, 1L, 1L, true);

    // Assert
    assertEquals(3, contractStateCapsule.getInstance().getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)} with {@code newCycle}, {@code threshold}, {@code increaseFactor}, {@code maxFactor}, {@code useStrictMath}.
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(long, long, long, long, boolean)"})
  public void testCatchUpToCycleWithNewCycleThresholdIncreaseFactorMaxFactorUseStrictMath3() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);

    // Act
    contractStateCapsule.catchUpToCycle(1L, 1L, 1L, 1L, true);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)} with {@code newCycle}, {@code threshold}, {@code increaseFactor}, {@code maxFactor}, {@code useStrictMath}.
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(long, long, long, long, boolean)"})
  public void testCatchUpToCycleWithNewCycleThresholdIncreaseFactorMaxFactorUseStrictMath4() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(10000L);

    // Act
    contractStateCapsule.catchUpToCycle(1L, 1L, 1L, 1L, true);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)} with {@code newCycle}, {@code threshold}, {@code increaseFactor}, {@code maxFactor}, {@code useStrictMath}.
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(long, long, long, long, boolean)"})
  public void testCatchUpToCycleWithNewCycleThresholdIncreaseFactorMaxFactorUseStrictMath5() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(Long.MIN_VALUE);

    // Act
    contractStateCapsule.catchUpToCycle(1L, 1L, 1L, 1L, true);

    // Assert that nothing has changed
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(11, instance.getSerializedSize());
    assertEquals(Long.MIN_VALUE, contractStateCapsule.getUpdateCycle());
    assertEquals(Long.MIN_VALUE, instance.getUpdateCycle());
    assertArrayEquals(new byte[]{24, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE,
        Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)} with {@code newCycle}, {@code threshold}, {@code increaseFactor}, {@code maxFactor}, {@code useStrictMath}.
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(long, long, long, long, boolean)"})
  public void testCatchUpToCycleWithNewCycleThresholdIncreaseFactorMaxFactorUseStrictMath6() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);
    contractStateCapsule.addEnergyUsage(10000L);

    // Act
    contractStateCapsule.catchUpToCycle(1L, 1L, 1L, 1L, true);

    // Assert
    assertEquals(0L, contractStateCapsule.getEnergyUsage());
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(0L, instance.getEnergyUsage());
    assertEquals(1, instance.getAllFields().size());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }

  /**
   * Test {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)} with {@code newCycle}, {@code threshold}, {@code increaseFactor}, {@code maxFactor}, {@code useStrictMath}.
   * <p>
   * Method under test: {@link ContractStateCapsule#catchUpToCycle(long, long, long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ContractStateCapsule.catchUpToCycle(long, long, long, long, boolean)"})
  public void testCatchUpToCycleWithNewCycleThresholdIncreaseFactorMaxFactorUseStrictMath7() {
    // Arrange
    ContractStateCapsule contractStateCapsule = new ContractStateCapsule(-1L);

    // Act
    contractStateCapsule.catchUpToCycle(1L, 1L, 1L, 1L, false);

    // Assert
    ContractState instance = contractStateCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, contractStateCapsule.getUpdateCycle());
    assertEquals(1L, instance.getUpdateCycle());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, 1}, contractStateCapsule.getData());
  }
}
