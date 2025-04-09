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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.typesafe.config.Config;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.logsfilter.trigger.ContractEventTrigger;
import org.tron.common.logsfilter.trigger.ContractLogTrigger;
import org.tron.common.utils.LocalWitnesses;
import org.tron.p2p.dns.update.DnsType;
import org.tron.p2p.dns.update.PublishConfig;

@RunWith(MockitoJUnitRunner.class)
public class ArgsDiffblueTest {
  @InjectMocks
  private Args args;

  @InjectMocks
  private ConcurrentHashMap<Long, BlockingQueue<ContractEventTrigger>> concurrentHashMap;

  @InjectMocks
  private ConcurrentHashMap<Long, BlockingQueue<ContractLogTrigger>> concurrentHashMap2;

  /**
   * Test {@link Args#printHelp(JCommander)}.
   * <p>
   * Method under test: {@link Args#printHelp(JCommander)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.printHelp(JCommander)"})
  public void testPrintHelp() {
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
   * Test {@link Args#printHelp(JCommander)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link JCommander#getParameters()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#printHelp(JCommander)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.printHelp(JCommander)"})
  public void testPrintHelp_givenArrayList_thenCallsGetParameters() {
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
   * Test {@link Args#printHelp(JCommander)}.
   * <ul>
   *   <li>Given {@link ParameterDescription} {@link ParameterDescription#getDescription()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#printHelp(JCommander)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.printHelp(JCommander)"})
  public void testPrintHelp_givenParameterDescriptionGetDescriptionReturnEmptyString() {
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
   * Test {@link Args#printHelp(JCommander)}.
   * <ul>
   *   <li>Given {@link ParameterDescription} {@link ParameterDescription#getNames()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#printHelp(JCommander)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.printHelp(JCommander)"})
  public void testPrintHelp_givenParameterDescriptionGetNamesReturnEmptyString() {
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
   * Test {@link Args#printHelp(JCommander)}.
   * <ul>
   *   <li>Given {@link Parameterized} {@link Parameterized#getName()} return {@code Name}.</li>
   *   <li>Then calls {@link ParameterDescription#getParameterized()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#printHelp(JCommander)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.printHelp(JCommander)"})
  public void testPrintHelp_givenParameterizedGetNameReturnName_thenCallsGetParameterized() {
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
   * Test {@link Args#printHelp(JCommander)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#printHelp(JCommander)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.printHelp(JCommander)"})
  public void testPrintHelp_thenThrowIllegalArgumentException() {
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
   * Test {@link Args#upperFirst(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#upperFirst(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Args.upperFirst(String)"})
  public void testUpperFirst_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", Args.upperFirst(""));
  }

  /**
   * Test {@link Args#upperFirst(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#upperFirst(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Args.upperFirst(String)"})
  public void testUpperFirst_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", Args.upperFirst("Name"));
  }

  /**
   * Test {@link Args#getInetSocketAddress(Config, String, boolean)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#getInetSocketAddress(Config, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Args.getInetSocketAddress(Config, String, boolean)"})
  public void testGetInetSocketAddress_givenArrayList_thenReturnEmpty() {
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
   * Test {@link Args#getInetSocketAddress(Config, String, boolean)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#getInetSocketAddress(Config, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Args.getInetSocketAddress(Config, String, boolean)"})
  public void testGetInetSocketAddress_givenFalse_whenConfigHasPathReturnFalse_thenReturnEmpty() {
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
   * Test {@link Args#getInetSocketAddress(Config, String, boolean)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#getInetSocketAddress(Config, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Args.getInetSocketAddress(Config, String, boolean)"})
  public void testGetInetSocketAddress_thenThrowIllegalArgumentException() {
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
   * Test {@link Args#getInetAddress(Config, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#getInetAddress(Config, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Args.getInetAddress(Config, String)"})
  public void testGetInetAddress_givenArrayList_thenReturnEmpty() {
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
   * Test {@link Args#getInetAddress(Config, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#getInetAddress(Config, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Args.getInetAddress(Config, String)"})
  public void testGetInetAddress_givenFalse_whenConfigHasPathReturnFalse_thenReturnEmpty() {
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
   * Test {@link Args#getInetAddress(Config, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#getInetAddress(Config, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Args.getInetAddress(Config, String)"})
  public void testGetInetAddress_thenThrowIllegalArgumentException() {
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
   * Test {@link Args#loadDnsPublishConfig(Config)}.
   * <ul>
   *   <li>Given {@code aliyun}.</li>
   *   <li>Then return AccessKeyId is {@code aliyun}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PublishConfig Args.loadDnsPublishConfig(Config)"})
  public void testLoadDnsPublishConfig_givenAliyun_thenReturnAccessKeyIdIsAliyun() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenReturn(10.0d);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.getStringList(Mockito.<String>any())).thenReturn(new ArrayList<>());
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
    assertEquals(DnsType.AliYun, actualLoadDnsPublishConfigResult.getDnsType());
  }

  /**
   * Test {@link Args#loadDnsPublishConfig(Config)}.
   * <ul>
   *   <li>Given {@code aws}.</li>
   *   <li>Then return AccessKeyId is {@code aws}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PublishConfig Args.loadDnsPublishConfig(Config)"})
  public void testLoadDnsPublishConfig_givenAws_thenReturnAccessKeyIdIsAws() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getDouble(Mockito.<String>any())).thenReturn(10.0d);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.getStringList(Mockito.<String>any())).thenReturn(new ArrayList<>());
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
    assertEquals(DnsType.AwsRoute53, actualLoadDnsPublishConfigResult.getDnsType());
  }

  /**
   * Test {@link Args#loadDnsPublishConfig(Config)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link Config} {@link Config#getString(String)} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PublishConfig Args.loadDnsPublishConfig(Config)"})
  public void testLoadDnsPublishConfig_givenEmptyString_whenConfigGetStringReturnEmptyString() {
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
   * Test {@link Args#loadDnsPublishConfig(Config)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code node.dns.publish}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PublishConfig Args.loadDnsPublishConfig(Config)"})
  public void testLoadDnsPublishConfig_givenIllegalArgumentExceptionWithNodeDnsPublish() {
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
   * Test {@link Args#loadDnsPublishConfig(Config)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PublishConfig Args.loadDnsPublishConfig(Config)"})
  public void testLoadDnsPublishConfig_givenTen_thenThrowIllegalArgumentException() {
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
   * Test {@link Args#loadDnsPublishConfig(Config)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link Config} {@link Config#getDouble(String)} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PublishConfig Args.loadDnsPublishConfig(Config)"})
  public void testLoadDnsPublishConfig_givenZero_whenConfigGetDoubleReturnZero() {
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
   * Test {@link Args#loadDnsPublishConfig(Config)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link Config} {@link Config#getInt(String)} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PublishConfig Args.loadDnsPublishConfig(Config)"})
  public void testLoadDnsPublishConfig_givenZero_whenConfigGetIntReturnZero() {
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
   * Test {@link Args#loadDnsPublishConfig(Config)}.
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PublishConfig Args.loadDnsPublishConfig(Config)"})
  public void testLoadDnsPublishConfig_whenConfigGetBooleanReturnFalse() {
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
    assertNull(actualLoadDnsPublishConfigResult.getDnsDomain());
    assertNull(actualLoadDnsPublishConfigResult.getDnsPrivate());
    assertNull(actualLoadDnsPublishConfigResult.getDnsType());
    assertEquals(0.1d, actualLoadDnsPublishConfigResult.getChangeThreshold(), 0.0);
    assertEquals(5, actualLoadDnsPublishConfigResult.getMaxMergeSize());
    assertFalse(actualLoadDnsPublishConfigResult.isDnsPublishEnable());
  }

  /**
   * Test {@link Args#loadDnsPublishConfig(Config)}.
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PublishConfig Args.loadDnsPublishConfig(Config)"})
  public void testLoadDnsPublishConfig_whenConfigHasPathReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    PublishConfig actualLoadDnsPublishConfigResult = Args.loadDnsPublishConfig(config);

    // Assert
    verify(config).hasPath(eq("node.dns.publish"));
    assertNull(actualLoadDnsPublishConfigResult.getAccessKeyId());
    assertNull(actualLoadDnsPublishConfigResult.getAccessKeySecret());
    assertNull(actualLoadDnsPublishConfigResult.getDnsDomain());
    assertNull(actualLoadDnsPublishConfigResult.getDnsPrivate());
    assertNull(actualLoadDnsPublishConfigResult.getDnsType());
    assertEquals(0.1d, actualLoadDnsPublishConfigResult.getChangeThreshold(), 0.0);
    assertEquals(5, actualLoadDnsPublishConfigResult.getMaxMergeSize());
    assertFalse(actualLoadDnsPublishConfigResult.isDnsPublishEnable());
  }

  /**
   * Test {@link Args#loadDnsPublishParameters(Config, PublishConfig)}.
   * <ul>
   *   <li>Given {@code aliyun}.</li>
   *   <li>Then {@link PublishConfig} (default constructor) AccessKeyId is {@code aliyun}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.loadDnsPublishParameters(Config, PublishConfig)"})
  public void testLoadDnsPublishParameters_givenAliyun_thenPublishConfigAccessKeyIdIsAliyun() {
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
    assertEquals("aliyun", publishConfig.getAccessKeyId());
    assertEquals("aliyun", publishConfig.getAccessKeySecret());
    assertEquals("aliyun", publishConfig.getAliDnsEndpoint());
    assertEquals("aliyun", publishConfig.getDnsDomain());
    assertEquals("aliyun", publishConfig.getDnsPrivate());
  }

  /**
   * Test {@link Args#loadDnsPublishParameters(Config, PublishConfig)}.
   * <ul>
   *   <li>Given {@code aws}.</li>
   *   <li>Then {@link PublishConfig} (default constructor) AccessKeyId is {@code aws}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.loadDnsPublishParameters(Config, PublishConfig)"})
  public void testLoadDnsPublishParameters_givenAws_thenPublishConfigAccessKeyIdIsAws() {
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
    assertEquals(DnsType.AwsRoute53, publishConfig.getDnsType());
  }

  /**
   * Test {@link Args#loadDnsPublishParameters(Config, PublishConfig)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.loadDnsPublishParameters(Config, PublishConfig)"})
  public void testLoadDnsPublishParameters_givenEmptyString() {
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
   * Test {@link Args#loadDnsPublishParameters(Config, PublishConfig)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.loadDnsPublishParameters(Config, PublishConfig)"})
  public void testLoadDnsPublishParameters_givenFalse_whenConfigHasPathReturnFalse() {
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
   * Test {@link Args#loadDnsPublishParameters(Config, PublishConfig)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Config}.</li>
   *   <li>Then calls {@link PublishConfig#isDnsPublishEnable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.loadDnsPublishParameters(Config, PublishConfig)"})
  public void testLoadDnsPublishParameters_givenFalse_whenConfig_thenCallsIsDnsPublishEnable() {
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

    // Assert
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
   * Test {@link Args#loadDnsPublishParameters(Config, PublishConfig)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code node.dns.dnsDomain}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.loadDnsPublishParameters(Config, PublishConfig)"})
  public void testLoadDnsPublishParameters_givenIllegalArgumentExceptionWithNodeDnsDnsDomain() {
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
   * Test {@link Args#loadDnsPublishParameters(Config, PublishConfig)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link Config#getInt(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.loadDnsPublishParameters(Config, PublishConfig)"})
  public void testLoadDnsPublishParameters_givenOne_thenCallsGetInt() {
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
   * Test {@link Args#loadDnsPublishParameters(Config, PublishConfig)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link Config} {@link Config#getDouble(String)} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.loadDnsPublishParameters(Config, PublishConfig)"})
  public void testLoadDnsPublishParameters_givenZero_whenConfigGetDoubleReturnZero() {
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
   * Test {@link Args#loadDnsPublishParameters(Config, PublishConfig)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link Config} {@link Config#getInt(String)} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#loadDnsPublishParameters(Config, PublishConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Args.loadDnsPublishParameters(Config, PublishConfig)"})
  public void testLoadDnsPublishParameters_givenZero_whenConfigGetIntReturnZero() {
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
   * Test {@link Args#getOutputDirectory()}.
   * <ul>
   *   <li>Given {@link Args} (default constructor).</li>
   *   <li>Then return {@code output-directory/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#getOutputDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Args.getOutputDirectory()"})
  public void testGetOutputDirectory_givenArgs_thenReturnOutputDirectory() {
    // Arrange, Act and Assert
    assertEquals("output-directory/", (new Args()).getOutputDirectory());
  }

  /**
   * Test {@link Args#getOutputDirectory()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Args#getOutputDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Args.getOutputDirectory()"})
  public void testGetOutputDirectory_thenReturnEmptyString() {
    // Arrange
    Args args = new Args();
    args.outputDirectory = "";

    // Act and Assert
    assertEquals("", args.getOutputDirectory());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LocalWitnesses Args.getLocalWitnesses()",
      "ConcurrentHashMap Args.getSolidityContractEventTriggerMap()",
      "ConcurrentHashMap Args.getSolidityContractLogTriggerMap()",
      "void Args.setFullNodeAllowShieldedTransaction(boolean)", "void Args.setLocalWitnesses(LocalWitnesses)"})
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
