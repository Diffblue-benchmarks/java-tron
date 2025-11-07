package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.ByteString;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MerkleRootDiffblueTest {
  /**
   * Method under test: {@link MerkleRoot#root(List)}
   */
  @Test
  public void testRoot() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();

    // Act
    Sha256Hash actualRootResult = MerkleRoot.root(hashList);

    // Assert
    BigInteger toBigIntegerResult = actualRootResult.toBigInteger();
    assertEquals("0", toBigIntegerResult.toString());
    ByteString byteString = actualRootResult.getByteString();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        byteString.toStringUtf8());
    assertEquals(-1, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.signum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertFalse(byteString.isEmpty());
    assertTrue(hashList.isEmpty());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[]{0}, toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualRootResult.getBytes());
  }

  /**
   * Method under test: {@link MerkleRoot#root(List)}
   */
  @Test
  public void testRoot2() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(Sha256Hash.ZERO_HASH);

    // Act
    Sha256Hash actualRootResult = MerkleRoot.root(hashList);

    // Assert
    assertEquals(1, hashList.size());
    BigInteger toBigIntegerResult = actualRootResult.toBigInteger();
    assertEquals("0", toBigIntegerResult.toString());
    ByteString byteString = actualRootResult.getByteString();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        byteString.toStringUtf8());
    assertEquals(-1, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.signum());
    ByteString.ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertFalse(byteString.isEmpty());
    assertTrue(iteratorResult.hasNext());
    Sha256Hash expectedGetResult = actualRootResult.ZERO_HASH;
    assertSame(expectedGetResult, hashList.get(0));
    assertArrayEquals(new byte[]{0}, toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualRootResult.getBytes());
  }
}
