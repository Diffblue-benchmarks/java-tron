package org.tron.core.config.args;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterDescription;
import com.beust.jcommander.Parameterized;
import com.typesafe.config.Config;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tron.common.logsfilter.trigger.ContractEventTrigger;
import org.tron.common.logsfilter.trigger.ContractLogTrigger;
import org.tron.common.utils.LocalWitnesses;
import org.tron.p2p.dns.update.DnsType;
import org.tron.p2p.dns.update.PublishConfig;

@ContextConfiguration(classes = {Args.class})
@RunWith(MockitoJUnitRunner.class)
public class ArgsDiffblueTest {
  @InjectMocks
  private Args args;

  @InjectMocks
  private ConcurrentHashMap<Long, BlockingQueue<ContractEventTrigger>> concurrentHashMap;

  @InjectMocks
  private ConcurrentHashMap<Long, BlockingQueue<ContractLogTrigger>> concurrentHashMap2;

  /**
   * Method under test: {@link Args#printHelp(JCommander)}
   */
  @Test
  public void testPrintHelp() {
    // Arrange
    JCommander jCommander = mock(JCommander.class);
    when(jCommander.getProgramName()).thenReturn("Program Name");
    when(jCommander.getParameters()).thenReturn(new ArrayList<>());

    // Act
    Args.printHelp(jCommander);

    // Assert
    verify(jCommander).getParameters();
    verify(jCommander, atLeast(1)).getProgramName();
  }

  /**
   * Method under test: {@link Args#printHelp(JCommander)}
   */
  @Test
  public void testPrintHelp2() {
    // Arrange
    Parameterized parameterized = mock(Parameterized.class);
    when(parameterized.getName()).thenReturn("Name");
    ParameterDescription parameterDescription = mock(ParameterDescription.class);
    when(parameterDescription.getParameterized()).thenReturn(parameterized);

    ArrayList<ParameterDescription> parameterDescriptionList = new ArrayList<>();
    parameterDescriptionList.add(parameterDescription);
    JCommander jCommander = mock(JCommander.class);
    when(jCommander.getProgramName()).thenReturn("Program Name");
    when(jCommander.getParameters()).thenReturn(parameterDescriptionList);

    // Act
    Args.printHelp(jCommander);

    // Assert
    verify(jCommander).getParameters();
    verify(jCommander, atLeast(1)).getProgramName();
    verify(parameterDescription).getParameterized();
    verify(parameterized).getName();
  }

  /**
   * Method under test: {@link Args#printHelp(JCommander)}
   */
  @Test
  public void testPrintHelp3() {
    // Arrange
    Parameterized parameterized = mock(Parameterized.class);
    when(parameterized.getName()).thenReturn("version");
    ParameterDescription parameterDescription = mock(ParameterDescription.class);
    when(parameterDescription.getDescription()).thenReturn("The characteristics of someone or something");
    when(parameterDescription.getNames()).thenReturn("Names");
    when(parameterDescription.getParameterized()).thenReturn(parameterized);

    ArrayList<ParameterDescription> parameterDescriptionList = new ArrayList<>();
    parameterDescriptionList.add(parameterDescription);
    JCommander jCommander = mock(JCommander.class);
    when(jCommander.getProgramName()).thenReturn("Program Name");
    when(jCommander.getParameters()).thenReturn(parameterDescriptionList);

    // Act
    Args.printHelp(jCommander);

    // Assert
    verify(jCommander).getParameters();
    verify(jCommander, atLeast(1)).getProgramName();
    verify(parameterDescription).getDescription();
    verify(parameterDescription, atLeast(1)).getNames();
    verify(parameterDescription).getParameterized();
    verify(parameterized).getName();
  }

