package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.contract.SmartContractOuterClass;
import org.tron.protos.contract.SmartContractOuterClass.SmartContract;
import org.tron.protos.contract.SmartContractOuterClass.SmartContractDataWrapper;

public class ContractCapsuleDiffblueTest {
  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_when0xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ContractCapsule("0XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and two.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithAAndTwo_thenReturnInstanceIsNull() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(
            new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and two.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithAAndTwo_thenReturnInstanceIsNull2() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(
            new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 'A', 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and two.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithEighteenAndTwo() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(
            new byte[] {18, 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithEighteenAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and two.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithLfAndTwo_thenReturnInstanceIsNull() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(
            new byte[] {'\n', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithLfAndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(new byte[] {'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithMin_valueAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code "} and two.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithQuotationMarkAndTwo() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(
            new byte[] {'"', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code "} and zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithQuotationMarkAndZero() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(new byte[] {'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and two.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithTwentySixAndTwo() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(
            new byte[] {26, 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithTwentySixAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange and Act
    ContractCapsule actualContractCapsule =
        new ContractCapsule(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualContractCapsule.getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ContractCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return ContractVersion is zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenEmptyArrayOfByte_thenReturnContractVersionIsZero() {
    // Arrange and Act
    ContractCapsule actualContractCapsule = new ContractCapsule(new byte[] {});

    // Assert
    assertEquals(0, actualContractCapsule.getContractVersion());
    assertEquals(0L, actualContractCapsule.getConsumeUserResourcePercent());
    assertEquals(10000000L, actualContractCapsule.getOriginEnergyLimit());
    byte[] codeHash = actualContractCapsule.getCodeHash();
    assertSame(codeHash, actualContractCapsule.getOriginAddress());
    assertSame(codeHash, actualContractCapsule.getTrxHash());
    assertArrayEquals(new byte[] {}, codeHash);
    assertArrayEquals(new byte[] {}, actualContractCapsule.getData());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ContractCapsule("\nXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code "XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ContractCapsule("\"XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code (XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ContractCapsule("(XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code :XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull4()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ContractCapsule(":XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ContractCapsule#ContractCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#ContractCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.<init>(byte[])"})
  public void testNewContractCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ContractCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ContractCapsule#getCodeHash()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#getCodeHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractCapsule.getCodeHash()"})
  public void testGetCodeHash_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[] {});
    contractCapsule.setCodeHash("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), contractCapsule.getCodeHash());
  }

  /**
   * Test {@link ContractCapsule#getCodeHash()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#getCodeHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractCapsule.getCodeHash()"})
  public void testGetCodeHash_thenReturnEmptyArrayOfByte() {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, contractCapsule.getCodeHash());
  }

  /**
   * Test {@link ContractCapsule#setCodeHash(byte[])}.
   *
   * <p>Method under test: {@link ContractCapsule#setCodeHash(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.setCodeHash(byte[])"})
  public void testSetCodeHash() throws UnsupportedEncodingException {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[] {});

    // Act
    contractCapsule.setCodeHash("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SmartContract instance = contractCapsule.getInstance();
    ByteString codeHash = instance.getCodeHash();
    assertEquals("AXAXAXAX", codeHash.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertFalse(codeHash.isEmpty());
    ByteIterator iteratorResult = codeHash.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] originAddress = contractCapsule.getOriginAddress();
    assertSame(originAddress, contractCapsule.getTrxHash());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), contractCapsule.getCodeHash());
    assertArrayEquals("J\bAXAXAXAX".getBytes("UTF-8"), contractCapsule.getData());
    assertArrayEquals(new byte[] {}, originAddress);
  }

  /**
   * Test {@link ContractCapsule#generateWrapper()}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#generateWrapper()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SmartContractDataWrapper ContractCapsule.generateWrapper()"})
  public void testGenerateWrapper_thenReturnInitializationErrorStringIsEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    SmartContract smartContract = SmartContract.getDefaultInstance();

    ContractCapsule contractCapsule = new ContractCapsule(smartContract);
    contractCapsule.setRuntimecode("AXAXAXAX".getBytes("UTF-8"));

    // Act
    SmartContractDataWrapper actualGenerateWrapperResult = contractCapsule.generateWrapper();

    // Assert
    assertEquals("", actualGenerateWrapperResult.getInitializationErrorString());
    assertEquals(12, actualGenerateWrapperResult.getSerializedSize());
    assertEquals(2, actualGenerateWrapperResult.getAllFields().size());
    assertFalse(actualGenerateWrapperResult.hasContractState());
    assertTrue(actualGenerateWrapperResult.findInitializationErrors().isEmpty());
    assertTrue(actualGenerateWrapperResult.hasSmartContract());
    assertTrue(actualGenerateWrapperResult.isInitialized());
    assertSame(smartContract, actualGenerateWrapperResult.getSmartContract());
    assertSame(smartContract, actualGenerateWrapperResult.getSmartContractOrBuilder());
  }

  /**
   * Test {@link ContractCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, contractCapsule.getData());
  }

  /**
   * Test {@link ContractCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return J backspace AXAXAXAX Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractCapsule.getData()"})
  public void testGetData_thenReturnJBackspaceAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[] {});
    contractCapsule.setCodeHash("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("J\bAXAXAXAX".getBytes("UTF-8"), contractCapsule.getData());
  }

  /**
   * Test {@link ContractCapsule#getInstance()}.
   *
   * <ul>
   *   <li>Given {@link ContractCapsule#ContractCapsule(byte[])} with data is {@code AXAXAXAX} Bytes
   *       is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SmartContract ContractCapsule.getInstance()"})
  public void testGetInstance_givenContractCapsuleWithDataIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ContractCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ContractCapsule#getOriginAddress()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#getOriginAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractCapsule.getOriginAddress()"})
  public void testGetOriginAddress_thenReturnEmptyArrayOfByte() {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, contractCapsule.getOriginAddress());
  }

  /**
   * Test {@link ContractCapsule#getConsumeUserResourcePercent()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#getConsumeUserResourcePercent()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractCapsule.getConsumeUserResourcePercent()"})
  public void testGetConsumeUserResourcePercent_thenReturnZero() {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, contractCapsule.getConsumeUserResourcePercent());
  }

  /**
   * Test {@link ContractCapsule#getOriginEnergyLimit()}.
   *
   * <ul>
   *   <li>Then return {@code 10000000}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#getOriginEnergyLimit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ContractCapsule.getOriginEnergyLimit()"})
  public void testGetOriginEnergyLimit_thenReturn10000000() {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[] {});

    // Act and Assert
    assertEquals(10000000L, contractCapsule.getOriginEnergyLimit());
  }

  /**
   * Test {@link ContractCapsule#clearABI()}.
   *
   * <p>Method under test: {@link ContractCapsule#clearABI()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.clearABI()"})
  public void testClearABI() {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[] {});

    // Act
    contractCapsule.clearABI();

    // Assert
    SmartContract instance = contractCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(11, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {26, 0}, contractCapsule.getData());
  }

  /**
   * Test {@link ContractCapsule#clearABI()}.
   *
   * <p>Method under test: {@link ContractCapsule#clearABI()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContractCapsule.clearABI()"})
  public void testClearABI2() throws UnsupportedEncodingException {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[] {});
    contractCapsule.setCodeHash("AXAXAXAX".getBytes("UTF-8"));

    // Act
    contractCapsule.clearABI();

    // Assert
    SmartContract instance = contractCapsule.getInstance();
    assertEquals(11, instance.getDescriptorForType().getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {26, 0, 'J', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        contractCapsule.getData());
  }

  /**
   * Test {@link ContractCapsule#getTrxHash()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#getTrxHash()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ContractCapsule.getTrxHash()"})
  public void testGetTrxHash_thenReturnEmptyArrayOfByte() {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, contractCapsule.getTrxHash());
  }

  /**
   * Test {@link ContractCapsule#getContractVersion()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ContractCapsule#getContractVersion()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ContractCapsule.getContractVersion()"})
  public void testGetContractVersion_thenReturnZero() {
    // Arrange
    ContractCapsule contractCapsule = new ContractCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0, contractCapsule.getContractVersion());
  }
}
