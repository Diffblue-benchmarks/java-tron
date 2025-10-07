package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OperationRegistryDiffblueTest {
  /**
   * Test {@link OperationRegistry#newTronV10OperationSet()}.
   *
   * <p>Method under test: {@link OperationRegistry#newTronV10OperationSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.vm.JumpTable OperationRegistry.newTronV10OperationSet()"})
  public void testNewTronV10OperationSet() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.newTronV10OperationSet().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Test {@link OperationRegistry#newTronV11OperationSet()}.
   *
   * <p>Method under test: {@link OperationRegistry#newTronV11OperationSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.vm.JumpTable OperationRegistry.newTronV11OperationSet()"})
  public void testNewTronV11OperationSet() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.newTronV11OperationSet().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Test {@link OperationRegistry#newTronV12OperationSet()}.
   *
   * <p>Method under test: {@link OperationRegistry#newTronV12OperationSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.vm.JumpTable OperationRegistry.newTronV12OperationSet()"})
  public void testNewTronV12OperationSet() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.newTronV12OperationSet().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Test {@link OperationRegistry#newTronV13OperationSet()}.
   *
   * <p>Method under test: {@link OperationRegistry#newTronV13OperationSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.vm.JumpTable OperationRegistry.newTronV13OperationSet()"})
  public void testNewTronV13OperationSet() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.newTronV13OperationSet().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Test {@link OperationRegistry#getTable()}.
   *
   * <p>Method under test: {@link OperationRegistry#getTable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.vm.JumpTable OperationRegistry.getTable()"})
  public void testGetTable() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.getTable().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Test {@link OperationRegistry#newBaseOperationSet()}.
   *
   * <p>Method under test: {@link OperationRegistry#newBaseOperationSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.tron.core.vm.JumpTable OperationRegistry.newBaseOperationSet()"})
  public void testNewBaseOperationSet() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.newBaseOperationSet().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }
}
