package org.tron.core.consensus;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.ProposalCapsule;
import org.tron.core.db.Manager;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class ProposalServiceDiffblueTest {
  @InjectMocks
  private ProposalService proposalService;

  /**
   * Method under test: {@link ProposalService#process(Manager, ProposalCapsule)}
   */
  @Test
  public void testProcess() {
    // Arrange
    Manager manager = new Manager();

    // Act and Assert
    assertTrue(ProposalService.process(manager, new ProposalCapsule(Protocol.Proposal.getDefaultInstance())));
  }

  /**
   * Method under test: {@link ProposalService#process(Manager, ProposalCapsule)}
   */
  @Test
  public void testProcess2() {
    // Arrange
    Manager manager = mock(Manager.class);

    // Act and Assert
    assertTrue(ProposalService.process(manager, new ProposalCapsule(Protocol.Proposal.getDefaultInstance())));
  }

  /**
   * Method under test: {@link ProposalService#process(Manager, ProposalCapsule)}
   */
  @Test
  public void testProcess3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveAccountUpgradeCost(anyLong());
    Manager manager = mock(Manager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setParameters(parameters);

    // Act
    boolean actualProcessResult = ProposalService.process(manager, proposalCapsule);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).saveAccountUpgradeCost(eq(1L));
    assertTrue(actualProcessResult);
  }

  /**
   * Method under test: {@link ProposalService#process(Manager, ProposalCapsule)}
   */
  @Test
  public void testProcess4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveAllowDelegateOptimization(anyLong());
    Manager manager = mock(Manager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(69L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setParameters(parameters);

    // Act
    boolean actualProcessResult = ProposalService.process(manager, proposalCapsule);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).saveAllowDelegateOptimization(eq(1L));
    assertTrue(actualProcessResult);
  }

  /**
   * Method under test: {@link ProposalService#process(Manager, ProposalCapsule)}
   */
  @Test
  public void testProcess5() {
    // Arrange
    Manager manager = mock(Manager.class);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(-1L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setParameters(parameters);

    // Act and Assert
    assertFalse(ProposalService.process(manager, proposalCapsule));
  }

  /**
   * Method under test: {@link ProposalService#process(Manager, ProposalCapsule)}
   */
  @Test
  public void testProcess6() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveCreateAccountFee(anyLong());
    Manager manager = mock(Manager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(2L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setParameters(parameters);

    // Act
    boolean actualProcessResult = ProposalService.process(manager, proposalCapsule);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).saveCreateAccountFee(eq(1L));
    assertTrue(actualProcessResult);
  }

  /**
   * Method under test: {@link ProposalService#process(Manager, ProposalCapsule)}
   */
  @Test
  public void testProcess7() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getBandwidthPriceHistory()).thenReturn("Bandwidth Price History");
    doNothing().when(dynamicPropertiesStore).saveBandwidthPriceHistory(Mockito.<String>any());
    doNothing().when(dynamicPropertiesStore).saveTransactionFee(anyLong());
    Manager manager = mock(Manager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(3L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setParameters(parameters);

    // Act
    boolean actualProcessResult = ProposalService.process(manager, proposalCapsule);

    // Assert
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getBandwidthPriceHistory();
    verify(dynamicPropertiesStore).saveBandwidthPriceHistory(eq("Bandwidth Price History,0:1"));
    verify(dynamicPropertiesStore).saveTransactionFee(eq(1L));
    assertTrue(actualProcessResult);
  }

  /**
   * Method under test: {@link ProposalService#process(Manager, ProposalCapsule)}
   */
  @Test
  public void testProcess8() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveMaintenanceTimeInterval(anyLong());
    Manager manager = mock(Manager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(0L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setParameters(parameters);

    // Act
    boolean actualProcessResult = ProposalService.process(manager, proposalCapsule);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).saveMaintenanceTimeInterval(eq(1L));
    assertTrue(actualProcessResult);
  }

  /**
   * Method under test: {@link ProposalService#process(Manager, ProposalCapsule)}
   */
  @Test
  public void testProcess9() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveAssetIssueFee(anyLong());
    Manager manager = mock(Manager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(4L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setParameters(parameters);

    // Act
    boolean actualProcessResult = ProposalService.process(manager, proposalCapsule);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).saveAssetIssueFee(eq(1L));
    assertTrue(actualProcessResult);
  }

  /**
   * Method under test: {@link ProposalService#process(Manager, ProposalCapsule)}
   */
  @Test
  public void testProcess10() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveWitnessPayPerBlock(anyLong());
    Manager manager = mock(Manager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(5L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(Protocol.Proposal.getDefaultInstance());
    proposalCapsule.setParameters(parameters);

    // Act
    boolean actualProcessResult = ProposalService.process(manager, proposalCapsule);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).saveWitnessPayPerBlock(eq(1L));
    assertTrue(actualProcessResult);
  }
}
