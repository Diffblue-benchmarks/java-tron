package org.tron.consensus.dpos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.tron.consensus.ConsensusDelegate;

@RunWith(MockitoJUnitRunner.class)
public class DposSlotDiffblueTest {
  @Mock
  private ConsensusDelegate consensusDelegate;

  @InjectMocks
  private DposSlot dposSlot;

  /**
   * Test {@link DposSlot#getAbSlot(long)}.
   * <ul>
   *   <li>Given {@link DposSlot} (default constructor) DposService is {@link DposService} (default constructor).</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposSlot#getAbSlot(long)}
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
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposSlot#getSlot(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DposSlot.getSlot(long)"})
  public void testGetSlot_thenThrowRuntimeException() {
    // Arrange
    when(consensusDelegate.getMaintenanceSkipSlots()).thenThrow(new RuntimeException("foo"));
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
   * <p>
   * Method under test: {@link DposSlot#getTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DposSlot.getTime(long)"})
  public void testGetTime() {
    // Arrange
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dposSlot.getTime(-1L));
    verify(consensusDelegate).getLatestBlockHeaderNumber();
  }

  /**
   * Test {@link DposSlot#getTime(long)}.
   * <ul>
   *   <li>Then calls {@link ConsensusDelegate#getMaintenanceSkipSlots()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposSlot#getTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DposSlot.getTime(long)"})
  public void testGetTime_thenCallsGetMaintenanceSkipSlots() {
    // Arrange
    when(consensusDelegate.getMaintenanceSkipSlots()).thenThrow(new RuntimeException("foo"));
    when(consensusDelegate.lastHeadBlockIsMaintenance()).thenReturn(true);
    when(consensusDelegate.getLatestBlockHeaderNumber()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dposSlot.getTime(1L));
    verify(consensusDelegate).getLatestBlockHeaderNumber();
    verify(consensusDelegate).getMaintenanceSkipSlots();
    verify(consensusDelegate).lastHeadBlockIsMaintenance();
  }

  /**
   * Test {@link DposSlot#getScheduledWitness(long)}.
   * <p>
   * Method under test: {@link DposSlot#getScheduledWitness(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString DposSlot.getScheduledWitness(long)"})
  public void testGetScheduledWitness() {
    // Arrange
    DposSlot dposSlot = new DposSlot();
    dposSlot.setDposService(new DposService());
    ConsensusDelegate consensusDelegate = mock(ConsensusDelegate.class);
    when(consensusDelegate.getLatestBlockHeaderTimestamp()).thenReturn(Long.MIN_VALUE);
    ReflectionTestUtils.setField(dposSlot, "consensusDelegate", consensusDelegate);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dposSlot.getScheduledWitness(1L));
    verify(consensusDelegate).getLatestBlockHeaderTimestamp();
  }

  /**
   * Test {@link DposSlot#getScheduledWitness(long)}.
   * <p>
   * Method under test: {@link DposSlot#getScheduledWitness(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString DposSlot.getScheduledWitness(long)"})
  public void testGetScheduledWitness2() {
    // Arrange
    DposSlot dposSlot = new DposSlot();
    dposSlot.setDposService(new DposService());
    ConsensusDelegate consensusDelegate = mock(ConsensusDelegate.class);
    when(consensusDelegate.getActiveWitnesses()).thenThrow(new RuntimeException("active witnesses is null."));
    when(consensusDelegate.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    ReflectionTestUtils.setField(dposSlot, "consensusDelegate", consensusDelegate);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dposSlot.getScheduledWitness(1L));
    verify(consensusDelegate).getActiveWitnesses();
    verify(consensusDelegate).getLatestBlockHeaderTimestamp();
  }

  /**
   * Test {@link DposSlot#getScheduledWitness(long)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ByteString}.</li>
   *   <li>Then calls {@link ConsensusDelegate#getActiveWitnesses()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposSlot#getScheduledWitness(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString DposSlot.getScheduledWitness(long)"})
  public void testGetScheduledWitness_givenArrayListAddByteString_thenCallsGetActiveWitnesses() {
    // Arrange
    DposSlot dposSlot = new DposSlot();
    dposSlot.setDposService(new DposService());

    ArrayList<ByteString> byteStringList = new ArrayList<>();
    byteStringList.add(mock(ByteString.class));
    ConsensusDelegate consensusDelegate = mock(ConsensusDelegate.class);
    when(consensusDelegate.getActiveWitnesses()).thenReturn(byteStringList);
    when(consensusDelegate.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    ReflectionTestUtils.setField(dposSlot, "consensusDelegate", consensusDelegate);

    // Act
    dposSlot.getScheduledWitness(1L);

    // Assert
    verify(consensusDelegate, atLeast(1)).getActiveWitnesses();
    verify(consensusDelegate).getLatestBlockHeaderTimestamp();
  }

  /**
   * Test {@link DposSlot#getScheduledWitness(long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposSlot#getScheduledWitness(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString DposSlot.getScheduledWitness(long)"})
  public void testGetScheduledWitness_thenThrowRuntimeException() {
    // Arrange
    DposSlot dposSlot = new DposSlot();
    dposSlot.setDposService(new DposService());
    ConsensusDelegate consensusDelegate = mock(ConsensusDelegate.class);
    when(consensusDelegate.getActiveWitnesses()).thenReturn(new ArrayList<>());
    when(consensusDelegate.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    ReflectionTestUtils.setField(dposSlot, "consensusDelegate", consensusDelegate);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dposSlot.getScheduledWitness(1L));
    verify(consensusDelegate).getActiveWitnesses();
    verify(consensusDelegate).getLatestBlockHeaderTimestamp();
  }
}