  /**
   * Method under test: {@link Args#printHelp(JCommander)}
   */
  @Test
  public void testPrintHelp4() {
    // Arrange
    Parameterized parameterized = mock(Parameterized.class);
    when(parameterized.getName()).thenReturn("version");
    ParameterDescription parameterDescription = mock(ParameterDescription.class);
    when(parameterDescription.getDescription())
        .thenThrow(new IllegalArgumentException("Name:\n\tFullNode - the java-tron command line interface\n"));
    when(parameterDescription.getNames()).thenReturn("Names");
    when(parameterDescription.getParameterized()).thenReturn(parameterized);

    ArrayList<ParameterDescription> parameterDescriptionList = new ArrayList<>();
    parameterDescriptionList.add(parameterDescription);
    JCommander jCommander = mock(JCommander.class);
    when(jCommander.getProgramName()).thenReturn("Program Name");
    when(jCommander.getParameters()).thenReturn(parameterDescriptionList);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.printHelp(jCommander));
    verify(jCommander).getParameters();
    verify(jCommander, atLeast(1)).getProgramName();
    verify(parameterDescription).getDescription();
    verify(parameterDescription, atLeast(1)).getNames();
    verify(parameterDescription).getParameterized();
    verify(parameterized).getName();
  }

  /**
   * Method under test: {@link Args#printHelp(JCommander)}
   */
  @Test
  public void testPrintHelp5() {
    // Arrange
    Parameterized parameterized = mock(Parameterized.class);
    when(parameterized.getName()).thenReturn("version");
    ParameterDescription parameterDescription = mock(ParameterDescription.class);
    when(parameterDescription.getDescription()).thenReturn("");
    when(parameterDescription.getNames()).thenReturn("Names");
    when(parameterDescription.getParameterized()).thenReturn(parameterized);

    ArrayList<ParameterDescription> parameterDescriptionList = new ArrayList<>();
    parameterDescriptionList.add(parameterDescription);
    JCommander jCommander = mock(JCommander.class);
    when(jCommander.getProgramName()).thenReturn("Program Name");
    when(jCommander.getParameters()).thenReturn(parameterDescriptionList);

    // Act
    Args.printHelp(jCommander);

    // Assert
    verify(jCommander).getParameters();
    verify(jCommander, atLeast(1)).getProgramName();
    verify(parameterDescription).getDescription();
    verify(parameterDescription, atLeast(1)).getNames();
    verify(parameterDescription).getParameterized();
    verify(parameterized).getName();
  }

  /**
   * Method under test: {@link Args#printHelp(JCommander)}
   */
  @Test
  public void testPrintHelp6() {
    // Arrange
    Parameterized parameterized = mock(Parameterized.class);
    when(parameterized.getName()).thenReturn("version");
    ParameterDescription parameterDescription = mock(ParameterDescription.class);
    when(parameterDescription.getDescription()).thenReturn("The characteristics of someone or something");
    when(parameterDescription.getNames()).thenReturn("");
    when(parameterDescription.getParameterized()).thenReturn(parameterized);

    ArrayList<ParameterDescription> parameterDescriptionList = new ArrayList<>();
    parameterDescriptionList.add(parameterDescription);
    JCommander jCommander = mock(JCommander.class);
    when(jCommander.getProgramName()).thenReturn("Program Name");
    when(jCommander.getParameters()).thenReturn(parameterDescriptionList);

    // Act
    Args.printHelp(jCommander);

    // Assert
    verify(jCommander).getParameters();
    verify(jCommander, atLeast(1)).getProgramName();
    verify(parameterDescription).getDescription();
    verify(parameterDescription, atLeast(1)).getNames();
    verify(parameterDescription).getParameterized();
    verify(parameterized).getName();
  }

  /**
   * Method under test: {@link Args#upperFirst(String)}
   */
  @Test
  public void testUpperFirst() {
    // Arrange, Act and Assert
    assertEquals("Name", Args.upperFirst("Name"));
    assertEquals("", Args.upperFirst(""));
  }

  /**
   * Method under test: {@link Args#getInetSocketAddress(Config, String, boolean)}
   */
  @Test
  public void testGetInetSocketAddress() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getStringList(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    List<InetSocketAddress> actualInetSocketAddress = Args.getInetSocketAddress(config, "Path", true);

    // Assert
    verify(config).getStringList(eq("Path"));
    verify(config).hasPath(eq("Path"));
    assertTrue(actualInetSocketAddress.isEmpty());
  }

  /**
   * Method under test: {@link Args#getInetSocketAddress(Config, String, boolean)}
   */
  @Test
  public void testGetInetSocketAddress2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getStringList(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.getInetSocketAddress(config, "Path", true));
    verify(config).getStringList(eq("Path"));
    verify(config).hasPath(eq("Path"));
  }

  /**
   * Method under test: {@link Args#getInetSocketAddress(Config, String, boolean)}
   */
  @Test
  public void testGetInetSocketAddress3() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    List<InetSocketAddress> actualInetSocketAddress = Args.getInetSocketAddress(config, "Path", true);

    // Assert
    verify(config).hasPath(eq("Path"));
    assertTrue(actualInetSocketAddress.isEmpty());
  }

  /**
   * Method under test: {@link Args#getInetAddress(Config, String)}
   */
  @Test
  public void testGetInetAddress() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getStringList(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    List<InetAddress> actualInetAddress = Args.getInetAddress(config, "Path");

    // Assert
    verify(config).getStringList(eq("Path"));
    verify(config).hasPath(eq("Path"));
    assertTrue(actualInetAddress.isEmpty());
  }

  /**
   * Method under test: {@link Args#getInetAddress(Config, String)}
   */
  @Test
  public void testGetInetAddress2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getStringList(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.getInetAddress(config, "Path"));
    verify(config).getStringList(eq("Path"));
    verify(config).hasPath(eq("Path"));
  }

  /**
   * Method under test: {@link Args#getInetAddress(Config, String)}
   */
  @Test
  public void testGetInetAddress3() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    List<InetAddress> actualInetAddress = Args.getInetAddress(config, "Path");

    // Assert
    verify(config).hasPath(eq("Path"));
    assertTrue(actualInetAddress.isEmpty());
  }

  /**
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  public void testLoadDnsPublishConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenReturn(10.0d);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.getStringList(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.loadDnsPublishConfig(config));
    verify(config).getBoolean(eq("node.dns.publish"));
    verify(config).getDouble(eq("node.dns.changeThreshold"));
    verify(config).getInt(eq("node.dns.maxMergeSize"));
    verify(config, atLeast(1)).getString(Mockito.<String>any());
    verify(config, atLeast(1)).getStringList(Mockito.<String>any());
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
  }

  /**
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  public void testLoadDnsPublishConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenThrow(new IllegalArgumentException("node.dns.publish"));
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.loadDnsPublishConfig(config));
    verify(config).getBoolean(eq("node.dns.publish"));
    verify(config).getDouble(eq("node.dns.changeThreshold"));
    verify(config, atLeast(1)).getString(eq("node.dns.dnsDomain"));
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
  }

  /**
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  public void testLoadDnsPublishConfig3() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenReturn(0.0d);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.getStringList(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.loadDnsPublishConfig(config));
    verify(config).getBoolean(eq("node.dns.publish"));
    verify(config).getDouble(eq("node.dns.changeThreshold"));
    verify(config).getInt(eq("node.dns.maxMergeSize"));
    verify(config, atLeast(1)).getString(Mockito.<String>any());
    verify(config, atLeast(1)).getStringList(Mockito.<String>any());
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
  }

  /**
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  public void testLoadDnsPublishConfig4() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenReturn(10.0d);
    when(config.getInt(Mockito.<String>any())).thenReturn(0);
    when(config.getStringList(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.loadDnsPublishConfig(config));
    verify(config).getBoolean(eq("node.dns.publish"));
    verify(config).getDouble(eq("node.dns.changeThreshold"));
    verify(config).getInt(eq("node.dns.maxMergeSize"));
    verify(config, atLeast(1)).getString(Mockito.<String>any());
    verify(config, atLeast(1)).getStringList(Mockito.<String>any());
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
  }

  /**
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  public void testLoadDnsPublishConfig5() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("");
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.loadDnsPublishConfig(config));
    verify(config).getBoolean(eq("node.dns.publish"));
    verify(config).getString(eq("node.dns.dnsDomain"));
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
  }

  /**
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  public void testLoadDnsPublishConfig6() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenReturn(10.0d);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    ArrayList<String> stringList = new ArrayList<>();
    when(config.getStringList(Mockito.<String>any())).thenReturn(stringList);
    when(config.getString(Mockito.<String>any())).thenReturn("aws");
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    PublishConfig actualLoadDnsPublishConfigResult = Args.loadDnsPublishConfig(config);

    // Assert
    verify(config).getBoolean(eq("node.dns.publish"));
    verify(config).getDouble(eq("node.dns.changeThreshold"));
    verify(config).getInt(eq("node.dns.maxMergeSize"));
    verify(config, atLeast(1)).getString(Mockito.<String>any());
    verify(config, atLeast(1)).getStringList(Mockito.<String>any());
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
    assertEquals("aws", actualLoadDnsPublishConfigResult.getAccessKeyId());
    assertEquals("aws", actualLoadDnsPublishConfigResult.getAccessKeySecret());
    assertEquals("aws", actualLoadDnsPublishConfigResult.getAwsHostZoneId());
    assertEquals("aws", actualLoadDnsPublishConfigResult.getAwsRegion());
    assertEquals("aws", actualLoadDnsPublishConfigResult.getDnsDomain());
    assertEquals("aws", actualLoadDnsPublishConfigResult.getDnsPrivate());
    assertNull(actualLoadDnsPublishConfigResult.getAliDnsEndpoint());
    assertEquals(1, actualLoadDnsPublishConfigResult.getMaxMergeSize());
    assertEquals(10.0d, actualLoadDnsPublishConfigResult.getChangeThreshold(), 0.0);
    assertEquals(DnsType.AwsRoute53, actualLoadDnsPublishConfigResult.getDnsType());
    List<String> knownTreeUrls = actualLoadDnsPublishConfigResult.getKnownTreeUrls();
    assertTrue(knownTreeUrls.isEmpty());
    assertTrue(actualLoadDnsPublishConfigResult.getStaticNodes().isEmpty());
    assertTrue(actualLoadDnsPublishConfigResult.isDnsPublishEnable());
    assertSame(stringList, knownTreeUrls);
  }

  /**
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  public void testLoadDnsPublishConfig7() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(false);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    PublishConfig actualLoadDnsPublishConfigResult = Args.loadDnsPublishConfig(config);

    // Assert
    verify(config).getBoolean(eq("node.dns.publish"));
    verify(config).hasPath(eq("node.dns.publish"));
    assertNull(actualLoadDnsPublishConfigResult.getAccessKeyId());
    assertNull(actualLoadDnsPublishConfigResult.getAccessKeySecret());
    assertNull(actualLoadDnsPublishConfigResult.getAliDnsEndpoint());
    assertNull(actualLoadDnsPublishConfigResult.getAwsHostZoneId());
    assertNull(actualLoadDnsPublishConfigResult.getAwsRegion());
    assertNull(actualLoadDnsPublishConfigResult.getDnsDomain());
    assertNull(actualLoadDnsPublishConfigResult.getDnsPrivate());
    assertNull(actualLoadDnsPublishConfigResult.getDnsType());
    assertEquals(0.1d, actualLoadDnsPublishConfigResult.getChangeThreshold(), 0.0);
    assertEquals(5, actualLoadDnsPublishConfigResult.getMaxMergeSize());
    assertFalse(actualLoadDnsPublishConfigResult.isDnsPublishEnable());
    assertTrue(actualLoadDnsPublishConfigResult.getKnownTreeUrls().isEmpty());
    assertTrue(actualLoadDnsPublishConfigResult.getStaticNodes().isEmpty());
  }

  /**
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  public void testLoadDnsPublishConfig8() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    PublishConfig actualLoadDnsPublishConfigResult = Args.loadDnsPublishConfig(config);

    // Assert
    verify(config).hasPath(eq("node.dns.publish"));
    assertNull(actualLoadDnsPublishConfigResult.getAccessKeyId());
    assertNull(actualLoadDnsPublishConfigResult.getAccessKeySecret());
    assertNull(actualLoadDnsPublishConfigResult.getAliDnsEndpoint());
    assertNull(actualLoadDnsPublishConfigResult.getAwsHostZoneId());
    assertNull(actualLoadDnsPublishConfigResult.getAwsRegion());
    assertNull(actualLoadDnsPublishConfigResult.getDnsDomain());
    assertNull(actualLoadDnsPublishConfigResult.getDnsPrivate());
    assertNull(actualLoadDnsPublishConfigResult.getDnsType());
    assertEquals(0.1d, actualLoadDnsPublishConfigResult.getChangeThreshold(), 0.0);
    assertEquals(5, actualLoadDnsPublishConfigResult.getMaxMergeSize());
    assertFalse(actualLoadDnsPublishConfigResult.isDnsPublishEnable());
    assertTrue(actualLoadDnsPublishConfigResult.getKnownTreeUrls().isEmpty());
    assertTrue(actualLoadDnsPublishConfigResult.getStaticNodes().isEmpty());
  }

  /**
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  public void testLoadDnsPublishConfig9() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenReturn(10.0d);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    ArrayList<String> stringList = new ArrayList<>();
    when(config.getStringList(Mockito.<String>any())).thenReturn(stringList);
    when(config.getString(Mockito.<String>any())).thenReturn("aliyun");
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    PublishConfig actualLoadDnsPublishConfigResult = Args.loadDnsPublishConfig(config);

    // Assert
    verify(config).getBoolean(eq("node.dns.publish"));
    verify(config).getDouble(eq("node.dns.changeThreshold"));
    verify(config).getInt(eq("node.dns.maxMergeSize"));
    verify(config, atLeast(1)).getString(Mockito.<String>any());
    verify(config, atLeast(1)).getStringList(Mockito.<String>any());
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
    assertEquals("aliyun", actualLoadDnsPublishConfigResult.getAccessKeyId());
    assertEquals("aliyun", actualLoadDnsPublishConfigResult.getAccessKeySecret());
    assertEquals("aliyun", actualLoadDnsPublishConfigResult.getAliDnsEndpoint());
    assertEquals("aliyun", actualLoadDnsPublishConfigResult.getDnsDomain());
    assertEquals("aliyun", actualLoadDnsPublishConfigResult.getDnsPrivate());
    assertNull(actualLoadDnsPublishConfigResult.getAwsHostZoneId());
    assertNull(actualLoadDnsPublishConfigResult.getAwsRegion());
    assertEquals(1, actualLoadDnsPublishConfigResult.getMaxMergeSize());
    assertEquals(10.0d, actualLoadDnsPublishConfigResult.getChangeThreshold(), 0.0);
    assertEquals(DnsType.AliYun, actualLoadDnsPublishConfigResult.getDnsType());
    List<String> knownTreeUrls = actualLoadDnsPublishConfigResult.getKnownTreeUrls();
    assertTrue(knownTreeUrls.isEmpty());
    assertTrue(actualLoadDnsPublishConfigResult.getStaticNodes().isEmpty());
    assertTrue(actualLoadDnsPublishConfigResult.isDnsPublishEnable());
    assertSame(stringList, knownTreeUrls);
  }

  /**
   * Method under test:
   * {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  public void testLoadDnsPublishParameters() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenReturn(10.0d);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.getStringList(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    PublishConfig publishConfig = new PublishConfig();
    publishConfig.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAliDnsEndpoint("https://config.us-east-2.amazonaws.com");
    publishConfig.setAwsHostZoneId("UTC");
    publishConfig.setAwsRegion("us-east-2");
    publishConfig.setChangeThreshold(10.0d);
    publishConfig.setDnsDomain("Dns Domain");
    publishConfig.setDnsPrivate("Dns Private");
    publishConfig.setDnsPublishEnable(true);
    publishConfig.setDnsType(DnsType.AliYun);
    publishConfig.setKnownTreeUrls(new ArrayList<>());
    publishConfig.setMaxMergeSize(3);
    publishConfig.setStaticNodes(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.loadDnsPublishParameters(config, publishConfig));
    verify(config).getDouble(eq("node.dns.changeThreshold"));
    verify(config).getInt(eq("node.dns.maxMergeSize"));
    verify(config, atLeast(1)).getString(Mockito.<String>any());
    verify(config, atLeast(1)).getStringList(Mockito.<String>any());
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  public void testLoadDnsPublishParameters2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenThrow(new IllegalArgumentException("node.dns.dnsDomain"));
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    PublishConfig publishConfig = new PublishConfig();
    publishConfig.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAliDnsEndpoint("https://config.us-east-2.amazonaws.com");
    publishConfig.setAwsHostZoneId("UTC");
    publishConfig.setAwsRegion("us-east-2");
    publishConfig.setChangeThreshold(10.0d);
    publishConfig.setDnsDomain("Dns Domain");
    publishConfig.setDnsPrivate("Dns Private");
    publishConfig.setDnsPublishEnable(true);
    publishConfig.setDnsType(DnsType.AliYun);
    publishConfig.setKnownTreeUrls(new ArrayList<>());
    publishConfig.setMaxMergeSize(3);
    publishConfig.setStaticNodes(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.loadDnsPublishParameters(config, publishConfig));
    verify(config).getDouble(eq("node.dns.changeThreshold"));
    verify(config, atLeast(1)).getString(eq("node.dns.dnsDomain"));
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  public void testLoadDnsPublishParameters3() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenReturn(0.0d);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.getStringList(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    PublishConfig publishConfig = new PublishConfig();
    publishConfig.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAliDnsEndpoint("https://config.us-east-2.amazonaws.com");
    publishConfig.setAwsHostZoneId("UTC");
    publishConfig.setAwsRegion("us-east-2");
    publishConfig.setChangeThreshold(10.0d);
    publishConfig.setDnsDomain("Dns Domain");
    publishConfig.setDnsPrivate("Dns Private");
    publishConfig.setDnsPublishEnable(true);
    publishConfig.setDnsType(DnsType.AliYun);
    publishConfig.setKnownTreeUrls(new ArrayList<>());
    publishConfig.setMaxMergeSize(3);
    publishConfig.setStaticNodes(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.loadDnsPublishParameters(config, publishConfig));
    verify(config).getDouble(eq("node.dns.changeThreshold"));
    verify(config).getInt(eq("node.dns.maxMergeSize"));
    verify(config, atLeast(1)).getString(Mockito.<String>any());
    verify(config, atLeast(1)).getStringList(Mockito.<String>any());
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  public void testLoadDnsPublishParameters4() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenReturn(10.0d);
    when(config.getInt(Mockito.<String>any())).thenReturn(0);
    when(config.getStringList(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    PublishConfig publishConfig = new PublishConfig();
    publishConfig.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAliDnsEndpoint("https://config.us-east-2.amazonaws.com");
    publishConfig.setAwsHostZoneId("UTC");
    publishConfig.setAwsRegion("us-east-2");
    publishConfig.setChangeThreshold(10.0d);
    publishConfig.setDnsDomain("Dns Domain");
    publishConfig.setDnsPrivate("Dns Private");
    publishConfig.setDnsPublishEnable(true);
    publishConfig.setDnsType(DnsType.AliYun);
    publishConfig.setKnownTreeUrls(new ArrayList<>());
    publishConfig.setMaxMergeSize(3);
    publishConfig.setStaticNodes(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.loadDnsPublishParameters(config, publishConfig));
    verify(config).getDouble(eq("node.dns.changeThreshold"));
    verify(config).getInt(eq("node.dns.maxMergeSize"));
    verify(config, atLeast(1)).getString(Mockito.<String>any());
    verify(config, atLeast(1)).getStringList(Mockito.<String>any());
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  public void testLoadDnsPublishParameters5() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenReturn(10.0d);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.getStringList(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(config.getString(Mockito.<String>any())).thenReturn("aws");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    PublishConfig publishConfig = new PublishConfig();
    publishConfig.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAliDnsEndpoint("https://config.us-east-2.amazonaws.com");
    publishConfig.setAwsHostZoneId("UTC");
    publishConfig.setAwsRegion("us-east-2");
    publishConfig.setChangeThreshold(10.0d);
    publishConfig.setDnsDomain("Dns Domain");
    publishConfig.setDnsPrivate("Dns Private");
    publishConfig.setDnsPublishEnable(true);
    publishConfig.setDnsType(DnsType.AliYun);
    publishConfig.setKnownTreeUrls(new ArrayList<>());
    publishConfig.setMaxMergeSize(3);
    publishConfig.setStaticNodes(new ArrayList<>());

    // Act
    Args.loadDnsPublishParameters(config, publishConfig);

    // Assert
    verify(config).getDouble(eq("node.dns.changeThreshold"));
    verify(config).getInt(eq("node.dns.maxMergeSize"));
    verify(config, atLeast(1)).getString(Mockito.<String>any());
    verify(config, atLeast(1)).getStringList(Mockito.<String>any());
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
    assertEquals("aws", publishConfig.getAccessKeyId());
    assertEquals("aws", publishConfig.getAccessKeySecret());
    assertEquals("aws", publishConfig.getAwsHostZoneId());
    assertEquals("aws", publishConfig.getAwsRegion());
    assertEquals("aws", publishConfig.getDnsDomain());
    assertEquals("aws", publishConfig.getDnsPrivate());
    assertEquals("https://config.us-east-2.amazonaws.com", publishConfig.getAliDnsEndpoint());
    assertEquals(1, publishConfig.getMaxMergeSize());
    assertEquals(DnsType.AwsRoute53, publishConfig.getDnsType());
    assertTrue(publishConfig.getStaticNodes().isEmpty());
  }

  /**
   * Method under test:
   * {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  public void testLoadDnsPublishParameters6() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    PublishConfig publishConfig = new PublishConfig();
    publishConfig.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAliDnsEndpoint("https://config.us-east-2.amazonaws.com");
    publishConfig.setAwsHostZoneId("UTC");
    publishConfig.setAwsRegion("us-east-2");
    publishConfig.setChangeThreshold(10.0d);
    publishConfig.setDnsDomain("Dns Domain");
    publishConfig.setDnsPrivate("Dns Private");
    publishConfig.setDnsPublishEnable(true);
    publishConfig.setDnsType(DnsType.AliYun);
    publishConfig.setKnownTreeUrls(new ArrayList<>());
    publishConfig.setMaxMergeSize(3);
    publishConfig.setStaticNodes(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.loadDnsPublishParameters(config, publishConfig));
    verify(config).getString(eq("node.dns.dnsDomain"));
    verify(config).hasPath(eq("node.dns.dnsDomain"));
  }

  /**
   * Method under test:
   * {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  public void testLoadDnsPublishParameters7() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenReturn(10.0d);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.getStringList(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(config.getString(Mockito.<String>any())).thenReturn("aliyun");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    PublishConfig publishConfig = new PublishConfig();
    publishConfig.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAliDnsEndpoint("https://config.us-east-2.amazonaws.com");
    publishConfig.setAwsHostZoneId("UTC");
    publishConfig.setAwsRegion("us-east-2");
    publishConfig.setChangeThreshold(10.0d);
    publishConfig.setDnsDomain("Dns Domain");
    publishConfig.setDnsPrivate("Dns Private");
    publishConfig.setDnsPublishEnable(true);
    publishConfig.setDnsType(DnsType.AliYun);
    publishConfig.setKnownTreeUrls(new ArrayList<>());
    publishConfig.setMaxMergeSize(3);
    publishConfig.setStaticNodes(new ArrayList<>());

    // Act
    Args.loadDnsPublishParameters(config, publishConfig);

    // Assert
    verify(config).getDouble(eq("node.dns.changeThreshold"));
    verify(config).getInt(eq("node.dns.maxMergeSize"));
    verify(config, atLeast(1)).getString(Mockito.<String>any());
    verify(config, atLeast(1)).getStringList(Mockito.<String>any());
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
    assertEquals("UTC", publishConfig.getAwsHostZoneId());
    assertEquals("aliyun", publishConfig.getAccessKeyId());
    assertEquals("aliyun", publishConfig.getAccessKeySecret());
    assertEquals("aliyun", publishConfig.getAliDnsEndpoint());
    assertEquals("aliyun", publishConfig.getDnsDomain());
    assertEquals("aliyun", publishConfig.getDnsPrivate());
    assertEquals("us-east-2", publishConfig.getAwsRegion());
    assertEquals(1, publishConfig.getMaxMergeSize());
    assertEquals(DnsType.AliYun, publishConfig.getDnsType());
    assertTrue(publishConfig.getStaticNodes().isEmpty());
  }

  /**
   * Method under test:
   * {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  public void testLoadDnsPublishParameters8() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    PublishConfig publishConfig = new PublishConfig();
    publishConfig.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAliDnsEndpoint("https://config.us-east-2.amazonaws.com");
    publishConfig.setAwsHostZoneId("UTC");
    publishConfig.setAwsRegion("us-east-2");
    publishConfig.setChangeThreshold(10.0d);
    publishConfig.setDnsDomain("Dns Domain");
    publishConfig.setDnsPrivate("Dns Private");
    publishConfig.setDnsPublishEnable(true);
    publishConfig.setDnsType(DnsType.AliYun);
    publishConfig.setKnownTreeUrls(new ArrayList<>());
    publishConfig.setMaxMergeSize(3);
    publishConfig.setStaticNodes(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.loadDnsPublishParameters(config, publishConfig));
    verify(config).hasPath(eq("node.dns.dnsDomain"));
  }

  /**
   * Method under test:
   * {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  public void testLoadDnsPublishParameters9() {
    // Arrange
    Config config = mock(Config.class);
    PublishConfig publishConfig = mock(PublishConfig.class);
    when(publishConfig.isDnsPublishEnable()).thenReturn(false);
    doNothing().when(publishConfig).setAccessKeyId(Mockito.<String>any());
    doNothing().when(publishConfig).setAccessKeySecret(Mockito.<String>any());
    doNothing().when(publishConfig).setAliDnsEndpoint(Mockito.<String>any());
    doNothing().when(publishConfig).setAwsHostZoneId(Mockito.<String>any());
    doNothing().when(publishConfig).setAwsRegion(Mockito.<String>any());
    doNothing().when(publishConfig).setChangeThreshold(anyDouble());
    doNothing().when(publishConfig).setDnsDomain(Mockito.<String>any());
    doNothing().when(publishConfig).setDnsPrivate(Mockito.<String>any());
    doNothing().when(publishConfig).setDnsPublishEnable(anyBoolean());
    doNothing().when(publishConfig).setDnsType(Mockito.<DnsType>any());
    doNothing().when(publishConfig).setKnownTreeUrls(Mockito.<List<String>>any());
    doNothing().when(publishConfig).setMaxMergeSize(anyInt());
    doNothing().when(publishConfig).setStaticNodes(Mockito.<List<InetSocketAddress>>any());
    publishConfig.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
    publishConfig.setAliDnsEndpoint("https://config.us-east-2.amazonaws.com");
    publishConfig.setAwsHostZoneId("UTC");
    publishConfig.setAwsRegion("us-east-2");
    publishConfig.setChangeThreshold(10.0d);
    publishConfig.setDnsDomain("Dns Domain");
    publishConfig.setDnsPrivate("Dns Private");
    publishConfig.setDnsPublishEnable(true);
    publishConfig.setDnsType(DnsType.AliYun);
    publishConfig.setKnownTreeUrls(new ArrayList<>());
    publishConfig.setMaxMergeSize(3);
    publishConfig.setStaticNodes(new ArrayList<>());

    // Act
    Args.loadDnsPublishParameters(config, publishConfig);

    // Assert that nothing has changed
    verify(publishConfig).isDnsPublishEnable();
    verify(publishConfig).setAccessKeyId(eq("EXAMPLEakiAIOSFODNN7"));
    verify(publishConfig).setAccessKeySecret(eq("EXAMPLEakiAIOSFODNN7"));
    verify(publishConfig).setAliDnsEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(publishConfig).setAwsHostZoneId(eq("UTC"));
    verify(publishConfig).setAwsRegion(eq("us-east-2"));
    verify(publishConfig).setChangeThreshold(eq(10.0d));
    verify(publishConfig).setDnsDomain(eq("Dns Domain"));
    verify(publishConfig).setDnsPrivate(eq("Dns Private"));
    verify(publishConfig).setDnsPublishEnable(eq(true));
    verify(publishConfig).setDnsType(eq(DnsType.AliYun));
    verify(publishConfig).setKnownTreeUrls(isA(List.class));
    verify(publishConfig).setMaxMergeSize(eq(3));
    verify(publishConfig).setStaticNodes(isA(List.class));
  }

  /**
   * Method under test: {@link Args#getOutputDirectory()}
   */
  @Test
  public void testGetOutputDirectory() {
    // Arrange, Act and Assert
    assertEquals("output-directory/", args.getOutputDirectory());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Args#getLocalWitnesses()}
   *   <li>{@link Args#getSolidityContractEventTriggerMap()}
   *   <li>{@link Args#getSolidityContractLogTriggerMap()}
   *   <li>{@link Args#setFullNodeAllowShieldedTransaction(boolean)}
   *   <li>{@link Args#setLocalWitnesses(LocalWitnesses)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Args args = new Args();

    // Act
    LocalWitnesses actualLocalWitnesses = args.getLocalWitnesses();
    ConcurrentHashMap<Long, BlockingQueue<ContractEventTrigger>> actualSolidityContractEventTriggerMap = args
        .getSolidityContractEventTriggerMap();
    ConcurrentHashMap<Long, BlockingQueue<ContractLogTrigger>> actualSolidityContractLogTriggerMap = args
        .getSolidityContractLogTriggerMap();
    args.setFullNodeAllowShieldedTransaction(true);
    LocalWitnesses localWitnesses = Args.getLocalWitnesses();
    args.setLocalWitnesses(localWitnesses);

    // Assert
    assertTrue(actualSolidityContractEventTriggerMap.isEmpty());
    assertTrue(actualSolidityContractLogTriggerMap.isEmpty());
    assertSame(localWitnesses, actualLocalWitnesses);
  }
}
