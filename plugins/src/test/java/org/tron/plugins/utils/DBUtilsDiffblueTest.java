package org.tron.plugins.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import org.iq80.leveldb.CompressionType;
import org.iq80.leveldb.Options;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.plugins.utils.DBUtils.Operator;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Transaction;

public class DBUtilsDiffblueTest {
  /**
   * Test {@link DBUtils#newDefaultLevelDbOptions()}.
   *
   * <p>Method under test: {@link DBUtils#newDefaultLevelDbOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Options DBUtils.newDefaultLevelDbOptions()"})
  public void testNewDefaultLevelDbOptions() {
    // Arrange and Act
    Options actualNewDefaultLevelDbOptionsResult = DBUtils.newDefaultLevelDbOptions();

    // Assert
    assertNull(actualNewDefaultLevelDbOptionsResult.comparator());
    assertNull(actualNewDefaultLevelDbOptionsResult.logger());
    assertEquals(0, actualNewDefaultLevelDbOptionsResult.maxManifestSize());
    assertEquals(1000, actualNewDefaultLevelDbOptionsResult.maxOpenFiles());
    assertEquals(10485760, actualNewDefaultLevelDbOptionsResult.writeBufferSize());
    assertEquals(10485760L, actualNewDefaultLevelDbOptionsResult.cacheSize());
    assertEquals(4096, actualNewDefaultLevelDbOptionsResult.blockSize());
    assertEquals(80000, actualNewDefaultLevelDbOptionsResult.maxBatchSize());
    assertEquals(CompressionType.SNAPPY, actualNewDefaultLevelDbOptionsResult.compressionType());
    assertFalse(actualNewDefaultLevelDbOptionsResult.errorIfExists());
    assertTrue(actualNewDefaultLevelDbOptionsResult.createIfMissing());
    assertTrue(actualNewDefaultLevelDbOptionsResult.paranoidChecks());
    assertTrue(actualNewDefaultLevelDbOptionsResult.verifyChecksums());
    assertEquals(Short.SIZE, actualNewDefaultLevelDbOptionsResult.blockRestartInterval());
  }

  /**
   * Test {@link DBUtils#newDefaultLevelDbOptions()}.
   *
   * <p>Method under test: {@link DBUtils#newDefaultLevelDbOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Options DBUtils.newDefaultLevelDbOptions()"})
  public void testNewDefaultLevelDbOptions2() {
    // Arrange and Act
    Options actualNewDefaultLevelDbOptionsResult = DBUtils.newDefaultLevelDbOptions();

    // Assert
    assertNull(actualNewDefaultLevelDbOptionsResult.comparator());
    assertNull(actualNewDefaultLevelDbOptionsResult.logger());
    assertEquals(0, actualNewDefaultLevelDbOptionsResult.maxManifestSize());
    assertEquals(1000, actualNewDefaultLevelDbOptionsResult.maxOpenFiles());
    assertEquals(10485760, actualNewDefaultLevelDbOptionsResult.writeBufferSize());
    assertEquals(10485760L, actualNewDefaultLevelDbOptionsResult.cacheSize());
    assertEquals(4096, actualNewDefaultLevelDbOptionsResult.blockSize());
    assertEquals(80000, actualNewDefaultLevelDbOptionsResult.maxBatchSize());
    assertEquals(CompressionType.SNAPPY, actualNewDefaultLevelDbOptionsResult.compressionType());
    assertFalse(actualNewDefaultLevelDbOptionsResult.errorIfExists());
    assertTrue(actualNewDefaultLevelDbOptionsResult.createIfMissing());
    assertTrue(actualNewDefaultLevelDbOptionsResult.paranoidChecks());
    assertTrue(actualNewDefaultLevelDbOptionsResult.verifyChecksums());
    assertEquals(Short.SIZE, actualNewDefaultLevelDbOptionsResult.blockRestartInterval());
  }

  /**
   * Test {@link DBUtils#getTransactionId(Transaction)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return not ByteString Empty.
   * </ul>
   *
   * <p>Method under test: {@link DBUtils#getTransactionId(Transaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sha256Hash DBUtils.getTransactionId(Transaction)"})
  public void testGetTransactionId_whenDefaultInstance_thenReturnNotByteStringEmpty() {
    // Arrange and Act
    Sha256Hash actualTransactionId = DBUtils.getTransactionId(Transaction.getDefaultInstance());

    // Assert
    ByteString byteString = actualTransactionId.getByteString();
    assertFalse(byteString.isEmpty());
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals((byte) -29, iteratorResult.next().byteValue());
    assertEquals((byte) -80, iteratorResult.next().byteValue());
    assertEquals((byte) -60, iteratorResult.next().byteValue());
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        actualTransactionId.getBytes());
  }

  /**
   * Test {@link DBUtils#getTransactionId(Transaction)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return not ByteString Empty.
   * </ul>
   *
   * <p>Method under test: {@link DBUtils#getTransactionId(Transaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sha256Hash DBUtils.getTransactionId(Transaction)"})
  public void testGetTransactionId_whenDefaultInstance_thenReturnNotByteStringEmpty2() {
    // Arrange and Act
    Sha256Hash actualTransactionId = DBUtils.getTransactionId(Transaction.getDefaultInstance());

    // Assert
    ByteString byteString = actualTransactionId.getByteString();
    assertFalse(byteString.isEmpty());
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals((byte) -29, iteratorResult.next().byteValue());
    assertEquals((byte) -80, iteratorResult.next().byteValue());
    assertEquals((byte) -60, iteratorResult.next().byteValue());
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        actualTransactionId.getBytes());
  }

  /**
   * Test Operator {@link Operator#getValue()}.
   *
   * <p>Method under test: {@link Operator#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte Operator.getValue()"})
  public void testOperatorGetValue() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, Operator.valueOf("CREATE").getValue());
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Operator.valueOf((byte) 'A'));
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code MODIFY}.
   * </ul>
   *
   * <p>Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenOne_thenReturnModify() {
    // Arrange, Act and Assert
    assertEquals(Operator.MODIFY, Operator.valueOf((byte) 1));
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code PUT}.
   * </ul>
   *
   * <p>Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenThree_thenReturnPut() {
    // Arrange, Act and Assert
    assertEquals(Operator.PUT, Operator.valueOf((byte) 3));
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code DELETE}.
   * </ul>
   *
   * <p>Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenTwo_thenReturnDelete() {
    // Arrange, Act and Assert
    assertEquals(Operator.DELETE, Operator.valueOf((byte) 2));
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code CREATE}.
   * </ul>
   *
   * <p>Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenZero_thenReturnCreate() {
    // Arrange, Act and Assert
    assertEquals(Operator.CREATE, Operator.valueOf((byte) 0));
  }
}
