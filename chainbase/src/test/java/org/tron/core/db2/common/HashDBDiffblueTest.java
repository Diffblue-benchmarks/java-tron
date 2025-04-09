package org.tron.core.db2.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.db2.common.Value.Operator;

public class HashDBDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HashDB#HashDB(String)}
   *   <li>{@link HashDB#stat()}
   *   <li>{@link HashDB#getDbName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HashDB.<init>(String)", "String HashDB.getDbName()", "void HashDB.stat()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    HashDB actualHashDB = new HashDB("Name");
    actualHashDB.stat();

    // Assert
    assertEquals("Name", actualHashDB.getDbName());
  }

  /**
   * Test {@link HashDB#get(Key)} with {@code Key}.
   * <ul>
   *   <li>When copyOf {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashDB#get(Key)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value HashDB.get(Key)"})
  public void testGetWithKey_whenCopyOfAxaxaxaxBytesIsUtf8_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    HashDB hashDB = new HashDB("Name");

    // Act and Assert
    assertNull(hashDB.get(Key.copyOf("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link HashDB#put(Key, Value)} with {@code Key}, {@code Value}.
   * <ul>
   *   <li>When copyOf {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then {@link HashDB#HashDB(String)} with {@code Name} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashDB#put(Key, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void HashDB.put(Key, Value)"})
  public void testPutWithKeyValue_whenCopyOfAxaxaxaxBytesIsUtf8_thenHashDBWithNameSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    HashDB hashDB = new HashDB("Name");
    Key key = Key.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Act
    hashDB.put(key, Value.copyOf(Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertEquals(1L, hashDB.size());
    assertFalse(hashDB.isEmpty());
  }

  /**
   * Test {@link HashDB#size()}.
   * <p>
   * Method under test: {@link HashDB#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long HashDB.size()"})
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0L, (new HashDB("Name")).size());
  }

  /**
   * Test {@link HashDB#isEmpty()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashDB#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean HashDB.isEmpty()"})
  public void testIsEmpty_givenA_thenReturnFalse() {
    // Arrange
    HashDB hashDB = new HashDB("Name");
    Key key = Key.copyOf(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});
    hashDB.put(key, Value.copyOf(Operator.CREATE, new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4}));

    // Act and Assert
    assertFalse(hashDB.isEmpty());
  }

  /**
   * Test {@link HashDB#isEmpty()}.
   * <ul>
   *   <li>Given {@link HashDB#HashDB(String)} with {@code Name}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashDB#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean HashDB.isEmpty()"})
  public void testIsEmpty_givenHashDBWithName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new HashDB("Name")).isEmpty());
  }

  /**
   * Test {@link HashDB#iterator()}.
   * <p>
   * Method under test: {@link HashDB#iterator()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Iterator HashDB.iterator()"})
  public void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new HashDB("Name")).iterator().hasNext());
  }

  /**
   * Test {@link HashDB#newInstance()}.
   * <p>
   * Method under test: {@link HashDB#newInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"HashDB HashDB.newInstance()"})
  public void testNewInstance() {
    // Arrange and Act
    HashDB actualNewInstanceResult = (new HashDB("Name")).newInstance();

    // Assert
    assertEquals("Name", actualNewInstanceResult.getDbName());
    assertEquals(0L, actualNewInstanceResult.size());
    assertTrue(actualNewInstanceResult.isEmpty());
  }
}
