package org.tron.consensus;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.consensus.base.Param;
import org.tron.consensus.dpos.DposService;

@RunWith(MockitoJUnitRunner.class)
public class ConsensusDiffblueTest {
  @InjectMocks
  private Consensus consensus;

  @Mock
  private DposService dposService;

  /**
   * Method under test: {@link Consensus#start(Param)}
   */
  @Test
  public void testStart() {
    // Arrange
    doNothing().when(dposService).start(Mockito.<Param>any());

    // Act
    consensus.start(Param.getInstance());

    // Assert
    verify(dposService).start(isA(Param.class));
  }

  /**
   * Method under test: {@link Consensus#stop()}
   */
  @Test
  public void testStop() {
    // Arrange
    doNothing().when(dposService).stop();

    // Act
    consensus.stop();

    // Assert
    verify(dposService).stop();
  }
}
