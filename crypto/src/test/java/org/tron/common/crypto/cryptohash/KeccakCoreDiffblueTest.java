package org.tron.common.crypto.cryptohash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.junit.Test;

public class KeccakCoreDiffblueTest {
  /**
   * Method under test: {@link KeccakCore#getBlockLength()}
   */
  @Test
  public void testGetBlockLength() {
    // Arrange, Act and Assert
    assertEquals(136, (new Keccak256()).getBlockLength());
  }

  /**
   * Method under test: {@link KeccakCore#copyState(KeccakCore)}
   */
  @Test
  public void testCopyState() {
    // Arrange
    Keccak256 keccak256 = new Keccak256();
    Keccak256 dst = new Keccak256();

    // Act and Assert
    assertSame(dst, keccak256.copyState(dst));
  }

  /**
   * Method under test: {@link KeccakCore#toString()}
   */
  @Test
  public void testToString() throws NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("SHA-1 Message Digest from SUN, <initialized>\n", MessageDigest.getInstance("SHA-1").toString());
    assertEquals("Keccak-256", (new Keccak256()).toString());
  }
}
