package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;
import org.tron.core.vm.program.Program;

public class JumpTableDiffblueTest {
  /**
   * Method under test: {@link JumpTable#get(int)}
   */
  @Test
  public void testGet() {
    // Arrange and Act
    Operation actualGetResult = (new JumpTable()).get(1);

    // Assert
    assertEquals(-1, actualGetResult.getOpcode());
    assertEquals(0, actualGetResult.getRequire());
    assertEquals(0, actualGetResult.getRet());
    assertFalse(actualGetResult.isEnabled());
  }

  /**
   * Method under test: {@link JumpTable#set(Operation)}
   */
  @Test
  public void testSet() {
    // Arrange
    JumpTable jumpTable = new JumpTable();
    Operation op = new Operation(1, 1, 1, mock(Function.class), mock(Consumer.class));

    // Act
    jumpTable.set(op);

    // Assert
    assertSame(op, jumpTable.get(1));
  }

  /**
   * Method under test: default or parameterless constructor of {@link JumpTable}
   */
  @Test
  public void testNewJumpTable() {
    // Arrange, Act and Assert
    Operation getResult = (new JumpTable()).get(1);
    assertEquals(-1, getResult.getOpcode());
    assertEquals(0, getResult.getRequire());
    assertEquals(0, getResult.getRet());
    assertFalse(getResult.isEnabled());
  }
}
