package org.tron.core.vm.trace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;
import org.tron.common.runtime.vm.DataWord;

public class OpActionsDiffblueTest {
  /**
   * Method under test: {@link OpActions.Action#addParam(String, Object)}
   */
  @Test
  public void testActionAddParam() {
    // Arrange
    OpActions.Action action = new OpActions.Action();

    // Act and Assert
    assertSame(action, action.addParam("Name", "Value"));
  }

  /**
   * Method under test: {@link OpActions.Action#addParam(String, Object)}
   */
  @Test
  public void testActionAddParam2() {
    // Arrange
    OpActions.Action action = new OpActions.Action();
    action.setName(OpActions.Action.Name.pop);
    action.setParams(null);

    // Act and Assert
    assertSame(action, action.addParam("Name", null));
  }

  /**
   * Method under test: {@link OpActions.Action#addParam(String, Object)}
   */
  @Test
  public void testActionAddParam3() {
    // Arrange
    OpActions.Action action = new OpActions.Action();
    action.setName(OpActions.Action.Name.pop);
    action.setParams(new HashMap<>());

    // Act and Assert
    assertSame(action, action.addParam("Name", "Value"));
  }

  /**
   * Method under test: {@link OpActions.Action#addParam(String, Object)}
   */
  @Test
  public void testActionAddParam4() {
    // Arrange
    HashMap<String, Object> params = new HashMap<>();
    params.computeIfPresent("foo", mock(BiFunction.class));

    OpActions.Action action = new OpActions.Action();
    action.setName(OpActions.Action.Name.pop);
    action.setParams(params);

    // Act and Assert
    assertSame(action, action.addParam("Name", "Value"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OpActions.Action}
   *   <li>{@link OpActions.Action#setName(OpActions.Action.Name)}
   *   <li>{@link OpActions.Action#setParams(Map)}
   *   <li>{@link OpActions.Action#getName()}
   *   <li>{@link OpActions.Action#getParams()}
   * </ul>
   */
  @Test
  public void testActionGettersAndSetters() {
    // Arrange and Act
    OpActions.Action actualAction = new OpActions.Action();
    actualAction.setName(OpActions.Action.Name.pop);
    HashMap<String, Object> params = new HashMap<>();
    actualAction.setParams(params);
    OpActions.Action.Name actualName = actualAction.getName();
    Map<String, Object> actualParams = actualAction.getParams();

    // Assert that nothing has changed
    assertEquals(OpActions.Action.Name.pop, actualName);
    assertTrue(actualParams.isEmpty());
    assertSame(params, actualParams);
  }

  /**
   * Method under test: {@link OpActions#addStackPop()}
   */
  @Test
  public void testAddStackPop() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    OpActions.Action actualAddStackPopResult = opActions.addStackPop();

    // Assert
    assertNull(actualAddStackPopResult.getParams());
    assertEquals(1, opActions.getStack().size());
    assertEquals(OpActions.Action.Name.pop, actualAddStackPopResult.getName());
  }

  /**
   * Method under test: {@link OpActions#addStackPush(DataWord)}
   */
  @Test
  public void testAddStackPush() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    OpActions.Action actualAddStackPushResult = opActions.addStackPush(DataWord.ZERO());

    // Assert
    Map<String, Object> params = actualAddStackPushResult.getParams();
    assertEquals(1, params.size());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", params.get("value"));
    assertEquals(1, opActions.getStack().size());
    assertEquals(OpActions.Action.Name.push, actualAddStackPushResult.getName());
  }

  /**
   * Method under test: {@link OpActions#addStackPush(DataWord)}
   */
  @Test
  public void testAddStackPush2() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    OpActions.Action actualAddStackPushResult = opActions.addStackPush(null);

    // Assert
    assertNull(actualAddStackPushResult.getParams());
    assertEquals(1, opActions.getStack().size());
    assertEquals(OpActions.Action.Name.push, actualAddStackPushResult.getName());
  }

  /**
   * Method under test: {@link OpActions#addStackSwap(int, int)}
   */
  @Test
  public void testAddStackSwap() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    OpActions.Action actualAddStackSwapResult = opActions.addStackSwap(2, 2);

    // Assert
    Map<String, Object> params = actualAddStackSwapResult.getParams();
    assertEquals(2, params.size());
    assertEquals("2", params.get("from"));
    assertEquals("2", params.get("to"));
    assertEquals(1, opActions.getStack().size());
    assertEquals(OpActions.Action.Name.swap, actualAddStackSwapResult.getName());
  }

  /**
   * Method under test: {@link OpActions#addMemoryExtend(long)}
   */
  @Test
  public void testAddMemoryExtend() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    OpActions.Action actualAddMemoryExtendResult = opActions.addMemoryExtend(2L);

    // Assert
    Map<String, Object> params = actualAddMemoryExtendResult.getParams();
    assertEquals(1, params.size());
    assertEquals("2", params.get("delta"));
    assertEquals(1, opActions.getMemory().size());
    assertEquals(OpActions.Action.Name.extend, actualAddMemoryExtendResult.getName());
    assertTrue(opActions.getStorage().isEmpty());
  }

  /**
   * Method under test: {@link OpActions#addMemoryWrite(int, byte[], int)}
   */
  @Test
  public void testAddMemoryWrite() throws UnsupportedEncodingException {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    OpActions.Action actualAddMemoryWriteResult = opActions.addMemoryWrite(19088743, "AXAXAXAX".getBytes("UTF-8"), 3);

    // Assert
    Map<String, Object> params = actualAddMemoryWriteResult.getParams();
    assertEquals(2, params.size());
    assertEquals("19088743", params.get("address"));
    assertEquals("415", params.get("data"));
    assertEquals(1, opActions.getMemory().size());
    assertEquals(OpActions.Action.Name.write, actualAddMemoryWriteResult.getName());
    assertTrue(opActions.getStorage().isEmpty());
  }

  /**
   * Method under test: {@link OpActions#addStoragePut(DataWord, DataWord)}
   */
  @Test
  public void testAddStoragePut() {
    // Arrange
    OpActions opActions = new OpActions();
    DataWord key = DataWord.ZERO();

    // Act
    OpActions.Action actualAddStoragePutResult = opActions.addStoragePut(key, DataWord.ZERO());

    // Assert
    Map<String, Object> params = actualAddStoragePutResult.getParams();
    assertEquals(2, params.size());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", params.get("key"));
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", params.get("value"));
    assertEquals(1, opActions.getStorage().size());
    assertEquals(OpActions.Action.Name.put, actualAddStoragePutResult.getName());
  }

  /**
   * Method under test: {@link OpActions#addStoragePut(DataWord, DataWord)}
   */
  @Test
  public void testAddStoragePut2() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    OpActions.Action actualAddStoragePutResult = opActions.addStoragePut(null, null);

    // Assert
    assertNull(actualAddStoragePutResult.getParams());
    assertEquals(1, opActions.getStorage().size());
    assertEquals(OpActions.Action.Name.put, actualAddStoragePutResult.getName());
  }

