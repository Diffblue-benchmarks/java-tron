package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.capsule.IncrementalMerkleTreeCapsule;
import org.tron.core.capsule.IncrementalMerkleVoucherCapsule;
import org.tron.core.exception.ZksnarkException;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.PedersenHash;

public class IncrementalMerkleVoucherContainerDiffblueTest {
  /**
   * Test {@link
   * IncrementalMerkleVoucherContainer#IncrementalMerkleVoucherContainer(IncrementalMerkleTreeContainer)}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * IncrementalMerkleVoucherContainer#IncrementalMerkleVoucherContainer(IncrementalMerkleTreeContainer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IncrementalMerkleVoucherContainer.<init>(IncrementalMerkleTreeContainer)"
  })
  public void testNewIncrementalMerkleVoucherContainer_thenReturnSizeIsZero() {
    // Arrange and Act
    IncrementalMerkleVoucherContainer actualIncrementalMerkleVoucherContainer =
        new IncrementalMerkleVoucherContainer(
            new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));

    // Assert
    assertEquals(0, actualIncrementalMerkleVoucherContainer.size());
    IncrementalMerkleVoucherCapsule voucherCapsule =
        actualIncrementalMerkleVoucherContainer.getVoucherCapsule();
    assertEquals(0L, voucherCapsule.getCursorDepth());
    assertTrue(voucherCapsule.getFilled().isEmpty());
    assertArrayEquals(new byte[] {'\n', 0}, voucherCapsule.getData());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#position()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherContainer#position()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long IncrementalMerkleVoucherContainer.position()"})
  public void testPosition() {
    // Arrange, Act and Assert
    assertEquals(
        -1L,
        new IncrementalMerkleVoucherContainer(
                new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()))
            .position());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#position()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherContainer#position()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long IncrementalMerkleVoucherContainer.position()"})
  public void testPosition2() {
    // Arrange, Act and Assert
    assertEquals(
        -1L,
        new IncrementalMerkleVoucherContainer(new IncrementalMerkleVoucherCapsule()).position());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#root()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherContainer#root()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleVoucherContainer.root()"})
  public void testRoot() throws ZksnarkException {
    // Arrange and Act
    PedersenHash actualRootResult =
        new IncrementalMerkleVoucherContainer(
                new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()))
            .root();

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
   * Test {@link IncrementalMerkleVoucherContainer#root()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherContainer#root()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PedersenHash IncrementalMerkleVoucherContainer.root()"})
  public void testRoot2() throws ZksnarkException {
    // Arrange and Act
    PedersenHash actualRootResult =
        new IncrementalMerkleVoucherContainer(new IncrementalMerkleVoucherCapsule()).root();

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
   * Test {@link IncrementalMerkleVoucherContainer#size()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleVoucherContainer.size()"})
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new IncrementalMerkleVoucherContainer(
                new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()))
            .size());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#size()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherContainer#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IncrementalMerkleVoucherContainer.size()"})
  public void testSize2() {
    // Arrange, Act and Assert
    assertEquals(
        0, new IncrementalMerkleVoucherContainer(new IncrementalMerkleVoucherCapsule()).size());
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#printSize()}.
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
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
    new IncrementalMerkleVoucherContainer(voucherCapsule).printSize();

    // Assert
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
  }

  /**
   * Test {@link IncrementalMerkleVoucherContainer#printSize()}.
   *
   * <ul>
   *   <li>Then calls {@link IncrementalMerkleTreeCapsule#toMerkleTreeContainer()}.
   * </ul>
   *
   * <p>Method under test: {@link IncrementalMerkleVoucherContainer#printSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncrementalMerkleVoucherContainer.printSize()"})
  public void testPrintSize_thenCallsToMerkleTreeContainer() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule =
        mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));

    IncrementalMerkleVoucherCapsule voucherCapsule = mock(IncrementalMerkleVoucherCapsule.class);
    when(voucherCapsule.getFilled()).thenReturn(new ArrayList<>());
    when(voucherCapsule.getCursor()).thenReturn(incrementalMerkleTreeCapsule);
    when(voucherCapsule.getTree()).thenReturn(new IncrementalMerkleTreeCapsule());

    // Act
    new IncrementalMerkleVoucherContainer(voucherCapsule).printSize();

    // Assert
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(voucherCapsule).getCursor();
    verify(voucherCapsule).getFilled();
    verify(voucherCapsule).getTree();
  }
}
