package org.tron.core.config.args;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.iq80.leveldb.CompressionType;
import org.iq80.leveldb.Options;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.cache.CacheType;
import org.tron.common.utils.Property;
import org.tron.common.utils.Sha256Hash;

@RunWith(MockitoJUnitRunner.class)
public class StorageDiffblueTest {
  @Mock private Config config;

  @Mock private Options options;

  @InjectMocks private Storage storage;

  /**
   * Test {@link Storage#getDbEngineFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code LEVELDB}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getDbEngineFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getDbEngineFromConfig(Config)"})
  public void testGetDbEngineFromConfig_givenFalse_thenReturnLeveldb() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    String actualDbEngineFromConfig = Storage.getDbEngineFromConfig(config);

    // Assert
    verify(config).hasPath("storage.db.engine");
    assertEquals("LEVELDB", actualDbEngineFromConfig);
  }

  /**
   * Test {@link Storage#getDbEngineFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getDbEngineFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getDbEngineFromConfig(Config)"})
  public void testGetDbEngineFromConfig_givenString_thenReturnString() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualDbEngineFromConfig = Storage.getDbEngineFromConfig(config);

    // Assert
    verify(config).getString("storage.db.engine");
    verify(config).hasPath("storage.db.engine");
    assertEquals("String", actualDbEngineFromConfig);
  }

  /**
   * Test {@link Storage#getDbEngineFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getString(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getDbEngineFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getDbEngineFromConfig(Config)"})
  public void testGetDbEngineFromConfig_whenConfigGetStringThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbEngineFromConfig(config));
    verify(config).getString("storage.db.engine");
    verify(config).hasPath("storage.db.engine");
  }

  /**
   * Test {@link Storage#getDbEngineFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getDbEngineFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getDbEngineFromConfig(Config)"})
  public void testGetDbEngineFromConfig_whenConfigHasPathThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbEngineFromConfig(config));
    verify(config).hasPath("storage.db.engine");
  }

  /**
   * Test {@link Storage#getDbVersionSyncFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Storage.getDbVersionSyncFromConfig(Config)"})
  public void testGetDbVersionSyncFromConfig_givenFalse_thenReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    Boolean actualDbVersionSyncFromConfig = Storage.getDbVersionSyncFromConfig(config);

    // Assert
    verify(config).hasPath("storage.db.sync");
    assertFalse(actualDbVersionSyncFromConfig);
  }

  /**
   * Test {@link Storage#getDbVersionSyncFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Storage.getDbVersionSyncFromConfig(Config)"})
  public void testGetDbVersionSyncFromConfig_whenConfigGetBooleanReturnTrue_thenReturnTrue() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    Boolean actualDbVersionSyncFromConfig = Storage.getDbVersionSyncFromConfig(config);

    // Assert
    verify(config).getBoolean("storage.db.sync");
    verify(config).hasPath("storage.db.sync");
    assertTrue(actualDbVersionSyncFromConfig);
  }

  /**
   * Test {@link Storage#getDbVersionSyncFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Storage.getDbVersionSyncFromConfig(Config)"})
  public void testGetDbVersionSyncFromConfig_whenConfigGetBooleanThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbVersionSyncFromConfig(config));
    verify(config).getBoolean("storage.db.sync");
    verify(config).hasPath("storage.db.sync");
  }

  /**
   * Test {@link Storage#getDbVersionSyncFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Storage.getDbVersionSyncFromConfig(Config)"})
  public void testGetDbVersionSyncFromConfig_whenConfigHasPathThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbVersionSyncFromConfig(config));
    verify(config).hasPath("storage.db.sync");
  }

  /**
   * Test {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getSnapshotMaxFlushCountFromConfig(Config)"})
  public void testGetSnapshotMaxFlushCountFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Storage.getSnapshotMaxFlushCountFromConfig(config));
    verify(config).hasPath("storage.snapshot.maxFlushCount");
  }

  /**
   * Test {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getSnapshotMaxFlushCountFromConfig(Config)"})
  public void testGetSnapshotMaxFlushCountFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Storage.getSnapshotMaxFlushCountFromConfig(config));
    verify(config).getInt("storage.snapshot.maxFlushCount");
    verify(config).hasPath("storage.snapshot.maxFlushCount");
  }

  /**
   * Test {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getSnapshotMaxFlushCountFromConfig(Config)"})
  public void testGetSnapshotMaxFlushCountFromConfig_givenFalse_whenConfigHasPathReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    int actualSnapshotMaxFlushCountFromConfig = Storage.getSnapshotMaxFlushCountFromConfig(config);

    // Assert
    verify(config).hasPath("storage.snapshot.maxFlushCount");
    assertEquals(1, actualSnapshotMaxFlushCountFromConfig);
  }

  /**
   * Test {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given five hundred one.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getSnapshotMaxFlushCountFromConfig(Config)"})
  public void testGetSnapshotMaxFlushCountFromConfig_givenFiveHundredOne() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenReturn(501);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Storage.getSnapshotMaxFlushCountFromConfig(config));
    verify(config).getInt("storage.snapshot.maxFlushCount");
    verify(config).hasPath("storage.snapshot.maxFlushCount");
  }

  /**
   * Test {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Config} {@link Config#getInt(String)} return one.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getSnapshotMaxFlushCountFromConfig(Config)"})
  public void testGetSnapshotMaxFlushCountFromConfig_givenOne_whenConfigGetIntReturnOne() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    int actualSnapshotMaxFlushCountFromConfig = Storage.getSnapshotMaxFlushCountFromConfig(config);

    // Assert
    verify(config).getInt("storage.snapshot.maxFlushCount");
    verify(config).hasPath("storage.snapshot.maxFlushCount");
    assertEquals(1, actualSnapshotMaxFlushCountFromConfig);
  }

  /**
   * Test {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link Config} {@link Config#getInt(String)} return zero.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getSnapshotMaxFlushCountFromConfig(Config)"})
  public void testGetSnapshotMaxFlushCountFromConfig_givenZero_whenConfigGetIntReturnZero() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenReturn(0);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Storage.getSnapshotMaxFlushCountFromConfig(config));
    verify(config).getInt("storage.snapshot.maxFlushCount");
    verify(config).hasPath("storage.snapshot.maxFlushCount");
  }

  /**
   * Test {@link Storage#getContractParseSwitchFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Storage.getContractParseSwitchFromConfig(Config)"})
  public void testGetContractParseSwitchFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Storage.getContractParseSwitchFromConfig(config));
    verify(config).hasPath("event.subscribe.contractParse");
  }

  /**
   * Test {@link Storage#getContractParseSwitchFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Storage.getContractParseSwitchFromConfig(Config)"})
  public void testGetContractParseSwitchFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Storage.getContractParseSwitchFromConfig(config));
    verify(config).getBoolean("event.subscribe.contractParse");
    verify(config).hasPath("event.subscribe.contractParse");
  }

  /**
   * Test {@link Storage#getContractParseSwitchFromConfig(Config)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Storage.getContractParseSwitchFromConfig(Config)"})
  public void testGetContractParseSwitchFromConfig_thenReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(false);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    Boolean actualContractParseSwitchFromConfig = Storage.getContractParseSwitchFromConfig(config);

    // Assert
    verify(config).getBoolean("event.subscribe.contractParse");
    verify(config).hasPath("event.subscribe.contractParse");
    assertFalse(actualContractParseSwitchFromConfig);
  }

  /**
   * Test {@link Storage#getContractParseSwitchFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Storage.getContractParseSwitchFromConfig(Config)"})
  public void testGetContractParseSwitchFromConfig_whenConfigGetBooleanReturnTrue() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    Boolean actualContractParseSwitchFromConfig = Storage.getContractParseSwitchFromConfig(config);

    // Assert
    verify(config).getBoolean("event.subscribe.contractParse");
    verify(config).hasPath("event.subscribe.contractParse");
    assertTrue(actualContractParseSwitchFromConfig);
  }

  /**
   * Test {@link Storage#getContractParseSwitchFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Storage.getContractParseSwitchFromConfig(Config)"})
  public void testGetContractParseSwitchFromConfig_whenConfigHasPathReturnFalse_thenReturnTrue() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    Boolean actualContractParseSwitchFromConfig = Storage.getContractParseSwitchFromConfig(config);

    // Assert
    verify(config).hasPath("event.subscribe.contractParse");
    assertTrue(actualContractParseSwitchFromConfig);
  }

  /**
   * Test {@link Storage#getDbDirectoryFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code database}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getDbDirectoryFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getDbDirectoryFromConfig(Config)"})
  public void testGetDbDirectoryFromConfig_givenFalse_thenReturnDatabase() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    String actualDbDirectoryFromConfig = Storage.getDbDirectoryFromConfig(config);

    // Assert
    verify(config).hasPath("storage.db.directory");
    assertEquals("database", actualDbDirectoryFromConfig);
  }

  /**
   * Test {@link Storage#getDbDirectoryFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getDbDirectoryFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getDbDirectoryFromConfig(Config)"})
  public void testGetDbDirectoryFromConfig_givenString_thenReturnString() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualDbDirectoryFromConfig = Storage.getDbDirectoryFromConfig(config);

    // Assert
    verify(config).getString("storage.db.directory");
    verify(config).hasPath("storage.db.directory");
    assertEquals("String", actualDbDirectoryFromConfig);
  }

  /**
   * Test {@link Storage#getDbDirectoryFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getString(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getDbDirectoryFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getDbDirectoryFromConfig(Config)"})
  public void testGetDbDirectoryFromConfig_whenConfigGetStringThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbDirectoryFromConfig(config));
    verify(config).getString("storage.db.directory");
    verify(config).hasPath("storage.db.directory");
  }

  /**
   * Test {@link Storage#getDbDirectoryFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getDbDirectoryFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getDbDirectoryFromConfig(Config)"})
  public void testGetDbDirectoryFromConfig_whenConfigHasPathThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbDirectoryFromConfig(config));
    verify(config).hasPath("storage.db.directory");
  }

  /**
   * Test {@link Storage#getIndexDirectoryFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code index}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getIndexDirectoryFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getIndexDirectoryFromConfig(Config)"})
  public void testGetIndexDirectoryFromConfig_givenFalse_thenReturnIndex() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    String actualIndexDirectoryFromConfig = Storage.getIndexDirectoryFromConfig(config);

    // Assert
    verify(config).hasPath("storage.index.directory");
    assertEquals("index", actualIndexDirectoryFromConfig);
  }

  /**
   * Test {@link Storage#getIndexDirectoryFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getIndexDirectoryFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getIndexDirectoryFromConfig(Config)"})
  public void testGetIndexDirectoryFromConfig_givenString_thenReturnString() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualIndexDirectoryFromConfig = Storage.getIndexDirectoryFromConfig(config);

    // Assert
    verify(config).getString("storage.index.directory");
    verify(config).hasPath("storage.index.directory");
    assertEquals("String", actualIndexDirectoryFromConfig);
  }

  /**
   * Test {@link Storage#getIndexDirectoryFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getString(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getIndexDirectoryFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getIndexDirectoryFromConfig(Config)"})
  public void testGetIndexDirectoryFromConfig_whenConfigGetStringThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getIndexDirectoryFromConfig(config));
    verify(config).getString("storage.index.directory");
    verify(config).hasPath("storage.index.directory");
  }

  /**
   * Test {@link Storage#getIndexDirectoryFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getIndexDirectoryFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getIndexDirectoryFromConfig(Config)"})
  public void testGetIndexDirectoryFromConfig_whenConfigHasPathThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getIndexDirectoryFromConfig(config));
    verify(config).hasPath("storage.index.directory");
  }

  /**
   * Test {@link Storage#getIndexSwitchFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getIndexSwitchFromConfig(Config)"})
  public void testGetIndexSwitchFromConfig_givenEmptyString() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualIndexSwitchFromConfig = Storage.getIndexSwitchFromConfig(config);

    // Assert
    verify(config).getString("storage.index.switch");
    verify(config).hasPath("storage.index.switch");
    assertEquals("on", actualIndexSwitchFromConfig);
  }

  /**
   * Test {@link Storage#getIndexSwitchFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getIndexSwitchFromConfig(Config)"})
  public void testGetIndexSwitchFromConfig_givenFalse_whenConfigHasPathReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    String actualIndexSwitchFromConfig = Storage.getIndexSwitchFromConfig(config);

    // Assert
    verify(config).hasPath("storage.index.switch");
    assertEquals("on", actualIndexSwitchFromConfig);
  }

  /**
   * Test {@link Storage#getIndexSwitchFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code not empty}.
   *   <li>Then return {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getIndexSwitchFromConfig(Config)"})
  public void testGetIndexSwitchFromConfig_givenNotEmpty_thenReturnNotEmpty() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("not empty");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualIndexSwitchFromConfig = Storage.getIndexSwitchFromConfig(config);

    // Assert
    verify(config, atLeast(1)).getString("storage.index.switch");
    verify(config).hasPath("storage.index.switch");
    assertEquals("not empty", actualIndexSwitchFromConfig);
  }

  /**
   * Test {@link Storage#getIndexSwitchFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getString(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getIndexSwitchFromConfig(Config)"})
  public void testGetIndexSwitchFromConfig_whenConfigGetStringThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getIndexSwitchFromConfig(config));
    verify(config).getString("storage.index.switch");
    verify(config).hasPath("storage.index.switch");
  }

  /**
   * Test {@link Storage#getIndexSwitchFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getIndexSwitchFromConfig(Config)"})
  public void testGetIndexSwitchFromConfig_whenConfigHasPathThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getIndexSwitchFromConfig(config));
    verify(config).hasPath("storage.index.switch");
  }

  /**
   * Test {@link Storage#getTransactionHistorySwitchFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#getTransactionHistorySwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getTransactionHistorySwitchFromConfig(Config)"})
  public void testGetTransactionHistorySwitchFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Storage.getTransactionHistorySwitchFromConfig(config));
    verify(config).hasPath("storage.transHistory.switch");
  }

  /**
   * Test {@link Storage#getTransactionHistorySwitchFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#getTransactionHistorySwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getTransactionHistorySwitchFromConfig(Config)"})
  public void testGetTransactionHistorySwitchFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Storage.getTransactionHistorySwitchFromConfig(config));
    verify(config).getString("storage.transHistory.switch");
    verify(config).hasPath("storage.transHistory.switch");
  }

  /**
   * Test {@link Storage#getTransactionHistorySwitchFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code on}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getTransactionHistorySwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getTransactionHistorySwitchFromConfig(Config)"})
  public void testGetTransactionHistorySwitchFromConfig_givenFalse_thenReturnOn() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    String actualTransactionHistorySwitchFromConfig =
        Storage.getTransactionHistorySwitchFromConfig(config);

    // Assert
    verify(config).hasPath("storage.transHistory.switch");
    assertEquals("on", actualTransactionHistorySwitchFromConfig);
  }

  /**
   * Test {@link Storage#getTransactionHistorySwitchFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getTransactionHistorySwitchFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getTransactionHistorySwitchFromConfig(Config)"})
  public void testGetTransactionHistorySwitchFromConfig_givenString_thenReturnString() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualTransactionHistorySwitchFromConfig =
        Storage.getTransactionHistorySwitchFromConfig(config);

    // Assert
    verify(config).getString("storage.transHistory.switch");
    verify(config).hasPath("storage.transHistory.switch");
    assertEquals("String", actualTransactionHistorySwitchFromConfig);
  }

  /**
   * Test {@link Storage#getCheckpointVersionFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#getCheckpointVersionFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getCheckpointVersionFromConfig(Config)"})
  public void testGetCheckpointVersionFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Storage.getCheckpointVersionFromConfig(config));
    verify(config).hasPath("storage.checkpoint.version");
  }

  /**
   * Test {@link Storage#getCheckpointVersionFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getCheckpointVersionFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getCheckpointVersionFromConfig(Config)"})
  public void testGetCheckpointVersionFromConfig_givenFalse_whenConfigHasPathReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    int actualCheckpointVersionFromConfig = Storage.getCheckpointVersionFromConfig(config);

    // Assert
    verify(config).hasPath("storage.checkpoint.version");
    assertEquals(1, actualCheckpointVersionFromConfig);
  }

  /**
   * Test {@link Storage#getCheckpointVersionFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Config} {@link Config#getInt(String)} return one.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getCheckpointVersionFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getCheckpointVersionFromConfig(Config)"})
  public void testGetCheckpointVersionFromConfig_givenOne_whenConfigGetIntReturnOne() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    int actualCheckpointVersionFromConfig = Storage.getCheckpointVersionFromConfig(config);

    // Assert
    verify(config).getInt("storage.checkpoint.version");
    verify(config).hasPath("storage.checkpoint.version");
    assertEquals(1, actualCheckpointVersionFromConfig);
  }

  /**
   * Test {@link Storage#getCheckpointVersionFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getInt(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getCheckpointVersionFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getCheckpointVersionFromConfig(Config)"})
  public void testGetCheckpointVersionFromConfig_whenConfigGetIntThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Storage.getCheckpointVersionFromConfig(config));
    verify(config).getInt("storage.checkpoint.version");
    verify(config).hasPath("storage.checkpoint.version");
  }

  /**
   * Test {@link Storage#getCheckpointSyncFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Storage.getCheckpointSyncFromConfig(Config)"})
  public void testGetCheckpointSyncFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getCheckpointSyncFromConfig(config));
    verify(config).getBoolean("storage.checkpoint.sync");
    verify(config).hasPath("storage.checkpoint.sync");
  }

  /**
   * Test {@link Storage#getCheckpointSyncFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Storage.getCheckpointSyncFromConfig(Config)"})
  public void testGetCheckpointSyncFromConfig_whenConfigGetBooleanReturnFalse_thenReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(false);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualCheckpointSyncFromConfig = Storage.getCheckpointSyncFromConfig(config);

    // Assert
    verify(config).getBoolean("storage.checkpoint.sync");
    verify(config).hasPath("storage.checkpoint.sync");
    assertFalse(actualCheckpointSyncFromConfig);
  }

  /**
   * Test {@link Storage#getCheckpointSyncFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Storage.getCheckpointSyncFromConfig(Config)"})
  public void testGetCheckpointSyncFromConfig_whenConfigGetBooleanReturnTrue_thenReturnTrue() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualCheckpointSyncFromConfig = Storage.getCheckpointSyncFromConfig(config);

    // Assert
    verify(config).getBoolean("storage.checkpoint.sync");
    verify(config).hasPath("storage.checkpoint.sync");
    assertTrue(actualCheckpointSyncFromConfig);
  }

  /**
   * Test {@link Storage#getCheckpointSyncFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Storage.getCheckpointSyncFromConfig(Config)"})
  public void testGetCheckpointSyncFromConfig_whenConfigHasPathReturnFalse_thenReturnTrue() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualCheckpointSyncFromConfig = Storage.getCheckpointSyncFromConfig(config);

    // Assert
    verify(config).hasPath("storage.checkpoint.sync");
    assertTrue(actualCheckpointSyncFromConfig);
  }

  /**
   * Test {@link Storage#getCheckpointSyncFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Storage.getCheckpointSyncFromConfig(Config)"})
  public void testGetCheckpointSyncFromConfig_whenConfigHasPathThrowIllegalArgumentException() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getCheckpointSyncFromConfig(config));
    verify(config).hasPath("storage.checkpoint.sync");
  }

  /**
   * Test {@link Storage#getEstimatedTransactionsFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getEstimatedTransactionsFromConfig(Config)"})
  public void testGetEstimatedTransactionsFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Storage.getEstimatedTransactionsFromConfig(config));
    verify(config).hasPath("storage.txCache.estimatedTransactions");
  }

  /**
   * Test {@link Storage#getEstimatedTransactionsFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getEstimatedTransactionsFromConfig(Config)"})
  public void testGetEstimatedTransactionsFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Storage.getEstimatedTransactionsFromConfig(config));
    verify(config).getInt("storage.txCache.estimatedTransactions");
    verify(config).hasPath("storage.txCache.estimatedTransactions");
  }

  /**
   * Test {@link Storage#getEstimatedTransactionsFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code 10000}.
   *   <li>When {@link Config} {@link Config#getInt(String)} return {@code 10000}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getEstimatedTransactionsFromConfig(Config)"})
  public void testGetEstimatedTransactionsFromConfig_given10000_whenConfigGetIntReturn10000() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenReturn(10000);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    int actualEstimatedTransactionsFromConfig = Storage.getEstimatedTransactionsFromConfig(config);

    // Assert
    verify(config).getInt("storage.txCache.estimatedTransactions");
    verify(config).hasPath("storage.txCache.estimatedTransactions");
    assertEquals(10000, actualEstimatedTransactionsFromConfig);
  }

  /**
   * Test {@link Storage#getEstimatedTransactionsFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code 10001}.
   *   <li>When {@link Config} {@link Config#getInt(String)} return {@code 10001}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getEstimatedTransactionsFromConfig(Config)"})
  public void testGetEstimatedTransactionsFromConfig_given10001_whenConfigGetIntReturn10001() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenReturn(10001);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    int actualEstimatedTransactionsFromConfig = Storage.getEstimatedTransactionsFromConfig(config);

    // Assert
    verify(config).getInt("storage.txCache.estimatedTransactions");
    verify(config).hasPath("storage.txCache.estimatedTransactions");
    assertEquals(10000, actualEstimatedTransactionsFromConfig);
  }

  /**
   * Test {@link Storage#getEstimatedTransactionsFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return one thousand.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getEstimatedTransactionsFromConfig(Config)"})
  public void testGetEstimatedTransactionsFromConfig_givenFalse_thenReturnOneThousand() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    int actualEstimatedTransactionsFromConfig = Storage.getEstimatedTransactionsFromConfig(config);

    // Assert
    verify(config).hasPath("storage.txCache.estimatedTransactions");
    assertEquals(1000, actualEstimatedTransactionsFromConfig);
  }

  /**
   * Test {@link Storage#getEstimatedTransactionsFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given ninety-nine.
   *   <li>Then return one hundred.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int Storage.getEstimatedTransactionsFromConfig(Config)"})
  public void testGetEstimatedTransactionsFromConfig_givenNinetyNine_thenReturnOneHundred() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenReturn(99);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    int actualEstimatedTransactionsFromConfig = Storage.getEstimatedTransactionsFromConfig(config);

    // Assert
    verify(config).getInt("storage.txCache.estimatedTransactions");
    verify(config).hasPath("storage.txCache.estimatedTransactions");
    assertEquals(100, actualEstimatedTransactionsFromConfig);
  }

  /**
   * Test {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Storage.getTxCacheInitOptimizationFromConfig(Config)"})
  public void testGetTxCacheInitOptimizationFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Storage.getTxCacheInitOptimizationFromConfig(config));
    verify(config).hasPath("storage.txCache.initOptimization");
  }

  /**
   * Test {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Storage.getTxCacheInitOptimizationFromConfig(Config)"})
  public void testGetTxCacheInitOptimizationFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Storage.getTxCacheInitOptimizationFromConfig(config));
    verify(config).getBoolean("storage.txCache.initOptimization");
    verify(config).hasPath("storage.txCache.initOptimization");
  }

  /**
   * Test {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Storage.getTxCacheInitOptimizationFromConfig(Config)"})
  public void testGetTxCacheInitOptimizationFromConfig_thenReturnTrue() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualTxCacheInitOptimizationFromConfig =
        Storage.getTxCacheInitOptimizationFromConfig(config);

    // Assert
    verify(config).getBoolean("storage.txCache.initOptimization");
    verify(config).hasPath("storage.txCache.initOptimization");
    assertTrue(actualTxCacheInitOptimizationFromConfig);
  }

  /**
   * Test {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Storage.getTxCacheInitOptimizationFromConfig(Config)"})
  public void testGetTxCacheInitOptimizationFromConfig_whenConfigGetBooleanReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(false);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualTxCacheInitOptimizationFromConfig =
        Storage.getTxCacheInitOptimizationFromConfig(config);

    // Assert
    verify(config).getBoolean("storage.txCache.initOptimization");
    verify(config).hasPath("storage.txCache.initOptimization");
    assertFalse(actualTxCacheInitOptimizationFromConfig);
  }

  /**
   * Test {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Storage.getTxCacheInitOptimizationFromConfig(Config)"})
  public void testGetTxCacheInitOptimizationFromConfig_whenConfigHasPathReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualTxCacheInitOptimizationFromConfig =
        Storage.getTxCacheInitOptimizationFromConfig(config);

    // Assert
    verify(config).hasPath("storage.txCache.initOptimization");
    assertFalse(actualTxCacheInitOptimizationFromConfig);
  }

  /**
   * Test {@link Storage#setCacheStrategies(Config)}.
   *
   * <ul>
   *   <li>Given {@link Config} {@link Config#entrySet()} return {@link HashSet#HashSet()}.
   *   <li>Then calls {@link Config#entrySet()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setCacheStrategies(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setCacheStrategies(Config)"})
  public void testSetCacheStrategies_givenConfigEntrySetReturnHashSet_thenCallsEntrySet() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.entrySet()).thenReturn(new HashSet<>());

    Config config2 = mock(Config.class);
    when(config2.resolve()).thenReturn(config);

    Config config3 = mock(Config.class);
    when(config3.getConfig(Mockito.<String>any())).thenReturn(config2);
    when(config3.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    storage.setCacheStrategies(config3);

    // Assert
    verify(config).entrySet();
    verify(config3).getConfig("storage.cache.strategies");
    verify(config3).hasPath("storage.cache.strategies");
    verify(config2).resolve();
  }

  /**
   * Test {@link Storage#setCacheStrategies(Config)}.
   *
   * <ul>
   *   <li>Given {@link Config} {@link Config#entrySet()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setCacheStrategies(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setCacheStrategies(Config)"})
  public void testSetCacheStrategies_givenConfigEntrySetThrowIllegalArgumentException() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.entrySet()).thenThrow(new IllegalArgumentException());

    Config config2 = mock(Config.class);
    when(config2.resolve()).thenReturn(config);

    Config config3 = mock(Config.class);
    when(config3.getConfig(Mockito.<String>any())).thenReturn(config2);
    when(config3.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setCacheStrategies(config3));
    verify(config).entrySet();
    verify(config3).getConfig("storage.cache.strategies");
    verify(config3).hasPath("storage.cache.strategies");
    verify(config2).resolve();
  }

  /**
   * Test {@link Storage#setCacheStrategies(Config)}.
   *
   * <ul>
   *   <li>Given {@link Config} {@link Config#resolve()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setCacheStrategies(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setCacheStrategies(Config)"})
  public void testSetCacheStrategies_givenConfigResolveThrowIllegalArgumentException() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.resolve()).thenThrow(new IllegalArgumentException());

    Config config2 = mock(Config.class);
    when(config2.getConfig(Mockito.<String>any())).thenReturn(config);
    when(config2.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setCacheStrategies(config2));
    verify(config2).getConfig("storage.cache.strategies");
    verify(config2).hasPath("storage.cache.strategies");
    verify(config).resolve();
  }

  /**
   * Test {@link Storage#setCacheStrategies(Config)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.
   *   <li>Then calls {@link Config#hasPath(String)}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setCacheStrategies(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setCacheStrategies(Config)"})
  public void testSetCacheStrategies_givenFalse_whenConfigHasPathReturnFalse_thenCallsHasPath() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    storage.setCacheStrategies(config);

    // Assert
    verify(config).hasPath("storage.cache.strategies");
  }

  /**
   * Test {@link Storage#setCacheStrategies(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getConfig(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setCacheStrategies(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setCacheStrategies(Config)"})
  public void testSetCacheStrategies_whenConfigGetConfigThrowIllegalArgumentException() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.getConfig(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setCacheStrategies(config));
    verify(config).getConfig("storage.cache.strategies");
    verify(config).hasPath("storage.cache.strategies");
  }

  /**
   * Test {@link Storage#setCacheStrategies(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setCacheStrategies(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setCacheStrategies(Config)"})
  public void testSetCacheStrategies_whenConfigHasPathThrowIllegalArgumentException() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setCacheStrategies(config));
    verify(config).hasPath("storage.cache.strategies");
  }

  /**
   * Test {@link Storage#getCacheStrategy(CacheType)}.
   *
   * <p>Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy() {
    // Arrange, Act and Assert
    assertEquals(
        "initialCapacity=1000,maximumSize=1000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        new Storage().getCacheStrategy(CacheType.witnessStandby));
  }

  /**
   * Test {@link Storage#getCacheStrategy(CacheType)}.
   *
   * <p>Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy2() {
    // Arrange, Act and Assert
    assertEquals(
        "initialCapacity=100,maximumSize=100,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        new Storage().getCacheStrategy(CacheType.recentBlock));
  }

  /**
   * Test {@link Storage#getCacheStrategy(CacheType)}.
   *
   * <p>Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy3() {
    // Arrange, Act and Assert
    assertEquals(
        "initialCapacity=500,maximumSize=500,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        new Storage().getCacheStrategy(CacheType.code));
  }

  /**
   * Test {@link Storage#getCacheStrategy(CacheType)}.
   *
   * <p>Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy4() {
    // Arrange, Act and Assert
    assertEquals(
        "initialCapacity=10000,maximumSize=10000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        new Storage().getCacheStrategy(CacheType.delegation));
  }

  /**
   * Test {@link Storage#getCacheStrategy(CacheType)}.
   *
   * <p>Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Storage.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy5() {
    // Arrange, Act and Assert
    assertEquals(
        "initialCapacity=20000,maximumSize=20000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        storage.getCacheStrategy(CacheType.storageRow));
  }

  /**
   * Test {@link Storage#getDbRoot(String, Sha256Hash)}.
   *
   * <p>Method under test: {@link Storage#getDbRoot(String, Sha256Hash)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sha256Hash Storage.getDbRoot(String, Sha256Hash)"})
  public void testGetDbRoot() {
    // Arrange, Act and Assert
    assertSame(Sha256Hash.ZERO_HASH, new Storage().getDbRoot("Db Name", Sha256Hash.ZERO_HASH));
  }

  /**
   * Test {@link Storage#setDbRoots(Config)}.
   *
   * <ul>
   *   <li>Given {@link Config} {@link Config#entrySet()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setDbRoots(Config)"})
  public void testSetDbRoots_givenConfigEntrySetThrowIllegalArgumentException() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.entrySet()).thenThrow(new IllegalArgumentException());

    Config config2 = mock(Config.class);
    when(config2.resolve()).thenReturn(config);

    Config config3 = mock(Config.class);
    when(config3.getConfig(Mockito.<String>any())).thenReturn(config2);
    when(config3.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setDbRoots(config3));
    verify(config).entrySet();
    verify(config3).getConfig("storage.merkleRoot");
    verify(config3).hasPath("storage.merkleRoot");
    verify(config2).resolve();
  }

  /**
   * Test {@link Storage#setDbRoots(Config)}.
   *
   * <ul>
   *   <li>Given {@link Config} {@link Config#resolve()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link Config#resolve()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setDbRoots(Config)"})
  public void testSetDbRoots_givenConfigResolveThrowIllegalArgumentException_thenCallsResolve() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.resolve()).thenThrow(new IllegalArgumentException());

    Config config2 = mock(Config.class);
    when(config2.getConfig(Mockito.<String>any())).thenReturn(config);
    when(config2.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setDbRoots(config2));
    verify(config2).getConfig("storage.merkleRoot");
    verify(config2).hasPath("storage.merkleRoot");
    verify(config).resolve();
  }

  /**
   * Test {@link Storage#setDbRoots(Config)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.
   *   <li>Then calls {@link Config#hasPath(String)}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setDbRoots(Config)"})
  public void testSetDbRoots_givenFalse_whenConfigHasPathReturnFalse_thenCallsHasPath() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    storage.setDbRoots(config);

    // Assert
    verify(config).hasPath("storage.merkleRoot");
  }

  /**
   * Test {@link Storage#setDbRoots(Config)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Config} {@link Config#getConfig(String)} return {@link Config}.
   *   <li>Then calls {@link Config#entrySet()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setDbRoots(Config)"})
  public void testSetDbRoots_givenTrue_whenConfigGetConfigReturnConfig_thenCallsEntrySet() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.entrySet()).thenReturn(new HashSet<>());

    Config config2 = mock(Config.class);
    when(config2.resolve()).thenReturn(config);

    Config config3 = mock(Config.class);
    when(config3.getConfig(Mockito.<String>any())).thenReturn(config2);
    when(config3.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    storage.setDbRoots(config3);

    // Assert
    verify(config).entrySet();
    verify(config3).getConfig("storage.merkleRoot");
    verify(config3).hasPath("storage.merkleRoot");
    verify(config2).resolve();
  }

  /**
   * Test {@link Storage#setDbRoots(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#getConfig(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setDbRoots(Config)"})
  public void testSetDbRoots_whenConfigGetConfigThrowIllegalArgumentException() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.getConfig(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setDbRoots(config));
    verify(config).getConfig("storage.merkleRoot");
    verify(config).hasPath("storage.merkleRoot");
  }

  /**
   * Test {@link Storage#setDbRoots(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setDbRoots(Config)"})
  public void testSetDbRoots_whenConfigHasPathThrowIllegalArgumentException() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setDbRoots(config));
    verify(config).hasPath("storage.merkleRoot");
  }

  /**
   * Test {@link Storage#setPropertyMapFromConfig(Config)}.
   *
   * <p>Method under test: {@link Storage#setPropertyMapFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setPropertyMapFromConfig(Config)"})
  public void testSetPropertyMapFromConfig() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    Mockito.<List<? extends ConfigObject>>when(config.getObjectList(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setPropertyMapFromConfig(config));
    verify(config).getObjectList("storage.properties");
    verify(config).hasPath("storage.properties");
  }

  /**
   * Test {@link Storage#setPropertyMapFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then {@link Storage} (default constructor) PropertyMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setPropertyMapFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setPropertyMapFromConfig(Config)"})
  public void testSetPropertyMapFromConfig_givenArrayList_thenStoragePropertyMapEmpty() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    Mockito.<List<? extends ConfigObject>>when(config.getObjectList(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    storage.setPropertyMapFromConfig(config);

    // Assert
    verify(config).getObjectList("storage.properties");
    verify(config).hasPath("storage.properties");
    assertTrue(storage.getPropertyMap().isEmpty());
  }

  /**
   * Test {@link Storage#setPropertyMapFromConfig(Config)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setPropertyMapFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setPropertyMapFromConfig(Config)"})
  public void testSetPropertyMapFromConfig_givenFalse_whenConfigHasPathReturnFalse() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    storage.setPropertyMapFromConfig(config);

    // Assert that nothing has changed
    verify(config).hasPath("storage.properties");
  }

  /**
   * Test {@link Storage#setPropertyMapFromConfig(Config)}.
   *
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setPropertyMapFromConfig(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setPropertyMapFromConfig(Config)"})
  public void testSetPropertyMapFromConfig_whenConfigHasPathThrowIllegalArgumentException() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setPropertyMapFromConfig(config));
    verify(config).hasPath("storage.properties");
  }

  /**
   * Test {@link Storage#deleteAllStoragePaths()}.
   *
   * <ul>
   *   <li>Then calls {@link Config#getObjectList(String)}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#deleteAllStoragePaths()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.deleteAllStoragePaths()"})
  public void testDeleteAllStoragePaths_thenCallsGetObjectList() {
    // Arrange
    Config config = mock(Config.class);
    Mockito.<List<? extends ConfigObject>>when(config.getObjectList(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    Storage storage = new Storage();
    storage.setPropertyMapFromConfig(config);

    // Act
    storage.deleteAllStoragePaths();

    // Assert
    verify(config).getObjectList("storage.properties");
    verify(config).hasPath("storage.properties");
  }

  /**
   * Test {@link Storage#setDefaultDbOptions(Config)}.
   *
   * <ul>
   *   <li>Given {@link Config}.
   *   <li>When {@link Config} {@link Config#getConfig(String)} return {@link Config}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setDefaultDbOptions(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setDefaultDbOptions(Config)"})
  public void testSetDefaultDbOptions_givenConfig_whenConfigGetConfigReturnConfig() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.getConfig(Mockito.<String>any())).thenReturn(mock(Config.class));

    // Act
    storage.setDefaultDbOptions(config);

    // Assert
    verify(config).getConfig("storage");
  }

  /**
   * Test {@link Storage#setDefaultDbOptions(Config)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#setDefaultDbOptions(Config)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.setDefaultDbOptions(Config)"})
  public void testSetDefaultDbOptions_thenThrowIllegalArgumentException() {
    // Arrange
    Storage storage = new Storage();

    Config config = mock(Config.class);
    when(config.getConfig(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setDefaultDbOptions(config));
    verify(config).getConfig("storage");
  }

  /**
   * Test {@link Storage#newDefaultDbOptions(String)}.
   *
   * <ul>
   *   <li>Given {@link Config} {@link Config#hasPath(String)} return {@code false}.
   *   <li>Then return comparator is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#newDefaultDbOptions(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Options Storage.newDefaultDbOptions(String)"})
  public void testNewDefaultDbOptions_givenConfigHasPathReturnFalse_thenReturnComparatorIsNull() {
    // Arrange
    when(options.blockSize()).thenReturn(3);
    when(options.maxOpenFiles()).thenReturn(3);
    when(options.writeBufferSize()).thenReturn(3);
    when(options.cacheSize()).thenReturn(3L);
    when(options.createIfMissing()).thenReturn(true);
    when(options.paranoidChecks()).thenReturn(true);
    when(options.verifyChecksums()).thenReturn(true);
    when(options.compressionType()).thenReturn(CompressionType.NONE);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    Options actualNewDefaultDbOptionsResult = storage.newDefaultDbOptions("Name");

    // Assert
    verify(config, atLeast(1)).hasPath(Mockito.<String>any());
    verify(options).blockSize();
    verify(options).cacheSize();
    verify(options).compressionType();
    verify(options).createIfMissing();
    verify(options).maxOpenFiles();
    verify(options).paranoidChecks();
    verify(options).verifyChecksums();
    verify(options).writeBufferSize();
    assertNull(actualNewDefaultDbOptionsResult.comparator());
    assertNull(actualNewDefaultDbOptionsResult.logger());
    assertEquals(3, actualNewDefaultDbOptionsResult.blockSize());
    assertEquals(3, actualNewDefaultDbOptionsResult.maxOpenFiles());
    assertEquals(3, actualNewDefaultDbOptionsResult.writeBufferSize());
    assertEquals(3L, actualNewDefaultDbOptionsResult.cacheSize());
    assertEquals(CompressionType.NONE, actualNewDefaultDbOptionsResult.compressionType());
    assertFalse(actualNewDefaultDbOptionsResult.errorIfExists());
    assertTrue(actualNewDefaultDbOptionsResult.createIfMissing());
    assertTrue(actualNewDefaultDbOptionsResult.paranoidChecks());
    assertTrue(actualNewDefaultDbOptionsResult.verifyChecksums());
    assertEquals(Short.SIZE, actualNewDefaultDbOptionsResult.blockRestartInterval());
  }

  /**
   * Test {@link Storage#newDefaultDbOptions(String)}.
   *
   * <ul>
   *   <li>Given {@link Config} {@link Config#hasPath(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#newDefaultDbOptions(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Options Storage.newDefaultDbOptions(String)"})
  public void testNewDefaultDbOptions_givenConfigHasPathThrowIllegalArgumentException() {
    // Arrange
    when(options.blockSize()).thenReturn(3);
    when(options.maxOpenFiles()).thenReturn(3);
    when(options.writeBufferSize()).thenReturn(3);
    when(options.cacheSize()).thenReturn(3L);
    when(options.createIfMissing()).thenReturn(true);
    when(options.paranoidChecks()).thenReturn(true);
    when(options.verifyChecksums()).thenReturn(true);
    when(options.compressionType()).thenReturn(CompressionType.NONE);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.newDefaultDbOptions("Name"));
    verify(config).hasPath("default");
    verify(options).blockSize();
    verify(options).cacheSize();
    verify(options).compressionType();
    verify(options).createIfMissing();
    verify(options).maxOpenFiles();
    verify(options).paranoidChecks();
    verify(options).verifyChecksums();
    verify(options).writeBufferSize();
  }

  /**
   * Test {@link Storage#newDefaultDbOptions(String)}.
   *
   * <ul>
   *   <li>Given {@link Options} {@link Options#blockSize()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#newDefaultDbOptions(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Options Storage.newDefaultDbOptions(String)"})
  public void testNewDefaultDbOptions_givenOptionsBlockSizeThrowIllegalArgumentException() {
    // Arrange
    when(options.blockSize()).thenThrow(new IllegalArgumentException());
    when(options.createIfMissing()).thenReturn(true);
    when(options.paranoidChecks()).thenReturn(true);
    when(options.verifyChecksums()).thenReturn(true);
    when(options.compressionType()).thenReturn(CompressionType.NONE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.newDefaultDbOptions("Name"));
    verify(options).blockSize();
    verify(options).compressionType();
    verify(options).createIfMissing();
    verify(options).paranoidChecks();
    verify(options).verifyChecksums();
  }

  /**
   * Test {@link Storage#newDefaultDbOptions(String)}.
   *
   * <ul>
   *   <li>Given {@link Options} {@link Options#createIfMissing()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#newDefaultDbOptions(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Options Storage.newDefaultDbOptions(String)"})
  public void testNewDefaultDbOptions_givenOptionsCreateIfMissingThrowIllegalArgumentException() {
    // Arrange
    when(options.createIfMissing()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.newDefaultDbOptions("Name"));
    verify(options).createIfMissing();
  }

  /**
   * Test {@link Storage#newDefaultDbOptions(String)}.
   *
   * <ul>
   *   <li>Then calls {@link Config#getObject(String)}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#newDefaultDbOptions(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Options Storage.newDefaultDbOptions(String)"})
  public void testNewDefaultDbOptions_thenCallsGetObject() {
    // Arrange
    when(options.blockSize()).thenReturn(3);
    when(options.maxOpenFiles()).thenReturn(3);
    when(options.writeBufferSize()).thenReturn(3);
    when(options.cacheSize()).thenReturn(3L);
    when(options.createIfMissing()).thenReturn(true);
    when(options.paranoidChecks()).thenReturn(true);
    when(options.verifyChecksums()).thenReturn(true);
    when(options.compressionType()).thenReturn(CompressionType.NONE);
    when(config.getObject(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.newDefaultDbOptions("Name"));
    verify(config).getObject("default");
    verify(config).hasPath("default");
    verify(options).blockSize();
    verify(options).cacheSize();
    verify(options).compressionType();
    verify(options).createIfMissing();
    verify(options).maxOpenFiles();
    verify(options).paranoidChecks();
    verify(options).verifyChecksums();
    verify(options).writeBufferSize();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Storage#setCheckpointSync(boolean)}
   *   <li>{@link Storage#setCheckpointVersion(int)}
   *   <li>{@link Storage#setContractParseSwitch(boolean)}
   *   <li>{@link Storage#setDbDirectory(String)}
   *   <li>{@link Storage#setDbEngine(String)}
   *   <li>{@link Storage#setDbSync(boolean)}
   *   <li>{@link Storage#setEstimatedBlockTransactions(int)}
   *   <li>{@link Storage#setIndexDirectory(String)}
   *   <li>{@link Storage#setIndexSwitch(String)}
   *   <li>{@link Storage#setMaxFlushCount(int)}
   *   <li>{@link Storage#setTransactionHistorySwitch(String)}
   *   <li>{@link Storage#setTxCacheInitOptimization(boolean)}
   *   <li>{@link Storage#getCacheDbs()}
   *   <li>{@link Storage#getCheckpointVersion()}
   *   <li>{@link Storage#getDbDirectory()}
   *   <li>{@link Storage#getDbEngine()}
   *   <li>{@link Storage#getEstimatedBlockTransactions()}
   *   <li>{@link Storage#getIndexDirectory()}
   *   <li>{@link Storage#getIndexSwitch()}
   *   <li>{@link Storage#getMaxFlushCount()}
   *   <li>{@link Storage#getPropertyMap()}
   *   <li>{@link Storage#getTransactionHistorySwitch()}
   *   <li>{@link Storage#isCheckpointSync()}
   *   <li>{@link Storage#isContractParseSwitch()}
   *   <li>{@link Storage#isDbSync()}
   *   <li>{@link Storage#isTxCacheInitOptimization()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List Storage.getCacheDbs()",
    "int Storage.getCheckpointVersion()",
    "String Storage.getDbDirectory()",
    "String Storage.getDbEngine()",
    "int Storage.getEstimatedBlockTransactions()",
    "String Storage.getIndexDirectory()",
    "String Storage.getIndexSwitch()",
    "int Storage.getMaxFlushCount()",
    "Map Storage.getPropertyMap()",
    "String Storage.getTransactionHistorySwitch()",
    "boolean Storage.isCheckpointSync()",
    "boolean Storage.isContractParseSwitch()",
    "boolean Storage.isDbSync()",
    "boolean Storage.isTxCacheInitOptimization()",
    "void Storage.setCheckpointSync(boolean)",
    "void Storage.setCheckpointVersion(int)",
    "void Storage.setContractParseSwitch(boolean)",
    "void Storage.setDbDirectory(String)",
    "void Storage.setDbEngine(String)",
    "void Storage.setDbSync(boolean)",
    "void Storage.setEstimatedBlockTransactions(int)",
    "void Storage.setIndexDirectory(String)",
    "void Storage.setIndexSwitch(String)",
    "void Storage.setMaxFlushCount(int)",
    "void Storage.setTransactionHistorySwitch(String)",
    "void Storage.setTxCacheInitOptimization(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    Storage storage = new Storage();

    // Act
    storage.setCheckpointSync(true);
    storage.setCheckpointVersion(1);
    storage.setContractParseSwitch(true);
    storage.setDbDirectory("/directory");
    storage.setDbEngine("Db Engine");
    storage.setDbSync(true);
    storage.setEstimatedBlockTransactions(1);
    storage.setIndexDirectory("/directory");
    storage.setIndexSwitch("Index Switch");
    storage.setMaxFlushCount(3);
    storage.setTransactionHistorySwitch("Transaction History Switch");
    storage.setTxCacheInitOptimization(true);
    List<String> actualCacheDbs = storage.getCacheDbs();
    int actualCheckpointVersion = storage.getCheckpointVersion();
    String actualDbDirectory = storage.getDbDirectory();
    String actualDbEngine = storage.getDbEngine();
    int actualEstimatedBlockTransactions = storage.getEstimatedBlockTransactions();
    String actualIndexDirectory = storage.getIndexDirectory();
    String actualIndexSwitch = storage.getIndexSwitch();
    int actualMaxFlushCount = storage.getMaxFlushCount();
    Map<String, Property> actualPropertyMap = storage.getPropertyMap();
    String actualTransactionHistorySwitch = storage.getTransactionHistorySwitch();
    boolean actualIsCheckpointSyncResult = storage.isCheckpointSync();
    boolean actualIsContractParseSwitchResult = storage.isContractParseSwitch();
    boolean actualIsDbSyncResult = storage.isDbSync();

    // Assert
    assertEquals("/directory", actualDbDirectory);
    assertEquals("/directory", actualIndexDirectory);
    assertEquals("Db Engine", actualDbEngine);
    assertEquals(14, actualCacheDbs.size());
    assertEquals("DelegatedResource", actualCacheDbs.get(3));
    assertEquals("DelegatedResourceAccountIndex", actualCacheDbs.get(4));
    assertEquals("Index Switch", actualIndexSwitch);
    assertEquals("Transaction History Switch", actualTransactionHistorySwitch);
    assertEquals("account", actualCacheDbs.get(13));
    assertEquals("asset-issue-v2", actualCacheDbs.get(9));
    assertEquals("contract", actualCacheDbs.get(8));
    assertEquals("delegation", actualCacheDbs.get(11));
    assertEquals("properties", actualCacheDbs.get(10));
    assertEquals("recent-block", actualCacheDbs.get(0));
    assertEquals("storage-row", actualCacheDbs.get(12));
    assertEquals("votes", actualCacheDbs.get(5));
    assertEquals("witness", actualCacheDbs.get(1));
    assertEquals("witness_schedule", actualCacheDbs.get(2));
    assertNull(actualPropertyMap);
    assertEquals(1, actualCheckpointVersion);
    assertEquals(1, actualEstimatedBlockTransactions);
    assertEquals(3, actualMaxFlushCount);
    assertTrue(actualIsCheckpointSyncResult);
    assertTrue(actualIsContractParseSwitchResult);
    assertTrue(actualIsDbSyncResult);
    assertTrue(storage.isTxCacheInitOptimization());
  }

  /**
   * Test new {@link Storage} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Storage}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.<init>()"})
  public void testNewStorage() {
    // Arrange and Act
    Storage actualStorage = new Storage();

    // Assert
    assertNull(actualStorage.getDbDirectory());
    assertNull(actualStorage.getDbEngine());
    assertNull(actualStorage.getIndexDirectory());
    assertNull(actualStorage.getIndexSwitch());
    assertNull(actualStorage.getTransactionHistorySwitch());
    assertNull(actualStorage.getPropertyMap());
    assertEquals(0, actualStorage.getCheckpointVersion());
    assertEquals(0, actualStorage.getEstimatedBlockTransactions());
    assertEquals(0, actualStorage.getMaxFlushCount());
    assertEquals(14, actualStorage.getCacheDbs().size());
    assertFalse(actualStorage.isCheckpointSync());
    assertFalse(actualStorage.isContractParseSwitch());
    assertFalse(actualStorage.isDbSync());
    assertFalse(actualStorage.isTxCacheInitOptimization());
  }
}
