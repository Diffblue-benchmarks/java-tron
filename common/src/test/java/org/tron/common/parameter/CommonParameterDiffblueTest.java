package org.tron.common.parameter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.quartz.CronExpression;
import org.tron.common.args.GenesisBlock;
import org.tron.common.config.DbBackupConfig;
import org.tron.common.logsfilter.EventPluginConfig;
import org.tron.common.logsfilter.FilterQuery;
import org.tron.common.setting.RocksDbSettings;
import org.tron.core.config.args.Overlay;
import org.tron.core.config.args.SeedNode;
import org.tron.core.config.args.Storage;
import org.tron.p2p.P2pConfig;
import org.tron.p2p.dns.update.DnsType;
import org.tron.p2p.dns.update.PublishConfig;

public class CommonParameterDiffblueTest {
  /**
   * Test {@link CommonParameter#getSafeLruCacheSize()}.
   *
   * <ul>
   *   <li>Given {@link CommonParameter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CommonParameter#getSafeLruCacheSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CommonParameter.getSafeLruCacheSize()"})
  public void testGetSafeLruCacheSize_givenCommonParameter() {
    // Arrange, Act and Assert
    assertEquals(500, new CommonParameter().getSafeLruCacheSize());
  }

  /**
   * Test {@link CommonParameter#getSafeLruCacheSize()}.
   *
   * <ul>
   *   <li>Given {@link CommonParameter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CommonParameter#getSafeLruCacheSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CommonParameter.getSafeLruCacheSize()"})
  public void testGetSafeLruCacheSize_givenCommonParameter2() {
    // Arrange, Act and Assert
    assertEquals(500, new CommonParameter().getSafeLruCacheSize());
  }

  /**
   * Test {@link CommonParameter#getSafeLruCacheSize()}.
   *
   * <ul>
   *   <li>Given {@link CommonParameter} (default constructor) LruCacheSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonParameter#getSafeLruCacheSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CommonParameter.getSafeLruCacheSize()"})
  public void testGetSafeLruCacheSize_givenCommonParameterLruCacheSizeIsZero() {
    // Arrange
    CommonParameter commonParameter = new CommonParameter();
    commonParameter.setLruCacheSize(0);

    // Act and Assert
    assertEquals(500, commonParameter.getSafeLruCacheSize());
  }

  /**
   * Test {@link CommonParameter#getSafeLruCacheSize()}.
   *
   * <ul>
   *   <li>Given {@link CommonParameter} (default constructor) LruCacheSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link CommonParameter#getSafeLruCacheSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CommonParameter.getSafeLruCacheSize()"})
  public void testGetSafeLruCacheSize_givenCommonParameterLruCacheSizeIsZero2() {
    // Arrange
    CommonParameter commonParameter = new CommonParameter();
    commonParameter.setLruCacheSize(0);

    // Act and Assert
    assertEquals(500, commonParameter.getSafeLruCacheSize());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CommonParameter#getInstance()}
   *   <li>{@link CommonParameter#setActiveNodes(List)}
   *   <li>{@link CommonParameter#setActuatorSet(Set)}
   *   <li>{@link CommonParameter#setAgreeNodeCount(int)}
   *   <li>{@link CommonParameter#setAllowAccountAssetOptimization(long)}
   *   <li>{@link CommonParameter#setAllowAccountStateRoot(long)}
   *   <li>{@link CommonParameter#setAllowAdaptiveEnergy(long)}
   *   <li>{@link CommonParameter#setAllowAssetOptimization(long)}
   *   <li>{@link CommonParameter#setAllowBlackHoleOptimization(long)}
   *   <li>{@link CommonParameter#setAllowCancelAllUnfreezeV2(long)}
   *   <li>{@link CommonParameter#setAllowCreationOfContracts(long)}
   *   <li>{@link CommonParameter#setAllowDelegateOptimization(long)}
   *   <li>{@link CommonParameter#setAllowDelegateResource(long)}
   *   <li>{@link CommonParameter#setAllowDynamicEnergy(long)}
   *   <li>{@link CommonParameter#setAllowEnergyAdjustment(long)}
   *   <li>{@link CommonParameter#setAllowHigherLimitForMaxCpuTimeOfOneTx(long)}
   *   <li>{@link CommonParameter#setAllowMarketTransaction(long)}
   *   <li>{@link CommonParameter#setAllowMultiSign(int)}
   *   <li>{@link CommonParameter#setAllowNewResourceModel(long)}
   *   <li>{@link CommonParameter#setAllowNewReward(long)}
   *   <li>{@link CommonParameter#setAllowNewRewardAlgorithm(long)}
   *   <li>{@link CommonParameter#setAllowOldRewardOpt(long)}
   *   <li>{@link CommonParameter#setAllowOptimizedReturnValueOfChainId(long)}
   *   <li>{@link CommonParameter#setAllowPBFT(long)}
   *   <li>{@link CommonParameter#setAllowSameTokenName(long)}
   *   <li>{@link CommonParameter#setAllowShieldedTRC20Transaction(long)}
   *   <li>{@link CommonParameter#setAllowStrictMath(long)}
   *   <li>{@link CommonParameter#setAllowTransactionFeePool(long)}
   *   <li>{@link CommonParameter#setAllowTvmCompatibleEvm(long)}
   *   <li>{@link CommonParameter#setAllowTvmConstantinople(long)}
   *   <li>{@link CommonParameter#setAllowTvmFreeze(long)}
   *   <li>{@link CommonParameter#setAllowTvmIstanbul(long)}
   *   <li>{@link CommonParameter#setAllowTvmLondon(long)}
   *   <li>{@link CommonParameter#setAllowTvmShangHai(long)}
   *   <li>{@link CommonParameter#setAllowTvmSolidity059(long)}
   *   <li>{@link CommonParameter#setAllowTvmTransferTrc10(long)}
   *   <li>{@link CommonParameter#setAllowTvmVote(long)}
   *   <li>{@link CommonParameter#setBackupMembers(List)}
   *   <li>{@link CommonParameter#setBackupPort(int)}
   *   <li>{@link CommonParameter#setBackupPriority(int)}
   *   <li>{@link CommonParameter#setBlockCacheTimeout(long)}
   *   <li>{@link CommonParameter#setBlockNumForEnergyLimit(long)}
   *   <li>{@link CommonParameter#setBlockProducedTimeOut(int)}
   *   <li>{@link CommonParameter#setChainId(String)}
   *   <li>{@link CommonParameter#setChangedDelegation(long)}
   *   <li>{@link CommonParameter#setCheckFrozenTime(int)}
   *   <li>{@link CommonParameter#setConsensusLogicOptimization(long)}
   *   <li>{@link CommonParameter#setDebug(boolean)}
   *   <li>{@link CommonParameter#setDisabledApiList(List)}
   *   <li>{@link CommonParameter#setDnsPublishConfig(PublishConfig)}
   *   <li>{@link CommonParameter#setDnsTreeUrls(List)}
   *   <li>{@link CommonParameter#setDynamicConfigCheckInterval(long)}
   *   <li>{@link CommonParameter#setDynamicConfigEnable(boolean)}
   *   <li>{@link CommonParameter#setDynamicEnergyIncreaseFactor(long)}
   *   <li>{@link CommonParameter#setDynamicEnergyMaxFactor(long)}
   *   <li>{@link CommonParameter#setDynamicEnergyThreshold(long)}
   *   <li>{@link CommonParameter#setEstimateEnergy(boolean)}
   *   <li>{@link CommonParameter#setEstimateEnergyMaxRetry(int)}
   *   <li>{@link CommonParameter#setEventSubscribe(boolean)}
   *   <li>{@link CommonParameter#setFetchBlockTimeout(int)}
   *   <li>{@link CommonParameter#setFlowControlWindow(int)}
   *   <li>{@link CommonParameter#setForbidTransferToContract(long)}
   *   <li>{@link CommonParameter#setFullNodeAllowShieldedTransactionArgs(boolean)}
   *   <li>{@link CommonParameter#setFullNodeHttpEnable(boolean)}
   *   <li>{@link CommonParameter#setFullNodeHttpPort(int)}
   *   <li>{@link CommonParameter#setHistoryBalanceLookup(boolean)}
   *   <li>{@link CommonParameter#setInactiveThreshold(int)}
   *   <li>{@link CommonParameter#setInfluxDbDatabase(String)}
   *   <li>{@link CommonParameter#setInfluxDbIp(String)}
   *   <li>{@link CommonParameter#setInfluxDbPort(int)}
   *   <li>{@link CommonParameter#setJsonRpcHttpFullNodeEnable(boolean)}
   *   <li>{@link CommonParameter#setJsonRpcHttpFullNodePort(int)}
   *   <li>{@link CommonParameter#setJsonRpcHttpPBFTNodeEnable(boolean)}
   *   <li>{@link CommonParameter#setJsonRpcHttpPBFTPort(int)}
   *   <li>{@link CommonParameter#setJsonRpcHttpSolidityNodeEnable(boolean)}
   *   <li>{@link CommonParameter#setJsonRpcHttpSolidityPort(int)}
   *   <li>{@link CommonParameter#setKeepAliveInterval(int)}
   *   <li>{@link CommonParameter#setLongRunningTime(int)}
   *   <li>{@link CommonParameter#setLruCacheSize(int)}
   *   <li>{@link CommonParameter#setMaintenanceTimeInterval(long)}
   *   <li>{@link CommonParameter#setMaxConcurrentCallsPerConnection(int)}
   *   <li>{@link CommonParameter#setMaxConnectionAgeInMillis(long)}
   *   <li>{@link CommonParameter#setMaxConnectionIdleInMillis(long)}
   *   <li>{@link CommonParameter#setMaxConnections(int)}
   *   <li>{@link CommonParameter#setMaxConnectionsWithSameIp(int)}
   *   <li>{@link CommonParameter#setMaxCreateAccountTxSize(long)}
   *   <li>{@link CommonParameter#setMaxEnergyLimitForConstant(long)}
   *   <li>{@link CommonParameter#setMaxHeaderListSize(int)}
   *   <li>{@link CommonParameter#setMaxHttpConnectNumber(int)}
   *   <li>{@link CommonParameter#setMaxMessageSize(int)}
   *   <li>{@link CommonParameter#setMaxTimeRatio(double)}
   *   <li>{@link CommonParameter#setMaxTps(int)}
   *   <li>{@link CommonParameter#setMaxTransactionPendingSize(int)}
   *   <li>{@link CommonParameter#setMaxUnsolidifiedBlocks(int)}
   *   <li>{@link CommonParameter#setMemoFee(long)}
   *   <li>{@link CommonParameter#setMetricsPrometheusEnable(boolean)}
   *   <li>{@link CommonParameter#setMetricsPrometheusPort(int)}
   *   <li>{@link CommonParameter#setMetricsReportInterval(int)}
   *   <li>{@link CommonParameter#setMetricsStorageEnable(boolean)}
   *   <li>{@link CommonParameter#setMinActiveConnections(int)}
   *   <li>{@link CommonParameter#setMinConnections(int)}
   *   <li>{@link CommonParameter#setMinEffectiveConnection(int)}
   *   <li>{@link CommonParameter#setMinParticipationRate(int)}
   *   <li>{@link CommonParameter#setMinTimeRatio(double)}
   *   <li>{@link CommonParameter#setNeedSyncCheck(boolean)}
   *   <li>{@link CommonParameter#setNeedToUpdateAsset(boolean)}
   *   <li>{@link CommonParameter#setNetMaxTrxPerSecond(long)}
   *   <li>{@link CommonParameter#setNodeChannelReadTimeout(int)}
   *   <li>{@link CommonParameter#setNodeConnectionTimeout(int)}
   *   <li>{@link CommonParameter#setNodeDetectEnable(boolean)}
   *   <li>{@link CommonParameter#setNodeDiscoveryEnable(boolean)}
   *   <li>{@link CommonParameter#setNodeDiscoveryPersist(boolean)}
   *   <li>{@link CommonParameter#setNodeEffectiveCheckEnable(boolean)}
   *   <li>{@link CommonParameter#setNodeEnableIpv6(boolean)}
   *   <li>{@link CommonParameter#setNodeExternalIp(String)}
   *   <li>{@link CommonParameter#setNodeLanIp(String)}
   *   <li>{@link CommonParameter#setNodeListenPort(int)}
   *   <li>{@link CommonParameter#setNodeMetricsEnable(boolean)}
   *   <li>{@link CommonParameter#setNodeP2pVersion(int)}
   *   <li>{@link CommonParameter#setOldSolidityBlockNum(long)}
   *   <li>{@link CommonParameter#setOpenFullTcpDisconnect(boolean)}
   *   <li>{@link CommonParameter#setOpenHistoryQueryWhenLiteFN(boolean)}
   *   <li>{@link CommonParameter#setOpenPrintLog(boolean)}
   *   <li>{@link CommonParameter#setOpenTransactionSort(boolean)}
   *   <li>{@link CommonParameter#setP2pDisable(boolean)}
   *   <li>{@link CommonParameter#setPBFTExpireNum(long)}
   *   <li>{@link CommonParameter#setPBFTHttpPort(int)}
   *   <li>{@link CommonParameter#setPassiveNodes(List)}
   *   <li>{@link CommonParameter#setPendingTransactionTimeout(long)}
   *   <li>{@link CommonParameter#setProposalExpireTime(long)}
   *   <li>{@link CommonParameter#setRateLimiterGlobalIpQps(int)}
   *   <li>{@link CommonParameter#setRateLimiterGlobalQps(int)}
   *   <li>{@link CommonParameter#setRateLimiterInitialization(RateLimiterInitialization)}
   *   <li>{@link CommonParameter#setReceiveTcpMinDataLength(long)}
   *   <li>{@link CommonParameter#setRpcOnPBFTPort(int)}
   *   <li>{@link CommonParameter#setRpcOnSolidityPort(int)}
   *   <li>{@link CommonParameter#setRpcPort(int)}
   *   <li>{@link CommonParameter#setRpcReflectionServiceEnable(boolean)}
   *   <li>{@link CommonParameter#setRpcThreadNum(int)}
   *   <li>{@link CommonParameter#setSaveFeaturedInternalTx(boolean)}
   *   <li>{@link CommonParameter#setSaveInternalTx(boolean)}
   *   <li>{@link CommonParameter#setShieldedTransInPendingMaxCounts(int)}
   *   <li>{@link CommonParameter#setShutdownBlockCount(long)}
   *   <li>{@link CommonParameter#setShutdownBlockHeight(long)}
   *   <li>{@link CommonParameter#setSolidityHttpPort(int)}
   *   <li>{@link CommonParameter#setSolidityNode(boolean)}
   *   <li>{@link CommonParameter#setSolidityNodeHttpEnable(boolean)}
   *   <li>{@link CommonParameter#setSolidityThreads(int)}
   *   <li>{@link CommonParameter#setSupportConstant(boolean)}
   *   <li>{@link CommonParameter#setSyncFetchBatchNum(long)}
   *   <li>{@link CommonParameter#setTcpNettyWorkThreadNum(int)}
   *   <li>{@link CommonParameter#setTrustNodeAddr(String)}
   *   <li>{@link CommonParameter#setTrxCacheEnable(boolean)}
   *   <li>{@link CommonParameter#setTrxExpirationTimeInMilliseconds(long)}
   *   <li>{@link CommonParameter#setTrxReferenceBlock(String)}
   *   <li>{@link CommonParameter#setUdpNettyWorkThreadNum(int)}
   *   <li>{@link CommonParameter#setUnfreezeDelayDays(long)}
   *   <li>{@link CommonParameter#setUnsolidifiedBlockCheck(boolean)}
   *   <li>{@link CommonParameter#setValidateSignThreadNum(int)}
   *   <li>{@link CommonParameter#setVmTrace(boolean)}
   *   <li>{@link CommonParameter#setWalletExtensionApi(boolean)}
   *   <li>{@link CommonParameter#setWitness(boolean)}
   *   <li>{@link CommonParameter#setZenTokenId(String)}
   *   <li>{@link CommonParameter#setAllowProtoFilterNum(long)}
   *   <li>{@link CommonParameter#setCryptoEngine(String)}
   *   <li>{@link CommonParameter#setENERGY_LIMIT_HARD_FORK(boolean)}
   *   <li>{@link CommonParameter#setValidContractProtoThreadNum(int)}
   *   <li>{@link CommonParameter#getActiveNodes()}
   *   <li>{@link CommonParameter#getActuatorSet()}
   *   <li>{@link CommonParameter#getAgreeNodeCount()}
   *   <li>{@link CommonParameter#getAllowAccountAssetOptimization()}
   *   <li>{@link CommonParameter#getAllowAccountStateRoot()}
   *   <li>{@link CommonParameter#getAllowAdaptiveEnergy()}
   *   <li>{@link CommonParameter#getAllowAssetOptimization()}
   *   <li>{@link CommonParameter#getAllowBlackHoleOptimization()}
   *   <li>{@link CommonParameter#getAllowCancelAllUnfreezeV2()}
   *   <li>{@link CommonParameter#getAllowCreationOfContracts()}
   *   <li>{@link CommonParameter#getAllowDelegateOptimization()}
   *   <li>{@link CommonParameter#getAllowDelegateResource()}
   *   <li>{@link CommonParameter#getAllowDynamicEnergy()}
   *   <li>{@link CommonParameter#getAllowEnergyAdjustment()}
   *   <li>{@link CommonParameter#getAllowHigherLimitForMaxCpuTimeOfOneTx()}
   *   <li>{@link CommonParameter#getAllowMarketTransaction()}
   *   <li>{@link CommonParameter#getAllowMultiSign()}
   *   <li>{@link CommonParameter#getAllowNewResourceModel()}
   *   <li>{@link CommonParameter#getAllowNewReward()}
   *   <li>{@link CommonParameter#getAllowNewRewardAlgorithm()}
   *   <li>{@link CommonParameter#getAllowOldRewardOpt()}
   *   <li>{@link CommonParameter#getAllowOptimizedReturnValueOfChainId()}
   *   <li>{@link CommonParameter#getAllowPBFT()}
   *   <li>{@link CommonParameter#getAllowProtoFilterNum()}
   *   <li>{@link CommonParameter#getAllowSameTokenName()}
   *   <li>{@link CommonParameter#getAllowShieldedTRC20Transaction()}
   *   <li>{@link CommonParameter#getAllowStrictMath()}
   *   <li>{@link CommonParameter#getAllowTransactionFeePool()}
   *   <li>{@link CommonParameter#getAllowTvmCompatibleEvm()}
   *   <li>{@link CommonParameter#getAllowTvmConstantinople()}
   *   <li>{@link CommonParameter#getAllowTvmFreeze()}
   *   <li>{@link CommonParameter#getAllowTvmIstanbul()}
   *   <li>{@link CommonParameter#getAllowTvmLondon()}
   *   <li>{@link CommonParameter#getAllowTvmShangHai()}
   *   <li>{@link CommonParameter#getAllowTvmSolidity059()}
   *   <li>{@link CommonParameter#getAllowTvmTransferTrc10()}
   *   <li>{@link CommonParameter#getAllowTvmVote()}
   *   <li>{@link CommonParameter#getBackupMembers()}
   *   <li>{@link CommonParameter#getBackupPort()}
   *   <li>{@link CommonParameter#getBackupPriority()}
   *   <li>{@link CommonParameter#getBlockCacheTimeout()}
   *   <li>{@link CommonParameter#getBlockNumForEnergyLimit()}
   *   <li>{@link CommonParameter#getBlockProducedTimeOut()}
   *   <li>{@link CommonParameter#getChainId()}
   *   <li>{@link CommonParameter#getChangedDelegation()}
   *   <li>{@link CommonParameter#getCheckFrozenTime()}
   *   <li>{@link CommonParameter#getConsensusLogicOptimization()}
   *   <li>{@link CommonParameter#getCryptoEngine()}
   *   <li>{@link CommonParameter#getDbBackupConfig()}
   *   <li>{@link CommonParameter#getDisabledApiList()}
   *   <li>{@link CommonParameter#getDnsPublishConfig()}
   *   <li>{@link CommonParameter#getDnsTreeUrls()}
   *   <li>{@link CommonParameter#getDynamicConfigCheckInterval()}
   *   <li>{@link CommonParameter#getDynamicEnergyIncreaseFactor()}
   *   <li>{@link CommonParameter#getDynamicEnergyMaxFactor()}
   *   <li>{@link CommonParameter#getDynamicEnergyThreshold()}
   *   <li>{@link CommonParameter#getEstimateEnergyMaxRetry()}
   *   <li>{@link CommonParameter#getEventFilter()}
   *   <li>{@link CommonParameter#getEventPluginConfig()}
   *   <li>{@link CommonParameter#getFastForwardNodes()}
   *   <li>{@link CommonParameter#getFetchBlockTimeout()}
   *   <li>{@link CommonParameter#getFlowControlWindow()}
   *   <li>{@link CommonParameter#getForbidTransferToContract()}
   *   <li>{@link CommonParameter#getFullNodeHttpPort()}
   *   <li>{@link CommonParameter#getGenesisBlock()}
   *   <li>{@link CommonParameter#getInactiveThreshold()}
   *   <li>{@link CommonParameter#getInfluxDbDatabase()}
   *   <li>{@link CommonParameter#getInfluxDbIp()}
   *   <li>{@link CommonParameter#getInfluxDbPort()}
   *   <li>{@link CommonParameter#getJsonRpcHttpFullNodePort()}
   *   <li>{@link CommonParameter#getJsonRpcHttpPBFTPort()}
   *   <li>{@link CommonParameter#getJsonRpcHttpSolidityPort()}
   *   <li>{@link CommonParameter#getKeepAliveInterval()}
   *   <li>{@link CommonParameter#getLogbackPath()}
   *   <li>{@link CommonParameter#getLongRunningTime()}
   *   <li>{@link CommonParameter#getLruCacheSize()}
   *   <li>{@link CommonParameter#getMaintenanceTimeInterval()}
   *   <li>{@link CommonParameter#getMaxConcurrentCallsPerConnection()}
   *   <li>{@link CommonParameter#getMaxConnectionAgeInMillis()}
   *   <li>{@link CommonParameter#getMaxConnectionIdleInMillis()}
   *   <li>{@link CommonParameter#getMaxConnections()}
   *   <li>{@link CommonParameter#getMaxConnectionsWithSameIp()}
   *   <li>{@link CommonParameter#getMaxCreateAccountTxSize()}
   *   <li>{@link CommonParameter#getMaxEnergyLimitForConstant()}
   *   <li>{@link CommonParameter#getMaxFastForwardNum()}
   *   <li>{@link CommonParameter#getMaxHeaderListSize()}
   *   <li>{@link CommonParameter#getMaxHttpConnectNumber()}
   *   <li>{@link CommonParameter#getMaxMessageSize()}
   *   <li>{@link CommonParameter#getMaxTimeRatio()}
   *   <li>{@link CommonParameter#getMaxTps()}
   *   <li>{@link CommonParameter#getMaxTransactionPendingSize()}
   *   <li>{@link CommonParameter#getMaxUnsolidifiedBlocks()}
   *   <li>{@link CommonParameter#getMemoFee()}
   *   <li>{@link CommonParameter#getMetricsPrometheusPort()}
   *   <li>{@link CommonParameter#getMetricsReportInterval()}
   *   <li>{@link CommonParameter#getMinActiveConnections()}
   *   <li>{@link CommonParameter#getMinConnections()}
   *   <li>{@link CommonParameter#getMinEffectiveConnection()}
   *   <li>{@link CommonParameter#getMinParticipationRate()}
   *   <li>{@link CommonParameter#getMinTimeRatio()}
   *   <li>{@link CommonParameter#getNetMaxTrxPerSecond()}
   *   <li>{@link CommonParameter#getNodeChannelReadTimeout()}
   *   <li>{@link CommonParameter#getNodeConnectionTimeout()}
   *   <li>{@link CommonParameter#getNodeExternalIp()}
   *   <li>{@link CommonParameter#getNodeLanIp()}
   *   <li>{@link CommonParameter#getNodeListenPort()}
   *   <li>{@link CommonParameter#getNodeP2pVersion()}
   *   <li>{@link CommonParameter#getOldSolidityBlockNum()}
   *   <li>{@link CommonParameter#getOutputDirectory()}
   *   <li>{@link CommonParameter#getOverlay()}
   *   <li>{@link CommonParameter#getP2pConfig()}
   *   <li>{@link CommonParameter#getPBFTExpireNum()}
   *   <li>{@link CommonParameter#getPBFTHttpPort()}
   *   <li>{@link CommonParameter#getPassiveNodes()}
   *   <li>{@link CommonParameter#getPendingTransactionTimeout()}
   *   <li>{@link CommonParameter#getProposalExpireTime()}
   *   <li>{@link CommonParameter#getRateLimiterGlobalApiQps()}
   *   <li>{@link CommonParameter#getRateLimiterGlobalIpQps()}
   *   <li>{@link CommonParameter#getRateLimiterGlobalQps()}
   *   <li>{@link CommonParameter#getRateLimiterInitialization()}
   *   <li>{@link CommonParameter#getReceiveTcpMinDataLength()}
   *   <li>{@link CommonParameter#getRocksDBCustomSettings()}
   *   <li>{@link CommonParameter#getRpcOnPBFTPort()}
   *   <li>{@link CommonParameter#getRpcOnSolidityPort()}
   *   <li>{@link CommonParameter#getRpcPort()}
   *   <li>{@link CommonParameter#getRpcThreadNum()}
   *   <li>{@link CommonParameter#getSeedNode()}
   *   <li>{@link CommonParameter#getSeedNodes()}
   *   <li>{@link CommonParameter#getShellConfFileName()}
   *   <li>{@link CommonParameter#getShieldedTransInPendingMaxCounts()}
   *   <li>{@link CommonParameter#getShutdownBlockCount()}
   *   <li>{@link CommonParameter#getShutdownBlockHeight()}
   *   <li>{@link CommonParameter#getShutdownBlockTime()}
   *   <li>{@link CommonParameter#getSolidityHttpPort()}
   *   <li>{@link CommonParameter#getSolidityThreads()}
   *   <li>{@link CommonParameter#getStorage()}
   *   <li>{@link CommonParameter#getSyncFetchBatchNum()}
   *   <li>{@link CommonParameter#getTcpNettyWorkThreadNum()}
   *   <li>{@link CommonParameter#getTrustNodeAddr()}
   *   <li>{@link CommonParameter#getTrxExpirationTimeInMilliseconds()}
   *   <li>{@link CommonParameter#getTrxReferenceBlock()}
   *   <li>{@link CommonParameter#getUdpNettyWorkThreadNum()}
   *   <li>{@link CommonParameter#getUnfreezeDelayDays()}
   *   <li>{@link CommonParameter#getValidContractProtoThreadNum()}
   *   <li>{@link CommonParameter#getValidateSignThreadNum()}
   *   <li>{@link CommonParameter#getZenTokenId()}
   *   <li>{@link CommonParameter#isDebug()}
   *   <li>{@link CommonParameter#isDynamicConfigEnable()}
   *   <li>{@link CommonParameter#isEstimateEnergy()}
   *   <li>{@link CommonParameter#isEventSubscribe()}
   *   <li>{@link CommonParameter#isFastForward()}
   *   <li>{@link CommonParameter#isFullNodeAllowShieldedTransactionArgs()}
   *   <li>{@link CommonParameter#isFullNodeHttpEnable()}
   *   <li>{@link CommonParameter#isHelp()}
   *   <li>{@link CommonParameter#isHistoryBalanceLookup()}
   *   <li>{@link CommonParameter#isJsonRpcHttpFullNodeEnable()}
   *   <li>{@link CommonParameter#isJsonRpcHttpPBFTNodeEnable()}
   *   <li>{@link CommonParameter#isJsonRpcHttpSolidityNodeEnable()}
   *   <li>{@link CommonParameter#isMetricsPrometheusEnable()}
   *   <li>{@link CommonParameter#isMetricsStorageEnable()}
   *   <li>{@link CommonParameter#isNeedSyncCheck()}
   *   <li>{@link CommonParameter#isNeedToUpdateAsset()}
   *   <li>{@link CommonParameter#isNodeDetectEnable()}
   *   <li>{@link CommonParameter#isNodeDiscoveryEnable()}
   *   <li>{@link CommonParameter#isNodeDiscoveryPersist()}
   *   <li>{@link CommonParameter#isNodeEffectiveCheckEnable()}
   *   <li>{@link CommonParameter#isNodeEnableIpv6()}
   *   <li>{@link CommonParameter#isNodeMetricsEnable()}
   *   <li>{@link CommonParameter#isOpenFullTcpDisconnect()}
   *   <li>{@link CommonParameter#isOpenHistoryQueryWhenLiteFN()}
   *   <li>{@link CommonParameter#isOpenPrintLog()}
   *   <li>{@link CommonParameter#isOpenTransactionSort()}
   *   <li>{@link CommonParameter#isP2pDisable()}
   *   <li>{@link CommonParameter#isRpcReflectionServiceEnable()}
   *   <li>{@link CommonParameter#isSaveFeaturedInternalTx()}
   *   <li>{@link CommonParameter#isSaveInternalTx()}
   *   <li>{@link CommonParameter#isSolidityNode()}
   *   <li>{@link CommonParameter#isSolidityNodeHttpEnable()}
   *   <li>{@link CommonParameter#isSupportConstant()}
   *   <li>{@link CommonParameter#isTrxCacheEnable()}
   *   <li>{@link CommonParameter#isUnsolidifiedBlockCheck()}
   *   <li>{@link CommonParameter#isVmTrace()}
   *   <li>{@link CommonParameter#isWalletExtensionApi()}
   *   <li>{@link CommonParameter#isWitness()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "List CommonParameter.getActiveNodes()",
    "Set CommonParameter.getActuatorSet()",
    "int CommonParameter.getAgreeNodeCount()",
    "long CommonParameter.getAllowAccountAssetOptimization()",
    "long CommonParameter.getAllowAccountStateRoot()",
    "long CommonParameter.getAllowAdaptiveEnergy()",
    "long CommonParameter.getAllowAssetOptimization()",
    "long CommonParameter.getAllowBlackHoleOptimization()",
    "long CommonParameter.getAllowCancelAllUnfreezeV2()",
    "long CommonParameter.getAllowCreationOfContracts()",
    "long CommonParameter.getAllowDelegateOptimization()",
    "long CommonParameter.getAllowDelegateResource()",
    "long CommonParameter.getAllowDynamicEnergy()",
    "long CommonParameter.getAllowEnergyAdjustment()",
    "long CommonParameter.getAllowHigherLimitForMaxCpuTimeOfOneTx()",
    "long CommonParameter.getAllowMarketTransaction()",
    "int CommonParameter.getAllowMultiSign()",
    "long CommonParameter.getAllowNewResourceModel()",
    "long CommonParameter.getAllowNewReward()",
    "long CommonParameter.getAllowNewRewardAlgorithm()",
    "long CommonParameter.getAllowOldRewardOpt()",
    "long CommonParameter.getAllowOptimizedReturnValueOfChainId()",
    "long CommonParameter.getAllowPBFT()",
    "long CommonParameter.getAllowProtoFilterNum()",
    "long CommonParameter.getAllowSameTokenName()",
    "long CommonParameter.getAllowShieldedTRC20Transaction()",
    "long CommonParameter.getAllowStrictMath()",
    "long CommonParameter.getAllowTransactionFeePool()",
    "long CommonParameter.getAllowTvmCompatibleEvm()",
    "long CommonParameter.getAllowTvmConstantinople()",
    "long CommonParameter.getAllowTvmFreeze()",
    "long CommonParameter.getAllowTvmIstanbul()",
    "long CommonParameter.getAllowTvmLondon()",
    "long CommonParameter.getAllowTvmShangHai()",
    "long CommonParameter.getAllowTvmSolidity059()",
    "long CommonParameter.getAllowTvmTransferTrc10()",
    "long CommonParameter.getAllowTvmVote()",
    "List CommonParameter.getBackupMembers()",
    "int CommonParameter.getBackupPort()",
    "int CommonParameter.getBackupPriority()",
    "long CommonParameter.getBlockCacheTimeout()",
    "long CommonParameter.getBlockNumForEnergyLimit()",
    "int CommonParameter.getBlockProducedTimeOut()",
    "String CommonParameter.getChainId()",
    "long CommonParameter.getChangedDelegation()",
    "int CommonParameter.getCheckFrozenTime()",
    "long CommonParameter.getConsensusLogicOptimization()",
    "String CommonParameter.getCryptoEngine()",
    "DbBackupConfig CommonParameter.getDbBackupConfig()",
    "List CommonParameter.getDisabledApiList()",
    "PublishConfig CommonParameter.getDnsPublishConfig()",
    "List CommonParameter.getDnsTreeUrls()",
    "long CommonParameter.getDynamicConfigCheckInterval()",
    "long CommonParameter.getDynamicEnergyIncreaseFactor()",
    "long CommonParameter.getDynamicEnergyMaxFactor()",
    "long CommonParameter.getDynamicEnergyThreshold()",
    "int CommonParameter.getEstimateEnergyMaxRetry()",
    "FilterQuery CommonParameter.getEventFilter()",
    "EventPluginConfig CommonParameter.getEventPluginConfig()",
    "List CommonParameter.getFastForwardNodes()",
    "int CommonParameter.getFetchBlockTimeout()",
    "int CommonParameter.getFlowControlWindow()",
    "long CommonParameter.getForbidTransferToContract()",
    "int CommonParameter.getFullNodeHttpPort()",
    "GenesisBlock CommonParameter.getGenesisBlock()",
    "int CommonParameter.getInactiveThreshold()",
    "String CommonParameter.getInfluxDbDatabase()",
    "String CommonParameter.getInfluxDbIp()",
    "int CommonParameter.getInfluxDbPort()",
    "CommonParameter CommonParameter.getInstance()",
    "int CommonParameter.getJsonRpcHttpFullNodePort()",
    "int CommonParameter.getJsonRpcHttpPBFTPort()",
    "int CommonParameter.getJsonRpcHttpSolidityPort()",
    "int CommonParameter.getKeepAliveInterval()",
    "String CommonParameter.getLogbackPath()",
    "int CommonParameter.getLongRunningTime()",
    "int CommonParameter.getLruCacheSize()",
    "long CommonParameter.getMaintenanceTimeInterval()",
    "int CommonParameter.getMaxConcurrentCallsPerConnection()",
    "long CommonParameter.getMaxConnectionAgeInMillis()",
    "long CommonParameter.getMaxConnectionIdleInMillis()",
    "int CommonParameter.getMaxConnections()",
    "int CommonParameter.getMaxConnectionsWithSameIp()",
    "long CommonParameter.getMaxCreateAccountTxSize()",
    "long CommonParameter.getMaxEnergyLimitForConstant()",
    "int CommonParameter.getMaxFastForwardNum()",
    "int CommonParameter.getMaxHeaderListSize()",
    "int CommonParameter.getMaxHttpConnectNumber()",
    "int CommonParameter.getMaxMessageSize()",
    "double CommonParameter.getMaxTimeRatio()",
    "int CommonParameter.getMaxTps()",
    "int CommonParameter.getMaxTransactionPendingSize()",
    "int CommonParameter.getMaxUnsolidifiedBlocks()",
    "long CommonParameter.getMemoFee()",
    "int CommonParameter.getMetricsPrometheusPort()",
    "int CommonParameter.getMetricsReportInterval()",
    "int CommonParameter.getMinActiveConnections()",
    "int CommonParameter.getMinConnections()",
    "int CommonParameter.getMinEffectiveConnection()",
    "int CommonParameter.getMinParticipationRate()",
    "double CommonParameter.getMinTimeRatio()",
    "long CommonParameter.getNetMaxTrxPerSecond()",
    "int CommonParameter.getNodeChannelReadTimeout()",
    "int CommonParameter.getNodeConnectionTimeout()",
    "String CommonParameter.getNodeExternalIp()",
    "String CommonParameter.getNodeLanIp()",
    "int CommonParameter.getNodeListenPort()",
    "int CommonParameter.getNodeP2pVersion()",
    "long CommonParameter.getOldSolidityBlockNum()",
    "String CommonParameter.getOutputDirectory()",
    "Overlay CommonParameter.getOverlay()",
    "P2pConfig CommonParameter.getP2pConfig()",
    "long CommonParameter.getPBFTExpireNum()",
    "int CommonParameter.getPBFTHttpPort()",
    "List CommonParameter.getPassiveNodes()",
    "long CommonParameter.getPendingTransactionTimeout()",
    "long CommonParameter.getProposalExpireTime()",
    "int CommonParameter.getRateLimiterGlobalApiQps()",
    "int CommonParameter.getRateLimiterGlobalIpQps()",
    "int CommonParameter.getRateLimiterGlobalQps()",
    "RateLimiterInitialization CommonParameter.getRateLimiterInitialization()",
    "long CommonParameter.getReceiveTcpMinDataLength()",
    "RocksDbSettings CommonParameter.getRocksDBCustomSettings()",
    "int CommonParameter.getRpcOnPBFTPort()",
    "int CommonParameter.getRpcOnSolidityPort()",
    "int CommonParameter.getRpcPort()",
    "int CommonParameter.getRpcThreadNum()",
    "SeedNode CommonParameter.getSeedNode()",
    "List CommonParameter.getSeedNodes()",
    "String CommonParameter.getShellConfFileName()",
    "int CommonParameter.getShieldedTransInPendingMaxCounts()",
    "long CommonParameter.getShutdownBlockCount()",
    "long CommonParameter.getShutdownBlockHeight()",
    "CronExpression CommonParameter.getShutdownBlockTime()",
    "int CommonParameter.getSolidityHttpPort()",
    "int CommonParameter.getSolidityThreads()",
    "Storage CommonParameter.getStorage()",
    "long CommonParameter.getSyncFetchBatchNum()",
    "int CommonParameter.getTcpNettyWorkThreadNum()",
    "String CommonParameter.getTrustNodeAddr()",
    "long CommonParameter.getTrxExpirationTimeInMilliseconds()",
    "String CommonParameter.getTrxReferenceBlock()",
    "int CommonParameter.getUdpNettyWorkThreadNum()",
    "long CommonParameter.getUnfreezeDelayDays()",
    "int CommonParameter.getValidContractProtoThreadNum()",
    "int CommonParameter.getValidateSignThreadNum()",
    "String CommonParameter.getZenTokenId()",
    "boolean CommonParameter.isDebug()",
    "boolean CommonParameter.isDynamicConfigEnable()",
    "boolean CommonParameter.isEstimateEnergy()",
    "boolean CommonParameter.isEventSubscribe()",
    "boolean CommonParameter.isFastForward()",
    "boolean CommonParameter.isFullNodeAllowShieldedTransactionArgs()",
    "boolean CommonParameter.isFullNodeHttpEnable()",
    "boolean CommonParameter.isHelp()",
    "boolean CommonParameter.isHistoryBalanceLookup()",
    "boolean CommonParameter.isJsonRpcHttpFullNodeEnable()",
    "boolean CommonParameter.isJsonRpcHttpPBFTNodeEnable()",
    "boolean CommonParameter.isJsonRpcHttpSolidityNodeEnable()",
    "boolean CommonParameter.isMetricsPrometheusEnable()",
    "boolean CommonParameter.isMetricsStorageEnable()",
    "boolean CommonParameter.isNeedSyncCheck()",
    "boolean CommonParameter.isNeedToUpdateAsset()",
    "boolean CommonParameter.isNodeDetectEnable()",
    "boolean CommonParameter.isNodeDiscoveryEnable()",
    "boolean CommonParameter.isNodeDiscoveryPersist()",
    "boolean CommonParameter.isNodeEffectiveCheckEnable()",
    "boolean CommonParameter.isNodeEnableIpv6()",
    "boolean CommonParameter.isNodeMetricsEnable()",
    "boolean CommonParameter.isOpenFullTcpDisconnect()",
    "boolean CommonParameter.isOpenHistoryQueryWhenLiteFN()",
    "boolean CommonParameter.isOpenPrintLog()",
    "boolean CommonParameter.isOpenTransactionSort()",
    "boolean CommonParameter.isP2pDisable()",
    "boolean CommonParameter.isRpcReflectionServiceEnable()",
    "boolean CommonParameter.isSaveFeaturedInternalTx()",
    "boolean CommonParameter.isSaveInternalTx()",
    "boolean CommonParameter.isSolidityNode()",
    "boolean CommonParameter.isSolidityNodeHttpEnable()",
    "boolean CommonParameter.isSupportConstant()",
    "boolean CommonParameter.isTrxCacheEnable()",
    "boolean CommonParameter.isUnsolidifiedBlockCheck()",
    "boolean CommonParameter.isVmTrace()",
    "boolean CommonParameter.isWalletExtensionApi()",
    "boolean CommonParameter.isWitness()",
    "void CommonParameter.setActiveNodes(List)",
    "void CommonParameter.setActuatorSet(Set)",
    "void CommonParameter.setAgreeNodeCount(int)",
    "void CommonParameter.setAllowAccountAssetOptimization(long)",
    "void CommonParameter.setAllowAccountStateRoot(long)",
    "void CommonParameter.setAllowAdaptiveEnergy(long)",
    "void CommonParameter.setAllowAssetOptimization(long)",
    "void CommonParameter.setAllowBlackHoleOptimization(long)",
    "void CommonParameter.setAllowCancelAllUnfreezeV2(long)",
    "void CommonParameter.setAllowCreationOfContracts(long)",
    "void CommonParameter.setAllowDelegateOptimization(long)",
    "void CommonParameter.setAllowDelegateResource(long)",
    "void CommonParameter.setAllowDynamicEnergy(long)",
    "void CommonParameter.setAllowEnergyAdjustment(long)",
    "void CommonParameter.setAllowHigherLimitForMaxCpuTimeOfOneTx(long)",
    "void CommonParameter.setAllowMarketTransaction(long)",
    "void CommonParameter.setAllowMultiSign(int)",
    "void CommonParameter.setAllowNewResourceModel(long)",
    "void CommonParameter.setAllowNewReward(long)",
    "void CommonParameter.setAllowNewRewardAlgorithm(long)",
    "void CommonParameter.setAllowOldRewardOpt(long)",
    "void CommonParameter.setAllowOptimizedReturnValueOfChainId(long)",
    "void CommonParameter.setAllowPBFT(long)",
    "void CommonParameter.setAllowProtoFilterNum(long)",
    "void CommonParameter.setAllowSameTokenName(long)",
    "void CommonParameter.setAllowShieldedTRC20Transaction(long)",
    "void CommonParameter.setAllowStrictMath(long)",
    "void CommonParameter.setAllowTransactionFeePool(long)",
    "void CommonParameter.setAllowTvmCompatibleEvm(long)",
    "void CommonParameter.setAllowTvmConstantinople(long)",
    "void CommonParameter.setAllowTvmFreeze(long)",
    "void CommonParameter.setAllowTvmIstanbul(long)",
    "void CommonParameter.setAllowTvmLondon(long)",
    "void CommonParameter.setAllowTvmShangHai(long)",
    "void CommonParameter.setAllowTvmSolidity059(long)",
    "void CommonParameter.setAllowTvmTransferTrc10(long)",
    "void CommonParameter.setAllowTvmVote(long)",
    "void CommonParameter.setBackupMembers(List)",
    "void CommonParameter.setBackupPort(int)",
    "void CommonParameter.setBackupPriority(int)",
    "void CommonParameter.setBlockCacheTimeout(long)",
    "void CommonParameter.setBlockNumForEnergyLimit(long)",
    "void CommonParameter.setBlockProducedTimeOut(int)",
    "void CommonParameter.setChainId(String)",
    "void CommonParameter.setChangedDelegation(long)",
    "void CommonParameter.setCheckFrozenTime(int)",
    "void CommonParameter.setConsensusLogicOptimization(long)",
    "void CommonParameter.setCryptoEngine(String)",
    "void CommonParameter.setDebug(boolean)",
    "void CommonParameter.setDisabledApiList(List)",
    "void CommonParameter.setDnsPublishConfig(PublishConfig)",
    "void CommonParameter.setDnsTreeUrls(List)",
    "void CommonParameter.setDynamicConfigCheckInterval(long)",
    "void CommonParameter.setDynamicConfigEnable(boolean)",
    "void CommonParameter.setDynamicEnergyIncreaseFactor(long)",
    "void CommonParameter.setDynamicEnergyMaxFactor(long)",
    "void CommonParameter.setDynamicEnergyThreshold(long)",
    "void CommonParameter.setENERGY_LIMIT_HARD_FORK(boolean)",
    "void CommonParameter.setEstimateEnergy(boolean)",
    "void CommonParameter.setEstimateEnergyMaxRetry(int)",
    "void CommonParameter.setEventSubscribe(boolean)",
    "void CommonParameter.setFetchBlockTimeout(int)",
    "void CommonParameter.setFlowControlWindow(int)",
    "void CommonParameter.setForbidTransferToContract(long)",
    "void CommonParameter.setFullNodeAllowShieldedTransactionArgs(boolean)",
    "void CommonParameter.setFullNodeHttpEnable(boolean)",
    "void CommonParameter.setFullNodeHttpPort(int)",
    "void CommonParameter.setHistoryBalanceLookup(boolean)",
    "void CommonParameter.setInactiveThreshold(int)",
    "void CommonParameter.setInfluxDbDatabase(String)",
    "void CommonParameter.setInfluxDbIp(String)",
    "void CommonParameter.setInfluxDbPort(int)",
    "void CommonParameter.setJsonRpcHttpFullNodeEnable(boolean)",
    "void CommonParameter.setJsonRpcHttpFullNodePort(int)",
    "void CommonParameter.setJsonRpcHttpPBFTNodeEnable(boolean)",
    "void CommonParameter.setJsonRpcHttpPBFTPort(int)",
    "void CommonParameter.setJsonRpcHttpSolidityNodeEnable(boolean)",
    "void CommonParameter.setJsonRpcHttpSolidityPort(int)",
    "void CommonParameter.setKeepAliveInterval(int)",
    "void CommonParameter.setLongRunningTime(int)",
    "void CommonParameter.setLruCacheSize(int)",
    "void CommonParameter.setMaintenanceTimeInterval(long)",
    "void CommonParameter.setMaxConcurrentCallsPerConnection(int)",
    "void CommonParameter.setMaxConnectionAgeInMillis(long)",
    "void CommonParameter.setMaxConnectionIdleInMillis(long)",
    "void CommonParameter.setMaxConnections(int)",
    "void CommonParameter.setMaxConnectionsWithSameIp(int)",
    "void CommonParameter.setMaxCreateAccountTxSize(long)",
    "void CommonParameter.setMaxEnergyLimitForConstant(long)",
    "void CommonParameter.setMaxHeaderListSize(int)",
    "void CommonParameter.setMaxHttpConnectNumber(int)",
    "void CommonParameter.setMaxMessageSize(int)",
    "void CommonParameter.setMaxTimeRatio(double)",
    "void CommonParameter.setMaxTps(int)",
    "void CommonParameter.setMaxTransactionPendingSize(int)",
    "void CommonParameter.setMaxUnsolidifiedBlocks(int)",
    "void CommonParameter.setMemoFee(long)",
    "void CommonParameter.setMetricsPrometheusEnable(boolean)",
    "void CommonParameter.setMetricsPrometheusPort(int)",
    "void CommonParameter.setMetricsReportInterval(int)",
    "void CommonParameter.setMetricsStorageEnable(boolean)",
    "void CommonParameter.setMinActiveConnections(int)",
    "void CommonParameter.setMinConnections(int)",
    "void CommonParameter.setMinEffectiveConnection(int)",
    "void CommonParameter.setMinParticipationRate(int)",
    "void CommonParameter.setMinTimeRatio(double)",
    "void CommonParameter.setNeedSyncCheck(boolean)",
    "void CommonParameter.setNeedToUpdateAsset(boolean)",
    "void CommonParameter.setNetMaxTrxPerSecond(long)",
    "void CommonParameter.setNodeChannelReadTimeout(int)",
    "void CommonParameter.setNodeConnectionTimeout(int)",
    "void CommonParameter.setNodeDetectEnable(boolean)",
    "void CommonParameter.setNodeDiscoveryEnable(boolean)",
    "void CommonParameter.setNodeDiscoveryPersist(boolean)",
    "void CommonParameter.setNodeEffectiveCheckEnable(boolean)",
    "void CommonParameter.setNodeEnableIpv6(boolean)",
    "void CommonParameter.setNodeExternalIp(String)",
    "void CommonParameter.setNodeLanIp(String)",
    "void CommonParameter.setNodeListenPort(int)",
    "void CommonParameter.setNodeMetricsEnable(boolean)",
    "void CommonParameter.setNodeP2pVersion(int)",
    "void CommonParameter.setOldSolidityBlockNum(long)",
    "void CommonParameter.setOpenFullTcpDisconnect(boolean)",
    "void CommonParameter.setOpenHistoryQueryWhenLiteFN(boolean)",
    "void CommonParameter.setOpenPrintLog(boolean)",
    "void CommonParameter.setOpenTransactionSort(boolean)",
    "void CommonParameter.setP2pDisable(boolean)",
    "void CommonParameter.setPBFTExpireNum(long)",
    "void CommonParameter.setPBFTHttpPort(int)",
    "void CommonParameter.setPassiveNodes(List)",
    "void CommonParameter.setPendingTransactionTimeout(long)",
    "void CommonParameter.setProposalExpireTime(long)",
    "void CommonParameter.setRateLimiterGlobalIpQps(int)",
    "void CommonParameter.setRateLimiterGlobalQps(int)",
    "void CommonParameter.setRateLimiterInitialization(RateLimiterInitialization)",
    "void CommonParameter.setReceiveTcpMinDataLength(long)",
    "void CommonParameter.setRpcOnPBFTPort(int)",
    "void CommonParameter.setRpcOnSolidityPort(int)",
    "void CommonParameter.setRpcPort(int)",
    "void CommonParameter.setRpcReflectionServiceEnable(boolean)",
    "void CommonParameter.setRpcThreadNum(int)",
    "void CommonParameter.setSaveFeaturedInternalTx(boolean)",
    "void CommonParameter.setSaveInternalTx(boolean)",
    "void CommonParameter.setShieldedTransInPendingMaxCounts(int)",
    "void CommonParameter.setShutdownBlockCount(long)",
    "void CommonParameter.setShutdownBlockHeight(long)",
    "void CommonParameter.setShutdownBlockTime(CronExpression)",
    "void CommonParameter.setSolidityHttpPort(int)",
    "void CommonParameter.setSolidityNode(boolean)",
    "void CommonParameter.setSolidityNodeHttpEnable(boolean)",
    "void CommonParameter.setSolidityThreads(int)",
    "void CommonParameter.setSupportConstant(boolean)",
    "void CommonParameter.setSyncFetchBatchNum(long)",
    "void CommonParameter.setTcpNettyWorkThreadNum(int)",
    "void CommonParameter.setTrustNodeAddr(String)",
    "void CommonParameter.setTrxCacheEnable(boolean)",
    "void CommonParameter.setTrxExpirationTimeInMilliseconds(long)",
    "void CommonParameter.setTrxReferenceBlock(String)",
    "void CommonParameter.setUdpNettyWorkThreadNum(int)",
    "void CommonParameter.setUnfreezeDelayDays(long)",
    "void CommonParameter.setUnsolidifiedBlockCheck(boolean)",
    "void CommonParameter.setValidContractProtoThreadNum(int)",
    "void CommonParameter.setValidateSignThreadNum(int)",
    "void CommonParameter.setVmTrace(boolean)",
    "void CommonParameter.setWalletExtensionApi(boolean)",
    "void CommonParameter.setWitness(boolean)",
    "void CommonParameter.setZenTokenId(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CommonParameter actualInstance = CommonParameter.getInstance();
    ArrayList<InetSocketAddress> activeNodes = new ArrayList<>();
    actualInstance.setActiveNodes(activeNodes);
    HashSet<String> actuatorSet = new HashSet<>();
    actualInstance.setActuatorSet(actuatorSet);
    actualInstance.setAgreeNodeCount(3);
    actualInstance.setAllowAccountAssetOptimization(3L);
    actualInstance.setAllowAccountStateRoot(3L);
    actualInstance.setAllowAdaptiveEnergy(1L);
    actualInstance.setAllowAssetOptimization(1L);
    actualInstance.setAllowBlackHoleOptimization(1L);
    actualInstance.setAllowCancelAllUnfreezeV2(1L);
    actualInstance.setAllowCreationOfContracts(1L);
    actualInstance.setAllowDelegateOptimization(1L);
    actualInstance.setAllowDelegateResource(1L);
    actualInstance.setAllowDynamicEnergy(1L);
    actualInstance.setAllowEnergyAdjustment(1L);
    actualInstance.setAllowHigherLimitForMaxCpuTimeOfOneTx(1L);
    actualInstance.setAllowMarketTransaction(1L);
    actualInstance.setAllowMultiSign(1);
    actualInstance.setAllowNewResourceModel(1L);
    actualInstance.setAllowNewReward(1L);
    actualInstance.setAllowNewRewardAlgorithm(1L);
    actualInstance.setAllowOldRewardOpt(1L);
    actualInstance.setAllowOptimizedReturnValueOfChainId(1L);
    actualInstance.setAllowPBFT(1L);
    actualInstance.setAllowSameTokenName(1L);
    actualInstance.setAllowShieldedTRC20Transaction(1L);
    actualInstance.setAllowStrictMath(1L);
    actualInstance.setAllowTransactionFeePool(1L);
    actualInstance.setAllowTvmCompatibleEvm(1L);
    actualInstance.setAllowTvmConstantinople(1L);
    actualInstance.setAllowTvmFreeze(1L);
    actualInstance.setAllowTvmIstanbul(1L);
    actualInstance.setAllowTvmLondon(1L);
    actualInstance.setAllowTvmShangHai(1L);
    actualInstance.setAllowTvmSolidity059(1L);
    actualInstance.setAllowTvmTransferTrc10(1L);
    actualInstance.setAllowTvmVote(1L);
    ArrayList<String> backupMembers = new ArrayList<>();
    actualInstance.setBackupMembers(backupMembers);
    actualInstance.setBackupPort(8080);
    actualInstance.setBackupPriority(1);
    actualInstance.setBlockCacheTimeout(1L);
    actualInstance.setBlockNumForEnergyLimit(1L);
    actualInstance.setBlockProducedTimeOut(1);
    actualInstance.setChainId("42");
    actualInstance.setChangedDelegation(1L);
    actualInstance.setCheckFrozenTime(1);
    actualInstance.setConsensusLogicOptimization(1L);
    actualInstance.setDebug(true);
    ArrayList<String> disabledApiList = new ArrayList<>();
    actualInstance.setDisabledApiList(disabledApiList);
    PublishConfig dnsPublishConfig = new PublishConfig();
    dnsPublishConfig.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    dnsPublishConfig.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
    dnsPublishConfig.setAliDnsEndpoint("https://config.us-east-2.amazonaws.com");
    dnsPublishConfig.setAwsHostZoneId("UTC");
    dnsPublishConfig.setAwsRegion("us-east-2");
    dnsPublishConfig.setChangeThreshold(10.0d);
    dnsPublishConfig.setDnsDomain("Dns Domain");
    dnsPublishConfig.setDnsPrivate("Dns Private");
    dnsPublishConfig.setDnsPublishEnable(true);
    dnsPublishConfig.setDnsType(DnsType.AliYun);
    dnsPublishConfig.setKnownTreeUrls(new ArrayList<>());
    dnsPublishConfig.setMaxMergeSize(3);
    dnsPublishConfig.setStaticNodes(new ArrayList<>());
    actualInstance.setDnsPublishConfig(dnsPublishConfig);
    ArrayList<String> dnsTreeUrls = new ArrayList<>();
    actualInstance.setDnsTreeUrls(dnsTreeUrls);
    actualInstance.setDynamicConfigCheckInterval(42L);
    actualInstance.setDynamicConfigEnable(true);
    actualInstance.setDynamicEnergyIncreaseFactor(1L);
    actualInstance.setDynamicEnergyMaxFactor(1L);
    actualInstance.setDynamicEnergyThreshold(1L);
    actualInstance.setEstimateEnergy(true);
    actualInstance.setEstimateEnergyMaxRetry(1);
    actualInstance.setEventSubscribe(true);
    actualInstance.setFetchBlockTimeout(10);
    actualInstance.setFlowControlWindow(1);
    actualInstance.setForbidTransferToContract(1L);
    actualInstance.setFullNodeAllowShieldedTransactionArgs(true);
    actualInstance.setFullNodeHttpEnable(true);
    actualInstance.setFullNodeHttpPort(8080);
    actualInstance.setHistoryBalanceLookup(true);
    actualInstance.setInactiveThreshold(1);
    actualInstance.setInfluxDbDatabase("Influx Db Database");
    actualInstance.setInfluxDbIp("Influx Db Ip");
    actualInstance.setInfluxDbPort(8080);
    actualInstance.setJsonRpcHttpFullNodeEnable(true);
    actualInstance.setJsonRpcHttpFullNodePort(8080);
    actualInstance.setJsonRpcHttpPBFTNodeEnable(true);
    actualInstance.setJsonRpcHttpPBFTPort(8080);
    actualInstance.setJsonRpcHttpSolidityNodeEnable(true);
    actualInstance.setJsonRpcHttpSolidityPort(1);
    actualInstance.setKeepAliveInterval(42);
    actualInstance.setLongRunningTime(1);
    actualInstance.setLruCacheSize(3);
    actualInstance.setMaintenanceTimeInterval(42L);
    actualInstance.setMaxConcurrentCallsPerConnection(3);
    actualInstance.setMaxConnectionAgeInMillis(1L);
    actualInstance.setMaxConnectionIdleInMillis(1L);
    actualInstance.setMaxConnections(3);
    actualInstance.setMaxConnectionsWithSameIp(3);
    actualInstance.setMaxCreateAccountTxSize(3L);
    actualInstance.setMaxEnergyLimitForConstant(1L);
    actualInstance.setMaxHeaderListSize(3);
    actualInstance.setMaxHttpConnectNumber(3);
    actualInstance.setMaxMessageSize(3);
    actualInstance.setMaxTimeRatio(10.0d);
    actualInstance.setMaxTps(3);
    actualInstance.setMaxTransactionPendingSize(3);
    actualInstance.setMaxUnsolidifiedBlocks(1);
    actualInstance.setMemoFee(1L);
    actualInstance.setMetricsPrometheusEnable(true);
    actualInstance.setMetricsPrometheusPort(8080);
    actualInstance.setMetricsReportInterval(42);
    actualInstance.setMetricsStorageEnable(true);
    actualInstance.setMinActiveConnections(1);
    actualInstance.setMinConnections(1);
    actualInstance.setMinEffectiveConnection(1);
    actualInstance.setMinParticipationRate(1);
    actualInstance.setMinTimeRatio(10.0d);
    actualInstance.setNeedSyncCheck(true);
    actualInstance.setNeedToUpdateAsset(true);
    actualInstance.setNetMaxTrxPerSecond(1L);
    actualInstance.setNodeChannelReadTimeout(10);
    actualInstance.setNodeConnectionTimeout(10);
    actualInstance.setNodeDetectEnable(true);
    actualInstance.setNodeDiscoveryEnable(true);
    actualInstance.setNodeDiscoveryPersist(true);
    actualInstance.setNodeEffectiveCheckEnable(true);
    actualInstance.setNodeEnableIpv6(true);
    actualInstance.setNodeExternalIp("Node External Ip");
    actualInstance.setNodeLanIp("Node Lan Ip");
    actualInstance.setNodeListenPort(8080);
    actualInstance.setNodeMetricsEnable(true);
    actualInstance.setNodeP2pVersion(1);
    actualInstance.setOldSolidityBlockNum(1L);
    actualInstance.setOpenFullTcpDisconnect(true);
    actualInstance.setOpenHistoryQueryWhenLiteFN(true);
    actualInstance.setOpenPrintLog(true);
    actualInstance.setOpenTransactionSort(true);
    actualInstance.setP2pDisable(true);
    actualInstance.setPBFTExpireNum(1L);
    actualInstance.setPBFTHttpPort(8080);
    ArrayList<InetAddress> passiveNodes = new ArrayList<>();
    actualInstance.setPassiveNodes(passiveNodes);
    actualInstance.setPendingTransactionTimeout(1L);
    actualInstance.setProposalExpireTime(1L);
    actualInstance.setRateLimiterGlobalIpQps(1);
    actualInstance.setRateLimiterGlobalQps(1);
    RateLimiterInitialization rateLimiterInitialization = new RateLimiterInitialization();
    rateLimiterInitialization.setHttpMap(new ArrayList<>());
    rateLimiterInitialization.setRpcMap(new ArrayList<>());
    actualInstance.setRateLimiterInitialization(rateLimiterInitialization);
    actualInstance.setReceiveTcpMinDataLength(3L);
    actualInstance.setRpcOnPBFTPort(8080);
    actualInstance.setRpcOnSolidityPort(1);
    actualInstance.setRpcPort(8080);
    actualInstance.setRpcReflectionServiceEnable(true);
    actualInstance.setRpcThreadNum(10);
    actualInstance.setSaveFeaturedInternalTx(true);
    actualInstance.setSaveInternalTx(true);
    actualInstance.setShieldedTransInPendingMaxCounts(3);
    actualInstance.setShutdownBlockCount(3L);
    actualInstance.setShutdownBlockHeight(1L);
    actualInstance.setSolidityHttpPort(1);
    actualInstance.setSolidityNode(true);
    actualInstance.setSolidityNodeHttpEnable(true);
    actualInstance.setSolidityThreads(1);
    actualInstance.setSupportConstant(true);
    actualInstance.setSyncFetchBatchNum(1L);
    actualInstance.setTcpNettyWorkThreadNum(10);
    actualInstance.setTrustNodeAddr("42 Main St");
    actualInstance.setTrxCacheEnable(true);
    actualInstance.setTrxExpirationTimeInMilliseconds(1L);
    actualInstance.setTrxReferenceBlock("Trx Reference Block");
    actualInstance.setUdpNettyWorkThreadNum(10);
    actualInstance.setUnfreezeDelayDays(1L);
    actualInstance.setUnsolidifiedBlockCheck(true);
    actualInstance.setValidateSignThreadNum(1);
    actualInstance.setVmTrace(true);
    actualInstance.setWalletExtensionApi(true);
    actualInstance.setWitness(true);
    actualInstance.setZenTokenId("42");
    CommonParameter actualInstance2 = actualInstance.getInstance();
    actualInstance.setAllowProtoFilterNum(1L);
    actualInstance.setCryptoEngine("Crypto Engine");
    actualInstance.setENERGY_LIMIT_HARD_FORK(true);
    actualInstance.setValidContractProtoThreadNum(1);
    List<InetSocketAddress> actualActiveNodes = actualInstance.getActiveNodes();
    Set<String> actualActuatorSet = actualInstance.getActuatorSet();
    int actualAgreeNodeCount = actualInstance.getAgreeNodeCount();
    long actualAllowAccountAssetOptimization = actualInstance.getAllowAccountAssetOptimization();
    long actualAllowAccountStateRoot = actualInstance.getAllowAccountStateRoot();
    long actualAllowAdaptiveEnergy = actualInstance.getAllowAdaptiveEnergy();
    long actualAllowAssetOptimization = actualInstance.getAllowAssetOptimization();
    long actualAllowBlackHoleOptimization = actualInstance.getAllowBlackHoleOptimization();
    long actualAllowCancelAllUnfreezeV2 = actualInstance.getAllowCancelAllUnfreezeV2();
    long actualAllowCreationOfContracts = actualInstance.getAllowCreationOfContracts();
    long actualAllowDelegateOptimization = actualInstance.getAllowDelegateOptimization();
    long actualAllowDelegateResource = actualInstance.getAllowDelegateResource();
    long actualAllowDynamicEnergy = actualInstance.getAllowDynamicEnergy();
    long actualAllowEnergyAdjustment = actualInstance.getAllowEnergyAdjustment();
    long actualAllowHigherLimitForMaxCpuTimeOfOneTx =
        actualInstance.getAllowHigherLimitForMaxCpuTimeOfOneTx();
    long actualAllowMarketTransaction = actualInstance.getAllowMarketTransaction();
    int actualAllowMultiSign = actualInstance.getAllowMultiSign();
    long actualAllowNewResourceModel = actualInstance.getAllowNewResourceModel();
    long actualAllowNewReward = actualInstance.getAllowNewReward();
    long actualAllowNewRewardAlgorithm = actualInstance.getAllowNewRewardAlgorithm();
    long actualAllowOldRewardOpt = actualInstance.getAllowOldRewardOpt();
    long actualAllowOptimizedReturnValueOfChainId =
        actualInstance.getAllowOptimizedReturnValueOfChainId();
    long actualAllowPBFT = actualInstance.getAllowPBFT();
    long actualAllowProtoFilterNum = actualInstance.getAllowProtoFilterNum();
    long actualAllowSameTokenName = actualInstance.getAllowSameTokenName();
    long actualAllowShieldedTRC20Transaction = actualInstance.getAllowShieldedTRC20Transaction();
    long actualAllowStrictMath = actualInstance.getAllowStrictMath();
    long actualAllowTransactionFeePool = actualInstance.getAllowTransactionFeePool();
    long actualAllowTvmCompatibleEvm = actualInstance.getAllowTvmCompatibleEvm();
    long actualAllowTvmConstantinople = actualInstance.getAllowTvmConstantinople();
    long actualAllowTvmFreeze = actualInstance.getAllowTvmFreeze();
    long actualAllowTvmIstanbul = actualInstance.getAllowTvmIstanbul();
    long actualAllowTvmLondon = actualInstance.getAllowTvmLondon();
    long actualAllowTvmShangHai = actualInstance.getAllowTvmShangHai();
    long actualAllowTvmSolidity059 = actualInstance.getAllowTvmSolidity059();
    long actualAllowTvmTransferTrc10 = actualInstance.getAllowTvmTransferTrc10();
    long actualAllowTvmVote = actualInstance.getAllowTvmVote();
    List<String> actualBackupMembers = actualInstance.getBackupMembers();
    int actualBackupPort = actualInstance.getBackupPort();
    int actualBackupPriority = actualInstance.getBackupPriority();
    long actualBlockCacheTimeout = actualInstance.getBlockCacheTimeout();
    long actualBlockNumForEnergyLimit = actualInstance.getBlockNumForEnergyLimit();
    int actualBlockProducedTimeOut = actualInstance.getBlockProducedTimeOut();
    String actualChainId = actualInstance.getChainId();
    long actualChangedDelegation = actualInstance.getChangedDelegation();
    int actualCheckFrozenTime = actualInstance.getCheckFrozenTime();
    long actualConsensusLogicOptimization = actualInstance.getConsensusLogicOptimization();
    String actualCryptoEngine = actualInstance.getCryptoEngine();
    DbBackupConfig actualDbBackupConfig = actualInstance.getDbBackupConfig();
    List<String> actualDisabledApiList = actualInstance.getDisabledApiList();
    PublishConfig actualDnsPublishConfig = actualInstance.getDnsPublishConfig();
    List<String> actualDnsTreeUrls = actualInstance.getDnsTreeUrls();
    long actualDynamicConfigCheckInterval = actualInstance.getDynamicConfigCheckInterval();
    long actualDynamicEnergyIncreaseFactor = actualInstance.getDynamicEnergyIncreaseFactor();
    long actualDynamicEnergyMaxFactor = actualInstance.getDynamicEnergyMaxFactor();
    long actualDynamicEnergyThreshold = actualInstance.getDynamicEnergyThreshold();
    int actualEstimateEnergyMaxRetry = actualInstance.getEstimateEnergyMaxRetry();
    FilterQuery actualEventFilter = actualInstance.getEventFilter();
    EventPluginConfig actualEventPluginConfig = actualInstance.getEventPluginConfig();
    List<InetSocketAddress> actualFastForwardNodes = actualInstance.getFastForwardNodes();
    int actualFetchBlockTimeout = actualInstance.getFetchBlockTimeout();
    int actualFlowControlWindow = actualInstance.getFlowControlWindow();
    long actualForbidTransferToContract = actualInstance.getForbidTransferToContract();
    int actualFullNodeHttpPort = actualInstance.getFullNodeHttpPort();
    GenesisBlock actualGenesisBlock = actualInstance.getGenesisBlock();
    int actualInactiveThreshold = actualInstance.getInactiveThreshold();
    String actualInfluxDbDatabase = actualInstance.getInfluxDbDatabase();
    String actualInfluxDbIp = actualInstance.getInfluxDbIp();
    int actualInfluxDbPort = actualInstance.getInfluxDbPort();
    int actualJsonRpcHttpFullNodePort = actualInstance.getJsonRpcHttpFullNodePort();
    int actualJsonRpcHttpPBFTPort = actualInstance.getJsonRpcHttpPBFTPort();
    int actualJsonRpcHttpSolidityPort = actualInstance.getJsonRpcHttpSolidityPort();
    int actualKeepAliveInterval = actualInstance.getKeepAliveInterval();
    String actualLogbackPath = actualInstance.getLogbackPath();
    int actualLongRunningTime = actualInstance.getLongRunningTime();
    int actualLruCacheSize = actualInstance.getLruCacheSize();
    long actualMaintenanceTimeInterval = actualInstance.getMaintenanceTimeInterval();
    int actualMaxConcurrentCallsPerConnection = actualInstance.getMaxConcurrentCallsPerConnection();
    long actualMaxConnectionAgeInMillis = actualInstance.getMaxConnectionAgeInMillis();
    long actualMaxConnectionIdleInMillis = actualInstance.getMaxConnectionIdleInMillis();
    int actualMaxConnections = actualInstance.getMaxConnections();
    int actualMaxConnectionsWithSameIp = actualInstance.getMaxConnectionsWithSameIp();
    long actualMaxCreateAccountTxSize = actualInstance.getMaxCreateAccountTxSize();
    long actualMaxEnergyLimitForConstant = actualInstance.getMaxEnergyLimitForConstant();
    int actualMaxFastForwardNum = actualInstance.getMaxFastForwardNum();
    int actualMaxHeaderListSize = actualInstance.getMaxHeaderListSize();
    int actualMaxHttpConnectNumber = actualInstance.getMaxHttpConnectNumber();
    int actualMaxMessageSize = actualInstance.getMaxMessageSize();
    double actualMaxTimeRatio = actualInstance.getMaxTimeRatio();
    int actualMaxTps = actualInstance.getMaxTps();
    int actualMaxTransactionPendingSize = actualInstance.getMaxTransactionPendingSize();
    int actualMaxUnsolidifiedBlocks = actualInstance.getMaxUnsolidifiedBlocks();
    long actualMemoFee = actualInstance.getMemoFee();
    int actualMetricsPrometheusPort = actualInstance.getMetricsPrometheusPort();
    int actualMetricsReportInterval = actualInstance.getMetricsReportInterval();
    int actualMinActiveConnections = actualInstance.getMinActiveConnections();
    int actualMinConnections = actualInstance.getMinConnections();
    int actualMinEffectiveConnection = actualInstance.getMinEffectiveConnection();
    int actualMinParticipationRate = actualInstance.getMinParticipationRate();
    double actualMinTimeRatio = actualInstance.getMinTimeRatio();
    long actualNetMaxTrxPerSecond = actualInstance.getNetMaxTrxPerSecond();
    int actualNodeChannelReadTimeout = actualInstance.getNodeChannelReadTimeout();
    int actualNodeConnectionTimeout = actualInstance.getNodeConnectionTimeout();
    String actualNodeExternalIp = actualInstance.getNodeExternalIp();
    String actualNodeLanIp = actualInstance.getNodeLanIp();
    int actualNodeListenPort = actualInstance.getNodeListenPort();
    int actualNodeP2pVersion = actualInstance.getNodeP2pVersion();
    long actualOldSolidityBlockNum = actualInstance.getOldSolidityBlockNum();
    String actualOutputDirectory = actualInstance.getOutputDirectory();
    Overlay actualOverlay = actualInstance.getOverlay();
    P2pConfig actualP2pConfig = actualInstance.getP2pConfig();
    long actualPBFTExpireNum = actualInstance.getPBFTExpireNum();
    int actualPBFTHttpPort = actualInstance.getPBFTHttpPort();
    List<InetAddress> actualPassiveNodes = actualInstance.getPassiveNodes();
    long actualPendingTransactionTimeout = actualInstance.getPendingTransactionTimeout();
    long actualProposalExpireTime = actualInstance.getProposalExpireTime();
    int actualRateLimiterGlobalApiQps = actualInstance.getRateLimiterGlobalApiQps();
    int actualRateLimiterGlobalIpQps = actualInstance.getRateLimiterGlobalIpQps();
    int actualRateLimiterGlobalQps = actualInstance.getRateLimiterGlobalQps();
    RateLimiterInitialization actualRateLimiterInitialization =
        actualInstance.getRateLimiterInitialization();
    long actualReceiveTcpMinDataLength = actualInstance.getReceiveTcpMinDataLength();
    RocksDbSettings actualRocksDBCustomSettings = actualInstance.getRocksDBCustomSettings();
    int actualRpcOnPBFTPort = actualInstance.getRpcOnPBFTPort();
    int actualRpcOnSolidityPort = actualInstance.getRpcOnSolidityPort();
    int actualRpcPort = actualInstance.getRpcPort();
    int actualRpcThreadNum = actualInstance.getRpcThreadNum();
    SeedNode actualSeedNode = actualInstance.getSeedNode();
    List<String> actualSeedNodes = actualInstance.getSeedNodes();
    String actualShellConfFileName = actualInstance.getShellConfFileName();
    int actualShieldedTransInPendingMaxCounts = actualInstance.getShieldedTransInPendingMaxCounts();
    long actualShutdownBlockCount = actualInstance.getShutdownBlockCount();
    long actualShutdownBlockHeight = actualInstance.getShutdownBlockHeight();
    CronExpression actualShutdownBlockTime = actualInstance.getShutdownBlockTime();
    int actualSolidityHttpPort = actualInstance.getSolidityHttpPort();
    int actualSolidityThreads = actualInstance.getSolidityThreads();
    Storage actualStorage = actualInstance.getStorage();
    long actualSyncFetchBatchNum = actualInstance.getSyncFetchBatchNum();
    int actualTcpNettyWorkThreadNum = actualInstance.getTcpNettyWorkThreadNum();
    String actualTrustNodeAddr = actualInstance.getTrustNodeAddr();
    long actualTrxExpirationTimeInMilliseconds =
        actualInstance.getTrxExpirationTimeInMilliseconds();
    String actualTrxReferenceBlock = actualInstance.getTrxReferenceBlock();
    int actualUdpNettyWorkThreadNum = actualInstance.getUdpNettyWorkThreadNum();
    long actualUnfreezeDelayDays = actualInstance.getUnfreezeDelayDays();
    int actualValidContractProtoThreadNum = actualInstance.getValidContractProtoThreadNum();
    int actualValidateSignThreadNum = actualInstance.getValidateSignThreadNum();
    String actualZenTokenId = actualInstance.getZenTokenId();
    boolean actualIsDebugResult = actualInstance.isDebug();
    boolean actualIsDynamicConfigEnableResult = actualInstance.isDynamicConfigEnable();
    boolean actualIsEstimateEnergyResult = actualInstance.isEstimateEnergy();
    boolean actualIsEventSubscribeResult = actualInstance.isEventSubscribe();
    boolean actualIsFastForwardResult = actualInstance.isFastForward();
    boolean actualIsFullNodeAllowShieldedTransactionArgsResult =
        actualInstance.isFullNodeAllowShieldedTransactionArgs();
    boolean actualIsFullNodeHttpEnableResult = actualInstance.isFullNodeHttpEnable();
    boolean actualIsHelpResult = actualInstance.isHelp();
    boolean actualIsHistoryBalanceLookupResult = actualInstance.isHistoryBalanceLookup();
    boolean actualIsJsonRpcHttpFullNodeEnableResult = actualInstance.isJsonRpcHttpFullNodeEnable();
    boolean actualIsJsonRpcHttpPBFTNodeEnableResult = actualInstance.isJsonRpcHttpPBFTNodeEnable();
    boolean actualIsJsonRpcHttpSolidityNodeEnableResult =
        actualInstance.isJsonRpcHttpSolidityNodeEnable();
    boolean actualIsMetricsPrometheusEnableResult = actualInstance.isMetricsPrometheusEnable();
    boolean actualIsMetricsStorageEnableResult = actualInstance.isMetricsStorageEnable();
    boolean actualIsNeedSyncCheckResult = actualInstance.isNeedSyncCheck();
    boolean actualIsNeedToUpdateAssetResult = actualInstance.isNeedToUpdateAsset();
    boolean actualIsNodeDetectEnableResult = actualInstance.isNodeDetectEnable();
    boolean actualIsNodeDiscoveryEnableResult = actualInstance.isNodeDiscoveryEnable();
    boolean actualIsNodeDiscoveryPersistResult = actualInstance.isNodeDiscoveryPersist();
    boolean actualIsNodeEffectiveCheckEnableResult = actualInstance.isNodeEffectiveCheckEnable();
    boolean actualIsNodeEnableIpv6Result = actualInstance.isNodeEnableIpv6();
    boolean actualIsNodeMetricsEnableResult = actualInstance.isNodeMetricsEnable();
    boolean actualIsOpenFullTcpDisconnectResult = actualInstance.isOpenFullTcpDisconnect();
    boolean actualIsOpenHistoryQueryWhenLiteFNResult =
        actualInstance.isOpenHistoryQueryWhenLiteFN();
    boolean actualIsOpenPrintLogResult = actualInstance.isOpenPrintLog();
    boolean actualIsOpenTransactionSortResult = actualInstance.isOpenTransactionSort();
    boolean actualIsP2pDisableResult = actualInstance.isP2pDisable();
    boolean actualIsRpcReflectionServiceEnableResult =
        actualInstance.isRpcReflectionServiceEnable();
    boolean actualIsSaveFeaturedInternalTxResult = actualInstance.isSaveFeaturedInternalTx();
    boolean actualIsSaveInternalTxResult = actualInstance.isSaveInternalTx();
    boolean actualIsSolidityNodeResult = actualInstance.isSolidityNode();
    boolean actualIsSolidityNodeHttpEnableResult = actualInstance.isSolidityNodeHttpEnable();
    boolean actualIsSupportConstantResult = actualInstance.isSupportConstant();
    boolean actualIsTrxCacheEnableResult = actualInstance.isTrxCacheEnable();
    boolean actualIsUnsolidifiedBlockCheckResult = actualInstance.isUnsolidifiedBlockCheck();
    boolean actualIsVmTraceResult = actualInstance.isVmTrace();
    boolean actualIsWalletExtensionApiResult = actualInstance.isWalletExtensionApi();
    boolean actualIsWitnessResult = actualInstance.isWitness();

    // Assert
    assertEquals("", actualLogbackPath);
    assertEquals("", actualShellConfFileName);
    assertEquals("42 Main St", actualTrustNodeAddr);
    assertEquals("42", actualChainId);
    assertEquals("42", actualZenTokenId);
    assertEquals("Crypto Engine", actualCryptoEngine);
    assertEquals("Influx Db Database", actualInfluxDbDatabase);
    assertEquals("Influx Db Ip", actualInfluxDbIp);
    assertEquals("Node External Ip", actualNodeExternalIp);
    assertEquals("Node Lan Ip", actualNodeLanIp);
    assertEquals("Trx Reference Block", actualTrxReferenceBlock);
    assertEquals("output-directory", actualOutputDirectory);
    assertNull(actualFastForwardNodes);
    assertNull(actualShutdownBlockTime);
    assertNull(actualGenesisBlock);
    assertNull(actualDbBackupConfig);
    assertNull(actualEventPluginConfig);
    assertNull(actualEventFilter);
    assertNull(actualRocksDBCustomSettings);
    assertNull(actualOverlay);
    assertNull(actualSeedNode);
    assertNull(actualStorage);
    assertNull(actualP2pConfig);
    assertEquals(0, actualMaxFastForwardNum);
    assertEquals(0, actualRateLimiterGlobalApiQps);
    assertEquals(1, actualAllowMultiSign);
    assertEquals(1, actualBackupPriority);
    assertEquals(1, actualBlockProducedTimeOut);
    assertEquals(1, actualCheckFrozenTime);
    assertEquals(1, actualEstimateEnergyMaxRetry);
    assertEquals(1, actualFlowControlWindow);
    assertEquals(1, actualInactiveThreshold);
    assertEquals(1, actualJsonRpcHttpSolidityPort);
    assertEquals(1, actualLongRunningTime);
    assertEquals(1, actualMaxUnsolidifiedBlocks);
    assertEquals(1, actualMinActiveConnections);
    assertEquals(1, actualMinConnections);
    assertEquals(1, actualMinEffectiveConnection);
    assertEquals(1, actualMinParticipationRate);
    assertEquals(1, actualNodeP2pVersion);
    assertEquals(1, actualRateLimiterGlobalIpQps);
    assertEquals(1, actualRateLimiterGlobalQps);
    assertEquals(1, actualRpcOnSolidityPort);
    assertEquals(1, actualSolidityHttpPort);
    assertEquals(1, actualSolidityThreads);
    assertEquals(1, actualValidContractProtoThreadNum);
    assertEquals(1, actualValidateSignThreadNum);
    assertEquals(10, actualFetchBlockTimeout);
    assertEquals(10, actualNodeChannelReadTimeout);
    assertEquals(10, actualNodeConnectionTimeout);
    assertEquals(10, actualRpcThreadNum);
    assertEquals(10, actualTcpNettyWorkThreadNum);
    assertEquals(10, actualUdpNettyWorkThreadNum);
    assertEquals(10.0d, actualMaxTimeRatio, 0.0);
    assertEquals(10.0d, actualMinTimeRatio, 0.0);
    assertEquals(1L, actualAllowAdaptiveEnergy);
    assertEquals(1L, actualAllowAssetOptimization);
    assertEquals(1L, actualAllowBlackHoleOptimization);
    assertEquals(1L, actualAllowCancelAllUnfreezeV2);
    assertEquals(1L, actualAllowCreationOfContracts);
    assertEquals(1L, actualAllowDelegateOptimization);
    assertEquals(1L, actualAllowDelegateResource);
    assertEquals(1L, actualAllowDynamicEnergy);
    assertEquals(1L, actualAllowEnergyAdjustment);
    assertEquals(1L, actualAllowHigherLimitForMaxCpuTimeOfOneTx);
    assertEquals(1L, actualAllowMarketTransaction);
    assertEquals(1L, actualAllowNewResourceModel);
    assertEquals(1L, actualAllowNewReward);
    assertEquals(1L, actualAllowNewRewardAlgorithm);
    assertEquals(1L, actualAllowOldRewardOpt);
    assertEquals(1L, actualAllowOptimizedReturnValueOfChainId);
    assertEquals(1L, actualAllowPBFT);
    assertEquals(1L, actualAllowProtoFilterNum);
    assertEquals(1L, actualAllowSameTokenName);
    assertEquals(1L, actualAllowShieldedTRC20Transaction);
    assertEquals(1L, actualAllowStrictMath);
    assertEquals(1L, actualAllowTransactionFeePool);
    assertEquals(1L, actualAllowTvmCompatibleEvm);
    assertEquals(1L, actualAllowTvmConstantinople);
    assertEquals(1L, actualAllowTvmFreeze);
    assertEquals(1L, actualAllowTvmIstanbul);
    assertEquals(1L, actualAllowTvmLondon);
    assertEquals(1L, actualAllowTvmShangHai);
    assertEquals(1L, actualAllowTvmSolidity059);
    assertEquals(1L, actualAllowTvmTransferTrc10);
    assertEquals(1L, actualAllowTvmVote);
    assertEquals(1L, actualBlockCacheTimeout);
    assertEquals(1L, actualBlockNumForEnergyLimit);
    assertEquals(1L, actualChangedDelegation);
    assertEquals(1L, actualConsensusLogicOptimization);
    assertEquals(1L, actualDynamicEnergyIncreaseFactor);
    assertEquals(1L, actualDynamicEnergyMaxFactor);
    assertEquals(1L, actualDynamicEnergyThreshold);
    assertEquals(1L, actualForbidTransferToContract);
    assertEquals(1L, actualMaxConnectionAgeInMillis);
    assertEquals(1L, actualMaxConnectionIdleInMillis);
    assertEquals(1L, actualMaxEnergyLimitForConstant);
    assertEquals(1L, actualMemoFee);
    assertEquals(1L, actualNetMaxTrxPerSecond);
    assertEquals(1L, actualOldSolidityBlockNum);
    assertEquals(1L, actualPBFTExpireNum);
    assertEquals(1L, actualPendingTransactionTimeout);
    assertEquals(1L, actualProposalExpireTime);
    assertEquals(1L, actualShutdownBlockHeight);
    assertEquals(1L, actualSyncFetchBatchNum);
    assertEquals(1L, actualTrxExpirationTimeInMilliseconds);
    assertEquals(1L, actualUnfreezeDelayDays);
    assertEquals(3, actualAgreeNodeCount);
    assertEquals(3, actualLruCacheSize);
    assertEquals(3, actualMaxConcurrentCallsPerConnection);
    assertEquals(3, actualMaxConnections);
    assertEquals(3, actualMaxConnectionsWithSameIp);
    assertEquals(3, actualMaxHeaderListSize);
    assertEquals(3, actualMaxHttpConnectNumber);
    assertEquals(3, actualMaxMessageSize);
    assertEquals(3, actualMaxTps);
    assertEquals(3, actualMaxTransactionPendingSize);
    assertEquals(3, actualShieldedTransInPendingMaxCounts);
    assertEquals(3L, actualAllowAccountAssetOptimization);
    assertEquals(3L, actualAllowAccountStateRoot);
    assertEquals(3L, actualMaxCreateAccountTxSize);
    assertEquals(3L, actualReceiveTcpMinDataLength);
    assertEquals(3L, actualShutdownBlockCount);
    assertEquals(42, actualKeepAliveInterval);
    assertEquals(42, actualMetricsReportInterval);
    assertEquals(42L, actualDynamicConfigCheckInterval);
    assertEquals(42L, actualMaintenanceTimeInterval);
    assertEquals(8080, actualBackupPort);
    assertEquals(8080, actualFullNodeHttpPort);
    assertEquals(8080, actualInfluxDbPort);
    assertEquals(8080, actualJsonRpcHttpFullNodePort);
    assertEquals(8080, actualJsonRpcHttpPBFTPort);
    assertEquals(8080, actualMetricsPrometheusPort);
    assertEquals(8080, actualNodeListenPort);
    assertEquals(8080, actualPBFTHttpPort);
    assertEquals(8080, actualRpcOnPBFTPort);
    assertEquals(8080, actualRpcPort);
    assertFalse(actualIsFastForwardResult);
    assertFalse(actualIsHelpResult);
    assertTrue(actualActiveNodes.isEmpty());
    assertTrue(actualBackupMembers.isEmpty());
    assertTrue(actualDisabledApiList.isEmpty());
    assertTrue(actualDnsTreeUrls.isEmpty());
    assertTrue(actualPassiveNodes.isEmpty());
    assertTrue(actualSeedNodes.isEmpty());
    assertTrue(actualActuatorSet.isEmpty());
    assertTrue(actualIsDebugResult);
    assertTrue(actualIsDynamicConfigEnableResult);
    assertTrue(actualIsEstimateEnergyResult);
    assertTrue(actualIsEventSubscribeResult);
    assertTrue(actualIsFullNodeAllowShieldedTransactionArgsResult);
    assertTrue(actualIsFullNodeHttpEnableResult);
    assertTrue(actualIsHistoryBalanceLookupResult);
    assertTrue(actualIsJsonRpcHttpFullNodeEnableResult);
    assertTrue(actualIsJsonRpcHttpPBFTNodeEnableResult);
    assertTrue(actualIsJsonRpcHttpSolidityNodeEnableResult);
    assertTrue(actualIsMetricsPrometheusEnableResult);
    assertTrue(actualIsMetricsStorageEnableResult);
    assertTrue(actualIsNeedSyncCheckResult);
    assertTrue(actualIsNeedToUpdateAssetResult);
    assertTrue(actualIsNodeDetectEnableResult);
    assertTrue(actualIsNodeDiscoveryEnableResult);
    assertTrue(actualIsNodeDiscoveryPersistResult);
    assertTrue(actualIsNodeEffectiveCheckEnableResult);
    assertTrue(actualIsNodeEnableIpv6Result);
    assertTrue(actualIsNodeMetricsEnableResult);
    assertTrue(actualIsOpenFullTcpDisconnectResult);
    assertTrue(actualIsOpenHistoryQueryWhenLiteFNResult);
    assertTrue(actualIsOpenPrintLogResult);
    assertTrue(actualIsOpenTransactionSortResult);
    assertTrue(actualIsP2pDisableResult);
    assertTrue(actualIsRpcReflectionServiceEnableResult);
    assertTrue(actualIsSaveFeaturedInternalTxResult);
    assertTrue(actualIsSaveInternalTxResult);
    assertTrue(actualIsSolidityNodeResult);
    assertTrue(actualIsSolidityNodeHttpEnableResult);
    assertTrue(actualIsSupportConstantResult);
    assertTrue(actualIsTrxCacheEnableResult);
    assertTrue(actualIsUnsolidifiedBlockCheckResult);
    assertTrue(actualIsVmTraceResult);
    assertTrue(actualIsWalletExtensionApiResult);
    assertTrue(actualIsWitnessResult);
    assertSame(activeNodes, actualActiveNodes);
    assertSame(backupMembers, actualBackupMembers);
    assertSame(disabledApiList, actualDisabledApiList);
    assertSame(dnsTreeUrls, actualDnsTreeUrls);
    assertSame(passiveNodes, actualPassiveNodes);
    assertSame(actuatorSet, actualActuatorSet);
    assertSame(rateLimiterInitialization, actualRateLimiterInitialization);
    assertSame(dnsPublishConfig, actualDnsPublishConfig);
    assertSame(CommonParameter.PARAMETER, actualInstance2);
  }

  /**
   * Test new {@link CommonParameter} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CommonParameter}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CommonParameter.<init>()"})
  public void testNewCommonParameter() {
    // Arrange and Act
    CommonParameter actualCommonParameter = new CommonParameter();

    // Assert
    assertEquals("", actualCommonParameter.getLogbackPath());
    assertEquals("", actualCommonParameter.getShellConfFileName());
    assertEquals("", actualCommonParameter.contractParseEnable);
    assertEquals("", actualCommonParameter.privateKey);
    assertEquals("", actualCommonParameter.storageDbDirectory);
    assertEquals("", actualCommonParameter.storageDbEngine);
    assertEquals("", actualCommonParameter.storageDbSynchronous);
    assertEquals("", actualCommonParameter.storageIndexDirectory);
    assertEquals("", actualCommonParameter.storageIndexSwitch);
    assertEquals("", actualCommonParameter.storageTransactionHistorySwitch);
    assertEquals("", actualCommonParameter.witnessAddress);
    assertEquals("ECKey", actualCommonParameter.getCryptoEngine());
    assertEquals("output-directory", actualCommonParameter.getOutputDirectory());
    assertNull(actualCommonParameter.getChainId());
    assertNull(actualCommonParameter.getInfluxDbDatabase());
    assertNull(actualCommonParameter.getInfluxDbIp());
    assertNull(actualCommonParameter.getNodeExternalIp());
    assertNull(actualCommonParameter.getNodeLanIp());
    assertNull(actualCommonParameter.getTrustNodeAddr());
    assertNull(actualCommonParameter.getTrxReferenceBlock());
    assertNull(actualCommonParameter.getZenTokenId());
    assertNull(actualCommonParameter.password);
    assertNull(actualCommonParameter.getBackupMembers());
    assertNull(actualCommonParameter.getDisabledApiList());
    assertNull(actualCommonParameter.getDnsTreeUrls());
    assertNull(actualCommonParameter.getPassiveNodes());
    assertNull(actualCommonParameter.getActiveNodes());
    assertNull(actualCommonParameter.getFastForwardNodes());
    assertNull(actualCommonParameter.getActuatorSet());
    assertNull(actualCommonParameter.getShutdownBlockTime());
    assertNull(actualCommonParameter.getGenesisBlock());
    assertNull(actualCommonParameter.getDbBackupConfig());
    assertNull(actualCommonParameter.getEventPluginConfig());
    assertNull(actualCommonParameter.getEventFilter());
    assertNull(actualCommonParameter.getRateLimiterInitialization());
    assertNull(actualCommonParameter.getRocksDBCustomSettings());
    assertNull(actualCommonParameter.getOverlay());
    assertNull(actualCommonParameter.getSeedNode());
    assertNull(actualCommonParameter.getStorage());
    assertNull(actualCommonParameter.getP2pConfig());
    assertNull(actualCommonParameter.getDnsPublishConfig());
    assertEquals(-1L, actualCommonParameter.getOldSolidityBlockNum());
    assertEquals(-1L, actualCommonParameter.getShutdownBlockCount());
    assertEquals(-1L, actualCommonParameter.getShutdownBlockHeight());
    assertEquals(0, actualCommonParameter.getAgreeNodeCount());
    assertEquals(0, actualCommonParameter.getAllowMultiSign());
    assertEquals(0, actualCommonParameter.getBackupPort());
    assertEquals(0, actualCommonParameter.getBackupPriority());
    assertEquals(0, actualCommonParameter.getBlockProducedTimeOut());
    assertEquals(0, actualCommonParameter.getCheckFrozenTime());
    assertEquals(0, actualCommonParameter.getEstimateEnergyMaxRetry());
    assertEquals(0, actualCommonParameter.getFetchBlockTimeout());
    assertEquals(0, actualCommonParameter.getFlowControlWindow());
    assertEquals(0, actualCommonParameter.getFullNodeHttpPort());
    assertEquals(0, actualCommonParameter.getInactiveThreshold());
    assertEquals(0, actualCommonParameter.getInfluxDbPort());
    assertEquals(0, actualCommonParameter.getJsonRpcHttpFullNodePort());
    assertEquals(0, actualCommonParameter.getJsonRpcHttpPBFTPort());
    assertEquals(0, actualCommonParameter.getJsonRpcHttpSolidityPort());
    assertEquals(0, actualCommonParameter.getKeepAliveInterval());
    assertEquals(0, actualCommonParameter.getMaxConcurrentCallsPerConnection());
    assertEquals(0, actualCommonParameter.getMaxConnections());
    assertEquals(0, actualCommonParameter.getMaxConnectionsWithSameIp());
    assertEquals(0, actualCommonParameter.getMaxFastForwardNum());
    assertEquals(0, actualCommonParameter.getMaxHeaderListSize());
    assertEquals(0, actualCommonParameter.getMaxMessageSize());
    assertEquals(0, actualCommonParameter.getMaxTps());
    assertEquals(0, actualCommonParameter.getMaxTransactionPendingSize());
    assertEquals(0, actualCommonParameter.getMaxUnsolidifiedBlocks());
    assertEquals(0, actualCommonParameter.getMetricsPrometheusPort());
    assertEquals(0, actualCommonParameter.getMinActiveConnections());
    assertEquals(0, actualCommonParameter.getMinConnections());
    assertEquals(0, actualCommonParameter.getMinEffectiveConnection());
    assertEquals(0, actualCommonParameter.getMinParticipationRate());
    assertEquals(0, actualCommonParameter.getNodeChannelReadTimeout());
    assertEquals(0, actualCommonParameter.getNodeConnectionTimeout());
    assertEquals(0, actualCommonParameter.getNodeListenPort());
    assertEquals(0, actualCommonParameter.getNodeP2pVersion());
    assertEquals(0, actualCommonParameter.getPBFTHttpPort());
    assertEquals(0, actualCommonParameter.getRateLimiterGlobalApiQps());
    assertEquals(0, actualCommonParameter.getRateLimiterGlobalIpQps());
    assertEquals(0, actualCommonParameter.getRateLimiterGlobalQps());
    assertEquals(0, actualCommonParameter.getRpcOnPBFTPort());
    assertEquals(0, actualCommonParameter.getRpcOnSolidityPort());
    assertEquals(0, actualCommonParameter.getRpcPort());
    assertEquals(0, actualCommonParameter.getRpcThreadNum());
    assertEquals(0, actualCommonParameter.getShieldedTransInPendingMaxCounts());
    assertEquals(0, actualCommonParameter.getSolidityHttpPort());
    assertEquals(0, actualCommonParameter.getSolidityThreads());
    assertEquals(0, actualCommonParameter.getTcpNettyWorkThreadNum());
    assertEquals(0, actualCommonParameter.getUdpNettyWorkThreadNum());
    assertEquals(0, actualCommonParameter.getValidateSignThreadNum());
    assertEquals(0.0d, actualCommonParameter.getMinTimeRatio(), 0.0);
    assertEquals(0L, actualCommonParameter.getAllowAccountAssetOptimization());
    assertEquals(0L, actualCommonParameter.getAllowAccountStateRoot());
    assertEquals(0L, actualCommonParameter.getAllowAdaptiveEnergy());
    assertEquals(0L, actualCommonParameter.getAllowAssetOptimization());
    assertEquals(0L, actualCommonParameter.getAllowBlackHoleOptimization());
    assertEquals(0L, actualCommonParameter.getAllowCancelAllUnfreezeV2());
    assertEquals(0L, actualCommonParameter.getAllowCreationOfContracts());
    assertEquals(0L, actualCommonParameter.getAllowDelegateOptimization());
    assertEquals(0L, actualCommonParameter.getAllowDelegateResource());
    assertEquals(0L, actualCommonParameter.getAllowDynamicEnergy());
    assertEquals(0L, actualCommonParameter.getAllowEnergyAdjustment());
    assertEquals(0L, actualCommonParameter.getAllowHigherLimitForMaxCpuTimeOfOneTx());
    assertEquals(0L, actualCommonParameter.getAllowMarketTransaction());
    assertEquals(0L, actualCommonParameter.getAllowNewResourceModel());
    assertEquals(0L, actualCommonParameter.getAllowNewReward());
    assertEquals(0L, actualCommonParameter.getAllowNewRewardAlgorithm());
    assertEquals(0L, actualCommonParameter.getAllowOldRewardOpt());
    assertEquals(0L, actualCommonParameter.getAllowOptimizedReturnValueOfChainId());
    assertEquals(0L, actualCommonParameter.getAllowPBFT());
    assertEquals(0L, actualCommonParameter.getAllowProtoFilterNum());
    assertEquals(0L, actualCommonParameter.getAllowSameTokenName());
    assertEquals(0L, actualCommonParameter.getAllowShieldedTRC20Transaction());
    assertEquals(0L, actualCommonParameter.getAllowStrictMath());
    assertEquals(0L, actualCommonParameter.getAllowTransactionFeePool());
    assertEquals(0L, actualCommonParameter.getAllowTvmCompatibleEvm());
    assertEquals(0L, actualCommonParameter.getAllowTvmConstantinople());
    assertEquals(0L, actualCommonParameter.getAllowTvmFreeze());
    assertEquals(0L, actualCommonParameter.getAllowTvmIstanbul());
    assertEquals(0L, actualCommonParameter.getAllowTvmLondon());
    assertEquals(0L, actualCommonParameter.getAllowTvmShangHai());
    assertEquals(0L, actualCommonParameter.getAllowTvmSolidity059());
    assertEquals(0L, actualCommonParameter.getAllowTvmTransferTrc10());
    assertEquals(0L, actualCommonParameter.getAllowTvmVote());
    assertEquals(0L, actualCommonParameter.getBlockNumForEnergyLimit());
    assertEquals(0L, actualCommonParameter.getChangedDelegation());
    assertEquals(0L, actualCommonParameter.getConsensusLogicOptimization());
    assertEquals(0L, actualCommonParameter.getDynamicConfigCheckInterval());
    assertEquals(0L, actualCommonParameter.getDynamicEnergyIncreaseFactor());
    assertEquals(0L, actualCommonParameter.getDynamicEnergyMaxFactor());
    assertEquals(0L, actualCommonParameter.getDynamicEnergyThreshold());
    assertEquals(0L, actualCommonParameter.getForbidTransferToContract());
    assertEquals(0L, actualCommonParameter.getMaintenanceTimeInterval());
    assertEquals(0L, actualCommonParameter.getMaxConnectionAgeInMillis());
    assertEquals(0L, actualCommonParameter.getMaxConnectionIdleInMillis());
    assertEquals(0L, actualCommonParameter.getMemoFee());
    assertEquals(0L, actualCommonParameter.getNetMaxTrxPerSecond());
    assertEquals(0L, actualCommonParameter.getPBFTExpireNum());
    assertEquals(0L, actualCommonParameter.getPendingTransactionTimeout());
    assertEquals(0L, actualCommonParameter.getProposalExpireTime());
    assertEquals(0L, actualCommonParameter.getReceiveTcpMinDataLength());
    assertEquals(0L, actualCommonParameter.getSyncFetchBatchNum());
    assertEquals(0L, actualCommonParameter.getTrxExpirationTimeInMilliseconds());
    assertEquals(0L, actualCommonParameter.getUnfreezeDelayDays());
    assertEquals(1, actualCommonParameter.getValidContractProtoThreadNum());
    assertEquals(10, actualCommonParameter.getLongRunningTime());
    assertEquals(10, actualCommonParameter.getMetricsReportInterval());
    assertEquals(100000000L, actualCommonParameter.getMaxEnergyLimitForConstant());
    assertEquals(1000L, actualCommonParameter.getMaxCreateAccountTxSize());
    assertEquals(5.0d, actualCommonParameter.getMaxTimeRatio(), 0.0);
    assertEquals(50, actualCommonParameter.getMaxHttpConnectNumber());
    assertEquals(500, actualCommonParameter.getLruCacheSize());
    assertEquals(500, actualCommonParameter.getSafeLruCacheSize());
    assertEquals(60L, actualCommonParameter.getBlockCacheTimeout());
    assertFalse(actualCommonParameter.isDebug());
    assertFalse(actualCommonParameter.isDynamicConfigEnable());
    assertFalse(actualCommonParameter.isEstimateEnergy());
    assertFalse(actualCommonParameter.isEventSubscribe());
    assertFalse(actualCommonParameter.isFastForward());
    assertFalse(actualCommonParameter.isFullNodeAllowShieldedTransactionArgs());
    assertFalse(actualCommonParameter.isHelp());
    assertFalse(actualCommonParameter.isHistoryBalanceLookup());
    assertFalse(actualCommonParameter.isJsonRpcFilterEnabled());
    assertFalse(actualCommonParameter.isJsonRpcHttpFullNodeEnable());
    assertFalse(actualCommonParameter.isJsonRpcHttpPBFTNodeEnable());
    assertFalse(actualCommonParameter.isJsonRpcHttpSolidityNodeEnable());
    assertFalse(actualCommonParameter.isMetricsPrometheusEnable());
    assertFalse(actualCommonParameter.isMetricsStorageEnable());
    assertFalse(actualCommonParameter.isNeedSyncCheck());
    assertFalse(actualCommonParameter.isNeedToUpdateAsset());
    assertFalse(actualCommonParameter.isNodeDetectEnable());
    assertFalse(actualCommonParameter.isNodeDiscoveryEnable());
    assertFalse(actualCommonParameter.isNodeDiscoveryPersist());
    assertFalse(actualCommonParameter.isNodeEffectiveCheckEnable());
    assertFalse(actualCommonParameter.isNodeEnableIpv6());
    assertFalse(actualCommonParameter.isNodeMetricsEnable());
    assertFalse(actualCommonParameter.isOpenFullTcpDisconnect());
    assertFalse(actualCommonParameter.isOpenHistoryQueryWhenLiteFN());
    assertFalse(actualCommonParameter.isOpenTransactionSort());
    assertFalse(actualCommonParameter.isP2pDisable());
    assertFalse(actualCommonParameter.isRpcReflectionServiceEnable());
    assertFalse(actualCommonParameter.isSaveFeaturedInternalTx());
    assertFalse(actualCommonParameter.isSaveInternalTx());
    assertFalse(actualCommonParameter.isSolidityNode());
    assertFalse(actualCommonParameter.isSupportConstant());
    assertFalse(actualCommonParameter.isTrxCacheEnable());
    assertFalse(actualCommonParameter.isUnsolidifiedBlockCheck());
    assertFalse(actualCommonParameter.isVmTrace());
    assertFalse(actualCommonParameter.isWalletExtensionApi());
    assertFalse(actualCommonParameter.isWitness());
    assertFalse(actualCommonParameter.version);
    assertTrue(actualCommonParameter.getSeedNodes().isEmpty());
    assertTrue(actualCommonParameter.isFullNodeHttpEnable());
    assertTrue(actualCommonParameter.isOpenPrintLog());
    assertTrue(actualCommonParameter.isSolidityNodeHttpEnable());
  }

  /**
   * Test new {@link CommonParameter} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CommonParameter}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CommonParameter.<init>()"})
  public void testNewCommonParameter2() {
    // Arrange and Act
    CommonParameter actualCommonParameter = new CommonParameter();

    // Assert
    assertEquals("", actualCommonParameter.getLogbackPath());
    assertEquals("", actualCommonParameter.getShellConfFileName());
    assertEquals("", actualCommonParameter.contractParseEnable);
    assertEquals("", actualCommonParameter.privateKey);
    assertEquals("", actualCommonParameter.storageDbDirectory);
    assertEquals("", actualCommonParameter.storageDbEngine);
    assertEquals("", actualCommonParameter.storageDbSynchronous);
    assertEquals("", actualCommonParameter.storageIndexDirectory);
    assertEquals("", actualCommonParameter.storageIndexSwitch);
    assertEquals("", actualCommonParameter.storageTransactionHistorySwitch);
    assertEquals("", actualCommonParameter.witnessAddress);
    assertEquals("ECKey", actualCommonParameter.getCryptoEngine());
    assertEquals("output-directory", actualCommonParameter.getOutputDirectory());
    assertNull(actualCommonParameter.getChainId());
    assertNull(actualCommonParameter.getInfluxDbDatabase());
    assertNull(actualCommonParameter.getInfluxDbIp());
    assertNull(actualCommonParameter.getNodeExternalIp());
    assertNull(actualCommonParameter.getNodeLanIp());
    assertNull(actualCommonParameter.getTrustNodeAddr());
    assertNull(actualCommonParameter.getTrxReferenceBlock());
    assertNull(actualCommonParameter.getZenTokenId());
    assertNull(actualCommonParameter.password);
    assertNull(actualCommonParameter.getBackupMembers());
    assertNull(actualCommonParameter.getDisabledApiList());
    assertNull(actualCommonParameter.getDnsTreeUrls());
    assertNull(actualCommonParameter.getPassiveNodes());
    assertNull(actualCommonParameter.getActiveNodes());
    assertNull(actualCommonParameter.getFastForwardNodes());
    assertNull(actualCommonParameter.getActuatorSet());
    assertNull(actualCommonParameter.getShutdownBlockTime());
    assertNull(actualCommonParameter.getGenesisBlock());
    assertNull(actualCommonParameter.getDbBackupConfig());
    assertNull(actualCommonParameter.getEventPluginConfig());
    assertNull(actualCommonParameter.getEventFilter());
    assertNull(actualCommonParameter.getRateLimiterInitialization());
    assertNull(actualCommonParameter.getRocksDBCustomSettings());
    assertNull(actualCommonParameter.getOverlay());
    assertNull(actualCommonParameter.getSeedNode());
    assertNull(actualCommonParameter.getStorage());
    assertNull(actualCommonParameter.getP2pConfig());
    assertNull(actualCommonParameter.getDnsPublishConfig());
    assertEquals(-1L, actualCommonParameter.getOldSolidityBlockNum());
    assertEquals(-1L, actualCommonParameter.getShutdownBlockCount());
    assertEquals(-1L, actualCommonParameter.getShutdownBlockHeight());
    assertEquals(0, actualCommonParameter.getAgreeNodeCount());
    assertEquals(0, actualCommonParameter.getAllowMultiSign());
    assertEquals(0, actualCommonParameter.getBackupPort());
    assertEquals(0, actualCommonParameter.getBackupPriority());
    assertEquals(0, actualCommonParameter.getBlockProducedTimeOut());
    assertEquals(0, actualCommonParameter.getCheckFrozenTime());
    assertEquals(0, actualCommonParameter.getEstimateEnergyMaxRetry());
    assertEquals(0, actualCommonParameter.getFetchBlockTimeout());
    assertEquals(0, actualCommonParameter.getFlowControlWindow());
    assertEquals(0, actualCommonParameter.getFullNodeHttpPort());
    assertEquals(0, actualCommonParameter.getInactiveThreshold());
    assertEquals(0, actualCommonParameter.getInfluxDbPort());
    assertEquals(0, actualCommonParameter.getJsonRpcHttpFullNodePort());
    assertEquals(0, actualCommonParameter.getJsonRpcHttpPBFTPort());
    assertEquals(0, actualCommonParameter.getJsonRpcHttpSolidityPort());
    assertEquals(0, actualCommonParameter.getKeepAliveInterval());
    assertEquals(0, actualCommonParameter.getMaxConcurrentCallsPerConnection());
    assertEquals(0, actualCommonParameter.getMaxConnections());
    assertEquals(0, actualCommonParameter.getMaxConnectionsWithSameIp());
    assertEquals(0, actualCommonParameter.getMaxFastForwardNum());
    assertEquals(0, actualCommonParameter.getMaxHeaderListSize());
    assertEquals(0, actualCommonParameter.getMaxMessageSize());
    assertEquals(0, actualCommonParameter.getMaxTps());
    assertEquals(0, actualCommonParameter.getMaxTransactionPendingSize());
    assertEquals(0, actualCommonParameter.getMaxUnsolidifiedBlocks());
    assertEquals(0, actualCommonParameter.getMetricsPrometheusPort());
    assertEquals(0, actualCommonParameter.getMinActiveConnections());
    assertEquals(0, actualCommonParameter.getMinConnections());
    assertEquals(0, actualCommonParameter.getMinEffectiveConnection());
    assertEquals(0, actualCommonParameter.getMinParticipationRate());
    assertEquals(0, actualCommonParameter.getNodeChannelReadTimeout());
    assertEquals(0, actualCommonParameter.getNodeConnectionTimeout());
    assertEquals(0, actualCommonParameter.getNodeListenPort());
    assertEquals(0, actualCommonParameter.getNodeP2pVersion());
    assertEquals(0, actualCommonParameter.getPBFTHttpPort());
    assertEquals(0, actualCommonParameter.getRateLimiterGlobalApiQps());
    assertEquals(0, actualCommonParameter.getRateLimiterGlobalIpQps());
    assertEquals(0, actualCommonParameter.getRateLimiterGlobalQps());
    assertEquals(0, actualCommonParameter.getRpcOnPBFTPort());
    assertEquals(0, actualCommonParameter.getRpcOnSolidityPort());
    assertEquals(0, actualCommonParameter.getRpcPort());
    assertEquals(0, actualCommonParameter.getRpcThreadNum());
    assertEquals(0, actualCommonParameter.getShieldedTransInPendingMaxCounts());
    assertEquals(0, actualCommonParameter.getSolidityHttpPort());
    assertEquals(0, actualCommonParameter.getSolidityThreads());
    assertEquals(0, actualCommonParameter.getTcpNettyWorkThreadNum());
    assertEquals(0, actualCommonParameter.getUdpNettyWorkThreadNum());
    assertEquals(0, actualCommonParameter.getValidateSignThreadNum());
    assertEquals(0.0d, actualCommonParameter.getMinTimeRatio(), 0.0);
    assertEquals(0L, actualCommonParameter.getAllowAccountAssetOptimization());
    assertEquals(0L, actualCommonParameter.getAllowAccountStateRoot());
    assertEquals(0L, actualCommonParameter.getAllowAdaptiveEnergy());
    assertEquals(0L, actualCommonParameter.getAllowAssetOptimization());
    assertEquals(0L, actualCommonParameter.getAllowBlackHoleOptimization());
    assertEquals(0L, actualCommonParameter.getAllowCancelAllUnfreezeV2());
    assertEquals(0L, actualCommonParameter.getAllowCreationOfContracts());
    assertEquals(0L, actualCommonParameter.getAllowDelegateOptimization());
    assertEquals(0L, actualCommonParameter.getAllowDelegateResource());
    assertEquals(0L, actualCommonParameter.getAllowDynamicEnergy());
    assertEquals(0L, actualCommonParameter.getAllowEnergyAdjustment());
    assertEquals(0L, actualCommonParameter.getAllowHigherLimitForMaxCpuTimeOfOneTx());
    assertEquals(0L, actualCommonParameter.getAllowMarketTransaction());
    assertEquals(0L, actualCommonParameter.getAllowNewResourceModel());
    assertEquals(0L, actualCommonParameter.getAllowNewReward());
    assertEquals(0L, actualCommonParameter.getAllowNewRewardAlgorithm());
    assertEquals(0L, actualCommonParameter.getAllowOldRewardOpt());
    assertEquals(0L, actualCommonParameter.getAllowOptimizedReturnValueOfChainId());
    assertEquals(0L, actualCommonParameter.getAllowPBFT());
    assertEquals(0L, actualCommonParameter.getAllowProtoFilterNum());
    assertEquals(0L, actualCommonParameter.getAllowSameTokenName());
    assertEquals(0L, actualCommonParameter.getAllowShieldedTRC20Transaction());
    assertEquals(0L, actualCommonParameter.getAllowStrictMath());
    assertEquals(0L, actualCommonParameter.getAllowTransactionFeePool());
    assertEquals(0L, actualCommonParameter.getAllowTvmCompatibleEvm());
    assertEquals(0L, actualCommonParameter.getAllowTvmConstantinople());
    assertEquals(0L, actualCommonParameter.getAllowTvmFreeze());
    assertEquals(0L, actualCommonParameter.getAllowTvmIstanbul());
    assertEquals(0L, actualCommonParameter.getAllowTvmLondon());
    assertEquals(0L, actualCommonParameter.getAllowTvmShangHai());
    assertEquals(0L, actualCommonParameter.getAllowTvmSolidity059());
    assertEquals(0L, actualCommonParameter.getAllowTvmTransferTrc10());
    assertEquals(0L, actualCommonParameter.getAllowTvmVote());
    assertEquals(0L, actualCommonParameter.getBlockNumForEnergyLimit());
    assertEquals(0L, actualCommonParameter.getChangedDelegation());
    assertEquals(0L, actualCommonParameter.getConsensusLogicOptimization());
    assertEquals(0L, actualCommonParameter.getDynamicConfigCheckInterval());
    assertEquals(0L, actualCommonParameter.getDynamicEnergyIncreaseFactor());
    assertEquals(0L, actualCommonParameter.getDynamicEnergyMaxFactor());
    assertEquals(0L, actualCommonParameter.getDynamicEnergyThreshold());
    assertEquals(0L, actualCommonParameter.getForbidTransferToContract());
    assertEquals(0L, actualCommonParameter.getMaintenanceTimeInterval());
    assertEquals(0L, actualCommonParameter.getMaxConnectionAgeInMillis());
    assertEquals(0L, actualCommonParameter.getMaxConnectionIdleInMillis());
    assertEquals(0L, actualCommonParameter.getMemoFee());
    assertEquals(0L, actualCommonParameter.getNetMaxTrxPerSecond());
    assertEquals(0L, actualCommonParameter.getPBFTExpireNum());
    assertEquals(0L, actualCommonParameter.getPendingTransactionTimeout());
    assertEquals(0L, actualCommonParameter.getProposalExpireTime());
    assertEquals(0L, actualCommonParameter.getReceiveTcpMinDataLength());
    assertEquals(0L, actualCommonParameter.getSyncFetchBatchNum());
    assertEquals(0L, actualCommonParameter.getTrxExpirationTimeInMilliseconds());
    assertEquals(0L, actualCommonParameter.getUnfreezeDelayDays());
    assertEquals(1, actualCommonParameter.getValidContractProtoThreadNum());
    assertEquals(10, actualCommonParameter.getLongRunningTime());
    assertEquals(10, actualCommonParameter.getMetricsReportInterval());
    assertEquals(100000000L, actualCommonParameter.getMaxEnergyLimitForConstant());
    assertEquals(1000L, actualCommonParameter.getMaxCreateAccountTxSize());
    assertEquals(5.0d, actualCommonParameter.getMaxTimeRatio(), 0.0);
    assertEquals(50, actualCommonParameter.getMaxHttpConnectNumber());
    assertEquals(500, actualCommonParameter.getLruCacheSize());
    assertEquals(500, actualCommonParameter.getSafeLruCacheSize());
    assertEquals(60L, actualCommonParameter.getBlockCacheTimeout());
    assertFalse(actualCommonParameter.isDebug());
    assertFalse(actualCommonParameter.isDynamicConfigEnable());
    assertFalse(actualCommonParameter.isEstimateEnergy());
    assertFalse(actualCommonParameter.isEventSubscribe());
    assertFalse(actualCommonParameter.isFastForward());
    assertFalse(actualCommonParameter.isFullNodeAllowShieldedTransactionArgs());
    assertFalse(actualCommonParameter.isHelp());
    assertFalse(actualCommonParameter.isHistoryBalanceLookup());
    assertFalse(actualCommonParameter.isJsonRpcFilterEnabled());
    assertFalse(actualCommonParameter.isJsonRpcHttpFullNodeEnable());
    assertFalse(actualCommonParameter.isJsonRpcHttpPBFTNodeEnable());
    assertFalse(actualCommonParameter.isJsonRpcHttpSolidityNodeEnable());
    assertFalse(actualCommonParameter.isMetricsPrometheusEnable());
    assertFalse(actualCommonParameter.isMetricsStorageEnable());
    assertFalse(actualCommonParameter.isNeedSyncCheck());
    assertFalse(actualCommonParameter.isNeedToUpdateAsset());
    assertFalse(actualCommonParameter.isNodeDetectEnable());
    assertFalse(actualCommonParameter.isNodeDiscoveryEnable());
    assertFalse(actualCommonParameter.isNodeDiscoveryPersist());
    assertFalse(actualCommonParameter.isNodeEffectiveCheckEnable());
    assertFalse(actualCommonParameter.isNodeEnableIpv6());
    assertFalse(actualCommonParameter.isNodeMetricsEnable());
    assertFalse(actualCommonParameter.isOpenFullTcpDisconnect());
    assertFalse(actualCommonParameter.isOpenHistoryQueryWhenLiteFN());
    assertFalse(actualCommonParameter.isOpenTransactionSort());
    assertFalse(actualCommonParameter.isP2pDisable());
    assertFalse(actualCommonParameter.isRpcReflectionServiceEnable());
    assertFalse(actualCommonParameter.isSaveFeaturedInternalTx());
    assertFalse(actualCommonParameter.isSaveInternalTx());
    assertFalse(actualCommonParameter.isSolidityNode());
    assertFalse(actualCommonParameter.isSupportConstant());
    assertFalse(actualCommonParameter.isTrxCacheEnable());
    assertFalse(actualCommonParameter.isUnsolidifiedBlockCheck());
    assertFalse(actualCommonParameter.isVmTrace());
    assertFalse(actualCommonParameter.isWalletExtensionApi());
    assertFalse(actualCommonParameter.isWitness());
    assertFalse(actualCommonParameter.version);
    assertTrue(actualCommonParameter.getSeedNodes().isEmpty());
    assertTrue(actualCommonParameter.isFullNodeHttpEnable());
    assertTrue(actualCommonParameter.isOpenPrintLog());
    assertTrue(actualCommonParameter.isSolidityNodeHttpEnable());
  }
}
