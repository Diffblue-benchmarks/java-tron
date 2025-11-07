package org.tron.core.consensus;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.consensus.Consensus;
import org.tron.core.store.WitnessStore;

@RunWith(MockitoJUnitRunner.class)
public class ConsensusServiceDiffblueTest {
  @Mock
  private BlockHandleImpl blockHandleImpl;

  @Mock
  private Consensus consensus;

  @InjectMocks
  private ConsensusService consensusService;

  @Mock
  private PbftBaseImpl pbftBaseImpl;

  @Mock
  private WitnessStore witnessStore;

  /**
   * Method under test: {@link ConsensusService#stop()}
   */
  @Test
  public void testStop() {
    // Arrange
    doNothing().when(consensus).stop();

    // Act
    consensusService.stop();

    // Assert that nothing has changed
    verify(consensus).stop();
  }
}
