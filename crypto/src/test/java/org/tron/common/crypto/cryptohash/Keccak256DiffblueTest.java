package org.tron.common.crypto.cryptohash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Keccak256DiffblueTest {
  /**
   * Test new {@link Keccak256} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Keccak256}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Keccak256.<init>()"})
  public void testNewKeccak256() {
    // Arrange and Act
    Keccak256 actualKeccak256 = new Keccak256();

    // Assert
    assertEquals("tron-keccak-256", actualKeccak256.getAlgorithm());
    assertNull(actualKeccak256.getProvider());
    assertEquals(0, actualKeccak256.flush());
    assertEquals(0L, actualKeccak256.getBlockCount());
    assertEquals(136, actualKeccak256.getInternalBlockLength());
    assertEquals(136, actualKeccak256.getBlockLength());
    assertEquals(136, actualKeccak256.getBlockBuffer().length);
    assertEquals(Integer.SIZE, actualKeccak256.getDigestLength());
  }

  /**
   * Test {@link Keccak256#copy()}.
   *
   * <p>Method under test: {@link Keccak256#copy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Digest Keccak256.copy()"})
  public void testCopy() {
    // Arrange and Act
    Digest actualCopyResult = new Keccak256().copy();

    // Assert
    assertTrue(actualCopyResult instanceof Keccak256);
    assertEquals("tron-keccak-256", ((Keccak256) actualCopyResult).getAlgorithm());
    assertNull(((Keccak256) actualCopyResult).getProvider());
    assertEquals(0, ((Keccak256) actualCopyResult).flush());
    assertEquals(0L, ((Keccak256) actualCopyResult).getBlockCount());
    assertEquals(136, actualCopyResult.getBlockLength());
    assertEquals(136, ((Keccak256) actualCopyResult).getInternalBlockLength());
    assertEquals(136, ((Keccak256) actualCopyResult).getBlockBuffer().length);
    assertEquals(Integer.SIZE, actualCopyResult.getDigestLength());
  }

  /**
   * Test {@link Keccak256#engineGetDigestLength()}.
   *
   * <p>Method under test: {@link Keccak256#engineGetDigestLength()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Keccak256.engineGetDigestLength()"})
  public void testEngineGetDigestLength() {
    // Arrange, Act and Assert
    assertEquals(Integer.SIZE, new Keccak256().engineGetDigestLength());
  }

  /**
   * Test {@link Keccak256#engineDigest()}.
   *
   * <p>Method under test: {@link Keccak256#engineDigest()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Keccak256.engineDigest()"})
  public void testEngineDigest() {
    // Arrange, Act and Assert
    assertNull(new Keccak256().engineDigest());
  }
}
