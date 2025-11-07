package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.DelegatedResourceCapsule;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.vm.nativecontract.param.UnDelegateResourceParam;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;
import org.tron.protos.contract.Common;

public class UnDelegateResourceProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link UnDelegateResourceProcessor#validate(UnDelegateResourceParam, Repository)}
   */
  @Test
  public void testValidate() throws ContractValidateException {
    // Arrange
    UnDelegateResourceProcessor unDelegateResourceProcessor = new UnDelegateResourceProcessor();

    UnDelegateResourceParam param = new UnDelegateResourceParam();
    param.setUnDelegateBalance(0L);
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    param.setReceiverAddress(null);
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> unDelegateResourceProcessor.validate(param, null));
  }

  /**
   * Method under test:
   * {@link UnDelegateResourceProcessor#execute(UnDelegateResourceParam, Repository)}
   */
  @Test
  public void testExecute() throws UnsupportedEncodingException {
    // Arrange
    UnDelegateResourceProcessor unDelegateResourceProcessor = new UnDelegateResourceProcessor();
    UnDelegateResourceParam param = mock(UnDelegateResourceParam.class);
    when(param.getResourceType()).thenReturn(Common.ResourceCode.TRON_POWER);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(param.getReceiverAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(param.getUnDelegateBalance()).thenReturn(42L);
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    doNothing().when(param).setReceiverAddress(Mockito.<byte[]>any());
    doNothing().when(param).setResourceType(Mockito.<Common.ResourceCode>any());
    doNothing().when(param).setUnDelegateBalance(anyLong());
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setReceiverAddress("AXAXAXAX".getBytes("UTF-8"));
    param.setResourceType(Common.ResourceCode.BANDWIDTH);
    param.setUnDelegateBalance(42L);
    DelegatedResourceCapsule delegatedResourceCapsule = mock(DelegatedResourceCapsule.class);
    when(delegatedResourceCapsule.getFrozenBalanceForBandwidth()).thenReturn(1L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).updateAccount(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    doNothing().when(repo).updateDelegatedResource(Mockito.<byte[]>any(), Mockito.<DelegatedResourceCapsule>any());
    when(repo.getHeadSlot()).thenReturn(1L);
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(new AccountCapsule(Protocol.Account.getDefaultInstance()));
    when(repo.getDelegatedResource(Mockito.<byte[]>any())).thenReturn(delegatedResourceCapsule);
    when(repo.getDynamicPropertiesStore()).thenReturn(null);

    // Act
    unDelegateResourceProcessor.execute(param, repo);

    // Assert
    verify(delegatedResourceCapsule).getFrozenBalanceForBandwidth();
    verify(param).getOwnerAddress();
    verify(param).getReceiverAddress();
    verify(param, atLeast(1)).getResourceType();
    verify(param).getUnDelegateBalance();
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(param).setReceiverAddress(isA(byte[].class));
    verify(param).setResourceType(eq(Common.ResourceCode.BANDWIDTH));
    verify(param).setUnDelegateBalance(eq(42L));
    verify(repo, atLeast(1)).getAccount(Mockito.<byte[]>any());
    verify(repo).getDelegatedResource(isA(byte[].class));
    verify(repo).getDynamicPropertiesStore();
    verify(repo).getHeadSlot();
    verify(repo, atLeast(1)).updateAccount(isA(byte[].class), isA(AccountCapsule.class));
    verify(repo).updateDelegatedResource(isA(byte[].class), isA(DelegatedResourceCapsule.class));
  }
}
