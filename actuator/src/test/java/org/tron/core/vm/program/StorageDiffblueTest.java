package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.capsule.StorageRowCapsule;
import org.tron.core.store.StorageRowStore;

public class StorageDiffblueTest {
  /**
   * Method under test: {@link Storage#generateAddrHash(byte[])}
   */
  @Test
  public void testGenerateAddrHash() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));

    // Act
    storage.generateAddrHash("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(new byte[]{'_', '\\', 'K', 24, 24, ',', -86, -15, -90, -81, -99, -127, '{', -23, 'i', -48, -7,
        -113, -47, '4', -19, -90, -77, -105, -79, '@', 'I', 'w', -34, '1', 'F', 16}, storage.getAddrHash());
  }

  /**
   * Method under test: {@link Storage#generateAddrHash(byte[])}
   */
  @Test
  public void testGenerateAddrHash2() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));

    // Act
    storage.generateAddrHash(null);

    // Assert
    assertArrayEquals(new byte[]{-84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75,
        -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54}, storage.getAddrHash());
  }

  /**
   * Method under test: {@link Storage#generateAddrHash(byte[])}
   */
  @Test
  public void testGenerateAddrHash3() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));

    // Act
    storage.generateAddrHash(new byte[]{});

    // Assert
    assertArrayEquals(new byte[]{-84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75,
        -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54}, storage.getAddrHash());
  }

  /**
   * Method under test: {@link Storage#getValue(DataWord)}
   */
  @Test
  public void testGetValue() throws UnsupportedEncodingException {
    // Arrange
    StorageRowStore store = mock(StorageRowStore.class);
    when(store.get(Mockito.<byte[]>any())).thenReturn(new StorageRowCapsule("AXAXAXAX".getBytes("UTF-8")));
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), store);

    // Act
    DataWord actualValue = storage.getValue(DataWord.ZERO());

    // Assert
    verify(store).get(isA(byte[].class));
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158", actualValue.toHexString());
    assertEquals("415841", actualValue.toPrefixString());
    assertEquals(1, storage.getRowCache().size());
    assertFalse(actualValue.isNegative());
    assertFalse(actualValue.isZero());
    byte[] data = actualValue.getData();
    assertSame(data, actualValue.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualValue.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualValue.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualValue.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualValue.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data);
  }

  /**
   * Method under test: {@link Storage#getValue(DataWord)}
   */
  @Test
  public void testGetValue2() throws UnsupportedEncodingException {
    // Arrange
    StorageRowStore store = mock(StorageRowStore.class);
    when(store.get(Mockito.<byte[]>any())).thenReturn(new StorageRowCapsule((byte[]) null));
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), store);

    // Act
    DataWord actualValue = storage.getValue(DataWord.ZERO());

    // Assert
    verify(store).get(isA(byte[].class));
    assertNull(actualValue);
    assertTrue(storage.getRowCache().isEmpty());
  }

  /**
   * Method under test: {@link Storage#getValue(DataWord)}
   */
  @Test
  public void testGetValue3() throws UnsupportedEncodingException {
    // Arrange
    StorageRowStore store = mock(StorageRowStore.class);
    when(store.get(Mockito.<byte[]>any())).thenReturn(null);
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), store);

    // Act
    DataWord actualValue = storage.getValue(DataWord.ZERO());

    // Assert
    verify(store).get(isA(byte[].class));
    assertNull(actualValue);
    assertTrue(storage.getRowCache().isEmpty());
  }

  /**
   * Method under test: {@link Storage#getValue(DataWord)}
   */
  @Test
  public void testGetValue4() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));
    DataWord key = DataWord.ZERO();
    storage.put(key, DataWord.ZERO());

    // Act
    DataWord actualValue = storage.getValue(DataWord.ZERO());

    // Assert
    assertEquals(1, storage.getRowCache().size());
    assertEquals(key, actualValue);
  }

  /**
   * Method under test: {@link Storage#getValue(DataWord)}
   */
  @Test
  public void testGetValue5() throws UnsupportedEncodingException {
    // Arrange
    StorageRowStore store = mock(StorageRowStore.class);
    when(store.get(Mockito.<byte[]>any())).thenReturn(new StorageRowCapsule("AXAXAXAX".getBytes("UTF-8")));

    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), store);
    storage.setContractVersion(1);

    // Act
    DataWord actualValue = storage.getValue(DataWord.ZERO());

    // Assert
    verify(store).get(isA(byte[].class));
    assertEquals("0000000000000000000000000000000000000000000000004158415841584158", actualValue.toHexString());
    assertEquals("415841", actualValue.toPrefixString());
    assertEquals(1, storage.getRowCache().size());
    assertFalse(actualValue.isNegative());
    assertFalse(actualValue.isZero());
    byte[] data = actualValue.getData();
    assertSame(data, actualValue.getNoEndZeroesData());
    byte[] expectedNoLeadZeroesData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNoLeadZeroesData, actualValue.getNoLeadZeroesData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualValue.getLast20Bytes());
    assertArrayEquals(new byte[]{'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualValue.toTronAddress());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualValue.getClonedData());
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, data);
  }

  /**
   * Method under test: {@link Storage#Storage(byte[], StorageRowStore)}
   */
  @Test
  public void testNewStorage3() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Storage actualStorage = new Storage(address, null);

    // Assert
    assertNull(actualStorage.getStore());
    assertTrue(actualStorage.getRowCache().isEmpty());
    assertSame(address, actualStorage.getAddress());
    assertArrayEquals(new byte[]{-84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75,
        -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54}, actualStorage.getAddrHash());
  }

  /**
   * Method under test: {@link Storage#Storage(byte[], StorageRowStore)}
   */
  @Test
  public void testNewStorage4() throws UnsupportedEncodingException {
    // Arrange
    byte[] address = "AXAXAXAX".getBytes("UTF-8");
    StorageRowStore store = mock(StorageRowStore.class);

    // Act
    Storage actualStorage = new Storage(address, store);

    // Assert
    assertTrue(actualStorage.getRowCache().isEmpty());
    assertSame(address, actualStorage.getAddress());
    assertSame(store, actualStorage.getStore());
    assertArrayEquals(new byte[]{-84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75,
        -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54}, actualStorage.getAddrHash());
  }

  /**
   * Method under test: {@link Storage#put(DataWord, DataWord)}
   */
  @Test
  public void testPut() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));
    DataWord key = DataWord.ZERO();

    // Act
    storage.put(key, DataWord.ZERO());

    // Assert
    assertEquals(1, storage.getRowCache().size());
  }

  /**
   * Method under test: {@link Storage#put(DataWord, DataWord)}
   */
  @Test
  public void testPut2() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));
    DataWord key = DataWord.ZERO();
    storage.put(key, DataWord.ZERO());
    DataWord key2 = DataWord.ZERO();

    // Act
    storage.put(key2, DataWord.ZERO());

    // Assert
    assertEquals(1, storage.getRowCache().size());
  }

  /**
   * Method under test: {@link Storage#put(DataWord, DataWord)}
   */
  @Test
  public void testPut3() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));
    storage.setContractVersion(1);
    DataWord key = DataWord.ZERO();

    // Act
    storage.put(key, DataWord.ZERO());

    // Assert
    assertEquals(1, storage.getRowCache().size());
  }

  /**
   * Method under test: {@link Storage#commit()}
   */
  @Test
  public void testCommit() throws UnsupportedEncodingException {
    // Arrange
    StorageRowStore store = mock(StorageRowStore.class);
    doNothing().when(store).delete(Mockito.<byte[]>any());

    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), store);
    DataWord key = DataWord.ZERO();
    storage.put(key, DataWord.ZERO());

    // Act
    storage.commit();

    // Assert
    verify(store).delete(isA(byte[].class));
  }

  /**
   * Method under test: {@link Storage#commit()}
   */
  @Test
  public void testCommit2() throws UnsupportedEncodingException {
    // Arrange
    StorageRowStore store = mock(StorageRowStore.class);
    doNothing().when(store).put(Mockito.<byte[]>any(), Mockito.<StorageRowCapsule>any());

    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), store);
    DataWord key = DataWord.ZERO();
    storage.put(key, DataWord.of((byte) 'A'));

    // Act
    storage.commit();

    // Assert
    verify(store).put(isA(byte[].class), isA(StorageRowCapsule.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Storage#setContractVersion(int)}
   *   <li>{@link Storage#getAddrHash()}
   *   <li>{@link Storage#getAddress()}
   *   <li>{@link Storage#getRowCache()}
   *   <li>{@link Storage#getStore()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), null);

    // Act
    storage.setContractVersion(1);
    byte[] actualAddrHash = storage.getAddrHash();
    byte[] actualAddress = storage.getAddress();
    Map<DataWord, StorageRowCapsule> actualRowCache = storage.getRowCache();
    storage.getStore();

    // Assert that nothing has changed
    assertTrue(actualRowCache.isEmpty());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualAddress);
    assertArrayEquals(new byte[]{-84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75,
        -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54}, actualAddrHash);
  }

  /**
   * Method under test: {@link Storage#Storage(Storage)}
   */
  @Test
  public void testNewStorage() throws UnsupportedEncodingException {
    // Arrange and Act
    Storage actualStorage = new Storage(new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class)));

    // Assert
    assertTrue(actualStorage.getRowCache().isEmpty());
    byte[] expectedAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedAddress, actualStorage.getAddress());
    assertArrayEquals(new byte[]{-84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75,
        -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54}, actualStorage.getAddrHash());
  }

  /**
   * Method under test: {@link Storage#Storage(Storage)}
   */
  @Test
  public void testNewStorage2() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));
    DataWord key = DataWord.ZERO();
    storage.put(key, DataWord.ZERO());

    // Act
    Storage actualStorage = new Storage(storage);

    // Assert
    assertEquals(1, actualStorage.getRowCache().size());
    byte[] expectedAddress = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedAddress, actualStorage.getAddress());
    assertArrayEquals(new byte[]{-84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75,
        -41, '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54}, actualStorage.getAddrHash());
  }
}
