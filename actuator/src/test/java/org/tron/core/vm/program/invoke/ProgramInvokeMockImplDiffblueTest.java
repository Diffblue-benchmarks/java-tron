package org.tron.core.vm.program.invoke;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.ChainBaseManager;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class ProgramInvokeMockImplDiffblueTest {
  /**
   * Test {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramInvokeMockImpl.<init>()"})
  public void testNewProgramInvokeMockImpl() {
    // Arrange and Act
    ProgramInvokeMockImpl actualProgramInvokeMockImpl = new ProgramInvokeMockImpl();

    // Assert
    assertTrue(actualProgramInvokeMockImpl.getDeposit() instanceof RepositoryImpl);
    assertNull(actualProgramInvokeMockImpl.getTokenId());
    assertNull(actualProgramInvokeMockImpl.getTokenValue());
    assertEquals(0, actualProgramInvokeMockImpl.getCallDeep());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmShouldEndInUs());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmStartInUs());
    assertEquals(50L, actualProgramInvokeMockImpl.getEnergyLimit());
    assertFalse(actualProgramInvokeMockImpl.isConstantCall());
    assertFalse(actualProgramInvokeMockImpl.isStaticCall());
  }

  /**
   * Test {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(boolean)}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramInvokeMockImpl.<init>(boolean)"})
  public void testNewProgramInvokeMockImpl2() {
    // Arrange and Act
    ProgramInvokeMockImpl actualProgramInvokeMockImpl = new ProgramInvokeMockImpl(true);

    // Assert
    assertNull(actualProgramInvokeMockImpl.getTokenId());
    assertNull(actualProgramInvokeMockImpl.getTokenValue());
    assertNull(actualProgramInvokeMockImpl.getDeposit());
    assertEquals(0, actualProgramInvokeMockImpl.getCallDeep());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmShouldEndInUs());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmStartInUs());
    assertEquals(50L, actualProgramInvokeMockImpl.getEnergyLimit());
    assertFalse(actualProgramInvokeMockImpl.isConstantCall());
    assertFalse(actualProgramInvokeMockImpl.isStaticCall());
  }

  /**
   * Test {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(StoreFactory, byte[], byte[])}.
   *
   * <ul>
   *   <li>Given {@link ChainBaseManager} (default constructor).
   *   <li>Then calls {@link StoreFactory#getChainBaseManager()}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(StoreFactory, byte[],
   * byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProgramInvokeMockImpl.<init>(StoreFactory, byte[], byte[])"})
  public void testNewProgramInvokeMockImpl_givenChainBaseManager_thenCallsGetChainBaseManager()
      throws UnsupportedEncodingException {
    // Arrange
    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(new ChainBaseManager());

    // Act
    new ProgramInvokeMockImpl(
        storeFactory, "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(storeFactory).getChainBaseManager();
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getContractAddress()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getContractAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getContractAddress()"})
  public void testGetContractAddress() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualContractAddress = programInvokeMockImpl.getContractAddress();

    // Assert
    assertEquals(
        "000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc",
        actualContractAddress.toHexString());
    assertEquals("41471f", actualContractAddress.toPrefixString());
    assertFalse(actualContractAddress.isNegative());
    assertFalse(actualContractAddress.isZero());
    assertEquals(DataWord.ZERO, programInvokeMockImpl.getDataSize());
    byte[] data = actualContractAddress.getData();
    assertSame(data, actualContractAddress.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4,
          -52
        },
        actualContractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P',
          7, 4, -52
        },
        actualContractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {
          'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P',
          7, 4, -52
        },
        actualContractAddress.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
          '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52
        },
        actualContractAddress.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
          '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52
        },
        data);
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getBalance()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getBalance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getBalance()"})
  public void testGetBalance() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualBalance = programInvokeMockImpl.getBalance();

    // Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000000de0b6b3a7640000",
        actualBalance.toHexString());
    assertEquals("0de0b6", actualBalance.toPrefixString());
    assertFalse(actualBalance.isNegative());
    assertFalse(actualBalance.isZero());
    assertEquals(DataWord.ZERO, programInvokeMockImpl.getDataSize());
    assertArrayEquals(
        new byte[] {'\r', -32, -74, -77, -89, 'd', 0, 0}, actualBalance.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        actualBalance.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        actualBalance.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
          -77, -89, 'd'
        },
        actualBalance.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
          -77, -89, 'd', 0, 0
        },
        actualBalance.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
          -77, -89, 'd', 0, 0
        },
        actualBalance.getData());
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getOriginAddress()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getOriginAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getOriginAddress()"})
  public void testGetOriginAddress() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualOriginAddress = programInvokeMockImpl.getOriginAddress();

    // Assert
    assertEquals(
        "00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f",
        actualOriginAddress.toHexString());
    assertEquals("411397", actualOriginAddress.toPrefixString());
    assertFalse(actualOriginAddress.isNegative());
    assertFalse(actualOriginAddress.isZero());
    assertEquals(DataWord.ZERO, programInvokeMockImpl.getDataSize());
    byte[] data = actualOriginAddress.getData();
    assertSame(data, actualOriginAddress.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41, 'c',
          -39, -51, '_'
        },
        actualOriginAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
          'c', -39, -51, '_'
        },
        actualOriginAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {
          'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
          'c', -39, -51, '_'
        },
        actualOriginAddress.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
          'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'
        },
        actualOriginAddress.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
          'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'
        },
        data);
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getCallerAddress()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getCallerAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getCallerAddress()"})
  public void testGetCallerAddress() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualCallerAddress = programInvokeMockImpl.getCallerAddress();

    // Assert
    assertEquals(
        "000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4",
        actualCallerAddress.toHexString());
    assertEquals("41885f", actualCallerAddress.toPrefixString());
    assertFalse(actualCallerAddress.isNegative());
    assertFalse(actualCallerAddress.isZero());
    assertEquals(DataWord.ZERO, programInvokeMockImpl.getDataSize());
    byte[] data = actualCallerAddress.getData();
    assertSame(data, actualCallerAddress.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
          ']', -106, -60
        },
        actualCallerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
          'F', ']', -106, -60
        },
        actualCallerAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {
          'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
          'F', ']', -106, -60
        },
        actualCallerAddress.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
          -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60
        },
        actualCallerAddress.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
          -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60
        },
        data);
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getMinEnergyPrice()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getMinEnergyPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getMinEnergyPrice()"})
  public void testGetMinEnergyPrice() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualMinEnergyPrice = programInvokeMockImpl.getMinEnergyPrice();

    // Assert
    assertEquals(
        "000000000000000000000000000000000000000000000000000009184e72a000",
        actualMinEnergyPrice.toHexString());
    assertEquals("09184e72a000", actualMinEnergyPrice.toPrefixString());
    assertFalse(actualMinEnergyPrice.isNegative());
    assertFalse(actualMinEnergyPrice.isZero());
    assertEquals(DataWord.ZERO, programInvokeMockImpl.getDataSize());
    assertArrayEquals(
        new byte[] {'\t', 24, 'N', 'r', -96, 0}, actualMinEnergyPrice.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        actualMinEnergyPrice.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        actualMinEnergyPrice.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
          'N', 'r', -96
        },
        actualMinEnergyPrice.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
          'N', 'r', -96, 0
        },
        actualMinEnergyPrice.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
          'N', 'r', -96, 0
        },
        actualMinEnergyPrice.getData());
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getCallValue()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getCallValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getCallValue()"})
  public void testGetCallValue() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualCallValue = programInvokeMockImpl.getCallValue();

    // Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000000de0b6b3a7640000",
        actualCallValue.toHexString());
    assertEquals("0de0b6", actualCallValue.toPrefixString());
    assertFalse(actualCallValue.isNegative());
    assertFalse(actualCallValue.isZero());
    assertEquals(DataWord.ZERO, programInvokeMockImpl.getDataSize());
    assertArrayEquals(
        new byte[] {'\r', -32, -74, -77, -89, 'd', 0, 0}, actualCallValue.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        actualCallValue.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        actualCallValue.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
          -77, -89, 'd'
        },
        actualCallValue.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
          -77, -89, 'd', 0, 0
        },
        actualCallValue.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
          -77, -89, 'd', 0, 0
        },
        actualCallValue.getData());
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getDataValue(DataWord)}.
   *
   * <ul>
   *   <li>Given {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.
   *   <li>When ZERO.
   *   <li>Then return ZERO.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getDataValue(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getDataValue(DataWord)"})
  public void testGetDataValue_givenProgramInvokeMockImpl_whenZero_thenReturnZero() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();
    DataWord indexData = DataWord.ZERO();

    // Act
    DataWord actualDataValue = programInvokeMockImpl.getDataValue(indexData);

    // Assert
    assertEquals(indexData, actualDataValue);
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getDataValue(DataWord)}.
   *
   * <ul>
   *   <li>Then return toPrefixString is {@code 412041}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getDataValue(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getDataValue(DataWord)"})
  public void testGetDataValue_thenReturnToPrefixStringIs412041()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl =
        new ProgramInvokeMockImpl("A A A A ".getBytes("UTF-8"));

    // Act
    DataWord actualDataValue = programInvokeMockImpl.getDataValue(DataWord.ZERO());

    // Assert
    assertEquals("412041", actualDataValue.toPrefixString());
    assertEquals(
        "4120412041204120000000000000000000000000000000000000000000000000",
        actualDataValue.toHexString());
    assertFalse(actualDataValue.isZero());
    byte[] data = actualDataValue.getData();
    assertSame(data, actualDataValue.getNoLeadZeroesData());
    assertArrayEquals("A A A A ".getBytes("UTF-8"), actualDataValue.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataValue.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataValue.toTronAddress());
    assertArrayEquals(
        new byte[] {
          'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0
        },
        actualDataValue.getClonedData());
    assertArrayEquals(
        new byte[] {
          'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0
        },
        data);
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getDataValue(DataWord)}.
   *
   * <ul>
   *   <li>When {@link DataWord} with num is {@code A}.
   *   <li>Then return {@link DataWord#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getDataValue(DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getDataValue(DataWord)"})
  public void testGetDataValue_whenDataWordWithNumIsA_thenReturnZero()
      throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl =
        new ProgramInvokeMockImpl("A A A A ".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(DataWord.ZERO, programInvokeMockImpl.getDataValue(DataWord.of((byte) 'A')));
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getDataSize()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getDataSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getDataSize()"})
  public void testGetDataSize() throws UnsupportedEncodingException {
    // Arrange and Act
    DataWord actualDataSize = new ProgramInvokeMockImpl("A A A A ".getBytes("UTF-8")).getDataSize();

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
   * Test {@link ProgramInvokeMockImpl#getDataSize()}.
   *
   * <ul>
   *   <li>Given {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getDataSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getDataSize()"})
  public void testGetDataSize_givenProgramInvokeMockImpl() {
    // Arrange and Act
    DataWord actualDataSize = new ProgramInvokeMockImpl().getDataSize();

    // Assert
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataSize.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataSize.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualDataSize.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualDataSize.getData());
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getDataSize()}.
   *
   * <ul>
   *   <li>Given {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(byte[])} with msgDataRaw is
   *       empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getDataSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getDataSize()"})
  public void testGetDataSize_givenProgramInvokeMockImplWithMsgDataRawIsEmptyArrayOfByte() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl(new byte[] {});

    // Act
    DataWord actualDataSize = programInvokeMockImpl.getDataSize();

    // Assert
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataSize.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataSize.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualDataSize.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0
        },
        actualDataSize.getData());
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getDataCopy(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link DataWord} with num is {@code A}.
   *   <li>Then return eleventh element is zero.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getDataCopy(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramInvokeMockImpl.getDataCopy(DataWord, DataWord)"})
  public void testGetDataCopy_givenA_whenDataWordWithNumIsA_thenReturnEleventhElementIsZero() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl =
        new ProgramInvokeMockImpl(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    DataWord offsetData = DataWord.ZERO();

    // Act
    byte[] actualDataCopy = programInvokeMockImpl.getDataCopy(offsetData, DataWord.of((byte) 'A'));

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
    assertEquals((byte) 1, actualDataCopy[1]);
    assertEquals((byte) 1, actualDataCopy[3]);
    assertEquals((byte) 1, actualDataCopy[5]);
    assertEquals((byte) 1, actualDataCopy[7]);
    assertEquals(65, actualDataCopy.length);
    assertEquals('A', actualDataCopy[0]);
    assertEquals('A', actualDataCopy[2]);
    assertEquals('A', actualDataCopy[4]);
    assertEquals('A', actualDataCopy[6]);
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getDataCopy(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link DataWord} with num is {@code A}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getDataCopy(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramInvokeMockImpl.getDataCopy(DataWord, DataWord)"})
  public void testGetDataCopy_givenA_whenDataWordWithNumIsA_thenReturnEmptyArrayOfByte() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl =
        new ProgramInvokeMockImpl(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    DataWord offsetData = DataWord.of((byte) 'A');

    // Act and Assert
    assertArrayEquals(
        new byte[] {}, programInvokeMockImpl.getDataCopy(offsetData, DataWord.ZERO()));
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getDataCopy(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When ZERO.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getDataCopy(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramInvokeMockImpl.getDataCopy(DataWord, DataWord)"})
  public void testGetDataCopy_givenA_whenZero_thenReturnEmptyArrayOfByte() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl =
        new ProgramInvokeMockImpl(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    DataWord offsetData = DataWord.ZERO();

    // Act and Assert
    assertArrayEquals(
        new byte[] {}, programInvokeMockImpl.getDataCopy(offsetData, DataWord.ZERO()));
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getDataCopy(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>Given {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}.
   *   <li>When ZERO.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getDataCopy(DataWord, DataWord)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ProgramInvokeMockImpl.getDataCopy(DataWord, DataWord)"})
  public void testGetDataCopy_givenProgramInvokeMockImpl_whenZero_thenReturnEmptyArrayOfByte() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();
    DataWord offsetData = DataWord.ZERO();

    // Act and Assert
    assertArrayEquals(
        new byte[] {}, programInvokeMockImpl.getDataCopy(offsetData, DataWord.ZERO()));
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getPrevHash()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getPrevHash()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getPrevHash()"})
  public void testGetPrevHash() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualPrevHash = programInvokeMockImpl.getPrevHash();

    // Assert
    assertEquals("961cb1", actualPrevHash.toPrefixString());
    assertEquals(
        "961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c",
        actualPrevHash.toHexString());
    assertFalse(actualPrevHash.isZero());
    assertTrue(actualPrevHash.isNegative());
    assertEquals(DataWord.ZERO, programInvokeMockImpl.getDataSize());
    byte[] data = actualPrevHash.getData();
    assertSame(data, actualPrevHash.getNoEndZeroesData());
    assertSame(data, actualPrevHash.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {
          'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46,
          -69, 28
        },
        actualPrevHash.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F',
          -46, -69, 28
        },
        actualPrevHash.toTronAddress());
    assertArrayEquals(
        new byte[] {
          -106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24, -120,
          '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28
        },
        actualPrevHash.getClonedData());
    assertArrayEquals(
        new byte[] {
          -106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24, -120,
          '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28
        },
        data);
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getCoinbase()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getCoinbase()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getCoinbase()"})
  public void testGetCoinbase() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualCoinbase = programInvokeMockImpl.getCoinbase();

    // Assert
    assertEquals(
        "000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e",
        actualCoinbase.toHexString());
    assertEquals("e559de", actualCoinbase.toPrefixString());
    assertFalse(actualCoinbase.isNegative());
    assertFalse(actualCoinbase.isZero());
    assertEquals(DataWord.ZERO, programInvokeMockImpl.getDataSize());
    byte[] data = actualCoinbase.getData();
    assertSame(data, actualCoinbase.getNoEndZeroesData());
    assertArrayEquals(
        new byte[] {
          -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104,
          -20, '?', 30
        },
        actualCoinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104,
          -20, '?', 30
        },
        actualCoinbase.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {
          'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
          -104, -20, '?', 30
        },
        actualCoinbase.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
          'h', -48, '}', -16, 't', '*', -104, -20, '?', 30
        },
        actualCoinbase.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
          'h', -48, '}', -16, 't', '*', -104, -20, '?', 30
        },
        data);
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getTimestamp()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getTimestamp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getTimestamp()"})
  public void testGetTimestamp() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualTimestamp = programInvokeMockImpl.getTimestamp();

    // Assert
    assertEquals(
        "000000000000000000000000000000000000000000000000000000005387fe24",
        actualTimestamp.toHexString());
    assertEquals("5387fe24", actualTimestamp.toPrefixString());
    assertFalse(actualTimestamp.isNegative());
    assertFalse(actualTimestamp.isZero());
    assertEquals(DataWord.ZERO, programInvokeMockImpl.getDataSize());
    byte[] data = actualTimestamp.getData();
    assertSame(data, actualTimestamp.getNoEndZeroesData());
    assertArrayEquals(new byte[] {'S', -121, -2, '$'}, actualTimestamp.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        actualTimestamp.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        actualTimestamp.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S',
          -121, -2, '$'
        },
        actualTimestamp.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S',
          -121, -2, '$'
        },
        data);
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getNumber()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getNumber()"})
  public void testGetNumber() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualNumber = programInvokeMockImpl.getNumber();

    // Assert
    assertEquals(
        "0000000000000000000000000000000000000000000000000000000000000021",
        actualNumber.toHexString());
    assertEquals("21", actualNumber.toPrefixString());
    assertFalse(actualNumber.isNegative());
    assertFalse(actualNumber.isZero());
    assertEquals(DataWord.ZERO, programInvokeMockImpl.getDataSize());
    byte[] data = actualNumber.getData();
    assertSame(data, actualNumber.getNoEndZeroesData());
    assertArrayEquals(new byte[] {'!'}, actualNumber.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        actualNumber.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        actualNumber.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '!'
        },
        actualNumber.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, '!'
        },
        data);
  }

  /**
   * Test {@link ProgramInvokeMockImpl#getDifficulty()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#getDifficulty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWord ProgramInvokeMockImpl.getDifficulty()"})
  public void testGetDifficulty() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualDifficulty = programInvokeMockImpl.getDifficulty();

    // Assert
    assertEquals(
        "00000000000000000000000000000000000000000000000000000000003ed290",
        actualDifficulty.toHexString());
    assertEquals("3ed290", actualDifficulty.toPrefixString());
    assertFalse(actualDifficulty.isNegative());
    assertFalse(actualDifficulty.isZero());
    assertEquals(DataWord.ZERO, programInvokeMockImpl.getDataSize());
    byte[] data = actualDifficulty.getData();
    assertSame(data, actualDifficulty.getNoEndZeroesData());
    assertArrayEquals(new byte[] {'>', -46, -112}, actualDifficulty.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        actualDifficulty.getLast20Bytes());
    assertArrayEquals(
        new byte[] {'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        actualDifficulty.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          '>', -46, -112
        },
        actualDifficulty.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          '>', -46, -112
        },
        data);
  }

  /**
   * Test {@link ProgramInvokeMockImpl#byTestingSuite()}.
   *
   * <p>Method under test: {@link ProgramInvokeMockImpl#byTestingSuite()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProgramInvokeMockImpl.byTestingSuite()"})
  public void testByTestingSuite() {
    // Arrange, Act and Assert
    assertFalse(new ProgramInvokeMockImpl().byTestingSuite());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProgramInvokeMockImpl#setEnergyLimit(long)}
   *   <li>{@link ProgramInvokeMockImpl#setConstantCall()}
   *   <li>{@link ProgramInvokeMockImpl#getCallDeep()}
   *   <li>{@link ProgramInvokeMockImpl#getDeposit()}
   *   <li>{@link ProgramInvokeMockImpl#getEnergyLimit()}
   *   <li>{@link ProgramInvokeMockImpl#getTokenId()}
   *   <li>{@link ProgramInvokeMockImpl#getTokenValue()}
   *   <li>{@link ProgramInvokeMockImpl#getVmShouldEndInUs()}
   *   <li>{@link ProgramInvokeMockImpl#getVmStartInUs()}
   *   <li>{@link ProgramInvokeMockImpl#isConstantCall()}
   *   <li>{@link ProgramInvokeMockImpl#isStaticCall()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "int ProgramInvokeMockImpl.getCallDeep()",
    "Repository ProgramInvokeMockImpl.getDeposit()",
    "long ProgramInvokeMockImpl.getEnergyLimit()",
    "DataWord ProgramInvokeMockImpl.getTokenId()",
    "DataWord ProgramInvokeMockImpl.getTokenValue()",
    "long ProgramInvokeMockImpl.getVmShouldEndInUs()",
    "long ProgramInvokeMockImpl.getVmStartInUs()",
    "boolean ProgramInvokeMockImpl.isConstantCall()",
    "boolean ProgramInvokeMockImpl.isStaticCall()",
    "void ProgramInvokeMockImpl.setConstantCall()",
    "void ProgramInvokeMockImpl.setEnergyLimit(long)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    programInvokeMockImpl.setEnergyLimit(1L);
    programInvokeMockImpl.setConstantCall();
    int actualCallDeep = programInvokeMockImpl.getCallDeep();
    Repository actualDeposit = programInvokeMockImpl.getDeposit();
    long actualEnergyLimit = programInvokeMockImpl.getEnergyLimit();
    DataWord actualTokenId = programInvokeMockImpl.getTokenId();
    DataWord actualTokenValue = programInvokeMockImpl.getTokenValue();
    long actualVmShouldEndInUs = programInvokeMockImpl.getVmShouldEndInUs();
    long actualVmStartInUs = programInvokeMockImpl.getVmStartInUs();
    boolean actualIsConstantCallResult = programInvokeMockImpl.isConstantCall();

    // Assert
    assertTrue(actualDeposit instanceof RepositoryImpl);
    assertNull(actualTokenId);
    assertNull(actualTokenValue);
    assertEquals(0, actualCallDeep);
    assertEquals(0L, actualVmShouldEndInUs);
    assertEquals(0L, actualVmStartInUs);
    assertEquals(1L, actualEnergyLimit);
    assertFalse(programInvokeMockImpl.isStaticCall());
    assertTrue(actualIsConstantCallResult);
  }
}
