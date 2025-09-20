package org.tron.core.db2.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.capsule.BytesCapsule;

public class ConcurrentHashDBDiffblueTest {
  /**
   * Test {@link ConcurrentHashDB#get(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentHashDB} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentHashDB#get(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BytesCapsule ConcurrentHashDB.get(byte[])"})
  public void testGetWithByte_givenConcurrentHashDB_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    BytesCapsule actualGetResult = new ConcurrentHashDB().get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualGetResult);
  }

  /**
   * Test {@link ConcurrentHashDB#get(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Then return {@link BytesCapsule#BytesCapsule(byte[])} with bytes is {@code A;A;A;A;}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentHashDB#get(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BytesCapsule ConcurrentHashDB.get(byte[])"})
  public void testGetWithByte_thenReturnBytesCapsuleWithBytesIsAAAABytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    BytesCapsule bytes2 = new BytesCapsule("A;A;A;A;".getBytes("UTF-8"));

    concurrentHashDB.put(bytes, bytes2);
    byte[] bytes3 = "A;A;A;A;".getBytes("UTF-8");
    concurrentHashDB.put(bytes3, new BytesCapsule("A;A;A;A;".getBytes("UTF-8")));

    // Act
    BytesCapsule actualGetResult = concurrentHashDB.get("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertSame(bytes2, actualGetResult);
  }

  /**
   * Test {@link ConcurrentHashDB#put(byte[], BytesCapsule)} with {@code byte[]}, {@code
   * BytesCapsule}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentHashDB} (default constructor).
   *   <li>Then {@link ConcurrentHashDB} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentHashDB#put(byte[], BytesCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConcurrentHashDB.put(byte[], BytesCapsule)"})
  public void testPutWithByteBytesCapsule_givenConcurrentHashDB_thenConcurrentHashDBSizeIsOne()
      throws UnsupportedEncodingException {
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
   * Test {@link ConcurrentHashDB#put(byte[], BytesCapsule)} with {@code byte[]}, {@code
   * BytesCapsule}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentHashDB} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentHashDB#put(byte[], BytesCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConcurrentHashDB.put(byte[], BytesCapsule)"})
  public void testPutWithByteBytesCapsule_thenConcurrentHashDBSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    concurrentHashDB.put(bytes, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    byte[] bytes2 = "A;A;A;A;".getBytes("UTF-8");
    concurrentHashDB.put(bytes2, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));
    byte[] bytes3 = "AXAXAXAX".getBytes("UTF-8");

    // Act
    concurrentHashDB.put(bytes3, new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Assert that nothing has changed
    assertEquals(2L, concurrentHashDB.size());
    assertFalse(concurrentHashDB.isEmpty());
  }

  /**
   * Test {@link ConcurrentHashDB#size()}.
   *
   * <p>Method under test: {@link ConcurrentHashDB#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ConcurrentHashDB.size()"})
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0L, new ConcurrentHashDB().size());
  }

  /**
   * Test {@link ConcurrentHashDB#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentHashDB#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConcurrentHashDB.isEmpty()"})
  public void testIsEmpty_givenA_thenReturnFalse() {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();
    BytesCapsule bytes2 = new BytesCapsule(new byte[] {'A', 4, 'A', 4, 'A', 4, 'A', 4});
    concurrentHashDB.put(new byte[] {'A', 4, 'A', 4, 'A', 4, 'A', 4}, bytes2);

    // Act and Assert
    assertFalse(concurrentHashDB.isEmpty());
  }

  /**
   * Test {@link ConcurrentHashDB#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentHashDB} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentHashDB#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ConcurrentHashDB.isEmpty()"})
  public void testIsEmpty_givenConcurrentHashDB_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ConcurrentHashDB().isEmpty());
  }

  /**
   * Test {@link ConcurrentHashDB#remove(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentHashDB} (default constructor).
   *   <li>Then {@link ConcurrentHashDB} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentHashDB#remove(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConcurrentHashDB.remove(byte[])"})
  public void testRemoveWithByte_givenConcurrentHashDB_thenConcurrentHashDBSizeIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashDB concurrentHashDB = new ConcurrentHashDB();

    // Act
    concurrentHashDB.remove("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertEquals(0L, concurrentHashDB.size());
  }

  /**
   * Test {@link ConcurrentHashDB#remove(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentHashDB} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentHashDB#remove(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConcurrentHashDB.remove(byte[])"})
  public void testRemoveWithByte_thenConcurrentHashDBSizeIsOne()
      throws UnsupportedEncodingException {
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
   * Test {@link ConcurrentHashDB#iterator()}.
   *
   * <p>Method under test: {@link ConcurrentHashDB#iterator()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Iterator ConcurrentHashDB.iterator()"})
  public void testIterator() {
    // Arrange, Act and Assert
    assertNull(new ConcurrentHashDB().iterator());
  }

  /**
   * Test {@link ConcurrentHashDB#newInstance()}.
   *
   * <p>Method under test: {@link ConcurrentHashDB#newInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.db2.common.DB ConcurrentHashDB.newInstance()"})
  public void testNewInstance() {
    // Arrange, Act and Assert
    assertNull(new ConcurrentHashDB().newInstance());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ConcurrentHashDB}
   *   <li>{@link ConcurrentHashDB#stat()}
   *   <li>{@link ConcurrentHashDB#getDbName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConcurrentHashDB.<init>()",
    "java.lang.String ConcurrentHashDB.getDbName()",
    "void ConcurrentHashDB.stat()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ConcurrentHashDB actualConcurrentHashDB = new ConcurrentHashDB();
    actualConcurrentHashDB.stat();

    // Assert
    assertNull(actualConcurrentHashDB.getDbName());
  }
}
