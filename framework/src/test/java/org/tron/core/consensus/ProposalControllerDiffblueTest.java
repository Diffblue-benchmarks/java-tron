package org.tron.core.consensus;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.ProposalCapsule;
import org.tron.core.db.Manager;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.ProposalStore;
import org.tron.core.store.WitnessScheduleStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Proposal;
import org.tron.protos.Protocol.Proposal.State;

public class ProposalControllerDiffblueTest {
  /**
   * Test {@link ProposalController#createInstance(Manager)}.
   * <p>
   * Method under test: {@link ProposalController#createInstance(Manager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProposalController ProposalController.createInstance(Manager)"})
  public void testCreateInstance() {
    // Arrange
    Manager manager = new Manager();

    // Act and Assert
    assertSame(manager, ProposalController.createInstance(manager).getManager());
  }

  /**
   * Test {@link ProposalController#processProposals()}.
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link DynamicPropertiesStore#getLatestProposalNum()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalController#processProposals()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalController.processProposals()"})
  public void testProcessProposals_givenDynamicPropertiesStoreGetLatestProposalNumReturnZero() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestProposalNum()).thenReturn(0L);
    Manager manager = mock(Manager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ProposalController proposalController = new ProposalController();
    proposalController.setManager(manager);

    // Act
    proposalController.processProposals();

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestProposalNum();
  }

  /**
   * Test {@link ProposalController#processProposals()}.
   * <ul>
   *   <li>Given {@link Manager} {@link Manager#getProposalStore()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalController#processProposals()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalController.processProposals()"})
  public void testProcessProposals_givenManagerGetProposalStoreReturnNull() {
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
   * Test {@link ProposalController#processProposals()}.
   * <ul>
   *   <li>Given {@link ProposalCapsule} {@link ProposalCapsule#hasProcessed()} return {@code true}.</li>
   *   <li>Then calls {@link ProposalCapsule#getID()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalController#processProposals()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalController.processProposals()"})
  public void testProcessProposals_givenProposalCapsuleHasProcessedReturnTrue_thenCallsGetID()
      throws ItemNotFoundException {
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
   * Test {@link ProposalController#processProposals()}.
   * <ul>
   *   <li>Then calls {@link ProposalCapsule#hasCanceled()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProposalController#processProposals()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalController.processProposals()"})
  public void testProcessProposals_thenCallsHasCanceled() throws ItemNotFoundException {
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
   * Test {@link ProposalController#processProposal(ProposalCapsule)}.
   * <p>
   * Method under test: {@link ProposalController#processProposal(ProposalCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalController.processProposal(ProposalCapsule)"})
  public void testProcessProposal() {
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
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});

    // Act
    proposalController.processProposal(proposalCapsule);

    // Assert
    verify(manager).getProposalStore();
    verify(manager).getWitnessScheduleStore();
    verify(proposalStore).put(isA(byte[].class), isA(ProposalCapsule.class));
    verify(witnessScheduleStore).getActiveWitnesses();
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(2, instance.getStateValue());
    assertEquals(State.APPROVED, proposalCapsule.getState());
    assertEquals(State.APPROVED, instance.getState());
    assertTrue(proposalCapsule.hasProcessed());
    assertArrayEquals(new byte[]{'8', 2}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalController#processProposal(ProposalCapsule)}.
   * <p>
   * Method under test: {@link ProposalController#processProposal(ProposalCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalController.processProposal(ProposalCapsule)"})
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
    ByteString committeeAddress = mock(ByteString.class);
    when(committeeAddress.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});
    proposalCapsule.addApproval(committeeAddress);

    // Act
    proposalController.processProposal(proposalCapsule);

    // Assert
    verify(committeeAddress).toByteArray();
    verify(manager).getProposalStore();
    verify(manager).getWitnessScheduleStore();
    verify(proposalStore).put(isA(byte[].class), isA(ProposalCapsule.class));
    verify(witnessScheduleStore).getActiveWitnesses();
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(2, instance.getStateValue());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(State.APPROVED, proposalCapsule.getState());
    assertEquals(State.APPROVED, instance.getState());
    assertTrue(proposalCapsule.hasProcessed());
    assertArrayEquals(new byte[]{'2', 0, '8', 2}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalController#processProposal(ProposalCapsule)}.
   * <p>
   * Method under test: {@link ProposalController#processProposal(ProposalCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalController.processProposal(ProposalCapsule)"})
  public void testProcessProposal3() throws UnsupportedEncodingException {
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
    ByteString committeeAddress = mock(ByteString.class);
    when(committeeAddress.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ByteString committeeAddress2 = mock(ByteString.class);
    when(committeeAddress2.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[]{});
    proposalCapsule.addApproval(committeeAddress2);
    proposalCapsule.addApproval(committeeAddress);

    // Act
    proposalController.processProposal(proposalCapsule);

    // Assert
    verify(committeeAddress2).toByteArray();
    verify(committeeAddress).toByteArray();
    verify(manager).getProposalStore();
    verify(manager).getWitnessScheduleStore();
    verify(proposalStore).put(isA(byte[].class), isA(ProposalCapsule.class));
    verify(witnessScheduleStore).getActiveWitnesses();
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(2, instance.getStateValue());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(State.APPROVED, proposalCapsule.getState());
    assertEquals(State.APPROVED, instance.getState());
    assertTrue(proposalCapsule.hasProcessed());
    assertArrayEquals(new byte[]{'2', 0, '2', 0, '8', 2}, proposalCapsule.getData());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ProposalController}
   *   <li>{@link ProposalController#setManager(Manager)}
   *   <li>{@link ProposalController#getManager()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProposalController.<init>()", "Manager ProposalController.getManager()",
      "void ProposalController.setManager(Manager)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ProposalController actualProposalController = new ProposalController();
    Manager manager = new Manager();
    actualProposalController.setManager(manager);

    // Assert
    assertSame(manager, actualProposalController.getManager());
  }
}
