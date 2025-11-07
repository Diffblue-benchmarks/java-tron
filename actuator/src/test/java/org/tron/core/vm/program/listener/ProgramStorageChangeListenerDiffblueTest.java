package org.tron.core.vm.program.listener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.tron.common.runtime.vm.DataWord;

public class ProgramStorageChangeListenerDiffblueTest {
  /**
   * Method under test:
   * {@link ProgramStorageChangeListener#onStoragePut(DataWord, DataWord)}
   */
  @Test
  public void testOnStoragePut() {
    // Arrange
    ProgramStorageChangeListener programStorageChangeListener = new ProgramStorageChangeListener();
    DataWord key = DataWord.ZERO();

    // Act
    programStorageChangeListener.onStoragePut(key, DataWord.ZERO());

    // Assert
    assertEquals(1, programStorageChangeListener.getDiff().size());
  }

  /**
   * Method under test: {@link ProgramStorageChangeListener#getDiff()}
   */
  @Test
  public void testGetDiff() {
    // Arrange, Act and Assert
    assertTrue((new ProgramStorageChangeListener()).getDiff().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ProgramStorageChangeListener}
   *   <li>{@link ProgramStorageChangeListener#onStorageClear()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProgramStorageChangeListener actualProgramStorageChangeListener = new ProgramStorageChangeListener();
    actualProgramStorageChangeListener.onStorageClear();

    // Assert that nothing has changed
    assertTrue(actualProgramStorageChangeListener.getDiff().isEmpty());
  }
}
