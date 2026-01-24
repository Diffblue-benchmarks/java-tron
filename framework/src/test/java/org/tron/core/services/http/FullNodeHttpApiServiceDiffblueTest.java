package org.tron.core.services.http;

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

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class FullNodeHttpApiServiceDiffblueTest {
  @Mock private AccountPermissionUpdateServlet accountPermissionUpdateServlet;

  @Mock private BroadcastHexServlet broadcastHexServlet;

  @Mock private BroadcastServlet broadcastServlet;

  @Mock private CancelAllUnfreezeV2Servlet cancelAllUnfreezeV2Servlet;

  @Mock private ClearABIServlet clearABIServlet;

  @Mock private CreateAccountServlet createAccountServlet;

  @Mock private CreateAssetIssueServlet createAssetIssueServlet;

  @Mock private CreateCommonTransactionServlet createCommonTransactionServlet;

  @Mock private CreateShieldedContractParametersServlet createShieldedContractParametersServlet;

  @Mock
  private CreateShieldedContractParametersWithoutAskServlet
      createShieldedContractParametersWithoutAskServlet;

  @Mock private CreateSpendAuthSigServlet createSpendAuthSigServlet;

  @Mock private CreateWitnessServlet createWitnessServlet;

  @Mock private DelegateResourceServlet delegateResourceServlet;

  @Mock private DeployContractServlet deployContractServlet;

  @Mock private EstimateEnergyServlet estimateEnergyServlet;

  @Mock private ExchangeCreateServlet exchangeCreateServlet;

  @Mock private ExchangeInjectServlet exchangeInjectServlet;

  @Mock private ExchangeTransactionServlet exchangeTransactionServlet;

  @Mock private ExchangeWithdrawServlet exchangeWithdrawServlet;

  @Mock private FreezeBalanceServlet freezeBalanceServlet;

  @Mock private FreezeBalanceV2Servlet freezeBalanceV2Servlet;

  @InjectMocks private FullNodeHttpApiService fullNodeHttpApiService;

  @Mock private GetAccountBalanceServlet getAccountBalanceServlet;

  @Mock private GetAccountByIdServlet getAccountByIdServlet;

  @Mock private GetAccountNetServlet getAccountNetServlet;

  @Mock private GetAccountResourceServlet getAccountResourceServlet;

  @Mock private GetAccountServlet getAccountServlet;

  @Mock private GetAkFromAskServlet getAkFromAskServlet;

  @Mock private GetAssetIssueByAccountServlet getAssetIssueByAccountServlet;

  @Mock private GetAssetIssueByIdServlet getAssetIssueByIdServlet;

  @Mock private GetAssetIssueByNameServlet getAssetIssueByNameServlet;

  @Mock private GetAssetIssueListByNameServlet getAssetIssueListByNameServlet;

  @Mock private GetAssetIssueListServlet getAssetIssueListServlet;

  @Mock private GetAvailableUnfreezeCountServlet getAvailableUnfreezeCountServlet;

  @Mock private GetBandwidthPricesServlet getBandwidthPricesServlet;

  @Mock private GetBlockBalanceServlet getBlockBalanceServlet;

  @Mock private GetBlockByIdServlet getBlockByIdServlet;

  @Mock private GetBlockByLatestNumServlet getBlockByLatestNumServlet;

  @Mock private GetBlockByLimitNextServlet getBlockByLimitNextServlet;

  @Mock private GetBlockByNumServlet getBlockByNumServlet;

  @Mock private GetBlockServlet getBlockServlet;

  @Mock private GetBrokerageServlet getBrokerageServlet;

  @Mock private GetBurnTrxServlet getBurnTrxServlet;

  @Mock private GetCanDelegatedMaxSizeServlet getCanDelegatedMaxSizeServlet;

  @Mock private GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet;

  @Mock private GetChainParametersServlet getChainParametersServlet;

  @Mock private GetContractInfoServlet getContractInfoServlet;

  @Mock private GetContractServlet getContractServlet;

  @Mock private GetDelegatedResourceAccountIndexServlet getDelegatedResourceAccountIndexServlet;

  @Mock private GetDelegatedResourceAccountIndexV2Servlet getDelegatedResourceAccountIndexV2Servlet;

  @Mock private GetDelegatedResourceServlet getDelegatedResourceServlet;

  @Mock private GetDelegatedResourceV2Servlet getDelegatedResourceV2Servlet;

  @Mock private GetDiversifierServlet getDiversifierServlet;

  @Mock private GetEnergyPricesServlet getEnergyPricesServlet;

  @Mock private GetExchangeByIdServlet getExchangeByIdServlet;

  @Mock private GetExpandedSpendingKeyServlet getExpandedSpendingKeyServlet;

  @Mock private GetIncomingViewingKeyServlet getIncomingViewingKeyServlet;

  @Mock private GetMarketOrderByAccountServlet getMarketOrderByAccountServlet;

  @Mock private GetMarketOrderByIdServlet getMarketOrderByIdServlet;

  @Mock private GetMarketOrderListByPairServlet getMarketOrderListByPairServlet;

  @Mock private GetMarketPairListServlet getMarketPairListServlet;

  @Mock private GetMarketPriceByPairServlet getMarketPriceByPairServlet;

  @Mock private GetMemoFeePricesServlet getMemoFeePricesServlet;

  @Mock private GetNewShieldedAddressServlet getNewShieldedAddressServlet;

  @Mock private GetNextMaintenanceTimeServlet getNextMaintenanceTimeServlet;

  @Mock private GetNkFromNskServlet getNkFromNskServlet;

  @Mock private GetNodeInfoServlet getNodeInfoServlet;

  @Mock private GetNowBlockServlet getNowBlockServlet;

  @Mock private GetPaginatedAssetIssueListServlet getPaginatedAssetIssueListServlet;

  @Mock private GetPaginatedExchangeListServlet getPaginatedExchangeListServlet;

  @Mock private GetPaginatedProposalListServlet getPaginatedProposalListServlet;

  @Mock private GetPendingSizeServlet getPendingSizeServlet;

  @Mock private GetProposalByIdServlet getProposalByIdServlet;

  @Mock private GetRcmServlet getRcmServlet;

  @Mock private GetRewardServlet getRewardServlet;

  @Mock private GetSpendingKeyServlet getSpendingKeyServlet;

  @Mock private GetTransactionApprovedListServlet getTransactionApprovedListServlet;

  @Mock private GetTransactionByIdServlet getTransactionByIdServlet;

  @Mock private GetTransactionCountByBlockNumServlet getTransactionCountByBlockNumServlet;

  @Mock private GetTransactionFromPendingServlet getTransactionFromPendingServlet;

  @Mock private GetTransactionInfoByBlockNumServlet getTransactionInfoByBlockNumServlet;

  @Mock private GetTransactionInfoByIdServlet getTransactionInfoByIdServlet;

  @Mock private GetTransactionListFromPendingServlet getTransactionListFromPendingServlet;

  @Mock private GetTransactionReceiptByIdServlet getTransactionReceiptByIdServlet;

  @Mock private GetTransactionSignWeightServlet getTransactionSignWeightServlet;

  @Mock
  private GetTriggerInputForShieldedTRC20ContractServlet
      getTriggerInputForShieldedTRC20ContractServlet;

  @Mock private GetZenPaymentAddressServlet getZenPaymentAddressServlet;

  @Mock private HttpApiAccessFilter httpApiAccessFilter;

  @Mock private IsShieldedTRC20ContractNoteSpentServlet isShieldedTRC20ContractNoteSpentServlet;

  @Mock private ListExchangesServlet listExchangesServlet;

  @Mock private ListNodesServlet listNodesServlet;

  @Mock private ListProposalsServlet listProposalsServlet;

  @Mock private ListWitnessesServlet listWitnessesServlet;

  @Mock private LiteFnQueryHttpFilter liteFnQueryHttpFilter;

  @Mock private MarketCancelOrderServlet marketCancelOrderServlet;

  @Mock private MarketSellAssetServlet marketSellAssetServlet;

  @Mock private MetricsServlet metricsServlet;

  @Mock private ParticipateAssetIssueServlet participateAssetIssueServlet;

  @Mock private ProposalApproveServlet proposalApproveServlet;

  @Mock private ProposalCreateServlet proposalCreateServlet;

  @Mock private ProposalDeleteServlet proposalDeleteServlet;

  @Mock private ScanShieldedTRC20NotesByIvkServlet scanShieldedTRC20NotesByIvkServlet;

  @Mock private ScanShieldedTRC20NotesByOvkServlet scanShieldedTRC20NotesByOvkServlet;

  @Mock private SetAccountIdServlet setAccountIdServlet;

  @Mock private TotalTransactionServlet totalTransactionServlet;

  @Mock private TransferAssetServlet transferAssetServlet;

  @Mock private TransferServlet transferServlet;

  @Mock private TriggerConstantContractServlet triggerConstantContractServlet;

  @Mock private TriggerSmartContractServlet triggerSmartContractServlet;

  @Mock private UnDelegateResourceServlet unDelegateResourceServlet;

  @Mock private UnFreezeAssetServlet unFreezeAssetServlet;

  @Mock private UnFreezeBalanceServlet unFreezeBalanceServlet;

  @Mock private UnFreezeBalanceV2Servlet unFreezeBalanceV2Servlet;

  @Mock private UpdateAccountServlet updateAccountServlet;

  @Mock private UpdateAssetServlet updateAssetServlet;

  @Mock private UpdateBrokerageServlet updateBrokerageServlet;

  @Mock private UpdateEnergyLimitServlet updateEnergyLimitServlet;

  @Mock private UpdateSettingServlet updateSettingServlet;

  @Mock private UpdateWitnessServlet updateWitnessServlet;

  @Mock private ValidateAddressServlet validateAddressServlet;

  @Mock private VoteWitnessAccountServlet voteWitnessAccountServlet;

  @Mock private WithdrawBalanceServlet withdrawBalanceServlet;

  @Mock private WithdrawExpireUnfreezeServlet withdrawExpireUnfreezeServlet;

  /**
   * Test {@link FullNodeHttpApiService#start()}.
   *
   * <ul>
   *   <li>Given {@link WithdrawBalanceServlet} {@link WithdrawBalanceServlet#init(ServletConfig)}
   *       does nothing.
   *   <li>Then calls {@link AccountPermissionUpdateServlet#init(ServletConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link FullNodeHttpApiService#start()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FullNodeHttpApiService.start()"})
  public void testStart_givenWithdrawBalanceServletInitDoesNothing_thenCallsInit()
      throws ServletException {
    // Arrange
    doNothing().when(accountPermissionUpdateServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(broadcastHexServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(broadcastServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(cancelAllUnfreezeV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(clearABIServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createAssetIssueServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createCommonTransactionServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createShieldedContractParametersServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(createShieldedContractParametersWithoutAskServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(createSpendAuthSigServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createWitnessServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(delegateResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(deployContractServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(estimateEnergyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(exchangeCreateServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(exchangeInjectServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(exchangeTransactionServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(exchangeWithdrawServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(freezeBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(freezeBalanceV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountNetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAkFromAskServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByNameServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListByNameServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAvailableUnfreezeCountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBandwidthPricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLatestNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLimitNextServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBrokerageServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBurnTrxServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanDelegatedMaxSizeServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanWithdrawUnfreezeAmountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getChainParametersServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getContractInfoServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getContractServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceAccountIndexServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceAccountIndexV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDiversifierServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getEnergyPricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExchangeByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExpandedSpendingKeyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getIncomingViewingKeyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderListByPairServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPairListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPriceByPairServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMemoFeePricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNewShieldedAddressServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNextMaintenanceTimeServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNkFromNskServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNodeInfoServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNowBlockServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedAssetIssueListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedExchangeListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedProposalListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPendingSizeServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getProposalByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getRcmServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getRewardServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getSpendingKeyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionApprovedListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionCountByBlockNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionFromPendingServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByBlockNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionListFromPendingServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionReceiptByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionSignWeightServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getTriggerInputForShieldedTRC20ContractServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getZenPaymentAddressServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(httpApiAccessFilter).init(Mockito.<FilterConfig>any());
    doNothing().when(isShieldedTRC20ContractNoteSpentServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listExchangesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listNodesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listProposalsServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listWitnessesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(liteFnQueryHttpFilter).init(Mockito.<FilterConfig>any());
    doNothing().when(marketCancelOrderServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(marketSellAssetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(metricsServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(participateAssetIssueServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(proposalApproveServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(proposalCreateServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(proposalDeleteServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanShieldedTRC20NotesByIvkServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanShieldedTRC20NotesByOvkServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(setAccountIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(totalTransactionServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(transferAssetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(transferServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(triggerConstantContractServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(triggerSmartContractServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(unDelegateResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(unFreezeAssetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(unFreezeBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(unFreezeBalanceV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateAssetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateBrokerageServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateEnergyLimitServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateSettingServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateWitnessServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(validateAddressServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(voteWitnessAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(withdrawBalanceServlet).init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException())
        .when(withdrawExpireUnfreezeServlet)
        .init(Mockito.<ServletConfig>any());

    // Act
    fullNodeHttpApiService.start();

    // Assert
    verify(accountPermissionUpdateServlet).init(isA(ServletConfig.class));
    verify(broadcastHexServlet).init(isA(ServletConfig.class));
    verify(broadcastServlet).init(isA(ServletConfig.class));
    verify(cancelAllUnfreezeV2Servlet).init(isA(ServletConfig.class));
    verify(clearABIServlet).init(isA(ServletConfig.class));
    verify(createAccountServlet).init(isA(ServletConfig.class));
    verify(createAssetIssueServlet).init(isA(ServletConfig.class));
    verify(createCommonTransactionServlet).init(isA(ServletConfig.class));
    verify(createShieldedContractParametersServlet).init(isA(ServletConfig.class));
    verify(createShieldedContractParametersWithoutAskServlet).init(isA(ServletConfig.class));
    verify(createSpendAuthSigServlet).init(isA(ServletConfig.class));
    verify(createWitnessServlet).init(isA(ServletConfig.class));
    verify(delegateResourceServlet).init(isA(ServletConfig.class));
    verify(deployContractServlet).init(isA(ServletConfig.class));
    verify(estimateEnergyServlet).init(isA(ServletConfig.class));
    verify(exchangeCreateServlet).init(isA(ServletConfig.class));
    verify(exchangeInjectServlet).init(isA(ServletConfig.class));
    verify(exchangeTransactionServlet).init(isA(ServletConfig.class));
    verify(exchangeWithdrawServlet).init(isA(ServletConfig.class));
    verify(freezeBalanceServlet).init(isA(ServletConfig.class));
    verify(freezeBalanceV2Servlet).init(isA(ServletConfig.class));
    verify(getAccountBalanceServlet).init(isA(ServletConfig.class));
    verify(getAccountByIdServlet).init(isA(ServletConfig.class));
    verify(getAccountNetServlet).init(isA(ServletConfig.class));
    verify(getAccountResourceServlet).init(isA(ServletConfig.class));
    verify(getAccountServlet).init(isA(ServletConfig.class));
    verify(getAkFromAskServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByAccountServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByIdServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByNameServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListByNameServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListServlet).init(isA(ServletConfig.class));
    verify(getAvailableUnfreezeCountServlet).init(isA(ServletConfig.class));
    verify(getBandwidthPricesServlet).init(isA(ServletConfig.class));
    verify(getBlockBalanceServlet).init(isA(ServletConfig.class));
    verify(getBlockByIdServlet).init(isA(ServletConfig.class));
    verify(getBlockByLatestNumServlet).init(isA(ServletConfig.class));
    verify(getBlockByLimitNextServlet).init(isA(ServletConfig.class));
    verify(getBlockByNumServlet).init(isA(ServletConfig.class));
    verify(getBlockServlet).init(isA(ServletConfig.class));
    verify(getBrokerageServlet).init(isA(ServletConfig.class));
    verify(getBurnTrxServlet).init(isA(ServletConfig.class));
    verify(getCanDelegatedMaxSizeServlet).init(isA(ServletConfig.class));
    verify(getCanWithdrawUnfreezeAmountServlet).init(isA(ServletConfig.class));
    verify(getChainParametersServlet).init(isA(ServletConfig.class));
    verify(getContractInfoServlet).init(isA(ServletConfig.class));
    verify(getContractServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexV2Servlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceV2Servlet).init(isA(ServletConfig.class));
    verify(getDiversifierServlet).init(isA(ServletConfig.class));
    verify(getEnergyPricesServlet).init(isA(ServletConfig.class));
    verify(getExchangeByIdServlet).init(isA(ServletConfig.class));
    verify(getExpandedSpendingKeyServlet).init(isA(ServletConfig.class));
    verify(getIncomingViewingKeyServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByAccountServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByIdServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderListByPairServlet).init(isA(ServletConfig.class));
    verify(getMarketPairListServlet).init(isA(ServletConfig.class));
    verify(getMarketPriceByPairServlet).init(isA(ServletConfig.class));
    verify(getMemoFeePricesServlet).init(isA(ServletConfig.class));
    verify(getNewShieldedAddressServlet).init(isA(ServletConfig.class));
    verify(getNextMaintenanceTimeServlet).init(isA(ServletConfig.class));
    verify(getNkFromNskServlet).init(isA(ServletConfig.class));
    verify(getNowBlockServlet).init(isA(ServletConfig.class));
    verify(getPaginatedAssetIssueListServlet).init(isA(ServletConfig.class));
    verify(getPaginatedExchangeListServlet).init(isA(ServletConfig.class));
    verify(getPaginatedProposalListServlet).init(isA(ServletConfig.class));
    verify(getPendingSizeServlet).init(isA(ServletConfig.class));
    verify(getProposalByIdServlet).init(isA(ServletConfig.class));
    verify(getRcmServlet).init(isA(ServletConfig.class));
    verify(getRewardServlet).init(isA(ServletConfig.class));
    verify(getSpendingKeyServlet).init(isA(ServletConfig.class));
    verify(getTransactionApprovedListServlet).init(isA(ServletConfig.class));
    verify(getTransactionByIdServlet).init(isA(ServletConfig.class));
    verify(getTransactionCountByBlockNumServlet).init(isA(ServletConfig.class));
    verify(getTransactionFromPendingServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByBlockNumServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByIdServlet).init(isA(ServletConfig.class));
    verify(getTransactionListFromPendingServlet).init(isA(ServletConfig.class));
    verify(getTransactionReceiptByIdServlet).init(isA(ServletConfig.class));
    verify(getTransactionSignWeightServlet).init(isA(ServletConfig.class));
    verify(getTriggerInputForShieldedTRC20ContractServlet).init(isA(ServletConfig.class));
    verify(getZenPaymentAddressServlet).init(isA(ServletConfig.class));
    verify(isShieldedTRC20ContractNoteSpentServlet).init(isA(ServletConfig.class));
    verify(listExchangesServlet).init(isA(ServletConfig.class));
    verify(listProposalsServlet).init(isA(ServletConfig.class));
    verify(listWitnessesServlet).init(isA(ServletConfig.class));
    verify(marketCancelOrderServlet).init(isA(ServletConfig.class));
    verify(marketSellAssetServlet).init(isA(ServletConfig.class));
    verify(metricsServlet).init(isA(ServletConfig.class));
    verify(participateAssetIssueServlet).init(isA(ServletConfig.class));
    verify(proposalApproveServlet).init(isA(ServletConfig.class));
    verify(proposalCreateServlet).init(isA(ServletConfig.class));
    verify(proposalDeleteServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByIvkServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByOvkServlet).init(isA(ServletConfig.class));
    verify(setAccountIdServlet).init(isA(ServletConfig.class));
    verify(totalTransactionServlet).init(isA(ServletConfig.class));
    verify(transferAssetServlet).init(isA(ServletConfig.class));
    verify(transferServlet).init(isA(ServletConfig.class));
    verify(triggerConstantContractServlet).init(isA(ServletConfig.class));
    verify(triggerSmartContractServlet).init(isA(ServletConfig.class));
    verify(unDelegateResourceServlet).init(isA(ServletConfig.class));
    verify(unFreezeAssetServlet).init(isA(ServletConfig.class));
    verify(unFreezeBalanceServlet).init(isA(ServletConfig.class));
    verify(unFreezeBalanceV2Servlet).init(isA(ServletConfig.class));
    verify(updateAccountServlet).init(isA(ServletConfig.class));
    verify(updateAssetServlet).init(isA(ServletConfig.class));
    verify(updateBrokerageServlet).init(isA(ServletConfig.class));
    verify(updateEnergyLimitServlet).init(isA(ServletConfig.class));
    verify(updateSettingServlet).init(isA(ServletConfig.class));
    verify(updateWitnessServlet).init(isA(ServletConfig.class));
    verify(validateAddressServlet).init(isA(ServletConfig.class));
    verify(voteWitnessAccountServlet).init(isA(ServletConfig.class));
    verify(withdrawBalanceServlet).init(isA(ServletConfig.class));
    verify(withdrawExpireUnfreezeServlet).init(isA(ServletConfig.class));
    verify(getNodeInfoServlet, atLeast(1)).init(Mockito.<ServletConfig>any());
    verify(listNodesServlet, atLeast(1)).init(Mockito.<ServletConfig>any());
    verify(httpApiAccessFilter).init(isA(FilterConfig.class));
    verify(liteFnQueryHttpFilter).init(isA(FilterConfig.class));
  }

  /**
   * Test {@link FullNodeHttpApiService#start()}.
   *
   * <ul>
   *   <li>Given {@link WithdrawBalanceServlet} {@link WithdrawBalanceServlet#init(ServletConfig)}
   *       throw {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link AccountPermissionUpdateServlet#init(ServletConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link FullNodeHttpApiService#start()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FullNodeHttpApiService.start()"})
  public void testStart_givenWithdrawBalanceServletInitThrowRuntimeException_thenCallsInit()
      throws ServletException {
    // Arrange
    doNothing().when(accountPermissionUpdateServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(broadcastHexServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(broadcastServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(cancelAllUnfreezeV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(clearABIServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createAssetIssueServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createCommonTransactionServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createShieldedContractParametersServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(createShieldedContractParametersWithoutAskServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(createSpendAuthSigServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createWitnessServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(delegateResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(deployContractServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(estimateEnergyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(exchangeCreateServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(exchangeInjectServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(exchangeTransactionServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(exchangeWithdrawServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(freezeBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(freezeBalanceV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountNetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAkFromAskServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByNameServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListByNameServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAvailableUnfreezeCountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBandwidthPricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLatestNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLimitNextServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBrokerageServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBurnTrxServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanDelegatedMaxSizeServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanWithdrawUnfreezeAmountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getChainParametersServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getContractInfoServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getContractServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceAccountIndexServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceAccountIndexV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDiversifierServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getEnergyPricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExchangeByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExpandedSpendingKeyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getIncomingViewingKeyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderListByPairServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPairListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPriceByPairServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMemoFeePricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNewShieldedAddressServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNextMaintenanceTimeServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNkFromNskServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNodeInfoServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNowBlockServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedAssetIssueListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedExchangeListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedProposalListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPendingSizeServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getProposalByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getRcmServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getRewardServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getSpendingKeyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionApprovedListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionCountByBlockNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionFromPendingServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByBlockNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionListFromPendingServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionReceiptByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionSignWeightServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getTriggerInputForShieldedTRC20ContractServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getZenPaymentAddressServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(httpApiAccessFilter).init(Mockito.<FilterConfig>any());
    doNothing().when(isShieldedTRC20ContractNoteSpentServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listExchangesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listNodesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listProposalsServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listWitnessesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(liteFnQueryHttpFilter).init(Mockito.<FilterConfig>any());
    doNothing().when(marketCancelOrderServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(marketSellAssetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(metricsServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(participateAssetIssueServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(proposalApproveServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(proposalCreateServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(proposalDeleteServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanShieldedTRC20NotesByIvkServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanShieldedTRC20NotesByOvkServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(setAccountIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(totalTransactionServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(transferAssetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(transferServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(triggerConstantContractServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(triggerSmartContractServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(unDelegateResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(unFreezeAssetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(unFreezeBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(unFreezeBalanceV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateAssetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateBrokerageServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateEnergyLimitServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateSettingServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateWitnessServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(validateAddressServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(voteWitnessAccountServlet).init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException()).when(withdrawBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(withdrawExpireUnfreezeServlet).init(Mockito.<ServletConfig>any());

    // Act
    fullNodeHttpApiService.start();

    // Assert
    verify(accountPermissionUpdateServlet).init(isA(ServletConfig.class));
    verify(broadcastHexServlet).init(isA(ServletConfig.class));
    verify(broadcastServlet).init(isA(ServletConfig.class));
    verify(cancelAllUnfreezeV2Servlet).init(isA(ServletConfig.class));
    verify(clearABIServlet).init(isA(ServletConfig.class));
    verify(createAccountServlet).init(isA(ServletConfig.class));
    verify(createAssetIssueServlet).init(isA(ServletConfig.class));
    verify(createCommonTransactionServlet).init(isA(ServletConfig.class));
    verify(createShieldedContractParametersServlet).init(isA(ServletConfig.class));
    verify(createShieldedContractParametersWithoutAskServlet).init(isA(ServletConfig.class));
    verify(createSpendAuthSigServlet).init(isA(ServletConfig.class));
    verify(createWitnessServlet).init(isA(ServletConfig.class));
    verify(delegateResourceServlet).init(isA(ServletConfig.class));
    verify(deployContractServlet).init(isA(ServletConfig.class));
    verify(estimateEnergyServlet).init(isA(ServletConfig.class));
    verify(exchangeCreateServlet).init(isA(ServletConfig.class));
    verify(exchangeInjectServlet).init(isA(ServletConfig.class));
    verify(exchangeTransactionServlet).init(isA(ServletConfig.class));
    verify(exchangeWithdrawServlet).init(isA(ServletConfig.class));
    verify(freezeBalanceServlet).init(isA(ServletConfig.class));
    verify(freezeBalanceV2Servlet).init(isA(ServletConfig.class));
    verify(getAccountBalanceServlet).init(isA(ServletConfig.class));
    verify(getAccountByIdServlet).init(isA(ServletConfig.class));
    verify(getAccountNetServlet).init(isA(ServletConfig.class));
    verify(getAccountResourceServlet).init(isA(ServletConfig.class));
    verify(getAccountServlet).init(isA(ServletConfig.class));
    verify(getAkFromAskServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByAccountServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByIdServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByNameServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListByNameServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListServlet).init(isA(ServletConfig.class));
    verify(getAvailableUnfreezeCountServlet).init(isA(ServletConfig.class));
    verify(getBandwidthPricesServlet).init(isA(ServletConfig.class));
    verify(getBlockBalanceServlet).init(isA(ServletConfig.class));
    verify(getBlockByIdServlet).init(isA(ServletConfig.class));
    verify(getBlockByLatestNumServlet).init(isA(ServletConfig.class));
    verify(getBlockByLimitNextServlet).init(isA(ServletConfig.class));
    verify(getBlockByNumServlet).init(isA(ServletConfig.class));
    verify(getBlockServlet).init(isA(ServletConfig.class));
    verify(getBrokerageServlet).init(isA(ServletConfig.class));
    verify(getBurnTrxServlet).init(isA(ServletConfig.class));
    verify(getCanDelegatedMaxSizeServlet).init(isA(ServletConfig.class));
    verify(getCanWithdrawUnfreezeAmountServlet).init(isA(ServletConfig.class));
    verify(getChainParametersServlet).init(isA(ServletConfig.class));
    verify(getContractInfoServlet).init(isA(ServletConfig.class));
    verify(getContractServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexV2Servlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceV2Servlet).init(isA(ServletConfig.class));
    verify(getDiversifierServlet).init(isA(ServletConfig.class));
    verify(getEnergyPricesServlet).init(isA(ServletConfig.class));
    verify(getExchangeByIdServlet).init(isA(ServletConfig.class));
    verify(getExpandedSpendingKeyServlet).init(isA(ServletConfig.class));
    verify(getIncomingViewingKeyServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByAccountServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByIdServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderListByPairServlet).init(isA(ServletConfig.class));
    verify(getMarketPairListServlet).init(isA(ServletConfig.class));
    verify(getMarketPriceByPairServlet).init(isA(ServletConfig.class));
    verify(getMemoFeePricesServlet).init(isA(ServletConfig.class));
    verify(getNewShieldedAddressServlet).init(isA(ServletConfig.class));
    verify(getNextMaintenanceTimeServlet).init(isA(ServletConfig.class));
    verify(getNkFromNskServlet).init(isA(ServletConfig.class));
    verify(getNowBlockServlet).init(isA(ServletConfig.class));
    verify(getPaginatedAssetIssueListServlet).init(isA(ServletConfig.class));
    verify(getPaginatedExchangeListServlet).init(isA(ServletConfig.class));
    verify(getPaginatedProposalListServlet).init(isA(ServletConfig.class));
    verify(getPendingSizeServlet).init(isA(ServletConfig.class));
    verify(getProposalByIdServlet).init(isA(ServletConfig.class));
    verify(getRcmServlet).init(isA(ServletConfig.class));
    verify(getRewardServlet).init(isA(ServletConfig.class));
    verify(getSpendingKeyServlet).init(isA(ServletConfig.class));
    verify(getTransactionApprovedListServlet).init(isA(ServletConfig.class));
    verify(getTransactionByIdServlet).init(isA(ServletConfig.class));
    verify(getTransactionCountByBlockNumServlet).init(isA(ServletConfig.class));
    verify(getTransactionFromPendingServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByBlockNumServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByIdServlet).init(isA(ServletConfig.class));
    verify(getTransactionListFromPendingServlet).init(isA(ServletConfig.class));
    verify(getTransactionReceiptByIdServlet).init(isA(ServletConfig.class));
    verify(getTransactionSignWeightServlet).init(isA(ServletConfig.class));
    verify(getTriggerInputForShieldedTRC20ContractServlet).init(isA(ServletConfig.class));
    verify(getZenPaymentAddressServlet).init(isA(ServletConfig.class));
    verify(isShieldedTRC20ContractNoteSpentServlet).init(isA(ServletConfig.class));
    verify(listExchangesServlet).init(isA(ServletConfig.class));
    verify(listProposalsServlet).init(isA(ServletConfig.class));
    verify(listWitnessesServlet).init(isA(ServletConfig.class));
    verify(marketCancelOrderServlet).init(isA(ServletConfig.class));
    verify(marketSellAssetServlet).init(isA(ServletConfig.class));
    verify(metricsServlet).init(isA(ServletConfig.class));
    verify(participateAssetIssueServlet).init(isA(ServletConfig.class));
    verify(proposalApproveServlet).init(isA(ServletConfig.class));
    verify(proposalCreateServlet).init(isA(ServletConfig.class));
    verify(proposalDeleteServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByIvkServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByOvkServlet).init(isA(ServletConfig.class));
    verify(setAccountIdServlet).init(isA(ServletConfig.class));
    verify(totalTransactionServlet).init(isA(ServletConfig.class));
    verify(transferAssetServlet).init(isA(ServletConfig.class));
    verify(transferServlet).init(isA(ServletConfig.class));
    verify(triggerConstantContractServlet).init(isA(ServletConfig.class));
    verify(triggerSmartContractServlet).init(isA(ServletConfig.class));
    verify(unDelegateResourceServlet).init(isA(ServletConfig.class));
    verify(unFreezeAssetServlet).init(isA(ServletConfig.class));
    verify(unFreezeBalanceServlet).init(isA(ServletConfig.class));
    verify(unFreezeBalanceV2Servlet).init(isA(ServletConfig.class));
    verify(updateAccountServlet).init(isA(ServletConfig.class));
    verify(updateAssetServlet).init(isA(ServletConfig.class));
    verify(updateBrokerageServlet).init(isA(ServletConfig.class));
    verify(updateEnergyLimitServlet).init(isA(ServletConfig.class));
    verify(updateSettingServlet).init(isA(ServletConfig.class));
    verify(updateWitnessServlet).init(isA(ServletConfig.class));
    verify(validateAddressServlet).init(isA(ServletConfig.class));
    verify(voteWitnessAccountServlet).init(isA(ServletConfig.class));
    verify(withdrawBalanceServlet).init(isA(ServletConfig.class));
    verify(withdrawExpireUnfreezeServlet).init(isA(ServletConfig.class));
    verify(getNodeInfoServlet, atLeast(1)).init(Mockito.<ServletConfig>any());
    verify(listNodesServlet, atLeast(1)).init(Mockito.<ServletConfig>any());
    verify(httpApiAccessFilter).init(isA(FilterConfig.class));
    verify(liteFnQueryHttpFilter).init(isA(FilterConfig.class));
  }

  /**
   * Test {@link FullNodeHttpApiService#start()}.
   *
   * <ul>
   *   <li>Given {@link WithdrawBalanceServlet} {@link WithdrawBalanceServlet#init(ServletConfig)}
   *       throw {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link AccountPermissionUpdateServlet#init(ServletConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link FullNodeHttpApiService#start()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FullNodeHttpApiService.start()"})
  public void testStart_givenWithdrawBalanceServletInitThrowRuntimeException_thenCallsInit2()
      throws ServletException {
    // Arrange
    doNothing().when(accountPermissionUpdateServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(broadcastHexServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(broadcastServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(cancelAllUnfreezeV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(clearABIServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createAssetIssueServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createCommonTransactionServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createShieldedContractParametersServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(createShieldedContractParametersWithoutAskServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(createSpendAuthSigServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(createWitnessServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(delegateResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(deployContractServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(estimateEnergyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(exchangeCreateServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(exchangeInjectServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(exchangeTransactionServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(exchangeWithdrawServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(freezeBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(freezeBalanceV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountNetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAkFromAskServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueByNameServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListByNameServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAssetIssueListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getAvailableUnfreezeCountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBandwidthPricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLatestNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByLimitNextServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockByNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBlockServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBrokerageServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getBurnTrxServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanDelegatedMaxSizeServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getCanWithdrawUnfreezeAmountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getChainParametersServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getContractInfoServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getContractServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceAccountIndexServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceAccountIndexV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDelegatedResourceV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getDiversifierServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getEnergyPricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExchangeByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getExpandedSpendingKeyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getIncomingViewingKeyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketOrderListByPairServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPairListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMarketPriceByPairServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getMemoFeePricesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNewShieldedAddressServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNextMaintenanceTimeServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNkFromNskServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNodeInfoServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getNowBlockServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedAssetIssueListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedExchangeListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPaginatedProposalListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getPendingSizeServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getProposalByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getRcmServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getRewardServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getSpendingKeyServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionApprovedListServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionCountByBlockNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionFromPendingServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByBlockNumServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionInfoByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionListFromPendingServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionReceiptByIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(getTransactionSignWeightServlet).init(Mockito.<ServletConfig>any());
    doNothing()
        .when(getTriggerInputForShieldedTRC20ContractServlet)
        .init(Mockito.<ServletConfig>any());
    doNothing().when(getZenPaymentAddressServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(httpApiAccessFilter).init(Mockito.<FilterConfig>any());
    doNothing().when(isShieldedTRC20ContractNoteSpentServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listExchangesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listNodesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listProposalsServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(listWitnessesServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(liteFnQueryHttpFilter).init(Mockito.<FilterConfig>any());
    doNothing().when(marketCancelOrderServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(marketSellAssetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(metricsServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(participateAssetIssueServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(proposalApproveServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(proposalCreateServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(proposalDeleteServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanShieldedTRC20NotesByIvkServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(scanShieldedTRC20NotesByOvkServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(setAccountIdServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(totalTransactionServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(transferAssetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(transferServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(triggerConstantContractServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(triggerSmartContractServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(unDelegateResourceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(unFreezeAssetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(unFreezeBalanceServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(unFreezeBalanceV2Servlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateAccountServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateAssetServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateBrokerageServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateEnergyLimitServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateSettingServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(updateWitnessServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(validateAddressServlet).init(Mockito.<ServletConfig>any());
    doNothing().when(voteWitnessAccountServlet).init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException()).when(withdrawBalanceServlet).init(Mockito.<ServletConfig>any());
    doThrow(new RuntimeException())
        .when(withdrawExpireUnfreezeServlet)
        .init(Mockito.<ServletConfig>any());

    // Act
    fullNodeHttpApiService.start();

    // Assert
    verify(accountPermissionUpdateServlet).init(isA(ServletConfig.class));
    verify(broadcastHexServlet).init(isA(ServletConfig.class));
    verify(broadcastServlet).init(isA(ServletConfig.class));
    verify(cancelAllUnfreezeV2Servlet).init(isA(ServletConfig.class));
    verify(clearABIServlet).init(isA(ServletConfig.class));
    verify(createAccountServlet).init(isA(ServletConfig.class));
    verify(createAssetIssueServlet).init(isA(ServletConfig.class));
    verify(createCommonTransactionServlet).init(isA(ServletConfig.class));
    verify(createShieldedContractParametersServlet).init(isA(ServletConfig.class));
    verify(createShieldedContractParametersWithoutAskServlet).init(isA(ServletConfig.class));
    verify(createSpendAuthSigServlet).init(isA(ServletConfig.class));
    verify(createWitnessServlet).init(isA(ServletConfig.class));
    verify(delegateResourceServlet).init(isA(ServletConfig.class));
    verify(deployContractServlet).init(isA(ServletConfig.class));
    verify(estimateEnergyServlet).init(isA(ServletConfig.class));
    verify(exchangeCreateServlet).init(isA(ServletConfig.class));
    verify(exchangeInjectServlet).init(isA(ServletConfig.class));
    verify(exchangeTransactionServlet).init(isA(ServletConfig.class));
    verify(exchangeWithdrawServlet).init(isA(ServletConfig.class));
    verify(freezeBalanceServlet).init(isA(ServletConfig.class));
    verify(freezeBalanceV2Servlet).init(isA(ServletConfig.class));
    verify(getAccountBalanceServlet).init(isA(ServletConfig.class));
    verify(getAccountByIdServlet).init(isA(ServletConfig.class));
    verify(getAccountNetServlet).init(isA(ServletConfig.class));
    verify(getAccountResourceServlet).init(isA(ServletConfig.class));
    verify(getAccountServlet).init(isA(ServletConfig.class));
    verify(getAkFromAskServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByAccountServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByIdServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueByNameServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListByNameServlet).init(isA(ServletConfig.class));
    verify(getAssetIssueListServlet).init(isA(ServletConfig.class));
    verify(getAvailableUnfreezeCountServlet).init(isA(ServletConfig.class));
    verify(getBandwidthPricesServlet).init(isA(ServletConfig.class));
    verify(getBlockBalanceServlet).init(isA(ServletConfig.class));
    verify(getBlockByIdServlet).init(isA(ServletConfig.class));
    verify(getBlockByLatestNumServlet).init(isA(ServletConfig.class));
    verify(getBlockByLimitNextServlet).init(isA(ServletConfig.class));
    verify(getBlockByNumServlet).init(isA(ServletConfig.class));
    verify(getBlockServlet).init(isA(ServletConfig.class));
    verify(getBrokerageServlet).init(isA(ServletConfig.class));
    verify(getBurnTrxServlet).init(isA(ServletConfig.class));
    verify(getCanDelegatedMaxSizeServlet).init(isA(ServletConfig.class));
    verify(getCanWithdrawUnfreezeAmountServlet).init(isA(ServletConfig.class));
    verify(getChainParametersServlet).init(isA(ServletConfig.class));
    verify(getContractInfoServlet).init(isA(ServletConfig.class));
    verify(getContractServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceAccountIndexV2Servlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceServlet).init(isA(ServletConfig.class));
    verify(getDelegatedResourceV2Servlet).init(isA(ServletConfig.class));
    verify(getDiversifierServlet).init(isA(ServletConfig.class));
    verify(getEnergyPricesServlet).init(isA(ServletConfig.class));
    verify(getExchangeByIdServlet).init(isA(ServletConfig.class));
    verify(getExpandedSpendingKeyServlet).init(isA(ServletConfig.class));
    verify(getIncomingViewingKeyServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByAccountServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderByIdServlet).init(isA(ServletConfig.class));
    verify(getMarketOrderListByPairServlet).init(isA(ServletConfig.class));
    verify(getMarketPairListServlet).init(isA(ServletConfig.class));
    verify(getMarketPriceByPairServlet).init(isA(ServletConfig.class));
    verify(getMemoFeePricesServlet).init(isA(ServletConfig.class));
    verify(getNewShieldedAddressServlet).init(isA(ServletConfig.class));
    verify(getNextMaintenanceTimeServlet).init(isA(ServletConfig.class));
    verify(getNkFromNskServlet).init(isA(ServletConfig.class));
    verify(getNowBlockServlet).init(isA(ServletConfig.class));
    verify(getPaginatedAssetIssueListServlet).init(isA(ServletConfig.class));
    verify(getPaginatedExchangeListServlet).init(isA(ServletConfig.class));
    verify(getPaginatedProposalListServlet).init(isA(ServletConfig.class));
    verify(getPendingSizeServlet).init(isA(ServletConfig.class));
    verify(getProposalByIdServlet).init(isA(ServletConfig.class));
    verify(getRcmServlet).init(isA(ServletConfig.class));
    verify(getRewardServlet).init(isA(ServletConfig.class));
    verify(getSpendingKeyServlet).init(isA(ServletConfig.class));
    verify(getTransactionApprovedListServlet).init(isA(ServletConfig.class));
    verify(getTransactionByIdServlet).init(isA(ServletConfig.class));
    verify(getTransactionCountByBlockNumServlet).init(isA(ServletConfig.class));
    verify(getTransactionFromPendingServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByBlockNumServlet).init(isA(ServletConfig.class));
    verify(getTransactionInfoByIdServlet).init(isA(ServletConfig.class));
    verify(getTransactionListFromPendingServlet).init(isA(ServletConfig.class));
    verify(getTransactionReceiptByIdServlet).init(isA(ServletConfig.class));
    verify(getTransactionSignWeightServlet).init(isA(ServletConfig.class));
    verify(getTriggerInputForShieldedTRC20ContractServlet).init(isA(ServletConfig.class));
    verify(getZenPaymentAddressServlet).init(isA(ServletConfig.class));
    verify(isShieldedTRC20ContractNoteSpentServlet).init(isA(ServletConfig.class));
    verify(listExchangesServlet).init(isA(ServletConfig.class));
    verify(listProposalsServlet).init(isA(ServletConfig.class));
    verify(listWitnessesServlet).init(isA(ServletConfig.class));
    verify(marketCancelOrderServlet).init(isA(ServletConfig.class));
    verify(marketSellAssetServlet).init(isA(ServletConfig.class));
    verify(metricsServlet).init(isA(ServletConfig.class));
    verify(participateAssetIssueServlet).init(isA(ServletConfig.class));
    verify(proposalApproveServlet).init(isA(ServletConfig.class));
    verify(proposalCreateServlet).init(isA(ServletConfig.class));
    verify(proposalDeleteServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByIvkServlet).init(isA(ServletConfig.class));
    verify(scanShieldedTRC20NotesByOvkServlet).init(isA(ServletConfig.class));
    verify(setAccountIdServlet).init(isA(ServletConfig.class));
    verify(totalTransactionServlet).init(isA(ServletConfig.class));
    verify(transferAssetServlet).init(isA(ServletConfig.class));
    verify(transferServlet).init(isA(ServletConfig.class));
    verify(triggerConstantContractServlet).init(isA(ServletConfig.class));
    verify(triggerSmartContractServlet).init(isA(ServletConfig.class));
    verify(unDelegateResourceServlet).init(isA(ServletConfig.class));
    verify(unFreezeAssetServlet).init(isA(ServletConfig.class));
    verify(unFreezeBalanceServlet).init(isA(ServletConfig.class));
    verify(unFreezeBalanceV2Servlet).init(isA(ServletConfig.class));
    verify(updateAccountServlet).init(isA(ServletConfig.class));
    verify(updateAssetServlet).init(isA(ServletConfig.class));
    verify(updateBrokerageServlet).init(isA(ServletConfig.class));
    verify(updateEnergyLimitServlet).init(isA(ServletConfig.class));
    verify(updateSettingServlet).init(isA(ServletConfig.class));
    verify(updateWitnessServlet).init(isA(ServletConfig.class));
    verify(validateAddressServlet).init(isA(ServletConfig.class));
    verify(voteWitnessAccountServlet).init(isA(ServletConfig.class));
    verify(withdrawBalanceServlet).init(isA(ServletConfig.class));
    verify(withdrawExpireUnfreezeServlet).init(isA(ServletConfig.class));
    verify(getNodeInfoServlet, atLeast(1)).init(Mockito.<ServletConfig>any());
    verify(listNodesServlet, atLeast(1)).init(Mockito.<ServletConfig>any());
    verify(httpApiAccessFilter).init(isA(FilterConfig.class));
    verify(liteFnQueryHttpFilter).init(isA(FilterConfig.class));
  }
}
