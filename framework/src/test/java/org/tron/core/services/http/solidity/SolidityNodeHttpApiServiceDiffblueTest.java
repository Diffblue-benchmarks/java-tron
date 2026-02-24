package org.tron.core.services.http.solidity;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.services.filter.HttpApiAccessFilter;
import org.tron.core.services.http.EstimateEnergyServlet;
import org.tron.core.services.http.GetAccountByIdServlet;
import org.tron.core.services.http.GetAccountServlet;
import org.tron.core.services.http.GetAssetIssueByIdServlet;
import org.tron.core.services.http.GetAssetIssueByNameServlet;
import org.tron.core.services.http.GetAssetIssueListByNameServlet;
import org.tron.core.services.http.GetAssetIssueListServlet;
import org.tron.core.services.http.GetAvailableUnfreezeCountServlet;
import org.tron.core.services.http.GetBandwidthPricesServlet;
import org.tron.core.services.http.GetBlockByIdServlet;
import org.tron.core.services.http.GetBlockByLatestNumServlet;
import org.tron.core.services.http.GetBlockByLimitNextServlet;
import org.tron.core.services.http.GetBlockByNumServlet;
import org.tron.core.services.http.GetBlockServlet;
import org.tron.core.services.http.GetBrokerageServlet;
import org.tron.core.services.http.GetBurnTrxServlet;
import org.tron.core.services.http.GetCanDelegatedMaxSizeServlet;
import org.tron.core.services.http.GetCanWithdrawUnfreezeAmountServlet;
import org.tron.core.services.http.GetDelegatedResourceAccountIndexServlet;
import org.tron.core.services.http.GetDelegatedResourceAccountIndexV2Servlet;
import org.tron.core.services.http.GetDelegatedResourceServlet;
import org.tron.core.services.http.GetDelegatedResourceV2Servlet;
import org.tron.core.services.http.GetEnergyPricesServlet;
import org.tron.core.services.http.GetExchangeByIdServlet;
import org.tron.core.services.http.GetMarketOrderByAccountServlet;
import org.tron.core.services.http.GetMarketOrderByIdServlet;
import org.tron.core.services.http.GetMarketOrderListByPairServlet;
import org.tron.core.services.http.GetMarketPairListServlet;
import org.tron.core.services.http.GetMarketPriceByPairServlet;
import org.tron.core.services.http.GetNodeInfoServlet;
import org.tron.core.services.http.GetNowBlockServlet;
import org.tron.core.services.http.GetPaginatedAssetIssueListServlet;
import org.tron.core.services.http.GetRewardServlet;
import org.tron.core.services.http.GetTransactionCountByBlockNumServlet;
import org.tron.core.services.http.GetTransactionInfoByBlockNumServlet;
import org.tron.core.services.http.IsShieldedTRC20ContractNoteSpentServlet;
import org.tron.core.services.http.ListExchangesServlet;
import org.tron.core.services.http.ListWitnessesServlet;
import org.tron.core.services.http.ScanShieldedTRC20NotesByIvkServlet;
import org.tron.core.services.http.ScanShieldedTRC20NotesByOvkServlet;
import org.tron.core.services.http.TriggerConstantContractServlet;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class SolidityNodeHttpApiServiceDiffblueTest {
  @Mock private EstimateEnergyServlet estimateEnergyServlet;

  @Mock private GetAccountByIdServlet getAccountByIdServlet;

  @Mock private GetAccountServlet getAccountServlet;

  @Mock private GetAssetIssueByIdServlet getAssetIssueByIdServlet;

  @Mock private GetAssetIssueByNameServlet getAssetIssueByNameServlet;

  @Mock private GetAssetIssueListByNameServlet getAssetIssueListByNameServlet;

  @Mock private GetAssetIssueListServlet getAssetIssueListServlet;

  @Mock private GetAvailableUnfreezeCountServlet getAvailableUnfreezeCountServlet;

  @Mock private GetBandwidthPricesServlet getBandwidthPricesServlet;

  @Mock private GetBlockByIdServlet getBlockByIdServlet;

  @Mock private GetBlockByLatestNumServlet getBlockByLatestNumServlet;

  @Mock private GetBlockByLimitNextServlet getBlockByLimitNextServlet;

  @Mock private GetBlockByNumServlet getBlockByNumServlet;

  @Mock private GetBlockServlet getBlockServlet;

  @Mock private GetBrokerageServlet getBrokerageServlet;

  @Mock private GetBurnTrxServlet getBurnTrxServlet;

  @Mock private GetCanDelegatedMaxSizeServlet getCanDelegatedMaxSizeServlet;

  @Mock private GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet;

  @Mock private GetDelegatedResourceAccountIndexServlet getDelegatedResourceAccountIndexServlet;

  @Mock private GetDelegatedResourceAccountIndexV2Servlet getDelegatedResourceAccountIndexV2Servlet;

  @Mock private GetDelegatedResourceServlet getDelegatedResourceServlet;

  @Mock private GetDelegatedResourceV2Servlet getDelegatedResourceV2Servlet;

  @Mock private GetEnergyPricesServlet getEnergyPricesServlet;

  @Mock private GetExchangeByIdServlet getExchangeByIdServlet;

  @Mock private GetMarketOrderByAccountServlet getMarketOrderByAccountServlet;

  @Mock private GetMarketOrderByIdServlet getMarketOrderByIdServlet;

  @Mock private GetMarketOrderListByPairServlet getMarketOrderListByPairServlet;

  @Mock private GetMarketPairListServlet getMarketPairListServlet;

  @Mock private GetMarketPriceByPairServlet getMarketPriceByPairServlet;

  @Mock private GetNodeInfoServlet getNodeInfoServlet;

  @Mock private GetNowBlockServlet getNowBlockServlet;

  @Mock private GetPaginatedAssetIssueListServlet getPaginatedAssetIssueListServlet;

  @Mock private GetRewardServlet getRewardServlet;

  @Mock private GetTransactionByIdSolidityServlet getTransactionByIdSolidityServlet;

  @Mock private GetTransactionCountByBlockNumServlet getTransactionCountByBlockNumServlet;

  @Mock private GetTransactionInfoByBlockNumServlet getTransactionInfoByBlockNumServlet;

  @Mock private GetTransactionInfoByIdSolidityServlet getTransactionInfoByIdSolidityServlet;

  @Mock private HttpApiAccessFilter httpApiAccessFilter;

  @Mock private IsShieldedTRC20ContractNoteSpentServlet isShieldedTRC20ContractNoteSpentServlet;

  @Mock private ListExchangesServlet listExchangesServlet;

  @Mock private ListWitnessesServlet listWitnessesServlet;

  @Mock private ScanShieldedTRC20NotesByIvkServlet scanShieldedTRC20NotesByIvkServlet;

  @Mock private ScanShieldedTRC20NotesByOvkServlet scanShieldedTRC20NotesByOvkServlet;

  @InjectMocks private SolidityNodeHttpApiService solidityNodeHttpApiService;

  @Mock private TriggerConstantContractServlet triggerConstantContractServlet;

  /**
   * Test {@link SolidityNodeHttpApiService#start()}.
   *
   * <ul>
   *   <li>Given {@link ScanShieldedTRC20NotesByOvkServlet} {@link
   *       ScanShieldedTRC20NotesByOvkServlet#init(ServletConfig)} does nothing.
   *   <li>Then calls {@link EstimateEnergyServlet#init(ServletConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link SolidityNodeHttpApiService#start()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolidityNodeHttpApiService.start()"})
  public void testStart_givenScanShieldedTRC20NotesByOvkServletInitDoesNothing_thenCallsInit()
      throws ServletException {
    // Arrange
    doNothing().when(estimateEnergyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByNameServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListByNameServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAvailableUnfreezeCountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBandwidthPricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLatestNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLimitNextServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBrokerageServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBurnTrxServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanDelegatedMaxSizeServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanWithdrawUnfreezeAmountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceAccountIndexServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceAccountIndexV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getEnergyPricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExchangeByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderListByPairServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPairListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPriceByPairServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNodeInfoServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNowBlockServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedAssetIssueListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getRewardServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionByIdSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionCountByBlockNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByBlockNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByIdSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(httpApiAccessFilter).init(Mockito.<FilterConfig>any());
    doNothing().when(isShieldedTRC20ContractNoteSpentServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listExchangesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listWitnessesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanShieldedTRC20NotesByIvkServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanShieldedTRC20NotesByOvkServlet).init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException())
        .when(triggerConstantContractServlet)
        .init(Mockito.<ServletConfig>any());

    // Act
    solidityNodeHttpApiService.start();

    // Assert
    verify(estimateEnergyServlet).init(isA(ServletConfig.class));
    verify(getAccountByIdServlet).init(isA(ServletConfig.class));
    verify(getAccountServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByIdServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByNameServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListByNameServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListServlet).init(isA(ServletConfig.class));
    verify(getAvailableUnfreezeCountServlet).init(isA(ServletConfig.class));
    verify(getBandwidthPricesServlet).init(isA(ServletConfig.class));
    verify(getBlockByIdServlet).init(isA(ServletConfig.class));
    verify(getBlockByLatestNumServlet).init(isA(ServletConfig.class));
    verify(getBlockByLimitNextServlet).init(isA(ServletConfig.class));
    verify(getBlockByNumServlet).init(isA(ServletConfig.class));
    verify(getBlockServlet).init(isA(ServletConfig.class));
    verify(getBrokerageServlet).init(isA(ServletConfig.class));
    verify(getBurnTrxServlet).init(isA(ServletConfig.class));
    verify(getCanDelegatedMaxSizeServlet).init(isA(ServletConfig.class));
    verify(getCanWithdrawUnfreezeAmountServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexV2Servlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceV2Servlet).init(isA(ServletConfig.class));
    verify(getEnergyPricesServlet).init(isA(ServletConfig.class));
    verify(getExchangeByIdServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByAccountServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByIdServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderListByPairServlet).init(isA(ServletConfig.class));
    verify(getMarketPairListServlet).init(isA(ServletConfig.class));
    verify(getMarketPriceByPairServlet).init(isA(ServletConfig.class));
    verify(getNowBlockServlet).init(isA(ServletConfig.class));
    verify(getPaginatedAssetIssueListServlet).init(isA(ServletConfig.class));
    verify(getRewardServlet).init(isA(ServletConfig.class));
    verify(getTransactionCountByBlockNumServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByBlockNumServlet).init(isA(ServletConfig.class));
    verify(isShieldedTRC20ContractNoteSpentServlet).init(isA(ServletConfig.class));
    verify(listExchangesServlet).init(isA(ServletConfig.class));
    verify(listWitnessesServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByIvkServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByOvkServlet).init(isA(ServletConfig.class));
    verify(triggerConstantContractServlet).init(isA(ServletConfig.class));
    verify(getTransactionByIdSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByIdSolidityServlet).init(isA(ServletConfig.class));
    verify(getNodeInfoServlet, atLeast(1)).init(Mockito.<ServletConfig>any());
    verify(httpApiAccessFilter).init(isA(FilterConfig.class));
  }

  /**
   * Test {@link SolidityNodeHttpApiService#start()}.
   *
   * <ul>
   *   <li>Given {@link ScanShieldedTRC20NotesByOvkServlet} {@link
   *       ScanShieldedTRC20NotesByOvkServlet#init(ServletConfig)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link SolidityNodeHttpApiService#start()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolidityNodeHttpApiService.start()"})
  public void testStart_givenScanShieldedTRC20NotesByOvkServletInitThrowRuntimeException()
      throws ServletException {
    // Arrange
    doNothing().when(estimateEnergyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByNameServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListByNameServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAvailableUnfreezeCountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBandwidthPricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLatestNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLimitNextServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBrokerageServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBurnTrxServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanDelegatedMaxSizeServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanWithdrawUnfreezeAmountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceAccountIndexServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceAccountIndexV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getEnergyPricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExchangeByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderListByPairServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPairListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPriceByPairServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNodeInfoServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNowBlockServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedAssetIssueListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getRewardServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionByIdSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionCountByBlockNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByBlockNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByIdSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(httpApiAccessFilter).init(Mockito.<FilterConfig>any());
    doNothing().when(isShieldedTRC20ContractNoteSpentServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listExchangesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listWitnessesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanShieldedTRC20NotesByIvkServlet).init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException())
        .when(scanShieldedTRC20NotesByOvkServlet)
        .init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException())
        .when(triggerConstantContractServlet)
        .init(Mockito.<ServletConfig>any());

    // Act
    solidityNodeHttpApiService.start();

    // Assert
    verify(estimateEnergyServlet).init(isA(ServletConfig.class));
    verify(getAccountByIdServlet).init(isA(ServletConfig.class));
    verify(getAccountServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByIdServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByNameServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListByNameServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListServlet).init(isA(ServletConfig.class));
    verify(getAvailableUnfreezeCountServlet).init(isA(ServletConfig.class));
    verify(getBandwidthPricesServlet).init(isA(ServletConfig.class));
    verify(getBlockByIdServlet).init(isA(ServletConfig.class));
    verify(getBlockByLatestNumServlet).init(isA(ServletConfig.class));
    verify(getBlockByLimitNextServlet).init(isA(ServletConfig.class));
    verify(getBlockByNumServlet).init(isA(ServletConfig.class));
    verify(getBlockServlet).init(isA(ServletConfig.class));
    verify(getBrokerageServlet).init(isA(ServletConfig.class));
    verify(getBurnTrxServlet).init(isA(ServletConfig.class));
    verify(getCanDelegatedMaxSizeServlet).init(isA(ServletConfig.class));
    verify(getCanWithdrawUnfreezeAmountServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexV2Servlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceV2Servlet).init(isA(ServletConfig.class));
    verify(getEnergyPricesServlet).init(isA(ServletConfig.class));
    verify(getExchangeByIdServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByAccountServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByIdServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderListByPairServlet).init(isA(ServletConfig.class));
    verify(getMarketPairListServlet).init(isA(ServletConfig.class));
    verify(getMarketPriceByPairServlet).init(isA(ServletConfig.class));
    verify(getNowBlockServlet).init(isA(ServletConfig.class));
    verify(getPaginatedAssetIssueListServlet).init(isA(ServletConfig.class));
    verify(getRewardServlet).init(isA(ServletConfig.class));
    verify(getTransactionCountByBlockNumServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByBlockNumServlet).init(isA(ServletConfig.class));
    verify(isShieldedTRC20ContractNoteSpentServlet).init(isA(ServletConfig.class));
    verify(listExchangesServlet).init(isA(ServletConfig.class));
    verify(listWitnessesServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByIvkServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByOvkServlet).init(isA(ServletConfig.class));
    verify(triggerConstantContractServlet).init(isA(ServletConfig.class));
    verify(getTransactionByIdSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByIdSolidityServlet).init(isA(ServletConfig.class));
    verify(getNodeInfoServlet, atLeast(1)).init(Mockito.<ServletConfig>any());
    verify(httpApiAccessFilter).init(isA(FilterConfig.class));
  }
}
