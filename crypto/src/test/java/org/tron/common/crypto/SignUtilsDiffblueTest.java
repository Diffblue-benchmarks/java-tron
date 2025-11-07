package org.tron.common.crypto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SignatureException;
import org.junit.Test;
import org.tron.common.crypto.sm2.SM2;

public class SignUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link SignUtils#signatureToAddress(byte[], String, boolean)}
   */
  @Test
  public void testSignatureToAddress() throws UnsupportedEncodingException, SignatureException {
    // Arrange, Act and Assert
    assertThrows(SignatureException.class,
        () -> SignUtils.signatureToAddress("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64", true));
    assertThrows(SignatureException.class,
        () -> SignUtils.signatureToAddress("AXAXAXAX".getBytes("UTF-8"), "Could not decode base64", false));
  }

  /**
   * Method under test:
   * {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  public void testFromComponents() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    SignatureInterface actualFromComponentsResult = SignUtils.fromComponents(r, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 'A', true);
    boolean actualValidateComponentsResult = actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof ECKey.ECDSASignature);
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
        + "000000000000415841584158415826", ((ECKey.ECDSASignature) actualFromComponentsResult).toHex());
    BigInteger bigInteger = ((ECKey.ECDSASignature) actualFromComponentsResult).r;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(3, bigInteger.getLowestSetBit());
    assertFalse(actualValidateComponentsResult);
    assertEquals(((ECKey.ECDSASignature) actualFromComponentsResult).r,
        ((ECKey.ECDSASignature) actualFromComponentsResult).s);
    assertEquals('A', ((ECKey.ECDSASignature) actualFromComponentsResult).v);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
  }

  /**
   * Method under test:
   * {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  public void testFromComponents2() throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult = SignUtils.fromComponents(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        (byte) 'A', false);
    boolean actualValidateComponentsResult = actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof SM2.SM2Signature);
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
        + "000000000000415841584158415826", ((SM2.SM2Signature) actualFromComponentsResult).toHex());
    BigInteger bigInteger = ((SM2.SM2Signature) actualFromComponentsResult).r;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals(3, bigInteger.getLowestSetBit());
    assertFalse(actualValidateComponentsResult);
    assertEquals(((SM2.SM2Signature) actualFromComponentsResult).r, ((SM2.SM2Signature) actualFromComponentsResult).s);
    assertEquals('A', ((SM2.SM2Signature) actualFromComponentsResult).v);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
  }

  /**
   * Method under test:
   * {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  public void testFromComponents3() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    SignatureInterface actualFromComponentsResult = SignUtils.fromComponents(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 27,
        true);
    boolean actualValidateComponentsResult = actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof ECKey.ECDSASignature);
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
        + "000000000000415841584158415800", ((ECKey.ECDSASignature) actualFromComponentsResult).toHex());
    BigInteger bigInteger = ((ECKey.ECDSASignature) actualFromComponentsResult).r;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals((byte) 27, ((ECKey.ECDSASignature) actualFromComponentsResult).v);
    assertEquals(3, bigInteger.getLowestSetBit());
    assertTrue(actualValidateComponentsResult);
    assertEquals(((ECKey.ECDSASignature) actualFromComponentsResult).r,
        ((ECKey.ECDSASignature) actualFromComponentsResult).s);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
  }

  /**
   * Method under test:
   * {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  public void testFromComponents4() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    SignatureInterface actualFromComponentsResult = SignUtils.fromComponents(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 28,
        true);
    boolean actualValidateComponentsResult = actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof ECKey.ECDSASignature);
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
        + "000000000000415841584158415801", ((ECKey.ECDSASignature) actualFromComponentsResult).toHex());
    BigInteger bigInteger = ((ECKey.ECDSASignature) actualFromComponentsResult).r;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals((byte) 28, ((ECKey.ECDSASignature) actualFromComponentsResult).v);
    assertEquals(3, bigInteger.getLowestSetBit());
    assertTrue(actualValidateComponentsResult);
    assertEquals(((ECKey.ECDSASignature) actualFromComponentsResult).r,
        ((ECKey.ECDSASignature) actualFromComponentsResult).s);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
  }

  /**
   * Method under test:
   * {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  public void testFromComponents5() throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult = SignUtils.fromComponents(new byte[]{}, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 27, true);
    boolean actualValidateComponentsResult = actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof ECKey.ECDSASignature);
    BigInteger bigInteger = ((ECKey.ECDSASignature) actualFromComponentsResult).r;
    assertEquals("0", bigInteger.toString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "000000000000415841584158415800", ((ECKey.ECDSASignature) actualFromComponentsResult).toHex());
    BigInteger bigInteger2 = ((ECKey.ECDSASignature) actualFromComponentsResult).s;
    assertEquals("4708585257725083992", bigInteger2.toString());
    assertEquals(-1, bigInteger.getLowestSetBit());
    assertEquals(0, bigInteger.signum());
    assertEquals(1, bigInteger2.signum());
    assertEquals((byte) 27, ((ECKey.ECDSASignature) actualFromComponentsResult).v);
    assertEquals(3, bigInteger2.getLowestSetBit());
    assertFalse(actualValidateComponentsResult);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{0}, bigInteger.toByteArray());
  }

  /**
   * Method under test:
   * {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  public void testFromComponents6() throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult = SignUtils.fromComponents("AXAXAXAX".getBytes("UTF-8"), new byte[]{},
        (byte) 27, true);
    boolean actualValidateComponentsResult = actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof ECKey.ECDSASignature);
    BigInteger bigInteger = ((ECKey.ECDSASignature) actualFromComponentsResult).s;
    assertEquals("0", bigInteger.toString());
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
        + "000000000000000000000000000000", ((ECKey.ECDSASignature) actualFromComponentsResult).toHex());
    BigInteger bigInteger2 = ((ECKey.ECDSASignature) actualFromComponentsResult).r;
    assertEquals("4708585257725083992", bigInteger2.toString());
    assertEquals(-1, bigInteger.getLowestSetBit());
    assertEquals(0, bigInteger.signum());
    assertEquals(1, bigInteger2.signum());
    assertEquals((byte) 27, ((ECKey.ECDSASignature) actualFromComponentsResult).v);
    assertEquals(3, bigInteger2.getLowestSetBit());
    assertFalse(actualValidateComponentsResult);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{0}, bigInteger.toByteArray());
  }

  /**
   * Method under test:
   * {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  public void testFromComponents7() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    SignatureInterface actualFromComponentsResult = SignUtils.fromComponents(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 27,
        false);
    boolean actualValidateComponentsResult = actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof SM2.SM2Signature);
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
        + "000000000000415841584158415800", ((SM2.SM2Signature) actualFromComponentsResult).toHex());
    BigInteger bigInteger = ((SM2.SM2Signature) actualFromComponentsResult).r;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals((byte) 27, ((SM2.SM2Signature) actualFromComponentsResult).v);
    assertEquals(3, bigInteger.getLowestSetBit());
    assertTrue(actualValidateComponentsResult);
    assertEquals(((SM2.SM2Signature) actualFromComponentsResult).r, ((SM2.SM2Signature) actualFromComponentsResult).s);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
  }

  /**
   * Method under test:
   * {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  public void testFromComponents8() throws UnsupportedEncodingException {
    // Arrange
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    SignatureInterface actualFromComponentsResult = SignUtils.fromComponents(r, "AXAXAXAX".getBytes("UTF-8"), (byte) 28,
        false);
    boolean actualValidateComponentsResult = actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof SM2.SM2Signature);
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
        + "000000000000415841584158415801", ((SM2.SM2Signature) actualFromComponentsResult).toHex());
    BigInteger bigInteger = ((SM2.SM2Signature) actualFromComponentsResult).r;
    assertEquals("4708585257725083992", bigInteger.toString());
    assertEquals(1, bigInteger.signum());
    assertEquals((byte) 28, ((SM2.SM2Signature) actualFromComponentsResult).v);
    assertEquals(3, bigInteger.getLowestSetBit());
    assertTrue(actualValidateComponentsResult);
    assertEquals(((SM2.SM2Signature) actualFromComponentsResult).r, ((SM2.SM2Signature) actualFromComponentsResult).s);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger.toByteArray());
  }

  /**
   * Method under test:
   * {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  public void testFromComponents9() throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult = SignUtils.fromComponents(new byte[]{}, "AXAXAXAX".getBytes("UTF-8"),
        (byte) 27, false);
    boolean actualValidateComponentsResult = actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof SM2.SM2Signature);
    BigInteger bigInteger = ((SM2.SM2Signature) actualFromComponentsResult).r;
    assertEquals("0", bigInteger.toString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
        + "000000000000415841584158415800", ((SM2.SM2Signature) actualFromComponentsResult).toHex());
    BigInteger bigInteger2 = ((SM2.SM2Signature) actualFromComponentsResult).s;
    assertEquals("4708585257725083992", bigInteger2.toString());
    assertEquals(-1, bigInteger.getLowestSetBit());
    assertEquals(0, bigInteger.signum());
    assertEquals(1, bigInteger2.signum());
    assertEquals((byte) 27, ((SM2.SM2Signature) actualFromComponentsResult).v);
    assertEquals(3, bigInteger2.getLowestSetBit());
    assertFalse(actualValidateComponentsResult);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{0}, bigInteger.toByteArray());
  }

  /**
   * Method under test:
   * {@link SignUtils#fromComponents(byte[], byte[], byte, boolean)}
   */
  @Test
  public void testFromComponents10() throws UnsupportedEncodingException {
    // Arrange and Act
    SignatureInterface actualFromComponentsResult = SignUtils.fromComponents("AXAXAXAX".getBytes("UTF-8"), new byte[]{},
        (byte) 27, false);
    boolean actualValidateComponentsResult = actualFromComponentsResult.validateComponents();

    // Assert
    assertTrue(actualFromComponentsResult instanceof SM2.SM2Signature);
    BigInteger bigInteger = ((SM2.SM2Signature) actualFromComponentsResult).s;
    assertEquals("0", bigInteger.toString());
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158000000000000000000000000000000000000"
        + "000000000000000000000000000000", ((SM2.SM2Signature) actualFromComponentsResult).toHex());
    BigInteger bigInteger2 = ((SM2.SM2Signature) actualFromComponentsResult).r;
    assertEquals("4708585257725083992", bigInteger2.toString());
    assertEquals(-1, bigInteger.getLowestSetBit());
    assertEquals(0, bigInteger.signum());
    assertEquals(1, bigInteger2.signum());
    assertEquals((byte) 27, ((SM2.SM2Signature) actualFromComponentsResult).v);
    assertEquals(3, bigInteger2.getLowestSetBit());
    assertFalse(actualValidateComponentsResult);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, bigInteger2.toByteArray());
    assertArrayEquals(new byte[]{0}, bigInteger.toByteArray());
  }
}
