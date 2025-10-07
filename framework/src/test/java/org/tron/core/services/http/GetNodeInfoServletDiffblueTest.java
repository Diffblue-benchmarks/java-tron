package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
    GetNodeInfoServlet getNodeInfoServlet = new GetNodeInfoServlet();
    MockHttpServletRequest request = HttpMethed.createRequest("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(new CharResponseWrapper(new MockHttpServletResponse()));

    // Act
    getNodeInfoServlet.doGet(request, response);

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
    GetNodeInfoServlet getNodeInfoServlet = new GetNodeInfoServlet();

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");

    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new IOException());
    CharResponseWrapper response2 = new CharResponseWrapper(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    // Act
    getNodeInfoServlet.doGet(request, response3);

    // Assert that nothing has changed
    verify(response).getOutputStream();
    verify(request).addParameter("https://example.org/example", "https://example.org/example");
    ServletResponse response4 = response3.getResponse();
    assertTrue(response4 instanceof CharResponseWrapper);
    assertEquals(0, ((CharResponseWrapper) response4).getByteSize());
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
    GetNodeInfoServlet getNodeInfoServlet = new GetNodeInfoServlet();

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");

    Response response = mock(Response.class);
    when(response.getWriter()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> getNodeInfoServlet.doGet(request, new HttpServletResponseWrapper(response)));
    verify(response).getWriter();
    verify(request).addParameter("https://example.org/example", "https://example.org/example");
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link HttpServletResponseWrapper#HttpServletResponseWrapper(HttpServletResponse)}
   *       with response is {@link Response#Response(HttpChannel, HttpOutput)} Response {@link
   *       Response}.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenHttpServletResponseWrapperWithResponseIsResponseResponseResponse()
      throws IOException {
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
  public void testDoPost5() throws IOException {
    // Arrange
    GetNodeInfoServlet getNodeInfoServlet = new GetNodeInfoServlet();

    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");

    Response response = mock(Response.class);
    when(response.getOutputStream()).thenThrow(new IOException());
    CharResponseWrapper response2 = new CharResponseWrapper(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    // Act
    getNodeInfoServlet.doPost(request, response3);

    // Assert that nothing has changed
    verify(response).getOutputStream();
    verify(request).addParameter("https://example.org/example", "https://example.org/example");
    ServletResponse response4 = response3.getResponse();
    assertTrue(response4 instanceof CharResponseWrapper);
    assertEquals(0, ((CharResponseWrapper) response4).getByteSize());
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link HttpServletResponseWrapper#HttpServletResponseWrapper(HttpServletResponse)}
   *       with response is {@link Response#Response(HttpChannel, HttpOutput)} Response {@link
   *       Response}.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenHttpServletResponseWrapperWithResponseIsResponseResponseResponse()
      throws IOException {
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
}
