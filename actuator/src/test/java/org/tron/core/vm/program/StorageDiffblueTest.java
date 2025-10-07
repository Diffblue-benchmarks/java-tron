package org.tron.core.vm.program;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.common.runtime.vm.DataWord;
import org.tron.core.capsule.StorageRowCapsule;
import org.tron.core.store.StorageRowStore;

public class StorageDiffblueTest {
  /**
   * Test {@link Storage#Storage(byte[], StorageRowStore)}.
   *
   * <p>Method under test: {@link Storage#Storage(byte[], StorageRowStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.<init>(byte[], StorageRowStore)"})
  public void testNewStorage() throws UnsupportedEncodingException {
    // Arrange and Act
    Storage actualStorage = new Storage("AXAXAXAX".getBytes("UTF-8"), null);

    // Assert
    assertNull(actualStorage.getStore());
    assertTrue(actualStorage.getRowCache().isEmpty());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualStorage.getAddress());
    assertArrayEquals(
        new byte[] {
          -84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75, -41,
          '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54
        },
        actualStorage.getAddrHash());
  }

  /**
   * Test {@link Storage#Storage(Storage)}.
   *
   * <ul>
   *   <li>Given {@link DataWord} with num is {@code A}.
   *   <li>Then return RowCache size is two.
   * </ul>
   *
   * <p>Method under test: {@link Storage#Storage(Storage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.<init>(Storage)"})
  public void testNewStorage_givenDataWordWithNumIsA_thenReturnRowCacheSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));
    DataWord key = DataWord.of((byte) 'A');
    storage.put(key, DataWord.ZERO());
    DataWord key2 = DataWord.ZERO();
    storage.put(key2, DataWord.ZERO());

    // Act
    Storage actualStorage = new Storage(storage);

    // Assert
    assertEquals(2, actualStorage.getRowCache().size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualStorage.getAddress());
    assertArrayEquals(
        new byte[] {
          -84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75, -41,
          '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54
        },
        actualStorage.getAddrHash());
  }

  /**
   * Test {@link Storage#Storage(Storage)}.
   *
   * <ul>
   *   <li>Given ZERO.
   *   <li>Then return RowCache size is one.
   * </ul>
   *
   * <p>Method under test: {@link Storage#Storage(Storage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.<init>(Storage)"})
  public void testNewStorage_givenZero_thenReturnRowCacheSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));
    DataWord key = DataWord.ZERO();
    storage.put(key, DataWord.ZERO());

    // Act
    Storage actualStorage = new Storage(storage);

    // Assert
    assertEquals(1, actualStorage.getRowCache().size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualStorage.getAddress());
    assertArrayEquals(
        new byte[] {
          -84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75, -41,
          '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54
        },
        actualStorage.getAddrHash());
  }

  /**
   * Test {@link Storage#Storage(Storage)}.
   *
   * <ul>
   *   <li>Then return RowCache Empty.
   * </ul>
   *
   * <p>Method under test: {@link Storage#Storage(Storage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.<init>(Storage)"})
  public void testNewStorage_thenReturnRowCacheEmpty() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));

    // Act
    Storage actualStorage = new Storage(storage);

    // Assert
    assertTrue(actualStorage.getRowCache().isEmpty());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualStorage.getAddress());
    assertArrayEquals(
        new byte[] {
          -84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75, -41,
          '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54
        },
        actualStorage.getAddrHash());
  }

  /**
   * Test {@link Storage#generateAddrHash(byte[])}.
   *
   * <p>Method under test: {@link Storage#generateAddrHash(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.generateAddrHash(byte[])"})
  public void testGenerateAddrHash() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));

    // Act
    storage.generateAddrHash("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          '_', '\\', 'K', 24, 24, ',', -86, -15, -90, -81, -99, -127, '{', -23, 'i', -48, -7, -113,
          -47, '4', -19, -90, -77, -105, -79, '@', 'I', 'w', -34, '1', 'F', 16
        },
        storage.getAddrHash());
  }

  /**
   * Test {@link Storage#generateAddrHash(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#generateAddrHash(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.generateAddrHash(byte[])"})
  public void testGenerateAddrHash_whenEmptyArrayOfByte() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));

    // Act
    storage.generateAddrHash(new byte[] {});

    // Assert that nothing has changed
    assertArrayEquals(
        new byte[] {
          -84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75, -41,
          '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54
        },
        storage.getAddrHash());
  }

  /**
   * Test {@link Storage#generateAddrHash(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#generateAddrHash(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.generateAddrHash(byte[])"})
  public void testGenerateAddrHash_whenNull() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));

    // Act
    storage.generateAddrHash(null);

    // Assert that nothing has changed
    assertArrayEquals(
        new byte[] {
          -84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75, -41,
          '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54
        },
        storage.getAddrHash());
  }

  /**
   * Test {@link Storage#getValue(DataWord)}.
   *
   * <p>Method under test: {@link Storage#getValue(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Storage.getValue(DataWord)"})
  public void testGetValue() throws UnsupportedEncodingException {
    // Arrange
    StorageRowStore store = mock(StorageRowStore.class);
    when(store.get(Mockito.<byte[]>any()))
        .thenReturn(new StorageRowCapsule("AXAXAXAX".getBytes("UTF-8")));

    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), store);
    storage.setContractVersion(1);

    // Act
    DataWord actualValue = storage.getValue(DataWord.ZERO());

    // Assert
    verify(store).get(isA(byte[].class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualValue.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualValue.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'
        },
        actualValue.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X'
        },
        actualValue.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X'
        },
        actualValue.getData());
  }

  /**
   * Test {@link Storage#getValue(DataWord)}.
   *
   * <ul>
   *   <li>Given {@link StorageRowStore} {@link StorageRowStore#get(byte[])} return {@code null}.
   *   <li>When ZERO.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getValue(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Storage.getValue(DataWord)"})
  public void testGetValue_givenStorageRowStoreGetReturnNull_whenZero_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    StorageRowStore store = mock(StorageRowStore.class);
    when(store.get(Mockito.<byte[]>any())).thenReturn(null);
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), store);

    // Act
    DataWord actualValue = storage.getValue(DataWord.ZERO());

    // Assert
    verify(store).get(isA(byte[].class));
    assertNull(actualValue);
  }

  /**
   * Test {@link Storage#getValue(DataWord)}.
   *
   * <ul>
   *   <li>Given {@link StorageRowStore} {@link StorageRowStore#get(byte[])} return {@link
   *       StorageRowCapsule#StorageRowCapsule(byte[])} with rowValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getValue(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Storage.getValue(DataWord)"})
  public void testGetValue_givenStorageRowStoreGetReturnStorageRowCapsuleWithRowValueIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    StorageRowStore store = mock(StorageRowStore.class);
    when(store.get(Mockito.<byte[]>any())).thenReturn(new StorageRowCapsule((byte[]) null));
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), store);

    // Act
    DataWord actualValue = storage.getValue(DataWord.ZERO());

    // Assert
    verify(store).get(isA(byte[].class));
    assertNull(actualValue);
  }

  /**
   * Test {@link Storage#getValue(DataWord)}.
   *
   * <ul>
   *   <li>Then return NoLeadZeroesData is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getValue(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Storage.getValue(DataWord)"})
  public void testGetValue_thenReturnNoLeadZeroesDataIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    StorageRowStore store = mock(StorageRowStore.class);
    when(store.get(Mockito.<byte[]>any()))
        .thenReturn(new StorageRowCapsule("AXAXAXAX".getBytes("UTF-8")));
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), store);

    // Act
    DataWord actualValue = storage.getValue(DataWord.ZERO());

    // Assert
    verify(store).get(isA(byte[].class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualValue.getNoLeadZeroesData());
    assertArrayEquals(
        new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualValue.getLast20Bytes());
    assertArrayEquals(
        new byte[] {
          'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'
        },
        actualValue.toTronAddress());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X'
        },
        actualValue.getClonedData());
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X'
        },
        actualValue.getData());
  }

  /**
   * Test {@link Storage#getValue(DataWord)}.
   *
   * <ul>
   *   <li>Then return ZERO.
   * </ul>
   *
   * <p>Method under test: {@link Storage#getValue(DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWord Storage.getValue(DataWord)"})
  public void testGetValue_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));
    DataWord key = DataWord.ZERO();
    storage.put(key, DataWord.ZERO());

    // Act and Assert
    assertEquals(key, storage.getValue(DataWord.ZERO()));
  }

  /**
   * Test {@link Storage#put(DataWord, DataWord)}.
   *
   * <p>Method under test: {@link Storage#put(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.put(DataWord, DataWord)"})
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
   * Test {@link Storage#put(DataWord, DataWord)}.
   *
   * <p>Method under test: {@link Storage#put(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.put(DataWord, DataWord)"})
  public void testPut2() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));
    DataWord key = DataWord.ZERO();
    storage.put(key, DataWord.ZERO());
    DataWord key2 = DataWord.ZERO();

    // Act
    storage.put(key2, DataWord.ZERO());

    // Assert that nothing has changed
    assertEquals(1, storage.getRowCache().size());
  }

  /**
   * Test {@link Storage#put(DataWord, DataWord)}.
   *
   * <ul>
   *   <li>Then {@link Storage#Storage(Storage)} with storage is {@link Storage#Storage(byte[],
   *       StorageRowStore)} RowCache size is one.
   * </ul>
   *
   * <p>Method under test: {@link Storage#put(DataWord, DataWord)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.put(DataWord, DataWord)"})
  public void testPut_thenStorageWithStorageIsStorageRowCacheSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), mock(StorageRowStore.class));

    Storage storage2 = new Storage(storage);
    storage2.setContractVersion(1);
    DataWord key = DataWord.ZERO();

    // Act
    storage2.put(key, DataWord.ZERO());

    // Assert
    assertEquals(1, storage2.getRowCache().size());
  }

  /**
   * Test {@link Storage#commit()}.
   *
   * <ul>
   *   <li>Given {@link StorageRowStore} {@link StorageRowStore#delete(byte[])} does nothing.
   *   <li>Then calls {@link StorageRowStore#delete(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#commit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.commit()"})
  public void testCommit_givenStorageRowStoreDeleteDoesNothing_thenCallsDelete()
      throws UnsupportedEncodingException {
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
   * Test {@link Storage#commit()}.
   *
   * <ul>
   *   <li>Given {@link StorageRowStore} {@link StorageRowStore#put(byte[], ProtoCapsule)} does
   *       nothing.
   *   <li>Then calls {@link StorageRowStore#put(byte[], ProtoCapsule)}.
   * </ul>
   *
   * <p>Method under test: {@link Storage#commit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Storage.commit()"})
  public void testCommit_givenStorageRowStorePutDoesNothing_thenCallsPut()
      throws UnsupportedEncodingException {
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Storage#setContractVersion(int)}
   *   <li>{@link Storage#getAddrHash()}
   *   <li>{@link Storage#getAddress()}
   *   <li>{@link Storage#getRowCache()}
   *   <li>{@link Storage#getStore()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] Storage.getAddrHash()",
    "byte[] Storage.getAddress()",
    "Map Storage.getRowCache()",
    "StorageRowStore Storage.getStore()",
    "void Storage.setContractVersion(int)"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    Storage storage = new Storage("AXAXAXAX".getBytes("UTF-8"), null);

    // Act
    storage.setContractVersion(1);
    byte[] actualAddrHash = storage.getAddrHash();
    byte[] actualAddress = storage.getAddress();
    Map<DataWord, StorageRowCapsule> actualRowCache = storage.getRowCache();

    // Assert
    assertNull(storage.getStore());
    assertTrue(actualRowCache.isEmpty());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualAddress);
    assertArrayEquals(
        new byte[] {
          -84, -91, '3', -51, -53, '2', -79, '"', '\b', 1, -60, '1', '\n', '>', -48, '0', -75, -41,
          '`', -121, '(', -22, -111, -6, 'J', 't', -83, 'Q', -3, -89, -95, -54
        },
        actualAddrHash);
  }
}
