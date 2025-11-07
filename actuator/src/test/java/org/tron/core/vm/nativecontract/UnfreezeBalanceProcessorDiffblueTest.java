package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.BytesCapsule;
import org.tron.core.capsule.DelegatedResourceCapsule;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.nativecontract.param.UnfreezeBalanceParam;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;
import org.tron.protos.contract.Common;

public class UnfreezeBalanceProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#validate(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testValidate() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> unfreezeBalanceProcessor.validate(param, null));
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute2() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("\bXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository, atLeast(1)).getAccount(Mockito.<byte[]>any());
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute3() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.ENERGY);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute4() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(new BytesCapsule(null));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> unfreezeBalanceProcessor.execute(param, new RepositoryImpl(StoreFactory.getInstance(), repository)));
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute5() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(new BytesCapsule(new byte[]{}));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(0L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute6() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(mock(ByteString.class), mock(ByteString.class)));
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute7() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(
        Protocol.DelegatedResource.getDefaultInstance());
    delegatedResourceCapsule.addFrozenBalanceForEnergy(8L, 8L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any())).thenReturn(delegatedResourceCapsule);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute8() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(
        Protocol.DelegatedResource.getDefaultInstance());
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(1L, 8L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any())).thenReturn(delegatedResourceCapsule);
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(1L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute9() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addDelegatedFrozenV2BalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute10() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addFrozenBalanceForBandwidthV2(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute11() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAcquiredDelegatedFrozenBalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute12() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAcquiredDelegatedFrozenV2BalanceForBandwidth(42L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute13() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addUnfrozenV2List(Common.ResourceCode.BANDWIDTH, 8L, 8L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute14() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.addAssetAmount("A\bA\bA\bA\b".getBytes("UTF-8"), 10L);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute15() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));

    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);
    repo.addBalance("A\bA\bA\bA\b".getBytes("UTF-8"), 42L);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository, atLeast(1)).getAccount(Mockito.<byte[]>any());
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute16() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAccountName("A\bA\bA\bA\b".getBytes("UTF-8"));
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute17() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAccountId("A\bA\bA\bA\b".getBytes("UTF-8"));
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute18() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute19() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setLatestOperationTime(8L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute20() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setLatestConsumeTime(8L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute21() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setLatestConsumeFreeTime(8L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute22() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAssetOptimized(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute23() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAssetIssuedName("A\bA\bA\bA\b".getBytes("UTF-8"));
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute24() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAssetIssuedID("A\bA\bA\bA\b".getBytes("UTF-8"));
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute25() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setAllowance(8L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute26() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setLatestWithdrawTime(8L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute27() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setIsWitness(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute28() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setIsCommittee(true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute29() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setFrozen(42L, 8L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute30() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setNetUsage(8L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute31() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setFreeNetUsage(8L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute32() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setNewWindowSize(Common.ResourceCode.BANDWIDTH, 3L);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute33() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setWindowOptimized(Common.ResourceCode.BANDWIDTH, true);
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository).getAccount(isA(byte[].class));
    verify(repository).getDelegatedResource(isA(byte[].class));
    verify(repository).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }

  /**
   * Method under test:
   * {@link UnfreezeBalanceProcessor#execute(UnfreezeBalanceParam, Repository)}
   */
  @Test
  public void testExecute34() throws UnsupportedEncodingException {
    // Arrange
    UnfreezeBalanceProcessor unfreezeBalanceProcessor = new UnfreezeBalanceProcessor();

    UnfreezeBalanceParam param = new UnfreezeBalanceParam();
    param.setDelegating(true);
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule accountCapsule = new AccountCapsule(Protocol.Account.getDefaultInstance());
    accountCapsule.setDefaultWitnessPermission(dynamicPropertiesStore);
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    RepositoryImpl repository2 = mock(RepositoryImpl.class);
    when(repository2.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    when(repository2.getDelegatedResource(Mockito.<byte[]>any()))
        .thenReturn(new DelegatedResourceCapsule(Protocol.DelegatedResource.getDefaultInstance()));
    when(repository2.getAccount(Mockito.<byte[]>any()))
        .thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    RepositoryImpl repository3 = new RepositoryImpl(StoreFactory.getInstance(), repository2);

    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), repository);
    repo.setParent(repository3);

    // Act
    long actualExecuteResult = unfreezeBalanceProcessor.execute(param, repo);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
    verify(repository2).getAccount(isA(byte[].class));
    verify(repository2).getDelegatedResource(isA(byte[].class));
    verify(repository2).getDynamicProperty(isA(byte[].class));
    assertEquals(0L, actualExecuteResult);
    assertEquals(4708585257725083992L, repo.getTotalNetWeight());
  }
}
