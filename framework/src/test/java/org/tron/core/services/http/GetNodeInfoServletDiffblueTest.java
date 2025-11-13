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
import java.util.HashMap;
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
import org.tron.common.entity.NodeInfo;
import org.tron.common.entity.NodeInfo.ConfigNodeInfo;
import org.tron.common.entity.NodeInfo.MachineInfo;
import org.tron.common.entity.PeerInfo;
import org.tron.core.services.NodeInfoService;

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
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    GetNodeInfoServlet getNodeInfoServlet = new GetNodeInfoServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getNodeInfoServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
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
  public void testDoGet2() throws UnsupportedEncodingException {
    // Arrange
    NodeInfo nodeInfo = mock(NodeInfo.class);
    when(nodeInfo.getActiveConnectCount()).thenThrow(new RuntimeException());
    when(nodeInfoService.getNodeInfo()).thenReturn(nodeInfo);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getNodeInfoServlet.doGet(request, response);

    // Assert
    verify(nodeInfo).getActiveConnectCount();
    verify(nodeInfoService).getNodeInfo();
    assertEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link ConfigNodeInfo} (default constructor) ActiveNodeSize is minus one.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenConfigNodeInfoActiveNodeSizeIsMinusOne()
      throws UnsupportedEncodingException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(904, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link ConfigNodeInfo} (default constructor) AllowAdaptiveEnergy is minus one.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenConfigNodeInfoAllowAdaptiveEnergyIsMinusOne()
      throws UnsupportedEncodingException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(904, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link ConfigNodeInfo} (default constructor) MaxTimeRatio is {@link Double#NaN}.
   *   <li>Then array length is nine hundred three.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenConfigNodeInfoMaxTimeRatioIsNaN_thenArrayLengthIsNineHundredThree()
      throws UnsupportedEncodingException {
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
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(903, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link PeerInfo} (default constructor) Active is {@code false}.
   *   <li>Then array length is {@code 1989}.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenPeerInfoActiveIsFalse_thenArrayLengthIs1989()
      throws UnsupportedEncodingException {
    // Arrange
    PeerInfo peerInfo = new PeerInfo();
    peerInfo.setActive(true);
    peerInfo.setAvgLatency(10.0d);
    peerInfo.setBlockInPorcSize(3);
    peerInfo.setConnectTime(3L);
    peerInfo.setDisconnectTimes(3);
    peerInfo.setHeadBlockTimeWeBothHave(3L);
    peerInfo.setHeadBlockWeBothHave("Head Block We Both Have");
    peerInfo.setHost("localhost");
    peerInfo.setInFlow(3L);
    peerInfo.setLastBlockUpdateTime(3L);
    peerInfo.setLastSyncBlock("Last Sync Block");
    peerInfo.setLocalDisconnectReason("Just cause");
    peerInfo.setNeedSyncFromPeer(true);
    peerInfo.setNeedSyncFromUs(true);
    peerInfo.setNodeCount(3);
    peerInfo.setNodeId("42");
    peerInfo.setPort(8080);
    peerInfo.setRemainNum(3L);
    peerInfo.setRemoteDisconnectReason("Just cause");
    peerInfo.setScore(3);
    peerInfo.setSyncBlockRequestedSize(3);
    peerInfo.setSyncFlag(true);
    peerInfo.setSyncToFetchSize(3);
    peerInfo.setSyncToFetchSizePeekNum(3L);
    peerInfo.setUnFetchSynNum(3L);

    PeerInfo peerInfo2 = new PeerInfo();
    peerInfo2.setActive(false);
    peerInfo2.setAvgLatency(0.5d);
    peerInfo2.setBlockInPorcSize(1);
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
    peerInfo2.setNodeCount(1);
    peerInfo2.setNodeId("Node Id");
    peerInfo2.setPort(3);
    peerInfo2.setRemainNum(1L);
    peerInfo2.setRemoteDisconnectReason("Remote Disconnect Reason");
    peerInfo2.setScore(1);
    peerInfo2.setSyncBlockRequestedSize(1);
    peerInfo2.setSyncFlag(false);
    peerInfo2.setSyncToFetchSize(1);
    peerInfo2.setSyncToFetchSizePeekNum(1L);
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
    MockHttpServletResponse response = new MockHttpServletResponse();

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
            + "\":1,\"connectTime\":1,\"disconnectTimes\":1,\"headBlockTimeWeBothHave\":1,\"headBlockWeBothHave\":\"42\",\"host"
            + "\":\"Host\",\"inFlow\":1,\"lastBlockUpdateTime\":1,\"lastSyncBlock\":\"42\",\"localDisconnectReason\":\"Local"
            + " Disconnect Reason\",\"needSyncFromPeer\":false,\"needSyncFromUs\":false,\"nodeCount\":1,\"nodeId\":\"Node"
            + " Id\",\"port\":3,\"remainNum\":1,\"remoteDisconnectReason\":\"Remote Disconnect Reason\",\"score\":1,\"syncBlock"
            + "RequestedSize\":1,\"syncFlag\":false,\"syncToFetchSize\":1,\"syncToFetchSizePeekNum\":1,\"unFetchSynNum\":1},"
            + "{\"active\":true,\"avgLatency\":10.0,\"blockInPorcSize\":3,\"connectTime\":3,\"disconnectTimes\":3,\"headBlockT"
            + "imeWeBothHave\":3,\"headBlockWeBothHave\":\"Head Block We Both Have\",\"host\":\"localhost\",\"inFlow\":3,"
            + "\"lastBlockUpdateTime\":3,\"lastSyncBlock\":\"Last Sync Block\",\"localDisconnectReason\":\"Just cause\","
            + "\"needSyncFromPeer\":true,\"needSyncFromUs\":true,\"nodeCount\":3,\"nodeId\":\"42\",\"port\":8080,\"remainNum\":3,"
            + "\"remoteDisconnectReason\":\"Just cause\",\"score\":3,\"syncBlockRequestedSize\":3,\"syncFlag\":true,\"syncToFetchSize"
            + "\":3,\"syncToFetchSizePeekNum\":3,\"unFetchSynNum\":3}],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}\n",
        response.getContentAsString());
    assertEquals(1989, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link PeerInfo} (default constructor) Active is {@code true}.
   *   <li>Then array length is {@code 1449}.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_givenPeerInfoActiveIsTrue_thenArrayLengthIs1449()
      throws UnsupportedEncodingException {
    // Arrange
    PeerInfo peerInfo = new PeerInfo();
    peerInfo.setActive(true);
    peerInfo.setAvgLatency(10.0d);
    peerInfo.setBlockInPorcSize(3);
    peerInfo.setConnectTime(3L);
    peerInfo.setDisconnectTimes(3);
    peerInfo.setHeadBlockTimeWeBothHave(3L);
    peerInfo.setHeadBlockWeBothHave("Head Block We Both Have");
    peerInfo.setHost("localhost");
    peerInfo.setInFlow(3L);
    peerInfo.setLastBlockUpdateTime(3L);
    peerInfo.setLastSyncBlock("Last Sync Block");
    peerInfo.setLocalDisconnectReason("Just cause");
    peerInfo.setNeedSyncFromPeer(true);
    peerInfo.setNeedSyncFromUs(true);
    peerInfo.setNodeCount(3);
    peerInfo.setNodeId("42");
    peerInfo.setPort(8080);
    peerInfo.setRemainNum(3L);
    peerInfo.setRemoteDisconnectReason("Just cause");
    peerInfo.setScore(3);
    peerInfo.setSyncBlockRequestedSize(3);
    peerInfo.setSyncFlag(true);
    peerInfo.setSyncToFetchSize(3);
    peerInfo.setSyncToFetchSizePeekNum(3L);
    peerInfo.setUnFetchSynNum(3L);

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
    MockHttpServletResponse response = new MockHttpServletResponse();

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
            + "\":3,\"connectTime\":3,\"disconnectTimes\":3,\"headBlockTimeWeBothHave\":3,\"headBlockWeBothHave\":\"Head Block"
            + " We Both Have\",\"host\":\"localhost\",\"inFlow\":3,\"lastBlockUpdateTime\":3,\"lastSyncBlock\":\"Last Sync"
            + " Block\",\"localDisconnectReason\":\"Just cause\",\"needSyncFromPeer\":true,\"needSyncFromUs\":true,\"nodeCount"
            + "\":3,\"nodeId\":\"42\",\"port\":8080,\"remainNum\":3,\"remoteDisconnectReason\":\"Just cause\",\"score\":3,"
            + "\"syncBlockRequestedSize\":3,\"syncFlag\":true,\"syncToFetchSize\":3,\"syncToFetchSizePeekNum\":3,\"unFetchSynNum"
            + "\":3}],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}\n",
        response.getContentAsString());
    assertEquals(1449, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then array length is nine hundred thirteen.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenArrayLengthIsNineHundredThirteen() throws UnsupportedEncodingException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(913, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then array length is nine hundred three.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenArrayLengthIsNineHundredThree() throws UnsupportedEncodingException {
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
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(903, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then array length is nine hundred twenty-one.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenArrayLengthIsNineHundredTwentyOne()
      throws UnsupportedEncodingException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(921, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then array length is nine hundred twenty-two.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenArrayLengthIsNineHundredTwentyTwo()
      throws UnsupportedEncodingException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(922, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then array length is one hundred forty-three.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenArrayLengthIsOneHundredFortyThree()
      throws UnsupportedEncodingException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getNodeInfoServlet.doGet(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertEquals(
        "{\"activeConnectCount\":0,\"beginSyncNum\":0,\"cheatWitnessInfoMap\":{},\"currentConnectCount\":0,\"passiveCo"
            + "nnectCount\":0,\"peerList\":[],\"totalFlow\":0}\n",
        response.getContentAsString());
    assertEquals(143, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doGet(HttpServletRequest, HttpServletResponse)"})
  public void testDoGet_thenMockHttpServletResponseContentAsStringIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getNodeInfoServlet.doGet(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertEquals("null\n", response.getContentAsString());
    assertArrayEquals("null\n".getBytes("UTF-8"), response.getContentAsByteArray());
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
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    GetNodeInfoServlet getNodeInfoServlet = new GetNodeInfoServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
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
  public void testDoPost_givenConfigNodeInfoActiveNodeSizeIsMinusOne()
      throws UnsupportedEncodingException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(904, response.getContentAsByteArray().length);
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
  public void testDoPost_givenConfigNodeInfoAllowAdaptiveEnergyIsMinusOne()
      throws UnsupportedEncodingException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(904, response.getContentAsByteArray().length);
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
  public void testDoPost_givenConfigNodeInfoMaxTimeRatioIsNaN()
      throws UnsupportedEncodingException {
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
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(903, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link PeerInfo} (default constructor) Active is {@code false}.
   *   <li>Then array length is {@code 1989}.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenPeerInfoActiveIsFalse_thenArrayLengthIs1989()
      throws UnsupportedEncodingException {
    // Arrange
    PeerInfo peerInfo = new PeerInfo();
    peerInfo.setActive(true);
    peerInfo.setAvgLatency(10.0d);
    peerInfo.setBlockInPorcSize(3);
    peerInfo.setConnectTime(3L);
    peerInfo.setDisconnectTimes(3);
    peerInfo.setHeadBlockTimeWeBothHave(3L);
    peerInfo.setHeadBlockWeBothHave("Head Block We Both Have");
    peerInfo.setHost("localhost");
    peerInfo.setInFlow(3L);
    peerInfo.setLastBlockUpdateTime(3L);
    peerInfo.setLastSyncBlock("Last Sync Block");
    peerInfo.setLocalDisconnectReason("Just cause");
    peerInfo.setNeedSyncFromPeer(true);
    peerInfo.setNeedSyncFromUs(true);
    peerInfo.setNodeCount(3);
    peerInfo.setNodeId("42");
    peerInfo.setPort(8080);
    peerInfo.setRemainNum(3L);
    peerInfo.setRemoteDisconnectReason("Just cause");
    peerInfo.setScore(3);
    peerInfo.setSyncBlockRequestedSize(3);
    peerInfo.setSyncFlag(true);
    peerInfo.setSyncToFetchSize(3);
    peerInfo.setSyncToFetchSizePeekNum(3L);
    peerInfo.setUnFetchSynNum(3L);

    PeerInfo peerInfo2 = new PeerInfo();
    peerInfo2.setActive(false);
    peerInfo2.setAvgLatency(0.5d);
    peerInfo2.setBlockInPorcSize(1);
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
    peerInfo2.setNodeCount(1);
    peerInfo2.setNodeId("Node Id");
    peerInfo2.setPort(3);
    peerInfo2.setRemainNum(1L);
    peerInfo2.setRemoteDisconnectReason("Remote Disconnect Reason");
    peerInfo2.setScore(1);
    peerInfo2.setSyncBlockRequestedSize(1);
    peerInfo2.setSyncFlag(false);
    peerInfo2.setSyncToFetchSize(1);
    peerInfo2.setSyncToFetchSizePeekNum(1L);
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
    MockHttpServletResponse response = new MockHttpServletResponse();

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
            + "\":1,\"connectTime\":1,\"disconnectTimes\":1,\"headBlockTimeWeBothHave\":1,\"headBlockWeBothHave\":\"42\",\"host"
            + "\":\"Host\",\"inFlow\":1,\"lastBlockUpdateTime\":1,\"lastSyncBlock\":\"42\",\"localDisconnectReason\":\"Local"
            + " Disconnect Reason\",\"needSyncFromPeer\":false,\"needSyncFromUs\":false,\"nodeCount\":1,\"nodeId\":\"Node"
            + " Id\",\"port\":3,\"remainNum\":1,\"remoteDisconnectReason\":\"Remote Disconnect Reason\",\"score\":1,\"syncBlock"
            + "RequestedSize\":1,\"syncFlag\":false,\"syncToFetchSize\":1,\"syncToFetchSizePeekNum\":1,\"unFetchSynNum\":1},"
            + "{\"active\":true,\"avgLatency\":10.0,\"blockInPorcSize\":3,\"connectTime\":3,\"disconnectTimes\":3,\"headBlockT"
            + "imeWeBothHave\":3,\"headBlockWeBothHave\":\"Head Block We Both Have\",\"host\":\"localhost\",\"inFlow\":3,"
            + "\"lastBlockUpdateTime\":3,\"lastSyncBlock\":\"Last Sync Block\",\"localDisconnectReason\":\"Just cause\","
            + "\"needSyncFromPeer\":true,\"needSyncFromUs\":true,\"nodeCount\":3,\"nodeId\":\"42\",\"port\":8080,\"remainNum\":3,"
            + "\"remoteDisconnectReason\":\"Just cause\",\"score\":3,\"syncBlockRequestedSize\":3,\"syncFlag\":true,\"syncToFetchSize"
            + "\":3,\"syncToFetchSizePeekNum\":3,\"unFetchSynNum\":3}],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}\n",
        response.getContentAsString());
    assertEquals(1989, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link PeerInfo} (default constructor) Active is {@code true}.
   *   <li>Then array length is {@code 1449}.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_givenPeerInfoActiveIsTrue_thenArrayLengthIs1449()
      throws UnsupportedEncodingException {
    // Arrange
    PeerInfo peerInfo = new PeerInfo();
    peerInfo.setActive(true);
    peerInfo.setAvgLatency(10.0d);
    peerInfo.setBlockInPorcSize(3);
    peerInfo.setConnectTime(3L);
    peerInfo.setDisconnectTimes(3);
    peerInfo.setHeadBlockTimeWeBothHave(3L);
    peerInfo.setHeadBlockWeBothHave("Head Block We Both Have");
    peerInfo.setHost("localhost");
    peerInfo.setInFlow(3L);
    peerInfo.setLastBlockUpdateTime(3L);
    peerInfo.setLastSyncBlock("Last Sync Block");
    peerInfo.setLocalDisconnectReason("Just cause");
    peerInfo.setNeedSyncFromPeer(true);
    peerInfo.setNeedSyncFromUs(true);
    peerInfo.setNodeCount(3);
    peerInfo.setNodeId("42");
    peerInfo.setPort(8080);
    peerInfo.setRemainNum(3L);
    peerInfo.setRemoteDisconnectReason("Just cause");
    peerInfo.setScore(3);
    peerInfo.setSyncBlockRequestedSize(3);
    peerInfo.setSyncFlag(true);
    peerInfo.setSyncToFetchSize(3);
    peerInfo.setSyncToFetchSizePeekNum(3L);
    peerInfo.setUnFetchSynNum(3L);

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
    MockHttpServletResponse response = new MockHttpServletResponse();

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
            + "\":3,\"connectTime\":3,\"disconnectTimes\":3,\"headBlockTimeWeBothHave\":3,\"headBlockWeBothHave\":\"Head Block"
            + " We Both Have\",\"host\":\"localhost\",\"inFlow\":3,\"lastBlockUpdateTime\":3,\"lastSyncBlock\":\"Last Sync"
            + " Block\",\"localDisconnectReason\":\"Just cause\",\"needSyncFromPeer\":true,\"needSyncFromUs\":true,\"nodeCount"
            + "\":3,\"nodeId\":\"42\",\"port\":8080,\"remainNum\":3,\"remoteDisconnectReason\":\"Just cause\",\"score\":3,"
            + "\"syncBlockRequestedSize\":3,\"syncFlag\":true,\"syncToFetchSize\":3,\"syncToFetchSizePeekNum\":3,\"unFetchSynNum"
            + "\":3}],\"solidityBlock\":\"Solidity Block\",\"totalFlow\":1}\n",
        response.getContentAsString());
    assertEquals(1449, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then array length is nine hundred thirteen.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenArrayLengthIsNineHundredThirteen()
      throws UnsupportedEncodingException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(913, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then array length is nine hundred three.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenArrayLengthIsNineHundredThree() throws UnsupportedEncodingException {
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
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(903, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then array length is nine hundred twenty-one.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenArrayLengthIsNineHundredTwentyOne()
      throws UnsupportedEncodingException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(921, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then array length is nine hundred twenty-two.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenArrayLengthIsNineHundredTwentyTwo()
      throws UnsupportedEncodingException {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
        response.getContentAsString());
    assertEquals(922, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then array length is one hundred forty-three.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenArrayLengthIsOneHundredFortyThree()
      throws UnsupportedEncodingException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertEquals(
        "{\"activeConnectCount\":0,\"beginSyncNum\":0,\"cheatWitnessInfoMap\":{},\"currentConnectCount\":0,\"passiveCo"
            + "nnectCount\":0,\"peerList\":[],\"totalFlow\":0}\n",
        response.getContentAsString());
    assertEquals(143, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link GetNodeInfoServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetNodeInfoServlet.doPost(HttpServletRequest, HttpServletResponse)"})
  public void testDoPost_thenMockHttpServletResponseContentAsStringIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    getNodeInfoServlet.doPost(request, response);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertEquals("null\n", response.getContentAsString());
    assertArrayEquals("null\n".getBytes("UTF-8"), response.getContentAsByteArray());
  }
}
