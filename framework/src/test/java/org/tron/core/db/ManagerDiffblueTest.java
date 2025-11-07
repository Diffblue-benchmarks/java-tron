package org.tron.core.db;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.util.ReflectionTestUtils;
import org.tron.common.utils.Pair;
import org.tron.common.utils.Sha256Hash;
import org.tron.consensus.Consensus;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.db.KhaosDatabase.KhaosBlock;
import org.tron.core.db.accountstate.TrieService;
import org.tron.core.db.accountstate.callback.AccountStateCallBack;
import org.tron.core.db2.core.Chainbase;
import org.tron.core.db2.core.Chainbase.Cursor;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.exception.NonCommonBlockException;
import org.tron.core.exception.RevokingStoreIllegalStateException;
import org.tron.core.service.MortgageService;
import org.tron.core.service.RewardViCalService;
import org.tron.core.store.AccountAssetStore;
import org.tron.core.store.AccountIdIndexStore;
import org.tron.core.store.AccountIndexStore;
import org.tron.core.store.AccountStore;
import org.tron.core.store.AssetIssueStore;
import org.tron.core.store.AssetIssueV2Store;
import org.tron.core.store.CodeStore;
import org.tron.core.store.ContractStore;
import org.tron.core.store.DelegatedResourceAccountIndexStore;
import org.tron.core.store.DelegatedResourceStore;
import org.tron.core.store.DelegationStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.ExchangeStore;
import org.tron.core.store.ExchangeV2Store;
import org.tron.core.store.IncrementalMerkleTreeStore;
import org.tron.core.store.NullifierStore;
import org.tron.core.store.ProposalStore;
import org.tron.core.store.StorageRowStore;
import org.tron.core.store.TransactionHistoryStore;
import org.tron.core.store.TransactionRetStore;
import org.tron.core.store.VotesStore;
import org.tron.core.store.WitnessScheduleStore;
import org.tron.core.store.WitnessStore;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ManagerDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  @InjectMocks
  private Manager manager;

  @Mock
  private RevokingDatabase revokingDatabase;

  @Mock
  private KhaosDatabase khaosDatabase;

  /**
   * Test {@link Manager#getWitnessStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getWitnessStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessStore Manager.getWitnessStore()"})
  public void testGetWitnessStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getWitnessStore()).thenReturn(null);

    // Act
    WitnessStore actualWitnessStore = manager.getWitnessStore();

    // Assert
    verify(chainBaseManager).getWitnessStore();
    assertNull(actualWitnessStore);
  }

  /**
   * Test {@link Manager#getWitnessStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getWitnessStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessStore Manager.getWitnessStore()"})
  public void testGetWitnessStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getWitnessStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getWitnessStore());
    verify(chainBaseManager).getWitnessStore();
  }

  /**
   * Test {@link Manager#getDynamicPropertiesStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getDynamicPropertiesStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DynamicPropertiesStore Manager.getDynamicPropertiesStore()"})
  public void testGetDynamicPropertiesStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);

    // Act
    DynamicPropertiesStore actualDynamicPropertiesStore = manager.getDynamicPropertiesStore();

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    assertNull(actualDynamicPropertiesStore);
  }

  /**
   * Test {@link Manager#getDynamicPropertiesStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getDynamicPropertiesStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DynamicPropertiesStore Manager.getDynamicPropertiesStore()"})
  public void testGetDynamicPropertiesStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getDynamicPropertiesStore());
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link Manager#getDelegationStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getDelegationStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegationStore Manager.getDelegationStore()"})
  public void testGetDelegationStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getDelegationStore()).thenReturn(null);

    // Act
    DelegationStore actualDelegationStore = manager.getDelegationStore();

    // Assert
    verify(chainBaseManager).getDelegationStore();
    assertNull(actualDelegationStore);
  }

  /**
   * Test {@link Manager#getDelegationStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getDelegationStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegationStore Manager.getDelegationStore()"})
  public void testGetDelegationStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getDelegationStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getDelegationStore());
    verify(chainBaseManager).getDelegationStore();
  }

  /**
   * Test {@link Manager#getMerkleTreeStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getMerkleTreeStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeStore Manager.getMerkleTreeStore()"})
  public void testGetMerkleTreeStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getMerkleTreeStore()).thenReturn(null);

    // Act
    IncrementalMerkleTreeStore actualMerkleTreeStore = manager.getMerkleTreeStore();

    // Assert
    verify(chainBaseManager).getMerkleTreeStore();
    assertNull(actualMerkleTreeStore);
  }

  /**
   * Test {@link Manager#getMerkleTreeStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getMerkleTreeStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IncrementalMerkleTreeStore Manager.getMerkleTreeStore()"})
  public void testGetMerkleTreeStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getMerkleTreeStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getMerkleTreeStore());
    verify(chainBaseManager).getMerkleTreeStore();
  }

  /**
   * Test {@link Manager#getWitnessScheduleStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getWitnessScheduleStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessScheduleStore Manager.getWitnessScheduleStore()"})
  public void testGetWitnessScheduleStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getWitnessScheduleStore()).thenReturn(null);

    // Act
    WitnessScheduleStore actualWitnessScheduleStore = manager.getWitnessScheduleStore();

    // Assert
    verify(chainBaseManager).getWitnessScheduleStore();
    assertNull(actualWitnessScheduleStore);
  }

  /**
   * Test {@link Manager#getWitnessScheduleStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getWitnessScheduleStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WitnessScheduleStore Manager.getWitnessScheduleStore()"})
  public void testGetWitnessScheduleStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getWitnessScheduleStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getWitnessScheduleStore());
    verify(chainBaseManager).getWitnessScheduleStore();
  }

  /**
   * Test {@link Manager#getDelegatedResourceStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getDelegatedResourceStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegatedResourceStore Manager.getDelegatedResourceStore()"})
  public void testGetDelegatedResourceStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getDelegatedResourceStore()).thenReturn(null);

    // Act
    DelegatedResourceStore actualDelegatedResourceStore = manager.getDelegatedResourceStore();

    // Assert
    verify(chainBaseManager).getDelegatedResourceStore();
    assertNull(actualDelegatedResourceStore);
  }

  /**
   * Test {@link Manager#getDelegatedResourceStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getDelegatedResourceStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegatedResourceStore Manager.getDelegatedResourceStore()"})
  public void testGetDelegatedResourceStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getDelegatedResourceStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getDelegatedResourceStore());
    verify(chainBaseManager).getDelegatedResourceStore();
  }

  /**
   * Test {@link Manager#getDelegatedResourceAccountIndexStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getDelegatedResourceAccountIndexStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegatedResourceAccountIndexStore Manager.getDelegatedResourceAccountIndexStore()"})
  public void testGetDelegatedResourceAccountIndexStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getDelegatedResourceAccountIndexStore()).thenReturn(null);

    // Act
    DelegatedResourceAccountIndexStore actualDelegatedResourceAccountIndexStore = manager
        .getDelegatedResourceAccountIndexStore();

    // Assert
    verify(chainBaseManager).getDelegatedResourceAccountIndexStore();
    assertNull(actualDelegatedResourceAccountIndexStore);
  }

  /**
   * Test {@link Manager#getDelegatedResourceAccountIndexStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getDelegatedResourceAccountIndexStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegatedResourceAccountIndexStore Manager.getDelegatedResourceAccountIndexStore()"})
  public void testGetDelegatedResourceAccountIndexStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getDelegatedResourceAccountIndexStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getDelegatedResourceAccountIndexStore());
    verify(chainBaseManager).getDelegatedResourceAccountIndexStore();
  }

  /**
   * Test {@link Manager#getCodeStore()}.
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getCodeStore()} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getCodeStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CodeStore Manager.getCodeStore()"})
  public void testGetCodeStore_givenChainBaseManagerGetCodeStoreReturnNull_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getCodeStore()).thenReturn(null);

    // Act
    CodeStore actualCodeStore = manager.getCodeStore();

    // Assert
    verify(chainBaseManager).getCodeStore();
    assertNull(actualCodeStore);
  }

  /**
   * Test {@link Manager#getCodeStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getCodeStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CodeStore Manager.getCodeStore()"})
  public void testGetCodeStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getCodeStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getCodeStore());
    verify(chainBaseManager).getCodeStore();
  }

  /**
   * Test {@link Manager#getContractStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getContractStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractStore Manager.getContractStore()"})
  public void testGetContractStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getContractStore()).thenReturn(null);

    // Act
    ContractStore actualContractStore = manager.getContractStore();

    // Assert
    verify(chainBaseManager).getContractStore();
    assertNull(actualContractStore);
  }

  /**
   * Test {@link Manager#getContractStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getContractStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ContractStore Manager.getContractStore()"})
  public void testGetContractStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getContractStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getContractStore());
    verify(chainBaseManager).getContractStore();
  }

  /**
   * Test {@link Manager#getVotesStore()}.
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getVotesStore()} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getVotesStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VotesStore Manager.getVotesStore()"})
  public void testGetVotesStore_givenChainBaseManagerGetVotesStoreReturnNull_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getVotesStore()).thenReturn(null);

    // Act
    VotesStore actualVotesStore = manager.getVotesStore();

    // Assert
    verify(chainBaseManager).getVotesStore();
    assertNull(actualVotesStore);
  }

  /**
   * Test {@link Manager#getVotesStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getVotesStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VotesStore Manager.getVotesStore()"})
  public void testGetVotesStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getVotesStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getVotesStore());
    verify(chainBaseManager).getVotesStore();
  }

  /**
   * Test {@link Manager#getProposalStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getProposalStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProposalStore Manager.getProposalStore()"})
  public void testGetProposalStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getProposalStore()).thenReturn(null);

    // Act
    ProposalStore actualProposalStore = manager.getProposalStore();

    // Assert
    verify(chainBaseManager).getProposalStore();
    assertNull(actualProposalStore);
  }

  /**
   * Test {@link Manager#getProposalStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getProposalStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProposalStore Manager.getProposalStore()"})
  public void testGetProposalStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getProposalStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getProposalStore());
    verify(chainBaseManager).getProposalStore();
  }

  /**
   * Test {@link Manager#getExchangeStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getExchangeStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeStore Manager.getExchangeStore()"})
  public void testGetExchangeStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getExchangeStore()).thenReturn(null);

    // Act
    ExchangeStore actualExchangeStore = manager.getExchangeStore();

    // Assert
    verify(chainBaseManager).getExchangeStore();
    assertNull(actualExchangeStore);
  }

  /**
   * Test {@link Manager#getExchangeStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getExchangeStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeStore Manager.getExchangeStore()"})
  public void testGetExchangeStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getExchangeStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getExchangeStore());
    verify(chainBaseManager).getExchangeStore();
  }

  /**
   * Test {@link Manager#getExchangeV2Store()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getExchangeV2Store()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeV2Store Manager.getExchangeV2Store()"})
  public void testGetExchangeV2Store_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getExchangeV2Store()).thenReturn(null);

    // Act
    ExchangeV2Store actualExchangeV2Store = manager.getExchangeV2Store();

    // Assert
    verify(chainBaseManager).getExchangeV2Store();
    assertNull(actualExchangeV2Store);
  }

  /**
   * Test {@link Manager#getExchangeV2Store()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getExchangeV2Store()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExchangeV2Store Manager.getExchangeV2Store()"})
  public void testGetExchangeV2Store_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getExchangeV2Store()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getExchangeV2Store());
    verify(chainBaseManager).getExchangeV2Store();
  }

  /**
   * Test {@link Manager#getStorageRowStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getStorageRowStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StorageRowStore Manager.getStorageRowStore()"})
  public void testGetStorageRowStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getStorageRowStore()).thenReturn(null);

    // Act
    StorageRowStore actualStorageRowStore = manager.getStorageRowStore();

    // Assert
    verify(chainBaseManager).getStorageRowStore();
    assertNull(actualStorageRowStore);
  }

  /**
   * Test {@link Manager#getStorageRowStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getStorageRowStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StorageRowStore Manager.getStorageRowStore()"})
  public void testGetStorageRowStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getStorageRowStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getStorageRowStore());
    verify(chainBaseManager).getStorageRowStore();
  }

  /**
   * Test {@link Manager#getBlockIndexStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getBlockIndexStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockIndexStore Manager.getBlockIndexStore()"})
  public void testGetBlockIndexStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getBlockIndexStore()).thenReturn(null);

    // Act
    BlockIndexStore actualBlockIndexStore = manager.getBlockIndexStore();

    // Assert
    verify(chainBaseManager).getBlockIndexStore();
    assertNull(actualBlockIndexStore);
  }

  /**
   * Test {@link Manager#getBlockIndexStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getBlockIndexStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockIndexStore Manager.getBlockIndexStore()"})
  public void testGetBlockIndexStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getBlockIndexStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getBlockIndexStore());
    verify(chainBaseManager).getBlockIndexStore();
  }

  /**
   * Test {@link Manager#init()}.
   * <p>
   * Method under test: {@link Manager#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.init()"})
  public void testInit() {
    // Arrange
    when(chainBaseManager.getAccountAssetStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.init());
    verify(chainBaseManager).getAccountAssetStore();
  }

  /**
   * Test {@link Manager#initGenesis()}.
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#containBlock(Sha256Hash)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#initGenesis()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.initGenesis()"})
  public void testInitGenesis_givenChainBaseManagerContainBlockReturnTrue() {
    // Arrange
    Manager manager = new Manager();
    ReflectionTestUtils.setField(manager, "trieService", mock(TrieService.class));
    ReflectionTestUtils.setField(manager, "transactionCache", mock(TransactionCache.class));
    ReflectionTestUtils.setField(manager, "rewardViCalService", mock(RewardViCalService.class));
    ReflectionTestUtils.setField(manager, "revokingStore", mock(RevokingDatabase.class));
    ReflectionTestUtils.setField(manager, "mortgageService", mock(MortgageService.class));
    ReflectionTestUtils.setField(manager, "khaosDb", mock(KhaosDatabase.class));
    ReflectionTestUtils.setField(manager, "consensus", mock(Consensus.class));
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getBlockId()).thenReturn(new BlockId());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(true);
    when(chainBaseManager.getGenesisBlock()).thenReturn(blockCapsule);
    doNothing().when(chainBaseManager).initGenesis();
    ReflectionTestUtils.setField(manager, "chainBaseManager", chainBaseManager);
    ReflectionTestUtils.setField(manager, "accountStateCallBack", mock(AccountStateCallBack.class));

    // Act
    manager.initGenesis();

    // Assert
    verify(chainBaseManager).containBlock(isA(Sha256Hash.class));
    verify(chainBaseManager).getGenesisBlock();
    verify(chainBaseManager).initGenesis();
    verify(blockCapsule, atLeast(1)).getBlockId();
  }

  /**
   * Test {@link Manager#initGenesis()}.
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#containBlock(Sha256Hash)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#initGenesis()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.initGenesis()"})
  public void testInitGenesis_givenChainBaseManagerContainBlockReturnTrue2() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {

      // Arrange
      mockRuntime.when(Runtime::getRuntime).thenReturn(mock(Runtime.class));
      Manager manager = new Manager();
      ReflectionTestUtils.setField(manager, "trieService", mock(TrieService.class));
      ReflectionTestUtils.setField(manager, "transactionCache", mock(TransactionCache.class));
      ReflectionTestUtils.setField(manager, "rewardViCalService", mock(RewardViCalService.class));
      ReflectionTestUtils.setField(manager, "revokingStore", mock(RevokingDatabase.class));
      ReflectionTestUtils.setField(manager, "mortgageService", mock(MortgageService.class));
      ReflectionTestUtils.setField(manager, "khaosDb", mock(KhaosDatabase.class));
      ReflectionTestUtils.setField(manager, "consensus", mock(Consensus.class));
      BlockCapsule blockCapsule = mock(BlockCapsule.class);
      when(blockCapsule.getBlockId()).thenReturn(mock(BlockId.class));
      ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
      when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(true);
      when(chainBaseManager.getGenesisBlock()).thenReturn(blockCapsule);
      doNothing().when(chainBaseManager).initGenesis();
      ReflectionTestUtils.setField(manager, "chainBaseManager", chainBaseManager);
      ReflectionTestUtils.setField(manager, "accountStateCallBack", mock(AccountStateCallBack.class));

      // Act
      manager.initGenesis();

      // Assert
      verify(chainBaseManager).containBlock(isA(Sha256Hash.class));
      verify(chainBaseManager).getGenesisBlock();
      verify(chainBaseManager).initGenesis();
      verify(blockCapsule, atLeast(1)).getBlockId();
    }
  }

  /**
   * Test {@link Manager#initGenesis()}.
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#hasBlocks()} return {@code true}.</li>
   *   <li>Then calls {@link Runtime#exit(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#initGenesis()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.initGenesis()"})
  public void testInitGenesis_givenChainBaseManagerHasBlocksReturnTrue_thenCallsExit() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {

      // Arrange
      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      Manager manager = new Manager();
      ReflectionTestUtils.setField(manager, "trieService", mock(TrieService.class));
      ReflectionTestUtils.setField(manager, "transactionCache", mock(TransactionCache.class));
      ReflectionTestUtils.setField(manager, "rewardViCalService", mock(RewardViCalService.class));
      ReflectionTestUtils.setField(manager, "revokingStore", mock(RevokingDatabase.class));
      ReflectionTestUtils.setField(manager, "mortgageService", mock(MortgageService.class));
      ReflectionTestUtils.setField(manager, "khaosDb", mock(KhaosDatabase.class));
      ReflectionTestUtils.setField(manager, "consensus", mock(Consensus.class));
      BlockCapsule blockCapsule = mock(BlockCapsule.class);
      when(blockCapsule.getBlockId()).thenReturn(new BlockId());
      ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
      when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(false);
      when(chainBaseManager.hasBlocks()).thenReturn(true);
      when(chainBaseManager.getGenesisBlock()).thenReturn(blockCapsule);
      doNothing().when(chainBaseManager).initGenesis();
      ReflectionTestUtils.setField(manager, "chainBaseManager", chainBaseManager);
      ReflectionTestUtils.setField(manager, "accountStateCallBack", mock(AccountStateCallBack.class));

      // Act
      manager.initGenesis();

      // Assert
      verify(runtime).exit(eq(1));
      mockRuntime.verify(Runtime::getRuntime);
      verify(chainBaseManager).containBlock(isA(Sha256Hash.class));
      verify(chainBaseManager).getGenesisBlock();
      verify(chainBaseManager).hasBlocks();
      verify(chainBaseManager).initGenesis();
      verify(blockCapsule).getBlockId();
    }
  }

  /**
   * Test {@link Manager#initGenesis()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#initGenesis()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.initGenesis()"})
  public void testInitGenesis_thenThrowIllegalArgumentException() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {

      // Arrange
      Runtime runtime = mock(Runtime.class);
      doThrow(new IllegalArgumentException("Genesis block modify, please delete database directory({}) and restart."))
          .when(runtime)
          .exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      Manager manager = new Manager();
      ReflectionTestUtils.setField(manager, "trieService", mock(TrieService.class));
      ReflectionTestUtils.setField(manager, "transactionCache", mock(TransactionCache.class));
      ReflectionTestUtils.setField(manager, "rewardViCalService", mock(RewardViCalService.class));
      ReflectionTestUtils.setField(manager, "revokingStore", mock(RevokingDatabase.class));
      ReflectionTestUtils.setField(manager, "mortgageService", mock(MortgageService.class));
      ReflectionTestUtils.setField(manager, "khaosDb", mock(KhaosDatabase.class));
      ReflectionTestUtils.setField(manager, "consensus", mock(Consensus.class));
      BlockCapsule blockCapsule = mock(BlockCapsule.class);
      when(blockCapsule.getBlockId()).thenReturn(new BlockId());
      ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
      when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(false);
      when(chainBaseManager.hasBlocks()).thenReturn(true);
      when(chainBaseManager.getGenesisBlock()).thenReturn(blockCapsule);
      doNothing().when(chainBaseManager).initGenesis();
      ReflectionTestUtils.setField(manager, "chainBaseManager", chainBaseManager);
      ReflectionTestUtils.setField(manager, "accountStateCallBack", mock(AccountStateCallBack.class));

      // Act and Assert
      assertThrows(IllegalArgumentException.class, () -> manager.initGenesis());
      verify(runtime).exit(eq(1));
      mockRuntime.verify(Runtime::getRuntime);
      verify(chainBaseManager).containBlock(isA(Sha256Hash.class));
      verify(chainBaseManager).getGenesisBlock();
      verify(chainBaseManager).hasBlocks();
      verify(chainBaseManager).initGenesis();
      verify(blockCapsule).getBlockId();
    }
  }

  /**
   * Test {@link Manager#getAccountStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getAccountStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStore Manager.getAccountStore()"})
  public void testGetAccountStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getAccountStore()).thenReturn(null);

    // Act
    AccountStore actualAccountStore = manager.getAccountStore();

    // Assert
    verify(chainBaseManager).getAccountStore();
    assertNull(actualAccountStore);
  }

  /**
   * Test {@link Manager#getAccountStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getAccountStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStore Manager.getAccountStore()"})
  public void testGetAccountStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getAccountStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getAccountStore());
    verify(chainBaseManager).getAccountStore();
  }

  /**
   * Test {@link Manager#getAccountAssetStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getAccountAssetStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountAssetStore Manager.getAccountAssetStore()"})
  public void testGetAccountAssetStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getAccountAssetStore()).thenReturn(null);

    // Act
    AccountAssetStore actualAccountAssetStore = manager.getAccountAssetStore();

    // Assert
    verify(chainBaseManager).getAccountAssetStore();
    assertNull(actualAccountAssetStore);
  }

  /**
   * Test {@link Manager#getAccountAssetStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getAccountAssetStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountAssetStore Manager.getAccountAssetStore()"})
  public void testGetAccountAssetStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getAccountAssetStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getAccountAssetStore());
    verify(chainBaseManager).getAccountAssetStore();
  }

  /**
   * Test {@link Manager#getAccountIndexStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getAccountIndexStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIndexStore Manager.getAccountIndexStore()"})
  public void testGetAccountIndexStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getAccountIndexStore()).thenReturn(null);

    // Act
    AccountIndexStore actualAccountIndexStore = manager.getAccountIndexStore();

    // Assert
    verify(chainBaseManager).getAccountIndexStore();
    assertNull(actualAccountIndexStore);
  }

  /**
   * Test {@link Manager#getAccountIndexStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getAccountIndexStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIndexStore Manager.getAccountIndexStore()"})
  public void testGetAccountIndexStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getAccountIndexStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getAccountIndexStore());
    verify(chainBaseManager).getAccountIndexStore();
  }

  /**
   * Test {@link Manager#eraseBlock()}.
   * <p>
   * Method under test: {@link Manager#eraseBlock()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.eraseBlock()"})
  public void testEraseBlock() {
    // Arrange
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.eraseBlock());
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link Manager#eraseBlock()}.
   * <p>
   * Method under test: {@link Manager#eraseBlock()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.eraseBlock()"})
  public void testEraseBlock2() throws BadItemException, ItemNotFoundException, RevokingStoreIllegalStateException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderHash()).thenReturn(null);
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any())).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(khaosDatabase.pop()).thenReturn(true);
    doThrow(new IllegalArgumentException("Start to erase block: {}.")).when(revokingDatabase).fastPop();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.eraseBlock());
    verify(chainBaseManager).getBlockById(isNull());
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(khaosDatabase).pop();
    verify(revokingDatabase).fastPop();
    verify(dynamicPropertiesStore).getLatestBlockHeaderHash();
  }

  /**
   * Test {@link Manager#eraseBlock()}.
   * <ul>
   *   <li>Then calls {@link BlockCapsule#getTransactions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#eraseBlock()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.eraseBlock()"})
  public void testEraseBlock_thenCallsGetTransactions()
      throws BadItemException, ItemNotFoundException, RevokingStoreIllegalStateException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderHash()).thenReturn(null);
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getTransactions()).thenReturn(new ArrayList<>());
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any())).thenReturn(blockCapsule);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(khaosDatabase.pop()).thenReturn(true);
    doNothing().when(revokingDatabase).fastPop();

    // Act
    manager.eraseBlock();

    // Assert
    verify(chainBaseManager).getBlockById(isNull());
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(blockCapsule, atLeast(1)).getTransactions();
    verify(khaosDatabase).pop();
    verify(revokingDatabase).fastPop();
    verify(dynamicPropertiesStore).getLatestBlockHeaderHash();
  }

  /**
   * Test {@link Manager#getBlockChainHashesOnFork(BlockId)}.
   * <p>
   * Method under test: {@link Manager#getBlockChainHashesOnFork(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedList Manager.getBlockChainHashesOnFork(BlockId)"})
  public void testGetBlockChainHashesOnFork() throws NonCommonBlockException {
    // Arrange
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getBlockChainHashesOnFork(new BlockId()));
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link Manager#getBlockChainHashesOnFork(BlockId)}.
   * <p>
   * Method under test: {@link Manager#getBlockChainHashesOnFork(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedList Manager.getBlockChainHashesOnFork(BlockId)"})
  public void testGetBlockChainHashesOnFork2() throws NonCommonBlockException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderHash()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(khaosDatabase.getBranch(Mockito.<Sha256Hash>any(), Mockito.<Sha256Hash>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getBlockChainHashesOnFork(new BlockId()));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(khaosDatabase).getBranch((Sha256Hash) isNull(), isA(Sha256Hash.class));
    verify(dynamicPropertiesStore).getLatestBlockHeaderHash();
  }

  /**
   * Test {@link Manager#getBlockChainHashesOnFork(BlockId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getBlockChainHashesOnFork(BlockId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedList Manager.getBlockChainHashesOnFork(BlockId)"})
  public void testGetBlockChainHashesOnFork_thenReturnEmpty() throws NonCommonBlockException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderHash()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    LinkedList<KhaosBlock> khaosBlockList = new LinkedList<>();
    when(khaosDatabase.getBranch(Mockito.<Sha256Hash>any(), Mockito.<Sha256Hash>any()))
        .thenReturn(new Pair<>(khaosBlockList, new LinkedList<>()));

    // Act
    LinkedList<BlockId> actualBlockChainHashesOnFork = manager.getBlockChainHashesOnFork(new BlockId());

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(khaosDatabase).getBranch((Sha256Hash) isNull(), isA(Sha256Hash.class));
    verify(dynamicPropertiesStore).getLatestBlockHeaderHash();
    assertTrue(actualBlockChainHashesOnFork.isEmpty());
  }

  /**
   * Test {@link Manager#getTransactionStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getTransactionStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionStore Manager.getTransactionStore()"})
  public void testGetTransactionStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getTransactionStore()).thenReturn(null);

    // Act
    TransactionStore actualTransactionStore = manager.getTransactionStore();

    // Assert
    verify(chainBaseManager).getTransactionStore();
    assertNull(actualTransactionStore);
  }

  /**
   * Test {@link Manager#getTransactionStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getTransactionStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionStore Manager.getTransactionStore()"})
  public void testGetTransactionStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getTransactionStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getTransactionStore());
    verify(chainBaseManager).getTransactionStore();
  }

  /**
   * Test {@link Manager#getTransactionHistoryStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getTransactionHistoryStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionHistoryStore Manager.getTransactionHistoryStore()"})
  public void testGetTransactionHistoryStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getTransactionHistoryStore()).thenReturn(null);

    // Act
    TransactionHistoryStore actualTransactionHistoryStore = manager.getTransactionHistoryStore();

    // Assert
    verify(chainBaseManager).getTransactionHistoryStore();
    assertNull(actualTransactionHistoryStore);
  }

  /**
   * Test {@link Manager#getTransactionHistoryStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getTransactionHistoryStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionHistoryStore Manager.getTransactionHistoryStore()"})
  public void testGetTransactionHistoryStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getTransactionHistoryStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getTransactionHistoryStore());
    verify(chainBaseManager).getTransactionHistoryStore();
  }

  /**
   * Test {@link Manager#getTransactionRetStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getTransactionRetStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionRetStore Manager.getTransactionRetStore()"})
  public void testGetTransactionRetStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getTransactionRetStore()).thenReturn(null);

    // Act
    TransactionRetStore actualTransactionRetStore = manager.getTransactionRetStore();

    // Assert
    verify(chainBaseManager).getTransactionRetStore();
    assertNull(actualTransactionRetStore);
  }

  /**
   * Test {@link Manager#getTransactionRetStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getTransactionRetStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionRetStore Manager.getTransactionRetStore()"})
  public void testGetTransactionRetStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getTransactionRetStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getTransactionRetStore());
    verify(chainBaseManager).getTransactionRetStore();
  }

  /**
   * Test {@link Manager#getBlockStore()}.
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getBlockStore()} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getBlockStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockStore Manager.getBlockStore()"})
  public void testGetBlockStore_givenChainBaseManagerGetBlockStoreReturnNull_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getBlockStore()).thenReturn(null);

    // Act
    BlockStore actualBlockStore = manager.getBlockStore();

    // Assert
    verify(chainBaseManager).getBlockStore();
    assertNull(actualBlockStore);
  }

  /**
   * Test {@link Manager#getBlockStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getBlockStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BlockStore Manager.getBlockStore()"})
  public void testGetBlockStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getBlockStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getBlockStore());
    verify(chainBaseManager).getBlockStore();
  }

  /**
   * Test {@link Manager#getAssetIssueStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getAssetIssueStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueStore Manager.getAssetIssueStore()"})
  public void testGetAssetIssueStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getAssetIssueStore()).thenReturn(null);

    // Act
    AssetIssueStore actualAssetIssueStore = manager.getAssetIssueStore();

    // Assert
    verify(chainBaseManager).getAssetIssueStore();
    assertNull(actualAssetIssueStore);
  }

  /**
   * Test {@link Manager#getAssetIssueStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getAssetIssueStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueStore Manager.getAssetIssueStore()"})
  public void testGetAssetIssueStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getAssetIssueStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getAssetIssueStore());
    verify(chainBaseManager).getAssetIssueStore();
  }

  /**
   * Test {@link Manager#getAssetIssueV2Store()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getAssetIssueV2Store()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueV2Store Manager.getAssetIssueV2Store()"})
  public void testGetAssetIssueV2Store_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(null);

    // Act
    AssetIssueV2Store actualAssetIssueV2Store = manager.getAssetIssueV2Store();

    // Assert
    verify(chainBaseManager).getAssetIssueV2Store();
    assertNull(actualAssetIssueV2Store);
  }

  /**
   * Test {@link Manager#getAssetIssueV2Store()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getAssetIssueV2Store()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueV2Store Manager.getAssetIssueV2Store()"})
  public void testGetAssetIssueV2Store_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getAssetIssueV2Store()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getAssetIssueV2Store());
    verify(chainBaseManager).getAssetIssueV2Store();
  }

  /**
   * Test {@link Manager#getAccountIdIndexStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getAccountIdIndexStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdIndexStore Manager.getAccountIdIndexStore()"})
  public void testGetAccountIdIndexStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getAccountIdIndexStore()).thenReturn(null);

    // Act
    AccountIdIndexStore actualAccountIdIndexStore = manager.getAccountIdIndexStore();

    // Assert
    verify(chainBaseManager).getAccountIdIndexStore();
    assertNull(actualAccountIdIndexStore);
  }

  /**
   * Test {@link Manager#getAccountIdIndexStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getAccountIdIndexStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountIdIndexStore Manager.getAccountIdIndexStore()"})
  public void testGetAccountIdIndexStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getAccountIdIndexStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getAccountIdIndexStore());
    verify(chainBaseManager).getAccountIdIndexStore();
  }

  /**
   * Test {@link Manager#getNullifierStore()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getNullifierStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NullifierStore Manager.getNullifierStore()"})
  public void testGetNullifierStore_thenReturnNull() {
    // Arrange
    when(chainBaseManager.getNullifierStore()).thenReturn(null);

    // Act
    NullifierStore actualNullifierStore = manager.getNullifierStore();

    // Assert
    verify(chainBaseManager).getNullifierStore();
    assertNull(actualNullifierStore);
  }

  /**
   * Test {@link Manager#getNullifierStore()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#getNullifierStore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NullifierStore Manager.getNullifierStore()"})
  public void testGetNullifierStore_thenThrowIllegalArgumentException() {
    // Arrange
    when(chainBaseManager.getNullifierStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getNullifierStore());
    verify(chainBaseManager).getNullifierStore();
  }

  /**
   * Test {@link Manager#resetCursor()}.
   * <ul>
   *   <li>Given {@link RevokingDatabase} {@link RevokingDatabase#setCursor(Cursor, long)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#resetCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.resetCursor()"})
  public void testResetCursor_givenRevokingDatabaseSetCursorDoesNothing() {
    // Arrange
    doNothing().when(revokingDatabase).setCursor(Mockito.<Cursor>any(), anyLong());

    // Act
    manager.resetCursor();

    // Assert
    verify(revokingDatabase).setCursor(eq(Cursor.HEAD), eq(0L));
  }

  /**
   * Test {@link Manager#resetCursor()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#resetCursor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.resetCursor()"})
  public void testResetCursor_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(revokingDatabase).setCursor(Mockito.<Cursor>any(), anyLong());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.resetCursor());
    verify(revokingDatabase).setCursor(eq(Cursor.HEAD), eq(0L));
  }

  /**
   * Test {@link Manager#close()}.
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#shutdown()} throw {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code repush}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.close()"})
  public void testClose_givenChainBaseManagerShutdownThrowIllegalArgumentExceptionWithRepush() {
    // Arrange
    doThrow(new IllegalArgumentException("repush")).when(chainBaseManager).shutdown();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.close());
    verify(chainBaseManager).shutdown();
  }

  /**
   * Test {@link Manager#close()}.
   * <ul>
   *   <li>Given {@link RevokingDatabase} {@link RevokingDatabase#shutdown()} does nothing.</li>
   *   <li>Then calls {@link RevokingDatabase#shutdown()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.close()"})
  public void testClose_givenRevokingDatabaseShutdownDoesNothing_thenCallsShutdown() {
    // Arrange
    doNothing().when(chainBaseManager).shutdown();
    doNothing().when(revokingDatabase).shutdown();

    // Act
    manager.close();

    // Assert
    verify(chainBaseManager).shutdown();
    verify(revokingDatabase).shutdown();
  }

  /**
   * Test {@link Manager#close()}.
   * <ul>
   *   <li>Given {@link RevokingDatabase} {@link RevokingDatabase#shutdown()} throw {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code repush}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Manager#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Manager.close()"})
  public void testClose_givenRevokingDatabaseShutdownThrowIllegalArgumentExceptionWithRepush() {
    // Arrange
    doNothing().when(chainBaseManager).shutdown();
    doThrow(new IllegalArgumentException("repush")).when(revokingDatabase).shutdown();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.close());
    verify(chainBaseManager).shutdown();
    verify(revokingDatabase).shutdown();
  }
}
