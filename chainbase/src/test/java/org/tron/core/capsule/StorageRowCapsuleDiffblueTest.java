package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;

public class StorageRowCapsuleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StorageRowCapsule.<init>(byte[])", "byte[] StorageRowCapsule.getData()",
      "byte[] StorageRowCapsule.getRowKey()", "byte[] StorageRowCapsule.getRowValue()",
      "byte[] StorageRowCapsule.getValue()", "boolean StorageRowCapsule.isDirty()",
      "void StorageRowCapsule.setRowKey(byte[])", "String StorageRowCapsule.toString()"})
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

    // Assert
    assertEquals("[65, 88, 65, 88, 65, 88, 65, 88]", actualToStringResult);
    assertFalse(actualStorageRowCapsule.isDirty());
    assertSame(rowValue, actualData);
    byte[] instance = actualStorageRowCapsule.getInstance();
    assertSame(rowValue, instance);
    assertSame(rowKey, actualRowKey);
    assertSame(rowValue, actualRowValue);
    assertSame(rowValue, actualValue);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), instance);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualRowKey);
  }

  /**
   * Test {@link StorageRowCapsule#StorageRowCapsule(byte[], byte[])}.
   * <p>
   * Method under test: {@link StorageRowCapsule#StorageRowCapsule(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StorageRowCapsule.<init>(byte[], byte[])"})
  public void testNewStorageRowCapsule() throws UnsupportedEncodingException {
    // Arrange
    byte[] rowKey = "AXAXAXAX".getBytes("UTF-8");
    byte[] rowValue = "AXAXAXAX".getBytes("UTF-8");

    // Act
    StorageRowCapsule actualStorageRowCapsule = new StorageRowCapsule(rowKey, rowValue);

    // Assert
    Sha256Hash hash = actualStorageRowCapsule.getHash();
    BigInteger toBigIntegerResult = hash.toBigInteger();
    assertEquals("41774241789126944098306227155094803171342615589867574088397738610130220530396",
        toBigIntegerResult.toString());
    ByteString byteString = hash.getByteString();
    assertEquals("\\[b\t�g�� �\ru�/���l�؊KS�\u0001�9�\u001a`��", byteString.toStringUtf8());
    assertEquals(1, toBigIntegerResult.signum());
    assertEquals(2, toBigIntegerResult.getLowestSetBit());
    assertFalse(byteString.isEmpty());
    assertTrue(byteString.iterator().hasNext());
    assertTrue(actualStorageRowCapsule.isDirty());
    assertSame(rowValue, actualStorageRowCapsule.getInstance());
    assertSame(rowValue, actualStorageRowCapsule.getRowValue());
    assertSame(rowValue, actualStorageRowCapsule.getValue());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualStorageRowCapsule.getData());
    byte[] expectedRowKey = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedRowKey, actualStorageRowCapsule.getRowKey());
    assertArrayEquals(new byte[]{'\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
        'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36}, toBigIntegerResult.toByteArray());
    assertArrayEquals(new byte[]{'\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
        'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36}, hash.getBytes());
  }

  /**
   * Test {@link StorageRowCapsule#StorageRowCapsule(StorageRowCapsule)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return not Dirty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageRowCapsule#StorageRowCapsule(StorageRowCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StorageRowCapsule.<init>(StorageRowCapsule)"})
  public void testNewStorageRowCapsule_givenAxaxaxaxBytesIsUtf8_thenReturnNotDirty()
      throws UnsupportedEncodingException {
    // Arrange
    StorageRowCapsule rowCapsule = new StorageRowCapsule("AXAXAXAX".getBytes("UTF-8"));
    rowCapsule.setRowKey("AXAXAXAX".getBytes("UTF-8"));

    // Act
    StorageRowCapsule actualStorageRowCapsule = new StorageRowCapsule(rowCapsule);

    // Assert
    assertFalse(actualStorageRowCapsule.isDirty());
    byte[] data = actualStorageRowCapsule.getData();
    assertSame(data, actualStorageRowCapsule.getInstance());
    assertSame(data, actualStorageRowCapsule.getRowValue());
    assertSame(data, actualStorageRowCapsule.getValue());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data);
    byte[] expectedRowKey = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedRowKey, actualStorageRowCapsule.getRowKey());
    Sha256Hash hash = actualStorageRowCapsule.getHash();
    assertArrayEquals(new byte[]{'\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
        'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36}, hash.toBigInteger().toByteArray());
    assertArrayEquals(new byte[]{'\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
        'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36}, hash.getBytes());
  }

  /**
   * Test {@link StorageRowCapsule#StorageRowCapsule(StorageRowCapsule)}.
   * <ul>
   *   <li>Then return Dirty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StorageRowCapsule#StorageRowCapsule(StorageRowCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StorageRowCapsule.<init>(StorageRowCapsule)"})
  public void testNewStorageRowCapsule_thenReturnDirty() throws UnsupportedEncodingException {
    // Arrange
    byte[] rowKey = "AXAXAXAX".getBytes("UTF-8");

    // Act
    StorageRowCapsule actualStorageRowCapsule = new StorageRowCapsule(
        new StorageRowCapsule(rowKey, "AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertTrue(actualStorageRowCapsule.isDirty());
    byte[] data = actualStorageRowCapsule.getData();
    assertSame(data, actualStorageRowCapsule.getInstance());
    assertSame(data, actualStorageRowCapsule.getRowValue());
    assertSame(data, actualStorageRowCapsule.getValue());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data);
    byte[] expectedRowKey = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedRowKey, actualStorageRowCapsule.getRowKey());
    Sha256Hash hash = actualStorageRowCapsule.getHash();
    assertArrayEquals(new byte[]{'\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
        'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36}, hash.toBigInteger().toByteArray());
    assertArrayEquals(new byte[]{'\\', '[', 'b', '\t', -40, 'g', -88, -64, ' ', -22, '\r', 'u', -94, '/', -77, -52, -10,
        'l', -76, -40, -118, 'K', 'S', -32, 1, -31, '9', -113, 26, '`', -70, -36}, hash.getBytes());
  }

  /**
   * Test {@link StorageRowCapsule#setValue(byte[])}.
   * <p>
   * Method under test: {@link StorageRowCapsule#setValue(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StorageRowCapsule.setValue(byte[])"})
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
   * Test {@link StorageRowCapsule#getInstance()}.
   * <p>
   * Method under test: {@link StorageRowCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] StorageRowCapsule.getInstance()"})
  public void testGetInstance() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualInstance = (new StorageRowCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualInstance);
  }
}
