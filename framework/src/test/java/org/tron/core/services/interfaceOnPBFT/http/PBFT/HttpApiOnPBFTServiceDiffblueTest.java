package org.tron.core.services.interfaceOnPBFT.http.PBFT;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.tron.core.services.interfaceOnPBFT.http.EstimateEnergyOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetAccountByIdOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetAccountOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetAssetIssueByIdOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetAssetIssueByNameOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetAssetIssueListByNameOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetAssetIssueListOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetAvailableUnfreezeCountOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetBandwidthPricesOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetBlockByIdOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetBlockByLatestNumOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetBlockByLimitNextOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetBlockByNumOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetBrokerageOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetBurnTrxOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetCanDelegatedMaxSizeOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetCanWithdrawUnfreezeAmountOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetDelegatedResourceAccountIndexOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetDelegatedResourceAccountIndexV2OnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetDelegatedResourceOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetDelegatedResourceV2OnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetEnergyPricesOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetExchangeByIdOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetMarketOrderByAccountOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetMarketOrderByIdOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetMarketOrderListByPairOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetMarketPairListOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetMarketPriceByPairOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetMerkleTreeVoucherInfoOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetNodeInfoOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetNowBlockOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetPaginatedAssetIssueListOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetRewardOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.GetTransactionCountByBlockNumOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.IsShieldedTRC20ContractNoteSpentOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.IsSpendOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.ListExchangesOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.ListWitnessesOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.ScanAndMarkNoteByIvkOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.ScanNoteByIvkOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.ScanNoteByOvkOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.ScanShieldedTRC20NotesByIvkOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.ScanShieldedTRC20NotesByOvkOnPBFTServlet;
import org.tron.core.services.interfaceOnPBFT.http.TriggerConstantContractOnPBFTServlet;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class HttpApiOnPBFTServiceDiffblueTest {
  @Mock private EstimateEnergyOnPBFTServlet estimateEnergyOnPBFTServlet;

  @Mock private GetAccountByIdOnPBFTServlet getAccountByIdOnPBFTServlet;

  @Mock private GetAccountOnPBFTServlet getAccountOnPBFTServlet;

  @Mock private GetAssetIssueByIdOnPBFTServlet getAssetIssueByIdOnPBFTServlet;

  @Mock private GetAssetIssueByNameOnPBFTServlet getAssetIssueByNameOnPBFTServlet;

  @Mock private GetAssetIssueListByNameOnPBFTServlet getAssetIssueListByNameOnPBFTServlet;

  @Mock private GetAssetIssueListOnPBFTServlet getAssetIssueListOnPBFTServlet;

  @Mock private GetAvailableUnfreezeCountOnPBFTServlet getAvailableUnfreezeCountOnPBFTServlet;

  @Mock private GetBandwidthPricesOnPBFTServlet getBandwidthPricesOnPBFTServlet;

  @Mock private GetBlockByIdOnPBFTServlet getBlockByIdOnPBFTServlet;

  @Mock private GetBlockByLatestNumOnPBFTServlet getBlockByLatestNumOnPBFTServlet;

  @Mock private GetBlockByLimitNextOnPBFTServlet getBlockByLimitNextOnPBFTServlet;

  @Mock private GetBlockByNumOnPBFTServlet getBlockByNumOnPBFTServlet;

  @Mock private GetBlockOnPBFTServlet getBlockOnPBFTServlet;

  @Mock private GetBrokerageOnPBFTServlet getBrokerageOnPBFTServlet;

  @Mock private GetBurnTrxOnPBFTServlet getBurnTrxOnPBFTServlet;

  @Mock private GetCanDelegatedMaxSizeOnPBFTServlet getCanDelegatedMaxSizeOnPBFTServlet;

  @Mock private GetCanWithdrawUnfreezeAmountOnPBFTServlet getCanWithdrawUnfreezeAmountOnPBFTServlet;

  @Mock
  private GetDelegatedResourceAccountIndexOnPBFTServlet
      getDelegatedResourceAccountIndexOnPBFTServlet;

  @Mock
  private GetDelegatedResourceAccountIndexV2OnPBFTServlet
      getDelegatedResourceAccountIndexV2OnPBFTServlet;

  @Mock private GetDelegatedResourceOnPBFTServlet getDelegatedResourceOnPBFTServlet;

  @Mock private GetDelegatedResourceV2OnPBFTServlet getDelegatedResourceV2OnPBFTServlet;

  @Mock private GetEnergyPricesOnPBFTServlet getEnergyPricesOnPBFTServlet;

  @Mock private GetExchangeByIdOnPBFTServlet getExchangeByIdOnPBFTServlet;

  @Mock private GetMarketOrderByAccountOnPBFTServlet getMarketOrderByAccountOnPBFTServlet;

  @Mock private GetMarketOrderByIdOnPBFTServlet getMarketOrderByIdOnPBFTServlet;

  @Mock private GetMarketOrderListByPairOnPBFTServlet getMarketOrderListByPairOnPBFTServlet;

  @Mock private GetMarketPairListOnPBFTServlet getMarketPairListOnPBFTServlet;

  @Mock private GetMarketPriceByPairOnPBFTServlet getMarketPriceByPairOnPBFTServlet;

  @Mock private GetMerkleTreeVoucherInfoOnPBFTServlet getMerkleTreeVoucherInfoOnPBFTServlet;

  @Mock private GetNodeInfoOnPBFTServlet getNodeInfoOnPBFTServlet;

  @Mock private GetNowBlockOnPBFTServlet getNowBlockOnPBFTServlet;

  @Mock private GetPaginatedAssetIssueListOnPBFTServlet getPaginatedAssetIssueListOnPBFTServlet;

  @Mock private GetRewardOnPBFTServlet getRewardOnPBFTServlet;

  @Mock private GetTransactionByIdOnPBFTServlet getTransactionByIdOnPBFTServlet;

  @Mock
  private GetTransactionCountByBlockNumOnPBFTServlet getTransactionCountByBlockNumOnPBFTServlet;

  @Mock private GetTransactionInfoByIdOnPBFTServlet getTransactionInfoByIdOnPBFTServlet;

  @Mock private HttpApiAccessFilter httpApiAccessFilter;

  @InjectMocks private HttpApiOnPBFTService httpApiOnPBFTService;

  @Mock
  private IsShieldedTRC20ContractNoteSpentOnPBFTServlet
      isShieldedTRC20ContractNoteSpentOnPBFTServlet;

  @Mock private IsSpendOnPBFTServlet isSpendOnPBFTServlet;

  @Mock private ListExchangesOnPBFTServlet listExchangesOnPBFTServlet;

  @Mock private ListWitnessesOnPBFTServlet listWitnessesOnPBFTServlet;

  @Mock private LiteFnQueryHttpFilter liteFnQueryHttpFilter;

  @Mock private ScanAndMarkNoteByIvkOnPBFTServlet scanAndMarkNoteByIvkOnPBFTServlet;

  @Mock private ScanNoteByIvkOnPBFTServlet scanNoteByIvkOnPBFTServlet;

  @Mock private ScanNoteByOvkOnPBFTServlet scanNoteByOvkOnPBFTServlet;

  @Mock private ScanShieldedTRC20NotesByIvkOnPBFTServlet scanShieldedTRC20NotesByIvkOnPBFTServlet;

  @Mock private ScanShieldedTRC20NotesByOvkOnPBFTServlet scanShieldedTRC20NotesByOvkOnPBFTServlet;

  @Mock private TriggerConstantContractOnPBFTServlet triggerConstantContractOnPBFTServlet;

  /**
   * Test {@link HttpApiOnPBFTService#start()}.
   *
   * <ul>
   *   <li>Given {@link ScanShieldedTRC20NotesByOvkOnPBFTServlet} {@link
   *       ScanShieldedTRC20NotesByOvkOnPBFTServlet#init(ServletConfig)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link HttpApiOnPBFTService#start()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HttpApiOnPBFTService.start()"})
  public void testStart_givenScanShieldedTRC20NotesByOvkOnPBFTServletInitThrowRuntimeException()
      throws ServletException {
    // Arrange
    doNothing().when(getAccountOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(estimateEnergyOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByNameOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListByNameOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAvailableUnfreezeCountOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBandwidthPricesOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLatestNumOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLimitNextOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByNumOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBrokerageOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBurnTrxOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanDelegatedMaxSizeOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanWithdrawUnfreezeAmountOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getDelegatedResourceAccountIndexOnPBFTServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getDelegatedResourceAccountIndexV2OnPBFTServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceV2OnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getEnergyPricesOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExchangeByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByAccountOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderListByPairOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPairListOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPriceByPairOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMerkleTreeVoucherInfoOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNodeInfoOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNowBlockOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedAssetIssueListOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getRewardOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionCountByBlockNumOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(httpApiAccessFilter).init(Mockito.<FilterConfig>any());
    doNothing()
        .when(isShieldedTRC20ContractNoteSpentOnPBFTServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(isSpendOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listExchangesOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listWitnessesOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(liteFnQueryHttpFilter).init(Mockito.<FilterConfig>any());
    doNothing().when(scanAndMarkNoteByIvkOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanNoteByIvkOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanNoteByOvkOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanShieldedTRC20NotesByIvkOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException())
        .when(scanShieldedTRC20NotesByOvkOnPBFTServlet)
        .init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException())
        .when(triggerConstantContractOnPBFTServlet)
        .init(Mockito.<ServletConfig>any());

    // Act
    httpApiOnPBFTService.start();

    // Assert
    verify(estimateEnergyOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAccountByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAccountOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByNameOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListByNameOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAvailableUnfreezeCountOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBandwidthPricesOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBlockByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBlockByLatestNumOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBlockByLimitNextOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBlockByNumOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBrokerageOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBurnTrxOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getCanDelegatedMaxSizeOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getCanWithdrawUnfreezeAmountOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexV2OnPBFTServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceV2OnPBFTServlet).init(isA(ServletConfig.class));
    verify(getEnergyPricesOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getExchangeByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByAccountOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderListByPairOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getMarketPairListOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getMarketPriceByPairOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getMerkleTreeVoucherInfoOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getNodeInfoOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getNowBlockOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getPaginatedAssetIssueListOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getRewardOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getTransactionCountByBlockNumOnPBFTServlet).init(isA(ServletConfig.class));
    verify(isShieldedTRC20ContractNoteSpentOnPBFTServlet).init(isA(ServletConfig.class));
    verify(isSpendOnPBFTServlet).init(isA(ServletConfig.class));
    verify(listExchangesOnPBFTServlet).init(isA(ServletConfig.class));
    verify(listWitnessesOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBlockOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getTransactionByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(scanAndMarkNoteByIvkOnPBFTServlet).init(isA(ServletConfig.class));
    verify(scanNoteByIvkOnPBFTServlet).init(isA(ServletConfig.class));
    verify(scanNoteByOvkOnPBFTServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByIvkOnPBFTServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByOvkOnPBFTServlet).init(isA(ServletConfig.class));
    verify(triggerConstantContractOnPBFTServlet).init(isA(ServletConfig.class));
    verify(httpApiAccessFilter).init(isA(FilterConfig.class));
    verify(liteFnQueryHttpFilter).init(isA(FilterConfig.class));
  }

  /**
   * Test {@link HttpApiOnPBFTService#start()}.
   *
   * <ul>
   *   <li>Then calls {@link EstimateEnergyOnPBFTServlet#init(ServletConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link HttpApiOnPBFTService#start()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HttpApiOnPBFTService.start()"})
  public void testStart_thenCallsInit() throws ServletException {
    // Arrange
    doNothing().when(getAccountOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(estimateEnergyOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByNameOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListByNameOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAvailableUnfreezeCountOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBandwidthPricesOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLatestNumOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLimitNextOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByNumOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBrokerageOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBurnTrxOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanDelegatedMaxSizeOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanWithdrawUnfreezeAmountOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getDelegatedResourceAccountIndexOnPBFTServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getDelegatedResourceAccountIndexV2OnPBFTServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceV2OnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getEnergyPricesOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExchangeByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByAccountOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderListByPairOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPairListOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPriceByPairOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMerkleTreeVoucherInfoOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNodeInfoOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNowBlockOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedAssetIssueListOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getRewardOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionCountByBlockNumOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByIdOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(httpApiAccessFilter).init(Mockito.<FilterConfig>any());
    doNothing()
        .when(isShieldedTRC20ContractNoteSpentOnPBFTServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(isSpendOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listExchangesOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listWitnessesOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(liteFnQueryHttpFilter).init(Mockito.<FilterConfig>any());
    doNothing().when(scanAndMarkNoteByIvkOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanNoteByIvkOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanNoteByOvkOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanShieldedTRC20NotesByIvkOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanShieldedTRC20NotesByOvkOnPBFTServlet).init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException())
        .when(triggerConstantContractOnPBFTServlet)
        .init(Mockito.<ServletConfig>any());

    // Act
    httpApiOnPBFTService.start();

    // Assert
    verify(estimateEnergyOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAccountByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAccountOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByNameOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListByNameOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getAvailableUnfreezeCountOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBandwidthPricesOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBlockByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBlockByLatestNumOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBlockByLimitNextOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBlockByNumOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBrokerageOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBurnTrxOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getCanDelegatedMaxSizeOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getCanWithdrawUnfreezeAmountOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexV2OnPBFTServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceV2OnPBFTServlet).init(isA(ServletConfig.class));
    verify(getEnergyPricesOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getExchangeByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByAccountOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderListByPairOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getMarketPairListOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getMarketPriceByPairOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getMerkleTreeVoucherInfoOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getNodeInfoOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getNowBlockOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getPaginatedAssetIssueListOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getRewardOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getTransactionCountByBlockNumOnPBFTServlet).init(isA(ServletConfig.class));
    verify(isShieldedTRC20ContractNoteSpentOnPBFTServlet).init(isA(ServletConfig.class));
    verify(isSpendOnPBFTServlet).init(isA(ServletConfig.class));
    verify(listExchangesOnPBFTServlet).init(isA(ServletConfig.class));
    verify(listWitnessesOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getBlockOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getTransactionByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByIdOnPBFTServlet).init(isA(ServletConfig.class));
    verify(scanAndMarkNoteByIvkOnPBFTServlet).init(isA(ServletConfig.class));
    verify(scanNoteByIvkOnPBFTServlet).init(isA(ServletConfig.class));
    verify(scanNoteByOvkOnPBFTServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByIvkOnPBFTServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByOvkOnPBFTServlet).init(isA(ServletConfig.class));
    verify(triggerConstantContractOnPBFTServlet).init(isA(ServletConfig.class));
    verify(httpApiAccessFilter).init(isA(FilterConfig.class));
    verify(liteFnQueryHttpFilter).init(isA(FilterConfig.class));
  }
}
