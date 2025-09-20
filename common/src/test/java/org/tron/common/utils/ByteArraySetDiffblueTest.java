package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ByteArraySetDiffblueTest {
  /**
   * Test {@link ByteArraySet#ByteArraySet()}.
   *
   * <p>Method under test: {@link ByteArraySet#ByteArraySet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ByteArraySet.<init>()", "void ByteArraySet.<init>(Set)"})
  public void testNewByteArraySet() {
    // Arrange, Act and Assert
    assertTrue(new ByteArraySet().isEmpty());
  }

  /**
   * Test {@link ByteArraySet#ByteArraySet(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#ByteArraySet(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ByteArraySet.<init>()", "void ByteArraySet.<init>(Set)"})
  public void testNewByteArraySet_whenHashSet() {
    // Arrange, Act and Assert
    assertTrue(new ByteArraySet(new HashSet<>()).isEmpty());
  }

  /**
   * Test {@link ByteArraySet#size()}.
   *
   * <p>Method under test: {@link ByteArraySet#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ByteArraySet.size()"})
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new ByteArraySet().size());
  }

  /**
   * Test {@link ByteArraySet#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.isEmpty()"})
  public void testIsEmpty_givenArrayListAddAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<byte[]> c = new ArrayList<>();
    c.add("AXAXAXAX".getBytes("UTF-8"));

    ByteArraySet byteArraySet = new ByteArraySet();
    byteArraySet.addAll(c);

    // Act and Assert
    assertFalse(byteArraySet.isEmpty());
  }

  /**
   * Test {@link ByteArraySet#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link ByteArraySet#ByteArraySet()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.isEmpty()"})
  public void testIsEmpty_givenByteArraySet_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ByteArraySet().isEmpty());
  }

  /**
   * Test {@link ByteArraySet#iterator()}.
   *
   * <p>Method under test: {@link ByteArraySet#iterator()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Iterator ByteArraySet.iterator()"})
  public void testIterator() {
    // Arrange, Act and Assert
    assertFalse(new ByteArraySet().iterator().hasNext());
  }

  /**
   * Test {@link ByteArraySet#toArray(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>Given {@link ByteArraySet#ByteArraySet()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#toArray(Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ByteArraySet.toArray(Object[])"})
  public void testToArrayWithObject_givenByteArraySet_thenReturnArrayLengthIsZero() {
    // Arrange and Act
    Object[] actualToArrayResult = new ByteArraySet().toArray(new Object[] {"42"});

    // Assert
    assertTrue(actualToArrayResult instanceof byte[][]);
    assertEquals(0, actualToArrayResult.length);
  }

  /**
   * Test {@link ByteArraySet#toArray()}.
   *
   * <ul>
   *   <li>Given {@link ByteArraySet#ByteArraySet()}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#toArray()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ByteArraySet.toArray()"})
  public void testToArray_givenByteArraySet_thenReturnArrayLengthIsZero() {
    // Arrange and Act
    Object[] actualToArrayResult = new ByteArraySet().toArray();

    // Assert
    assertTrue(actualToArrayResult instanceof byte[][]);
    assertEquals(0, actualToArrayResult.length);
  }

  /**
   * Test {@link ByteArraySet#add(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then {@link ByteArraySet#ByteArraySet()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#add(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.add(byte[])"})
  public void testAddWithByte_whenAxaxaxaxBytesIsUtf8_thenByteArraySetSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    // Act
    boolean actualAddResult = byteArraySet.add("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(1, byteArraySet.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link ByteArraySet#containsAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#containsAll(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.containsAll(Collection)"})
  public void testContainsAll_given42_whenArrayListAdd42() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.containsAll(c));
  }

  /**
   * Test {@link ByteArraySet#containsAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#containsAll(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.containsAll(Collection)"})
  public void testContainsAll_given42_whenArrayListAdd422() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");
    c.add("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.containsAll(c));
  }

  /**
   * Test {@link ByteArraySet#containsAll(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#containsAll(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.containsAll(Collection)"})
  public void testContainsAll_whenArrayList() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.containsAll(new ArrayList<>()));
  }

  /**
   * Test {@link ByteArraySet#addAll(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then {@link ByteArraySet#ByteArraySet()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#addAll(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.addAll(Collection)"})
  public void testAddAll_whenArrayListAddAxaxaxaxBytesIsUtf8_thenByteArraySetSizeIsOne()
      throws UnsupportedEncodingException {
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
   * Test {@link ByteArraySet#addAll(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#addAll(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.addAll(Collection)"})
  public void testAddAll_whenArrayList_thenReturnFalse() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    // Act and Assert
    assertFalse(byteArraySet.addAll(new ArrayList<>()));
    assertTrue(byteArraySet.isEmpty());
  }

  /**
   * Test {@link ByteArraySet#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#retainAll(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.retainAll(Collection)"})
  public void testRetainAll_given42_whenArrayListAdd42() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.retainAll(c));
  }

  /**
   * Test {@link ByteArraySet#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#retainAll(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.retainAll(Collection)"})
  public void testRetainAll_given42_whenArrayListAdd422() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");
    c.add("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.retainAll(c));
  }

  /**
   * Test {@link ByteArraySet#retainAll(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#retainAll(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.retainAll(Collection)"})
  public void testRetainAll_whenArrayList() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.retainAll(new ArrayList<>()));
  }

  /**
   * Test {@link ByteArraySet#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#removeAll(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.removeAll(Collection)"})
  public void testRemoveAll_given42_whenArrayListAdd42() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.removeAll(c));
  }

  /**
   * Test {@link ByteArraySet#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#removeAll(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.removeAll(Collection)"})
  public void testRemoveAll_given42_whenArrayListAdd422() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");
    c.add("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.removeAll(c));
  }

  /**
   * Test {@link ByteArraySet#removeAll(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#removeAll(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.removeAll(Collection)"})
  public void testRemoveAll_whenArrayList() {
    // Arrange
    ByteArraySet byteArraySet = new ByteArraySet();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> byteArraySet.removeAll(new ArrayList<>()));
  }

  /**
   * Test {@link ByteArraySet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.equals(Object)", "int ByteArraySet.hashCode()"})
  public void testEquals_whenOtherIsNull_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new ByteArraySet().equals(null));
  }

  /**
   * Test {@link ByteArraySet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.equals(Object)", "int ByteArraySet.hashCode()"})
  public void testEquals_whenOtherIsSame_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new ByteArraySet().equals(new ByteArraySet()));
  }

  /**
   * Test {@link ByteArraySet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link ByteArraySet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ByteArraySet.equals(Object)", "int ByteArraySet.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenThrowException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> new ByteArraySet().equals("Different type to ByteArraySet"));
  }
}
