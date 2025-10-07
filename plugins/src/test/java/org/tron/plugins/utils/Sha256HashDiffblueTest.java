package org.tron.plugins.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.Provider;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Sha256HashDiffblueTest {
  /**
   * Test {@link Sha256Hash#of(boolean, byte[])} with {@code isSha256}, {@code contents}.
   *
   * <p>Method under test: {@link Sha256Hash#of(boolean, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sha256Hash Sha256Hash.of(boolean, byte[])"})
  public void testOfWithIsSha256Contents() throws UnsupportedEncodingException {
    // Arrange and Act
    Sha256Hash actualOfResult = Sha256Hash.of(true, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ByteString byteString = actualOfResult.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    assertEquals("\\[b\t�g�� �\ru�/���l�؊KS�\u0001�9�\u001a`��", byteString.toStringUtf8());
    assertTrue(iteratorResult.hasNext());
    assertEquals('[', nextResult2.byteValue());
    assertEquals('\\', nextResult.byteValue());
    assertEquals('b', nextResult3.byteValue());
    assertArrayEquals(
        new byte[] {
          '\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
          'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36
        },
        actualOfResult.getBytes());
  }

  /**
   * Test {@link Sha256Hash#of(boolean, byte[])} with {@code isSha256}, {@code contents}.
   *
   * <ul>
   *   <li>Then return ByteString iterator next byteValue is minus two.
   * </ul>
   *
   * <p>Method under test: {@link Sha256Hash#of(boolean, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sha256Hash Sha256Hash.of(boolean, byte[])"})
  public void testOfWithIsSha256Contents_thenReturnByteStringIteratorNextByteValueIsMinusTwo() {
    // Arrange and Act
    Sha256Hash actualOfResult =
        Sha256Hash.of(false, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    ByteString byteString = actualOfResult.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertEquals("E�C\\�]��\u0006��s�F��U��h�7��T�_\t�", byteString.toStringUtf8());
    assertEquals((byte) -2, nextResult2.byteValue());
    assertTrue(actualHasNextResult);
    assertEquals('C', nextResult3.byteValue());
    assertEquals('E', nextResult.byteValue());
    assertArrayEquals(
        new byte[] {
          'E',
          -2,
          'C',
          '\\',
          -12,
          ']',
          -77,
          -93,
          6,
          -119,
          -105,
          's',
          -83,
          'F',
          -31,
          -103,
          -27,
          -72,
          'U',
          -6,
          -125,
          'h',
          -105,
          '7',
          -7,
          -51,
          'T',
          -83,
          '_',
          '\t',
          -101,
          Byte.MAX_VALUE
        },
        actualOfResult.getBytes());
  }

  /**
   * Test {@link Sha256Hash#newDigest()}.
   *
   * <p>Method under test: {@link Sha256Hash#newDigest()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageDigest Sha256Hash.newDigest()"})
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
    assertEquals(
        "sun.security.provider.SHA5$SHA512_224", provider.get("MessageDigest.SHA-512/224"));
    assertEquals(Sha256Hash.LENGTH, actualNewDigestResult.getDigestLength());
  }

  /**
   * Test {@link Sha256Hash#newSM3Digest()}.
   *
   * <p>Method under test: {@link Sha256Hash#newSM3Digest()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SM3Digest Sha256Hash.newSM3Digest()"})
  public void testNewSM3Digest() {
    // Arrange and Act
    SM3Digest actualNewSM3DigestResult = Sha256Hash.newSM3Digest();

    // Assert
    assertEquals("SM3", actualNewSM3DigestResult.getAlgorithmName());
    assertEquals(Double.SIZE, actualNewSM3DigestResult.getByteLength());
    assertEquals(Sha256Hash.LENGTH, actualNewSM3DigestResult.getDigestSize());
  }

  /**
   * Test {@link Sha256Hash#hash(boolean, byte[], int, int)} with {@code isSha256}, {@code input},
   * {@code offset}, {@code length}.
   *
   * <p>Method under test: {@link Sha256Hash#hash(boolean, byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Sha256Hash.hash(boolean, byte[], int, int)"})
  public void testHashWithIsSha256InputOffsetLength() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualHashResult = Sha256Hash.hash(true, "AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Assert
    assertArrayEquals(
        new byte[] {
          -80, '(', 16, 'i', 'n', -65, '\t', -91, 7, -105, -63, -117, 'r', 6, -112, '+', -41, -28,
          -87, 'k', '<', 1, 3, -125, -91, '*', 26, -57, 'z', ',', ',', -65
        },
        actualHashResult);
  }

  /**
   * Test {@link Sha256Hash#hash(boolean, byte[], int, int)} with {@code isSha256}, {@code input},
   * {@code offset}, {@code length}.
   *
   * <p>Method under test: {@link Sha256Hash#hash(boolean, byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Sha256Hash.hash(boolean, byte[], int, int)"})
  public void testHashWithIsSha256InputOffsetLength2() {
    // Arrange and Act
    byte[] actualHashResult =
        Sha256Hash.hash(false, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 3);

    // Assert
    assertArrayEquals(
        new byte[] {
          21, -114, -117, -61, '\\', 14, -97, '\t', -54, '4', '\f', -43, 26, '\'', 2, -43, '2',
          '\'', -26, -78, -71, '\f', -117, -59, -74, -82, -110, '\'', -45, 'V', -69, -26
        },
        actualHashResult);
  }

  /**
   * Test {@link Sha256Hash#hash(boolean, byte[], int, int)} with {@code isSha256}, {@code input},
   * {@code offset}, {@code length}.
   *
   * <p>Method under test: {@link Sha256Hash#hash(boolean, byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Sha256Hash.hash(boolean, byte[], int, int)"})
  public void testHashWithIsSha256InputOffsetLength3() {
    // Arrange and Act
    byte[] actualHashResult = Sha256Hash.hash(false, new byte[] {}, 2, 0);

    // Assert
    assertArrayEquals(
        new byte[] {
          26,
          -78,
          29,
          -125,
          'U',
          -49,
          -95,
          Byte.MAX_VALUE,
          -114,
          'a',
          25,
          'H',
          '1',
          -24,
          26,
          -113,
          '"',
          -66,
          -56,
          -57,
          '(',
          -2,
          -5,
          't',
          '~',
          -48,
          '5',
          -21,
          'P',
          -126,
          -86,
          '+'
        },
        actualHashResult);
  }

  /**
   * Test {@link Sha256Hash#hash(boolean, byte[])} with {@code isSha256}, {@code input}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code \} and {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link Sha256Hash#hash(boolean, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Sha256Hash.hash(boolean, byte[])"})
  public void testHashWithIsSha256Input_thenReturnArrayOfByteWithBackslashAndLeftSquareBracket()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualHashResult = Sha256Hash.hash(true, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          '\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
          'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36
        },
        actualHashResult);
  }

  /**
   * Test {@link Sha256Hash#hash(boolean, byte[])} with {@code isSha256}, {@code input}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return array of {@code byte} with {@code E} and minus two.
   * </ul>
   *
   * <p>Method under test: {@link Sha256Hash#hash(boolean, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Sha256Hash.hash(boolean, byte[])"})
  public void testHashWithIsSha256Input_whenFalse_thenReturnArrayOfByteWithEAndMinusTwo() {
    // Arrange and Act
    byte[] actualHashResult =
        Sha256Hash.hash(false, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertArrayEquals(
        new byte[] {
          'E',
          -2,
          'C',
          '\\',
          -12,
          ']',
          -77,
          -93,
          6,
          -119,
          -105,
          's',
          -83,
          'F',
          -31,
          -103,
          -27,
          -72,
          'U',
          -6,
          -125,
          'h',
          -105,
          '7',
          -7,
          -51,
          'T',
          -83,
          '_',
          '\t',
          -101,
          Byte.MAX_VALUE
        },
        actualHashResult);
  }

  /**
   * Test {@link Sha256Hash#equals(Object)}, and {@link Sha256Hash#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Sha256Hash#equals(Object)}
   *   <li>{@link Sha256Hash#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Sha256Hash.equals(Object)", "int Sha256Hash.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Sha256Hash sha256Hash = Sha256Hash.ZERO_HASH;
    Sha256Hash sha256Hash2 = Sha256Hash.ZERO_HASH;

    // Act and Assert
    assertEquals(sha256Hash, sha256Hash2);
    assertEquals(sha256Hash.hashCode(), sha256Hash2.hashCode());
  }

  /**
   * Test {@link Sha256Hash#equals(Object)}, and {@link Sha256Hash#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Sha256Hash#equals(Object)}
   *   <li>{@link Sha256Hash#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Sha256Hash.equals(Object)", "int Sha256Hash.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Sha256Hash sha256Hash = Sha256Hash.ZERO_HASH;

    // Act and Assert
    assertEquals(sha256Hash, sha256Hash);
    int expectedHashCodeResult = sha256Hash.hashCode();
    assertEquals(expectedHashCodeResult, sha256Hash.hashCode());
  }

  /**
   * Test {@link Sha256Hash#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Sha256Hash#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Sha256Hash.equals(Object)", "int Sha256Hash.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Sha256Hash.ZERO_HASH, 1);
  }

  /**
   * Test {@link Sha256Hash#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Sha256Hash#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Sha256Hash.equals(Object)", "int Sha256Hash.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Sha256Hash.ZERO_HASH, null);
  }

  /**
   * Test {@link Sha256Hash#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Sha256Hash#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Sha256Hash.equals(Object)", "int Sha256Hash.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Sha256Hash.ZERO_HASH, "Different type to Sha256Hash");
  }

  /**
   * Test {@link Sha256Hash#getByteString()}.
   *
   * <p>Method under test: {@link Sha256Hash#getByteString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString Sha256Hash.getByteString()"})
  public void testGetByteString() {
    // Arrange and Act
    ByteString actualByteString = Sha256Hash.ZERO_HASH.getByteString();

    // Assert
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        actualByteString.toStringUtf8());
    ByteIterator iteratorResult = actualByteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertFalse(actualByteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link Sha256Hash#compareTo(Sha256Hash)} with {@code Sha256Hash}.
   *
   * <ul>
   *   <li>When {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Sha256Hash#compareTo(Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Sha256Hash.compareTo(Sha256Hash)"})
  public void testCompareToWithSha256Hash_whenZero_hash_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Sha256Hash.ZERO_HASH.compareTo(Sha256Hash.ZERO_HASH));
  }
}
