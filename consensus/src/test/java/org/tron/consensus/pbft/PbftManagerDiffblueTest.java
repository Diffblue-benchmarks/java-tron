package org.tron.consensus.pbft;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.consensus.dpos.MaintenanceManager;
import org.tron.consensus.pbft.message.PbftBaseMessage;
import org.tron.consensus.pbft.message.PbftMessage;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.store.DynamicPropertiesStore;

@RunWith(MockitoJUnitRunner.class)
public class PbftManagerDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  @InjectMocks
  private PbftManager pbftManager;

  @Mock
  private PbftMessageHandle pbftMessageHandle;

  @Mock
  private MaintenanceManager maintenanceManager;

  /**
   * Test {@link PbftManager#init()}.
   * <p>
   * Method under test: {@link PbftManager#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftManager.init()"})
  public void testInit() {
    // Arrange
    doNothing().when(maintenanceManager).setPbftManager(Mockito.<PbftManager>any());
    doNothing().when(pbftMessageHandle).setMaintenanceManager(Mockito.<MaintenanceManager>any());

    // Act
    pbftManager.init();

    // Assert
    verify(maintenanceManager).setPbftManager(isA(PbftManager.class));
    verify(pbftMessageHandle).setMaintenanceManager(isA(MaintenanceManager.class));
  }

  /**
   * Test {@link PbftManager#blockPrePrepare(BlockCapsule, long)}.
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#allowPBFT()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftManager#blockPrePrepare(BlockCapsule, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftManager.blockPrePrepare(BlockCapsule, long)"})
  public void testBlockPrePrepare_givenDynamicPropertiesStoreAllowPBFTReturnFalse() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(false);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    pbftManager.blockPrePrepare(null, 1L);

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftManager#blockPrePrepare(BlockCapsule, long)}.
   * <ul>
   *   <li>Given {@link PbftMessageHandle} {@link PbftMessageHandle#isSyncing()} return {@code true}.</li>
   *   <li>Then calls {@link PbftMessageHandle#isSyncing()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftManager#blockPrePrepare(BlockCapsule, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftManager.blockPrePrepare(BlockCapsule, long)"})
  public void testBlockPrePrepare_givenPbftMessageHandleIsSyncingReturnTrue_thenCallsIsSyncing() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(pbftMessageHandle.isSyncing()).thenReturn(true);

    // Act
    pbftManager.blockPrePrepare(null, 1L);

    // Assert
    verify(pbftMessageHandle).isSyncing();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftManager#blockPrePrepare(BlockCapsule, long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link PbftMessageHandle#getSrMinerList(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftManager#blockPrePrepare(BlockCapsule, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftManager.blockPrePrepare(BlockCapsule, long)"})
  public void testBlockPrePrepare_whenNull_thenCallsGetSrMinerList() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(pbftMessageHandle.isSyncing()).thenReturn(false);
    when(pbftMessageHandle.getSrMinerList(anyLong())).thenReturn(new ArrayList<>());

    // Act
    pbftManager.blockPrePrepare(null, 1L);

    // Assert
    verify(pbftMessageHandle).getSrMinerList(eq(1L));
    verify(pbftMessageHandle).isSyncing();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}.
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#allowPBFT()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftManager.srPrePrepare(BlockCapsule, List, long)"})
  public void testSrPrePrepare_givenDynamicPropertiesStoreAllowPBFTReturnFalse() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(false);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    pbftManager.srPrePrepare(null, new ArrayList<>(), 1L);

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}.
   * <ul>
   *   <li>Given {@link PbftMessageHandle} {@link PbftMessageHandle#isSyncing()} return {@code true}.</li>
   *   <li>Then calls {@link PbftMessageHandle#isSyncing()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftManager.srPrePrepare(BlockCapsule, List, long)"})
  public void testSrPrePrepare_givenPbftMessageHandleIsSyncingReturnTrue_thenCallsIsSyncing() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(pbftMessageHandle.isSyncing()).thenReturn(true);

    // Act
    pbftManager.srPrePrepare(null, new ArrayList<>(), 1L);

    // Assert
    verify(pbftMessageHandle).isSyncing();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}.
   * <ul>
   *   <li>Then calls {@link PbftMessageHandle#getSrMinerList(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftManager.srPrePrepare(BlockCapsule, List, long)"})
  public void testSrPrePrepare_thenCallsGetSrMinerList() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowPBFT()).thenReturn(true);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(pbftMessageHandle.isSyncing()).thenReturn(false);
    when(pbftMessageHandle.getSrMinerList(anyLong())).thenReturn(new ArrayList<>());

    // Act
    pbftManager.srPrePrepare(null, new ArrayList<>(), 1L);

    // Assert
    verify(pbftMessageHandle).getSrMinerList(eq(1L));
    verify(pbftMessageHandle).isSyncing();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowPBFT();
  }

  /**
   * Test {@link PbftManager#forwardMessage(PbftBaseMessage)}.
   * <p>
   * Method under test: {@link PbftManager#forwardMessage(PbftBaseMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftManager.forwardMessage(PbftBaseMessage)"})
  public void testForwardMessage() {
    // Arrange
    doNothing().when(pbftMessageHandle).forwardMessage(Mockito.<PbftBaseMessage>any());

    // Act
    pbftManager.forwardMessage(new PbftMessage());

    // Assert
    verify(pbftMessageHandle).forwardMessage(isA(PbftBaseMessage.class));
  }

  /**
   * Test {@link PbftManager#doAction(PbftMessage)}.
   * <p>
   * Method under test: {@link PbftManager#doAction(PbftMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PbftManager.doAction(PbftMessage)"})
  public void testDoAction() {
    // Arrange, Act and Assert
    assertTrue(pbftManager.doAction(new PbftMessage()));
  }
}
