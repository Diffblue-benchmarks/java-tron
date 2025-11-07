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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.SpendDescription;

public class SpendDescriptionCapsuleDiffblueTest {
  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule()}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>()"})
  public void testNewSpendDescriptionCapsule() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new SpendDescriptionCapsule()).getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>Then return Data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new SpendDescriptionCapsule(new byte[]{})).getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_when2xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule("2XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWith2AndZero() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithAsteriskAndZero() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithLfAndZero() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code "} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithQuotationMarkAndZero() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithTwentySixAndX() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenArrayOfByteWithZeroAndX() {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(ByteString, ByteString, ByteString, ByteString, ByteString, ByteString)}.
   * <ul>
   *   <li>When {@link ByteString}.</li>
   *   <li>Then return Anchor is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(ByteString, ByteString, ByteString, ByteString, ByteString, ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SpendDescriptionCapsule.<init>(ByteString, ByteString, ByteString, ByteString, ByteString, ByteString)"})
  public void testNewSpendDescriptionCapsule_whenByteString_thenReturnAnchorIsByteString() {
    // Arrange
    ByteString cv = mock(ByteString.class);
    ByteString anchor = mock(ByteString.class);
    ByteString nf = mock(ByteString.class);
    ByteString rk = mock(ByteString.class);
    ByteString zkproof = mock(ByteString.class);
    ByteString sig = mock(ByteString.class);

    // Act
    SpendDescriptionCapsule actualSpendDescriptionCapsule = new SpendDescriptionCapsule(cv, anchor, nf, rk, zkproof,
        sig);

    // Assert
    assertSame(anchor, actualSpendDescriptionCapsule.getAnchor());
    assertSame(nf, actualSpendDescriptionCapsule.getNullifier());
    assertSame(rk, actualSpendDescriptionCapsule.getRk());
    assertSame(sig, actualSpendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(cv, actualSpendDescriptionCapsule.getValueCommitment());
    assertSame(zkproof, actualSpendDescriptionCapsule.getZkproof());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 26, 0, '"', 0, '*', 0, '2', 0},
        actualSpendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code "XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule("\"XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code *XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule("*XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#SpendDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.<init>(byte[])"})
  public void testNewSpendDescriptionCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new SpendDescriptionCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getValueCommitment()}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Anchor is {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getValueCommitment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString SpendDescriptionCapsule.getValueCommitment()"})
  public void testGetValueCommitment_thenSpendDescriptionCapsuleAnchorIsEmpty() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualValueCommitment = spendDescriptionCapsule.getValueCommitment();

    // Assert
    ByteString byteString = actualValueCommitment.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, actualValueCommitment);
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    byte[] expectedData = "\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte2() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    spendDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte3() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    spendDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 26, '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte4() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    spendDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '"', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte5() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    spendDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '*', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte6() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Act
    spendDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '2', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString2() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    spendDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 18, '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString3() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    spendDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 26, '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString4() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    spendDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString5() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    spendDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '*', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString6() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Act
    spendDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getAnchor()}.
   * <ul>
   *   <li>Given {@link SpendDescriptionCapsule#SpendDescriptionCapsule()}.</li>
   *   <li>Then return {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getAnchor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString SpendDescriptionCapsule.getAnchor()"})
  public void testGetAnchor_givenSpendDescriptionCapsule_thenReturnEmpty() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualAnchor = spendDescriptionCapsule.getAnchor();

    // Assert
    ByteString byteString = actualAnchor.EMPTY;
    assertSame(byteString, actualAnchor);
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(byte[])"})
  public void testSetAnchorWithByte() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    spendDescriptionCapsule.setAnchor("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, spendDescriptionCapsule.getInstance().getSerializedSize());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(byte[])"})
  public void testSetAnchorWithByte2() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    spendDescriptionCapsule.setAnchor("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, spendDescriptionCapsule.getInstance().getSerializedSize());
    assertArrayEquals(
        new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '*', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(ByteString)"})
  public void testSetAnchorWithByteString() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setAnchor(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{18, 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(ByteString)"})
  public void testSetAnchorWithByteString2() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setAnchor(bytes);

    // Assert
    assertEquals(12, spendDescriptionCapsule.getInstance().getSerializedSize());
    ByteString expectedRk = bytes.EMPTY;
    assertSame(expectedRk, spendDescriptionCapsule.getRk());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 18, 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(ByteString)"})
  public void testSetAnchorWithByteString3() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    spendDescriptionCapsule.setAnchor(mock(ByteString.class));

    // Assert
    ByteString rk = spendDescriptionCapsule.getRk();
    assertEquals("", rk.toStringUtf8());
    assertFalse(rk.iterator().hasNext());
    assertTrue(rk.isEmpty());
    assertSame(rk, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(rk, spendDescriptionCapsule.getValueCommitment());
    assertSame(rk, spendDescriptionCapsule.getZkproof());
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertSame(rk, instance.getRk());
    assertSame(rk, instance.getSpendAuthoritySignature());
    assertSame(rk, instance.getValueCommitment());
    assertSame(rk, instance.getZkproof());
    assertArrayEquals(new byte[]{18, 0, 26, '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(ByteString)"})
  public void testSetAnchorWithByteString4() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    spendDescriptionCapsule.setAnchor(mock(ByteString.class));

    // Assert
    assertEquals(12, spendDescriptionCapsule.getInstance().getSerializedSize());
    assertArrayEquals(new byte[]{18, 0, '"', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(ByteString)"})
  public void testSetAnchorWithByteString5() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setAnchor(bytes);

    // Assert
    assertEquals(12, spendDescriptionCapsule.getInstance().getSerializedSize());
    ByteString expectedRk = bytes.EMPTY;
    assertSame(expectedRk, spendDescriptionCapsule.getRk());
    assertArrayEquals(new byte[]{18, 0, '*', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(ByteString)"})
  public void testSetAnchorWithByteString6() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setAnchor(bytes);

    // Assert
    assertEquals(4, spendDescriptionCapsule.getInstance().getSerializedSize());
    ByteString expectedRk = bytes.EMPTY;
    assertSame(expectedRk, spendDescriptionCapsule.getRk());
    assertArrayEquals(new byte[]{18, 0, '2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Given {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Rk is array of {@code byte} with {@code A} and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(byte[])"})
  public void testSetAnchorWithByte_givenSpendDescriptionCapsuleRkIsArrayOfByteWithAAndTwo()
      throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    spendDescriptionCapsule.setAnchor("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, spendDescriptionCapsule.getInstance().getSerializedSize());
    assertArrayEquals(
        new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '"', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(byte[])"})
  public void testSetAnchorWithByte_thenSpendDescriptionCapsuleInstanceAllFieldsSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setAnchor("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Instance SerializedSize is twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(byte[])"})
  public void testSetAnchorWithByte_thenSpendDescriptionCapsuleInstanceSerializedSizeIsTwelve()
      throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Act
    spendDescriptionCapsule.setAnchor("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, spendDescriptionCapsule.getInstance().getSerializedSize());
    assertArrayEquals(new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '2', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setAnchor(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Rk toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setAnchor(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setAnchor(byte[])"})
  public void testSetAnchorWithByte_thenSpendDescriptionCapsuleRkToStringUtf8IsEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    spendDescriptionCapsule.setAnchor("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ByteString rk = spendDescriptionCapsule.getRk();
    assertEquals("", rk.toStringUtf8());
    assertFalse(rk.iterator().hasNext());
    assertTrue(rk.isEmpty());
    assertSame(rk, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(rk, spendDescriptionCapsule.getValueCommitment());
    assertSame(rk, spendDescriptionCapsule.getZkproof());
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertSame(rk, instance.getRk());
    assertSame(rk, instance.getSpendAuthoritySignature());
    assertSame(rk, instance.getValueCommitment());
    assertSame(rk, instance.getZkproof());
    assertArrayEquals(
        new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 26, '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getNullifier()}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Anchor is {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getNullifier()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString SpendDescriptionCapsule.getNullifier()"})
  public void testGetNullifier_thenSpendDescriptionCapsuleAnchorIsEmpty() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualNullifier = spendDescriptionCapsule.getNullifier();

    // Assert
    ByteString byteString = actualNullifier.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, actualNullifier);
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(byte[])"})
  public void testSetNullifierWithByte() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    spendDescriptionCapsule.setNullifier("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4, 26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(byte[])"})
  public void testSetNullifierWithByte2() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    spendDescriptionCapsule.setNullifier("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertArrayEquals(
        new byte[]{26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '*', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(byte[])"})
  public void testSetNullifierWithByte3() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Act
    spendDescriptionCapsule.setNullifier("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '2', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(ByteString)"})
  public void testSetNullifierWithByteString() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setNullifier(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(ByteString)"})
  public void testSetNullifierWithByteString2() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, instance.getZkproof());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4, 26, 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(ByteString)"})
  public void testSetNullifierWithByteString3() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    ByteString rk = spendDescriptionCapsule.getRk();
    assertEquals("", rk.toStringUtf8());
    assertFalse(rk.iterator().hasNext());
    assertTrue(rk.isEmpty());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertSame(byteString, instance.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertArrayEquals(new byte[]{18, '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4, 26, 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(ByteString)"})
  public void testSetNullifierWithByteString4() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertArrayEquals(new byte[]{26, 0, '"', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(ByteString)"})
  public void testSetNullifierWithByteString5() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, instance.getSpendAuthoritySignature());
    assertSame(byteString, instance.getValueCommitment());
    assertArrayEquals(new byte[]{26, 0, '*', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(ByteString)"})
  public void testSetNullifierWithByteString6() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));
    ByteString bytes = mock(ByteString.class);

    // Act
    spendDescriptionCapsule.setNullifier(bytes);

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getRk());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertArrayEquals(new byte[]{26, 0, '2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Given {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Rk is array of {@code byte} with {@code A} and four.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(byte[])"})
  public void testSetNullifierWithByte_givenSpendDescriptionCapsuleRkIsArrayOfByteWithAAndFour()
      throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    spendDescriptionCapsule.setNullifier("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertArrayEquals(
        new byte[]{26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '"', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(byte[])"})
  public void testSetNullifierWithByte_thenSpendDescriptionCapsuleInstanceAllFieldsSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setNullifier("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setNullifier(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Rk toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setNullifier(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setNullifier(byte[])"})
  public void testSetNullifierWithByte_thenSpendDescriptionCapsuleRkToStringUtf8IsEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    spendDescriptionCapsule.setNullifier("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ByteString rk = spendDescriptionCapsule.getRk();
    assertEquals("", rk.toStringUtf8());
    assertFalse(rk.iterator().hasNext());
    assertTrue(rk.isEmpty());
    assertSame(rk, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(rk, spendDescriptionCapsule.getValueCommitment());
    assertSame(rk, spendDescriptionCapsule.getZkproof());
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertSame(rk, instance.getRk());
    assertSame(rk, instance.getSpendAuthoritySignature());
    assertSame(rk, instance.getValueCommitment());
    assertSame(rk, instance.getZkproof());
    assertArrayEquals(
        new byte[]{18, '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4, 26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getRk()}.
   * <ul>
   *   <li>Given {@link SpendDescriptionCapsule#SpendDescriptionCapsule()}.</li>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Anchor is {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getRk()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString SpendDescriptionCapsule.getRk()"})
  public void testGetRk_givenSpendDescriptionCapsule_thenSpendDescriptionCapsuleAnchorIsEmpty() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualRk = spendDescriptionCapsule.getRk();

    // Assert
    ByteString byteString = actualRk.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, actualRk);
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setRk(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(byte[])"})
  public void testSetRkWithByte() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setRk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    byte[] expectedData = "\n\bA\bA\bA\bA\b\"\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setRk(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(byte[])"})
  public void testSetRkWithByte2() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setRk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{18, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', '"', '\b', 'A', 'X', 'A', 'X',
        'A', 'X', 'A', 'X'}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setRk(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(byte[])"})
  public void testSetRkWithByte3() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setRk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', '"', '\b', 'A', 'X', 'A', 'X',
        'A', 'X', 'A', 'X'}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setRk(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(byte[])"})
  public void testSetRkWithByte4() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setRk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    byte[] expectedData = "\"\bAXAXAXAX*\bA\bA\bA\bA\b".getBytes("UTF-8");
    assertArrayEquals(expectedData, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(ByteString)"})
  public void testSetRkWithByteString() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setRk(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', '"', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(ByteString)"})
  public void testSetRkWithByteString2() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setRk(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{18, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', '"', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(ByteString)"})
  public void testSetRkWithByteString3() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setRk(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', '"', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(ByteString)"})
  public void testSetRkWithByteString4() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setRk(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'"', 0, '*', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b'},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(ByteString)"})
  public void testSetRkWithByteString_thenSpendDescriptionCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setRk(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'"', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Instance SerializedSize is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setRk(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(ByteString)"})
  public void testSetRkWithByteString_thenSpendDescriptionCapsuleInstanceSerializedSizeIsFour() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Act
    spendDescriptionCapsule.setRk(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'"', 0, '2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setRk(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(byte[])"})
  public void testSetRkWithByte_thenSpendDescriptionCapsuleInstanceAllFieldsSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setRk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    byte[] expectedData = "\"\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setRk(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Instance SerializedSize is twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setRk(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setRk(byte[])"})
  public void testSetRkWithByte_thenSpendDescriptionCapsuleInstanceSerializedSizeIsTwelve()
      throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Act
    spendDescriptionCapsule.setRk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '2', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getZkproof()}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Anchor is {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getZkproof()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString SpendDescriptionCapsule.getZkproof()"})
  public void testGetZkproof_thenSpendDescriptionCapsuleAnchorIsEmpty() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualZkproof = spendDescriptionCapsule.getZkproof();

    // Assert
    ByteString byteString = actualZkproof.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, spendDescriptionCapsule.getSpendAuthoritySignature());
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, actualZkproof);
  }

  /**
   * Test {@link SpendDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setZkproof(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'*', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString2() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    // Act
    spendDescriptionCapsule.setZkproof(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 16, 'A', 16, 'A', 16, 'A', 16, '*', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString3() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    // Act
    spendDescriptionCapsule.setZkproof(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{18, '\b', 'A', 16, 'A', 16, 'A', 16, 'A', 16, '*', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString4() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    // Act
    spendDescriptionCapsule.setZkproof(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, '\b', 'A', 16, 'A', 16, 'A', 16, 'A', 16, '*', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString5() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    // Act
    spendDescriptionCapsule.setZkproof(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'"', '\b', 'A', 16, 'A', 16, 'A', 16, 'A', 16, '*', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString6() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Act
    spendDescriptionCapsule.setZkproof(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'*', 0, '2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getSpendAuthoritySignature()}.
   * <ul>
   *   <li>Then {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Anchor is {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getSpendAuthoritySignature()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString SpendDescriptionCapsule.getSpendAuthoritySignature()"})
  public void testGetSpendAuthoritySignature_thenSpendDescriptionCapsuleAnchorIsEmpty() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    ByteString actualSpendAuthoritySignature = spendDescriptionCapsule.getSpendAuthoritySignature();

    // Assert
    ByteString byteString = actualSpendAuthoritySignature.EMPTY;
    assertSame(byteString, spendDescriptionCapsule.getAnchor());
    assertSame(byteString, spendDescriptionCapsule.getNullifier());
    assertSame(byteString, spendDescriptionCapsule.getRk());
    assertSame(byteString, actualSpendAuthoritySignature);
    assertSame(byteString, spendDescriptionCapsule.getValueCommitment());
    assertSame(byteString, spendDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setSpendAuthoritySignature(ByteString)"})
  public void testSetSpendAuthoritySignature() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'2', 0}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setSpendAuthoritySignature(ByteString)"})
  public void testSetSpendAuthoritySignature2() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment("A A A A ".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', '2', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setSpendAuthoritySignature(ByteString)"})
  public void testSetSpendAuthoritySignature3() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor("A A A A ".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{18, '\b', 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', '2', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setSpendAuthoritySignature(ByteString)"})
  public void testSetSpendAuthoritySignature4() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier("A A A A ".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, '\b', 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', '2', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setSpendAuthoritySignature(ByteString)"})
  public void testSetSpendAuthoritySignature5() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk("A A A A ".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'"', '\b', 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', '2', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#setSpendAuthoritySignature(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SpendDescriptionCapsule.setSpendAuthoritySignature(ByteString)"})
  public void testSetSpendAuthoritySignature6() throws UnsupportedEncodingException {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof("A A A A ".getBytes("UTF-8"));

    // Act
    spendDescriptionCapsule.setSpendAuthoritySignature(mock(ByteString.class));

    // Assert
    SpendDescription instance = spendDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'*', '\b', 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', '2', 0},
        spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isEmpty()} return {@code true}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData_givenByteStringIsEmptyReturnTrue_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Given {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Rk is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData_givenSpendDescriptionCapsuleRkIsByteString() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(bytes4);
    spendDescriptionCapsule.setNullifier(bytes3);
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Given {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} SpendAuthoritySignature is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData_givenSpendDescriptionCapsuleSpendAuthoritySignatureIsByteString() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);
    ByteString proof = mock(ByteString.class);
    when(proof.isEmpty()).thenReturn(true);
    ByteString bytes5 = mock(ByteString.class);
    when(bytes5.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setSpendAuthoritySignature(bytes5);
    spendDescriptionCapsule.setZkproof(proof);
    spendDescriptionCapsule.setRk(bytes4);
    spendDescriptionCapsule.setNullifier(bytes3);
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes5, atLeast(1)).isEmpty();
    verify(proof, atLeast(1)).isEmpty();
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Given {@link SpendDescriptionCapsule#SpendDescriptionCapsule()} Zkproof is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData_givenSpendDescriptionCapsuleZkproofIsByteString() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);
    ByteString proof = mock(ByteString.class);
    when(proof.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(proof);
    spendDescriptionCapsule.setRk(bytes4);
    spendDescriptionCapsule.setNullifier(bytes3);
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(proof, atLeast(1)).isEmpty();
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Given {@link SpendDescriptionCapsule#SpendDescriptionCapsule()}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData_givenSpendDescriptionCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new SpendDescriptionCapsule()).getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code *} and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithAsteriskAndBackspace() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setZkproof(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    spendDescriptionCapsule.setRk(bytes4);
    spendDescriptionCapsule.setNullifier(bytes3);
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'*', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with eighteen and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithEighteenAndBackspace() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with lf and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithLfAndBackspace() {
    // Arrange
    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setValueCommitment(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, spendDescriptionCapsule.getData());
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code "} and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithQuotationMarkAndBackspace() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setRk(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    spendDescriptionCapsule.setNullifier(bytes3);
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'"', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-six and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentySixAndBackspace() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{26, '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link SpendDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SpendDescriptionCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte2() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);

    SpendDescriptionCapsule spendDescriptionCapsule = new SpendDescriptionCapsule();
    spendDescriptionCapsule.setNullifier(bytes3);
    spendDescriptionCapsule.setAnchor(bytes2);
    spendDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = spendDescriptionCapsule.getData();

    // Assert
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link SpendDescriptionCapsule#getInstance()}.
   * <p>
   * Method under test: {@link SpendDescriptionCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpendDescription SpendDescriptionCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    SpendDescription actualInstance = (new SpendDescriptionCapsule()).getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getSerializedSize());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.isInitialized());
    assertEquals(actualInstance, actualInstance.getDefaultInstanceForType());
  }
}
