package org.tron.core.db2.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.db2.ISession;
import org.tron.core.db2.core.SnapshotManager.Session;
import org.tron.core.exception.RevokingStoreIllegalStateException;
import org.tron.core.store.CheckTmpStore;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SnapshotManagerDiffblueTest {
  @InjectMocks
  private SnapshotManager snapshotManager;

  /**
   * Test {@link SnapshotManager#SnapshotManager(String)}.
   * <p>
   * Method under test: {@link SnapshotManager#SnapshotManager(String)}
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
   * Test {@link SnapshotManager#buildSession()}.
   * <p>
   * Method under test: {@link SnapshotManager#buildSession()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ISession SnapshotManager.buildSession()"})
  public void testBuildSession() {
    // Arrange and Act
    ISession actualBuildSessionResult = snapshotManager.buildSession();

    // Assert
    assertTrue(actualBuildSessionResult instanceof Session);
    assertFalse(((Session) actualBuildSessionResult).isDisableOnExit());
    assertTrue(((Session) actualBuildSessionResult).isApplySnapshot());
    assertSame(snapshotManager, ((Session) actualBuildSessionResult).getSnapshotManager());
  }

  /**
   * Test {@link SnapshotManager#buildSession(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Then return SnapshotManager ActiveSession is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnapshotManager#buildSession(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ISession SnapshotManager.buildSession(boolean)"})
  public void testBuildSessionWithBoolean_thenReturnSnapshotManagerActiveSessionIsZero() {
    // Arrange and Act
    ISession actualBuildSessionResult = snapshotManager.buildSession(false);

    // Assert
    assertTrue(actualBuildSessionResult instanceof Session);
    SnapshotManager snapshotManager2 = ((Session) actualBuildSessionResult).getSnapshotManager();
    assertEquals(0, snapshotManager2.getActiveSession());
    assertEquals(0, snapshotManager.getActiveSession());
    assertEquals(0, snapshotManager2.getSize());
    assertEquals(0, snapshotManager.getSize());
    assertEquals(0, snapshotManager2.size());
    assertEquals(0, snapshotManager.size());
    assertFalse(((Session) actualBuildSessionResult).isDisableOnExit());
  }

  /**
   * Test {@link SnapshotManager#buildSession(boolean)} with {@code boolean}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return SnapshotManager ActiveSession is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnapshotManager#buildSession(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ISession SnapshotManager.buildSession(boolean)"})
  public void testBuildSessionWithBoolean_whenTrue_thenReturnSnapshotManagerActiveSessionIsOne() {
    // Arrange and Act
    ISession actualBuildSessionResult = snapshotManager.buildSession(true);

    // Assert
    assertTrue(actualBuildSessionResult instanceof Session);
    SnapshotManager snapshotManager2 = ((Session) actualBuildSessionResult).getSnapshotManager();
    assertEquals(1, snapshotManager2.getActiveSession());
    assertEquals(1, snapshotManager.getActiveSession());
    assertEquals(1, snapshotManager2.getSize());
    assertEquals(1, snapshotManager.getSize());
    assertEquals(1, snapshotManager2.size());
    assertEquals(1, snapshotManager.size());
    assertTrue(((Session) actualBuildSessionResult).isDisableOnExit());
  }

  /**
   * Test {@link SnapshotManager#merge()}.
   * <p>
   * Method under test: {@link SnapshotManager#merge()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SnapshotManager.merge()"})
  public void testMerge() {
    // Arrange, Act and Assert
    assertThrows(RevokingStoreIllegalStateException.class, () -> snapshotManager.merge());
  }

  /**
   * Test {@link SnapshotManager#commit()}.
   * <p>
   * Method under test: {@link SnapshotManager#commit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SnapshotManager.commit()"})
  public void testCommit() {
    // Arrange, Act and Assert
    assertThrows(RevokingStoreIllegalStateException.class, () -> snapshotManager.commit());
  }

  /**
   * Test {@link SnapshotManager#pop()}.
   * <p>
   * Method under test: {@link SnapshotManager#pop()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SnapshotManager.pop()"})
  public void testPop() {
    // Arrange, Act and Assert
    assertThrows(RevokingStoreIllegalStateException.class, () -> snapshotManager.pop());
  }

  /**
   * Test {@link SnapshotManager#fastPop()}.
   * <p>
   * Method under test: {@link SnapshotManager#fastPop()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SnapshotManager.fastPop()"})
  public void testFastPop() {
    // Arrange, Act and Assert
    assertThrows(RevokingStoreIllegalStateException.class, () -> snapshotManager.fastPop());
  }

  /**
   * Test {@link SnapshotManager#getMaxSize()}.
   * <p>
   * Method under test: {@link SnapshotManager#getMaxSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SnapshotManager.getMaxSize()"})
  public void testGetMaxSize() {
    // Arrange, Act and Assert
    assertEquals(256, snapshotManager.getMaxSize());
  }

  /**
   * Test Session getters and setters.
   * <ul>
   *   <li>Then return not DisableOnExit.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Session#Session(SnapshotManager)}
   *   <li>{@link Session#getSnapshotManager()}
   *   <li>{@link Session#isApplySnapshot()}
   *   <li>{@link Session#isDisableOnExit()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Session.<init>(SnapshotManager)", "void Session.<init>(SnapshotManager, boolean)",
      "SnapshotManager Session.getSnapshotManager()", "boolean Session.isApplySnapshot()",
      "boolean Session.isDisableOnExit()"})
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
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return DisableOnExit.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Session#Session(SnapshotManager, boolean)}
   *   <li>{@link Session#getSnapshotManager()}
   *   <li>{@link Session#isApplySnapshot()}
   *   <li>{@link Session#isDisableOnExit()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Session.<init>(SnapshotManager)", "void Session.<init>(SnapshotManager, boolean)",
      "SnapshotManager Session.getSnapshotManager()", "boolean Session.isApplySnapshot()",
      "boolean Session.isDisableOnExit()"})
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

  /**
   * Test {@link SnapshotManager#setMaxSize(int)}.
   * <p>
   * Method under test: {@link SnapshotManager#setMaxSize(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SnapshotManager.setMaxSize(int)"})
  public void testSetMaxSize() {
    // Arrange and Act
    snapshotManager.setMaxSize(3);

    // Assert
    assertEquals(3, snapshotManager.getMaxSize());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SnapshotManager.disable()", "void SnapshotManager.enable()",
      "int SnapshotManager.getActiveSession()", "CheckTmpStore SnapshotManager.getCheckTmpStore()",
      "List SnapshotManager.getDbs()", "int SnapshotManager.getSize()",
      "void SnapshotManager.setCheckTmpStore(CheckTmpStore)", "void SnapshotManager.setMaxFlushCount(int)",
      "void SnapshotManager.setUnChecked(boolean)", "int SnapshotManager.size()"})
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
}
