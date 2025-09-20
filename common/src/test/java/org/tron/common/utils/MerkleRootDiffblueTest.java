package org.tron.common.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MerkleRootDiffblueTest {
  /**
   * Test {@link MerkleRoot#root(List)}.
   *
   * <p>Method under test: {@link MerkleRoot#root(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash MerkleRoot.root(List)"})
  public void testRoot() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);

    // Act
    Sha256Hash actualRootResult = MerkleRoot.root(hashList);

    // Assert
    ByteString byteString = actualRootResult.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    BigInteger toBigIntegerResult = actualRootResult.toBigInteger();
    assertEquals(
        "111109925611824843164212799849330761292948257037696933205019304127221294824267",
        toBigIntegerResult.toString());
    assertEquals("���B�j 0'��n�\t��C\u0000=# ����1�'Y�K", byteString.toStringUtf8());
    assertEquals((byte) -11, nextResult.byteValue());
    assertEquals((byte) -3, nextResult3.byteValue());
    assertEquals((byte) -91, nextResult2.byteValue());
    assertTrue(actualHasNextResult);
    assertArrayEquals(
        new byte[] {
          -11, -91, -3, 'B', -47, 'j', ' ', '0', '\'', -104, -17, 'n', -45, '\t', -105, -101, 'C',
          0, '=', '#', ' ', -39, -16, -24, -22, -104, '1', -87, '\'', 'Y', -5, 'K'
        },
        actualRootResult.getBytes());
    assertArrayEquals(
        new byte[] {
          0, -11, -91, -3, 'B', -47, 'j', ' ', '0', '\'', -104, -17, 'n', -45, '\t', -105, -101,
          'C', 0, '=', '#', ' ', -39, -16, -24, -22, -104, '1', -87, '\'', 'Y', -5, 'K'
        },
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link MerkleRoot#root(List)}.
   *
   * <p>Method under test: {@link MerkleRoot#root(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash MerkleRoot.root(List)"})
  public void testRoot2() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);

    // Act
    Sha256Hash actualRootResult = MerkleRoot.root(hashList);

    // Assert
    ByteString byteString = actualRootResult.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    BigInteger toBigIntegerResult = actualRootResult.toBigInteger();
    assertEquals(
        "55191015285158161600233643484143974962737278466358095552940783730116826383093",
        toBigIntegerResult.toString());
    assertEquals("z\u0005\u0001��{ߜ���If�\"e�he�z�bd,�\u0011e�fB�", byteString.toStringUtf8());
    assertEquals((byte) 1, nextResult3.byteValue());
    assertEquals((byte) 5, nextResult2.byteValue());
    assertTrue(actualHasNextResult);
    assertEquals('z', nextResult.byteValue());
    assertArrayEquals(
        new byte[] {
          'z', 5, 1, -11, -107, '{', -33, -100, -77, -88, -1, 'I', 'f', -16, '"', 'e', -7, 'h', 'e',
          -117, 'z', -100, 'b', 'd', ',', -70, 17, 'e', -24, 'f', 'B', -11
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          'z', 5, 1, -11, -107, '{', -33, -100, -77, -88, -1, 'I', 'f', -16, '"', 'e', -7, 'h', 'e',
          -117, 'z', -100, 'b', 'd', ',', -70, 17, 'e', -24, 'f', 'B', -11
        },
        actualRootResult.getBytes());
  }

  /**
   * Test {@link MerkleRoot#root(List)}.
   *
   * <ul>
   *   <li>Given {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then return toBigInteger toString is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleRoot#root(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash MerkleRoot.root(List)"})
  public void testRoot_givenZero_hash_thenReturnToBigIntegerToStringIs0() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(Sha256Hash.ZERO_HASH);

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
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[] {0}, toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualRootResult.getBytes());
  }

  /**
   * Test {@link MerkleRoot#root(List)}.
   *
   * <ul>
   *   <li>Given {@link Sha256Hash#ZERO_HASH}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then {@link ArrayList#ArrayList()} size is five.
   * </ul>
   *
   * <p>Method under test: {@link MerkleRoot#root(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash MerkleRoot.root(List)"})
  public void testRoot_givenZero_hash_whenArrayListAddZero_hash_thenArrayListSizeIsFive() {
    // Arrange
    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);

    // Act
    Sha256Hash actualRootResult = MerkleRoot.root(hashList);

    // Assert
    ByteString byteString = actualRootResult.getByteString();
    ByteIterator iteratorResult = byteString.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    assertEquals(5, hashList.size());
    assertEquals("(�\u00184���WF\f矣��\t��(�UvY��UJ����0", byteString.toStringUtf8());
    BigInteger toBigIntegerResult = actualRootResult.toBigInteger();
    assertEquals(
        "18421314558443881053392146436562336482445031783023775370411934591306128485424",
        toBigIntegerResult.toString());
    assertEquals((byte) -70, nextResult2.byteValue());
    assertEquals((byte) 24, nextResult3.byteValue());
    assertEquals(4, toBigIntegerResult.getLowestSetBit());
    assertTrue(actualHasNextResult);
    assertEquals('(', nextResult.byteValue());
    Sha256Hash sha256Hash = Sha256Hash.ZERO_HASH;
    assertSame(sha256Hash, hashList.get(3));
    assertSame(sha256Hash, hashList.get(4));
    assertArrayEquals(
        new byte[] {
          '(', -70, 24, '4', -93, -89, -74, 'W', 'F', '\f', -25, -97, -93, -95, -39, '\t', -85,
          -120, '(', -3, 'U', 'v', 'Y', -44, -48, 'U', 'J', -101, -37, -64, -20, '0'
        },
        toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          '(', -70, 24, '4', -93, -89, -74, 'W', 'F', '\f', -25, -97, -93, -95, -39, '\t', -85,
          -120, '(', -3, 'U', 'v', 'Y', -44, -48, 'U', 'J', -101, -37, -64, -20, '0'
        },
        actualRootResult.getBytes());
  }

  /**
   * Test {@link MerkleRoot#root(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return toBigInteger toString is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleRoot#root(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash MerkleRoot.root(List)"})
  public void testRoot_whenArrayList_thenReturnToBigIntegerToStringIs0() {
    // Arrange and Act
    Sha256Hash actualRootResult = MerkleRoot.root(new ArrayList<>());

    // Assert
    BigInteger toBigIntegerResult = actualRootResult.toBigInteger();
    assertEquals("0", toBigIntegerResult.toString());
    ByteString byteString = actualRootResult.getByteString();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        byteString.toStringUtf8());
    assertEquals(-1, toBigIntegerResult.getLowestSetBit());
    assertEquals(0, toBigIntegerResult.signum());
    ByteIterator iteratorResult = byteString.iterator();
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertEquals((byte) 0, iteratorResult.next().byteValue());
    assertTrue(iteratorResult.hasNext());
    assertArrayEquals(new byte[] {0}, toBigIntegerResult.toByteArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualRootResult.getBytes());
  }
}
