package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Deque;
import java.util.LinkedList;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.capsule.IncrementalMerkleTreeCapsule;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.ShieldContract;

public class IncrementalMerkleTreeContainerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link IncrementalMerkleTreeContainer.EmptyMerkleRoots#getEmptyMerkleRootsInstance()}
   *   <li>
   * {@link IncrementalMerkleTreeContainer.EmptyMerkleRoots#setEmptyMerkleRootsInstance(IncrementalMerkleTreeContainer.EmptyMerkleRoots)}
   * </ul>
   */
  @Test
  public void testEmptyMerkleRootsGettersAndSetters() {
    // Arrange and Act
    IncrementalMerkleTreeContainer.EmptyMerkleRoots actualEmptyMerkleRootsInstance = IncrementalMerkleTreeContainer.EmptyMerkleRoots
        .getEmptyMerkleRootsInstance();
    IncrementalMerkleTreeContainer.EmptyMerkleRoots actualEmptyMerkleRootsInstance2 = actualEmptyMerkleRootsInstance
        .getEmptyMerkleRootsInstance();
    IncrementalMerkleTreeContainer.EmptyMerkleRoots emptyMerkleRootsInstance = IncrementalMerkleTreeContainer.EmptyMerkleRoots
        .getEmptyMerkleRootsInstance();
    actualEmptyMerkleRootsInstance.setEmptyMerkleRootsInstance(emptyMerkleRootsInstance);

    // Assert
    assertSame(emptyMerkleRootsInstance, actualEmptyMerkleRootsInstance2);
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeContainer.PathFiller#next(int)}
   */
  @Test
  public void testPathFillerNext() {
    // Arrange
    LinkedList<ShieldContract.PedersenHash> queue = new LinkedList<>();
    ShieldContract.PedersenHash defaultInstance = ShieldContract.PedersenHash.getDefaultInstance();
    queue.add(defaultInstance);

    // Act and Assert
    assertSame(defaultInstance, (new IncrementalMerkleTreeContainer.PathFiller(queue)).next(2));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#wfcheck()}
   */
  @Test
  public void testWfcheck() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> (new IncrementalMerkleTreeContainer(treeCapsule)).wfcheck());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#last()}
   */
  @Test
  public void testLast() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class,
        () -> (new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())).last());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#last()}
   */
  @Test
  public void testLast2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> incrementalMerkleTreeContainer.last());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#last()}
   */
  @Test
  public void testLast3() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> (new IncrementalMerkleTreeContainer(treeCapsule)).last());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#size()}
   */
  @Test
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())).size());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#size()}
   */
  @Test
  public void testSize2() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, (new IncrementalMerkleTreeContainer(treeCapsule)).size());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#size()}
   */
  @Test
  public void testSize3() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, (new IncrementalMerkleTreeContainer(treeCapsule)).size());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#size()}
   */
  @Test
  public void testSize4() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, (new IncrementalMerkleTreeContainer(treeCapsule)).size());
  }

  /**
   * Method under test:
   * {@link IncrementalMerkleTreeContainer#append(ShieldContract.PedersenHash)}
   */
  @Test
  public void testAppend() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    doNothing().when(treeCapsule).setLeft(Mockito.<ShieldContract.PedersenHash>any());
    when(treeCapsule.getLeft()).thenReturn(ShieldContract.PedersenHash.getDefaultInstance());
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(treeCapsule);

    // Act
    incrementalMerkleTreeContainer.append(ShieldContract.PedersenHash.getDefaultInstance());

    // Assert that nothing has changed
    verify(treeCapsule, atLeast(1)).getLeft();
    verify(treeCapsule).setLeft(isA(ShieldContract.PedersenHash.class));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#isComplete()}
   */
  @Test
  public void testIsComplete() {
    // Arrange, Act and Assert
    assertFalse((new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())).isComplete());
    assertFalse((new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())).isComplete(1L));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#isComplete()}
   */
  @Test
  public void testIsComplete2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertFalse(incrementalMerkleTreeContainer.isComplete());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#isComplete(long)}
   */
  @Test
  public void testIsComplete3() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertFalse(incrementalMerkleTreeContainer.isComplete(1L));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#nextDepth(int)}
   */
  @Test
  public void testNextDepth() {
    // Arrange, Act and Assert
    assertEquals(0, (new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())).nextDepth(1));
    assertEquals(0, (new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())).nextDepth(0));
    assertEquals(-2, (new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())).nextDepth(-1));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#nextDepth(int)}
   */
  @Test
  public void testNextDepth2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, incrementalMerkleTreeContainer.nextDepth(1));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#nextDepth(int)}
   */
  @Test
  public void testNextDepth3() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, (new IncrementalMerkleTreeContainer(treeCapsule)).nextDepth(1));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#nextDepth(int)}
   */
  @Test
  public void testNextDepth4() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(-2, (new IncrementalMerkleTreeContainer(treeCapsule)).nextDepth(-1));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#path()}
   */
  @Test
  public void testPath() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class,
        () -> (new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())).path());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#path()}
   */
  @Test
  public void testPath2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> incrementalMerkleTreeContainer.path());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#path(Deque)}
   */
  @Test
  public void testPath3() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> incrementalMerkleTreeContainer.path(new LinkedList<>()));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#path(Deque)}
   */
  @Test
  public void testPath4() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> incrementalMerkleTreeContainer.path(new LinkedList<>()));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#path(Deque)}
   */
  @Test
  public void testPath5() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());

    LinkedList<ShieldContract.PedersenHash> fillerHashes = new LinkedList<>();
    fillerHashes.add(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> incrementalMerkleTreeContainer.path(fillerHashes));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#path(Deque)}
   */
  @Test
  public void testPath6() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());

    LinkedList<ShieldContract.PedersenHash> fillerHashes = new LinkedList<>();
    fillerHashes.add(ShieldContract.PedersenHash.getDefaultInstance());
    fillerHashes.add(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> incrementalMerkleTreeContainer.path(fillerHashes));
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#getMerkleTreeKey()}
   */
  @Test
  public void testGetMerkleTreeKey() throws ZksnarkException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        (new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())).getMerkleTreeKey());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#getMerkleTreeKey()}
   */
  @Test
  public void testGetMerkleTreeKey2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        (new IncrementalMerkleTreeContainer(treeCapsule)).getMerkleTreeKey());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#getMerkleTreeKey()}
   */
  @Test
  public void testGetMerkleTreeKey3() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        (new IncrementalMerkleTreeContainer(treeCapsule)).getMerkleTreeKey());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#getMerkleTreeKey()}
   */
  @Test
  public void testGetMerkleTreeKey4() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        (new IncrementalMerkleTreeContainer(treeCapsule)).getMerkleTreeKey());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#getRootArray()}
   */
  @Test
  public void testGetRootArray() throws ZksnarkException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        (new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())).getRootArray());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#getRootArray()}
   */
  @Test
  public void testGetRootArray2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        (new IncrementalMerkleTreeContainer(treeCapsule)).getRootArray());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#getRootArray()}
   */
  @Test
  public void testGetRootArray3() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        (new IncrementalMerkleTreeContainer(treeCapsule)).getRootArray());
  }

  /**
   * Method under test: {@link IncrementalMerkleTreeContainer#getRootArray()}
   */
  @Test
  public void testGetRootArray4() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        (new IncrementalMerkleTreeContainer(treeCapsule)).getRootArray());
  }
}
