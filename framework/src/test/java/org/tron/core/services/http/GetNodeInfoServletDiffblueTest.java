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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.tron.common.entity.NodeInfo;
import org.tron.common.entity.NodeInfo.ConfigNodeInfo;
import org.tron.common.entity.NodeInfo.MachineInfo;
import org.tron.common.entity.NodeInfo.MachineInfo.DeadLockThreadInfo;
import org.tron.common.entity.PeerInfo;
import org.tron.common.utils.client.utils.HttpMethed;
import org.tron.core.services.NodeInfoService;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class GetNodeInfoServletDiffblueTest {
  @InjectMocks private GetNodeInfoServlet getNodeInfoServlet;

  @Mock private NodeInfoService nodeInfoService;

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doGet(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":0,\"beginSyncNum\":0,\"cheatWitnessInfoMap\":{},\"currentConnectCount\":0,\"passiveCo"
            + "nnectCount\":0,\"peerList\":[],\"totalFlow\":0}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(143, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(143, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet2() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(null);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doGet(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals("null\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(5, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "null\n".getBytes("UTF-8"), ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet3() throws IOException {
    // Arrange
    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenThrow(new RuntimeException());
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doGet(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfoService).getNodeInfo();
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
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet4() throws IOException {
    // Arrange
    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(1L);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(new ArrayList<>());
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(new HashMap<>());
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doGet(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\":"
            + "{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(903, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(903, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet5() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(mock(NodeInfo.class));
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new IOException());
    CharResponseWrapper response2 = new CharResponseWrapper(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    // Act
    getNodeInfoServlet.doGet(request, response3);

    // Assert that nothing has changed
    verify(response, atLeast(1)).getOutputStream();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response4 = response3.getResponse();
    assertTrue(response4 instanceof CharResponseWrapper);
    assertEquals(0, ((CharResponseWrapper) response4).getByteSize());
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet6() throws IOException {
    // Arrange
    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenThrow(new RuntimeException());
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
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
    getNodeInfoServlet.doGet(request, response2);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(52L, httpOutput.getWritten());
    assertEquals(52L, ((Response) response3).getContentCount());
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
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet7() throws IOException {
    // Arrange
    GetNodeInfoServlet getNodeInfoServlet = new GetNodeInfoServlet();

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
    getNodeInfoServlet.doGet(request, response2);

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
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link NodeInfoService} {@link NodeInfoService#getNodeInfo()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenNodeInfoServiceGetNodeInfoThrowRuntimeException() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenThrow(new RuntimeException());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doGet(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
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
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link PrintWriter#PrintWriter(Writer)} with {@link
   *       SerializeWriter#SerializeWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenPrintWriterWithSerializeWriter() throws IOException {
    // Arrange
    GetNodeInfoServlet getNodeInfoServlet = new GetNodeInfoServlet();

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");

    Response response = mock(Response.class);
    when(response.getWriter()).thenReturn(new PrintWriter(new SerializeWriter()));

    // Act
    getNodeInfoServlet.doGet(request, response);

    // Assert
    verify(response).getWriter();
    verify(request).addParameter("https://example.org/example", "https://example.org/example");
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenRuntimeException_thenThrowRuntimeException() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(mock(NodeInfo.class));
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    Response response = mock(Response.class);
    when(response.getWriter()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> getNodeInfoServlet.doGet(request, new HttpServletResponseWrapper(response)));
    verify(response, atLeast(1)).getWriter();
    verify(nodeInfoService).getNodeInfo();
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":0,\"beginSyncNum\":0,\"cheatWitnessInfoMap\":{},\"currentConnectCount\":0,\"passiveCo"
            + "nnectCount\":0,\"peerList\":[],\"totalFlow\":0}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(143, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(143, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost2() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(null);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals("null\n", ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(5, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "null\n".getBytes("UTF-8"), ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost3() throws IOException {
    // Arrange
    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(1L);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(new ArrayList<>());
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(new HashMap<>());
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\":"
            + "{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(903, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(903, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost4() throws IOException {
    // Arrange
    PeerInfo peerInfo = new PeerInfo();
    peerInfo.setActive(true);
    peerInfo.setAvgLatency(10.0d);
    peerInfo.setBlockInPorcSize(3);
    peerInfo.setConnectTime(4096L);
    peerInfo.setDisconnectTimes(4096);
    peerInfo.setHeadBlockTimeWeBothHave(4096L);
    peerInfo.setHeadBlockWeBothHave("Head Block We Both Have");
    peerInfo.setHost("localhost");
    peerInfo.setInFlow(4096L);
    peerInfo.setLastBlockUpdateTime(4096L);
    peerInfo.setLastSyncBlock("Last Sync Block");
    peerInfo.setLocalDisconnectReason("Just cause");
    peerInfo.setNeedSyncFromPeer(true);
    peerInfo.setNeedSyncFromUs(true);
    peerInfo.setNodeCount(3);
    peerInfo.setNodeId("42");
    peerInfo.setPort(8080);
    peerInfo.setRemainNum(4096L);
    peerInfo.setRemoteDisconnectReason("Just cause");
    peerInfo.setScore(3);
    peerInfo.setSyncBlockRequestedSize(3);
    peerInfo.setSyncFlag(true);
    peerInfo.setSyncToFetchSize(3);
    peerInfo.setSyncToFetchSizePeekNum(3L);
    peerInfo.setUnFetchSynNum(4096L);

    ArrayList<PeerInfo> peerInfoList = new ArrayList<>();
    peerInfoList.add(peerInfo);

    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(1L);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(peerInfoList);
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(new HashMap<>());
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\":{"
            + "\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[{\"active\":true,\"avgLatency\":10.0,\"blockInPorcSize"
            + "\":3,\"connectTime\":4096,\"disconnectTimes\":4096,\"headBlockTimeWeBothHave\":4096,\"headBlockWeBothHave\":\"Head"
            + " Block We Both Have\",\"host\":\"localhost\",\"inFlow\":4096,\"lastBlockUpdateTime\":4096,\"lastSyncBlock\":\"Last"
            + " Sync Block\",\"localDisconnectReason\":\"Just cause\",\"needSyncFromPeer\":true,\"needSyncFromUs\":true,"
            + "\"nodeCount\":3,\"nodeId\":\"42\",\"port\":8080,\"remainNum\":4096,\"remoteDisconnectReason\":\"Just cause\",\"score"
            + "\":3,\"syncBlockRequestedSize\":3,\"syncFlag\":true,\"syncToFetchSize\":3,\"syncToFetchSizePeekNum\":3,"
            + "\"unFetchSynNum\":4096}],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(1470, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(1470, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost5() throws IOException {
    // Arrange
    PeerInfo peerInfo = new PeerInfo();
    peerInfo.setActive(true);
    peerInfo.setAvgLatency(10.0d);
    peerInfo.setBlockInPorcSize(3);
    peerInfo.setConnectTime(4096L);
    peerInfo.setDisconnectTimes(4096);
    peerInfo.setHeadBlockTimeWeBothHave(4096L);
    peerInfo.setHeadBlockWeBothHave("Head Block We Both Have");
    peerInfo.setHost("localhost");
    peerInfo.setInFlow(4096L);
    peerInfo.setLastBlockUpdateTime(4096L);
    peerInfo.setLastSyncBlock("Last Sync Block");
    peerInfo.setLocalDisconnectReason("Just cause");
    peerInfo.setNeedSyncFromPeer(true);
    peerInfo.setNeedSyncFromUs(true);
    peerInfo.setNodeCount(3);
    peerInfo.setNodeId("42");
    peerInfo.setPort(8080);
    peerInfo.setRemainNum(4096L);
    peerInfo.setRemoteDisconnectReason("Just cause");
    peerInfo.setScore(3);
    peerInfo.setSyncBlockRequestedSize(3);
    peerInfo.setSyncFlag(true);
    peerInfo.setSyncToFetchSize(3);
    peerInfo.setSyncToFetchSizePeekNum(3L);
    peerInfo.setUnFetchSynNum(4096L);

    PeerInfo peerInfo2 = new PeerInfo();
    peerInfo2.setActive(false);
    peerInfo2.setAvgLatency(0.5d);
    peerInfo2.setBlockInPorcSize(4096);
    peerInfo2.setConnectTime(1L);
    peerInfo2.setDisconnectTimes(1);
    peerInfo2.setHeadBlockTimeWeBothHave(1L);
    peerInfo2.setHeadBlockWeBothHave("42");
    peerInfo2.setHost("Host");
    peerInfo2.setInFlow(1L);
    peerInfo2.setLastBlockUpdateTime(1L);
    peerInfo2.setLastSyncBlock("42");
    peerInfo2.setLocalDisconnectReason("Local Disconnect Reason");
    peerInfo2.setNeedSyncFromPeer(false);
    peerInfo2.setNeedSyncFromUs(false);
    peerInfo2.setNodeCount(4096);
    peerInfo2.setNodeId("Node Id");
    peerInfo2.setPort(4096);
    peerInfo2.setRemainNum(1L);
    peerInfo2.setRemoteDisconnectReason("Remote Disconnect Reason");
    peerInfo2.setScore(4096);
    peerInfo2.setSyncBlockRequestedSize(4096);
    peerInfo2.setSyncFlag(false);
    peerInfo2.setSyncToFetchSize(4096);
    peerInfo2.setSyncToFetchSizePeekNum(4096L);
    peerInfo2.setUnFetchSynNum(1L);

    ArrayList<PeerInfo> peerInfoList = new ArrayList<>();
    peerInfoList.add(peerInfo2);
    peerInfoList.add(peerInfo);

    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(1L);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(peerInfoList);
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(new HashMap<>());
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\":{"
            + "\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[{\"active\":false,\"avgLatency\":0.5,\"blockInPorcSize"
            + "\":4096,\"connectTime\":1,\"disconnectTimes\":1,\"headBlockTimeWeBothHave\":1,\"headBlockWeBothHave\":\"42\","
            + "\"host\":\"Host\",\"inFlow\":1,\"lastBlockUpdateTime\":1,\"lastSyncBlock\":\"42\",\"localDisconnectReason\":\"Local"
            + " Disconnect Reason\",\"needSyncFromPeer\":false,\"needSyncFromUs\":false,\"nodeCount\":4096,\"nodeId\":\"Node"
            + " Id\",\"port\":4096,\"remainNum\":1,\"remoteDisconnectReason\":\"Remote Disconnect Reason\",\"score\":4096,"
            + "\"syncBlockRequestedSize\":4096,\"syncFlag\":false,\"syncToFetchSize\":4096,\"syncToFetchSizePeekNum\":4096,"
            + "\"unFetchSynNum\":1},{\"active\":true,\"avgLatency\":10.0,\"blockInPorcSize\":3,\"connectTime\":4096,\"disconnectTimes"
            + "\":4096,\"headBlockTimeWeBothHave\":4096,\"headBlockWeBothHave\":\"Head Block We Both Have\",\"host\":\"localhost"
            + "\",\"inFlow\":4096,\"lastBlockUpdateTime\":4096,\"lastSyncBlock\":\"Last Sync Block\",\"localDisconnectReason\":\"Just"
            + " cause\",\"needSyncFromPeer\":true,\"needSyncFromUs\":true,\"nodeCount\":3,\"nodeId\":\"42\",\"port\":8080,\"remainNum"
            + "\":4096,\"remoteDisconnectReason\":\"Just cause\",\"score\":3,\"syncBlockRequestedSize\":3,\"syncFlag\":true,"
            + "\"syncToFetchSize\":3,\"syncToFetchSizePeekNum\":3,\"unFetchSynNum\":4096}],\"solidityBlock\":\"Solidity"
            + " Block\",\"totalFlow\":1}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(2031, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(2031, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost6() throws IOException {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");

    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(1L);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(new ArrayList<>());
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(stringStringMap);
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{\"foo\":\"foo\"},"
            + "\"configNodeInfo\":{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort"
            + "\":8080,\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\""
            + ":true,\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio"
            + "\":10.0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(914, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(914, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost7() throws IOException {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("42", "42");
    stringStringMap.put("foo", "foo");

    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(1L);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(new ArrayList<>());
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(stringStringMap);
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{\"foo\":\"foo\",\"42\":\"42"
            + "\"},\"configNodeInfo\":{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,"
            + "\"backupListenPort\":8080,\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,"
            + "\"discoverEnable\":true,\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate"
            + "\":1,\"minTimeRatio\":10.0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize"
            + "\":3,\"supportConstant\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3"
            + ",\"cpuRate\":10.0,\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0"
            + ".2\",\"jvmFreeMemory\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\""
            + ":10.0,\"threadCount\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity"
            + " Block\",\"totalFlow\":1}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(924, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(924, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost8() throws IOException {
    // Arrange
    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(Integer.MIN_VALUE);
    configNodeInfo.setAllowAdaptiveEnergy(1L);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(new ArrayList<>());
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(new HashMap<>());
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\":{"
            + "\"activeNodeSize\":-2147483648,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\""
            + ":8080,\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\""
            + ":true,\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio"
            + "\":10.0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(913, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(913, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost9() throws IOException {
    // Arrange
    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(Long.MAX_VALUE);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(new ArrayList<>());
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(new HashMap<>());
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\":{"
            + "\"activeNodeSize\":3,\"allowAdaptiveEnergy\":9223372036854775807,\"allowCreationOfContracts\":1,\"backupListenPort"
            + "\":8080,\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\""
            + ":true,\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio"
            + "\":10.0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(921, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(921, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost10() throws IOException {
    // Arrange
    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(Long.MIN_VALUE);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(new ArrayList<>());
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(new HashMap<>());
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\":{"
            + "\"activeNodeSize\":3,\"allowAdaptiveEnergy\":-9223372036854775808,\"allowCreationOfContracts\":1,\"backupListenPort"
            + "\":8080,\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\""
            + ":true,\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio"
            + "\":10.0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(922, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(922, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost11() throws IOException {
    // Arrange
    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(1L);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    DeadLockThreadInfo deadLockThreadInfo = new DeadLockThreadInfo();
    deadLockThreadInfo.setBlockTime(4096L);
    deadLockThreadInfo.setLockName("Lock Name");
    deadLockThreadInfo.setLockOwner("Lock Owner");
    deadLockThreadInfo.setName("Name");
    deadLockThreadInfo.setStackTrace("Stack Trace");
    deadLockThreadInfo.setState("MD");
    deadLockThreadInfo.setWaitTime(4096L);

    ArrayList<DeadLockThreadInfo> deadLockThreadInfoList = new ArrayList<>();
    deadLockThreadInfoList.add(deadLockThreadInfo);

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(deadLockThreadInfoList);
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(new ArrayList<>());
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(new HashMap<>());
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\":{"
            + "\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[{\"blockTime\":4096,\"lockName\":\"Lock Name\",\"lockOwner\":\"Lock"
            + " Owner\",\"name\":\"Name\",\"stackTrace\":\"Stack Trace\",\"state\":\"MD\",\"waitTime\":4096}],\"freeMemory\":1,"
            + "\"javaVersion\":\"1.0.2\",\"jvmFreeMemory\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os"
            + " Name\",\"processCpuRate\":10.0,\"threadCount\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],"
            + "\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(1039, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(1039, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost12() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(mock(NodeInfo.class));
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");

    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new IOException());
    CharResponseWrapper response2 = new CharResponseWrapper(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    // Act
    getNodeInfoServlet.doPost(request, response3);

    // Assert that nothing has changed
    verify(response, atLeast(1)).getOutputStream();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response4 = response3.getResponse();
    assertTrue(response4 instanceof CharResponseWrapper);
    assertEquals(0, ((CharResponseWrapper) response4).getByteSize());
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost13() throws IOException {
    // Arrange
    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(1L);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(new ArrayList<>());
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(new HashMap<>());
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
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
    getNodeInfoServlet.doPost(request, response2);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof Response);
    PrintWriter writer = response2.getWriter();
    assertTrue(writer instanceof ResponseWriter);
    HttpOutput httpOutput = ((Response) response3).getHttpOutput();
    assertEquals(32768, httpOutput.getBufferSize());
    assertEquals(903L, httpOutput.getWritten());
    assertEquals(903L, ((Response) response3).getContentCount());
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
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost14() throws IOException {
    // Arrange
    GetNodeInfoServlet getNodeInfoServlet = new GetNodeInfoServlet();
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(56, ((CharResponseWrapper) response2).getByteSize());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost15() throws IOException {
    // Arrange
    GetNodeInfoServlet getNodeInfoServlet = new GetNodeInfoServlet();

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
    getNodeInfoServlet.doPost(request, response2);

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
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link ConfigNodeInfo} (default constructor) ActiveNodeSize is minus one.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenConfigNodeInfoActiveNodeSizeIsMinusOne() throws IOException {
    // Arrange
    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(-1);
    configNodeInfo.setAllowAdaptiveEnergy(1L);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(new ArrayList<>());
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(new HashMap<>());
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\":"
            + "{\"activeNodeSize\":-1,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(904, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(904, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link ConfigNodeInfo} (default constructor) AllowAdaptiveEnergy is minus one.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenConfigNodeInfoAllowAdaptiveEnergyIsMinusOne() throws IOException {
    // Arrange
    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(-1L);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(10.0d);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(new ArrayList<>());
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(new HashMap<>());
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\":"
            + "{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":-1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(904, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(904, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link ConfigNodeInfo} (default constructor) MaxTimeRatio is {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenConfigNodeInfoMaxTimeRatioIsNaN() throws IOException {
    // Arrange
    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(1L);
    configNodeInfo.setAllowCreationOfContracts(1L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(1);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(1);
    configNodeInfo.setDiscoverEnable(true);
    configNodeInfo.setListenPort(8080);
    configNodeInfo.setMaxConnectCount(3);
    configNodeInfo.setMaxTimeRatio(Double.NaN);
    configNodeInfo.setMinParticipationRate(1);
    configNodeInfo.setMinTimeRatio(10.0d);
    configNodeInfo.setP2pVersion("1.0.2");
    configNodeInfo.setPassiveNodeSize(3);
    configNodeInfo.setSameIpMaxConnectCount(3);
    configNodeInfo.setSendNodeSize(3);
    configNodeInfo.setSupportConstant(true);
    configNodeInfo.setVersionNum("1.0.2");

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(1L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(1L);
    machineInfo.setJvmTotalMemory(1L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(1L);

    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenReturn(3);
    when(nodeInfo.getCurrentConnectCount()).thenReturn(3);
    when(nodeInfo.getPassiveConnectCount()).thenReturn(3);
    when(nodeInfo.getBlock()).thenReturn("Block");
    when(nodeInfo.getSolidityBlock()).thenReturn("Solidity Block");
    when(nodeInfo.getPeerList()).thenReturn(new ArrayList<>());
    when(nodeInfo.getCheatWitnessInfoMap()).thenReturn(new HashMap<>());
    when(nodeInfo.getBeginSyncNum()).thenReturn(1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfo).getBeginSyncNum();
    verify(nodeInfo).getBlock();
    verify(nodeInfo).getCheatWitnessInfoMap();
    verify(nodeInfo).getConfigNodeInfo();
    verify(nodeInfo).getCurrentConnectCount();
    verify(nodeInfo).getMachineInfo();
    verify(nodeInfo).getPassiveConnectCount();
    verify(nodeInfo).getPeerList();
    verify(nodeInfo).getSolidityBlock();
    verify(nodeInfo).getTotalFlow();
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    ServletResponse response3 = ((CharResponseWrapper) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertTrue(response2 instanceof CharResponseWrapper);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\":"
            + "{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":null,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(903, ((CharResponseWrapper) response2).getByteSize());
    assertEquals(903, ((MockHttpServletResponse) response3).getContentAsByteArray().length);
  }
}
