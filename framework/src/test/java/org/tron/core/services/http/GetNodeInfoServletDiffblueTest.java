package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.io.ByteArrayEndPoint;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnection;
import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.LocalConnector;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.Server;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.common.entity.NodeInfo;
import org.tron.common.entity.NodeInfo.ConfigNodeInfo;
import org.tron.common.entity.NodeInfo.MachineInfo;
import org.tron.common.entity.PeerInfo;
import org.tron.core.services.NodeInfoService;
import org.tron.core.services.filter.CharResponseWrapper;

@RunWith(MockitoJUnitRunner.class)
public class GetNodeInfoServletDiffblueTest {
  @InjectMocks
  private GetNodeInfoServlet getNodeInfoServlet;

  @Mock
  private NodeInfoService nodeInfoService;

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getNodeInfoServlet.doGet(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"activeConnectCount\":0,\"beginSyncNum\":0,\"cheatWitnessInfoMap\":{},\"currentConnectCount\":0,\"passiveCo"
            + "nnectCount\":0,\"peerList\":[],\"totalFlow\":0}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(143, response.getByteSize());
    assertEquals(143, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet2() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getNodeInfoServlet.doGet(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("null\n", ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(5, response.getByteSize());
    byte[] expectedContentAsByteArray = "null\n".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet3() throws IOException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
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
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(903, response.getByteSize());
    assertEquals(903, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    when(nodeInfo.getActiveConnectCount()).thenReturn(Integer.MIN_VALUE);
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"activeConnectCount\":-2147483648,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo"
            + "\":{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(913, response.getByteSize());
    assertEquals(913, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet5() throws IOException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
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
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(1470, response.getByteSize());
    assertEquals(1470, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet6() throws IOException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
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
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(2031, response.getByteSize());
    assertEquals(2031, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet7() throws IOException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
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
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(914, response.getByteSize());
    assertEquals(914, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet8() throws IOException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
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
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(924, response.getByteSize());
    assertEquals(924, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet9() throws IOException {
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
    when(nodeInfo.getBeginSyncNum()).thenReturn(Long.MAX_VALUE);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":9223372036854775807,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},"
            + "\"configNodeInfo\":{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort"
            + "\":8080,\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\""
            + ":true,\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio"
            + "\":10.0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(921, response.getByteSize());
    assertEquals(921, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet10() throws IOException {
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
    when(nodeInfo.getBeginSyncNum()).thenReturn(Long.MIN_VALUE);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":-9223372036854775808,\"block\":\"Block\",\"cheatWitnessInfoMap\":{}"
            + ",\"configNodeInfo\":{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort"
            + "\":8080,\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\""
            + ":true,\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio"
            + "\":10.0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(922, response.getByteSize());
    assertEquals(922, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link ConfigNodeInfo} (default constructor) MaxTimeRatio is {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenConfigNodeInfoMaxTimeRatioIsNaN() throws IOException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
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
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(903, response.getByteSize());
    assertEquals(903, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link CharResponseWrapper#CharResponseWrapper(HttpServletResponse)} with {@link Response} ByteSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenFoo_thenCharResponseWrapperWithResponseByteSizeIsZero() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(mock(NodeInfo.class));
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("foo");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    when(response.getOutputStream()).thenReturn(new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))));
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

    // Assert that nothing has changed
    verify(response, atLeast(1)).getCharacterEncoding();
    verify(response, atLeast(1)).getOutputStream();
    verify(nodeInfoService).getNodeInfo();
    assertEquals(0, response2.getByteSize());
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link NodeInfo} {@link NodeInfo#getActiveConnectCount()} return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenNodeInfoGetActiveConnectCountReturnMinusOne() throws IOException {
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
    when(nodeInfo.getActiveConnectCount()).thenReturn(-1);
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"activeConnectCount\":-1,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\""
            + ":{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(904, response.getByteSize());
    assertEquals(904, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link NodeInfo} {@link NodeInfo#getBeginSyncNum()} return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenNodeInfoGetBeginSyncNumReturnMinusOne() throws IOException {
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
    when(nodeInfo.getBeginSyncNum()).thenReturn(-1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":-1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\""
            + ":{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(904, response.getByteSize());
    assertEquals(904, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then {@link CharResponseWrapper#CharResponseWrapper(HttpServletResponse)} with {@link Response} ByteSize is {@link Double#MAX_EXPONENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenCharResponseWrapperWithResponseByteSizeIsMax_exponent() throws IOException {
    // Arrange
    PeerInfo peerInfo = new PeerInfo();
    peerInfo.setActive(false);
    peerInfo.setAvgLatency(10.0d);
    peerInfo.setBlockInPorcSize(3);
    peerInfo.setConnectTime(1L);
    peerInfo.setDisconnectTimes(1);
    peerInfo.setHeadBlockTimeWeBothHave(1L);
    peerInfo.setHeadBlockWeBothHave("Head Block We Both Have");
    peerInfo.setHost("localhost");
    peerInfo.setInFlow(1L);
    peerInfo.setLastBlockUpdateTime(1L);
    peerInfo.setLastSyncBlock("Last Sync Block");
    peerInfo.setLocalDisconnectReason("Just cause");
    peerInfo.setNeedSyncFromPeer(false);
    peerInfo.setNeedSyncFromUs(false);
    peerInfo.setNodeCount(3);
    peerInfo.setNodeId("42");
    peerInfo.setPort(8080);
    peerInfo.setRemainNum(1L);
    peerInfo.setRemoteDisconnectReason("Just cause");
    peerInfo.setScore(3);
    peerInfo.setSyncBlockRequestedSize(3);
    peerInfo.setSyncFlag(false);
    peerInfo.setSyncToFetchSize(3);
    peerInfo.setSyncToFetchSizePeekNum(3L);
    peerInfo.setUnFetchSynNum(1L);

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
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpConfiguration configuration = mock(HttpConfiguration.class);
    when(configuration.getBlockingTimeout()).thenReturn(1L);
    when(configuration.getMinResponseDataRate()).thenReturn(1L);
    when(configuration.getOutputAggregationSize()).thenReturn(3);
    when(configuration.getOutputBufferSize()).thenReturn(3);
    LocalConnector connector = new LocalConnector(new Server());
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpOutput httpOutput = new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true)));
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("UTF-8");
    when(response.getOutputStream()).thenReturn(httpOutput);
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

    // Assert
    verify(configuration, atLeast(1)).getBlockingTimeout();
    verify(configuration).getMinResponseDataRate();
    verify(configuration, atLeast(1)).getOutputAggregationSize();
    verify(configuration, atLeast(1)).getOutputBufferSize();
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
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
    assertEquals(Double.MAX_EXPONENT, response2.getByteSize());
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"activeConnectCount\":0,\"beginSyncNum\":0,\"cheatWitnessInfoMap\":{},\"currentConnectCount\":0,\"passiveCo"
            + "nnectCount\":0,\"peerList\":[],\"totalFlow\":0}\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(143, response.getByteSize());
    assertEquals(143, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost2() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals("null\n", ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(5, response.getByteSize());
    byte[] expectedContentAsByteArray = "null\n".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, ((MockHttpServletResponse) response2).getContentAsByteArray());
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
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
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(903, response.getByteSize());
    assertEquals(903, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost4() throws IOException {
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
    when(nodeInfo.getActiveConnectCount()).thenReturn(Integer.MIN_VALUE);
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"activeConnectCount\":-2147483648,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo"
            + "\":{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(913, response.getByteSize());
    assertEquals(913, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
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
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(1470, response.getByteSize());
    assertEquals(1470, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost6() throws IOException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
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
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(2031, response.getByteSize());
    assertEquals(2031, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost7() throws IOException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
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
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(914, response.getByteSize());
    assertEquals(914, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost8() throws IOException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
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
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(924, response.getByteSize());
    assertEquals(924, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost9() throws IOException {
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
    when(nodeInfo.getBeginSyncNum()).thenReturn(Long.MAX_VALUE);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":9223372036854775807,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},"
            + "\"configNodeInfo\":{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort"
            + "\":8080,\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\""
            + ":true,\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio"
            + "\":10.0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(921, response.getByteSize());
    assertEquals(921, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost10() throws IOException {
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
    when(nodeInfo.getBeginSyncNum()).thenReturn(Long.MIN_VALUE);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":-9223372036854775808,\"block\":\"Block\",\"cheatWitnessInfoMap\":{}"
            + ",\"configNodeInfo\":{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort"
            + "\":8080,\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\""
            + ":true,\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio"
            + "\":10.0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(922, response.getByteSize());
    assertEquals(922, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link ConfigNodeInfo} (default constructor) MaxTimeRatio is {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
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
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(903, response.getByteSize());
    assertEquals(903, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link CharResponseWrapper#CharResponseWrapper(HttpServletResponse)} with {@link Response} ByteSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenFoo_thenCharResponseWrapperWithResponseByteSizeIsZero() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(mock(NodeInfo.class));
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("foo");
    LocalConnector connector = new LocalConnector(new Server());
    HttpConfiguration configuration = new HttpConfiguration();
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    when(response.getOutputStream()).thenReturn(new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true))));
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doPost(request, response2);

    // Assert that nothing has changed
    verify(response, atLeast(1)).getCharacterEncoding();
    verify(response, atLeast(1)).getOutputStream();
    verify(nodeInfoService).getNodeInfo();
    assertEquals(0, response2.getByteSize());
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link NodeInfo} {@link NodeInfo#getActiveConnectCount()} return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenNodeInfoGetActiveConnectCountReturnMinusOne() throws IOException {
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
    when(nodeInfo.getActiveConnectCount()).thenReturn(-1);
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"activeConnectCount\":-1,\"beginSyncNum\":1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\""
            + ":{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(904, response.getByteSize());
    assertEquals(904, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link NodeInfo} {@link NodeInfo#getBeginSyncNum()} return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenNodeInfoGetBeginSyncNumReturnMinusOne() throws IOException {
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
    when(nodeInfo.getBeginSyncNum()).thenReturn(-1L);
    when(nodeInfo.getTotalFlow()).thenReturn(1L);
    when(nodeInfo.getConfigNodeInfo()).thenReturn(configNodeInfo);
    when(nodeInfo.getMachineInfo()).thenReturn(machineInfo);
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    CharResponseWrapper response = new CharResponseWrapper(new MockHttpServletResponse());

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
    assertTrue(response2 instanceof MockHttpServletResponse);
    assertEquals(
        "{\"activeConnectCount\":3,\"beginSyncNum\":-1,\"block\":\"Block\",\"cheatWitnessInfoMap\":{},\"configNodeInfo\""
            + ":{\"activeNodeSize\":3,\"allowAdaptiveEnergy\":1,\"allowCreationOfContracts\":1,\"backupListenPort\":8080,"
            + "\"backupMemberSize\":3,\"backupPriority\":1,\"codeVersion\":\"1.0.2\",\"dbVersion\":1,\"discoverEnable\":true,"
            + "\"listenPort\":8080,\"maxConnectCount\":3,\"maxTimeRatio\":10.0,\"minParticipationRate\":1,\"minTimeRatio\":10"
            + ".0,\"p2pVersion\":\"1.0.2\",\"passiveNodeSize\":3,\"sameIpMaxConnectCount\":3,\"sendNodeSize\":3,\"supportConstant"
            + "\":true,\"versionNum\":\"1.0.2\"},\"currentConnectCount\":3,\"machineInfo\":{\"cpuCount\":3,\"cpuRate\":10.0,"
            + "\"deadLockThreadCount\":3,\"deadLockThreadInfoList\":[],\"freeMemory\":1,\"javaVersion\":\"1.0.2\",\"jvmFreeMemory"
            + "\":1,\"jvmTotalMemory\":1,\"memoryDescInfoList\":[],\"osName\":\"Os Name\",\"processCpuRate\":10.0,\"threadCount"
            + "\":3,\"totalMemory\":1},\"passiveConnectCount\":3,\"peerList\":[],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}"
            + "\n",
        ((MockHttpServletResponse) response2).getContentAsString());
    assertEquals(904, response.getByteSize());
    assertEquals(904, ((MockHttpServletResponse) response2).getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then {@link CharResponseWrapper#CharResponseWrapper(HttpServletResponse)} with {@link Response} ByteSize is {@link Double#MAX_EXPONENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenCharResponseWrapperWithResponseByteSizeIsMax_exponent() throws IOException {
    // Arrange
    PeerInfo peerInfo = new PeerInfo();
    peerInfo.setActive(false);
    peerInfo.setAvgLatency(10.0d);
    peerInfo.setBlockInPorcSize(3);
    peerInfo.setConnectTime(1L);
    peerInfo.setDisconnectTimes(1);
    peerInfo.setHeadBlockTimeWeBothHave(1L);
    peerInfo.setHeadBlockWeBothHave("Head Block We Both Have");
    peerInfo.setHost("localhost");
    peerInfo.setInFlow(1L);
    peerInfo.setLastBlockUpdateTime(1L);
    peerInfo.setLastSyncBlock("Last Sync Block");
    peerInfo.setLocalDisconnectReason("Just cause");
    peerInfo.setNeedSyncFromPeer(false);
    peerInfo.setNeedSyncFromUs(false);
    peerInfo.setNodeCount(3);
    peerInfo.setNodeId("42");
    peerInfo.setPort(8080);
    peerInfo.setRemainNum(1L);
    peerInfo.setRemoteDisconnectReason("Just cause");
    peerInfo.setScore(3);
    peerInfo.setSyncBlockRequestedSize(3);
    peerInfo.setSyncFlag(false);
    peerInfo.setSyncToFetchSize(3);
    peerInfo.setSyncToFetchSizePeekNum(3L);
    peerInfo.setUnFetchSynNum(1L);

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
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpConfiguration configuration = mock(HttpConfiguration.class);
    when(configuration.getBlockingTimeout()).thenReturn(1L);
    when(configuration.getMinResponseDataRate()).thenReturn(1L);
    when(configuration.getOutputAggregationSize()).thenReturn(3);
    when(configuration.getOutputBufferSize()).thenReturn(3);
    LocalConnector connector = new LocalConnector(new Server());
    ByteArrayEndPoint endPoint = new ByteArrayEndPoint();
    HttpConfiguration config = new HttpConfiguration();
    LocalConnector connector2 = new LocalConnector(new Server());
    HttpOutput httpOutput = new HttpOutput(new HttpChannel(connector, configuration, endPoint,
        new HttpConnection(config, connector2, new ByteArrayEndPoint(), HttpCompliance.LEGACY, true)));
    Response response = mock(Response.class);
    when(response.getCharacterEncoding()).thenReturn("UTF-8");
    when(response.getOutputStream()).thenReturn(httpOutput);
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doPost(request, response2);

    // Assert
    verify(configuration, atLeast(1)).getBlockingTimeout();
    verify(configuration).getMinResponseDataRate();
    verify(configuration, atLeast(1)).getOutputAggregationSize();
    verify(configuration, atLeast(1)).getOutputBufferSize();
    verify(response).getCharacterEncoding();
    verify(response).getOutputStream();
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
    assertEquals(Double.MAX_EXPONENT, response2.getByteSize());
  }
}
