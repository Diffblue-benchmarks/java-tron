package org.tron.consensus.dpos;

import static org.mockito.ArgumentMatchers.isA;
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
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.consensus.ConsensusDelegate;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.WitnessCapsule;

@RunWith(MockitoJUnitRunner.class)
public class IncentiveManagerDiffblueTest {
  @Mock private ConsensusDelegate consensusDelegate;

  @InjectMocks private IncentiveManager incentiveManager;

  /**
   * Test {@link IncentiveManager#reward(List)}.
   *
   * <ul>
   *   <li>Given {@link AccountCapsule} {@link AccountCapsule#getAllowance()} return one.
   *   <li>Then calls {@link ByteString#toByteArray()}.
   * </ul>
   *
   * <p>Method under test: {@link IncentiveManager#reward(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncentiveManager.reward(List)"})
  public void testReward_givenAccountCapsuleGetAllowanceReturnOne_thenCallsToByteArray()
      throws UnsupportedEncodingException {
    // Arrange
    WitnessCapsule witnessCapsule = mock(WitnessCapsule.class);
    when(witnessCapsule.getVoteCount()).thenReturn(3L);

    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAllowance()).thenReturn(1L);
    doNothing().when(accountCapsule).setAllowance(anyLong());
    doNothing().when(consensusDelegate).saveAccount(Mockito.<AccountCapsule>any());
    when(consensusDelegate.getWitnessStandbyAllowance()).thenReturn(1L);
    when(consensusDelegate.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(witnessCapsule);
    when(consensusDelegate.allowChangeDelegation()).thenReturn(false);

    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<ByteString> witnesses = new ArrayList<>();
    witnesses.add(byteString);

    // Act
    incentiveManager.reward(witnesses);

    // Assert
    verify(byteString, atLeast(1)).toByteArray();
    verify(consensusDelegate).allowChangeDelegation();
    verify(consensusDelegate).getAccount(isA(byte[].class));
    verify(consensusDelegate, atLeast(1)).getWitness(isA(byte[].class));
    verify(consensusDelegate).getWitnessStandbyAllowance();
    verify(consensusDelegate).saveAccount(isA(AccountCapsule.class));
    verify(accountCapsule).getAllowance();
    verify(accountCapsule).setAllowance(2L);
    verify(witnessCapsule, atLeast(1)).getVoteCount();
  }

  /**
   * Test {@link IncentiveManager#reward(List)}.
   *
   * <ul>
   *   <li>Given {@link ByteString}.
   *   <li>Then calls {@link ConsensusDelegate#allowChangeDelegation()}.
   * </ul>
   *
   * <p>Method under test: {@link IncentiveManager#reward(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncentiveManager.reward(List)"})
  public void testReward_givenByteString_thenCallsAllowChangeDelegation() {
    // Arrange
    when(consensusDelegate.allowChangeDelegation()).thenReturn(true);

    ArrayList<ByteString> witnesses = new ArrayList<>();
    witnesses.add(mock(ByteString.class));

    // Act
    incentiveManager.reward(witnesses);

    // Assert
    verify(consensusDelegate).allowChangeDelegation();
  }

  /**
   * Test {@link IncentiveManager#reward(List)}.
   *
   * <ul>
   *   <li>Given {@link ByteString}.
   *   <li>Then calls {@link ConsensusDelegate#allowChangeDelegation()}.
   * </ul>
   *
   * <p>Method under test: {@link IncentiveManager#reward(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncentiveManager.reward(List)"})
  public void testReward_givenByteString_thenCallsAllowChangeDelegation2() {
    // Arrange
    when(consensusDelegate.allowChangeDelegation()).thenReturn(true);

    ArrayList<ByteString> witnesses = new ArrayList<>();
    witnesses.add(mock(ByteString.class));
    witnesses.add(mock(ByteString.class));

    // Act
    incentiveManager.reward(witnesses);

    // Assert
    verify(consensusDelegate).allowChangeDelegation();
  }

  /**
   * Test {@link IncentiveManager#reward(List)}.
   *
   * <ul>
   *   <li>Given {@link ConsensusDelegate} {@link ConsensusDelegate#allowChangeDelegation()} return
   *       {@code true}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link IncentiveManager#reward(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncentiveManager.reward(List)"})
  public void testReward_givenConsensusDelegateAllowChangeDelegationReturnTrue_whenArrayList() {
    // Arrange
    when(consensusDelegate.allowChangeDelegation()).thenReturn(true);

    // Act
    incentiveManager.reward(new ArrayList<>());

    // Assert
    verify(consensusDelegate).allowChangeDelegation();
  }

  /**
   * Test {@link IncentiveManager#reward(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link ConsensusDelegate#allowChangeDelegation()}.
   * </ul>
   *
   * <p>Method under test: {@link IncentiveManager#reward(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IncentiveManager.reward(List)"})
  public void testReward_whenArrayList_thenCallsAllowChangeDelegation() {
    // Arrange
    when(consensusDelegate.allowChangeDelegation()).thenReturn(false);

    // Act
    incentiveManager.reward(new ArrayList<>());

    // Assert
    verify(consensusDelegate).allowChangeDelegation();
  }
}
