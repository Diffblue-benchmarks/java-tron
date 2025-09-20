package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.contract.AssetIssueContractOuterClass;
import org.tron.protos.contract.AssetIssueContractOuterClass.AssetIssueContract;

public class AssetIssueCapsuleDiffblueTest {
  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_when0xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AssetIssueCapsule("0XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 8} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenArrayOfByteWith8AndMinusOne() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule(
            new byte[] {'8', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Assert
    assertNull(actualAssetIssueCapsule.getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenArrayOfByteWithAAndMinusOne() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule(
            new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Assert
    assertNull(actualAssetIssueCapsule.getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenArrayOfByteWithAsteriskAndMinusOne() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule(
            new byte[] {'*', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Assert
    assertNull(actualAssetIssueCapsule.getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenArrayOfByteWithAsteriskAndZero() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule(new byte[] {'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAssetIssueCapsule.getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAssetIssueCapsule.getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAssetIssueCapsule.getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenArrayOfByteWithLfAndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule(new byte[] {'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAssetIssueCapsule.getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenArrayOfByteWithMin_valueAndX() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAssetIssueCapsule.getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAssetIssueCapsule.getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenArrayOfByteWithTwentySixAndX() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAssetIssueCapsule.getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAssetIssueCapsule.getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualAssetIssueCapsule.getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[], String, String, String, long, int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Id is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[], String, String,
   * String, long, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[], String, String, String, long, int)"})
  public void testNewAssetIssueCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnIdIs42()
      throws UnsupportedEncodingException {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Assert
    assertEquals("42", actualAssetIssueCapsule.getId());
    assertEquals(0, actualAssetIssueCapsule.getFrozenSupplyCount());
    assertEquals(0, actualAssetIssueCapsule.getNum());
    assertEquals(0, actualAssetIssueCapsule.getTrxNum());
    assertEquals(0L, actualAssetIssueCapsule.getEndTime());
    assertEquals(0L, actualAssetIssueCapsule.getFreeAssetNetLimit());
    assertEquals(0L, actualAssetIssueCapsule.getFrozenSupply());
    assertEquals(0L, actualAssetIssueCapsule.getOrder());
    assertEquals(0L, actualAssetIssueCapsule.getPublicFreeAssetNetLimit());
    assertEquals(0L, actualAssetIssueCapsule.getPublicFreeAssetNetUsage());
    assertEquals(0L, actualAssetIssueCapsule.getPublicLatestFreeNetTime());
    assertEquals(0L, actualAssetIssueCapsule.getStartTime());
    assertEquals(1, actualAssetIssueCapsule.getPrecision());
    assertTrue(actualAssetIssueCapsule.getFrozenSupplyList().isEmpty());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -54, 2, 2, '4', '2'
        },
        actualAssetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Id is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenEmptyArrayOfByte_thenReturnIdIsEmptyString() {
    // Arrange and Act
    AssetIssueCapsule actualAssetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    // Assert
    assertEquals("", actualAssetIssueCapsule.getId());
    assertEquals(0, actualAssetIssueCapsule.getFrozenSupplyCount());
    assertEquals(0, actualAssetIssueCapsule.getNum());
    assertEquals(0, actualAssetIssueCapsule.getPrecision());
    assertEquals(0, actualAssetIssueCapsule.getTrxNum());
    assertEquals(0L, actualAssetIssueCapsule.getEndTime());
    assertEquals(0L, actualAssetIssueCapsule.getFreeAssetNetLimit());
    assertEquals(0L, actualAssetIssueCapsule.getFrozenSupply());
    assertEquals(0L, actualAssetIssueCapsule.getOrder());
    assertEquals(0L, actualAssetIssueCapsule.getPublicFreeAssetNetLimit());
    assertEquals(0L, actualAssetIssueCapsule.getPublicFreeAssetNetUsage());
    assertEquals(0L, actualAssetIssueCapsule.getPublicLatestFreeNetTime());
    assertEquals(0L, actualAssetIssueCapsule.getStartTime());
    assertTrue(actualAssetIssueCapsule.getFrozenSupplyList().isEmpty());
    assertArrayEquals(new byte[] {}, actualAssetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AssetIssueCapsule("\nXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AssetIssueCapsule(" XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code *XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AssetIssueCapsule("*XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#AssetIssueCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.<init>(byte[])"})
  public void testNewAssetIssueCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AssetIssueCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#createDbKeyString(String, long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#createDbKeyString(String, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AssetIssueCapsule.createDbKeyString(String, long)"})
  public void testCreateDbKeyString() {
    // Arrange, Act and Assert
    assertEquals("Name_1", AssetIssueCapsule.createDbKeyString("Name", 1L));
  }

  /**
   * Test {@link AssetIssueCapsule#getData()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.getData()"})
  public void testGetData() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getData()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.getData()"})
  public void testGetData2() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPrecision(-1);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getData()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.getData()"})
  public void testGetData3() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setOrder(-1L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -54, 2, 2, '4',
          '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getData()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.getData()"})
  public void testGetData4() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setFreeAssetNetLimit(-1L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -80, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -54, 2, 2,
          '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getData()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.getData()"})
  public void testGetData5() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetLimit(-1L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -72, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -54, 2, 2,
          '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getData()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.getData()"})
  public void testGetData6() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -64, 1, '*', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getData()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.getData()"})
  public void testGetData7() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getData()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.getData()"})
  public void testGetData8() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPrecision(0);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getData()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.getData()"})
  public void testGetData9() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setOrder(Long.MAX_VALUE);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          '\n',
          '\b',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          18,
          4,
          'N',
          'a',
          'm',
          'e',
          26,
          4,
          'A',
          'b',
          'b',
          'r',
          ' ',
          1,
          '8',
          1,
          'X',
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          -1,
          Byte.MAX_VALUE,
          -54,
          2,
          2,
          '4',
          '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getInstance()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetIssueContract AssetIssueCapsule.getInstance()"})
  public void testGetInstance_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link AssetIssueCapsule#getName()}.
   *
   * <ul>
   *   <li>Then return not Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString AssetIssueCapsule.getName()"})
  public void testGetName_thenReturnNotEmpty() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    ByteString actualName = assetIssueCapsule.getName();

    // Assert
    assertFalse(actualName.isEmpty());
    ByteIterator iteratorResult = actualName.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    Byte nextResult4 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('N', nextResult.byteValue());
    assertEquals('a', nextResult2.byteValue());
    assertEquals('m', nextResult3.byteValue());
    assertEquals('e', nextResult4.byteValue());
    assertEquals("Name", actualName.toStringUtf8());
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, assetIssueCapsule.getDesc());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertSame(byteString, instance.getDescription());
    assertSame(byteString, instance.getUrl());
    assertSame(byteString, assetIssueCapsule.getUrl());
  }

  /**
   * Test {@link AssetIssueCapsule#getId()}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AssetIssueCapsule.getId()"})
  public void testGetId_thenReturn42() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals("42", assetIssueCapsule.getId());
  }

  /**
   * Test {@link AssetIssueCapsule#setId(String)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setId(String)"})
  public void testSetId() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    assetIssueCapsule.setId("42");

    // Assert that nothing has changed
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
    assertEquals("42", assetIssueCapsule.getId());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(6, instance.getAllFields().size());
    assertEquals("42", instance.getId());
    ByteString idBytes = instance.getIdBytes();
    assertFalse(idBytes.isEmpty());
    ByteIterator iteratorResult = idBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('4', nextResult.byteValue());
    assertEquals('2', nextResult2.byteValue());
    assertEquals("42", idBytes.toStringUtf8());
    assertEquals(31, instance.getSerializedSize());
  }

  /**
   * Test {@link AssetIssueCapsule#setId(String)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setId(String)"})
  public void testSetId2() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setOrder(1L);

    // Act
    assetIssueCapsule.setId("42");

    // Assert that nothing has changed
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
    assertEquals("42", assetIssueCapsule.getId());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(7, instance.getAllFields().size());
    assertEquals("42", instance.getId());
    ByteString idBytes = instance.getIdBytes();
    assertFalse(idBytes.isEmpty());
    ByteIterator iteratorResult = idBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('4', nextResult.byteValue());
    assertEquals('2', nextResult2.byteValue());
    assertEquals("42", idBytes.toStringUtf8());
    assertEquals(33, instance.getSerializedSize());
  }

  /**
   * Test {@link AssetIssueCapsule#setId(String)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setId(String)"})
  public void testSetId3() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setId("42");

    // Assert that nothing has changed
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -80, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
    assertEquals("42", assetIssueCapsule.getId());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(7, instance.getAllFields().size());
    assertEquals("42", instance.getId());
    ByteString idBytes = instance.getIdBytes();
    assertFalse(idBytes.isEmpty());
    ByteIterator iteratorResult = idBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('4', nextResult.byteValue());
    assertEquals('2', nextResult2.byteValue());
    assertEquals("42", idBytes.toStringUtf8());
    assertEquals(34, instance.getSerializedSize());
  }

  /**
   * Test {@link AssetIssueCapsule#setId(String)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setId(String)"})
  public void testSetId4() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setId("42");

    // Assert that nothing has changed
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -72, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
    assertEquals("42", assetIssueCapsule.getId());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(7, instance.getAllFields().size());
    assertEquals("42", instance.getId());
    ByteString idBytes = instance.getIdBytes();
    assertFalse(idBytes.isEmpty());
    ByteIterator iteratorResult = idBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('4', nextResult.byteValue());
    assertEquals('2', nextResult2.byteValue());
    assertEquals("42", idBytes.toStringUtf8());
    assertEquals(34, instance.getSerializedSize());
  }

  /**
   * Test {@link AssetIssueCapsule#setId(String)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setId(String)"})
  public void testSetId5() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setId("42");

    // Assert that nothing has changed
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -64, 1, '*', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
    assertEquals("42", assetIssueCapsule.getId());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(7, instance.getAllFields().size());
    assertEquals("42", instance.getId());
    ByteString idBytes = instance.getIdBytes();
    assertFalse(idBytes.isEmpty());
    ByteIterator iteratorResult = idBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('4', nextResult.byteValue());
    assertEquals('2', nextResult2.byteValue());
    assertEquals("42", idBytes.toStringUtf8());
    assertEquals(34, instance.getSerializedSize());
  }

  /**
   * Test {@link AssetIssueCapsule#setId(String)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setId(String)"})
  public void testSetId6() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setId("42");

    // Assert that nothing has changed
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
    assertEquals("42", assetIssueCapsule.getId());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(7, instance.getAllFields().size());
    assertEquals("42", instance.getId());
    ByteString idBytes = instance.getIdBytes();
    assertFalse(idBytes.isEmpty());
    ByteIterator iteratorResult = idBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('4', nextResult.byteValue());
    assertEquals('2', nextResult2.byteValue());
    assertEquals("42", idBytes.toStringUtf8());
    assertEquals(34, instance.getSerializedSize());
  }

  /**
   * Test {@link AssetIssueCapsule#setId(String)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setId(String)"})
  public void testSetId7() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    // Act
    assetIssueCapsule.setId("42");

    // Assert
    assertArrayEquals(new byte[] {-54, 2, 2, '4', '2'}, assetIssueCapsule.getData());
    assertEquals("42", assetIssueCapsule.getId());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals("42", instance.getId());
    ByteString idBytes = instance.getIdBytes();
    assertFalse(idBytes.isEmpty());
    ByteIterator iteratorResult = idBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('4', nextResult.byteValue());
    assertEquals('2', nextResult2.byteValue());
    assertEquals("42", idBytes.toStringUtf8());
    assertEquals(5, instance.getSerializedSize());
  }

  /**
   * Test {@link AssetIssueCapsule#getPrecision()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getPrecision()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AssetIssueCapsule.getPrecision()"})
  public void testGetPrecision_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals(1, assetIssueCapsule.getPrecision());
  }

  /**
   * Test {@link AssetIssueCapsule#setPrecision(int)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPrecision(int)"})
  public void testSetPrecision() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert that nothing has changed
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    assertEquals(31, instance.getSerializedSize());
    assertEquals(6, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPrecision(int)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPrecision(int)"})
  public void testSetPrecision2() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setOrder(1L);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert that nothing has changed
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPrecision(int)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPrecision(int)"})
  public void testSetPrecision3() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert that nothing has changed
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    assertEquals(34, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -80, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPrecision(int)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPrecision(int)"})
  public void testSetPrecision4() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert that nothing has changed
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    assertEquals(34, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -72, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPrecision(int)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPrecision(int)"})
  public void testSetPrecision5() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert that nothing has changed
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    assertEquals(34, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -64, 1, '*', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPrecision(int)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPrecision(int)"})
  public void testSetPrecision6() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert that nothing has changed
    assertEquals(1, assetIssueCapsule.getPrecision());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getPrecision());
    assertEquals(34, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPrecision(int)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPrecision(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPrecision(int)"})
  public void testSetPrecision7() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    // Act
    assetIssueCapsule.setPrecision(1);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, assetIssueCapsule.getPrecision());
    assertEquals(1, instance.getPrecision());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'8', 1}, assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getOrder()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long AssetIssueCapsule.getOrder()"})
  public void testGetOrder_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getOrder());
  }

  /**
   * Test {@link AssetIssueCapsule#setOrder(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setOrder(long)"})
  public void testSetOrder() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setOrder(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setOrder(long)"})
  public void testSetOrder2() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(36, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -80, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setOrder(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setOrder(long)"})
  public void testSetOrder3() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(36, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -72, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setOrder(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setOrder(long)"})
  public void testSetOrder4() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(36, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -64, 1, '*', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setOrder(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setOrder(long)"})
  public void testSetOrder5() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(36, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setOrder(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setOrder(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setOrder(long)"})
  public void testSetOrder6() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    // Act
    assetIssueCapsule.setOrder(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'X', 1}, assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#createDbV2Key()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#createDbV2Key()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.createDbV2Key()"})
  public void testCreateDbV2Key() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertArrayEquals(new byte[] {'4', '2'}, assetIssueCapsule.createDbV2Key());
  }

  /**
   * Test {@link AssetIssueCapsule#createDbV2Key()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#createDbV2Key()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.createDbV2Key()"})
  public void testCreateDbV2Key2() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setId("42");

    // Act and Assert
    assertArrayEquals(new byte[] {'4', '2'}, assetIssueCapsule.createDbV2Key());
  }

  /**
   * Test {@link AssetIssueCapsule#createDbV2Key()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#createDbV2Key()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.createDbV2Key()"})
  public void testCreateDbV2Key_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setId("");

    // Act and Assert
    assertNull(assetIssueCapsule.createDbV2Key());
  }

  /**
   * Test {@link AssetIssueCapsule#createDbKey()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnEmptyArrayOfByte() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, assetIssueCapsule.createDbKey());
  }

  /**
   * Test {@link AssetIssueCapsule#createDbKey()}.
   *
   * <ul>
   *   <li>Then return {@code Name} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnNameBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertArrayEquals("Name".getBytes("UTF-8"), assetIssueCapsule.createDbKey());
  }

  /**
   * Test {@link AssetIssueCapsule#createDbKeyFinal(DynamicPropertiesStore)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code 4} and {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#createDbKeyFinal(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.createDbKeyFinal(DynamicPropertiesStore)"})
  public void testCreateDbKeyFinal_thenReturnArrayOfByteWith4And2()
      throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);

    // Act
    byte[] actualCreateDbKeyFinalResult =
        assetIssueCapsule.createDbKeyFinal(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertArrayEquals(new byte[] {'4', '2'}, actualCreateDbKeyFinalResult);
  }

  /**
   * Test {@link AssetIssueCapsule#createDbKeyFinal(DynamicPropertiesStore)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#createDbKeyFinal(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.createDbKeyFinal(DynamicPropertiesStore)"})
  public void testCreateDbKeyFinal_thenReturnEmptyArrayOfByte() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);

    // Act
    byte[] actualCreateDbKeyFinalResult =
        assetIssueCapsule.createDbKeyFinal(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertArrayEquals(new byte[] {}, actualCreateDbKeyFinalResult);
  }

  /**
   * Test {@link AssetIssueCapsule#createDbKeyFinal(DynamicPropertiesStore)}.
   *
   * <ul>
   *   <li>Then return {@code Name} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#createDbKeyFinal(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.createDbKeyFinal(DynamicPropertiesStore)"})
  public void testCreateDbKeyFinal_thenReturnNameBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(0L);

    // Act
    byte[] actualCreateDbKeyFinalResult =
        assetIssueCapsule.createDbKeyFinal(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertArrayEquals("Name".getBytes("UTF-8"), actualCreateDbKeyFinalResult);
  }

  /**
   * Test {@link AssetIssueCapsule#createDbKeyFinal(DynamicPropertiesStore)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#createDbKeyFinal(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] AssetIssueCapsule.createDbKeyFinal(DynamicPropertiesStore)"})
  public void testCreateDbKeyFinal_thenReturnNull() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);

    // Act
    byte[] actualCreateDbKeyFinalResult =
        assetIssueCapsule.createDbKeyFinal(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
    assertNull(actualCreateDbKeyFinalResult);
  }

  /**
   * Test {@link AssetIssueCapsule#getNum()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getNum()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AssetIssueCapsule.getNum()"})
  public void testGetNum_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals(0, assetIssueCapsule.getNum());
  }

  /**
   * Test {@link AssetIssueCapsule#getTrxNum()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getTrxNum()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AssetIssueCapsule.getTrxNum()"})
  public void testGetTrxNum_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals(0, assetIssueCapsule.getTrxNum());
  }

  /**
   * Test {@link AssetIssueCapsule#getStartTime()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getStartTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long AssetIssueCapsule.getStartTime()"})
  public void testGetStartTime_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getStartTime());
  }

  /**
   * Test {@link AssetIssueCapsule#getEndTime()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getEndTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long AssetIssueCapsule.getEndTime()"})
  public void testGetEndTime_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getEndTime());
  }

  /**
   * Test {@link AssetIssueCapsule#getOwnerAddress()}.
   *
   * <ul>
   *   <li>Then return not Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getOwnerAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString AssetIssueCapsule.getOwnerAddress()"})
  public void testGetOwnerAddress_thenReturnNotEmpty() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    ByteString actualOwnerAddress = assetIssueCapsule.getOwnerAddress();

    // Assert
    assertFalse(actualOwnerAddress.isEmpty());
    ByteIterator iteratorResult = actualOwnerAddress.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals("AXAXAXAX", actualOwnerAddress.toStringUtf8());
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, assetIssueCapsule.getDesc());
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertSame(byteString, instance.getDescription());
    assertSame(byteString, instance.getUrl());
    assertSame(byteString, assetIssueCapsule.getUrl());
  }

  /**
   * Test {@link AssetIssueCapsule#getFrozenSupplyCount()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getFrozenSupplyCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AssetIssueCapsule.getFrozenSupplyCount()"})
  public void testGetFrozenSupplyCount_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals(0, assetIssueCapsule.getFrozenSupplyCount());
  }

  /**
   * Test {@link AssetIssueCapsule#getFrozenSupplyList()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getFrozenSupplyList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List AssetIssueCapsule.getFrozenSupplyList()"})
  public void testGetFrozenSupplyList_thenReturnEmpty() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertTrue(assetIssueCapsule.getFrozenSupplyList().isEmpty());
  }

  /**
   * Test {@link AssetIssueCapsule#getFrozenSupply()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getFrozenSupply()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long AssetIssueCapsule.getFrozenSupply()"})
  public void testGetFrozenSupply_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getFrozenSupply());
  }

  /**
   * Test {@link AssetIssueCapsule#getFreeAssetNetLimit()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getFreeAssetNetLimit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long AssetIssueCapsule.getFreeAssetNetLimit()"})
  public void testGetFreeAssetNetLimit_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getFreeAssetNetLimit());
  }

  /**
   * Test {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setFreeAssetNetLimit(long)"})
  public void testSetFreeAssetNetLimit() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(34, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -80, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setFreeAssetNetLimit(long)"})
  public void testSetFreeAssetNetLimit2() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setOrder(1L);

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(36, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -80, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setFreeAssetNetLimit(long)"})
  public void testSetFreeAssetNetLimit3() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -80, 1, 1, -72, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setFreeAssetNetLimit(long)"})
  public void testSetFreeAssetNetLimit4() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -80, 1, 1, -64, 1, '*', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setFreeAssetNetLimit(long)"})
  public void testSetFreeAssetNetLimit5() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -80, 1, 1, -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setFreeAssetNetLimit(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setFreeAssetNetLimit(long)"})
  public void testSetFreeAssetNetLimit6() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    // Act
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-80, 1, 1}, assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getPublicFreeAssetNetLimit()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getPublicFreeAssetNetLimit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long AssetIssueCapsule.getPublicFreeAssetNetLimit()"})
  public void testGetPublicFreeAssetNetLimit_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getPublicFreeAssetNetLimit());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicFreeAssetNetLimit(long)"})
  public void testSetPublicFreeAssetNetLimit() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(34, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -72, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicFreeAssetNetLimit(long)"})
  public void testSetPublicFreeAssetNetLimit2() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setOrder(1L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(36, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -72, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicFreeAssetNetLimit(long)"})
  public void testSetPublicFreeAssetNetLimit3() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -80, 1, 1, -72, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicFreeAssetNetLimit(long)"})
  public void testSetPublicFreeAssetNetLimit4() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -72, 1, 1, -64, 1, '*', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicFreeAssetNetLimit(long)"})
  public void testSetPublicFreeAssetNetLimit5() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -72, 1, 1, -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetLimit(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicFreeAssetNetLimit(long)"})
  public void testSetPublicFreeAssetNetLimit6() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    // Act
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-72, 1, 1}, assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getPublicFreeAssetNetUsage()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getPublicFreeAssetNetUsage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long AssetIssueCapsule.getPublicFreeAssetNetUsage()"})
  public void testGetPublicFreeAssetNetUsage_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getPublicFreeAssetNetUsage());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicFreeAssetNetUsage(long)"})
  public void testSetPublicFreeAssetNetUsage() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(34, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -64, 1, '*', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicFreeAssetNetUsage(long)"})
  public void testSetPublicFreeAssetNetUsage2() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setOrder(1L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(36, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -64, 1, '*', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicFreeAssetNetUsage(long)"})
  public void testSetPublicFreeAssetNetUsage3() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -80, 1, 1, -64, 1, '*', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicFreeAssetNetUsage(long)"})
  public void testSetPublicFreeAssetNetUsage4() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -72, 1, 1, -64, 1, '*', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicFreeAssetNetUsage(long)"})
  public void testSetPublicFreeAssetNetUsage5() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -64, 1, '*', -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicFreeAssetNetUsage(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicFreeAssetNetUsage(long)"})
  public void testSetPublicFreeAssetNetUsage6() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    // Act
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-64, 1, '*'}, assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getPublicLatestFreeNetTime()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetIssueCapsule#getPublicLatestFreeNetTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long AssetIssueCapsule.getPublicLatestFreeNetTime()"})
  public void testGetPublicLatestFreeNetTime_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act and Assert
    assertEquals(0L, assetIssueCapsule.getPublicLatestFreeNetTime());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicLatestFreeNetTime(long)"})
  public void testSetPublicLatestFreeNetTime() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(34, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicLatestFreeNetTime(long)"})
  public void testSetPublicLatestFreeNetTime2() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setOrder(1L);

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(36, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicLatestFreeNetTime(long)"})
  public void testSetPublicLatestFreeNetTime3() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -80, 1, 1, -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicLatestFreeNetTime(long)"})
  public void testSetPublicLatestFreeNetTime4() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -72, 1, 1, -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicLatestFreeNetTime(long)"})
  public void testSetPublicLatestFreeNetTime5() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -64, 1, '*', -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setPublicLatestFreeNetTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setPublicLatestFreeNetTime(long)"})
  public void testSetPublicLatestFreeNetTime6() {
    // Arrange
    AssetIssueCapsule assetIssueCapsule = new AssetIssueCapsule(new byte[] {});

    // Act
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(19, instance.getDescriptorForType().getFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {-56, 1, '\n'}, assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setUrl(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setUrl(ByteString)"})
  public void testSetUrl() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(34, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -86, 1, 0, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setUrl(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setUrl(ByteString)"})
  public void testSetUrl2() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setOrder(1L);

    // Act
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(36, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -86, 1, 0, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setUrl(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setUrl(ByteString)"})
  public void testSetUrl3() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -86, 1, 0, -80, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setUrl(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setUrl(ByteString)"})
  public void testSetUrl4() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -86, 1, 0, -72, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setUrl(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setUrl(ByteString)"})
  public void testSetUrl5() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -86, 1, 0, -64, 1, '*', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setUrl(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setUrl(ByteString)"})
  public void testSetUrl6() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -86, 1, 0, -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setUrl(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setUrl(ByteString)"})
  public void testSetUrl7() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "", "Name", "Abbr", 1L, 1);

    // Act
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(29, instance.getSerializedSize());
    assertEquals(6, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -86, 1, 0
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setUrl(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setUrl(ByteString)"})
  public void testSetUrl8() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 0L, 1);

    // Act
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(6, instance.getAllFields().size());
    assertEquals(Integer.SIZE, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', '8', 1, -86, 1, 0, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setUrl(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setUrl(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setUrl(ByteString)"})
  public void testSetUrl9() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 0);

    // Act
    assetIssueCapsule.setUrl(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(6, instance.getAllFields().size());
    assertEquals(Integer.SIZE, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, -86, 1, 0, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getUrl()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#getUrl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString AssetIssueCapsule.getUrl()"})
  public void testGetUrl() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    ByteString actualUrl = assetIssueCapsule.getUrl();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    AssetIssueContract defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getIdBytes());
    assertSame(byteString, assetIssueCapsule.getDesc());
    assertSame(byteString, actualUrl);
    assertSame(byteString, defaultInstanceForType.getAbbr());
    assertSame(byteString, instance.getDescription());
    assertSame(byteString, defaultInstanceForType.getDescription());
    assertSame(byteString, defaultInstanceForType.getName());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, instance.getUrl());
    assertSame(byteString, defaultInstanceForType.getUrl());
  }

  /**
   * Test {@link AssetIssueCapsule#setDescription(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setDescription(ByteString)"})
  public void testSetDescription() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(34, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -94, 1, 0, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setDescription(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setDescription(ByteString)"})
  public void testSetDescription2() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setOrder(1L);

    // Act
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(36, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, 'X', 1, -94, 1, 0, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setDescription(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setDescription(ByteString)"})
  public void testSetDescription3() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -94, 1, 0, -80, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setDescription(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setDescription(ByteString)"})
  public void testSetDescription4() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetLimit(1L);

    // Act
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -94, 1, 0, -72, 1, 1, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setDescription(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setDescription(ByteString)"})
  public void testSetDescription5() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicFreeAssetNetUsage(42L);

    // Act
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -94, 1, 0, -64, 1, '*', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setDescription(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setDescription(ByteString)"})
  public void testSetDescription6() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);
    assetIssueCapsule.setPublicLatestFreeNetTime(10L);

    // Act
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Assert
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    assertEquals(37, instance.getSerializedSize());
    assertEquals(8, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -94, 1, 0, -56, 1, '\n', -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setDescription(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setDescription(ByteString)"})
  public void testSetDescription7() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "", "Name", "Abbr", 1L, 1);

    // Act
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Assert
    assertEquals(29, assetIssueCapsule.getInstance().getSerializedSize());
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, '8', 1, -94, 1, 0
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setDescription(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setDescription(ByteString)"})
  public void testSetDescription8() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 0L, 1);

    // Act
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Assert
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', '8', 1, -94, 1, 0, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#setDescription(ByteString)}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#setDescription(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetIssueCapsule.setDescription(ByteString)"})
  public void testSetDescription9() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 0);

    // Act
    assetIssueCapsule.setDescription(mock(ByteString.class));

    // Assert
    assertArrayEquals(
        new byte[] {
          '\n', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 18, 4, 'N', 'a', 'm', 'e', 26, 4, 'A',
          'b', 'b', 'r', ' ', 1, -94, 1, 0, -54, 2, 2, '4', '2'
        },
        assetIssueCapsule.getData());
  }

  /**
   * Test {@link AssetIssueCapsule#getDesc()}.
   *
   * <p>Method under test: {@link AssetIssueCapsule#getDesc()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString AssetIssueCapsule.getDesc()"})
  public void testGetDesc() throws UnsupportedEncodingException {
    // Arrange
    AssetIssueCapsule assetIssueCapsule =
        new AssetIssueCapsule("AXAXAXAX".getBytes("UTF-8"), "42", "Name", "Abbr", 1L, 1);

    // Act
    ByteString actualDesc = assetIssueCapsule.getDesc();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    AssetIssueContract instance = assetIssueCapsule.getInstance();
    AssetIssueContract defaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getIdBytes());
    assertSame(byteString, actualDesc);
    assertSame(byteString, assetIssueCapsule.getUrl());
    assertSame(byteString, defaultInstanceForType.getAbbr());
    assertSame(byteString, instance.getDescription());
    assertSame(byteString, defaultInstanceForType.getDescription());
    assertSame(byteString, defaultInstanceForType.getName());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, instance.getUrl());
    assertSame(byteString, defaultInstanceForType.getUrl());
  }
}
