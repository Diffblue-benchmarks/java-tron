package org.tron.core.db.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.ProposalCapsule;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.ProposalStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Proposal;
import org.tron.protos.Protocol.Proposal.State;

public class EnergyPriceHistoryLoaderDiffblueTest {
  /**
   * Test {@link EnergyPriceHistoryLoader#doWork()}.
   *
   * <p>Method under test: {@link EnergyPriceHistoryLoader#doWork()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EnergyPriceHistoryLoader.doWork()"})
  public void testDoWork() {
    // Arrange
    ProposalCapsule proposalCapsule = mock(ProposalCapsule.class);
    when(proposalCapsule.getParameters()).thenReturn(new HashMap<>());
    when(proposalCapsule.getExpirationTime()).thenReturn(1L);

    ArrayList<ProposalCapsule> proposalCapsuleList = new ArrayList<>();
    proposalCapsuleList.add(proposalCapsule);

    ProposalStore proposalStore = mock(ProposalStore.class);
    when(proposalStore.getSpecifiedProposals(Mockito.<State>any(), anyLong()))
        .thenReturn(proposalCapsuleList);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveEnergyPriceHistory(Mockito.<String>any());
    doNothing().when(dynamicPropertiesStore).saveEnergyPriceHistoryDone(anyLong());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getProposalStore()).thenReturn(proposalStore);
    EnergyPriceHistoryLoader energyPriceHistoryLoader =
        new EnergyPriceHistoryLoader(chainBaseManager);

    // Act
    energyPriceHistoryLoader.doWork();

    // Assert
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getProposalStore();
    verify(proposalCapsule).getExpirationTime();
    verify(proposalCapsule).getParameters();
    verify(dynamicPropertiesStore).saveEnergyPriceHistory("0:100,1:null");
    verify(dynamicPropertiesStore).saveEnergyPriceHistoryDone(1L);
    verify(proposalStore).getSpecifiedProposals(State.APPROVED, 11L);
    assertEquals("0:100,1:null", energyPriceHistoryLoader.parseProposalsToStr());
  }

  /**
   * Test {@link EnergyPriceHistoryLoader#getEnergyProposals()}.
   *
   * <ul>
   *   <li>Then calls {@link ChainBaseManager#getProposalStore()}.
   * </ul>
   *
   * <p>Method under test: {@link EnergyPriceHistoryLoader#getEnergyProposals()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EnergyPriceHistoryLoader.getEnergyProposals()"})
  public void testGetEnergyProposals_thenCallsGetProposalStore() {
    // Arrange
    ProposalStore proposalStore = mock(ProposalStore.class);
    when(proposalStore.getSpecifiedProposals(Mockito.<State>any(), anyLong()))
        .thenReturn(new ArrayList<>());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getProposalStore()).thenReturn(proposalStore);

    // Act
    new EnergyPriceHistoryLoader(chainBaseManager).getEnergyProposals();

    // Assert
    verify(chainBaseManager).getProposalStore();
    verify(proposalStore).getSpecifiedProposals(State.APPROVED, 11L);
  }

  /**
   * Test {@link EnergyPriceHistoryLoader#parseProposalsToStr()}.
   *
   * <p>Method under test: {@link EnergyPriceHistoryLoader#parseProposalsToStr()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EnergyPriceHistoryLoader.parseProposalsToStr()"})
  public void testParseProposalsToStr() {
    // Arrange, Act and Assert
    assertEquals(
        "0:100",
        new EnergyPriceHistoryLoader(ChainBaseManager.getChainBaseManager()).parseProposalsToStr());
  }

  /**
   * Test {@link EnergyPriceHistoryLoader#finish()}.
   *
   * <ul>
   *   <li>Then calls {@link ChainBaseManager#getDynamicPropertiesStore()}.
   * </ul>
   *
   * <p>Method under test: {@link EnergyPriceHistoryLoader#finish()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EnergyPriceHistoryLoader.finish()"})
  public void testFinish_thenCallsGetDynamicPropertiesStore() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveEnergyPriceHistoryDone(anyLong());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    new EnergyPriceHistoryLoader(chainBaseManager).finish();

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).saveEnergyPriceHistoryDone(1L);
  }
}
