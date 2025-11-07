package org.tron.plugins.utils.db;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Consumer;
import org.iq80.leveldb.DBException;
import org.iq80.leveldb.ReadOptions;
import org.iq80.leveldb.impl.DbImpl;
import org.iq80.leveldb.impl.SeekingIteratorAdapter;
import org.junit.Test;
import org.mockito.Mockito;

public class LevelDBImplDiffblueTest {
  /**
   * Method under test: {@link LevelDBImpl#get(byte[])}
   */
  @Test
  public void testGet() throws UnsupportedEncodingException, DBException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DbImpl leveldb = mock(DbImpl.class);
    when(leveldb.get(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    LevelDBImpl levelDBImpl = new LevelDBImpl(leveldb, "Name");

    // Act
    byte[] actualGetResult = levelDBImpl.get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(leveldb).get(isA(byte[].class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Method under test: {@link LevelDBImpl#put(byte[], byte[])}
   */
  @Test
  public void testPut() throws UnsupportedEncodingException, DBException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DbImpl leveldb = mock(DbImpl.class);
    doNothing().when(leveldb).put(Mockito.<byte[]>any(), Mockito.<byte[]>any());
    LevelDBImpl levelDBImpl = new LevelDBImpl(leveldb, "Name");
    byte[] key = "AXAXAXAX".getBytes("UTF-8");

    // Act
    levelDBImpl.put(key, "AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    verify(leveldb).put(isA(byte[].class), isA(byte[].class));
  }

  /**
   * Method under test: {@link LevelDBImpl#delete(byte[])}
   */
  @Test
  public void testDelete() throws UnsupportedEncodingException, DBException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DbImpl leveldb = mock(DbImpl.class);
    doNothing().when(leveldb).delete(Mockito.<byte[]>any());
    LevelDBImpl levelDBImpl = new LevelDBImpl(leveldb, "Name");

    // Act
    levelDBImpl.delete("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    verify(leveldb).delete(isA(byte[].class));
  }

  /**
   * Method under test: {@link LevelDBImpl#iterator()}
   */
  @Test
  public void testIterator() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DbImpl leveldb = mock(DbImpl.class);
    when(leveldb.iterator(Mockito.<ReadOptions>any())).thenReturn(new SeekingIteratorAdapter(null));

    // Act
    DBIterator actualIteratorResult = (new LevelDBImpl(leveldb, "Name")).iterator();

    // Assert
    verify(leveldb).iterator(isA(ReadOptions.class));
    assertTrue(actualIteratorResult instanceof LevelDBIterator);
  }

  /**
   * Method under test: {@link LevelDBImpl#size()}
   */
  @Test
  public void testSize() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    SeekingIteratorAdapter seekingIteratorAdapter = mock(SeekingIteratorAdapter.class);
    doNothing().when(seekingIteratorAdapter).forEachRemaining(Mockito.<Consumer<Map.Entry<byte[], byte[]>>>any());
    DbImpl leveldb = mock(DbImpl.class);
    when(leveldb.iterator()).thenReturn(seekingIteratorAdapter);

    // Act
    long actualSizeResult = (new LevelDBImpl(leveldb, "Name")).size();

    // Assert
    verify(seekingIteratorAdapter).forEachRemaining(isA(Consumer.class));
    verify(leveldb).iterator();
    assertEquals(0L, actualSizeResult);
  }

  /**
   * Method under test: {@link LevelDBImpl#close()}
   */
  @Test
  public void testClose() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DbImpl leveldb = mock(DbImpl.class);
    doNothing().when(leveldb).close();

    // Act
    (new LevelDBImpl(leveldb, "Name")).close();

    // Assert that nothing has changed
    verify(leveldb).close();
  }
}
