package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class OperationRegistryDiffblueTest {
  /**
   * Test {@link OperationRegistry#newTronV10OperationSet()}.
   * <p>
   * Method under test: {@link OperationRegistry#newTronV10OperationSet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JumpTable OperationRegistry.newTronV10OperationSet()"})
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
   * <p>
   * Method under test: {@link OperationRegistry#newTronV11OperationSet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JumpTable OperationRegistry.newTronV11OperationSet()"})
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
   * <p>
   * Method under test: {@link OperationRegistry#newTronV12OperationSet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JumpTable OperationRegistry.newTronV12OperationSet()"})
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
   * <p>
   * Method under test: {@link OperationRegistry#newTronV13OperationSet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JumpTable OperationRegistry.newTronV13OperationSet()"})
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
   * <p>
   * Method under test: {@link OperationRegistry#getTable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JumpTable OperationRegistry.getTable()"})
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
   * <p>
   * Method under test: {@link OperationRegistry#newBaseOperationSet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JumpTable OperationRegistry.newBaseOperationSet()"})
  public void testNewBaseOperationSet() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.newBaseOperationSet().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Test {@link OperationRegistry#appendTransferTrc10Operations(JumpTable)}.
   * <ul>
   *   <li>When {@link JumpTable} {@link JumpTable#set(Operation)} does nothing.</li>
   *   <li>Then calls {@link JumpTable#set(Operation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationRegistry#appendTransferTrc10Operations(JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationRegistry.appendTransferTrc10Operations(JumpTable)"})
  public void testAppendTransferTrc10Operations_whenJumpTableSetDoesNothing_thenCallsSet() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendTransferTrc10Operations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Test {@link OperationRegistry#appendConstantinopleOperations(JumpTable)}.
   * <ul>
   *   <li>When {@link JumpTable} {@link JumpTable#set(Operation)} does nothing.</li>
   *   <li>Then calls {@link JumpTable#set(Operation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationRegistry#appendConstantinopleOperations(JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationRegistry.appendConstantinopleOperations(JumpTable)"})
  public void testAppendConstantinopleOperations_whenJumpTableSetDoesNothing_thenCallsSet() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendConstantinopleOperations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Test {@link OperationRegistry#appendSolidity059Operations(JumpTable)}.
   * <ul>
   *   <li>When {@link JumpTable} {@link JumpTable#set(Operation)} does nothing.</li>
   *   <li>Then calls {@link JumpTable#set(Operation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationRegistry#appendSolidity059Operations(JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationRegistry.appendSolidity059Operations(JumpTable)"})
  public void testAppendSolidity059Operations_whenJumpTableSetDoesNothing_thenCallsSet() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendSolidity059Operations(table);

    // Assert
    verify(table).set(isA(Operation.class));
  }

  /**
   * Test {@link OperationRegistry#appendIstanbulOperations(JumpTable)}.
   * <ul>
   *   <li>When {@link JumpTable} {@link JumpTable#set(Operation)} does nothing.</li>
   *   <li>Then calls {@link JumpTable#set(Operation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationRegistry#appendIstanbulOperations(JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationRegistry.appendIstanbulOperations(JumpTable)"})
  public void testAppendIstanbulOperations_whenJumpTableSetDoesNothing_thenCallsSet() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendIstanbulOperations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Test {@link OperationRegistry#appendFreezeOperations(JumpTable)}.
   * <ul>
   *   <li>When {@link JumpTable} {@link JumpTable#set(Operation)} does nothing.</li>
   *   <li>Then calls {@link JumpTable#set(Operation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationRegistry#appendFreezeOperations(JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationRegistry.appendFreezeOperations(JumpTable)"})
  public void testAppendFreezeOperations_whenJumpTableSetDoesNothing_thenCallsSet() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendFreezeOperations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Test {@link OperationRegistry#appendVoteOperations(JumpTable)}.
   * <ul>
   *   <li>When {@link JumpTable} {@link JumpTable#set(Operation)} does nothing.</li>
   *   <li>Then calls {@link JumpTable#set(Operation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationRegistry#appendVoteOperations(JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationRegistry.appendVoteOperations(JumpTable)"})
  public void testAppendVoteOperations_whenJumpTableSetDoesNothing_thenCallsSet() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendVoteOperations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Test {@link OperationRegistry#appendLondonOperations(JumpTable)}.
   * <ul>
   *   <li>When {@link JumpTable} {@link JumpTable#set(Operation)} does nothing.</li>
   *   <li>Then calls {@link JumpTable#set(Operation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationRegistry#appendLondonOperations(JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationRegistry.appendLondonOperations(JumpTable)"})
  public void testAppendLondonOperations_whenJumpTableSetDoesNothing_thenCallsSet() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendLondonOperations(table);

    // Assert
    verify(table).set(isA(Operation.class));
  }

  /**
   * Test {@link OperationRegistry#adjustMemOperations(JumpTable)}.
   * <ul>
   *   <li>When {@link JumpTable} {@link JumpTable#set(Operation)} does nothing.</li>
   *   <li>Then calls {@link JumpTable#set(Operation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationRegistry#adjustMemOperations(JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationRegistry.adjustMemOperations(JumpTable)"})
  public void testAdjustMemOperations_whenJumpTableSetDoesNothing_thenCallsSet() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.adjustMemOperations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Test {@link OperationRegistry#appendFreezeV2Operations(JumpTable)}.
   * <ul>
   *   <li>When {@link JumpTable} {@link JumpTable#set(Operation)} does nothing.</li>
   *   <li>Then calls {@link JumpTable#set(Operation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationRegistry#appendFreezeV2Operations(JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationRegistry.appendFreezeV2Operations(JumpTable)"})
  public void testAppendFreezeV2Operations_whenJumpTableSetDoesNothing_thenCallsSet() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendFreezeV2Operations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Test {@link OperationRegistry#appendDelegateOperations(JumpTable)}.
   * <ul>
   *   <li>When {@link JumpTable} {@link JumpTable#set(Operation)} does nothing.</li>
   *   <li>Then calls {@link JumpTable#set(Operation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationRegistry#appendDelegateOperations(JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationRegistry.appendDelegateOperations(JumpTable)"})
  public void testAppendDelegateOperations_whenJumpTableSetDoesNothing_thenCallsSet() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendDelegateOperations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Test {@link OperationRegistry#appendShangHaiOperations(JumpTable)}.
   * <ul>
   *   <li>When {@link JumpTable} {@link JumpTable#set(Operation)} does nothing.</li>
   *   <li>Then calls {@link JumpTable#set(Operation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationRegistry#appendShangHaiOperations(JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationRegistry.appendShangHaiOperations(JumpTable)"})
  public void testAppendShangHaiOperations_whenJumpTableSetDoesNothing_thenCallsSet() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendShangHaiOperations(table);

    // Assert
    verify(table).set(isA(Operation.class));
  }

  /**
   * Test {@link OperationRegistry#adjustForFairEnergy(JumpTable)}.
   * <ul>
   *   <li>When {@link JumpTable} {@link JumpTable#set(Operation)} does nothing.</li>
   *   <li>Then calls {@link JumpTable#set(Operation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationRegistry#adjustForFairEnergy(JumpTable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OperationRegistry.adjustForFairEnergy(JumpTable)"})
  public void testAdjustForFairEnergy_whenJumpTableSetDoesNothing_thenCallsSet() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.adjustForFairEnergy(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }
}
