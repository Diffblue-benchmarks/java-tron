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

public class BandwidthPriceHistoryLoaderDiffblueTest {
  /**
   * Test {@link BandwidthPriceHistoryLoader#doWork()}.
   *
   * <p>Method under test: {@link BandwidthPriceHistoryLoader#doWork()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthPriceHistoryLoader.doWork()"})
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
    doNothing().when(dynamicPropertiesStore).saveBandwidthPriceHistory(Mockito.<String>any());
    doNothing().when(dynamicPropertiesStore).saveBandwidthPriceHistoryDone(anyLong());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getProposalStore()).thenReturn(proposalStore);
    BandwidthPriceHistoryLoader bandwidthPriceHistoryLoader =
        new BandwidthPriceHistoryLoader(chainBaseManager);

    // Act
    bandwidthPriceHistoryLoader.doWork();

    // Assert
    verify(chainBaseManager, atLeast(1)).getDynamicPropertiesStore();
    verify(chainBaseManager).getProposalStore();
    verify(proposalCapsule).getExpirationTime();
    verify(proposalCapsule).getParameters();
    verify(dynamicPropertiesStore).saveBandwidthPriceHistory("0:10,1:null");
    verify(dynamicPropertiesStore).saveBandwidthPriceHistoryDone(1L);
    verify(proposalStore).getSpecifiedProposals(State.APPROVED, 3L);
    assertEquals("0:10,1:null", bandwidthPriceHistoryLoader.parseProposalsToStr());
  }

  /**
   * Test {@link BandwidthPriceHistoryLoader#getBandwidthProposals()}.
   *
   * <ul>
   *   <li>Then calls {@link ChainBaseManager#getProposalStore()}.
   * </ul>
   *
   * <p>Method under test: {@link BandwidthPriceHistoryLoader#getBandwidthProposals()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthPriceHistoryLoader.getBandwidthProposals()"})
  public void testGetBandwidthProposals_thenCallsGetProposalStore() {
    // Arrange
    ProposalStore proposalStore = mock(ProposalStore.class);
    when(proposalStore.getSpecifiedProposals(Mockito.<State>any(), anyLong()))
        .thenReturn(new ArrayList<>());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getProposalStore()).thenReturn(proposalStore);

    // Act
    new BandwidthPriceHistoryLoader(chainBaseManager).getBandwidthProposals();

    // Assert
    verify(chainBaseManager).getProposalStore();
    verify(proposalStore).getSpecifiedProposals(State.APPROVED, 3L);
  }

  /**
   * Test {@link BandwidthPriceHistoryLoader#parseProposalsToStr()}.
   *
   * <p>Method under test: {@link BandwidthPriceHistoryLoader#parseProposalsToStr()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BandwidthPriceHistoryLoader.parseProposalsToStr()"})
  public void testParseProposalsToStr() {
    // Arrange, Act and Assert
    assertEquals(
        "0:10",
        new BandwidthPriceHistoryLoader(ChainBaseManager.getChainBaseManager())
            .parseProposalsToStr());
  }

  /**
   * Test {@link BandwidthPriceHistoryLoader#finish()}.
   *
   * <ul>
   *   <li>Then calls {@link ChainBaseManager#getDynamicPropertiesStore()}.
   * </ul>
   *
   * <p>Method under test: {@link BandwidthPriceHistoryLoader#finish()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandwidthPriceHistoryLoader.finish()"})
  public void testFinish_thenCallsGetDynamicPropertiesStore() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveBandwidthPriceHistoryDone(anyLong());

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    new BandwidthPriceHistoryLoader(chainBaseManager).finish();

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).saveBandwidthPriceHistoryDone(1L);
  }
}
