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
   * <p>
   * Method under test: default or parameterless constructor of {@link Keccak256}
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
    assertEquals(136, actualKeccak256.getBlockBuffer().length);
    assertEquals(Integer.SIZE, actualKeccak256.getDigestLength());
  }

  /**
   * Test {@link Keccak256#copy()}.
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).</li>
   *   <li>Then return {@link Keccak256}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keccak256#copy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Digest Keccak256.copy()"})
  public void testCopy_givenKeccak256_thenReturnKeccak256() {
    // Arrange and Act
    Digest actualCopyResult = (new Keccak256()).copy();

    // Assert
    assertTrue(actualCopyResult instanceof Keccak256);
    assertEquals("tron-keccak-256", ((Keccak256) actualCopyResult).getAlgorithm());
    assertNull(((Keccak256) actualCopyResult).getProvider());
    assertEquals(0, ((Keccak256) actualCopyResult).flush());
    assertEquals(0L, ((Keccak256) actualCopyResult).getBlockCount());
    assertEquals(136, ((Keccak256) actualCopyResult).getInternalBlockLength());
    assertEquals(136, ((Keccak256) actualCopyResult).getBlockBuffer().length);
    assertEquals(Integer.SIZE, actualCopyResult.getDigestLength());
  }

  /**
   * Test {@link Keccak256#engineGetDigestLength()}.
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).</li>
   *   <li>Then return {@link Integer#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keccak256#engineGetDigestLength()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Keccak256.engineGetDigestLength()"})
  public void testEngineGetDigestLength_givenKeccak256_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Integer.SIZE, (new Keccak256()).engineGetDigestLength());
  }

  /**
   * Test {@link Keccak256#engineDigest()}.
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keccak256#engineDigest()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Keccak256.engineDigest()"})
  public void testEngineDigest_givenKeccak256_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Keccak256()).engineDigest());
  }
}
