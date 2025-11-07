package org.tron.common.crypto.cryptohash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Keccak512DiffblueTest {
  /**
   * Test new {@link Keccak512} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Keccak512}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    assertEquals(72, actualKeccak512.getBlockBuffer().length);
    assertEquals(Double.SIZE, actualKeccak512.getDigestLength());
  }

  /**
   * Test {@link Keccak512#copy()}.
   * <ul>
   *   <li>Given {@link Keccak512} (default constructor).</li>
   *   <li>Then return {@link Keccak512}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keccak512#copy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Digest Keccak512.copy()"})
  public void testCopy_givenKeccak512_thenReturnKeccak512() {
    // Arrange and Act
    Digest actualCopyResult = (new Keccak512()).copy();

    // Assert
    assertTrue(actualCopyResult instanceof Keccak512);
    assertEquals("tron-keccak-512", ((Keccak512) actualCopyResult).getAlgorithm());
    assertNull(((Keccak512) actualCopyResult).getProvider());
    assertEquals(0, ((Keccak512) actualCopyResult).flush());
    assertEquals(0L, ((Keccak512) actualCopyResult).getBlockCount());
    assertEquals(72, ((Keccak512) actualCopyResult).getInternalBlockLength());
    assertEquals(72, ((Keccak512) actualCopyResult).getBlockBuffer().length);
    assertEquals(Double.SIZE, actualCopyResult.getDigestLength());
  }

  /**
   * Test {@link Keccak512#engineGetDigestLength()}.
   * <ul>
   *   <li>Given {@link Keccak512} (default constructor).</li>
   *   <li>Then return {@link Double#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keccak512#engineGetDigestLength()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Keccak512.engineGetDigestLength()"})
  public void testEngineGetDigestLength_givenKeccak512_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Double.SIZE, (new Keccak512()).engineGetDigestLength());
  }

  /**
   * Test {@link Keccak512#engineDigest()}.
   * <ul>
   *   <li>Given {@link Keccak512} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Keccak512#engineDigest()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Keccak512.engineDigest()"})
  public void testEngineDigest_givenKeccak512_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Keccak512()).engineDigest());
  }
}
