package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.UnknownFieldSet;
import java.util.Deque;
import java.util.LinkedList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.zksnark.IncrementalMerkleTreeContainer.EmptyMerkleRoots;
import org.tron.common.zksnark.IncrementalMerkleTreeContainer.PathFiller;
import org.tron.core.capsule.IncrementalMerkleTreeCapsule;
import org.tron.core.capsule.IncrementalMerkleVoucherCapsule;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.PedersenHash;

public class IncrementalMerkleTreeContainerDiffblueTest {
  /**
   * Test EmptyMerkleRoots {@link EmptyMerkleRoots#emptyRoot(int)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link EmptyMerkleRoots#emptyRoot(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash EmptyMerkleRoots.emptyRoot(int)"})
  public void testEmptyMerkleRootsEmptyRoot_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    PedersenHash actualEmptyRootResult =
        EmptyMerkleRoots.getEmptyMerkleRootsInstance().emptyRoot(1);

    // Assert
    assertEquals("", actualEmptyRootResult.getInitializationErrorString());
    assertEquals(1, actualEmptyRootResult.getAllFields().size());
    assertEquals(34, actualEmptyRootResult.getSerializedSize());
    assertTrue(actualEmptyRootResult.findInitializationErrors().isEmpty());
    assertTrue(actualEmptyRootResult.isInitialized());
  }

  /**
   * Test EmptyMerkleRoots getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmptyMerkleRoots#getEmptyMerkleRootsInstance()}
   *   <li>{@link EmptyMerkleRoots#setEmptyMerkleRootsInstance(EmptyMerkleRoots)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "EmptyMerkleRoots EmptyMerkleRoots.getEmptyMerkleRootsInstance()",
    "void EmptyMerkleRoots.setEmptyMerkleRootsInstance(EmptyMerkleRoots)"
  })
  public void testEmptyMerkleRootsGettersAndSetters() {
    // Arrange and Act
    EmptyMerkleRoots actualEmptyMerkleRootsInstance =
        EmptyMerkleRoots.getEmptyMerkleRootsInstance();
    EmptyMerkleRoots actualEmptyMerkleRootsInstance2 =
        actualEmptyMerkleRootsInstance.getEmptyMerkleRootsInstance();
    EmptyMerkleRoots emptyMerkleRootsInstance = EmptyMerkleRoots.getEmptyMerkleRootsInstance();
    actualEmptyMerkleRootsInstance.setEmptyMerkleRootsInstance(emptyMerkleRootsInstance);

    // Assert
    assertSame(emptyMerkleRootsInstance, actualEmptyMerkleRootsInstance2);
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#emptyRoot()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#emptyRoot()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.emptyRoot()"})
  public void testEmptyRoot() {
    // Arrange and Act
    PedersenHash actualEmptyRootResult = IncrementalMerkleTreeContainer.emptyRoot();

    // Assert
    assertEquals("", actualEmptyRootResult.getInitializationErrorString());
    assertEquals(1, actualEmptyRootResult.getAllFields().size());
    assertEquals(34, actualEmptyRootResult.getSerializedSize());
    assertTrue(actualEmptyRootResult.findInitializationErrors().isEmpty());
    assertTrue(actualEmptyRootResult.isInitialized());
  }

  /**
   * Test PathFiller {@link PathFiller#next(int)}.
   *
   * <p>Method under test: {@link PathFiller#next(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PathFiller.next(int)"})
  public void testPathFillerNext() {
    // Arrange and Act
    PedersenHash actualNextResult = new PathFiller(new LinkedList<>()).next(1);

    // Assert
    PedersenHash defaultInstanceForType = actualNextResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    ByteString content = actualNextResult.getContent();
    assertEquals(
        "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        content.toStringUtf8());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(1, actualNextResult.getAllFields().size());
    assertEquals(34, actualNextResult.getSerializedSize());
    assertFalse(content.isEmpty());
    assertTrue(content.iterator().hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(defaultInstanceForType.isInitialized());
    UnknownFieldSet unknownFields = actualNextResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test PathFiller {@link PathFiller#next(int)}.
   *
   * <ul>
   *   <li>Given {@link LinkedList#LinkedList()} add DefaultInstance.
   *   <li>Then return DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link PathFiller#next(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash PathFiller.next(int)"})
  public void testPathFillerNext_givenLinkedListAddDefaultInstance_thenReturnDefaultInstance() {
    // Arrange
    LinkedList<PedersenHash> queue = new LinkedList<>();
    PedersenHash defaultInstance = PedersenHash.getDefaultInstance();
    queue.add(defaultInstance);

    // Act and Assert
    assertSame(defaultInstance, new PathFiller(queue).next(2));
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#wfcheck()}.
   *
   * <ul>
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#wfcheck()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleTreeContainer.wfcheck()"})
  public void testWfcheck_thenThrowZksnarkException() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(
        ZksnarkException.class, () -> new IncrementalMerkleTreeContainer(treeCapsule).wfcheck());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#last()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#last()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.last()"})
  public void testLast() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () -> new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).last());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#last()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#last()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.last()"})
  public void testLast2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> incrementalMerkleTreeContainer.last());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#size()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleTreeContainer.size()"})
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).size());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#size()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleTreeContainer.size()"})
  public void testSize2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, incrementalMerkleTreeContainer.size());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#size()}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()} addParents
   *       DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleTreeContainer.size()"})
  public void testSize_givenIncrementalMerkleTreeCapsuleAddParentsDefaultInstance() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, new IncrementalMerkleTreeContainer(treeCapsule).size());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#isComplete()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#isComplete()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTreeContainer.isComplete()"})
  public void testIsComplete() {
    // Arrange, Act and Assert
    assertFalse(
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).isComplete());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#isComplete()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#isComplete()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTreeContainer.isComplete()"})
  public void testIsComplete2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertFalse(incrementalMerkleTreeContainer.isComplete());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#isComplete(long)} with {@code long}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#isComplete(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTreeContainer.isComplete(long)"})
  public void testIsCompleteWithLong() {
    // Arrange, Act and Assert
    assertFalse(
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).isComplete(1L));
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#isComplete(long)} with {@code long}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#isComplete(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IncrementalMerkleTreeContainer.isComplete(long)"})
  public void testIsCompleteWithLong2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertFalse(incrementalMerkleTreeContainer.isComplete(1L));
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#nextDepth(int)}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#nextDepth(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleTreeContainer.nextDepth(int)"})
  public void testNextDepth() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(0, incrementalMerkleTreeContainer.nextDepth(1));
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#nextDepth(int)}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()} addParents
   *       DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#nextDepth(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleTreeContainer.nextDepth(int)"})
  public void testNextDepth_givenIncrementalMerkleTreeCapsuleAddParentsDefaultInstance() {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertEquals(-2, new IncrementalMerkleTreeContainer(treeCapsule).nextDepth(-1));
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#nextDepth(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return minus two.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#nextDepth(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleTreeContainer.nextDepth(int)"})
  public void testNextDepth_whenMinusOne_thenReturnMinusTwo() {
    // Arrange, Act and Assert
    assertEquals(
        -2, new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).nextDepth(-1));
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#nextDepth(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#nextDepth(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleTreeContainer.nextDepth(int)"})
  public void testNextDepth_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).nextDepth(1));
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#nextDepth(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#nextDepth(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleTreeContainer.nextDepth(int)"})
  public void testNextDepth_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).nextDepth(0));
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#root()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#root()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.root()"})
  public void testRoot() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    PedersenHash obj = PedersenHash.getDefaultInstance();
    incrementalMerkleTreeContainer.append(obj);

    // Act
    PedersenHash actualRootResult = incrementalMerkleTreeContainer.root();

    // Assert
    assertEquals("", actualRootResult.getInitializationErrorString());
    assertEquals(1, actualRootResult.getAllFields().size());
    assertEquals(34, actualRootResult.getSerializedSize());
    assertTrue(actualRootResult.findInitializationErrors().isEmpty());
    assertTrue(actualRootResult.isInitialized());
    assertSame(obj, actualRootResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#root(long)} with {@code depth}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#root(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.root(long)"})
  public void testRootWithDepth() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    PedersenHash obj = PedersenHash.getDefaultInstance();
    incrementalMerkleTreeContainer.append(obj);

    // Act
    PedersenHash actualRootResult = incrementalMerkleTreeContainer.root(1L);

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(obj, actualRootResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#root(long, Deque)} with {@code depth}, {@code
   * fillerHashes}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#root(long, Deque)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.root(long, Deque)"})
  public void testRootWithDepthFillerHashes() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());

    // Act
    PedersenHash actualRootResult = incrementalMerkleTreeContainer.root(1L, new LinkedList<>());

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    PedersenHash defaultInstanceForType = actualRootResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#root(long, Deque)} with {@code depth}, {@code
   * fillerHashes}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#root(long, Deque)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.root(long, Deque)"})
  public void testRootWithDepthFillerHashes2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    PedersenHash obj = PedersenHash.getDefaultInstance();
    incrementalMerkleTreeContainer.append(obj);

    // Act
    PedersenHash actualRootResult = incrementalMerkleTreeContainer.root(1L, new LinkedList<>());

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(obj, actualRootResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#root(long, Deque)} with {@code depth}, {@code
   * fillerHashes}.
   *
   * <ul>
   *   <li>Then return DefaultInstanceForType is DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#root(long, Deque)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.root(long, Deque)"})
  public void testRootWithDepthFillerHashes_thenReturnDefaultInstanceForTypeIsDefaultInstance()
      throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    PedersenHash parents = PedersenHash.getDefaultInstance();
    treeCapsule.addParents(parents);
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(treeCapsule);

    // Act
    PedersenHash actualRootResult = incrementalMerkleTreeContainer.root(1L, new LinkedList<>());

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(parents, actualRootResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#root(long, Deque)} with {@code depth}, {@code
   * fillerHashes}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#root(long, Deque)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.root(long, Deque)"})
  public void testRootWithDepthFillerHashes_whenTwo() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());

    // Act
    PedersenHash actualRootResult = incrementalMerkleTreeContainer.root(2L, new LinkedList<>());

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    PedersenHash defaultInstanceForType = actualRootResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#root(long)} with {@code depth}.
   *
   * <ul>
   *   <li>Then return DefaultInstanceForType is DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#root(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.root(long)"})
  public void testRootWithDepth_thenReturnDefaultInstanceForTypeIsDefaultInstance()
      throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    PedersenHash parents = PedersenHash.getDefaultInstance();
    treeCapsule.addParents(parents);

    // Act
    PedersenHash actualRootResult = new IncrementalMerkleTreeContainer(treeCapsule).root(1L);

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(parents, actualRootResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#root(long)} with {@code depth}.
   *
   * <ul>
   *   <li>Then return DefaultInstanceForType UnknownFields is UnknownFields.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#root(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.root(long)"})
  public void testRootWithDepth_thenReturnDefaultInstanceForTypeUnknownFieldsIsUnknownFields()
      throws ZksnarkException {
    // Arrange and Act
    PedersenHash actualRootResult =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).root(1L);

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    PedersenHash defaultInstanceForType = actualRootResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#root(long)} with {@code depth}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#root(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.root(long)"})
  public void testRootWithDepth_whenTwo() throws ZksnarkException {
    // Arrange and Act
    PedersenHash actualRootResult =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).root(2L);

    // Assert
    UnknownFieldSet unknownFields = actualRootResult.getUnknownFields();
    PedersenHash defaultInstanceForType = actualRootResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#root()}.
   *
   * <ul>
   *   <li>Then return DefaultInstanceForType is DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#root()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.root()"})
  public void testRoot_thenReturnDefaultInstanceForTypeIsDefaultInstance() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    PedersenHash parents = PedersenHash.getDefaultInstance();
    treeCapsule.addParents(parents);

    // Act
    PedersenHash actualRootResult = new IncrementalMerkleTreeContainer(treeCapsule).root();

    // Assert
    assertEquals("", actualRootResult.getInitializationErrorString());
    assertEquals(1, actualRootResult.getAllFields().size());
    assertEquals(34, actualRootResult.getSerializedSize());
    assertTrue(actualRootResult.findInitializationErrors().isEmpty());
    assertTrue(actualRootResult.isInitialized());
    assertSame(parents, actualRootResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#root()}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#root()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleTreeContainer.root()"})
  public void testRoot_thenReturnInitializationErrorStringIsEmptyString() throws ZksnarkException {
    // Arrange and Act
    PedersenHash actualRootResult =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).root();

    // Assert
    assertEquals("", actualRootResult.getInitializationErrorString());
    assertEquals(1, actualRootResult.getAllFields().size());
    assertEquals(34, actualRootResult.getSerializedSize());
    assertTrue(actualRootResult.findInitializationErrors().isEmpty());
    assertTrue(actualRootResult.isInitialized());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#path()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#path()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.zksnark.MerklePath IncrementalMerkleTreeContainer.path()"})
  public void testPath() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () -> new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).path());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#path()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#path()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.common.zksnark.MerklePath IncrementalMerkleTreeContainer.path()"})
  public void testPath2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> incrementalMerkleTreeContainer.path());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#path(Deque)} with {@code Deque}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#path(Deque)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "org.tron.common.zksnark.MerklePath IncrementalMerkleTreeContainer.path(Deque)"
  })
  public void testPathWithDeque() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());

    // Act and Assert
    assertThrows(
        ZksnarkException.class, () -> incrementalMerkleTreeContainer.path(new LinkedList<>()));
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#path(Deque)} with {@code Deque}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#path(Deque)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "org.tron.common.zksnark.MerklePath IncrementalMerkleTreeContainer.path(Deque)"
  })
  public void testPathWithDeque2() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(
        ZksnarkException.class, () -> incrementalMerkleTreeContainer.path(new LinkedList<>()));
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#path(Deque)} with {@code Deque}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>When {@link LinkedList#LinkedList()} add DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#path(Deque)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "org.tron.common.zksnark.MerklePath IncrementalMerkleTreeContainer.path(Deque)"
  })
  public void testPathWithDeque_givenDefaultInstance_whenLinkedListAddDefaultInstance()
      throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());

    LinkedList<PedersenHash> fillerHashes = new LinkedList<>();
    fillerHashes.add(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> incrementalMerkleTreeContainer.path(fillerHashes));
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#path(Deque)} with {@code Deque}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>When {@link LinkedList#LinkedList()} add DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#path(Deque)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "org.tron.common.zksnark.MerklePath IncrementalMerkleTreeContainer.path(Deque)"
  })
  public void testPathWithDeque_givenDefaultInstance_whenLinkedListAddDefaultInstance2()
      throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());

    LinkedList<PedersenHash> fillerHashes = new LinkedList<>();
    fillerHashes.add(PedersenHash.getDefaultInstance());
    fillerHashes.add(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> incrementalMerkleTreeContainer.path(fillerHashes));
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#getMerkleTreeKey()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#getMerkleTreeKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleTreeContainer.getMerkleTreeKey()"})
  public void testGetMerkleTreeKey() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        incrementalMerkleTreeContainer.getMerkleTreeKey());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#getMerkleTreeKey()}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()} addParents
   *       DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#getMerkleTreeKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleTreeContainer.getMerkleTreeKey()"})
  public void testGetMerkleTreeKey_givenIncrementalMerkleTreeCapsuleAddParentsDefaultInstance()
      throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        new IncrementalMerkleTreeContainer(treeCapsule).getMerkleTreeKey());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#getMerkleTreeKey()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#getMerkleTreeKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleTreeContainer.getMerkleTreeKey()"})
  public void testGetMerkleTreeKey_thenReturnArrayOfByteWithZeroAndZero() throws ZksnarkException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).getMerkleTreeKey());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#getRootArray()}.
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#getRootArray()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleTreeContainer.getRootArray()"})
  public void testGetRootArray() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    incrementalMerkleTreeContainer.append(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        incrementalMerkleTreeContainer.getRootArray());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#getRootArray()}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()} addParents
   *       DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#getRootArray()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleTreeContainer.getRootArray()"})
  public void testGetRootArray_givenIncrementalMerkleTreeCapsuleAddParentsDefaultInstance()
      throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    treeCapsule.addParents(PedersenHash.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        new IncrementalMerkleTreeContainer(treeCapsule).getRootArray());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#getRootArray()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#getRootArray()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] IncrementalMerkleTreeContainer.getRootArray()"})
  public void testGetRootArray_thenReturnArrayOfByteWithZeroAndZero() throws ZksnarkException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).getRootArray());
  }

  /**
   * Test {@link IncrementalMerkleTreeContainer#toVoucher()}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleTreeContainer#toVoucher()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "IncrementalMerkleVoucherContainer IncrementalMerkleTreeContainer.toVoucher()"
  })
  public void testToVoucher_thenReturnSizeIsZero() {
    // Arrange and Act
    IncrementalMerkleVoucherContainer actualToVoucherResult =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()).toVoucher();

    // Assert
    assertEquals(0, actualToVoucherResult.size());
    IncrementalMerkleVoucherCapsule voucherCapsule = actualToVoucherResult.getVoucherCapsule();
    assertEquals(0L, voucherCapsule.getCursorDepth());
    assertTrue(voucherCapsule.getFilled().isEmpty());
    assertArrayEquals(new byte[] {'\n', 0}, voucherCapsule.getData());
  }
}
