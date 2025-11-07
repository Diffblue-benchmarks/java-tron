package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.VotesCapsule;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.nativecontract.param.VoteWitnessParam;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Vote;

public class VoteWitnessProcessorDiffblueTest {
  /**
   * Test {@link VoteWitnessProcessor#validate(VoteWitnessParam, Repository)}.
   * <ul>
   *   <li>When {@link VoteWitnessParam} (default constructor).</li>
   *   <li>Then throw {@link ContractValidateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessProcessor#validate(VoteWitnessParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VoteWitnessProcessor.validate(VoteWitnessParam, Repository)"})
  public void testValidate_whenVoteWitnessParam_thenThrowContractValidateException() throws ContractValidateException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> voteWitnessProcessor.validate(new VoteWitnessParam(), null));
  }

  /**
   * Test {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}.
   * <ul>
   *   <li>Given {@link ArithmeticException#ArithmeticException(String)} with {@code Witness[}.</li>
   *   <li>Then calls {@link AccountCapsule#getVotesList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VoteWitnessProcessor.execute(VoteWitnessParam, Repository)"})
  public void testExecute_givenArithmeticExceptionWithWitness_thenCallsGetVotesList()
      throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Vote> voteList = new ArrayList<>();
    voteList.add(Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(param).addVote(Mockito.<byte[]>any(), anyLong());
    param.addVote("AXAXAXAX".getBytes("UTF-8"), -1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getVotesList()).thenReturn(new ArrayList<>());
    doNothing().when(accountCapsule).clearVotes();
    doNothing().when(accountCapsule).addDelegatedFrozenBalanceForBandwidth(anyLong());
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(1L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(null);

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(accountCapsule).addDelegatedFrozenBalanceForBandwidth(eq(1L));
    verify(accountCapsule).clearVotes();
    verify(accountCapsule).getVotesList();
    verify(param).addVote(isA(byte[].class), eq(-1L));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Test {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}.
   * <ul>
   *   <li>Given {@link ArithmeticException#ArithmeticException(String)} with {@code Witness[}.</li>
   *   <li>Then calls {@link AccountCapsule#getVotesList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VoteWitnessProcessor.execute(VoteWitnessParam, Repository)"})
  public void testExecute_givenArithmeticExceptionWithWitness_thenCallsGetVotesList2()
      throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Vote> voteList = new ArrayList<>();
    voteList.add(Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(param).addVote(Mockito.<byte[]>any(), anyLong());
    param.addVote("AXAXAXAX".getBytes("UTF-8"), -1L);

    ArrayList<Vote> voteList2 = new ArrayList<>();
    voteList2.add(Vote.getDefaultInstance());
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getVotesList()).thenReturn(voteList2);
    doNothing().when(accountCapsule).clearVotes();
    doNothing().when(accountCapsule).addDelegatedFrozenBalanceForBandwidth(anyLong());
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(1L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(null);

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(accountCapsule).addDelegatedFrozenBalanceForBandwidth(eq(1L));
    verify(accountCapsule).clearVotes();
    verify(accountCapsule).getVotesList();
    verify(param).addVote(isA(byte[].class), eq(-1L));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Test {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}.
   * <ul>
   *   <li>Given {@link VotesCapsule} {@link VotesCapsule#clearNewVotes()} does nothing.</li>
   *   <li>Then calls {@link VotesCapsule#clearNewVotes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VoteWitnessProcessor.execute(VoteWitnessParam, Repository)"})
  public void testExecute_givenVotesCapsuleClearNewVotesDoesNothing_thenCallsClearNewVotes()
      throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Vote> voteList = new ArrayList<>();
    voteList.add(Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(param).addVote(Mockito.<byte[]>any(), anyLong());
    param.addVote("AXAXAXAX".getBytes("UTF-8"), -1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doNothing().when(accountCapsule).clearVotes();
    doNothing().when(accountCapsule).addDelegatedFrozenBalanceForBandwidth(anyLong());
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(1L);
    VotesCapsule votesCapsule = mock(VotesCapsule.class);
    doNothing().when(votesCapsule).clearNewVotes();
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(votesCapsule);

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(accountCapsule).addDelegatedFrozenBalanceForBandwidth(eq(1L));
    verify(accountCapsule).clearVotes();
    verify(votesCapsule).clearNewVotes();
    verify(param).addVote(isA(byte[].class), eq(-1L));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Test {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}.
   * <ul>
   *   <li>When {@link RepositoryImpl} {@link RepositoryImpl#getWitness(byte[])} return {@code null}.</li>
   *   <li>Then calls {@link AccountCapsule#getVotesList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VoteWitnessProcessor.execute(VoteWitnessParam, Repository)"})
  public void testExecute_whenRepositoryImplGetWitnessReturnNull_thenCallsGetVotesList()
      throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Vote> voteList = new ArrayList<>();
    voteList.add(Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(param).addVote(Mockito.<byte[]>any(), anyLong());
    param.addVote("AXAXAXAX".getBytes("UTF-8"), -1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getVotesList()).thenReturn(new ArrayList<>());
    doNothing().when(accountCapsule).clearVotes();
    doNothing().when(accountCapsule).addDelegatedFrozenBalanceForBandwidth(anyLong());
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(1L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenReturn(null);
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(null);

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(accountCapsule).addDelegatedFrozenBalanceForBandwidth(eq(1L));
    verify(accountCapsule).clearVotes();
    verify(accountCapsule).getVotesList();
    verify(param).addVote(isA(byte[].class), eq(-1L));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }
}
