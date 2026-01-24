package org.tron.core.vm.program.listener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.common.runtime.vm.DataWord;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class ProgramStorageChangeListenerDiffblueTest {
  @Mock private Map<DataWord, DataWord> map;

  @InjectMocks private ProgramStorageChangeListener programStorageChangeListener;

  /**
   * Test {@link ProgramStorageChangeListener#onStoragePut(DataWord, DataWord)}.
   *
   * <p>Method under test: {@link ProgramStorageChangeListener#onStoragePut(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * <ul>
   *   <li>Given {@link ProgramStorageChangeListener} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProgramStorageChangeListener#getDiff()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProgramStorageChangeListener.getDiff()"})
  public void testGetDiff_givenProgramStorageChangeListener_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new ProgramStorageChangeListener().getDiff().isEmpty());
  }

  /**
   * Test {@link ProgramStorageChangeListener#merge(Map)}.
   *
   * <p>Method under test: {@link ProgramStorageChangeListener#merge(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProgramStorageChangeListener.merge(Map)"})
  public void testMerge() {
    // Arrange
    doNothing().when(map).putAll(Mockito.<Map<DataWord, DataWord>>any());

    // Act
    programStorageChangeListener.merge(new HashMap<>());

    // Assert
    verify(map).putAll(isA(Map.class));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
