package org.tron.consensus.dpos;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @Mock
  private ConsensusDelegate consensusDelegate;

  @Mock
  private DposSlot dposSlot;

  @InjectMocks
  private StatisticManager statisticManager;

  /**
   * Test {@link StatisticManager#applyBlock(BlockCapsule)}.
   * <p>
   * Method under test: {@link StatisticManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatisticManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(consensusDelegate).applyBlock(anyBoolean());
    doNothing().when(consensusDelegate).saveWitness(Mockito.<WitnessCapsule>any());
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(new WitnessCapsule(mock(ByteString.class)));
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
  }

  /**
   * Test {@link StatisticManager#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@link DposSlot} {@link DposSlot#getSlot(long)} return one.</li>
   *   <li>Then calls {@link DposSlot#getSlot(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatisticManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenDposSlotGetSlotReturnOne_thenCallsGetSlot() throws UnsupportedEncodingException {
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
    when(blockCapsule.getWitnessAddress()).thenReturn(byteString);
    when(blockCapsule.getNum()).thenReturn(2L);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);

    // Act
    statisticManager.applyBlock(blockCapsule);

    // Assert
    verify(byteString).toByteArray();
    verify(consensusDelegate).applyBlock(eq(true));
    verify(consensusDelegate).getWitness(isA(byte[].class));
    verify(consensusDelegate).saveWitness(isA(WitnessCapsule.class));
    verify(dposSlot).getAbSlot(eq(10L));
    verify(dposSlot).getSlot(eq(10L));
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
    verify(blockCapsule).getWitnessAddress();
    verify(witnessCapsule).getTotalProduced();
    verify(witnessCapsule).setLatestBlockNum(eq(2L));
    verify(witnessCapsule).setLatestSlotNum(eq(1L));
    verify(witnessCapsule).setTotalProduced(eq(2L));
  }

  /**
   * Test {@link StatisticManager#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link WitnessCapsule#getTotalProduced()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatisticManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenOne_thenCallsGetTotalProduced() throws UnsupportedEncodingException {
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
   * Test {@link StatisticManager#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@code X}.</li>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getNum()} return one.</li>
   *   <li>Then calls {@link WitnessCapsule#getTotalProduced()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatisticManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenX_whenBlockCapsuleGetNumReturnOne_thenCallsGetTotalProduced() {
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

  /**
   * Test {@link StatisticManager#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Then calls {@link DposSlot#getScheduledWitness(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatisticManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_thenCallsGetScheduledWitness() throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    WitnessCapsule witnessCapsule = mock(WitnessCapsule.class);
    when(witnessCapsule.getAddress()).thenReturn(byteString);
    when(witnessCapsule.getTotalMissed()).thenReturn(1L);
    doNothing().when(witnessCapsule).setTotalMissed(anyLong());
    when(witnessCapsule.getTotalProduced()).thenReturn(1L);
    doNothing().when(witnessCapsule).setLatestBlockNum(anyLong());
    doNothing().when(witnessCapsule).setLatestSlotNum(anyLong());
    doNothing().when(witnessCapsule).setTotalProduced(anyLong());
    doNothing().when(consensusDelegate).applyBlock(anyBoolean());
    doNothing().when(consensusDelegate).saveWitness(Mockito.<WitnessCapsule>any());
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(witnessCapsule);
    ByteString byteString2 = mock(ByteString.class);
    when(byteString2.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dposSlot.getScheduledWitness(anyLong())).thenReturn(byteString2);
    when(dposSlot.getSlot(anyLong())).thenReturn(2L);
    when(dposSlot.getAbSlot(anyLong())).thenReturn(1L);
    ByteString byteString3 = mock(ByteString.class);
    when(byteString3.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getWitnessAddress()).thenReturn(byteString3);
    when(blockCapsule.getNum()).thenReturn(2L);
    when(blockCapsule.getTimeStamp()).thenReturn(10L);

    // Act
    statisticManager.applyBlock(blockCapsule);

    // Assert
    verify(byteString2).toByteArray();
    verify(byteString3).toByteArray();
    verify(byteString, atLeast(1)).toByteArray();
    verify(consensusDelegate, atLeast(1)).applyBlock(anyBoolean());
    verify(consensusDelegate, atLeast(1)).getWitness(Mockito.<byte[]>any());
    verify(consensusDelegate, atLeast(1)).saveWitness(isA(WitnessCapsule.class));
    verify(dposSlot).getAbSlot(eq(10L));
    verify(dposSlot).getScheduledWitness(eq(1L));
    verify(dposSlot).getSlot(eq(10L));
    verify(blockCapsule).getNum();
    verify(blockCapsule).getTimeStamp();
    verify(blockCapsule).getWitnessAddress();
    verify(witnessCapsule, atLeast(1)).getAddress();
    verify(witnessCapsule, atLeast(1)).getTotalMissed();
    verify(witnessCapsule).getTotalProduced();
    verify(witnessCapsule).setLatestBlockNum(eq(2L));
    verify(witnessCapsule).setLatestSlotNum(eq(1L));
    verify(witnessCapsule).setTotalMissed(eq(2L));
    verify(witnessCapsule).setTotalProduced(eq(2L));
  }
}
