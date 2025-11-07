package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class StorageRowCapsuleDiffblueTest {
  /**
   * Method under test: {@link StorageRowCapsule#setValue(byte[])}
   */
  @Test
  public void testSetValue() throws UnsupportedEncodingException {
    // Arrange
    StorageRowCapsule storageRowCapsule = new StorageRowCapsule("AXAXAXAX".getBytes("UTF-8"));
    byte[] value = "AXAXAXAX".getBytes("UTF-8");

    // Act
    storageRowCapsule.setValue(value);

    // Assert
    assertTrue(storageRowCapsule.isDirty());
    assertSame(value, storageRowCapsule.getData());
    assertSame(value, storageRowCapsule.getInstance());
    assertSame(value, storageRowCapsule.getRowValue());
    assertSame(value, storageRowCapsule.getValue());
  }

  /**
   * Method under test: {@link StorageRowCapsule#getInstance()}
   */
  @Test
  public void testGetInstance() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualInstance = (new StorageRowCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualInstance);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StorageRowCapsule#StorageRowCapsule(byte[])}
   *   <li>{@link StorageRowCapsule#setRowKey(byte[])}
   *   <li>{@link StorageRowCapsule#toString()}
   *   <li>{@link StorageRowCapsule#getData()}
   *   <li>{@link StorageRowCapsule#getRowKey()}
   *   <li>{@link StorageRowCapsule#getRowValue()}
   *   <li>{@link StorageRowCapsule#getValue()}
   *   <li>{@link StorageRowCapsule#isDirty()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] rowValue = "AXAXAXAX".getBytes("UTF-8");

    // Act
    StorageRowCapsule actualStorageRowCapsule = new StorageRowCapsule(rowValue);
    byte[] rowKey = "AXAXAXAX".getBytes("UTF-8");
    actualStorageRowCapsule.setRowKey(rowKey);
    String actualToStringResult = actualStorageRowCapsule.toString();
    byte[] actualData = actualStorageRowCapsule.getData();
    byte[] actualRowKey = actualStorageRowCapsule.getRowKey();
    byte[] actualRowValue = actualStorageRowCapsule.getRowValue();
    byte[] actualValue = actualStorageRowCapsule.getValue();

    // Assert that nothing has changed
    assertEquals("[65, 88, 65, 88, 65, 88, 65, 88]", actualToStringResult);
    assertFalse(actualStorageRowCapsule.isDirty());
    assertSame(rowValue, actualData);
    assertSame(rowValue, actualStorageRowCapsule.getInstance());
    assertSame(rowKey, actualRowKey);
    assertSame(rowValue, actualRowValue);
    assertSame(rowValue, actualValue);
  }
}
