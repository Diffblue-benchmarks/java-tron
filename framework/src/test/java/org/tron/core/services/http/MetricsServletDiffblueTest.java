package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.core.metrics.MetricsApiService;
import org.tron.core.metrics.MetricsInfo;
import org.tron.core.metrics.blockchain.BlockChainInfo;
import org.tron.core.metrics.net.ApiInfo;
import org.tron.core.metrics.net.LatencyInfo;
import org.tron.core.metrics.net.NetInfo;
import org.tron.core.metrics.net.RateInfo;
import org.tron.core.metrics.node.NodeInfo;

@RunWith(MockitoJUnitRunner.class)
public class MetricsServletDiffblueTest {
  @Mock private MetricsApiService metricsApiService;

  @InjectMocks private MetricsServlet metricsServlet;

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    MetricsServlet metricsServlet = new MetricsServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link BlockChainInfo} (default constructor) BlockProcessTime is {@code null}.
   *   <li>Then array length is {@code 1895}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenBlockChainInfoBlockProcessTimeIsNull_thenArrayLengthIs1895() {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(null);
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
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    assertEquals(1895, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link BlockChainInfo} (default constructor) BlockProcessTime is {@link RateInfo}
   *       (default constructor).
   *   <li>Then array length is {@code 2032}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenBlockChainInfoBlockProcessTimeIsRateInfo_thenArrayLengthIs2032() {
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
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    assertEquals(2032, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is a string.
   * </ul>
   *
   * <p>Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsAString()
      throws UnsupportedEncodingException {
    // Arrange
    RateInfo blockProcessTime = mock(RateInfo.class);
    when(blockProcessTime.getCount()).thenThrow(new RuntimeException());

    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(blockProcessTime);
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
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(blockProcessTime).getCount();
    assertEquals(
        "{\"Error\":\"class com.alibaba.fastjson.JSONException : write javaBean error, fastjson version 1.2.83,"
            + " class org.tron.core.metrics.MetricsInfo, write javaBean error, fastjson version 1.2.83, class"
            + " org.tron.core.metrics.blockchain.BlockChainInfo, fieldName : blockchain, write javaBean error, fastjson"
            + " version 1.2.83, class org.tron.core.metrics.net.RateInfo, fieldName : blockProcessTime\"}\n",
        response.getContentAsString());
    assertEquals(387, response.getContentAsByteArray().length);
  }
}
