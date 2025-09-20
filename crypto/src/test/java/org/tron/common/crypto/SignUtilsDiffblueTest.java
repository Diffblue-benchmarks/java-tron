package org.tron.common.crypto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SignatureException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.crypto.ECKey.ECDSASignature;
import org.tron.common.crypto.sm2.SM2;
import org.tron.common.crypto.sm2.SM2.SM2Signature;

public class SignUtilsDiffblueTest {
  /**
   * Test {@link SignUtils#signatureToAddress(byte[], String, boolean)} with {@code messageHash},
   * {@code signatureBase64}, {@code isECKeyCryptoEngine}.
   *
   * <p>Method under test: {@link SignUtils#signatureToAddress(byte[], String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SignUtils.signatureToAddress(byte[], String, boolean)"})
  public void testSignatureToAddressWithMessageHashSignatureBase64IsECKeyCryptoEngine()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () ->
            SignUtils.signatureToAddress(
                "AXAXAXAX".getBytes("UTF-8"), "Could not decode base64", true));
  }

  /**
   * Test {@link SignUtils#signatureToAddress(byte[], String, boolean)} with {@code messageHash},
   * {@code signatureBase64}, {@code isECKeyCryptoEngine}.
   *
   * <p>Method under test: {@link SignUtils#signatureToAddress(byte[], String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] SignUtils.signatureToAddress(byte[], String, boolean)"})
  public void testSignatureToAddressWithMessageHashSignatureBase64IsECKeyCryptoEngine2()
      throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(
        SignatureException.class,
        () ->
            SignUtils.signatureToAddress(
                "AXAXAXAX".getBytes("UTF-8"), "Could not decode base64", false));
  }

  /**
   * Test {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@link ECDSASignature#r} toByteArray is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignatureInterface SignUtils.fromComponents(byte[], byte[], byte, boolean)"})
  public void testFromComponents_whenA_thenReturnRToByteArrayIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult =
        SignUtils.fromComponents(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), (byte) 'A', true);
    actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof ECDSASignature);
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000415841584158415826",
        ((ECDSASignature) actualFromComponentsResult).toHex());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ECDSASignature) actualFromComponentsResult).r.toByteArray());
    byte[] expectedToByteArrayResult2 = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult2, ((ECDSASignature) actualFromComponentsResult).s.toByteArray());
  }

  /**
   * Test {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@link ECDSASignature#r} toString is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignatureInterface SignUtils.fromComponents(byte[], byte[], byte, boolean)"})
  public void testFromComponents_whenEmptyArrayOfByte_thenReturnRToStringIs0()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult =
        SignUtils.fromComponents(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"), (byte) 27, true);
    actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof ECDSASignature);
    BigInteger bigInteger = ((ECDSASignature) actualFromComponentsResult).r;
    assertEquals("0", bigInteger.toString());
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
            + "000000000000415841584158415800",
        ((ECDSASignature) actualFromComponentsResult).toHex());
    assertEquals(-1, bigInteger.getLowestSetBit());
    assertEquals(0, bigInteger.signum());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ECDSASignature) actualFromComponentsResult).s.toByteArray());
    assertArrayEquals(new byte[] {0}, bigInteger.toByteArray());
  }

  /**
   * Test {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@link SM2Signature#r} toString is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignatureInterface SignUtils.fromComponents(byte[], byte[], byte, boolean)"})
  public void testFromComponents_whenEmptyArrayOfByte_thenReturnRToStringIs02()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult =
        SignUtils.fromComponents(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"), (byte) 27, false);
    actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof SM2Signature);
    BigInteger bigInteger = ((SM2Signature) actualFromComponentsResult).r;
    assertEquals("0", bigInteger.toString());
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
            + "000000000000415841584158415800",
        ((SM2Signature) actualFromComponentsResult).toHex());
    assertEquals(-1, bigInteger.getLowestSetBit());
    assertEquals(0, bigInteger.signum());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((SM2Signature) actualFromComponentsResult).s.toByteArray());
    assertArrayEquals(new byte[] {0}, bigInteger.toByteArray());
  }

  /**
   * Test {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@link ECDSASignature#s} toString is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignatureInterface SignUtils.fromComponents(byte[], byte[], byte, boolean)"})
  public void testFromComponents_whenEmptyArrayOfByte_thenReturnSToStringIs0()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult =
        SignUtils.fromComponents("AXAXAXAX".getBytes("UTF-8"), new byte[] {}, (byte) 27, true);
    actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof ECDSASignature);
    BigInteger bigInteger = ((ECDSASignature) actualFromComponentsResult).s;
    assertEquals("0", bigInteger.toString());
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000000000000000000000",
        ((ECDSASignature) actualFromComponentsResult).toHex());
    assertEquals(-1, bigInteger.getLowestSetBit());
    assertEquals(0, bigInteger.signum());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ECDSASignature) actualFromComponentsResult).r.toByteArray());
    assertArrayEquals(new byte[] {0}, bigInteger.toByteArray());
  }

  /**
   * Test {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@link SM2Signature#s} toString is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignatureInterface SignUtils.fromComponents(byte[], byte[], byte, boolean)"})
  public void testFromComponents_whenEmptyArrayOfByte_thenReturnSToStringIs02()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult =
        SignUtils.fromComponents("AXAXAXAX".getBytes("UTF-8"), new byte[] {}, (byte) 27, false);
    actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof SM2Signature);
    BigInteger bigInteger = ((SM2Signature) actualFromComponentsResult).s;
    assertEquals("0", bigInteger.toString());
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000000000000000000000",
        ((SM2Signature) actualFromComponentsResult).toHex());
    assertEquals(-1, bigInteger.getLowestSetBit());
    assertEquals(0, bigInteger.signum());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((SM2Signature) actualFromComponentsResult).r.toByteArray());
    assertArrayEquals(new byte[] {0}, bigInteger.toByteArray());
  }

  /**
   * Test {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@link SM2Signature#r} toByteArray is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignatureInterface SignUtils.fromComponents(byte[], byte[], byte, boolean)"})
  public void testFromComponents_whenFalse_thenReturnRToByteArrayIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult =
        SignUtils.fromComponents(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), (byte) 27, false);
    actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof SM2Signature);
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000415841584158415800",
        ((SM2Signature) actualFromComponentsResult).toHex());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((SM2Signature) actualFromComponentsResult).r.toByteArray());
    byte[] expectedToByteArrayResult2 = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult2, ((SM2Signature) actualFromComponentsResult).s.toByteArray());
  }

  /**
   * Test {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@link ECDSASignature#r} toByteArray is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignatureInterface SignUtils.fromComponents(byte[], byte[], byte, boolean)"})
  public void testFromComponents_whenTrue_thenReturnRToByteArrayIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult =
        SignUtils.fromComponents(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), (byte) 27, true);
    actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof ECDSASignature);
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000415841584158415800",
        ((ECDSASignature) actualFromComponentsResult).toHex());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ECDSASignature) actualFromComponentsResult).r.toByteArray());
    byte[] expectedToByteArrayResult2 = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult2, ((ECDSASignature) actualFromComponentsResult).s.toByteArray());
  }

  /**
   * Test {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}.
   *
   * <ul>
   *   <li>When twenty-eight.
   *   <li>Then return {@link ECDSASignature#r} toByteArray is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignatureInterface SignUtils.fromComponents(byte[], byte[], byte, boolean)"})
  public void testFromComponents_whenTwentyEight_thenReturnRToByteArrayIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult =
        SignUtils.fromComponents(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), (byte) 28, true);
    actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof ECDSASignature);
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000415841584158415801",
        ((ECDSASignature) actualFromComponentsResult).toHex());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((ECDSASignature) actualFromComponentsResult).r.toByteArray());
    byte[] expectedToByteArrayResult2 = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult2, ((ECDSASignature) actualFromComponentsResult).s.toByteArray());
  }

  /**
   * Test {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}.
   *
   * <ul>
   *   <li>When twenty-eight.
   *   <li>Then return {@link SM2Signature#r} toByteArray is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignatureInterface SignUtils.fromComponents(byte[], byte[], byte, boolean)"})
  public void testFromComponents_whenTwentyEight_thenReturnRToByteArrayIsAxaxaxaxBytesIsUtf82()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult =
        SignUtils.fromComponents(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), (byte) 28, false);
    actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof SM2Signature);
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000415841584158415801",
        ((SM2Signature) actualFromComponentsResult).toHex());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((SM2Signature) actualFromComponentsResult).r.toByteArray());
    byte[] expectedToByteArrayResult2 = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult2, ((SM2Signature) actualFromComponentsResult).s.toByteArray());
  }

  /**
   * Test {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return {@link SM2Signature#r} toByteArray is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SignatureInterface SignUtils.fromComponents(byte[], byte[], byte, boolean)"})
  public void testFromComponents_whenX_thenReturnRToByteArrayIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult =
        SignUtils.fromComponents(
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            (byte) 'A',
            false);
    actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof SM2Signature);
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
            + "000000000000415841584158415826",
        ((SM2Signature) actualFromComponentsResult).toHex());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult, ((SM2Signature) actualFromComponentsResult).r.toByteArray());
    byte[] expectedToByteArrayResult2 = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(
        expectedToByteArrayResult2, ((SM2Signature) actualFromComponentsResult).s.toByteArray());
  }
}
