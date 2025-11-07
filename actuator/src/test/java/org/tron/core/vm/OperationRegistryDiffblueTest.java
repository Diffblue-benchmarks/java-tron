package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.mockito.Mockito;

public class OperationRegistryDiffblueTest {
  /**
   * Method under test: {@link OperationRegistry#newTronV10OperationSet()}
   */
  @Test
  public void testNewTronV10OperationSet() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.newTronV10OperationSet().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Method under test: {@link OperationRegistry#newTronV11OperationSet()}
   */
  @Test
  public void testNewTronV11OperationSet() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.newTronV11OperationSet().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Method under test: {@link OperationRegistry#newTronV12OperationSet()}
   */
  @Test
  public void testNewTronV12OperationSet() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.newTronV12OperationSet().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Method under test: {@link OperationRegistry#newTronV13OperationSet()}
   */
  @Test
  public void testNewTronV13OperationSet() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.newTronV13OperationSet().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Method under test: {@link OperationRegistry#getTable()}
   */
  @Test
  public void testGetTable() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.getTable().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Method under test: {@link OperationRegistry#newBaseOperationSet()}
   */
  @Test
  public void testNewBaseOperationSet() {
    // Arrange, Act and Assert
    Operation getResult = OperationRegistry.newBaseOperationSet().get(1);
    assertEquals(1, getResult.getOpcode());
    assertEquals(1, getResult.getRet());
    assertEquals(2, getResult.getRequire());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Method under test:
   * {@link OperationRegistry#appendTransferTrc10Operations(JumpTable)}
   */
  @Test
  public void testAppendTransferTrc10Operations() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendTransferTrc10Operations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Method under test:
   * {@link OperationRegistry#appendConstantinopleOperations(JumpTable)}
   */
  @Test
  public void testAppendConstantinopleOperations() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendConstantinopleOperations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Method under test:
   * {@link OperationRegistry#appendSolidity059Operations(JumpTable)}
   */
  @Test
  public void testAppendSolidity059Operations() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendSolidity059Operations(table);

    // Assert
    verify(table).set(isA(Operation.class));
  }

  /**
   * Method under test:
   * {@link OperationRegistry#appendIstanbulOperations(JumpTable)}
   */
  @Test
  public void testAppendIstanbulOperations() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendIstanbulOperations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Method under test:
   * {@link OperationRegistry#appendFreezeOperations(JumpTable)}
   */
  @Test
  public void testAppendFreezeOperations() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendFreezeOperations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Method under test: {@link OperationRegistry#appendVoteOperations(JumpTable)}
   */
  @Test
  public void testAppendVoteOperations() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendVoteOperations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Method under test:
   * {@link OperationRegistry#appendLondonOperations(JumpTable)}
   */
  @Test
  public void testAppendLondonOperations() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendLondonOperations(table);

    // Assert
    verify(table).set(isA(Operation.class));
  }

  /**
   * Method under test: {@link OperationRegistry#adjustMemOperations(JumpTable)}
   */
  @Test
  public void testAdjustMemOperations() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.adjustMemOperations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Method under test:
   * {@link OperationRegistry#appendFreezeV2Operations(JumpTable)}
   */
  @Test
  public void testAppendFreezeV2Operations() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendFreezeV2Operations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Method under test:
   * {@link OperationRegistry#appendDelegateOperations(JumpTable)}
   */
  @Test
  public void testAppendDelegateOperations() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendDelegateOperations(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }

  /**
   * Method under test:
   * {@link OperationRegistry#appendShangHaiOperations(JumpTable)}
   */
  @Test
  public void testAppendShangHaiOperations() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.appendShangHaiOperations(table);

    // Assert
    verify(table).set(isA(Operation.class));
  }

  /**
   * Method under test: {@link OperationRegistry#adjustForFairEnergy(JumpTable)}
   */
  @Test
  public void testAdjustForFairEnergy() {
    // Arrange
    JumpTable table = mock(JumpTable.class);
    doNothing().when(table).set(Mockito.<Operation>any());

    // Act
    OperationRegistry.adjustForFairEnergy(table);

    // Assert
    verify(table, atLeast(1)).set(Mockito.<Operation>any());
  }
}
