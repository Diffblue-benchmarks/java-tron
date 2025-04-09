package org.tron.common.crypto.cryptohash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KeccakCoreDiffblueTest {
  /**
   * Test {@link KeccakCore#getBlockLength()}.
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).</li>
   *   <li>Then return one hundred thirty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeccakCore#getBlockLength()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int KeccakCore.getBlockLength()"})
  public void testGetBlockLength_givenKeccak256_thenReturnOneHundredThirtySix() {
    // Arrange, Act and Assert
    assertEquals(136, (new Keccak256()).getBlockLength());
  }

  /**
   * Test {@link KeccakCore#copyState(KeccakCore)} with {@code dst}.
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).</li>
   *   <li>When {@link Keccak256} (default constructor).</li>
   *   <li>Then return {@link Keccak256} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link KeccakCore#copyState(KeccakCore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.crypto.cryptohash.Digest KeccakCore.copyState(KeccakCore)"})
  public void testCopyStateWithDst_givenKeccak256_whenKeccak256_thenReturnKeccak256() {
    // Arrange
    Keccak256 keccak256 = new Keccak256();
    Keccak256 dst = new Keccak256();

    // Act and Assert
    assertSame(dst, keccak256.copyState(dst));
  }

  /**
   * Test {@link KeccakCore#toString()}.
   * <ul>
   *   <li>Given Instance is {@code SHA-1}.</li>
   *   <li>Then return {@code SHA-1 Message Digest from SUN, <initialized>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeccakCore#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String KeccakCore.toString()"})
  public void testToString_givenInstanceIsSha1_thenReturnSha1MessageDigestFromSunInitialized()
      throws NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("SHA-1 Message Digest from SUN, <initialized>\n", MessageDigest.getInstance("SHA-1").toString());
  }

  /**
   * Test {@link KeccakCore#toString()}.
   * <ul>
   *   <li>Given {@link Keccak256} (default constructor).</li>
   *   <li>Then return {@code Keccak-256}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeccakCore#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String KeccakCore.toString()"})
  public void testToString_givenKeccak256_thenReturnKeccak256() {
    // Arrange, Act and Assert
    assertEquals("Keccak-256", (new Keccak256()).toString());
  }
}
