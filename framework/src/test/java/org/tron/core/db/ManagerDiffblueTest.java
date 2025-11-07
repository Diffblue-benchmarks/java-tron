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
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.tron.common.utils.ForkController;
import org.tron.common.utils.Pair;
import org.tron.common.utils.Sha256Hash;
import org.tron.consensus.Consensus;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.db2.core.Chainbase;
import org.tron.core.db.accountstate.TrieService;
import org.tron.core.db.accountstate.callback.AccountStateCallBack;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.exception.NonCommonBlockException;
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
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class ManagerDiffblueTest {
  @Mock
  private AccountStateCallBack accountStateCallBack;

  @Mock
  private ChainBaseManager chainBaseManager;

  @Mock
  private Consensus consensus;

  @Mock
  private KhaosDatabase khaosDatabase;

  @InjectMocks
  private Manager manager;

  @Mock
  private MortgageService mortgageService;

  @Mock
  private RevokingDatabase revokingDatabase;

  @Mock
  private RewardViCalService rewardViCalService;

  @Mock
  private TransactionCache transactionCache;

  @Mock
  private TrieService trieService;

  /**
   * Method under test: {@link Manager#getWitnessStore()}
   */
  @Test
  public void testGetWitnessStore() {
    // Arrange
    when(chainBaseManager.getWitnessStore()).thenReturn(null);

    // Act
    WitnessStore actualWitnessStore = manager.getWitnessStore();

    // Assert
    verify(chainBaseManager).getWitnessStore();
    assertNull(actualWitnessStore);
  }

  /**
   * Method under test: {@link Manager#getWitnessStore()}
   */
  @Test
  public void testGetWitnessStore2() {
    // Arrange
    when(chainBaseManager.getWitnessStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getWitnessStore());
    verify(chainBaseManager).getWitnessStore();
  }

  /**
   * Method under test: {@link Manager#getDynamicPropertiesStore()}
   */
  @Test
  public void testGetDynamicPropertiesStore() {
    // Arrange
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(null);

    // Act
    DynamicPropertiesStore actualDynamicPropertiesStore = manager.getDynamicPropertiesStore();

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    assertNull(actualDynamicPropertiesStore);
  }

  /**
   * Method under test: {@link Manager#getDynamicPropertiesStore()}
   */
  @Test
  public void testGetDynamicPropertiesStore2() {
    // Arrange
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getDynamicPropertiesStore());
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Method under test: {@link Manager#getDelegationStore()}
   */
  @Test
  public void testGetDelegationStore() {
    // Arrange
    when(chainBaseManager.getDelegationStore()).thenReturn(null);

    // Act
    DelegationStore actualDelegationStore = manager.getDelegationStore();

    // Assert
    verify(chainBaseManager).getDelegationStore();
    assertNull(actualDelegationStore);
  }

  /**
   * Method under test: {@link Manager#getDelegationStore()}
   */
  @Test
  public void testGetDelegationStore2() {
    // Arrange
    when(chainBaseManager.getDelegationStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getDelegationStore());
    verify(chainBaseManager).getDelegationStore();
  }

  /**
   * Method under test: {@link Manager#getMerkleTreeStore()}
   */
  @Test
  public void testGetMerkleTreeStore() {
    // Arrange
    when(chainBaseManager.getMerkleTreeStore()).thenReturn(null);

    // Act
    IncrementalMerkleTreeStore actualMerkleTreeStore = manager.getMerkleTreeStore();

    // Assert
    verify(chainBaseManager).getMerkleTreeStore();
    assertNull(actualMerkleTreeStore);
  }

  /**
   * Method under test: {@link Manager#getMerkleTreeStore()}
   */
  @Test
  public void testGetMerkleTreeStore2() {
    // Arrange
    when(chainBaseManager.getMerkleTreeStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getMerkleTreeStore());
    verify(chainBaseManager).getMerkleTreeStore();
  }

  /**
   * Method under test: {@link Manager#getWitnessScheduleStore()}
   */
  @Test
  public void testGetWitnessScheduleStore() {
    // Arrange
    when(chainBaseManager.getWitnessScheduleStore()).thenReturn(null);

    // Act
    WitnessScheduleStore actualWitnessScheduleStore = manager.getWitnessScheduleStore();

    // Assert
    verify(chainBaseManager).getWitnessScheduleStore();
    assertNull(actualWitnessScheduleStore);
  }

  /**
   * Method under test: {@link Manager#getWitnessScheduleStore()}
   */
  @Test
  public void testGetWitnessScheduleStore2() {
    // Arrange
    when(chainBaseManager.getWitnessScheduleStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getWitnessScheduleStore());
    verify(chainBaseManager).getWitnessScheduleStore();
  }

  /**
   * Method under test: {@link Manager#getDelegatedResourceStore()}
   */
  @Test
  public void testGetDelegatedResourceStore() {
    // Arrange
    when(chainBaseManager.getDelegatedResourceStore()).thenReturn(null);

    // Act
    DelegatedResourceStore actualDelegatedResourceStore = manager.getDelegatedResourceStore();

    // Assert
    verify(chainBaseManager).getDelegatedResourceStore();
    assertNull(actualDelegatedResourceStore);
  }

  /**
   * Method under test: {@link Manager#getDelegatedResourceStore()}
   */
  @Test
  public void testGetDelegatedResourceStore2() {
    // Arrange
    when(chainBaseManager.getDelegatedResourceStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getDelegatedResourceStore());
    verify(chainBaseManager).getDelegatedResourceStore();
  }

  /**
   * Method under test: {@link Manager#getDelegatedResourceAccountIndexStore()}
   */
  @Test
  public void testGetDelegatedResourceAccountIndexStore() {
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
   * Method under test: {@link Manager#getDelegatedResourceAccountIndexStore()}
   */
  @Test
  public void testGetDelegatedResourceAccountIndexStore2() {
    // Arrange
    when(chainBaseManager.getDelegatedResourceAccountIndexStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getDelegatedResourceAccountIndexStore());
    verify(chainBaseManager).getDelegatedResourceAccountIndexStore();
  }

  /**
   * Method under test: {@link Manager#getCodeStore()}
   */
  @Test
  public void testGetCodeStore() {
    // Arrange
    when(chainBaseManager.getCodeStore()).thenReturn(null);

    // Act
    CodeStore actualCodeStore = manager.getCodeStore();

    // Assert
    verify(chainBaseManager).getCodeStore();
    assertNull(actualCodeStore);
  }

  /**
   * Method under test: {@link Manager#getCodeStore()}
   */
  @Test
  public void testGetCodeStore2() {
    // Arrange
    when(chainBaseManager.getCodeStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getCodeStore());
    verify(chainBaseManager).getCodeStore();
  }

  /**
   * Method under test: {@link Manager#getContractStore()}
   */
  @Test
  public void testGetContractStore() {
    // Arrange
    when(chainBaseManager.getContractStore()).thenReturn(null);

    // Act
    ContractStore actualContractStore = manager.getContractStore();

    // Assert
    verify(chainBaseManager).getContractStore();
    assertNull(actualContractStore);
  }

  /**
   * Method under test: {@link Manager#getContractStore()}
   */
  @Test
  public void testGetContractStore2() {
    // Arrange
    when(chainBaseManager.getContractStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getContractStore());
    verify(chainBaseManager).getContractStore();
  }

  /**
   * Method under test: {@link Manager#getVotesStore()}
   */
  @Test
  public void testGetVotesStore() {
    // Arrange
    when(chainBaseManager.getVotesStore()).thenReturn(null);

    // Act
    VotesStore actualVotesStore = manager.getVotesStore();

    // Assert
    verify(chainBaseManager).getVotesStore();
    assertNull(actualVotesStore);
  }

  /**
   * Method under test: {@link Manager#getVotesStore()}
   */
  @Test
  public void testGetVotesStore2() {
    // Arrange
    when(chainBaseManager.getVotesStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getVotesStore());
    verify(chainBaseManager).getVotesStore();
  }

  /**
   * Method under test: {@link Manager#getProposalStore()}
   */
  @Test
  public void testGetProposalStore() {
    // Arrange
    when(chainBaseManager.getProposalStore()).thenReturn(null);

    // Act
    ProposalStore actualProposalStore = manager.getProposalStore();

    // Assert
    verify(chainBaseManager).getProposalStore();
    assertNull(actualProposalStore);
  }

  /**
   * Method under test: {@link Manager#getProposalStore()}
   */
  @Test
  public void testGetProposalStore2() {
    // Arrange
    when(chainBaseManager.getProposalStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getProposalStore());
    verify(chainBaseManager).getProposalStore();
  }

  /**
   * Method under test: {@link Manager#getExchangeStore()}
   */
  @Test
  public void testGetExchangeStore() {
    // Arrange
    when(chainBaseManager.getExchangeStore()).thenReturn(null);

    // Act
    ExchangeStore actualExchangeStore = manager.getExchangeStore();

    // Assert
    verify(chainBaseManager).getExchangeStore();
    assertNull(actualExchangeStore);
  }

  /**
   * Method under test: {@link Manager#getExchangeStore()}
   */
  @Test
  public void testGetExchangeStore2() {
    // Arrange
    when(chainBaseManager.getExchangeStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getExchangeStore());
    verify(chainBaseManager).getExchangeStore();
  }

  /**
   * Method under test: {@link Manager#getExchangeV2Store()}
   */
  @Test
  public void testGetExchangeV2Store() {
    // Arrange
    when(chainBaseManager.getExchangeV2Store()).thenReturn(null);

    // Act
    ExchangeV2Store actualExchangeV2Store = manager.getExchangeV2Store();

    // Assert
    verify(chainBaseManager).getExchangeV2Store();
    assertNull(actualExchangeV2Store);
  }

  /**
   * Method under test: {@link Manager#getExchangeV2Store()}
   */
  @Test
  public void testGetExchangeV2Store2() {
    // Arrange
    when(chainBaseManager.getExchangeV2Store()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getExchangeV2Store());
    verify(chainBaseManager).getExchangeV2Store();
  }

  /**
   * Method under test: {@link Manager#getStorageRowStore()}
   */
  @Test
  public void testGetStorageRowStore() {
    // Arrange
    when(chainBaseManager.getStorageRowStore()).thenReturn(null);

    // Act
    StorageRowStore actualStorageRowStore = manager.getStorageRowStore();

    // Assert
    verify(chainBaseManager).getStorageRowStore();
    assertNull(actualStorageRowStore);
  }

  /**
   * Method under test: {@link Manager#getStorageRowStore()}
   */
  @Test
  public void testGetStorageRowStore2() {
    // Arrange
    when(chainBaseManager.getStorageRowStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getStorageRowStore());
    verify(chainBaseManager).getStorageRowStore();
  }

  /**
   * Method under test: {@link Manager#getBlockIndexStore()}
   */
  @Test
  public void testGetBlockIndexStore() {
    // Arrange
    when(chainBaseManager.getBlockIndexStore()).thenReturn(null);

    // Act
    BlockIndexStore actualBlockIndexStore = manager.getBlockIndexStore();

    // Assert
    verify(chainBaseManager).getBlockIndexStore();
    assertNull(actualBlockIndexStore);
  }

  /**
   * Method under test: {@link Manager#getBlockIndexStore()}
   */
  @Test
  public void testGetBlockIndexStore2() {
    // Arrange
    when(chainBaseManager.getBlockIndexStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getBlockIndexStore());
    verify(chainBaseManager).getBlockIndexStore();
  }

  /**
   * Method under test: {@link Manager#init()}
   */
  @Test
  public void testInit() {
    // Arrange
    when(chainBaseManager.getAccountAssetStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.init());
    verify(chainBaseManager).getAccountAssetStore();
  }

  /**
   * Method under test: {@link Manager#initGenesis()}
   */
  @Test
  public void testInitGenesis() {
    // Arrange
    Manager manager = new Manager();
    ReflectionTestUtils.setField(manager, "trieService", mock(TrieService.class));
    ReflectionTestUtils.setField(manager, "transactionCache", mock(TransactionCache.class));
    ReflectionTestUtils.setField(manager, "rewardViCalService", mock(RewardViCalService.class));
    ReflectionTestUtils.setField(manager, "revokingStore", mock(RevokingDatabase.class));
    ReflectionTestUtils.setField(manager, "mortgageService", mock(MortgageService.class));
    ReflectionTestUtils.setField(manager, "khaosDb", mock(KhaosDatabase.class));
    ReflectionTestUtils.setField(manager, "consensus", mock(Consensus.class));
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(true);
    when(chainBaseManager.getGenesisBlock()).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
    doNothing().when(chainBaseManager).initGenesis();
    ReflectionTestUtils.setField(manager, "chainBaseManager", chainBaseManager);
    ReflectionTestUtils.setField(manager, "accountStateCallBack", mock(AccountStateCallBack.class));

    // Act
    manager.initGenesis();

    // Assert
    verify(chainBaseManager).containBlock(isA(Sha256Hash.class));
    verify(chainBaseManager).getGenesisBlock();
    verify(chainBaseManager).initGenesis();
  }

  /**
   * Method under test: {@link Manager#initGenesis()}
   */
  @Test
  public void testInitGenesis2() {
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
      ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
      when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(false);
      when(chainBaseManager.hasBlocks()).thenReturn(true);
      when(chainBaseManager.getGenesisBlock()).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
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
    }
  }

  /**
   * Method under test: {@link Manager#initGenesis()}
   */
  @Test
  public void testInitGenesis3() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {
      // Arrange
      Runtime runtime = mock(Runtime.class);
      doThrow(new IllegalArgumentException("ECKey")).when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      Manager manager = new Manager();
      ReflectionTestUtils.setField(manager, "trieService", mock(TrieService.class));
      ReflectionTestUtils.setField(manager, "transactionCache", mock(TransactionCache.class));
      ReflectionTestUtils.setField(manager, "rewardViCalService", mock(RewardViCalService.class));
      ReflectionTestUtils.setField(manager, "revokingStore", mock(RevokingDatabase.class));
      ReflectionTestUtils.setField(manager, "mortgageService", mock(MortgageService.class));
      ReflectionTestUtils.setField(manager, "khaosDb", mock(KhaosDatabase.class));
      ReflectionTestUtils.setField(manager, "consensus", mock(Consensus.class));
      ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
      when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(false);
      when(chainBaseManager.hasBlocks()).thenReturn(true);
      when(chainBaseManager.getGenesisBlock()).thenReturn(new BlockCapsule(Protocol.Block.getDefaultInstance()));
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
    }
  }

  /**
   * Method under test: {@link Manager#initGenesis()}
   */
  @Test
  public void testInitGenesis4() {
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
      when(blockCapsule.getBlockId()).thenReturn(new BlockCapsule.BlockId());
      ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
      when(chainBaseManager.containBlock(Mockito.<Sha256Hash>any())).thenReturn(false);
      when(chainBaseManager.hasBlocks()).thenReturn(true);
      when(chainBaseManager.getGenesisBlock()).thenReturn(blockCapsule);
      doNothing().when(chainBaseManager).initGenesis();
      ReflectionTestUtils.setField(manager, "chainBaseManager", chainBaseManager);
      ReflectionTestUtils.setField(manager, "accountStateCallBack", mock(AccountStateCallBack.class));

      // Act
      manager.initGenesis();

      // Assert that nothing has changed
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
   * Method under test: {@link Manager#initGenesis()}
   */
  @Test
  public void testInitGenesis5() {
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
      when(blockCapsule.getBlockId()).thenReturn(new BlockCapsule.BlockId());
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
   * Method under test: {@link Manager#initGenesis()}
   */
  @Test
  public void testInitGenesis6() {
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
      when(blockCapsule.getBlockId()).thenReturn(mock(BlockCapsule.BlockId.class));
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
   * Method under test: {@link Manager#getAccountStore()}
   */
  @Test
  public void testGetAccountStore() {
    // Arrange
    when(chainBaseManager.getAccountStore()).thenReturn(null);

    // Act
    AccountStore actualAccountStore = manager.getAccountStore();

    // Assert
    verify(chainBaseManager).getAccountStore();
    assertNull(actualAccountStore);
  }

  /**
   * Method under test: {@link Manager#getAccountStore()}
   */
  @Test
  public void testGetAccountStore2() {
    // Arrange
    when(chainBaseManager.getAccountStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getAccountStore());
    verify(chainBaseManager).getAccountStore();
  }

  /**
   * Method under test: {@link Manager#getAccountAssetStore()}
   */
  @Test
  public void testGetAccountAssetStore() {
    // Arrange
    when(chainBaseManager.getAccountAssetStore()).thenReturn(null);

    // Act
    AccountAssetStore actualAccountAssetStore = manager.getAccountAssetStore();

    // Assert
    verify(chainBaseManager).getAccountAssetStore();
    assertNull(actualAccountAssetStore);
  }

  /**
   * Method under test: {@link Manager#getAccountAssetStore()}
   */
  @Test
  public void testGetAccountAssetStore2() {
    // Arrange
    when(chainBaseManager.getAccountAssetStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getAccountAssetStore());
    verify(chainBaseManager).getAccountAssetStore();
  }

  /**
   * Method under test: {@link Manager#getAccountIndexStore()}
   */
  @Test
  public void testGetAccountIndexStore() {
    // Arrange
    when(chainBaseManager.getAccountIndexStore()).thenReturn(null);

    // Act
    AccountIndexStore actualAccountIndexStore = manager.getAccountIndexStore();

    // Assert
    verify(chainBaseManager).getAccountIndexStore();
    assertNull(actualAccountIndexStore);
  }

  /**
   * Method under test: {@link Manager#getAccountIndexStore()}
   */
  @Test
  public void testGetAccountIndexStore2() {
    // Arrange
    when(chainBaseManager.getAccountIndexStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getAccountIndexStore());
    verify(chainBaseManager).getAccountIndexStore();
  }

  /**
   * Method under test: {@link Manager#eraseBlock()}
   */
  @Test
  public void testEraseBlock() {
    // Arrange
    Manager manager = new Manager();
    ReflectionTestUtils.setField(manager, "trieService", mock(TrieService.class));
    ReflectionTestUtils.setField(manager, "transactionCache", mock(TransactionCache.class));
    ReflectionTestUtils.setField(manager, "rewardViCalService", mock(RewardViCalService.class));
    ReflectionTestUtils.setField(manager, "revokingStore", mock(RevokingDatabase.class));
    ReflectionTestUtils.setField(manager, "mortgageService", mock(MortgageService.class));
    ReflectionTestUtils.setField(manager, "khaosDb", mock(KhaosDatabase.class));
    ReflectionTestUtils.setField(manager, "consensus", mock(Consensus.class));
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new IllegalArgumentException("foo"));
    ReflectionTestUtils.setField(manager, "chainBaseManager", chainBaseManager);
    ReflectionTestUtils.setField(manager, "accountStateCallBack", mock(AccountStateCallBack.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.eraseBlock());
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Method under test: {@link Manager#eraseBlock()}
   */
  @Test
  public void testEraseBlock2() throws BadItemException, ItemNotFoundException {
    // Arrange
    Manager manager = new Manager();
    ReflectionTestUtils.setField(manager, "trieService", mock(TrieService.class));
    ReflectionTestUtils.setField(manager, "transactionCache", mock(TransactionCache.class));
    ReflectionTestUtils.setField(manager, "rewardViCalService", mock(RewardViCalService.class));
    ReflectionTestUtils.setField(manager, "revokingStore", mock(RevokingDatabase.class));
    ReflectionTestUtils.setField(manager, "mortgageService", mock(MortgageService.class));
    ReflectionTestUtils.setField(manager, "khaosDb", mock(KhaosDatabase.class));
    ReflectionTestUtils.setField(manager, "consensus", mock(Consensus.class));
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderHash()).thenReturn(null);
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any()))
        .thenThrow(new ItemNotFoundException("An error occurred"));
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    ReflectionTestUtils.setField(manager, "chainBaseManager", chainBaseManager);
    ReflectionTestUtils.setField(manager, "accountStateCallBack", mock(AccountStateCallBack.class));

    // Act
    manager.eraseBlock();

    // Assert
    verify(chainBaseManager).getBlockById(isNull());
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderHash();
  }

  /**
   * Method under test:
   * {@link Manager#getBlockChainHashesOnFork(BlockCapsule.BlockId)}
   */
  @Test
  public void testGetBlockChainHashesOnFork() throws NonCommonBlockException {
    // Arrange
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getBlockChainHashesOnFork(new BlockCapsule.BlockId()));
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Method under test:
   * {@link Manager#getBlockChainHashesOnFork(BlockCapsule.BlockId)}
   */
  @Test
  public void testGetBlockChainHashesOnFork2() throws NonCommonBlockException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderHash()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    LinkedList<KhaosDatabase.KhaosBlock> khaosBlockList = new LinkedList<>();
    when(khaosDatabase.getBranch(Mockito.<Sha256Hash>any(), Mockito.<Sha256Hash>any()))
        .thenReturn(new Pair<>(khaosBlockList, new LinkedList<>()));

    // Act
    LinkedList<BlockCapsule.BlockId> actualBlockChainHashesOnFork = manager
        .getBlockChainHashesOnFork(new BlockCapsule.BlockId());

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(khaosDatabase).getBranch((Sha256Hash) isNull(), isA(Sha256Hash.class));
    verify(dynamicPropertiesStore).getLatestBlockHeaderHash();
    assertTrue(actualBlockChainHashesOnFork.isEmpty());
  }

  /**
   * Method under test:
   * {@link Manager#getBlockChainHashesOnFork(BlockCapsule.BlockId)}
   */
  @Test
  public void testGetBlockChainHashesOnFork3() throws NonCommonBlockException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderHash()).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(khaosDatabase.getBranch(Mockito.<Sha256Hash>any(), Mockito.<Sha256Hash>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getBlockChainHashesOnFork(new BlockCapsule.BlockId()));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(khaosDatabase).getBranch((Sha256Hash) isNull(), isA(Sha256Hash.class));
    verify(dynamicPropertiesStore).getLatestBlockHeaderHash();
  }

  /**
   * Method under test: {@link Manager#getTransactionStore()}
   */
  @Test
  public void testGetTransactionStore() {
    // Arrange
    when(chainBaseManager.getTransactionStore()).thenReturn(null);

    // Act
    TransactionStore actualTransactionStore = manager.getTransactionStore();

    // Assert
    verify(chainBaseManager).getTransactionStore();
    assertNull(actualTransactionStore);
  }

  /**
   * Method under test: {@link Manager#getTransactionStore()}
   */
  @Test
  public void testGetTransactionStore2() {
    // Arrange
    when(chainBaseManager.getTransactionStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getTransactionStore());
    verify(chainBaseManager).getTransactionStore();
  }

  /**
   * Method under test: {@link Manager#getTransactionHistoryStore()}
   */
  @Test
  public void testGetTransactionHistoryStore() {
    // Arrange
    when(chainBaseManager.getTransactionHistoryStore()).thenReturn(null);

    // Act
    TransactionHistoryStore actualTransactionHistoryStore = manager.getTransactionHistoryStore();

    // Assert
    verify(chainBaseManager).getTransactionHistoryStore();
    assertNull(actualTransactionHistoryStore);
  }

  /**
   * Method under test: {@link Manager#getTransactionHistoryStore()}
   */
  @Test
  public void testGetTransactionHistoryStore2() {
    // Arrange
    when(chainBaseManager.getTransactionHistoryStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getTransactionHistoryStore());
    verify(chainBaseManager).getTransactionHistoryStore();
  }

  /**
   * Method under test: {@link Manager#getTransactionRetStore()}
   */
  @Test
  public void testGetTransactionRetStore() {
    // Arrange
    when(chainBaseManager.getTransactionRetStore()).thenReturn(null);

    // Act
    TransactionRetStore actualTransactionRetStore = manager.getTransactionRetStore();

    // Assert
    verify(chainBaseManager).getTransactionRetStore();
    assertNull(actualTransactionRetStore);
  }

  /**
   * Method under test: {@link Manager#getTransactionRetStore()}
   */
  @Test
  public void testGetTransactionRetStore2() {
    // Arrange
    when(chainBaseManager.getTransactionRetStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getTransactionRetStore());
    verify(chainBaseManager).getTransactionRetStore();
  }

  /**
   * Method under test: {@link Manager#getBlockStore()}
   */
  @Test
  public void testGetBlockStore() {
    // Arrange
    when(chainBaseManager.getBlockStore()).thenReturn(null);

    // Act
    BlockStore actualBlockStore = manager.getBlockStore();

    // Assert
    verify(chainBaseManager).getBlockStore();
    assertNull(actualBlockStore);
  }

  /**
   * Method under test: {@link Manager#getBlockStore()}
   */
  @Test
  public void testGetBlockStore2() {
    // Arrange
    when(chainBaseManager.getBlockStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getBlockStore());
    verify(chainBaseManager).getBlockStore();
  }

  /**
   * Method under test: {@link Manager#updateFork(BlockCapsule)}
   */
  @Test
  public void testUpdateFork() {
    // Arrange
    ForkController forkController = mock(ForkController.class);
    doNothing().when(forkController).update(Mockito.<BlockCapsule>any());
    when(chainBaseManager.getForkController()).thenReturn(forkController);

    // Act
    manager.updateFork(new BlockCapsule(Protocol.Block.getDefaultInstance()));

    // Assert that nothing has changed
    verify(forkController).update(isA(BlockCapsule.class));
    verify(chainBaseManager).getForkController();
  }

  /**
   * Method under test: {@link Manager#updateFork(BlockCapsule)}
   */
  @Test
  public void testUpdateFork2() {
    // Arrange
    ForkController forkController = mock(ForkController.class);
    doNothing().when(forkController).update(Mockito.<BlockCapsule>any());
    when(chainBaseManager.getForkController()).thenReturn(forkController);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getInstance()).thenReturn(Protocol.Block.getDefaultInstance());

    // Act
    manager.updateFork(block);

    // Assert that nothing has changed
    verify(forkController).update(isA(BlockCapsule.class));
    verify(chainBaseManager).getForkController();
    verify(block).getInstance();
  }

  /**
   * Method under test: {@link Manager#updateFork(BlockCapsule)}
   */
  @Test
  public void testUpdateFork3() throws UnsupportedEncodingException {
    // Arrange
    ForkController forkController = mock(ForkController.class);
    doNothing().when(forkController).update(Mockito.<BlockCapsule>any());
    when(chainBaseManager.getForkController()).thenReturn(forkController);

    BlockCapsule block = new BlockCapsule(Protocol.Block.getDefaultInstance());
    block.setAccountStateRoot("AXAXAXAX".getBytes("UTF-8"));

    // Act
    manager.updateFork(block);

    // Assert that nothing has changed
    verify(forkController).update(isA(BlockCapsule.class));
    verify(chainBaseManager).getForkController();
  }

  /**
   * Method under test: {@link Manager#getAssetIssueStore()}
   */
  @Test
  public void testGetAssetIssueStore() {
    // Arrange
    when(chainBaseManager.getAssetIssueStore()).thenReturn(null);

    // Act
    AssetIssueStore actualAssetIssueStore = manager.getAssetIssueStore();

    // Assert
    verify(chainBaseManager).getAssetIssueStore();
    assertNull(actualAssetIssueStore);
  }

  /**
   * Method under test: {@link Manager#getAssetIssueStore()}
   */
  @Test
  public void testGetAssetIssueStore2() {
    // Arrange
    when(chainBaseManager.getAssetIssueStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getAssetIssueStore());
    verify(chainBaseManager).getAssetIssueStore();
  }

  /**
   * Method under test: {@link Manager#getAssetIssueV2Store()}
   */
  @Test
  public void testGetAssetIssueV2Store() {
    // Arrange
    when(chainBaseManager.getAssetIssueV2Store()).thenReturn(null);

    // Act
    AssetIssueV2Store actualAssetIssueV2Store = manager.getAssetIssueV2Store();

    // Assert
    verify(chainBaseManager).getAssetIssueV2Store();
    assertNull(actualAssetIssueV2Store);
  }

  /**
   * Method under test: {@link Manager#getAssetIssueV2Store()}
   */
  @Test
  public void testGetAssetIssueV2Store2() {
    // Arrange
    when(chainBaseManager.getAssetIssueV2Store()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getAssetIssueV2Store());
    verify(chainBaseManager).getAssetIssueV2Store();
  }

  /**
   * Method under test: {@link Manager#getAccountIdIndexStore()}
   */
  @Test
  public void testGetAccountIdIndexStore() {
    // Arrange
    when(chainBaseManager.getAccountIdIndexStore()).thenReturn(null);

    // Act
    AccountIdIndexStore actualAccountIdIndexStore = manager.getAccountIdIndexStore();

    // Assert
    verify(chainBaseManager).getAccountIdIndexStore();
    assertNull(actualAccountIdIndexStore);
  }

  /**
   * Method under test: {@link Manager#getAccountIdIndexStore()}
   */
  @Test
  public void testGetAccountIdIndexStore2() {
    // Arrange
    when(chainBaseManager.getAccountIdIndexStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getAccountIdIndexStore());
    verify(chainBaseManager).getAccountIdIndexStore();
  }

  /**
   * Method under test: {@link Manager#getNullifierStore()}
   */
  @Test
  public void testGetNullifierStore() {
    // Arrange
    when(chainBaseManager.getNullifierStore()).thenReturn(null);

    // Act
    NullifierStore actualNullifierStore = manager.getNullifierStore();

    // Assert
    verify(chainBaseManager).getNullifierStore();
    assertNull(actualNullifierStore);
  }

  /**
   * Method under test: {@link Manager#getNullifierStore()}
   */
  @Test
  public void testGetNullifierStore2() {
    // Arrange
    when(chainBaseManager.getNullifierStore()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.getNullifierStore());
    verify(chainBaseManager).getNullifierStore();
  }

  /**
   * Method under test: {@link Manager#resetCursor()}
   */
  @Test
  public void testResetCursor() {
    // Arrange
    doNothing().when(revokingDatabase).setCursor(Mockito.<Chainbase.Cursor>any(), anyLong());

    // Act
    manager.resetCursor();

    // Assert
    verify(revokingDatabase).setCursor(eq(Chainbase.Cursor.HEAD), eq(0L));
  }

  /**
   * Method under test: {@link Manager#resetCursor()}
   */
  @Test
  public void testResetCursor2() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(revokingDatabase)
        .setCursor(Mockito.<Chainbase.Cursor>any(), anyLong());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.resetCursor());
    verify(revokingDatabase).setCursor(eq(Chainbase.Cursor.HEAD), eq(0L));
  }

  /**
   * Method under test: {@link Manager#close()}
   */
  @Test
  public void testClose() {
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
   * Method under test: {@link Manager#close()}
   */
  @Test
  public void testClose2() {
    // Arrange
    doNothing().when(chainBaseManager).shutdown();
    doThrow(new IllegalArgumentException("repush")).when(revokingDatabase).shutdown();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.close());
    verify(chainBaseManager).shutdown();
    verify(revokingDatabase).shutdown();
  }

  /**
   * Method under test: {@link Manager#close()}
   */
  @Test
  public void testClose3() {
    // Arrange
    doThrow(new IllegalArgumentException("repush")).when(chainBaseManager).shutdown();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> manager.close());
    verify(chainBaseManager).shutdown();
  }
}
