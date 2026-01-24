package org.tron.core.vm.program.listener;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
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
public class CompositeProgramListenerDiffblueTest {
  @InjectMocks private CompositeProgramListener compositeProgramListener;

  @Mock private List<ProgramListener> list;

  /**
   * Test {@link CompositeProgramListener#onMemoryExtend(int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CompositeProgramListener} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onMemoryExtend(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onMemoryExtend(int)"})
  public void testOnMemoryExtend_givenArrayListAddCompositeProgramListener_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new CompositeProgramListener());
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onMemoryExtend(2);

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onMemoryExtend(int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProgramListenerAdaptor} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onMemoryExtend(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onMemoryExtend(int)"})
  public void testOnMemoryExtend_givenArrayListAddProgramListenerAdaptor_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new ProgramListenerAdaptor());
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onMemoryExtend(2);

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onMemoryExtend(int)}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onMemoryExtend(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onMemoryExtend(int)"})
  public void testOnMemoryExtend_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onMemoryExtend(2);

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onMemoryWrite(int, byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CompositeProgramListener} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onMemoryWrite(int, byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onMemoryWrite(int, byte[], int)"})
  public void testOnMemoryWrite_givenArrayListAddCompositeProgramListener_thenCallsIterator()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new CompositeProgramListener());
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onMemoryWrite(19088743, "AXAXAXAX".getBytes("UTF-8"), 3);

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onMemoryWrite(int, byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProgramListenerAdaptor} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onMemoryWrite(int, byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onMemoryWrite(int, byte[], int)"})
  public void testOnMemoryWrite_givenArrayListAddProgramListenerAdaptor_thenCallsIterator()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new ProgramListenerAdaptor());
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onMemoryWrite(19088743, "AXAXAXAX".getBytes("UTF-8"), 3);

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onMemoryWrite(int, byte[], int)}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onMemoryWrite(int, byte[], int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onMemoryWrite(int, byte[], int)"})
  public void testOnMemoryWrite_thenCallsIterator() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onMemoryWrite(19088743, "AXAXAXAX".getBytes("UTF-8"), 3);

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStackPop()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CompositeProgramListener} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStackPop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStackPop()"})
  public void testOnStackPop_givenArrayListAddCompositeProgramListener_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new CompositeProgramListener());
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onStackPop();

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStackPop()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProgramListenerAdaptor} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStackPop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStackPop()"})
  public void testOnStackPop_givenArrayListAddProgramListenerAdaptor_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new ProgramListenerAdaptor());
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onStackPop();

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStackPop()}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStackPop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStackPop()"})
  public void testOnStackPop_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onStackPop();

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStackPush(DataWord)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CompositeProgramListener} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStackPush(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStackPush(DataWord)"})
  public void testOnStackPush_givenArrayListAddCompositeProgramListener_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new CompositeProgramListener());
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onStackPush(DataWord.ZERO());

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStackPush(DataWord)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProgramListenerAdaptor} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStackPush(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStackPush(DataWord)"})
  public void testOnStackPush_givenArrayListAddProgramListenerAdaptor_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new ProgramListenerAdaptor());
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onStackPush(DataWord.ZERO());

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStackPush(DataWord)}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStackPush(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStackPush(DataWord)"})
  public void testOnStackPush_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onStackPush(DataWord.ZERO());

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStackSwap(int, int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CompositeProgramListener} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStackSwap(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStackSwap(int, int)"})
  public void testOnStackSwap_givenArrayListAddCompositeProgramListener_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new CompositeProgramListener());
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onStackSwap(1, 1);

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStackSwap(int, int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProgramListenerAdaptor} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStackSwap(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStackSwap(int, int)"})
  public void testOnStackSwap_givenArrayListAddProgramListenerAdaptor_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new ProgramListenerAdaptor());
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onStackSwap(1, 1);

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStackSwap(int, int)}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStackSwap(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStackSwap(int, int)"})
  public void testOnStackSwap_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onStackSwap(1, 1);

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStoragePut(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CompositeProgramListener} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStoragePut(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStoragePut(DataWord, DataWord)"})
  public void testOnStoragePut_givenArrayListAddCompositeProgramListener_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new CompositeProgramListener());
    when(list.iterator()).thenReturn(programListenerList.iterator());
    DataWord key = DataWord.ZERO();

    // Act
    compositeProgramListener.onStoragePut(key, DataWord.ZERO());

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStoragePut(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProgramListenerAdaptor} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStoragePut(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStoragePut(DataWord, DataWord)"})
  public void testOnStoragePut_givenArrayListAddProgramListenerAdaptor_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new ProgramListenerAdaptor());
    when(list.iterator()).thenReturn(programListenerList.iterator());
    DataWord key = DataWord.ZERO();

    // Act
    compositeProgramListener.onStoragePut(key, DataWord.ZERO());

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStoragePut(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStoragePut(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStoragePut(DataWord, DataWord)"})
  public void testOnStoragePut_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    when(list.iterator()).thenReturn(programListenerList.iterator());
    DataWord key = DataWord.ZERO();

    // Act
    compositeProgramListener.onStoragePut(key, DataWord.ZERO());

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStorageClear()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CompositeProgramListener} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStorageClear()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStorageClear()"})
  public void testOnStorageClear_givenArrayListAddCompositeProgramListener_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new CompositeProgramListener());
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onStorageClear();

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStorageClear()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProgramListenerAdaptor} (default
   *       constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStorageClear()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStorageClear()"})
  public void testOnStorageClear_givenArrayListAddProgramListenerAdaptor_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    programListenerList.add(new ProgramListenerAdaptor());
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onStorageClear();

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#onStorageClear()}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#onStorageClear()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.onStorageClear()"})
  public void testOnStorageClear_thenCallsIterator() {
    // Arrange
    ArrayList<ProgramListener> programListenerList = new ArrayList<>();
    when(list.iterator()).thenReturn(programListenerList.iterator());

    // Act
    compositeProgramListener.onStorageClear();

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link CompositeProgramListener#addListener(ProgramListener)}.
   *
   * <p>Method under test: {@link CompositeProgramListener#addListener(ProgramListener)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.addListener(ProgramListener)"})
  public void testAddListener() {
    // Arrange
    when(list.add(Mockito.<ProgramListener>any())).thenReturn(true);

    // Act
    compositeProgramListener.addListener(new CompositeProgramListener());

    // Assert
    verify(list).add(isA(ProgramListener.class));
  }

  /**
   * Test {@link CompositeProgramListener#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link CompositeProgramListener} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#isEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CompositeProgramListener.isEmpty()"})
  public void testIsEmpty_givenCompositeProgramListener_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new CompositeProgramListener().isEmpty());
  }

  /**
   * Test {@link CompositeProgramListener#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#isEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CompositeProgramListener.isEmpty()"})
  public void testIsEmpty_thenReturnFalse() {
    // Arrange
    CompositeProgramListener compositeProgramListener = new CompositeProgramListener();
    compositeProgramListener.addListener(new CompositeProgramListener());

    // Act and Assert
    assertFalse(compositeProgramListener.isEmpty());
  }

  /**
   * Test new {@link CompositeProgramListener} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CompositeProgramListener}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.<init>()"})
  public void testNewCompositeProgramListener() {
    // Arrange, Act and Assert
    assertTrue(new CompositeProgramListener().isEmpty());
  }
}
