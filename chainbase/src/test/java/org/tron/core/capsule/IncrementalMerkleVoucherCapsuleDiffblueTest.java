package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
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
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.zksnark.IncrementalMerkleVoucherContainer;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.IncrementalMerkleTree;
import org.tron.protos.contract.ShieldContract.IncrementalMerkleVoucher;
import org.tron.protos.contract.ShieldContract.OutputPoint;
import org.tron.protos.contract.ShieldContract.PedersenHash;

public class IncrementalMerkleVoucherCapsuleDiffblueTest {
  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>()"})
  public void testNewIncrementalMerkleVoucherCapsule() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule();

    // Assert
    assertEquals(0L, actualIncrementalMerkleVoucherCapsule.getCursorDepth());
    assertTrue(actualIncrementalMerkleVoucherCapsule.getFilled().isEmpty());
    assertArrayEquals(new byte[] {}, actualIncrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>Then return CursorDepth is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_thenReturnCursorDepthIsZero() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(new byte[] {});

    // Assert
    assertEquals(0L, actualIncrementalMerkleVoucherCapsule.getCursorDepth());
    assertTrue(actualIncrementalMerkleVoucherCapsule.getFilled().isEmpty());
    assertArrayEquals(new byte[] {}, actualIncrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and two.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithAAndTwo() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(
            new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and two.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithAsteriskAndTwo() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(
            new byte[] {'*', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithAsteriskAndZero() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(new byte[] {'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and two.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithEighteenAndTwo() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(
            new byte[] {18, 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and two.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithLfAndTwo() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(
            new byte[] {'\n', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithLfAndZero() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(new byte[] {'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code R} and two.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithRAndTwo() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(
            new byte[] {'R', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code R} and zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithRAndZero() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(new byte[] {'R', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithTwentySixAndX() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code RXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenRxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule("RXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule("\nXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenXaxaxaxBytesIsUtf82()
      throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule(" XAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code *XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenXaxaxaxBytesIsUtf83()
      throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule("*XAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule("XXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(
        actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getTree()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#getTree()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IncrementalMerkleTreeCapsule IncrementalMerkleVoucherCapsule.getTree()"})
  public void testGetTree() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualTree = new IncrementalMerkleVoucherCapsule().getTree();

    // Assert
    assertTrue(actualTree.getParents().isEmpty());
    assertArrayEquals(new byte[] {}, actualTree.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setTree(IncrementalMerkleTreeCapsule)}.
   *
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance
   *       AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#setTree(IncrementalMerkleTreeCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setTree(IncrementalMerkleTreeCapsule)"})
  public void testSetTree_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule();

    IncrementalMerkleTreeCapsule merkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(merkleTreeCapsule.getInstance()).thenReturn(IncrementalMerkleTree.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setTree(merkleTreeCapsule);

    // Assert
    verify(merkleTreeCapsule).getInstance();
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\n', 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setTree(IncrementalMerkleTreeCapsule)}.
   *
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance
   *       AllFields size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#setTree(IncrementalMerkleTreeCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setTree(IncrementalMerkleTreeCapsule)"})
  public void testSetTree_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsTwo() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());

    IncrementalMerkleTreeCapsule merkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(merkleTreeCapsule.getInstance()).thenReturn(IncrementalMerkleTree.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setTree(merkleTreeCapsule);

    // Assert
    verify(merkleTreeCapsule).getInstance();
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(instance.hasTree());
    assertArrayEquals(new byte[] {'\n', 0, 26, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setTree(IncrementalMerkleTreeCapsule)}.
   *
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance
   *       AllFields size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#setTree(IncrementalMerkleTreeCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setTree(IncrementalMerkleTreeCapsule)"})
  public void testSetTree_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsTwo2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(2L);

    IncrementalMerkleTreeCapsule merkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(merkleTreeCapsule.getInstance()).thenReturn(IncrementalMerkleTree.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setTree(merkleTreeCapsule);

    // Assert
    verify(merkleTreeCapsule).getInstance();
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(instance.hasTree());
    assertArrayEquals(new byte[] {'\n', 0, ' ', 2}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getFilled()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#getFilled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List IncrementalMerkleVoucherCapsule.getFilled()"})
  public void testGetFilled() {
    // Arrange, Act and Assert
    assertTrue(new IncrementalMerkleVoucherCapsule().getFilled().isEmpty());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getCursor()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#getCursor()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IncrementalMerkleTreeCapsule IncrementalMerkleVoucherCapsule.getCursor()"})
  public void testGetCursor() {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualCursor = new IncrementalMerkleVoucherCapsule().getCursor();

    // Assert
    assertTrue(actualCursor.getParents().isEmpty());
    assertArrayEquals(new byte[] {}, actualCursor.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setCursor(IncrementalMerkleTreeCapsule)}.
   *
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Data is
   *       array of {@code byte} with lf and zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#setCursor(IncrementalMerkleTreeCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IncrementalMerkleVoucherCapsule.setCursor(IncrementalMerkleTreeCapsule)"
  })
  public void testSetCursor_thenIncrementalMerkleVoucherCapsuleDataIsArrayOfByteWithLfAndZero() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());

    IncrementalMerkleTreeCapsule cursor = mock(IncrementalMerkleTreeCapsule.class);
    when(cursor.getInstance()).thenReturn(IncrementalMerkleTree.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setCursor(cursor);

    // Assert
    verify(cursor).getInstance();
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\n', 0, 26, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setCursor(IncrementalMerkleTreeCapsule)}.
   *
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance
   *       AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#setCursor(IncrementalMerkleTreeCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IncrementalMerkleVoucherCapsule.setCursor(IncrementalMerkleTreeCapsule)"
  })
  public void testSetCursor_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule();

    IncrementalMerkleTreeCapsule cursor = mock(IncrementalMerkleTreeCapsule.class);
    when(cursor.getInstance()).thenReturn(IncrementalMerkleTree.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setCursor(cursor);

    // Assert
    verify(cursor).getInstance();
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {26, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setCursor(IncrementalMerkleTreeCapsule)}.
   *
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance
   *       hasCursor.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherCapsule#setCursor(IncrementalMerkleTreeCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IncrementalMerkleVoucherCapsule.setCursor(IncrementalMerkleTreeCapsule)"
  })
  public void testSetCursor_thenIncrementalMerkleVoucherCapsuleInstanceHasCursor() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(2L);

    IncrementalMerkleTreeCapsule cursor = mock(IncrementalMerkleTreeCapsule.class);
    when(cursor.getInstance()).thenReturn(IncrementalMerkleTree.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setCursor(cursor);

    // Assert
    verify(cursor).getInstance();
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(instance.hasCursor());
    assertArrayEquals(new byte[] {26, 0, ' ', 2}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#clearCursor()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.clearCursor()"})
  public void testClearCursor() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule();

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    IncrementalMerkleVoucher actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getCursorDepth()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#getCursorDepth()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long IncrementalMerkleVoucherCapsule.getCursorDepth()"})
  public void testGetCursorDepth() {
    // Arrange, Act and Assert
    assertEquals(0L, new IncrementalMerkleVoucherCapsule().getCursorDepth());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setCursorDepth(long)"})
  public void testSetCursorDepth() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule();

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, incrementalMerkleVoucherCapsule.getCursorDepth());
    assertEquals(1L, instance.getCursorDepth());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {' ', 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#resetRt()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#resetRt()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.resetRt()"})
  public void testResetRt() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule();

    // Act
    incrementalMerkleVoucherCapsule.resetRt();

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(34, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {
          '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0
        },
        incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getOutputPoint()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#getOutputPoint()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ShieldContract.OutputPoint IncrementalMerkleVoucherCapsule.getOutputPoint()"})
  public void testGetOutputPoint() {
    // Arrange and Act
    OutputPoint actualOutputPoint = new IncrementalMerkleVoucherCapsule().getOutputPoint();

    // Assert
    assertEquals("", actualOutputPoint.getInitializationErrorString());
    assertEquals(0, actualOutputPoint.getIndex());
    assertEquals(0, actualOutputPoint.getSerializedSize());
    assertTrue(actualOutputPoint.findInitializationErrors().isEmpty());
    assertTrue(actualOutputPoint.getAllFields().isEmpty());
    assertTrue(actualOutputPoint.isInitialized());
    OutputPoint actualDefaultInstanceForType = actualOutputPoint.getDefaultInstanceForType();
    assertSame(actualOutputPoint, actualDefaultInstanceForType);
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}.
   *
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance
   *       AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setOutputPoint(ByteString, int)"})
  public void testSetOutputPoint_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule();
    ByteString hash = mock(ByteString.class);

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    OutputPoint outputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();
    assertEquals(1, outputPoint.getIndex());
    assertEquals(2, outputPoint.getAllFields().size());
    assertEquals(4, outputPoint.getSerializedSize());
    assertEquals(6, instance.getSerializedSize());
    assertTrue(instance.hasOutputPoint());
    assertSame(hash, outputPoint.getHash());
    assertArrayEquals(
        new byte[] {'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getData()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] IncrementalMerkleVoucherCapsule.getData()"})
  public void testGetData() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new IncrementalMerkleVoucherCapsule().getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getInstance()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucherCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    IncrementalMerkleVoucher actualInstance = new IncrementalMerkleVoucherCapsule().getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getFilledCount());
    assertEquals(0, actualInstance.getSerializedSize());
    assertEquals(0L, actualInstance.getCursorDepth());
    assertFalse(actualInstance.hasCursor());
    assertFalse(actualInstance.hasOutputPoint());
    assertFalse(actualInstance.hasTree());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    List<PedersenHash> filledList = actualInstance.getFilledList();
    assertTrue(filledList.isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.isInitialized());
    IncrementalMerkleVoucher actualDefaultInstanceForType =
        actualInstance.getDefaultInstanceForType();
    assertSame(actualInstance, actualDefaultInstanceForType);
    assertSame(filledList, actualInstance.getFilledOrBuilderList());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#toMerkleVoucherContainer()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherCapsule#toMerkleVoucherContainer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IncrementalMerkleVoucherContainer IncrementalMerkleVoucherCapsule.toMerkleVoucherContainer()"
  })
  public void testToMerkleVoucherContainer() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule =
        new IncrementalMerkleVoucherCapsule();

    // Act
    IncrementalMerkleVoucherContainer actualToMerkleVoucherContainerResult =
        incrementalMerkleVoucherCapsule.toMerkleVoucherContainer();

    // Assert
    assertEquals(0, actualToMerkleVoucherContainerResult.size());
    assertSame(
        incrementalMerkleVoucherCapsule, actualToMerkleVoucherContainerResult.getVoucherCapsule());
  }
}
