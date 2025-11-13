package org.tron.core.services.interfaceOnSolidity.http.solidity;

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
import org.tron.core.services.filter.LiteFnQueryHttpFilter;
import org.tron.core.services.interfaceOnSolidity.http.EstimateEnergyOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetAccountByIdOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetAccountOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetAssetIssueByIdOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetAssetIssueByNameOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetAssetIssueListByNameOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetAssetIssueListOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetAvailableUnfreezeCountOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetBandwidthPricesOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetBlockByIdOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetBlockByLatestNumOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetBlockByLimitNextOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetBlockByNumOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetBlockOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetBrokerageOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetBurnTrxOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetCanDelegatedMaxSizeOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetCanWithdrawUnfreezeAmountOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetDelegatedResourceAccountIndexOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetDelegatedResourceAccountIndexV2OnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetDelegatedResourceOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetDelegatedResourceV2OnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetEnergyPricesOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetExchangeByIdOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetMarketOrderByAccountOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetMarketOrderByIdOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetMarketOrderListByPairOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetMarketPairListOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetMarketPriceByPairOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetNodeInfoOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetNowBlockOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetPaginatedAssetIssueListOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetRewardOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetTransactionCountByBlockNumOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.GetTransactionInfoByBlockNumOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.IsShieldedTRC20ContractNoteSpentOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.ListExchangesOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.ListWitnessesOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.ScanShieldedTRC20NotesByIvkOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.ScanShieldedTRC20NotesByOvkOnSolidityServlet;
import org.tron.core.services.interfaceOnSolidity.http.TriggerConstantContractOnSolidityServlet;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class HttpApiOnSolidityServiceDiffblueTest {
  @Mock private EstimateEnergyOnSolidityServlet estimateEnergyOnSolidityServlet;

  @Mock private GetAccountByIdOnSolidityServlet getAccountByIdOnSolidityServlet;

  @Mock private GetAccountOnSolidityServlet getAccountOnSolidityServlet;

  @Mock private GetAssetIssueByIdOnSolidityServlet getAssetIssueByIdOnSolidityServlet;

  @Mock private GetAssetIssueByNameOnSolidityServlet getAssetIssueByNameOnSolidityServlet;

  @Mock private GetAssetIssueListByNameOnSolidityServlet getAssetIssueListByNameOnSolidityServlet;

  @Mock private GetAssetIssueListOnSolidityServlet getAssetIssueListOnSolidityServlet;

  @Mock
  private GetAvailableUnfreezeCountOnSolidityServlet getAvailableUnfreezeCountOnSolidityServlet;

  @Mock private GetBandwidthPricesOnSolidityServlet getBandwidthPricesOnSolidityServlet;

  @Mock private GetBlockByIdOnSolidityServlet getBlockByIdOnSolidityServlet;

  @Mock private GetBlockByLatestNumOnSolidityServlet getBlockByLatestNumOnSolidityServlet;

  @Mock private GetBlockByLimitNextOnSolidityServlet getBlockByLimitNextOnSolidityServlet;

  @Mock private GetBlockByNumOnSolidityServlet getBlockByNumOnSolidityServlet;

  @Mock private GetBlockOnSolidityServlet getBlockOnSolidityServlet;

  @Mock private GetBrokerageOnSolidityServlet getBrokerageOnSolidityServlet;

  @Mock private GetBurnTrxOnSolidityServlet getBurnTrxOnSolidityServlet;

  @Mock private GetCanDelegatedMaxSizeOnSolidityServlet getCanDelegatedMaxSizeOnSolidityServlet;

  @Mock
  private GetCanWithdrawUnfreezeAmountOnSolidityServlet
      getCanWithdrawUnfreezeAmountOnSolidityServlet;

  @Mock
  private GetDelegatedResourceAccountIndexOnSolidityServlet
      getDelegatedResourceAccountIndexOnSolidityServlet;

  @Mock
  private GetDelegatedResourceAccountIndexV2OnSolidityServlet
      getDelegatedResourceAccountIndexV2OnSolidityServlet;

  @Mock private GetDelegatedResourceOnSolidityServlet getDelegatedResourceOnSolidityServlet;

  @Mock private GetDelegatedResourceV2OnSolidityServlet getDelegatedResourceV2OnSolidityServlet;

  @Mock private GetEnergyPricesOnSolidityServlet getEnergyPricesOnSolidityServlet;

  @Mock private GetExchangeByIdOnSolidityServlet getExchangeByIdOnSolidityServlet;

  @Mock private GetMarketOrderByAccountOnSolidityServlet getMarketOrderByAccountOnSolidityServlet;

  @Mock private GetMarketOrderByIdOnSolidityServlet getMarketOrderByIdOnSolidityServlet;

  @Mock private GetMarketOrderListByPairOnSolidityServlet getMarketOrderListByPairOnSolidityServlet;

  @Mock private GetMarketPairListOnSolidityServlet getMarketPairListOnSolidityServlet;

  @Mock private GetMarketPriceByPairOnSolidityServlet getMarketPriceByPairOnSolidityServlet;

  @Mock private GetNodeInfoOnSolidityServlet getNodeInfoOnSolidityServlet;

  @Mock private GetNowBlockOnSolidityServlet getNowBlockOnSolidityServlet;

  @Mock
  private GetPaginatedAssetIssueListOnSolidityServlet getPaginatedAssetIssueListOnSolidityServlet;

  @Mock private GetRewardOnSolidityServlet getRewardOnSolidityServlet;

  @Mock private GetTransactionByIdOnSolidityServlet getTransactionByIdOnSolidityServlet;

  @Mock
  private GetTransactionCountByBlockNumOnSolidityServlet
      getTransactionCountByBlockNumOnSolidityServlet;

  @Mock
  private GetTransactionInfoByBlockNumOnSolidityServlet
      getTransactionInfoByBlockNumOnSolidityServlet;

  @Mock private GetTransactionInfoByIdOnSolidityServlet getTransactionInfoByIdOnSolidityServlet;

  @Mock private HttpApiAccessFilter httpApiAccessFilter;

  @InjectMocks private HttpApiOnSolidityService httpApiOnSolidityService;

  @Mock
  private IsShieldedTRC20ContractNoteSpentOnSolidityServlet
      isShieldedTRC20ContractNoteSpentOnSolidityServlet;

  @Mock private ListExchangesOnSolidityServlet listExchangesOnSolidityServlet;

  @Mock private ListWitnessesOnSolidityServlet listWitnessesOnSolidityServlet;

  @Mock private LiteFnQueryHttpFilter liteFnQueryHttpFilter;

  @Mock
  private ScanShieldedTRC20NotesByIvkOnSolidityServlet scanShieldedTRC20NotesByIvkOnSolidityServlet;

  @Mock
  private ScanShieldedTRC20NotesByOvkOnSolidityServlet scanShieldedTRC20NotesByOvkOnSolidityServlet;

  @Mock private TriggerConstantContractOnSolidityServlet triggerConstantContractOnSolidityServlet;

  /**
   * Test {@link HttpApiOnSolidityService#start()}.
   *
   * <p>Method under test: {@link HttpApiOnSolidityService#start()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpApiOnSolidityService.start()"})
  public void testStart() throws ServletException {
    // Arrange
    doNothing().when(getAccountOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(estimateEnergyOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByNameOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListByNameOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAvailableUnfreezeCountOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBandwidthPricesOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLatestNumOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLimitNextOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByNumOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBrokerageOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBurnTrxOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanDelegatedMaxSizeOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getCanWithdrawUnfreezeAmountOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getDelegatedResourceAccountIndexOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getDelegatedResourceAccountIndexV2OnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceV2OnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getEnergyPricesOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExchangeByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByAccountOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderListByPairOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPairListOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPriceByPairOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNodeInfoOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNowBlockOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getPaginatedAssetIssueListOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getRewardOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getTransactionCountByBlockNumOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getTransactionInfoByBlockNumOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(httpApiAccessFilter).init(Mockito.<FilterConfig>any());
    doNothing()
        .when(isShieldedTRC20ContractNoteSpentOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(listExchangesOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listWitnessesOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(liteFnQueryHttpFilter).init(Mockito.<FilterConfig>any());
    doNothing()
        .when(scanShieldedTRC20NotesByIvkOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException())
        .when(scanShieldedTRC20NotesByOvkOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException())
        .when(triggerConstantContractOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());

    // Act
    httpApiOnSolidityService.start();

    // Assert
    verify(estimateEnergyOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAccountByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAccountOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByNameOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListByNameOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAvailableUnfreezeCountOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBandwidthPricesOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockByLatestNumOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockByLimitNextOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockByNumOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBrokerageOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBurnTrxOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getCanDelegatedMaxSizeOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getCanWithdrawUnfreezeAmountOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexV2OnSolidityServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceV2OnSolidityServlet).init(isA(ServletConfig.class));
    verify(getEnergyPricesOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getExchangeByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByAccountOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderListByPairOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketPairListOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketPriceByPairOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getNowBlockOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getPaginatedAssetIssueListOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getRewardOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionCountByBlockNumOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByBlockNumOnSolidityServlet).init(isA(ServletConfig.class));
    verify(isShieldedTRC20ContractNoteSpentOnSolidityServlet).init(isA(ServletConfig.class));
    verify(listExchangesOnSolidityServlet).init(isA(ServletConfig.class));
    verify(listWitnessesOnSolidityServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByIvkOnSolidityServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByOvkOnSolidityServlet).init(isA(ServletConfig.class));
    verify(triggerConstantContractOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getNodeInfoOnSolidityServlet, atLeast(1)).init(Mockito.<ServletConfig>any());
    verify(httpApiAccessFilter).init(isA(FilterConfig.class));
    verify(liteFnQueryHttpFilter).init(isA(FilterConfig.class));
  }

  /**
   * Test {@link HttpApiOnSolidityService#start()}.
   *
   * <ul>
   *   <li>Given {@link LiteFnQueryHttpFilter} {@link LiteFnQueryHttpFilter#init(FilterConfig)}
   *       throw {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link EstimateEnergyOnSolidityServlet#init(ServletConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link HttpApiOnSolidityService#start()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpApiOnSolidityService.start()"})
  public void testStart_givenLiteFnQueryHttpFilterInitThrowRuntimeException_thenCallsInit()
      throws ServletException {
    // Arrange
    doNothing().when(getAccountOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(estimateEnergyOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByNameOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListByNameOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAvailableUnfreezeCountOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBandwidthPricesOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLatestNumOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLimitNextOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByNumOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBrokerageOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBurnTrxOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanDelegatedMaxSizeOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getCanWithdrawUnfreezeAmountOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getDelegatedResourceAccountIndexOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getDelegatedResourceAccountIndexV2OnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceV2OnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getEnergyPricesOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExchangeByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByAccountOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderListByPairOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPairListOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPriceByPairOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNodeInfoOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNowBlockOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getPaginatedAssetIssueListOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getRewardOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getTransactionCountByBlockNumOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getTransactionInfoByBlockNumOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(httpApiAccessFilter).init(Mockito.<FilterConfig>any());
    doNothing()
        .when(isShieldedTRC20ContractNoteSpentOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(listExchangesOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listWitnessesOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException()).when(liteFnQueryHttpFilter).init(Mockito.<FilterConfig>any());
    doNothing()
        .when(scanShieldedTRC20NotesByIvkOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(scanShieldedTRC20NotesByOvkOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(triggerConstantContractOnSolidityServlet).init(Mockito.<ServletConfig>any());

    // Act
    httpApiOnSolidityService.start();

    // Assert
    verify(estimateEnergyOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAccountByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAccountOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByNameOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListByNameOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAvailableUnfreezeCountOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBandwidthPricesOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockByLatestNumOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockByLimitNextOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockByNumOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBrokerageOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBurnTrxOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getCanDelegatedMaxSizeOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getCanWithdrawUnfreezeAmountOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexV2OnSolidityServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceV2OnSolidityServlet).init(isA(ServletConfig.class));
    verify(getEnergyPricesOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getExchangeByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByAccountOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderListByPairOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketPairListOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketPriceByPairOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getNowBlockOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getPaginatedAssetIssueListOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getRewardOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionCountByBlockNumOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByBlockNumOnSolidityServlet).init(isA(ServletConfig.class));
    verify(isShieldedTRC20ContractNoteSpentOnSolidityServlet).init(isA(ServletConfig.class));
    verify(listExchangesOnSolidityServlet).init(isA(ServletConfig.class));
    verify(listWitnessesOnSolidityServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByIvkOnSolidityServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByOvkOnSolidityServlet).init(isA(ServletConfig.class));
    verify(triggerConstantContractOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getNodeInfoOnSolidityServlet, atLeast(1)).init(Mockito.<ServletConfig>any());
    verify(httpApiAccessFilter).init(isA(FilterConfig.class));
    verify(liteFnQueryHttpFilter).init(isA(FilterConfig.class));
  }

  /**
   * Test {@link HttpApiOnSolidityService#start()}.
   *
   * <ul>
   *   <li>Given {@link TriggerConstantContractOnSolidityServlet} {@link
   *       TriggerConstantContractOnSolidityServlet#init(ServletConfig)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link HttpApiOnSolidityService#start()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HttpApiOnSolidityService.start()"})
  public void testStart_givenTriggerConstantContractOnSolidityServletInitThrowRuntimeException()
      throws ServletException {
    // Arrange
    doNothing().when(getAccountOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(estimateEnergyOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByNameOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListByNameOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAvailableUnfreezeCountOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBandwidthPricesOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLatestNumOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLimitNextOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByNumOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBrokerageOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBurnTrxOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanDelegatedMaxSizeOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getCanWithdrawUnfreezeAmountOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getDelegatedResourceAccountIndexOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getDelegatedResourceAccountIndexV2OnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceV2OnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getEnergyPricesOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExchangeByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByAccountOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderListByPairOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPairListOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPriceByPairOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNodeInfoOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNowBlockOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getPaginatedAssetIssueListOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getRewardOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getTransactionCountByBlockNumOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getTransactionInfoByBlockNumOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByIdOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(httpApiAccessFilter).init(Mockito.<FilterConfig>any());
    doNothing()
        .when(isShieldedTRC20ContractNoteSpentOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(listExchangesOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listWitnessesOnSolidityServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(liteFnQueryHttpFilter).init(Mockito.<FilterConfig>any());
    doNothing()
        .when(scanShieldedTRC20NotesByIvkOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(scanShieldedTRC20NotesByOvkOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException())
        .when(triggerConstantContractOnSolidityServlet)
        .init(Mockito.<ServletConfig>any());

    // Act
    httpApiOnSolidityService.start();

    // Assert
    verify(estimateEnergyOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAccountByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAccountOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByNameOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListByNameOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getAvailableUnfreezeCountOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBandwidthPricesOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockByLatestNumOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockByLimitNextOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockByNumOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBlockOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBrokerageOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getBurnTrxOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getCanDelegatedMaxSizeOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getCanWithdrawUnfreezeAmountOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexV2OnSolidityServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceV2OnSolidityServlet).init(isA(ServletConfig.class));
    verify(getEnergyPricesOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getExchangeByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByAccountOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderListByPairOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketPairListOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getMarketPriceByPairOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getNowBlockOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getPaginatedAssetIssueListOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getRewardOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionCountByBlockNumOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByBlockNumOnSolidityServlet).init(isA(ServletConfig.class));
    verify(isShieldedTRC20ContractNoteSpentOnSolidityServlet).init(isA(ServletConfig.class));
    verify(listExchangesOnSolidityServlet).init(isA(ServletConfig.class));
    verify(listWitnessesOnSolidityServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByIvkOnSolidityServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByOvkOnSolidityServlet).init(isA(ServletConfig.class));
    verify(triggerConstantContractOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByIdOnSolidityServlet).init(isA(ServletConfig.class));
    verify(getNodeInfoOnSolidityServlet, atLeast(1)).init(Mockito.<ServletConfig>any());
    verify(httpApiAccessFilter).init(isA(FilterConfig.class));
    verify(liteFnQueryHttpFilter).init(isA(FilterConfig.class));
  }
}
