package org.tron.common.crypto.cryptohash;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DigestEngineDiffblueTest {
  /**
   * Test {@link DigestEngine#digest(byte[], int, int)} with {@code buf}, {@code offset}, {@code
   * len}.
   *
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).
   *   <li>Then array length is one hundred thirty-six.
   * </ul>
   *
   * <p>Method under test: {@link DigestEngine#digest(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DigestEngine.digest(byte[], int, int)"})
  public void testDigestWithBufOffsetLen_givenKeccak256_thenArrayLengthIsOneHundredThirtySix()
      throws UnsupportedEncodingException {
    // Arrange
    Keccak256 keccak256 = new Keccak256();
    byte[] buf = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualDigestResult = keccak256.digest(buf, 2, 3);

    // Assert
    byte[] blockBuffer = keccak256.getBlockBuffer();
    assertEquals(136, blockBuffer.length);
    assertEquals((byte) 1, blockBuffer[0]);
    assertEquals(3, actualDigestResult);
    assertEquals(Byte.MIN_VALUE, blockBuffer[135]);
    assertArrayEquals(new byte[] {'A', 'X', -59, -46, 'F', 'X', 'A', 'X'}, buf);
  }

  /**
   * Test {@link DigestEngine#digest(byte[])} with {@code input}.
   *
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).
   *   <li>Then array length is one hundred thirty-six.
   * </ul>
   *
   * <p>Method under test: {@link DigestEngine#digest(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DigestEngine.digest(byte[])"})
  public void testDigestWithInput_givenKeccak256_thenArrayLengthIsOneHundredThirtySix()
      throws UnsupportedEncodingException {
    // Arrange
    Keccak256 keccak256 = new Keccak256();

    // Act
    byte[] actualDigestResult = keccak256.digest("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] blockBuffer = keccak256.getBlockBuffer();
    assertEquals(136, blockBuffer.length);
    assertEquals((byte) 1, blockBuffer[8]);
    assertEquals(Byte.MIN_VALUE, blockBuffer[135]);
    assertEquals('A', blockBuffer[0]);
    assertEquals('A', blockBuffer[2]);
    assertEquals('A', blockBuffer[4]);
    assertEquals('A', blockBuffer[6]);
    assertEquals('X', blockBuffer[1]);
    assertEquals('X', blockBuffer[3]);
    assertEquals('X', blockBuffer[5]);
    assertEquals('X', blockBuffer[7]);
    assertArrayEquals(
        new byte[] {
          -84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75, -41,
          '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54
        },
        actualDigestResult);
  }

  /**
   * Test {@link DigestEngine#digest()}.
   *
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).
   *   <li>Then array length is one hundred thirty-six.
   * </ul>
   *
   * <p>Method under test: {@link DigestEngine#digest()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DigestEngine.digest()"})
  public void testDigest_givenKeccak256_thenArrayLengthIsOneHundredThirtySix() {
    // Arrange
    Keccak256 keccak256 = new Keccak256();

    // Act
    byte[] actualDigestResult = keccak256.digest();

    // Assert
    byte[] blockBuffer = keccak256.getBlockBuffer();
    assertEquals(136, blockBuffer.length);
    assertEquals((byte) 1, blockBuffer[0]);
    assertEquals(Byte.MIN_VALUE, blockBuffer[135]);
    assertArrayEquals(
        new byte[] {
          -59, -46, 'F', 1, -122, -9, '#', '<', -110, '~', '}', -78, -36, -57, 3, -64, -27, 0, -74,
          'S', -54, -126, '\'', ';', '{', -6, -40, 4, ']', -123, -92, 'p'
        },
        actualDigestResult);
  }

  /**
   * Test {@link DigestEngine#update(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).
   *   <li>Then array length is one hundred thirty-six.
   * </ul>
   *
   * <p>Method under test: {@link DigestEngine#update(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DigestEngine.update(byte[], int, int)"})
  public void testUpdateWithByteIntInt_givenKeccak256_thenArrayLengthIsOneHundredThirtySix()
      throws UnsupportedEncodingException {
    // Arrange
    Keccak256 keccak256 = new Keccak256();

    // Act
    keccak256.update("AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Assert
    byte[] blockBuffer = keccak256.getBlockBuffer();
    assertEquals(136, blockBuffer.length);
    assertEquals(3, keccak256.flush());
    assertEquals('A', blockBuffer[0]);
    assertEquals('A', blockBuffer[2]);
    assertEquals('X', blockBuffer[1]);
  }

  /**
   * Test {@link DigestEngine#update(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).
   *   <li>Then array length is one hundred thirty-six.
   * </ul>
   *
   * <p>Method under test: {@link DigestEngine#update(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DigestEngine.update(byte[])"})
  public void testUpdateWithByte_givenKeccak256_thenArrayLengthIsOneHundredThirtySix()
      throws UnsupportedEncodingException {
    // Arrange
    Keccak256 keccak256 = new Keccak256();

    // Act
    keccak256.update("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] blockBuffer = keccak256.getBlockBuffer();
    assertEquals(136, blockBuffer.length);
    assertEquals(8, keccak256.flush());
    assertEquals('A', blockBuffer[0]);
    assertEquals('A', blockBuffer[2]);
    assertEquals('A', blockBuffer[4]);
    assertEquals('A', blockBuffer[6]);
    assertEquals('X', blockBuffer[1]);
    assertEquals('X', blockBuffer[3]);
    assertEquals('X', blockBuffer[5]);
    assertEquals('X', blockBuffer[7]);
  }

  /**
   * Test {@link DigestEngine#update(byte)} with {@code byte}.
   *
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).
   *   <li>Then {@link Keccak256} (default constructor) flush is one.
   * </ul>
   *
   * <p>Method under test: {@link DigestEngine#update(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DigestEngine.update(byte)"})
  public void testUpdateWithByte_givenKeccak256_thenKeccak256FlushIsOne() {
    // Arrange
    Keccak256 keccak256 = new Keccak256();

    // Act
    keccak256.update((byte) 'A');

    // Assert
    assertEquals(1, keccak256.flush());
    byte[] blockBuffer = keccak256.getBlockBuffer();
    assertEquals(136, blockBuffer.length);
    assertEquals('A', blockBuffer[0]);
  }

  /**
   * Test {@link DigestEngine#getInternalBlockLength()}.
   *
   * <p>Method under test: {@link DigestEngine#getInternalBlockLength()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DigestEngine.getInternalBlockLength()"})
  public void testGetInternalBlockLength() {
    // Arrange, Act and Assert
    assertEquals(136, new Keccak256().getInternalBlockLength());
  }

  /**
   * Test {@link DigestEngine#flush()}.
   *
   * <p>Method under test: {@link DigestEngine#flush()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DigestEngine.flush()"})
  public void testFlush() {
    // Arrange, Act and Assert
    assertEquals(0, new Keccak256().flush());
  }

  /**
   * Test {@link DigestEngine#getBlockBuffer()}.
   *
   * <p>Method under test: {@link DigestEngine#getBlockBuffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DigestEngine.getBlockBuffer()"})
  public void testGetBlockBuffer() {
    // Arrange and Act
    byte[] actualBlockBuffer = new Keccak256().getBlockBuffer();

    // Assert
    assertEquals((byte) 0, actualBlockBuffer[0]);
    assertEquals((byte) 0, actualBlockBuffer[1]);
    assertEquals((byte) 0, actualBlockBuffer[10]);
    assertEquals((byte) 0, actualBlockBuffer[11]);
    assertEquals((byte) 0, actualBlockBuffer[111]);
    assertEquals((byte) 0, actualBlockBuffer[112]);
    assertEquals((byte) 0, actualBlockBuffer[113]);
    assertEquals((byte) 0, actualBlockBuffer[114]);
    assertEquals((byte) 0, actualBlockBuffer[115]);
    assertEquals((byte) 0, actualBlockBuffer[116]);
    assertEquals((byte) 0, actualBlockBuffer[117]);
    assertEquals((byte) 0, actualBlockBuffer[118]);
    assertEquals((byte) 0, actualBlockBuffer[119]);
    assertEquals((byte) 0, actualBlockBuffer[12]);
    assertEquals((byte) 0, actualBlockBuffer[120]);
    assertEquals((byte) 0, actualBlockBuffer[121]);
    assertEquals((byte) 0, actualBlockBuffer[122]);
    assertEquals((byte) 0, actualBlockBuffer[123]);
    assertEquals((byte) 0, actualBlockBuffer[124]);
    assertEquals((byte) 0, actualBlockBuffer[125]);
    assertEquals((byte) 0, actualBlockBuffer[126]);
    assertEquals((byte) 0, actualBlockBuffer[128]);
    assertEquals((byte) 0, actualBlockBuffer[129]);
    assertEquals((byte) 0, actualBlockBuffer[13]);
    assertEquals((byte) 0, actualBlockBuffer[130]);
    assertEquals((byte) 0, actualBlockBuffer[131]);
    assertEquals((byte) 0, actualBlockBuffer[132]);
    assertEquals((byte) 0, actualBlockBuffer[133]);
    assertEquals((byte) 0, actualBlockBuffer[134]);
    assertEquals((byte) 0, actualBlockBuffer[135]);
    assertEquals((byte) 0, actualBlockBuffer[14]);
    assertEquals((byte) 0, actualBlockBuffer[15]);
    assertEquals((byte) 0, actualBlockBuffer[17]);
    assertEquals((byte) 0, actualBlockBuffer[18]);
    assertEquals((byte) 0, actualBlockBuffer[19]);
    assertEquals((byte) 0, actualBlockBuffer[2]);
    assertEquals((byte) 0, actualBlockBuffer[20]);
    assertEquals((byte) 0, actualBlockBuffer[21]);
    assertEquals((byte) 0, actualBlockBuffer[22]);
    assertEquals((byte) 0, actualBlockBuffer[23]);
    assertEquals((byte) 0, actualBlockBuffer[24]);
    assertEquals((byte) 0, actualBlockBuffer[3]);
    assertEquals((byte) 0, actualBlockBuffer[4]);
    assertEquals((byte) 0, actualBlockBuffer[5]);
    assertEquals((byte) 0, actualBlockBuffer[6]);
    assertEquals((byte) 0, actualBlockBuffer[7]);
    assertEquals((byte) 0, actualBlockBuffer[8]);
    assertEquals((byte) 0, actualBlockBuffer[9]);
    assertEquals((byte) 0, actualBlockBuffer[Float.MAX_EXPONENT]);
    assertEquals((byte) 0, actualBlockBuffer[Short.SIZE]);
    assertEquals(136, actualBlockBuffer.length);
  }

  /**
   * Test {@link DigestEngine#getBlockCount()}.
   *
   * <p>Method under test: {@link DigestEngine#getBlockCount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DigestEngine.getBlockCount()"})
  public void testGetBlockCount() {
    // Arrange, Act and Assert
    assertEquals(0L, new Keccak256().getBlockCount());
  }

  /**
   * Test {@link DigestEngine#copyState(DigestEngine)}.
   *
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).
   *   <li>When {@link Keccak256} (default constructor).
   *   <li>Then return {@link Keccak256} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DigestEngine#copyState(DigestEngine)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Digest DigestEngine.copyState(DigestEngine)"})
  public void testCopyState_givenKeccak256_whenKeccak256_thenReturnKeccak256() {
    // Arrange
    Keccak256 keccak256 = new Keccak256();
    Keccak256 dest = new Keccak256();

    // Act
    Digest actualCopyStateResult = keccak256.copyState((DigestEngine) dest);

    // Assert
    assertSame(dest, actualCopyStateResult);
  }
}
