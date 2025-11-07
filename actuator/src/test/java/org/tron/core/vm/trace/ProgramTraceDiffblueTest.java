package org.tron.core.vm.trace;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.program.invoke.ProgramInvoke;
import org.tron.core.vm.program.invoke.ProgramInvokeImpl;
import org.tron.core.vm.program.invoke.ProgramInvokeMockImpl;
import org.tron.core.vm.repository.RepositoryImpl;

public class ProgramTraceDiffblueTest {
  /**
   * Method under test: {@link ProgramTrace#result(byte[])}
   */
  @Test
  public void testResult() throws UnsupportedEncodingException {
    // Arrange
    ProgramTrace programTrace = new ProgramTrace();

    // Act
    ProgramTrace actualResultResult = programTrace.result("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4158415841584158", programTrace.getResult());
    assertSame(programTrace, actualResultResult);
  }

  /**
   * Method under test: {@link ProgramTrace#result(byte[])}
   */
  @Test
  public void testResult2() {
    // Arrange
    ProgramTrace programTrace = new ProgramTrace();

    // Act
    ProgramTrace actualResultResult = programTrace.result(null);

    // Assert
    assertEquals("", programTrace.getResult());
    assertSame(programTrace, actualResultResult);
  }

  /**
   * Method under test: {@link ProgramTrace#result(byte[])}
   */
  @Test
  public void testResult3() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramTrace programTrace = new ProgramTrace(
        new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 1L, 1L, 1L));

    // Act
    ProgramTrace actualResultResult = programTrace.result("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("4158415841584158", programTrace.getResult());
    assertSame(programTrace, actualResultResult);
  }

  /**
   * Method under test: {@link ProgramTrace#error(Exception)}
   */
  @Test
  public void testError() {
    // Arrange
    ProgramTrace programTrace = new ProgramTrace();

    // Act
    ProgramTrace actualErrorResult = programTrace.error(new Exception("foo"));

    // Assert
    assertEquals("class java.lang.Exception: foo", programTrace.getError());
    assertSame(programTrace, actualErrorResult);
  }

  /**
   * Method under test: {@link ProgramTrace#error(Exception)}
   */
  @Test
  public void testError2() {
    // Arrange
    ProgramTrace programTrace = new ProgramTrace();

    // Act
    ProgramTrace actualErrorResult = programTrace.error(null);

    // Assert
    assertEquals("", programTrace.getError());
    assertSame(programTrace, actualErrorResult);
  }

  /**
   * Method under test: {@link ProgramTrace#error(Exception)}
   */
  @Test
  public void testError3() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramTrace programTrace = new ProgramTrace(
        new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 1L, 1L, 1L));

    // Act
    ProgramTrace actualErrorResult = programTrace.error(new Exception("foo"));

    // Assert
    assertEquals("class java.lang.Exception: foo", programTrace.getError());
    assertSame(programTrace, actualErrorResult);
  }

  /**
   * Method under test:
   * {@link ProgramTrace#addOp(byte, int, int, DataWord, OpActions)}
   */
  @Test
  public void testAddOp() {
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
    assertArrayEquals(new byte[]{0}, energy2.toByteArray());
  }

  /**
   * Method under test:
   * {@link ProgramTrace#addOp(byte, int, int, DataWord, OpActions)}
   */
  @Test
  public void testAddOp2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramTrace programTrace = new ProgramTrace(
        new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 1L, 1L, 1L));
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
    assertArrayEquals(new byte[]{0}, energy2.toByteArray());
  }

  /**
   * Method under test: {@link ProgramTrace#asJsonString(boolean)}
   */
  @Test
  public void testAsJsonString() {
    // Arrange, Act and Assert
    assertEquals("{\n  \"ops\" : [ ],\n  \"result\" : null,\n  \"error\" : null,\n  \"contractAddress\" : null\n}",
        (new ProgramTrace()).asJsonString(true));
    assertEquals("{\"ops\":[],\"result\":null,\"error\":null,\"contractAddress\":null}",
        (new ProgramTrace()).asJsonString(false));
  }

  /**
   * Method under test: {@link ProgramTrace#asJsonString(boolean)}
   */
  @Test
  public void testAsJsonString2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals("{\n  \"ops\" : [ ],\n  \"result\" : null,\n  \"error\" : null,\n  \"contractAddress\" : null\n}",
        (new ProgramTrace(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase,
            10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 1L, 1L, 1L)))
                .asJsonString(true));
  }

  /**
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("42 Main St", actualContractAddress);
    assertEquals("An error occurred", actualError);
    assertEquals("Result", programTrace.getResult());
    assertEquals("{\n" + "  \"ops\" : [ ],\n" + "  \"result\" : \"Result\",\n"
        + "  \"error\" : \"An error occurred\",\n" + "  \"contractAddress\" : \"42 Main St\"\n" + "}",
        actualToStringResult);
    assertTrue(actualOps.isEmpty());
    assertSame(ops, actualOps);
  }

  /**
   * Method under test: {@link ProgramTrace#ProgramTrace()}
   */
  @Test
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
   * Method under test: {@link ProgramTrace#ProgramTrace(ProgramInvoke)}
   */
  @Test
  public void testNewProgramTrace2() {
    // Arrange and Act
    ProgramTrace actualProgramTrace = new ProgramTrace(new ProgramInvokeMockImpl());

    // Assert
    assertNull(actualProgramTrace.getContractAddress());
    assertNull(actualProgramTrace.getError());
    assertNull(actualProgramTrace.getResult());
    assertTrue(actualProgramTrace.getOps().isEmpty());
  }

  /**
   * Method under test: {@link ProgramTrace#ProgramTrace(ProgramInvoke)}
   */
  @Test
  public void testNewProgramTrace3() {
    // Arrange and Act
    ProgramTrace actualProgramTrace = new ProgramTrace(null);

    // Assert
    assertNull(actualProgramTrace.getContractAddress());
    assertNull(actualProgramTrace.getError());
    assertNull(actualProgramTrace.getResult());
    assertTrue(actualProgramTrace.getOps().isEmpty());
  }

  /**
   * Method under test: {@link ProgramTrace#ProgramTrace(ProgramInvoke)}
   */
  @Test
  public void testNewProgramTrace4() {
    // Arrange and Act
    ProgramTrace actualProgramTrace = new ProgramTrace(
        new ProgramInvokeImpl(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2},
            new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 42L, 42L, 42L, 1L, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2},
            new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2}, 10L, 2L,
            new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 2L, 2L, 2L));

    // Assert
    assertNull(actualProgramTrace.getContractAddress());
    assertNull(actualProgramTrace.getError());
    assertNull(actualProgramTrace.getResult());
    assertTrue(actualProgramTrace.getOps().isEmpty());
  }
}
