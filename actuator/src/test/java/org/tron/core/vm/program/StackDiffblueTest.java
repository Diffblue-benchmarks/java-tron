package org.tron.core.vm.program;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.vm.program.listener.CompositeProgramListener;
import org.tron.core.vm.program.listener.ProgramListener;

public class StackDiffblueTest {
  /**
   * Method under test: {@link Stack#pop()}
   */
  @Test
  public void testPop() {
    // Arrange
    Stack stack = new Stack();
    DataWord ZEROResult = DataWord.ZERO();
    stack.add(ZEROResult);

    // Act
    DataWord actualPopResult = stack.pop();

    // Assert
    assertTrue(stack.isEmpty());
    assertSame(ZEROResult, actualPopResult);
  }

  /**
   * Method under test: {@link Stack#push(DataWord)}
   */
  @Test
  public void testPush() {
    // Arrange
    Stack stack = new Stack();
    DataWord item = DataWord.ZERO();

    // Act
    DataWord actualPushResult = stack.push(item);

    // Assert
    assertEquals(1, stack.size());
    assertSame(item, stack.get(0));
    assertSame(item, actualPushResult);
  }

  /**
   * Method under test: {@link Stack#push(DataWord)}
   */
  @Test
  public void testPush2() {
    // Arrange
    Stack stack = new Stack();
    stack.setProgramListener(new CompositeProgramListener());
    DataWord item = DataWord.ZERO();

    // Act
    DataWord actualPushResult = stack.push(item);

    // Assert
    assertEquals(1, stack.size());
    assertSame(item, stack.get(0));
    assertSame(item, actualPushResult);
  }

  /**
   * Method under test: {@link Stack#swap(int, int)}
   */
  @Test
  public void testSwap() {
    // Arrange
    Stack stack = new Stack();

    // Act
    stack.swap(1, 1);

    // Assert that nothing has changed
    assertTrue(stack.isEmpty());
  }

  /**
   * Method under test: {@link Stack#swap(int, int)}
   */
  @Test
  public void testSwap2() {
    // Arrange
    Stack stack = new Stack();
    stack.setProgramListener(null);

    // Act
    stack.swap(-1, 0);

    // Assert that nothing has changed
    assertTrue(stack.isEmpty());
  }

  /**
   * Method under test: {@link Stack#swap(int, int)}
   */
  @Test
  public void testSwap3() {
    // Arrange
    Stack stack = new Stack();
    DataWord ZEROResult = DataWord.ZERO();
    stack.add(ZEROResult);
    stack.add(DataWord.ZERO());

    // Act
    stack.swap(1, 1);

    // Assert that nothing has changed
    assertEquals(2, stack.size());
    assertSame(ZEROResult, stack.get(0));
  }

  /**
   * Method under test: {@link Stack#swap(int, int)}
   */
  @Test
  public void testSwap4() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    DataWord ZEROResult = DataWord.ZERO();
    stack.add(ZEROResult);

    // Act
    stack.swap(0, 1);

    // Assert that nothing has changed
    assertEquals(2, stack.size());
    assertSame(ZEROResult, stack.get(0));
  }

  /**
   * Method under test: {@link Stack#swap(int, int)}
   */
  @Test
  public void testSwap5() {
    // Arrange
    Stack stack = new Stack();
    DataWord ZEROResult = DataWord.ZERO();
    stack.add(ZEROResult);
    stack.add(DataWord.ZERO());

    // Act
    stack.swap(1, 2);

    // Assert that nothing has changed
    assertEquals(2, stack.size());
    assertSame(ZEROResult, stack.get(0));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Stack#equals(Object)}
   *   <li>{@link Stack#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Stack stack = new Stack();
    Stack stack2 = new Stack();

    // Act and Assert
    assertEquals(stack, stack2);
    int expectedHashCodeResult = stack.hashCode();
    assertEquals(expectedHashCodeResult, stack2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Stack#equals(Object)}
   *   <li>{@link Stack#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Stack stack = new Stack();

    // Act and Assert
    assertEquals(stack, stack);
    int expectedHashCodeResult = stack.hashCode();
    assertEquals(expectedHashCodeResult, stack.hashCode());
  }

  /**
   * Method under test: {@link Stack#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());

    // Act and Assert
    assertNotEquals(stack, new Stack());
  }

  /**
   * Method under test: {@link Stack#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Stack stack = new Stack();
    stack.add(mock(DataWord.class));

    // Act and Assert
    assertNotEquals(stack, new Stack());
  }

  /**
   * Method under test: {@link Stack#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Stack(), null);
  }

  /**
   * Method under test: {@link Stack#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Stack(), "Different type to Stack");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Stack}
   *   <li>{@link Stack#setProgramListener(ProgramListener)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Stack actualStack = new Stack();
    actualStack.setProgramListener(new CompositeProgramListener());

    // Assert
    assertTrue(actualStack.isEmpty());
  }
}
