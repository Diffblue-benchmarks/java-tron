package org.tron.plugins.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.Provider;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.junit.Test;

public class Sha256HashDiffblueTest {
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
}
