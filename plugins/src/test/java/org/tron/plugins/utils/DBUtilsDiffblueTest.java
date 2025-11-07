package org.tron.plugins.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.iq80.leveldb.CompressionType;
import org.iq80.leveldb.Options;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.plugins.utils.DBUtils.Operator;

public class DBUtilsDiffblueTest {
  /**
   * Test {@link DBUtils#newDefaultLevelDbOptions()}.
   * <p>
   * Method under test: {@link DBUtils#newDefaultLevelDbOptions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test Operator {@link Operator#getValue()}.
   * <p>
   * Method under test: {@link Operator#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte Operator.getValue()"})
  public void testOperatorGetValue() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, Operator.valueOf("CREATE").getValue());
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Operator.valueOf((byte) 'A'));
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code MODIFY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenOne_thenReturnModify() {
    // Arrange, Act and Assert
    assertEquals(Operator.MODIFY, Operator.valueOf((byte) 1));
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code PUT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenThree_thenReturnPut() {
    // Arrange, Act and Assert
    assertEquals(Operator.PUT, Operator.valueOf((byte) 3));
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code DELETE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenTwo_thenReturnDelete() {
    // Arrange, Act and Assert
    assertEquals(Operator.DELETE, Operator.valueOf((byte) 2));
  }

  /**
   * Test Operator {@link Operator#valueOf(byte)} with {@code b}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code CREATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operator#valueOf(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operator Operator.valueOf(byte)"})
  public void testOperatorValueOfWithB_whenZero_thenReturnCreate() {
    // Arrange, Act and Assert
    assertEquals(Operator.CREATE, Operator.valueOf((byte) 0));
  }
}
