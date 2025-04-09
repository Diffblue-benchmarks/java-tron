package org.tron.core.vm.nativecontract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
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
import org.tron.core.capsule.BytesCapsule;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.nativecontract.param.CancelAllUnfreezeV2Param;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Account;
import org.tron.protos.Protocol.Account.UnFreezeV2;
import org.tron.protos.contract.Common;
import org.tron.protos.contract.Common.ResourceCode;

public class CancelAllUnfreezeV2ProcessorDiffblueTest {
  /**
   * Test {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CancelAllUnfreezeV2Processor.validate(CancelAllUnfreezeV2Param, Repository)"})
  public void testValidate_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    CancelAllUnfreezeV2Param param = new CancelAllUnfreezeV2Param();
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> cancelAllUnfreezeV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CancelAllUnfreezeV2Processor.validate(CancelAllUnfreezeV2Param, Repository)"})
  public void testValidate_givenEmptyArrayOfByte() throws ContractValidateException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    CancelAllUnfreezeV2Param param = new CancelAllUnfreezeV2Param();
    param.setOwnerAddress(new byte[]{});

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> cancelAllUnfreezeV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link CancelAllUnfreezeV2Param} (default constructor) OwnerAddress is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CancelAllUnfreezeV2Processor.validate(CancelAllUnfreezeV2Param, Repository)"})
  public void testValidate_givenNull_whenCancelAllUnfreezeV2ParamOwnerAddressIsNull() throws ContractValidateException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    CancelAllUnfreezeV2Param param = new CancelAllUnfreezeV2Param();
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> cancelAllUnfreezeV2Processor.validate(param,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class))));
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Processor#validate(CancelAllUnfreezeV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CancelAllUnfreezeV2Processor.validate(CancelAllUnfreezeV2Param, Repository)"})
  public void testValidate_givenNull_whenNull() throws ContractValidateException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();

    CancelAllUnfreezeV2Param param = new CancelAllUnfreezeV2Param();
    param.setOwnerAddress(null);

    // Act and Assert
    assertThrows(ContractValidateException.class, () -> cancelAllUnfreezeV2Processor.validate(param, null));
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#execute(CancelAllUnfreezeV2Param, Repository)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add DefaultInstance.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Processor#execute(CancelAllUnfreezeV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long CancelAllUnfreezeV2Processor.execute(CancelAllUnfreezeV2Param, Repository)"})
  public void testExecute_givenArrayListAddDefaultInstance_thenReturnZero()
      throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    CancelAllUnfreezeV2Param param = mock(CancelAllUnfreezeV2Param.class);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<UnFreezeV2> unFreezeV2List = new ArrayList<>();
    unFreezeV2List.add(UnFreezeV2.getDefaultInstance());
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getUnfrozenV2List()).thenReturn(unFreezeV2List);
    doNothing().when(accountCapsule).clearUnfrozenV2();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).updateAccount(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    long actualExecuteResult = cancelAllUnfreezeV2Processor.execute(param, repo);

    // Assert
    verify(accountCapsule).clearUnfrozenV2();
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getUnfrozenV2List();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(param).getOwnerAddress();
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getDynamicPropertiesStore();
    verify(repo).updateAccount(isA(byte[].class), isA(AccountCapsule.class));
    assertEquals(0L, actualExecuteResult);
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#execute(CancelAllUnfreezeV2Param, Repository)}.
   * <ul>
   *   <li>Then calls {@link AccountCapsule#addFrozenBalanceForBandwidthV2(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Processor#execute(CancelAllUnfreezeV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long CancelAllUnfreezeV2Processor.execute(CancelAllUnfreezeV2Param, Repository)"})
  public void testExecute_thenCallsAddFrozenBalanceForBandwidthV2()
      throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    CancelAllUnfreezeV2Param param = mock(CancelAllUnfreezeV2Param.class);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<UnFreezeV2> unFreezeV2List = new ArrayList<>();
    unFreezeV2List.add(UnFreezeV2.getDefaultInstance());
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFrozenV2BalanceWithDelegated(Mockito.<ResourceCode>any())).thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenBalanceForBandwidthV2(anyLong());
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getUnfrozenV2List()).thenReturn(unFreezeV2List);
    doNothing().when(accountCapsule).clearUnfrozenV2();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(-1L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalNetWeight(anyLong());
    doNothing().when(repo).updateAccount(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    long actualExecuteResult = cancelAllUnfreezeV2Processor.execute(param, repo);

    // Assert
    verify(accountCapsule).addFrozenBalanceForBandwidthV2(eq(0L));
    verify(accountCapsule).clearUnfrozenV2();
    verify(accountCapsule).createDbKey();
    verify(accountCapsule, atLeast(1)).getFrozenV2BalanceWithDelegated(eq(ResourceCode.BANDWIDTH));
    verify(accountCapsule).getUnfrozenV2List();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(param).getOwnerAddress();
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(repo).addTotalNetWeight(eq(0L));
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getDynamicPropertiesStore();
    verify(repo).updateAccount(isA(byte[].class), isA(AccountCapsule.class));
    assertEquals(0L, actualExecuteResult);
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#execute(CancelAllUnfreezeV2Param, Repository)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Processor#execute(CancelAllUnfreezeV2Param, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long CancelAllUnfreezeV2Processor.execute(CancelAllUnfreezeV2Param, Repository)"})
  public void testExecute_thenReturnZero() throws UnsupportedEncodingException, ContractExeException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    CancelAllUnfreezeV2Param param = mock(CancelAllUnfreezeV2Param.class);
    when(param.getOwnerAddress()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(param).setOwnerAddress(Mockito.<byte[]>any());
    param.setOwnerAddress("AXAXAXAX".getBytes("UTF-8"));
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(accountCapsule.getUnfrozenV2List()).thenReturn(new ArrayList<>());
    doNothing().when(accountCapsule).clearUnfrozenV2();
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).updateAccount(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(repo.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    when(repo.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    long actualExecuteResult = cancelAllUnfreezeV2Processor.execute(param, repo);

    // Assert
    verify(accountCapsule).clearUnfrozenV2();
    verify(accountCapsule).createDbKey();
    verify(accountCapsule).getUnfrozenV2List();
    verify(dynamicPropertiesStore).getLatestBlockHeaderTimestamp();
    verify(param).getOwnerAddress();
    verify(param).setOwnerAddress(isA(byte[].class));
    verify(repo).getAccount(isA(byte[].class));
    verify(repo).getDynamicPropertiesStore();
    verify(repo).updateAccount(isA(byte[].class), isA(AccountCapsule.class));
    assertEquals(0L, actualExecuteResult);
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, UnFreezeV2, Repository)}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Account.UnFreezeV2, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Account.UnFreezeV2, Repository)"})
  public void testUpdateFrozenInfoAndTotalResourceWeight() throws UnsupportedEncodingException {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFrozenV2BalanceWithDelegated(Mockito.<ResourceCode>any())).thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenBalanceForBandwidthV2(anyLong());
    UnFreezeV2 unFreezeV2 = UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);
    repo.setParent(repository);

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2, repo);

    // Assert
    verify(accountCapsule).addFrozenBalanceForBandwidthV2(eq(0L));
    verify(accountCapsule, atLeast(1)).getFrozenV2BalanceWithDelegated(eq(ResourceCode.BANDWIDTH));
    verify(repository).getDynamicProperty(isA(byte[].class));
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, UnFreezeV2, Repository)}.
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Account.UnFreezeV2, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Account.UnFreezeV2, Repository)"})
  public void testUpdateFrozenInfoAndTotalResourceWeight2() {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFrozenV2BalanceWithDelegated(Mockito.<ResourceCode>any())).thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenBalanceForBandwidthV2(anyLong());
    UnFreezeV2 unFreezeV2 = UnFreezeV2.getDefaultInstance();
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getDynamicProperty(Mockito.<byte[]>any())).thenReturn(new BytesCapsule(new byte[]{}));

    RepositoryImpl repo = new RepositoryImpl(StoreFactory.getInstance(), null);
    repo.setParent(repository);

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2, repo);

    // Assert
    verify(accountCapsule).addFrozenBalanceForBandwidthV2(eq(0L));
    verify(accountCapsule, atLeast(1)).getFrozenV2BalanceWithDelegated(eq(ResourceCode.BANDWIDTH));
    verify(repository).getDynamicProperty(isA(byte[].class));
  }

  /**
   * Test {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, UnFreezeV2, Repository)}.
   * <ul>
   *   <li>Then calls {@link RepositoryImpl#addTotalNetWeight(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CancelAllUnfreezeV2Processor#updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Account.UnFreezeV2, Repository)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(AccountCapsule, Account.UnFreezeV2, Repository)"})
  public void testUpdateFrozenInfoAndTotalResourceWeight_thenCallsAddTotalNetWeight() {
    // Arrange
    CancelAllUnfreezeV2Processor cancelAllUnfreezeV2Processor = new CancelAllUnfreezeV2Processor();
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getFrozenV2BalanceWithDelegated(Mockito.<ResourceCode>any())).thenReturn(42L);
    doNothing().when(accountCapsule).addFrozenBalanceForBandwidthV2(anyLong());
    UnFreezeV2 unFreezeV2 = UnFreezeV2.getDefaultInstance();
    RepositoryImpl repo = mock(RepositoryImpl.class);
    doNothing().when(repo).addTotalNetWeight(anyLong());

    // Act
    cancelAllUnfreezeV2Processor.updateFrozenInfoAndTotalResourceWeight(accountCapsule, unFreezeV2, repo);

    // Assert
    verify(accountCapsule).addFrozenBalanceForBandwidthV2(eq(0L));
    verify(accountCapsule, atLeast(1)).getFrozenV2BalanceWithDelegated(eq(ResourceCode.BANDWIDTH));
    verify(repo).addTotalNetWeight(eq(0L));
  }
}
