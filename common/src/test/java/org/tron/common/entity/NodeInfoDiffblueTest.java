package org.tron.common.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSet;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.entity.NodeInfo.ConfigNodeInfo;
import org.tron.common.entity.NodeInfo.MachineInfo;
import org.tron.common.entity.NodeInfo.MachineInfo.DeadLockThreadInfo;
import org.tron.common.entity.NodeInfo.MachineInfo.MemoryDescInfo;
import org.tron.protos.Protocol;

public class NodeInfoDiffblueTest {
  /**
   * Test ConfigNodeInfo getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ConfigNodeInfo}
   *   <li>{@link ConfigNodeInfo#setActiveNodeSize(int)}
   *   <li>{@link ConfigNodeInfo#setAllowAdaptiveEnergy(long)}
   *   <li>{@link ConfigNodeInfo#setAllowCreationOfContracts(long)}
   *   <li>{@link ConfigNodeInfo#setBackupListenPort(int)}
   *   <li>{@link ConfigNodeInfo#setBackupMemberSize(int)}
   *   <li>{@link ConfigNodeInfo#setBackupPriority(int)}
   *   <li>{@link ConfigNodeInfo#setCodeVersion(String)}
   *   <li>{@link ConfigNodeInfo#setDbVersion(int)}
   *   <li>{@link ConfigNodeInfo#setDiscoverEnable(boolean)}
   *   <li>{@link ConfigNodeInfo#setListenPort(int)}
   *   <li>{@link ConfigNodeInfo#setMaxConnectCount(int)}
   *   <li>{@link ConfigNodeInfo#setMaxTimeRatio(double)}
   *   <li>{@link ConfigNodeInfo#setMinParticipationRate(int)}
   *   <li>{@link ConfigNodeInfo#setMinTimeRatio(double)}
   *   <li>{@link ConfigNodeInfo#setP2pVersion(String)}
   *   <li>{@link ConfigNodeInfo#setPassiveNodeSize(int)}
   *   <li>{@link ConfigNodeInfo#setSameIpMaxConnectCount(int)}
   *   <li>{@link ConfigNodeInfo#setSendNodeSize(int)}
   *   <li>{@link ConfigNodeInfo#setSupportConstant(boolean)}
   *   <li>{@link ConfigNodeInfo#setVersionNum(String)}
   *   <li>{@link ConfigNodeInfo#getActiveNodeSize()}
   *   <li>{@link ConfigNodeInfo#getAllowAdaptiveEnergy()}
   *   <li>{@link ConfigNodeInfo#getAllowCreationOfContracts()}
   *   <li>{@link ConfigNodeInfo#getBackupListenPort()}
   *   <li>{@link ConfigNodeInfo#getBackupMemberSize()}
   *   <li>{@link ConfigNodeInfo#getBackupPriority()}
   *   <li>{@link ConfigNodeInfo#getCodeVersion()}
   *   <li>{@link ConfigNodeInfo#getDbVersion()}
   *   <li>{@link ConfigNodeInfo#getListenPort()}
   *   <li>{@link ConfigNodeInfo#getMaxConnectCount()}
   *   <li>{@link ConfigNodeInfo#getMaxTimeRatio()}
   *   <li>{@link ConfigNodeInfo#getMinParticipationRate()}
   *   <li>{@link ConfigNodeInfo#getMinTimeRatio()}
   *   <li>{@link ConfigNodeInfo#getP2pVersion()}
   *   <li>{@link ConfigNodeInfo#getPassiveNodeSize()}
   *   <li>{@link ConfigNodeInfo#getSameIpMaxConnectCount()}
   *   <li>{@link ConfigNodeInfo#getSendNodeSize()}
   *   <li>{@link ConfigNodeInfo#getVersionNum()}
   *   <li>{@link ConfigNodeInfo#isDiscoverEnable()}
   *   <li>{@link ConfigNodeInfo#isSupportConstant()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConfigNodeInfo.<init>()",
    "int ConfigNodeInfo.getActiveNodeSize()",
    "long ConfigNodeInfo.getAllowAdaptiveEnergy()",
    "long ConfigNodeInfo.getAllowCreationOfContracts()",
    "int ConfigNodeInfo.getBackupListenPort()",
    "int ConfigNodeInfo.getBackupMemberSize()",
    "int ConfigNodeInfo.getBackupPriority()",
    "String ConfigNodeInfo.getCodeVersion()",
    "int ConfigNodeInfo.getDbVersion()",
    "int ConfigNodeInfo.getListenPort()",
    "int ConfigNodeInfo.getMaxConnectCount()",
    "double ConfigNodeInfo.getMaxTimeRatio()",
    "int ConfigNodeInfo.getMinParticipationRate()",
    "double ConfigNodeInfo.getMinTimeRatio()",
    "String ConfigNodeInfo.getP2pVersion()",
    "int ConfigNodeInfo.getPassiveNodeSize()",
    "int ConfigNodeInfo.getSameIpMaxConnectCount()",
    "int ConfigNodeInfo.getSendNodeSize()",
    "String ConfigNodeInfo.getVersionNum()",
    "boolean ConfigNodeInfo.isDiscoverEnable()",
    "boolean ConfigNodeInfo.isSupportConstant()",
    "ConfigNodeInfo ConfigNodeInfo.setActiveNodeSize(int)",
    "ConfigNodeInfo ConfigNodeInfo.setAllowAdaptiveEnergy(long)",
    "ConfigNodeInfo ConfigNodeInfo.setAllowCreationOfContracts(long)",
    "ConfigNodeInfo ConfigNodeInfo.setBackupListenPort(int)",
    "ConfigNodeInfo ConfigNodeInfo.setBackupMemberSize(int)",
    "ConfigNodeInfo ConfigNodeInfo.setBackupPriority(int)",
    "ConfigNodeInfo ConfigNodeInfo.setCodeVersion(String)",
    "ConfigNodeInfo ConfigNodeInfo.setDbVersion(int)",
    "ConfigNodeInfo ConfigNodeInfo.setDiscoverEnable(boolean)",
    "ConfigNodeInfo ConfigNodeInfo.setListenPort(int)",
    "ConfigNodeInfo ConfigNodeInfo.setMaxConnectCount(int)",
    "ConfigNodeInfo ConfigNodeInfo.setMaxTimeRatio(double)",
    "ConfigNodeInfo ConfigNodeInfo.setMinParticipationRate(int)",
    "ConfigNodeInfo ConfigNodeInfo.setMinTimeRatio(double)",
    "ConfigNodeInfo ConfigNodeInfo.setP2pVersion(String)",
    "ConfigNodeInfo ConfigNodeInfo.setPassiveNodeSize(int)",
    "ConfigNodeInfo ConfigNodeInfo.setSameIpMaxConnectCount(int)",
    "ConfigNodeInfo ConfigNodeInfo.setSendNodeSize(int)",
    "ConfigNodeInfo ConfigNodeInfo.setSupportConstant(boolean)",
    "void ConfigNodeInfo.setVersionNum(String)"
  })
  public void testConfigNodeInfoGettersAndSetters() {
    // Arrange and Act
    ConfigNodeInfo actualConfigNodeInfo = new ConfigNodeInfo();
    ConfigNodeInfo actualSetActiveNodeSizeResult = actualConfigNodeInfo.setActiveNodeSize(3);
    ConfigNodeInfo actualSetAllowAdaptiveEnergyResult =
        actualConfigNodeInfo.setAllowAdaptiveEnergy(1L);
    ConfigNodeInfo actualSetAllowCreationOfContractsResult =
        actualConfigNodeInfo.setAllowCreationOfContracts(1L);
    ConfigNodeInfo actualSetBackupListenPortResult = actualConfigNodeInfo.setBackupListenPort(8080);
    ConfigNodeInfo actualSetBackupMemberSizeResult = actualConfigNodeInfo.setBackupMemberSize(3);
    ConfigNodeInfo actualSetBackupPriorityResult = actualConfigNodeInfo.setBackupPriority(1);
    ConfigNodeInfo actualSetCodeVersionResult = actualConfigNodeInfo.setCodeVersion("1.0.2");
    ConfigNodeInfo actualSetDbVersionResult = actualConfigNodeInfo.setDbVersion(1);
    ConfigNodeInfo actualSetDiscoverEnableResult = actualConfigNodeInfo.setDiscoverEnable(true);
    ConfigNodeInfo actualSetListenPortResult = actualConfigNodeInfo.setListenPort(8080);
    ConfigNodeInfo actualSetMaxConnectCountResult = actualConfigNodeInfo.setMaxConnectCount(3);
    ConfigNodeInfo actualSetMaxTimeRatioResult = actualConfigNodeInfo.setMaxTimeRatio(10.0d);
    ConfigNodeInfo actualSetMinParticipationRateResult =
        actualConfigNodeInfo.setMinParticipationRate(1);
    ConfigNodeInfo actualSetMinTimeRatioResult = actualConfigNodeInfo.setMinTimeRatio(10.0d);
    ConfigNodeInfo actualSetP2pVersionResult = actualConfigNodeInfo.setP2pVersion("1.0.2");
    ConfigNodeInfo actualSetPassiveNodeSizeResult = actualConfigNodeInfo.setPassiveNodeSize(3);
    ConfigNodeInfo actualSetSameIpMaxConnectCountResult =
        actualConfigNodeInfo.setSameIpMaxConnectCount(3);
    ConfigNodeInfo actualSetSendNodeSizeResult = actualConfigNodeInfo.setSendNodeSize(3);
    ConfigNodeInfo actualSetSupportConstantResult = actualConfigNodeInfo.setSupportConstant(true);
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

    // Assert
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
   * Test {@link NodeInfo#getPeerList()}.
   *
   * <p>Method under test: {@link NodeInfo#getPeerList()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List NodeInfo.getPeerList()"})
  public void testGetPeerList() {
    // Arrange, Act and Assert
    assertTrue(new NodeInfo().getPeerList().isEmpty());
  }

  /**
   * Test MachineInfo {@link MachineInfo#getDeadLockThreadInfoList()}.
   *
   * <p>Method under test: {@link MachineInfo#getDeadLockThreadInfoList()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List MachineInfo.getDeadLockThreadInfoList()"})
  public void testMachineInfoGetDeadLockThreadInfoList() {
    // Arrange, Act and Assert
    assertTrue(new MachineInfo().getDeadLockThreadInfoList().isEmpty());
  }

  /**
   * Test MachineInfo {@link MachineInfo#getMemoryDescInfoList()}.
   *
   * <p>Method under test: {@link MachineInfo#getMemoryDescInfoList()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List MachineInfo.getMemoryDescInfoList()"})
  public void testMachineInfoGetMemoryDescInfoList() {
    // Arrange, Act and Assert
    assertTrue(new MachineInfo().getMemoryDescInfoList().isEmpty());
  }

  /**
   * Test MachineInfo getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MachineInfo}
   *   <li>{@link MachineInfo#setCpuCount(int)}
   *   <li>{@link MachineInfo#setCpuRate(double)}
   *   <li>{@link MachineInfo#setDeadLockThreadCount(int)}
   *   <li>{@link MachineInfo#setFreeMemory(long)}
   *   <li>{@link MachineInfo#setJavaVersion(String)}
   *   <li>{@link MachineInfo#setJvmFreeMemory(long)}
   *   <li>{@link MachineInfo#setJvmTotalMemory(long)}
   *   <li>{@link MachineInfo#setOsName(String)}
   *   <li>{@link MachineInfo#setProcessCpuRate(double)}
   *   <li>{@link MachineInfo#setThreadCount(int)}
   *   <li>{@link MachineInfo#setTotalMemory(long)}
   *   <li>{@link MachineInfo#getCpuCount()}
   *   <li>{@link MachineInfo#getCpuRate()}
   *   <li>{@link MachineInfo#getDeadLockThreadCount()}
   *   <li>{@link MachineInfo#getFreeMemory()}
   *   <li>{@link MachineInfo#getJavaVersion()}
   *   <li>{@link MachineInfo#getJvmFreeMemory()}
   *   <li>{@link MachineInfo#getJvmTotalMemory()}
   *   <li>{@link MachineInfo#getOsName()}
   *   <li>{@link MachineInfo#getProcessCpuRate()}
   *   <li>{@link MachineInfo#getThreadCount()}
   *   <li>{@link MachineInfo#getTotalMemory()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MachineInfo.<init>()",
    "int MachineInfo.getCpuCount()",
    "double MachineInfo.getCpuRate()",
    "int MachineInfo.getDeadLockThreadCount()",
    "long MachineInfo.getFreeMemory()",
    "String MachineInfo.getJavaVersion()",
    "long MachineInfo.getJvmFreeMemory()",
    "long MachineInfo.getJvmTotalMemory()",
    "String MachineInfo.getOsName()",
    "double MachineInfo.getProcessCpuRate()",
    "int MachineInfo.getThreadCount()",
    "long MachineInfo.getTotalMemory()",
    "MachineInfo MachineInfo.setCpuCount(int)",
    "MachineInfo MachineInfo.setCpuRate(double)",
    "MachineInfo MachineInfo.setDeadLockThreadCount(int)",
    "MachineInfo MachineInfo.setFreeMemory(long)",
    "MachineInfo MachineInfo.setJavaVersion(String)",
    "MachineInfo MachineInfo.setJvmFreeMemory(long)",
    "MachineInfo MachineInfo.setJvmTotalMemory(long)",
    "MachineInfo MachineInfo.setOsName(String)",
    "MachineInfo MachineInfo.setProcessCpuRate(double)",
    "MachineInfo MachineInfo.setThreadCount(int)",
    "MachineInfo MachineInfo.setTotalMemory(long)"
  })
  public void testMachineInfoGettersAndSetters() {
    // Arrange and Act
    MachineInfo actualMachineInfo = new MachineInfo();
    MachineInfo actualSetCpuCountResult = actualMachineInfo.setCpuCount(3);
    MachineInfo actualSetCpuRateResult = actualMachineInfo.setCpuRate(10.0d);
    MachineInfo actualSetDeadLockThreadCountResult = actualMachineInfo.setDeadLockThreadCount(3);
    MachineInfo actualSetFreeMemoryResult = actualMachineInfo.setFreeMemory(1L);
    MachineInfo actualSetJavaVersionResult = actualMachineInfo.setJavaVersion("1.0.2");
    MachineInfo actualSetJvmFreeMemoryResult = actualMachineInfo.setJvmFreeMemory(1L);
    MachineInfo actualSetJvmTotalMemoryResult = actualMachineInfo.setJvmTotalMemory(1L);
    MachineInfo actualSetOsNameResult = actualMachineInfo.setOsName("Os Name");
    MachineInfo actualSetProcessCpuRateResult = actualMachineInfo.setProcessCpuRate(10.0d);
    MachineInfo actualSetThreadCountResult = actualMachineInfo.setThreadCount(3);
    MachineInfo actualSetTotalMemoryResult = actualMachineInfo.setTotalMemory(1L);
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
   * Test MachineInfo {@link MachineInfo#setDeadLockThreadInfoList(List)}.
   *
   * <p>Method under test: {@link MachineInfo#setDeadLockThreadInfoList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MachineInfo MachineInfo.setDeadLockThreadInfoList(List)"})
  public void testMachineInfoSetDeadLockThreadInfoList() {
    // Arrange
    MachineInfo machineInfo = new MachineInfo();

    DeadLockThreadInfo deadLockThreadInfo = new DeadLockThreadInfo();
    deadLockThreadInfo.setBlockTime(1L);
    deadLockThreadInfo.setLockName("Lock Name");
    deadLockThreadInfo.setLockOwner("Lock Owner");
    deadLockThreadInfo.setName("Name");
    deadLockThreadInfo.setStackTrace("Stack Trace");
    deadLockThreadInfo.setState("MD");
    deadLockThreadInfo.setWaitTime(1L);

    ArrayList<DeadLockThreadInfo> deadLockThreadInfoList = new ArrayList<>();
    deadLockThreadInfoList.add(deadLockThreadInfo);

    // Act and Assert
    List<DeadLockThreadInfo> deadLockThreadInfoList2 =
        machineInfo.setDeadLockThreadInfoList(deadLockThreadInfoList).getDeadLockThreadInfoList();
    assertEquals(1, deadLockThreadInfoList2.size());
    DeadLockThreadInfo getResult = deadLockThreadInfoList2.get(0);
    assertEquals("Lock Name", getResult.getLockName());
    assertEquals("Lock Owner", getResult.getLockOwner());
    assertEquals("MD", getResult.getState());
    assertEquals("Name", getResult.getName());
    assertEquals("Stack Trace", getResult.getStackTrace());
    assertEquals(1L, getResult.getBlockTime());
    assertEquals(1L, getResult.getWaitTime());
  }

  /**
   * Test MachineInfo {@link MachineInfo#setDeadLockThreadInfoList(List)}.
   *
   * <p>Method under test: {@link MachineInfo#setDeadLockThreadInfoList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MachineInfo MachineInfo.setDeadLockThreadInfoList(List)"})
  public void testMachineInfoSetDeadLockThreadInfoList2() {
    // Arrange
    MachineInfo machineInfo = new MachineInfo();

    DeadLockThreadInfo deadLockThreadInfo = new DeadLockThreadInfo();
    deadLockThreadInfo.setBlockTime(1L);
    deadLockThreadInfo.setLockName("Lock Name");
    deadLockThreadInfo.setLockOwner("Lock Owner");
    deadLockThreadInfo.setName("Name");
    deadLockThreadInfo.setStackTrace("Stack Trace");
    deadLockThreadInfo.setState("MD");
    deadLockThreadInfo.setWaitTime(1L);

    DeadLockThreadInfo deadLockThreadInfo2 = new DeadLockThreadInfo();
    deadLockThreadInfo2.setBlockTime(0L);
    deadLockThreadInfo2.setLockName("42");
    deadLockThreadInfo2.setLockOwner("42");
    deadLockThreadInfo2.setName("42");
    deadLockThreadInfo2.setStackTrace("42");
    deadLockThreadInfo2.setState("State");
    deadLockThreadInfo2.setWaitTime(0L);

    ArrayList<DeadLockThreadInfo> deadLockThreadInfoList = new ArrayList<>();
    deadLockThreadInfoList.add(deadLockThreadInfo2);
    deadLockThreadInfoList.add(deadLockThreadInfo);

    // Act and Assert
    List<DeadLockThreadInfo> deadLockThreadInfoList2 =
        machineInfo.setDeadLockThreadInfoList(deadLockThreadInfoList).getDeadLockThreadInfoList();
    assertEquals(2, deadLockThreadInfoList2.size());
    DeadLockThreadInfo getResult = deadLockThreadInfoList2.get(0);
    assertEquals("42", getResult.getLockName());
    assertEquals("42", getResult.getLockOwner());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getStackTrace());
    assertEquals("State", getResult.getState());
    assertEquals(0L, getResult.getBlockTime());
    assertEquals(0L, getResult.getWaitTime());
    assertSame(deadLockThreadInfo, deadLockThreadInfoList2.get(1));
  }

  /**
   * Test MachineInfo {@link MachineInfo#setDeadLockThreadInfoList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link MachineInfo} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MachineInfo#setDeadLockThreadInfoList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MachineInfo MachineInfo.setDeadLockThreadInfoList(List)"})
  public void testMachineInfoSetDeadLockThreadInfoList_whenArrayList_thenReturnMachineInfo() {
    // Arrange
    MachineInfo machineInfo = new MachineInfo();

    // Act
    MachineInfo actualSetDeadLockThreadInfoListResult =
        machineInfo.setDeadLockThreadInfoList(new ArrayList<>());

    // Assert
    assertSame(machineInfo, actualSetDeadLockThreadInfoListResult);
  }

  /**
   * Test MachineInfo {@link MachineInfo#setMemoryDescInfoList(List)}.
   *
   * <ul>
   *   <li>Then return MemoryDescInfoList size is one.
   * </ul>
   *
   * <p>Method under test: {@link MachineInfo#setMemoryDescInfoList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MachineInfo MachineInfo.setMemoryDescInfoList(List)"})
  public void testMachineInfoSetMemoryDescInfoList_thenReturnMemoryDescInfoListSizeIsOne() {
    // Arrange
    MachineInfo machineInfo = new MachineInfo();

    MemoryDescInfo memoryDescInfo = new MemoryDescInfo();
    memoryDescInfo.setInitSize(3L);
    memoryDescInfo.setMaxSize(3L);
    memoryDescInfo.setName("Name");
    memoryDescInfo.setUseRate(10.0d);
    memoryDescInfo.setUseSize(3L);

    ArrayList<MemoryDescInfo> memoryDescInfoList = new ArrayList<>();
    memoryDescInfoList.add(memoryDescInfo);

    // Act and Assert
    List<MemoryDescInfo> memoryDescInfoList2 =
        machineInfo.setMemoryDescInfoList(memoryDescInfoList).getMemoryDescInfoList();
    assertEquals(1, memoryDescInfoList2.size());
    MemoryDescInfo getResult = memoryDescInfoList2.get(0);
    assertEquals("Name", getResult.getName());
    assertEquals(10.0d, getResult.getUseRate(), 0.0);
    assertEquals(3L, getResult.getInitSize());
    assertEquals(3L, getResult.getMaxSize());
    assertEquals(3L, getResult.getUseSize());
  }

  /**
   * Test MachineInfo {@link MachineInfo#setMemoryDescInfoList(List)}.
   *
   * <ul>
   *   <li>Then return MemoryDescInfoList size is two.
   * </ul>
   *
   * <p>Method under test: {@link MachineInfo#setMemoryDescInfoList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MachineInfo MachineInfo.setMemoryDescInfoList(List)"})
  public void testMachineInfoSetMemoryDescInfoList_thenReturnMemoryDescInfoListSizeIsTwo() {
    // Arrange
    MachineInfo machineInfo = new MachineInfo();

    MemoryDescInfo memoryDescInfo = new MemoryDescInfo();
    memoryDescInfo.setInitSize(3L);
    memoryDescInfo.setMaxSize(3L);
    memoryDescInfo.setName("Name");
    memoryDescInfo.setUseRate(10.0d);
    memoryDescInfo.setUseSize(3L);

    MemoryDescInfo memoryDescInfo2 = new MemoryDescInfo();
    memoryDescInfo2.setInitSize(1L);
    memoryDescInfo2.setMaxSize(1L);
    memoryDescInfo2.setName("42");
    memoryDescInfo2.setUseRate(0.5d);
    memoryDescInfo2.setUseSize(1L);

    ArrayList<MemoryDescInfo> memoryDescInfoList = new ArrayList<>();
    memoryDescInfoList.add(memoryDescInfo2);
    memoryDescInfoList.add(memoryDescInfo);

    // Act and Assert
    List<MemoryDescInfo> memoryDescInfoList2 =
        machineInfo.setMemoryDescInfoList(memoryDescInfoList).getMemoryDescInfoList();
    assertEquals(2, memoryDescInfoList2.size());
    MemoryDescInfo getResult = memoryDescInfoList2.get(0);
    assertEquals("42", getResult.getName());
    assertEquals(0.5d, getResult.getUseRate(), 0.0);
    assertEquals(1L, getResult.getInitSize());
    assertEquals(1L, getResult.getMaxSize());
    assertEquals(1L, getResult.getUseSize());
    assertSame(memoryDescInfo, memoryDescInfoList2.get(1));
  }

  /**
   * Test MachineInfo {@link MachineInfo#setMemoryDescInfoList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link MachineInfo} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MachineInfo#setMemoryDescInfoList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MachineInfo MachineInfo.setMemoryDescInfoList(List)"})
  public void testMachineInfoSetMemoryDescInfoList_whenArrayList_thenReturnMachineInfo() {
    // Arrange
    MachineInfo machineInfo = new MachineInfo();

    // Act
    MachineInfo actualSetMemoryDescInfoListResult =
        machineInfo.setMemoryDescInfoList(new ArrayList<>());

    // Assert
    assertSame(machineInfo, actualSetMemoryDescInfoListResult);
  }

  /**
   * Test MachineInfo_DeadLockThreadInfo getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MachineInfo.DeadLockThreadInfo}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#setBlockTime(long)}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#setLockName(String)}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#setLockOwner(String)}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#setName(String)}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#setStackTrace(String)}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#setState(String)}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#setWaitTime(long)}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#getBlockTime()}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#getLockName()}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#getLockOwner()}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#getName()}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#getStackTrace()}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#getState()}
   *   <li>{@link MachineInfo.DeadLockThreadInfo#getWaitTime()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MachineInfo.DeadLockThreadInfo.<init>()",
    "long MachineInfo.DeadLockThreadInfo.getBlockTime()",
    "String MachineInfo.DeadLockThreadInfo.getLockName()",
    "String MachineInfo.DeadLockThreadInfo.getLockOwner()",
    "String MachineInfo.DeadLockThreadInfo.getName()",
    "String MachineInfo.DeadLockThreadInfo.getStackTrace()",
    "String MachineInfo.DeadLockThreadInfo.getState()",
    "long MachineInfo.DeadLockThreadInfo.getWaitTime()",
    "MachineInfo.DeadLockThreadInfo MachineInfo.DeadLockThreadInfo.setBlockTime(long)",
    "MachineInfo.DeadLockThreadInfo MachineInfo.DeadLockThreadInfo.setLockName(String)",
    "MachineInfo.DeadLockThreadInfo MachineInfo.DeadLockThreadInfo.setLockOwner(String)",
    "MachineInfo.DeadLockThreadInfo MachineInfo.DeadLockThreadInfo.setName(String)",
    "MachineInfo.DeadLockThreadInfo MachineInfo.DeadLockThreadInfo.setStackTrace(String)",
    "MachineInfo.DeadLockThreadInfo MachineInfo.DeadLockThreadInfo.setState(String)",
    "MachineInfo.DeadLockThreadInfo MachineInfo.DeadLockThreadInfo.setWaitTime(long)"
  })
  public void testMachineInfo_DeadLockThreadInfoGettersAndSetters() {
    // Arrange and Act
    DeadLockThreadInfo actualDeadLockThreadInfo = new DeadLockThreadInfo();
    DeadLockThreadInfo actualSetBlockTimeResult = actualDeadLockThreadInfo.setBlockTime(1L);
    DeadLockThreadInfo actualSetLockNameResult = actualDeadLockThreadInfo.setLockName("Lock Name");
    DeadLockThreadInfo actualSetLockOwnerResult =
        actualDeadLockThreadInfo.setLockOwner("Lock Owner");
    DeadLockThreadInfo actualSetNameResult = actualDeadLockThreadInfo.setName("Name");
    DeadLockThreadInfo actualSetStackTraceResult =
        actualDeadLockThreadInfo.setStackTrace("Stack Trace");
    DeadLockThreadInfo actualSetStateResult = actualDeadLockThreadInfo.setState("MD");
    DeadLockThreadInfo actualSetWaitTimeResult = actualDeadLockThreadInfo.setWaitTime(1L);
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
   * Test MachineInfo_MemoryDescInfo getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MachineInfo.MemoryDescInfo}
   *   <li>{@link MachineInfo.MemoryDescInfo#setInitSize(long)}
   *   <li>{@link MachineInfo.MemoryDescInfo#setMaxSize(long)}
   *   <li>{@link MachineInfo.MemoryDescInfo#setName(String)}
   *   <li>{@link MachineInfo.MemoryDescInfo#setUseRate(double)}
   *   <li>{@link MachineInfo.MemoryDescInfo#setUseSize(long)}
   *   <li>{@link MachineInfo.MemoryDescInfo#getInitSize()}
   *   <li>{@link MachineInfo.MemoryDescInfo#getMaxSize()}
   *   <li>{@link MachineInfo.MemoryDescInfo#getName()}
   *   <li>{@link MachineInfo.MemoryDescInfo#getUseRate()}
   *   <li>{@link MachineInfo.MemoryDescInfo#getUseSize()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MachineInfo.MemoryDescInfo.<init>()",
    "long MachineInfo.MemoryDescInfo.getInitSize()",
    "long MachineInfo.MemoryDescInfo.getMaxSize()",
    "String MachineInfo.MemoryDescInfo.getName()",
    "double MachineInfo.MemoryDescInfo.getUseRate()",
    "long MachineInfo.MemoryDescInfo.getUseSize()",
    "MachineInfo.MemoryDescInfo MachineInfo.MemoryDescInfo.setInitSize(long)",
    "MachineInfo.MemoryDescInfo MachineInfo.MemoryDescInfo.setMaxSize(long)",
    "MachineInfo.MemoryDescInfo MachineInfo.MemoryDescInfo.setName(String)",
    "MachineInfo.MemoryDescInfo MachineInfo.MemoryDescInfo.setUseRate(double)",
    "MachineInfo.MemoryDescInfo MachineInfo.MemoryDescInfo.setUseSize(long)"
  })
  public void testMachineInfo_MemoryDescInfoGettersAndSetters() {
    // Arrange and Act
    MemoryDescInfo actualMemoryDescInfo = new MemoryDescInfo();
    MemoryDescInfo actualSetInitSizeResult = actualMemoryDescInfo.setInitSize(3L);
    MemoryDescInfo actualSetMaxSizeResult = actualMemoryDescInfo.setMaxSize(3L);
    MemoryDescInfo actualSetNameResult = actualMemoryDescInfo.setName("Name");
    MemoryDescInfo actualSetUseRateResult = actualMemoryDescInfo.setUseRate(10.0d);
    MemoryDescInfo actualSetUseSizeResult = actualMemoryDescInfo.setUseSize(3L);
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
   * Test {@link NodeInfo#setPeerList(List)}.
   *
   * <ul>
   *   <li>Given {@link PeerInfo} (default constructor) Active is {@code false}.
   *   <li>Then return PeerList size is two.
   * </ul>
   *
   * <p>Method under test: {@link NodeInfo#setPeerList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NodeInfo NodeInfo.setPeerList(List)"})
  public void testSetPeerList_givenPeerInfoActiveIsFalse_thenReturnPeerListSizeIsTwo() {
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

    // Act and Assert
    List<PeerInfo> peerList2 = nodeInfo.setPeerList(peerList).getPeerList();
    assertEquals(2, peerList2.size());
    assertSame(peerInfo, peerList2.get(1));
  }

  /**
   * Test {@link NodeInfo#setPeerList(List)}.
   *
   * <ul>
   *   <li>Given {@link PeerInfo} (default constructor) Active is {@code true}.
   *   <li>Then return PeerList size is one.
   * </ul>
   *
   * <p>Method under test: {@link NodeInfo#setPeerList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NodeInfo NodeInfo.setPeerList(List)"})
  public void testSetPeerList_givenPeerInfoActiveIsTrue_thenReturnPeerListSizeIsOne() {
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

    // Act and Assert
    assertEquals(1, nodeInfo.setPeerList(peerList).getPeerList().size());
  }

  /**
   * Test {@link NodeInfo#setPeerList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link NodeInfo} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link NodeInfo#setPeerList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NodeInfo NodeInfo.setPeerList(List)"})
  public void testSetPeerList_whenArrayList_thenReturnNodeInfo() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();

    // Act
    NodeInfo actualSetPeerListResult = nodeInfo.setPeerList(new ArrayList<>());

    // Assert
    assertSame(nodeInfo, actualSetPeerListResult);
  }

  /**
   * Test {@link NodeInfo#transferToProtoEntity()}.
   *
   * <p>Method under test: {@link NodeInfo#transferToProtoEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.NodeInfo NodeInfo.transferToProtoEntity()"})
  public void testTransferToProtoEntity() {
    // Arrange
    DeadLockThreadInfo deadLockThreadInfo = new DeadLockThreadInfo();
    deadLockThreadInfo.setBlockTime(2L);
    deadLockThreadInfo.setLockName("Lock Name");
    deadLockThreadInfo.setLockOwner("Lock Owner");
    deadLockThreadInfo.setName("Name");
    deadLockThreadInfo.setStackTrace("Stack Trace");
    deadLockThreadInfo.setState("MD");
    deadLockThreadInfo.setWaitTime(2L);

    ArrayList<DeadLockThreadInfo> deadLockThreadInfoList = new ArrayList<>();
    deadLockThreadInfoList.add(deadLockThreadInfo);

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(deadLockThreadInfoList);
    machineInfo.setFreeMemory(2L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(2L);
    machineInfo.setJvmTotalMemory(2L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(2L);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setMachineInfo(machineInfo);
    nodeInfo.setSolidityBlock("");
    nodeInfo.setBlock("");

    // Act
    Protocol.NodeInfo actualTransferToProtoEntityResult = nodeInfo.transferToProtoEntity();

    // Assert
    Protocol.NodeInfo.MachineInfo machineInfo2 = actualTransferToProtoEntityResult.getMachineInfo();
    List<Protocol.NodeInfo.MachineInfo.DeadLockThreadInfo> deadLockThreadInfoListList =
        machineInfo2.getDeadLockThreadInfoListList();
    assertEquals(1, deadLockThreadInfoListList.size());
    Protocol.NodeInfo.MachineInfo.DeadLockThreadInfo getResult = deadLockThreadInfoListList.get(0);
    assertEquals("Lock Name", getResult.getLockName());
    assertEquals("Lock Owner", getResult.getLockOwner());
    assertEquals("MD", getResult.getState());
    assertEquals("Name", getResult.getName());
    assertEquals("Stack Trace", getResult.getStackTrace());
    assertEquals(1, machineInfo2.getDeadLockThreadInfoListCount());
    assertEquals(100, machineInfo2.getSerializedSize());
    assertEquals(102, actualTransferToProtoEntityResult.getSerializedSize());
    assertEquals(2L, getResult.getBlockTime());
    assertEquals(2L, getResult.getWaitTime());
    assertEquals(50, getResult.getSerializedSize());
  }

  /**
   * Test {@link NodeInfo#transferToProtoEntity()}.
   *
   * <p>Method under test: {@link NodeInfo#transferToProtoEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.NodeInfo NodeInfo.transferToProtoEntity()"})
  public void testTransferToProtoEntity2() {
    // Arrange
    DeadLockThreadInfo deadLockThreadInfo = new DeadLockThreadInfo();
    deadLockThreadInfo.setBlockTime(2L);
    deadLockThreadInfo.setLockName("Lock Name");
    deadLockThreadInfo.setLockOwner("Lock Owner");
    deadLockThreadInfo.setName("Name");
    deadLockThreadInfo.setStackTrace("Stack Trace");
    deadLockThreadInfo.setState("MD");
    deadLockThreadInfo.setWaitTime(2L);

    DeadLockThreadInfo deadLockThreadInfo2 = new DeadLockThreadInfo();
    deadLockThreadInfo2.setBlockTime(1L);
    deadLockThreadInfo2.setLockName("");
    deadLockThreadInfo2.setLockOwner("");
    deadLockThreadInfo2.setName("");
    deadLockThreadInfo2.setStackTrace("");
    deadLockThreadInfo2.setState("State");
    deadLockThreadInfo2.setWaitTime(1L);

    ArrayList<DeadLockThreadInfo> deadLockThreadInfoList = new ArrayList<>();
    deadLockThreadInfoList.add(deadLockThreadInfo2);
    deadLockThreadInfoList.add(deadLockThreadInfo);

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(deadLockThreadInfoList);
    machineInfo.setFreeMemory(2L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(2L);
    machineInfo.setJvmTotalMemory(2L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(2L);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setMachineInfo(machineInfo);
    nodeInfo.setSolidityBlock("");
    nodeInfo.setBlock("");

    // Act
    Protocol.NodeInfo actualTransferToProtoEntityResult = nodeInfo.transferToProtoEntity();

    // Assert
    Protocol.NodeInfo.MachineInfo machineInfo2 = actualTransferToProtoEntityResult.getMachineInfo();
    assertEquals(113, machineInfo2.getSerializedSize());
    assertEquals(115, actualTransferToProtoEntityResult.getSerializedSize());
    assertEquals(2, machineInfo2.getDeadLockThreadInfoListList().size());
    assertEquals(2, machineInfo2.getDeadLockThreadInfoListCount());
  }

  /**
   * Test {@link NodeInfo#transferToProtoEntity()}.
   *
   * <ul>
   *   <li>Given {@link ConfigNodeInfo} (default constructor) ActiveNodeSize is two.
   * </ul>
   *
   * <p>Method under test: {@link NodeInfo#transferToProtoEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.NodeInfo NodeInfo.transferToProtoEntity()"})
  public void testTransferToProtoEntity_givenConfigNodeInfoActiveNodeSizeIsTwo() {
    // Arrange
    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(2);
    configNodeInfo.setAllowAdaptiveEnergy(2L);
    configNodeInfo.setAllowCreationOfContracts(2L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(2);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(2);
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

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setConfigNodeInfo(configNodeInfo);
    nodeInfo.setSolidityBlock("");
    nodeInfo.setBlock("");

    // Act
    Protocol.NodeInfo actualTransferToProtoEntityResult = nodeInfo.transferToProtoEntity();

    // Assert
    assertEquals(70, actualTransferToProtoEntityResult.getSerializedSize());
    assertTrue(actualTransferToProtoEntityResult.hasConfigNodeInfo());
  }

  /**
   * Test {@link NodeInfo#transferToProtoEntity()}.
   *
   * <ul>
   *   <li>Then return DescriptorForType Fields size is eleven.
   * </ul>
   *
   * <p>Method under test: {@link NodeInfo#transferToProtoEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.NodeInfo NodeInfo.transferToProtoEntity()"})
  public void testTransferToProtoEntity_thenReturnDescriptorForTypeFieldsSizeIsEleven() {
    // Arrange
    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(2L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(2L);
    machineInfo.setJvmTotalMemory(2L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(2L);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setMachineInfo(machineInfo);
    nodeInfo.setSolidityBlock("");
    nodeInfo.setBlock("");

    // Act
    Protocol.NodeInfo actualTransferToProtoEntityResult = nodeInfo.transferToProtoEntity();

    // Assert
    List<FieldDescriptor> fields =
        actualTransferToProtoEntityResult.getDescriptorForType().getFields();
    assertEquals(11, fields.size());
    Protocol.NodeInfo.MachineInfo machineInfo2 = actualTransferToProtoEntityResult.getMachineInfo();
    assertEquals(11, machineInfo2.getAllFields().size());
    assertEquals(48, machineInfo2.getSerializedSize());
    assertEquals(50, actualTransferToProtoEntityResult.getSerializedSize());
    FieldDescriptorProto toProtoResult = fields.get(1).toProto();
    assertFalse(toProtoResult.hasOneofIndex());
    assertFalse(toProtoResult.hasOptions());
  }

  /**
   * Test {@link NodeInfo#transferToProtoEntity()}.
   *
   * <ul>
   *   <li>Then return MachineInfo CpuCount is two.
   * </ul>
   *
   * <p>Method under test: {@link NodeInfo#transferToProtoEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.NodeInfo NodeInfo.transferToProtoEntity()"})
  public void testTransferToProtoEntity_thenReturnMachineInfoCpuCountIsTwo() {
    // Arrange
    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(2);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(2L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(2L);
    machineInfo.setJvmTotalMemory(2L);
    machineInfo.setMemoryDescInfoList(new ArrayList<>());
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(2L);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setMachineInfo(machineInfo);
    nodeInfo.setSolidityBlock("");
    nodeInfo.setBlock("");

    // Act
    Protocol.NodeInfo actualTransferToProtoEntityResult = nodeInfo.transferToProtoEntity();

    // Assert
    Protocol.NodeInfo.MachineInfo machineInfo2 = actualTransferToProtoEntityResult.getMachineInfo();
    assertEquals(11, machineInfo2.getAllFields().size());
    assertEquals(2, machineInfo2.getCpuCount());
    assertEquals(48, machineInfo2.getSerializedSize());
    assertEquals(50, actualTransferToProtoEntityResult.getSerializedSize());
  }

  /**
   * Test {@link NodeInfo#transferToProtoEntity()}.
   *
   * <ul>
   *   <li>Then return MachineInfo MemoryDescInfoListList size is one.
   * </ul>
   *
   * <p>Method under test: {@link NodeInfo#transferToProtoEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.NodeInfo NodeInfo.transferToProtoEntity()"})
  public void testTransferToProtoEntity_thenReturnMachineInfoMemoryDescInfoListListSizeIsOne() {
    // Arrange
    MemoryDescInfo memoryDescInfo = new MemoryDescInfo();
    memoryDescInfo.setInitSize(3L);
    memoryDescInfo.setMaxSize(3L);
    memoryDescInfo.setName("Name");
    memoryDescInfo.setUseRate(10.0d);
    memoryDescInfo.setUseSize(3L);

    ArrayList<MemoryDescInfo> memoryDescInfoList = new ArrayList<>();
    memoryDescInfoList.add(memoryDescInfo);

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(2L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(2L);
    machineInfo.setJvmTotalMemory(2L);
    machineInfo.setMemoryDescInfoList(memoryDescInfoList);
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(2L);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setMachineInfo(machineInfo);
    nodeInfo.setSolidityBlock("");
    nodeInfo.setBlock("");

    // Act
    Protocol.NodeInfo actualTransferToProtoEntityResult = nodeInfo.transferToProtoEntity();

    // Assert
    Protocol.NodeInfo.MachineInfo machineInfo2 = actualTransferToProtoEntityResult.getMachineInfo();
    List<Protocol.NodeInfo.MachineInfo.MemoryDescInfo> memoryDescInfoListList =
        machineInfo2.getMemoryDescInfoListList();
    assertEquals(1, memoryDescInfoListList.size());
    Protocol.NodeInfo.MachineInfo.MemoryDescInfo getResult = memoryDescInfoListList.get(0);
    assertEquals("Name", getResult.getName());
    assertEquals(1, machineInfo2.getMemoryDescInfoListCount());
    assertEquals(10.0d, getResult.getUseRate(), 0.0);
    assertEquals(21, getResult.getSerializedSize());
    assertEquals(3L, getResult.getInitSize());
    assertEquals(3L, getResult.getMaxSize());
    assertEquals(3L, getResult.getUseSize());
    assertEquals(71, machineInfo2.getSerializedSize());
    assertEquals(73, actualTransferToProtoEntityResult.getSerializedSize());
  }

  /**
   * Test {@link NodeInfo#transferToProtoEntity()}.
   *
   * <ul>
   *   <li>Then return MachineInfo MemoryDescInfoListList size is two.
   * </ul>
   *
   * <p>Method under test: {@link NodeInfo#transferToProtoEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.NodeInfo NodeInfo.transferToProtoEntity()"})
  public void testTransferToProtoEntity_thenReturnMachineInfoMemoryDescInfoListListSizeIsTwo() {
    // Arrange
    MemoryDescInfo memoryDescInfo = new MemoryDescInfo();
    memoryDescInfo.setInitSize(3L);
    memoryDescInfo.setMaxSize(3L);
    memoryDescInfo.setName("Name");
    memoryDescInfo.setUseRate(10.0d);
    memoryDescInfo.setUseSize(3L);

    MemoryDescInfo memoryDescInfo2 = new MemoryDescInfo();
    memoryDescInfo2.setInitSize(2L);
    memoryDescInfo2.setMaxSize(2L);
    memoryDescInfo2.setName("");
    memoryDescInfo2.setUseRate(0.0d);
    memoryDescInfo2.setUseSize(2L);

    ArrayList<MemoryDescInfo> memoryDescInfoList = new ArrayList<>();
    memoryDescInfoList.add(memoryDescInfo2);
    memoryDescInfoList.add(memoryDescInfo);

    MachineInfo machineInfo = new MachineInfo();
    machineInfo.setCpuCount(3);
    machineInfo.setCpuRate(10.0d);
    machineInfo.setDeadLockThreadCount(3);
    machineInfo.setDeadLockThreadInfoList(new ArrayList<>());
    machineInfo.setFreeMemory(2L);
    machineInfo.setJavaVersion("1.0.2");
    machineInfo.setJvmFreeMemory(2L);
    machineInfo.setJvmTotalMemory(2L);
    machineInfo.setMemoryDescInfoList(memoryDescInfoList);
    machineInfo.setOsName("Os Name");
    machineInfo.setProcessCpuRate(10.0d);
    machineInfo.setThreadCount(3);
    machineInfo.setTotalMemory(2L);

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setMachineInfo(machineInfo);
    nodeInfo.setSolidityBlock("");
    nodeInfo.setBlock("");

    // Act
    Protocol.NodeInfo actualTransferToProtoEntityResult = nodeInfo.transferToProtoEntity();

    // Assert
    Protocol.NodeInfo.MachineInfo machineInfo2 = actualTransferToProtoEntityResult.getMachineInfo();
    assertEquals(2, machineInfo2.getMemoryDescInfoListList().size());
    assertEquals(2, machineInfo2.getMemoryDescInfoListCount());
    assertEquals(79, machineInfo2.getSerializedSize());
    assertEquals(81, actualTransferToProtoEntityResult.getSerializedSize());
  }

  /**
   * Test {@link NodeInfo#transferToProtoEntity()}.
   *
   * <ul>
   *   <li>Then return SerializedSize is seventy.
   * </ul>
   *
   * <p>Method under test: {@link NodeInfo#transferToProtoEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.NodeInfo NodeInfo.transferToProtoEntity()"})
  public void testTransferToProtoEntity_thenReturnSerializedSizeIsSeventy() {
    // Arrange
    ConfigNodeInfo configNodeInfo = new ConfigNodeInfo();
    configNodeInfo.setActiveNodeSize(3);
    configNodeInfo.setAllowAdaptiveEnergy(2L);
    configNodeInfo.setAllowCreationOfContracts(2L);
    configNodeInfo.setBackupListenPort(8080);
    configNodeInfo.setBackupMemberSize(3);
    configNodeInfo.setBackupPriority(2);
    configNodeInfo.setCodeVersion("1.0.2");
    configNodeInfo.setDbVersion(2);
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

    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setConfigNodeInfo(configNodeInfo);
    nodeInfo.setSolidityBlock("");
    nodeInfo.setBlock("");

    // Act
    Protocol.NodeInfo actualTransferToProtoEntityResult = nodeInfo.transferToProtoEntity();

    // Assert
    assertEquals(70, actualTransferToProtoEntityResult.getSerializedSize());
    assertTrue(actualTransferToProtoEntityResult.hasConfigNodeInfo());
  }

  /**
   * Test {@link NodeInfo#transferToProtoEntity()}.
   *
   * <ul>
   *   <li>Then return SerializedSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link NodeInfo#transferToProtoEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.NodeInfo NodeInfo.transferToProtoEntity()"})
  public void testTransferToProtoEntity_thenReturnSerializedSizeIsZero() {
    // Arrange
    NodeInfo nodeInfo = new NodeInfo();
    nodeInfo.setSolidityBlock("");
    nodeInfo.setBlock("");

    // Act
    Protocol.NodeInfo actualTransferToProtoEntityResult = nodeInfo.transferToProtoEntity();

    // Assert
    assertEquals(0, actualTransferToProtoEntityResult.getSerializedSize());
    Map<FieldDescriptor, Object> allFields = actualTransferToProtoEntityResult.getAllFields();
    assertTrue(allFields.isEmpty());
    Descriptor descriptorForType = actualTransferToProtoEntityResult.getDescriptorForType();
    assertEquals(allFields, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(allFields, features.getAllFields());
    assertEquals(allFields, features.getAllFieldsRaw());
    Protocol.NodeInfo actualDefaultInstanceForType =
        actualTransferToProtoEntityResult.getDefaultInstanceForType();
    assertEquals(actualTransferToProtoEntityResult, actualDefaultInstanceForType);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NodeInfo}
   *   <li>{@link NodeInfo#setActiveConnectCount(int)}
   *   <li>{@link NodeInfo#setBeginSyncNum(long)}
   *   <li>{@link NodeInfo#setBlock(String)}
   *   <li>{@link NodeInfo#setCheatWitnessInfoMap(Map)}
   *   <li>{@link NodeInfo#setConfigNodeInfo(ConfigNodeInfo)}
   *   <li>{@link NodeInfo#setCurrentConnectCount(int)}
   *   <li>{@link NodeInfo#setMachineInfo(MachineInfo)}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NodeInfo.<init>()",
    "int NodeInfo.getActiveConnectCount()",
    "long NodeInfo.getBeginSyncNum()",
    "String NodeInfo.getBlock()",
    "Map NodeInfo.getCheatWitnessInfoMap()",
    "ConfigNodeInfo NodeInfo.getConfigNodeInfo()",
    "int NodeInfo.getCurrentConnectCount()",
    "MachineInfo NodeInfo.getMachineInfo()",
    "int NodeInfo.getPassiveConnectCount()",
    "String NodeInfo.getSolidityBlock()",
    "long NodeInfo.getTotalFlow()",
    "NodeInfo NodeInfo.setActiveConnectCount(int)",
    "NodeInfo NodeInfo.setBeginSyncNum(long)",
    "NodeInfo NodeInfo.setBlock(String)",
    "NodeInfo NodeInfo.setCheatWitnessInfoMap(Map)",
    "NodeInfo NodeInfo.setConfigNodeInfo(ConfigNodeInfo)",
    "NodeInfo NodeInfo.setCurrentConnectCount(int)",
    "NodeInfo NodeInfo.setMachineInfo(MachineInfo)",
    "NodeInfo NodeInfo.setPassiveConnectCount(int)",
    "NodeInfo NodeInfo.setSolidityBlock(String)",
    "NodeInfo NodeInfo.setTotalFlow(long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    NodeInfo actualNodeInfo = new NodeInfo();
    NodeInfo actualSetActiveConnectCountResult = actualNodeInfo.setActiveConnectCount(3);
    NodeInfo actualSetBeginSyncNumResult = actualNodeInfo.setBeginSyncNum(1L);
    NodeInfo actualSetBlockResult = actualNodeInfo.setBlock("Block");
    HashMap<String, String> cheatWitnessInfoMap = new HashMap<>();
    NodeInfo actualSetCheatWitnessInfoMapResult =
        actualNodeInfo.setCheatWitnessInfoMap(cheatWitnessInfoMap);
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
    NodeInfo actualSetConfigNodeInfoResult = actualNodeInfo.setConfigNodeInfo(configNodeInfo);
    NodeInfo actualSetCurrentConnectCountResult = actualNodeInfo.setCurrentConnectCount(3);
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
    NodeInfo actualSetMachineInfoResult = actualNodeInfo.setMachineInfo(machineInfo);
    NodeInfo actualSetPassiveConnectCountResult = actualNodeInfo.setPassiveConnectCount(3);
    NodeInfo actualSetSolidityBlockResult = actualNodeInfo.setSolidityBlock("Solidity Block");
    NodeInfo actualSetTotalFlowResult = actualNodeInfo.setTotalFlow(1L);
    int actualActiveConnectCount = actualNodeInfo.getActiveConnectCount();
    long actualBeginSyncNum = actualNodeInfo.getBeginSyncNum();
    String actualBlock = actualNodeInfo.getBlock();
    Map<String, String> actualCheatWitnessInfoMap = actualNodeInfo.getCheatWitnessInfoMap();
    ConfigNodeInfo actualConfigNodeInfo = actualNodeInfo.getConfigNodeInfo();
    int actualCurrentConnectCount = actualNodeInfo.getCurrentConnectCount();
    MachineInfo actualMachineInfo = actualNodeInfo.getMachineInfo();
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
