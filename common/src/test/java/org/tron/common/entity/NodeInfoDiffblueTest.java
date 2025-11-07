package org.tron.common.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class NodeInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NodeInfo.ConfigNodeInfo}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setActiveNodeSize(int)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setAllowAdaptiveEnergy(long)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setAllowCreationOfContracts(long)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setBackupListenPort(int)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setBackupMemberSize(int)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setBackupPriority(int)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setCodeVersion(String)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setDbVersion(int)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setDiscoverEnable(boolean)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setListenPort(int)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setMaxConnectCount(int)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setMaxTimeRatio(double)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setMinParticipationRate(int)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setMinTimeRatio(double)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setP2pVersion(String)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setPassiveNodeSize(int)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setSameIpMaxConnectCount(int)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setSendNodeSize(int)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setSupportConstant(boolean)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#setVersionNum(String)}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getActiveNodeSize()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getAllowAdaptiveEnergy()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getAllowCreationOfContracts()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getBackupListenPort()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getBackupMemberSize()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getBackupPriority()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getCodeVersion()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getDbVersion()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getListenPort()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getMaxConnectCount()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getMaxTimeRatio()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getMinParticipationRate()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getMinTimeRatio()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getP2pVersion()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getPassiveNodeSize()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getSameIpMaxConnectCount()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getSendNodeSize()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#getVersionNum()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#isDiscoverEnable()}
   *   <li>{@link NodeInfo.ConfigNodeInfo#isSupportConstant()}
   * </ul>
   */
  @Test
  public void testConfigNodeInfoGettersAndSetters() {
    // Arrange and Act
    NodeInfo.ConfigNodeInfo actualConfigNodeInfo = new NodeInfo.ConfigNodeInfo();
    NodeInfo.ConfigNodeInfo actualSetActiveNodeSizeResult = actualConfigNodeInfo.setActiveNodeSize(3);
    NodeInfo.ConfigNodeInfo actualSetAllowAdaptiveEnergyResult = actualConfigNodeInfo.setAllowAdaptiveEnergy(1L);
    NodeInfo.ConfigNodeInfo actualSetAllowCreationOfContractsResult = actualConfigNodeInfo
        .setAllowCreationOfContracts(1L);
    NodeInfo.ConfigNodeInfo actualSetBackupListenPortResult = actualConfigNodeInfo.setBackupListenPort(8080);
    NodeInfo.ConfigNodeInfo actualSetBackupMemberSizeResult = actualConfigNodeInfo.setBackupMemberSize(3);
    NodeInfo.ConfigNodeInfo actualSetBackupPriorityResult = actualConfigNodeInfo.setBackupPriority(1);
    NodeInfo.ConfigNodeInfo actualSetCodeVersionResult = actualConfigNodeInfo.setCodeVersion("1.0.2");
    NodeInfo.ConfigNodeInfo actualSetDbVersionResult = actualConfigNodeInfo.setDbVersion(1);
    NodeInfo.ConfigNodeInfo actualSetDiscoverEnableResult = actualConfigNodeInfo.setDiscoverEnable(true);
    NodeInfo.ConfigNodeInfo actualSetListenPortResult = actualConfigNodeInfo.setListenPort(8080);
    NodeInfo.ConfigNodeInfo actualSetMaxConnectCountResult = actualConfigNodeInfo.setMaxConnectCount(3);
    NodeInfo.ConfigNodeInfo actualSetMaxTimeRatioResult = actualConfigNodeInfo.setMaxTimeRatio(10.0d);
    NodeInfo.ConfigNodeInfo actualSetMinParticipationRateResult = actualConfigNodeInfo.setMinParticipationRate(1);
    NodeInfo.ConfigNodeInfo actualSetMinTimeRatioResult = actualConfigNodeInfo.setMinTimeRatio(10.0d);
    NodeInfo.ConfigNodeInfo actualSetP2pVersionResult = actualConfigNodeInfo.setP2pVersion("1.0.2");
    NodeInfo.ConfigNodeInfo actualSetPassiveNodeSizeResult = actualConfigNodeInfo.setPassiveNodeSize(3);
    NodeInfo.ConfigNodeInfo actualSetSameIpMaxConnectCountResult = actualConfigNodeInfo.setSameIpMaxConnectCount(3);
    NodeInfo.ConfigNodeInfo actualSetSendNodeSizeResult = actualConfigNodeInfo.setSendNodeSize(3);
    NodeInfo.ConfigNodeInfo actualSetSupportConstantResult = actualConfigNodeInfo.setSupportConstant(true);
    actualConfigNodeInfo.setVersionNum("1.0.2");
    int actualActiveNodeSize = actualConfigNodeInfo.getActiveNodeSize();
    long actualAllowAdaptiveEnergy = actualConfigNodeInfo.getAllowAdaptiveEnergy();
    long actualAllowCreationOfContracts = actualConfigNodeInfo.getAllowCreationOfContracts();
    int actualBackupListenPort = actualConfigNodeInfo.getBackupListenPort();
    int actualBackupMemberSize = actualConfigNodeInfo.getBackupMemberSize();
    int actualBackupPriority = actualConfigNodeInfo.getBackupPriority();
    String actualCodeVersion = actualConfigNodeInfo.getCodeVersion();
    int actualDbVersion = actualConfigNodeInfo.getDbVersion();
    int actualListenPort = actualConfigNodeInfo.getListenPort();
    int actualMaxConnectCount = actualConfigNodeInfo.getMaxConnectCount();
    double actualMaxTimeRatio = actualConfigNodeInfo.getMaxTimeRatio();
    int actualMinParticipationRate = actualConfigNodeInfo.getMinParticipationRate();
    double actualMinTimeRatio = actualConfigNodeInfo.getMinTimeRatio();
    String actualP2pVersion = actualConfigNodeInfo.getP2pVersion();
    int actualPassiveNodeSize = actualConfigNodeInfo.getPassiveNodeSize();
    int actualSameIpMaxConnectCount = actualConfigNodeInfo.getSameIpMaxConnectCount();
    int actualSendNodeSize = actualConfigNodeInfo.getSendNodeSize();
    String actualVersionNum = actualConfigNodeInfo.getVersionNum();
    boolean actualIsDiscoverEnableResult = actualConfigNodeInfo.isDiscoverEnable();

    // Assert that nothing has changed
    assertEquals("1.0.2", actualCodeVersion);
    assertEquals("1.0.2", actualP2pVersion);
    assertEquals("1.0.2", actualVersionNum);
    assertEquals(1, actualBackupPriority);
    assertEquals(1, actualDbVersion);
    assertEquals(1, actualMinParticipationRate);
    assertEquals(10.0d, actualMaxTimeRatio, 0.0);
    assertEquals(10.0d, actualMinTimeRatio, 0.0);
    assertEquals(1L, actualAllowAdaptiveEnergy);
    assertEquals(1L, actualAllowCreationOfContracts);
    assertEquals(3, actualActiveNodeSize);
    assertEquals(3, actualBackupMemberSize);
    assertEquals(3, actualMaxConnectCount);
    assertEquals(3, actualPassiveNodeSize);
    assertEquals(3, actualSameIpMaxConnectCount);
    assertEquals(3, actualSendNodeSize);
    assertEquals(8080, actualBackupListenPort);
    assertEquals(8080, actualListenPort);
    assertTrue(actualIsDiscoverEnableResult);
    assertTrue(actualConfigNodeInfo.isSupportConstant());
    assertSame(actualConfigNodeInfo, actualSetActiveNodeSizeResult);
    assertSame(actualConfigNodeInfo, actualSetAllowAdaptiveEnergyResult);
    assertSame(actualConfigNodeInfo, actualSetAllowCreationOfContractsResult);
    assertSame(actualConfigNodeInfo, actualSetBackupListenPortResult);
    assertSame(actualConfigNodeInfo, actualSetBackupMemberSizeResult);
    assertSame(actualConfigNodeInfo, actualSetBackupPriorityResult);
    assertSame(actualConfigNodeInfo, actualSetCodeVersionResult);
    assertSame(actualConfigNodeInfo, actualSetDbVersionResult);
    assertSame(actualConfigNodeInfo, actualSetDiscoverEnableResult);
    assertSame(actualConfigNodeInfo, actualSetListenPortResult);
    assertSame(actualConfigNodeInfo, actualSetMaxConnectCountResult);
    assertSame(actualConfigNodeInfo, actualSetMaxTimeRatioResult);
    assertSame(actualConfigNodeInfo, actualSetMinParticipationRateResult);
    assertSame(actualConfigNodeInfo, actualSetMinTimeRatioResult);
    assertSame(actualConfigNodeInfo, actualSetP2pVersionResult);
    assertSame(actualConfigNodeInfo, actualSetPassiveNodeSizeResult);
    assertSame(actualConfigNodeInfo, actualSetSameIpMaxConnectCountResult);
    assertSame(actualConfigNodeInfo, actualSetSendNodeSizeResult);
    assertSame(actualConfigNodeInfo, actualSetSupportConstantResult);
  }

  /**
   * Method under test: {@link NodeInfo#getPeerList()}
   */
  @Test
  public void testGetPeerList() {
    // Arrange, Act and Assert
    assertTrue((new NodeInfo()).getPeerList().isEmpty());
  }

  /**
   * Method under test: {@link NodeInfo#getPeerList()}
   */
  @Test
  public void testGetPeerList2() {
    // Arrange
    HashMap<String, String> cheatWitnessInfoMap = new HashMap<>();
    cheatWitnessInfoMap.computeIfPresent("foo", mock(BiFunction.class));

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setCheatWitnessInfoMap(cheatWitnessInfoMap);

    // Act and Assert
    assertTrue(nodeInfo.getPeerList().isEmpty());
  }

  /**
   * Method under test: {@link NodeInfo.MachineInfo#getDeadLockThreadInfoList()}
   */
  @Test
  public void testMachineInfoGetDeadLockThreadInfoList() {
    // Arrange, Act and Assert
    assertTrue((new NodeInfo.MachineInfo()).getDeadLockThreadInfoList().isEmpty());
  }

  /**
   * Method under test: {@link NodeInfo.MachineInfo#getMemoryDescInfoList()}
   */
  @Test
  public void testMachineInfoGetMemoryDescInfoList() {
    // Arrange, Act and Assert
    assertTrue((new NodeInfo.MachineInfo()).getMemoryDescInfoList().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NodeInfo.MachineInfo}
   *   <li>{@link NodeInfo.MachineInfo#setCpuCount(int)}
   *   <li>{@link NodeInfo.MachineInfo#setCpuRate(double)}
   *   <li>{@link NodeInfo.MachineInfo#setDeadLockThreadCount(int)}
   *   <li>{@link NodeInfo.MachineInfo#setFreeMemory(long)}
   *   <li>{@link NodeInfo.MachineInfo#setJavaVersion(String)}
   *   <li>{@link NodeInfo.MachineInfo#setJvmFreeMemory(long)}
   *   <li>{@link NodeInfo.MachineInfo#setJvmTotalMemory(long)}
   *   <li>{@link NodeInfo.MachineInfo#setOsName(String)}
   *   <li>{@link NodeInfo.MachineInfo#setProcessCpuRate(double)}
   *   <li>{@link NodeInfo.MachineInfo#setThreadCount(int)}
   *   <li>{@link NodeInfo.MachineInfo#setTotalMemory(long)}
   *   <li>{@link NodeInfo.MachineInfo#getCpuCount()}
   *   <li>{@link NodeInfo.MachineInfo#getCpuRate()}
   *   <li>{@link NodeInfo.MachineInfo#getDeadLockThreadCount()}
   *   <li>{@link NodeInfo.MachineInfo#getFreeMemory()}
   *   <li>{@link NodeInfo.MachineInfo#getJavaVersion()}
   *   <li>{@link NodeInfo.MachineInfo#getJvmFreeMemory()}
   *   <li>{@link NodeInfo.MachineInfo#getJvmTotalMemory()}
   *   <li>{@link NodeInfo.MachineInfo#getOsName()}
   *   <li>{@link NodeInfo.MachineInfo#getProcessCpuRate()}
   *   <li>{@link NodeInfo.MachineInfo#getThreadCount()}
   *   <li>{@link NodeInfo.MachineInfo#getTotalMemory()}
   * </ul>
   */
  @Test
  public void testMachineInfoGettersAndSetters() {
    // Arrange and Act
    NodeInfo.MachineInfo actualMachineInfo = new NodeInfo.MachineInfo();
    NodeInfo.MachineInfo actualSetCpuCountResult = actualMachineInfo.setCpuCount(3);
    NodeInfo.MachineInfo actualSetCpuRateResult = actualMachineInfo.setCpuRate(10.0d);
    NodeInfo.MachineInfo actualSetDeadLockThreadCountResult = actualMachineInfo.setDeadLockThreadCount(3);
    NodeInfo.MachineInfo actualSetFreeMemoryResult = actualMachineInfo.setFreeMemory(1L);
    NodeInfo.MachineInfo actualSetJavaVersionResult = actualMachineInfo.setJavaVersion("1.0.2");
    NodeInfo.MachineInfo actualSetJvmFreeMemoryResult = actualMachineInfo.setJvmFreeMemory(1L);
    NodeInfo.MachineInfo actualSetJvmTotalMemoryResult = actualMachineInfo.setJvmTotalMemory(1L);
    NodeInfo.MachineInfo actualSetOsNameResult = actualMachineInfo.setOsName("Os Name");
    NodeInfo.MachineInfo actualSetProcessCpuRateResult = actualMachineInfo.setProcessCpuRate(10.0d);
    NodeInfo.MachineInfo actualSetThreadCountResult = actualMachineInfo.setThreadCount(3);
    NodeInfo.MachineInfo actualSetTotalMemoryResult = actualMachineInfo.setTotalMemory(1L);
    int actualCpuCount = actualMachineInfo.getCpuCount();
    double actualCpuRate = actualMachineInfo.getCpuRate();
    int actualDeadLockThreadCount = actualMachineInfo.getDeadLockThreadCount();
    long actualFreeMemory = actualMachineInfo.getFreeMemory();
    String actualJavaVersion = actualMachineInfo.getJavaVersion();
    long actualJvmFreeMemory = actualMachineInfo.getJvmFreeMemory();
    long actualJvmTotalMemory = actualMachineInfo.getJvmTotalMemory();
    String actualOsName = actualMachineInfo.getOsName();
    double actualProcessCpuRate = actualMachineInfo.getProcessCpuRate();
    int actualThreadCount = actualMachineInfo.getThreadCount();

    // Assert
    assertEquals("1.0.2", actualJavaVersion);
    assertEquals("Os Name", actualOsName);
    assertEquals(10.0d, actualCpuRate, 0.0);
    assertEquals(10.0d, actualProcessCpuRate, 0.0);
    assertEquals(1L, actualFreeMemory);
    assertEquals(1L, actualJvmFreeMemory);
    assertEquals(1L, actualJvmTotalMemory);
    assertEquals(1L, actualMachineInfo.getTotalMemory());
    assertEquals(3, actualCpuCount);
    assertEquals(3, actualDeadLockThreadCount);
    assertEquals(3, actualThreadCount);
    assertSame(actualMachineInfo, actualSetCpuCountResult);
    assertSame(actualMachineInfo, actualSetCpuRateResult);
    assertSame(actualMachineInfo, actualSetDeadLockThreadCountResult);
    assertSame(actualMachineInfo, actualSetFreeMemoryResult);
    assertSame(actualMachineInfo, actualSetJavaVersionResult);
    assertSame(actualMachineInfo, actualSetJvmFreeMemoryResult);
    assertSame(actualMachineInfo, actualSetJvmTotalMemoryResult);
    assertSame(actualMachineInfo, actualSetOsNameResult);
    assertSame(actualMachineInfo, actualSetProcessCpuRateResult);
    assertSame(actualMachineInfo, actualSetThreadCountResult);
    assertSame(actualMachineInfo, actualSetTotalMemoryResult);
  }

  /**
   * Method under test:
   * {@link NodeInfo.MachineInfo#setDeadLockThreadInfoList(List)}
   */
  @Test
  public void testMachineInfoSetDeadLockThreadInfoList() {
    // Arrange
    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();

    // Act
    NodeInfo.MachineInfo actualSetDeadLockThreadInfoListResult = machineInfo
        .setDeadLockThreadInfoList(new ArrayList<>());

    // Assert
    assertTrue(machineInfo.getDeadLockThreadInfoList().isEmpty());
    assertSame(machineInfo, actualSetDeadLockThreadInfoListResult);
  }

  /**
   * Method under test:
   * {@link NodeInfo.MachineInfo#setDeadLockThreadInfoList(List)}
   */
  @Test
  public void testMachineInfoSetDeadLockThreadInfoList2() {
    // Arrange
    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();

    NodeInfo.MachineInfo.DeadLockThreadInfo deadLockThreadInfo = new NodeInfo.MachineInfo.DeadLockThreadInfo();
    deadLockThreadInfo.setBlockTime(1L);
    deadLockThreadInfo.setLockName("Lock Name");
    deadLockThreadInfo.setLockOwner("Lock Owner");
    deadLockThreadInfo.setName("Name");
    deadLockThreadInfo.setStackTrace("Stack Trace");
    deadLockThreadInfo.setState("MD");
    deadLockThreadInfo.setWaitTime(1L);

    ArrayList<NodeInfo.MachineInfo.DeadLockThreadInfo> deadLockThreadInfoList = new ArrayList<>();
    deadLockThreadInfoList.add(deadLockThreadInfo);

    // Act
    NodeInfo.MachineInfo actualSetDeadLockThreadInfoListResult = machineInfo
        .setDeadLockThreadInfoList(deadLockThreadInfoList);

    // Assert
    List<NodeInfo.MachineInfo.DeadLockThreadInfo> deadLockThreadInfoList2 = machineInfo.getDeadLockThreadInfoList();
    assertEquals(1, deadLockThreadInfoList2.size());
    assertSame(machineInfo, actualSetDeadLockThreadInfoListResult);
    assertSame(deadLockThreadInfo, deadLockThreadInfoList2.get(0));
  }

  /**
   * Method under test:
   * {@link NodeInfo.MachineInfo#setDeadLockThreadInfoList(List)}
   */
  @Test
  public void testMachineInfoSetDeadLockThreadInfoList3() {
    // Arrange
    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();

    NodeInfo.MachineInfo.DeadLockThreadInfo deadLockThreadInfo = new NodeInfo.MachineInfo.DeadLockThreadInfo();
    deadLockThreadInfo.setBlockTime(1L);
    deadLockThreadInfo.setLockName("Lock Name");
    deadLockThreadInfo.setLockOwner("Lock Owner");
    deadLockThreadInfo.setName("Name");
    deadLockThreadInfo.setStackTrace("Stack Trace");
    deadLockThreadInfo.setState("MD");
    deadLockThreadInfo.setWaitTime(1L);

    NodeInfo.MachineInfo.DeadLockThreadInfo deadLockThreadInfo2 = new NodeInfo.MachineInfo.DeadLockThreadInfo();
    deadLockThreadInfo2.setBlockTime(0L);
    deadLockThreadInfo2.setLockName("42");
    deadLockThreadInfo2.setLockOwner("42");
    deadLockThreadInfo2.setName("42");
    deadLockThreadInfo2.setStackTrace("42");
    deadLockThreadInfo2.setState("State");
    deadLockThreadInfo2.setWaitTime(0L);

    ArrayList<NodeInfo.MachineInfo.DeadLockThreadInfo> deadLockThreadInfoList = new ArrayList<>();
    deadLockThreadInfoList.add(deadLockThreadInfo2);
    deadLockThreadInfoList.add(deadLockThreadInfo);

    // Act
    NodeInfo.MachineInfo actualSetDeadLockThreadInfoListResult = machineInfo
        .setDeadLockThreadInfoList(deadLockThreadInfoList);

    // Assert
    assertEquals(deadLockThreadInfoList, machineInfo.getDeadLockThreadInfoList());
    assertSame(machineInfo, actualSetDeadLockThreadInfoListResult);
  }

  /**
   * Method under test: {@link NodeInfo.MachineInfo#setMemoryDescInfoList(List)}
   */
  @Test
  public void testMachineInfoSetMemoryDescInfoList() {
    // Arrange
    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();

    // Act
    NodeInfo.MachineInfo actualSetMemoryDescInfoListResult = machineInfo.setMemoryDescInfoList(new ArrayList<>());

    // Assert
    assertTrue(machineInfo.getMemoryDescInfoList().isEmpty());
    assertSame(machineInfo, actualSetMemoryDescInfoListResult);
  }

  /**
   * Method under test: {@link NodeInfo.MachineInfo#setMemoryDescInfoList(List)}
   */
  @Test
  public void testMachineInfoSetMemoryDescInfoList2() {
    // Arrange
    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();

    NodeInfo.MachineInfo.MemoryDescInfo memoryDescInfo = new NodeInfo.MachineInfo.MemoryDescInfo();
    memoryDescInfo.setInitSize(3L);
    memoryDescInfo.setMaxSize(3L);
    memoryDescInfo.setName("Name");
    memoryDescInfo.setUseRate(10.0d);
    memoryDescInfo.setUseSize(3L);

    ArrayList<NodeInfo.MachineInfo.MemoryDescInfo> memoryDescInfoList = new ArrayList<>();
    memoryDescInfoList.add(memoryDescInfo);

    // Act
    NodeInfo.MachineInfo actualSetMemoryDescInfoListResult = machineInfo.setMemoryDescInfoList(memoryDescInfoList);

    // Assert
    List<NodeInfo.MachineInfo.MemoryDescInfo> memoryDescInfoList2 = machineInfo.getMemoryDescInfoList();
    assertEquals(1, memoryDescInfoList2.size());
    assertSame(machineInfo, actualSetMemoryDescInfoListResult);
    assertSame(memoryDescInfo, memoryDescInfoList2.get(0));
  }

  /**
   * Method under test: {@link NodeInfo.MachineInfo#setMemoryDescInfoList(List)}
   */
  @Test
  public void testMachineInfoSetMemoryDescInfoList3() {
    // Arrange
    NodeInfo.MachineInfo machineInfo = new NodeInfo.MachineInfo();

    NodeInfo.MachineInfo.MemoryDescInfo memoryDescInfo = new NodeInfo.MachineInfo.MemoryDescInfo();
    memoryDescInfo.setInitSize(3L);
    memoryDescInfo.setMaxSize(3L);
    memoryDescInfo.setName("Name");
    memoryDescInfo.setUseRate(10.0d);
    memoryDescInfo.setUseSize(3L);

    NodeInfo.MachineInfo.MemoryDescInfo memoryDescInfo2 = new NodeInfo.MachineInfo.MemoryDescInfo();
    memoryDescInfo2.setInitSize(1L);
    memoryDescInfo2.setMaxSize(1L);
    memoryDescInfo2.setName("42");
    memoryDescInfo2.setUseRate(0.5d);
    memoryDescInfo2.setUseSize(1L);

    ArrayList<NodeInfo.MachineInfo.MemoryDescInfo> memoryDescInfoList = new ArrayList<>();
    memoryDescInfoList.add(memoryDescInfo2);
    memoryDescInfoList.add(memoryDescInfo);

    // Act
    NodeInfo.MachineInfo actualSetMemoryDescInfoListResult = machineInfo.setMemoryDescInfoList(memoryDescInfoList);

    // Assert
    assertEquals(memoryDescInfoList, machineInfo.getMemoryDescInfoList());
    assertSame(machineInfo, actualSetMemoryDescInfoListResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link NodeInfo.MachineInfo.DeadLockThreadInfo}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#setBlockTime(long)}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#setLockName(String)}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#setLockOwner(String)}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#setName(String)}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#setStackTrace(String)}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#setState(String)}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#setWaitTime(long)}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#getBlockTime()}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#getLockName()}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#getLockOwner()}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#getName()}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#getStackTrace()}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#getState()}
   *   <li>{@link NodeInfo.MachineInfo.DeadLockThreadInfo#getWaitTime()}
   * </ul>
   */
  @Test
  public void testMachineInfo_DeadLockThreadInfoGettersAndSetters() {
    // Arrange and Act
    NodeInfo.MachineInfo.DeadLockThreadInfo actualDeadLockThreadInfo = new NodeInfo.MachineInfo.DeadLockThreadInfo();
    NodeInfo.MachineInfo.DeadLockThreadInfo actualSetBlockTimeResult = actualDeadLockThreadInfo.setBlockTime(1L);
    NodeInfo.MachineInfo.DeadLockThreadInfo actualSetLockNameResult = actualDeadLockThreadInfo.setLockName("Lock Name");
    NodeInfo.MachineInfo.DeadLockThreadInfo actualSetLockOwnerResult = actualDeadLockThreadInfo
        .setLockOwner("Lock Owner");
    NodeInfo.MachineInfo.DeadLockThreadInfo actualSetNameResult = actualDeadLockThreadInfo.setName("Name");
    NodeInfo.MachineInfo.DeadLockThreadInfo actualSetStackTraceResult = actualDeadLockThreadInfo
        .setStackTrace("Stack Trace");
    NodeInfo.MachineInfo.DeadLockThreadInfo actualSetStateResult = actualDeadLockThreadInfo.setState("MD");
    NodeInfo.MachineInfo.DeadLockThreadInfo actualSetWaitTimeResult = actualDeadLockThreadInfo.setWaitTime(1L);
    long actualBlockTime = actualDeadLockThreadInfo.getBlockTime();
    String actualLockName = actualDeadLockThreadInfo.getLockName();
    String actualLockOwner = actualDeadLockThreadInfo.getLockOwner();
    String actualName = actualDeadLockThreadInfo.getName();
    String actualStackTrace = actualDeadLockThreadInfo.getStackTrace();
    String actualState = actualDeadLockThreadInfo.getState();

    // Assert
    assertEquals("Lock Name", actualLockName);
    assertEquals("Lock Owner", actualLockOwner);
    assertEquals("MD", actualState);
    assertEquals("Name", actualName);
    assertEquals("Stack Trace", actualStackTrace);
    assertEquals(1L, actualBlockTime);
    assertEquals(1L, actualDeadLockThreadInfo.getWaitTime());
    assertSame(actualDeadLockThreadInfo, actualSetBlockTimeResult);
    assertSame(actualDeadLockThreadInfo, actualSetLockNameResult);
    assertSame(actualDeadLockThreadInfo, actualSetLockOwnerResult);
    assertSame(actualDeadLockThreadInfo, actualSetNameResult);
    assertSame(actualDeadLockThreadInfo, actualSetStackTraceResult);
    assertSame(actualDeadLockThreadInfo, actualSetStateResult);
    assertSame(actualDeadLockThreadInfo, actualSetWaitTimeResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link NodeInfo.MachineInfo.MemoryDescInfo}
   *   <li>{@link NodeInfo.MachineInfo.MemoryDescInfo#setInitSize(long)}
   *   <li>{@link NodeInfo.MachineInfo.MemoryDescInfo#setMaxSize(long)}
   *   <li>{@link NodeInfo.MachineInfo.MemoryDescInfo#setName(String)}
   *   <li>{@link NodeInfo.MachineInfo.MemoryDescInfo#setUseRate(double)}
   *   <li>{@link NodeInfo.MachineInfo.MemoryDescInfo#setUseSize(long)}
   *   <li>{@link NodeInfo.MachineInfo.MemoryDescInfo#getInitSize()}
   *   <li>{@link NodeInfo.MachineInfo.MemoryDescInfo#getMaxSize()}
   *   <li>{@link NodeInfo.MachineInfo.MemoryDescInfo#getName()}
   *   <li>{@link NodeInfo.MachineInfo.MemoryDescInfo#getUseRate()}
   *   <li>{@link NodeInfo.MachineInfo.MemoryDescInfo#getUseSize()}
   * </ul>
   */
  @Test
  public void testMachineInfo_MemoryDescInfoGettersAndSetters() {
    // Arrange and Act
    NodeInfo.MachineInfo.MemoryDescInfo actualMemoryDescInfo = new NodeInfo.MachineInfo.MemoryDescInfo();
    NodeInfo.MachineInfo.MemoryDescInfo actualSetInitSizeResult = actualMemoryDescInfo.setInitSize(3L);
    NodeInfo.MachineInfo.MemoryDescInfo actualSetMaxSizeResult = actualMemoryDescInfo.setMaxSize(3L);
    NodeInfo.MachineInfo.MemoryDescInfo actualSetNameResult = actualMemoryDescInfo.setName("Name");
    NodeInfo.MachineInfo.MemoryDescInfo actualSetUseRateResult = actualMemoryDescInfo.setUseRate(10.0d);
    NodeInfo.MachineInfo.MemoryDescInfo actualSetUseSizeResult = actualMemoryDescInfo.setUseSize(3L);
    long actualInitSize = actualMemoryDescInfo.getInitSize();
    long actualMaxSize = actualMemoryDescInfo.getMaxSize();
    String actualName = actualMemoryDescInfo.getName();
    double actualUseRate = actualMemoryDescInfo.getUseRate();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(10.0d, actualUseRate, 0.0);
    assertEquals(3L, actualInitSize);
    assertEquals(3L, actualMaxSize);
    assertEquals(3L, actualMemoryDescInfo.getUseSize());
    assertSame(actualMemoryDescInfo, actualSetInitSizeResult);
    assertSame(actualMemoryDescInfo, actualSetMaxSizeResult);
    assertSame(actualMemoryDescInfo, actualSetNameResult);
    assertSame(actualMemoryDescInfo, actualSetUseRateResult);
    assertSame(actualMemoryDescInfo, actualSetUseSizeResult);
  }

  /**
   * Method under test: {@link NodeInfo#setPeerList(List)}
   */
  @Test
  public void testSetPeerList() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();

    // Act
    NodeInfo actualSetPeerListResult = nodeInfo.setPeerList(new ArrayList<>());

    // Assert
    assertTrue(nodeInfo.getPeerList().isEmpty());
    assertSame(nodeInfo, actualSetPeerListResult);
  }

  /**
   * Method under test: {@link NodeInfo#setPeerList(List)}
   */
  @Test
  public void testSetPeerList2() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();

    PeerInfo peerInfo = new PeerInfo();
    peerInfo.setActive(true);
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
    peerInfo.setNeedSyncFromPeer(true);
    peerInfo.setNeedSyncFromUs(true);
    peerInfo.setNodeCount(3);
    peerInfo.setNodeId("42");
    peerInfo.setPort(8080);
    peerInfo.setRemainNum(1L);
    peerInfo.setRemoteDisconnectReason("Just cause");
    peerInfo.setScore(3);
    peerInfo.setSyncBlockRequestedSize(3);
    peerInfo.setSyncFlag(true);
    peerInfo.setSyncToFetchSize(3);
    peerInfo.setSyncToFetchSizePeekNum(3L);
    peerInfo.setUnFetchSynNum(1L);

    ArrayList<PeerInfo> peerList = new ArrayList<>();
    peerList.add(peerInfo);

    // Act
    NodeInfo actualSetPeerListResult = nodeInfo.setPeerList(peerList);

    // Assert
    List<PeerInfo> peerList2 = nodeInfo.getPeerList();
    assertEquals(1, peerList2.size());
    assertSame(nodeInfo, actualSetPeerListResult);
    assertSame(peerInfo, peerList2.get(0));
  }

  /**
   * Method under test: {@link NodeInfo#setPeerList(List)}
   */
  @Test
  public void testSetPeerList3() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();

    PeerInfo peerInfo = new PeerInfo();
    peerInfo.setActive(true);
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
    peerInfo.setNeedSyncFromPeer(true);
    peerInfo.setNeedSyncFromUs(true);
    peerInfo.setNodeCount(3);
    peerInfo.setNodeId("42");
    peerInfo.setPort(8080);
    peerInfo.setRemainNum(1L);
    peerInfo.setRemoteDisconnectReason("Just cause");
    peerInfo.setScore(3);
    peerInfo.setSyncBlockRequestedSize(3);
    peerInfo.setSyncFlag(true);
    peerInfo.setSyncToFetchSize(3);
    peerInfo.setSyncToFetchSizePeekNum(3L);
    peerInfo.setUnFetchSynNum(1L);

    PeerInfo peerInfo2 = new PeerInfo();
    peerInfo2.setActive(false);
    peerInfo2.setAvgLatency(0.5d);
    peerInfo2.setBlockInPorcSize(1);
    peerInfo2.setConnectTime(0L);
    peerInfo2.setDisconnectTimes(0);
    peerInfo2.setHeadBlockTimeWeBothHave(0L);
    peerInfo2.setHeadBlockWeBothHave("42");
    peerInfo2.setHost("Host");
    peerInfo2.setInFlow(0L);
    peerInfo2.setLastBlockUpdateTime(0L);
    peerInfo2.setLastSyncBlock("42");
    peerInfo2.setLocalDisconnectReason("Local Disconnect Reason");
    peerInfo2.setNeedSyncFromPeer(false);
    peerInfo2.setNeedSyncFromUs(false);
    peerInfo2.setNodeCount(1);
    peerInfo2.setNodeId("Node Id");
    peerInfo2.setPort(1);
    peerInfo2.setRemainNum(0L);
    peerInfo2.setRemoteDisconnectReason("Remote Disconnect Reason");
    peerInfo2.setScore(1);
    peerInfo2.setSyncBlockRequestedSize(1);
    peerInfo2.setSyncFlag(false);
    peerInfo2.setSyncToFetchSize(1);
    peerInfo2.setSyncToFetchSizePeekNum(1L);
    peerInfo2.setUnFetchSynNum(0L);

    ArrayList<PeerInfo> peerList = new ArrayList<>();
    peerList.add(peerInfo2);
    peerList.add(peerInfo);

    // Act
    NodeInfo actualSetPeerListResult = nodeInfo.setPeerList(peerList);

    // Assert
    assertEquals(peerList, nodeInfo.getPeerList());
    assertSame(nodeInfo, actualSetPeerListResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NodeInfo}
   *   <li>{@link NodeInfo#setActiveConnectCount(int)}
   *   <li>{@link NodeInfo#setBeginSyncNum(long)}
   *   <li>{@link NodeInfo#setBlock(String)}
   *   <li>{@link NodeInfo#setCheatWitnessInfoMap(Map)}
   *   <li>{@link NodeInfo#setConfigNodeInfo(NodeInfo.ConfigNodeInfo)}
   *   <li>{@link NodeInfo#setCurrentConnectCount(int)}
   *   <li>{@link NodeInfo#setMachineInfo(NodeInfo.MachineInfo)}
   *   <li>{@link NodeInfo#setPassiveConnectCount(int)}
   *   <li>{@link NodeInfo#setSolidityBlock(String)}
   *   <li>{@link NodeInfo#setTotalFlow(long)}
   *   <li>{@link NodeInfo#getActiveConnectCount()}
   *   <li>{@link NodeInfo#getBeginSyncNum()}
   *   <li>{@link NodeInfo#getBlock()}
   *   <li>{@link NodeInfo#getCheatWitnessInfoMap()}
   *   <li>{@link NodeInfo#getConfigNodeInfo()}
   *   <li>{@link NodeInfo#getCurrentConnectCount()}
   *   <li>{@link NodeInfo#getMachineInfo()}
   *   <li>{@link NodeInfo#getPassiveConnectCount()}
   *   <li>{@link NodeInfo#getSolidityBlock()}
   *   <li>{@link NodeInfo#getTotalFlow()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NodeInfo actualNodeInfo = new NodeInfo();
    NodeInfo actualSetActiveConnectCountResult = actualNodeInfo.setActiveConnectCount(3);
    NodeInfo actualSetBeginSyncNumResult = actualNodeInfo.setBeginSyncNum(1L);
    NodeInfo actualSetBlockResult = actualNodeInfo.setBlock("Block");
    HashMap<String, String> cheatWitnessInfoMap = new HashMap<>();
    NodeInfo actualSetCheatWitnessInfoMapResult = actualNodeInfo.setCheatWitnessInfoMap(cheatWitnessInfoMap);
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
    NodeInfo actualSetConfigNodeInfoResult = actualNodeInfo.setConfigNodeInfo(configNodeInfo);
    NodeInfo actualSetCurrentConnectCountResult = actualNodeInfo.setCurrentConnectCount(3);
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
    NodeInfo actualSetMachineInfoResult = actualNodeInfo.setMachineInfo(machineInfo);
    NodeInfo actualSetPassiveConnectCountResult = actualNodeInfo.setPassiveConnectCount(3);
    NodeInfo actualSetSolidityBlockResult = actualNodeInfo.setSolidityBlock("Solidity Block");
    NodeInfo actualSetTotalFlowResult = actualNodeInfo.setTotalFlow(1L);
    int actualActiveConnectCount = actualNodeInfo.getActiveConnectCount();
    long actualBeginSyncNum = actualNodeInfo.getBeginSyncNum();
    String actualBlock = actualNodeInfo.getBlock();
    Map<String, String> actualCheatWitnessInfoMap = actualNodeInfo.getCheatWitnessInfoMap();
    NodeInfo.ConfigNodeInfo actualConfigNodeInfo = actualNodeInfo.getConfigNodeInfo();
    int actualCurrentConnectCount = actualNodeInfo.getCurrentConnectCount();
    NodeInfo.MachineInfo actualMachineInfo = actualNodeInfo.getMachineInfo();
    int actualPassiveConnectCount = actualNodeInfo.getPassiveConnectCount();
    String actualSolidityBlock = actualNodeInfo.getSolidityBlock();

    // Assert
    assertEquals("Block", actualBlock);
    assertEquals("Solidity Block", actualSolidityBlock);
    assertEquals(1L, actualBeginSyncNum);
    assertEquals(1L, actualNodeInfo.getTotalFlow());
    assertEquals(3, actualActiveConnectCount);
    assertEquals(3, actualCurrentConnectCount);
    assertEquals(3, actualPassiveConnectCount);
    assertTrue(actualCheatWitnessInfoMap.isEmpty());
    assertSame(cheatWitnessInfoMap, actualCheatWitnessInfoMap);
    assertSame(actualNodeInfo, actualSetActiveConnectCountResult);
    assertSame(actualNodeInfo, actualSetBeginSyncNumResult);
    assertSame(actualNodeInfo, actualSetBlockResult);
    assertSame(actualNodeInfo, actualSetCheatWitnessInfoMapResult);
    assertSame(actualNodeInfo, actualSetConfigNodeInfoResult);
    assertSame(actualNodeInfo, actualSetCurrentConnectCountResult);
    assertSame(actualNodeInfo, actualSetMachineInfoResult);
    assertSame(actualNodeInfo, actualSetPassiveConnectCountResult);
    assertSame(actualNodeInfo, actualSetSolidityBlockResult);
    assertSame(actualNodeInfo, actualSetTotalFlowResult);
    assertSame(configNodeInfo, actualConfigNodeInfo);
    assertSame(machineInfo, actualMachineInfo);
  }
}
