package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.MarketPrice;

public class MarketPriceCapsuleDiffblueTest {
  /**
   * Test {@link MarketPriceCapsule#MarketPriceCapsule()}.
   *
   * <p>Method under test: {@link MarketPriceCapsule#MarketPriceCapsule()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.<init>()"})
  public void testNewMarketPriceCapsule() {
    // Arrange and Act
    MarketPriceCapsule actualMarketPriceCapsule = new MarketPriceCapsule();

    // Assert
    MarketPrice instance = actualMarketPriceCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0L, actualMarketPriceCapsule.getBuyTokenQuantity());
    assertEquals(0L, actualMarketPriceCapsule.getSellTokenQuantity());
    assertEquals(0L, instance.getBuyTokenQuantity());
    assertEquals(0L, instance.getSellTokenQuantity());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(actualMarketPriceCapsule.isNull());
    assertTrue(instance.isInitialized());
    MarketPrice actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertArrayEquals(new byte[] {}, actualMarketPriceCapsule.getData());
  }

  /**
   * Test {@link MarketPriceCapsule#MarketPriceCapsule(long, long)}.
   *
   * <p>Method under test: {@link MarketPriceCapsule#MarketPriceCapsule(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.<init>(long, long)"})
  public void testNewMarketPriceCapsule2() {
    // Arrange and Act
    MarketPriceCapsule actualMarketPriceCapsule = new MarketPriceCapsule(1L, 1L);

    // Assert
    MarketPrice instance = actualMarketPriceCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(1L, actualMarketPriceCapsule.getBuyTokenQuantity());
    assertEquals(1L, actualMarketPriceCapsule.getSellTokenQuantity());
    assertEquals(1L, instance.getBuyTokenQuantity());
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertFalse(actualMarketPriceCapsule.isNull());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.isInitialized());
    assertArrayEquals(new byte[] {'\b', 1, 16, 1}, actualMarketPriceCapsule.getData());
  }

  /**
   * Test {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}.
   *
   * <p>Method under test: {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.<init>(byte[])"})
  public void testNewMarketPriceCapsule3() {
    // Arrange and Act
    MarketPriceCapsule actualMarketPriceCapsule = new MarketPriceCapsule(new byte[] {});

    // Assert
    MarketPrice instance = actualMarketPriceCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0L, actualMarketPriceCapsule.getBuyTokenQuantity());
    assertEquals(0L, actualMarketPriceCapsule.getSellTokenQuantity());
    assertEquals(0L, instance.getBuyTokenQuantity());
    assertEquals(0L, instance.getSellTokenQuantity());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(actualMarketPriceCapsule.isNull());
    assertTrue(instance.isInitialized());
    MarketPrice actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertArrayEquals(new byte[] {}, actualMarketPriceCapsule.getData());
  }

  /**
   * Test {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}.
   *
   * <p>Method under test: {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.<init>(byte[])"})
  public void testNewMarketPriceCapsule4() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketPriceCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.<init>(byte[])"})
  public void testNewMarketPriceCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    MarketPriceCapsule actualMarketPriceCapsule =
        new MarketPriceCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketPriceCapsule.getInstance());
  }

  /**
   * Test {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.<init>(byte[])"})
  public void testNewMarketPriceCapsule_whenArrayOfByteWithSixteenAndX() {
    // Arrange and Act
    MarketPriceCapsule actualMarketPriceCapsule =
        new MarketPriceCapsule(new byte[] {16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketPriceCapsule.getInstance());
  }

  /**
   * Test {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.<init>(byte[])"})
  public void testNewMarketPriceCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    MarketPriceCapsule actualMarketPriceCapsule =
        new MarketPriceCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketPriceCapsule.getInstance());
  }

  /**
   * Test {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.<init>(byte[])"})
  public void testNewMarketPriceCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketPriceCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.<init>(byte[])"})
  public void testNewMarketPriceCapsule_whenBackspace_thenReturnInstanceIsNull() {
    // Arrange and Act
    MarketPriceCapsule actualMarketPriceCapsule =
        new MarketPriceCapsule(
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', 16
            });

    // Assert
    assertNull(actualMarketPriceCapsule.getInstance());
  }

  /**
   * Test {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.<init>(byte[])"})
  public void testNewMarketPriceCapsule_whenBackspace_thenReturnInstanceIsNull2() {
    // Arrange and Act
    MarketPriceCapsule actualMarketPriceCapsule =
        new MarketPriceCapsule(
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', -1
            });

    // Assert
    assertNull(actualMarketPriceCapsule.getInstance());
  }

  /**
   * Test {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#MarketPriceCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.<init>(byte[])"})
  public void testNewMarketPriceCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketPriceCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketPriceCapsule#getSellTokenQuantity()}.
   *
   * <p>Method under test: {@link MarketPriceCapsule#getSellTokenQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long MarketPriceCapsule.getSellTokenQuantity()"})
  public void testGetSellTokenQuantity() {
    // Arrange, Act and Assert
    assertEquals(0L, new MarketPriceCapsule().getSellTokenQuantity());
  }

  /**
   * Test {@link MarketPriceCapsule#setSellTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketPriceCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity() {
    // Arrange
    MarketPriceCapsule marketPriceCapsule = new MarketPriceCapsule(1L, 1L);

    // Act
    marketPriceCapsule.setSellTokenQuantity(1L);

    // Assert that nothing has changed
    assertEquals(1L, marketPriceCapsule.getSellTokenQuantity());
    MarketPrice instance = marketPriceCapsule.getInstance();
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals(2, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertFalse(marketPriceCapsule.isNull());
    assertArrayEquals(new byte[] {'\b', 1, 16, 1}, marketPriceCapsule.getData());
  }

  /**
   * Test {@link MarketPriceCapsule#setSellTokenQuantity(long)}.
   *
   * <ul>
   *   <li>Then {@link MarketPriceCapsule#MarketPriceCapsule()} Instance AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity_thenMarketPriceCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    MarketPriceCapsule marketPriceCapsule = new MarketPriceCapsule();

    // Act
    marketPriceCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketPrice instance = marketPriceCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, marketPriceCapsule.getSellTokenQuantity());
    assertEquals(1L, instance.getSellTokenQuantity());
    assertEquals(2, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(marketPriceCapsule.isNull());
    assertArrayEquals(new byte[] {'\b', 1}, marketPriceCapsule.getData());
  }

  /**
   * Test {@link MarketPriceCapsule#getBuyTokenQuantity()}.
   *
   * <p>Method under test: {@link MarketPriceCapsule#getBuyTokenQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long MarketPriceCapsule.getBuyTokenQuantity()"})
  public void testGetBuyTokenQuantity() {
    // Arrange, Act and Assert
    assertEquals(0L, new MarketPriceCapsule().getBuyTokenQuantity());
  }

  /**
   * Test {@link MarketPriceCapsule#setBuyTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketPriceCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity() {
    // Arrange
    MarketPriceCapsule marketPriceCapsule = new MarketPriceCapsule(2L, 2L);

    // Act
    marketPriceCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketPrice instance = marketPriceCapsule.getInstance();
    assertEquals(2, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertFalse(marketPriceCapsule.isNull());
    assertArrayEquals(new byte[] {'\b', 2, 16, '*'}, marketPriceCapsule.getData());
  }

  /**
   * Test {@link MarketPriceCapsule#setBuyTokenQuantity(long)}.
   *
   * <ul>
   *   <li>Then {@link MarketPriceCapsule#MarketPriceCapsule()} Instance AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketPriceCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity_thenMarketPriceCapsuleInstanceAllFieldsSizeIsOne() {
    // Arrange
    MarketPriceCapsule marketPriceCapsule = new MarketPriceCapsule();

    // Act
    marketPriceCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketPrice instance = marketPriceCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getDescriptorForType().getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(marketPriceCapsule.isNull());
    assertArrayEquals(new byte[] {16, '*'}, marketPriceCapsule.getData());
  }

  /**
   * Test {@link MarketPriceCapsule#getKey(byte[], byte[])}.
   *
   * <ul>
   *   <li>Given {@link MarketPriceCapsule#MarketPriceCapsule()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#getKey(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketPriceCapsule.getKey(byte[], byte[])"})
  public void testGetKey_givenMarketPriceCapsule_thenReturnEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {},
        new MarketPriceCapsule()
            .getKey("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketPriceCapsule#getKey(byte[], byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#getKey(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketPriceCapsule.getKey(byte[], byte[])"})
  public void testGetKey_thenReturnArrayOfByteWithAAndX() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
          0, 0, 0, 0, 1
        },
        new MarketPriceCapsule(1L, 1L)
            .getKey("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketPriceCapsule#isNull()}.
   *
   * <ul>
   *   <li>Given {@link MarketPriceCapsule#MarketPriceCapsule()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#isNull()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketPriceCapsule.isNull()"})
  public void testIsNull_givenMarketPriceCapsule_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new MarketPriceCapsule().isNull());
  }

  /**
   * Test {@link MarketPriceCapsule#isNull()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#isNull()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketPriceCapsule.isNull()"})
  public void testIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new MarketPriceCapsule(1L, 1L).isNull());
  }

  /**
   * Test {@link MarketPriceCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link MarketPriceCapsule#MarketPriceCapsule()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketPriceCapsule.getData()"})
  public void testGetData_givenMarketPriceCapsule_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new MarketPriceCapsule().getData());
  }

  /**
   * Test {@link MarketPriceCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and minus one.
   * </ul>
   *
   * <p>Method under test: {@link MarketPriceCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketPriceCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithBackspaceAndMinusOne() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          '\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1
        },
        new MarketPriceCapsule(-1L, -1L).getData());
  }

  /**
   * Test {@link MarketPriceCapsule#getInstance()}.
   *
   * <p>Method under test: {@link MarketPriceCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MarketPrice MarketPriceCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    MarketPrice actualInstance = new MarketPriceCapsule().getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getSerializedSize());
    assertEquals(0L, actualInstance.getBuyTokenQuantity());
    assertEquals(0L, actualInstance.getSellTokenQuantity());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.getAllFields().isEmpty());
    assertTrue(actualInstance.isInitialized());
    MarketPrice actualDefaultInstanceForType = actualInstance.getDefaultInstanceForType();
    assertEquals(actualInstance, actualDefaultInstanceForType);
  }
}
