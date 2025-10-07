package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.EmptyStackException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.vm.program.listener.CompositeProgramListener;
import org.tron.core.vm.program.listener.ProgramListener;

public class StackDiffblueTest {
  /**
   * Test {@link Stack#pop()}.
   *
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.
   *   <li>Then {@link Stack} (default constructor) Empty.
   * </ul>
   *
   * <p>Method under test: {@link Stack#pop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Stack.pop()"})
  public void testPop_givenStackAddZero_thenStackEmpty() {
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
   * Test {@link Stack#pop()}.
   *
   * <ul>
   *   <li>Given {@link Stack} (default constructor).
   *   <li>Then throw {@link EmptyStackException}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#pop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Stack.pop()"})
  public void testPop_givenStack_thenThrowEmptyStackException() {
    // Arrange, Act and Assert
    assertThrows(EmptyStackException.class, () -> new Stack().pop());
  }

  /**
   * Test {@link Stack#pop()}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyStackException}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#pop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Stack.pop()"})
  public void testPop_thenThrowEmptyStackException() {
    // Arrange
    Stack stack = new Stack();
    stack.setProgramListener(new CompositeProgramListener());

    // Act and Assert
    assertThrows(EmptyStackException.class, () -> stack.pop());
  }

  /**
   * Test {@link Stack#push(DataWord)} with {@code DataWord}.
   *
   * <ul>
   *   <li>Given {@link Stack} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Stack#push(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Stack.push(DataWord)"})
  public void testPushWithDataWord_givenStack() {
    // Arrange
    Stack stack = new Stack();

    // Act
    DataWord actualPushResult = stack.push(DataWord.ZERO());

    // Assert
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualPushResult.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualPushResult.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualPushResult.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualPushResult.getData());
  }

  /**
   * Test {@link Stack#push(DataWord)} with {@code DataWord}.
   *
   * <ul>
   *   <li>Then return Last20Bytes is array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link Stack#push(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Stack.push(DataWord)"})
  public void testPushWithDataWord_thenReturnLast20BytesIsArrayOfByteWithZeroAndZero() {
    // Arrange
    Stack stack = new Stack();
    stack.setProgramListener(new CompositeProgramListener());

    // Act
    DataWord actualPushResult = stack.push(DataWord.ZERO());

    // Assert
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualPushResult.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualPushResult.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualPushResult.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualPushResult.getData());
  }

  /**
   * Test {@link Stack#swap(int, int)}.
   *
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.
   *   <li>When one.
   *   <li>Then {@link Stack} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link Stack#swap(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.swap(int, int)"})
  public void testSwap_givenStackAddZero_whenOne_thenStackSizeIsTwo() {
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
   * Test {@link Stack#swap(int, int)}.
   *
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.
   *   <li>When two.
   *   <li>Then {@link Stack} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link Stack#swap(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.swap(int, int)"})
  public void testSwap_givenStackAddZero_whenTwo_thenStackSizeIsTwo() {
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
   * Test {@link Stack#swap(int, int)}.
   *
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add ZERO.
   *   <li>When zero.
   *   <li>Then {@link Stack} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link Stack#swap(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.swap(int, int)"})
  public void testSwap_givenStackAddZero_whenZero_thenStackSizeIsTwo() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());
    DataWord ZEROResult = DataWord.ZERO();
    stack.add(ZEROResult);

    // Act
    stack.swap(0, 1);

    // Assert
    assertEquals(2, stack.size());
    assertSame(ZEROResult, stack.get(0));
  }

  /**
   * Test {@link Stack#equals(Object)}, and {@link Stack#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Stack#equals(Object)}
   *   <li>{@link Stack#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Stack stack = new Stack();
    Stack stack2 = new Stack();

    // Act and Assert
    assertEquals(stack, stack2);
    assertEquals(stack.hashCode(), stack2.hashCode());
  }

  /**
   * Test {@link Stack#equals(Object)}, and {@link Stack#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Stack#equals(Object)}
   *   <li>{@link Stack#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Stack stack = new Stack();

    // Act and Assert
    assertEquals(stack, stack);
    int expectedHashCodeResult = stack.hashCode();
    assertEquals(expectedHashCodeResult, stack.hashCode());
  }

  /**
   * Test {@link Stack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Stack#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Stack stack = new Stack();
    stack.add(DataWord.ZERO());

    // Act and Assert
    assertNotEquals(stack, new Stack());
  }

  /**
   * Test {@link Stack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Stack#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Stack(), null);
  }

  /**
   * Test {@link Stack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Stack#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Stack(), "Different type to Stack");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Stack}
   *   <li>{@link Stack#setProgramListener(ProgramListener)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.<init>()", "void Stack.setProgramListener(ProgramListener)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Stack actualStack = new Stack();
    actualStack.setProgramListener(new CompositeProgramListener());

    // Assert
    assertTrue(actualStack.isEmpty());
  }
}
