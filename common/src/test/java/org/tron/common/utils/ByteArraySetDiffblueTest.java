package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class ByteArraySetDiffblueTest {
  /**
   * Method under test: {@link ByteArraySet#size()}
   */
  @Test
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new ByteArraySet()).size());
  }

  /**
   * Method under test: {@link ByteArraySet#isEmpty()}
   */
  @Test
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ByteArraySet()).isEmpty());
  }

  /**
   * Method under test: {@link ByteArraySet#isEmpty()}
   */
  @Test
  public void testIsEmpty2() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<byte[]> c = new ArrayList<>();
    c.add("AXAXAXAX".getBytes("UTF-8"));

    ByteArraySet byteArraySet = new ByteArraySet();
    byteArraySet.addAll(c);

    // Act and Assert
    assertFalse(byteArraySet.isEmpty());
  }

  /**
   * Method under test: {@link ByteArraySet#iterator()}
   */
  @Test
  public void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new ByteArraySet()).iterator().hasNext());
  }

  /**
   * Method under test: {@link ByteArraySet#toArray()}
   */
  @Test
  public void testToArray() {
    // Arrange and Act
    Object[] actualToArrayResult = (new ByteArraySet()).toArray();

    // Assert
    assertTrue(actualToArrayResult instanceof byte[][]);
    assertEquals(0, actualToArrayResult.length);
  }

  /**
   * Method under test: {@link ByteArraySet#toArray(Object[])}
   */
  @Test
  public void testToArray2() {
    // Arrange and Act
    Object[] actualToArrayResult = (new ByteArraySet()).toArray(new Object[]{"42"});

    // Assert
    assertTrue(actualToArrayResult instanceof byte[][]);
    assertEquals(0, actualToArrayResult.length);
  }

  /**
   * Method under test: {@link ByteArraySet#add(byte[])}
   */
  @Test
  public void testAdd() throws UnsupportedEncodingException {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    // Act
    boolean actualAddResult = byteArraySet.add("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, byteArraySet.size());
    assertTrue(actualAddResult);
  }

  /**
   * Method under test: {@link ByteArraySet#containsAll(Collection)}
   */
  @Test
  public void testContainsAll() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.containsAll(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ByteArraySet#containsAll(Collection)}
   */
  @Test
  public void testContainsAll2() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.containsAll(c));
  }

  /**
   * Method under test: {@link ByteArraySet#containsAll(Collection)}
   */
  @Test
  public void testContainsAll3() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");
    c.add("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.containsAll(c));
  }

  /**
   * Method under test: {@link ByteArraySet#addAll(Collection)}
   */
  @Test
  public void testAddAll() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    // Act and Assert
    assertFalse(byteArraySet.addAll(new ArrayList<>()));
    assertTrue(byteArraySet.isEmpty());
  }

  /**
   * Method under test: {@link ByteArraySet#addAll(Collection)}
   */
  @Test
  public void testAddAll2() throws UnsupportedEncodingException {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<byte[]> c = new ArrayList<>();
    c.add("AXAXAXAX".getBytes("UTF-8"));
    c.add("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualAddAllResult = byteArraySet.addAll(c);

    // Assert
    assertEquals(1, byteArraySet.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Method under test: {@link ByteArraySet#retainAll(Collection)}
   */
  @Test
  public void testRetainAll() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.retainAll(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ByteArraySet#retainAll(Collection)}
   */
  @Test
  public void testRetainAll2() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.retainAll(c));
  }

  /**
   * Method under test: {@link ByteArraySet#retainAll(Collection)}
   */
  @Test
  public void testRetainAll3() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");
    c.add("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.retainAll(c));
  }

  /**
   * Method under test: {@link ByteArraySet#removeAll(Collection)}
   */
  @Test
  public void testRemoveAll() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.removeAll(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ByteArraySet#removeAll(Collection)}
   */
  @Test
  public void testRemoveAll2() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.removeAll(c));
  }

  /**
   * Method under test: {@link ByteArraySet#removeAll(Collection)}
   */
  @Test
  public void testRemoveAll3() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");
    c.add("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.removeAll(c));
  }

  /**
   * Method under test: {@link ByteArraySet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new ByteArraySet()).equals(null));
  }

  /**
   * Method under test: {@link ByteArraySet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsSame_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new ByteArraySet()).equals(new ByteArraySet()));
  }

  /**
   * Method under test: {@link ByteArraySet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new ByteArraySet()).equals("Different type to ByteArraySet"));
  }

  /**
   * Method under test: {@link ByteArraySet#ByteArraySet()}
   */
  @Test
  public void testNewByteArraySet() {
    // Arrange, Act and Assert
    assertTrue((new ByteArraySet()).isEmpty());
    assertTrue((new ByteArraySet(new HashSet<>())).isEmpty());
  }
}
