package org.tron.common.crypto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class Blake2bfMessageDigestDiffblueTest {
  /**
   * Method under test:
   * {@link Blake2bfMessageDigest.Blake2bfDigest#doFinal(byte[], int)}
   */
  @Test
  public void testBlake2bfDigestDoFinal() throws UnsupportedEncodingException {
    // Arrange
    Blake2bfMessageDigest.Blake2bfDigest blake2bfDigest = new Blake2bfMessageDigest.Blake2bfDigest();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> blake2bfDigest.doFinal("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test:
   * {@link Blake2bfMessageDigest.Blake2bfDigest#getAlgorithmName()}
   */
  @Test
  public void testBlake2bfDigestGetAlgorithmName() {
    // Arrange, Act and Assert
    assertEquals("BLAKE2f", (new Blake2bfMessageDigest.Blake2bfDigest()).getAlgorithmName());
  }

  /**
   * Method under test:
   * {@link Blake2bfMessageDigest.Blake2bfDigest#getDigestSize()}
   */
  @Test
  public void testBlake2bfDigestGetDigestSize() {
    // Arrange, Act and Assert
    assertEquals(Double.SIZE, (new Blake2bfMessageDigest.Blake2bfDigest()).getDigestSize());
  }

  /**
   * Method under test:
   * {@link Blake2bfMessageDigest.Blake2bfDigest#Blake2bfDigest()}
   */
  @Test
  public void testBlake2bfDigestNewBlake2bfDigest() {
    // Arrange and Act
    Blake2bfMessageDigest.Blake2bfDigest actualBlake2bfDigest = new Blake2bfMessageDigest.Blake2bfDigest();

    // Assert
    assertEquals("BLAKE2f", actualBlake2bfDigest.getAlgorithmName());
    assertEquals(Double.SIZE, actualBlake2bfDigest.getDigestSize());
  }

  /**
   * Method under test:
   * {@link Blake2bfMessageDigest.Blake2bfDigest#Blake2bfDigest(long[], long[], long[], boolean, long)}
   */
  @Test
  public void testBlake2bfDigestNewBlake2bfDigest2() {
    // Arrange and Act
    Blake2bfMessageDigest.Blake2bfDigest actualBlake2bfDigest = new Blake2bfMessageDigest.Blake2bfDigest(
        new long[]{1L, 0L, 1L, 0L}, new long[]{1L, 0L, 1L, 0L}, new long[]{1L, 0L, 1L, 0L}, true, 1L);

    // Assert
    assertEquals("BLAKE2f", actualBlake2bfDigest.getAlgorithmName());
    assertEquals(Double.SIZE, actualBlake2bfDigest.getDigestSize());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link Blake2bfMessageDigest}
   */
  @Test
  public void testNewBlake2bfMessageDigest() {
    // Arrange and Act
    Blake2bfMessageDigest actualBlake2bfMessageDigest = new Blake2bfMessageDigest();

    // Assert
    assertEquals("BLAKE2f", actualBlake2bfMessageDigest.getAlgorithm());
    assertNull(actualBlake2bfMessageDigest.getProvider());
    assertEquals(Double.SIZE, actualBlake2bfMessageDigest.getDigestLength());
  }
}
