package org.tron.core.vm.trace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.vm.trace.OpActions.Action;
import org.tron.core.vm.trace.OpActions.Action.Name;

public class OpActionsDiffblueTest {
  /**
   * Test Action {@link Action#addParam(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link Action} (default constructor) Params is {@link HashMap#HashMap()}.
   *   <li>When {@code Value}.
   *   <li>Then return Name is {@code pop}.
   * </ul>
   *
   * <p>Method under test: {@link Action#addParam(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action Action.addParam(String, Object)"})
  public void testActionAddParam_givenActionParamsIsHashMap_whenValue_thenReturnNameIsPop() {
    // Arrange
    Action action = new Action();
    action.setName(Name.pop);
    HashMap<String, Object> params = new HashMap<>();
    action.setParams(params);

    // Act
    Action actualAddParamResult = action.addParam("Name", "Value");

    // Assert
    Map<String, Object> params2 = actualAddParamResult.getParams();
    assertEquals(1, params2.size());
    assertEquals("Value", params2.get("Name"));
    assertEquals(Name.pop, actualAddParamResult.getName());
    assertSame(params, params2);
  }

  /**
   * Test Action {@link Action#addParam(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link Action} (default constructor) Params is {@code null}.
   *   <li>When {@code null}.
   *   <li>Then return {@link Action} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Action#addParam(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action Action.addParam(String, Object)"})
  public void testActionAddParam_givenActionParamsIsNull_whenNull_thenReturnAction() {
    // Arrange
    Action action = new Action();
    action.setName(Name.pop);
    action.setParams(null);

    // Act
    Action actualAddParamResult = action.addParam("Name", null);

    // Assert
    assertSame(action, actualAddParamResult);
  }

  /**
   * Test Action {@link Action#addParam(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link Action} (default constructor).
   *   <li>When {@code Value}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Action#addParam(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action Action.addParam(String, Object)"})
  public void testActionAddParam_givenAction_whenValue_thenReturnNameIsNull() {
    // Arrange and Act
    Action actualAddParamResult = new Action().addParam("Name", "Value");

    // Assert
    Map<String, Object> params = actualAddParamResult.getParams();
    assertEquals(1, params.size());
    assertEquals("Value", params.get("Name"));
    assertNull(actualAddParamResult.getName());
  }

  /**
   * Test Action getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Action}
   *   <li>{@link Action#setName(Action.Name)}
   *   <li>{@link Action#setParams(Map)}
   *   <li>{@link Action#getName()}
   *   <li>{@link Action#getParams()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Action.<init>()",
    "Action.Name Action.getName()",
    "Map Action.getParams()",
    "void Action.setName(Action.Name)",
    "void Action.setParams(Map)"
  })
  public void testActionGettersAndSetters() {
    // Arrange and Act
    Action actualAction = new Action();
    actualAction.setName(Name.pop);
    HashMap<String, Object> params = new HashMap<>();
    actualAction.setParams(params);
    Name actualName = actualAction.getName();
    Map<String, Object> actualParams = actualAction.getParams();

    // Assert
    assertEquals(Name.pop, actualName);
    assertTrue(actualParams.isEmpty());
    assertSame(params, actualParams);
  }

  /**
   * Test {@link OpActions#addStackPop()}.
   *
   * <p>Method under test: {@link OpActions#addStackPop()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action OpActions.addStackPop()"})
  public void testAddStackPop() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    Action actualAddStackPopResult = opActions.addStackPop();

    // Assert
    assertNull(actualAddStackPopResult.getParams());
    assertEquals(1, opActions.getStack().size());
    assertEquals(Name.pop, actualAddStackPopResult.getName());
  }

  /**
   * Test {@link OpActions#addStackPush(DataWord)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Params is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OpActions#addStackPush(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action OpActions.addStackPush(DataWord)"})
  public void testAddStackPush_whenNull_thenReturnParamsIsNull() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    Action actualAddStackPushResult = opActions.addStackPush(null);

    // Assert
    assertNull(actualAddStackPushResult.getParams());
    assertEquals(1, opActions.getStack().size());
    assertEquals(Name.push, actualAddStackPushResult.getName());
  }

  /**
   * Test {@link OpActions#addStackPush(DataWord)}.
   *
   * <ul>
   *   <li>When ZERO.
   *   <li>Then return Params size is one.
   * </ul>
   *
   * <p>Method under test: {@link OpActions#addStackPush(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action OpActions.addStackPush(DataWord)"})
  public void testAddStackPush_whenZero_thenReturnParamsSizeIsOne() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    Action actualAddStackPushResult = opActions.addStackPush(DataWord.ZERO());

    // Assert
    Map<String, Object> params = actualAddStackPushResult.getParams();
    assertEquals(1, params.size());
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000", params.get("value"));
    assertEquals(1, opActions.getStack().size());
    assertEquals(Name.push, actualAddStackPushResult.getName());
  }

  /**
   * Test {@link OpActions#addStackSwap(int, int)}.
   *
   * <p>Method under test: {@link OpActions#addStackSwap(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action OpActions.addStackSwap(int, int)"})
  public void testAddStackSwap() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    Action actualAddStackSwapResult = opActions.addStackSwap(2, 2);

    // Assert
    Map<String, Object> params = actualAddStackSwapResult.getParams();
    assertEquals(2, params.size());
    assertEquals("2", params.get("from"));
    assertEquals("2", params.get("to"));
    assertEquals(1, opActions.getStack().size());
    assertEquals(Name.swap, actualAddStackSwapResult.getName());
  }

  /**
   * Test {@link OpActions#addMemoryExtend(long)}.
   *
   * <p>Method under test: {@link OpActions#addMemoryExtend(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action OpActions.addMemoryExtend(long)"})
  public void testAddMemoryExtend() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    Action actualAddMemoryExtendResult = opActions.addMemoryExtend(2L);

    // Assert
    Map<String, Object> params = actualAddMemoryExtendResult.getParams();
    assertEquals(1, params.size());
    assertEquals("2", params.get("delta"));
    assertEquals(1, opActions.getMemory().size());
    assertEquals(Name.extend, actualAddMemoryExtendResult.getName());
  }

  /**
   * Test {@link OpActions#addMemoryWrite(int, byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Params {@code data} is {@code 415}.
   * </ul>
   *
   * <p>Method under test: {@link OpActions#addMemoryWrite(int, byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action OpActions.addMemoryWrite(int, byte[], int)"})
  public void testAddMemoryWrite_whenAxaxaxaxBytesIsUtf8_thenReturnParamsDataIs415()
      throws UnsupportedEncodingException {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    Action actualAddMemoryWriteResult =
        opActions.addMemoryWrite(19088743, "AXAXAXAX".getBytes("UTF-8"), 3);

    // Assert
    Map<String, Object> params = actualAddMemoryWriteResult.getParams();
    assertEquals(2, params.size());
    assertEquals("19088743", params.get("address"));
    assertEquals("415", params.get("data"));
    assertEquals(1, opActions.getMemory().size());
    assertEquals(Name.write, actualAddMemoryWriteResult.getName());
  }

  /**
   * Test {@link OpActions#addMemoryWrite(int, byte[], int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Params {@code data} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link OpActions#addMemoryWrite(int, byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action OpActions.addMemoryWrite(int, byte[], int)"})
  public void testAddMemoryWrite_whenZero_thenReturnParamsDataIsEmptyString() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    Action actualAddMemoryWriteResult = opActions.addMemoryWrite(19088743, null, 0);

    // Assert
    Map<String, Object> params = actualAddMemoryWriteResult.getParams();
    assertEquals(2, params.size());
    assertEquals("", params.get("data"));
    assertEquals("19088743", params.get("address"));
    assertEquals(1, opActions.getMemory().size());
    assertEquals(Name.write, actualAddMemoryWriteResult.getName());
  }

  /**
   * Test {@link OpActions#addStoragePut(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Params is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OpActions#addStoragePut(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action OpActions.addStoragePut(DataWord, DataWord)"})
  public void testAddStoragePut_whenNull_thenReturnParamsIsNull() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    Action actualAddStoragePutResult = opActions.addStoragePut(null, null);

    // Assert
    assertNull(actualAddStoragePutResult.getParams());
    assertEquals(1, opActions.getStorage().size());
    assertEquals(Name.put, actualAddStoragePutResult.getName());
  }

  /**
   * Test {@link OpActions#addStoragePut(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>When ZERO.
   *   <li>Then return Params size is two.
   * </ul>
   *
   * <p>Method under test: {@link OpActions#addStoragePut(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action OpActions.addStoragePut(DataWord, DataWord)"})
  public void testAddStoragePut_whenZero_thenReturnParamsSizeIsTwo() {
    // Arrange
    OpActions opActions = new OpActions();
    DataWord key = DataWord.ZERO();

    // Act and Assert
    Map<String, Object> params = opActions.addStoragePut(key, DataWord.ZERO()).getParams();
    assertEquals(2, params.size());
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000", params.get("key"));
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000", params.get("value"));
  }

  /**
   * Test {@link OpActions#addStorageRemove(DataWord)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Params is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OpActions#addStorageRemove(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action OpActions.addStorageRemove(DataWord)"})
  public void testAddStorageRemove_whenNull_thenReturnParamsIsNull() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    Action actualAddStorageRemoveResult = opActions.addStorageRemove(null);

    // Assert
    assertNull(actualAddStorageRemoveResult.getParams());
    assertEquals(1, opActions.getStorage().size());
    assertEquals(Name.remove, actualAddStorageRemoveResult.getName());
  }

  /**
   * Test {@link OpActions#addStorageRemove(DataWord)}.
   *
   * <ul>
   *   <li>When ZERO.
   *   <li>Then return Params size is one.
   * </ul>
   *
   * <p>Method under test: {@link OpActions#addStorageRemove(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action OpActions.addStorageRemove(DataWord)"})
  public void testAddStorageRemove_whenZero_thenReturnParamsSizeIsOne() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    Action actualAddStorageRemoveResult = opActions.addStorageRemove(DataWord.ZERO());

    // Assert
    Map<String, Object> params = actualAddStorageRemoveResult.getParams();
    assertEquals(1, params.size());
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000000", params.get("key"));
    assertEquals(1, opActions.getStorage().size());
    assertEquals(Name.remove, actualAddStorageRemoveResult.getName());
  }

  /**
   * Test {@link OpActions#addStorageClear()}.
   *
   * <p>Method under test: {@link OpActions#addStorageClear()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Action OpActions.addStorageClear()"})
  public void testAddStorageClear() {
    // Arrange
    OpActions opActions = new OpActions();

    // Act
    Action actualAddStorageClearResult = opActions.addStorageClear();

    // Assert
    assertNull(actualAddStorageClearResult.getParams());
    assertEquals(1, opActions.getStorage().size());
    assertEquals(Name.clear, actualAddStorageClearResult.getName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void OpActions.<init>()",
    "List OpActions.getMemory()",
    "List OpActions.getStack()",
    "List OpActions.getStorage()",
    "void OpActions.setMemory(List)",
    "void OpActions.setStack(List)",
    "void OpActions.setStorage(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OpActions actualOpActions = new OpActions();
    ArrayList<Action> memory = new ArrayList<>();
    actualOpActions.setMemory(memory);
    ArrayList<Action> stack = new ArrayList<>();
    actualOpActions.setStack(stack);
    ArrayList<Action> storage = new ArrayList<>();
    actualOpActions.setStorage(storage);
    List<Action> actualMemory = actualOpActions.getMemory();
    List<Action> actualStack = actualOpActions.getStack();
    List<Action> actualStorage = actualOpActions.getStorage();

    // Assert
    assertTrue(actualMemory.isEmpty());
    assertTrue(actualStack.isEmpty());
    assertTrue(actualStorage.isEmpty());
    assertSame(memory, actualMemory);
    assertSame(stack, actualStack);
    assertSame(storage, actualStorage);
  }
}
