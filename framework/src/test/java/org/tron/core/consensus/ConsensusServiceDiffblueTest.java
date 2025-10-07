package org.tron.core.consensus;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.consensus.Consensus;

@RunWith(MockitoJUnitRunner.class)
public class ConsensusServiceDiffblueTest {
  @Mock private Consensus consensus;

  @InjectMocks private ConsensusService consensusService;

  /**
   * Test {@link ConsensusService#stop()}.
   *
   * <p>Method under test: {@link ConsensusService#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConsensusService.stop()"})
  public void testStop() {
    // Arrange
    doNothing().when(consensus).stop();

    // Act
    consensusService.stop();

    // Assert
    verify(consensus).stop();
  }
}
