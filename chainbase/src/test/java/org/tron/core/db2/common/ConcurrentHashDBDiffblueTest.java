package org.tron.core.db2.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.capsule.BytesCapsule;

public class ConcurrentHashDBDiffblueTest {
  /**
   * Method under test: {@link ConcurrentHashDB#get(byte[])}
   */
  @Test
  public void testGet() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();

    // Act and Assert
    assertNull(concurrentHashDB.get("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ConcurrentHashDB#get(byte[])}
   */
  @Test
  public void testGet2() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    BytesCapsule bytes2 = new BytesCapsule("A;A;A;A;".getBytes("UTF-8"));
    concurrentHashDB.put(bytes, bytes2);
    byte[] bytes3 = "A;A;A;A;".getBytes("UTF-8");
    concurrentHashDB.put(bytes3, new BytesCapsule("A;A;A;A;".getBytes("UTF-8")));

    // Act and Assert
    assertSame(bytes2, concurrentHashDB.get("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ConcurrentHashDB#put(byte[], BytesCapsule)}
   */
  @Test
  public void testPut() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    concurrentHashDB.put(bytes, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertEquals(1L, concurrentHashDB.size());
    assertFalse(concurrentHashDB.isEmpty());
  }

  /**
   * Method under test: {@link ConcurrentHashDB#put(byte[], BytesCapsule)}
   */
  @Test
  public void testPut2() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    concurrentHashDB.put(bytes, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    byte[] bytes2 = "A;A;A;A;".getBytes("UTF-8");
    concurrentHashDB.put(bytes2, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    byte[] bytes3 = "AXAXAXAX".getBytes("UTF-8");

    // Act
    concurrentHashDB.put(bytes3, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertEquals(2L, concurrentHashDB.size());
    assertFalse(concurrentHashDB.isEmpty());
  }

  /**
   * Method under test: {@link ConcurrentHashDB#size()}
   */
  @Test
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ConcurrentHashDB()).size());
  }

  /**
   * Method under test: {@link ConcurrentHashDB#isEmpty()}
   */
  @Test
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ConcurrentHashDB()).isEmpty());
  }

  /**
   * Method under test: {@link ConcurrentHashDB#isEmpty()}
   */
  @Test
  public void testIsEmpty2() {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();
    concurrentHashDB.put(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4},
        new BytesCapsule(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4}));

    // Act and Assert
    assertFalse(concurrentHashDB.isEmpty());
  }

  /**
   * Method under test: {@link ConcurrentHashDB#remove(byte[])}
   */
  @Test
  public void testRemove() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();

    // Act
    concurrentHashDB.remove("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0L, concurrentHashDB.size());
  }

  /**
   * Method under test: {@link ConcurrentHashDB#remove(byte[])}
   */
  @Test
  public void testRemove2() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    concurrentHashDB.put(bytes, new BytesCapsule("A;A;A;A;".getBytes("UTF-8")));
    byte[] bytes2 = "A;A;A;A;".getBytes("UTF-8");
    concurrentHashDB.put(bytes2, new BytesCapsule("A;A;A;A;".getBytes("UTF-8")));

    // Act
    concurrentHashDB.remove("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1L, concurrentHashDB.size());
  }

  /**
   * Method under test: {@link ConcurrentHashDB#iterator()}
   */
  @Test
  public void testIterator() {
    // Arrange, Act and Assert
    assertNull((new ConcurrentHashDB()).iterator());
  }

  /**
   * Method under test: {@link ConcurrentHashDB#close()}
   */
  @Test
  public void testClose() {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();

    // Act
    concurrentHashDB.close();

    // Assert
    assertEquals(0L, concurrentHashDB.size());
    assertTrue(concurrentHashDB.isEmpty());
  }

  /**
   * Method under test: {@link ConcurrentHashDB#close()}
   */
  @Test
  public void testClose2() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();
    concurrentHashDB.put("AXAXAXAX".getBytes("UTF-8"), mock(BytesCapsule.class));

    // Act
    concurrentHashDB.close();

    // Assert
    assertEquals(0L, concurrentHashDB.size());
    assertTrue(concurrentHashDB.isEmpty());
  }

  /**
   * Method under test: {@link ConcurrentHashDB#newInstance()}
   */
  @Test
  public void testNewInstance() {
    // Arrange, Act and Assert
    assertNull((new ConcurrentHashDB()).newInstance());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ConcurrentHashDB}
   *   <li>{@link ConcurrentHashDB#stat()}
   *   <li>{@link ConcurrentHashDB#getDbName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ConcurrentHashDB actualConcurrentHashDB = new ConcurrentHashDB();
    actualConcurrentHashDB.stat();
    actualConcurrentHashDB.getDbName();

    // Assert that nothing has changed
    assertEquals(0L, actualConcurrentHashDB.size());
    assertTrue(actualConcurrentHashDB.isEmpty());
  }
}
