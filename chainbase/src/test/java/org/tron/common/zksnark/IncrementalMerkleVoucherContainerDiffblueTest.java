package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.IncrementalMerkleTreeCapsule;
import org.tron.core.capsule.IncrementalMerkleVoucherCapsule;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.PedersenHash;

public class IncrementalMerkleVoucherContainerDiffblueTest {
  /**
   * Test {@link IncrementalMerkleVoucherContainer#IncrementalMerkleVoucherContainer(IncrementalMerkleTreeContainer)}.
   * <ul>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#IncrementalMerkleVoucherContainer(IncrementalMerkleTreeContainer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherContainer.<init>(IncrementalMerkleTreeContainer)"})
  public void testNewIncrementalMerkleVoucherContainer_thenReturnSizeIsZero() {
    // Arrange and Act
    IncrementalMerkleVoucherContainer actualIncrementalMerkleVoucherContainer = new IncrementalMerkleVoucherContainer(
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));

    // Assert
    assertEquals(0, actualIncrementalMerkleVoucherContainer.size());
    IncrementalMerkleVoucherCapsule voucherCapsule = actualIncrementalMerkleVoucherContainer.getVoucherCapsule();
    assertEquals(0L, voucherCapsule.getCursorDepth());
    assertTrue(voucherCapsule.getFilled().isEmpty());
    assertArrayEquals(new byte[]{'\n', 0}, voucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#path()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#path()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerklePath IncrementalMerkleVoucherContainer.path()"})
  public void testPath() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = mock(IncrementalMerkleTreeContainer.class);
    ArrayList<List<Boolean>> authenticationPath = new ArrayList<>();
    MerklePath merklePath = new MerklePath(authenticationPath, new ArrayList<>());

    when(incrementalMerkleTreeContainer.path(Mockito.<Deque<PedersenHash>>any())).thenReturn(merklePath);
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
   * Test {@link IncrementalMerkleVoucherContainer#position()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#position()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long IncrementalMerkleVoucherContainer.position()"})
  public void testPosition() {
    // Arrange, Act and Assert
    assertEquals(-1L,
        (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())))
            .position());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#position()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#position()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long IncrementalMerkleVoucherContainer.position()"})
  public void testPosition2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer tree = new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    tree.append(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(-1L, (new IncrementalMerkleVoucherContainer(tree)).position());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#position()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#position()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long IncrementalMerkleVoucherContainer.position()"})
  public void testPosition3() {
    // Arrange, Act and Assert
    assertEquals(-1L, (new IncrementalMerkleVoucherContainer(new IncrementalMerkleVoucherCapsule())).position());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#position()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()} addParents DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#position()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long IncrementalMerkleVoucherContainer.position()"})
  public void testPosition_givenIncrementalMerkleTreeCapsuleAddParentsDefaultInstance() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(-1L,
        (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(treeCapsule))).position());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#root()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#root()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleVoucherContainer.root()"})
  public void testRoot() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer tree = new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    PedersenHash obj = PedersenHash.getDefaultInstance();
    tree.append(obj);

    // Act
    PedersenHash actualRootResult = (new IncrementalMerkleVoucherContainer(tree)).root();

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(obj, actualRootResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#root()}.
   * <ul>
   *   <li>Then return DefaultInstanceForType is DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#root()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleVoucherContainer.root()"})
  public void testRoot_thenReturnDefaultInstanceForTypeIsDefaultInstance() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    PedersenHash parents = PedersenHash.getDefaultInstance();
    treeCapsule.addParents(parents);

    // Act
    PedersenHash actualRootResult = (new IncrementalMerkleVoucherContainer(
        new IncrementalMerkleTreeContainer(treeCapsule))).root();

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(parents, actualRootResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#root()}.
   * <ul>
   *   <li>Then return DefaultInstanceForType is DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#root()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleVoucherContainer.root()"})
  public void testRoot_thenReturnDefaultInstanceForTypeIsDefaultInstance2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule cursor = new IncrementalMerkleTreeCapsule();
    PedersenHash parents = PedersenHash.getDefaultInstance();
    cursor.addParents(parents);

    IncrementalMerkleVoucherCapsule voucherCapsule = new IncrementalMerkleVoucherCapsule();
    voucherCapsule.setCursor(cursor);

    // Act
    PedersenHash actualRootResult = (new IncrementalMerkleVoucherContainer(voucherCapsule)).root();

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(parents, actualRootResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#root()}.
   * <ul>
   *   <li>Then return DefaultInstanceForType UnknownFields is UnknownFields.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#root()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleVoucherContainer.root()"})
  public void testRoot_thenReturnDefaultInstanceForTypeUnknownFieldsIsUnknownFields() throws ZksnarkException {
    // Arrange and Act
    PedersenHash actualRootResult = (new IncrementalMerkleVoucherContainer(
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()))).root();

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    PedersenHash defaultInstanceForType = actualRootResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#root()}.
   * <ul>
   *   <li>Then return DefaultInstanceForType UnknownFields is UnknownFields.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#root()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleVoucherContainer.root()"})
  public void testRoot_thenReturnDefaultInstanceForTypeUnknownFieldsIsUnknownFields2() throws ZksnarkException {
    // Arrange and Act
    PedersenHash actualRootResult = (new IncrementalMerkleVoucherContainer(new IncrementalMerkleVoucherCapsule()))
        .root();

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    PedersenHash defaultInstanceForType = actualRootResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#root()}.
   * <ul>
   *   <li>Then return DefaultInstanceForType UnknownFields is UnknownFields.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#root()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleVoucherContainer.root()"})
  public void testRoot_thenReturnDefaultInstanceForTypeUnknownFieldsIsUnknownFields3() throws ZksnarkException {
    // Arrange
    IncrementalMerkleVoucherCapsule voucherCapsule = new IncrementalMerkleVoucherCapsule();
    voucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());

    // Act
    PedersenHash actualRootResult = (new IncrementalMerkleVoucherContainer(voucherCapsule)).root();

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    PedersenHash defaultInstanceForType = actualRootResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#size()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleVoucherContainer.size()"})
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule())))
            .size());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#size()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleVoucherContainer.size()"})
  public void testSize2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer tree = new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    tree.append(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, (new IncrementalMerkleVoucherContainer(tree)).size());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#size()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleVoucherContainer.size()"})
  public void testSize3() {
    // Arrange, Act and Assert
    assertEquals(0, (new IncrementalMerkleVoucherContainer(new IncrementalMerkleVoucherCapsule())).size());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#size()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleVoucherContainer.size()"})
  public void testSize4() {
    // Arrange
    IncrementalMerkleVoucherCapsule voucherCapsule = new IncrementalMerkleVoucherCapsule();
    voucherCapsule.setCursor(new IncrementalMerkleTreeCapsule());

    // Act and Assert
    assertEquals(0, (new IncrementalMerkleVoucherContainer(voucherCapsule)).size());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#size()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()} addParents DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleVoucherContainer.size()"})
  public void testSize_givenIncrementalMerkleTreeCapsuleAddParentsDefaultInstance() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, (new IncrementalMerkleVoucherContainer(new IncrementalMerkleTreeContainer(treeCapsule))).size());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#printSize()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherContainer.printSize()"})
  public void testPrintSize() {
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
   * Test {@link IncrementalMerkleVoucherContainer#printSize()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherContainer.printSize()"})
  public void testPrintSize2() {
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
   * Test {@link IncrementalMerkleVoucherContainer#printSize()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherContainer.printSize()"})
  public void testPrintSize3() {
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
   * Test {@link IncrementalMerkleVoucherContainer#printSize()}.
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherContainer.printSize()"})
  public void testPrintSize4() {
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

  /**
   * Test {@link IncrementalMerkleVoucherContainer#printSize()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeContainer} {@link IncrementalMerkleTreeContainer#size()} return three.</li>
   *   <li>Then calls {@link IncrementalMerkleTreeContainer#size()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherContainer.printSize()"})
  public void testPrintSize_givenIncrementalMerkleTreeContainerSizeReturnThree_thenCallsSize() {
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
}
