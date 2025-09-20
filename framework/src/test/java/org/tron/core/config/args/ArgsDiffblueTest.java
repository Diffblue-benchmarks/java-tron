package org.tron.core.config.args;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.mockito.Mockito;
import org.tron.common.logsfilter.trigger.ContractEventTrigger;
import org.tron.common.logsfilter.trigger.ContractLogTrigger;
import org.tron.common.utils.LocalWitnesses;

public class ArgsDiffblueTest {
  /**
   * Test {@link Args#getInetSocketAddress(Config, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Args#getInetSocketAddress(Config, String, boolean)}
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
    List<InetSocketAddress> actualInetSocketAddress =
        Args.getInetSocketAddress(config, "Path", true);

    // Assert
    verify(config).getStringList("Path");
    verify(config).hasPath("Path");
    assertTrue(actualInetSocketAddress.isEmpty());
  }

  /**
   * Test {@link Args#getInetSocketAddress(Config, String, boolean)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Args#getInetSocketAddress(Config, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Args.getInetSocketAddress(Config, String, boolean)"})
  public void testGetInetSocketAddress_givenFalse_whenConfigHasPathReturnFalse_thenReturnEmpty() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    List<InetSocketAddress> actualInetSocketAddress =
        Args.getInetSocketAddress(config, "Path", true);

    // Assert
    verify(config).hasPath("Path");
    assertTrue(actualInetSocketAddress.isEmpty());
  }

  /**
   * Test {@link Args#getInetSocketAddress(Config, String, boolean)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getStringList(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Args#getInetSocketAddress(Config, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Args.getInetSocketAddress(Config, String, boolean)"})
  public void testGetInetSocketAddress_whenConfigGetStringListThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getStringList(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Args.getInetSocketAddress(config, "Path", true));
    verify(config).getStringList("Path");
    verify(config).hasPath("Path");
  }

  /**
   * Test {@link Args#getInetSocketAddress(Config, String, boolean)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Args#getInetSocketAddress(Config, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Args.getInetSocketAddress(Config, String, boolean)"})
  public void testGetInetSocketAddress_whenConfigHasPathThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Args.getInetSocketAddress(config, "Path", true));
    verify(config).hasPath("Path");
  }

  /**
   * Test {@link Args#getInetAddress(Config, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Args#getInetAddress(Config, String)}
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
    verify(config).getStringList("Path");
    verify(config).hasPath("Path");
    assertTrue(actualInetAddress.isEmpty());
  }

  /**
   * Test {@link Args#getInetAddress(Config, String)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Args#getInetAddress(Config, String)}
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
    verify(config).hasPath("Path");
    assertTrue(actualInetAddress.isEmpty());
  }

  /**
   * Test {@link Args#getInetAddress(Config, String)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getStringList(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Args#getInetAddress(Config, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Args.getInetAddress(Config, String)"})
  public void testGetInetAddress_whenConfigGetStringListThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getStringList(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.getInetAddress(config, "Path"));
    verify(config).getStringList("Path");
    verify(config).hasPath("Path");
  }

  /**
   * Test {@link Args#getInetAddress(Config, String)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Args#getInetAddress(Config, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Args.getInetAddress(Config, String)"})
  public void testGetInetAddress_whenConfigHasPathThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Args.getInetAddress(config, "Path"));
    verify(config).hasPath("Path");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @MethodsUnderTest({
    "LocalWitnesses Args.getLocalWitnesses()",
    "ConcurrentHashMap Args.getSolidityContractEventTriggerMap()",
    "ConcurrentHashMap Args.getSolidityContractLogTriggerMap()",
    "void Args.setFullNodeAllowShieldedTransaction(boolean)",
    "void Args.setLocalWitnesses(LocalWitnesses)"
  })
  public void testGettersAndSetters() {
    // Arrange
    Args args = new Args();

    // Act
    LocalWitnesses actualLocalWitnesses = args.getLocalWitnesses();
    ConcurrentHashMap<Long, BlockingQueue<ContractEventTrigger>>
        actualSolidityContractEventTriggerMap = args.getSolidityContractEventTriggerMap();
    ConcurrentHashMap<Long, BlockingQueue<ContractLogTrigger>> actualSolidityContractLogTriggerMap =
        args.getSolidityContractLogTriggerMap();
    args.setFullNodeAllowShieldedTransaction(true);
    LocalWitnesses localWitnesses = Args.getLocalWitnesses();
    args.setLocalWitnesses(localWitnesses);

    // Assert
    assertTrue(actualSolidityContractEventTriggerMap.isEmpty());
    assertTrue(actualSolidityContractLogTriggerMap.isEmpty());
    assertSame(localWitnesses, actualLocalWitnesses);
  }
}
