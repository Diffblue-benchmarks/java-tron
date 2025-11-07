package org.tron.core.vm.program.invoke;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class ProgramInvokeMockImplDiffblueTest {
  /**
   * Method under test: {@link ProgramInvokeMockImpl#getContractAddress()}
   */
  @Test
  public void testGetContractAddress() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualContractAddress = programInvokeMockImpl.getContractAddress();

    // Assert
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc",
        actualContractAddress.toHexString());
    assertEquals("41471f", actualContractAddress.toPrefixString());
    assertFalse(actualContractAddress.isNegative());
    assertFalse(actualContractAddress.isZero());
    DataWord expectedDataSize = actualContractAddress.ZERO;
    assertEquals(expectedDataSize, programInvokeMockImpl.getDataSize());
    byte[] data = actualContractAddress.getData();
    assertSame(data, actualContractAddress.getNoEndZeroesData());
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        actualContractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        actualContractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        actualContractAddress.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, actualContractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getBalance()}
   */
  @Test
  public void testGetBalance() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualBalance = programInvokeMockImpl.getBalance();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", actualBalance.toHexString());
    assertEquals("0de0b6", actualBalance.toPrefixString());
    assertFalse(actualBalance.isNegative());
    assertFalse(actualBalance.isZero());
    DataWord expectedDataSize = actualBalance.ZERO;
    assertEquals(expectedDataSize, programInvokeMockImpl.getDataSize());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, actualBalance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        actualBalance.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        actualBalance.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, actualBalance.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, actualBalance.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, actualBalance.getData());
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getOriginAddress()}
   */
  @Test
  public void testGetOriginAddress() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualOriginAddress = programInvokeMockImpl.getOriginAddress();

    // Assert
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", actualOriginAddress.toHexString());
    assertEquals("411397", actualOriginAddress.toPrefixString());
    assertFalse(actualOriginAddress.isNegative());
    assertFalse(actualOriginAddress.isZero());
    DataWord expectedDataSize = actualOriginAddress.ZERO;
    assertEquals(expectedDataSize, programInvokeMockImpl.getDataSize());
    byte[] data = actualOriginAddress.getData();
    assertSame(data, actualOriginAddress.getNoEndZeroesData());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, actualOriginAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, actualOriginAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, actualOriginAddress.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, actualOriginAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getCallerAddress()}
   */
  @Test
  public void testGetCallerAddress() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualCallerAddress = programInvokeMockImpl.getCallerAddress();

    // Assert
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", actualCallerAddress.toHexString());
    assertEquals("41885f", actualCallerAddress.toPrefixString());
    assertFalse(actualCallerAddress.isNegative());
    assertFalse(actualCallerAddress.isZero());
    DataWord expectedDataSize = actualCallerAddress.ZERO;
    assertEquals(expectedDataSize, programInvokeMockImpl.getDataSize());
    byte[] data = actualCallerAddress.getData();
    assertSame(data, actualCallerAddress.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, actualCallerAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, actualCallerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, actualCallerAddress.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, actualCallerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getMinEnergyPrice()}
   */
  @Test
  public void testGetMinEnergyPrice() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualMinEnergyPrice = programInvokeMockImpl.getMinEnergyPrice();

    // Assert
    assertEquals("000000000000000000000000000000000000000000000000000009184e72a000",
        actualMinEnergyPrice.toHexString());
    assertEquals("09184e72a000", actualMinEnergyPrice.toPrefixString());
    assertFalse(actualMinEnergyPrice.isNegative());
    assertFalse(actualMinEnergyPrice.isZero());
    DataWord expectedDataSize = actualMinEnergyPrice.ZERO;
    assertEquals(expectedDataSize, programInvokeMockImpl.getDataSize());
    assertArrayEquals(new byte[]{'\t', 24, 'N', 'r', -96, 0}, actualMinEnergyPrice.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        actualMinEnergyPrice.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        actualMinEnergyPrice.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96}, actualMinEnergyPrice.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, actualMinEnergyPrice.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, actualMinEnergyPrice.getData());
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getCallValue()}
   */
  @Test
  public void testGetCallValue() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualCallValue = programInvokeMockImpl.getCallValue();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", actualCallValue.toHexString());
    assertEquals("0de0b6", actualCallValue.toPrefixString());
    assertFalse(actualCallValue.isNegative());
    assertFalse(actualCallValue.isZero());
    DataWord expectedDataSize = actualCallValue.ZERO;
    assertEquals(expectedDataSize, programInvokeMockImpl.getDataSize());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, actualCallValue.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        actualCallValue.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        actualCallValue.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, actualCallValue.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, actualCallValue.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, actualCallValue.getData());
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getDataValue(DataWord)}
   */
  @Test
  public void testGetDataValue() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();
    DataWord indexData = DataWord.ZERO();

    // Act and Assert
    assertEquals(indexData, programInvokeMockImpl.getDataValue(indexData));
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getDataValue(DataWord)}
   */
  @Test
  public void testGetDataValue2() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl("A A A A ".getBytes("UTF-8"));

    // Act
    DataWord actualDataValue = programInvokeMockImpl.getDataValue(DataWord.ZERO());

    // Assert
    assertEquals("412041", actualDataValue.toPrefixString());
    assertEquals("4120412041204120000000000000000000000000000000000000000000000000", actualDataValue.toHexString());
    assertFalse(actualDataValue.isNegative());
    assertFalse(actualDataValue.isZero());
    byte[] data = actualDataValue.getData();
    assertSame(data, actualDataValue.getNoLeadZeroesData());
    byte[] expectedNoEndZeroesData = "A A A A ".getBytes("UTF-8");
    assertArrayEquals(expectedNoEndZeroesData, actualDataValue.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataValue.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataValue.toTronAddress());
    assertArrayEquals(new byte[]{'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, actualDataValue.getClonedData());
    assertArrayEquals(new byte[]{'A', ' ', 'A', ' ', 'A', ' ', 'A', ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, data);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getDataValue(DataWord)}
   */
  @Test
  public void testGetDataValue3() throws UnsupportedEncodingException {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl("A A A A ".getBytes("UTF-8"));

    // Act
    DataWord actualDataValue = programInvokeMockImpl.getDataValue(DataWord.of((byte) 'A'));

    // Assert
    assertEquals(actualDataValue.ZERO, actualDataValue);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getDataSize()}
   */
  @Test
  public void testGetDataSize() {
    // Arrange and Act
    DataWord actualDataSize = (new ProgramInvokeMockImpl()).getDataSize();

    // Assert
    assertEquals(actualDataSize.ZERO, actualDataSize);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getDataSize()}
   */
  @Test
  public void testGetDataSize2() throws UnsupportedEncodingException {
    // Arrange and Act
    DataWord actualDataSize = (new ProgramInvokeMockImpl("A A A A ".getBytes("UTF-8"))).getDataSize();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", actualDataSize.toHexString());
    assertEquals("08", actualDataSize.toPrefixString());
    assertFalse(actualDataSize.isNegative());
    assertFalse(actualDataSize.isZero());
    byte[] data = actualDataSize.getData();
    assertSame(data, actualDataSize.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'\b'}, actualDataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualDataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualDataSize.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        actualDataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getDataSize()}
   */
  @Test
  public void testGetDataSize3() {
    // Arrange and Act
    DataWord actualDataSize = (new ProgramInvokeMockImpl(new byte[]{})).getDataSize();

    // Assert
    assertEquals(actualDataSize.ZERO, actualDataSize);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#getDataCopy(DataWord, DataWord)}
   */
  @Test
  public void testGetDataCopy() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();
    DataWord offsetData = DataWord.ZERO();

    // Act and Assert
    assertEquals(0, programInvokeMockImpl.getDataCopy(offsetData, DataWord.ZERO()).length);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#getDataCopy(DataWord, DataWord)}
   */
  @Test
  public void testGetDataCopy2() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    DataWord offsetData = DataWord.ZERO();

    // Act and Assert
    assertEquals(0, programInvokeMockImpl.getDataCopy(offsetData, DataWord.ZERO()).length);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#getDataCopy(DataWord, DataWord)}
   */
  @Test
  public void testGetDataCopy3() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    DataWord offsetData = DataWord.of((byte) 'A');

    // Act and Assert
    assertEquals(0, programInvokeMockImpl.getDataCopy(offsetData, DataWord.ZERO()).length);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#getDataCopy(DataWord, DataWord)}
   */
  @Test
  public void testGetDataCopy4() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
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
   * Method under test: {@link ProgramInvokeMockImpl#getPrevHash()}
   */
  @Test
  public void testGetPrevHash() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualPrevHash = programInvokeMockImpl.getPrevHash();

    // Assert
    assertEquals("961cb1", actualPrevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", actualPrevHash.toHexString());
    assertFalse(actualPrevHash.isZero());
    assertTrue(actualPrevHash.isNegative());
    DataWord expectedDataSize = actualPrevHash.ZERO;
    assertEquals(expectedDataSize, programInvokeMockImpl.getDataSize());
    byte[] data = actualPrevHash.getData();
    assertSame(data, actualPrevHash.getNoEndZeroesData());
    assertSame(data, actualPrevHash.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        actualPrevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, actualPrevHash.toTronAddress());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, actualPrevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getCoinbase()}
   */
  @Test
  public void testGetCoinbase() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualCoinbase = programInvokeMockImpl.getCoinbase();

    // Assert
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", actualCoinbase.toHexString());
    assertEquals("e559de", actualCoinbase.toPrefixString());
    assertFalse(actualCoinbase.isNegative());
    assertFalse(actualCoinbase.isZero());
    DataWord expectedDataSize = actualCoinbase.ZERO;
    assertEquals(expectedDataSize, programInvokeMockImpl.getDataSize());
    byte[] data = actualCoinbase.getData();
    assertSame(data, actualCoinbase.getNoEndZeroesData());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        actualCoinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        actualCoinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, actualCoinbase.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, actualCoinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getTimestamp()}
   */
  @Test
  public void testGetTimestamp() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualTimestamp = programInvokeMockImpl.getTimestamp();

    // Assert
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", actualTimestamp.toHexString());
    assertEquals("5387fe24", actualTimestamp.toPrefixString());
    assertFalse(actualTimestamp.isNegative());
    assertFalse(actualTimestamp.isZero());
    DataWord expectedDataSize = actualTimestamp.ZERO;
    assertEquals(expectedDataSize, programInvokeMockImpl.getDataSize());
    byte[] data = actualTimestamp.getData();
    assertSame(data, actualTimestamp.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, actualTimestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        actualTimestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        actualTimestamp.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, actualTimestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getNumber()}
   */
  @Test
  public void testGetNumber() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualNumber = programInvokeMockImpl.getNumber();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", actualNumber.toHexString());
    assertEquals("21", actualNumber.toPrefixString());
    assertFalse(actualNumber.isNegative());
    assertFalse(actualNumber.isZero());
    DataWord expectedDataSize = actualNumber.ZERO;
    assertEquals(expectedDataSize, programInvokeMockImpl.getDataSize());
    byte[] data = actualNumber.getData();
    assertSame(data, actualNumber.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'!'}, actualNumber.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        actualNumber.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        actualNumber.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        actualNumber.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#getDifficulty()}
   */
  @Test
  public void testGetDifficulty() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    DataWord actualDifficulty = programInvokeMockImpl.getDifficulty();

    // Assert
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", actualDifficulty.toHexString());
    assertEquals("3ed290", actualDifficulty.toPrefixString());
    assertFalse(actualDifficulty.isNegative());
    assertFalse(actualDifficulty.isZero());
    DataWord expectedDataSize = actualDifficulty.ZERO;
    assertEquals(expectedDataSize, programInvokeMockImpl.getDataSize());
    byte[] data = actualDifficulty.getData();
    assertSame(data, actualDifficulty.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, actualDifficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        actualDifficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        actualDifficulty.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, actualDifficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#byTestingSuite()}
   */
  @Test
  public void testByTestingSuite() {
    // Arrange, Act and Assert
    assertFalse((new ProgramInvokeMockImpl()).byTestingSuite());
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange
    ProgramInvokeMockImpl programInvokeMockImpl = new ProgramInvokeMockImpl();

    // Act
    programInvokeMockImpl.setEnergyLimit(1L);
    programInvokeMockImpl.setConstantCall();
    int actualCallDeep = programInvokeMockImpl.getCallDeep();
    Repository actualDeposit = programInvokeMockImpl.getDeposit();
    long actualEnergyLimit = programInvokeMockImpl.getEnergyLimit();
    programInvokeMockImpl.getTokenId();
    programInvokeMockImpl.getTokenValue();
    long actualVmShouldEndInUs = programInvokeMockImpl.getVmShouldEndInUs();
    long actualVmStartInUs = programInvokeMockImpl.getVmStartInUs();
    boolean actualIsConstantCallResult = programInvokeMockImpl.isConstantCall();

    // Assert that nothing has changed
    assertTrue(actualDeposit instanceof RepositoryImpl);
    assertEquals(0, actualCallDeep);
    assertEquals(0L, actualVmShouldEndInUs);
    assertEquals(0L, actualVmStartInUs);
    assertEquals(1L, actualEnergyLimit);
    assertFalse(programInvokeMockImpl.isStaticCall());
    assertTrue(actualIsConstantCallResult);
  }

  /**
   * Method under test: {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl()}
   */
  @Test
  public void testNewProgramInvokeMockImpl() {
    // Arrange and Act
    ProgramInvokeMockImpl actualProgramInvokeMockImpl = new ProgramInvokeMockImpl();

    // Assert
    Repository deposit = actualProgramInvokeMockImpl.getDeposit();
    assertTrue(deposit instanceof RepositoryImpl);
    DataWord dataSize = actualProgramInvokeMockImpl.getDataSize();
    assertEquals("00", dataSize.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", dataSize.toHexString());
    DataWord number = actualProgramInvokeMockImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", number.toHexString());
    DataWord difficulty = actualProgramInvokeMockImpl.getDifficulty();
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", difficulty.toHexString());
    DataWord timestamp = actualProgramInvokeMockImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", timestamp.toHexString());
    DataWord minEnergyPrice = actualProgramInvokeMockImpl.getMinEnergyPrice();
    assertEquals("000000000000000000000000000000000000000000000000000009184e72a000", minEnergyPrice.toHexString());
    DataWord balance = actualProgramInvokeMockImpl.getBalance();
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", balance.toHexString());
    DataWord coinbase = actualProgramInvokeMockImpl.getCoinbase();
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", coinbase.toHexString());
    DataWord originAddress = actualProgramInvokeMockImpl.getOriginAddress();
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", originAddress.toHexString());
    DataWord contractAddress = actualProgramInvokeMockImpl.getContractAddress();
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc", contractAddress.toHexString());
    DataWord callerAddress = actualProgramInvokeMockImpl.getCallerAddress();
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", callerAddress.toHexString());
    assertEquals("09184e72a000", minEnergyPrice.toPrefixString());
    assertEquals("0de0b6", balance.toPrefixString());
    assertEquals("21", number.toPrefixString());
    assertEquals("3ed290", difficulty.toPrefixString());
    assertEquals("411397", originAddress.toPrefixString());
    assertEquals("41471f", contractAddress.toPrefixString());
    assertEquals("41885f", callerAddress.toPrefixString());
    assertEquals("5387fe24", timestamp.toPrefixString());
    DataWord prevHash = actualProgramInvokeMockImpl.getPrevHash();
    assertEquals("961cb1", prevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", prevHash.toHexString());
    assertEquals("e559de", coinbase.toPrefixString());
    assertNull(actualProgramInvokeMockImpl.getTokenId());
    assertNull(actualProgramInvokeMockImpl.getTokenValue());
    assertNull(((RepositoryImpl) deposit).getBlockIndexStore());
    assertNull(((RepositoryImpl) deposit).getBlockStore());
    assertNull(((RepositoryImpl) deposit).getKhaosDb());
    assertNull(((RepositoryImpl) deposit).getAbiStore());
    assertNull(((RepositoryImpl) deposit).getAccountStore());
    assertNull(deposit.getAssetIssueStore());
    assertNull(deposit.getAssetIssueV2Store());
    assertNull(((RepositoryImpl) deposit).getCodeStore());
    assertNull(((RepositoryImpl) deposit).getContractStateStore());
    assertNull(((RepositoryImpl) deposit).getContractStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceAccountIndexStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceStore());
    assertNull(deposit.getDelegationStore());
    assertNull(deposit.getDynamicPropertiesStore());
    assertNull(((RepositoryImpl) deposit).getStorageRowStore());
    assertNull(((RepositoryImpl) deposit).getVotesStore());
    assertNull(((RepositoryImpl) deposit).getWitnessStore());
    assertEquals(0, actualProgramInvokeMockImpl.getCallDeep());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmShouldEndInUs());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmStartInUs());
    assertEquals(50L, actualProgramInvokeMockImpl.getEnergyLimit());
    assertFalse(balance.isNegative());
    assertFalse(callerAddress.isNegative());
    assertFalse(coinbase.isNegative());
    assertFalse(contractAddress.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(minEnergyPrice.isNegative());
    assertFalse(number.isNegative());
    assertFalse(originAddress.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(callerAddress.isZero());
    assertFalse(coinbase.isZero());
    assertFalse(contractAddress.isZero());
    assertFalse(difficulty.isZero());
    assertFalse(minEnergyPrice.isZero());
    assertFalse(number.isZero());
    assertFalse(originAddress.isZero());
    assertFalse(prevHash.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeMockImpl.isConstantCall());
    assertFalse(actualProgramInvokeMockImpl.isStaticCall());
    assertTrue(prevHash.isNegative());
    assertTrue(dataSize.isZero());
    assertEquals(balance, actualProgramInvokeMockImpl.getCallValue());
    byte[] data = callerAddress.getData();
    assertSame(data, callerAddress.getNoEndZeroesData());
    byte[] data2 = coinbase.getData();
    assertSame(data2, coinbase.getNoEndZeroesData());
    byte[] data3 = contractAddress.getData();
    assertSame(data3, contractAddress.getNoEndZeroesData());
    byte[] data4 = difficulty.getData();
    assertSame(data4, difficulty.getNoEndZeroesData());
    byte[] data5 = number.getData();
    assertSame(data5, number.getNoEndZeroesData());
    byte[] data6 = originAddress.getData();
    assertSame(data6, originAddress.getNoEndZeroesData());
    byte[] data7 = prevHash.getData();
    assertSame(data7, prevHash.getNoEndZeroesData());
    assertSame(data7, prevHash.getNoLeadZeroesData());
    byte[] data8 = timestamp.getData();
    assertSame(data8, timestamp.getNoEndZeroesData());
    byte[] noEndZeroesData = dataSize.getNoEndZeroesData();
    assertSame(noEndZeroesData, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{'!'}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, difficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\t', 24, 'N', 'r', -96, 0}, minEnergyPrice.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, callerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, originAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        prevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, coinbase.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, prevHash.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, balance.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96}, minEnergyPrice.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, prevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data7);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, coinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data5);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, difficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data4);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, timestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data8);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, callerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, originAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data6);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, contractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data3);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(StoreFactory, byte[], byte[])}
   */
  @Test
  public void testNewProgramInvokeMockImpl2() throws UnsupportedEncodingException {
    // Arrange
    StoreFactory storeFactory = StoreFactory.getInstance();
    byte[] op = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ProgramInvokeMockImpl actualProgramInvokeMockImpl = new ProgramInvokeMockImpl(storeFactory, op,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Repository deposit = actualProgramInvokeMockImpl.getDeposit();
    assertTrue(deposit instanceof RepositoryImpl);
    DataWord dataSize = actualProgramInvokeMockImpl.getDataSize();
    assertEquals("00", dataSize.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", dataSize.toHexString());
    DataWord number = actualProgramInvokeMockImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", number.toHexString());
    DataWord difficulty = actualProgramInvokeMockImpl.getDifficulty();
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", difficulty.toHexString());
    DataWord timestamp = actualProgramInvokeMockImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", timestamp.toHexString());
    DataWord minEnergyPrice = actualProgramInvokeMockImpl.getMinEnergyPrice();
    assertEquals("000000000000000000000000000000000000000000000000000009184e72a000", minEnergyPrice.toHexString());
    DataWord balance = actualProgramInvokeMockImpl.getBalance();
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", balance.toHexString());
    DataWord coinbase = actualProgramInvokeMockImpl.getCoinbase();
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", coinbase.toHexString());
    DataWord originAddress = actualProgramInvokeMockImpl.getOriginAddress();
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", originAddress.toHexString());
    DataWord contractAddress = actualProgramInvokeMockImpl.getContractAddress();
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc", contractAddress.toHexString());
    DataWord callerAddress = actualProgramInvokeMockImpl.getCallerAddress();
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", callerAddress.toHexString());
    assertEquals("09184e72a000", minEnergyPrice.toPrefixString());
    assertEquals("0de0b6", balance.toPrefixString());
    assertEquals("21", number.toPrefixString());
    assertEquals("3ed290", difficulty.toPrefixString());
    assertEquals("411397", originAddress.toPrefixString());
    assertEquals("41471f", contractAddress.toPrefixString());
    assertEquals("41885f", callerAddress.toPrefixString());
    assertEquals("5387fe24", timestamp.toPrefixString());
    DataWord prevHash = actualProgramInvokeMockImpl.getPrevHash();
    assertEquals("961cb1", prevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", prevHash.toHexString());
    assertEquals("e559de", coinbase.toPrefixString());
    assertNull(actualProgramInvokeMockImpl.getTokenId());
    assertNull(actualProgramInvokeMockImpl.getTokenValue());
    assertNull(((RepositoryImpl) deposit).getBlockIndexStore());
    assertNull(((RepositoryImpl) deposit).getBlockStore());
    assertNull(((RepositoryImpl) deposit).getKhaosDb());
    assertNull(((RepositoryImpl) deposit).getAbiStore());
    assertNull(((RepositoryImpl) deposit).getAccountStore());
    assertNull(deposit.getAssetIssueStore());
    assertNull(deposit.getAssetIssueV2Store());
    assertNull(((RepositoryImpl) deposit).getCodeStore());
    assertNull(((RepositoryImpl) deposit).getContractStateStore());
    assertNull(((RepositoryImpl) deposit).getContractStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceAccountIndexStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceStore());
    assertNull(deposit.getDelegationStore());
    assertNull(deposit.getDynamicPropertiesStore());
    assertNull(((RepositoryImpl) deposit).getStorageRowStore());
    assertNull(((RepositoryImpl) deposit).getVotesStore());
    assertNull(((RepositoryImpl) deposit).getWitnessStore());
    assertEquals(0, actualProgramInvokeMockImpl.getCallDeep());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmShouldEndInUs());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmStartInUs());
    assertEquals(50L, actualProgramInvokeMockImpl.getEnergyLimit());
    assertFalse(balance.isNegative());
    assertFalse(callerAddress.isNegative());
    assertFalse(coinbase.isNegative());
    assertFalse(contractAddress.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(minEnergyPrice.isNegative());
    assertFalse(number.isNegative());
    assertFalse(originAddress.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(callerAddress.isZero());
    assertFalse(coinbase.isZero());
    assertFalse(contractAddress.isZero());
    assertFalse(difficulty.isZero());
    assertFalse(minEnergyPrice.isZero());
    assertFalse(number.isZero());
    assertFalse(originAddress.isZero());
    assertFalse(prevHash.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeMockImpl.isConstantCall());
    assertFalse(actualProgramInvokeMockImpl.isStaticCall());
    assertTrue(prevHash.isNegative());
    assertTrue(dataSize.isZero());
    assertEquals(balance, actualProgramInvokeMockImpl.getCallValue());
    byte[] data = callerAddress.getData();
    assertSame(data, callerAddress.getNoEndZeroesData());
    byte[] data2 = coinbase.getData();
    assertSame(data2, coinbase.getNoEndZeroesData());
    byte[] data3 = contractAddress.getData();
    assertSame(data3, contractAddress.getNoEndZeroesData());
    byte[] data4 = difficulty.getData();
    assertSame(data4, difficulty.getNoEndZeroesData());
    byte[] data5 = number.getData();
    assertSame(data5, number.getNoEndZeroesData());
    byte[] data6 = originAddress.getData();
    assertSame(data6, originAddress.getNoEndZeroesData());
    byte[] data7 = prevHash.getData();
    assertSame(data7, prevHash.getNoEndZeroesData());
    assertSame(data7, prevHash.getNoLeadZeroesData());
    byte[] data8 = timestamp.getData();
    assertSame(data8, timestamp.getNoEndZeroesData());
    byte[] noEndZeroesData = dataSize.getNoEndZeroesData();
    assertSame(noEndZeroesData, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{'!'}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, difficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\t', 24, 'N', 'r', -96, 0}, minEnergyPrice.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, callerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, originAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        prevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, coinbase.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, prevHash.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, balance.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96}, minEnergyPrice.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, prevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data7);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, coinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data5);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, difficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data4);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, timestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data8);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, callerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, originAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data6);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, contractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data3);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(StoreFactory, byte[], byte[])}
   */
  @Test
  public void testNewProgramInvokeMockImpl3() throws UnsupportedEncodingException {
    // Arrange
    StoreFactory storeFactory = StoreFactory.getInstance();

    // Act
    ProgramInvokeMockImpl actualProgramInvokeMockImpl = new ProgramInvokeMockImpl(storeFactory, new byte[]{},
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Repository deposit = actualProgramInvokeMockImpl.getDeposit();
    assertTrue(deposit instanceof RepositoryImpl);
    DataWord dataSize = actualProgramInvokeMockImpl.getDataSize();
    assertEquals("00", dataSize.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", dataSize.toHexString());
    DataWord number = actualProgramInvokeMockImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", number.toHexString());
    DataWord difficulty = actualProgramInvokeMockImpl.getDifficulty();
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", difficulty.toHexString());
    DataWord timestamp = actualProgramInvokeMockImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", timestamp.toHexString());
    DataWord minEnergyPrice = actualProgramInvokeMockImpl.getMinEnergyPrice();
    assertEquals("000000000000000000000000000000000000000000000000000009184e72a000", minEnergyPrice.toHexString());
    DataWord balance = actualProgramInvokeMockImpl.getBalance();
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", balance.toHexString());
    DataWord coinbase = actualProgramInvokeMockImpl.getCoinbase();
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", coinbase.toHexString());
    DataWord originAddress = actualProgramInvokeMockImpl.getOriginAddress();
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", originAddress.toHexString());
    DataWord contractAddress = actualProgramInvokeMockImpl.getContractAddress();
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc", contractAddress.toHexString());
    DataWord callerAddress = actualProgramInvokeMockImpl.getCallerAddress();
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", callerAddress.toHexString());
    assertEquals("09184e72a000", minEnergyPrice.toPrefixString());
    assertEquals("0de0b6", balance.toPrefixString());
    assertEquals("21", number.toPrefixString());
    assertEquals("3ed290", difficulty.toPrefixString());
    assertEquals("411397", originAddress.toPrefixString());
    assertEquals("41471f", contractAddress.toPrefixString());
    assertEquals("41885f", callerAddress.toPrefixString());
    assertEquals("5387fe24", timestamp.toPrefixString());
    DataWord prevHash = actualProgramInvokeMockImpl.getPrevHash();
    assertEquals("961cb1", prevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", prevHash.toHexString());
    assertEquals("e559de", coinbase.toPrefixString());
    assertNull(actualProgramInvokeMockImpl.getTokenId());
    assertNull(actualProgramInvokeMockImpl.getTokenValue());
    assertNull(((RepositoryImpl) deposit).getBlockIndexStore());
    assertNull(((RepositoryImpl) deposit).getBlockStore());
    assertNull(((RepositoryImpl) deposit).getKhaosDb());
    assertNull(((RepositoryImpl) deposit).getAbiStore());
    assertNull(((RepositoryImpl) deposit).getAccountStore());
    assertNull(deposit.getAssetIssueStore());
    assertNull(deposit.getAssetIssueV2Store());
    assertNull(((RepositoryImpl) deposit).getCodeStore());
    assertNull(((RepositoryImpl) deposit).getContractStateStore());
    assertNull(((RepositoryImpl) deposit).getContractStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceAccountIndexStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceStore());
    assertNull(deposit.getDelegationStore());
    assertNull(deposit.getDynamicPropertiesStore());
    assertNull(((RepositoryImpl) deposit).getStorageRowStore());
    assertNull(((RepositoryImpl) deposit).getVotesStore());
    assertNull(((RepositoryImpl) deposit).getWitnessStore());
    assertEquals(0, actualProgramInvokeMockImpl.getCallDeep());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmShouldEndInUs());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmStartInUs());
    assertEquals(50L, actualProgramInvokeMockImpl.getEnergyLimit());
    assertFalse(balance.isNegative());
    assertFalse(callerAddress.isNegative());
    assertFalse(coinbase.isNegative());
    assertFalse(contractAddress.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(minEnergyPrice.isNegative());
    assertFalse(number.isNegative());
    assertFalse(originAddress.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(callerAddress.isZero());
    assertFalse(coinbase.isZero());
    assertFalse(contractAddress.isZero());
    assertFalse(difficulty.isZero());
    assertFalse(minEnergyPrice.isZero());
    assertFalse(number.isZero());
    assertFalse(originAddress.isZero());
    assertFalse(prevHash.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeMockImpl.isConstantCall());
    assertFalse(actualProgramInvokeMockImpl.isStaticCall());
    assertTrue(prevHash.isNegative());
    assertTrue(dataSize.isZero());
    assertEquals(balance, actualProgramInvokeMockImpl.getCallValue());
    byte[] data = callerAddress.getData();
    assertSame(data, callerAddress.getNoEndZeroesData());
    byte[] data2 = coinbase.getData();
    assertSame(data2, coinbase.getNoEndZeroesData());
    byte[] data3 = contractAddress.getData();
    assertSame(data3, contractAddress.getNoEndZeroesData());
    byte[] data4 = difficulty.getData();
    assertSame(data4, difficulty.getNoEndZeroesData());
    byte[] data5 = number.getData();
    assertSame(data5, number.getNoEndZeroesData());
    byte[] data6 = originAddress.getData();
    assertSame(data6, originAddress.getNoEndZeroesData());
    byte[] data7 = prevHash.getData();
    assertSame(data7, prevHash.getNoEndZeroesData());
    assertSame(data7, prevHash.getNoLeadZeroesData());
    byte[] data8 = timestamp.getData();
    assertSame(data8, timestamp.getNoEndZeroesData());
    byte[] noEndZeroesData = dataSize.getNoEndZeroesData();
    assertSame(noEndZeroesData, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{'!'}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, difficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\t', 24, 'N', 'r', -96, 0}, minEnergyPrice.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, callerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, originAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        prevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, coinbase.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, prevHash.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, balance.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96}, minEnergyPrice.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, prevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data7);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, coinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data5);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, difficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data4);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, timestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data8);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, callerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, originAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data6);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, contractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data3);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(StoreFactory, byte[], byte[])}
   */
  @Test
  public void testNewProgramInvokeMockImpl4() throws UnsupportedEncodingException {
    // Arrange
    StoreFactory storeFactory = StoreFactory.getInstance();

    // Act
    ProgramInvokeMockImpl actualProgramInvokeMockImpl = new ProgramInvokeMockImpl(storeFactory,
        "AXAXAXAX".getBytes("UTF-8"), new byte[]{});

    // Assert
    Repository deposit = actualProgramInvokeMockImpl.getDeposit();
    assertTrue(deposit instanceof RepositoryImpl);
    DataWord dataSize = actualProgramInvokeMockImpl.getDataSize();
    assertEquals("00", dataSize.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", dataSize.toHexString());
    DataWord number = actualProgramInvokeMockImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", number.toHexString());
    DataWord difficulty = actualProgramInvokeMockImpl.getDifficulty();
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", difficulty.toHexString());
    DataWord timestamp = actualProgramInvokeMockImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", timestamp.toHexString());
    DataWord minEnergyPrice = actualProgramInvokeMockImpl.getMinEnergyPrice();
    assertEquals("000000000000000000000000000000000000000000000000000009184e72a000", minEnergyPrice.toHexString());
    DataWord balance = actualProgramInvokeMockImpl.getBalance();
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", balance.toHexString());
    DataWord coinbase = actualProgramInvokeMockImpl.getCoinbase();
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", coinbase.toHexString());
    DataWord originAddress = actualProgramInvokeMockImpl.getOriginAddress();
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", originAddress.toHexString());
    DataWord contractAddress = actualProgramInvokeMockImpl.getContractAddress();
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc", contractAddress.toHexString());
    DataWord callerAddress = actualProgramInvokeMockImpl.getCallerAddress();
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", callerAddress.toHexString());
    assertEquals("09184e72a000", minEnergyPrice.toPrefixString());
    assertEquals("0de0b6", balance.toPrefixString());
    assertEquals("21", number.toPrefixString());
    assertEquals("3ed290", difficulty.toPrefixString());
    assertEquals("411397", originAddress.toPrefixString());
    assertEquals("41471f", contractAddress.toPrefixString());
    assertEquals("41885f", callerAddress.toPrefixString());
    assertEquals("5387fe24", timestamp.toPrefixString());
    DataWord prevHash = actualProgramInvokeMockImpl.getPrevHash();
    assertEquals("961cb1", prevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", prevHash.toHexString());
    assertEquals("e559de", coinbase.toPrefixString());
    assertNull(actualProgramInvokeMockImpl.getTokenId());
    assertNull(actualProgramInvokeMockImpl.getTokenValue());
    assertNull(((RepositoryImpl) deposit).getBlockIndexStore());
    assertNull(((RepositoryImpl) deposit).getBlockStore());
    assertNull(((RepositoryImpl) deposit).getKhaosDb());
    assertNull(((RepositoryImpl) deposit).getAbiStore());
    assertNull(((RepositoryImpl) deposit).getAccountStore());
    assertNull(deposit.getAssetIssueStore());
    assertNull(deposit.getAssetIssueV2Store());
    assertNull(((RepositoryImpl) deposit).getCodeStore());
    assertNull(((RepositoryImpl) deposit).getContractStateStore());
    assertNull(((RepositoryImpl) deposit).getContractStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceAccountIndexStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceStore());
    assertNull(deposit.getDelegationStore());
    assertNull(deposit.getDynamicPropertiesStore());
    assertNull(((RepositoryImpl) deposit).getStorageRowStore());
    assertNull(((RepositoryImpl) deposit).getVotesStore());
    assertNull(((RepositoryImpl) deposit).getWitnessStore());
    assertEquals(0, actualProgramInvokeMockImpl.getCallDeep());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmShouldEndInUs());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmStartInUs());
    assertEquals(50L, actualProgramInvokeMockImpl.getEnergyLimit());
    assertFalse(balance.isNegative());
    assertFalse(callerAddress.isNegative());
    assertFalse(coinbase.isNegative());
    assertFalse(contractAddress.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(minEnergyPrice.isNegative());
    assertFalse(number.isNegative());
    assertFalse(originAddress.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(callerAddress.isZero());
    assertFalse(coinbase.isZero());
    assertFalse(contractAddress.isZero());
    assertFalse(difficulty.isZero());
    assertFalse(minEnergyPrice.isZero());
    assertFalse(number.isZero());
    assertFalse(originAddress.isZero());
    assertFalse(prevHash.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeMockImpl.isConstantCall());
    assertFalse(actualProgramInvokeMockImpl.isStaticCall());
    assertTrue(prevHash.isNegative());
    assertTrue(dataSize.isZero());
    assertEquals(balance, actualProgramInvokeMockImpl.getCallValue());
    byte[] data = callerAddress.getData();
    assertSame(data, callerAddress.getNoEndZeroesData());
    byte[] data2 = coinbase.getData();
    assertSame(data2, coinbase.getNoEndZeroesData());
    byte[] data3 = contractAddress.getData();
    assertSame(data3, contractAddress.getNoEndZeroesData());
    byte[] data4 = difficulty.getData();
    assertSame(data4, difficulty.getNoEndZeroesData());
    byte[] data5 = number.getData();
    assertSame(data5, number.getNoEndZeroesData());
    byte[] data6 = originAddress.getData();
    assertSame(data6, originAddress.getNoEndZeroesData());
    byte[] data7 = prevHash.getData();
    assertSame(data7, prevHash.getNoEndZeroesData());
    assertSame(data7, prevHash.getNoLeadZeroesData());
    byte[] data8 = timestamp.getData();
    assertSame(data8, timestamp.getNoEndZeroesData());
    byte[] noEndZeroesData = dataSize.getNoEndZeroesData();
    assertSame(noEndZeroesData, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{'!'}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, difficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\t', 24, 'N', 'r', -96, 0}, minEnergyPrice.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, callerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, originAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        prevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, coinbase.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, prevHash.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, balance.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96}, minEnergyPrice.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, prevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data7);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, coinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data5);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, difficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data4);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, timestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data8);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, callerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, originAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data6);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, contractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data3);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(boolean)}
   */
  @Test
  public void testNewProgramInvokeMockImpl5() {
    // Arrange and Act
    ProgramInvokeMockImpl actualProgramInvokeMockImpl = new ProgramInvokeMockImpl(true);

    // Assert
    DataWord dataSize = actualProgramInvokeMockImpl.getDataSize();
    assertEquals("00", dataSize.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", dataSize.toHexString());
    DataWord number = actualProgramInvokeMockImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", number.toHexString());
    DataWord difficulty = actualProgramInvokeMockImpl.getDifficulty();
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", difficulty.toHexString());
    DataWord timestamp = actualProgramInvokeMockImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", timestamp.toHexString());
    DataWord minEnergyPrice = actualProgramInvokeMockImpl.getMinEnergyPrice();
    assertEquals("000000000000000000000000000000000000000000000000000009184e72a000", minEnergyPrice.toHexString());
    DataWord balance = actualProgramInvokeMockImpl.getBalance();
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", balance.toHexString());
    DataWord coinbase = actualProgramInvokeMockImpl.getCoinbase();
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", coinbase.toHexString());
    DataWord originAddress = actualProgramInvokeMockImpl.getOriginAddress();
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", originAddress.toHexString());
    DataWord contractAddress = actualProgramInvokeMockImpl.getContractAddress();
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc", contractAddress.toHexString());
    DataWord callerAddress = actualProgramInvokeMockImpl.getCallerAddress();
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", callerAddress.toHexString());
    assertEquals("09184e72a000", minEnergyPrice.toPrefixString());
    assertEquals("0de0b6", balance.toPrefixString());
    assertEquals("21", number.toPrefixString());
    assertEquals("3ed290", difficulty.toPrefixString());
    assertEquals("411397", originAddress.toPrefixString());
    assertEquals("41471f", contractAddress.toPrefixString());
    assertEquals("41885f", callerAddress.toPrefixString());
    assertEquals("5387fe24", timestamp.toPrefixString());
    DataWord prevHash = actualProgramInvokeMockImpl.getPrevHash();
    assertEquals("961cb1", prevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", prevHash.toHexString());
    assertEquals("e559de", coinbase.toPrefixString());
    assertNull(actualProgramInvokeMockImpl.getTokenId());
    assertNull(actualProgramInvokeMockImpl.getTokenValue());
    assertNull(actualProgramInvokeMockImpl.getDeposit());
    assertEquals(0, actualProgramInvokeMockImpl.getCallDeep());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmShouldEndInUs());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmStartInUs());
    assertEquals(50L, actualProgramInvokeMockImpl.getEnergyLimit());
    assertFalse(balance.isNegative());
    assertFalse(callerAddress.isNegative());
    assertFalse(coinbase.isNegative());
    assertFalse(contractAddress.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(minEnergyPrice.isNegative());
    assertFalse(number.isNegative());
    assertFalse(originAddress.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(callerAddress.isZero());
    assertFalse(coinbase.isZero());
    assertFalse(contractAddress.isZero());
    assertFalse(difficulty.isZero());
    assertFalse(minEnergyPrice.isZero());
    assertFalse(number.isZero());
    assertFalse(originAddress.isZero());
    assertFalse(prevHash.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeMockImpl.isConstantCall());
    assertFalse(actualProgramInvokeMockImpl.isStaticCall());
    assertTrue(prevHash.isNegative());
    assertTrue(dataSize.isZero());
    assertEquals(balance, actualProgramInvokeMockImpl.getCallValue());
    byte[] data = callerAddress.getData();
    assertSame(data, callerAddress.getNoEndZeroesData());
    byte[] data2 = coinbase.getData();
    assertSame(data2, coinbase.getNoEndZeroesData());
    byte[] data3 = contractAddress.getData();
    assertSame(data3, contractAddress.getNoEndZeroesData());
    byte[] data4 = difficulty.getData();
    assertSame(data4, difficulty.getNoEndZeroesData());
    byte[] data5 = number.getData();
    assertSame(data5, number.getNoEndZeroesData());
    byte[] data6 = originAddress.getData();
    assertSame(data6, originAddress.getNoEndZeroesData());
    byte[] data7 = prevHash.getData();
    assertSame(data7, prevHash.getNoEndZeroesData());
    assertSame(data7, prevHash.getNoLeadZeroesData());
    byte[] data8 = timestamp.getData();
    assertSame(data8, timestamp.getNoEndZeroesData());
    byte[] noEndZeroesData = dataSize.getNoEndZeroesData();
    assertSame(noEndZeroesData, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{'!'}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, difficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\t', 24, 'N', 'r', -96, 0}, minEnergyPrice.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, callerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, originAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        prevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, coinbase.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, prevHash.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, balance.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96}, minEnergyPrice.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, prevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data7);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, coinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data5);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, difficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data4);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, timestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data8);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, callerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, originAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data6);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, contractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data3);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(byte[])}
   */
  @Test
  public void testNewProgramInvokeMockImpl6() throws UnsupportedEncodingException {
    // Arrange and Act
    ProgramInvokeMockImpl actualProgramInvokeMockImpl = new ProgramInvokeMockImpl("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Repository deposit = actualProgramInvokeMockImpl.getDeposit();
    assertTrue(deposit instanceof RepositoryImpl);
    DataWord dataSize = actualProgramInvokeMockImpl.getDataSize();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", dataSize.toHexString());
    DataWord number = actualProgramInvokeMockImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", number.toHexString());
    DataWord difficulty = actualProgramInvokeMockImpl.getDifficulty();
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", difficulty.toHexString());
    DataWord timestamp = actualProgramInvokeMockImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", timestamp.toHexString());
    DataWord minEnergyPrice = actualProgramInvokeMockImpl.getMinEnergyPrice();
    assertEquals("000000000000000000000000000000000000000000000000000009184e72a000", minEnergyPrice.toHexString());
    DataWord balance = actualProgramInvokeMockImpl.getBalance();
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", balance.toHexString());
    DataWord coinbase = actualProgramInvokeMockImpl.getCoinbase();
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", coinbase.toHexString());
    DataWord originAddress = actualProgramInvokeMockImpl.getOriginAddress();
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", originAddress.toHexString());
    DataWord contractAddress = actualProgramInvokeMockImpl.getContractAddress();
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc", contractAddress.toHexString());
    DataWord callerAddress = actualProgramInvokeMockImpl.getCallerAddress();
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", callerAddress.toHexString());
    assertEquals("08", dataSize.toPrefixString());
    assertEquals("09184e72a000", minEnergyPrice.toPrefixString());
    assertEquals("0de0b6", balance.toPrefixString());
    assertEquals("21", number.toPrefixString());
    assertEquals("3ed290", difficulty.toPrefixString());
    assertEquals("411397", originAddress.toPrefixString());
    assertEquals("41471f", contractAddress.toPrefixString());
    assertEquals("41885f", callerAddress.toPrefixString());
    assertEquals("5387fe24", timestamp.toPrefixString());
    DataWord prevHash = actualProgramInvokeMockImpl.getPrevHash();
    assertEquals("961cb1", prevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", prevHash.toHexString());
    assertEquals("e559de", coinbase.toPrefixString());
    assertNull(actualProgramInvokeMockImpl.getTokenId());
    assertNull(actualProgramInvokeMockImpl.getTokenValue());
    assertNull(((RepositoryImpl) deposit).getBlockIndexStore());
    assertNull(((RepositoryImpl) deposit).getBlockStore());
    assertNull(((RepositoryImpl) deposit).getKhaosDb());
    assertNull(((RepositoryImpl) deposit).getAbiStore());
    assertNull(((RepositoryImpl) deposit).getAccountStore());
    assertNull(deposit.getAssetIssueStore());
    assertNull(deposit.getAssetIssueV2Store());
    assertNull(((RepositoryImpl) deposit).getCodeStore());
    assertNull(((RepositoryImpl) deposit).getContractStateStore());
    assertNull(((RepositoryImpl) deposit).getContractStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceAccountIndexStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceStore());
    assertNull(deposit.getDelegationStore());
    assertNull(deposit.getDynamicPropertiesStore());
    assertNull(((RepositoryImpl) deposit).getStorageRowStore());
    assertNull(((RepositoryImpl) deposit).getVotesStore());
    assertNull(((RepositoryImpl) deposit).getWitnessStore());
    assertEquals(0, actualProgramInvokeMockImpl.getCallDeep());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmShouldEndInUs());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmStartInUs());
    assertEquals(50L, actualProgramInvokeMockImpl.getEnergyLimit());
    assertFalse(balance.isNegative());
    assertFalse(callerAddress.isNegative());
    assertFalse(coinbase.isNegative());
    assertFalse(contractAddress.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(minEnergyPrice.isNegative());
    assertFalse(number.isNegative());
    assertFalse(originAddress.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(callerAddress.isZero());
    assertFalse(coinbase.isZero());
    assertFalse(contractAddress.isZero());
    assertFalse(dataSize.isZero());
    assertFalse(difficulty.isZero());
    assertFalse(minEnergyPrice.isZero());
    assertFalse(number.isZero());
    assertFalse(originAddress.isZero());
    assertFalse(prevHash.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeMockImpl.isConstantCall());
    assertFalse(actualProgramInvokeMockImpl.isStaticCall());
    assertTrue(prevHash.isNegative());
    assertEquals(balance, actualProgramInvokeMockImpl.getCallValue());
    byte[] data = callerAddress.getData();
    assertSame(data, callerAddress.getNoEndZeroesData());
    byte[] data2 = coinbase.getData();
    assertSame(data2, coinbase.getNoEndZeroesData());
    byte[] data3 = contractAddress.getData();
    assertSame(data3, contractAddress.getNoEndZeroesData());
    byte[] data4 = dataSize.getData();
    assertSame(data4, dataSize.getNoEndZeroesData());
    byte[] data5 = difficulty.getData();
    assertSame(data5, difficulty.getNoEndZeroesData());
    byte[] data6 = number.getData();
    assertSame(data6, number.getNoEndZeroesData());
    byte[] data7 = originAddress.getData();
    assertSame(data7, originAddress.getNoEndZeroesData());
    byte[] data8 = prevHash.getData();
    assertSame(data8, prevHash.getNoEndZeroesData());
    assertSame(data8, prevHash.getNoLeadZeroesData());
    byte[] data9 = timestamp.getData();
    assertSame(data9, timestamp.getNoEndZeroesData());
    assertArrayEquals(new byte[]{'!'}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\b'}, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, difficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\t', 24, 'N', 'r', -96, 0}, minEnergyPrice.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, callerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, originAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        prevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, coinbase.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, prevHash.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, balance.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96}, minEnergyPrice.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, prevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data8);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, coinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data6);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data4);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, difficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data5);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, timestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data9);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, callerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, originAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data7);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, contractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data3);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(byte[])}
   */
  @Test
  public void testNewProgramInvokeMockImpl7() {
    // Arrange and Act
    ProgramInvokeMockImpl actualProgramInvokeMockImpl = new ProgramInvokeMockImpl(null);

    // Assert
    Repository deposit = actualProgramInvokeMockImpl.getDeposit();
    assertTrue(deposit instanceof RepositoryImpl);
    DataWord dataSize = actualProgramInvokeMockImpl.getDataSize();
    assertEquals("00", dataSize.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", dataSize.toHexString());
    DataWord number = actualProgramInvokeMockImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", number.toHexString());
    DataWord difficulty = actualProgramInvokeMockImpl.getDifficulty();
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", difficulty.toHexString());
    DataWord timestamp = actualProgramInvokeMockImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", timestamp.toHexString());
    DataWord minEnergyPrice = actualProgramInvokeMockImpl.getMinEnergyPrice();
    assertEquals("000000000000000000000000000000000000000000000000000009184e72a000", minEnergyPrice.toHexString());
    DataWord balance = actualProgramInvokeMockImpl.getBalance();
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", balance.toHexString());
    DataWord coinbase = actualProgramInvokeMockImpl.getCoinbase();
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", coinbase.toHexString());
    DataWord originAddress = actualProgramInvokeMockImpl.getOriginAddress();
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", originAddress.toHexString());
    DataWord contractAddress = actualProgramInvokeMockImpl.getContractAddress();
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc", contractAddress.toHexString());
    DataWord callerAddress = actualProgramInvokeMockImpl.getCallerAddress();
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", callerAddress.toHexString());
    assertEquals("09184e72a000", minEnergyPrice.toPrefixString());
    assertEquals("0de0b6", balance.toPrefixString());
    assertEquals("21", number.toPrefixString());
    assertEquals("3ed290", difficulty.toPrefixString());
    assertEquals("411397", originAddress.toPrefixString());
    assertEquals("41471f", contractAddress.toPrefixString());
    assertEquals("41885f", callerAddress.toPrefixString());
    assertEquals("5387fe24", timestamp.toPrefixString());
    DataWord prevHash = actualProgramInvokeMockImpl.getPrevHash();
    assertEquals("961cb1", prevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", prevHash.toHexString());
    assertEquals("e559de", coinbase.toPrefixString());
    assertNull(actualProgramInvokeMockImpl.getTokenId());
    assertNull(actualProgramInvokeMockImpl.getTokenValue());
    assertNull(((RepositoryImpl) deposit).getBlockIndexStore());
    assertNull(((RepositoryImpl) deposit).getBlockStore());
    assertNull(((RepositoryImpl) deposit).getKhaosDb());
    assertNull(((RepositoryImpl) deposit).getAbiStore());
    assertNull(((RepositoryImpl) deposit).getAccountStore());
    assertNull(deposit.getAssetIssueStore());
    assertNull(deposit.getAssetIssueV2Store());
    assertNull(((RepositoryImpl) deposit).getCodeStore());
    assertNull(((RepositoryImpl) deposit).getContractStateStore());
    assertNull(((RepositoryImpl) deposit).getContractStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceAccountIndexStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceStore());
    assertNull(deposit.getDelegationStore());
    assertNull(deposit.getDynamicPropertiesStore());
    assertNull(((RepositoryImpl) deposit).getStorageRowStore());
    assertNull(((RepositoryImpl) deposit).getVotesStore());
    assertNull(((RepositoryImpl) deposit).getWitnessStore());
    assertEquals(0, actualProgramInvokeMockImpl.getCallDeep());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmShouldEndInUs());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmStartInUs());
    assertEquals(50L, actualProgramInvokeMockImpl.getEnergyLimit());
    assertFalse(balance.isNegative());
    assertFalse(callerAddress.isNegative());
    assertFalse(coinbase.isNegative());
    assertFalse(contractAddress.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(minEnergyPrice.isNegative());
    assertFalse(number.isNegative());
    assertFalse(originAddress.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(callerAddress.isZero());
    assertFalse(coinbase.isZero());
    assertFalse(contractAddress.isZero());
    assertFalse(difficulty.isZero());
    assertFalse(minEnergyPrice.isZero());
    assertFalse(number.isZero());
    assertFalse(originAddress.isZero());
    assertFalse(prevHash.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeMockImpl.isConstantCall());
    assertFalse(actualProgramInvokeMockImpl.isStaticCall());
    assertTrue(prevHash.isNegative());
    assertTrue(dataSize.isZero());
    assertEquals(balance, actualProgramInvokeMockImpl.getCallValue());
    byte[] data = callerAddress.getData();
    assertSame(data, callerAddress.getNoEndZeroesData());
    byte[] data2 = coinbase.getData();
    assertSame(data2, coinbase.getNoEndZeroesData());
    byte[] data3 = contractAddress.getData();
    assertSame(data3, contractAddress.getNoEndZeroesData());
    byte[] data4 = difficulty.getData();
    assertSame(data4, difficulty.getNoEndZeroesData());
    byte[] data5 = number.getData();
    assertSame(data5, number.getNoEndZeroesData());
    byte[] data6 = originAddress.getData();
    assertSame(data6, originAddress.getNoEndZeroesData());
    byte[] data7 = prevHash.getData();
    assertSame(data7, prevHash.getNoEndZeroesData());
    assertSame(data7, prevHash.getNoLeadZeroesData());
    byte[] data8 = timestamp.getData();
    assertSame(data8, timestamp.getNoEndZeroesData());
    byte[] noEndZeroesData = dataSize.getNoEndZeroesData();
    assertSame(noEndZeroesData, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{'!'}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, difficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\t', 24, 'N', 'r', -96, 0}, minEnergyPrice.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, callerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, originAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        prevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, coinbase.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, prevHash.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, balance.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96}, minEnergyPrice.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, prevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data7);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, coinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data5);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, difficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data4);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, timestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data8);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, callerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, originAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data6);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, contractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data3);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(byte[], byte[])}
   */
  @Test
  public void testNewProgramInvokeMockImpl8() throws UnsupportedEncodingException {
    // Arrange
    byte[] op = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ProgramInvokeMockImpl actualProgramInvokeMockImpl = new ProgramInvokeMockImpl(op, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Repository deposit = actualProgramInvokeMockImpl.getDeposit();
    assertTrue(deposit instanceof RepositoryImpl);
    DataWord dataSize = actualProgramInvokeMockImpl.getDataSize();
    assertEquals("00", dataSize.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", dataSize.toHexString());
    DataWord number = actualProgramInvokeMockImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", number.toHexString());
    DataWord difficulty = actualProgramInvokeMockImpl.getDifficulty();
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", difficulty.toHexString());
    DataWord timestamp = actualProgramInvokeMockImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", timestamp.toHexString());
    DataWord minEnergyPrice = actualProgramInvokeMockImpl.getMinEnergyPrice();
    assertEquals("000000000000000000000000000000000000000000000000000009184e72a000", minEnergyPrice.toHexString());
    DataWord balance = actualProgramInvokeMockImpl.getBalance();
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", balance.toHexString());
    DataWord coinbase = actualProgramInvokeMockImpl.getCoinbase();
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", coinbase.toHexString());
    DataWord originAddress = actualProgramInvokeMockImpl.getOriginAddress();
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", originAddress.toHexString());
    DataWord contractAddress = actualProgramInvokeMockImpl.getContractAddress();
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc", contractAddress.toHexString());
    DataWord callerAddress = actualProgramInvokeMockImpl.getCallerAddress();
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", callerAddress.toHexString());
    assertEquals("09184e72a000", minEnergyPrice.toPrefixString());
    assertEquals("0de0b6", balance.toPrefixString());
    assertEquals("21", number.toPrefixString());
    assertEquals("3ed290", difficulty.toPrefixString());
    assertEquals("411397", originAddress.toPrefixString());
    assertEquals("41471f", contractAddress.toPrefixString());
    assertEquals("41885f", callerAddress.toPrefixString());
    assertEquals("5387fe24", timestamp.toPrefixString());
    DataWord prevHash = actualProgramInvokeMockImpl.getPrevHash();
    assertEquals("961cb1", prevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", prevHash.toHexString());
    assertEquals("e559de", coinbase.toPrefixString());
    assertNull(actualProgramInvokeMockImpl.getTokenId());
    assertNull(actualProgramInvokeMockImpl.getTokenValue());
    assertNull(((RepositoryImpl) deposit).getBlockIndexStore());
    assertNull(((RepositoryImpl) deposit).getBlockStore());
    assertNull(((RepositoryImpl) deposit).getKhaosDb());
    assertNull(((RepositoryImpl) deposit).getAbiStore());
    assertNull(((RepositoryImpl) deposit).getAccountStore());
    assertNull(deposit.getAssetIssueStore());
    assertNull(deposit.getAssetIssueV2Store());
    assertNull(((RepositoryImpl) deposit).getCodeStore());
    assertNull(((RepositoryImpl) deposit).getContractStateStore());
    assertNull(((RepositoryImpl) deposit).getContractStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceAccountIndexStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceStore());
    assertNull(deposit.getDelegationStore());
    assertNull(deposit.getDynamicPropertiesStore());
    assertNull(((RepositoryImpl) deposit).getStorageRowStore());
    assertNull(((RepositoryImpl) deposit).getVotesStore());
    assertNull(((RepositoryImpl) deposit).getWitnessStore());
    assertEquals(0, actualProgramInvokeMockImpl.getCallDeep());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmShouldEndInUs());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmStartInUs());
    assertEquals(50L, actualProgramInvokeMockImpl.getEnergyLimit());
    assertFalse(balance.isNegative());
    assertFalse(callerAddress.isNegative());
    assertFalse(coinbase.isNegative());
    assertFalse(contractAddress.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(minEnergyPrice.isNegative());
    assertFalse(number.isNegative());
    assertFalse(originAddress.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(callerAddress.isZero());
    assertFalse(coinbase.isZero());
    assertFalse(contractAddress.isZero());
    assertFalse(difficulty.isZero());
    assertFalse(minEnergyPrice.isZero());
    assertFalse(number.isZero());
    assertFalse(originAddress.isZero());
    assertFalse(prevHash.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeMockImpl.isConstantCall());
    assertFalse(actualProgramInvokeMockImpl.isStaticCall());
    assertTrue(prevHash.isNegative());
    assertTrue(dataSize.isZero());
    assertEquals(balance, actualProgramInvokeMockImpl.getCallValue());
    byte[] data = callerAddress.getData();
    assertSame(data, callerAddress.getNoEndZeroesData());
    byte[] data2 = coinbase.getData();
    assertSame(data2, coinbase.getNoEndZeroesData());
    byte[] data3 = contractAddress.getData();
    assertSame(data3, contractAddress.getNoEndZeroesData());
    byte[] data4 = difficulty.getData();
    assertSame(data4, difficulty.getNoEndZeroesData());
    byte[] data5 = number.getData();
    assertSame(data5, number.getNoEndZeroesData());
    byte[] data6 = originAddress.getData();
    assertSame(data6, originAddress.getNoEndZeroesData());
    byte[] data7 = prevHash.getData();
    assertSame(data7, prevHash.getNoEndZeroesData());
    assertSame(data7, prevHash.getNoLeadZeroesData());
    byte[] data8 = timestamp.getData();
    assertSame(data8, timestamp.getNoEndZeroesData());
    byte[] noEndZeroesData = dataSize.getNoEndZeroesData();
    assertSame(noEndZeroesData, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{'!'}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, difficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\t', 24, 'N', 'r', -96, 0}, minEnergyPrice.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, callerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, originAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        prevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, coinbase.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, prevHash.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, balance.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96}, minEnergyPrice.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, prevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data7);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, coinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data5);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, difficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data4);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, timestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data8);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, callerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, originAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data6);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, contractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data3);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(byte[], byte[])}
   */
  @Test
  public void testNewProgramInvokeMockImpl9() throws UnsupportedEncodingException {
    // Arrange and Act
    ProgramInvokeMockImpl actualProgramInvokeMockImpl = new ProgramInvokeMockImpl(new byte[]{},
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Repository deposit = actualProgramInvokeMockImpl.getDeposit();
    assertTrue(deposit instanceof RepositoryImpl);
    DataWord dataSize = actualProgramInvokeMockImpl.getDataSize();
    assertEquals("00", dataSize.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", dataSize.toHexString());
    DataWord number = actualProgramInvokeMockImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", number.toHexString());
    DataWord difficulty = actualProgramInvokeMockImpl.getDifficulty();
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", difficulty.toHexString());
    DataWord timestamp = actualProgramInvokeMockImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", timestamp.toHexString());
    DataWord minEnergyPrice = actualProgramInvokeMockImpl.getMinEnergyPrice();
    assertEquals("000000000000000000000000000000000000000000000000000009184e72a000", minEnergyPrice.toHexString());
    DataWord balance = actualProgramInvokeMockImpl.getBalance();
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", balance.toHexString());
    DataWord coinbase = actualProgramInvokeMockImpl.getCoinbase();
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", coinbase.toHexString());
    DataWord originAddress = actualProgramInvokeMockImpl.getOriginAddress();
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", originAddress.toHexString());
    DataWord contractAddress = actualProgramInvokeMockImpl.getContractAddress();
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc", contractAddress.toHexString());
    DataWord callerAddress = actualProgramInvokeMockImpl.getCallerAddress();
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", callerAddress.toHexString());
    assertEquals("09184e72a000", minEnergyPrice.toPrefixString());
    assertEquals("0de0b6", balance.toPrefixString());
    assertEquals("21", number.toPrefixString());
    assertEquals("3ed290", difficulty.toPrefixString());
    assertEquals("411397", originAddress.toPrefixString());
    assertEquals("41471f", contractAddress.toPrefixString());
    assertEquals("41885f", callerAddress.toPrefixString());
    assertEquals("5387fe24", timestamp.toPrefixString());
    DataWord prevHash = actualProgramInvokeMockImpl.getPrevHash();
    assertEquals("961cb1", prevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", prevHash.toHexString());
    assertEquals("e559de", coinbase.toPrefixString());
    assertNull(actualProgramInvokeMockImpl.getTokenId());
    assertNull(actualProgramInvokeMockImpl.getTokenValue());
    assertNull(((RepositoryImpl) deposit).getBlockIndexStore());
    assertNull(((RepositoryImpl) deposit).getBlockStore());
    assertNull(((RepositoryImpl) deposit).getKhaosDb());
    assertNull(((RepositoryImpl) deposit).getAbiStore());
    assertNull(((RepositoryImpl) deposit).getAccountStore());
    assertNull(deposit.getAssetIssueStore());
    assertNull(deposit.getAssetIssueV2Store());
    assertNull(((RepositoryImpl) deposit).getCodeStore());
    assertNull(((RepositoryImpl) deposit).getContractStateStore());
    assertNull(((RepositoryImpl) deposit).getContractStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceAccountIndexStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceStore());
    assertNull(deposit.getDelegationStore());
    assertNull(deposit.getDynamicPropertiesStore());
    assertNull(((RepositoryImpl) deposit).getStorageRowStore());
    assertNull(((RepositoryImpl) deposit).getVotesStore());
    assertNull(((RepositoryImpl) deposit).getWitnessStore());
    assertEquals(0, actualProgramInvokeMockImpl.getCallDeep());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmShouldEndInUs());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmStartInUs());
    assertEquals(50L, actualProgramInvokeMockImpl.getEnergyLimit());
    assertFalse(balance.isNegative());
    assertFalse(callerAddress.isNegative());
    assertFalse(coinbase.isNegative());
    assertFalse(contractAddress.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(minEnergyPrice.isNegative());
    assertFalse(number.isNegative());
    assertFalse(originAddress.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(callerAddress.isZero());
    assertFalse(coinbase.isZero());
    assertFalse(contractAddress.isZero());
    assertFalse(difficulty.isZero());
    assertFalse(minEnergyPrice.isZero());
    assertFalse(number.isZero());
    assertFalse(originAddress.isZero());
    assertFalse(prevHash.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeMockImpl.isConstantCall());
    assertFalse(actualProgramInvokeMockImpl.isStaticCall());
    assertTrue(prevHash.isNegative());
    assertTrue(dataSize.isZero());
    assertEquals(balance, actualProgramInvokeMockImpl.getCallValue());
    byte[] data = callerAddress.getData();
    assertSame(data, callerAddress.getNoEndZeroesData());
    byte[] data2 = coinbase.getData();
    assertSame(data2, coinbase.getNoEndZeroesData());
    byte[] data3 = contractAddress.getData();
    assertSame(data3, contractAddress.getNoEndZeroesData());
    byte[] data4 = difficulty.getData();
    assertSame(data4, difficulty.getNoEndZeroesData());
    byte[] data5 = number.getData();
    assertSame(data5, number.getNoEndZeroesData());
    byte[] data6 = originAddress.getData();
    assertSame(data6, originAddress.getNoEndZeroesData());
    byte[] data7 = prevHash.getData();
    assertSame(data7, prevHash.getNoEndZeroesData());
    assertSame(data7, prevHash.getNoLeadZeroesData());
    byte[] data8 = timestamp.getData();
    assertSame(data8, timestamp.getNoEndZeroesData());
    byte[] noEndZeroesData = dataSize.getNoEndZeroesData();
    assertSame(noEndZeroesData, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{'!'}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, difficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\t', 24, 'N', 'r', -96, 0}, minEnergyPrice.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, callerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, originAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        prevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, coinbase.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, prevHash.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, balance.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96}, minEnergyPrice.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, prevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data7);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, coinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data5);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, difficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data4);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, timestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data8);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, callerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, originAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data6);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, contractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data3);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeMockImpl#ProgramInvokeMockImpl(byte[], byte[])}
   */
  @Test
  public void testNewProgramInvokeMockImpl10() throws UnsupportedEncodingException {
    // Arrange and Act
    ProgramInvokeMockImpl actualProgramInvokeMockImpl = new ProgramInvokeMockImpl("AXAXAXAX".getBytes("UTF-8"),
        new byte[]{});

    // Assert
    Repository deposit = actualProgramInvokeMockImpl.getDeposit();
    assertTrue(deposit instanceof RepositoryImpl);
    DataWord dataSize = actualProgramInvokeMockImpl.getDataSize();
    assertEquals("00", dataSize.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", dataSize.toHexString());
    DataWord number = actualProgramInvokeMockImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000021", number.toHexString());
    DataWord difficulty = actualProgramInvokeMockImpl.getDifficulty();
    assertEquals("00000000000000000000000000000000000000000000000000000000003ed290", difficulty.toHexString());
    DataWord timestamp = actualProgramInvokeMockImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000005387fe24", timestamp.toHexString());
    DataWord minEnergyPrice = actualProgramInvokeMockImpl.getMinEnergyPrice();
    assertEquals("000000000000000000000000000000000000000000000000000009184e72a000", minEnergyPrice.toHexString());
    DataWord balance = actualProgramInvokeMockImpl.getBalance();
    assertEquals("0000000000000000000000000000000000000000000000000de0b6b3a7640000", balance.toHexString());
    DataWord coinbase = actualProgramInvokeMockImpl.getCoinbase();
    assertEquals("000000000000000000000000e559de5527492bcb42ec68d07df0742a98ec3f1e", coinbase.toHexString());
    DataWord originAddress = actualProgramInvokeMockImpl.getOriginAddress();
    assertEquals("00000000000000000000004113978aee95f38490e9769c39b2773ed763d9cd5f", originAddress.toHexString());
    DataWord contractAddress = actualProgramInvokeMockImpl.getContractAddress();
    assertEquals("000000000000000000000041471fd3ad3e9eeadeec4608b92d16ce6b500704cc", contractAddress.toHexString());
    DataWord callerAddress = actualProgramInvokeMockImpl.getCallerAddress();
    assertEquals("000000000000000000000041885f93eed577f2fc341ebb9a5c9b2ce4465d96c4", callerAddress.toHexString());
    assertEquals("09184e72a000", minEnergyPrice.toPrefixString());
    assertEquals("0de0b6", balance.toPrefixString());
    assertEquals("21", number.toPrefixString());
    assertEquals("3ed290", difficulty.toPrefixString());
    assertEquals("411397", originAddress.toPrefixString());
    assertEquals("41471f", contractAddress.toPrefixString());
    assertEquals("41885f", callerAddress.toPrefixString());
    assertEquals("5387fe24", timestamp.toPrefixString());
    DataWord prevHash = actualProgramInvokeMockImpl.getPrevHash();
    assertEquals("961cb1", prevHash.toPrefixString());
    assertEquals("961cb117aba86d1e596854015a1483323f18883c2d745b0bc03e87f146d2bb1c", prevHash.toHexString());
    assertEquals("e559de", coinbase.toPrefixString());
    assertNull(actualProgramInvokeMockImpl.getTokenId());
    assertNull(actualProgramInvokeMockImpl.getTokenValue());
    assertNull(((RepositoryImpl) deposit).getBlockIndexStore());
    assertNull(((RepositoryImpl) deposit).getBlockStore());
    assertNull(((RepositoryImpl) deposit).getKhaosDb());
    assertNull(((RepositoryImpl) deposit).getAbiStore());
    assertNull(((RepositoryImpl) deposit).getAccountStore());
    assertNull(deposit.getAssetIssueStore());
    assertNull(deposit.getAssetIssueV2Store());
    assertNull(((RepositoryImpl) deposit).getCodeStore());
    assertNull(((RepositoryImpl) deposit).getContractStateStore());
    assertNull(((RepositoryImpl) deposit).getContractStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceAccountIndexStore());
    assertNull(((RepositoryImpl) deposit).getDelegatedResourceStore());
    assertNull(deposit.getDelegationStore());
    assertNull(deposit.getDynamicPropertiesStore());
    assertNull(((RepositoryImpl) deposit).getStorageRowStore());
    assertNull(((RepositoryImpl) deposit).getVotesStore());
    assertNull(((RepositoryImpl) deposit).getWitnessStore());
    assertEquals(0, actualProgramInvokeMockImpl.getCallDeep());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmShouldEndInUs());
    assertEquals(0L, actualProgramInvokeMockImpl.getVmStartInUs());
    assertEquals(50L, actualProgramInvokeMockImpl.getEnergyLimit());
    assertFalse(balance.isNegative());
    assertFalse(callerAddress.isNegative());
    assertFalse(coinbase.isNegative());
    assertFalse(contractAddress.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(minEnergyPrice.isNegative());
    assertFalse(number.isNegative());
    assertFalse(originAddress.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(callerAddress.isZero());
    assertFalse(coinbase.isZero());
    assertFalse(contractAddress.isZero());
    assertFalse(difficulty.isZero());
    assertFalse(minEnergyPrice.isZero());
    assertFalse(number.isZero());
    assertFalse(originAddress.isZero());
    assertFalse(prevHash.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeMockImpl.isConstantCall());
    assertFalse(actualProgramInvokeMockImpl.isStaticCall());
    assertTrue(prevHash.isNegative());
    assertTrue(dataSize.isZero());
    assertEquals(balance, actualProgramInvokeMockImpl.getCallValue());
    byte[] data = callerAddress.getData();
    assertSame(data, callerAddress.getNoEndZeroesData());
    byte[] data2 = coinbase.getData();
    assertSame(data2, coinbase.getNoEndZeroesData());
    byte[] data3 = contractAddress.getData();
    assertSame(data3, contractAddress.getNoEndZeroesData());
    byte[] data4 = difficulty.getData();
    assertSame(data4, difficulty.getNoEndZeroesData());
    byte[] data5 = number.getData();
    assertSame(data5, number.getNoEndZeroesData());
    byte[] data6 = originAddress.getData();
    assertSame(data6, originAddress.getNoEndZeroesData());
    byte[] data7 = prevHash.getData();
    assertSame(data7, prevHash.getNoEndZeroesData());
    assertSame(data7, prevHash.getNoLeadZeroesData());
    byte[] data8 = timestamp.getData();
    assertSame(data8, timestamp.getNoEndZeroesData());
    byte[] noEndZeroesData = dataSize.getNoEndZeroesData();
    assertSame(noEndZeroesData, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{'!'}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'>', -46, -112}, difficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'S', -121, -2, '$'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\t', 24, 'N', 'r', -96, 0}, minEnergyPrice.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\r', -32, -74, -77, -89, 'd', 0, 0}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{-120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28, 'F',
        ']', -106, -60}, callerAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getLast20Bytes());
    assertArrayEquals(
        new byte[]{-27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*', -104, -20, '?', 30},
        coinbase.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>', -41,
        'c', -39, -51, '_'}, originAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getLast20Bytes());
    assertArrayEquals(
        new byte[]{'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28},
        prevHash.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30, -69, -102, '\\', -101, ',', -28,
        'F', ']', -106, -60}, callerAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20, 'h', -48, '}', -16, 't', '*',
        -104, -20, '?', 30}, coinbase.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '>', -46, -112},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'S', -121, -2, '$'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24, 'N', 'r', -96, 0},
        minEnergyPrice.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74, -77, -89, 'd', 0, 0},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'A', 19, -105, -118, -18, -107, -13, -124, -112, -23, 'v', -100, '9', -78, 'w', '>',
        -41, 'c', -39, -51, '_'}, originAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[]{'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F', '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52},
        contractAddress.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'Z', 20, -125, '2', '?', 24, -120, '<', '-', 't', '[', 11, -64, '>', -121, -15,
        'F', -46, -69, 28}, prevHash.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd'}, balance.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96}, minEnergyPrice.getNoEndZeroesData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, prevHash.getClonedData());
    assertArrayEquals(new byte[]{-106, 28, -79, 23, -85, -88, 'm', 30, 'Y', 'h', 'T', 1, 'Z', 20, -125, '2', '?', 24,
        -120, '<', '-', 't', '[', 11, -64, '>', -121, -15, 'F', -46, -69, 28}, data7);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, coinbase.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 'Y', -34, 'U', '\'', 'I', '+', -53, 'B', -20,
        'h', -48, '}', -16, 't', '*', -104, -20, '?', 30}, data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        dataSize.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '!'},
        data5);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, difficulty.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        '>', -46, -112}, data4);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, timestamp.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        'S', -121, -2, '$'}, data8);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\t', 24,
        'N', 'r', -96, 0}, minEnergyPrice.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\r', -32, -74,
        -77, -89, 'd', 0, 0}, balance.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, callerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', -120, '_', -109, -18, -43, 'w', -14, -4, '4', 30,
        -69, -102, '\\', -101, ',', -28, 'F', ']', -106, -60}, data);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, originAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 19, -105, -118, -18, -107, -13, -124, -112, -23,
        'v', -100, '9', -78, 'w', '>', -41, 'c', -39, -51, '_'}, data6);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, contractAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'G', 31, -45, -83, '>', -98, -22, -34, -20, 'F',
        '\b', -71, '-', 22, -50, 'k', 'P', 7, 4, -52}, data3);
  }
}
