package org.tron.common.zksnark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.capsule.IncrementalMerkleTreeCapsule;
import org.tron.core.capsule.IncrementalMerkleVoucherCapsule;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.ShieldContract;

public class IncrementalMerkleVoucherContainerDiffblueTest {
  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#path()}
   */
  @Test
  public void testPath() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = mock(IncrementalMerkleTreeContainer.class);
    ArrayList<List<Boolean>> authenticationPath = new ArrayList<>();
    MerklePath merklePath = new MerklePath(authenticationPath, new ArrayList<>());

    when(incrementalMerkleTreeContainer.path(Mockito.<Deque<ShieldContract.PedersenHash>>any())).thenReturn(merklePath);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule2 = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule2.isEmptyTree()).thenReturn(true);
    when(incrementalMerkleTreeCapsule2.toMerkleTreeContainer())
        .thenReturn(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(incrementalMerkleTreeCapsule2);
    when(voucherCapsule.getTree()).thenReturn(incrementalMerkleTreeCapsule);

    // Act
    MerklePath actualPathResult = (new IncrementalMerkleVoucherContainer(voucherCapsule)).path();

    // Assert
    verify(incrementalMerkleTreeContainer).path(isA(Deque.class));
    verify(incrementalMerkleTreeCapsule2).isEmptyTree();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
    assertSame(merklePath, actualPathResult);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#path()}
   */
  @Test
  public void testPath2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = mock(IncrementalMerkleTreeContainer.class);
    ArrayList<List<Boolean>> authenticationPath = new ArrayList<>();
    MerklePath merklePath = new MerklePath(authenticationPath, new ArrayList<>());

    when(incrementalMerkleTreeContainer.path(Mockito.<Deque<ShieldContract.PedersenHash>>any())).thenReturn(merklePath);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer2 = mock(IncrementalMerkleTreeContainer.class);
    when(incrementalMerkleTreeContainer2.root(anyLong())).thenReturn(ShieldContract.PedersenHash.getDefaultInstance());
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule2 = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule2.isEmptyTree()).thenReturn(false);
    when(incrementalMerkleTreeCapsule2.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer2);
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getCursorDepth()).thenReturn(Long.MAX_VALUE);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(incrementalMerkleTreeCapsule2);
    when(voucherCapsule.getTree()).thenReturn(incrementalMerkleTreeCapsule);

    // Act
    MerklePath actualPathResult = (new IncrementalMerkleVoucherContainer(voucherCapsule)).path();

    // Assert
    verify(incrementalMerkleTreeContainer).path(isA(Deque.class));
    verify(incrementalMerkleTreeContainer2).root(eq(9223372036854775807L));
    verify(incrementalMerkleTreeCapsule2).isEmptyTree();
    verify(incrementalMerkleTreeCapsule2).toMerkleTreeContainer();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule, atLeast(1)).getCursor();
    verify(voucherCapsule).getCursorDepth();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
    assertSame(merklePath, actualPathResult);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#element()}
   */
  @Test
  public void testElement() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = mock(IncrementalMerkleTreeContainer.class);
    ShieldContract.PedersenHash defaultInstance = ShieldContract.PedersenHash.getDefaultInstance();
    when(incrementalMerkleTreeContainer.last()).thenReturn(defaultInstance);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getTree()).thenReturn(incrementalMerkleTreeCapsule);

    // Act
    ShieldContract.PedersenHash actualElementResult = (new IncrementalMerkleVoucherContainer(voucherCapsule)).element();

    // Assert
    verify(incrementalMerkleTreeContainer).last();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule).getTree();
    assertSame(defaultInstance, actualElementResult);
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#position()}
   */
  @Test
  public void testPosition() {
    // Arrange, Act and Assert
    assertEquals(-1L,
        (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())))
            .position());
    assertEquals(-1L, (new IncrementalMerkleVoucherContainer(new IncrementalMerkleVoucherCapsule())).position());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#position()}
   */
  @Test
  public void testPosition2() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(-1L,
        (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(treeCapsule))).position());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#position()}
   */
  @Test
  public void testPosition3() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(-1L,
        (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(treeCapsule))).position());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#position()}
   */
  @Test
  public void testPosition4() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(-1L,
        (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(treeCapsule))).position());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#position()}
   */
  @Test
  public void testPosition5() {
    // Arrange
    IncrementalMerkleVoucherCapsule voucherCapsule = new IncrementalMerkleVoucherCapsule();
    voucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Act and Assert
    assertEquals(-1L, (new IncrementalMerkleVoucherContainer(voucherCapsule)).position());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())))
            .size());
    assertEquals(0, (new IncrementalMerkleVoucherContainer(new IncrementalMerkleVoucherCapsule())).size());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  public void testSize2() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(treeCapsule))).size());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  public void testSize3() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(treeCapsule))).size());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  public void testSize4() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(treeCapsule))).size());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  public void testSize5() {
    // Arrange
    IncrementalMerkleVoucherCapsule voucherCapsule = new IncrementalMerkleVoucherCapsule();
    voucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());

    // Act and Assert
    assertEquals(0, (new IncrementalMerkleVoucherContainer(voucherCapsule)).size());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  public void testSize6() {
    // Arrange
    IncrementalMerkleVoucherCapsule voucherCapsule = new IncrementalMerkleVoucherCapsule();
    voucherCapsule.setOutputPoint(mock(ByteString.class), 1);

    // Act and Assert
    assertEquals(0, (new IncrementalMerkleVoucherContainer(voucherCapsule)).size());
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  public void testPrintSize() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(treeCapsule.getInstance()).thenReturn(ShieldContract.IncrementalMerkleTree.getDefaultInstance());

    // Act
    (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(treeCapsule))).printSize();

    // Assert
    verify(treeCapsule).getInstance();
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  public void testPrintSize2() {
    // Arrange
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(new IncrementalMerkleTreeCapsule());
    when(voucherCapsule.getTree()).thenReturn(new IncrementalMerkleTreeCapsule());

    // Act
    (new IncrementalMerkleVoucherContainer(voucherCapsule)).printSize();

    // Assert
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  public void testPrintSize3() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(incrementalMerkleTreeCapsule);
    when(voucherCapsule.getTree()).thenReturn(new IncrementalMerkleTreeCapsule());

    // Act
    (new IncrementalMerkleVoucherContainer(voucherCapsule)).printSize();

    // Assert
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  public void testPrintSize4() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(treeCapsule.getParents()).thenReturn(new ArrayList<>());
    when(treeCapsule.getRight()).thenReturn(ShieldContract.PedersenHash.getDefaultInstance());
    when(treeCapsule.getLeft()).thenReturn(ShieldContract.PedersenHash.getDefaultInstance());
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(new IncrementalMerkleTreeContainer(treeCapsule));
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(incrementalMerkleTreeCapsule);
    when(voucherCapsule.getTree()).thenReturn(new IncrementalMerkleTreeCapsule());

    // Act
    (new IncrementalMerkleVoucherContainer(voucherCapsule)).printSize();

    // Assert
    verify(treeCapsule).getLeft();
    verify(treeCapsule).getParents();
    verify(treeCapsule).getRight();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  public void testPrintSize5() {
    // Arrange
    ArrayList<ShieldContract.PedersenHash> pedersenHashList = new ArrayList<>();
    pedersenHashList.add(ShieldContract.PedersenHash.getDefaultInstance());
    IncrementalMerkleTreeCapsule treeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(treeCapsule.getParents()).thenReturn(pedersenHashList);
    when(treeCapsule.getRight()).thenReturn(ShieldContract.PedersenHash.getDefaultInstance());
    when(treeCapsule.getLeft()).thenReturn(ShieldContract.PedersenHash.getDefaultInstance());
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(new IncrementalMerkleTreeContainer(treeCapsule));
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(incrementalMerkleTreeCapsule);
    when(voucherCapsule.getTree()).thenReturn(new IncrementalMerkleTreeCapsule());

    // Act
    (new IncrementalMerkleVoucherContainer(voucherCapsule)).printSize();

    // Assert
    verify(treeCapsule).getLeft();
    verify(treeCapsule, atLeast(1)).getParents();
    verify(treeCapsule).getRight();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  public void testPrintSize6() {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = mock(IncrementalMerkleTreeContainer.class);
    when(incrementalMerkleTreeContainer.size()).thenReturn(3);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(incrementalMerkleTreeCapsule);
    when(voucherCapsule.getTree()).thenReturn(new IncrementalMerkleTreeCapsule());

    // Act
    (new IncrementalMerkleVoucherContainer(voucherCapsule)).printSize();

    // Assert
    verify(incrementalMerkleTreeContainer).size();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  public void testPrintSize7() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = mock(IncrementalMerkleTreeContainer.class);
    when(incrementalMerkleTreeContainer.size()).thenReturn(3);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule2 = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule2.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(incrementalMerkleTreeCapsule2);
    when(voucherCapsule.getTree()).thenReturn(incrementalMerkleTreeCapsule);

    // Act
    (new IncrementalMerkleVoucherContainer(voucherCapsule)).printSize();

    // Assert
    verify(incrementalMerkleTreeContainer).size();
    verify(incrementalMerkleTreeCapsule2).toMerkleTreeContainer();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  public void testPrintSize8() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(new IncrementalMerkleTreeContainer(treeCapsule));
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = mock(IncrementalMerkleTreeContainer.class);
    when(incrementalMerkleTreeContainer.size()).thenReturn(3);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule2 = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule2.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(incrementalMerkleTreeCapsule2);
    when(voucherCapsule.getTree()).thenReturn(incrementalMerkleTreeCapsule);

    // Act
    (new IncrementalMerkleVoucherContainer(voucherCapsule)).printSize();

    // Assert
    verify(incrementalMerkleTreeContainer).size();
    verify(incrementalMerkleTreeCapsule2).toMerkleTreeContainer();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  public void testPrintSize9() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setLeft(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(new IncrementalMerkleTreeContainer(treeCapsule));
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = mock(IncrementalMerkleTreeContainer.class);
    when(incrementalMerkleTreeContainer.size()).thenReturn(3);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule2 = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule2.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(incrementalMerkleTreeCapsule2);
    when(voucherCapsule.getTree()).thenReturn(incrementalMerkleTreeCapsule);

    // Act
    (new IncrementalMerkleVoucherContainer(voucherCapsule)).printSize();

    // Assert
    verify(incrementalMerkleTreeContainer).size();
    verify(incrementalMerkleTreeCapsule2).toMerkleTreeContainer();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  public void testPrintSize10() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.setRight(ShieldContract.PedersenHash.getDefaultInstance());
    treeCapsule.addParents(ShieldContract.PedersenHash.getDefaultInstance());
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(new IncrementalMerkleTreeContainer(treeCapsule));
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = mock(IncrementalMerkleTreeContainer.class);
    when(incrementalMerkleTreeContainer.size()).thenReturn(3);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule2 = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule2.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(incrementalMerkleTreeCapsule2);
    when(voucherCapsule.getTree()).thenReturn(incrementalMerkleTreeCapsule);

    // Act
    (new IncrementalMerkleVoucherContainer(voucherCapsule)).printSize();

    // Assert
    verify(incrementalMerkleTreeContainer).size();
    verify(incrementalMerkleTreeCapsule2).toMerkleTreeContainer();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
  }

  /**
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  public void testPrintSize11() {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = mock(IncrementalMerkleTreeContainer.class);
    when(incrementalMerkleTreeContainer.size()).thenReturn(3);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer2 = mock(IncrementalMerkleTreeContainer.class);
    when(incrementalMerkleTreeContainer2.size()).thenReturn(3);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule2 = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule2.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer2);
    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(incrementalMerkleTreeCapsule2);
    when(voucherCapsule.getTree()).thenReturn(incrementalMerkleTreeCapsule);

    // Act
    (new IncrementalMerkleVoucherContainer(voucherCapsule)).printSize();

    // Assert
    verify(incrementalMerkleTreeContainer2).size();
    verify(incrementalMerkleTreeContainer).size();
    verify(incrementalMerkleTreeCapsule2).toMerkleTreeContainer();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
  }
}
