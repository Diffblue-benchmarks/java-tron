package org.tron.common.crypto.cryptohash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Keccak512DiffblueTest {
  /**
   * Method under test: {@link Keccak512#copy()}
   */
  @Test
  public void testCopy() {
    // Arrange and Act
    Digest actualCopyResult = (new Keccak512()).copy();

    // Assert
    assertTrue(actualCopyResult instanceof Keccak512);
    assertEquals("tron-keccak-512", ((Keccak512) actualCopyResult).getAlgorithm());
    assertNull(((Keccak512) actualCopyResult).getProvider());
    assertEquals(0, ((Keccak512) actualCopyResult).flush());
    assertEquals(0L, ((Keccak512) actualCopyResult).getBlockCount());
    byte[] blockBuffer = ((Keccak512) actualCopyResult).getBlockBuffer();
    assertEquals((byte) 0, blockBuffer[0]);
    assertEquals((byte) 0, blockBuffer[1]);
    assertEquals((byte) 0, blockBuffer[10]);
    assertEquals((byte) 0, blockBuffer[11]);
    assertEquals((byte) 0, blockBuffer[12]);
    assertEquals((byte) 0, blockBuffer[13]);
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
    assertEquals((byte) 0, blockBuffer[47]);
    assertEquals((byte) 0, blockBuffer[48]);
    assertEquals((byte) 0, blockBuffer[49]);
    assertEquals((byte) 0, blockBuffer[5]);
    assertEquals((byte) 0, blockBuffer[50]);
    assertEquals((byte) 0, blockBuffer[51]);
    assertEquals((byte) 0, blockBuffer[52]);
    assertEquals((byte) 0, blockBuffer[53]);
    assertEquals((byte) 0, blockBuffer[54]);
    assertEquals((byte) 0, blockBuffer[55]);
    assertEquals((byte) 0, blockBuffer[56]);
    assertEquals((byte) 0, blockBuffer[57]);
    assertEquals((byte) 0, blockBuffer[58]);
    assertEquals((byte) 0, blockBuffer[59]);
    assertEquals((byte) 0, blockBuffer[6]);
    assertEquals((byte) 0, blockBuffer[60]);
    assertEquals((byte) 0, blockBuffer[61]);
    assertEquals((byte) 0, blockBuffer[62]);
    assertEquals((byte) 0, blockBuffer[63]);
    assertEquals((byte) 0, blockBuffer[65]);
    assertEquals((byte) 0, blockBuffer[66]);
    assertEquals((byte) 0, blockBuffer[67]);
    assertEquals((byte) 0, blockBuffer[68]);
    assertEquals((byte) 0, blockBuffer[69]);
    assertEquals((byte) 0, blockBuffer[7]);
    assertEquals((byte) 0, blockBuffer[70]);
    assertEquals((byte) 0, blockBuffer[71]);
    assertEquals((byte) 0, blockBuffer[8]);
    assertEquals((byte) 0, blockBuffer[9]);
    assertEquals((byte) 0, blockBuffer[Double.SIZE]);
    assertEquals((byte) 0, blockBuffer[Short.SIZE]);
    assertEquals(72, ((Keccak512) actualCopyResult).getInternalBlockLength());
    assertEquals(72, blockBuffer.length);
    assertEquals(Double.SIZE, actualCopyResult.getDigestLength());
  }

  /**
   * Method under test: {@link Keccak512#engineGetDigestLength()}
   */
  @Test
  public void testEngineGetDigestLength() {
    // Arrange, Act and Assert
    assertEquals(Double.SIZE, (new Keccak512()).engineGetDigestLength());
  }

  /**
   * Method under test: {@link Keccak512#engineDigest()}
   */
  @Test
  public void testEngineDigest() {
    // Arrange, Act and Assert
    assertNull((new Keccak512()).engineDigest());
  }

  /**
   * Method under test: default or parameterless constructor of {@link Keccak512}
   */
  @Test
  public void testNewKeccak512() {
    // Arrange and Act
    Keccak512 actualKeccak512 = new Keccak512();

    // Assert
    assertEquals("tron-keccak-512", actualKeccak512.getAlgorithm());
    assertNull(actualKeccak512.getProvider());
    assertEquals(0, actualKeccak512.flush());
    assertEquals(0L, actualKeccak512.getBlockCount());
    byte[] blockBuffer = actualKeccak512.getBlockBuffer();
    assertEquals((byte) 0, blockBuffer[0]);
    assertEquals((byte) 0, blockBuffer[1]);
    assertEquals((byte) 0, blockBuffer[10]);
    assertEquals((byte) 0, blockBuffer[11]);
    assertEquals((byte) 0, blockBuffer[12]);
    assertEquals((byte) 0, blockBuffer[13]);
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
    assertEquals((byte) 0, blockBuffer[47]);
    assertEquals((byte) 0, blockBuffer[48]);
    assertEquals((byte) 0, blockBuffer[49]);
    assertEquals((byte) 0, blockBuffer[5]);
    assertEquals((byte) 0, blockBuffer[50]);
    assertEquals((byte) 0, blockBuffer[51]);
    assertEquals((byte) 0, blockBuffer[52]);
    assertEquals((byte) 0, blockBuffer[53]);
    assertEquals((byte) 0, blockBuffer[54]);
    assertEquals((byte) 0, blockBuffer[55]);
    assertEquals((byte) 0, blockBuffer[56]);
    assertEquals((byte) 0, blockBuffer[57]);
    assertEquals((byte) 0, blockBuffer[58]);
    assertEquals((byte) 0, blockBuffer[59]);
    assertEquals((byte) 0, blockBuffer[6]);
    assertEquals((byte) 0, blockBuffer[60]);
    assertEquals((byte) 0, blockBuffer[61]);
    assertEquals((byte) 0, blockBuffer[62]);
    assertEquals((byte) 0, blockBuffer[63]);
    assertEquals((byte) 0, blockBuffer[65]);
    assertEquals((byte) 0, blockBuffer[66]);
    assertEquals((byte) 0, blockBuffer[67]);
    assertEquals((byte) 0, blockBuffer[68]);
    assertEquals((byte) 0, blockBuffer[69]);
    assertEquals((byte) 0, blockBuffer[7]);
    assertEquals((byte) 0, blockBuffer[70]);
    assertEquals((byte) 0, blockBuffer[71]);
    assertEquals((byte) 0, blockBuffer[8]);
    assertEquals((byte) 0, blockBuffer[9]);
    assertEquals((byte) 0, blockBuffer[Double.SIZE]);
    assertEquals((byte) 0, blockBuffer[Short.SIZE]);
    assertEquals(72, actualKeccak512.getInternalBlockLength());
    assertEquals(72, blockBuffer.length);
    assertEquals(Double.SIZE, actualKeccak512.getDigestLength());
  }
}
