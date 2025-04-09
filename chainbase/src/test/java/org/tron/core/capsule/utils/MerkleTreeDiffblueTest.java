package org.tron.core.capsule.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.capsule.utils.MerkleTree.Leaf;

public class MerkleTreeDiffblueTest {
  /**
   * Test {@link MerkleTree#createTree(List)}.
   * <ul>
   *   <li>Given {@link BlockId#BlockId()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link BlockId#BlockId()}.</li>
   *   <li>Then return HashList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerkleTree#createTree(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerkleTree MerkleTree.createTree(List)"})
  public void testCreateTree_givenBlockId_whenArrayListAddBlockId_thenReturnHashListSizeIsTwo() {
    // Arrange
    MerkleTree instance = MerkleTree.getInstance();

    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    BlockId blockId = new BlockId();
    hashList.add(blockId);
    BlockId blockId2 = new BlockId();
    hashList.add(blockId2);

    // Act
    MerkleTree actualCreateTreeResult = instance.createTree(hashList);

    // Assert
    List<Sha256Hash> hashList2 = actualCreateTreeResult.getHashList();
    assertEquals(2, hashList2.size());
    Sha256Hash getResult = hashList2.get(0);
    assertTrue(getResult instanceof BlockId);
    List<Leaf> leaves = actualCreateTreeResult.getLeaves();
    assertEquals(3, leaves.size());
    assertSame(blockId, getResult);
    assertSame(blockId2, hashList2.get(1));
    Leaf expectedRight = leaves.get(0);
    Leaf root = actualCreateTreeResult.getRoot();
    assertSame(expectedRight, root.getRight());
    Leaf expectedLeft = leaves.get(1);
    assertSame(expectedLeft, root.getLeft());
    assertSame(root, leaves.get(2));
  }

  /**
   * Test {@link MerkleTree#createTree(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return Leaves size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerkleTree#createTree(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerkleTree MerkleTree.createTree(List)"})
  public void testCreateTree_givenNull_whenArrayListAddNull_thenReturnLeavesSizeIsTwo() {
    // Arrange
    MerkleTree instance = MerkleTree.getInstance();

    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(null);

    // Act
    MerkleTree actualCreateTreeResult = instance.createTree(hashList);

    // Assert
    List<Leaf> leaves = actualCreateTreeResult.getLeaves();
    assertEquals(2, leaves.size());
    Leaf getResult = leaves.get(0);
    assertNull(getResult.getHash());
    Leaf root = actualCreateTreeResult.getRoot();
    assertNull(root.getHash());
    assertNull(root.getRight());
    assertSame(getResult, root.getLeft());
    assertSame(root, leaves.get(1));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MerkleTree}
   *   <li>{@link MerkleTree#getHashList()}
   *   <li>{@link MerkleTree#getLeaves()}
   *   <li>{@link MerkleTree#getRoot()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MerkleTree.<init>()", "List MerkleTree.getHashList()", "List MerkleTree.getLeaves()",
      "Leaf MerkleTree.getRoot()"})
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Leaf#Leaf(MerkleTree)}
   *   <li>{@link Leaf#getHash()}
   *   <li>{@link Leaf#getLeft()}
   *   <li>{@link Leaf#getRight()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Leaf.<init>(MerkleTree)", "Sha256Hash Leaf.getHash()", "Leaf Leaf.getLeft()",
      "Leaf Leaf.getRight()"})
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
