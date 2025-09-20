package org.tron.core.db2.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.db2.core.SnapshotManager.Session;
import org.tron.core.store.CheckTmpStore;

public class SnapshotManagerDiffblueTest {
  /**
   * Test {@link SnapshotManager#SnapshotManager(String)}.
   *
   * <p>Method under test: {@link SnapshotManager#SnapshotManager(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SnapshotManager.<init>(String)"})
  public void testNewSnapshotManager() {
    // Arrange and Act
    SnapshotManager actualSnapshotManager = new SnapshotManager("Checkpoint Path");

    // Assert
    assertNull(actualSnapshotManager.getCheckTmpStore());
    assertEquals(0, actualSnapshotManager.getActiveSession());
    assertEquals(0, actualSnapshotManager.getSize());
    assertEquals(0, actualSnapshotManager.size());
    assertEquals(256, actualSnapshotManager.getMaxSize());
    assertTrue(actualSnapshotManager.getDbs().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SnapshotManager#setMaxFlushCount(int)}
   *   <li>{@link SnapshotManager#setUnChecked(boolean)}
   *   <li>{@link SnapshotManager#disable()}
   *   <li>{@link SnapshotManager#enable()}
   *   <li>{@link SnapshotManager#getActiveSession()}
   *   <li>{@link SnapshotManager#getCheckTmpStore()}
   *   <li>{@link SnapshotManager#getDbs()}
   *   <li>{@link SnapshotManager#getSize()}
   *   <li>{@link SnapshotManager#size()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SnapshotManager.disable()",
    "void SnapshotManager.enable()",
    "int SnapshotManager.getActiveSession()",
    "CheckTmpStore SnapshotManager.getCheckTmpStore()",
    "List SnapshotManager.getDbs()",
    "int SnapshotManager.getSize()",
    "void SnapshotManager.setCheckTmpStore(CheckTmpStore)",
    "void SnapshotManager.setMaxFlushCount(int)",
    "void SnapshotManager.setUnChecked(boolean)",
    "int SnapshotManager.size()"
  })
  public void testGettersAndSetters() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");

    // Act
    snapshotManager.setMaxFlushCount(3);
    snapshotManager.setUnChecked(true);
    snapshotManager.disable();
    snapshotManager.enable();
    int actualActiveSession = snapshotManager.getActiveSession();
    CheckTmpStore actualCheckTmpStore = snapshotManager.getCheckTmpStore();
    List<Chainbase> actualDbs = snapshotManager.getDbs();
    int actualSize = snapshotManager.getSize();

    // Assert
    assertNull(actualCheckTmpStore);
    assertEquals(0, actualActiveSession);
    assertEquals(0, actualSize);
    assertEquals(0, snapshotManager.size());
    assertTrue(actualDbs.isEmpty());
  }

  /**
   * Test Session getters and setters.
   *
   * <ul>
   *   <li>Then return not DisableOnExit.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Session#Session(SnapshotManager)}
   *   <li>{@link Session#getSnapshotManager()}
   *   <li>{@link Session#isApplySnapshot()}
   *   <li>{@link Session#isDisableOnExit()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Session.<init>(SnapshotManager)",
    "void Session.<init>(SnapshotManager, boolean)",
    "SnapshotManager Session.getSnapshotManager()",
    "boolean Session.isApplySnapshot()",
    "boolean Session.isDisableOnExit()"
  })
  public void testSessionGettersAndSetters_thenReturnNotDisableOnExit() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");

    // Act
    Session actualSession = new Session(snapshotManager);
    SnapshotManager actualSnapshotManager = actualSession.getSnapshotManager();
    boolean actualIsApplySnapshotResult = actualSession.isApplySnapshot();

    // Assert
    assertFalse(actualSession.isDisableOnExit());
    assertTrue(actualIsApplySnapshotResult);
    assertSame(snapshotManager, actualSnapshotManager);
  }

  /**
   * Test Session getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return DisableOnExit.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Session#Session(SnapshotManager, boolean)}
   *   <li>{@link Session#getSnapshotManager()}
   *   <li>{@link Session#isApplySnapshot()}
   *   <li>{@link Session#isDisableOnExit()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Session.<init>(SnapshotManager)",
    "void Session.<init>(SnapshotManager, boolean)",
    "SnapshotManager Session.getSnapshotManager()",
    "boolean Session.isApplySnapshot()",
    "boolean Session.isDisableOnExit()"
  })
  public void testSessionGettersAndSetters_whenTrue_thenReturnDisableOnExit() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");

    // Act
    Session actualSession = new Session(snapshotManager, true);
    SnapshotManager actualSnapshotManager = actualSession.getSnapshotManager();
    boolean actualIsApplySnapshotResult = actualSession.isApplySnapshot();

    // Assert
    assertTrue(actualIsApplySnapshotResult);
    assertTrue(actualSession.isDisableOnExit());
    assertSame(snapshotManager, actualSnapshotManager);
  }
}
