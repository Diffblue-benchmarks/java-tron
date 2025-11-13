package org.tron.core.db2.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.db2.ISession;
import org.tron.core.db2.core.SnapshotManager.Session;
import org.tron.core.exception.RevokingStoreIllegalStateException;
import org.tron.core.store.CheckTmpStore;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SnapshotManagerDiffblueTest {
  /**
   * Test {@link SnapshotManager#SnapshotManager(String)}.
   *
   * <p>Method under test: {@link SnapshotManager#SnapshotManager(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link SnapshotManager#buildSession()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ISession SnapshotManager.buildSession()"})
  public void testBuildSession() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");

    // Act
    ISession actualBuildSessionResult = snapshotManager.buildSession();

    // Assert
    assertTrue(actualBuildSessionResult instanceof Session);
    assertFalse(((Session) actualBuildSessionResult).isDisableOnExit());
    assertTrue(((Session) actualBuildSessionResult).isApplySnapshot());
    assertSame(snapshotManager, ((Session) actualBuildSessionResult).getSnapshotManager());
  }

  /**
   * Test {@link SnapshotManager#buildSession(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link SnapshotManager#buildSession(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ISession SnapshotManager.buildSession(boolean)"})
  public void testBuildSessionWithBoolean() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");

    // Act
    ISession actualBuildSessionResult = snapshotManager.buildSession(false);

    // Assert
    assertTrue(actualBuildSessionResult instanceof Session);
    assertEquals(0, snapshotManager.getActiveSession());
    SnapshotManager snapshotManager2 = ((Session) actualBuildSessionResult).getSnapshotManager();
    assertEquals(0, snapshotManager2.getActiveSession());
    assertEquals(256, snapshotManager2.getMaxSize());
    assertFalse(((Session) actualBuildSessionResult).isDisableOnExit());
  }

  /**
   * Test {@link SnapshotManager#buildSession(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link SnapshotManager#buildSession(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ISession SnapshotManager.buildSession(boolean)"})
  public void testBuildSessionWithBoolean2() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");
    snapshotManager.setUnChecked(false);
    snapshotManager.setMaxSize(-1);

    // Act
    ISession actualBuildSessionResult = snapshotManager.buildSession(true);

    // Assert
    assertTrue(actualBuildSessionResult instanceof Session);
    SnapshotManager snapshotManager2 = ((Session) actualBuildSessionResult).getSnapshotManager();
    assertEquals(-1, snapshotManager2.getMaxSize());
    assertEquals(0, snapshotManager.getSize());
    assertEquals(0, snapshotManager2.getSize());
    assertEquals(0, snapshotManager.size());
    assertEquals(0, snapshotManager2.size());
    assertEquals(1, snapshotManager.getActiveSession());
    assertEquals(1, snapshotManager2.getActiveSession());
    assertTrue(((Session) actualBuildSessionResult).isDisableOnExit());
  }

  /**
   * Test {@link SnapshotManager#buildSession(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link SnapshotManager#buildSession(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ISession SnapshotManager.buildSession(boolean)"})
  public void testBuildSessionWithBoolean3() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");
    snapshotManager.setMaxFlushCount(3);
    snapshotManager.setUnChecked(false);
    snapshotManager.setMaxSize(-1);

    // Act
    ISession actualBuildSessionResult = snapshotManager.buildSession(true);

    // Assert
    assertTrue(actualBuildSessionResult instanceof Session);
    SnapshotManager snapshotManager2 = ((Session) actualBuildSessionResult).getSnapshotManager();
    assertEquals(-1, snapshotManager2.getMaxSize());
    assertEquals(0, snapshotManager.getSize());
    assertEquals(0, snapshotManager2.getSize());
    assertEquals(0, snapshotManager.size());
    assertEquals(0, snapshotManager2.size());
    assertEquals(1, snapshotManager.getActiveSession());
    assertEquals(1, snapshotManager2.getActiveSession());
    assertTrue(((Session) actualBuildSessionResult).isDisableOnExit());
  }

  /**
   * Test {@link SnapshotManager#buildSession(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Then return SnapshotManager MaxSize is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SnapshotManager#buildSession(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ISession SnapshotManager.buildSession(boolean)"})
  public void testBuildSessionWithBoolean_thenReturnSnapshotManagerMaxSizeIsMinusOne() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");
    snapshotManager.setMaxSize(-1);

    // Act
    ISession actualBuildSessionResult = snapshotManager.buildSession(true);

    // Assert
    assertTrue(actualBuildSessionResult instanceof Session);
    SnapshotManager snapshotManager2 = ((Session) actualBuildSessionResult).getSnapshotManager();
    assertEquals(-1, snapshotManager2.getMaxSize());
    assertEquals(0, snapshotManager.getSize());
    assertEquals(0, snapshotManager2.getSize());
    assertEquals(0, snapshotManager.size());
    assertEquals(0, snapshotManager2.size());
    assertEquals(1, snapshotManager.getActiveSession());
    assertEquals(1, snapshotManager2.getActiveSession());
    assertTrue(((Session) actualBuildSessionResult).isDisableOnExit());
  }

  /**
   * Test {@link SnapshotManager#buildSession(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Then {@link SnapshotManager#SnapshotManager(String)} with {@code Checkpoint Path} Size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link SnapshotManager#buildSession(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ISession SnapshotManager.buildSession(boolean)"})
  public void testBuildSessionWithBoolean_thenSnapshotManagerWithCheckpointPathSizeIsOne() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");

    // Act
    ISession actualBuildSessionResult = snapshotManager.buildSession(true);

    // Assert
    assertTrue(actualBuildSessionResult instanceof Session);
    assertEquals(1, snapshotManager.getSize());
    SnapshotManager snapshotManager2 = ((Session) actualBuildSessionResult).getSnapshotManager();
    assertEquals(1, snapshotManager2.getSize());
    assertEquals(1, snapshotManager.size());
    assertEquals(1, snapshotManager2.size());
  }

  /**
   * Test {@link SnapshotManager#merge()}.
   *
   * <p>Method under test: {@link SnapshotManager#merge()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnapshotManager.merge()"})
  public void testMerge() {
    // Arrange, Act and Assert
    assertThrows(
        RevokingStoreIllegalStateException.class,
        () -> new SnapshotManager("Checkpoint Path").merge());
  }

  /**
   * Test {@link SnapshotManager#commit()}.
   *
   * <p>Method under test: {@link SnapshotManager#commit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnapshotManager.commit()"})
  public void testCommit() {
    // Arrange, Act and Assert
    assertThrows(
        RevokingStoreIllegalStateException.class,
        () -> new SnapshotManager("Checkpoint Path").commit());
  }

  /**
   * Test {@link SnapshotManager#pop()}.
   *
   * <p>Method under test: {@link SnapshotManager#pop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnapshotManager.pop()"})
  public void testPop() {
    // Arrange, Act and Assert
    assertThrows(
        RevokingStoreIllegalStateException.class,
        () -> new SnapshotManager("Checkpoint Path").pop());
  }

  /**
   * Test {@link SnapshotManager#fastPop()}.
   *
   * <p>Method under test: {@link SnapshotManager#fastPop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnapshotManager.fastPop()"})
  public void testFastPop() {
    // Arrange, Act and Assert
    assertThrows(
        RevokingStoreIllegalStateException.class,
        () -> new SnapshotManager("Checkpoint Path").fastPop());
  }

  /**
   * Test {@link SnapshotManager#getMaxSize()}.
   *
   * <p>Method under test: {@link SnapshotManager#getMaxSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SnapshotManager.getMaxSize()"})
  public void testGetMaxSize() {
    // Arrange, Act and Assert
    assertEquals(256, new SnapshotManager("Checkpoint Path").getMaxSize());
  }

  /**
   * Test Session {@link Session#close()}.
   *
   * <ul>
   *   <li>Given {@link Session#Session(SnapshotManager)} with {@link SnapshotManager}.
   *   <li>Then calls {@link SnapshotManager#revoke()}.
   * </ul>
   *
   * <p>Method under test: {@link Session#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Session.close()"})
  public void testSessionClose_givenSessionWithSnapshotManager_thenCallsRevoke() {
    // Arrange
    SnapshotManager snapshotManager = mock(SnapshotManager.class);
    doNothing().when(snapshotManager).revoke();
    try (Session session = new Session(snapshotManager)) {}

    // Act and Assert
    verify(snapshotManager).revoke();
  }

  /**
   * Test Session {@link Session#close()}.
   *
   * <ul>
   *   <li>Given {@link SnapshotManager} {@link SnapshotManager#disable()} does nothing.
   *   <li>Then calls {@link SnapshotManager#disable()}.
   * </ul>
   *
   * <p>Method under test: {@link Session#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Session.close()"})
  public void testSessionClose_givenSnapshotManagerDisableDoesNothing_thenCallsDisable() {
    // Arrange
    SnapshotManager snapshotManager = mock(SnapshotManager.class);
    doNothing().when(snapshotManager).disable();
    doNothing().when(snapshotManager).revoke();
    try (Session session = new Session(snapshotManager, true)) {}

    // Act and Assert
    verify(snapshotManager).disable();
    verify(snapshotManager).revoke();
  }

  /**
   * Test Session {@link Session#commit()}.
   *
   * <ul>
   *   <li>Then not {@link Session#Session(SnapshotManager)} with {@link SnapshotManager}
   *       ApplySnapshot.
   * </ul>
   *
   * <p>Method under test: {@link Session#commit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Session.commit()"})
  public void testSessionCommit_thenNotSessionWithSnapshotManagerApplySnapshot() {
    // Arrange
    SnapshotManager snapshotManager = mock(SnapshotManager.class);
    doNothing().when(snapshotManager).commit();
    Session session = new Session(snapshotManager);

    // Act
    session.commit();

    // Assert
    verify(snapshotManager).commit();
    assertFalse(session.isApplySnapshot());
  }

  /**
   * Test Session {@link Session#destroy()}.
   *
   * <ul>
   *   <li>Given {@link Session#Session(SnapshotManager)} with {@link SnapshotManager}.
   *   <li>Then calls {@link SnapshotManager#revoke()}.
   * </ul>
   *
   * <p>Method under test: {@link Session#destroy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Session.destroy()"})
  public void testSessionDestroy_givenSessionWithSnapshotManager_thenCallsRevoke() {
    // Arrange
    SnapshotManager snapshotManager = mock(SnapshotManager.class);
    doNothing().when(snapshotManager).revoke();

    // Act
    new Session(snapshotManager).destroy();

    // Assert
    verify(snapshotManager).revoke();
  }

  /**
   * Test Session {@link Session#destroy()}.
   *
   * <ul>
   *   <li>Given {@link SnapshotManager} {@link SnapshotManager#disable()} does nothing.
   *   <li>Then calls {@link SnapshotManager#disable()}.
   * </ul>
   *
   * <p>Method under test: {@link Session#destroy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Session.destroy()"})
  public void testSessionDestroy_givenSnapshotManagerDisableDoesNothing_thenCallsDisable() {
    // Arrange
    SnapshotManager snapshotManager = mock(SnapshotManager.class);
    doNothing().when(snapshotManager).disable();
    doNothing().when(snapshotManager).revoke();

    // Act
    new Session(snapshotManager, true).destroy();

    // Assert
    verify(snapshotManager).disable();
    verify(snapshotManager).revoke();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

  /**
   * Test Session {@link Session#merge()}.
   *
   * <ul>
   *   <li>Then not {@link Session#Session(SnapshotManager)} with {@link SnapshotManager}
   *       ApplySnapshot.
   * </ul>
   *
   * <p>Method under test: {@link Session#merge()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Session.merge()"})
  public void testSessionMerge_thenNotSessionWithSnapshotManagerApplySnapshot() {
    // Arrange
    SnapshotManager snapshotManager = mock(SnapshotManager.class);
    doNothing().when(snapshotManager).merge();
    Session session = new Session(snapshotManager);

    // Act
    session.merge();

    // Assert
    verify(snapshotManager).merge();
    assertFalse(session.isApplySnapshot());
  }

  /**
   * Test Session {@link Session#revoke()}.
   *
   * <p>Method under test: {@link Session#revoke()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Session.revoke()"})
  public void testSessionRevoke() {
    // Arrange
    Session session = new Session(new SnapshotManager("Checkpoint Path"));

    // Act
    session.revoke();

    // Assert
    assertFalse(session.isApplySnapshot());
  }

  /**
   * Test {@link SnapshotManager#setMaxSize(int)}.
   *
   * <p>Method under test: {@link SnapshotManager#setMaxSize(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnapshotManager.setMaxSize(int)"})
  public void testSetMaxSize() {
    // Arrange
    SnapshotManager snapshotManager = new SnapshotManager("Checkpoint Path");

    // Act
    snapshotManager.setMaxSize(3);

    // Assert
    assertEquals(3, snapshotManager.getMaxSize());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
}
