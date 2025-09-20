package org.tron.core.db.accountstate.callback;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.DynamicPropertiesStore;

public class AccountStateCallBackDiffblueTest {
  /**
   * Test {@link AccountStateCallBack#preExecute(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getBlockById(Sha256Hash)} return
   *       {@code null}.
   *   <li>Then calls {@link ChainBaseManager#getBlockById(Sha256Hash)}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateCallBack#preExecute(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountStateCallBack.preExecute(BlockCapsule)"})
  public void testPreExecute_givenChainBaseManagerGetBlockByIdReturnNull_thenCallsGetBlockById()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowAccountStateRoot()).thenReturn(true);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any())).thenReturn(null);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    AccountStateCallBack accountStateCallBack = new AccountStateCallBack();
    accountStateCallBack.setChainBaseManager(chainBaseManager);

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getParentBlockId()).thenReturn(new BlockId());

    // Act
    accountStateCallBack.preExecute(blockCapsule);

    // Assert
    verify(chainBaseManager).getBlockById(isA(Sha256Hash.class));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(blockCapsule).getParentBlockId();
    verify(dynamicPropertiesStore).allowAccountStateRoot();
  }

  /**
   * Test {@link AccountStateCallBack#preExecute(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getBlockById(Sha256Hash)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateCallBack#preExecute(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountStateCallBack.preExecute(BlockCapsule)"})
  public void testPreExecute_givenChainBaseManagerGetBlockByIdThrowRuntimeException()
      throws BadItemException, ItemNotFoundException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowAccountStateRoot()).thenReturn(true);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getBlockById(Mockito.<Sha256Hash>any()))
        .thenThrow(new RuntimeException());
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    AccountStateCallBack accountStateCallBack = new AccountStateCallBack();
    accountStateCallBack.setChainBaseManager(chainBaseManager);

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getParentBlockId()).thenReturn(new BlockId());

    // Act
    accountStateCallBack.preExecute(blockCapsule);

    // Assert
    verify(chainBaseManager).getBlockById(isA(Sha256Hash.class));
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(blockCapsule).getParentBlockId();
    verify(dynamicPropertiesStore).allowAccountStateRoot();
  }

  /**
   * Test {@link AccountStateCallBack#preExecute(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link
   *       DynamicPropertiesStore#allowAccountStateRoot()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateCallBack#preExecute(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountStateCallBack.preExecute(BlockCapsule)"})
  public void testPreExecute_givenDynamicPropertiesStoreAllowAccountStateRootReturnFalse() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowAccountStateRoot()).thenReturn(false);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    AccountStateCallBack accountStateCallBack = new AccountStateCallBack();
    accountStateCallBack.setChainBaseManager(chainBaseManager);

    // Act
    accountStateCallBack.preExecute(null);

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowAccountStateRoot();
  }

  /**
   * Test {@link AccountStateCallBack#preExecute(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link DynamicPropertiesStore} {@link
   *       DynamicPropertiesStore#allowAccountStateRoot()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateCallBack#preExecute(BlockCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountStateCallBack.preExecute(BlockCapsule)"})
  public void testPreExecute_givenDynamicPropertiesStoreAllowAccountStateRootReturnTrue() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.allowAccountStateRoot()).thenReturn(true);

    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    AccountStateCallBack accountStateCallBack = new AccountStateCallBack();
    accountStateCallBack.setChainBaseManager(chainBaseManager);

    // Act
    accountStateCallBack.preExecute(null);

    // Assert
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).allowAccountStateRoot();
  }
}
