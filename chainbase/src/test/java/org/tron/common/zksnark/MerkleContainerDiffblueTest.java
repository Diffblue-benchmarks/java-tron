package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.IncrementalMerkleTreeCapsule;
import org.tron.core.capsule.IncrementalMerkleVoucherCapsule;
import org.tron.core.exception.ZksnarkException;
import org.tron.core.store.IncrementalMerkleTreeStore;
import org.tron.core.store.TreeBlockIndexStore;
import org.tron.protos.contract.ShieldContract;
import org.tron.protos.contract.ShieldContract.IncrementalMerkleTree;
import org.tron.protos.contract.ShieldContract.PedersenHash;

public class MerkleContainerDiffblueTest {
  /**
   * Test {@link MerkleContainer#createInstance(IncrementalMerkleTreeStore, TreeBlockIndexStore)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return IncrementalMerkleTreeStore is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#createInstance(IncrementalMerkleTreeStore,
   * TreeBlockIndexStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MerkleContainer MerkleContainer.createInstance(IncrementalMerkleTreeStore, TreeBlockIndexStore)"
  })
  public void testCreateInstance_whenNull_thenReturnIncrementalMerkleTreeStoreIsNull() {
    // Arrange and Act
    MerkleContainer actualCreateInstanceResult = MerkleContainer.createInstance(null, null);

    // Assert
    assertNull(actualCreateInstanceResult.getIncrementalMerkleTreeStore());
    assertNull(actualCreateInstanceResult.getMerkleTreeIndexStore());
  }

  /**
   * Test {@link MerkleContainer#getCurrentMerkle()}.
   *
   * <p>Method under test: {@link MerkleContainer#getCurrentMerkle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IncrementalMerkleTreeContainer MerkleContainer.getCurrentMerkle()"})
  public void testGetCurrentMerkle() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any()))
        .thenReturn(new IncrementalMerkleTreeCapsule());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    IncrementalMerkleTreeContainer actualCurrentMerkle = merkleContainer.getCurrentMerkle();

    // Assert
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    IncrementalMerkleTreeCapsule treeCapsule = actualCurrentMerkle.getTreeCapsule();
    assertArrayEquals(new byte[] {}, treeCapsule.getData());
    IncrementalMerkleVoucherCapsule voucherCapsule =
        actualCurrentMerkle.toVoucher().getVoucherCapsule();
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    assertArrayEquals(new byte[] {}, cursor.getData());
    IncrementalMerkleTreeCapsule tree = voucherCapsule.getTree();
    assertArrayEquals(new byte[] {}, tree.getData());
    assertArrayEquals(new byte[] {'\n', 0}, voucherCapsule.getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult =
        treeCapsule.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {'\n', 0},
        toMerkleTreeContainerResult.toVoucher().getVoucherCapsule().getData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualCurrentMerkle.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult2 = cursor.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult2.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult3 = tree.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult3.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualCurrentMerkle.getRootArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getRootArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult2.getRootArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult3.getRootArray());
  }

  /**
   * Test {@link MerkleContainer#getCurrentMerkle()}.
   *
   * <p>Method under test: {@link MerkleContainer#getCurrentMerkle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IncrementalMerkleTreeContainer MerkleContainer.getCurrentMerkle()"})
  public void testGetCurrentMerkle2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule =
        mock(IncrementalMerkleTreeCapsule.class);
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(incrementalMerkleTreeContainer);

    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any()))
        .thenReturn(incrementalMerkleTreeCapsule);

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
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeStore} {@link IncrementalMerkleTreeStore#get(byte[])}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#getCurrentMerkle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IncrementalMerkleTreeContainer MerkleContainer.getCurrentMerkle()"})
  public void testGetCurrentMerkle_givenIncrementalMerkleTreeStoreGetReturnNull()
      throws ZksnarkException {
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
    assertArrayEquals(new byte[] {}, treeCapsule.getData());
    IncrementalMerkleVoucherCapsule voucherCapsule =
        actualCurrentMerkle.toVoucher().getVoucherCapsule();
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    assertArrayEquals(new byte[] {}, cursor.getData());
    IncrementalMerkleTreeCapsule tree = voucherCapsule.getTree();
    assertArrayEquals(new byte[] {}, tree.getData());
    assertArrayEquals(new byte[] {'\n', 0}, voucherCapsule.getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult =
        treeCapsule.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {'\n', 0},
        toMerkleTreeContainerResult.toVoucher().getVoucherCapsule().getData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualCurrentMerkle.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult2 = cursor.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult2.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult3 = tree.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult3.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualCurrentMerkle.getRootArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getRootArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult2.getRootArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult3.getRootArray());
  }

  /**
   * Test {@link MerkleContainer#setCurrentMerkle(IncrementalMerkleTreeContainer)}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeStore} {@link IncrementalMerkleTreeStore#put(byte[],
   *       ProtoCapsule)} does nothing.
   *   <li>Then calls {@link IncrementalMerkleTreeStore#put(byte[], ProtoCapsule)}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#setCurrentMerkle(IncrementalMerkleTreeContainer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerkleContainer.setCurrentMerkle(IncrementalMerkleTreeContainer)"})
  public void testSetCurrentMerkle_givenIncrementalMerkleTreeStorePutDoesNothing_thenCallsPut() {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    doNothing()
        .when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    merkleContainer.setCurrentMerkle(
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));

    // Assert
    verify(incrementalMerkleTreeStore)
        .put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
  }

  /**
   * Test {@link MerkleContainer#getBestMerkle()}.
   *
   * <p>Method under test: {@link MerkleContainer#getBestMerkle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IncrementalMerkleTreeContainer MerkleContainer.getBestMerkle()"})
  public void testGetBestMerkle() throws ZksnarkException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any()))
        .thenReturn(new IncrementalMerkleTreeCapsule());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    IncrementalMerkleTreeContainer actualBestMerkle = merkleContainer.getBestMerkle();

    // Assert
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    IncrementalMerkleTreeCapsule treeCapsule = actualBestMerkle.getTreeCapsule();
    assertArrayEquals(new byte[] {}, treeCapsule.getData());
    IncrementalMerkleVoucherCapsule voucherCapsule =
        actualBestMerkle.toVoucher().getVoucherCapsule();
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    assertArrayEquals(new byte[] {}, cursor.getData());
    IncrementalMerkleTreeCapsule tree = voucherCapsule.getTree();
    assertArrayEquals(new byte[] {}, tree.getData());
    assertArrayEquals(new byte[] {'\n', 0}, voucherCapsule.getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult =
        treeCapsule.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {'\n', 0},
        toMerkleTreeContainerResult.toVoucher().getVoucherCapsule().getData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualBestMerkle.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult2 = cursor.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult2.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult3 = tree.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult3.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualBestMerkle.getRootArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getRootArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult2.getRootArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult3.getRootArray());
  }

  /**
   * Test {@link MerkleContainer#getBestMerkle()}.
   *
   * <p>Method under test: {@link MerkleContainer#getBestMerkle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IncrementalMerkleTreeContainer MerkleContainer.getBestMerkle()"})
  public void testGetBestMerkle2() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule =
        mock(IncrementalMerkleTreeCapsule.class);
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(incrementalMerkleTreeContainer);

    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any()))
        .thenReturn(incrementalMerkleTreeCapsule);

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
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeStore} {@link IncrementalMerkleTreeStore#get(byte[])}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#getBestMerkle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IncrementalMerkleTreeContainer MerkleContainer.getBestMerkle()"})
  public void testGetBestMerkle_givenIncrementalMerkleTreeStoreGetReturnNull()
      throws ZksnarkException {
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
    assertArrayEquals(new byte[] {}, treeCapsule.getData());
    IncrementalMerkleVoucherCapsule voucherCapsule =
        actualBestMerkle.toVoucher().getVoucherCapsule();
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    assertArrayEquals(new byte[] {}, cursor.getData());
    IncrementalMerkleTreeCapsule tree = voucherCapsule.getTree();
    assertArrayEquals(new byte[] {}, tree.getData());
    assertArrayEquals(new byte[] {'\n', 0}, voucherCapsule.getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult =
        treeCapsule.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {'\n', 0},
        toMerkleTreeContainerResult.toVoucher().getVoucherCapsule().getData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualBestMerkle.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult2 = cursor.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult2.getMerkleTreeKey());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult3 = tree.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult3.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualBestMerkle.getRootArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getRootArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult2.getRootArray());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult3.getRootArray());
  }

  /**
   * Test {@link MerkleContainer#resetCurrentMerkleTree()}.
   *
   * <p>Method under test: {@link MerkleContainer#resetCurrentMerkleTree()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerkleContainer.resetCurrentMerkleTree()"})
  public void testResetCurrentMerkleTree() {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any()))
        .thenReturn(new IncrementalMerkleTreeCapsule());
    doNothing()
        .when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    merkleContainer.resetCurrentMerkleTree();

    // Assert
    verify(incrementalMerkleTreeStore)
        .put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
  }

  /**
   * Test {@link MerkleContainer#resetCurrentMerkleTree()}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeStore} {@link IncrementalMerkleTreeStore#get(byte[])}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#resetCurrentMerkleTree()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerkleContainer.resetCurrentMerkleTree()"})
  public void testResetCurrentMerkleTree_givenIncrementalMerkleTreeStoreGetReturnNull() {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any())).thenReturn(null);
    doNothing()
        .when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    merkleContainer.resetCurrentMerkleTree();

    // Assert
    verify(incrementalMerkleTreeStore)
        .put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
  }

  /**
   * Test {@link MerkleContainer#resetCurrentMerkleTree()}.
   *
   * <ul>
   *   <li>Then calls {@link IncrementalMerkleTreeCapsule#toMerkleTreeContainer()}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#resetCurrentMerkleTree()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerkleContainer.resetCurrentMerkleTree()"})
  public void testResetCurrentMerkleTree_thenCallsToMerkleTreeContainer() {
    // Arrange
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule =
        mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()));

    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any()))
        .thenReturn(incrementalMerkleTreeCapsule);
    doNothing()
        .when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    merkleContainer.resetCurrentMerkleTree();

    // Assert
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(incrementalMerkleTreeStore)
        .put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
  }

  /**
   * Test {@link MerkleContainer#saveCurrentMerkleTreeAsBestMerkleTree(long)}.
   *
   * <ul>
   *   <li>Then calls {@link IncrementalMerkleTreeContainer#getMerkleTreeKey()}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#saveCurrentMerkleTreeAsBestMerkleTree(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerkleContainer.saveCurrentMerkleTreeAsBestMerkleTree(long)"})
  public void testSaveCurrentMerkleTreeAsBestMerkleTree_thenCallsGetMerkleTreeKey()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        mock(IncrementalMerkleTreeContainer.class);
    when(incrementalMerkleTreeContainer.getMerkleTreeKey())
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(incrementalMerkleTreeContainer.getTreeCapsule())
        .thenReturn(new IncrementalMerkleTreeCapsule());

    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule =
        mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(incrementalMerkleTreeContainer);

    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any()))
        .thenReturn(incrementalMerkleTreeCapsule);
    doNothing()
        .when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    TreeBlockIndexStore merkleTreeIndexStore = mock(TreeBlockIndexStore.class);
    doNothing().when(merkleTreeIndexStore).put(anyLong(), Mockito.<byte[]>any());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setMerkleTreeIndexStore(merkleTreeIndexStore);
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    merkleContainer.saveCurrentMerkleTreeAsBestMerkleTree(1L);

    // Assert
    verify(incrementalMerkleTreeContainer, atLeast(1)).getMerkleTreeKey();
    verify(incrementalMerkleTreeContainer, atLeast(1)).getTreeCapsule();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(incrementalMerkleTreeStore, atLeast(1))
        .put(Mockito.<byte[]>any(), isA(IncrementalMerkleTreeCapsule.class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    verify(merkleTreeIndexStore).put(eq(1L), isA(byte[].class));
  }

  /**
   * Test {@link MerkleContainer#setBestMerkle(long, IncrementalMerkleTreeContainer)}.
   *
   * <ul>
   *   <li>Then calls {@link IncrementalMerkleTreeContainer#getMerkleTreeKey()}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#setBestMerkle(long,
   * IncrementalMerkleTreeContainer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerkleContainer.setBestMerkle(long, IncrementalMerkleTreeContainer)"})
  public void testSetBestMerkle_thenCallsGetMerkleTreeKey()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    doNothing()
        .when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    TreeBlockIndexStore merkleTreeIndexStore = mock(TreeBlockIndexStore.class);
    doNothing().when(merkleTreeIndexStore).put(anyLong(), Mockito.<byte[]>any());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setMerkleTreeIndexStore(merkleTreeIndexStore);
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    IncrementalMerkleTreeContainer treeContainer = mock(IncrementalMerkleTreeContainer.class);
    when(treeContainer.getMerkleTreeKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(treeContainer.getTreeCapsule()).thenReturn(new IncrementalMerkleTreeCapsule());

    // Act
    merkleContainer.setBestMerkle(1L, treeContainer);

    // Assert
    verify(treeContainer).getMerkleTreeKey();
    verify(treeContainer).getTreeCapsule();
    verify(incrementalMerkleTreeStore)
        .put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
    verify(merkleTreeIndexStore).put(eq(1L), isA(byte[].class));
  }

  /**
   * Test {@link MerkleContainer#merkleRootExist(byte[])}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#merkleRootExist(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MerkleContainer.merkleRootExist(byte[])"})
  public void testMerkleRootExist_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.contain(Mockito.<byte[]>any())).thenReturn(false);

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    boolean actualMerkleRootExistResult =
        merkleContainer.merkleRootExist("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(incrementalMerkleTreeStore).contain(isA(byte[].class));
    assertFalse(actualMerkleRootExistResult);
  }

  /**
   * Test {@link MerkleContainer#merkleRootExist(byte[])}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#merkleRootExist(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MerkleContainer.merkleRootExist(byte[])"})
  public void testMerkleRootExist_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.contain(Mockito.<byte[]>any())).thenReturn(true);

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    boolean actualMerkleRootExistResult =
        merkleContainer.merkleRootExist("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(incrementalMerkleTreeStore).contain(isA(byte[].class));
    assertTrue(actualMerkleRootExistResult);
  }

  /**
   * Test {@link MerkleContainer#getMerkleTree(byte[])}.
   *
   * <ul>
   *   <li>Then return {@link IncrementalMerkleTreeCapsule#IncrementalMerkleTreeCapsule()}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#getMerkleTree(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IncrementalMerkleTreeCapsule MerkleContainer.getMerkleTree(byte[])"})
  public void testGetMerkleTree_thenReturnIncrementalMerkleTreeCapsule()
      throws UnsupportedEncodingException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule = new IncrementalMerkleTreeCapsule();
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any()))
        .thenReturn(incrementalMerkleTreeCapsule);

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    IncrementalMerkleTreeCapsule actualMerkleTree =
        merkleContainer.getMerkleTree("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    assertSame(incrementalMerkleTreeCapsule, actualMerkleTree);
  }

  /**
   * Test {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}.
   *
   * <p>Method under test: {@link
   * MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IncrementalMerkleTreeContainer MerkleContainer.saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])"
  })
  public void testSaveCmIntoMerkleTree() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    MerkleContainer merkleContainer = new MerkleContainer();

    // Act
    IncrementalMerkleTreeContainer actualSaveCmIntoMerkleTreeResult =
        merkleContainer.saveCmIntoMerkleTree(
            new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule()),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedData = "\n\f\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    IncrementalMerkleVoucherCapsule voucherCapsule =
        actualSaveCmIntoMerkleTreeResult.toVoucher().getVoucherCapsule();
    assertArrayEquals(expectedData, voucherCapsule.getData());
    byte[] expectedData2 = "\n\f\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    IncrementalMerkleTreeCapsule treeCapsule = actualSaveCmIntoMerkleTreeResult.getTreeCapsule();
    IncrementalMerkleVoucherCapsule voucherCapsule2 =
        treeCapsule.toMerkleTreeContainer().toVoucher().getVoucherCapsule();
    assertArrayEquals(expectedData2, voucherCapsule2.getData());
    assertArrayEquals("\n\n\n\bAXAXAXAX".getBytes("UTF-8"), treeCapsule.getData());
    assertArrayEquals("\n\n\n\bAXAXAXAX".getBytes("UTF-8"), voucherCapsule.getTree().getData());
    assertArrayEquals("\n\n\n\bAXAXAXAX".getBytes("UTF-8"), voucherCapsule2.getTree().getData());
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    assertArrayEquals(new byte[] {}, cursor.getData());
    assertArrayEquals(new byte[] {}, voucherCapsule2.getCursor().getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = cursor.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getRootArray());
  }

  /**
   * Test {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}.
   *
   * <p>Method under test: {@link
   * MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IncrementalMerkleTreeContainer MerkleContainer.saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])"
  })
  public void testSaveCmIntoMerkleTree2() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    MerkleContainer merkleContainer = new MerkleContainer();

    IncrementalMerkleTreeContainer tree =
        new IncrementalMerkleTreeContainer(new IncrementalMerkleTreeCapsule());
    tree.append(PedersenHash.getDefaultInstance());

    // Act
    IncrementalMerkleTreeContainer actualSaveCmIntoMerkleTreeResult =
        merkleContainer.saveCmIntoMerkleTree(tree, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedData = "\n\f\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    IncrementalMerkleVoucherCapsule voucherCapsule =
        actualSaveCmIntoMerkleTreeResult.toVoucher().getVoucherCapsule();
    assertArrayEquals(expectedData, voucherCapsule.getData());
    byte[] expectedData2 = "\n\f\n\n\n\bAXAXAXAX".getBytes("UTF-8");
    IncrementalMerkleTreeCapsule treeCapsule = actualSaveCmIntoMerkleTreeResult.getTreeCapsule();
    IncrementalMerkleVoucherCapsule voucherCapsule2 =
        treeCapsule.toMerkleTreeContainer().toVoucher().getVoucherCapsule();
    assertArrayEquals(expectedData2, voucherCapsule2.getData());
    assertArrayEquals("\n\n\n\bAXAXAXAX".getBytes("UTF-8"), treeCapsule.getData());
    assertArrayEquals("\n\n\n\bAXAXAXAX".getBytes("UTF-8"), voucherCapsule.getTree().getData());
    assertArrayEquals("\n\n\n\bAXAXAXAX".getBytes("UTF-8"), voucherCapsule2.getTree().getData());
    IncrementalMerkleTreeCapsule cursor = voucherCapsule.getCursor();
    assertArrayEquals(new byte[] {}, cursor.getData());
    assertArrayEquals(new byte[] {}, voucherCapsule2.getCursor().getData());
    IncrementalMerkleTreeContainer toMerkleTreeContainerResult = cursor.toMerkleTreeContainer();
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getMerkleTreeKey());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        toMerkleTreeContainerResult.getRootArray());
  }

  /**
   * Test {@link MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}.
   *
   * <ul>
   *   <li>Then return TreeCapsule Parents size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * MerkleContainer#saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IncrementalMerkleTreeContainer MerkleContainer.saveCmIntoMerkleTree(IncrementalMerkleTreeContainer, byte[])"
  })
  public void testSaveCmIntoMerkleTree_thenReturnTreeCapsuleParentsSizeIsOne()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    MerkleContainer merkleContainer = new MerkleContainer();

    IncrementalMerkleTreeCapsule treeCapsule = new IncrementalMerkleTreeCapsule();
    PedersenHash parents = PedersenHash.getDefaultInstance();
    treeCapsule.addParents(parents);

    // Act
    IncrementalMerkleTreeContainer actualSaveCmIntoMerkleTreeResult =
        merkleContainer.saveCmIntoMerkleTree(
            new IncrementalMerkleTreeContainer(treeCapsule), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    IncrementalMerkleTreeCapsule treeCapsule2 = actualSaveCmIntoMerkleTreeResult.getTreeCapsule();
    List<PedersenHash> parents2 = treeCapsule2.getParents();
    assertEquals(1, parents2.size());
    IncrementalMerkleTree instance = treeCapsule2.getInstance();
    assertEquals(1, instance.getParentsCount());
    assertEquals(14, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    IncrementalMerkleVoucherCapsule voucherCapsule =
        actualSaveCmIntoMerkleTreeResult.toVoucher().getVoucherCapsule();
    assertTrue(voucherCapsule.getFilled().isEmpty());
    assertSame(parents, parents2.get(0));
    assertArrayEquals(
        new byte[] {'\n', '\n', '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 26, 0},
        treeCapsule2.getData());
    assertArrayEquals(
        new byte[] {
          '\n', 14, '\n', '\n', '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 26, 0
        },
        voucherCapsule.getData());
  }

  /**
   * Test {@link MerkleContainer#putMerkleTreeIntoStore(byte[], IncrementalMerkleTreeCapsule)}.
   *
   * <ul>
   *   <li>Then calls {@link IncrementalMerkleTreeStore#put(byte[], ProtoCapsule)}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#putMerkleTreeIntoStore(byte[],
   * IncrementalMerkleTreeCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MerkleContainer.putMerkleTreeIntoStore(byte[], IncrementalMerkleTreeCapsule)"
  })
  public void testPutMerkleTreeIntoStore_thenCallsPut() throws UnsupportedEncodingException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    doNothing()
        .when(incrementalMerkleTreeStore)
        .put(Mockito.<byte[]>any(), Mockito.<IncrementalMerkleTreeCapsule>any());

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);
    byte[] key = "AXAXAXAX".getBytes("UTF-8");

    // Act
    merkleContainer.putMerkleTreeIntoStore(key, new IncrementalMerkleTreeCapsule());

    // Assert
    verify(incrementalMerkleTreeStore)
        .put(isA(byte[].class), isA(IncrementalMerkleTreeCapsule.class));
  }

  /**
   * Test {@link MerkleContainer#merklePath(byte[])}.
   *
   * <p>Method under test: {@link MerkleContainer#merklePath(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MerklePath MerkleContainer.merklePath(byte[])"})
  public void testMerklePath() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    IncrementalMerkleTreeContainer incrementalMerkleTreeContainer =
        mock(IncrementalMerkleTreeContainer.class);
    ArrayList<List<Boolean>> authenticationPath = new ArrayList<>();
    MerklePath merklePath = new MerklePath(authenticationPath, new ArrayList<>());
    when(incrementalMerkleTreeContainer.path()).thenReturn(merklePath);

    IncrementalMerkleTreeCapsule incrementalMerkleTreeCapsule =
        mock(IncrementalMerkleTreeCapsule.class);
    when(incrementalMerkleTreeCapsule.toMerkleTreeContainer())
        .thenReturn(incrementalMerkleTreeContainer);

    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.get(Mockito.<byte[]>any()))
        .thenReturn(incrementalMerkleTreeCapsule);
    when(incrementalMerkleTreeStore.contain(Mockito.<byte[]>any())).thenReturn(true);

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    MerklePath actualMerklePathResult = merkleContainer.merklePath("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(incrementalMerkleTreeContainer).path();
    verify(incrementalMerkleTreeCapsule).toMerkleTreeContainer();
    verify(incrementalMerkleTreeStore).contain(isA(byte[].class));
    verify(incrementalMerkleTreeStore).get(isA(byte[].class));
    assertSame(merklePath, actualMerklePathResult);
  }

  /**
   * Test {@link MerkleContainer#merklePath(byte[])}.
   *
   * <ul>
   *   <li>Given {@link IncrementalMerkleTreeStore} {@link
   *       IncrementalMerkleTreeStore#contain(byte[])} return {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MerkleContainer#merklePath(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MerklePath MerkleContainer.merklePath(byte[])"})
  public void testMerklePath_givenIncrementalMerkleTreeStoreContainReturnFalse_thenReturnNull()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    IncrementalMerkleTreeStore incrementalMerkleTreeStore = mock(IncrementalMerkleTreeStore.class);
    when(incrementalMerkleTreeStore.contain(Mockito.<byte[]>any())).thenReturn(false);

    MerkleContainer merkleContainer = new MerkleContainer();
    merkleContainer.setIncrementalMerkleTreeStore(incrementalMerkleTreeStore);

    // Act
    MerklePath actualMerklePathResult = merkleContainer.merklePath("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(incrementalMerkleTreeStore).contain(isA(byte[].class));
    assertNull(actualMerklePathResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MerkleContainer}
   *   <li>{@link MerkleContainer#getIncrementalMerkleTreeStore()}
   *   <li>{@link MerkleContainer#getMerkleTreeIndexStore()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MerkleContainer.<init>()",
    "IncrementalMerkleTreeStore MerkleContainer.getIncrementalMerkleTreeStore()",
    "TreeBlockIndexStore MerkleContainer.getMerkleTreeIndexStore()",
    "void MerkleContainer.setIncrementalMerkleTreeStore(IncrementalMerkleTreeStore)",
    "void MerkleContainer.setMerkleTreeIndexStore(TreeBlockIndexStore)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MerkleContainer actualMerkleContainer = new MerkleContainer();
    IncrementalMerkleTreeStore actualIncrementalMerkleTreeStore =
        actualMerkleContainer.getIncrementalMerkleTreeStore();

    // Assert
    assertNull(actualIncrementalMerkleTreeStore);
    assertNull(actualMerkleContainer.getMerkleTreeIndexStore());
  }
}
