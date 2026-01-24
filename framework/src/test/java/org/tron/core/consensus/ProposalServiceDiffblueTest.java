package org.tron.core.consensus;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.capsule.ProposalCapsule;
import org.tron.core.db.Manager;

public class ProposalServiceDiffblueTest {
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
