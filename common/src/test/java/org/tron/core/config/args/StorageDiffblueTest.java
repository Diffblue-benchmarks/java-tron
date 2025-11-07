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
import com.typesafe.config.Config;
import com.typesafe.config.ConfigObject;
import com.typesafe.config.ConfigValue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.common.cache.CacheType;
import org.tron.common.utils.Sha256Hash;

public class StorageDiffblueTest {
  /**
   * Method under test: {@link Storage#getDbEngineFromConfig(Config)}
   */
  @Test
  public void testGetDbEngineFromConfig() {
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
   * Method under test: {@link Storage#getDbEngineFromConfig(Config)}
   */
  @Test
  public void testGetDbEngineFromConfig2() {
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
   * Method under test: {@link Storage#getDbEngineFromConfig(Config)}
   */
  @Test
  public void testGetDbEngineFromConfig3() {
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
   * Method under test: {@link Storage#getDbEngineFromConfig(Config)}
   */
  @Test
  public void testGetDbEngineFromConfig4() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.db.engine"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbEngineFromConfig(config));
    verify(config).hasPath(eq("storage.db.engine"));
  }

  /**
   * Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  public void testGetDbVersionSyncFromConfig() {
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
   * Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  public void testGetDbVersionSyncFromConfig2() {
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
   * Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  public void testGetDbVersionSyncFromConfig3() {
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
   * Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  public void testGetDbVersionSyncFromConfig4() {
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
   * Method under test: {@link Storage#getDbVersionSyncFromConfig(Config)}
   */
  @Test
  public void testGetDbVersionSyncFromConfig5() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.db.sync"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbVersionSyncFromConfig(config));
    verify(config).hasPath(eq("storage.db.sync"));
  }

  /**
   * Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  public void testGetSnapshotMaxFlushCountFromConfig() {
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
   * Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  public void testGetSnapshotMaxFlushCountFromConfig2() {
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
   * Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  public void testGetSnapshotMaxFlushCountFromConfig3() {
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
   * Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  public void testGetSnapshotMaxFlushCountFromConfig4() {
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
   * Method under test: {@link Storage#getSnapshotMaxFlushCountFromConfig(Config)}
   */
  @Test
  public void testGetSnapshotMaxFlushCountFromConfig5() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("storage.snapshot.maxFlushCount"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getSnapshotMaxFlushCountFromConfig(config));
    verify(config).hasPath(eq("storage.snapshot.maxFlushCount"));
  }

  /**
   * Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  public void testGetContractParseSwitchFromConfig() {
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
   * Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  public void testGetContractParseSwitchFromConfig2() {
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
   * Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  public void testGetContractParseSwitchFromConfig3() {
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
   * Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  public void testGetContractParseSwitchFromConfig4() {
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
   * Method under test: {@link Storage#getContractParseSwitchFromConfig(Config)}
   */
  @Test
  public void testGetContractParseSwitchFromConfig5() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("event.subscribe.contractParse"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getContractParseSwitchFromConfig(config));
    verify(config).hasPath(eq("event.subscribe.contractParse"));
  }

  /**
   * Method under test: {@link Storage#getDbDirectoryFromConfig(Config)}
   */
  @Test
  public void testGetDbDirectoryFromConfig() {
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
   * Method under test: {@link Storage#getDbDirectoryFromConfig(Config)}
   */
  @Test
  public void testGetDbDirectoryFromConfig2() {
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
   * Method under test: {@link Storage#getDbDirectoryFromConfig(Config)}
   */
  @Test
  public void testGetDbDirectoryFromConfig3() {
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
   * Method under test: {@link Storage#getDbDirectoryFromConfig(Config)}
   */
  @Test
  public void testGetDbDirectoryFromConfig4() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.db.directory"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getDbDirectoryFromConfig(config));
    verify(config).hasPath(eq("storage.db.directory"));
  }

  /**
   * Method under test: {@link Storage#getIndexDirectoryFromConfig(Config)}
   */
  @Test
  public void testGetIndexDirectoryFromConfig() {
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
   * Method under test: {@link Storage#getIndexDirectoryFromConfig(Config)}
   */
  @Test
  public void testGetIndexDirectoryFromConfig2() {
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
   * Method under test: {@link Storage#getIndexDirectoryFromConfig(Config)}
   */
  @Test
  public void testGetIndexDirectoryFromConfig3() {
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
   * Method under test: {@link Storage#getIndexDirectoryFromConfig(Config)}
   */
  @Test
  public void testGetIndexDirectoryFromConfig4() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.index.directory"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getIndexDirectoryFromConfig(config));
    verify(config).hasPath(eq("storage.index.directory"));
  }

  /**
   * Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  public void testGetIndexSwitchFromConfig() {
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
   * Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  public void testGetIndexSwitchFromConfig2() {
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
   * Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  public void testGetIndexSwitchFromConfig3() {
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
   * Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  public void testGetIndexSwitchFromConfig4() {
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
   * Method under test: {@link Storage#getIndexSwitchFromConfig(Config)}
   */
  @Test
  public void testGetIndexSwitchFromConfig5() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.index.switch"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getIndexSwitchFromConfig(config));
    verify(config).hasPath(eq("storage.index.switch"));
  }

  /**
   * Method under test:
   * {@link Storage#getTransactionHistorySwitchFromConfig(Config)}
   */
  @Test
  public void testGetTransactionHistorySwitchFromConfig() {
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
   * Method under test:
   * {@link Storage#getTransactionHistorySwitchFromConfig(Config)}
   */
  @Test
  public void testGetTransactionHistorySwitchFromConfig2() {
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
   * Method under test:
   * {@link Storage#getTransactionHistorySwitchFromConfig(Config)}
   */
  @Test
  public void testGetTransactionHistorySwitchFromConfig3() {
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
   * Method under test:
   * {@link Storage#getTransactionHistorySwitchFromConfig(Config)}
   */
  @Test
  public void testGetTransactionHistorySwitchFromConfig4() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.transHistory.switch"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getTransactionHistorySwitchFromConfig(config));
    verify(config).hasPath(eq("storage.transHistory.switch"));
  }

  /**
   * Method under test: {@link Storage#getCheckpointVersionFromConfig(Config)}
   */
  @Test
  public void testGetCheckpointVersionFromConfig() {
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
   * Method under test: {@link Storage#getCheckpointVersionFromConfig(Config)}
   */
  @Test
  public void testGetCheckpointVersionFromConfig2() {
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
   * Method under test: {@link Storage#getCheckpointVersionFromConfig(Config)}
   */
  @Test
  public void testGetCheckpointVersionFromConfig3() {
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
   * Method under test: {@link Storage#getCheckpointVersionFromConfig(Config)}
   */
  @Test
  public void testGetCheckpointVersionFromConfig4() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.checkpoint.version"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getCheckpointVersionFromConfig(config));
    verify(config).hasPath(eq("storage.checkpoint.version"));
  }

  /**
   * Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  public void testGetCheckpointSyncFromConfig() {
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
   * Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  public void testGetCheckpointSyncFromConfig2() {
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
   * Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  public void testGetCheckpointSyncFromConfig3() {
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
   * Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  public void testGetCheckpointSyncFromConfig4() {
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
   * Method under test: {@link Storage#getCheckpointSyncFromConfig(Config)}
   */
  @Test
  public void testGetCheckpointSyncFromConfig5() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage.checkpoint.sync"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getCheckpointSyncFromConfig(config));
    verify(config).hasPath(eq("storage.checkpoint.sync"));
  }

  /**
   * Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  public void testGetEstimatedTransactionsFromConfig() {
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
   * Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  public void testGetEstimatedTransactionsFromConfig2() {
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
   * Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  public void testGetEstimatedTransactionsFromConfig3() {
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
   * Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  public void testGetEstimatedTransactionsFromConfig4() {
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
   * Method under test: {@link Storage#getEstimatedTransactionsFromConfig(Config)}
   */
  @Test
  public void testGetEstimatedTransactionsFromConfig5() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("storage.txCache.estimatedTransactions"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getEstimatedTransactionsFromConfig(config));
    verify(config).hasPath(eq("storage.txCache.estimatedTransactions"));
  }

  /**
   * Method under test:
   * {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  public void testGetTxCacheInitOptimizationFromConfig() {
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
   * Method under test:
   * {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  public void testGetTxCacheInitOptimizationFromConfig2() {
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
   * Method under test:
   * {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  public void testGetTxCacheInitOptimizationFromConfig3() {
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
   * Method under test:
   * {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  public void testGetTxCacheInitOptimizationFromConfig4() {
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
   * Method under test:
   * {@link Storage#getTxCacheInitOptimizationFromConfig(Config)}
   */
  @Test
  public void testGetTxCacheInitOptimizationFromConfig5() {
    // Arrange
    Config config = mock(Config.class);
    when(config.hasPath(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException(Storage.TX_CACHE_INIT_OPTIMIZATION));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Storage.getTxCacheInitOptimizationFromConfig(config));
    verify(config).hasPath(eq("storage.txCache.initOptimization"));
  }

  /**
   * Method under test: {@link Storage#setCacheStrategies(Config)}
   */
  @Test
  public void testSetCacheStrategies() {
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
   * Method under test: {@link Storage#setCacheStrategies(Config)}
   */
  @Test
  public void testSetCacheStrategies2() {
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
   * Method under test: {@link Storage#setCacheStrategies(Config)}
   */
  @Test
  public void testSetCacheStrategies3() {
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
   * Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  public void testGetCacheStrategy() {
    // Arrange, Act and Assert
    assertEquals("initialCapacity=1000,maximumSize=1000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        (new Storage()).getCacheStrategy(CacheType.witnessStandby));
    assertEquals("initialCapacity=100,maximumSize=100,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        (new Storage()).getCacheStrategy(CacheType.recentBlock));
  }

  /**
   * Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  public void testGetCacheStrategy2() {
    // Arrange
    Config config = mock(Config.class);
    Mockito.<List<? extends ConfigObject>>when(config.getObjectList(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    Storage storage = new Storage();
    storage.setPropertyMapFromConfig(config);

    // Act
    String actualCacheStrategy = storage.getCacheStrategy(CacheType.witnessStandby);

    // Assert
    verify(config).getObjectList(eq("storage.properties"));
    verify(config).hasPath(eq("storage.properties"));
    assertEquals("initialCapacity=1000,maximumSize=1000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        actualCacheStrategy);
  }

  /**
   * Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  public void testGetCacheStrategy3() {
    // Arrange
    Config config = mock(Config.class);
    Mockito.<List<? extends ConfigObject>>when(config.getObjectList(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    Storage storage = new Storage();
    storage.setPropertyMapFromConfig(config);

    // Act
    String actualCacheStrategy = storage.getCacheStrategy(CacheType.code);

    // Assert
    verify(config).getObjectList(eq("storage.properties"));
    verify(config).hasPath(eq("storage.properties"));
    assertEquals("initialCapacity=500,maximumSize=500,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        actualCacheStrategy);
  }

  /**
   * Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  public void testGetCacheStrategy4() {
    // Arrange
    Config config = mock(Config.class);
    Mockito.<List<? extends ConfigObject>>when(config.getObjectList(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    Storage storage = new Storage();
    storage.setPropertyMapFromConfig(config);

    // Act
    String actualCacheStrategy = storage.getCacheStrategy(CacheType.delegation);

    // Assert
    verify(config).getObjectList(eq("storage.properties"));
    verify(config).hasPath(eq("storage.properties"));
    assertEquals("initialCapacity=10000,maximumSize=10000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        actualCacheStrategy);
  }

  /**
   * Method under test: {@link Storage#getCacheStrategy(CacheType)}
   */
  @Test
  public void testGetCacheStrategy5() {
    // Arrange
    Config config = mock(Config.class);
    Mockito.<List<? extends ConfigObject>>when(config.getObjectList(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    Storage storage = new Storage();
    storage.setPropertyMapFromConfig(config);

    // Act
    String actualCacheStrategy = storage.getCacheStrategy(CacheType.storageRow);

    // Assert
    verify(config).getObjectList(eq("storage.properties"));
    verify(config).hasPath(eq("storage.properties"));
    assertEquals("initialCapacity=20000,maximumSize=20000,expireAfterAccess=30s,concurrencyLevel=7,recordStats",
        actualCacheStrategy);
  }

  /**
   * Method under test: {@link Storage#getDbRoot(String, Sha256Hash)}
   */
  @Test
  public void testGetDbRoot() {
    // Arrange and Act
    Sha256Hash actualDbRoot = (new Storage()).getDbRoot("Db Name", Sha256Hash.ZERO_HASH);

    // Assert
    assertSame(actualDbRoot.ZERO_HASH, actualDbRoot);
  }

  /**
   * Method under test: {@link Storage#getDbRoot(String, Sha256Hash)}
   */
  @Test
  public void testGetDbRoot2() {
    // Arrange
    Config config = mock(Config.class);
    Mockito.<List<? extends ConfigObject>>when(config.getObjectList(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    Storage storage = new Storage();
    storage.setPropertyMapFromConfig(config);

    // Act
    Sha256Hash actualDbRoot = storage.getDbRoot("Db Name", Sha256Hash.ZERO_HASH);

    // Assert
    verify(config).getObjectList(eq("storage.properties"));
    verify(config).hasPath(eq("storage.properties"));
    assertSame(actualDbRoot.ZERO_HASH, actualDbRoot);
  }

  /**
   * Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  public void testSetDbRoots() {
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
   * Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  public void testSetDbRoots2() {
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
   * Method under test: {@link Storage#setDbRoots(Config)}
   */
  @Test
  public void testSetDbRoots3() {
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
   * Method under test: {@link Storage#setPropertyMapFromConfig(Config)}
   */
  @Test
  public void testSetPropertyMapFromConfig() {
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
   * Method under test: {@link Storage#setPropertyMapFromConfig(Config)}
   */
  @Test
  public void testSetPropertyMapFromConfig2() {
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
   * Method under test: {@link Storage#setPropertyMapFromConfig(Config)}
   */
  @Test
  public void testSetPropertyMapFromConfig3() {
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
   * Method under test: {@link Storage#deleteAllStoragePaths()}
   */
  @Test
  public void testDeleteAllStoragePaths() {
    // Arrange
    Config config = mock(Config.class);
    Mockito.<List<? extends ConfigObject>>when(config.getObjectList(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(config.hasPath(Mockito.<String>any())).thenReturn(true);

    Storage storage = new Storage();
    storage.setPropertyMapFromConfig(config);

    // Act
    storage.deleteAllStoragePaths();

    // Assert that nothing has changed
    verify(config).getObjectList(eq("storage.properties"));
    verify(config).hasPath(eq("storage.properties"));
  }

  /**
   * Method under test: {@link Storage#setDefaultDbOptions(Config)}
   */
  @Test
  public void testSetDefaultDbOptions() {
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
   * Method under test: {@link Storage#setDefaultDbOptions(Config)}
   */
  @Test
  public void testSetDefaultDbOptions2() {
    // Arrange
    Storage storage = new Storage();
    Config config = mock(Config.class);
    when(config.getConfig(Mockito.<String>any())).thenThrow(new IllegalArgumentException("storage"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> storage.setDefaultDbOptions(config));
    verify(config).getConfig(eq("storage"));
  }

  /**
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
    storage.getPropertyMap();
    String actualTransactionHistorySwitch = storage.getTransactionHistorySwitch();
    boolean actualIsCheckpointSyncResult = storage.isCheckpointSync();
    boolean actualIsContractParseSwitchResult = storage.isContractParseSwitch();
    boolean actualIsDbSyncResult = storage.isDbSync();

    // Assert that nothing has changed
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
    assertEquals(1, actualCheckpointVersion);
    assertEquals(1, actualEstimatedBlockTransactions);
    assertEquals(3, actualMaxFlushCount);
    assertTrue(actualIsCheckpointSyncResult);
    assertTrue(actualIsContractParseSwitchResult);
    assertTrue(actualIsDbSyncResult);
    assertTrue(storage.isTxCacheInitOptimization());
  }

  /**
   * Method under test: default or parameterless constructor of {@link Storage}
   */
  @Test
  public void testNewStorage() {
    // Arrange and Act
    Storage actualStorage = new Storage();

    // Assert
    List<String> cacheDbs = actualStorage.getCacheDbs();
    assertEquals(14, cacheDbs.size());
    assertEquals("account", cacheDbs.get(13));
    assertEquals("delegation", cacheDbs.get(11));
    assertEquals("recent-block", cacheDbs.get(0));
    assertEquals("storage-row", cacheDbs.get(12));
    assertEquals("witness", cacheDbs.get(1));
    assertEquals("witness_schedule", cacheDbs.get(2));
    assertNull(actualStorage.getDbDirectory());
    assertNull(actualStorage.getDbEngine());
    assertNull(actualStorage.getIndexDirectory());
    assertNull(actualStorage.getIndexSwitch());
    assertNull(actualStorage.getTransactionHistorySwitch());
    assertNull(actualStorage.getPropertyMap());
    assertEquals(0, actualStorage.getCheckpointVersion());
    assertEquals(0, actualStorage.getEstimatedBlockTransactions());
    assertEquals(0, actualStorage.getMaxFlushCount());
    assertFalse(actualStorage.isCheckpointSync());
    assertFalse(actualStorage.isContractParseSwitch());
    assertFalse(actualStorage.isDbSync());
    assertFalse(actualStorage.isTxCacheInitOptimization());
  }
}
