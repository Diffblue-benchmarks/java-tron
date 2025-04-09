package org.tron.core.metrics.blockchain;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.TransactionCapsule;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BlockChainMetricManagerDiffblueTest {
  @InjectMocks
  private BlockChainMetricManager blockChainMetricManager;

  /**
   * Test {@link BlockChainMetricManager#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getTimeStamp()} return ten.</li>
   *   <li>Then calls {@link ByteString#toByteArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockChainMetricManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockChainMetricManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenA_whenBlockCapsuleGetTimeStampReturnTen_thenCallsToByteArray() {
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
   * Test {@link BlockChainMetricManager#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getTimeStamp()} return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockChainMetricManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockChainMetricManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenArrayListAddNull_whenBlockCapsuleGetTimeStampReturnTen()
      throws UnsupportedEncodingException {
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
   * Test {@link BlockChainMetricManager#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getTimeStamp()} return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockChainMetricManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockChainMetricManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenArrayList_whenBlockCapsuleGetTimeStampReturnTen()
      throws UnsupportedEncodingException {
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
   * Test {@link BlockChainMetricManager#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given {@link Long#MAX_VALUE}.</li>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getTimeStamp()} return {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockChainMetricManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockChainMetricManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenMax_value_whenBlockCapsuleGetTimeStampReturnMax_value()
      throws UnsupportedEncodingException {
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
   * Test {@link BlockChainMetricManager#applyBlock(BlockCapsule)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getTimeStamp()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockChainMetricManager#applyBlock(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BlockChainMetricManager.applyBlock(BlockCapsule)"})
  public void testApplyBlock_givenOne_whenBlockCapsuleGetTimeStampReturnOne() throws UnsupportedEncodingException {
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlockChainMetricManager#setFailProcessBlockNum(long)}
   *   <li>{@link BlockChainMetricManager#setFailProcessBlockReason(String)}
   *   <li>{@link BlockChainMetricManager#getDupWitnessBlockNum()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map BlockChainMetricManager.getDupWitnessBlockNum()",
      "void BlockChainMetricManager.setFailProcessBlockNum(long)",
      "void BlockChainMetricManager.setFailProcessBlockReason(String)"})
  public void testGettersAndSetters() {
    // Arrange
    BlockChainMetricManager blockChainMetricManager = new BlockChainMetricManager();

    // Act
    blockChainMetricManager.setFailProcessBlockNum(1L);
    blockChainMetricManager.setFailProcessBlockReason("Just cause");

    // Assert
    assertTrue(blockChainMetricManager.getDupWitnessBlockNum().isEmpty());
  }
}
