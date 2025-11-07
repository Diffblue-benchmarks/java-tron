package org.tron.consensus.dpos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import org.junit.Test;
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
   * Method under test: {@link DposSlot#getAbSlot(long)}
   */
  @Test
  public void testGetAbSlot() {
    // Arrange
    DposSlot dposSlot = new DposSlot();
    dposSlot.setDposService(new DposService());
    ReflectionTestUtils.setField(dposSlot, "consensusDelegate", mock(ConsensusDelegate.class));

    // Act and Assert
    assertEquals(0L, dposSlot.getAbSlot(10L));
  }

  /**
   * Method under test: {@link DposSlot#getSlot(long)}
   */
  @Test
  public void testGetSlot() {
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
   * Method under test: {@link DposSlot#getTime(long)}
   */
  @Test
  public void testGetTime() {
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
   * Method under test: {@link DposSlot#getScheduledWitness(long)}
   */
  @Test
  public void testGetScheduledWitness() {
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

  /**
   * Method under test: {@link DposSlot#getScheduledWitness(long)}
   */
  @Test
  public void testGetScheduledWitness2() {
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
   * Method under test: {@link DposSlot#getScheduledWitness(long)}
   */
  @Test
  public void testGetScheduledWitness3() {
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
   * Method under test: {@link DposSlot#getScheduledWitness(long)}
   */
  @Test
  public void testGetScheduledWitness4() {
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
}
