package org.tron.consensus.dpos;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.consensus.ConsensusDelegate;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.WitnessCapsule;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class IncentiveManagerDiffblueTest {
  @Mock
  private ConsensusDelegate consensusDelegate;

  @InjectMocks
  private IncentiveManager incentiveManager;

  /**
   * Method under test: {@link IncentiveManager#reward(List)}
   */
  @Test
  public void testReward() {
    // Arrange
    when(consensusDelegate.allowChangeDelegation()).thenReturn(true);

    // Act
    incentiveManager.reward(new ArrayList<>());

    // Assert that nothing has changed
    verify(consensusDelegate).allowChangeDelegation();
  }

  /**
   * Method under test: {@link IncentiveManager#reward(List)}
   */
  @Test
  public void testReward2() {
    // Arrange
    when(consensusDelegate.allowChangeDelegation()).thenReturn(false);

    // Act
    incentiveManager.reward(new ArrayList<>());

    // Assert that nothing has changed
    verify(consensusDelegate).allowChangeDelegation();
  }

  /**
   * Method under test: {@link IncentiveManager#reward(List)}
   */
  @Test
  public void testReward3() {
    // Arrange
    when(consensusDelegate.allowChangeDelegation()).thenReturn(true);

    ArrayList<ByteString> witnesses = new ArrayList<>();
    witnesses.add(mock(ByteString.class));

    // Act
    incentiveManager.reward(witnesses);

    // Assert that nothing has changed
    verify(consensusDelegate).allowChangeDelegation();
  }

  /**
   * Method under test: {@link IncentiveManager#reward(List)}
   */
  @Test
  public void testReward4() {
    // Arrange
    when(consensusDelegate.allowChangeDelegation()).thenReturn(true);

    ArrayList<ByteString> witnesses = new ArrayList<>();
    witnesses.add(mock(ByteString.class));
    witnesses.add(mock(ByteString.class));

    // Act
    incentiveManager.reward(witnesses);

    // Assert that nothing has changed
    verify(consensusDelegate).allowChangeDelegation();
  }

  /**
   * Method under test: {@link IncentiveManager#reward(List)}
   */
  @Test
  public void testReward5() throws UnsupportedEncodingException {
    // Arrange
    when(consensusDelegate.getWitness(Mockito.<byte[]>any())).thenReturn(new WitnessCapsule(mock(ByteString.class)));
    when(consensusDelegate.allowChangeDelegation()).thenReturn(false);
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<ByteString> witnesses = new ArrayList<>();
    witnesses.add(byteString);

    // Act
    incentiveManager.reward(witnesses);

    // Assert that nothing has changed
    verify(byteString).toByteArray();
    verify(consensusDelegate).allowChangeDelegation();
    verify(consensusDelegate).getWitness(isA(byte[].class));
  }

  /**
   * Method under test: {@link IncentiveManager#reward(List)}
   */
  @Test
  public void testReward6() throws UnsupportedEncodingException {
    // Arrange
    WitnessCapsule witnessCapsule = mock(WitnessCapsule.class);
    when(witnessCapsule.getVoteCount()).thenReturn(3L);
    doNothing().when(consensusDelegate).saveAccount(Mockito.<AccountCapsule>any());
    when(consensusDelegate.getWitnessStandbyAllowance()).thenReturn(1L);
    when(consensusDelegate.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
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
    verify(witnessCapsule, atLeast(1)).getVoteCount();
  }

  /**
   * Method under test: {@link IncentiveManager#reward(List)}
   */
  @Test
  public void testReward7() throws UnsupportedEncodingException {
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

    // Assert that nothing has changed
    verify(byteString, atLeast(1)).toByteArray();
    verify(consensusDelegate).allowChangeDelegation();
    verify(consensusDelegate).getAccount(isA(byte[].class));
    verify(consensusDelegate, atLeast(1)).getWitness(isA(byte[].class));
    verify(consensusDelegate).getWitnessStandbyAllowance();
    verify(consensusDelegate).saveAccount(isA(AccountCapsule.class));
    verify(accountCapsule).getAllowance();
    verify(accountCapsule).setAllowance(eq(2L));
    verify(witnessCapsule, atLeast(1)).getVoteCount();
  }
}
