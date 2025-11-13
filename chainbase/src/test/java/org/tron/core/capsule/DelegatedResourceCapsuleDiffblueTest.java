package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.DelegatedResource;

public class DelegatedResourceCapsuleDiffblueTest {
  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(ByteString, ByteString)}.
   *
   * <ul>
   *   <li>Then return ExpireTimeForBandwidth is zero.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(ByteString,
   * ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(ByteString, ByteString)"})
  public void testNewDelegatedResourceCapsule_thenReturnExpireTimeForBandwidthIsZero() {
    // Arrange
    ByteString from = mock(ByteString.class);
    ByteString resultTo = mock(ByteString.class);

    // Act
    DelegatedResourceCapsule actualDelegatedResourceCapsule =
        new DelegatedResourceCapsule(from, resultTo);

    // Assert
    assertEquals(0L, actualDelegatedResourceCapsule.getExpireTimeForBandwidth());
    assertEquals(0L, actualDelegatedResourceCapsule.getExpireTimeForEnergy());
    assertEquals(0L, actualDelegatedResourceCapsule.getFrozenBalanceForBandwidth());
    assertEquals(0L, actualDelegatedResourceCapsule.getFrozenBalanceForEnergy());
    assertSame(from, actualDelegatedResourceCapsule.getFrom());
    assertSame(resultTo, actualDelegatedResourceCapsule.getTo());
    assertArrayEquals(new byte[] {'\n', 0, 18, 0}, actualDelegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>Then return ExpireTimeForBandwidth is zero.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_thenReturnExpireTimeForBandwidthIsZero2() {
    // Arrange and Act
    DelegatedResourceCapsule actualDelegatedResourceCapsule =
        new DelegatedResourceCapsule(new byte[] {});

    // Assert
    assertEquals(0L, actualDelegatedResourceCapsule.getExpireTimeForBandwidth());
    assertEquals(0L, actualDelegatedResourceCapsule.getExpireTimeForEnergy());
    assertEquals(0L, actualDelegatedResourceCapsule.getFrozenBalanceForBandwidth());
    assertEquals(0L, actualDelegatedResourceCapsule.getFrozenBalanceForEnergy());
    assertArrayEquals(new byte[] {}, actualDelegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_when0xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new DelegatedResourceCapsule("0XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenAAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new DelegatedResourceCapsule("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new DelegatedResourceCapsule("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and lf.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithAAndLf() {
    // Arrange and Act
    DelegatedResourceCapsule actualDelegatedResourceCapsule =
        new DelegatedResourceCapsule(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 0, '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualDelegatedResourceCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and lf.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithEighteenAndLf() {
    // Arrange and Act
    DelegatedResourceCapsule actualDelegatedResourceCapsule =
        new DelegatedResourceCapsule(
            new byte[] {
              18, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualDelegatedResourceCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange and Act
    DelegatedResourceCapsule actualDelegatedResourceCapsule =
        new DelegatedResourceCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualDelegatedResourceCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    DelegatedResourceCapsule actualDelegatedResourceCapsule =
        new DelegatedResourceCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualDelegatedResourceCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    DelegatedResourceCapsule actualDelegatedResourceCapsule =
        new DelegatedResourceCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualDelegatedResourceCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithTwentyFourAndX() {
    // Arrange and Act
    DelegatedResourceCapsule actualDelegatedResourceCapsule =
        new DelegatedResourceCapsule(new byte[] {24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualDelegatedResourceCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithZeroAndX() {
    // Arrange and Act
    DelegatedResourceCapsule actualDelegatedResourceCapsule =
        new DelegatedResourceCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualDelegatedResourceCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new DelegatedResourceCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new DelegatedResourceCapsule(" XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code (XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new DelegatedResourceCapsule("(XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new DelegatedResourceCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#createDbKey(byte[], byte[])} with {@code byte[]}, {@code
   * byte[]}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#createDbKey(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.createDbKey(byte[], byte[])"})
  public void testCreateDbKeyWithByteByte() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCreateDbKeyResult =
        DelegatedResourceCapsule.createDbKey(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAXAXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Test {@link DelegatedResourceCapsule#createDbKey()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#createDbKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnEmptyArrayOfByte() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, delegatedResourceCapsule.createDbKey());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getData()}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.getData()"})
  public void testGetData() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForEnergy(-1L, -1L);
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, 0L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          24, 3, ' ', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '0', -1, -1, -1, -1, -1, -1, -1, -1,
          -1, 1
        },
        delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with space and minus one.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithSpaceAndMinusOne() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForEnergy(Long.MAX_VALUE, 0L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {' ', -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE},
        delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and one.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndOne() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, -1L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {24, 1, '(', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1},
        delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and three.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndThree() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, 0L);

    // Act and Assert
    assertArrayEquals(new byte[] {24, 3}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getInstance()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DelegatedResource DelegatedResourceCapsule.getInstance()"})
  public void testGetInstance_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new DelegatedResourceCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#createDbKeyV2(byte[], byte[], boolean)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return array of {@code byte} with one and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#createDbKeyV2(byte[], byte[], boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.createDbKeyV2(byte[], byte[], boolean)"})
  public void testCreateDbKeyV2_whenA_thenReturnArrayOfByteWithOneAndA() {
    // Arrange and Act
    byte[] actualCreateDbKeyV2Result =
        DelegatedResourceCapsule.createDbKeyV2(
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            false);

    // Assert
    assertArrayEquals(
        new byte[] {
          1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'
        },
        actualCreateDbKeyV2Result);
  }

  /**
   * Test {@link DelegatedResourceCapsule#createDbKeyV2(byte[], byte[], boolean)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return array of {@code byte} with two and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#createDbKeyV2(byte[], byte[], boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.createDbKeyV2(byte[], byte[], boolean)"})
  public void testCreateDbKeyV2_whenAxaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithTwoAndA()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCreateDbKeyV2Result =
        DelegatedResourceCapsule.createDbKeyV2(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), true);

    // Assert
    assertArrayEquals(
        new byte[] {
          2, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'
        },
        actualCreateDbKeyV2Result);
  }

  /**
   * Test {@link DelegatedResourceCapsule#getFrom()}.
   *
   * <ul>
   *   <li>Then return {@link ByteString#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getFrom()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString DelegatedResourceCapsule.getFrom()"})
  public void testGetFrom_thenReturnEmpty() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act and Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, delegatedResourceCapsule.getFrom());
    assertSame(byteString, delegatedResourceCapsule.getTo());
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertSame(byteString, instance.getFrom());
    DelegatedResource defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getFrom());
    assertSame(byteString, instance.getTo());
    assertSame(byteString, defaultInstanceForType.getTo());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getTo()}.
   *
   * <ul>
   *   <li>Then {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])} with data is empty
   *       array of {@code byte} From is {@link ByteString#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getTo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString DelegatedResourceCapsule.getTo()"})
  public void testGetTo_thenDelegatedResourceCapsuleWithDataIsEmptyArrayOfByteFromIsEmpty() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act
    ByteString actualTo = delegatedResourceCapsule.getTo();

    // Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, delegatedResourceCapsule.getFrom());
    assertSame(byteString, actualTo);
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertSame(byteString, instance.getFrom());
    DelegatedResource defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getFrom());
    assertSame(byteString, instance.getTo());
    assertSame(byteString, defaultInstanceForType.getTo());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getFrozenBalanceForEnergy()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getFrozenBalanceForEnergy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DelegatedResourceCapsule.getFrozenBalanceForEnergy()"})
  public void testGetFrozenBalanceForEnergy_thenReturnZero() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForEnergy(long, long)"})
  public void testSetFrozenBalanceForEnergy() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act
    delegatedResourceCapsule.setFrozenBalanceForEnergy(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForEnergy(long, long)"})
  public void testSetFrozenBalanceForEnergy2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForEnergy(-1L, -1L);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForEnergy(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForEnergy(long, long)"})
  public void testSetFrozenBalanceForEnergy3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, -1L);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForEnergy(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(17, instance.getSerializedSize());
    assertEquals(4, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[] {24, 3, ' ', 1, '(', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '0', 1},
        delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForEnergy(long, long)"})
  public void testAddFrozenBalanceForEnergy() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForEnergy(long, long)"})
  public void testAddFrozenBalanceForEnergy2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForEnergy(-1L, -1L);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Assert
    assertEquals(0L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(0L, instance.getFrozenBalanceForEnergy());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForEnergy(long, long)"})
  public void testAddFrozenBalanceForEnergy3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, -1L);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(17, instance.getSerializedSize());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    assertEquals(1L, instance.getFrozenBalanceForEnergy());
    assertEquals(4, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {24, 3, ' ', 1, '(', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '0', 1},
        delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getFrozenBalanceForBandwidth()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getFrozenBalanceForBandwidth()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DelegatedResourceCapsule.getFrozenBalanceForBandwidth()"})
  public void testGetFrozenBalanceForBandwidth_thenReturnZero() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getFrozenBalance(boolean)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getFrozenBalance(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DelegatedResourceCapsule.getFrozenBalance(boolean)"})
  public void testGetFrozenBalance_thenReturnZero() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, delegatedResourceCapsule.getFrozenBalance(true));
  }

  /**
   * Test {@link DelegatedResourceCapsule#getFrozenBalance(boolean)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getFrozenBalance(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DelegatedResourceCapsule.getFrozenBalance(boolean)"})
  public void testGetFrozenBalance_thenReturnZero2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, delegatedResourceCapsule.getFrozenBalance(false));
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForBandwidth(long, long)"})
  public void testSetFrozenBalanceForBandwidth() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {24, 1, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForBandwidth(long, long)"})
  public void testSetFrozenBalanceForBandwidth2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForEnergy(-1L, -1L);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(26, instance.getSerializedSize());
    assertEquals(4, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[] {
          24, 1, ' ', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '(', 1, '0', -1, -1, -1, -1, -1, -1,
          -1, -1, -1, 1
        },
        delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForBandwidth(long, long)"})
  public void testSetFrozenBalanceForBandwidth3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, -1L);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {24, 1, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForBandwidth(long, long)"})
  public void testAddFrozenBalanceForBandwidth() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {24, 1, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForBandwidth(long, long)"})
  public void testAddFrozenBalanceForBandwidth2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForEnergy(-1L, -1L);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getFrozenBalanceForBandwidth());
    assertEquals(26, instance.getSerializedSize());
    assertEquals(4, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {
          24, 1, ' ', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '(', 1, '0', -1, -1, -1, -1, -1, -1,
          -1, -1, -1, 1
        },
        delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForBandwidth(long, long)"})
  public void testAddFrozenBalanceForBandwidth3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, -1L);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    assertEquals(4L, instance.getFrozenBalanceForBandwidth());
    assertArrayEquals(new byte[] {24, 4, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getExpireTimeForBandwidth()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getExpireTimeForBandwidth()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DelegatedResourceCapsule.getExpireTimeForBandwidth()"})
  public void testGetExpireTimeForBandwidth_thenReturnZero() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, delegatedResourceCapsule.getExpireTimeForBandwidth());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getExpireTimeForEnergy(DynamicPropertiesStore)} with
   * {@code DynamicPropertiesStore}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceCapsule#getExpireTimeForEnergy(DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DelegatedResourceCapsule.getExpireTimeForEnergy(DynamicPropertiesStore)"
  })
  public void testGetExpireTimeForEnergyWithDynamicPropertiesStore_thenReturnZero() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(0L);

    // Act
    long actualExpireTimeForEnergy =
        delegatedResourceCapsule.getExpireTimeForEnergy(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowMultiSign();
    assertEquals(0L, actualExpireTimeForEnergy);
  }

  /**
   * Test {@link DelegatedResourceCapsule#getExpireTimeForEnergy(DynamicPropertiesStore)} with
   * {@code DynamicPropertiesStore}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceCapsule#getExpireTimeForEnergy(DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DelegatedResourceCapsule.getExpireTimeForEnergy(DynamicPropertiesStore)"
  })
  public void testGetExpireTimeForEnergyWithDynamicPropertiesStore_thenReturnZero2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);

    // Act
    long actualExpireTimeForEnergy =
        delegatedResourceCapsule.getExpireTimeForEnergy(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowMultiSign();
    assertEquals(0L, actualExpireTimeForEnergy);
  }

  /**
   * Test {@link DelegatedResourceCapsule#getExpireTimeForEnergy()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#getExpireTimeForEnergy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DelegatedResourceCapsule.getExpireTimeForEnergy()"})
  public void testGetExpireTimeForEnergy_thenReturnZero() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, delegatedResourceCapsule.getExpireTimeForEnergy());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForEnergy(long)"})
  public void testSetExpireTimeForEnergy() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act
    delegatedResourceCapsule.setExpireTimeForEnergy(1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {'0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForEnergy(long)"})
  public void testSetExpireTimeForEnergy2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Act
    delegatedResourceCapsule.setExpireTimeForEnergy(1L);

    // Assert that nothing has changed
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForEnergy(long)"})
  public void testSetExpireTimeForEnergy3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, 1L);

    // Act
    delegatedResourceCapsule.setExpireTimeForEnergy(1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForEnergy());
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForEnergy());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {24, 3, '(', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForBandwidth(long)"})
  public void testSetExpireTimeForBandwidth() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});

    // Act
    delegatedResourceCapsule.setExpireTimeForBandwidth(1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {'(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForBandwidth(long)"})
  public void testSetExpireTimeForBandwidth2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Act
    delegatedResourceCapsule.setExpireTimeForBandwidth(1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {' ', 1, '(', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}.
   *
   * <p>Method under test: {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForBandwidth(long)"})
  public void testSetExpireTimeForBandwidth3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[] {});
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, 1L);

    // Act
    delegatedResourceCapsule.setExpireTimeForBandwidth(1L);

    // Assert that nothing has changed
    assertEquals(1L, delegatedResourceCapsule.getExpireTimeForBandwidth());
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getExpireTimeForBandwidth());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {24, 3, '(', 1}, delegatedResourceCapsule.getData());
  }
}
