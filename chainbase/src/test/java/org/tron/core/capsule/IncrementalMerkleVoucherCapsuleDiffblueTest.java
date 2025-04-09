package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.zksnark.IncrementalMerkleTreeContainer;
import org.tron.common.zksnark.IncrementalMerkleVoucherContainer;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.IncrementalMerkleVoucher;
import org.tron.protos.contract.ShieldContract.OutputPoint;
import org.tron.protos.contract.ShieldContract.PedersenHash;

public class IncrementalMerkleVoucherCapsuleDiffblueTest {
  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>()"})
  public void testNewIncrementalMerkleVoucherCapsule() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();

    // Assert
    assertEquals(0L, actualIncrementalMerkleVoucherCapsule.getCursorDepth());
    assertTrue(actualIncrementalMerkleVoucherCapsule.getFilled().isEmpty());
    assertArrayEquals(new byte[]{}, actualIncrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>Then return CursorDepth is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_thenReturnCursorDepthIsZero() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{});

    // Assert
    assertEquals(0L, actualIncrementalMerkleVoucherCapsule.getCursorDepth());
    assertTrue(actualIncrementalMerkleVoucherCapsule.getFilled().isEmpty());
    assertArrayEquals(new byte[]{}, actualIncrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithAsteriskAndTwo() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'*', 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithAsteriskAndZero() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithEighteenAndTwo() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{18, 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithLfAndTwo() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithLfAndZero() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code R} and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithRAndTwo() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'R', 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code R} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithRAndZero() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'R', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithTwentySixAndX() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with two and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenArrayOfByteWithTwoAndX() {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When {@code RXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenRxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        "RXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        "\nXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenXaxaxaxBytesIsUtf82() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        " XAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When {@code *XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenXaxaxaxBytesIsUtf83() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        "*XAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.<init>(byte[])"})
  public void testNewIncrementalMerkleVoucherCapsule_whenXxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    IncrementalMerkleVoucherCapsule actualIncrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        "XXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualIncrementalMerkleVoucherCapsule.getInstance());
    assertSame(actualIncrementalMerkleVoucherCapsule,
        actualIncrementalMerkleVoucherCapsule.toMerkleVoucherContainer().getVoucherCapsule());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getTree()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getTree()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeCapsule IncrementalMerkleVoucherCapsule.getTree()"})
  public void testGetTree() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());

    // Act
    IncrementalMerkleTreeCapsule actualTree = incrementalMerkleVoucherCapsule.getTree();

    // Assert
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = actualTree.toMerkleTreeContainer();
    IncrementalMerkleVoucherCapsule voucherCapsule = toMerkleTreeContainerResult.toVoucher().getVoucherCapsule();
    assertArrayEquals(new byte[]{}, voucherCapsule.getCursor().getData());
    assertArrayEquals(new byte[]{}, actualTree.getData());
    assertArrayEquals(new byte[]{'\n', 0}, voucherCapsule.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getRootArray());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getTree()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getTree()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeCapsule IncrementalMerkleVoucherCapsule.getTree()"})
  public void testGetTree_givenIncrementalMerkleVoucherCapsule() throws ZksnarkException {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualTree = (new IncrementalMerkleVoucherCapsule()).getTree();

    // Assert
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = actualTree.toMerkleTreeContainer();
    IncrementalMerkleVoucherCapsule voucherCapsule = toMerkleTreeContainerResult.toVoucher().getVoucherCapsule();
    assertArrayEquals(new byte[]{}, voucherCapsule.getCursor().getData());
    assertArrayEquals(new byte[]{}, actualTree.getData());
    assertArrayEquals(new byte[]{'\n', 0}, voucherCapsule.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getRootArray());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getFilled()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getFilled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List IncrementalMerkleVoucherCapsule.getFilled()"})
  public void testGetFilled_givenIncrementalMerkleVoucherCapsule_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new IncrementalMerkleVoucherCapsule()).getFilled().isEmpty());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getCursor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeCapsule IncrementalMerkleVoucherCapsule.getCursor()"})
  public void testGetCursor() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());

    // Act
    IncrementalMerkleTreeCapsule actualCursor = incrementalMerkleVoucherCapsule.getCursor();

    // Assert
    assertArrayEquals(new byte[]{}, actualCursor.getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = actualCursor.toMerkleTreeContainer();
    IncrementalMerkleVoucherCapsule voucherCapsule = toMerkleTreeContainerResult.toVoucher().getVoucherCapsule();
    assertArrayEquals(new byte[]{}, voucherCapsule.getTree().getData());
    assertArrayEquals(new byte[]{'\n', 0}, voucherCapsule.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getRootArray());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getCursor()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeCapsule IncrementalMerkleVoucherCapsule.getCursor()"})
  public void testGetCursor_givenIncrementalMerkleVoucherCapsule() throws ZksnarkException {
    // Arrange and Act
    IncrementalMerkleTreeCapsule actualCursor = (new IncrementalMerkleVoucherCapsule()).getCursor();

    // Assert
    assertArrayEquals(new byte[]{}, actualCursor.getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = actualCursor.toMerkleTreeContainer();
    IncrementalMerkleVoucherCapsule voucherCapsule = toMerkleTreeContainerResult.toVoucher().getVoucherCapsule();
    assertArrayEquals(new byte[]{}, voucherCapsule.getTree().getData());
    assertArrayEquals(new byte[]{'\n', 0}, voucherCapsule.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getRootArray());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#clearCursor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.clearCursor()"})
  public void testClearCursor() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(instance, instance.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#clearCursor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.clearCursor()"})
  public void testClearCursor2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(instance.hasCursor());
    assertArrayEquals(new byte[]{18, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#clearCursor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.clearCursor()"})
  public void testClearCursor3() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert that nothing has changed
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(instance.hasCursor());
    assertArrayEquals(new byte[]{'\n', 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#clearCursor()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.clearCursor()"})
  public void testClearCursor4() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert that nothing has changed
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertFalse(instance.hasCursor());
    assertTrue(instance.getAllFields().isEmpty());
    assertEquals(Short.SIZE, instance.getSerializedSize());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#clearCursor()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} CursorDepth is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.clearCursor()"})
  public void testClearCursor_givenIncrementalMerkleVoucherCapsuleCursorDepthIsTwo() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(2L);
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert that nothing has changed
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertFalse(instance.hasCursor());
    assertArrayEquals(new byte[]{18, 0, ' ', 2}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#clearCursor()}.
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.clearCursor()"})
  public void testClearCursor_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert that nothing has changed
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(instance.hasCursor());
    assertArrayEquals(new byte[]{18, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#clearCursor()}.
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance SerializedSize is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.clearCursor()"})
  public void testClearCursor_thenIncrementalMerkleVoucherCapsuleInstanceSerializedSizeIsEight() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert that nothing has changed
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertFalse(instance.hasCursor());
    assertArrayEquals(new byte[]{18, 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#clearCursor()}.
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance SerializedSize is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#clearCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.clearCursor()"})
  public void testClearCursor_thenIncrementalMerkleVoucherCapsuleInstanceSerializedSizeIsFour() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.clearCursor();

    // Assert that nothing has changed
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertFalse(instance.hasCursor());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getCursorDepth()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getCursorDepth()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long IncrementalMerkleVoucherCapsule.getCursorDepth()"})
  public void testGetCursorDepth_givenIncrementalMerkleVoucherCapsule_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new IncrementalMerkleVoucherCapsule()).getCursorDepth());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setCursorDepth(long)"})
  public void testSetCursorDepth() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, ' ', 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setCursorDepth(long)"})
  public void testSetCursorDepth2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{18, 0, 26, 0, ' ', 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setCursorDepth(long)"})
  public void testSetCursorDepth3() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(10, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{18, 0, ' ', 1, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}.
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setCursorDepth(long)"})
  public void testSetCursorDepth_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{' ', 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}.
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance AllFields size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setCursorDepth(long)"})
  public void testSetCursorDepth_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsTwo() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{18, 0, ' ', 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}.
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance AllFields size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#setCursorDepth(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setCursorDepth(long)"})
  public void testSetCursorDepth_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsTwo2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());

    // Act
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, ' ', 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#resetRt()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#resetRt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.resetRt()"})
  public void testResetRt() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());

    // Act
    incrementalMerkleVoucherCapsule.resetRt();

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(36, instance.getSerializedSize());
    assertArrayEquals(new byte[]{26, 0, '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#resetRt()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#resetRt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.resetRt()"})
  public void testResetRt2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Act
    incrementalMerkleVoucherCapsule.resetRt();

    // Assert
    ByteString content = incrementalMerkleVoucherCapsule.getCursor().getLeft().getContent();
    assertEquals("", content.toStringUtf8());
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(40, instance.getSerializedSize());
    assertFalse(content.iterator().hasNext());
    assertTrue(content.isEmpty());
    assertSame(content, instance.getDefaultInstanceForType().getRt());
    assertSame(content, incrementalMerkleVoucherCapsule.getOutputPoint().getDefaultInstanceForType().getHash());
    assertArrayEquals(new byte[]{'*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#resetRt()}.
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Data is array of {@code byte} with lf and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#resetRt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.resetRt()"})
  public void testResetRt_thenIncrementalMerkleVoucherCapsuleDataIsArrayOfByteWithLfAndZero() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());

    // Act
    incrementalMerkleVoucherCapsule.resetRt();

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(36, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#resetRt()}.
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Data is array of {@code byte} with space and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#resetRt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.resetRt()"})
  public void testResetRt_thenIncrementalMerkleVoucherCapsuleDataIsArrayOfByteWithSpaceAndTwo()
      throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(2L);

    // Act
    incrementalMerkleVoucherCapsule.resetRt();

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(36, instance.getSerializedSize());
    assertArrayEquals(new byte[]{' ', 2, '*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#resetRt()}.
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#resetRt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.resetRt()"})
  public void testResetRt_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsOne() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();

    // Act
    incrementalMerkleVoucherCapsule.resetRt();

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(34, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'*', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getOutputPoint()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getOutputPoint()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldContract.OutputPoint IncrementalMerkleVoucherCapsule.getOutputPoint()"})
  public void testGetOutputPoint() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Act
    OutputPoint actualOutputPoint = incrementalMerkleVoucherCapsule.getOutputPoint();

    // Assert
    OutputPoint defaultInstanceForType = actualOutputPoint.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getIndex());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(1, actualOutputPoint.getIndex());
    assertEquals(2, actualOutputPoint.getAllFields().size());
    assertEquals(4, actualOutputPoint.getSerializedSize());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getOutputPoint()}.
   * <ul>
   *   <li>Then return Hash toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getOutputPoint()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ShieldContract.OutputPoint IncrementalMerkleVoucherCapsule.getOutputPoint()"})
  public void testGetOutputPoint_thenReturnHashToStringUtf8IsEmptyString() {
    // Arrange and Act
    OutputPoint actualOutputPoint = (new IncrementalMerkleVoucherCapsule()).getOutputPoint();

    // Assert
    ByteString hash = actualOutputPoint.getHash();
    assertEquals("", hash.toStringUtf8());
    assertEquals(0, actualOutputPoint.getIndex());
    assertEquals(0, actualOutputPoint.getSerializedSize());
    assertEquals(11, actualOutputPoint.getDescriptorForType().getFile().getMessageTypes().size());
    assertFalse(hash.iterator().hasNext());
    assertTrue(hash.isEmpty());
    assertTrue(actualOutputPoint.getAllFields().isEmpty());
    assertSame(actualOutputPoint, actualOutputPoint.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setOutputPoint(ByteString, int)"})
  public void testSetOutputPoint() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(10, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setOutputPoint(ByteString, int)"})
  public void testSetOutputPoint2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(10, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{18, 0, 26, 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} CursorDepth is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setOutputPoint(ByteString, int)"})
  public void testSetOutputPoint_givenIncrementalMerkleVoucherCapsuleCursorDepthIsTwo() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(2L);
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(10, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(new byte[]{18, 0, ' ', 2, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}.
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setOutputPoint(ByteString, int)"})
  public void testSetOutputPoint_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}.
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance AllFields size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setOutputPoint(ByteString, int)"})
  public void testSetOutputPoint_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsTwo() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{18, 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}.
   * <ul>
   *   <li>Then {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} Instance AllFields size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#setOutputPoint(ByteString, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherCapsule.setOutputPoint(ByteString, int)"})
  public void testSetOutputPoint_thenIncrementalMerkleVoucherCapsuleInstanceAllFieldsSizeIsTwo2() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());

    // Act
    incrementalMerkleVoucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Assert
    IncrementalMerkleVoucher instance = incrementalMerkleVoucherCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 'R', 4, '\n', 0, 16, 1}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getData()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleVoucherCapsule.getData()"})
  public void testGetData() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{18, 0, 26, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isEmpty()} return {@code true}.</li>
   *   <li>Then calls {@link ByteString#isEmpty()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleVoucherCapsule.getData()"})
  public void testGetData_givenByteStringIsEmptyReturnTrue_thenCallsIsEmpty() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, 0, 'R', 2, 16, 1}, actualData);
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getData()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} CursorDepth is {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleVoucherCapsule.getData()"})
  public void testGetData_givenIncrementalMerkleVoucherCapsuleCursorDepthIsMax_value() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(Long.MAX_VALUE);
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, 0, 18, 0, ' ', -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE, 'R', 2, 16, 1},
        actualData);
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getData()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} CursorDepth is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleVoucherCapsule.getData()"})
  public void testGetData_givenIncrementalMerkleVoucherCapsuleCursorDepthIsMinusOne() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(-1L);
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{18, 0, ' ', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getData()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} CursorDepth is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleVoucherCapsule.getData()"})
  public void testGetData_givenIncrementalMerkleVoucherCapsuleCursorDepthIsOne() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setCursorDepth(1L);
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 1);
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, 0, 18, 0, ' ', 1, 'R', 2, 16, 1}, actualData);
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getData()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} OutputPoint {@link ByteString} is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleVoucherCapsule.getData()"})
  public void testGetData_givenIncrementalMerkleVoucherCapsuleOutputPointByteStringIsMinusOne() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, -1);
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, 0, 'R', 11, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getData()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()} OutputPoint {@link ByteString} is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleVoucherCapsule.getData()"})
  public void testGetData_givenIncrementalMerkleVoucherCapsuleOutputPointByteStringIsZero() {
    // Arrange
    ByteString hash = mock(ByteString.class);
    when(hash.isEmpty()).thenReturn(true);

    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setOutputPoint(hash, 0);
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act
    byte[] actualData = incrementalMerkleVoucherCapsule.getData();

    // Assert
    verify(hash, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, 0, 'R', 0}, actualData);
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getData()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleVoucherCapsule#IncrementalMerkleVoucherCapsule()}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleVoucherCapsule.getData()"})
  public void testGetData_givenIncrementalMerkleVoucherCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new IncrementalMerkleVoucherCapsule()).getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleVoucherCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithEighteenAndZero() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{18, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with lf and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleVoucherCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithLfAndZero() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();
    incrementalMerkleVoucherCapsule.setTree(new IncrementalMerkleTreeCapsule());
    incrementalMerkleVoucherCapsule.addFilled(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, incrementalMerkleVoucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#getInstance()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucher IncrementalMerkleVoucherCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    IncrementalMerkleVoucher actualInstance = (new IncrementalMerkleVoucherCapsule()).getInstance();

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
    assertSame(actualInstance, actualInstance.getDefaultInstanceForType());
    assertSame(filledList, actualInstance.getFilledOrBuilderList());
  }

  /**
   * Test {@link IncrementalMerkleVoucherCapsule#toMerkleVoucherContainer()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherCapsule#toMerkleVoucherContainer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleVoucherContainer IncrementalMerkleVoucherCapsule.toMerkleVoucherContainer()"})
  public void testToMerkleVoucherContainer() {
    // Arrange
    IncrementalMerkleVoucherCapsule incrementalMerkleVoucherCapsule = new IncrementalMerkleVoucherCapsule();

    // Act
    IncrementalMerkleVoucherContainer actualToMerkleVoucherContainerResult = incrementalMerkleVoucherCapsule
        .toMerkleVoucherContainer();

    // Assert
    assertEquals(0, actualToMerkleVoucherContainerResult.size());
    assertSame(incrementalMerkleVoucherCapsule, actualToMerkleVoucherContainerResult.getVoucherCapsule());
  }
}
