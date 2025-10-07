package org.tron.consensus;

import static org.mockito.ArgumentMatchers.isA;
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
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.consensus.base.Param;
import org.tron.consensus.dpos.DposService;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class ConsensusDiffblueTest {
  @InjectMocks private Consensus consensus;

  @Mock private DposService dposService;

  /**
   * Test {@link Consensus#start(Param)}.
   *
   * <p>Method under test: {@link Consensus#start(Param)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Consensus.start(Param)"})
  public void testStart() {
    // Arrange
    doNothing().when(dposService).start(Mockito.<Param>any());

    // Act
    consensus.start(Param.getInstance());

    // Assert
    verify(dposService).start(isA(Param.class));
  }

  /**
   * Test {@link Consensus#stop()}.
   *
   * <p>Method under test: {@link Consensus#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Consensus.stop()"})
  public void testStop() {
    // Arrange
    doNothing().when(dposService).stop();

    // Act
    consensus.stop();

    // Assert
    verify(dposService).stop();
  }
}
