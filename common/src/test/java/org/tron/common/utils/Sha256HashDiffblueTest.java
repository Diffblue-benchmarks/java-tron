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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Provider;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Sha256HashDiffblueTest {
  /**
   * Test {@link Sha256Hash#Sha256Hash(long, Sha256Hash)}.
   *
   * <p>Method under test: {@link Sha256Hash#Sha256Hash(long, Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Sha256Hash.<init>(long, Sha256Hash)"})
  public void testNewSha256Hash() {
    // Arrange and Act
    Sha256Hash actualSha256Hash = new Sha256Hash(1L, Sha256Hash.ZERO_HASH);

    // Assert
    BigInteger toBigIntegerResult = actualSha256Hash.toBigInteger();
    assertEquals(
        "6277101735386680763835789423207666416102355444464034512896",
        toBigIntegerResult.toString());
    ByteString byteString = actualSha256Hash.getByteString();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(192, toBigIntegerResult.getLowestSetBit());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(
        new byte[] {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualSha256Hash.getBytes());
  }

  /**
   * Test {@link Sha256Hash#wrap(ByteString)} with {@code rawHashByteString}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Sha256Hash#wrap(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash Sha256Hash.wrap(ByteString)"})
  public void testWrapWithRawHashByteString_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    ByteString rawHashByteString = mock(ByteString.class);
    when(rawHashByteString.toByteArray()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Sha256Hash.wrap(rawHashByteString));
    verify(rawHashByteString).toByteArray();
  }

  /**
   * Test {@link Sha256Hash#create(boolean, byte[])}.
   *
   * <p>Method under test: {@link Sha256Hash#create(boolean, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash Sha256Hash.create(boolean, byte[])"})
  public void testCreate() throws UnsupportedEncodingException {
    // Arrange and Act
    Sha256Hash actualCreateResult = Sha256Hash.create(true, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ByteString byteString = actualCreateResult.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    BigInteger toBigIntegerResult = actualCreateResult.toBigInteger();
    assertEquals(
        "41774241789126944098306227155094803171342615589867574088397738610130220530396",
        toBigIntegerResult.toString());
    assertEquals("\\[b\t�g�� �\ru�/���l�؊KS�\u0001�9�\u001a`��", byteString.toStringUtf8());
    assertEquals(2, toBigIntegerResult.getLowestSetBit());
    assertTrue(actualHasNextResult);
    assertEquals('[', nextResult2.byteValue());
    assertEquals('\\', nextResult.byteValue());
    assertEquals('b', nextResult3.byteValue());
    assertArrayEquals(
        new byte[] {
          '\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
          'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          '\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
          'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36
        },
        actualCreateResult.getBytes());
  }

  /**
   * Test {@link Sha256Hash#create(boolean, byte[])}.
   *
   * <p>Method under test: {@link Sha256Hash#create(boolean, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash Sha256Hash.create(boolean, byte[])"})
  public void testCreate2() {
    // Arrange and Act
    Sha256Hash actualCreateResult =
        Sha256Hash.create(false, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    ByteString byteString = actualCreateResult.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    BigInteger toBigIntegerResult = actualCreateResult.toBigInteger();
    assertEquals(
        "31658830629754164576429618908241169406204886439014109266135958988289879939967",
        toBigIntegerResult.toString());
    assertEquals("E�C\\�]��\u0006��s�F��U��h�7��T�_\t�", byteString.toStringUtf8());
    assertEquals((byte) -2, nextResult2.byteValue());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
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
        toBigIntegerResult.toByteArray());
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
        actualCreateResult.getBytes());
  }

  /**
   * Test {@link Sha256Hash#of(boolean, byte[])} with {@code isSha256}, {@code contents}.
   *
   * <p>Method under test: {@link Sha256Hash#of(boolean, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    boolean actualHasNextResult = iteratorResult.hasNext();
    BigInteger toBigIntegerResult = actualOfResult.toBigInteger();
    assertEquals(
        "41774241789126944098306227155094803171342615589867574088397738610130220530396",
        toBigIntegerResult.toString());
    assertEquals("\\[b\t�g�� �\ru�/���l�؊KS�\u0001�9�\u001a`��", byteString.toStringUtf8());
    assertEquals(2, toBigIntegerResult.getLowestSetBit());
    assertTrue(actualHasNextResult);
    assertEquals('[', nextResult2.byteValue());
    assertEquals('\\', nextResult.byteValue());
    assertEquals('b', nextResult3.byteValue());
    assertArrayEquals(
        new byte[] {
          '\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
          'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36
        },
        toBigIntegerResult.toByteArray());
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
   * <p>Method under test: {@link Sha256Hash#of(boolean, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash Sha256Hash.of(boolean, byte[])"})
  public void testOfWithIsSha256Contents2() {
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
    BigInteger toBigIntegerResult = actualOfResult.toBigInteger();
    assertEquals(
        "31658830629754164576429618908241169406204886439014109266135958988289879939967",
        toBigIntegerResult.toString());
    assertEquals("E�C\\�]��\u0006��s�F��U��h�7��T�_\t�", byteString.toStringUtf8());
    assertEquals((byte) -2, nextResult2.byteValue());
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
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
        toBigIntegerResult.toByteArray());
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
   * Test {@link Sha256Hash#createDouble(boolean, byte[])}.
   *
   * <p>Method under test: {@link Sha256Hash#createDouble(boolean, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash Sha256Hash.createDouble(boolean, byte[])"})
  public void testCreateDouble() throws UnsupportedEncodingException {
    // Arrange and Act
    Sha256Hash actualCreateDoubleResult =
        Sha256Hash.createDouble(true, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ByteString byteString = actualCreateDoubleResult.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    BigInteger toBigIntegerResult = actualCreateDoubleResult.toBigInteger();
    assertEquals(
        "3814881959798452480687030053349855260723236035514956795799861880773642403771",
        toBigIntegerResult.toString());
    assertEquals("\bo%�KW�[�|P��\u001an��ߑK^rZ�\"��N߭��", byteString.toStringUtf8());
    assertTrue(actualHasNextResult);
    assertEquals('%', nextResult3.byteValue());
    assertEquals('\b', nextResult.byteValue());
    assertEquals('o', nextResult2.byteValue());
    assertArrayEquals(
        new byte[] {
          '\b', 'o', '%', -116, 'K', 'W', -42, '[', -14, '|', 'P', -34, -20, 26, 'n', -77, -30, -33,
          -111, 'K', '^', 'r', 'Z', -97, '"', -111, -54, 'N', -33, -83, -65, -69
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          '\b', 'o', '%', -116, 'K', 'W', -42, '[', -14, '|', 'P', -34, -20, 26, 'n', -77, -30, -33,
          -111, 'K', '^', 'r', 'Z', -97, '"', -111, -54, 'N', -33, -83, -65, -69
        },
        actualCreateDoubleResult.getBytes());
  }

  /**
   * Test {@link Sha256Hash#createDouble(boolean, byte[])}.
   *
   * <p>Method under test: {@link Sha256Hash#createDouble(boolean, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash Sha256Hash.createDouble(boolean, byte[])"})
  public void testCreateDouble2() {
    // Arrange and Act
    Sha256Hash actualCreateDoubleResult =
        Sha256Hash.createDouble(false, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    BigInteger toBigIntegerResult = actualCreateDoubleResult.toBigInteger();
    assertEquals(
        "87843101699767594173218391882965946153171449445678377364257449524895409992451",
        toBigIntegerResult.toString());
    ByteString byteString = actualCreateDoubleResult.getByteString();
    assertEquals("�5o\u00033Ϙqޯ���\u0005-q|Co�Ì�)�H�b\u001cs\u0003", byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -62, iteratorResult.next().byteValue());
    assertTrue(iteratorResult.hasNext());
    assertEquals('5', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
    assertArrayEquals(
        new byte[] {
          -62,
          '5',
          'o',
          3,
          '3',
          -49,
          -104,
          'q',
          -34,
          -81,
          -77,
          -124,
          -40,
          5,
          '-',
          'q',
          '|',
          'C',
          'o',
          -46,
          -61,
          -116,
          -49,
          ')',
          -11,
          'H',
          -54,
          'b',
          28,
          Byte.MAX_VALUE,
          's',
          3
        },
        actualCreateDoubleResult.getBytes());
    assertArrayEquals(
        new byte[] {
          0,
          -62,
          '5',
          'o',
          3,
          '3',
          -49,
          -104,
          'q',
          -34,
          -81,
          -77,
          -124,
          -40,
          5,
          '-',
          'q',
          '|',
          'C',
          'o',
          -46,
          -61,
          -116,
          -49,
          ')',
          -11,
          'H',
          -54,
          'b',
          28,
          Byte.MAX_VALUE,
          's',
          3
        },
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link Sha256Hash#twiceOf(boolean, byte[])}.
   *
   * <p>Method under test: {@link Sha256Hash#twiceOf(boolean, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash Sha256Hash.twiceOf(boolean, byte[])"})
  public void testTwiceOf() throws UnsupportedEncodingException {
    // Arrange and Act
    Sha256Hash actualTwiceOfResult = Sha256Hash.twiceOf(true, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    ByteString byteString = actualTwiceOfResult.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    BigInteger toBigIntegerResult = actualTwiceOfResult.toBigInteger();
    assertEquals(
        "3814881959798452480687030053349855260723236035514956795799861880773642403771",
        toBigIntegerResult.toString());
    assertEquals("\bo%�KW�[�|P��\u001an��ߑK^rZ�\"��N߭��", byteString.toStringUtf8());
    assertTrue(actualHasNextResult);
    assertEquals('%', nextResult3.byteValue());
    assertEquals('\b', nextResult.byteValue());
    assertEquals('o', nextResult2.byteValue());
    assertArrayEquals(
        new byte[] {
          '\b', 'o', '%', -116, 'K', 'W', -42, '[', -14, '|', 'P', -34, -20, 26, 'n', -77, -30, -33,
          -111, 'K', '^', 'r', 'Z', -97, '"', -111, -54, 'N', -33, -83, -65, -69
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          '\b', 'o', '%', -116, 'K', 'W', -42, '[', -14, '|', 'P', -34, -20, 26, 'n', -77, -30, -33,
          -111, 'K', '^', 'r', 'Z', -97, '"', -111, -54, 'N', -33, -83, -65, -69
        },
        actualTwiceOfResult.getBytes());
  }

  /**
   * Test {@link Sha256Hash#twiceOf(boolean, byte[])}.
   *
   * <p>Method under test: {@link Sha256Hash#twiceOf(boolean, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash Sha256Hash.twiceOf(boolean, byte[])"})
  public void testTwiceOf2() {
    // Arrange and Act
    Sha256Hash actualTwiceOfResult =
        Sha256Hash.twiceOf(false, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    BigInteger toBigIntegerResult = actualTwiceOfResult.toBigInteger();
    assertEquals(
        "87843101699767594173218391882965946153171449445678377364257449524895409992451",
        toBigIntegerResult.toString());
    ByteString byteString = actualTwiceOfResult.getByteString();
    assertEquals("�5o\u00033Ϙqޯ���\u0005-q|Co�Ì�)�H�b\u001cs\u0003", byteString.toStringUtf8());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) -62, iteratorResult.next().byteValue());
    assertTrue(iteratorResult.hasNext());
    assertEquals('5', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
    assertArrayEquals(
        new byte[] {
          -62,
          '5',
          'o',
          3,
          '3',
          -49,
          -104,
          'q',
          -34,
          -81,
          -77,
          -124,
          -40,
          5,
          '-',
          'q',
          '|',
          'C',
          'o',
          -46,
          -61,
          -116,
          -49,
          ')',
          -11,
          'H',
          -54,
          'b',
          28,
          Byte.MAX_VALUE,
          's',
          3
        },
        actualTwiceOfResult.getBytes());
    assertArrayEquals(
        new byte[] {
          0,
          -62,
          '5',
          'o',
          3,
          '3',
          -49,
          -104,
          'q',
          -34,
          -81,
          -77,
          -124,
          -40,
          5,
          '-',
          'q',
          '|',
          'C',
          'o',
          -46,
          -61,
          -116,
          -49,
          ')',
          -11,
          'H',
          -54,
          'b',
          28,
          Byte.MAX_VALUE,
          's',
          3
        },
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link Sha256Hash#newDigest()}.
   *
   * <p>Method under test: {@link Sha256Hash#newDigest()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link Sha256Hash#hashTwice(boolean, byte[], int, int, byte[], int, int)} with {@code
   * isSha256}, {@code input1}, {@code offset1}, {@code length1}, {@code input2}, {@code offset2},
   * {@code length2}.
   *
   * <p>Method under test: {@link Sha256Hash#hashTwice(boolean, byte[], int, int, byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Sha256Hash.hashTwice(boolean, byte[], int, int, byte[], int, int)"})
  public void testHashTwiceWithIsSha256Input1Offset1Length1Input2Offset2Length2()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualHashTwiceResult =
        Sha256Hash.hashTwice(
            true, "AXAXAXAX".getBytes("UTF-8"), 2, 3, "AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Assert
    assertArrayEquals(
        new byte[] {
          ' ', -84, -23, 18, '\b', '.', -70, -91, '/', 7, -94, -15, ' ', -71, -54, -73, '^', 'b',
          22, -76, 'i', -80, -89, -104, -68, -29, -116, 'w', -62, -1, '\n', ';'
        },
        actualHashTwiceResult);
  }

  /**
   * Test {@link Sha256Hash#hashTwice(boolean, byte[], int, int, byte[], int, int)} with {@code
   * isSha256}, {@code input1}, {@code offset1}, {@code length1}, {@code input2}, {@code offset2},
   * {@code length2}.
   *
   * <p>Method under test: {@link Sha256Hash#hashTwice(boolean, byte[], int, int, byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Sha256Hash.hashTwice(boolean, byte[], int, int, byte[], int, int)"})
  public void testHashTwiceWithIsSha256Input1Offset1Length1Input2Offset2Length22() {
    // Arrange and Act
    byte[] actualHashTwiceResult =
        Sha256Hash.hashTwice(
            false,
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            2,
            3,
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            2,
            3);

    // Assert
    assertArrayEquals(
        new byte[] {
          -99, -92, '.', -2, ':', 'N', -28, '_', -9, '_', -8, -86, -2, -49, 'g', 2, 'J', 'w', 'f',
          -73, -2, -80, -115, '%', '#', '\'', '\f', '-', -26, -127, 29, 'h'
        },
        actualHashTwiceResult);
  }

  /**
   * Test {@link Sha256Hash#hashTwice(boolean, byte[], int, int, byte[], int, int)} with {@code
   * isSha256}, {@code input1}, {@code offset1}, {@code length1}, {@code input2}, {@code offset2},
   * {@code length2}.
   *
   * <p>Method under test: {@link Sha256Hash#hashTwice(boolean, byte[], int, int, byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Sha256Hash.hashTwice(boolean, byte[], int, int, byte[], int, int)"})
  public void testHashTwiceWithIsSha256Input1Offset1Length1Input2Offset2Length23()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualHashTwiceResult =
        Sha256Hash.hashTwice(false, "AXAXAXAX".getBytes("UTF-8"), 2, 3, new byte[] {}, 2, 0);

    // Assert
    assertArrayEquals(
        new byte[] {
          21, -114, -117, -61, '\\', 14, -97, '\t', -54, '4', '\f', -43, 26, '\'', 2, -43, '2',
          '\'', -26, -78, -71, '\f', -117, -59, -74, -82, -110, '\'', -45, 'V', -69, -26
        },
        actualHashTwiceResult);
  }

  /**
   * Test {@link Sha256Hash#hashTwice(boolean, byte[], int, int, byte[], int, int)} with {@code
   * isSha256}, {@code input1}, {@code offset1}, {@code length1}, {@code input2}, {@code offset2},
   * {@code length2}.
   *
   * <p>Method under test: {@link Sha256Hash#hashTwice(boolean, byte[], int, int, byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Sha256Hash.hashTwice(boolean, byte[], int, int, byte[], int, int)"})
  public void testHashTwiceWithIsSha256Input1Offset1Length1Input2Offset2Length24()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualHashTwiceResult =
        Sha256Hash.hashTwice(
            false,
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            2,
            1,
            "AXAXAXAX".getBytes("UTF-8"),
            2,
            3);

    // Assert
    assertArrayEquals(
        new byte[] {
          -45, -82, ')', -87, -24, -73, -77, 15, -107, -34, -46, -32, 'w', 'e', -90, 'n', 5, '+',
          '$', -10, 'd', 22, -19, '=', ']', 'D', '9', 'd', 22, 'A', 't', '-'
        },
        actualHashTwiceResult);
  }

  /**
   * Test {@link Sha256Hash#hashTwice(boolean, byte[], int, int)} with {@code isSha256}, {@code
   * input}, {@code offset}, {@code length}.
   *
   * <p>Method under test: {@link Sha256Hash#hashTwice(boolean, byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Sha256Hash.hashTwice(boolean, byte[], int, int)"})
  public void testHashTwiceWithIsSha256InputOffsetLength() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualHashTwiceResult = Sha256Hash.hashTwice(true, "AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Assert
    assertArrayEquals(
        new byte[] {
          -120, '|', -112, 't', 'Z', '2', 'O', 29, -82, -94, ':', '5', -45, 'P', '^', '=', 'R',
          -109, -55, '\r', -109, '<', 'Y', -52, 'R', 26, '-', 'G', 'o', -34, -127, 's'
        },
        actualHashTwiceResult);
  }

  /**
   * Test {@link Sha256Hash#hashTwice(boolean, byte[], int, int)} with {@code isSha256}, {@code
   * input}, {@code offset}, {@code length}.
   *
   * <p>Method under test: {@link Sha256Hash#hashTwice(boolean, byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Sha256Hash.hashTwice(boolean, byte[], int, int)"})
  public void testHashTwiceWithIsSha256InputOffsetLength2() {
    // Arrange and Act
    byte[] actualHashTwiceResult =
        Sha256Hash.hashTwice(false, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 3);

    // Assert
    assertArrayEquals(
        new byte[] {
          -106, -116, '$', 'm', -15, '{', '>', -59, -89, -93, 't', '*', -54, 26, '@', -96, -64, -33,
          -96, '8', -110, -101, -69, -116, '*', -85, -41, '~', 1, '\\', 'D', '<'
        },
        actualHashTwiceResult);
  }

  /**
   * Test {@link Sha256Hash#hashTwice(boolean, byte[])} with {@code isSha256}, {@code input}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus sixty-two and {@code 5}.
   * </ul>
   *
   * <p>Method under test: {@link Sha256Hash#hashTwice(boolean, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Sha256Hash.hashTwice(boolean, byte[])"})
  public void testHashTwiceWithIsSha256Input_thenReturnArrayOfByteWithMinusSixtyTwoAnd5() {
    // Arrange and Act
    byte[] actualHashTwiceResult =
        Sha256Hash.hashTwice(false, new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertArrayEquals(
        new byte[] {
          -62,
          '5',
          'o',
          3,
          '3',
          -49,
          -104,
          'q',
          -34,
          -81,
          -77,
          -124,
          -40,
          5,
          '-',
          'q',
          '|',
          'C',
          'o',
          -46,
          -61,
          -116,
          -49,
          ')',
          -11,
          'H',
          -54,
          'b',
          28,
          Byte.MAX_VALUE,
          's',
          3
        },
        actualHashTwiceResult);
  }

  /**
   * Test {@link Sha256Hash#hashTwice(boolean, byte[])} with {@code isSha256}, {@code input}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return array of {@code byte} with backspace and {@code o}.
   * </ul>
   *
   * <p>Method under test: {@link Sha256Hash#hashTwice(boolean, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Sha256Hash.hashTwice(boolean, byte[])"})
  public void testHashTwiceWithIsSha256Input_whenTrue_thenReturnArrayOfByteWithBackspaceAndO()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualHashTwiceResult = Sha256Hash.hashTwice(true, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          '\b', 'o', '%', -116, 'K', 'W', -42, '[', -14, '|', 'P', -34, -20, 26, 'n', -77, -30, -33,
          -111, 'K', '^', 'r', 'Z', -97, '"', -111, -54, 'N', -33, -83, -65, -69
        },
        actualHashTwiceResult);
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Sha256Hash.equals(Object)", "int Sha256Hash.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Sha256Hash.ZERO_HASH, "Different type to Sha256Hash");
  }

  /**
   * Test {@link Sha256Hash#toBigInteger()}.
   *
   * <p>Method under test: {@link Sha256Hash#toBigInteger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigInteger Sha256Hash.toBigInteger()"})
  public void testToBigInteger() {
    // Arrange, Act and Assert
    assertEquals(BigInteger.ZERO, Sha256Hash.ZERO_HASH.toBigInteger());
  }

  /**
   * Test {@link Sha256Hash#getByteString()}.
   *
   * <p>Method under test: {@link Sha256Hash#getByteString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Sha256Hash.compareTo(Sha256Hash)"})
  public void testCompareToWithSha256Hash_whenZero_hash_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Sha256Hash.ZERO_HASH.compareTo(Sha256Hash.ZERO_HASH));
  }
}
