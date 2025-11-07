package org.tron.core.config.args;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigObject;
import com.typesafe.config.ConfigValue;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.cache.CacheType;
import org.tron.common.utils.Property;
import org.tron.common.utils.Sha256Hash;

public class StorageDiffblueTest {
  /**
   * Test {@link Storage#getDbEngineFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getDbEngineFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getDbEngineFromConfig(Config)"})
  public void testGetDbEngineFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.db.engine"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbEngineFromConfig(config));
    verify(config).getString(eq("storage.db.engine"));
    verify(config).hasPath(eq("storage.db.engine"));
  }

  /**
   * Test {@link Storage#getDbEngineFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getDbEngineFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getDbEngineFromConfig(Config)"})
  public void testGetDbEngineFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.db.engine"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbEngineFromConfig(config));
    verify(config).hasPath(eq("storage.db.engine"));
  }

  /**
   * Test {@link Storage#getDbEngineFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code LEVELDB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getDbEngineFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getDbEngineFromConfig(Config)"})
  public void testGetDbEngineFromConfig_givenFalse_thenReturnLeveldb() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    String actualDbEngineFromConfig = Storage.getDbEngineFromConfig(config);

    // Assert
    verify(config).hasPath(eq("storage.db.engine"));
    assertEquals("LEVELDB", actualDbEngineFromConfig);
  }

  /**
   * Test {@link Storage#getDbEngineFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code String}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getDbEngineFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getDbEngineFromConfig(Config)"})
  public void testGetDbEngineFromConfig_givenString_thenReturnString() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualDbEngineFromConfig = Storage.getDbEngineFromConfig(config);

    // Assert
    verify(config).getString(eq("storage.db.engine"));
    verify(config).hasPath(eq("storage.db.engine"));
    assertEquals("String", actualDbEngineFromConfig);
  }

  /**
   * Test {@link Storage#getDbVersionSyncFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean Storage.getDbVersionSyncFromConfig(Config)"})
  public void testGetDbVersionSyncFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.db.sync"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbVersionSyncFromConfig(config));
    verify(config).getBoolean(eq("storage.db.sync"));
    verify(config).hasPath(eq("storage.db.sync"));
  }

  /**
   * Test {@link Storage#getDbVersionSyncFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean Storage.getDbVersionSyncFromConfig(Config)"})
  public void testGetDbVersionSyncFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.db.sync"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbVersionSyncFromConfig(config));
    verify(config).hasPath(eq("storage.db.sync"));
  }

  /**
   * Test {@link Storage#getDbVersionSyncFromConfig(Config)}.
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean Storage.getDbVersionSyncFromConfig(Config)"})
  public void testGetDbVersionSyncFromConfig_whenConfigGetBooleanReturnFalse_thenReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(false);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    Boolean actualDbVersionSyncFromConfig = Storage.getDbVersionSyncFromConfig(config);

    // Assert
    verify(config).getBoolean(eq("storage.db.sync"));
    verify(config).hasPath(eq("storage.db.sync"));
    assertFalse(actualDbVersionSyncFromConfig);
  }

  /**
   * Test {@link Storage#getDbVersionSyncFromConfig(Config)}.
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean Storage.getDbVersionSyncFromConfig(Config)"})
  public void testGetDbVersionSyncFromConfig_whenConfigGetBooleanReturnTrue_thenReturnTrue() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    Boolean actualDbVersionSyncFromConfig = Storage.getDbVersionSyncFromConfig(config);

    // Assert
    verify(config).getBoolean(eq("storage.db.sync"));
    verify(config).hasPath(eq("storage.db.sync"));
    assertTrue(actualDbVersionSyncFromConfig);
  }

  /**
   * Test {@link Storage#getDbVersionSyncFromConfig(Config)}.
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean Storage.getDbVersionSyncFromConfig(Config)"})
  public void testGetDbVersionSyncFromConfig_whenConfigHasPathReturnFalse_thenReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    Boolean actualDbVersionSyncFromConfig = Storage.getDbVersionSyncFromConfig(config);

    // Assert
    verify(config).hasPath(eq("storage.db.sync"));
    assertFalse(actualDbVersionSyncFromConfig);
  }

  /**
   * Test {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getSnapshotMaxFlushCountFromConfig(Config)"})
  public void testGetSnapshotMaxFlushCountFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("storage.snapshot.maxFlushCount"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getSnapshotMaxFlushCountFromConfig(config));
    verify(config).getInt(eq("storage.snapshot.maxFlushCount"));
    verify(config).hasPath(eq("storage.snapshot.maxFlushCount"));
  }

  /**
   * Test {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getSnapshotMaxFlushCountFromConfig(Config)"})
  public void testGetSnapshotMaxFlushCountFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("storage.snapshot.maxFlushCount"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getSnapshotMaxFlushCountFromConfig(config));
    verify(config).hasPath(eq("storage.snapshot.maxFlushCount"));
  }

  /**
   * Test {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getSnapshotMaxFlushCountFromConfig(Config)"})
  public void testGetSnapshotMaxFlushCountFromConfig_givenFalse_whenConfigHasPathReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    int actualSnapshotMaxFlushCountFromConfig = Storage.getSnapshotMaxFlushCountFromConfig(config);

    // Assert
    verify(config).hasPath(eq("storage.snapshot.maxFlushCount"));
    assertEquals(1, actualSnapshotMaxFlushCountFromConfig);
  }

  /**
   * Test {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link Config} {@link Config#getInt(String)} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getSnapshotMaxFlushCountFromConfig(Config)"})
  public void testGetSnapshotMaxFlushCountFromConfig_givenOne_whenConfigGetIntReturnOne() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    int actualSnapshotMaxFlushCountFromConfig = Storage.getSnapshotMaxFlushCountFromConfig(config);

    // Assert
    verify(config).getInt(eq("storage.snapshot.maxFlushCount"));
    verify(config).hasPath(eq("storage.snapshot.maxFlushCount"));
    assertEquals(1, actualSnapshotMaxFlushCountFromConfig);
  }

  /**
   * Test {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link Config} {@link Config#getInt(String)} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getSnapshotMaxFlushCountFromConfig(Config)"})
  public void testGetSnapshotMaxFlushCountFromConfig_givenZero_whenConfigGetIntReturnZero() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenReturn(0);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getSnapshotMaxFlushCountFromConfig(config));
    verify(config).getInt(eq("storage.snapshot.maxFlushCount"));
    verify(config).hasPath(eq("storage.snapshot.maxFlushCount"));
  }

  /**
   * Test {@link Storage#getContractParseSwitchFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean Storage.getContractParseSwitchFromConfig(Config)"})
  public void testGetContractParseSwitchFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("event.subscribe.contractParse"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getContractParseSwitchFromConfig(config));
    verify(config).getBoolean(eq("event.subscribe.contractParse"));
    verify(config).hasPath(eq("event.subscribe.contractParse"));
  }

  /**
   * Test {@link Storage#getContractParseSwitchFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean Storage.getContractParseSwitchFromConfig(Config)"})
  public void testGetContractParseSwitchFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("event.subscribe.contractParse"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getContractParseSwitchFromConfig(config));
    verify(config).hasPath(eq("event.subscribe.contractParse"));
  }

  /**
   * Test {@link Storage#getContractParseSwitchFromConfig(Config)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean Storage.getContractParseSwitchFromConfig(Config)"})
  public void testGetContractParseSwitchFromConfig_thenReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(false);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    Boolean actualContractParseSwitchFromConfig = Storage.getContractParseSwitchFromConfig(config);

    // Assert
    verify(config).getBoolean(eq("event.subscribe.contractParse"));
    verify(config).hasPath(eq("event.subscribe.contractParse"));
    assertFalse(actualContractParseSwitchFromConfig);
  }

  /**
   * Test {@link Storage#getContractParseSwitchFromConfig(Config)}.
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean Storage.getContractParseSwitchFromConfig(Config)"})
  public void testGetContractParseSwitchFromConfig_whenConfigGetBooleanReturnTrue() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    Boolean actualContractParseSwitchFromConfig = Storage.getContractParseSwitchFromConfig(config);

    // Assert
    verify(config).getBoolean(eq("event.subscribe.contractParse"));
    verify(config).hasPath(eq("event.subscribe.contractParse"));
    assertTrue(actualContractParseSwitchFromConfig);
  }

  /**
   * Test {@link Storage#getContractParseSwitchFromConfig(Config)}.
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean Storage.getContractParseSwitchFromConfig(Config)"})
  public void testGetContractParseSwitchFromConfig_whenConfigHasPathReturnFalse_thenReturnTrue() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    Boolean actualContractParseSwitchFromConfig = Storage.getContractParseSwitchFromConfig(config);

    // Assert
    verify(config).hasPath(eq("event.subscribe.contractParse"));
    assertTrue(actualContractParseSwitchFromConfig);
  }

  /**
   * Test {@link Storage#getDbDirectoryFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getDbDirectoryFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getDbDirectoryFromConfig(Config)"})
  public void testGetDbDirectoryFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.db.directory"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbDirectoryFromConfig(config));
    verify(config).getString(eq("storage.db.directory"));
    verify(config).hasPath(eq("storage.db.directory"));
  }

  /**
   * Test {@link Storage#getDbDirectoryFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getDbDirectoryFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getDbDirectoryFromConfig(Config)"})
  public void testGetDbDirectoryFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.db.directory"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbDirectoryFromConfig(config));
    verify(config).hasPath(eq("storage.db.directory"));
  }

  /**
   * Test {@link Storage#getDbDirectoryFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code database}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getDbDirectoryFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getDbDirectoryFromConfig(Config)"})
  public void testGetDbDirectoryFromConfig_givenFalse_thenReturnDatabase() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    String actualDbDirectoryFromConfig = Storage.getDbDirectoryFromConfig(config);

    // Assert
    verify(config).hasPath(eq("storage.db.directory"));
    assertEquals("database", actualDbDirectoryFromConfig);
  }

  /**
   * Test {@link Storage#getDbDirectoryFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code String}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getDbDirectoryFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getDbDirectoryFromConfig(Config)"})
  public void testGetDbDirectoryFromConfig_givenString_thenReturnString() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualDbDirectoryFromConfig = Storage.getDbDirectoryFromConfig(config);

    // Assert
    verify(config).getString(eq("storage.db.directory"));
    verify(config).hasPath(eq("storage.db.directory"));
    assertEquals("String", actualDbDirectoryFromConfig);
  }

  /**
   * Test {@link Storage#getIndexDirectoryFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getIndexDirectoryFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getIndexDirectoryFromConfig(Config)"})
  public void testGetIndexDirectoryFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.index.directory"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getIndexDirectoryFromConfig(config));
    verify(config).getString(eq("storage.index.directory"));
    verify(config).hasPath(eq("storage.index.directory"));
  }

  /**
   * Test {@link Storage#getIndexDirectoryFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getIndexDirectoryFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getIndexDirectoryFromConfig(Config)"})
  public void testGetIndexDirectoryFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.index.directory"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getIndexDirectoryFromConfig(config));
    verify(config).hasPath(eq("storage.index.directory"));
  }

  /**
   * Test {@link Storage#getIndexDirectoryFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code index}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getIndexDirectoryFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getIndexDirectoryFromConfig(Config)"})
  public void testGetIndexDirectoryFromConfig_givenFalse_thenReturnIndex() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    String actualIndexDirectoryFromConfig = Storage.getIndexDirectoryFromConfig(config);

    // Assert
    verify(config).hasPath(eq("storage.index.directory"));
    assertEquals("index", actualIndexDirectoryFromConfig);
  }

  /**
   * Test {@link Storage#getIndexDirectoryFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code String}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getIndexDirectoryFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getIndexDirectoryFromConfig(Config)"})
  public void testGetIndexDirectoryFromConfig_givenString_thenReturnString() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualIndexDirectoryFromConfig = Storage.getIndexDirectoryFromConfig(config);

    // Assert
    verify(config).getString(eq("storage.index.directory"));
    verify(config).hasPath(eq("storage.index.directory"));
    assertEquals("String", actualIndexDirectoryFromConfig);
  }

  /**
   * Test {@link Storage#getIndexSwitchFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getIndexSwitchFromConfig(Config)"})
  public void testGetIndexSwitchFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.index.switch"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getIndexSwitchFromConfig(config));
    verify(config).getString(eq("storage.index.switch"));
    verify(config).hasPath(eq("storage.index.switch"));
  }

  /**
   * Test {@link Storage#getIndexSwitchFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getIndexSwitchFromConfig(Config)"})
  public void testGetIndexSwitchFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.index.switch"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getIndexSwitchFromConfig(config));
    verify(config).hasPath(eq("storage.index.switch"));
  }

  /**
   * Test {@link Storage#getIndexSwitchFromConfig(Config)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getIndexSwitchFromConfig(Config)"})
  public void testGetIndexSwitchFromConfig_givenEmptyString() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualIndexSwitchFromConfig = Storage.getIndexSwitchFromConfig(config);

    // Assert
    verify(config).getString(eq("storage.index.switch"));
    verify(config).hasPath(eq("storage.index.switch"));
    assertEquals("on", actualIndexSwitchFromConfig);
  }

  /**
   * Test {@link Storage#getIndexSwitchFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getIndexSwitchFromConfig(Config)"})
  public void testGetIndexSwitchFromConfig_givenFalse_whenConfigHasPathReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    String actualIndexSwitchFromConfig = Storage.getIndexSwitchFromConfig(config);

    // Assert
    verify(config).hasPath(eq("storage.index.switch"));
    assertEquals("on", actualIndexSwitchFromConfig);
  }

  /**
   * Test {@link Storage#getIndexSwitchFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code String}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getIndexSwitchFromConfig(Config)"})
  public void testGetIndexSwitchFromConfig_givenString_thenReturnString() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualIndexSwitchFromConfig = Storage.getIndexSwitchFromConfig(config);

    // Assert
    verify(config, atLeast(1)).getString(eq("storage.index.switch"));
    verify(config).hasPath(eq("storage.index.switch"));
    assertEquals("String", actualIndexSwitchFromConfig);
  }

  /**
   * Test {@link Storage#getTransactionHistorySwitchFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getTransactionHistorySwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getTransactionHistorySwitchFromConfig(Config)"})
  public void testGetTransactionHistorySwitchFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("storage.transHistory.switch"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getTransactionHistorySwitchFromConfig(config));
    verify(config).getString(eq("storage.transHistory.switch"));
    verify(config).hasPath(eq("storage.transHistory.switch"));
  }

  /**
   * Test {@link Storage#getTransactionHistorySwitchFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getTransactionHistorySwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getTransactionHistorySwitchFromConfig(Config)"})
  public void testGetTransactionHistorySwitchFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.transHistory.switch"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getTransactionHistorySwitchFromConfig(config));
    verify(config).hasPath(eq("storage.transHistory.switch"));
  }

  /**
   * Test {@link Storage#getTransactionHistorySwitchFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code on}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getTransactionHistorySwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getTransactionHistorySwitchFromConfig(Config)"})
  public void testGetTransactionHistorySwitchFromConfig_givenFalse_thenReturnOn() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    String actualTransactionHistorySwitchFromConfig = Storage.getTransactionHistorySwitchFromConfig(config);

    // Assert
    verify(config).hasPath(eq("storage.transHistory.switch"));
    assertEquals("on", actualTransactionHistorySwitchFromConfig);
  }

  /**
   * Test {@link Storage#getTransactionHistorySwitchFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code String}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getTransactionHistorySwitchFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getTransactionHistorySwitchFromConfig(Config)"})
  public void testGetTransactionHistorySwitchFromConfig_givenString_thenReturnString() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getString(Mockito.<String>any())).thenReturn("String");
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualTransactionHistorySwitchFromConfig = Storage.getTransactionHistorySwitchFromConfig(config);

    // Assert
    verify(config).getString(eq("storage.transHistory.switch"));
    verify(config).hasPath(eq("storage.transHistory.switch"));
    assertEquals("String", actualTransactionHistorySwitchFromConfig);
  }

  /**
   * Test {@link Storage#getCheckpointVersionFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getCheckpointVersionFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getCheckpointVersionFromConfig(Config)"})
  public void testGetCheckpointVersionFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.checkpoint.version"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getCheckpointVersionFromConfig(config));
    verify(config).getInt(eq("storage.checkpoint.version"));
    verify(config).hasPath(eq("storage.checkpoint.version"));
  }

  /**
   * Test {@link Storage#getCheckpointVersionFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getCheckpointVersionFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getCheckpointVersionFromConfig(Config)"})
  public void testGetCheckpointVersionFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.checkpoint.version"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getCheckpointVersionFromConfig(config));
    verify(config).hasPath(eq("storage.checkpoint.version"));
  }

  /**
   * Test {@link Storage#getCheckpointVersionFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getCheckpointVersionFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getCheckpointVersionFromConfig(Config)"})
  public void testGetCheckpointVersionFromConfig_givenFalse_whenConfigHasPathReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    int actualCheckpointVersionFromConfig = Storage.getCheckpointVersionFromConfig(config);

    // Assert
    verify(config).hasPath(eq("storage.checkpoint.version"));
    assertEquals(1, actualCheckpointVersionFromConfig);
  }

  /**
   * Test {@link Storage#getCheckpointVersionFromConfig(Config)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link Config} {@link Config#getInt(String)} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getCheckpointVersionFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getCheckpointVersionFromConfig(Config)"})
  public void testGetCheckpointVersionFromConfig_givenOne_whenConfigGetIntReturnOne() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    int actualCheckpointVersionFromConfig = Storage.getCheckpointVersionFromConfig(config);

    // Assert
    verify(config).getInt(eq("storage.checkpoint.version"));
    verify(config).hasPath(eq("storage.checkpoint.version"));
    assertEquals(1, actualCheckpointVersionFromConfig);
  }

  /**
   * Test {@link Storage#getCheckpointSyncFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Storage.getCheckpointSyncFromConfig(Config)"})
  public void testGetCheckpointSyncFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.checkpoint.sync"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getCheckpointSyncFromConfig(config));
    verify(config).getBoolean(eq("storage.checkpoint.sync"));
    verify(config).hasPath(eq("storage.checkpoint.sync"));
  }

  /**
   * Test {@link Storage#getCheckpointSyncFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Storage.getCheckpointSyncFromConfig(Config)"})
  public void testGetCheckpointSyncFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.checkpoint.sync"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getCheckpointSyncFromConfig(config));
    verify(config).hasPath(eq("storage.checkpoint.sync"));
  }

  /**
   * Test {@link Storage#getCheckpointSyncFromConfig(Config)}.
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Storage.getCheckpointSyncFromConfig(Config)"})
  public void testGetCheckpointSyncFromConfig_whenConfigGetBooleanReturnFalse_thenReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(false);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualCheckpointSyncFromConfig = Storage.getCheckpointSyncFromConfig(config);

    // Assert
    verify(config).getBoolean(eq("storage.checkpoint.sync"));
    verify(config).hasPath(eq("storage.checkpoint.sync"));
    assertFalse(actualCheckpointSyncFromConfig);
  }

  /**
   * Test {@link Storage#getCheckpointSyncFromConfig(Config)}.
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Storage.getCheckpointSyncFromConfig(Config)"})
  public void testGetCheckpointSyncFromConfig_whenConfigGetBooleanReturnTrue_thenReturnTrue() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualCheckpointSyncFromConfig = Storage.getCheckpointSyncFromConfig(config);

    // Assert
    verify(config).getBoolean(eq("storage.checkpoint.sync"));
    verify(config).hasPath(eq("storage.checkpoint.sync"));
    assertTrue(actualCheckpointSyncFromConfig);
  }

  /**
   * Test {@link Storage#getCheckpointSyncFromConfig(Config)}.
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Storage.getCheckpointSyncFromConfig(Config)"})
  public void testGetCheckpointSyncFromConfig_whenConfigHasPathReturnFalse_thenReturnTrue() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualCheckpointSyncFromConfig = Storage.getCheckpointSyncFromConfig(config);

    // Assert
    verify(config).hasPath(eq("storage.checkpoint.sync"));
    assertTrue(actualCheckpointSyncFromConfig);
  }

  /**
   * Test {@link Storage#getEstimatedTransactionsFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getEstimatedTransactionsFromConfig(Config)"})
  public void testGetEstimatedTransactionsFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("storage.txCache.estimatedTransactions"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getEstimatedTransactionsFromConfig(config));
    verify(config).getInt(eq("storage.txCache.estimatedTransactions"));
    verify(config).hasPath(eq("storage.txCache.estimatedTransactions"));
  }

  /**
   * Test {@link Storage#getEstimatedTransactionsFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getEstimatedTransactionsFromConfig(Config)"})
  public void testGetEstimatedTransactionsFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("storage.txCache.estimatedTransactions"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getEstimatedTransactionsFromConfig(config));
    verify(config).hasPath(eq("storage.txCache.estimatedTransactions"));
  }

  /**
   * Test {@link Storage#getEstimatedTransactionsFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code 10000}.</li>
   *   <li>Then return {@code 10000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getEstimatedTransactionsFromConfig(Config)"})
  public void testGetEstimatedTransactionsFromConfig_given10000_thenReturn10000() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenReturn(10000);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    int actualEstimatedTransactionsFromConfig = Storage.getEstimatedTransactionsFromConfig(config);

    // Assert
    verify(config).getInt(eq("storage.txCache.estimatedTransactions"));
    verify(config).hasPath(eq("storage.txCache.estimatedTransactions"));
    assertEquals(10000, actualEstimatedTransactionsFromConfig);
  }

  /**
   * Test {@link Storage#getEstimatedTransactionsFromConfig(Config)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return one thousand.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getEstimatedTransactionsFromConfig(Config)"})
  public void testGetEstimatedTransactionsFromConfig_givenFalse_thenReturnOneThousand() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    int actualEstimatedTransactionsFromConfig = Storage.getEstimatedTransactionsFromConfig(config);

    // Assert
    verify(config).hasPath(eq("storage.txCache.estimatedTransactions"));
    assertEquals(1000, actualEstimatedTransactionsFromConfig);
  }

  /**
   * Test {@link Storage#getEstimatedTransactionsFromConfig(Config)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Storage.getEstimatedTransactionsFromConfig(Config)"})
  public void testGetEstimatedTransactionsFromConfig_givenOne_thenReturnOneHundred() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getInt(Mockito.<String>any())).thenReturn(1);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    int actualEstimatedTransactionsFromConfig = Storage.getEstimatedTransactionsFromConfig(config);

    // Assert
    verify(config).getInt(eq("storage.txCache.estimatedTransactions"));
    verify(config).hasPath(eq("storage.txCache.estimatedTransactions"));
    assertEquals(100, actualEstimatedTransactionsFromConfig);
  }

  /**
   * Test {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Storage.getTxCacheInitOptimizationFromConfig(Config)"})
  public void testGetTxCacheInitOptimizationFromConfig() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException(Storage.TX_CACHE_INIT_OPTIMIZATION));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getTxCacheInitOptimizationFromConfig(config));
    verify(config).getBoolean(eq("storage.txCache.initOptimization"));
    verify(config).hasPath(eq("storage.txCache.initOptimization"));
  }

  /**
   * Test {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}.
   * <p>
   * Method under test: {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Storage.getTxCacheInitOptimizationFromConfig(Config)"})
  public void testGetTxCacheInitOptimizationFromConfig2() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException(Storage.TX_CACHE_INIT_OPTIMIZATION));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getTxCacheInitOptimizationFromConfig(config));
    verify(config).hasPath(eq("storage.txCache.initOptimization"));
  }

  /**
   * Test {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Storage.getTxCacheInitOptimizationFromConfig(Config)"})
  public void testGetTxCacheInitOptimizationFromConfig_thenReturnTrue() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(true);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualTxCacheInitOptimizationFromConfig = Storage.getTxCacheInitOptimizationFromConfig(config);

    // Assert
    verify(config).getBoolean(eq("storage.txCache.initOptimization"));
    verify(config).hasPath(eq("storage.txCache.initOptimization"));
    assertTrue(actualTxCacheInitOptimizationFromConfig);
  }

  /**
   * Test {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}.
   * <ul>
   *   <li>When {@link Config} {@link Config#getBoolean(String)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Storage.getTxCacheInitOptimizationFromConfig(Config)"})
  public void testGetTxCacheInitOptimizationFromConfig_whenConfigGetBooleanReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.getBoolean(Mockito.<String>any())).thenReturn(false);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualTxCacheInitOptimizationFromConfig = Storage.getTxCacheInitOptimizationFromConfig(config);

    // Assert
    verify(config).getBoolean(eq("storage.txCache.initOptimization"));
    verify(config).hasPath(eq("storage.txCache.initOptimization"));
    assertFalse(actualTxCacheInitOptimizationFromConfig);
  }

  /**
   * Test {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}.
   * <ul>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Storage.getTxCacheInitOptimizationFromConfig(Config)"})
  public void testGetTxCacheInitOptimizationFromConfig_whenConfigHasPathReturnFalse() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualTxCacheInitOptimizationFromConfig = Storage.getTxCacheInitOptimizationFromConfig(config);

    // Assert
    verify(config).hasPath(eq("storage.txCache.initOptimization"));
    assertFalse(actualTxCacheInitOptimizationFromConfig);
  }

  /**
   * Test {@link Storage#setCacheStrategies(Config)}.
   * <ul>
   *   <li>Given {@link Config} {@link Config#entrySet()} return {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link Config#entrySet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#setCacheStrategies(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    verify(config3).getConfig(eq("storage.cache.strategies"));
    verify(config3).hasPath(eq("storage.cache.strategies"));
    verify(config2).resolve();
  }

  /**
   * Test {@link Storage#setCacheStrategies(Config)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   *   <li>Then calls {@link Config#hasPath(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#setCacheStrategies(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Storage.setCacheStrategies(Config)"})
  public void testSetCacheStrategies_givenFalse_whenConfigHasPathReturnFalse_thenCallsHasPath() {
    // Arrange
    Storage storage = new Storage();
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    storage.setCacheStrategies(config);

    // Assert
    verify(config).hasPath(eq("storage.cache.strategies"));
  }

  /**
   * Test {@link Storage#setCacheStrategies(Config)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#setCacheStrategies(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Storage.setCacheStrategies(Config)"})
  public void testSetCacheStrategies_thenThrowIllegalArgumentException() {
    // Arrange
    Storage storage = new Storage();
    Config config = mock(Config.class);
    when(config.entrySet()).thenThrow(new IllegalArgumentException("storage.cache.strategies"));
    Config config2 = mock(Config.class);
    when(config2.resolve()).thenReturn(config);
    Config config3 = mock(Config.class);
    when(config3.getConfig(Mockito.<String>any())).thenReturn(config2);
    when(config3.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setCacheStrategies(config3));
    verify(config).entrySet();
    verify(config3).getConfig(eq("storage.cache.strategies"));
    verify(config3).hasPath(eq("storage.cache.strategies"));
    verify(config2).resolve();
  }

  /**
   * Test {@link Storage#getCacheStrategy(CacheType)}.
   * <p>
   * Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy() {
    // Arrange, Act and Assert
    assertEquals("initialCapacity=1000,maximumSize=1000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        (new Storage()).getCacheStrategy(CacheType.witnessStandby));
  }

  /**
   * Test {@link Storage#getCacheStrategy(CacheType)}.
   * <p>
   * Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy2() {
    // Arrange, Act and Assert
    assertEquals("initialCapacity=100,maximumSize=100,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        (new Storage()).getCacheStrategy(CacheType.recentBlock));
  }

  /**
   * Test {@link Storage#getCacheStrategy(CacheType)}.
   * <p>
   * Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy3() {
    // Arrange, Act and Assert
    assertEquals("initialCapacity=500,maximumSize=500,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        (new Storage()).getCacheStrategy(CacheType.code));
  }

  /**
   * Test {@link Storage#getCacheStrategy(CacheType)}.
   * <p>
   * Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy4() {
    // Arrange, Act and Assert
    assertEquals("initialCapacity=10000,maximumSize=10000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        (new Storage()).getCacheStrategy(CacheType.delegation));
  }

  /**
   * Test {@link Storage#getCacheStrategy(CacheType)}.
   * <p>
   * Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Storage.getCacheStrategy(CacheType)"})
  public void testGetCacheStrategy5() {
    // Arrange, Act and Assert
    assertEquals("initialCapacity=20000,maximumSize=20000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        (new Storage()).getCacheStrategy(CacheType.storageRow));
  }

  /**
   * Test {@link Storage#getDbRoot(String, Sha256Hash)}.
   * <p>
   * Method under test: {@link Storage#getDbRoot(String, Sha256Hash)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sha256Hash Storage.getDbRoot(String, Sha256Hash)"})
  public void testGetDbRoot() {
    // Arrange and Act
    Sha256Hash actualDbRoot = (new Storage()).getDbRoot("Db Name", Sha256Hash.ZERO_HASH);

    // Assert
    assertSame(actualDbRoot.ZERO_HASH, actualDbRoot);
  }

  /**
   * Test {@link Storage#setDbRoots(Config)}.
   * <p>
   * Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Storage.setDbRoots(Config)"})
  public void testSetDbRoots() {
    // Arrange
    Storage storage = new Storage();
    Config config = mock(Config.class);
    when(config.entrySet()).thenThrow(new IllegalArgumentException("storage.merkleRoot"));
    Config config2 = mock(Config.class);
    when(config2.resolve()).thenReturn(config);
    Config config3 = mock(Config.class);
    when(config3.getConfig(Mockito.<String>any())).thenReturn(config2);
    when(config3.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setDbRoots(config3));
    verify(config).entrySet();
    verify(config3).getConfig(eq("storage.merkleRoot"));
    verify(config3).hasPath(eq("storage.merkleRoot"));
    verify(config2).resolve();
  }

  /**
   * Test {@link Storage#setDbRoots(Config)}.
   * <ul>
   *   <li>Given {@link Config} {@link Config#entrySet()} return {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link Config#entrySet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Storage.setDbRoots(Config)"})
  public void testSetDbRoots_givenConfigEntrySetReturnHashSet_thenCallsEntrySet() {
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
    verify(config3).getConfig(eq("storage.merkleRoot"));
    verify(config3).hasPath(eq("storage.merkleRoot"));
    verify(config2).resolve();
  }

  /**
   * Test {@link Storage#setDbRoots(Config)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Config} {@link Config#hasPath(String)} return {@code false}.</li>
   *   <li>Then calls {@link Config#hasPath(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Storage.setDbRoots(Config)"})
  public void testSetDbRoots_givenFalse_whenConfigHasPathReturnFalse_thenCallsHasPath() {
    // Arrange
    Storage storage = new Storage();
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenReturn(false);

    // Act
    storage.setDbRoots(config);

    // Assert
    verify(config).hasPath(eq("storage.merkleRoot"));
  }

  /**
   * Test {@link Storage#setDbRoots(Config)}.
   * <ul>
   *   <li>Then calls {@link ConfigValue#unwrapped()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Storage.setDbRoots(Config)"})
  public void testSetDbRoots_thenCallsUnwrapped() {
    // Arrange
    Storage storage = new Storage();
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenThrow(new IllegalArgumentException("storage.merkleRoot"));
    SimpleEntry<String, ConfigValue> simpleEntry = new SimpleEntry<>(
        new SimpleEntry<>("storage.merkleRoot", configValue));

    HashSet<Entry<String, ConfigValue>> entrySet = new HashSet<>();
    entrySet.add(simpleEntry);
    Config config = mock(Config.class);
    when(config.entrySet()).thenReturn(entrySet);
    Config config2 = mock(Config.class);
    when(config2.resolve()).thenReturn(config);
    Config config3 = mock(Config.class);
    when(config3.getConfig(Mockito.<String>any())).thenReturn(config2);
    when(config3.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setDbRoots(config3));
    verify(config).entrySet();
    verify(config3).getConfig(eq("storage.merkleRoot"));
    verify(config3).hasPath(eq("storage.merkleRoot"));
    verify(config2).resolve();
    verify(configValue).unwrapped();
  }

  /**
   * Test {@link Storage#setPropertyMapFromConfig(Config)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link Storage} (default constructor) PropertyMap Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#setPropertyMapFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    verify(config).getObjectList(eq("storage.properties"));
    verify(config).hasPath(eq("storage.properties"));
    assertTrue(storage.getPropertyMap().isEmpty());
  }

  /**
   * Test {@link Storage#setPropertyMapFromConfig(Config)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code storage.properties}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#setPropertyMapFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Storage.setPropertyMapFromConfig(Config)"})
  public void testSetPropertyMapFromConfig_givenIllegalArgumentExceptionWithStorageProperties() {
    // Arrange
    Storage storage = new Storage();
    Config config = mock(Config.class);
    Mockito.<List<? extends ConfigObject>>when(config.getObjectList(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("storage.properties"));
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setPropertyMapFromConfig(config));
    verify(config).getObjectList(eq("storage.properties"));
    verify(config).hasPath(eq("storage.properties"));
  }

  /**
   * Test {@link Storage#setPropertyMapFromConfig(Config)}.
   * <ul>
   *   <li>Then calls {@link ConfigObject#get(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#setPropertyMapFromConfig(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Storage.setPropertyMapFromConfig(Config)"})
  public void testSetPropertyMapFromConfig_thenCallsGet() {
    // Arrange
    Storage storage = new Storage();
    ConfigValue configValue = mock(ConfigValue.class);
    when(configValue.unwrapped()).thenThrow(new IllegalArgumentException("storage.properties"));
    ConfigObject configObject = mock(ConfigObject.class);
    when(configObject.get(Mockito.<Object>any())).thenReturn(configValue);
    when(configObject.containsKey(Mockito.<Object>any())).thenReturn(true);

    ArrayList<ConfigObject> configObjectList = new ArrayList<>();
    configObjectList.add(configObject);
    Config config = mock(Config.class);
    Mockito.<List<? extends ConfigObject>>when(config.getObjectList(Mockito.<String>any()))
        .thenReturn(configObjectList);
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setPropertyMapFromConfig(config));
    verify(config).getObjectList(eq("storage.properties"));
    verify(config).hasPath(eq("storage.properties"));
    verify(configObject).get(isA(Object.class));
    verify(configValue).unwrapped();
    verify(configObject).containsKey(isA(Object.class));
  }

  /**
   * Test {@link Storage#deleteAllStoragePaths()}.
   * <ul>
   *   <li>Then calls {@link Config#getObjectList(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#deleteAllStoragePaths()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    verify(config).getObjectList(eq("storage.properties"));
    verify(config).hasPath(eq("storage.properties"));
  }

  /**
   * Test {@link Storage#setDefaultDbOptions(Config)}.
   * <ul>
   *   <li>Given {@link Config}.</li>
   *   <li>When {@link Config} {@link Config#getConfig(String)} return {@link Config}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#setDefaultDbOptions(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Storage.setDefaultDbOptions(Config)"})
  public void testSetDefaultDbOptions_givenConfig_whenConfigGetConfigReturnConfig() {
    // Arrange
    Storage storage = new Storage();
    Config config = mock(Config.class);
    when(config.getConfig(Mockito.<String>any())).thenReturn(mock(Config.class));

    // Act
    storage.setDefaultDbOptions(config);

    // Assert
    verify(config).getConfig(eq("storage"));
  }

  /**
   * Test {@link Storage#setDefaultDbOptions(Config)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Storage#setDefaultDbOptions(Config)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Storage.setDefaultDbOptions(Config)"})
  public void testSetDefaultDbOptions_thenThrowIllegalArgumentException() {
    // Arrange
    Storage storage = new Storage();
    Config config = mock(Config.class);
    when(config.getConfig(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setDefaultDbOptions(config));
    verify(config).getConfig(eq("storage"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List Storage.getCacheDbs()", "int Storage.getCheckpointVersion()",
      "String Storage.getDbDirectory()", "String Storage.getDbEngine()", "int Storage.getEstimatedBlockTransactions()",
      "String Storage.getIndexDirectory()", "String Storage.getIndexSwitch()", "int Storage.getMaxFlushCount()",
      "Map Storage.getPropertyMap()", "String Storage.getTransactionHistorySwitch()",
      "boolean Storage.isCheckpointSync()", "boolean Storage.isContractParseSwitch()", "boolean Storage.isDbSync()",
      "boolean Storage.isTxCacheInitOptimization()", "void Storage.setCheckpointSync(boolean)",
      "void Storage.setCheckpointVersion(int)", "void Storage.setContractParseSwitch(boolean)",
      "void Storage.setDbDirectory(String)", "void Storage.setDbEngine(String)", "void Storage.setDbSync(boolean)",
      "void Storage.setEstimatedBlockTransactions(int)", "void Storage.setIndexDirectory(String)",
      "void Storage.setIndexSwitch(String)", "void Storage.setMaxFlushCount(int)",
      "void Storage.setTransactionHistorySwitch(String)", "void Storage.setTxCacheInitOptimization(boolean)"})
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
   * <p>
   * Method under test: default or parameterless constructor of {@link Storage}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
