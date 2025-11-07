package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.IncrementalMerkleTreeCapsule;
import org.tron.core.capsule.IncrementalMerkleVoucherCapsule;
import org.tron.core.db.TronStoreWithRevoking;
import org.tron.core.exception.ZksnarkException;
import org.tron.core.store.IncrementalMerkleTreeStore;
import org.tron.core.store.TreeBlockIndexStore;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.IncrementalMerkleTree;
import org.tron.protos.contract.ShieldContract.PedersenHash;

public class MerkleContainerDiffblueTest {
  /**
   * Test {@link MerkleContainer#createInstance(IncrementalMerkleTreeStore, TreeBlockIndexStore)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return IncrementalMerkleTreeStore is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerkleContainer#createInstance(IncrementalMerkleTreeStore, TreeBlockIndexStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MerkleContainer MerkleContainer.createInstance(IncrementalMerkleTreeStore, TreeBlockIndexStore)"})
  public void testCreateInstance_whenNull_thenReturnIncrementalMerkleTreeStoreIsNull() {
    // Arrange and Act
    MerkleContainer actualCreateInstanceResult = MerkleContainer.createInstance(null, null);

    // Assert
    assertNull(actualCreateInstanceResult.getIncrementalMerkleTreeStore());
    assertNull(actualCreateInstanceResult.getMerkleTreeIndexStore());
  }

  /**
   * Test {@link MerkleContainer#getCurrentMerkle()}.
   * <p>
   * Method under test: {@link MerkleContainer#getCurrentMerkle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeContainer MerkleContainer.getCurrentMerkle()"})
  public void testGetCurrentMerkle() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(new IncrementalMerkleTreeCapsule());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    IncrementalMerkleTreeContainer actualCurrentMerkle = merkleContainer.getCurrentMerkle();

    // Assert
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    IncrementalMerkleTreeCapsule treeCapsule = actualCurrentMerkle.getTreeCapsule();
    assertArrayEquals(new byte[]{}, treeCapsule.getData());
    IncrementalMerkleVoucherCapsule voucherCapsule = actualCurrentMerkle.toVoucher().getVoucherCapsule();
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    assertArrayEquals(new byte[]{}, cursor.getData());
    IncrementalMerkleTreeCapsule tree = voucherCapsule.getTree();
    assertArrayEquals(new byte[]{}, tree.getData());
    assertArrayEquals(new byte[]{'\n', 0}, voucherCapsule.getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = treeCapsule.toMerkleTreeContainer();
    assertArrayEquals(new byte[]{'\n', 0}, toMerkleTreeContainerResult.toVoucher().getVoucherCapsule().getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCurrentMerkle.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult2 = cursor.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult2.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult3 = tree.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult3.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCurrentMerkle.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult2.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult3.getRootArray());
  }

  /**
   * Test {@link MerkleContainer#getCurrentMerkle()}.
   * <p>
   * Method under test: {@link MerkleContainer#getCurrentMerkle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeContainer MerkleContainer.getCurrentMerkle()"})
  public void testGetCurrentMerkle2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(incrementalMerkleTreeCapsule);

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    IncrementalMerkleTreeContainer actualCurrentMerkle = merkleContainer.getCurrentMerkle();

    // Assert
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    assertSame(incrementalMerkleTreeContainer, actualCurrentMerkle);
  }

  /**
   * Test {@link MerkleContainer#getCurrentMerkle()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeStore} {@link IncrementalMerkleTreeStore#get(byte[])} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerkleContainer#getCurrentMerkle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeContainer MerkleContainer.getCurrentMerkle()"})
  public void testGetCurrentMerkle_givenIncrementalMerkleTreeStoreGetReturnNull() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(null);

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    IncrementalMerkleTreeContainer actualCurrentMerkle = merkleContainer.getCurrentMerkle();

    // Assert
    verify(incrementalMerkleTreeStore, atLeast(1)).get(Mockito.<byte[]>any());
    IncrementalMerkleTreeCapsule treeCapsule = actualCurrentMerkle.getTreeCapsule();
    assertArrayEquals(new byte[]{}, treeCapsule.getData());
    IncrementalMerkleVoucherCapsule voucherCapsule = actualCurrentMerkle.toVoucher().getVoucherCapsule();
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    assertArrayEquals(new byte[]{}, cursor.getData());
    IncrementalMerkleTreeCapsule tree = voucherCapsule.getTree();
    assertArrayEquals(new byte[]{}, tree.getData());
    assertArrayEquals(new byte[]{'\n', 0}, voucherCapsule.getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = treeCapsule.toMerkleTreeContainer();
    assertArrayEquals(new byte[]{'\n', 0}, toMerkleTreeContainerResult.toVoucher().getVoucherCapsule().getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCurrentMerkle.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult2 = cursor.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult2.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult3 = tree.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult3.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualCurrentMerkle.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult2.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult3.getRootArray());
  }

  /**
   * Test {@link MerkleContainer#setCurrentMerkle(IncrementalMerkleTreeContainer)}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeStore} {@link TronStoreWithRevoking#put(byte[], ProtoCapsule)} does nothing.</li>
   *   <li>Then calls {@link TronStoreWithRevoking#put(byte[], ProtoCapsule)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerkleContainer#setCurrentMerkle(IncrementalMerkleTreeContainer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MerkleContainer.setCurrentMerkle(IncrementalMerkleTreeContainer)"})
  public void testSetCurrentMerkle_givenIncrementalMerkleTreeStorePutDoesNothing_thenCallsPut() {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    doNothing().when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    merkleContainer.setCurrentMerkle(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));

    // Assert
    verify(incrementalMerkleTreeStore).put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
  }

  /**
   * Test {@link MerkleContainer#getBestMerkle()}.
   * <p>
   * Method under test: {@link MerkleContainer#getBestMerkle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeContainer MerkleContainer.getBestMerkle()"})
  public void testGetBestMerkle() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(new IncrementalMerkleTreeCapsule());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    IncrementalMerkleTreeContainer actualBestMerkle = merkleContainer.getBestMerkle();

    // Assert
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    IncrementalMerkleTreeCapsule treeCapsule = actualBestMerkle.getTreeCapsule();
    assertArrayEquals(new byte[]{}, treeCapsule.getData());
    IncrementalMerkleVoucherCapsule voucherCapsule = actualBestMerkle.toVoucher().getVoucherCapsule();
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    assertArrayEquals(new byte[]{}, cursor.getData());
    IncrementalMerkleTreeCapsule tree = voucherCapsule.getTree();
    assertArrayEquals(new byte[]{}, tree.getData());
    assertArrayEquals(new byte[]{'\n', 0}, voucherCapsule.getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = treeCapsule.toMerkleTreeContainer();
    assertArrayEquals(new byte[]{'\n', 0}, toMerkleTreeContainerResult.toVoucher().getVoucherCapsule().getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualBestMerkle.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult2 = cursor.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult2.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult3 = tree.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult3.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualBestMerkle.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult2.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult3.getRootArray());
  }

  /**
   * Test {@link MerkleContainer#getBestMerkle()}.
   * <p>
   * Method under test: {@link MerkleContainer#getBestMerkle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeContainer MerkleContainer.getBestMerkle()"})
  public void testGetBestMerkle2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer = new IncrementalMerkleTreeContainer(
        new IncrementalMerkleTreeCapsule());
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer()).thenReturn(incrementalMerkleTreeContainer);
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(incrementalMerkleTreeCapsule);

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    IncrementalMerkleTreeContainer actualBestMerkle = merkleContainer.getBestMerkle();

    // Assert
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    assertSame(incrementalMerkleTreeContainer, actualBestMerkle);
  }

  /**
   * Test {@link MerkleContainer#getBestMerkle()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeStore} {@link IncrementalMerkleTreeStore#get(byte[])} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerkleContainer#getBestMerkle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeContainer MerkleContainer.getBestMerkle()"})
  public void testGetBestMerkle_givenIncrementalMerkleTreeStoreGetReturnNull() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(null);

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    IncrementalMerkleTreeContainer actualBestMerkle = merkleContainer.getBestMerkle();

    // Assert
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    IncrementalMerkleTreeCapsule treeCapsule = actualBestMerkle.getTreeCapsule();
    assertArrayEquals(new byte[]{}, treeCapsule.getData());
    IncrementalMerkleVoucherCapsule voucherCapsule = actualBestMerkle.toVoucher().getVoucherCapsule();
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    assertArrayEquals(new byte[]{}, cursor.getData());
    IncrementalMerkleTreeCapsule tree = voucherCapsule.getTree();
    assertArrayEquals(new byte[]{}, tree.getData());
    assertArrayEquals(new byte[]{'\n', 0}, voucherCapsule.getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = treeCapsule.toMerkleTreeContainer();
    assertArrayEquals(new byte[]{'\n', 0}, toMerkleTreeContainerResult.toVoucher().getVoucherCapsule().getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualBestMerkle.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult2 = cursor.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult2.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult3 = tree.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult3.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualBestMerkle.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult2.getRootArray());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult3.getRootArray());
  }

  /**
   * Test {@link MerkleContainer#resetCurrentMerkleTree()}.
   * <p>
   * Method under test: {@link MerkleContainer#resetCurrentMerkleTree()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MerkleContainer.resetCurrentMerkleTree()"})
  public void testResetCurrentMerkleTree() {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(new IncrementalMerkleTreeCapsule());
    doNothing().when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    merkleContainer.resetCurrentMerkleTree();

    // Assert
    verify(incrementalMerkleTreeStore).put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
  }

  /**
   * Test {@link MerkleContainer#resetCurrentMerkleTree()}.
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeStore} {@link IncrementalMerkleTreeStore#get(byte[])} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerkleContainer#resetCurrentMerkleTree()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MerkleContainer.resetCurrentMerkleTree()"})
  public void testResetCurrentMerkleTree_givenIncrementalMerkleTreeStoreGetReturnNull() {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(null);
    doNothing().when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    merkleContainer.resetCurrentMerkleTree();

    // Assert
    verify(incrementalMerkleTreeStore).put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
  }

  /**
   * Test {@link MerkleContainer#resetCurrentMerkleTree()}.
   * <ul>
   *   <li>Then calls {@link IncrementalMerkleTreeCapsule#toMerkleTreeContainer()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerkleContainer#resetCurrentMerkleTree()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MerkleContainer.resetCurrentMerkleTree()"})
  public void testResetCurrentMerkleTree_thenCallsToMerkleTreeContainer() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(incrementalMerkleTreeCapsule);
    doNothing().when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    merkleContainer.resetCurrentMerkleTree();

    // Assert
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(incrementalMerkleTreeStore).put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
  }

  /**
   * Test {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}.
   * <p>
   * Method under test: {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleTreeContainer MerkleContainer.saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])"})
  public void testSaveCmIntoMerkleTree() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    MerkleContainer merkleContainer = new MerkleContainer();
    IncrementalMerkleTreeContainer tree = new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());

    // Act
    IncrementalMerkleTreeContainer actualSaveCmIntoMerkleTreeResult = merkleContainer.saveCmIntoMerkleTree(tree,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedData = "\n\f\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    IncrementalMerkleVoucherCapsule voucherCapsule = actualSaveCmIntoMerkleTreeResult.toVoucher().getVoucherCapsule();
    assertArrayEquals(expectedData, voucherCapsule.getData());
    byte[] expectedData2 = "\n\f\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    IncrementalMerkleTreeCapsule treeCapsule = actualSaveCmIntoMerkleTreeResult.getTreeCapsule();
    IncrementalMerkleVoucherCapsule voucherCapsule2 = treeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    assertArrayEquals(expectedData2, voucherCapsule2.getData());
    byte[] expectedData3 = "\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData3, treeCapsule.getData());
    byte[] expectedData4 = "\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData4, voucherCapsule.getTree().getData());
    byte[] expectedData5 = "\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData5, voucherCapsule2.getTree().getData());
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    assertArrayEquals(new byte[]{}, cursor.getData());
    assertArrayEquals(new byte[]{}, voucherCapsule2.getCursor().getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = cursor.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getRootArray());
  }

  /**
   * Test {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}.
   * <p>
   * Method under test: {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleTreeContainer MerkleContainer.saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])"})
  public void testSaveCmIntoMerkleTree2() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    MerkleContainer merkleContainer = new MerkleContainer();

    IncrementalMerkleTreeContainer tree = new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    tree.append(PedersenHash.getDefaultInstance());

    // Act
    IncrementalMerkleTreeContainer actualSaveCmIntoMerkleTreeResult = merkleContainer.saveCmIntoMerkleTree(tree,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedData = "\n\f\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    IncrementalMerkleVoucherCapsule voucherCapsule = actualSaveCmIntoMerkleTreeResult.toVoucher().getVoucherCapsule();
    assertArrayEquals(expectedData, voucherCapsule.getData());
    byte[] expectedData2 = "\n\f\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    IncrementalMerkleTreeCapsule treeCapsule = actualSaveCmIntoMerkleTreeResult.getTreeCapsule();
    IncrementalMerkleVoucherCapsule voucherCapsule2 = treeCapsule.toMerkleTreeContainer()
        .toVoucher()
        .getVoucherCapsule();
    assertArrayEquals(expectedData2, voucherCapsule2.getData());
    byte[] expectedData3 = "\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData3, treeCapsule.getData());
    byte[] expectedData4 = "\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData4, voucherCapsule.getTree().getData());
    byte[] expectedData5 = "\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData5, voucherCapsule2.getTree().getData());
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    assertArrayEquals(new byte[]{}, cursor.getData());
    assertArrayEquals(new byte[]{}, voucherCapsule2.getCursor().getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = cursor.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        toMerkleTreeContainerResult.getRootArray());
  }

  /**
   * Test {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}.
   * <ul>
   *   <li>Then return TreeCapsule Parents size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "IncrementalMerkleTreeContainer MerkleContainer.saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])"})
  public void testSaveCmIntoMerkleTree_thenReturnTreeCapsuleParentsSizeIsOne()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    MerkleContainer merkleContainer = new MerkleContainer();

    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    PedersenHash parents = PedersenHash.getDefaultInstance();
    treeCapsule.addParents(parents);
    IncrementalMerkleTreeContainer tree = new IncrementalMerkleTreeContainer(treeCapsule);

    // Act
    IncrementalMerkleTreeContainer actualSaveCmIntoMerkleTreeResult = merkleContainer.saveCmIntoMerkleTree(tree,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    IncrementalMerkleTreeCapsule treeCapsule2 = actualSaveCmIntoMerkleTreeResult.getTreeCapsule();
    List<PedersenHash> parents2 = treeCapsule2.getParents();
    assertEquals(1, parents2.size());
    IncrementalMerkleTree instance = treeCapsule2.getInstance();
    assertEquals(1, instance.getParentsCount());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    IncrementalMerkleVoucherCapsule voucherCapsule = actualSaveCmIntoMerkleTreeResult.toVoucher().getVoucherCapsule();
    assertTrue(voucherCapsule.getFilled().isEmpty());
    assertSame(parents, parents2.get(0));
    assertArrayEquals(new byte[]{'\n', '\n', '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 26, 0},
        treeCapsule2.getData());
    assertArrayEquals(new byte[]{'\n', 14, '\n', '\n', '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 26, 0},
        voucherCapsule.getData());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MerkleContainer}
   *   <li>{@link MerkleContainer#getIncrementalMerkleTreeStore()}
   *   <li>{@link MerkleContainer#getMerkleTreeIndexStore()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MerkleContainer.<init>()",
      "IncrementalMerkleTreeStore MerkleContainer.getIncrementalMerkleTreeStore()",
      "TreeBlockIndexStore MerkleContainer.getMerkleTreeIndexStore()",
      "void MerkleContainer.setIncrementalMerkleTreeStore(IncrementalMerkleTreeStore)",
      "void MerkleContainer.setMerkleTreeIndexStore(TreeBlockIndexStore)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    MerkleContainer actualMerkleContainer = new MerkleContainer();
    IncrementalMerkleTreeStore actualIncrementalMerkleTreeStore = actualMerkleContainer.getIncrementalMerkleTreeStore();

    // Assert
    assertNull(actualIncrementalMerkleTreeStore);
    assertNull(actualMerkleContainer.getMerkleTreeIndexStore());
  }
}
