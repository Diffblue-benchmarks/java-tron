package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.zksnark.IncrementalMerkleTreeContainer;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.IncrementalMerkleTree;
import org.tron.protos.contract.ShieldContract.PedersenHash;

public class IncrementalMerkleTreeCapsuleDiffblueTest {
  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>()"})
  public void testNewIncrementalMerkleTreeCapsule() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule();

    // Assert
    assertTrue(actualIncrementalMerkleTreeCapsule.getParents().isEmpty());
    assertArrayEquals(new byte[] {}, actualIncrementalMerkleTreeCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and two.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenArrayOfByteWithAAndTwo() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(
            new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and lf.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenArrayOfByteWithLfAndLf() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(
            new byte[] {'\n', '\n', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and two.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenArrayOfByteWithLfAndTwo() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(
            new byte[] {'\n', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenArrayOfByteWithLfAndZero() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(new byte[] {'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenArrayOfByteWithLfAndZero2() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(new byte[] {'\n', 0, 18, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and two.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenArrayOfByteWithTwentySixAndTwo() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(
            new byte[] {26, 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenArrayOfByteWithTwentySixAndX() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Parents Empty.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenEmptyArrayOfByte_thenReturnParentsEmpty() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(new byte[] {});

    // Assert
    assertTrue(actualIncrementalMerkleTreeCapsule.getParents().isEmpty());
    assertArrayEquals(new byte[] {}, actualIncrementalMerkleTreeCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenLf_thenReturnInstanceIsNull() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(
            new byte[] {'\n', 2, '\n', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenLf_thenReturnInstanceIsNull2() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(new byte[] {'\n', 0, '\n', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule("\nXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleTreeCapsule_whenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualIncrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule("XXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleTreeCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleTreeCapsule,
        actualIncrementalMerkleTreeCapsule.toMerkleTreeContainer().getTreeCapsule());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#getLeft()}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#getLeft()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeCapsule.getLeft()"})
  public void testGetLeft_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    PedersenHash actualLeft = new IncrementalMerkleTreeCapsule().getLeft();

    // Assert
    assertEquals("", actualLeft.getInitializationErrorString());
    assertEquals(0, actualLeft.getSerializedSize());
    assertTrue(actualLeft.findInitializationErrors().isEmpty());
    assertTrue(actualLeft.getAllFields().isEmpty());
    assertTrue(actualLeft.isInitialized());
    PedersenHash actualDefaultInstanceForType = actualLeft.getDefaultInstanceForType();
    assertSame(actualLeft, actualDefaultInstanceForType);
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#leftIsEmpty()}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#leftIsEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean IncrementalMerkleTreeCapsule.leftIsEmpty()"})
  public void testLeftIsEmpty_givenIncrementalMerkleTreeCapsule_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new IncrementalMerkleTreeCapsule().leftIsEmpty());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#clearLeft()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#clearLeft()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.clearLeft()"})
  public void testClearLeft() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();

    // Act
    incrementalMerkleTreeCapsule.clearLeft();

    // Assert
    IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    IncrementalMerkleTree actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#clearLeft()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#clearLeft()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.clearLeft()"})
  public void testClearLeft2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    PedersenHash parents = PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.addParents(parents);

    // Act
    incrementalMerkleTreeCapsule.clearLeft();

    // Assert that nothing has changed
    IncrementalMerkleTree defaultInstanceForType =
        incrementalMerkleTreeCapsule.getInstance().getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getParentsCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertFalse(defaultInstanceForType.hasLeft());
    assertFalse(defaultInstanceForType.hasRight());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    List<PedersenHash> parentsList = defaultInstanceForType.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(parentsList, defaultInstanceForType.getParentsOrBuilderList());
    assertSame(parents, defaultInstanceForType.getLeft());
    assertSame(parents, defaultInstanceForType.getLeftOrBuilder());
    assertSame(parents, defaultInstanceForType.getRight());
    assertSame(parents, defaultInstanceForType.getRightOrBuilder());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#clearLeft()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#clearLeft()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.clearLeft()"})
  public void testClearLeft3() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(new byte[] {});

    // Act
    incrementalMerkleTreeCapsule.clearLeft();

    // Assert that nothing has changed
    IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    IncrementalMerkleTree actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#getRight()}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#getRight()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeCapsule.getRight()"})
  public void testGetRight_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    PedersenHash actualRight = new IncrementalMerkleTreeCapsule().getRight();

    // Assert
    assertEquals("", actualRight.getInitializationErrorString());
    assertEquals(0, actualRight.getSerializedSize());
    assertTrue(actualRight.findInitializationErrors().isEmpty());
    assertTrue(actualRight.getAllFields().isEmpty());
    assertTrue(actualRight.isInitialized());
    PedersenHash actualDefaultInstanceForType = actualRight.getDefaultInstanceForType();
    assertSame(actualRight, actualDefaultInstanceForType);
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#rightIsEmpty()}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#rightIsEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean IncrementalMerkleTreeCapsule.rightIsEmpty()"})
  public void testRightIsEmpty_givenIncrementalMerkleTreeCapsule_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new IncrementalMerkleTreeCapsule().rightIsEmpty());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#clearRight()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#clearRight()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.clearRight()"})
  public void testClearRight() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();

    // Act
    incrementalMerkleTreeCapsule.clearRight();

    // Assert
    IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    IncrementalMerkleTree actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#clearRight()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#clearRight()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.clearRight()"})
  public void testClearRight2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    PedersenHash parents = PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.addParents(parents);

    // Act
    incrementalMerkleTreeCapsule.clearRight();

    // Assert that nothing has changed
    IncrementalMerkleTree defaultInstanceForType =
        incrementalMerkleTreeCapsule.getInstance().getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getParentsCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertFalse(defaultInstanceForType.hasLeft());
    assertFalse(defaultInstanceForType.hasRight());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    List<PedersenHash> parentsList = defaultInstanceForType.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(parentsList, defaultInstanceForType.getParentsOrBuilderList());
    assertSame(parents, defaultInstanceForType.getLeft());
    assertSame(parents, defaultInstanceForType.getLeftOrBuilder());
    assertSame(parents, defaultInstanceForType.getRight());
    assertSame(parents, defaultInstanceForType.getRightOrBuilder());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#clearRight()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#clearRight()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.clearRight()"})
  public void testClearRight3() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule =
        new IncrementalMerkleTreeCapsule(new byte[] {});

    // Act
    incrementalMerkleTreeCapsule.clearRight();

    // Assert that nothing has changed
    IncrementalMerkleTree instance = incrementalMerkleTreeCapsule.getInstance();
    IncrementalMerkleTree actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#getParents()}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#getParents()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List IncrementalMerkleTreeCapsule.getParents()"})
  public void testGetParents_givenIncrementalMerkleTreeCapsule_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new IncrementalMerkleTreeCapsule().getParents().isEmpty());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#parentsIsEmpty()}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#parentsIsEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean IncrementalMerkleTreeCapsule.parentsIsEmpty()"})
  public void testParentsIsEmpty_givenIncrementalMerkleTreeCapsule_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new IncrementalMerkleTreeCapsule().parentsIsEmpty());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#parentsIsEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#parentsIsEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean IncrementalMerkleTreeCapsule.parentsIsEmpty()"})
  public void testParentsIsEmpty_thenReturnFalse() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.addParents(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertFalse(incrementalMerkleTreeCapsule.parentsIsEmpty());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#clearParents(int)}.
   *
   * <ul>
   *   <li>Then {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()} Parents size is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#clearParents(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeCapsule.clearParents(int)"})
  public void testClearParents_thenIncrementalMerkleTreeCapsuleParentsSizeIsTwo() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.addParents(PedersenHash.getDefaultInstance());
    PedersenHash parents = PedersenHash.getDefaultInstance();
    incrementalMerkleTreeCapsule.addParents(parents);

    // Act
    incrementalMerkleTreeCapsule.clearParents(1);

    // Assert
    List<PedersenHash> parents2 = incrementalMerkleTreeCapsule.getParents();
    assertEquals(2, parents2.size());
    assertEquals(parents, parents2.get(1));
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#isEmptyTree()}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#isEmptyTree()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTreeCapsule.isEmptyTree()"})
  public void testIsEmptyTree_givenIncrementalMerkleTreeCapsule_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new IncrementalMerkleTreeCapsule().isEmptyTree());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#isEmptyTree()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#isEmptyTree()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTreeCapsule.isEmptyTree()"})
  public void testIsEmptyTree_thenReturnFalse() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.addParents(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertFalse(incrementalMerkleTreeCapsule.isEmptyTree());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#notEmptyTree()}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#notEmptyTree()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTreeCapsule.notEmptyTree()"})
  public void testNotEmptyTree_givenIncrementalMerkleTreeCapsule_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new IncrementalMerkleTreeCapsule().notEmptyTree());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#notEmptyTree()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#notEmptyTree()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTreeCapsule.notEmptyTree()"})
  public void testNotEmptyTree_thenReturnTrue() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.addParents(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertTrue(incrementalMerkleTreeCapsule.notEmptyTree());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleTreeCapsule.getData()"})
  public void testGetData_givenIncrementalMerkleTreeCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new IncrementalMerkleTreeCapsule().getData());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleTreeCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentySixAndZero() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.addParents(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[] {26, 0}, incrementalMerkleTreeCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#getInstance()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTree IncrementalMerkleTreeCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    IncrementalMerkleTree actualInstance = new IncrementalMerkleTreeCapsule().getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getParentsCount());
    assertEquals(0, actualInstance.getSerializedSize());
    assertFalse(actualInstance.hasLeft());
    assertFalse(actualInstance.hasRight());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    List<PedersenHash> parentsList = actualInstance.getParentsList();
    assertTrue(parentsList.isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.isInitialized());
    IncrementalMerkleTree actualDefaultInstanceForType = actualInstance.getDefaultInstanceForType();
    assertSame(actualInstance, actualDefaultInstanceForType);
    assertSame(parentsList, actualInstance.getParentsOrBuilderList());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#toMerkleTreeContainer()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#toMerkleTreeContainer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "IncrementalMerkleTreeContainer IncrementalMerkleTreeCapsule.toMerkleTreeContainer()"
  })
  public void testToMerkleTreeContainer() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();

    // Act
    IncrementalMerkleTreeContainer actualToMerkleTreeContainerResult =
        incrementalMerkleTreeCapsule.toMerkleTreeContainer();

    // Assert
    assertEquals(0, actualToMerkleTreeContainerResult.size());
    assertEquals(0, actualToMerkleTreeContainerResult.toVoucher().size());
    assertSame(incrementalMerkleTreeCapsule, actualToMerkleTreeContainerResult.getTreeCapsule());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualToMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualToMerkleTreeContainerResult.getRootArray());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#deepCopy()}.
   *
   * <ul>
   *   <li>Then return Instance ParentsCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#deepCopy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeCapsule IncrementalMerkleTreeCapsule.deepCopy()"})
  public void testDeepCopy_thenReturnInstanceParentsCountIsZero() throws ZksnarkException {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualDeepCopyResult =
        new IncrementalMerkleTreeCapsule().deepCopy();

    // Assert
    IncrementalMerkleTree instance = actualDeepCopyResult.getInstance();
    assertEquals(0, instance.getParentsCount());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(3, instance.getDescriptorForType().getFields().size());
    assertTrue(actualDeepCopyResult.getParents().isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    IncrementalMerkleTree actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertArrayEquals(new byte[] {}, actualDeepCopyResult.getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult =
        actualDeepCopyResult.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getRootArray());
  }

  /**
   * Test {@link IncrementalMerkleTreeCapsule#deepCopy()}.
   *
   * <ul>
   *   <li>Then return Parents size is one.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeCapsule#deepCopy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeCapsule IncrementalMerkleTreeCapsule.deepCopy()"})
  public void testDeepCopy_thenReturnParentsSizeIsOne() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    incrementalMerkleTreeCapsule.addParents(PedersenHash.getDefaultInstance());

    // Act
    IncrementalMerkleTreeCapsule actualDeepCopyResult = incrementalMerkleTreeCapsule.deepCopy();

    // Assert
    assertEquals(1, actualDeepCopyResult.getParents().size());
    IncrementalMerkleTree instance = actualDeepCopyResult.getInstance();
    assertEquals(1, instance.getParentsCount());
    assertEquals(2, instance.getSerializedSize());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult =
        actualDeepCopyResult.toMerkleTreeContainer();
    IncrementalMerkleVoucherCapsule voucherCapsule =
        toMerkleTreeContainerResult.toVoucher().getVoucherCapsule();
    assertEquals(4, voucherCapsule.getInstance().getSerializedSize());
    assertArrayEquals(new byte[] {}, voucherCapsule.getCursor().getData());
    assertArrayEquals(new byte[] {26, 0}, actualDeepCopyResult.getData());
    assertArrayEquals(new byte[] {26, 0}, voucherCapsule.getTree().getData());
    assertArrayEquals(new byte[] {'\n', 2, 26, 0}, voucherCapsule.getData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getRootArray());
  }
}
