package org.tron.core.metrics.blockchain;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.TransactionCapsule;
import org.tron.core.db.Manager;

@RunWith(MockitoJUnitRunner.class)
public class BlockChainMetricManagerDiffblueTest {
  @InjectMocks
  private BlockChainMetricManager blockChainMetricManager;

  @Mock
  private ChainBaseManager chainBaseManager;

  @Mock
  private Manager manager;

  /**
   * Method under test: {@link BlockChainMetricManager#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock() throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getTransactions()).thenReturn(new ArrayList<>());
    when(block.getTimeStamp()).thenReturn(10L);
    when(block.getWitnessAddress()).thenReturn(byteString);

    // Act
    blockChainMetricManager.applyBlock(block);

    // Assert
    verify(byteString).toByteArray();
    verify(block).getTimeStamp();
    verify(block).getTransactions();
    verify(block).getWitnessAddress();
  }

  /**
   * Method under test: {@link BlockChainMetricManager#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock2() throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getTransactions()).thenReturn(new ArrayList<>());
    when(block.getTimeStamp()).thenReturn(Long.MAX_VALUE);
    when(block.getWitnessAddress()).thenReturn(byteString);

    // Act
    blockChainMetricManager.applyBlock(block);

    // Assert
    verify(byteString).toByteArray();
    verify(block).getTimeStamp();
    verify(block).getTransactions();
    verify(block).getWitnessAddress();
  }

  /**
   * Method under test: {@link BlockChainMetricManager#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock3() {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getTransactions()).thenReturn(new ArrayList<>());
    when(block.getTimeStamp()).thenReturn(10L);
    when(block.getWitnessAddress()).thenReturn(byteString);

    // Act
    blockChainMetricManager.applyBlock(block);

    // Assert
    verify(byteString).toByteArray();
    verify(block).getTimeStamp();
    verify(block).getTransactions();
    verify(block).getWitnessAddress();
  }

  /**
   * Method under test: {@link BlockChainMetricManager#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock4() throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<TransactionCapsule> transactionCapsuleList = new ArrayList<>();
    transactionCapsuleList.add(null);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getTransactions()).thenReturn(transactionCapsuleList);
    when(block.getTimeStamp()).thenReturn(10L);
    when(block.getWitnessAddress()).thenReturn(byteString);

    // Act
    blockChainMetricManager.applyBlock(block);

    // Assert
    verify(byteString).toByteArray();
    verify(block).getTimeStamp();
    verify(block, atLeast(1)).getTransactions();
    verify(block).getWitnessAddress();
  }

  /**
   * Method under test: {@link BlockChainMetricManager#applyBlock(BlockCapsule)}
   */
  @Test
  public void testApplyBlock5() throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<TransactionCapsule> transactionCapsuleList = new ArrayList<>();
    transactionCapsuleList.add(null);
    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getTransactions()).thenReturn(transactionCapsuleList);
    when(block.getTimeStamp()).thenReturn(1L);
    when(block.getWitnessAddress()).thenReturn(byteString);

    // Act
    blockChainMetricManager.applyBlock(block);

    // Assert
    verify(byteString).toByteArray();
    verify(block).getTimeStamp();
    verify(block, atLeast(1)).getTransactions();
    verify(block).getWitnessAddress();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BlockChainMetricManager#setFailProcessBlockNum(long)}
   *   <li>{@link BlockChainMetricManager#setFailProcessBlockReason(String)}
   *   <li>{@link BlockChainMetricManager#getDupWitnessBlockNum()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BlockChainMetricManager blockChainMetricManager = new BlockChainMetricManager();

    // Act
    blockChainMetricManager.setFailProcessBlockNum(1L);
    blockChainMetricManager.setFailProcessBlockReason("Just cause");

    // Assert that nothing has changed
    assertTrue(blockChainMetricManager.getDupWitnessBlockNum().isEmpty());
  }
}
