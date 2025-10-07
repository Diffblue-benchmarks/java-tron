package org.tron.consensus.dpos;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.consensus.ConsensusDelegate;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.WitnessCapsule;

@RunWith(MockitoJUnitRunner.class)
public class StatisticManagerDiffblueTest {
  @Mock private ConsensusDelegate consensusDelegate;

  @Mock private DposSlot dposSlot;

  @InjectMocks private StatisticManager statisticManager;

  /**
   * Test {@link StatisticManager#applyBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link DposSlot} {@link DposSlot#getSlot(long)} return one.
   *   <li>Then calls {@link DposSlot#getSlot(long)}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatisticManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenDposSlotGetSlotReturnOne_thenCallsGetSlot()
      throws UnsupportedEncodingException {
    // Arrange
    WitnessCapsule witnessCapsule = mock(WitnessCapsule.class);
    when(witnessCapsule.getTotalProduced()).thenReturn(1L);
    doNothing().when(witnessCapsule).setLatestBlockNum(anyLong());
    doNothing().when(witnessCapsule).setLatestSlotNum(anyLong());
    doNothing().when(witnessCapsule).setTotalProduced(anyLong());
    doNothing().when(consensusDelegate).applyBlock(anyBoolean());
    doNothing().when(consensusDelegate).saveWitness(Mockito.<WitnessCapsule>any());
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(witnessCapsule);
    when(dposSlot.getSlot(anyLong())).thenReturn(1L);
    when(dposSlot.getAbSlot(anyLong())).thenReturn(1L);

    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(2L);
    when(blockCapsule.getWitnessAddress()).thenReturn(byteString);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);

    // Act
    statisticManager.applyBlock(blockCapsule);

    // Assert
    verify(byteString).toByteArray();
    verify(consensusDelegate).applyBlock(true);
    verify(consensusDelegate).getWitness(isA(byte[].class));
    verify(consensusDelegate).saveWitness(isA(WitnessCapsule.class));
    verify(dposSlot).getAbSlot(10L);
    verify(dposSlot).getSlot(10L);
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
    verify(blockCapsule).getWitnessAddress();
    verify(witnessCapsule).getTotalProduced();
    verify(witnessCapsule).setLatestBlockNum(2L);
    verify(witnessCapsule).setLatestSlotNum(1L);
    verify(witnessCapsule).setTotalProduced(2L);
  }

  /**
   * Test {@link StatisticManager#applyBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link WitnessCapsule} {@link WitnessCapsule#getTotalProduced()} return one.
   *   <li>Then calls {@link ByteString#toByteArray()}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatisticManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenWitnessCapsuleGetTotalProducedReturnOne_thenCallsToByteArray()
      throws UnsupportedEncodingException {
    // Arrange
    WitnessCapsule witnessCapsule = mock(WitnessCapsule.class);
    when(witnessCapsule.getTotalProduced()).thenReturn(1L);
    doNothing().when(witnessCapsule).setLatestBlockNum(anyLong());
    doNothing().when(witnessCapsule).setLatestSlotNum(anyLong());
    doNothing().when(witnessCapsule).setTotalProduced(anyLong());
    doNothing().when(consensusDelegate).applyBlock(anyBoolean());
    doNothing().when(consensusDelegate).saveWitness(Mockito.<WitnessCapsule>any());
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(witnessCapsule);
    when(dposSlot.getAbSlot(anyLong())).thenReturn(1L);

    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getNum()).thenReturn(1L);
    when(blockCapsule.getWitnessAddress()).thenReturn(byteString);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);

    // Act
    statisticManager.applyBlock(blockCapsule);

    // Assert
    verify(byteString).toByteArray();
    verify(consensusDelegate).applyBlock(true);
    verify(consensusDelegate).getWitness(isA(byte[].class));
    verify(consensusDelegate).saveWitness(isA(WitnessCapsule.class));
    verify(dposSlot).getAbSlot(10L);
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
    verify(blockCapsule).getWitnessAddress();
    verify(witnessCapsule).getTotalProduced();
    verify(witnessCapsule).setLatestBlockNum(1L);
    verify(witnessCapsule).setLatestSlotNum(1L);
    verify(witnessCapsule).setTotalProduced(2L);
  }
}
