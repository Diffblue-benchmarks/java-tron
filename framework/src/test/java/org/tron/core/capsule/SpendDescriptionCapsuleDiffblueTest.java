package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.SpendDescription;

public class SpendDescriptionCapsuleDiffblueTest {
  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule()}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>()"})
  public void testNewSpendDescriptionCapsule() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new SpendDescriptionCapsule().getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>Then return Data is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(new byte[] {});

    // Assert
    assertArrayEquals(new byte[] {}, actualSpendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 2 A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_when2AAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new SpendDescriptionCapsule("2\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_when2xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new SpendDescriptionCapsule("2XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenAAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new SpendDescriptionCapsule("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new SpendDescriptionCapsule("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code " A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new SpendDescriptionCapsule("\"\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code * A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new SpendDescriptionCapsule("*\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWith2AndZero() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(new byte[] {'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualSpendDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and lf.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithAAndLf() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 0, '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualSpendDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and zero.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithAsteriskAndZero() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(new byte[] {'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualSpendDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and lf.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithEighteenAndLf() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(
            new byte[] {
              18, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualSpendDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualSpendDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualSpendDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualSpendDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code "} and zero.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithQuotationMarkAndZero() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(new byte[] {'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualSpendDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and lf.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithTwentySixAndLf() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(
            new byte[] {
              26, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualSpendDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithTwentySixAndX() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualSpendDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualSpendDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithZeroAndX() {
    // Arrange and Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualSpendDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new SpendDescriptionCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(ByteString, ByteString, ByteString,
   * ByteString, ByteString, ByteString)}.
   *
   * <ul>
   *   <li>When {@link ByteString}.
   *   <li>Then return Anchor is {@link ByteString}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(ByteString,
   * ByteString, ByteString, ByteString, ByteString, ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SpendDescriptionCapsule.<init>(ByteString, ByteString, ByteString, ByteString, ByteString, ByteString)"
  })
  public void testNewSpendDescriptionCapsule_whenByteString_thenReturnAnchorIsByteString() {
    // Arrange
    ByteString cv = mock(ByteString.class);
    ByteString anchor = mock(ByteString.class);
    ByteString nf = mock(ByteString.class);
    ByteString rk = mock(ByteString.class);
    ByteString zkproof = mock(ByteString.class);
    ByteString sig = mock(ByteString.class);

    // Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule =
        new SpendDescriptionCapsule(cv, anchor, nf, rk, zkproof, sig);

    // Assert
    assertSame(anchor, actualSpendDescriptionCapsule.getAnchor());
    assertSame(nf, actualSpendDescriptionCapsule.getNullifier());
    assertSame(rk, actualSpendDescriptionCapsule.getRk());
    assertSame(sig, actualSpendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(cv, actualSpendDescriptionCapsule.getValueCommitment());
    assertSame(zkproof, actualSpendDescriptionCapsule.getZkproof());
    assertArrayEquals(
        new byte[] {'\n', 0, 18, 0, 26, 0, '"', 0, '*', 0, '2', 0},
        actualSpendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code "XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new SpendDescriptionCapsule("\"XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code *XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new SpendDescriptionCapsule("*XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new SpendDescriptionCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getValueCommitment()}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#getValueCommitment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString SpendDescriptionCapsule.getValueCommitment()"})
  public void testGetValueCommitment() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualValueCommitment = spendDescriptionCapsule.getValueCommitment();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, actualValueCommitment);
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("\n\bAXAXAXAX".getBytes("UTF-8"), spendDescriptionCapsule.getData());
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    ByteString valueCommitment = spendDescriptionCapsule.getValueCommitment();
    assertFalse(valueCommitment.isEmpty());
    ByteIterator iteratorResult = valueCommitment.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals("AXAXAXAX", valueCommitment.toStringUtf8());
    assertSame(valueCommitment, instance.getValueCommitment());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertSame(bytes, spendDescriptionCapsule.getValueCommitment());
    assertSame(bytes, instance.getValueCommitment());
    assertArrayEquals(new byte[] {'\n', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getAnchor()}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#getAnchor()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString SpendDescriptionCapsule.getAnchor()"})
  public void testGetAnchor() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act and Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#setAnchor(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(byte[])"})
  public void testSetAnchorWithByte() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setAnchor("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ByteString nullifier = spendDescriptionCapsule.getNullifier();
    assertEquals("", nullifier.toStringUtf8());
    ByteString anchor = spendDescriptionCapsule.getAnchor();
    assertEquals("AXAXAXAX", anchor.toStringUtf8());
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertFalse(anchor.isEmpty());
    assertFalse(nullifier.iterator().hasNext());
    assertTrue(nullifier.isEmpty());
    assertTrue(anchor.iterator().hasNext());
    assertSame(nullifier, spendDescriptionCapsule.getRk());
    assertSame(nullifier, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(nullifier, spendDescriptionCapsule.getValueCommitment());
    assertSame(nullifier, spendDescriptionCapsule.getZkproof());
    assertSame(nullifier, instance.getNullifier());
    assertSame(nullifier, instance.getRk());
    assertSame(nullifier, instance.getSpendAuthoritySignature());
    assertSame(nullifier, instance.getValueCommitment());
    assertSame(nullifier, instance.getZkproof());
    assertArrayEquals(
        new byte[] {18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(ByteString)} with {@code ByteString}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(ByteString)"})
  public void testSetAnchorWithByteString() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setAnchor(bytes);

    // Assert
    ByteString nullifier = spendDescriptionCapsule.getNullifier();
    assertEquals("", nullifier.toStringUtf8());
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(nullifier.iterator().hasNext());
    assertTrue(nullifier.isEmpty());
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getNullifier());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(bytes, spendDescriptionCapsule.getAnchor());
    assertSame(bytes, instance.getAnchor());
    assertArrayEquals(new byte[] {18, 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getNullifier()}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#getNullifier()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString SpendDescriptionCapsule.getNullifier()"})
  public void testGetNullifier() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualNullifier = spendDescriptionCapsule.getNullifier();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, actualNullifier);
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#setNullifier(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(byte[])"})
  public void testSetNullifierWithByte() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setNullifier("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        spendDescriptionCapsule.getData());
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    ByteString nullifier = spendDescriptionCapsule.getNullifier();
    assertFalse(nullifier.isEmpty());
    ByteIterator iteratorResult = nullifier.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals("AXAXAXAX", nullifier.toStringUtf8());
    assertSame(nullifier, instance.getNullifier());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(ByteString)} with {@code ByteString}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(ByteString)"})
  public void testSetNullifierWithByteString() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertSame(bytes, spendDescriptionCapsule.getNullifier());
    assertSame(bytes, instance.getNullifier());
    assertArrayEquals(new byte[] {26, 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getRk()}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#getRk()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString SpendDescriptionCapsule.getRk()"})
  public void testGetRk() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualRk = spendDescriptionCapsule.getRk();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, actualRk);
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#setRk(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(byte[])"})
  public void testSetRkWithByte() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setRk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("\"\bAXAXAXAX".getBytes("UTF-8"), spendDescriptionCapsule.getData());
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    ByteString rk = spendDescriptionCapsule.getRk();
    assertFalse(rk.isEmpty());
    ByteIterator iteratorResult = rk.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals("AXAXAXAX", rk.toStringUtf8());
    assertSame(rk, instance.getRk());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(ByteString)} with {@code ByteString}.
   *
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Instance AllFields size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(ByteString)"})
  public void testSetRkWithByteString_thenSpendDescriptionCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setRk(bytes);

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertSame(bytes, spendDescriptionCapsule.getRk());
    assertSame(bytes, instance.getRk());
    assertArrayEquals(new byte[] {'"', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getZkproof()}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#getZkproof()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString SpendDescriptionCapsule.getZkproof()"})
  public void testGetZkproof() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualZkproof = spendDescriptionCapsule.getZkproof();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, actualZkproof);
  }

  /**
   * Test {@link SpendDescriptionCapsule#setZkproof(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#setZkproof(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.setZkproof(byte[])"})
  public void testSetZkproofWithByte() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setZkproof("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("*\bAXAXAXAX".getBytes("UTF-8"), spendDescriptionCapsule.getData());
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    ByteString zkproof = spendDescriptionCapsule.getZkproof();
    assertFalse(zkproof.isEmpty());
    ByteIterator iteratorResult = zkproof.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals("AXAXAXAX", zkproof.toStringUtf8());
    assertSame(zkproof, instance.getZkproof());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    ByteString proof = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setZkproof(proof);

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertSame(proof, spendDescriptionCapsule.getZkproof());
    assertSame(proof, instance.getZkproof());
    assertArrayEquals(new byte[] {'*', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getSpendAuthoritySignature()}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#getSpendAuthoritySignature()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString SpendDescriptionCapsule.getSpendAuthoritySignature()"})
  public void testGetSpendAuthoritySignature() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualSpendAuthoritySignature = spendDescriptionCapsule.getSpendAuthoritySignature();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, actualSpendAuthoritySignature);
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpendDescriptionCapsule.setSpendAuthoritySignature(ByteString)"})
  public void testSetSpendAuthoritySignature() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(bytes);

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertSame(bytes, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(bytes, instance.getSpendAuthoritySignature());
    assertArrayEquals(new byte[] {'2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new SpendDescriptionCapsule().getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getInstance()}.
   *
   * <p>Method under test: {@link SpendDescriptionCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SpendDescription SpendDescriptionCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    SpendDescription actualInstance = new SpendDescriptionCapsule().getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getSerializedSize());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    SpendDescription actualDefaultInstanceForType = actualInstance.getDefaultInstanceForType();
    assertEquals(actualInstance, actualDefaultInstanceForType);
  }
}
