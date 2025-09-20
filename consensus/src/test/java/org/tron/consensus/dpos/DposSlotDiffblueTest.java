package org.tron.consensus.dpos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.consensus.ConsensusDelegate;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class DposSlotDiffblueTest {
  @Mock private ConsensusDelegate consensusDelegate;

  @InjectMocks private DposSlot dposSlot;

  /**
   * Test {@link DposSlot#getAbSlot(long)}.
   *
   * <ul>
   *   <li>Given {@link DposSlot} (default constructor) DposService is {@link DposService} (default
   *       constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DposSlot#getAbSlot(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DposSlot.getAbSlot(long)"})
  public void testGetAbSlot_givenDposSlotDposServiceIsDposService_thenReturnZero() {
    // Arrange
    DposSlot dposSlot = new DposSlot();
    dposSlot.setDposService(new DposService());

    // Act and Assert
    assertEquals(0L, dposSlot.getAbSlot(10L));
  }

  /**
   * Test {@link DposSlot#getSlot(long)}.
   *
   * <p>Method under test: {@link DposSlot#getSlot(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DposSlot.getSlot(long)"})
  public void testGetSlot() {
    // Arrange
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dposSlot.getSlot(10L));
    verify(consensusDelegate).getLatestBlockHeaderNumber();
  }

  /**
   * Test {@link DposSlot#getSlot(long)}.
   *
   * <p>Method under test: {@link DposSlot#getSlot(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DposSlot.getSlot(long)"})
  public void testGetSlot2() {
    // Arrange
    when(consensusDelegate.lastHeadBlockIsMaintenance()).thenThrow(new RuntimeException());
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dposSlot.getSlot(10L));
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    verify(consensusDelegate).lastHeadBlockIsMaintenance();
  }

  /**
   * Test {@link DposSlot#getSlot(long)}.
   *
   * <ul>
   *   <li>Then calls {@link ConsensusDelegate#getMaintenanceSkipSlots()}.
   * </ul>
   *
   * <p>Method under test: {@link DposSlot#getSlot(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DposSlot.getSlot(long)"})
  public void testGetSlot_thenCallsGetMaintenanceSkipSlots() {
    // Arrange
    when(consensusDelegate.getMaintenanceSkipSlots()).thenThrow(new RuntimeException());
    when(consensusDelegate.lastHeadBlockIsMaintenance()).thenReturn(true);
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dposSlot.getSlot(10L));
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    verify(consensusDelegate).getMaintenanceSkipSlots();
    verify(consensusDelegate).lastHeadBlockIsMaintenance();
  }

  /**
   * Test {@link DposSlot#getTime(long)}.
   *
   * <p>Method under test: {@link DposSlot#getTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DposSlot.getTime(long)"})
  public void testGetTime() {
    // Arrange
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dposSlot.getTime(1L));
    verify(consensusDelegate).getLatestBlockHeaderNumber();
  }

  /**
   * Test {@link DposSlot#getTime(long)}.
   *
   * <p>Method under test: {@link DposSlot#getTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DposSlot.getTime(long)"})
  public void testGetTime2() {
    // Arrange
    when(consensusDelegate.lastHeadBlockIsMaintenance()).thenThrow(new RuntimeException());
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dposSlot.getTime(1L));
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    verify(consensusDelegate).lastHeadBlockIsMaintenance();
  }

  /**
   * Test {@link DposSlot#getTime(long)}.
   *
   * <ul>
   *   <li>Then calls {@link ConsensusDelegate#getMaintenanceSkipSlots()}.
   * </ul>
   *
   * <p>Method under test: {@link DposSlot#getTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DposSlot.getTime(long)"})
  public void testGetTime_thenCallsGetMaintenanceSkipSlots() {
    // Arrange
    when(consensusDelegate.getMaintenanceSkipSlots()).thenThrow(new RuntimeException());
    when(consensusDelegate.lastHeadBlockIsMaintenance()).thenReturn(true);
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dposSlot.getTime(1L));
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    verify(consensusDelegate).getMaintenanceSkipSlots();
    verify(consensusDelegate).lastHeadBlockIsMaintenance();
  }
}
