package org.tron.core.db.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.ProposalCapsule;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.ProposalStore;
import org.tron.protos.Protocol;

public class EnergyPriceHistoryLoaderDiffblueTest {
  /**
   * Method under test: {@link EnergyPriceHistoryLoader#doWork()}
   */
  @Test
  public void testDoWork() {
    // Arrange
    ProposalCapsule proposalCapsule = mock(ProposalCapsule.class);
    when(proposalCapsule.getParameters()).thenReturn(new HashMap<>());
    when(proposalCapsule.getExpirationTime()).thenReturn(1L);

    ArrayList<ProposalCapsule> proposalCapsuleList = new ArrayList<>();
    proposalCapsuleList.add(proposalCapsule);
    ProposalStore proposalStore = mock(ProposalStore.class);
    when(proposalStore.getSpecifiedProposals(Mockito.<Protocol.Proposal.State>any(), anyLong()))
        .thenReturn(proposalCapsuleList);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveEnergyPriceHistory(Mockito.<String>any());
    doNothing().when(dynamicPropertiesStore).saveEnergyPriceHistoryDone(anyLong());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getProposalStore()).thenReturn(proposalStore);
    EnergyPriceHistoryLoader energyPriceHistoryLoader = new EnergyPriceHistoryLoader(chainBaseManager);

    // Act
    energyPriceHistoryLoader.doWork();

    // Assert
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getProposalStore();
    verify(proposalCapsule).getExpirationTime();
    verify(proposalCapsule).getParameters();
    verify(dynamicPropertiesStore).saveEnergyPriceHistory(eq("0:100,1:null"));
    verify(dynamicPropertiesStore).saveEnergyPriceHistoryDone(eq(1L));
    verify(proposalStore).getSpecifiedProposals(eq(Protocol.Proposal.State.APPROVED), eq(11L));
    assertEquals("0:100,1:null", energyPriceHistoryLoader.parseProposalsToStr());
  }

  /**
   * Method under test: {@link EnergyPriceHistoryLoader#getEnergyProposals()}
   */
  @Test
  public void testGetEnergyProposals() {
    // Arrange
    ProposalStore proposalStore = mock(ProposalStore.class);
    when(proposalStore.getSpecifiedProposals(Mockito.<Protocol.Proposal.State>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getProposalStore()).thenReturn(proposalStore);

    // Act
    (new EnergyPriceHistoryLoader(chainBaseManager)).getEnergyProposals();

    // Assert
    verify(chainBaseManager).getProposalStore();
    verify(proposalStore).getSpecifiedProposals(eq(Protocol.Proposal.State.APPROVED), eq(11L));
  }

  /**
   * Method under test: {@link EnergyPriceHistoryLoader#parseProposalsToStr()}
   */
  @Test
  public void testParseProposalsToStr() {
    // Arrange, Act and Assert
    assertEquals("0:100", (new EnergyPriceHistoryLoader(ChainBaseManager.getChainBaseManager())).parseProposalsToStr());
  }

  /**
   * Method under test: {@link EnergyPriceHistoryLoader#finish()}
   */
  @Test
  public void testFinish() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveEnergyPriceHistoryDone(anyLong());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    (new EnergyPriceHistoryLoader(chainBaseManager)).finish();

    // Assert that nothing has changed
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).saveEnergyPriceHistoryDone(eq(1L));
  }
}
