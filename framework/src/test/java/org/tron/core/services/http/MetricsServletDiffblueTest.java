package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.io.ByteArrayEndPoint;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnection;
import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.LocalConnector;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.ResponseWriter;
import org.eclipse.jetty.server.Server;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.common.utils.client.utils.HttpMethed;
import org.tron.core.metrics.MetricsApiService;
import org.tron.core.metrics.MetricsInfo;
import org.tron.core.metrics.blockchain.BlockChainInfo;
import org.tron.core.metrics.net.ApiInfo;
import org.tron.core.metrics.net.LatencyInfo;
import org.tron.core.metrics.net.NetInfo;
import org.tron.core.metrics.net.RateInfo;
import org.tron.core.metrics.node.NodeInfo;
import org.tron.core.services.filter.CharResponseWrapper;

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

    MetricsInfo metricsInfo = new MetricsInfo();
    metricsInfo.setBlockchain(blockchain);
    metricsInfo.setInterval(42L);
    metricsInfo.setNet(net);
    metricsInfo.setNode(node);
    when(metricsApiService.getMetricsInfo()).thenReturn(metricsInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(2032, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(2032, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet2() throws IOException {
    // Arrange
    when(metricsApiService.getMetricsInfo()).thenThrow(new RuntimeException());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(52, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet3() throws IOException {
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
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(1895, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(1895, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet4() throws IOException {
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
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(blockProcessTime).getCount();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class com.alibaba.fastjson.JSONException : write javaBean error, fastjson version 1.2.83,"
            + " class org.tron.core.metrics.MetricsInfo, write javaBean error, fastjson version 1.2.83, class"
            + " org.tron.core.metrics.blockchain.BlockChainInfo, fieldName : blockchain, write javaBean error, fastjson"
            + " version 1.2.83, class org.tron.core.metrics.net.RateInfo, fieldName : blockProcessTime\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(387, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(387, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet5() throws IOException {
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
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());

    HttpConnection transport =
        new HttpConnection(
            config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true);

    HttpChannel channel = new HttpChannel(connector, configuration, endPoint, transport);
    LocalConnector connector3 = new LocalConnector(new Server());
    HttpConfiguration configuration2 = new HttpConfiguration();
    ByteArrayEndPoint endPoint2 = new ByteArrayEndPoint();
    HttpConfiguration config2 = new HttpConfiguration();
    LocalConnector connector4 = new LocalConnector(new Server());

    HttpConnection transport2 =
        new HttpConnection(
            config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true);

    HttpChannel channel2 = new HttpChannel(connector3, configuration2, endPoint2, transport2);
    Response response = new Response(channel, new HttpOutput(channel2));
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);

    // Act
    metricsServlet.doGet(request, response2);

    // Assert
    verify(metricsApiService).getMetricsInfo();
    verify(blockProcessTime).getCount();
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(387L, httpOutput.getWritten());
    assertEquals(387L, ((Response) response3).getContentCount());
    assertFalse(httpOutput.isAsync());
    assertFalse(httpOutput.isClosed());
    assertFalse(((Response) response3).isStreaming());
    assertTrue(httpOutput.isWritten());
    assertTrue(((Response) response3).isWriting());
    assertSame(channel2, httpOutput.getHttpChannel());
    assertSame(channel2, httpOutput.getInterceptor());
    assertSame(writer, response3.getWriter());
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet6() throws IOException {
    // Arrange
    MetricsServlet metricsServlet = new MetricsServlet();

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());

    HttpConnection transport =
        new HttpConnection(
            config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true);

    HttpChannel channel = new HttpChannel(connector, configuration, endPoint, transport);
    LocalConnector connector3 = new LocalConnector(new Server());
    HttpConfiguration configuration2 = new HttpConfiguration();
    ByteArrayEndPoint endPoint2 = new ByteArrayEndPoint();
    HttpConfiguration config2 = new HttpConfiguration();
    LocalConnector connector4 = new LocalConnector(new Server());

    HttpConnection transport2 =
        new HttpConnection(
            config2, connector4, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true);

    HttpChannel channel2 = new HttpChannel(connector3, configuration2, endPoint2, transport2);
    Response response = new Response(channel, new HttpOutput(channel2));
    HttpServletResponseWrapper response2 = new HttpServletResponseWrapper(response);

    // Act
    metricsServlet.doGet(request, response2);

    // Assert
    verify(request).addParameter("https://example.org/example", "https://example.org/example");
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(56L, httpOutput.getWritten());
    assertEquals(56L, ((Response) response3).getContentCount());
    assertFalse(httpOutput.isAsync());
    assertFalse(httpOutput.isClosed());
    assertFalse(((Response) response3).isStreaming());
    assertTrue(httpOutput.isWritten());
    assertTrue(((Response) response3).isWriting());
    assertSame(channel2, httpOutput.getHttpChannel());
    assertSame(channel2, httpOutput.getInterceptor());
    assertSame(writer, response3.getWriter());
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link PrintWriter#PrintWriter(Writer)} with {@link
   *       SerializeWriter#SerializeWriter()}.
   *   <li>Then calls {@link Response#getWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenPrintWriterWithSerializeWriter_thenCallsGetWriter()
      throws IOException {
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
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    Response response = mock(Response.class);
    when(response.getWriter()).thenReturn(new PrintWriter(new SerializeWriter()));

    // Act
    metricsServlet.doGet(request, response);

    // Assert
    verify(response, atLeast(1)).getWriter();
    verify(metricsApiService).getMetricsInfo();
    verify(blockProcessTime).getCount();
  }

  /**
   * Test {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link MetricsServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MetricsServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenRuntimeException_thenThrowRuntimeException() throws IOException {
    // Arrange
    BlockChainInfo blockchain = new BlockChainInfo();
    blockchain.setBlockProcessTime(mock(RateInfo.class));
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
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new RuntimeException());
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> metricsServlet.doGet(request, new HttpServletResponseWrapper(response2)));
    verify(response, atLeast(1)).getOutputStream();
    verify(metricsApiService).getMetricsInfo();
  }
}
