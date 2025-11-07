package org.tron.core.consensus;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.ProposalCapsule;
import org.tron.core.db.Manager;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.ProposalStore;
import org.tron.core.store.WitnessScheduleStore;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class ProposalControllerDiffblueTest {
  @InjectMocks
  private ProposalController proposalController;

  /**
   * Method under test: {@link ProposalController#createInstance(Manager)}
   */
  @Test
  public void testCreateInstance() {
    // Arrange
    Manager manager = new Manager();

    // Act and Assert
    assertSame(manager, ProposalController.createInstance(manager).getManager());
  }

  /**
   * Method under test: {@link ProposalController#createInstance(Manager)}
   */
  @Test
  public void testCreateInstance2() {
    // Arrange
    Manager manager = mock(Manager.class);

    // Act and Assert
    assertSame(manager, ProposalController.createInstance(manager).getManager());
  }

  /**
   * Method under test: {@link ProposalController#processProposals()}
   */
  @Test
  public void testProcessProposals() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestProposalNum()).thenReturn(1L);
    Manager manager = mock(Manager.class);
    when(manager.getProposalStore()).thenReturn(null);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ProposalController proposalController = new ProposalController();
    proposalController.setManager(manager);

    // Act
    proposalController.processProposals();

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(manager).getProposalStore();
    verify(dynamicPropertiesStore).getLatestProposalNum();
  }

  /**
   * Method under test: {@link ProposalController#processProposals()}
   */
  @Test
  public void testProcessProposals2() throws ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestProposalNum()).thenReturn(1L);
    ProposalCapsule proposalCapsule = mock(ProposalCapsule.class);
    when(proposalCapsule.hasProcessed()).thenReturn(true);
    when(proposalCapsule.getID()).thenReturn(1L);
    ProposalStore proposalStore = mock(ProposalStore.class);
    when(proposalStore.get(Mockito.<byte[]>any())).thenReturn(proposalCapsule);
    Manager manager = mock(Manager.class);
    when(manager.getProposalStore()).thenReturn(proposalStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ProposalController proposalController = new ProposalController();
    proposalController.setManager(manager);

    // Act
    proposalController.processProposals();

    // Assert
    verify(proposalCapsule).getID();
    verify(proposalCapsule).hasProcessed();
    verify(manager).getDynamicPropertiesStore();
    verify(manager).getProposalStore();
    verify(dynamicPropertiesStore).getLatestProposalNum();
    verify(proposalStore).get(isA(byte[].class));
  }

  /**
   * Method under test: {@link ProposalController#processProposals()}
   */
  @Test
  public void testProcessProposals3() throws ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestProposalNum()).thenReturn(1L);
    ProposalCapsule proposalCapsule = mock(ProposalCapsule.class);
    when(proposalCapsule.hasCanceled()).thenReturn(true);
    when(proposalCapsule.hasProcessed()).thenReturn(false);
    when(proposalCapsule.getID()).thenReturn(1L);
    ProposalStore proposalStore = mock(ProposalStore.class);
    when(proposalStore.get(Mockito.<byte[]>any())).thenReturn(proposalCapsule);
    Manager manager = mock(Manager.class);
    when(manager.getProposalStore()).thenReturn(proposalStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ProposalController proposalController = new ProposalController();
    proposalController.setManager(manager);

    // Act
    proposalController.processProposals();

    // Assert
    verify(proposalCapsule).getID();
    verify(proposalCapsule).hasCanceled();
    verify(proposalCapsule).hasProcessed();
    verify(manager).getDynamicPropertiesStore();
    verify(manager).getProposalStore();
    verify(dynamicPropertiesStore).getLatestProposalNum();
    verify(proposalStore).get(isA(byte[].class));
  }

  /**
   * Method under test: {@link ProposalController#processProposals()}
   */
  @Test
  public void testProcessProposals4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestProposalNum()).thenReturn(0L);
    Manager manager = mock(Manager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ProposalController proposalController = new ProposalController();
    proposalController.setManager(manager);

    // Act
    proposalController.processProposals();

    // Assert that nothing has changed
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestProposalNum();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ProposalController}
   *   <li>{@link ProposalController#setManager(Manager)}
   *   <li>{@link ProposalController#getManager()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProposalController actualProposalController = new ProposalController();
    Manager manager = new Manager();
    actualProposalController.setManager(manager);

    // Assert that nothing has changed
    assertSame(manager, actualProposalController.getManager());
  }

  /**
   * Method under test:
   * {@link ProposalController#processProposal(ProposalCapsule)}
   */
  @Test
  public void testProcessProposal() throws UnsupportedEncodingException {
    // Arrange
    WitnessScheduleStore witnessScheduleStore = mock(WitnessScheduleStore.class);
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());
    ProposalStore proposalStore = mock(ProposalStore.class);
    doNothing().when(proposalStore).put(Mockito.<byte[]>any(), Mockito.<ProposalCapsule>any());
    Manager manager = mock(Manager.class);
    when(manager.getProposalStore()).thenReturn(proposalStore);
    when(manager.getWitnessScheduleStore()).thenReturn(witnessScheduleStore);

    ProposalController proposalController = new ProposalController();
    proposalController.setManager(manager);
    ProposalCapsule proposalCapsule = mock(ProposalCapsule.class);
    when(proposalCapsule.getParameters()).thenReturn(new HashMap<>());
    when(proposalCapsule.getInstance()).thenReturn(Protocol.Proposal.getDefaultInstance());
    when(proposalCapsule.hasMostApprovals(Mockito.<List<ByteString>>any())).thenReturn(true);
    when(proposalCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(proposalCapsule.getID()).thenReturn(1L);
    doNothing().when(proposalCapsule).setState(Mockito.<Protocol.Proposal.State>any());

    // Act
    proposalController.processProposal(proposalCapsule);

    // Assert
    verify(proposalCapsule).createDbKey();
    verify(proposalCapsule).getID();
    verify(proposalCapsule).getInstance();
    verify(proposalCapsule).getParameters();
    verify(proposalCapsule).hasMostApprovals(isA(List.class));
    verify(proposalCapsule).setState(eq(Protocol.Proposal.State.APPROVED));
    verify(manager).getProposalStore();
    verify(manager).getWitnessScheduleStore();
    verify(proposalStore).put(isA(byte[].class), isA(ProposalCapsule.class));
    verify(witnessScheduleStore).getActiveWitnesses();
  }

  /**
   * Method under test:
   * {@link ProposalController#processProposal(ProposalCapsule)}
   */
  @Test
  public void testProcessProposal2() throws UnsupportedEncodingException {
    // Arrange
    WitnessScheduleStore witnessScheduleStore = mock(WitnessScheduleStore.class);
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());
    ProposalStore proposalStore = mock(ProposalStore.class);
    doNothing().when(proposalStore).put(Mockito.<byte[]>any(), Mockito.<ProposalCapsule>any());
    Manager manager = mock(Manager.class);
    when(manager.getProposalStore()).thenReturn(proposalStore);
    when(manager.getWitnessScheduleStore()).thenReturn(witnessScheduleStore);

    ProposalController proposalController = new ProposalController();
    proposalController.setManager(manager);
    ProposalCapsule proposalCapsule = mock(ProposalCapsule.class);
    when(proposalCapsule.hasMostApprovals(Mockito.<List<ByteString>>any())).thenReturn(false);
    when(proposalCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(proposalCapsule.getID()).thenReturn(1L);
    doNothing().when(proposalCapsule).setState(Mockito.<Protocol.Proposal.State>any());

    // Act
    proposalController.processProposal(proposalCapsule);

    // Assert that nothing has changed
    verify(proposalCapsule).createDbKey();
    verify(proposalCapsule).getID();
    verify(proposalCapsule).hasMostApprovals(isA(List.class));
    verify(proposalCapsule).setState(eq(Protocol.Proposal.State.DISAPPROVED));
    verify(manager).getProposalStore();
    verify(manager).getWitnessScheduleStore();
    verify(proposalStore).put(isA(byte[].class), isA(ProposalCapsule.class));
    verify(witnessScheduleStore).getActiveWitnesses();
  }

  /**
   * Method under test:
   * {@link ProposalController#setDynamicParameters(ProposalCapsule)}
   */
  @Test
  public void testSetDynamicParameters() {
    // Arrange
    ProposalController proposalController = new ProposalController();
    ProposalCapsule proposalCapsule = mock(ProposalCapsule.class);
    when(proposalCapsule.getInstance()).thenReturn(Protocol.Proposal.getDefaultInstance());

    // Act
    proposalController.setDynamicParameters(proposalCapsule);

    // Assert
    verify(proposalCapsule).getInstance();
  }
}
