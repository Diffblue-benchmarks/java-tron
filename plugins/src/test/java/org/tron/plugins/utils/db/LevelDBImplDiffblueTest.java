package org.tron.plugins.utils.db;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import org.fusesource.leveldbjni.internal.JniDB;
import org.fusesource.leveldbjni.internal.NativeComparator;
import org.fusesource.leveldbjni.internal.NativeDB;
import org.fusesource.leveldbjni.internal.NativeLogger;
import org.iq80.leveldb.DBException;
import org.iq80.leveldb.ReadOptions;
import org.iq80.leveldb.impl.DbImpl;
import org.iq80.leveldb.impl.SeekingIteratorAdapter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class LevelDBImplDiffblueTest {
  /**
   * Test {@link LevelDBImpl#get(byte[])}.
   *
   * <ul>
   *   <li>Given {@link DbImpl} {@link DbImpl#get(byte[])} return {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBImpl#get(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] LevelDBImpl.get(byte[])"})
  public void testGet_givenDbImplGetReturnAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, DBException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    DbImpl leveldb = mock(DbImpl.class);
    when(leveldb.get(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualGetResult = new LevelDBImpl(leveldb, "Name").get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(leveldb).get(isA(byte[].class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Test {@link LevelDBImpl#put(byte[], byte[])}.
   *
   * <ul>
   *   <li>Given {@link DbImpl} {@link DbImpl#put(byte[], byte[])} does nothing.
   *   <li>Then calls {@link DbImpl#put(byte[], byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBImpl#put(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LevelDBImpl.put(byte[], byte[])"})
  public void testPut_givenDbImplPutDoesNothing_thenCallsPut()
      throws UnsupportedEncodingException, DBException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    DbImpl leveldb = mock(DbImpl.class);
    doNothing().when(leveldb).put(Mockito.<byte[]>any(), Mockito.<byte[]>any());

    // Act
    new LevelDBImpl(leveldb, "Name")
        .put("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(leveldb).put(isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link LevelDBImpl#delete(byte[])}.
   *
   * <ul>
   *   <li>Given {@link DbImpl} {@link DbImpl#delete(byte[])} does nothing.
   *   <li>Then calls {@link DbImpl#delete(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBImpl#delete(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LevelDBImpl.delete(byte[])"})
  public void testDelete_givenDbImplDeleteDoesNothing_thenCallsDelete()
      throws UnsupportedEncodingException, DBException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    DbImpl leveldb = mock(DbImpl.class);
    doNothing().when(leveldb).delete(Mockito.<byte[]>any());

    // Act
    new LevelDBImpl(leveldb, "Name").delete("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(leveldb).delete(isA(byte[].class));
  }

  /**
   * Test {@link LevelDBImpl#iterator()}.
   *
   * <ul>
   *   <li>Then return {@link LevelDBIterator}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBImpl#iterator()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DBIterator LevelDBImpl.iterator()"})
  public void testIterator_thenReturnLevelDBIterator() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    DbImpl leveldb = mock(DbImpl.class);
    when(leveldb.iterator(Mockito.<ReadOptions>any())).thenReturn(new SeekingIteratorAdapter(null));

    // Act
    DBIterator actualIteratorResult = new LevelDBImpl(leveldb, "Name").iterator();

    // Assert
    verify(leveldb).iterator(isA(ReadOptions.class));
    assertTrue(actualIteratorResult instanceof LevelDBIterator);
  }

  /**
   * Test {@link LevelDBImpl#size()}.
   *
   * <ul>
   *   <li>Given {@link SeekingIteratorAdapter} {@link
   *       SeekingIteratorAdapter#forEachRemaining(Consumer)} does nothing.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBImpl#size()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long LevelDBImpl.size()"})
  public void testSize_givenSeekingIteratorAdapterForEachRemainingDoesNothing_thenReturnZero() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    SeekingIteratorAdapter seekingIteratorAdapter = mock(SeekingIteratorAdapter.class);
    doNothing()
        .when(seekingIteratorAdapter)
        .forEachRemaining(Mockito.<Consumer<Entry<byte[], byte[]>>>any());

    DbImpl leveldb = mock(DbImpl.class);
    when(leveldb.iterator()).thenReturn(seekingIteratorAdapter);

    // Act
    long actualSizeResult = new LevelDBImpl(leveldb, "Name").size();

    // Assert
    verify(seekingIteratorAdapter).forEachRemaining(isA(Consumer.class));
    verify(leveldb).iterator();
    assertEquals(0L, actualSizeResult);
  }

  /**
   * Test {@link LevelDBImpl#close()}.
   *
   * <ul>
   *   <li>Given {@link NativeDB} {@link NativeDB#delete()} does nothing.
   *   <li>Then calls {@link NativeComparator#delete()}.
   * </ul>
   *
   * <p>Method under test: {@link LevelDBImpl#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LevelDBImpl.close()"})
  public void testClose_givenNativeDBDeleteDoesNothing_thenCallsDelete() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    NativeDB db = mock(NativeDB.class);
    doNothing().when(db).delete();

    NativeComparator comparator = mock(NativeComparator.class);
    doNothing().when(comparator).delete();

    NativeLogger logger = mock(NativeLogger.class);
    doNothing().when(logger).delete();

    JniDB leveldb = new JniDB(db, null, comparator, logger);
    try (LevelDBImpl levelDBImpl = new LevelDBImpl(leveldb, "Name")) {}

    // Act and Assert
    verify(comparator).delete();
    verify(db).delete();
    verify(logger).delete();
  }
}
