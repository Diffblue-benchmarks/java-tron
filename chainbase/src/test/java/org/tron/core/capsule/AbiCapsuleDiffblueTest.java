package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <ul>
   *   <li>Then return Instance InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(ContractCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(ContractCapsule)"})
  public void testNewAbiCapsule_thenReturnInstanceInitializationErrorStringIsEmptyString() {
    // Arrange
    ContractCapsule contract = new ContractCapsule(new byte[] {});

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
    ABI actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertSame(entrysList, instance.getEntrysOrBuilderList());
    assertArrayEquals(new byte[] {}, actualAbiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>Then return Instance InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_thenReturnInstanceInitializationErrorStringIsEmptyString2() {
    // Arrange and Act
    AbiCapsule actualAbiCapsule = new AbiCapsule(new byte[] {});

    // Assert
    ABI instance = actualAbiCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getEntrysCount());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<Entry> entrysList = instance.getEntrysList();
    assertTrue(entrysList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    ABI actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertSame(entrysList, instance.getEntrysOrBuilderList());
    assertArrayEquals(new byte[] {}, actualAbiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 0 A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_when0AAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("\n\n0\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 8 A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_when8AAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("\n\n8\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A0A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAA0aABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("\n\nA\nA\nA\nA\nA0A\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new AbiCapsule("A\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A"A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("\n\nA\nA\nA\nA\nA\"A\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A*A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("\n\nA\nA\nA\nA\nA*A\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("\n\n\b\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code " A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAABytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("\n\n\"\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code * A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAAABytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("\n\n*\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When A A A A A backspace A A Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAAAAABackspaceAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("\n\nA\nA\nA\nA\nA\bA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithAAndLf_thenReturnInstanceIsNull() {
    // Arrange and Act
    AbiCapsule actualAbiCapsule =
        new AbiCapsule(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 0, '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualAbiCapsule.getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithAAndLf_thenReturnInstanceIsNull2() {
    // Arrange and Act
    AbiCapsule actualAbiCapsule =
        new AbiCapsule(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 0, '\n', 0, '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualAbiCapsule.getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithLfAndLf_thenReturnInstanceIsNull() {
    // Arrange and Act
    AbiCapsule actualAbiCapsule =
        new AbiCapsule(
            new byte[] {
              '\n', '\n', 16, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualAbiCapsule.getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithLfAndLf_thenReturnInstanceIsNull2() {
    // Arrange and Act
    AbiCapsule actualAbiCapsule =
        new AbiCapsule(
            new byte[] {
              '\n', '\n', 26, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualAbiCapsule.getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithLfAndLf_thenReturnInstanceIsNull3() {
    // Arrange and Act
    AbiCapsule actualAbiCapsule =
        new AbiCapsule(
            new byte[] {
              '\n', '\n', 0, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualAbiCapsule.getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithLfAndLf_thenReturnInstanceIsNull4() {
    // Arrange and Act
    AbiCapsule actualAbiCapsule =
        new AbiCapsule(
            new byte[] {
              '\n', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', 16, 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualAbiCapsule.getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithLfAndLf_thenReturnInstanceIsNull5() {
    // Arrange and Act
    AbiCapsule actualAbiCapsule =
        new AbiCapsule(
            new byte[] {
              '\n', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', -1, 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualAbiCapsule.getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    AbiCapsule actualAbiCapsule =
        new AbiCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAbiCapsule.getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenArrayOfByteWithOneAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    AbiCapsule actualAbiCapsule = new AbiCapsule(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAbiCapsule.getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(ABI)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return Instance is DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(ABI)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(ABI)"})
  public void testNewAbiCapsule_whenDefaultInstance_thenReturnInstanceIsDefaultInstance() {
    // Arrange
    ABI abi = ABI.getDefaultInstance();

    // Act
    AbiCapsule actualAbiCapsule = new AbiCapsule(abi);

    // Assert
    assertEquals(abi, actualAbiCapsule.getInstance());
    assertArrayEquals(new byte[] {}, actualAbiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#AbiCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#AbiCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbiCapsule.<init>(byte[])"})
  public void testNewAbiCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AbiCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link AbiCapsule#AbiCapsule(byte[])} with data is array of {@code byte} with
   *       {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbiCapsule.getData()"})
  public void testGetData_givenAbiCapsuleWithDataIsArrayOfByteWithAAndX() {
    // Arrange
    AbiCapsule abiCapsule =
        new AbiCapsule(
            new byte[] {
              'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'
            });

    // Act and Assert
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'},
        abiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link AbiCapsule#AbiCapsule(byte[])} with data is array of {@code byte} with
   *       {@link Byte#MIN_VALUE} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbiCapsule.getData()"})
  public void testGetData_givenAbiCapsuleWithDataIsArrayOfByteWithMin_valueAndMinusOne() {
    // Arrange
    AbiCapsule abiCapsule =
        new AbiCapsule(
            new byte[] {
              Byte.MIN_VALUE,
              -1,
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              -1,
              'X'
            });

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X', Byte.MIN_VALUE, -1, 'A', 'X'
        },
        abiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link AbiCapsule#AbiCapsule(byte[])} with data is array of {@code byte} with
   *       {@link Byte#MIN_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbiCapsule.getData()"})
  public void testGetData_givenAbiCapsuleWithDataIsArrayOfByteWithMin_valueAndX() {
    // Arrange
    AbiCapsule abiCapsule =
        new AbiCapsule(
            new byte[] {
              Byte.MIN_VALUE,
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              -1,
              'X'
            });

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X', Byte.MIN_VALUE, 'X', 'A'
        },
        abiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link AbiCapsule#AbiCapsule(byte[])} with data is array of {@code byte} with
   *       {@code X} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbiCapsule.getData()"})
  public void testGetData_givenAbiCapsuleWithDataIsArrayOfByteWithXAndMinusOne() {
    // Arrange
    AbiCapsule abiCapsule =
        new AbiCapsule(
            new byte[] {
              'X', -1, -1, 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'
            });

    // Act and Assert
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, -1, 'X', 'X', -1, 'X'},
        abiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link AbiCapsule#AbiCapsule(byte[])} with data is empty array of {@code byte}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbiCapsule.getData()"})
  public void testGetData_givenAbiCapsuleWithDataIsEmptyArrayOfByte_thenReturnEmptyArrayOfByte() {
    // Arrange
    AbiCapsule abiCapsule = new AbiCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, abiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code X} and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbiCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithXAndA() {
    // Arrange
    AbiCapsule abiCapsule =
        new AbiCapsule(
            new byte[] {
              Byte.MIN_VALUE, -1, -1, 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'
            });

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X', Byte.MIN_VALUE, -1, -1, 'X', 'A'
        },
        abiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code X} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbiCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithXAndMinusOne() {
    // Arrange
    AbiCapsule abiCapsule =
        new AbiCapsule(
            new byte[] {
              'X', -1, -1, -1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'
            });

    // Act and Assert
    assertArrayEquals(
        new byte[] {'X', -1, -1, -1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'},
        abiCapsule.getData());
  }

  /**
   * Test {@link AbiCapsule#getInstance()}.
   *
   * <ul>
   *   <li>Given {@link AbiCapsule#AbiCapsule(byte[])} with data is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbiCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ABI AbiCapsule.getInstance()"})
  public void testGetInstance_givenAbiCapsuleWithDataIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AbiCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }
}
