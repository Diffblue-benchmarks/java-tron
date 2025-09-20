package org.tron.core.vm.program.invoke;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class ProgramInvokeImplDiffblueTest {
  /**
   * Test {@link ProgramInvokeImpl#ProgramInvokeImpl(DataWord, DataWord, DataWord, DataWord,
   * DataWord, DataWord, DataWord, byte[], DataWord, DataWord, DataWord, DataWord, DataWord,
   * Repository, int, boolean, boolean, long, long, long)}.
   *
   * <p>Method under test: {@link ProgramInvokeImpl#ProgramInvokeImpl(DataWord, DataWord, DataWord,
   * DataWord, DataWord, DataWord, DataWord, byte[], DataWord, DataWord, DataWord, DataWord,
   * DataWord, Repository, int, boolean, boolean, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ProgramInvokeImpl.<init>(DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, byte[], DataWord, DataWord, DataWord, DataWord, DataWord, Repository, int, boolean, boolean, long, long, long)"
  })
  public void testNewProgramInvokeImpl() throws UnsupportedEncodingException {
    // Arrange
    DataWord address = DataWord.ZERO();
    DataWord origin = DataWord.ZERO();
    DataWord caller = DataWord.ZERO();
    DataWord balance = DataWord.ZERO();
    DataWord callValue = DataWord.ZERO();
    DataWord tokenValue = DataWord.ZERO();
    DataWord tokenId = DataWord.ZERO();
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    DataWord lastHash = DataWord.ZERO();
    DataWord coinbase = DataWord.ZERO();
    DataWord timestamp = DataWord.ZERO();
    DataWord number = DataWord.ZERO();
    DataWord difficulty = DataWord.ZERO();
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    ProgramInvokeImpl actualProgramInvokeImpl =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            balance,
            callValue,
            tokenValue,
            tokenId,
            msgData,
            lastHash,
            coinbase,
            timestamp,
            number,
            difficulty,
            deposit,
            1,
            true,
            true,
            1L,
            1L,
            1L);

    // Assert
    Repository deposit2 = actualProgramInvokeImpl.getDeposit();
    assertTrue(deposit2 instanceof RepositoryImpl);
    assertEquals(1, actualProgramInvokeImpl.getCallDeep());
    assertEquals(1L, actualProgramInvokeImpl.getEnergyLimit());
    assertEquals(1L, actualProgramInvokeImpl.getVmShouldEndInUs());
    assertEquals(1L, actualProgramInvokeImpl.getVmStartInUs());
    assertFalse(actualProgramInvokeImpl.isConstantCall());
    assertTrue(actualProgramInvokeImpl.byTestingSuite());
    assertTrue(actualProgramInvokeImpl.isStaticCall());
    assertSame(deposit, deposit2);
    assertSame(balance, actualProgramInvokeImpl.getBalance());
    assertSame(callValue, actualProgramInvokeImpl.getCallValue());
    assertSame(caller, actualProgramInvokeImpl.getCallerAddress());
    assertSame(coinbase, actualProgramInvokeImpl.getCoinbase());
    assertSame(address, actualProgramInvokeImpl.getContractAddress());
    assertSame(number, actualProgramInvokeImpl.getNumber());
    assertSame(origin, actualProgramInvokeImpl.getOriginAddress());
    assertSame(lastHash, actualProgramInvokeImpl.getPrevHash());
    assertSame(timestamp, actualProgramInvokeImpl.getTimestamp());
    assertSame(tokenId, actualProgramInvokeImpl.getTokenId());
    assertSame(tokenValue, actualProgramInvokeImpl.getTokenValue());
  }

  /**
   * Test {@link ProgramInvokeImpl#getDataValue(DataWord)}.
   *
   * <ul>
   *   <li>When {@link DataWord} with num is {@code A}.
   *   <li>Then return {@link DataWord#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeImpl#getDataValue(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeImpl.getDataValue(DataWord)"})
  public void testGetDataValue_whenDataWordWithNumIsA_thenReturnZero()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L);

    // Act and Assert
    assertEquals(DataWord.ZERO, programInvokeImpl.getDataValue(DataWord.of((byte) 'A')));
  }

  /**
   * Test {@link ProgramInvokeImpl#getDataValue(DataWord)}.
   *
   * <ul>
   *   <li>When ZERO.
   *   <li>Then return toPrefixString is {@code 415841}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeImpl#getDataValue(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeImpl.getDataValue(DataWord)"})
  public void testGetDataValue_whenZero_thenReturnToPrefixStringIs415841()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L);

    // Act
    DataWord actualDataValue = programInvokeImpl.getDataValue(DataWord.ZERO());

    // Assert
    assertEquals("415841", actualDataValue.toPrefixString());
    assertEquals(
        "4158415841584158000000000000000000000000000000000000000000000000",
        actualDataValue.toHexString());
    assertFalse(actualDataValue.isZero());
    byte[] data = actualDataValue.getData();
    assertSame(data, actualDataValue.getNoLeadZeroesData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualDataValue.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataValue.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataValue.toTronAddress());
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0
        },
        actualDataValue.getClonedData());
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0
        },
        data);
  }

  /**
   * Test {@link ProgramInvokeImpl#getDataSize()}.
   *
   * <p>Method under test: {@link ProgramInvokeImpl#getDataSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeImpl.getDataSize()"})
  public void testGetDataSize() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L);

    // Act
    DataWord actualDataSize = programInvokeImpl.getDataSize();

    // Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000008",
        actualDataSize.toHexString());
    assertEquals("08", actualDataSize.toPrefixString());
    assertFalse(actualDataSize.isZero());
    byte[] data = actualDataSize.getData();
    assertSame(data, actualDataSize.getNoEndZeroesData());
    assertArrayEquals(new byte[] {'\b'}, actualDataSize.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualDataSize.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualDataSize.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '\b'
        },
        actualDataSize.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '\b'
        },
        data);
  }

  /**
   * Test {@link ProgramInvokeImpl#getDataSize()}.
   *
   * <ul>
   *   <li>Then return {@link DataWord#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeImpl#getDataSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeImpl.getDataSize()"})
  public void testGetDataSize_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            address,
            origin,
            caller,
            42L,
            42L,
            42L,
            1L,
            new byte[] {},
            lastHash,
            coinbase,
            10L,
            1L,
            deposit,
            1L,
            1L,
            1L);

    // Act and Assert
    assertSame(DataWord.ZERO, programInvokeImpl.getDataSize());
  }

  /**
   * Test {@link ProgramInvokeImpl#getDataCopy(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>When {@link DataWord} with num is {@code A}.
   *   <li>Then return eleventh element is zero.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeImpl#getDataCopy(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramInvokeImpl.getDataCopy(DataWord, DataWord)"})
  public void testGetDataCopy_whenDataWordWithNumIsA_thenReturnEleventhElementIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L);
    DataWord offsetData = DataWord.ZERO();

    // Act
    byte[] actualDataCopy = programInvokeImpl.getDataCopy(offsetData, DataWord.of((byte) 'A'));

    // Assert
    assertEquals((byte) 0, actualDataCopy[10]);
    assertEquals((byte) 0, actualDataCopy[11]);
    assertEquals((byte) 0, actualDataCopy[12]);
    assertEquals((byte) 0, actualDataCopy[13]);
    assertEquals((byte) 0, actualDataCopy[14]);
    assertEquals((byte) 0, actualDataCopy[15]);
    assertEquals((byte) 0, actualDataCopy[17]);
    assertEquals((byte) 0, actualDataCopy[18]);
    assertEquals((byte) 0, actualDataCopy[19]);
    assertEquals((byte) 0, actualDataCopy[20]);
    assertEquals((byte) 0, actualDataCopy[21]);
    assertEquals((byte) 0, actualDataCopy[22]);
    assertEquals((byte) 0, actualDataCopy[23]);
    assertEquals((byte) 0, actualDataCopy[24]);
    assertEquals((byte) 0, actualDataCopy[40]);
    assertEquals((byte) 0, actualDataCopy[41]);
    assertEquals((byte) 0, actualDataCopy[42]);
    assertEquals((byte) 0, actualDataCopy[43]);
    assertEquals((byte) 0, actualDataCopy[44]);
    assertEquals((byte) 0, actualDataCopy[45]);
    assertEquals((byte) 0, actualDataCopy[46]);
    assertEquals((byte) 0, actualDataCopy[47]);
    assertEquals((byte) 0, actualDataCopy[48]);
    assertEquals((byte) 0, actualDataCopy[49]);
    assertEquals((byte) 0, actualDataCopy[50]);
    assertEquals((byte) 0, actualDataCopy[51]);
    assertEquals((byte) 0, actualDataCopy[52]);
    assertEquals((byte) 0, actualDataCopy[53]);
    assertEquals((byte) 0, actualDataCopy[54]);
    assertEquals((byte) 0, actualDataCopy[55]);
    assertEquals((byte) 0, actualDataCopy[56]);
    assertEquals((byte) 0, actualDataCopy[57]);
    assertEquals((byte) 0, actualDataCopy[58]);
    assertEquals((byte) 0, actualDataCopy[59]);
    assertEquals((byte) 0, actualDataCopy[60]);
    assertEquals((byte) 0, actualDataCopy[61]);
    assertEquals((byte) 0, actualDataCopy[62]);
    assertEquals((byte) 0, actualDataCopy[63]);
    assertEquals((byte) 0, actualDataCopy[8]);
    assertEquals((byte) 0, actualDataCopy[9]);
    assertEquals((byte) 0, actualDataCopy[Double.SIZE]);
    assertEquals((byte) 0, actualDataCopy[Short.SIZE]);
    assertEquals(65, actualDataCopy.length);
    assertEquals('A', actualDataCopy[0]);
    assertEquals('A', actualDataCopy[2]);
    assertEquals('A', actualDataCopy[4]);
    assertEquals('A', actualDataCopy[6]);
    assertEquals('X', actualDataCopy[1]);
    assertEquals('X', actualDataCopy[3]);
    assertEquals('X', actualDataCopy[5]);
    assertEquals('X', actualDataCopy[7]);
  }

  /**
   * Test {@link ProgramInvokeImpl#getDataCopy(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>When {@link DataWord} with num is {@code A}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeImpl#getDataCopy(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramInvokeImpl.getDataCopy(DataWord, DataWord)"})
  public void testGetDataCopy_whenDataWordWithNumIsA_thenReturnEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L);
    DataWord offsetData = DataWord.of((byte) 'A');

    // Act and Assert
    assertArrayEquals(new byte[] {}, programInvokeImpl.getDataCopy(offsetData, DataWord.ZERO()));
  }

  /**
   * Test {@link ProgramInvokeImpl#getDataCopy(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>When ZERO.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeImpl#getDataCopy(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramInvokeImpl.getDataCopy(DataWord, DataWord)"})
  public void testGetDataCopy_whenZero_thenReturnEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L);
    DataWord offsetData = DataWord.ZERO();

    // Act and Assert
    assertArrayEquals(new byte[] {}, programInvokeImpl.getDataCopy(offsetData, DataWord.ZERO()));
  }

  /**
   * Test {@link ProgramInvokeImpl#getDifficulty()}.
   *
   * <p>Method under test: {@link ProgramInvokeImpl#getDifficulty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeImpl.getDifficulty()"})
  public void testGetDifficulty() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit =
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L);

    // Act and Assert
    assertEquals(DataWord.ZERO, programInvokeImpl.getDifficulty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProgramInvokeImpl#setConstantCall()}
   *   <li>{@link ProgramInvokeImpl#toString()}
   *   <li>{@link ProgramInvokeImpl#byTestingSuite()}
   *   <li>{@link ProgramInvokeImpl#getBalance()}
   *   <li>{@link ProgramInvokeImpl#getCallDeep()}
   *   <li>{@link ProgramInvokeImpl#getCallValue()}
   *   <li>{@link ProgramInvokeImpl#getCallerAddress()}
   *   <li>{@link ProgramInvokeImpl#getCoinbase()}
   *   <li>{@link ProgramInvokeImpl#getContractAddress()}
   *   <li>{@link ProgramInvokeImpl#getDeposit()}
   *   <li>{@link ProgramInvokeImpl#getEnergyLimit()}
   *   <li>{@link ProgramInvokeImpl#getNumber()}
   *   <li>{@link ProgramInvokeImpl#getOriginAddress()}
   *   <li>{@link ProgramInvokeImpl#getPrevHash()}
   *   <li>{@link ProgramInvokeImpl#getTimestamp()}
   *   <li>{@link ProgramInvokeImpl#getTokenId()}
   *   <li>{@link ProgramInvokeImpl#getTokenValue()}
   *   <li>{@link ProgramInvokeImpl#getVmShouldEndInUs()}
   *   <li>{@link ProgramInvokeImpl#getVmStartInUs()}
   *   <li>{@link ProgramInvokeImpl#isConstantCall()}
   *   <li>{@link ProgramInvokeImpl#isStaticCall()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ProgramInvokeImpl.byTestingSuite()",
    "DataWord ProgramInvokeImpl.getBalance()",
    "int ProgramInvokeImpl.getCallDeep()",
    "DataWord ProgramInvokeImpl.getCallValue()",
    "DataWord ProgramInvokeImpl.getCallerAddress()",
    "DataWord ProgramInvokeImpl.getCoinbase()",
    "DataWord ProgramInvokeImpl.getContractAddress()",
    "Repository ProgramInvokeImpl.getDeposit()",
    "long ProgramInvokeImpl.getEnergyLimit()",
    "DataWord ProgramInvokeImpl.getNumber()",
    "DataWord ProgramInvokeImpl.getOriginAddress()",
    "DataWord ProgramInvokeImpl.getPrevHash()",
    "DataWord ProgramInvokeImpl.getTimestamp()",
    "DataWord ProgramInvokeImpl.getTokenId()",
    "DataWord ProgramInvokeImpl.getTokenValue()",
    "long ProgramInvokeImpl.getVmShouldEndInUs()",
    "long ProgramInvokeImpl.getVmStartInUs()",
    "boolean ProgramInvokeImpl.isConstantCall()",
    "boolean ProgramInvokeImpl.isStaticCall()",
    "void ProgramInvokeImpl.setConstantCall()",
    "String ProgramInvokeImpl.toString()"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), null);

    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L);

    // Act
    programInvokeImpl.setConstantCall();
    String actualToStringResult = programInvokeImpl.toString();
    boolean actualByTestingSuiteResult = programInvokeImpl.byTestingSuite();
    DataWord actualBalance = programInvokeImpl.getBalance();
    int actualCallDeep = programInvokeImpl.getCallDeep();
    DataWord actualCallValue = programInvokeImpl.getCallValue();
    DataWord actualCallerAddress = programInvokeImpl.getCallerAddress();
    DataWord actualCoinbase = programInvokeImpl.getCoinbase();
    DataWord actualContractAddress = programInvokeImpl.getContractAddress();
    Repository actualDeposit = programInvokeImpl.getDeposit();
    long actualEnergyLimit = programInvokeImpl.getEnergyLimit();
    DataWord actualNumber = programInvokeImpl.getNumber();
    DataWord actualOriginAddress = programInvokeImpl.getOriginAddress();
    DataWord actualPrevHash = programInvokeImpl.getPrevHash();
    DataWord actualTimestamp = programInvokeImpl.getTimestamp();
    DataWord actualTokenId = programInvokeImpl.getTokenId();
    DataWord actualTokenValue = programInvokeImpl.getTokenValue();
    long actualVmShouldEndInUs = programInvokeImpl.getVmShouldEndInUs();
    long actualVmStartInUs = programInvokeImpl.getVmStartInUs();
    boolean actualIsConstantCallResult = programInvokeImpl.isConstantCall();
    boolean actualIsStaticCallResult = programInvokeImpl.isStaticCall();

    // Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000001",
        actualNumber.toHexString());
    assertEquals(
        "000000000000000000000000000000000000000000000000000000000000000a",
        actualTimestamp.toHexString());
    assertEquals(
        "000000000000000000000000000000000000000000000000000000000000002a",
        actualBalance.toHexString());
    assertEquals(
        "0000000000000000000000000000000000000000000000004158415841584158",
        actualCallerAddress.toHexString());
    assertEquals("01", actualNumber.toPrefixString());
    assertEquals("0a", actualTimestamp.toPrefixString());
    assertEquals("2a", actualBalance.toPrefixString());
    assertEquals("415841", actualCallerAddress.toPrefixString());
    assertEquals(
        "ProgramInvokeImpl{address=0000000000000000000000000000000000000000000000004158415841584158,"
            + " origin=0000000000000000000000000000000000000000000000004158415841584158, caller=0000000000000000000"
            + "000000000000000000000000000004158415841584158, balance=000000000000000000000000000000000000000000000"
            + "000000000000000002a, callValue=000000000000000000000000000000000000000000000000000000000000002a,"
            + " msgData=[65, 88, 65, 88, 65, 88, 65, 88], prevHash=000000000000000000000000000000000000000000000000"
            + "4158415841584158, coinbase=0000000000000000000000000000000000000000000000004158415841584158,"
            + " timestamp=000000000000000000000000000000000000000000000000000000000000000a, number=0000000000000000"
            + "000000000000000000000000000000000000000000000001, byTransaction=true, byTestingSuite=false,"
            + " callDeep=0}",
        actualToStringResult);
    assertEquals(0, actualCallDeep);
    assertEquals(1L, actualEnergyLimit);
    assertEquals(1L, actualVmShouldEndInUs);
    assertEquals(1L, actualVmStartInUs);
    assertFalse(actualBalance.isNegative());
    assertFalse(actualCallerAddress.isNegative());
    assertFalse(actualNumber.isNegative());
    assertFalse(actualTimestamp.isNegative());
    assertFalse(actualBalance.isZero());
    assertFalse(actualCallerAddress.isZero());
    assertFalse(actualNumber.isZero());
    assertFalse(actualTimestamp.isZero());
    assertFalse(actualByTestingSuiteResult);
    assertFalse(actualIsStaticCallResult);
    assertTrue(actualIsConstantCallResult);
    assertEquals(actualBalance, actualCallValue);
    assertEquals(actualBalance, actualTokenValue);
    assertEquals(actualCallerAddress, actualCoinbase);
    assertEquals(actualCallerAddress, actualContractAddress);
    assertEquals(actualCallerAddress, actualOriginAddress);
    assertEquals(actualCallerAddress, actualPrevHash);
    assertEquals(actualNumber, actualTokenId);
    assertSame(deposit, actualDeposit);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCallerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[] {1}, actualNumber.getNoLeadZeroesData());
    assertArrayEquals(new byte[] {'*'}, actualBalance.getNoLeadZeroesData());
    assertArrayEquals(new byte[] {'\n'}, actualTimestamp.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualNumber.getLast20Bytes());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        actualBalance.getLast20Bytes());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        actualTimestamp.getLast20Bytes());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualCallerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualNumber.toTronAddress());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        actualBalance.toTronAddress());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        actualTimestamp.toTronAddress());
    assertArrayEquals(
        new byte[] {
          'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'
        },
        actualCallerAddress.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 1
        },
        actualNumber.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 1
        },
        actualNumber.getData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '*'
        },
        actualBalance.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '*'
        },
        actualBalance.getData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '\n'
        },
        actualTimestamp.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '\n'
        },
        actualTimestamp.getData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X'
        },
        actualCallerAddress.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X'
        },
        actualCallerAddress.getData());
  }

  /**
   * Test {@link ProgramInvokeImpl#equals(Object)}, and {@link ProgramInvokeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProgramInvokeImpl#equals(Object)}
   *   <li>{@link ProgramInvokeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ProgramInvokeImpl.equals(Object)",
    "int ProgramInvokeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), null);

    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L);

    // Act and Assert
    assertEquals(programInvokeImpl, programInvokeImpl);
    int expectedHashCodeResult = programInvokeImpl.hashCode();
    assertEquals(expectedHashCodeResult, programInvokeImpl.hashCode());
  }

  /**
   * Test {@link ProgramInvokeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ProgramInvokeImpl.equals(Object)",
    "int ProgramInvokeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), null);

    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase2 = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit2 = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertNotEquals(
        programInvokeImpl,
        new ProgramInvokeImpl(
            address2, origin2, caller2, 42L, 42L, 42L, 1L, msgData2, lastHash2, coinbase2, 10L, 1L,
            deposit2, 1L, 1L, 1L));
  }

  /**
   * Test {@link ProgramInvokeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ProgramInvokeImpl.equals(Object)",
    "int ProgramInvokeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            42L,
            42L,
            42L,
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            10L,
            1L,
            null,
            1L,
            1L,
            1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertNotEquals(
        programInvokeImpl,
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L));
  }

  /**
   * Test {@link ProgramInvokeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ProgramInvokeImpl.equals(Object)",
    "int ProgramInvokeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3()
      throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), null);
    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            42L,
            42L,
            42L,
            1L,
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            10L,
            1L,
            deposit,
            1L,
            1L,
            true,
            1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit2 = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertNotEquals(
        programInvokeImpl,
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit2, 1L, 1L, 1L));
  }

  /**
   * Test {@link ProgramInvokeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ProgramInvokeImpl.equals(Object)",
    "int ProgramInvokeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsEqual_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeImpl programInvokeImpl =
        new ProgramInvokeImpl(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            42L,
            42L,
            42L,
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            10L,
            1L,
            null,
            1L,
            1L,
            1L);

    // Act and Assert
    assertEquals(
        programInvokeImpl,
        new ProgramInvokeImpl(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            42L,
            42L,
            42L,
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            10L,
            1L,
            null,
            1L,
            1L,
            1L));
  }

  /**
   * Test {@link ProgramInvokeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ProgramInvokeImpl.equals(Object)",
    "int ProgramInvokeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertNotEquals(
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L),
        null);
  }

  /**
   * Test {@link ProgramInvokeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ProgramInvokeImpl.equals(Object)",
    "int ProgramInvokeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), null);

    // Act and Assert
    assertNotEquals(
        new ProgramInvokeImpl(
            address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
            deposit, 1L, 1L, 1L),
        "Different type to ProgramInvokeImpl");
  }
}
