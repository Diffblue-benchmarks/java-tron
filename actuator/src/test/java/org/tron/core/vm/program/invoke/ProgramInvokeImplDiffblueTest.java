package org.tron.core.vm.program.invoke;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.ChainBaseManager;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class ProgramInvokeImplDiffblueTest {
  /**
   * Method under test: {@link ProgramInvokeImpl#getDataValue(DataWord)}
   */
  @Test
  public void testGetDataValue() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 1L, 1L,
        1L);

    // Act
    DataWord actualDataValue = programInvokeImpl.getDataValue(DataWord.ZERO());

    // Assert
    assertEquals("415841", actualDataValue.toPrefixString());
    assertEquals("4158415841584158000000000000000000000000000000000000000000000000", actualDataValue.toHexString());
    assertFalse(actualDataValue.isNegative());
    assertFalse(actualDataValue.isZero());
    byte[] data = actualDataValue.getData();
    assertSame(data, actualDataValue.getNoLeadZeroesData());
    byte[] expectedNoEndZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoEndZeroesData, actualDataValue.getNoEndZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataValue.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        actualDataValue.toTronAddress());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, actualDataValue.getClonedData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0}, data);
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#getDataValue(DataWord)}
   */
  @Test
  public void testGetDataValue2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        new byte[]{}, lastHash, coinbase, 10L, 1L,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 1L, 1L, 1L);
    DataWord indexData = DataWord.ZERO();

    // Act
    DataWord actualDataValue = programInvokeImpl.getDataValue(indexData);

    // Assert
    assertEquals(indexData, actualDataValue);
    DataWord expectedDataSize = actualDataValue.ZERO;
    assertSame(expectedDataSize, programInvokeImpl.getDataSize());
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#getDataSize()}
   */
  @Test
  public void testGetDataSize() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 1L, 1L,
        1L);

    // Act
    DataWord actualDataSize = programInvokeImpl.getDataSize();

    // Assert
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", actualDataSize.toHexString());
    assertEquals("08", actualDataSize.toPrefixString());
    assertFalse(actualDataSize.isNegative());
    assertFalse(actualDataSize.isZero());
    DataWord expectedDifficulty = actualDataSize.ZERO;
    assertEquals(expectedDifficulty, programInvokeImpl.getDifficulty());
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
   * Method under test: {@link ProgramInvokeImpl#getDataSize()}
   */
  @Test
  public void testGetDataSize2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        new byte[]{}, lastHash, coinbase, 10L, 1L,
        new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 1L, 1L, 1L);

    // Act
    DataWord actualDataSize = programInvokeImpl.getDataSize();

    // Assert
    DataWord dataWord = actualDataSize.ZERO;
    assertEquals(dataWord, programInvokeImpl.getDifficulty());
    assertSame(dataWord, actualDataSize);
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#getDataCopy(DataWord, DataWord)}
   */
  @Test
  public void testGetDataCopy() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 1L, 1L,
        1L);
    DataWord offsetData = DataWord.ZERO();

    // Act and Assert
    assertEquals(0, programInvokeImpl.getDataCopy(offsetData, DataWord.ZERO()).length);
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#getDifficulty()}
   */
  @Test
  public void testGetDifficulty() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    // Act
    DataWord actualDifficulty = (new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash,
        coinbase, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class)), 1L, 1L, 1L))
            .getDifficulty();

    // Assert
    assertEquals(actualDifficulty.ZERO, actualDifficulty);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProgramInvokeImpl#equals(Object)}
   *   <li>{@link ProgramInvokeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L);

    // Act and Assert
    assertEquals(programInvokeImpl, programInvokeImpl);
    int expectedHashCodeResult = programInvokeImpl.hashCode();
    assertEquals(expectedHashCodeResult, programInvokeImpl.hashCode());
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address2, origin2, caller2, 42L, 42L, 42L, 1L, msgData2,
        lastHash2, coinbase2, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws UnsupportedEncodingException {
    // Arrange
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
        new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L);
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address, origin2, caller2, 42L, 42L, 42L, 1L, msgData2,
        lastHash2, coinbase2, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address,
        new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L,
        1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address2, origin, caller2, 42L, 42L, 42L, 1L, msgData2,
        lastHash2, coinbase2, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin,
        new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L, 1L,
        new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address2, origin2, caller, 42L, 42L, 42L, 1L, msgData2,
        lastHash2, coinbase2, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 1L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address2, origin2, caller2, 42L, 42L, 42L, 1L, msgData2,
        lastHash2, coinbase2, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 1L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address2, origin2, caller2, 42L, 42L, 42L, 1L, msgData2,
        lastHash2, coinbase2, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, lastHash, coinbase, 10L, 1L,
        new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address2, origin2, caller2, 42L, 42L, 42L, 1L, msgData,
        lastHash2, coinbase2, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, coinbase, 10L, 1L,
        new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address2, origin2, caller2, 42L, 42L, 42L, 1L, msgData2,
        lastHash, coinbase2, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 10L, 1L,
        new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address2, origin2, caller2, 42L, 42L, 42L, 1L, msgData2,
        lastHash2, coinbase, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 0L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address2, origin2, caller2, 42L, 42L, 42L, 1L, msgData2,
        lastHash2, coinbase2, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() throws UnsupportedEncodingException {
    // Arrange
    StoreFactory storeFactory = mock(StoreFactory.class);
    when(storeFactory.getChainBaseManager()).thenReturn(new ChainBaseManager());
    RepositoryImpl deposit = new RepositoryImpl(storeFactory, null);

    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, "AXAXAXAX".getBytes("UTF-8"), 10L, 1L, deposit, 1L, 1L, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address2, origin2, caller2, 42L, 42L, 42L, 1L, msgData2,
        lastHash2, coinbase, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, "AXAXAXAX".getBytes("UTF-8"), 10L, 1L, null, 1L, 1L, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address2, origin2, caller2, 42L, 42L, 42L, 1L, msgData2,
        lastHash2, coinbase, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, true, 1L);
    byte[] address2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase2 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(programInvokeImpl, new ProgramInvokeImpl(address2, origin2, caller2, 42L, 42L, 42L, 1L, msgData2,
        lastHash2, coinbase2, 10L, 1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L));
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L,
        1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L), null);
  }

  /**
   * Method under test: {@link ProgramInvokeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNotEquals(new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData, lastHash, coinbase, 10L,
        1L, new RepositoryImpl(StoreFactory.getInstance(), null), 1L, 1L, 1L), "Different type to ProgramInvokeImpl");
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), null);

    ProgramInvokeImpl programInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L, msgData,
        lastHash, coinbase, 10L, 1L, deposit, 1L, 1L, 1L);

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

    // Assert that nothing has changed
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", actualNumber.toHexString());
    assertEquals("000000000000000000000000000000000000000000000000000000000000000a", actualTimestamp.toHexString());
    assertEquals("000000000000000000000000000000000000000000000000000000000000002a", actualBalance.toHexString());
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158", actualCallerAddress.toHexString());
    assertEquals("01", actualNumber.toPrefixString());
    assertEquals("0a", actualTimestamp.toPrefixString());
    assertEquals("2a", actualBalance.toPrefixString());
    assertEquals("415841", actualCallerAddress.toPrefixString());
    assertEquals("ProgramInvokeImpl{address=0000000000000000000000000000000000000000000000004158415841584158,"
        + " origin=0000000000000000000000000000000000000000000000004158415841584158, caller=0000000000000000000"
        + "000000000000000000000000000004158415841584158, balance=000000000000000000000000000000000000000000000"
        + "000000000000000002a, callValue=000000000000000000000000000000000000000000000000000000000000002a,"
        + " msgData=[65, 88, 65, 88, 65, 88, 65, 88], prevHash=000000000000000000000000000000000000000000000000"
        + "4158415841584158, coinbase=0000000000000000000000000000000000000000000000004158415841584158,"
        + " timestamp=000000000000000000000000000000000000000000000000000000000000000a, number=0000000000000000"
        + "000000000000000000000000000000000000000000000001, byTransaction=true, byTestingSuite=false,"
        + " callDeep=0}", actualToStringResult);
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
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualCallerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{1}, actualNumber.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'*'}, actualBalance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\n'}, actualTimestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualNumber.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        actualBalance.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        actualTimestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualCallerAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualNumber.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        actualBalance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        actualTimestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualCallerAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualNumber.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        actualNumber.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        actualBalance.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        actualBalance.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        actualTimestamp.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        actualTimestamp.getData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualCallerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualCallerAddress.getData());
  }

  /**
   * Method under test:
   * {@link ProgramInvokeImpl#ProgramInvokeImpl(DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, byte[], DataWord, DataWord, DataWord, DataWord, DataWord, Repository, int, boolean, boolean, long, long, long)}
   */
  @Test
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
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    ProgramInvokeImpl actualProgramInvokeImpl = new ProgramInvokeImpl(address, origin, caller, balance, callValue,
        tokenValue, tokenId, msgData, lastHash, coinbase, timestamp, number, difficulty, deposit, 1, true, true, 1L, 1L,
        1L);

    // Assert
    DataWord dataSize = actualProgramInvokeImpl.getDataSize();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", dataSize.toHexString());
    assertEquals("08", dataSize.toPrefixString());
    assertEquals(1, actualProgramInvokeImpl.getCallDeep());
    assertEquals(1L, actualProgramInvokeImpl.getEnergyLimit());
    assertEquals(1L, actualProgramInvokeImpl.getVmShouldEndInUs());
    assertEquals(1L, actualProgramInvokeImpl.getVmStartInUs());
    assertFalse(dataSize.isNegative());
    assertFalse(dataSize.isZero());
    assertFalse(actualProgramInvokeImpl.isConstantCall());
    assertTrue(actualProgramInvokeImpl.byTestingSuite());
    assertTrue(actualProgramInvokeImpl.isStaticCall());
    assertEquals(address, actualProgramInvokeImpl.getDifficulty());
    assertSame(deposit, actualProgramInvokeImpl.getDeposit());
    byte[] data = dataSize.getData();
    assertSame(data, dataSize.getNoEndZeroesData());
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
    assertArrayEquals(new byte[]{'\b'}, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeImpl#ProgramInvokeImpl(byte[], byte[], byte[], long, long, long, long, byte[], byte[], byte[], long, long, Repository, long, long, long)}
   */
  @Test
  public void testNewProgramInvokeImpl2() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    ProgramInvokeImpl actualProgramInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, coinbase, 10L, 1L, deposit, 1L, 1L, 1L);

    // Assert
    DataWord difficulty = actualProgramInvokeImpl.getDifficulty();
    assertEquals("00", difficulty.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", difficulty.toHexString());
    DataWord number = actualProgramInvokeImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", number.toHexString());
    DataWord dataSize = actualProgramInvokeImpl.getDataSize();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", dataSize.toHexString());
    DataWord timestamp = actualProgramInvokeImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000000000000a", timestamp.toHexString());
    DataWord balance = actualProgramInvokeImpl.getBalance();
    assertEquals("000000000000000000000000000000000000000000000000000000000000002a", balance.toHexString());
    DataWord callerAddress = actualProgramInvokeImpl.getCallerAddress();
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158", callerAddress.toHexString());
    assertEquals("01", number.toPrefixString());
    assertEquals("08", dataSize.toPrefixString());
    assertEquals("0a", timestamp.toPrefixString());
    assertEquals("2a", balance.toPrefixString());
    assertEquals("415841", callerAddress.toPrefixString());
    assertEquals(0, actualProgramInvokeImpl.getCallDeep());
    assertEquals(1L, actualProgramInvokeImpl.getEnergyLimit());
    assertEquals(1L, actualProgramInvokeImpl.getVmShouldEndInUs());
    assertEquals(1L, actualProgramInvokeImpl.getVmStartInUs());
    assertFalse(balance.isNegative());
    assertFalse(callerAddress.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(number.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(callerAddress.isZero());
    assertFalse(dataSize.isZero());
    assertFalse(number.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeImpl.byTestingSuite());
    assertFalse(actualProgramInvokeImpl.isConstantCall());
    assertFalse(actualProgramInvokeImpl.isStaticCall());
    assertTrue(difficulty.isZero());
    assertEquals(balance, actualProgramInvokeImpl.getCallValue());
    assertEquals(balance, actualProgramInvokeImpl.getTokenValue());
    assertEquals(callerAddress, actualProgramInvokeImpl.getCoinbase());
    assertEquals(callerAddress, actualProgramInvokeImpl.getContractAddress());
    assertEquals(callerAddress, actualProgramInvokeImpl.getOriginAddress());
    assertEquals(callerAddress, actualProgramInvokeImpl.getPrevHash());
    assertEquals(number, actualProgramInvokeImpl.getTokenId());
    assertSame(deposit, actualProgramInvokeImpl.getDeposit());
    byte[] data = balance.getData();
    assertSame(data, balance.getNoEndZeroesData());
    byte[] data2 = callerAddress.getData();
    assertSame(data2, callerAddress.getNoEndZeroesData());
    byte[] data3 = dataSize.getData();
    assertSame(data3, dataSize.getNoEndZeroesData());
    byte[] data4 = number.getData();
    assertSame(data4, number.getNoEndZeroesData());
    byte[] data5 = timestamp.getData();
    assertSame(data5, timestamp.getNoEndZeroesData());
    byte[] noEndZeroesData = difficulty.getNoEndZeroesData();
    assertSame(noEndZeroesData, difficulty.getNoLeadZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, callerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{1}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'*'}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\b'}, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\n'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        callerAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        callerAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data4);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        data);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data3);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        timestamp.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        data5);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, callerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data2);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeImpl#ProgramInvokeImpl(byte[], byte[], byte[], long, long, long, long, byte[], byte[], byte[], long, long, Repository, long, long, long)}
   */
  @Test
  public void testNewProgramInvokeImpl3() {
    // Arrange
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    ProgramInvokeImpl actualProgramInvokeImpl = new ProgramInvokeImpl(null, null, null, 42L, 42L, 42L, 1L,
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null, null, 10L, 1L, deposit, 1L, 1L, 1L);

    // Assert
    DataWord callerAddress = actualProgramInvokeImpl.getCallerAddress();
    assertEquals("", callerAddress.toHexString());
    assertEquals("00", callerAddress.toPrefixString());
    DataWord difficulty = actualProgramInvokeImpl.getDifficulty();
    assertEquals("00", difficulty.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", difficulty.toHexString());
    DataWord number = actualProgramInvokeImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", number.toHexString());
    DataWord dataSize = actualProgramInvokeImpl.getDataSize();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", dataSize.toHexString());
    DataWord timestamp = actualProgramInvokeImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000000000000a", timestamp.toHexString());
    DataWord balance = actualProgramInvokeImpl.getBalance();
    assertEquals("000000000000000000000000000000000000000000000000000000000000002a", balance.toHexString());
    assertEquals("01", number.toPrefixString());
    assertEquals("08", dataSize.toPrefixString());
    assertEquals("0a", timestamp.toPrefixString());
    assertEquals("2a", balance.toPrefixString());
    assertEquals(0, actualProgramInvokeImpl.getCallDeep());
    assertEquals(0, callerAddress.getData().length);
    assertEquals(1L, actualProgramInvokeImpl.getEnergyLimit());
    assertEquals(1L, actualProgramInvokeImpl.getVmShouldEndInUs());
    assertEquals(1L, actualProgramInvokeImpl.getVmStartInUs());
    assertFalse(balance.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(number.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(dataSize.isZero());
    assertFalse(number.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeImpl.byTestingSuite());
    assertFalse(actualProgramInvokeImpl.isConstantCall());
    assertFalse(actualProgramInvokeImpl.isStaticCall());
    assertTrue(callerAddress.isZero());
    assertTrue(difficulty.isZero());
    assertEquals(balance, actualProgramInvokeImpl.getCallValue());
    assertEquals(balance, actualProgramInvokeImpl.getTokenValue());
    assertEquals(callerAddress, actualProgramInvokeImpl.getCoinbase());
    assertEquals(callerAddress, actualProgramInvokeImpl.getContractAddress());
    assertEquals(callerAddress, actualProgramInvokeImpl.getOriginAddress());
    assertEquals(callerAddress, actualProgramInvokeImpl.getPrevHash());
    assertEquals(number, actualProgramInvokeImpl.getTokenId());
    assertSame(deposit, actualProgramInvokeImpl.getDeposit());
    byte[] data = balance.getData();
    assertSame(data, balance.getNoEndZeroesData());
    byte[] data2 = dataSize.getData();
    assertSame(data2, dataSize.getNoEndZeroesData());
    byte[] data3 = number.getData();
    assertSame(data3, number.getNoEndZeroesData());
    byte[] data4 = timestamp.getData();
    assertSame(data4, timestamp.getNoEndZeroesData());
    byte[] noLeadZeroesData = callerAddress.getNoLeadZeroesData();
    assertSame(noLeadZeroesData, difficulty.getNoEndZeroesData());
    assertSame(noLeadZeroesData, difficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noLeadZeroesData);
    assertArrayEquals(new byte[]{1}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'*'}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\b'}, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\n'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        timestamp.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        callerAddress.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data3);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        data);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        timestamp.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        data4);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeImpl#ProgramInvokeImpl(byte[], byte[], byte[], long, long, long, long, byte[], byte[], byte[], long, long, Repository, long, long, boolean, long)}
   */
  @Test
  public void testNewProgramInvokeImpl4() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    byte[] origin = "AXAXAXAX".getBytes("UTF-8");
    byte[] caller = "AXAXAXAX".getBytes("UTF-8");
    byte[] msgData = "AXAXAXAX".getBytes("UTF-8");
    byte[] lastHash = "AXAXAXAX".getBytes("UTF-8");
    byte[] coinbase = "AXAXAXAX".getBytes("UTF-8");
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    ProgramInvokeImpl actualProgramInvokeImpl = new ProgramInvokeImpl(address, origin, caller, 42L, 42L, 42L, 1L,
        msgData, lastHash, coinbase, 10L, 1L, deposit, 1L, 1L, true, 1L);

    // Assert
    DataWord difficulty = actualProgramInvokeImpl.getDifficulty();
    assertEquals("00", difficulty.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", difficulty.toHexString());
    DataWord number = actualProgramInvokeImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", number.toHexString());
    DataWord dataSize = actualProgramInvokeImpl.getDataSize();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", dataSize.toHexString());
    DataWord timestamp = actualProgramInvokeImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000000000000a", timestamp.toHexString());
    DataWord balance = actualProgramInvokeImpl.getBalance();
    assertEquals("000000000000000000000000000000000000000000000000000000000000002a", balance.toHexString());
    DataWord callerAddress = actualProgramInvokeImpl.getCallerAddress();
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158", callerAddress.toHexString());
    assertEquals("01", number.toPrefixString());
    assertEquals("08", dataSize.toPrefixString());
    assertEquals("0a", timestamp.toPrefixString());
    assertEquals("2a", balance.toPrefixString());
    assertEquals("415841", callerAddress.toPrefixString());
    assertEquals(0, actualProgramInvokeImpl.getCallDeep());
    assertEquals(1L, actualProgramInvokeImpl.getEnergyLimit());
    assertEquals(1L, actualProgramInvokeImpl.getVmShouldEndInUs());
    assertEquals(1L, actualProgramInvokeImpl.getVmStartInUs());
    assertFalse(balance.isNegative());
    assertFalse(callerAddress.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(number.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(callerAddress.isZero());
    assertFalse(dataSize.isZero());
    assertFalse(number.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeImpl.isConstantCall());
    assertFalse(actualProgramInvokeImpl.isStaticCall());
    assertTrue(difficulty.isZero());
    assertTrue(actualProgramInvokeImpl.byTestingSuite());
    assertEquals(balance, actualProgramInvokeImpl.getCallValue());
    assertEquals(balance, actualProgramInvokeImpl.getTokenValue());
    assertEquals(callerAddress, actualProgramInvokeImpl.getCoinbase());
    assertEquals(callerAddress, actualProgramInvokeImpl.getContractAddress());
    assertEquals(callerAddress, actualProgramInvokeImpl.getOriginAddress());
    assertEquals(callerAddress, actualProgramInvokeImpl.getPrevHash());
    assertEquals(number, actualProgramInvokeImpl.getTokenId());
    assertSame(deposit, actualProgramInvokeImpl.getDeposit());
    byte[] data = balance.getData();
    assertSame(data, balance.getNoEndZeroesData());
    byte[] data2 = callerAddress.getData();
    assertSame(data2, callerAddress.getNoEndZeroesData());
    byte[] data3 = dataSize.getData();
    assertSame(data3, dataSize.getNoEndZeroesData());
    byte[] data4 = number.getData();
    assertSame(data4, number.getNoEndZeroesData());
    byte[] data5 = timestamp.getData();
    assertSame(data5, timestamp.getNoEndZeroesData());
    byte[] noEndZeroesData = difficulty.getNoEndZeroesData();
    assertSame(noEndZeroesData, difficulty.getNoLeadZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, callerAddress.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noEndZeroesData);
    assertArrayEquals(new byte[]{1}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'*'}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\b'}, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\n'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        callerAddress.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        timestamp.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        callerAddress.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data4);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        data);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data3);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        timestamp.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        data5);
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, callerAddress.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data2);
  }

  /**
   * Method under test:
   * {@link ProgramInvokeImpl#ProgramInvokeImpl(byte[], byte[], byte[], long, long, long, long, byte[], byte[], byte[], long, long, Repository, long, long, boolean, long)}
   */
  @Test
  public void testNewProgramInvokeImpl5() {
    // Arrange
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), mock(RepositoryImpl.class));

    // Act
    ProgramInvokeImpl actualProgramInvokeImpl = new ProgramInvokeImpl(null, null, null, 42L, 42L, 42L, 1L,
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, null, null, 10L, 1L, deposit, 1L, 1L, true, 1L);

    // Assert
    DataWord callerAddress = actualProgramInvokeImpl.getCallerAddress();
    assertEquals("", callerAddress.toHexString());
    assertEquals("00", callerAddress.toPrefixString());
    DataWord difficulty = actualProgramInvokeImpl.getDifficulty();
    assertEquals("00", difficulty.toPrefixString());
    assertEquals("0000000000000000000000000000000000000000000000000000000000000000", difficulty.toHexString());
    DataWord number = actualProgramInvokeImpl.getNumber();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000001", number.toHexString());
    DataWord dataSize = actualProgramInvokeImpl.getDataSize();
    assertEquals("0000000000000000000000000000000000000000000000000000000000000008", dataSize.toHexString());
    DataWord timestamp = actualProgramInvokeImpl.getTimestamp();
    assertEquals("000000000000000000000000000000000000000000000000000000000000000a", timestamp.toHexString());
    DataWord balance = actualProgramInvokeImpl.getBalance();
    assertEquals("000000000000000000000000000000000000000000000000000000000000002a", balance.toHexString());
    assertEquals("01", number.toPrefixString());
    assertEquals("08", dataSize.toPrefixString());
    assertEquals("0a", timestamp.toPrefixString());
    assertEquals("2a", balance.toPrefixString());
    assertEquals(0, actualProgramInvokeImpl.getCallDeep());
    assertEquals(0, callerAddress.getData().length);
    assertEquals(1L, actualProgramInvokeImpl.getEnergyLimit());
    assertEquals(1L, actualProgramInvokeImpl.getVmShouldEndInUs());
    assertEquals(1L, actualProgramInvokeImpl.getVmStartInUs());
    assertFalse(balance.isNegative());
    assertFalse(dataSize.isNegative());
    assertFalse(difficulty.isNegative());
    assertFalse(number.isNegative());
    assertFalse(timestamp.isNegative());
    assertFalse(balance.isZero());
    assertFalse(dataSize.isZero());
    assertFalse(number.isZero());
    assertFalse(timestamp.isZero());
    assertFalse(actualProgramInvokeImpl.isConstantCall());
    assertFalse(actualProgramInvokeImpl.isStaticCall());
    assertTrue(callerAddress.isZero());
    assertTrue(difficulty.isZero());
    assertTrue(actualProgramInvokeImpl.byTestingSuite());
    assertEquals(balance, actualProgramInvokeImpl.getCallValue());
    assertEquals(balance, actualProgramInvokeImpl.getTokenValue());
    assertEquals(callerAddress, actualProgramInvokeImpl.getCoinbase());
    assertEquals(callerAddress, actualProgramInvokeImpl.getContractAddress());
    assertEquals(callerAddress, actualProgramInvokeImpl.getOriginAddress());
    assertEquals(callerAddress, actualProgramInvokeImpl.getPrevHash());
    assertEquals(number, actualProgramInvokeImpl.getTokenId());
    assertSame(deposit, actualProgramInvokeImpl.getDeposit());
    byte[] data = balance.getData();
    assertSame(data, balance.getNoEndZeroesData());
    byte[] data2 = dataSize.getData();
    assertSame(data2, dataSize.getNoEndZeroesData());
    byte[] data3 = number.getData();
    assertSame(data3, number.getNoEndZeroesData());
    byte[] data4 = timestamp.getData();
    assertSame(data4, timestamp.getNoEndZeroesData());
    byte[] noLeadZeroesData = callerAddress.getNoLeadZeroesData();
    assertSame(noLeadZeroesData, difficulty.getNoEndZeroesData());
    assertSame(noLeadZeroesData, difficulty.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0}, noLeadZeroesData);
    assertArrayEquals(new byte[]{1}, number.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'*'}, balance.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\b'}, dataSize.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{'\n'}, timestamp.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, number.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getLast20Bytes());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        timestamp.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        number.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.toTronAddress());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        timestamp.toTronAddress());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        callerAddress.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        difficulty.getData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        number.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        data3);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        balance.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '*'},
        data);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        dataSize.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'},
        data2);
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        timestamp.getClonedData());
    assertArrayEquals(
        new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\n'},
        data4);
  }
}
