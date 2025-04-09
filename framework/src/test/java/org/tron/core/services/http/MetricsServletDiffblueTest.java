package org.tron.core.services.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.core.metrics.MetricsApiService;
import org.tron.core.metrics.MetricsInfo;
import org.tron.core.metrics.blockchain.BlockChainInfo;
import org.tron.core.metrics.blockchain.DupWitnessInfo;
import org.tron.core.metrics.blockchain.WitnessInfo;
import org.tron.core.metrics.net.ApiInfo;
import org.tron.core.metrics.net.LatencyInfo;
import org.tron.core.metrics.net.NetInfo;
import org.tron.core.metrics.net.RateInfo;
import org.tron.core.metrics.node.NodeInfo;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class MetricsServletDiffblueTest {
  @Mock
  private MetricsApiService metricsApiService;

  @InjectMocks
  private MetricsServlet metricsServlet;

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");

    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api2);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency2);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");
    MetricsInfo metricsInfo = mock(MetricsInfo.class);
    when(metricsInfo.getInterval()).thenReturn(42L);
    when(metricsInfo.getBlockchain()).thenReturn(blockChainInfo);
    when(metricsInfo.getNet()).thenReturn(netInfo);
    when(metricsInfo.getNode()).thenReturn(nodeInfo);
    doNothing().when(metricsInfo).setBlockchain(Mockito.<BlockChainInfo>any());
    doNothing().when(metricsInfo).setInterval(anyLong());
    doNothing().when(metricsInfo).setNet(Mockito.<NetInfo>any());
    doNothing().when(metricsInfo).setNode(Mockito.<NodeInfo>any());
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(metricsInfo).getBlockchain();
    verify(metricsInfo).getInterval();
    verify(metricsInfo).getNet();
    verify(metricsInfo).getNode();
    verify(metricsInfo).setBlockchain(isA(BlockChainInfo.class));
    verify(metricsInfo).setInterval(eq(42L));
    verify(metricsInfo).setNet(isA(NetInfo.class));
    verify(metricsInfo).setNode(isA(NodeInfo.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(2032, response.getByteSize());
    assertEquals(2032, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet2() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");

    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api2);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency2);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");
    MetricsInfo metricsInfo = mock(MetricsInfo.class);
    when(metricsInfo.getInterval()).thenReturn(Long.MAX_VALUE);
    when(metricsInfo.getBlockchain()).thenReturn(blockChainInfo);
    when(metricsInfo.getNet()).thenReturn(netInfo);
    when(metricsInfo.getNode()).thenReturn(nodeInfo);
    doNothing().when(metricsInfo).setBlockchain(Mockito.<BlockChainInfo>any());
    doNothing().when(metricsInfo).setInterval(anyLong());
    doNothing().when(metricsInfo).setNet(Mockito.<NetInfo>any());
    doNothing().when(metricsInfo).setNode(Mockito.<NodeInfo>any());
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(metricsInfo).getBlockchain();
    verify(metricsInfo).getInterval();
    verify(metricsInfo).getNet();
    verify(metricsInfo).getNode();
    verify(metricsInfo).setBlockchain(isA(BlockChainInfo.class));
    verify(metricsInfo).setInterval(eq(42L));
    verify(metricsInfo).setNet(isA(NetInfo.class));
    verify(metricsInfo).setNode(isA(NodeInfo.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(2049, response.getByteSize());
    assertEquals(2049, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet3() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");

    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api2);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency2);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");
    MetricsInfo metricsInfo = mock(MetricsInfo.class);
    when(metricsInfo.getInterval()).thenReturn(Long.MIN_VALUE);
    when(metricsInfo.getBlockchain()).thenReturn(blockChainInfo);
    when(metricsInfo.getNet()).thenReturn(netInfo);
    when(metricsInfo.getNode()).thenReturn(nodeInfo);
    doNothing().when(metricsInfo).setBlockchain(Mockito.<BlockChainInfo>any());
    doNothing().when(metricsInfo).setInterval(anyLong());
    doNothing().when(metricsInfo).setNet(Mockito.<NetInfo>any());
    doNothing().when(metricsInfo).setNode(Mockito.<NodeInfo>any());
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(metricsInfo).getBlockchain();
    verify(metricsInfo).getInterval();
    verify(metricsInfo).getNet();
    verify(metricsInfo).getNode();
    verify(metricsInfo).setBlockchain(isA(BlockChainInfo.class));
    verify(metricsInfo).setInterval(eq(42L));
    verify(metricsInfo).setNet(isA(NetInfo.class));
    verify(metricsInfo).setNode(isA(NodeInfo.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(2050, response.getByteSize());
    assertEquals(2050, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet4() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");
    BlockChainInfo blockChainInfo = mock(BlockChainInfo.class);
    when(blockChainInfo.getFailForkCount()).thenReturn(-1);
    when(blockChainInfo.getForkCount()).thenReturn(3);
    when(blockChainInfo.getTransactionCacheSize()).thenReturn(3);
    when(blockChainInfo.getFailProcessBlockReason()).thenReturn("Just cause");
    when(blockChainInfo.getHeadBlockHash()).thenReturn("Head Block Hash");
    when(blockChainInfo.getDupWitness()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getWitnesses()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getFailProcessBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockTimestamp()).thenReturn(1L);
    when(blockChainInfo.getBlockProcessTime()).thenReturn(new RateInfo());
    when(blockChainInfo.getMissedTransaction()).thenReturn(new RateInfo());
    when(blockChainInfo.getTps()).thenReturn(new RateInfo());
    doNothing().when(blockChainInfo).setBlockProcessTime(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setDupWitness(Mockito.<List<DupWitnessInfo>>any());
    doNothing().when(blockChainInfo).setFailForkCount(anyInt());
    doNothing().when(blockChainInfo).setFailProcessBlockNum(anyLong());
    doNothing().when(blockChainInfo).setFailProcessBlockReason(Mockito.<String>any());
    doNothing().when(blockChainInfo).setForkCount(anyInt());
    doNothing().when(blockChainInfo).setHeadBlockHash(Mockito.<String>any());
    doNothing().when(blockChainInfo).setHeadBlockNum(anyLong());
    doNothing().when(blockChainInfo).setHeadBlockTimestamp(anyLong());
    doNothing().when(blockChainInfo).setMissedTransaction(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTps(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTransactionCacheSize(anyInt());
    doNothing().when(blockChainInfo).setWitnesses(Mockito.<List<WitnessInfo>>any());
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api2);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency2);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");
    MetricsInfo metricsInfo = mock(MetricsInfo.class);
    when(metricsInfo.getInterval()).thenReturn(42L);
    when(metricsInfo.getBlockchain()).thenReturn(blockChainInfo);
    when(metricsInfo.getNet()).thenReturn(netInfo);
    when(metricsInfo.getNode()).thenReturn(nodeInfo);
    doNothing().when(metricsInfo).setBlockchain(Mockito.<BlockChainInfo>any());
    doNothing().when(metricsInfo).setInterval(anyLong());
    doNothing().when(metricsInfo).setNet(Mockito.<NetInfo>any());
    doNothing().when(metricsInfo).setNode(Mockito.<NodeInfo>any());
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(metricsInfo).getBlockchain();
    verify(metricsInfo).getInterval();
    verify(metricsInfo).getNet();
    verify(metricsInfo).getNode();
    verify(metricsInfo).setBlockchain(isA(BlockChainInfo.class));
    verify(metricsInfo).setInterval(eq(42L));
    verify(metricsInfo).setNet(isA(NetInfo.class));
    verify(metricsInfo).setNode(isA(NodeInfo.class));
    verify(blockChainInfo).getBlockProcessTime();
    verify(blockChainInfo).getDupWitness();
    verify(blockChainInfo).getFailForkCount();
    verify(blockChainInfo).getFailProcessBlockNum();
    verify(blockChainInfo).getFailProcessBlockReason();
    verify(blockChainInfo).getForkCount();
    verify(blockChainInfo).getHeadBlockHash();
    verify(blockChainInfo).getHeadBlockNum();
    verify(blockChainInfo).getHeadBlockTimestamp();
    verify(blockChainInfo).getMissedTransaction();
    verify(blockChainInfo).getTps();
    verify(blockChainInfo).getTransactionCacheSize();
    verify(blockChainInfo).getWitnesses();
    verify(blockChainInfo).setBlockProcessTime(isA(RateInfo.class));
    verify(blockChainInfo).setDupWitness(isA(List.class));
    verify(blockChainInfo).setFailForkCount(eq(3));
    verify(blockChainInfo).setFailProcessBlockNum(eq(1L));
    verify(blockChainInfo).setFailProcessBlockReason(eq("Just cause"));
    verify(blockChainInfo).setForkCount(eq(3));
    verify(blockChainInfo).setHeadBlockHash(eq("Head Block Hash"));
    verify(blockChainInfo).setHeadBlockNum(eq(1L));
    verify(blockChainInfo).setHeadBlockTimestamp(eq(1L));
    verify(blockChainInfo).setMissedTransaction(isA(RateInfo.class));
    verify(blockChainInfo).setTps(isA(RateInfo.class));
    verify(blockChainInfo).setTransactionCacheSize(eq(3));
    verify(blockChainInfo).setWitnesses(isA(List.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(2033, response.getByteSize());
    assertEquals(2033, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet5() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");
    BlockChainInfo blockChainInfo = mock(BlockChainInfo.class);
    when(blockChainInfo.getFailForkCount()).thenReturn(Integer.MIN_VALUE);
    when(blockChainInfo.getForkCount()).thenReturn(3);
    when(blockChainInfo.getTransactionCacheSize()).thenReturn(3);
    when(blockChainInfo.getFailProcessBlockReason()).thenReturn("Just cause");
    when(blockChainInfo.getHeadBlockHash()).thenReturn("Head Block Hash");
    when(blockChainInfo.getDupWitness()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getWitnesses()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getFailProcessBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockTimestamp()).thenReturn(1L);
    when(blockChainInfo.getBlockProcessTime()).thenReturn(new RateInfo());
    when(blockChainInfo.getMissedTransaction()).thenReturn(new RateInfo());
    when(blockChainInfo.getTps()).thenReturn(new RateInfo());
    doNothing().when(blockChainInfo).setBlockProcessTime(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setDupWitness(Mockito.<List<DupWitnessInfo>>any());
    doNothing().when(blockChainInfo).setFailForkCount(anyInt());
    doNothing().when(blockChainInfo).setFailProcessBlockNum(anyLong());
    doNothing().when(blockChainInfo).setFailProcessBlockReason(Mockito.<String>any());
    doNothing().when(blockChainInfo).setForkCount(anyInt());
    doNothing().when(blockChainInfo).setHeadBlockHash(Mockito.<String>any());
    doNothing().when(blockChainInfo).setHeadBlockNum(anyLong());
    doNothing().when(blockChainInfo).setHeadBlockTimestamp(anyLong());
    doNothing().when(blockChainInfo).setMissedTransaction(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTps(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTransactionCacheSize(anyInt());
    doNothing().when(blockChainInfo).setWitnesses(Mockito.<List<WitnessInfo>>any());
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api2);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency2);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");
    MetricsInfo metricsInfo = mock(MetricsInfo.class);
    when(metricsInfo.getInterval()).thenReturn(42L);
    when(metricsInfo.getBlockchain()).thenReturn(blockChainInfo);
    when(metricsInfo.getNet()).thenReturn(netInfo);
    when(metricsInfo.getNode()).thenReturn(nodeInfo);
    doNothing().when(metricsInfo).setBlockchain(Mockito.<BlockChainInfo>any());
    doNothing().when(metricsInfo).setInterval(anyLong());
    doNothing().when(metricsInfo).setNet(Mockito.<NetInfo>any());
    doNothing().when(metricsInfo).setNode(Mockito.<NodeInfo>any());
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(metricsInfo).getBlockchain();
    verify(metricsInfo).getInterval();
    verify(metricsInfo).getNet();
    verify(metricsInfo).getNode();
    verify(metricsInfo).setBlockchain(isA(BlockChainInfo.class));
    verify(metricsInfo).setInterval(eq(42L));
    verify(metricsInfo).setNet(isA(NetInfo.class));
    verify(metricsInfo).setNode(isA(NodeInfo.class));
    verify(blockChainInfo).getBlockProcessTime();
    verify(blockChainInfo).getDupWitness();
    verify(blockChainInfo).getFailForkCount();
    verify(blockChainInfo).getFailProcessBlockNum();
    verify(blockChainInfo).getFailProcessBlockReason();
    verify(blockChainInfo).getForkCount();
    verify(blockChainInfo).getHeadBlockHash();
    verify(blockChainInfo).getHeadBlockNum();
    verify(blockChainInfo).getHeadBlockTimestamp();
    verify(blockChainInfo).getMissedTransaction();
    verify(blockChainInfo).getTps();
    verify(blockChainInfo).getTransactionCacheSize();
    verify(blockChainInfo).getWitnesses();
    verify(blockChainInfo).setBlockProcessTime(isA(RateInfo.class));
    verify(blockChainInfo).setDupWitness(isA(List.class));
    verify(blockChainInfo).setFailForkCount(eq(3));
    verify(blockChainInfo).setFailProcessBlockNum(eq(1L));
    verify(blockChainInfo).setFailProcessBlockReason(eq("Just cause"));
    verify(blockChainInfo).setForkCount(eq(3));
    verify(blockChainInfo).setHeadBlockHash(eq("Head Block Hash"));
    verify(blockChainInfo).setHeadBlockNum(eq(1L));
    verify(blockChainInfo).setHeadBlockTimestamp(eq(1L));
    verify(blockChainInfo).setMissedTransaction(isA(RateInfo.class));
    verify(blockChainInfo).setTps(isA(RateInfo.class));
    verify(blockChainInfo).setTransactionCacheSize(eq(3));
    verify(blockChainInfo).setWitnesses(isA(List.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(2042, response.getByteSize());
    assertEquals(2042, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet6() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");
    BlockChainInfo blockChainInfo = mock(BlockChainInfo.class);
    when(blockChainInfo.getFailForkCount()).thenReturn(3);
    when(blockChainInfo.getForkCount()).thenReturn(3);
    when(blockChainInfo.getTransactionCacheSize()).thenReturn(3);
    when(blockChainInfo.getFailProcessBlockReason()).thenReturn("org.tron.core.metrics.blockchain.BlockChainInfo");
    when(blockChainInfo.getHeadBlockHash()).thenReturn("Head Block Hash");
    when(blockChainInfo.getDupWitness()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getWitnesses()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getFailProcessBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockTimestamp()).thenReturn(1L);
    when(blockChainInfo.getBlockProcessTime()).thenReturn(new RateInfo());
    when(blockChainInfo.getMissedTransaction()).thenReturn(new RateInfo());
    when(blockChainInfo.getTps()).thenReturn(new RateInfo());
    doNothing().when(blockChainInfo).setBlockProcessTime(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setDupWitness(Mockito.<List<DupWitnessInfo>>any());
    doNothing().when(blockChainInfo).setFailForkCount(anyInt());
    doNothing().when(blockChainInfo).setFailProcessBlockNum(anyLong());
    doNothing().when(blockChainInfo).setFailProcessBlockReason(Mockito.<String>any());
    doNothing().when(blockChainInfo).setForkCount(anyInt());
    doNothing().when(blockChainInfo).setHeadBlockHash(Mockito.<String>any());
    doNothing().when(blockChainInfo).setHeadBlockNum(anyLong());
    doNothing().when(blockChainInfo).setHeadBlockTimestamp(anyLong());
    doNothing().when(blockChainInfo).setMissedTransaction(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTps(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTransactionCacheSize(anyInt());
    doNothing().when(blockChainInfo).setWitnesses(Mockito.<List<WitnessInfo>>any());
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api2);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency2);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");
    MetricsInfo metricsInfo = mock(MetricsInfo.class);
    when(metricsInfo.getInterval()).thenReturn(42L);
    when(metricsInfo.getBlockchain()).thenReturn(blockChainInfo);
    when(metricsInfo.getNet()).thenReturn(netInfo);
    when(metricsInfo.getNode()).thenReturn(nodeInfo);
    doNothing().when(metricsInfo).setBlockchain(Mockito.<BlockChainInfo>any());
    doNothing().when(metricsInfo).setInterval(anyLong());
    doNothing().when(metricsInfo).setNet(Mockito.<NetInfo>any());
    doNothing().when(metricsInfo).setNode(Mockito.<NodeInfo>any());
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(metricsInfo).getBlockchain();
    verify(metricsInfo).getInterval();
    verify(metricsInfo).getNet();
    verify(metricsInfo).getNode();
    verify(metricsInfo).setBlockchain(isA(BlockChainInfo.class));
    verify(metricsInfo).setInterval(eq(42L));
    verify(metricsInfo).setNet(isA(NetInfo.class));
    verify(metricsInfo).setNode(isA(NodeInfo.class));
    verify(blockChainInfo).getBlockProcessTime();
    verify(blockChainInfo).getDupWitness();
    verify(blockChainInfo).getFailForkCount();
    verify(blockChainInfo).getFailProcessBlockNum();
    verify(blockChainInfo).getFailProcessBlockReason();
    verify(blockChainInfo).getForkCount();
    verify(blockChainInfo).getHeadBlockHash();
    verify(blockChainInfo).getHeadBlockNum();
    verify(blockChainInfo).getHeadBlockTimestamp();
    verify(blockChainInfo).getMissedTransaction();
    verify(blockChainInfo).getTps();
    verify(blockChainInfo).getTransactionCacheSize();
    verify(blockChainInfo).getWitnesses();
    verify(blockChainInfo).setBlockProcessTime(isA(RateInfo.class));
    verify(blockChainInfo).setDupWitness(isA(List.class));
    verify(blockChainInfo).setFailForkCount(eq(3));
    verify(blockChainInfo).setFailProcessBlockNum(eq(1L));
    verify(blockChainInfo).setFailProcessBlockReason(eq("Just cause"));
    verify(blockChainInfo).setForkCount(eq(3));
    verify(blockChainInfo).setHeadBlockHash(eq("Head Block Hash"));
    verify(blockChainInfo).setHeadBlockNum(eq(1L));
    verify(blockChainInfo).setHeadBlockTimestamp(eq(1L));
    verify(blockChainInfo).setMissedTransaction(isA(RateInfo.class));
    verify(blockChainInfo).setTps(isA(RateInfo.class));
    verify(blockChainInfo).setTransactionCacheSize(eq(3));
    verify(blockChainInfo).setWitnesses(isA(List.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(2069, response.getByteSize());
    assertEquals(2069, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet7() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");

    DupWitnessInfo dupWitnessInfo = new DupWitnessInfo();
    dupWitnessInfo.setAddress("42 Main St");
    dupWitnessInfo.setBlockNum(1L);
    dupWitnessInfo.setCount(3);

    ArrayList<DupWitnessInfo> dupWitnessInfoList = new ArrayList<>();
    dupWitnessInfoList.add(dupWitnessInfo);
    BlockChainInfo blockChainInfo = mock(BlockChainInfo.class);
    when(blockChainInfo.getFailForkCount()).thenReturn(3);
    when(blockChainInfo.getForkCount()).thenReturn(3);
    when(blockChainInfo.getTransactionCacheSize()).thenReturn(3);
    when(blockChainInfo.getFailProcessBlockReason()).thenReturn("Just cause");
    when(blockChainInfo.getHeadBlockHash()).thenReturn("Head Block Hash");
    when(blockChainInfo.getDupWitness()).thenReturn(dupWitnessInfoList);
    when(blockChainInfo.getWitnesses()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getFailProcessBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockTimestamp()).thenReturn(1L);
    when(blockChainInfo.getBlockProcessTime()).thenReturn(new RateInfo());
    when(blockChainInfo.getMissedTransaction()).thenReturn(new RateInfo());
    when(blockChainInfo.getTps()).thenReturn(new RateInfo());
    doNothing().when(blockChainInfo).setBlockProcessTime(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setDupWitness(Mockito.<List<DupWitnessInfo>>any());
    doNothing().when(blockChainInfo).setFailForkCount(anyInt());
    doNothing().when(blockChainInfo).setFailProcessBlockNum(anyLong());
    doNothing().when(blockChainInfo).setFailProcessBlockReason(Mockito.<String>any());
    doNothing().when(blockChainInfo).setForkCount(anyInt());
    doNothing().when(blockChainInfo).setHeadBlockHash(Mockito.<String>any());
    doNothing().when(blockChainInfo).setHeadBlockNum(anyLong());
    doNothing().when(blockChainInfo).setHeadBlockTimestamp(anyLong());
    doNothing().when(blockChainInfo).setMissedTransaction(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTps(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTransactionCacheSize(anyInt());
    doNothing().when(blockChainInfo).setWitnesses(Mockito.<List<WitnessInfo>>any());
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api2);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency2);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");
    MetricsInfo metricsInfo = mock(MetricsInfo.class);
    when(metricsInfo.getInterval()).thenReturn(42L);
    when(metricsInfo.getBlockchain()).thenReturn(blockChainInfo);
    when(metricsInfo.getNet()).thenReturn(netInfo);
    when(metricsInfo.getNode()).thenReturn(nodeInfo);
    doNothing().when(metricsInfo).setBlockchain(Mockito.<BlockChainInfo>any());
    doNothing().when(metricsInfo).setInterval(anyLong());
    doNothing().when(metricsInfo).setNet(Mockito.<NetInfo>any());
    doNothing().when(metricsInfo).setNode(Mockito.<NodeInfo>any());
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(metricsInfo).getBlockchain();
    verify(metricsInfo).getInterval();
    verify(metricsInfo).getNet();
    verify(metricsInfo).getNode();
    verify(metricsInfo).setBlockchain(isA(BlockChainInfo.class));
    verify(metricsInfo).setInterval(eq(42L));
    verify(metricsInfo).setNet(isA(NetInfo.class));
    verify(metricsInfo).setNode(isA(NodeInfo.class));
    verify(blockChainInfo).getBlockProcessTime();
    verify(blockChainInfo).getDupWitness();
    verify(blockChainInfo).getFailForkCount();
    verify(blockChainInfo).getFailProcessBlockNum();
    verify(blockChainInfo).getFailProcessBlockReason();
    verify(blockChainInfo).getForkCount();
    verify(blockChainInfo).getHeadBlockHash();
    verify(blockChainInfo).getHeadBlockNum();
    verify(blockChainInfo).getHeadBlockTimestamp();
    verify(blockChainInfo).getMissedTransaction();
    verify(blockChainInfo).getTps();
    verify(blockChainInfo).getTransactionCacheSize();
    verify(blockChainInfo).getWitnesses();
    verify(blockChainInfo).setBlockProcessTime(isA(RateInfo.class));
    verify(blockChainInfo).setDupWitness(isA(List.class));
    verify(blockChainInfo).setFailForkCount(eq(3));
    verify(blockChainInfo).setFailProcessBlockNum(eq(1L));
    verify(blockChainInfo).setFailProcessBlockReason(eq("Just cause"));
    verify(blockChainInfo).setForkCount(eq(3));
    verify(blockChainInfo).setHeadBlockHash(eq("Head Block Hash"));
    verify(blockChainInfo).setHeadBlockNum(eq(1L));
    verify(blockChainInfo).setHeadBlockTimestamp(eq(1L));
    verify(blockChainInfo).setMissedTransaction(isA(RateInfo.class));
    verify(blockChainInfo).setTps(isA(RateInfo.class));
    verify(blockChainInfo).setTransactionCacheSize(eq(3));
    verify(blockChainInfo).setWitnesses(isA(List.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(2105, response.getByteSize());
    assertEquals(2105, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet8() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");

    DupWitnessInfo dupWitnessInfo = new DupWitnessInfo();
    dupWitnessInfo.setAddress("42 Main St");
    dupWitnessInfo.setBlockNum(1L);
    dupWitnessInfo.setCount(3);

    DupWitnessInfo dupWitnessInfo2 = new DupWitnessInfo();
    dupWitnessInfo2.setAddress("17 High St");
    dupWitnessInfo2.setBlockNum(1L);
    dupWitnessInfo2.setCount(4096);

    ArrayList<DupWitnessInfo> dupWitnessInfoList = new ArrayList<>();
    dupWitnessInfoList.add(dupWitnessInfo2);
    dupWitnessInfoList.add(dupWitnessInfo);
    BlockChainInfo blockChainInfo = mock(BlockChainInfo.class);
    when(blockChainInfo.getFailForkCount()).thenReturn(3);
    when(blockChainInfo.getForkCount()).thenReturn(3);
    when(blockChainInfo.getTransactionCacheSize()).thenReturn(3);
    when(blockChainInfo.getFailProcessBlockReason()).thenReturn("Just cause");
    when(blockChainInfo.getHeadBlockHash()).thenReturn("Head Block Hash");
    when(blockChainInfo.getDupWitness()).thenReturn(dupWitnessInfoList);
    when(blockChainInfo.getWitnesses()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getFailProcessBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockTimestamp()).thenReturn(1L);
    when(blockChainInfo.getBlockProcessTime()).thenReturn(new RateInfo());
    when(blockChainInfo.getMissedTransaction()).thenReturn(new RateInfo());
    when(blockChainInfo.getTps()).thenReturn(new RateInfo());
    doNothing().when(blockChainInfo).setBlockProcessTime(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setDupWitness(Mockito.<List<DupWitnessInfo>>any());
    doNothing().when(blockChainInfo).setFailForkCount(anyInt());
    doNothing().when(blockChainInfo).setFailProcessBlockNum(anyLong());
    doNothing().when(blockChainInfo).setFailProcessBlockReason(Mockito.<String>any());
    doNothing().when(blockChainInfo).setForkCount(anyInt());
    doNothing().when(blockChainInfo).setHeadBlockHash(Mockito.<String>any());
    doNothing().when(blockChainInfo).setHeadBlockNum(anyLong());
    doNothing().when(blockChainInfo).setHeadBlockTimestamp(anyLong());
    doNothing().when(blockChainInfo).setMissedTransaction(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTps(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTransactionCacheSize(anyInt());
    doNothing().when(blockChainInfo).setWitnesses(Mockito.<List<WitnessInfo>>any());
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api2);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency2);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");
    MetricsInfo metricsInfo = mock(MetricsInfo.class);
    when(metricsInfo.getInterval()).thenReturn(42L);
    when(metricsInfo.getBlockchain()).thenReturn(blockChainInfo);
    when(metricsInfo.getNet()).thenReturn(netInfo);
    when(metricsInfo.getNode()).thenReturn(nodeInfo);
    doNothing().when(metricsInfo).setBlockchain(Mockito.<BlockChainInfo>any());
    doNothing().when(metricsInfo).setInterval(anyLong());
    doNothing().when(metricsInfo).setNet(Mockito.<NetInfo>any());
    doNothing().when(metricsInfo).setNode(Mockito.<NodeInfo>any());
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(metricsInfo).getBlockchain();
    verify(metricsInfo).getInterval();
    verify(metricsInfo).getNet();
    verify(metricsInfo).getNode();
    verify(metricsInfo).setBlockchain(isA(BlockChainInfo.class));
    verify(metricsInfo).setInterval(eq(42L));
    verify(metricsInfo).setNet(isA(NetInfo.class));
    verify(metricsInfo).setNode(isA(NodeInfo.class));
    verify(blockChainInfo).getBlockProcessTime();
    verify(blockChainInfo).getDupWitness();
    verify(blockChainInfo).getFailForkCount();
    verify(blockChainInfo).getFailProcessBlockNum();
    verify(blockChainInfo).getFailProcessBlockReason();
    verify(blockChainInfo).getForkCount();
    verify(blockChainInfo).getHeadBlockHash();
    verify(blockChainInfo).getHeadBlockNum();
    verify(blockChainInfo).getHeadBlockTimestamp();
    verify(blockChainInfo).getMissedTransaction();
    verify(blockChainInfo).getTps();
    verify(blockChainInfo).getTransactionCacheSize();
    verify(blockChainInfo).getWitnesses();
    verify(blockChainInfo).setBlockProcessTime(isA(RateInfo.class));
    verify(blockChainInfo).setDupWitness(isA(List.class));
    verify(blockChainInfo).setFailForkCount(eq(3));
    verify(blockChainInfo).setFailProcessBlockNum(eq(1L));
    verify(blockChainInfo).setFailProcessBlockReason(eq("Just cause"));
    verify(blockChainInfo).setForkCount(eq(3));
    verify(blockChainInfo).setHeadBlockHash(eq("Head Block Hash"));
    verify(blockChainInfo).setHeadBlockNum(eq(1L));
    verify(blockChainInfo).setHeadBlockTimestamp(eq(1L));
    verify(blockChainInfo).setMissedTransaction(isA(RateInfo.class));
    verify(blockChainInfo).setTps(isA(RateInfo.class));
    verify(blockChainInfo).setTransactionCacheSize(eq(3));
    verify(blockChainInfo).setWitnesses(isA(List.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(2179, response.getByteSize());
    assertEquals(2179, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet9() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");

    ArrayList<WitnessInfo> witnessInfoList = new ArrayList<>();
    witnessInfoList.add(new WitnessInfo("42 Main St", 1));
    BlockChainInfo blockChainInfo = mock(BlockChainInfo.class);
    when(blockChainInfo.getFailForkCount()).thenReturn(3);
    when(blockChainInfo.getForkCount()).thenReturn(3);
    when(blockChainInfo.getTransactionCacheSize()).thenReturn(3);
    when(blockChainInfo.getFailProcessBlockReason()).thenReturn("Just cause");
    when(blockChainInfo.getHeadBlockHash()).thenReturn("Head Block Hash");
    when(blockChainInfo.getDupWitness()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getWitnesses()).thenReturn(witnessInfoList);
    when(blockChainInfo.getFailProcessBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockTimestamp()).thenReturn(1L);
    when(blockChainInfo.getBlockProcessTime()).thenReturn(new RateInfo());
    when(blockChainInfo.getMissedTransaction()).thenReturn(new RateInfo());
    when(blockChainInfo.getTps()).thenReturn(new RateInfo());
    doNothing().when(blockChainInfo).setBlockProcessTime(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setDupWitness(Mockito.<List<DupWitnessInfo>>any());
    doNothing().when(blockChainInfo).setFailForkCount(anyInt());
    doNothing().when(blockChainInfo).setFailProcessBlockNum(anyLong());
    doNothing().when(blockChainInfo).setFailProcessBlockReason(Mockito.<String>any());
    doNothing().when(blockChainInfo).setForkCount(anyInt());
    doNothing().when(blockChainInfo).setHeadBlockHash(Mockito.<String>any());
    doNothing().when(blockChainInfo).setHeadBlockNum(anyLong());
    doNothing().when(blockChainInfo).setHeadBlockTimestamp(anyLong());
    doNothing().when(blockChainInfo).setMissedTransaction(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTps(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTransactionCacheSize(anyInt());
    doNothing().when(blockChainInfo).setWitnesses(Mockito.<List<WitnessInfo>>any());
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api2);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency2);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");
    MetricsInfo metricsInfo = mock(MetricsInfo.class);
    when(metricsInfo.getInterval()).thenReturn(42L);
    when(metricsInfo.getBlockchain()).thenReturn(blockChainInfo);
    when(metricsInfo.getNet()).thenReturn(netInfo);
    when(metricsInfo.getNode()).thenReturn(nodeInfo);
    doNothing().when(metricsInfo).setBlockchain(Mockito.<BlockChainInfo>any());
    doNothing().when(metricsInfo).setInterval(anyLong());
    doNothing().when(metricsInfo).setNet(Mockito.<NetInfo>any());
    doNothing().when(metricsInfo).setNode(Mockito.<NodeInfo>any());
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(metricsInfo).getBlockchain();
    verify(metricsInfo).getInterval();
    verify(metricsInfo).getNet();
    verify(metricsInfo).getNode();
    verify(metricsInfo).setBlockchain(isA(BlockChainInfo.class));
    verify(metricsInfo).setInterval(eq(42L));
    verify(metricsInfo).setNet(isA(NetInfo.class));
    verify(metricsInfo).setNode(isA(NodeInfo.class));
    verify(blockChainInfo).getBlockProcessTime();
    verify(blockChainInfo).getDupWitness();
    verify(blockChainInfo).getFailForkCount();
    verify(blockChainInfo).getFailProcessBlockNum();
    verify(blockChainInfo).getFailProcessBlockReason();
    verify(blockChainInfo).getForkCount();
    verify(blockChainInfo).getHeadBlockHash();
    verify(blockChainInfo).getHeadBlockNum();
    verify(blockChainInfo).getHeadBlockTimestamp();
    verify(blockChainInfo).getMissedTransaction();
    verify(blockChainInfo).getTps();
    verify(blockChainInfo).getTransactionCacheSize();
    verify(blockChainInfo).getWitnesses();
    verify(blockChainInfo).setBlockProcessTime(isA(RateInfo.class));
    verify(blockChainInfo).setDupWitness(isA(List.class));
    verify(blockChainInfo).setFailForkCount(eq(3));
    verify(blockChainInfo).setFailProcessBlockNum(eq(1L));
    verify(blockChainInfo).setFailProcessBlockReason(eq("Just cause"));
    verify(blockChainInfo).setForkCount(eq(3));
    verify(blockChainInfo).setHeadBlockHash(eq("Head Block Hash"));
    verify(blockChainInfo).setHeadBlockNum(eq(1L));
    verify(blockChainInfo).setHeadBlockTimestamp(eq(1L));
    verify(blockChainInfo).setMissedTransaction(isA(RateInfo.class));
    verify(blockChainInfo).setTps(isA(RateInfo.class));
    verify(blockChainInfo).setTransactionCacheSize(eq(3));
    verify(blockChainInfo).setWitnesses(isA(List.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(2089, response.getByteSize());
    assertEquals(2089, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet10() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");
    BlockChainInfo blockChainInfo = mock(BlockChainInfo.class);
    when(blockChainInfo.getFailForkCount()).thenReturn(3);
    when(blockChainInfo.getForkCount()).thenReturn(3);
    when(blockChainInfo.getTransactionCacheSize()).thenReturn(3);
    when(blockChainInfo.getFailProcessBlockReason()).thenReturn("Just cause");
    when(blockChainInfo.getHeadBlockHash()).thenReturn("Head Block Hash");
    when(blockChainInfo.getDupWitness()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getWitnesses()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getFailProcessBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockTimestamp()).thenReturn(1L);
    when(blockChainInfo.getBlockProcessTime()).thenReturn(null);
    when(blockChainInfo.getMissedTransaction()).thenReturn(new RateInfo());
    when(blockChainInfo.getTps()).thenReturn(new RateInfo());
    doNothing().when(blockChainInfo).setBlockProcessTime(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setDupWitness(Mockito.<List<DupWitnessInfo>>any());
    doNothing().when(blockChainInfo).setFailForkCount(anyInt());
    doNothing().when(blockChainInfo).setFailProcessBlockNum(anyLong());
    doNothing().when(blockChainInfo).setFailProcessBlockReason(Mockito.<String>any());
    doNothing().when(blockChainInfo).setForkCount(anyInt());
    doNothing().when(blockChainInfo).setHeadBlockHash(Mockito.<String>any());
    doNothing().when(blockChainInfo).setHeadBlockNum(anyLong());
    doNothing().when(blockChainInfo).setHeadBlockTimestamp(anyLong());
    doNothing().when(blockChainInfo).setMissedTransaction(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTps(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTransactionCacheSize(anyInt());
    doNothing().when(blockChainInfo).setWitnesses(Mockito.<List<WitnessInfo>>any());
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api2);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency2);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");
    MetricsInfo metricsInfo = mock(MetricsInfo.class);
    when(metricsInfo.getInterval()).thenReturn(42L);
    when(metricsInfo.getBlockchain()).thenReturn(blockChainInfo);
    when(metricsInfo.getNet()).thenReturn(netInfo);
    when(metricsInfo.getNode()).thenReturn(nodeInfo);
    doNothing().when(metricsInfo).setBlockchain(Mockito.<BlockChainInfo>any());
    doNothing().when(metricsInfo).setInterval(anyLong());
    doNothing().when(metricsInfo).setNet(Mockito.<NetInfo>any());
    doNothing().when(metricsInfo).setNode(Mockito.<NodeInfo>any());
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(metricsInfo).getBlockchain();
    verify(metricsInfo).getInterval();
    verify(metricsInfo).getNet();
    verify(metricsInfo).getNode();
    verify(metricsInfo).setBlockchain(isA(BlockChainInfo.class));
    verify(metricsInfo).setInterval(eq(42L));
    verify(metricsInfo).setNet(isA(NetInfo.class));
    verify(metricsInfo).setNode(isA(NodeInfo.class));
    verify(blockChainInfo).getBlockProcessTime();
    verify(blockChainInfo).getDupWitness();
    verify(blockChainInfo).getFailForkCount();
    verify(blockChainInfo).getFailProcessBlockNum();
    verify(blockChainInfo).getFailProcessBlockReason();
    verify(blockChainInfo).getForkCount();
    verify(blockChainInfo).getHeadBlockHash();
    verify(blockChainInfo).getHeadBlockNum();
    verify(blockChainInfo).getHeadBlockTimestamp();
    verify(blockChainInfo).getMissedTransaction();
    verify(blockChainInfo).getTps();
    verify(blockChainInfo).getTransactionCacheSize();
    verify(blockChainInfo).getWitnesses();
    verify(blockChainInfo).setBlockProcessTime(isA(RateInfo.class));
    verify(blockChainInfo).setDupWitness(isA(List.class));
    verify(blockChainInfo).setFailForkCount(eq(3));
    verify(blockChainInfo).setFailProcessBlockNum(eq(1L));
    verify(blockChainInfo).setFailProcessBlockReason(eq("Just cause"));
    verify(blockChainInfo).setForkCount(eq(3));
    verify(blockChainInfo).setHeadBlockHash(eq("Head Block Hash"));
    verify(blockChainInfo).setHeadBlockNum(eq(1L));
    verify(blockChainInfo).setHeadBlockTimestamp(eq(1L));
    verify(blockChainInfo).setMissedTransaction(isA(RateInfo.class));
    verify(blockChainInfo).setTps(isA(RateInfo.class));
    verify(blockChainInfo).setTransactionCacheSize(eq(3));
    verify(blockChainInfo).setWitnesses(isA(List.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(1895, response.getByteSize());
    assertEquals(1895, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet11() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");
    BlockChainInfo blockChainInfo = mock(BlockChainInfo.class);
    when(blockChainInfo.getFailForkCount()).thenReturn(3);
    when(blockChainInfo.getForkCount()).thenReturn(3);
    when(blockChainInfo.getTransactionCacheSize()).thenReturn(3);
    when(blockChainInfo.getFailProcessBlockReason()).thenReturn("Just cause");
    when(blockChainInfo.getHeadBlockHash()).thenReturn("Head Block Hash");
    when(blockChainInfo.getDupWitness()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getWitnesses()).thenReturn(new ArrayList<>());
    when(blockChainInfo.getFailProcessBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockNum()).thenReturn(1L);
    when(blockChainInfo.getHeadBlockTimestamp()).thenReturn(1L);
    when(blockChainInfo.getBlockProcessTime()).thenReturn(new RateInfo());
    when(blockChainInfo.getMissedTransaction()).thenReturn(new RateInfo());
    when(blockChainInfo.getTps()).thenReturn(new RateInfo());
    doNothing().when(blockChainInfo).setBlockProcessTime(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setDupWitness(Mockito.<List<DupWitnessInfo>>any());
    doNothing().when(blockChainInfo).setFailForkCount(anyInt());
    doNothing().when(blockChainInfo).setFailProcessBlockNum(anyLong());
    doNothing().when(blockChainInfo).setFailProcessBlockReason(Mockito.<String>any());
    doNothing().when(blockChainInfo).setForkCount(anyInt());
    doNothing().when(blockChainInfo).setHeadBlockHash(Mockito.<String>any());
    doNothing().when(blockChainInfo).setHeadBlockNum(anyLong());
    doNothing().when(blockChainInfo).setHeadBlockTimestamp(anyLong());
    doNothing().when(blockChainInfo).setMissedTransaction(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTps(Mockito.<RateInfo>any());
    doNothing().when(blockChainInfo).setTransactionCacheSize(anyInt());
    doNothing().when(blockChainInfo).setWitnesses(Mockito.<List<WitnessInfo>>any());
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api2);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency2);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);
    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getBackupStatus()).thenReturn(1);
    when(nodeInfo.getNodeType()).thenReturn(1);
    when(nodeInfo.getIp()).thenReturn("org.tron.core.metrics.node.NodeInfo");
    when(nodeInfo.getVersion()).thenReturn("1.0.2");
    doNothing().when(nodeInfo).setBackupStatus(anyInt());
    doNothing().when(nodeInfo).setIp(Mockito.<String>any());
    doNothing().when(nodeInfo).setNodeType(anyInt());
    doNothing().when(nodeInfo).setVersion(Mockito.<String>any());
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");
    MetricsInfo metricsInfo = mock(MetricsInfo.class);
    when(metricsInfo.getInterval()).thenReturn(42L);
    when(metricsInfo.getBlockchain()).thenReturn(blockChainInfo);
    when(metricsInfo.getNet()).thenReturn(netInfo);
    when(metricsInfo.getNode()).thenReturn(nodeInfo);
    doNothing().when(metricsInfo).setBlockchain(Mockito.<BlockChainInfo>any());
    doNothing().when(metricsInfo).setInterval(anyLong());
    doNothing().when(metricsInfo).setNet(Mockito.<NetInfo>any());
    doNothing().when(metricsInfo).setNode(Mockito.<NodeInfo>any());
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(metricsInfo).getBlockchain();
    verify(metricsInfo).getInterval();
    verify(metricsInfo).getNet();
    verify(metricsInfo).getNode();
    verify(metricsInfo).setBlockchain(isA(BlockChainInfo.class));
    verify(metricsInfo).setInterval(eq(42L));
    verify(metricsInfo).setNet(isA(NetInfo.class));
    verify(metricsInfo).setNode(isA(NodeInfo.class));
    verify(blockChainInfo).getBlockProcessTime();
    verify(blockChainInfo).getDupWitness();
    verify(blockChainInfo).getFailForkCount();
    verify(blockChainInfo).getFailProcessBlockNum();
    verify(blockChainInfo).getFailProcessBlockReason();
    verify(blockChainInfo).getForkCount();
    verify(blockChainInfo).getHeadBlockHash();
    verify(blockChainInfo).getHeadBlockNum();
    verify(blockChainInfo).getHeadBlockTimestamp();
    verify(blockChainInfo).getMissedTransaction();
    verify(blockChainInfo).getTps();
    verify(blockChainInfo).getTransactionCacheSize();
    verify(blockChainInfo).getWitnesses();
    verify(blockChainInfo).setBlockProcessTime(isA(RateInfo.class));
    verify(blockChainInfo).setDupWitness(isA(List.class));
    verify(blockChainInfo).setFailForkCount(eq(3));
    verify(blockChainInfo).setFailProcessBlockNum(eq(1L));
    verify(blockChainInfo).setFailProcessBlockReason(eq("Just cause"));
    verify(blockChainInfo).setForkCount(eq(3));
    verify(blockChainInfo).setHeadBlockHash(eq("Head Block Hash"));
    verify(blockChainInfo).setHeadBlockNum(eq(1L));
    verify(blockChainInfo).setHeadBlockTimestamp(eq(1L));
    verify(blockChainInfo).setMissedTransaction(isA(RateInfo.class));
    verify(blockChainInfo).setTps(isA(RateInfo.class));
    verify(blockChainInfo).setTransactionCacheSize(eq(3));
    verify(blockChainInfo).setWitnesses(isA(List.class));
    verify(nodeInfo).getBackupStatus();
    verify(nodeInfo).getIp();
    verify(nodeInfo).getNodeType();
    verify(nodeInfo).getVersion();
    verify(nodeInfo).setBackupStatus(eq(1));
    verify(nodeInfo).setNodeType(eq(1));
    verify(nodeInfo).setVersion(eq("1.0.2"));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("{\n" + "\t\"blockchain\":{\n" + "\t\t\"blockProcessTime\":{\n" + "\t\t\t\"count\":0,\n"
        + "\t\t\t\"fifteenMinuteRate\":0.0,\n" + "\t\t\t\"fiveMinuteRate\":0.0,\n" + "\t\t\t\"meanRate\":0.0,\n"
        + "\t\t\t\"oneMinuteRate\":0.0\n" + "\t\t},\n" + "\t\t\"dupWitness\":[],\n" + "\t\t\"failForkCount\":3,\n"
        + "\t\t\"failProcessBlockNum\":1,\n" + "\t\t\"failProcessBlockReason\":\"Just cause\",\n"
        + "\t\t\"forkCount\":3,\n" + "\t\t\"headBlockHash\":\"Head Block Hash\",\n" + "\t\t\"headBlockNum\":1,\n"
        + "\t\t\"headBlockTimestamp\":1,\n" + "\t\t\"missedTransaction\":{\n" + "\t\t\t\"count\":0,\n"
        + "\t\t\t\"fifteenMinuteRate\":0.0,\n" + "\t\t\t\"fiveMinuteRate\":0.0,\n" + "\t\t\t\"meanRate\":0.0,\n"
        + "\t\t\t\"oneMinuteRate\":0.0\n" + "\t\t},\n" + "\t\t\"tps\":{\n" + "\t\t\t\"count\":0,\n"
        + "\t\t\t\"fifteenMinuteRate\":0.0,\n" + "\t\t\t\"fiveMinuteRate\":0.0,\n" + "\t\t\t\"meanRate\":0.0,\n"
        + "\t\t\t\"oneMinuteRate\":0.0\n" + "\t\t},\n" + "\t\t\"transactionCacheSize\":3,\n" + "\t\t\"witnesses\":[]\n"
        + "\t},\n" + "\t\"interval\":42,\n" + "\t\"net\":{\n" + "\t\t\"api\":{\n" + "\t\t\t\"detail\":[],\n"
        + "\t\t\t\"failQps\":{\n" + "\t\t\t\t\"count\":0,\n" + "\t\t\t\t\"fifteenMinuteRate\":0.0,\n"
        + "\t\t\t\t\"fiveMinuteRate\":0.0,\n" + "\t\t\t\t\"meanRate\":0.0,\n" + "\t\t\t\t\"oneMinuteRate\":0.0\n"
        + "\t\t\t},\n" + "\t\t\t\"outTraffic\":{\n" + "\t\t\t\t\"count\":0,\n" + "\t\t\t\t\"fifteenMinuteRate\":0.0,\n"
        + "\t\t\t\t\"fiveMinuteRate\":0.0,\n" + "\t\t\t\t\"meanRate\":0.0,\n" + "\t\t\t\t\"oneMinuteRate\":0.0\n"
        + "\t\t\t},\n" + "\t\t\t\"qps\":{\n" + "\t\t\t\t\"count\":0,\n" + "\t\t\t\t\"fifteenMinuteRate\":0.0,\n"
        + "\t\t\t\t\"fiveMinuteRate\":0.0,\n" + "\t\t\t\t\"meanRate\":0.0,\n" + "\t\t\t\t\"oneMinuteRate\":0.0\n"
        + "\t\t\t}\n" + "\t\t},\n" + "\t\t\"connectionCount\":3,\n" + "\t\t\"disconnectionCount\":3,\n"
        + "\t\t\"disconnectionDetail\":[],\n" + "\t\t\"errorProtoCount\":0,\n" + "\t\t\"latency\":{\n"
        + "\t\t\t\"delay1S\":1,\n" + "\t\t\t\"delay2S\":1,\n" + "\t\t\t\"delay3S\":1,\n" + "\t\t\t\"detail\":[],\n"
        + "\t\t\t\"top75\":1,\n" + "\t\t\t\"top95\":1,\n" + "\t\t\t\"top99\":1,\n" + "\t\t\t\"totalCount\":3\n"
        + "\t\t},\n" + "\t\t\"tcpInTraffic\":{\n" + "\t\t\t\"count\":0,\n" + "\t\t\t\"fifteenMinuteRate\":0.0,\n"
        + "\t\t\t\"fiveMinuteRate\":0.0,\n" + "\t\t\t\"meanRate\":0.0,\n" + "\t\t\t\"oneMinuteRate\":0.0\n" + "\t\t},\n"
        + "\t\t\"tcpOutTraffic\":{\n" + "\t\t\t\"count\":0,\n" + "\t\t\t\"fifteenMinuteRate\":0.0,\n"
        + "\t\t\t\"fiveMinuteRate\":0.0,\n" + "\t\t\t\"meanRate\":0.0,\n" + "\t\t\t\"oneMinuteRate\":0.0\n" + "\t\t},\n"
        + "\t\t\"udpInTraffic\":{\n" + "\t\t\t\"count\":0,\n" + "\t\t\t\"fifteenMinuteRate\":0.0,\n"
        + "\t\t\t\"fiveMinuteRate\":0.0,\n" + "\t\t\t\"meanRate\":0.0,\n" + "\t\t\t\"oneMinuteRate\":0.0\n" + "\t\t},\n"
        + "\t\t\"udpOutTraffic\":{\n" + "\t\t\t\"count\":0,\n" + "\t\t\t\"fifteenMinuteRate\":0.0,\n"
        + "\t\t\t\"fiveMinuteRate\":0.0,\n" + "\t\t\t\"meanRate\":0.0,\n" + "\t\t\t\"oneMinuteRate\":0.0\n" + "\t\t},\n"
        + "\t\t\"validConnectionCount\":1\n" + "\t},\n" + "\t\"node\":{\n" + "\t\t\"backupStatus\":1,\n"
        + "\t\t\"ip\":\"org.tron.core.metrics.node.NodeInfo\",\n" + "\t\t\"nodeType\":1,\n"
        + "\t\t\"version\":\"1.0.2\"\n" + "\t}\n" + "}\n", ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(2058, response.getByteSize());
    assertEquals(2058, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link MetricsInfo} (default constructor) Blockchain is {@link BlockChainInfo} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenMetricsInfoBlockchainIsBlockChainInfo() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");

    MetricsInfo metricsInfo = new MetricsInfo();
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(2032, response.getByteSize());
    assertEquals(2032, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link MetricsInfo} {@link MetricsInfo#getInterval()} return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenMetricsInfoGetIntervalReturnMinusOne() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(new RateInfo());
    blockchain.setDupWitness(new ArrayList<>());
    blockchain.setFailForkCount(3);
    blockchain.setFailProcessBlockNum(1L);
    blockchain.setFailProcessBlockReason("Just cause");
    blockchain.setForkCount(3);
    blockchain.setHeadBlockHash("Head Block Hash");
    blockchain.setHeadBlockNum(1L);
    blockchain.setHeadBlockTimestamp(1L);
    blockchain.setMissedTransaction(new RateInfo());
    blockchain.setTps(new RateInfo());
    blockchain.setTransactionCacheSize(3);
    blockchain.setWitnesses(new ArrayList<>());

    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo net = new NetInfo();
    net.setApi(api);
    net.setConnectionCount(3);
    net.setDisconnectionCount(3);
    net.setDisconnectionDetail(new ArrayList<>());
    net.setLatency(latency);
    net.setTcpInTraffic(new RateInfo());
    net.setTcpOutTraffic(new RateInfo());
    net.setUdpInTraffic(new RateInfo());
    net.setUdpOutTraffic(new RateInfo());
    net.setValidConnectionCount(1);

    NodeInfo node = new NodeInfo();
    node.setBackupStatus(1);
    node.setIp("127.0.0.1");
    node.setNodeType(1);
    node.setVersion("1.0.2");

    BlockChainInfo blockChainInfo = new BlockChainInfo();
    blockChainInfo.setBlockProcessTime(new RateInfo());
    blockChainInfo.setDupWitness(new ArrayList<>());
    blockChainInfo.setFailForkCount(3);
    blockChainInfo.setFailProcessBlockNum(1L);
    blockChainInfo.setFailProcessBlockReason("Just cause");
    blockChainInfo.setForkCount(3);
    blockChainInfo.setHeadBlockHash("Head Block Hash");
    blockChainInfo.setHeadBlockNum(1L);
    blockChainInfo.setHeadBlockTimestamp(1L);
    blockChainInfo.setMissedTransaction(new RateInfo());
    blockChainInfo.setTps(new RateInfo());
    blockChainInfo.setTransactionCacheSize(3);
    blockChainInfo.setWitnesses(new ArrayList<>());

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api2);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency2);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setBackupStatus(1);
    nodeInfo.setIp("127.0.0.1");
    nodeInfo.setNodeType(1);
    nodeInfo.setVersion("1.0.2");
    MetricsInfo metricsInfo = mock(MetricsInfo.class);
    when(metricsInfo.getInterval()).thenReturn(-1L);
    when(metricsInfo.getBlockchain()).thenReturn(blockChainInfo);
    when(metricsInfo.getNet()).thenReturn(netInfo);
    when(metricsInfo.getNode()).thenReturn(nodeInfo);
    doNothing().when(metricsInfo).setBlockchain(Mockito.<BlockChainInfo>any());
    doNothing().when(metricsInfo).setInterval(anyLong());
    doNothing().when(metricsInfo).setNet(Mockito.<NetInfo>any());
    doNothing().when(metricsInfo).setNode(Mockito.<NodeInfo>any());
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(metricsInfo).getBlockchain();
    verify(metricsInfo).getInterval();
    verify(metricsInfo).getNet();
    verify(metricsInfo).getNode();
    verify(metricsInfo).setBlockchain(isA(BlockChainInfo.class));
    verify(metricsInfo).setInterval(eq(42L));
    verify(metricsInfo).setNet(isA(NetInfo.class));
    verify(metricsInfo).setNode(isA(NodeInfo.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(2032, response.getByteSize());
    assertEquals(2032, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }
}
