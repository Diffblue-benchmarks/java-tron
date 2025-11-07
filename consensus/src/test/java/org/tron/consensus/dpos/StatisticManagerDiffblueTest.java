package org.tron.consensus.dpos;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.consensus.ConsensusDelegate;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.WitnessCapsule;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class StatisticManagerDiffblueTest {
  @Mock
  private ConsensusDelegate consensusDelegate;

  @Mock
  private DposSlot dposSlot;

  @InjectMocks
  private StatisticManager statisticManager;

  /**
   * Method under test: {@link StatisticManager#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock() {
    // Arrange
    doNothing().when(consensusDelegate).applyBlock(anyBoolean());
    doNothing().when(consensusDelegate).saveWitness(Mockito.<WitnessCapsule>any());
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(new WitnessCapsule(mock(ByteString.class)));
    when(dposSlot.getAbSlot(anyLong())).thenReturn(1L);
    when(dposSlot.getSlot(anyLong())).thenReturn(1L);

    // Act
    statisticManager.applyBlock(new BlockCapsule(Protocol.Block.getDefaultInstance()));

    // Assert
    verify(consensusDelegate).applyBlock(eq(true));
    verify(consensusDelegate).getWitness(isA(byte[].class));
    verify(consensusDelegate).saveWitness(isA(WitnessCapsule.class));
    verify(dposSlot).getAbSlot(eq(0L));
    verify(dposSlot).getSlot(eq(0L));
  }

  /**
   * Method under test: {@link StatisticManager#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock2() {
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
    when(dposSlot.getSlot(anyLong())).thenReturn(1L);

    // Act
    statisticManager.applyBlock(new BlockCapsule(Protocol.Block.getDefaultInstance()));

    // Assert
    verify(consensusDelegate).applyBlock(eq(true));
    verify(consensusDelegate).getWitness(isA(byte[].class));
    verify(consensusDelegate).saveWitness(isA(WitnessCapsule.class));
    verify(dposSlot).getAbSlot(eq(0L));
    verify(dposSlot).getSlot(eq(0L));
    verify(witnessCapsule).getTotalProduced();
    verify(witnessCapsule).setLatestBlockNum(eq(0L));
    verify(witnessCapsule).setLatestSlotNum(eq(1L));
    verify(witnessCapsule).setTotalProduced(eq(2L));
  }

  /**
   * Method under test: {@link StatisticManager#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock3() throws UnsupportedEncodingException {
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
    when(blockCapsule.getWitnessAddress()).thenReturn(byteString);
    when(blockCapsule.getNum()).thenReturn(1L);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);

    // Act
    statisticManager.applyBlock(blockCapsule);

    // Assert
    verify(byteString).toByteArray();
    verify(consensusDelegate).applyBlock(eq(true));
    verify(consensusDelegate).getWitness(isA(byte[].class));
    verify(consensusDelegate).saveWitness(isA(WitnessCapsule.class));
    verify(dposSlot).getAbSlot(eq(10L));
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
    verify(blockCapsule).getWitnessAddress();
    verify(witnessCapsule).getTotalProduced();
    verify(witnessCapsule).setLatestBlockNum(eq(1L));
    verify(witnessCapsule).setLatestSlotNum(eq(1L));
    verify(witnessCapsule).setTotalProduced(eq(2L));
  }

  /**
   * Method under test: {@link StatisticManager#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock4() {
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
    when(byteString.toByteArray()).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getWitnessAddress()).thenReturn(byteString);
    when(blockCapsule.getNum()).thenReturn(1L);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);

    // Act
    statisticManager.applyBlock(blockCapsule);

    // Assert
    verify(byteString).toByteArray();
    verify(consensusDelegate).applyBlock(eq(true));
    verify(consensusDelegate).getWitness(isA(byte[].class));
    verify(consensusDelegate).saveWitness(isA(WitnessCapsule.class));
    verify(dposSlot).getAbSlot(eq(10L));
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
    verify(blockCapsule).getWitnessAddress();
    verify(witnessCapsule).getTotalProduced();
    verify(witnessCapsule).setLatestBlockNum(eq(1L));
    verify(witnessCapsule).setLatestSlotNum(eq(1L));
    verify(witnessCapsule).setTotalProduced(eq(2L));
  }
}
