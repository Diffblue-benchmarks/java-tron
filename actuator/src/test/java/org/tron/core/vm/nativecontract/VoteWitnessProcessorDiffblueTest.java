package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.VotesCapsule;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.nativecontract.param.VoteWitnessParam;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;
import org.tron.protos.contract.AccountContract;
import org.tron.protos.contract.Common;

public class VoteWitnessProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link VoteWitnessProcessor#validate(VoteWitnessParam, Repository)}
   */
  @Test
  public void testValidate() throws ContractValidateException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> voteWitnessProcessor.validate(new VoteWitnessParam(), null));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(new ArrayList<>());
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getDynamicPropertiesStore()).thenThrow(new ArithmeticException("foo"));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getDynamicPropertiesStore();
    verify(repo).getVotes(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute2() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenReturn(null);
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute3() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute4() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(AccountContract.AccountCreateContract.getDefaultInstance()));
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute5() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addDelegatedFrozenBalanceForBandwidth(2L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute6() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addDelegatedFrozenV2BalanceForBandwidth(2L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute7() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addFrozenBalanceForBandwidthV2(2L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute8() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAcquiredDelegatedFrozenBalanceForBandwidth(2L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute9() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAcquiredDelegatedFrozenV2BalanceForBandwidth(2L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute10() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAcquiredDelegatedFrozenBalanceForEnergy(2L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute11() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addVotes(mock(ByteString.class), -17L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute12() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addUnfrozenV2List(Common.ResourceCode.ENERGY, -17L, -17L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute13() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAssetAmount(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 2L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute14() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAssetMapV2(new HashMap<>());
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute15() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAllLatestAssetOperationTimeV2(new HashMap<>());
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute16() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.putLatestAssetOperationTimeMap("42", 2L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute17() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAllFreeAssetNetUsageV2(new HashMap<>());
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute18() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.putFreeAssetNetUsage("42", -17L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute19() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doNothing().when(accountCapsule).clearVotes();
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(new VotesCapsule(Protocol.Votes.getDefaultInstance()));

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(accountCapsule).clearVotes();
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute20() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getVotesList()).thenReturn(new ArrayList<>());
    doNothing().when(accountCapsule).clearVotes();
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(null);

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(accountCapsule).clearVotes();
    verify(accountCapsule).getVotesList();
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute21() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<Protocol.Vote> voteList2 = new ArrayList<>();
    voteList2.add(Protocol.Vote.getDefaultInstance());
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getVotesList()).thenReturn(voteList2);
    doNothing().when(accountCapsule).clearVotes();
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(null);

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(accountCapsule).clearVotes();
    verify(accountCapsule).getVotesList();
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link VoteWitnessProcessor#execute(VoteWitnessParam, Repository)}
   */
  @Test
  public void testExecute22() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    VoteWitnessProcessor voteWitnessProcessor = new VoteWitnessProcessor();

    ArrayList<Protocol.Vote> voteList = new ArrayList<>();
    voteList.add(Protocol.Vote.getDefaultInstance());
    VoteWitnessParam param = mock(VoteWitnessParam.class);
    when(param.getVotes()).thenReturn(voteList);
    when(param.getVoterAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    doNothing().when(accountCapsule).clearVotes();
    VotesCapsule votesCapsule = mock(VotesCapsule.class);
    doNothing().when(votesCapsule).clearNewVotes();
    RepositoryImpl repo = mock(RepositoryImpl.class);
    when(repo.getWitness(Mockito.<byte[]>any())).thenThrow(new ArithmeticException("Witness["));
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getVotes(Mockito.<byte[]>any())).thenReturn(votesCapsule);

    // Act and Assert
    assertThrows(ContractExeException.class, () -> voteWitnessProcessor.execute(param, repo));
    verify(accountCapsule).clearVotes();
    verify(votesCapsule).clearNewVotes();
    verify(param).getVoterAddress();
    verify(param).getVotes();
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getVotes(isA(byte[].class));
    verify(repo).getWitness(isA(byte[].class));
  }
}
