package org.tron.common.crypto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.crypto.Blake2bfMessageDigest.Blake2bfDigest;

public class Blake2bfMessageDigestDiffblueTest {
  /**
   * Test Blake2bfDigest {@link Blake2bfDigest#doFinal(byte[], int)}.
   *
   * <p>Method under test: {@link Blake2bfDigest#doFinal(byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Blake2bfDigest.doFinal(byte[], int)"})
  public void testBlake2bfDigestDoFinal() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new Blake2bfDigest().doFinal("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test Blake2bfDigest {@link Blake2bfDigest#getAlgorithmName()}.
   *
   * <p>Method under test: {@link Blake2bfDigest#getAlgorithmName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Blake2bfDigest.getAlgorithmName()"})
  public void testBlake2bfDigestGetAlgorithmName() {
    // Arrange, Act and Assert
    assertEquals("BLAKE2f", new Blake2bfDigest().getAlgorithmName());
  }

  /**
   * Test Blake2bfDigest {@link Blake2bfDigest#getDigestSize()}.
   *
   * <p>Method under test: {@link Blake2bfDigest#getDigestSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Blake2bfDigest.getDigestSize()"})
  public void testBlake2bfDigestGetDigestSize() {
    // Arrange, Act and Assert
    assertEquals(Double.SIZE, new Blake2bfDigest().getDigestSize());
  }

  /**
   * Test Blake2bfDigest {@link Blake2bfDigest#Blake2bfDigest()}.
   *
   * <p>Method under test: {@link Blake2bfDigest#Blake2bfDigest()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Blake2bfDigest.<init>()"})
  public void testBlake2bfDigestNewBlake2bfDigest() {
    // Arrange and Act
    Blake2bfDigest actualBlake2bfDigest = new Blake2bfDigest();

    // Assert
    assertEquals("BLAKE2f", actualBlake2bfDigest.getAlgorithmName());
    assertEquals(Double.SIZE, actualBlake2bfDigest.getDigestSize());
  }

  /**
   * Test Blake2bfDigest {@link Blake2bfDigest#Blake2bfDigest(long[], long[], long[], boolean,
   * long)}.
   *
   * <p>Method under test: {@link Blake2bfDigest#Blake2bfDigest(long[], long[], long[], boolean,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Blake2bfDigest.<init>(long[], long[], long[], boolean, long)"})
  public void testBlake2bfDigestNewBlake2bfDigest2() {
    // Arrange and Act
    Blake2bfDigest actualBlake2bfDigest =
        new Blake2bfDigest(
            new long[] {1L, 0L, 1L, 0L},
            new long[] {1L, 0L, 1L, 0L},
            new long[] {1L, 0L, 1L, 0L},
            true,
            1L);

    // Assert
    assertEquals("BLAKE2f", actualBlake2bfDigest.getAlgorithmName());
    assertEquals(Double.SIZE, actualBlake2bfDigest.getDigestSize());
  }

  /**
   * Test new {@link Blake2bfMessageDigest} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Blake2bfMessageDigest}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Blake2bfMessageDigest.<init>()"})
  public void testNewBlake2bfMessageDigest() {
    // Arrange and Act
    Blake2bfMessageDigest actualBlake2bfMessageDigest = new Blake2bfMessageDigest();

    // Assert
    assertEquals("BLAKE2f", actualBlake2bfMessageDigest.getAlgorithm());
    assertNull(actualBlake2bfMessageDigest.getProvider());
    assertEquals(Double.SIZE, actualBlake2bfMessageDigest.getDigestLength());
  }
}
