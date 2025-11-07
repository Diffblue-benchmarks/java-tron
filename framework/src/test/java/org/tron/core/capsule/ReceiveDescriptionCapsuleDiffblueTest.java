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
import org.tron.protos.contract.ShieldContract.ReceiveDescription;

public class ReceiveDescriptionCapsuleDiffblueTest {
  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>()"})
  public void testNewReceiveDescriptionCapsule() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new ReceiveDescriptionCapsule()).getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>Then return Data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_thenReturnDataIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new ReceiveDescriptionCapsule(new byte[]{})).getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_when2xaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule("2XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWith2AndZero() {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule(new byte[]{'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithAsteriskAndZero() {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule(new byte[]{'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithLfAndZero() {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code "} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithQuotationMarkAndZero() {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule(new byte[]{'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithTwentySixAndX() {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenArrayOfByteWithZeroAndX() {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(ByteString, ByteString, ByteString, ByteString, ByteString, ByteString)}.
   * <ul>
   *   <li>When {@link ByteString}.</li>
   *   <li>Then return Cm is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(ByteString, ByteString, ByteString, ByteString, ByteString, ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ReceiveDescriptionCapsule.<init>(ByteString, ByteString, ByteString, ByteString, ByteString, ByteString)"})
  public void testNewReceiveDescriptionCapsule_whenByteString_thenReturnCmIsByteString() {
    // Arrange
    ByteString cv = mock(ByteString.class);
    ByteString cm = mock(ByteString.class);
    ByteString ephemeralKey = mock(ByteString.class);
    ByteString encCiphertext = mock(ByteString.class);
    ByteString outCiphertext = mock(ByteString.class);
    ByteString zkproof = mock(ByteString.class);

    // Act
    ReceiveDescriptionCapsule actualReceiveDescriptionCapsule = new ReceiveDescriptionCapsule(cv, cm, ephemeralKey,
        encCiphertext, outCiphertext, zkproof);

    // Assert
    assertSame(cm, actualReceiveDescriptionCapsule.getCm());
    assertSame(encCiphertext, actualReceiveDescriptionCapsule.getEncCiphertext());
    assertSame(ephemeralKey, actualReceiveDescriptionCapsule.getEphemeralKey());
    assertSame(outCiphertext, actualReceiveDescriptionCapsule.getOutCiphertext());
    assertSame(cv, actualReceiveDescriptionCapsule.getValueCommitment());
    assertSame(zkproof, actualReceiveDescriptionCapsule.getZkproof());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 26, 0, '"', 0, '*', 0, '2', 0},
        actualReceiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code "XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule("\"XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code *XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule("*XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.<init>(byte[])"})
  public void testNewReceiveDescriptionCapsule_whenXxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ReceiveDescriptionCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getValueCommitment()}.
   * <ul>
   *   <li>Then {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} Cm is {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getValueCommitment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString ReceiveDescriptionCapsule.getValueCommitment()"})
  public void testGetValueCommitment_thenReceiveDescriptionCapsuleCmIsEmpty() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    ByteString actualValueCommitment = receiveDescriptionCapsule.getValueCommitment();

    // Assert
    ByteString byteString = actualValueCommitment.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getCm());
    assertSame(byteString, receiveDescriptionCapsule.getEncCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, actualValueCommitment);
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    byte[] expectedData = "\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte2() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setEpk(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    receiveDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 26, '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte3() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCEnc(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    receiveDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '"', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte4() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCOut(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    receiveDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '*', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte5() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setNoteCommitment(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    receiveDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(byte[])"})
  public void testSetValueCommitmentWithByte6() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setZkproof(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    receiveDescriptionCapsule.setValueCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '2', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString2() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setEpk(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    receiveDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 26, '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString3() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCEnc(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    receiveDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString4() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCOut(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    receiveDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '*', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString5() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setNoteCommitment(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    receiveDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 18, '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setValueCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setValueCommitment(ByteString)"})
  public void testSetValueCommitmentWithByteString6() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setZkproof(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    receiveDescriptionCapsule.setValueCommitment(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '2', '\b', 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getEphemeralKey()}.
   * <ul>
   *   <li>Then {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} Cm is {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getEphemeralKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString ReceiveDescriptionCapsule.getEphemeralKey()"})
  public void testGetEphemeralKey_thenReceiveDescriptionCapsuleCmIsEmpty() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    ByteString actualEphemeralKey = receiveDescriptionCapsule.getEphemeralKey();

    // Assert
    ByteString byteString = actualEphemeralKey.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getCm());
    assertSame(byteString, receiveDescriptionCapsule.getEncCiphertext());
    assertSame(byteString, actualEphemeralKey);
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setEpk(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(byte[])"})
  public void testSetEpkWithByte() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setValueCommitment(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    receiveDescriptionCapsule.setEpk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4, 26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setEpk(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(byte[])"})
  public void testSetEpkWithByte2() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setNoteCommitment(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    receiveDescriptionCapsule.setEpk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{18, '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4, 26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setEpk(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(byte[])"})
  public void testSetEpkWithByte3() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setZkproof(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    receiveDescriptionCapsule.setEpk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '2', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setEpk(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(ByteString)"})
  public void testSetEpkWithByteString() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setValueCommitment(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    receiveDescriptionCapsule.setEpk(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4, 26, 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setEpk(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(ByteString)"})
  public void testSetEpkWithByteString2() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCEnc(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    receiveDescriptionCapsule.setEpk(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, 0, '"', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setEpk(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(ByteString)"})
  public void testSetEpkWithByteString3() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCOut(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    receiveDescriptionCapsule.setEpk(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, 0, '*', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setEpk(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(ByteString)"})
  public void testSetEpkWithByteString4() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setNoteCommitment(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    receiveDescriptionCapsule.setEpk(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{18, '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4, 26, 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setEpk(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(ByteString)"})
  public void testSetEpkWithByteString5() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setZkproof(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    receiveDescriptionCapsule.setEpk(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, 0, '2', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setEpk(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(ByteString)"})
  public void testSetEpkWithByteString_thenReceiveDescriptionCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setEpk(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Given {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} CEnc is array of {@code byte} with {@code A} and four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setEpk(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(byte[])"})
  public void testSetEpkWithByte_givenReceiveDescriptionCapsuleCEncIsArrayOfByteWithAAndFour()
      throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCEnc(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    receiveDescriptionCapsule.setEpk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '"', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Given {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} COut is array of {@code byte} with {@code A} and four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setEpk(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(byte[])"})
  public void testSetEpkWithByte_givenReceiveDescriptionCapsuleCOutIsArrayOfByteWithAAndFour()
      throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCOut(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});

    // Act
    receiveDescriptionCapsule.setEpk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '*', '\b', 'A', 4, 'A', 4, 'A', 4, 'A', 4},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setEpk(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setEpk(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setEpk(byte[])"})
  public void testSetEpkWithByte_thenReceiveDescriptionCapsuleInstanceAllFieldsSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setEpk("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getEncCiphertext()}.
   * <ul>
   *   <li>Then {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} Cm is {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getEncCiphertext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString ReceiveDescriptionCapsule.getEncCiphertext()"})
  public void testGetEncCiphertext_thenReceiveDescriptionCapsuleCmIsEmpty() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    ByteString actualEncCiphertext = receiveDescriptionCapsule.getEncCiphertext();

    // Assert
    ByteString byteString = actualEncCiphertext.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getCm());
    assertSame(byteString, actualEncCiphertext);
    assertSame(byteString, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCEnc(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(byte[])"})
  public void testSetCEncWithByte() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setValueCommitment("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    receiveDescriptionCapsule.setCEnc("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    byte[] expectedData = "\n\bA\bA\bA\bA\b\"\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCEnc(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(byte[])"})
  public void testSetCEncWithByte2() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setEpk("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    receiveDescriptionCapsule.setCEnc("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    assertArrayEquals(new byte[]{26, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', '"', '\b', 'A', 'X', 'A', 'X',
        'A', 'X', 'A', 'X'}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCEnc(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(byte[])"})
  public void testSetCEncWithByte3() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCOut("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    receiveDescriptionCapsule.setCEnc("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    byte[] expectedData = "\"\bAXAXAXAX*\bA\bA\bA\bA\b".getBytes("UTF-8");
    assertArrayEquals(expectedData, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCEnc(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(byte[])"})
  public void testSetCEncWithByte4() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setNoteCommitment("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    receiveDescriptionCapsule.setCEnc("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ByteString ephemeralKey = receiveDescriptionCapsule.getEphemeralKey();
    assertEquals("", ephemeralKey.toStringUtf8());
    assertFalse(ephemeralKey.iterator().hasNext());
    assertTrue(ephemeralKey.isEmpty());
    assertSame(ephemeralKey, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(ephemeralKey, receiveDescriptionCapsule.getValueCommitment());
    assertSame(ephemeralKey, receiveDescriptionCapsule.getZkproof());
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertSame(ephemeralKey, instance.getCOut());
    assertSame(ephemeralKey, instance.getEpk());
    assertSame(ephemeralKey, instance.getValueCommitment());
    assertSame(ephemeralKey, instance.getZkproof());
    assertArrayEquals(new byte[]{18, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', '"', '\b', 'A', 'X', 'A', 'X',
        'A', 'X', 'A', 'X'}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCEnc(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(byte[])"})
  public void testSetCEncWithByte5() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setZkproof("A\bA\bA\bA\b".getBytes("UTF-8"));

    // Act
    receiveDescriptionCapsule.setCEnc("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(20, instance.getSerializedSize());
    byte[] expectedData = "\"\bAXAXAXAX2\bA\bA\bA\bA\b".getBytes("UTF-8");
    assertArrayEquals(expectedData, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCEnc(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(ByteString)"})
  public void testSetCEncWithByteString() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setCEnc(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'"', 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCEnc(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(ByteString)"})
  public void testSetCEncWithByteString2() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setValueCommitment("A\bA\bA\bA\b".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setCEnc(bytes);

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getCOut());
    assertSame(byteString, instance.getEpk());
    assertSame(byteString, instance.getZkproof());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', '"', 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCEnc(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(ByteString)"})
  public void testSetCEncWithByteString3() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setEpk("A\bA\bA\bA\b".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setCEnc(bytes);

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getCOut());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertArrayEquals(new byte[]{26, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', '"', 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCEnc(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(ByteString)"})
  public void testSetCEncWithByteString4() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCOut("A\bA\bA\bA\b".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setCEnc(bytes);

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
    assertSame(byteString, instance.getEpk());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertArrayEquals(new byte[]{'"', 0, '*', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b'},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCEnc(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(ByteString)"})
  public void testSetCEncWithByteString5() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setNoteCommitment("A\bA\bA\bA\b".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setCEnc(bytes);

    // Assert
    ByteString ephemeralKey = receiveDescriptionCapsule.getEphemeralKey();
    assertEquals("", ephemeralKey.toStringUtf8());
    assertFalse(ephemeralKey.iterator().hasNext());
    assertTrue(ephemeralKey.isEmpty());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertSame(byteString, instance.getCOut());
    assertSame(byteString, instance.getEpk());
    assertSame(byteString, instance.getValueCommitment());
    assertSame(byteString, instance.getZkproof());
    assertArrayEquals(new byte[]{18, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', '"', 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCEnc(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(ByteString)"})
  public void testSetCEncWithByteString6() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setZkproof("A\bA\bA\bA\b".getBytes("UTF-8"));
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setCEnc(bytes);

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    ByteString byteString = bytes.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, instance.getCOut());
    assertSame(byteString, instance.getEpk());
    assertSame(byteString, instance.getValueCommitment());
    assertArrayEquals(new byte[]{'"', 0, '2', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b'},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCEnc(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCEnc(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCEnc(byte[])"})
  public void testSetCEncWithByte_thenReceiveDescriptionCapsuleInstanceAllFieldsSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setCEnc("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    byte[] expectedData = "\"\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getOutCiphertext()}.
   * <ul>
   *   <li>Then {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} Cm is {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getOutCiphertext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString ReceiveDescriptionCapsule.getOutCiphertext()"})
  public void testGetOutCiphertext_thenReceiveDescriptionCapsuleCmIsEmpty() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    ByteString actualOutCiphertext = receiveDescriptionCapsule.getOutCiphertext();

    // Assert
    ByteString byteString = actualOutCiphertext.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getCm());
    assertSame(byteString, receiveDescriptionCapsule.getEncCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(byteString, actualOutCiphertext);
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCOut(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCOut(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCOut(ByteString)"})
  public void testSetCOutWithByteString() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setCOut(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'*', 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCOut(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCOut(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCOut(ByteString)"})
  public void testSetCOutWithByteString2() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setValueCommitment(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    // Act
    receiveDescriptionCapsule.setCOut(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 16, 'A', 16, 'A', 16, 'A', 16, '*', 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCOut(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCOut(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCOut(ByteString)"})
  public void testSetCOutWithByteString3() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setEpk(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    // Act
    receiveDescriptionCapsule.setCOut(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, '\b', 'A', 16, 'A', 16, 'A', 16, 'A', 16, '*', 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCOut(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCOut(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCOut(ByteString)"})
  public void testSetCOutWithByteString4() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCEnc(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    // Act
    receiveDescriptionCapsule.setCOut(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'"', '\b', 'A', 16, 'A', 16, 'A', 16, 'A', 16, '*', 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCOut(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCOut(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCOut(ByteString)"})
  public void testSetCOutWithByteString5() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setNoteCommitment(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    // Act
    receiveDescriptionCapsule.setCOut(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{18, '\b', 'A', 16, 'A', 16, 'A', 16, 'A', 16, '*', 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setCOut(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setCOut(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setCOut(ByteString)"})
  public void testSetCOutWithByteString6() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setZkproof(new byte[]{'A', 16, 'A', 16, 'A', 16, 'A', 16});

    // Act
    receiveDescriptionCapsule.setCOut(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'*', 0, '2', '\b', 'A', 16, 'A', 16, 'A', 16, 'A', 16},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getCm()}.
   * <ul>
   *   <li>Given {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()}.</li>
   *   <li>Then return {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getCm()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString ReceiveDescriptionCapsule.getCm()"})
  public void testGetCm_givenReceiveDescriptionCapsule_thenReturnEmpty() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    ByteString actualCm = receiveDescriptionCapsule.getCm();

    // Assert
    ByteString byteString = actualCm.EMPTY;
    assertSame(byteString, actualCm);
    assertSame(byteString, receiveDescriptionCapsule.getEncCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, receiveDescriptionCapsule.getZkproof());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(byte[])"})
  public void testSetNoteCommitmentWithByte() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setNoteCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(byte[])"})
  public void testSetNoteCommitmentWithByte2() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setValueCommitment(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    receiveDescriptionCapsule.setNoteCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[]{'\n', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(byte[])"})
  public void testSetNoteCommitmentWithByte3() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setEpk(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    receiveDescriptionCapsule.setNoteCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 26, '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(byte[])"})
  public void testSetNoteCommitmentWithByte4() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCEnc(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    receiveDescriptionCapsule.setNoteCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ByteString ephemeralKey = receiveDescriptionCapsule.getEphemeralKey();
    assertEquals("", ephemeralKey.toStringUtf8());
    assertFalse(ephemeralKey.iterator().hasNext());
    assertTrue(ephemeralKey.isEmpty());
    assertSame(ephemeralKey, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(ephemeralKey, receiveDescriptionCapsule.getValueCommitment());
    assertSame(ephemeralKey, receiveDescriptionCapsule.getZkproof());
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertSame(ephemeralKey, instance.getCOut());
    assertSame(ephemeralKey, instance.getEpk());
    assertSame(ephemeralKey, instance.getValueCommitment());
    assertSame(ephemeralKey, instance.getZkproof());
    assertArrayEquals(
        new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '"', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(byte[])"})
  public void testSetNoteCommitmentWithByte5() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCOut(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    receiveDescriptionCapsule.setNoteCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '*', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(byte[])"})
  public void testSetNoteCommitmentWithByte6() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setZkproof(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    receiveDescriptionCapsule.setNoteCommitment("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[]{18, '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '2', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(ByteString)"})
  public void testSetNoteCommitmentWithByteString() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setNoteCommitment(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{18, 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(ByteString)"})
  public void testSetNoteCommitmentWithByteString2() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setValueCommitment(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setNoteCommitment(bytes);

    // Assert
    ByteString expectedEphemeralKey = bytes.EMPTY;
    assertSame(expectedEphemeralKey, receiveDescriptionCapsule.getEphemeralKey());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2, 18, 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(ByteString)"})
  public void testSetNoteCommitmentWithByteString3() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setEpk(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    receiveDescriptionCapsule.setNoteCommitment(mock(ByteString.class));

    // Assert
    assertArrayEquals(new byte[]{18, 0, 26, '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(ByteString)"})
  public void testSetNoteCommitmentWithByteString4() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCEnc(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    receiveDescriptionCapsule.setNoteCommitment(mock(ByteString.class));

    // Assert
    ByteString ephemeralKey = receiveDescriptionCapsule.getEphemeralKey();
    assertEquals("", ephemeralKey.toStringUtf8());
    assertFalse(ephemeralKey.iterator().hasNext());
    assertTrue(ephemeralKey.isEmpty());
    assertSame(ephemeralKey, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(ephemeralKey, receiveDescriptionCapsule.getValueCommitment());
    assertSame(ephemeralKey, receiveDescriptionCapsule.getZkproof());
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertSame(ephemeralKey, instance.getCOut());
    assertSame(ephemeralKey, instance.getEpk());
    assertSame(ephemeralKey, instance.getValueCommitment());
    assertSame(ephemeralKey, instance.getZkproof());
    assertArrayEquals(new byte[]{18, 0, '"', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(ByteString)"})
  public void testSetNoteCommitmentWithByteString5() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCOut(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setNoteCommitment(bytes);

    // Assert
    ByteString expectedEphemeralKey = bytes.EMPTY;
    assertSame(expectedEphemeralKey, receiveDescriptionCapsule.getEphemeralKey());
    assertArrayEquals(new byte[]{18, 0, '*', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setNoteCommitment(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setNoteCommitment(ByteString)"})
  public void testSetNoteCommitmentWithByteString6() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setZkproof(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    ByteString bytes = mock(ByteString.class);

    // Act
    receiveDescriptionCapsule.setNoteCommitment(bytes);

    // Assert
    ByteString expectedEphemeralKey = bytes.EMPTY;
    assertSame(expectedEphemeralKey, receiveDescriptionCapsule.getEphemeralKey());
    assertArrayEquals(new byte[]{18, 0, '2', '\b', 'A', 2, 'A', 2, 'A', 2, 'A', 2},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getZkproof()}.
   * <ul>
   *   <li>Then {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} Cm is {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getZkproof()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString ReceiveDescriptionCapsule.getZkproof()"})
  public void testGetZkproof_thenReceiveDescriptionCapsuleCmIsEmpty() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    ByteString actualZkproof = receiveDescriptionCapsule.getZkproof();

    // Assert
    ByteString byteString = actualZkproof.EMPTY;
    assertSame(byteString, receiveDescriptionCapsule.getCm());
    assertSame(byteString, receiveDescriptionCapsule.getEncCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getEphemeralKey());
    assertSame(byteString, receiveDescriptionCapsule.getOutCiphertext());
    assertSame(byteString, receiveDescriptionCapsule.getValueCommitment());
    assertSame(byteString, actualZkproof);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();

    // Act
    receiveDescriptionCapsule.setZkproof(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'2', 0}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString2() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setValueCommitment("A A A A ".getBytes("UTF-8"));

    // Act
    receiveDescriptionCapsule.setZkproof(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', '\b', 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', '2', 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString3() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setEpk("A A A A ".getBytes("UTF-8"));

    // Act
    receiveDescriptionCapsule.setZkproof(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, '\b', 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', '2', 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString4() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCEnc("A A A A ".getBytes("UTF-8"));

    // Act
    receiveDescriptionCapsule.setZkproof(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'"', '\b', 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', '2', 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString5() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCOut("A A A A ".getBytes("UTF-8"));

    // Act
    receiveDescriptionCapsule.setZkproof(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'*', '\b', 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', '2', 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#setZkproof(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#setZkproof(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReceiveDescriptionCapsule.setZkproof(ByteString)"})
  public void testSetZkproofWithByteString6() throws UnsupportedEncodingException {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setNoteCommitment("A A A A ".getBytes("UTF-8"));

    // Act
    receiveDescriptionCapsule.setZkproof(mock(ByteString.class));

    // Assert
    ReceiveDescription instance = receiveDescriptionCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{18, '\b', 'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', '2', 0},
        receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isEmpty()} return {@code true}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_givenByteStringIsEmptyReturnTrue_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);

    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = receiveDescriptionCapsule.getData();

    // Assert
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} NoteCommitment is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_givenReceiveDescriptionCapsuleNoteCommitmentIsByteString() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);
    ByteString bytes5 = mock(ByteString.class);
    when(bytes5.isEmpty()).thenReturn(true);

    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setNoteCommitment(bytes5);
    receiveDescriptionCapsule.setCOut(bytes4);
    receiveDescriptionCapsule.setCEnc(bytes3);
    receiveDescriptionCapsule.setEpk(bytes2);
    receiveDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = receiveDescriptionCapsule.getData();

    // Assert
    verify(bytes5, atLeast(1)).isEmpty();
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()} Zkproof is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_givenReceiveDescriptionCapsuleZkproofIsByteString() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);
    ByteString bytes5 = mock(ByteString.class);
    when(bytes5.isEmpty()).thenReturn(true);
    ByteString proof = mock(ByteString.class);
    when(proof.isEmpty()).thenReturn(true);

    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setZkproof(proof);
    receiveDescriptionCapsule.setNoteCommitment(bytes5);
    receiveDescriptionCapsule.setCOut(bytes4);
    receiveDescriptionCapsule.setCEnc(bytes3);
    receiveDescriptionCapsule.setEpk(bytes2);
    receiveDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = receiveDescriptionCapsule.getData();

    // Assert
    verify(proof, atLeast(1)).isEmpty();
    verify(bytes5, atLeast(1)).isEmpty();
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ReceiveDescriptionCapsule#ReceiveDescriptionCapsule()}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_givenReceiveDescriptionCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new ReceiveDescriptionCapsule()).getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code 2} and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWith2AndBackspace() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);
    ByteString bytes5 = mock(ByteString.class);
    when(bytes5.isEmpty()).thenReturn(true);

    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setZkproof(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    receiveDescriptionCapsule.setNoteCommitment(bytes5);
    receiveDescriptionCapsule.setCOut(bytes4);
    receiveDescriptionCapsule.setCEnc(bytes3);
    receiveDescriptionCapsule.setEpk(bytes2);
    receiveDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = receiveDescriptionCapsule.getData();

    // Assert
    verify(bytes5, atLeast(1)).isEmpty();
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'2', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code *} and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithAsteriskAndBackspace() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);

    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCOut(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    receiveDescriptionCapsule.setCEnc(bytes3);
    receiveDescriptionCapsule.setEpk(bytes2);
    receiveDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = receiveDescriptionCapsule.getData();

    // Assert
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'*', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with eighteen and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithEighteenAndBackspace() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);

    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setNoteCommitment(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    receiveDescriptionCapsule.setCOut(bytes4);
    receiveDescriptionCapsule.setCEnc(bytes3);
    receiveDescriptionCapsule.setEpk(bytes2);
    receiveDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = receiveDescriptionCapsule.getData();

    // Assert
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with lf and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithLfAndBackspace() {
    // Arrange
    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setValueCommitment(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertArrayEquals(new byte[]{'\n', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, receiveDescriptionCapsule.getData());
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code "} and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithQuotationMarkAndBackspace() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);

    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCEnc(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    receiveDescriptionCapsule.setEpk(bytes2);
    receiveDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = receiveDescriptionCapsule.getData();

    // Assert
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'"', '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-six and backspace.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentySixAndBackspace() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);

    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setEpk(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});
    receiveDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = receiveDescriptionCapsule.getData();

    // Assert
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{26, '\b', 'A', -1, 'A', -1, 'A', -1, 'A', -1}, actualData);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);

    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setEpk(bytes2);
    receiveDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = receiveDescriptionCapsule.getData();

    // Assert
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte2() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);

    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCEnc(bytes3);
    receiveDescriptionCapsule.setEpk(bytes2);
    receiveDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = receiveDescriptionCapsule.getData();

    // Assert
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ReceiveDescriptionCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte3() {
    // Arrange
    ByteString bytes = mock(ByteString.class);
    when(bytes.isEmpty()).thenReturn(true);
    ByteString bytes2 = mock(ByteString.class);
    when(bytes2.isEmpty()).thenReturn(true);
    ByteString bytes3 = mock(ByteString.class);
    when(bytes3.isEmpty()).thenReturn(true);
    ByteString bytes4 = mock(ByteString.class);
    when(bytes4.isEmpty()).thenReturn(true);

    ReceiveDescriptionCapsule receiveDescriptionCapsule = new ReceiveDescriptionCapsule();
    receiveDescriptionCapsule.setCOut(bytes4);
    receiveDescriptionCapsule.setCEnc(bytes3);
    receiveDescriptionCapsule.setEpk(bytes2);
    receiveDescriptionCapsule.setValueCommitment(bytes);

    // Act
    byte[] actualData = receiveDescriptionCapsule.getData();

    // Assert
    verify(bytes4, atLeast(1)).isEmpty();
    verify(bytes3, atLeast(1)).isEmpty();
    verify(bytes2, atLeast(1)).isEmpty();
    verify(bytes, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link ReceiveDescriptionCapsule#getInstance()}.
   * <p>
   * Method under test: {@link ReceiveDescriptionCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReceiveDescription ReceiveDescriptionCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    ReceiveDescription actualInstance = (new ReceiveDescriptionCapsule()).getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getSerializedSize());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.isInitialized());
    assertEquals(actualInstance, actualInstance.getDefaultInstanceForType());
  }
}
