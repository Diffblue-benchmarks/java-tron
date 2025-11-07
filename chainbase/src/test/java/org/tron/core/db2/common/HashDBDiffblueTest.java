package org.tron.core.db2.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class HashDBDiffblueTest {
  /**
   * Method under test: {@link HashDB#get(Key)}
   */
  @Test
  public void testGet() throws UnsupportedEncodingException {
    // Arrange
    HashDB hashDB = new HashDB("Name");

    // Act and Assert
    assertNull(hashDB.get(Key.copyOf("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test: {@link HashDB#put(Key, Value)}
   */
  @Test
  public void testPut() throws UnsupportedEncodingException {
    // Arrange
    HashDB hashDB = new HashDB("Name");
    Key key = Key.copyOf("AXAXAXAX".getBytes("UTF-8"));

    // Act
    hashDB.put(key, Value.copyOf(Value.Operator.CREATE, "AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertEquals(1L, hashDB.size());
    assertFalse(hashDB.isEmpty());
  }

  /**
   * Method under test: {@link HashDB#size()}
   */
  @Test
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0L, (new HashDB("Name")).size());
  }

  /**
   * Method under test: {@link HashDB#isEmpty()}
   */
  @Test
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new HashDB("Name")).isEmpty());
  }

  /**
   * Method under test: {@link HashDB#isEmpty()}
   */
  @Test
  public void testIsEmpty2() {
    // Arrange
    HashDB hashDB = new HashDB("Name");
    Key key = Key.copyOf(new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4});
    hashDB.put(key, Value.copyOf(Value.Operator.CREATE, new byte[]{'A', 4, 'A', 4, 'A', 4, 'A', 4}));

    // Act and Assert
    assertFalse(hashDB.isEmpty());
  }

  /**
   * Method under test: {@link HashDB#iterator()}
   */
  @Test
  public void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new HashDB("Name")).iterator().hasNext());
  }

  /**
   * Method under test: {@link HashDB#newInstance()}
   */
  @Test
  public void testNewInstance() {
    // Arrange and Act
    HashDB actualNewInstanceResult = (new HashDB("Name")).newInstance();

    // Assert
    assertEquals("Name", actualNewInstanceResult.getDbName());
    assertEquals(0L, actualNewInstanceResult.size());
    assertTrue(actualNewInstanceResult.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HashDB#HashDB(String)}
   *   <li>{@link HashDB#stat()}
   *   <li>{@link HashDB#getDbName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    HashDB actualHashDB = new HashDB("Name");
    actualHashDB.stat();

    // Assert that nothing has changed
    assertEquals("Name", actualHashDB.getDbName());
  }
}
