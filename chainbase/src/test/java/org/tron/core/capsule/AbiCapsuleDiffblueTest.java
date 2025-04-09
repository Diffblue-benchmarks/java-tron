package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract.ABI.Entry;

public class AbiCapsuleDiffblueTest {
  /**
   * Test {@link AbiCapsule#AbiCapsule(ContractCapsule)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(ContractCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(ContractCapsule)"})
  public void testNewAbiCapsule_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ContractCapsule contract = new ContractCapsule(new byte[]{});
    contract.setCodeHash("AXAXAXAX".getBytes("UTF-8"));

    // Act
    AbiCapsule actualAbiCapsule = new AbiCapsule(contract);

    // Assert
    ABI instance = actualAbiCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getEntrysCount());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<Entry> entrysList = instance.getEntrysList();
    assertTrue(entrysList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(instance.isInitialized());
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertSame(entrysList, instance.getEntrysOrBuilderList());
    assertArrayEquals(new byte[]{}, actualAbiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>Then return Instance InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_thenReturnInstanceInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    AbiCapsule actualAbiCapsule = new AbiCapsule(new byte[]{});

    // Assert
    ABI instance = actualAbiCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getEntrysCount());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<Entry> entrysList = instance.getEntrysList();
    assertTrue(entrysList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(instance.isInitialized());
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertSame(entrysList, instance.getEntrysOrBuilderList());
    assertArrayEquals(new byte[]{}, actualAbiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 0 A A A A A A} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_when0AAAAAABytesIsUtf8_thenReturnInstanceIsNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\n\n0\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 0}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_when0_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, '0', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 8 A A A A A A} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_when8AAAAAABytesIsUtf8_thenReturnInstanceIsNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\n\n8\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_when8_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, '8', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAAAABytesIsUtf8_thenReturnInstanceIsNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code A A A A A A A} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code A A A A A A} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAABytesIsUtf8_thenReturnInstanceIsNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\n\n\b\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code " A A A A A A} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAABytesIsUtf8_thenReturnInstanceIsNull2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\n\n\"\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code * A A A A A A} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAABytesIsUtf8_thenReturnInstanceIsNull3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\n\n*\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and one.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithLfAndOne_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and one.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithLfAndOne_thenReturnInstanceIsNull2() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, 16, 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and one.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithLfAndOne_thenReturnInstanceIsNull3() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, 26, 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and one.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithLfAndOne_thenReturnInstanceIsNull4() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, 0, 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and one.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithLfAndOne_thenReturnInstanceIsNull5() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, -1, 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithLfAndZero_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithOneAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code *}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAsterisk_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, '*', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When backspace.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenBackspace_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, '\b', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code @}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenCommercialAt_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, '@', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(ContractCapsule)}.
   * <ul>
   *   <li>When {@link ContractCapsule#ContractCapsule(byte[])} with data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(ContractCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(ContractCapsule)"})
  public void testNewAbiCapsule_whenContractCapsuleWithDataIsEmptyArrayOfByte() {
    // Arrange and Act
    AbiCapsule actualAbiCapsule = new AbiCapsule(new ContractCapsule(new byte[]{}));

    // Assert
    ABI instance = actualAbiCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getEntrysCount());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<Entry> entrysList = instance.getEntrysList();
    assertTrue(entrysList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(instance.isInitialized());
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertSame(entrysList, instance.getEntrysOrBuilderList());
    assertArrayEquals(new byte[]{}, actualAbiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(ABI)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Instance is DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(ABI)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(ABI)"})
  public void testNewAbiCapsule_whenDefaultInstance_thenReturnInstanceIsDefaultInstance() {
    // Arrange
    ABI abi = ABI.getDefaultInstance();

    // Act
    AbiCapsule actualAbiCapsule = new AbiCapsule(abi);

    // Assert
    assertEquals(abi, actualAbiCapsule.getInstance());
    assertArrayEquals(new byte[]{}, actualAbiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenLf_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(
        new byte[]{'\n', '\n', 16, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'}))
            .getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code "}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenQuotationMark_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule(new byte[]{'\n', 1, '"', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link AbiCapsule#getData()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AbiCapsule.getData()"})
  public void testGetData_givenA_thenReturnArrayOfByteWithAAndX() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        (new AbiCapsule(
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}))
                .getData());
  }

  /**
   * Test {@link AbiCapsule#getData()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AbiCapsule.getData()"})
  public void testGetData_givenA_thenReturnArrayOfByteWithAAndX2() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'},
        (new AbiCapsule(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'}))
            .getData());
  }

  /**
   * Test {@link AbiCapsule#getData()}.
   * <ul>
   *   <li>Given {@link AbiCapsule#AbiCapsule(byte[])} with data is empty array of {@code byte}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AbiCapsule.getData()"})
  public void testGetData_givenAbiCapsuleWithDataIsEmptyArrayOfByte_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new AbiCapsule(new byte[]{})).getData());
  }

  /**
   * Test {@link AbiCapsule#getData()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAXAAAXAXAXAXXAXAXA} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AbiCapsule.getData()"})
  public void testGetData_thenReturnAxaxaxaxaaaxaxaxaxxaxaxaBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualData = (new AbiCapsule("AXAXAXAXAXAXAXAAAXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    assertArrayEquals("AXAXAXAXAAAXAXAXAXXAXAXA".getBytes("UTF-8"), actualData);
  }

  /**
   * Test {@link AbiCapsule#getInstance()}.
   * <ul>
   *   <li>Given {@link AbiCapsule#AbiCapsule(byte[])} with data is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbiCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ABI AbiCapsule.getInstance()"})
  public void testGetInstance_givenAbiCapsuleWithDataIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new AbiCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }
}
