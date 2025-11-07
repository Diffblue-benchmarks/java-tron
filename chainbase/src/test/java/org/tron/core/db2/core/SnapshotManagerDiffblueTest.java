package org.tron.core.db2.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.db2.ISession;
import org.tron.core.exception.RevokingStoreIllegalStateException;
import org.tron.core.store.CheckTmpStore;

@RunWith(MockitoJUnitRunner.class)
public class SnapshotManagerDiffblueTest {
  @Mock
  private CheckTmpStore checkTmpStore;

  @InjectMocks
  private SnapshotManager snapshotManager;

  @InjectMocks
  private String string;

  /**
   * Method under test: {@link SnapshotManager#buildSession()}
   */
  @Test
  public void testBuildSession() {
    // Arrange and Act
    ISession actualBuildSessionResult = snapshotManager.buildSession();

    // Assert
    assertTrue(actualBuildSessionResult instanceof SnapshotManager.Session);
    assertFalse(((SnapshotManager.Session) actualBuildSessionResult).isDisableOnExit());
    assertTrue(((SnapshotManager.Session) actualBuildSessionResult).isApplySnapshot());
    assertSame(snapshotManager, ((SnapshotManager.Session) actualBuildSessionResult).getSnapshotManager());
  }

  /**
   * Method under test: {@link SnapshotManager#buildSession(boolean)}
   */
  @Test
  public void testBuildSession2() {
    // Arrange and Act
    ISession actualBuildSessionResult = snapshotManager.buildSession(true);

    // Assert
    assertTrue(actualBuildSessionResult instanceof SnapshotManager.Session);
    assertTrue(((SnapshotManager.Session) actualBuildSessionResult).isApplySnapshot());
    assertSame(snapshotManager, ((SnapshotManager.Session) actualBuildSessionResult).getSnapshotManager());
  }

  /**
   * Method under test: {@link SnapshotManager#buildSession(boolean)}
   */
  @Test
  public void testBuildSession3() {
    // Arrange and Act
    ISession actualBuildSessionResult = snapshotManager.buildSession(false);

    // Assert
    assertTrue(actualBuildSessionResult instanceof SnapshotManager.Session);
    assertEquals(0, snapshotManager.getActiveSession());
    assertEquals(0, snapshotManager.getSize());
    assertEquals(0, snapshotManager.size());
    assertFalse(((SnapshotManager.Session) actualBuildSessionResult).isDisableOnExit());
    assertTrue(((SnapshotManager.Session) actualBuildSessionResult).isApplySnapshot());
    assertSame(snapshotManager, ((SnapshotManager.Session) actualBuildSessionResult).getSnapshotManager());
  }

  /**
   * Method under test: {@link SnapshotManager#merge()}
   */
  @Test
  public void testMerge() {
    // Arrange, Act and Assert
    assertThrows(RevokingStoreIllegalStateException.class, () -> snapshotManager.merge());
  }

  /**
   * Method under test: {@link SnapshotManager#commit()}
   */
  @Test
  public void testCommit() {
    // Arrange, Act and Assert
    assertThrows(RevokingStoreIllegalStateException.class, () -> snapshotManager.commit());
  }

  /**
   * Method under test: {@link SnapshotManager#pop()}
   */
  @Test
  public void testPop() {
    // Arrange, Act and Assert
    assertThrows(RevokingStoreIllegalStateException.class, () -> snapshotManager.pop());
  }

  /**
   * Method under test: {@link SnapshotManager#fastPop()}
   */
  @Test
  public void testFastPop() {
    // Arrange, Act and Assert
    assertThrows(RevokingStoreIllegalStateException.class, () -> snapshotManager.fastPop());
  }

  /**
   * Method under test: {@link SnapshotManager#getMaxSize()}
   */
  @Test
  public void testGetMaxSize() {
    // Arrange, Act and Assert
    assertEquals(256, snapshotManager.getMaxSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SnapshotManager.Session#Session(SnapshotManager)}
   *   <li>{@link SnapshotManager.Session#getSnapshotManager()}
   *   <li>{@link SnapshotManager.Session#isApplySnapshot()}
   *   <li>{@link SnapshotManager.Session#isDisableOnExit()}
   * </ul>
   */
  @Test
  public void testSessionGettersAndSetters() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");

    // Act
    SnapshotManager.Session actualSession = new SnapshotManager.Session(snapshotManager);
    SnapshotManager actualSnapshotManager = actualSession.getSnapshotManager();
    boolean actualIsApplySnapshotResult = actualSession.isApplySnapshot();

    // Assert
    assertFalse(actualSession.isDisableOnExit());
    assertTrue(actualIsApplySnapshotResult);
    assertSame(snapshotManager, actualSnapshotManager);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SnapshotManager.Session#Session(SnapshotManager, boolean)}
   *   <li>{@link SnapshotManager.Session#getSnapshotManager()}
   *   <li>{@link SnapshotManager.Session#isApplySnapshot()}
   *   <li>{@link SnapshotManager.Session#isDisableOnExit()}
   * </ul>
   */
  @Test
  public void testSessionGettersAndSetters2() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");

    // Act
    SnapshotManager.Session actualSession = new SnapshotManager.Session(snapshotManager, true);
    SnapshotManager actualSnapshotManager = actualSession.getSnapshotManager();
    boolean actualIsApplySnapshotResult = actualSession.isApplySnapshot();

    // Assert
    assertTrue(actualIsApplySnapshotResult);
    assertTrue(actualSession.isDisableOnExit());
    assertSame(snapshotManager, actualSnapshotManager);
  }

  /**
   * Method under test: {@link SnapshotManager#setMaxSize(int)}
   */
  @Test
  public void testSetMaxSize() {
    // Arrange and Act
    snapshotManager.setMaxSize(3);

    // Assert
    assertEquals(3, snapshotManager.getMaxSize());
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");

    // Act
    snapshotManager.setMaxFlushCount(3);
    snapshotManager.setUnChecked(true);
    snapshotManager.disable();
    snapshotManager.enable();
    int actualActiveSession = snapshotManager.getActiveSession();
    snapshotManager.getCheckTmpStore();
    List<Chainbase> actualDbs = snapshotManager.getDbs();
    int actualSize = snapshotManager.getSize();

    // Assert that nothing has changed
    assertEquals(0, actualActiveSession);
    assertEquals(0, actualSize);
    assertEquals(0, snapshotManager.size());
    assertTrue(actualDbs.isEmpty());
  }

  /**
   * Method under test: {@link SnapshotManager#SnapshotManager(String)}
   */
  @Test
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
}
