package org.tron.consensus.dpos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.consensus.ConsensusDelegate;
import org.tron.consensus.pbft.PbftManager;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class MaintenanceManagerDiffblueTest {
  @Mock private ConsensusDelegate consensusDelegate;

  @InjectMocks private MaintenanceManager maintenanceManager;

  /**
   * Test {@link MaintenanceManager#init()}.
   *
   * <p>Method under test: {@link MaintenanceManager#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MaintenanceManager.init()"})
  public void testInit() {
    // Arrange
    when(consensusDelegate.getActiveWitnesses()).thenReturn(new ArrayList<>());

    // Act
    maintenanceManager.init();

    // Assert
    verify(consensusDelegate).getActiveWitnesses();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MaintenanceManager#setDposService(DposService)}
   *   <li>{@link MaintenanceManager#setPbftManager(PbftManager)}
   *   <li>{@link MaintenanceManager#getBeforeMaintenanceTime()}
   *   <li>{@link MaintenanceManager#getBeforeWitness()}
   *   <li>{@link MaintenanceManager#getCurrentWitness()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "long MaintenanceManager.getBeforeMaintenanceTime()",
    "List MaintenanceManager.getBeforeWitness()",
    "List MaintenanceManager.getCurrentWitness()",
    "void MaintenanceManager.setDposService(DposService)",
    "void MaintenanceManager.setPbftManager(PbftManager)"
  })
  public void testGettersAndSetters() {
    // Arrange
    MaintenanceManager maintenanceManager = new MaintenanceManager();

    // Act
    maintenanceManager.setDposService(new DposService());
    maintenanceManager.setPbftManager(new PbftManager());
    long actualBeforeMaintenanceTime = maintenanceManager.getBeforeMaintenanceTime();
    List<ByteString> actualBeforeWitness = maintenanceManager.getBeforeWitness();
    List<ByteString> actualCurrentWitness = maintenanceManager.getCurrentWitness();

    // Assert
    assertEquals(0L, actualBeforeMaintenanceTime);
    assertTrue(actualBeforeWitness.isEmpty());
    assertTrue(actualCurrentWitness.isEmpty());
  }
}
