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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.store.AssetIssueStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Exchange;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ExchangeCapsuleDiffblueTest {
  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ExchangeCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ExchangeCapsule("2\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ExchangeCapsule("B\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule4() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ExchangeCapsule("A\bA\bA\bA\bA\bA\bA\bA8".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule5() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ExchangeCapsule("A\bA\bA\bA\bA\bA\bA\bAH".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(ByteString, long, long, byte[], byte[])}.
   *
   * <ul>
   *   <li>Then return Instance AllFields size is four.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(ByteString, long, long, byte[],
   * byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(ByteString, long, long, byte[], byte[])"})
  public void testNewExchangeCapsule_thenReturnInstanceAllFieldsSizeIsFour()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule =
        new ExchangeCapsule(
            mock(ByteString.class), 1L, 1L, new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Exchange instance = actualExchangeCapsule.getInstance();
    assertEquals(4, instance.getAllFields().size());
    assertEquals(ByteString.EMPTY, instance.getFirstTokenId());
    assertEquals(Short.SIZE, instance.getSerializedSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualExchangeCapsule.getSecondTokenId());
    assertArrayEquals(new byte[] {}, actualExchangeCapsule.getFirstTokenId());
    assertArrayEquals(
        new byte[] {'\b', 1, 18, 0, 24, 1, 'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        actualExchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(ByteString, long, long, byte[], byte[])}.
   *
   * <ul>
   *   <li>Then return Instance SerializedSize is twenty-six.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(ByteString, long, long, byte[],
   * byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(ByteString, long, long, byte[], byte[])"})
  public void testNewExchangeCapsule_thenReturnInstanceSerializedSizeIsTwentySix()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule =
        new ExchangeCapsule(
            mock(ByteString.class),
            1L,
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Exchange instance = actualExchangeCapsule.getInstance();
    assertEquals(26, instance.getSerializedSize());
    assertEquals(5, instance.getAllFields().size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualExchangeCapsule.getFirstTokenId());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualExchangeCapsule.getSecondTokenId());
    assertArrayEquals(
        new byte[] {
          '\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'B', '\b', 'A',
          'X', 'A', 'X', 'A', 'X', 'A', 'X'
        },
        actualExchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_when2xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ExchangeCapsule("2XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 8XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_when8xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ExchangeCapsule("8XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWith2AndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule =
        new ExchangeCapsule(new byte[] {'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualExchangeCapsule.getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and backspace.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithAAndBackspace_thenReturnInstanceIsNull() {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule =
        new ExchangeCapsule(
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', 24
            });

    // Assert
    assertNull(actualExchangeCapsule.getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and backspace.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithAAndBackspace_thenReturnInstanceIsNull2() {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule =
        new ExchangeCapsule(
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', -1
            });

    // Assert
    assertNull(actualExchangeCapsule.getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code B} and zero.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithBAndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule =
        new ExchangeCapsule(new byte[] {'B', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualExchangeCapsule.getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and backspace.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithEighteenAndBackspace() {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule =
        new ExchangeCapsule(
            new byte[] {
              18, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b'
            });

    // Assert
    assertNull(actualExchangeCapsule.getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithEighteenAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule =
        new ExchangeCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualExchangeCapsule.getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule =
        new ExchangeCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualExchangeCapsule.getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule =
        new ExchangeCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualExchangeCapsule.getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithTwentyFourAndX() {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule =
        new ExchangeCapsule(new byte[] {24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualExchangeCapsule.getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule =
        new ExchangeCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualExchangeCapsule.getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ExchangeCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code BXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenBxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ExchangeCapsule("BXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return CreateTime is zero.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenEmptyArrayOfByte_thenReturnCreateTimeIsZero() {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Assert
    assertEquals(0L, actualExchangeCapsule.getCreateTime());
    assertEquals(0L, actualExchangeCapsule.getFirstTokenBalance());
    assertEquals(0L, actualExchangeCapsule.getID());
    assertEquals(0L, actualExchangeCapsule.getSecondTokenBalance());
    byte[] firstTokenId = actualExchangeCapsule.getFirstTokenId();
    assertSame(firstTokenId, actualExchangeCapsule.getSecondTokenId());
    assertArrayEquals(new byte[] {}, actualExchangeCapsule.getData());
    assertArrayEquals(new byte[] {}, firstTokenId);
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code HXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenHxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ExchangeCapsule("HXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ExchangeCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#calculateDbKey(long)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#calculateDbKey(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.calculateDbKey(long)"})
  public void testCalculateDbKey() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 1}, ExchangeCapsule.calculateDbKey(1L));
  }

  /**
   * Test {@link ExchangeCapsule#getID()}.
   *
   * <ul>
   *   <li>Given {@link ExchangeCapsule#ExchangeCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getID()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.getID()"})
  public void testGetID_givenExchangeCapsuleWithDataIsEmptyArrayOfByte_thenReturnZero() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, exchangeCapsule.getID());
  }

  /**
   * Test {@link ExchangeCapsule#setID(long)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#setID(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.setID(long)"})
  public void testSetID() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act
    exchangeCapsule.setID(1L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {'\b', 1}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setID(long)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#setID(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.setID(long)"})
  public void testSetID2() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    exchangeCapsule.setID(1L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {'\b', 1, '8', '*', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setID(long)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#setID(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.setID(long)"})
  public void testSetID3() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setCreateTime(10L);

    // Act
    exchangeCapsule.setID(1L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {'\b', 1, 24, '\n'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setID(long)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#setID(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.setID(long)"})
  public void testSetID4() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setFirstTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.setID(1L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[] {'\b', 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setID(long)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#setID(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.setID(long)"})
  public void testSetID5() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setSecondTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.setID(1L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[] {'\b', 1, 'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getCreatorAddress()}.
   *
   * <ul>
   *   <li>Then return {@link ByteString#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getCreatorAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString ExchangeCapsule.getCreatorAddress()"})
  public void testGetCreatorAddress_thenReturnEmpty() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act and Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, exchangeCapsule.getCreatorAddress());
    Exchange instance = exchangeCapsule.getInstance();
    assertSame(byteString, instance.getCreatorAddress());
    Exchange defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getCreatorAddress());
    assertSame(byteString, instance.getFirstTokenId());
    assertSame(byteString, defaultInstanceForType.getFirstTokenId());
    assertSame(byteString, instance.getSecondTokenId());
    assertSame(byteString, defaultInstanceForType.getSecondTokenId());
  }

  /**
   * Test {@link ExchangeCapsule#getCreateTime()}.
   *
   * <ul>
   *   <li>Given {@link ExchangeCapsule#ExchangeCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getCreateTime()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.getCreateTime()"})
  public void testGetCreateTime_givenExchangeCapsuleWithDataIsEmptyArrayOfByte_thenReturnZero() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, exchangeCapsule.getCreateTime());
  }

  /**
   * Test {@link ExchangeCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.setCreateTime(long)"})
  public void testSetCreateTime() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {24, '\n'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.setCreateTime(long)"})
  public void testSetCreateTime2() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setID(1L);

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {'\b', 1, 24, '\n'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.setCreateTime(long)"})
  public void testSetCreateTime3() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {24, '\n', '8', '*', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.setCreateTime(long)"})
  public void testSetCreateTime4() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setFirstTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[] {24, '\n', '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExchangeCapsule.setCreateTime(long)"})
  public void testSetCreateTime5() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setSecondTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[] {24, '\n', 'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getFirstTokenId()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getFirstTokenId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.getFirstTokenId()"})
  public void testGetFirstTokenId_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setFirstTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), exchangeCapsule.getFirstTokenId());
  }

  /**
   * Test {@link ExchangeCapsule#getFirstTokenId()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getFirstTokenId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.getFirstTokenId()"})
  public void testGetFirstTokenId_thenReturnEmptyArrayOfByte() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, exchangeCapsule.getFirstTokenId());
  }

  /**
   * Test {@link ExchangeCapsule#getSecondTokenId()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getSecondTokenId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.getSecondTokenId()"})
  public void testGetSecondTokenId_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setSecondTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), exchangeCapsule.getSecondTokenId());
  }

  /**
   * Test {@link ExchangeCapsule#getSecondTokenId()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getSecondTokenId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.getSecondTokenId()"})
  public void testGetSecondTokenId_thenReturnEmptyArrayOfByte() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, exchangeCapsule.getSecondTokenId());
  }

  /**
   * Test {@link ExchangeCapsule#getFirstTokenBalance()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getFirstTokenBalance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.getFirstTokenBalance()"})
  public void testGetFirstTokenBalance_thenReturnZero() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, exchangeCapsule.getFirstTokenBalance());
  }

  /**
   * Test {@link ExchangeCapsule#getSecondTokenBalance()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getSecondTokenBalance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.getSecondTokenBalance()"})
  public void testGetSecondTokenBalance_thenReturnZero() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, exchangeCapsule.getSecondTokenBalance());
  }

  /**
   * Test {@link ExchangeCapsule#createDbKey()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#createDbKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnArrayOfByteWithZeroAndZero() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 0}, exchangeCapsule.createDbKey());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {'H', 1}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction2() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act
    exchangeCapsule.transaction(new byte[] {}, 1L, true);

    // Assert
    assertEquals(0L, exchangeCapsule.getSecondTokenBalance());
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(0L, instance.getSecondTokenBalance());
    assertEquals(1L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(1L, instance.getFirstTokenBalance());
    assertArrayEquals(new byte[] {'8', 1}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction3() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setID(1L);

    // Act
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    assertEquals(1L, exchangeCapsule.getSecondTokenBalance());
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1L, instance.getSecondTokenBalance());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, 'H', 1}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction4() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(43L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(43L, instance.getSecondTokenBalance());
    assertArrayEquals("8*H+".getBytes("UTF-8"), exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction5() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setCreateTime(10L);

    // Act
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    assertEquals(1L, exchangeCapsule.getSecondTokenBalance());
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1L, instance.getSecondTokenBalance());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {24, '\n', 'H', 1}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction6() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setFirstTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    assertEquals(0L, exchangeCapsule.getSecondTokenBalance());
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(0L, instance.getSecondTokenBalance());
    assertEquals(1L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(1L, instance.getFirstTokenBalance());
    assertArrayEquals(
        new byte[] {'2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '8', 1},
        exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   *
   * <p>Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction7() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setSecondTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(1L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(1L, instance.getSecondTokenBalance());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', 1},
        exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction_givenA() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setFirstTokenId(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(1L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(1L, instance.getSecondTokenBalance());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {'2', '\b', 1, 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', 1},
        exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction_whenFalse() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, false);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[] {'H', 1}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#resetTokenWithID(AssetIssueStore, DynamicPropertiesStore)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link DynamicPropertiesStore#getAllowSameTokenName()}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#resetTokenWithID(AssetIssueStore,
   * DynamicPropertiesStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExchangeCapsule.resetTokenWithID(AssetIssueStore, DynamicPropertiesStore)"
  })
  public void testResetTokenWithID_givenOne_thenCallsGetAllowSameTokenName()
      throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule("AXAXAXAX".getBytes("UTF-8"));

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowSameTokenName()).thenReturn(1L);

    // Act
    exchangeCapsule.resetTokenWithID(null, dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowSameTokenName();
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return 2 backspace AXAXAXAX Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData_thenReturn2BackspaceAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setFirstTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("2\bAXAXAXAX".getBytes("UTF-8"), exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return {@code 8*H*} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData_thenReturn8HBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setBalance(42L, 42L);

    // Act and Assert
    assertArrayEquals("8*H*".getBytes("UTF-8"), exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithBackspaceAndMin_value() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setID(1000000000000000000L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\b', Byte.MIN_VALUE, Byte.MIN_VALUE, -112, -69, -70, -42, -83, -16, '\r'},
        exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and one.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithBackspaceAndOne() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setID(1L);

    // Act and Assert
    assertArrayEquals(new byte[] {'\b', 1}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code H} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithHAndMinusOne()
      throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), -1L, true);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'H', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and lf.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndLf() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setCreateTime(10L);

    // Act and Assert
    assertArrayEquals(new byte[] {24, '\n'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return B backspace AXAXAXAX Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData_thenReturnBBackspaceAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});
    exchangeCapsule.setSecondTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("B\bAXAXAXAX".getBytes("UTF-8"), exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getInstance()}.
   *
   * <ul>
   *   <li>Given {@link ExchangeCapsule#ExchangeCapsule(byte[])} with data is {@code AXAXAXAX} Bytes
   *       is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExchangeCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Exchange ExchangeCapsule.getInstance()"})
  public void testGetInstance_givenExchangeCapsuleWithDataIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ExchangeCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }
}
