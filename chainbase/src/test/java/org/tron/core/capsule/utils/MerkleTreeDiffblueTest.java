package org.tron.core.capsule.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.utils.MerkleTree.Leaf;

public class MerkleTreeDiffblueTest {
  /**
   * Test {@link MerkleTree#createTree(List)}.
   *
   * <p>Method under test: {@link MerkleTree#createTree(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MerkleTree MerkleTree.createTree(List)"})
  public void testCreateTree() {
    // Arrange
    MerkleTree instance = MerkleTree.getInstance();

    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);

    // Act
    MerkleTree actualCreateTreeResult = instance.createTree(hashList);

    // Assert
    Leaf root = actualCreateTreeResult.getRoot();
    Sha256Hash hash = root.getHash();
    BigInteger toBigIntegerResult = hash.toBigInteger();
    assertEquals(
        "111109925611824843164212799849330761292948257037696933205019304127221294824267",
        toBigIntegerResult.toString());
    ByteString byteString = hash.getByteString();
    assertEquals("���B�j 0'��n�\t��C\u0000=# ����1�'Y�K", byteString.toStringUtf8());
    List<Sha256Hash> hashList2 = actualCreateTreeResult.getHashList();
    assertEquals(2, hashList2.size());
    List<Leaf> leaves = actualCreateTreeResult.getLeaves();
    assertEquals(3, leaves.size());
    assertTrue(byteString.iterator().hasNext());
    assertSame(leaves.get(0), root.getRight());
    assertSame(leaves.get(1), root.getLeft());
    assertSame(root, leaves.get(2));
    assertArrayEquals(new byte[] {0}, hashList2.get(0).toBigInteger().toByteArray());
    assertArrayEquals(
        new byte[] {
          -11, -91, -3, 'B', -47, 'j', ' ', '0', '\'', -104, -17, 'n', -45, '\t', -105, -101, 'C',
          0, '=', '#', ' ', -39, -16, -24, -22, -104, '1', -87, '\'', 'Y', -5, 'K'
        },
        hash.getBytes());
    assertArrayEquals(
        new byte[] {
          0, -11, -91, -3, 'B', -47, 'j', ' ', '0', '\'', -104, -17, 'n', -45, '\t', -105, -101,
          'C', 0, '=', '#', ' ', -39, -16, -24, -22, -104, '1', -87, '\'', 'Y', -5, 'K'
        },
        toBigIntegerResult.toByteArray());
  }

  /**
   * Test {@link MerkleTree#createTree(List)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>Then return Leaves size is eleven.
   * </ul>
   *
   * <p>Method under test: {@link MerkleTree#createTree(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MerkleTree MerkleTree.createTree(List)"})
  public void testCreateTree_givenInstance_thenReturnLeavesSizeIsEleven() {
    // Arrange
    MerkleTree instance = MerkleTree.getInstance();

    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);

    // Act
    MerkleTree actualCreateTreeResult = instance.createTree(hashList);

    // Assert
    List<Leaf> leaves = actualCreateTreeResult.getLeaves();
    assertEquals(11, leaves.size());
    Leaf getResult = leaves.get(9);
    assertNull(getResult.getRight());
    List<Sha256Hash> hashList2 = actualCreateTreeResult.getHashList();
    assertEquals(5, hashList2.size());
    Sha256Hash getResult2 = hashList2.get(0);
    assertSame(getResult2, hashList2.get(3));
    assertSame(getResult2, hashList2.get(4));
    assertSame(getResult2, getResult.getHash());
    Leaf expectedLeft = leaves.get(2);
    Leaf getResult3 = leaves.get(8);
    assertSame(expectedLeft, getResult3.getLeft());
    Leaf root = actualCreateTreeResult.getRoot();
    assertSame(getResult3, root.getLeft());
    assertSame(getResult, root.getRight());
    assertSame(root, leaves.get(10));
    assertArrayEquals(
        new byte[] {
          '(', -70, 24, '4', -93, -89, -74, 'W', 'F', '\f', -25, -97, -93, -95, -39, '\t', -85,
          -120, '(', -3, 'U', 'v', 'Y', -44, -48, 'U', 'J', -101, -37, -64, -20, '0'
        },
        root.getHash().getBytes());
  }

  /**
   * Test {@link MerkleTree#createTree(List)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then return Leaves size is six.
   * </ul>
   *
   * <p>Method under test: {@link MerkleTree#createTree(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MerkleTree MerkleTree.createTree(List)"})
  public void testCreateTree_givenInstance_whenArrayListAddZero_hash_thenReturnLeavesSizeIsSix() {
    // Arrange
    MerkleTree instance = MerkleTree.getInstance();

    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);
    hashList.add(Sha256Hash.ZERO_HASH);

    // Act
    MerkleTree actualCreateTreeResult = instance.createTree(hashList);

    // Assert
    List<Leaf> leaves = actualCreateTreeResult.getLeaves();
    assertEquals(6, leaves.size());
    Leaf getResult = leaves.get(3);
    assertNull(getResult.getLeft());
    assertNull(getResult.getRight());
    Leaf getResult2 = leaves.get(4);
    assertNull(getResult2.getRight());
    List<Sha256Hash> hashList2 = actualCreateTreeResult.getHashList();
    assertEquals(3, hashList2.size());
    Sha256Hash getResult3 = hashList2.get(0);
    assertSame(getResult3, getResult.getHash());
    assertSame(getResult3, getResult2.getHash());
    Leaf root = actualCreateTreeResult.getRoot();
    assertSame(leaves.get(2), root.getLeft());
    assertSame(getResult, getResult2.getLeft());
    assertSame(getResult2, root.getRight());
    assertSame(root, leaves.get(5));
    assertArrayEquals(
        new byte[] {
          'z', 5, 1, -11, -107, '{', -33, -100, -77, -88, -1, 'I', 'f', -16, '"', 'e', -7, 'h', 'e',
          -117, 'z', -100, 'b', 'd', ',', -70, 17, 'e', -24, 'f', 'B', -11
        },
        root.getHash().getBytes());
  }

  /**
   * Test {@link MerkleTree#createTree(List)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Sha256Hash#ZERO_HASH}.
   *   <li>Then return Root Right is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleTree#createTree(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MerkleTree MerkleTree.createTree(List)"})
  public void testCreateTree_givenInstance_whenArrayListAddZero_hash_thenReturnRootRightIsNull() {
    // Arrange
    MerkleTree instance = MerkleTree.getInstance();

    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(Sha256Hash.ZERO_HASH);

    // Act
    MerkleTree actualCreateTreeResult = instance.createTree(hashList);

    // Assert
    Leaf root = actualCreateTreeResult.getRoot();
    assertNull(root.getRight());
    List<Sha256Hash> hashList2 = actualCreateTreeResult.getHashList();
    assertEquals(1, hashList2.size());
    List<Leaf> leaves = actualCreateTreeResult.getLeaves();
    assertEquals(2, leaves.size());
    Sha256Hash getResult = hashList2.get(0);
    assertSame(getResult, root.getHash());
    assertSame(leaves.get(0), root.getLeft());
    assertSame(root, leaves.get(1));
    assertArrayEquals(new byte[] {0}, getResult.toBigInteger().toByteArray());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MerkleTree}
   *   <li>{@link MerkleTree#getHashList()}
   *   <li>{@link MerkleTree#getLeaves()}
   *   <li>{@link MerkleTree#getRoot()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MerkleTree.<init>()",
    "List MerkleTree.getHashList()",
    "List MerkleTree.getLeaves()",
    "Leaf MerkleTree.getRoot()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MerkleTree actualMerkleTree = new MerkleTree();
    List<Sha256Hash> actualHashList = actualMerkleTree.getHashList();
    List<Leaf> actualLeaves = actualMerkleTree.getLeaves();

    // Assert
    assertNull(actualHashList);
    assertNull(actualLeaves);
    assertNull(actualMerkleTree.getRoot());
  }

  /**
   * Test Leaf getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Leaf#Leaf(MerkleTree)}
   *   <li>{@link Leaf#getHash()}
   *   <li>{@link Leaf#getLeft()}
   *   <li>{@link Leaf#getRight()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Leaf.<init>(MerkleTree)",
    "Sha256Hash Leaf.getHash()",
    "Leaf Leaf.getLeft()",
    "Leaf Leaf.getRight()"
  })
  public void testLeafGettersAndSetters() {
    // Arrange and Act
    Leaf actualLeaf = MerkleTree.getInstance().new Leaf();
    Sha256Hash actualHash = actualLeaf.getHash();
    Leaf actualLeft = actualLeaf.getLeft();

    // Assert
    assertNull(actualHash);
    assertNull(actualLeft);
    assertNull(actualLeaf.getRight());
  }
}
