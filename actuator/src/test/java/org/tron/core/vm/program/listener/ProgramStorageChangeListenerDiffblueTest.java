package org.tron.core.vm.program.listener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;

public class ProgramStorageChangeListenerDiffblueTest {
  /**
   * Test {@link ProgramStorageChangeListener#onStoragePut(DataWord, DataWord)}.
   *
   * <p>Method under test: {@link ProgramStorageChangeListener#onStoragePut(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramStorageChangeListener.onStoragePut(DataWord, DataWord)"})
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
   * Test {@link ProgramStorageChangeListener#getDiff()}.
   *
   * <p>Method under test: {@link ProgramStorageChangeListener#getDiff()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map ProgramStorageChangeListener.getDiff()"})
  public void testGetDiff() {
    // Arrange, Act and Assert
    assertTrue(new ProgramStorageChangeListener().getDiff().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ProgramStorageChangeListener}
   *   <li>{@link ProgramStorageChangeListener#onStorageClear()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramStorageChangeListener.<init>()",
    "void ProgramStorageChangeListener.onStorageClear()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ProgramStorageChangeListener actualProgramStorageChangeListener =
        new ProgramStorageChangeListener();
    actualProgramStorageChangeListener.onStorageClear();

    // Assert
    assertTrue(actualProgramStorageChangeListener.getDiff().isEmpty());
  }
}