  /**
   * Method under test: {@link OpActions#addStorageRemove(DataWord)}
   */
  @Test
  public void testAddStorageRemove() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    OpActions.Action actualAddStorageRemoveResult = opActions.addStorageRemove(DataWord.ZERO());

    // Assert
    Map<String, Object> params = actualAddStorageRemoveResult.getParams();
    assertEquals(1, params.size());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", params.get("key"));
    assertEquals(1, opActions.getStorage().size());
    assertEquals(OpActions.Action.Name.remove, actualAddStorageRemoveResult.getName());
  }

  /**
   * Method under test: {@link OpActions#addStorageRemove(DataWord)}
   */
  @Test
  public void testAddStorageRemove2() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    OpActions.Action actualAddStorageRemoveResult = opActions.addStorageRemove(null);

    // Assert
    assertNull(actualAddStorageRemoveResult.getParams());
    assertEquals(1, opActions.getStorage().size());
    assertEquals(OpActions.Action.Name.remove, actualAddStorageRemoveResult.getName());
  }

  /**
   * Method under test: {@link OpActions#addStorageClear()}
   */
  @Test
  public void testAddStorageClear() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    OpActions.Action actualAddStorageClearResult = opActions.addStorageClear();

    // Assert
    assertNull(actualAddStorageClearResult.getParams());
    assertEquals(1, opActions.getStorage().size());
    assertEquals(OpActions.Action.Name.clear, actualAddStorageClearResult.getName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OpActions}
   *   <li>{@link OpActions#setMemory(List)}
   *   <li>{@link OpActions#setStack(List)}
   *   <li>{@link OpActions#setStorage(List)}
   *   <li>{@link OpActions#getMemory()}
   *   <li>{@link OpActions#getStack()}
   *   <li>{@link OpActions#getStorage()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OpActions actualOpActions = new OpActions();
    ArrayList<OpActions.Action> memory = new ArrayList<>();
    actualOpActions.setMemory(memory);
    ArrayList<OpActions.Action> stack = new ArrayList<>();
    actualOpActions.setStack(stack);
    ArrayList<OpActions.Action> storage = new ArrayList<>();
    actualOpActions.setStorage(storage);
    List<OpActions.Action> actualMemory = actualOpActions.getMemory();
    List<OpActions.Action> actualStack = actualOpActions.getStack();
    List<OpActions.Action> actualStorage = actualOpActions.getStorage();

    // Assert that nothing has changed
    assertTrue(actualMemory.isEmpty());
    assertTrue(actualStack.isEmpty());
    assertTrue(actualStorage.isEmpty());
    assertSame(memory, actualMemory);
    assertSame(stack, actualStack);
    assertSame(storage, actualStorage);
  }
}
