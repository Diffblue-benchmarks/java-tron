package org.tron.core.vm.trace;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.vm.program.invoke.ProgramInvoke;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;

public class ProgramTraceDiffblueTest {
  /**
   * Test {@link ProgramTrace#ProgramTrace()}.
   *
   * <p>Method under test: {@link ProgramTrace#ProgramTrace()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramTrace.<init>()"})
  public void testNewProgramTrace() {
    // Arrange and Act
    ProgramTrace actualProgramTrace = new ProgramTrace();

    // Assert
    assertNull(actualProgramTrace.getContractAddress());
    assertNull(actualProgramTrace.getError());
    assertNull(actualProgramTrace.getResult());
    assertTrue(actualProgramTrace.getOps().isEmpty());
  }

  /**
   * Test {@link ProgramTrace#ProgramTrace(ProgramInvoke)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramTrace#ProgramTrace(ProgramInvoke)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramTrace.<init>(ProgramInvoke)"})
  public void testNewProgramTrace_whenNull() {
    // Arrange and Act
    ProgramTrace actualProgramTrace = new ProgramTrace(null);

    // Assert
    assertNull(actualProgramTrace.getContractAddress());
    assertNull(actualProgramTrace.getError());
    assertNull(actualProgramTrace.getResult());
    assertTrue(actualProgramTrace.getOps().isEmpty());
  }

  /**
   * Test {@link ProgramTrace#ProgramTrace(ProgramInvoke)}.
   *
   * <ul>
   *   <li>When {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramTrace#ProgramTrace(ProgramInvoke)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramTrace.<init>(ProgramInvoke)"})
  public void testNewProgramTrace_whenProgramInvokeMockImpl() {
    // Arrange and Act
    ProgramTrace actualProgramTrace = new ProgramTrace(new ProgramInvokeMockImpl());

    // Assert
    assertNull(actualProgramTrace.getContractAddress());
    assertNull(actualProgramTrace.getError());
    assertNull(actualProgramTrace.getResult());
    assertTrue(actualProgramTrace.getOps().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProgramTrace#setContractAddress(String)}
   *   <li>{@link ProgramTrace#setError(String)}
   *   <li>{@link ProgramTrace#setOps(List)}
   *   <li>{@link ProgramTrace#setResult(String)}
   *   <li>{@link ProgramTrace#toString()}
   *   <li>{@link ProgramTrace#getContractAddress()}
   *   <li>{@link ProgramTrace#getError()}
   *   <li>{@link ProgramTrace#getOps()}
   *   <li>{@link ProgramTrace#getResult()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "String ProgramTrace.getContractAddress()",
    "String ProgramTrace.getError()",
    "List ProgramTrace.getOps()",
    "String ProgramTrace.getResult()",
    "void ProgramTrace.setContractAddress(String)",
    "void ProgramTrace.setError(String)",
    "void ProgramTrace.setOps(List)",
    "void ProgramTrace.setResult(String)",
    "String ProgramTrace.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    ProgramTrace programTrace = new ProgramTrace();

    // Act
    programTrace.setContractAddress("42 Main St");
    programTrace.setError("An error occurred");
    ArrayList<Op> ops = new ArrayList<>();
    programTrace.setOps(ops);
    programTrace.setResult("Result");
    String actualToStringResult = programTrace.toString();
    String actualContractAddress = programTrace.getContractAddress();
    String actualError = programTrace.getError();
    List<Op> actualOps = programTrace.getOps();

    // Assert
    assertEquals("42 Main St", actualContractAddress);
    assertEquals("An error occurred", actualError);
    assertEquals("Result", programTrace.getResult());
    assertEquals(
        "{\n"
            + "  \"ops\" : [ ],\n"
            + "  \"result\" : \"Result\",\n"
            + "  \"error\" : \"An error occurred\",\n"
            + "  \"contractAddress\" : \"42 Main St\"\n"
            + "}",
        actualToStringResult);
    assertTrue(actualOps.isEmpty());
    assertSame(ops, actualOps);
  }

  /**
   * Test {@link ProgramTrace#result(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then {@link ProgramTrace#ProgramTrace()} Result is {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramTrace#result(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramTrace ProgramTrace.result(byte[])"})
  public void testResult_whenAxaxaxaxBytesIsUtf8_thenProgramTraceResultIs4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramTrace programTrace = new ProgramTrace();

    // Act
    ProgramTrace actualResultResult = programTrace.result("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4158415841584158", programTrace.getResult());
    assertSame(programTrace, actualResultResult);
  }

  /**
   * Test {@link ProgramTrace#result(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ProgramTrace#ProgramTrace()} Result is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ProgramTrace#result(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramTrace ProgramTrace.result(byte[])"})
  public void testResult_whenNull_thenProgramTraceResultIsEmptyString() {
    // Arrange
    ProgramTrace programTrace = new ProgramTrace();

    // Act
    ProgramTrace actualResultResult = programTrace.result(null);

    // Assert
    assertEquals("", programTrace.getResult());
    assertSame(programTrace, actualResultResult);
  }

  /**
   * Test {@link ProgramTrace#error(Exception)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then {@link ProgramTrace#ProgramTrace()} Error is {@code class Exception: null}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramTrace#error(Exception)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramTrace ProgramTrace.error(Exception)"})
  public void testError_whenException_thenProgramTraceErrorIsClassJavaLangExceptionNull() {
    // Arrange
    ProgramTrace programTrace = new ProgramTrace();

    // Act
    ProgramTrace actualErrorResult = programTrace.error(new Exception());

    // Assert
    assertEquals("class java.lang.Exception: null", programTrace.getError());
    assertSame(programTrace, actualErrorResult);
  }

  /**
   * Test {@link ProgramTrace#error(Exception)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ProgramTrace#ProgramTrace()} Error is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ProgramTrace#error(Exception)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramTrace ProgramTrace.error(Exception)"})
  public void testError_whenNull_thenProgramTraceErrorIsEmptyString() {
    // Arrange
    ProgramTrace programTrace = new ProgramTrace();

    // Act
    ProgramTrace actualErrorResult = programTrace.error(null);

    // Assert
    assertEquals("", programTrace.getError());
    assertSame(programTrace, actualErrorResult);
  }

  /**
   * Test {@link ProgramTrace#addOp(byte, int, int, DataWord, OpActions)}.
   *
   * <ul>
   *   <li>When ZERO.
   *   <li>Then return Energy toString is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramTrace#addOp(byte, int, int, DataWord, OpActions)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Op ProgramTrace.addOp(byte, int, int, DataWord, OpActions)"})
  public void testAddOp_whenZero_thenReturnEnergyToStringIs0() {
    // Arrange
    ProgramTrace programTrace = new ProgramTrace();
    DataWord energy = DataWord.ZERO();
    OpActions actions = new OpActions();

    // Act
    Op actualAddOpResult = programTrace.addOp((byte) 'A', 2, 2, energy, actions);

    // Assert
    BigInteger energy2 = actualAddOpResult.getEnergy();
    assertEquals("0", energy2.toString());
    assertEquals(-1, energy2.getLowestSetBit());
    assertEquals(0, energy2.signum());
    assertEquals(1, programTrace.getOps().size());
    assertEquals(2, actualAddOpResult.getDeep());
    assertEquals(2, actualAddOpResult.getPc());
    assertEquals(65, actualAddOpResult.getCode());
    assertSame(actions, actualAddOpResult.getActions());
    assertArrayEquals(new byte[] {0}, energy2.toByteArray());
  }

  /**
   * Test {@link ProgramTrace#asJsonString(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code {"ops":[],"result":null,"error":null,"contractAddress":null}}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramTrace#asJsonString(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProgramTrace.asJsonString(boolean)"})
  public void testAsJsonString_whenFalse_thenReturnOpsResultNullErrorNullContractAddressNull() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"ops\":[],\"result\":null,\"error\":null,\"contractAddress\":null}",
        new ProgramTrace().asJsonString(false));
  }

  /**
   * Test {@link ProgramTrace#asJsonString(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code { "ops" : [ ], "result" : null, "error" : null, "contractAddress" :
   *       null }}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramTrace#asJsonString(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProgramTrace.asJsonString(boolean)"})
  public void testAsJsonString_whenTrue_thenReturnOpsResultNullErrorNullContractAddressNull() {
    // Arrange, Act and Assert
    assertEquals(
        "{\n  \"ops\" : [ ],\n  \"result\" : null,\n  \"error\" : null,\n  \"contractAddress\" : null\n}",
        new ProgramTrace().asJsonString(true));
  }
}
