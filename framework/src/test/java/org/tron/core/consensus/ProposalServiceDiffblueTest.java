package org.tron.core.consensus;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.capsule.ProposalCapsule;
import org.tron.core.db.Manager;

public class ProposalServiceDiffblueTest {
  /**
   * Test {@link ProposalService#process(Manager, ProposalCapsule)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} minus one is one.
   *   <li>When {@link Manager}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalService#process(Manager, ProposalCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProposalService.process(Manager, ProposalCapsule)"})
  public void testProcess_givenHashMapMinusOneIsOne_whenManager_thenReturnFalse() {
    // Arrange
    Manager manager = mock(Manager.class);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(-1L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setParameters(parameters);

    // Act
    boolean actualProcessResult = ProposalService.process(manager, proposalCapsule);

    // Assert
    assertFalse(actualProcessResult);
  }

  /**
   * Test {@link ProposalService#process(Manager, ProposalCapsule)}.
   *
   * <ul>
   *   <li>When {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalService#process(Manager, ProposalCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProposalService.process(Manager, ProposalCapsule)"})
  public void testProcess_whenProposalCapsuleWithDataIsEmptyArrayOfByte_thenReturnTrue() {
    // Arrange
    Manager manager = new Manager();
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act
    boolean actualProcessResult = ProposalService.process(manager, proposalCapsule);

    // Assert
    assertTrue(actualProcessResult);
  }
}
