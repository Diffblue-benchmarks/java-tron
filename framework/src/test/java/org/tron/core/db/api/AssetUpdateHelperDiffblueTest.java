package org.tron.core.db.api;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.ChainBaseManager;

public class AssetUpdateHelperDiffblueTest {
  /**
   * Test {@link AssetUpdateHelper#doWork()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetUpdateHelper#doWork()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.doWork()"})
  public void testDoWork_thenThrowRuntimeException() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAssetIssueV2Store()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).doWork());
    verify(chainBaseManager).getAssetIssueV2Store();
  }

  /**
   * Test {@link AssetUpdateHelper#init()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetUpdateHelper#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.init()"})
  public void testInit_thenThrowRuntimeException() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAssetIssueV2Store()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).init());
    verify(chainBaseManager).getAssetIssueV2Store();
  }

  /**
   * Test {@link AssetUpdateHelper#getAllAssetIssues()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetUpdateHelper#getAllAssetIssues()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List AssetUpdateHelper.getAllAssetIssues()"})
  public void testGetAllAssetIssues_thenThrowRuntimeException() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).getAllAssetIssues());
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAsset()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetUpdateHelper#updateAsset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.updateAsset()"})
  public void testUpdateAsset_thenThrowRuntimeException() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateAsset());
    verify(chainBaseManager).getDynamicPropertiesStore();
  }

  /**
   * Test {@link AssetUpdateHelper#updateExchange()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetUpdateHelper#updateExchange()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.updateExchange()"})
  public void testUpdateExchange_thenThrowRuntimeException() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getExchangeStore()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateExchange());
    verify(chainBaseManager).getExchangeStore();
  }

  /**
   * Test {@link AssetUpdateHelper#updateAccount()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetUpdateHelper#updateAccount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.updateAccount()"})
  public void testUpdateAccount_thenThrowRuntimeException() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getAccountStore()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).updateAccount());
    verify(chainBaseManager).getAccountStore();
  }

  /**
   * Test {@link AssetUpdateHelper#finish()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetUpdateHelper#finish()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetUpdateHelper.finish()"})
  public void testFinish_thenThrowRuntimeException() {
    // Arrange
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> (new AssetUpdateHelper(chainBaseManager)).finish());
    verify(chainBaseManager).getDynamicPropertiesStore();
  }
}
