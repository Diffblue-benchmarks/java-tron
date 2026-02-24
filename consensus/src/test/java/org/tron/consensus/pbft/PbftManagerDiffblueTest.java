package org.tron.consensus.pbft;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Mock private ChainBaseManager chainBaseManager;

  @Mock private MaintenanceManager maintenanceManager;

  @InjectMocks private PbftManager pbftManager;

  @Mock private PbftMessageHandle pbftMessageHandle;

  /**
   * Test {@link PbftManager#init()}.
   *
   * <p>Method under test: {@link PbftManager#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#allowPBFT()} return
   *       {@code false}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PbftManager#blockPrePrepare(BlockCapsule, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftManager.blockPrePrepare(BlockCapsule, long)"})
  public void testBlockPrePrepare_givenDynamicPropertiesStoreAllowPBFTReturnFalse_whenNull() {
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
   *
   * <ul>
   *   <li>Given {@link PbftMessageHandle} {@link PbftMessageHandle#isSyncing()} return {@code
   *       true}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PbftManager#blockPrePrepare(BlockCapsule, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftManager.blockPrePrepare(BlockCapsule, long)"})
  public void testBlockPrePrepare_givenPbftMessageHandleIsSyncingReturnTrue_whenNull() {
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
   * Test {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#allowPBFT()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PbftMessageHandle} {@link PbftMessageHandle#isSyncing()} return {@code
   *       true}.
   *   <li>Then calls {@link PbftMessageHandle#isSyncing()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftManager#srPrePrepare(BlockCapsule, List, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link PbftManager#forwardMessage(PbftBaseMessage)}.
   *
   * <p>Method under test: {@link PbftManager#forwardMessage(PbftBaseMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link PbftManager#doAction(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PbftManager.doAction(PbftMessage)"})
  public void testDoAction() {
    // Arrange
    PbftManager pbftManager = new PbftManager();

    // Act and Assert
    assertTrue(pbftManager.doAction(new PbftMessage()));
  }
}
