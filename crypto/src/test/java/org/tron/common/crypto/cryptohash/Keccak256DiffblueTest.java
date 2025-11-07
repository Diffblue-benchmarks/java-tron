package org.tron.common.crypto.cryptohash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Keccak256DiffblueTest {
  /**
   * Method under test: {@link Keccak256#copy()}
   */
  @Test
  public void testCopy() {
    // Arrange and Act
    Digest actualCopyResult = (new Keccak256()).copy();

    // Assert
    assertTrue(actualCopyResult instanceof Keccak256);
    assertEquals("tron-keccak-256", ((Keccak256) actualCopyResult).getAlgorithm());
    assertNull(((Keccak256) actualCopyResult).getProvider());
    assertEquals(0, ((Keccak256) actualCopyResult).flush());
    assertEquals(0L, ((Keccak256) actualCopyResult).getBlockCount());
    byte[] blockBuffer = ((Keccak256) actualCopyResult).getBlockBuffer();
    assertEquals((byte) 0, blockBuffer[0]);
    assertEquals((byte) 0, blockBuffer[1]);
    assertEquals((byte) 0, blockBuffer[10]);
    assertEquals((byte) 0, blockBuffer[11]);
    assertEquals((byte) 0, blockBuffer[111]);
    assertEquals((byte) 0, blockBuffer[112]);
    assertEquals((byte) 0, blockBuffer[113]);
    assertEquals((byte) 0, blockBuffer[114]);
    assertEquals((byte) 0, blockBuffer[115]);
    assertEquals((byte) 0, blockBuffer[116]);
    assertEquals((byte) 0, blockBuffer[117]);
    assertEquals((byte) 0, blockBuffer[118]);
    assertEquals((byte) 0, blockBuffer[119]);
    assertEquals((byte) 0, blockBuffer[12]);
    assertEquals((byte) 0, blockBuffer[120]);
    assertEquals((byte) 0, blockBuffer[121]);
    assertEquals((byte) 0, blockBuffer[122]);
    assertEquals((byte) 0, blockBuffer[123]);
    assertEquals((byte) 0, blockBuffer[124]);
    assertEquals((byte) 0, blockBuffer[125]);
    assertEquals((byte) 0, blockBuffer[126]);
    assertEquals((byte) 0, blockBuffer[128]);
    assertEquals((byte) 0, blockBuffer[129]);
    assertEquals((byte) 0, blockBuffer[13]);
    assertEquals((byte) 0, blockBuffer[130]);
    assertEquals((byte) 0, blockBuffer[131]);
    assertEquals((byte) 0, blockBuffer[132]);
    assertEquals((byte) 0, blockBuffer[133]);
    assertEquals((byte) 0, blockBuffer[134]);
    assertEquals((byte) 0, blockBuffer[135]);
    assertEquals((byte) 0, blockBuffer[14]);
    assertEquals((byte) 0, blockBuffer[15]);
    assertEquals((byte) 0, blockBuffer[17]);
    assertEquals((byte) 0, blockBuffer[18]);
    assertEquals((byte) 0, blockBuffer[19]);
    assertEquals((byte) 0, blockBuffer[2]);
    assertEquals((byte) 0, blockBuffer[20]);
    assertEquals((byte) 0, blockBuffer[21]);
    assertEquals((byte) 0, blockBuffer[22]);
    assertEquals((byte) 0, blockBuffer[23]);
    assertEquals((byte) 0, blockBuffer[24]);
    assertEquals((byte) 0, blockBuffer[3]);
    assertEquals((byte) 0, blockBuffer[4]);
    assertEquals((byte) 0, blockBuffer[5]);
    assertEquals((byte) 0, blockBuffer[6]);
    assertEquals((byte) 0, blockBuffer[7]);
    assertEquals((byte) 0, blockBuffer[8]);
    assertEquals((byte) 0, blockBuffer[9]);
    assertEquals((byte) 0, blockBuffer[Float.MAX_EXPONENT]);
    assertEquals((byte) 0, blockBuffer[Short.SIZE]);
    assertEquals(136, ((Keccak256) actualCopyResult).getInternalBlockLength());
    assertEquals(136, blockBuffer.length);
    assertEquals(Integer.SIZE, actualCopyResult.getDigestLength());
  }

  /**
   * Method under test: {@link Keccak256#engineGetDigestLength()}
   */
  @Test
  public void testEngineGetDigestLength() {
    // Arrange, Act and Assert
    assertEquals(Integer.SIZE, (new Keccak256()).engineGetDigestLength());
  }

  /**
   * Method under test: {@link Keccak256#engineDigest()}
   */
  @Test
  public void testEngineDigest() {
    // Arrange, Act and Assert
    assertNull((new Keccak256()).engineDigest());
  }

  /**
   * Method under test: default or parameterless constructor of {@link Keccak256}
   */
  @Test
  public void testNewKeccak256() {
    // Arrange and Act
    Keccak256 actualKeccak256 = new Keccak256();

    // Assert
    assertEquals("tron-keccak-256", actualKeccak256.getAlgorithm());
    assertNull(actualKeccak256.getProvider());
    assertEquals(0, actualKeccak256.flush());
    assertEquals(0L, actualKeccak256.getBlockCount());
    byte[] blockBuffer = actualKeccak256.getBlockBuffer();
    assertEquals((byte) 0, blockBuffer[0]);
    assertEquals((byte) 0, blockBuffer[1]);
    assertEquals((byte) 0, blockBuffer[10]);
    assertEquals((byte) 0, blockBuffer[11]);
    assertEquals((byte) 0, blockBuffer[111]);
    assertEquals((byte) 0, blockBuffer[112]);
    assertEquals((byte) 0, blockBuffer[113]);
    assertEquals((byte) 0, blockBuffer[114]);
    assertEquals((byte) 0, blockBuffer[115]);
    assertEquals((byte) 0, blockBuffer[116]);
    assertEquals((byte) 0, blockBuffer[117]);
    assertEquals((byte) 0, blockBuffer[118]);
    assertEquals((byte) 0, blockBuffer[119]);
    assertEquals((byte) 0, blockBuffer[12]);
    assertEquals((byte) 0, blockBuffer[120]);
    assertEquals((byte) 0, blockBuffer[121]);
    assertEquals((byte) 0, blockBuffer[122]);
    assertEquals((byte) 0, blockBuffer[123]);
    assertEquals((byte) 0, blockBuffer[124]);
    assertEquals((byte) 0, blockBuffer[125]);
    assertEquals((byte) 0, blockBuffer[126]);
    assertEquals((byte) 0, blockBuffer[128]);
    assertEquals((byte) 0, blockBuffer[129]);
    assertEquals((byte) 0, blockBuffer[13]);
    assertEquals((byte) 0, blockBuffer[130]);
    assertEquals((byte) 0, blockBuffer[131]);
    assertEquals((byte) 0, blockBuffer[132]);
    assertEquals((byte) 0, blockBuffer[133]);
    assertEquals((byte) 0, blockBuffer[134]);
    assertEquals((byte) 0, blockBuffer[135]);
    assertEquals((byte) 0, blockBuffer[14]);
    assertEquals((byte) 0, blockBuffer[15]);
    assertEquals((byte) 0, blockBuffer[17]);
    assertEquals((byte) 0, blockBuffer[18]);
    assertEquals((byte) 0, blockBuffer[19]);
    assertEquals((byte) 0, blockBuffer[2]);
    assertEquals((byte) 0, blockBuffer[20]);
    assertEquals((byte) 0, blockBuffer[21]);
    assertEquals((byte) 0, blockBuffer[22]);
    assertEquals((byte) 0, blockBuffer[23]);
    assertEquals((byte) 0, blockBuffer[24]);
    assertEquals((byte) 0, blockBuffer[3]);
    assertEquals((byte) 0, blockBuffer[4]);
    assertEquals((byte) 0, blockBuffer[5]);
    assertEquals((byte) 0, blockBuffer[6]);
    assertEquals((byte) 0, blockBuffer[7]);
    assertEquals((byte) 0, blockBuffer[8]);
    assertEquals((byte) 0, blockBuffer[9]);
    assertEquals((byte) 0, blockBuffer[Float.MAX_EXPONENT]);
    assertEquals((byte) 0, blockBuffer[Short.SIZE]);
    assertEquals(136, actualKeccak256.getInternalBlockLength());
    assertEquals(136, blockBuffer.length);
    assertEquals(Integer.SIZE, actualKeccak256.getDigestLength());
  }
}
