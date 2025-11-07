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

public class BandwidthPriceHistoryLoaderDiffblueTest {
  /**
   * Method under test: {@link BandwidthPriceHistoryLoader#doWork()}
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
    doNothing().when(dynamicPropertiesStore).saveBandwidthPriceHistory(Mockito.<String>any());
    doNothing().when(dynamicPropertiesStore).saveBandwidthPriceHistoryDone(anyLong());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getProposalStore()).thenReturn(proposalStore);
    BandwidthPriceHistoryLoader bandwidthPriceHistoryLoader = new BandwidthPriceHistoryLoader(chainBaseManager);

    // Act
    bandwidthPriceHistoryLoader.doWork();

    // Assert
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getProposalStore();
    verify(proposalCapsule).getExpirationTime();
    verify(proposalCapsule).getParameters();
    verify(dynamicPropertiesStore).saveBandwidthPriceHistory(eq("0:10,1:null"));
    verify(dynamicPropertiesStore).saveBandwidthPriceHistoryDone(eq(1L));
    verify(proposalStore).getSpecifiedProposals(eq(Protocol.Proposal.State.APPROVED), eq(3L));
    assertEquals("0:10,1:null", bandwidthPriceHistoryLoader.parseProposalsToStr());
  }

  /**
   * Method under test:
   * {@link BandwidthPriceHistoryLoader#getBandwidthProposals()}
   */
  @Test
  public void testGetBandwidthProposals() {
    // Arrange
    ProposalStore proposalStore = mock(ProposalStore.class);
    when(proposalStore.getSpecifiedProposals(Mockito.<Protocol.Proposal.State>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getProposalStore()).thenReturn(proposalStore);

    // Act
    (new BandwidthPriceHistoryLoader(chainBaseManager)).getBandwidthProposals();

    // Assert
    verify(chainBaseManager).getProposalStore();
    verify(proposalStore).getSpecifiedProposals(eq(Protocol.Proposal.State.APPROVED), eq(3L));
  }

  /**
   * Method under test: {@link BandwidthPriceHistoryLoader#parseProposalsToStr()}
   */
  @Test
  public void testParseProposalsToStr() {
    // Arrange, Act and Assert
    assertEquals("0:10",
        (new BandwidthPriceHistoryLoader(ChainBaseManager.getChainBaseManager())).parseProposalsToStr());
  }

  /**
   * Method under test: {@link BandwidthPriceHistoryLoader#finish()}
   */
  @Test
  public void testFinish() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveBandwidthPriceHistoryDone(anyLong());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    (new BandwidthPriceHistoryLoader(chainBaseManager)).finish();

    // Assert that nothing has changed
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).saveBandwidthPriceHistoryDone(eq(1L));
  }
}
