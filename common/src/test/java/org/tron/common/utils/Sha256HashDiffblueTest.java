package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Provider;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.junit.Test;

public class Sha256HashDiffblueTest {
  /**
   * Method under test: {@link Sha256Hash#wrap(ByteString)}
   */
  @Test
  public void testWrap() {
    // Arrange
    ByteString rawHashByteString = mock(ByteString.class);
    when(rawHashByteString.toByteArray()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Sha256Hash.wrap(rawHashByteString));
    verify(rawHashByteString).toByteArray();
  }

  /**
   * Method under test: {@link Sha256Hash#createDouble(boolean, byte[])}
   */
  @Test
  public void testCreateDouble() {
    // Arrange and Act
    Sha256Hash actualCreateDoubleResult = Sha256Hash.createDouble(false,
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    BigInteger toBigIntegerResult = actualCreateDoubleResult.toBigInteger();
    assertEquals("87843101699767594173218391882965946153171449445678377364257449524895409992451",
        toBigIntegerResult.toString());
    ByteString byteString = actualCreateDoubleResult.getByteString();
    assertEquals("�5o\u00033Ϙqޯ���\u0005-q|Co�Ì�)�H�b\u001cs\u0003", byteString.toStringUtf8());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -62, iteratorResult.next().byteValue());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(1, toBigIntegerResult.signum());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertEquals('5', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
    assertArrayEquals(new byte[]{-62, '5', 'o', 3, '3', -49, -104, 'q', -34, -81, -77, -124, -40, 5, '-', 'q', '|', 'C',
        'o', -46, -61, -116, -49, ')', -11, 'H', -54, 'b', 28, Byte.MAX_VALUE, 's', 3},
        actualCreateDoubleResult.getBytes());
    assertArrayEquals(new byte[]{0, -62, '5', 'o', 3, '3', -49, -104, 'q', -34, -81, -77, -124, -40, 5, '-', 'q', '|',
        'C', 'o', -46, -61, -116, -49, ')', -11, 'H', -54, 'b', 28, Byte.MAX_VALUE, 's', 3},
        toBigIntegerResult.toByteArray());
  }

  /**
   * Method under test: {@link Sha256Hash#twiceOf(boolean, byte[])}
   */
  @Test
  public void testTwiceOf() {
    // Arrange and Act
    Sha256Hash actualTwiceOfResult = Sha256Hash.twiceOf(false, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    BigInteger toBigIntegerResult = actualTwiceOfResult.toBigInteger();
    assertEquals("87843101699767594173218391882965946153171449445678377364257449524895409992451",
        toBigIntegerResult.toString());
    ByteString byteString = actualTwiceOfResult.getByteString();
    assertEquals("�5o\u00033Ϙqޯ���\u0005-q|Co�Ì�)�H�b\u001cs\u0003", byteString.toStringUtf8());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -62, iteratorResult.next().byteValue());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(1, toBigIntegerResult.signum());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertEquals('5', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
    assertArrayEquals(new byte[]{-62, '5', 'o', 3, '3', -49, -104, 'q', -34, -81, -77, -124, -40, 5, '-', 'q', '|', 'C',
        'o', -46, -61, -116, -49, ')', -11, 'H', -54, 'b', 28, Byte.MAX_VALUE, 's', 3}, actualTwiceOfResult.getBytes());
    assertArrayEquals(new byte[]{0, -62, '5', 'o', 3, '3', -49, -104, 'q', -34, -81, -77, -124, -40, 5, '-', 'q', '|',
        'C', 'o', -46, -61, -116, -49, ')', -11, 'H', -54, 'b', 28, Byte.MAX_VALUE, 's', 3},
        toBigIntegerResult.toByteArray());
  }

  /**
   * Method under test: {@link Sha256Hash#newDigest()}
   */
  @Test
  public void testNewDigest() {
    // Arrange and Act
    MessageDigest actualNewDigestResult = Sha256Hash.newDigest();

    // Assert
    assertEquals("SHA-256", actualNewDigestResult.getAlgorithm());
    Provider provider = actualNewDigestResult.getProvider();
    assertEquals(106, provider.size());
    assertEquals("SHA1withDSA", provider.get("Alg.Alias.Signature.1.2.840.10040.4.3"));
    assertEquals("SHA1withDSA", provider.get("Alg.Alias.Signature.DSS"));
    assertEquals("SHA1withDSA", provider.get("Alg.Alias.Signature.SHA1/DSA"));
    assertEquals("Software", provider.get("SecureRandom.SHA1PRNG ImplementedIn"));
    assertEquals("sun.security.provider.JavaKeyStore$DualFormatJKS", provider.get("KeyStore.JKS"));
    assertEquals("sun.security.provider.SHA5$SHA512_224", provider.get("MessageDigest.SHA-512/224"));
    assertEquals(Sha256Hash.LENGTH, actualNewDigestResult.getDigestLength());
  }

  /**
   * Method under test: {@link Sha256Hash#newSM3Digest()}
   */
  @Test
  public void testNewSM3Digest() {
    // Arrange and Act
    SM3Digest actualNewSM3DigestResult = Sha256Hash.newSM3Digest();

    // Assert
    assertEquals("SM3", actualNewSM3DigestResult.getAlgorithmName());
    assertEquals(Double.SIZE, actualNewSM3DigestResult.getByteLength());
    assertEquals(Sha256Hash.LENGTH, actualNewSM3DigestResult.getDigestSize());
  }

  /**
   * Method under test: {@link Sha256Hash#hash(boolean, byte[])}
   */
  @Test
  public void testHash() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{'\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10, 'l', -76,
            -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36},
        Sha256Hash.hash(true, "AXAXAXAX".getBytes("UTF-8")));
    assertArrayEquals(
        new byte[]{'E', -2, 'C', '\\', -12, ']', -77, -93, 6, -119, -105, 's', -83, 'F', -31, -103, -27, -72, 'U', -6,
            -125, 'h', -105, '7', -7, -51, 'T', -83, '_', '\t', -101, Byte.MAX_VALUE},
        Sha256Hash.hash(false, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertArrayEquals(
        new byte[]{-80, '(', 16, 'i', 'n', -65, '\t', -91, 7, -105, -63, -117, 'r', 6, -112, '+', -41, -28, -87, 'k',
            '<', 1, 3, -125, -91, '*', 26, -57, 'z', ',', ',', -65},
        Sha256Hash.hash(true, "AXAXAXAX".getBytes("UTF-8"), 2, 3));
    assertArrayEquals(
        new byte[]{21, -114, -117, -61, '\\', 14, -97, '\t', -54, '4', '\f', -43, 26, '\'', 2, -43, '2', '\'', -26, -78,
            -71, '\f', -117, -59, -74, -82, -110, '\'', -45, 'V', -69, -26},
        Sha256Hash.hash(false, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 3));
    assertArrayEquals(
        new byte[]{26, -78, 29, -125, 'U', -49, -95, Byte.MAX_VALUE, -114, 'a', 25, 'H', '1', -24, 26, -113, '"', -66,
            -56, -57, '(', -2, -5, 't', '~', -48, '5', -21, 'P', -126, -86, '+'},
        Sha256Hash.hash(false, new byte[]{}, 2, 0));
  }

  /**
   * Method under test: {@link Sha256Hash#hashTwice(boolean, byte[])}
   */
  @Test
  public void testHashTwice() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{'\b', 'o', '%', -116, 'K', 'W', -42, '[', -14, '|', 'P', -34, -20, 26, 'n', -77, -30, -33, -111, 'K',
            '^', 'r', 'Z', -97, '"', -111, -54, 'N', -33, -83, -65, -69},
        Sha256Hash.hashTwice(true, "AXAXAXAX".getBytes("UTF-8")));
    assertArrayEquals(
        new byte[]{-62, '5', 'o', 3, '3', -49, -104, 'q', -34, -81, -77, -124, -40, 5, '-', 'q', '|', 'C', 'o', -46,
            -61, -116, -49, ')', -11, 'H', -54, 'b', 28, Byte.MAX_VALUE, 's', 3},
        Sha256Hash.hashTwice(false, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertArrayEquals(
        new byte[]{-120, '|', -112, 't', 'Z', '2', 'O', 29, -82, -94, ':', '5', -45, 'P', '^', '=', 'R', -109, -55,
            '\r', -109, '<', 'Y', -52, 'R', 26, '-', 'G', 'o', -34, -127, 's'},
        Sha256Hash.hashTwice(true, "AXAXAXAX".getBytes("UTF-8"), 2, 3));
    assertArrayEquals(
        new byte[]{-106, -116, '$', 'm', -15, '{', '>', -59, -89, -93, 't', '*', -54, 26, '@', -96, -64, -33, -96, '8',
            -110, -101, -69, -116, '*', -85, -41, '~', 1, '\\', 'D', '<'},
        Sha256Hash.hashTwice(false, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 3));
    assertArrayEquals(
        new byte[]{-99, -92, '.', -2, ':', 'N', -28, '_', -9, '_', -8, -86, -2, -49, 'g', 2, 'J', 'w', 'f', -73, -2,
            -80, -115, '%', '#', '\'', '\f', '-', -26, -127, 29, 'h'},
        Sha256Hash.hashTwice(false, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 3,
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 3));
    assertArrayEquals(
        new byte[]{21, -114, -117, -61, '\\', 14, -97, '\t', -54, '4', '\f', -43, 26, '\'', 2, -43, '2', '\'', -26, -78,
            -71, '\f', -117, -59, -74, -82, -110, '\'', -45, 'V', -69, -26},
        Sha256Hash.hashTwice(false, "AXAXAXAX".getBytes("UTF-8"), 2, 3, new byte[]{}, 2, 0));
  }

  /**
   * Method under test:
   * {@link Sha256Hash#hashTwice(boolean, byte[], int, int, byte[], int, int)}
   */
  @Test
  public void testHashTwice2() throws UnsupportedEncodingException {
    // Arrange
    byte[] input1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{' ', -84, -23, 18, '\b', '.', -70, -91, '/', 7, -94, -15, ' ', -71, -54, -73, '^', 'b', 22, -76, 'i',
            -80, -89, -104, -68, -29, -116, 'w', -62, -1, '\n', ';'},
        Sha256Hash.hashTwice(true, input1, 2, 3, "AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Sha256Hash#equals(Object)}
   *   <li>{@link Sha256Hash#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Sha256Hash sha256Hash = Sha256Hash.ZERO_HASH;
    Sha256Hash sha256Hash2 = Sha256Hash.ZERO_HASH;

    // Act and Assert
    assertEquals(sha256Hash, sha256Hash2);
    int expectedHashCodeResult = sha256Hash.hashCode();
    assertEquals(expectedHashCodeResult, sha256Hash2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Sha256Hash#equals(Object)}
   *   <li>{@link Sha256Hash#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Sha256Hash sha256Hash = Sha256Hash.ZERO_HASH;

    // Act and Assert
    assertEquals(sha256Hash, sha256Hash);
    int expectedHashCodeResult = sha256Hash.hashCode();
    assertEquals(expectedHashCodeResult, sha256Hash.hashCode());
  }

  /**
   * Method under test: {@link Sha256Hash#toBigInteger()}
   */
  @Test
  public void testToBigInteger() {
    // Arrange and Act
    BigInteger actualToBigIntegerResult = Sha256Hash.ZERO_HASH.toBigInteger();

    // Assert
    assertEquals(actualToBigIntegerResult.ZERO, actualToBigIntegerResult);
  }

  /**
   * Method under test: {@link Sha256Hash#getByteString()}
   */
  @Test
  public void testGetByteString() {
    // Arrange and Act
    ByteString actualByteString = Sha256Hash.ZERO_HASH.getByteString();

    // Assert
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        actualByteString.toStringUtf8());
    ByteString.ByteIterator iteratorResult = actualByteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertFalse(actualByteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Method under test: {@link Sha256Hash#compareTo(Sha256Hash)}
   */
  @Test
  public void testCompareTo() {
    // Arrange, Act and Assert
    assertEquals(0, Sha256Hash.ZERO_HASH.compareTo(Sha256Hash.ZERO_HASH));
  }

  /**
   * Method under test: {@link Sha256Hash#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Sha256Hash.ZERO_HASH, 1);
  }

  /**
   * Method under test: {@link Sha256Hash#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Sha256Hash.ZERO_HASH, null);
  }

  /**
   * Method under test: {@link Sha256Hash#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Sha256Hash.ZERO_HASH, "Different type to Sha256Hash");
  }

  /**
   * Method under test: {@link Sha256Hash#Sha256Hash(long, Sha256Hash)}
   */
  @Test
  public void testNewSha256Hash() {
    // Arrange and Act
    Sha256Hash actualSha256Hash = new Sha256Hash(1L, Sha256Hash.ZERO_HASH);

    // Assert
    BigInteger toBigIntegerResult = actualSha256Hash.toBigInteger();
    assertEquals("6277101735386680763835789423207666416102355444464034512896", toBigIntegerResult.toString());
    ByteString byteString = actualSha256Hash.getByteString();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        byteString.toStringUtf8());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(192, toBigIntegerResult.getLowestSetBit());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualSha256Hash.getBytes());
  }
}
