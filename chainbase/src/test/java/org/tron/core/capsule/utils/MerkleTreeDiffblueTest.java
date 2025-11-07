package org.tron.core.capsule.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.common.utils.Sha256Hash;

public class MerkleTreeDiffblueTest {
  /**
   * Method under test: {@link MerkleTree#getInstance()}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    MerkleTree actualInstance = MerkleTree.getInstance();

    // Assert
    List<Sha256Hash> hashList = actualInstance.getHashList();
    assertEquals(1, hashList.size());
    assertNull(hashList.get(0));
    List<MerkleTree.Leaf> leaves = actualInstance.getLeaves();
    assertEquals(2, leaves.size());
    MerkleTree.Leaf getResult = leaves.get(0);
    assertNull(getResult.getHash());
    MerkleTree.Leaf root = actualInstance.getRoot();
    assertNull(root.getHash());
    assertNull(getResult.getLeft());
    assertNull(getResult.getRight());
    assertNull(root.getRight());
    assertSame(getResult, root.getLeft());
    assertSame(root, leaves.get(1));
  }

  /**
   * Method under test: {@link MerkleTree#createTree(List)}
   */
  @Test
  public void testCreateTree() {
    // Arrange
    MerkleTree instance = MerkleTree.getInstance();

    ArrayList<Sha256Hash> hashList = new ArrayList<>();
    hashList.add(null);

    // Act
    MerkleTree actualCreateTreeResult = instance.createTree(hashList);

    // Assert
    assertSame(hashList, instance.getHashList());
    assertSame(instance, actualCreateTreeResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MerkleTree}
   *   <li>{@link MerkleTree#getHashList()}
   *   <li>{@link MerkleTree#getLeaves()}
   *   <li>{@link MerkleTree#getRoot()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MerkleTree actualMerkleTree = new MerkleTree();
    List<Sha256Hash> actualHashList = actualMerkleTree.getHashList();
    List<MerkleTree.Leaf> actualLeaves = actualMerkleTree.getLeaves();

    // Assert
    assertNull(actualHashList);
    assertNull(actualLeaves);
    assertNull(actualMerkleTree.getRoot());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MerkleTree.Leaf#Leaf(MerkleTree)}
   *   <li>{@link MerkleTree.Leaf#getHash()}
   *   <li>{@link MerkleTree.Leaf#getLeft()}
   *   <li>{@link MerkleTree.Leaf#getRight()}
   * </ul>
   */
  @Test
  public void testLeafGettersAndSetters() {
    // Arrange and Act
    MerkleTree.Leaf actualLeaf = MerkleTree.getInstance().new Leaf();
    Sha256Hash actualHash = actualLeaf.getHash();
    MerkleTree.Leaf actualLeft = actualLeaf.getLeft();

    // Assert
    assertNull(actualHash);
    assertNull(actualLeft);
    assertNull(actualLeaf.getRight());
  }
}
