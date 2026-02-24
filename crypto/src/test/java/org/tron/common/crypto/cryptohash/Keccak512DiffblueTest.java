package org.tron.common.crypto.cryptohash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Keccak512DiffblueTest {
  /**
   * Test new {@link Keccak512} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Keccak512}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Keccak512.<init>()"})
  public void testNewKeccak512() {
    // Arrange and Act
    Keccak512 actualKeccak512 = new Keccak512();

    // Assert
    assertEquals("tron-keccak-512", actualKeccak512.getAlgorithm());
    assertNull(actualKeccak512.getProvider());
    assertEquals(0, actualKeccak512.flush());
    assertEquals(0L, actualKeccak512.getBlockCount());
    assertEquals(72, actualKeccak512.getInternalBlockLength());
    assertEquals(72, actualKeccak512.getBlockLength());
    assertEquals(72, actualKeccak512.getBlockBuffer().length);
    assertEquals(Double.SIZE, actualKeccak512.getDigestLength());
  }

  /**
   * Test {@link Keccak512#copy()}.
   *
   * <p>Method under test: {@link Keccak512#copy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Digest Keccak512.copy()"})
  public void testCopy() {
    // Arrange and Act
    Digest actualCopyResult = new Keccak512().copy();

    // Assert
    assertTrue(actualCopyResult instanceof Keccak512);
    assertEquals("tron-keccak-512", ((Keccak512) actualCopyResult).getAlgorithm());
    assertNull(((Keccak512) actualCopyResult).getProvider());
    assertEquals(0, ((Keccak512) actualCopyResult).flush());
    assertEquals(0L, ((Keccak512) actualCopyResult).getBlockCount());
    assertEquals(72, actualCopyResult.getBlockLength());
    assertEquals(72, ((Keccak512) actualCopyResult).getInternalBlockLength());
    assertEquals(72, ((Keccak512) actualCopyResult).getBlockBuffer().length);
    assertEquals(Double.SIZE, actualCopyResult.getDigestLength());
  }

  /**
   * Test {@link Keccak512#engineGetDigestLength()}.
   *
   * <p>Method under test: {@link Keccak512#engineGetDigestLength()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Keccak512.engineGetDigestLength()"})
  public void testEngineGetDigestLength() {
    // Arrange, Act and Assert
    assertEquals(Double.SIZE, new Keccak512().engineGetDigestLength());
  }

  /**
   * Test {@link Keccak512#engineDigest()}.
   *
   * <p>Method under test: {@link Keccak512#engineDigest()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Keccak512.engineDigest()"})
  public void testEngineDigest() {
    // Arrange, Act and Assert
    assertNull(new Keccak512().engineDigest());
  }
}
