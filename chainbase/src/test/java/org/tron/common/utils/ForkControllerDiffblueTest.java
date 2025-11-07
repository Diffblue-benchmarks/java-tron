package org.tron.common.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tron.core.ChainBaseManager;
import org.tron.core.config.Parameter;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.WitnessScheduleStore;

@ContextConfiguration(classes = {ForkController.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ForkControllerDiffblueTest {
  @Autowired
  private ForkController forkController;

  /**
   * Method under test: {@link ForkController#init(ChainBaseManager)}
   */
  @Test
  public void testInit() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(1);
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    forkController.init(manager);

    // Assert
    verify(manager).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestVersion();
    assertSame(manager, forkController.getManager());
  }

  /**
   * Method under test: {@link ForkController#init(ChainBaseManager)}
   */
  @Test
  public void testInit2() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveLatestVersion(anyInt());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(0);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    forkController.init(manager);

    // Assert
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore).saveLatestVersion(eq(5));
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    assertSame(manager, forkController.getManager());
  }

  /**
   * Method under test: {@link ForkController#init(ChainBaseManager)}
   */
  @Test
  public void testInit3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveLatestVersion(anyInt());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(0);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    forkController.init(manager);

    // Assert
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore).saveLatestVersion(eq(5));
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    assertSame(manager, forkController.getManager());
  }

  /**
   * Method under test: {@link ForkController#init(ChainBaseManager)}
   */
  @Test
  public void testInit4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveLatestVersion(anyInt());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn(null);
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(0);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    forkController.init(manager);

    // Assert
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore).saveLatestVersion(eq(5));
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    assertSame(manager, forkController.getManager());
  }

  /**
   * Method under test: {@link ForkController#init(ChainBaseManager)}
   */
  @Test
  public void testInit5() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveLatestVersion(anyInt());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn(new byte[]{});
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(0);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    forkController.init(manager);

    // Assert
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore).saveLatestVersion(eq(5));
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    assertSame(manager, forkController.getManager());
  }

  /**
   * Method under test: {@link ForkController#init(ChainBaseManager)}
   */
  @Test
  public void testInit6() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveLatestVersion(anyInt());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(0);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(-1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    forkController.init(manager);

    // Assert
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore).saveLatestVersion(eq(0));
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    assertSame(manager, forkController.getManager());
  }

  /**
   * Method under test: {@link ForkController#init(ChainBaseManager)}
   */
  @Test
  public void testInit7() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveLatestVersion(anyInt());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(0);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(Long.MAX_VALUE);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    forkController.init(manager);

    // Assert
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore).saveLatestVersion(eq(5));
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    assertSame(manager, forkController.getManager());
  }

  /**
   * Method under test: {@link ForkController#init(ChainBaseManager)}
   */
  @Test
  public void testInit8() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doThrow(new IllegalStateException("foo")).when(dynamicPropertiesStore).saveLatestVersion(anyInt());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(0);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> forkController.init(manager));
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore).saveLatestVersion(eq(5));
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
  }

  /**
   * Method under test: {@link ForkController#init(ChainBaseManager)}
   */
  @Test
  public void testInit9() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveLatestVersion(anyInt());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(0);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(Long.MAX_VALUE);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    forkController.init(manager);

    // Assert
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore).saveLatestVersion(eq(5));
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    assertSame(manager, forkController.getManager());
  }

  /**
   * Method under test: {@link ForkController#init(ChainBaseManager)}
   */
  @Test
  public void testInit10() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveLatestVersion(anyInt());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn(null);
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(0);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(Long.MAX_VALUE);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    forkController.init(manager);

    // Assert
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore).saveLatestVersion(eq(5));
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    assertSame(manager, forkController.getManager());
  }

  /**
   * Method under test: {@link ForkController#init(ChainBaseManager)}
   */
  @Test
  public void testInit11() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveLatestVersion(anyInt());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn(new byte[]{});
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(0);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(Long.MAX_VALUE);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    // Act
    forkController.init(manager);

    // Assert
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore).saveLatestVersion(eq(5));
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    assertSame(manager, forkController.getManager());
  }

  /**
   * Method under test: {@link ForkController#pass(int)}
   */
  @Test
  public void testPass() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ForkController.instance().pass(1));
    assertThrows(IllegalStateException.class,
        () -> ForkController.instance().pass(Parameter.ForkBlockVersionEnum.ENERGY_LIMIT));
  }

  /**
   * Method under test: {@link ForkController#reset()}
   */
  @Test
  public void testReset() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).statsByVersion(anyInt(), Mockito.<byte[]>any());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(1);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    WitnessScheduleStore witnessScheduleStore = mock(WitnessScheduleStore.class);
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getWitnessScheduleStore()).thenReturn(witnessScheduleStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ForkController forkController = new ForkController();
    forkController.init(manager);

    // Act
    forkController.reset();

    // Assert that nothing has changed
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(manager).getWitnessScheduleStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt(), Mockito.<byte[]>any());
    verify(witnessScheduleStore).getActiveWitnesses();
  }

  /**
   * Method under test: {@link ForkController#reset()}
   */
  @Test
  public void testReset2() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doThrow(new IllegalStateException("foo")).when(dynamicPropertiesStore)
        .statsByVersion(anyInt(), Mockito.<byte[]>any());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(1);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    WitnessScheduleStore witnessScheduleStore = mock(WitnessScheduleStore.class);
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getWitnessScheduleStore()).thenReturn(witnessScheduleStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ForkController forkController = new ForkController();
    forkController.init(manager);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> forkController.reset());
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(manager).getWitnessScheduleStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    verify(dynamicPropertiesStore).statsByVersion(eq(6), isA(byte[].class));
    verify(witnessScheduleStore).getActiveWitnesses();
  }

  /**
   * Method under test: {@link ForkController#reset()}
   */
  @Test
  public void testReset3() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).statsByVersion(anyInt(), Mockito.<byte[]>any());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(1);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    WitnessScheduleStore witnessScheduleStore = mock(WitnessScheduleStore.class);
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getWitnessScheduleStore()).thenReturn(witnessScheduleStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ForkController forkController = new ForkController();
    forkController.init(manager);

    // Act
    forkController.reset();

    // Assert that nothing has changed
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(manager).getWitnessScheduleStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt(), Mockito.<byte[]>any());
    verify(witnessScheduleStore).getActiveWitnesses();
  }

  /**
   * Method under test: {@link ForkController#reset()}
   */
  @Test
  public void testReset4() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn(null);
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(1);
    WitnessScheduleStore witnessScheduleStore = mock(WitnessScheduleStore.class);
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getWitnessScheduleStore()).thenReturn(witnessScheduleStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ForkController forkController = new ForkController();
    forkController.init(manager);

    // Act
    forkController.reset();

    // Assert that nothing has changed
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(manager).getWitnessScheduleStore();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    verify(witnessScheduleStore).getActiveWitnesses();
  }

  /**
   * Method under test: {@link ForkController#reset()}
   */
  @Test
  public void testReset5() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).statsByVersion(anyInt(), Mockito.<byte[]>any());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn(new byte[]{});
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(1);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    WitnessScheduleStore witnessScheduleStore = mock(WitnessScheduleStore.class);
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getWitnessScheduleStore()).thenReturn(witnessScheduleStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ForkController forkController = new ForkController();
    forkController.init(manager);

    // Act
    forkController.reset();

    // Assert that nothing has changed
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(manager).getWitnessScheduleStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt(), Mockito.<byte[]>any());
    verify(witnessScheduleStore).getActiveWitnesses();
  }

  /**
   * Method under test: {@link ForkController#reset()}
   */
  @Test
  public void testReset6() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).statsByVersion(anyInt(), Mockito.<byte[]>any());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(1);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(-1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(1L);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    WitnessScheduleStore witnessScheduleStore = mock(WitnessScheduleStore.class);
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getWitnessScheduleStore()).thenReturn(witnessScheduleStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ForkController forkController = new ForkController();
    forkController.init(manager);

    // Act
    forkController.reset();

    // Assert that nothing has changed
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(manager).getWitnessScheduleStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt(), Mockito.<byte[]>any());
    verify(witnessScheduleStore).getActiveWitnesses();
  }

  /**
   * Method under test: {@link ForkController#reset()}
   */
  @Test
  public void testReset7() throws UnsupportedEncodingException {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).statsByVersion(anyInt(), Mockito.<byte[]>any());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(1);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(Long.MAX_VALUE);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    WitnessScheduleStore witnessScheduleStore = mock(WitnessScheduleStore.class);
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getWitnessScheduleStore()).thenReturn(witnessScheduleStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ForkController forkController = new ForkController();
    forkController.init(manager);

    // Act
    forkController.reset();

    // Assert that nothing has changed
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(manager).getWitnessScheduleStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt(), Mockito.<byte[]>any());
    verify(witnessScheduleStore).getActiveWitnesses();
  }

  /**
   * Method under test: {@link ForkController#reset()}
   */
  @Test
  public void testReset8() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).statsByVersion(anyInt(), Mockito.<byte[]>any());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(1);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(Long.MAX_VALUE);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    WitnessScheduleStore witnessScheduleStore = mock(WitnessScheduleStore.class);
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getWitnessScheduleStore()).thenReturn(witnessScheduleStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ForkController forkController = new ForkController();
    forkController.init(manager);

    // Act
    forkController.reset();

    // Assert that nothing has changed
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(manager).getWitnessScheduleStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt(), Mockito.<byte[]>any());
    verify(witnessScheduleStore).getActiveWitnesses();
  }

  /**
   * Method under test: {@link ForkController#reset()}
   */
  @Test
  public void testReset9() {
    // Arrange
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).statsByVersion(anyInt(), Mockito.<byte[]>any());
    when(dynamicPropertiesStore.statsByVersion(anyInt())).thenReturn(new byte[]{});
    when(dynamicPropertiesStore.getLatestVersion()).thenReturn(1);
    when(dynamicPropertiesStore.getLatestBlockHeaderNumber()).thenReturn(1L);
    when(dynamicPropertiesStore.getLatestBlockHeaderTimestamp()).thenReturn(Long.MAX_VALUE);
    when(dynamicPropertiesStore.getMaintenanceTimeInterval()).thenReturn(42L);
    WitnessScheduleStore witnessScheduleStore = mock(WitnessScheduleStore.class);
    when(witnessScheduleStore.getActiveWitnesses()).thenReturn(new ArrayList<>());
    ChainBaseManager manager = mock(ChainBaseManager.class);
    when(manager.getWitnessScheduleStore()).thenReturn(witnessScheduleStore);
    when(manager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);

    ForkController forkController = new ForkController();
    forkController.init(manager);

    // Act
    forkController.reset();

    // Assert that nothing has changed
    verify(manager, atLeast(1)).getDynamicPropertiesStore();
    verify(manager).getWitnessScheduleStore();
    verify(dynamicPropertiesStore).getLatestBlockHeaderNumber();
    verify(dynamicPropertiesStore, atLeast(1)).getLatestBlockHeaderTimestamp();
    verify(dynamicPropertiesStore).getLatestVersion();
    verify(dynamicPropertiesStore, atLeast(1)).getMaintenanceTimeInterval();
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt());
    verify(dynamicPropertiesStore, atLeast(1)).statsByVersion(anyInt(), Mockito.<byte[]>any());
    verify(witnessScheduleStore).getActiveWitnesses();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ForkController}
   *   <li>{@link ForkController#getManager()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new ForkController()).getManager());
  }

  /**
   * Method under test: {@link ForkController#instance()}
   */
  @Test
  public void testInstance() {
    // Arrange, Act and Assert
    assertNull(ForkController.instance().getManager());
  }
}
