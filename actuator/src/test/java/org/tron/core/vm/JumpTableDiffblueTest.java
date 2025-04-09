package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JumpTableDiffblueTest {
  /**
   * Test new {@link JumpTable} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link JumpTable}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JumpTable.<init>()"})
  public void testNewJumpTable() {
    // Arrange, Act and Assert
    Operation getResult = (new JumpTable()).get(1);
    assertEquals(-1, getResult.getOpcode());
    assertEquals(0, getResult.getRequire());
    assertEquals(0, getResult.getRet());
    assertFalse(getResult.isEnabled());
  }

  /**
   * Test {@link JumpTable#get(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Opcode is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JumpTable#get(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation JumpTable.get(int)"})
  public void testGet_whenOne_thenReturnOpcodeIsMinusOne() {
    // Arrange and Act
    Operation actualGetResult = (new JumpTable()).get(1);

    // Assert
    assertEquals(-1, actualGetResult.getOpcode());
    assertEquals(0, actualGetResult.getRequire());
    assertEquals(0, actualGetResult.getRet());
    assertFalse(actualGetResult.isEnabled());
  }

  /**
   * Test {@link JumpTable#set(Operation)}.
   * <p>
   * Method under test: {@link JumpTable#set(Operation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JumpTable.set(Operation)"})
  public void testSet() {
    // Arrange
    JumpTable jumpTable = new JumpTable();
    Operation op = new Operation(1, 1, 1, mock(Function.class), mock(Consumer.class));

    // Act
    jumpTable.set(op);

    // Assert
    assertSame(op, jumpTable.get(1));
  }
}
