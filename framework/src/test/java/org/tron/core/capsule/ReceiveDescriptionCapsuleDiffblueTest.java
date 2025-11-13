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
import org.tron.protos.contract.ShieldContract.ReceiveDescription;

public class ReceiveDescriptionCapsuleDiffblueTest {
  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>()"})
  public void testNewReceiveDescriptionCapsule() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new ReceiveDescriptionCapsule().getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>Then return Data is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(new byte[] {});

    // Assert
    assertArrayEquals(new byte[] {}, actualReceiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 2 A A A A A A A} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_when2AAAAAAABytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new ReceiveDescriptionCapsule("2\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_when2xaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ReceiveDescriptionCapsule("2XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenAAAAAAAABytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new ReceiveDescriptionCapsule("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new ReceiveDescriptionCapsule("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code " A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new ReceiveDescriptionCapsule("\"\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code * A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new ReceiveDescriptionCapsule("*\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWith2AndZero() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(new byte[] {'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualReceiveDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and lf.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithAAndLf() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 0, '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualReceiveDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and zero.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithAsteriskAndZero() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(new byte[] {'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualReceiveDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and lf.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithEighteenAndLf() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(
            new byte[] {
              18, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualReceiveDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualReceiveDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualReceiveDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualReceiveDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code "} and zero.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithQuotationMarkAndZero() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(new byte[] {'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualReceiveDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and lf.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithTwentySixAndLf() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(
            new byte[] {
              26, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualReceiveDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithTwentySixAndX() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualReceiveDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualReceiveDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithZeroAndX() {
    // Arrange and Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualReceiveDescriptionCapsule.getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ReceiveDescriptionCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(ByteString, ByteString,
   * ByteString, ByteString, ByteString, ByteString)}.
   *
   * <ul>
   *   <li>When {@link ByteString}.
   *   <li>Then return Cm is {@link ByteString}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(ByteString,
   * ByteString, ByteString, ByteString, ByteString, ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReceiveDescriptionCapsule.<init>(ByteString, ByteString, ByteString, ByteString, ByteString, ByteString)"
  })
  public void testNewReceiveDescriptionCapsule_whenByteString_thenReturnCmIsByteString() {
    // Arrange
    ByteString cv = mock(ByteString.class);
    ByteString cm = mock(ByteString.class);
    ByteString ephemeralKey = mock(ByteString.class);
    ByteString encCiphertext = mock(ByteString.class);
    ByteString outCiphertext = mock(ByteString.class);
    ByteString zkproof = mock(ByteString.class);

    // Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule =
        new ReceiveDescriptionCapsule(cv, cm, ephemeralKey, encCiphertext, outCiphertext, zkproof);

    // Assert
    assertSame(cm, actualReceiveDescriptionCapsule.getCm());
    assertSame(encCiphertext, actualReceiveDescriptionCapsule.getEncCiphertext());
    assertSame(ephemeralKey, actualReceiveDescriptionCapsule.getEphemeralKey());
    assertSame(outCiphertext, actualReceiveDescriptionCapsule.getOutCiphertext());
    assertSame(cv, actualReceiveDescriptionCapsule.getValueCommitment());
    assertSame(zkproof, actualReceiveDescriptionCapsule.getZkproof());
    assertArrayEquals(
        new byte[] {'\n', 0, 18, 0, 26, 0, '"', 0, '*', 0, '2', 0},
        actualReceiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code "XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ReceiveDescriptionCapsule("\"XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code *XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ReceiveDescriptionCapsule("*XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ReceiveDescriptionCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getValueCommitment()}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#getValueCommitment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString ReceiveDescriptionCapsule.getValueCommitment()"})
  public void testGetValueCommitment() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    ByteString actualValueCommitment = receiveDescriptionCapsule.getValueCommitment();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getCm());
    assertSame(byteString, receiveDescriptionCapsule.getEncCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, actualValueCommitment);
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("\n\bAXAXAXAX".getBytes("UTF-8"), receiveDescriptionCapsule.getData());
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    ByteString valueCommitment = receiveDescriptionCapsule.getValueCommitment();
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
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setValueCommitment(bytes);

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertSame(bytes, receiveDescriptionCapsule.getValueCommitment());
    assertSame(bytes, instance.getValueCommitment());
    assertArrayEquals(new byte[] {'\n', 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getEphemeralKey()}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#getEphemeralKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString ReceiveDescriptionCapsule.getEphemeralKey()"})
  public void testGetEphemeralKey() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    ByteString actualEphemeralKey = receiveDescriptionCapsule.getEphemeralKey();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getCm());
    assertSame(byteString, receiveDescriptionCapsule.getEncCiphertext());
    assertSame(byteString, actualEphemeralKey);
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#setEpk(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(byte[])"})
  public void testSetEpkWithByte() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setEpk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        receiveDescriptionCapsule.getData());
    ByteString ephemeralKey = receiveDescriptionCapsule.getEphemeralKey();
    assertFalse(ephemeralKey.isEmpty());
    ByteIterator iteratorResult = ephemeralKey.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals("AXAXAXAX", ephemeralKey.toStringUtf8());
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertSame(ephemeralKey, instance.getEpk());
    assertEquals(10, instance.getSerializedSize());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(ByteString)} with {@code ByteString}.
   *
   * <ul>
   *   <li>Then {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} Instance AllFields
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#setEpk(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(ByteString)"})
  public void testSetEpkWithByteString_thenReceiveDescriptionCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setEpk(bytes);

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertSame(bytes, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(bytes, instance.getEpk());
    assertArrayEquals(new byte[] {26, 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getEncCiphertext()}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#getEncCiphertext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString ReceiveDescriptionCapsule.getEncCiphertext()"})
  public void testGetEncCiphertext() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    ByteString actualEncCiphertext = receiveDescriptionCapsule.getEncCiphertext();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getCm());
    assertSame(byteString, actualEncCiphertext);
    assertSame(byteString, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#setCEnc(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(byte[])"})
  public void testSetCEncWithByte() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setCEnc("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("\"\bAXAXAXAX".getBytes("UTF-8"), receiveDescriptionCapsule.getData());
    ByteString encCiphertext = receiveDescriptionCapsule.getEncCiphertext();
    assertFalse(encCiphertext.isEmpty());
    ByteIterator iteratorResult = encCiphertext.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals("AXAXAXAX", encCiphertext.toStringUtf8());
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertSame(encCiphertext, instance.getCEnc());
    assertEquals(10, instance.getSerializedSize());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(ByteString)} with {@code ByteString}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#setCEnc(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(ByteString)"})
  public void testSetCEncWithByteString() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setCEnc(bytes);

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertSame(bytes, receiveDescriptionCapsule.getEncCiphertext());
    assertSame(bytes, instance.getCEnc());
    assertArrayEquals(new byte[] {'"', 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getOutCiphertext()}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#getOutCiphertext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString ReceiveDescriptionCapsule.getOutCiphertext()"})
  public void testGetOutCiphertext() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    ByteString actualOutCiphertext = receiveDescriptionCapsule.getOutCiphertext();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getCm());
    assertSame(byteString, receiveDescriptionCapsule.getEncCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(byteString, actualOutCiphertext);
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCOut(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#setCOut(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCOut(byte[])"})
  public void testSetCOutWithByte() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setCOut("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("*\bAXAXAXAX".getBytes("UTF-8"), receiveDescriptionCapsule.getData());
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    ByteString outCiphertext = receiveDescriptionCapsule.getOutCiphertext();
    assertFalse(outCiphertext.isEmpty());
    ByteIterator iteratorResult = outCiphertext.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals("AXAXAXAX", outCiphertext.toStringUtf8());
    assertSame(outCiphertext, instance.getCOut());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCOut(ByteString)} with {@code ByteString}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#setCOut(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCOut(ByteString)"})
  public void testSetCOutWithByteString() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setCOut(bytes);

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertSame(bytes, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(bytes, instance.getCOut());
    assertArrayEquals(new byte[] {'*', 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getCm()}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#getCm()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString ReceiveDescriptionCapsule.getCm()"})
  public void testGetCm() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act and Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getCm());
    assertSame(byteString, receiveDescriptionCapsule.getEncCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(byte[])"})
  public void testSetNoteCommitmentWithByte() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setNoteCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ByteString encCiphertext = receiveDescriptionCapsule.getEncCiphertext();
    assertEquals("", encCiphertext.toStringUtf8());
    ByteString cm = receiveDescriptionCapsule.getCm();
    assertEquals("AXAXAXAX", cm.toStringUtf8());
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertFalse(cm.isEmpty());
    assertFalse(encCiphertext.iterator().hasNext());
    assertTrue(encCiphertext.isEmpty());
    assertTrue(cm.iterator().hasNext());
    assertSame(encCiphertext, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(encCiphertext, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(encCiphertext, receiveDescriptionCapsule.getValueCommitment());
    assertSame(encCiphertext, receiveDescriptionCapsule.getZkproof());
    assertSame(encCiphertext, instance.getCEnc());
    assertSame(encCiphertext, instance.getCOut());
    assertSame(encCiphertext, instance.getEpk());
    assertSame(encCiphertext, instance.getValueCommitment());
    assertSame(encCiphertext, instance.getZkproof());
    assertArrayEquals(
        new byte[] {18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)} with {@code ByteString}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(ByteString)"})
  public void testSetNoteCommitmentWithByteString() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setNoteCommitment(bytes);

    // Assert
    ByteString encCiphertext = receiveDescriptionCapsule.getEncCiphertext();
    assertEquals("", encCiphertext.toStringUtf8());
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(encCiphertext.iterator().hasNext());
    assertTrue(encCiphertext.isEmpty());
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getCEnc());
    assertSame(byteString, instance.getCOut());
    assertSame(byteString, instance.getEpk());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertSame(bytes, receiveDescriptionCapsule.getCm());
    assertSame(bytes, instance.getNoteCommitment());
    assertArrayEquals(new byte[] {18, 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getZkproof()}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#getZkproof()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString ReceiveDescriptionCapsule.getZkproof()"})
  public void testGetZkproof() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    ByteString actualZkproof = receiveDescriptionCapsule.getZkproof();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getCm());
    assertSame(byteString, receiveDescriptionCapsule.getEncCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, actualZkproof);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setZkproof(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#setZkproof(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setZkproof(byte[])"})
  public void testSetZkproofWithByte() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setZkproof("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("2\bAXAXAXAX".getBytes("UTF-8"), receiveDescriptionCapsule.getData());
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    ByteString zkproof = receiveDescriptionCapsule.getZkproof();
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
   * Test {@link ReceiveDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    ByteString proof = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setZkproof(proof);

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertSame(proof, receiveDescriptionCapsule.getZkproof());
    assertSame(proof, instance.getZkproof());
    assertArrayEquals(new byte[] {'2', 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new ReceiveDescriptionCapsule().getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getInstance()}.
   *
   * <p>Method under test: {@link ReceiveDescriptionCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReceiveDescription ReceiveDescriptionCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    ReceiveDescription actualInstance = new ReceiveDescriptionCapsule().getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getSerializedSize());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    ReceiveDescription actualDefaultInstanceForType = actualInstance.getDefaultInstanceForType();
    assertEquals(actualInstance, actualDefaultInstanceForType);
  }
}
