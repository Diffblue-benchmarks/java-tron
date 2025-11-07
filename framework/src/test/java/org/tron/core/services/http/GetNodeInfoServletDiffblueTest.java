package org.tron.core.services.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.common.entity.NodeInfo;
import org.tron.common.entity.PeerInfo;
import org.tron.core.services.NodeInfoService;
import org.tron.core.services.filter.CharResponseWrapper;
import org.tron.core.services.ratelimiter.RateLimiterContainer;

@RunWith(MockitoJUnitRunner.class)
public class GetNodeInfoServletDiffblueTest {
  @InjectMocks
  private GetNodeInfoServlet getNodeInfoServlet;

  @Mock
  private NodeInfoService nodeInfoService;

  @Mock
  private RateLimiterContainer rateLimiterContainer;

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertEquals(143, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet2() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertEquals(5, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet3() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

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
    assertEquals(903, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet4() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

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
    assertEquals(904, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet5() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

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
    assertEquals(913, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
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

    ArrayList<PeerInfo> peerInfoList = new ArrayList<>();
    peerInfoList.add(peerInfo);

    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

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
    assertEquals(1470, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet7() throws IOException {
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

    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

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
    assertEquals(2031, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet8() throws IOException {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");

    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

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
    assertEquals(914, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet9() throws IOException {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("42", "42");
    stringStringMap.put("foo", "foo");

    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

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
    assertEquals(924, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet10() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

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
    assertEquals(904, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet11() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

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
    assertEquals(921, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet12() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

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
    assertEquals(922, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet13() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doGet(request, response2);

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
    assertEquals(903, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet14() throws IOException {
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

    // Assert
    verify(response, atLeast(1)).getCharacterEncoding();
    verify(response, atLeast(1)).getOutputStream();
    verify(nodeInfoService).getNodeInfo();
    assertEquals(0, response2.getByteSize());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doGet(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoGet15() throws IOException {
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

    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(new NodeInfo());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doPost(request, response2);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertEquals(143, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost2() throws IOException {
    // Arrange
    when(nodeInfoService.getNodeInfo()).thenReturn(null);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

    // Act
    getNodeInfoServlet.doPost(request, response2);

    // Assert
    verify(nodeInfoService).getNodeInfo();
    assertEquals(5, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost3() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    CharResponseWrapper response2 = new CharResponseWrapper(response);

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
    assertEquals(903, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost4() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

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
    assertEquals(904, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost5() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

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
    assertEquals(913, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
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

    ArrayList<PeerInfo> peerInfoList = new ArrayList<>();
    peerInfoList.add(peerInfo);

    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    CharResponseWrapper response2 = new CharResponseWrapper(response);

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
    assertEquals(1470, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost7() throws IOException {
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

    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    CharResponseWrapper response2 = new CharResponseWrapper(response);

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
    assertEquals(2031, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost8() throws IOException {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");

    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

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
    assertEquals(914, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost9() throws IOException {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("42", "42");
    stringStringMap.put("foo", "foo");

    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

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
    assertEquals(924, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost10() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

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
    assertEquals(904, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost11() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

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
    assertEquals(921, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost12() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    MockHttpServletResponse response = new MockHttpServletResponse();
    CharResponseWrapper response2 = new CharResponseWrapper(response);

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
    assertEquals(922, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost13() throws IOException {
    // Arrange
    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
    CharResponseWrapper response2 = new CharResponseWrapper(response);

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
    assertEquals(903, response2.getByteSize());
    assertSame(response, response2.getResponse());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost14() throws IOException {
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

    // Assert
    verify(response, atLeast(1)).getCharacterEncoding();
    verify(response, atLeast(1)).getOutputStream();
    verify(nodeInfoService).getNodeInfo();
    assertEquals(0, response2.getByteSize());
  }

  /**
   * Method under test:
   * {@link GetNodeInfoServlet#doPost(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDoPost15() throws IOException {
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

    NodeInfo.ConfigNodeInfo configNodeInfo = new NodeInfo.ConfigNodeInfo();
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

    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();
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
