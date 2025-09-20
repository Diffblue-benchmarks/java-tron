package org.tron.core.capsule.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.capsule.MarketOrderCapsule;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.MarketAccountStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.MarketOrder;
import org.tron.protos.Protocol.MarketOrder.State;
import org.tron.protos.Protocol.MarketPrice;

public class MarketUtilsDiffblueTest {
  /**
   * Test {@link MarketUtils#calculateOrderId(ByteString, byte[], byte[], long)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return array of {@code byte} with {@code q} and {@code d}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#calculateOrderId(ByteString, byte[], byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.calculateOrderId(ByteString, byte[], byte[], long)"})
  public void testCalculateOrderId_givenAxaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithQAndD()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCalculateOrderIdResult =
        MarketUtils.calculateOrderId(
            address, "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), 3L);

    // Assert
    verify(address).toByteArray();
    assertArrayEquals(
        new byte[] {
          'q',
          'd',
          '\f',
          'd',
          'v',
          'l',
          ' ',
          '_',
          '#',
          -121,
          Byte.MAX_VALUE,
          'H',
          -104,
          -33,
          -59,
          '\'',
          -22,
          25,
          'z',
          '+',
          -121,
          -11,
          -49,
          -21,
          -70,
          -14,
          '8',
          -95,
          'R',
          -88,
          'C',
          -72
        },
        actualCalculateOrderIdResult);
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenFive_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5L, MarketUtils.findGCD(5L, 5L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1L, MarketUtils.findGCD(1L, 5L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, MarketUtils.findGCD(0L, 0L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenZero_thenReturnZero2() {
    // Arrange, Act and Assert
    assertEquals(0L, MarketUtils.findGCD(0L, 5L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenZero_thenReturnZero3() {
    // Arrange, Act and Assert
    assertEquals(0L, MarketUtils.findGCD(5L, 0L));
  }

  /**
   * Test {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKey(byte[], byte[], long, long)"})
  public void testCreatePairPriceKey_whenA() {
    // Arrange and Act
    byte[] actualCreatePairPriceKeyResult =
        MarketUtils.createPairPriceKey(
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            0L,
            0L);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0
        },
        actualCreatePairPriceKeyResult);
  }

  /**
   * Test {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKey(byte[], byte[], long, long)"})
  public void testCreatePairPriceKey_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCreatePairPriceKeyResult =
        MarketUtils.createPairPriceKey(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), 1L, 1L);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
          0, 0, 0, 0, 1
        },
        actualCreatePairPriceKeyResult);
  }

  /**
   * Test {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKey(byte[], byte[], long, long)"})
  public void testCreatePairPriceKey_whenAxaxaxaxBytesIsUtf82()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCreatePairPriceKeyResult =
        MarketUtils.createPairPriceKey(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), 1L, 0L);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
          0, 0, 0, 0, 0
        },
        actualCreatePairPriceKeyResult);
  }

  /**
   * Test {@link MarketUtils#createPairPriceKeyNoGCD(byte[], byte[], long, long)}.
   *
   * <p>Method under test: {@link MarketUtils#createPairPriceKeyNoGCD(byte[], byte[], long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKeyNoGCD(byte[], byte[], long, long)"})
  public void testCreatePairPriceKeyNoGCD() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCreatePairPriceKeyNoGCDResult =
        MarketUtils.createPairPriceKeyNoGCD(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"), 1L, 1L);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
          0, 0, 0, 0, 1
        },
        actualCreatePairPriceKeyNoGCDResult);
  }

  /**
   * Test {@link MarketUtils#getPairPriceHeadKey(byte[], byte[])}.
   *
   * <p>Method under test: {@link MarketUtils#getPairPriceHeadKey(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.getPairPriceHeadKey(byte[], byte[])"})
  public void testGetPairPriceHeadKey() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualPairPriceHeadKey =
        MarketUtils.getPairPriceHeadKey("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0
        },
        actualPairPriceHeadKey);
  }

  /**
   * Test {@link MarketUtils#expandTokenIdToPriceArray(byte[])}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#expandTokenIdToPriceArray(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.expandTokenIdToPriceArray(byte[])"})
  public void testExpandTokenIdToPriceArray_thenReturnArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        MarketUtils.expandTokenIdToPriceArray("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#trim(byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code AXAXAXA} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#trim(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.trim(byte[])"})
  public void testTrim_whenA_thenReturnAxaxaxaBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXA".getBytes("UTF-8"),
        MarketUtils.trim(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 0}));
  }

  /**
   * Test {@link MarketUtils#trim(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#trim(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.trim(byte[])"})
  public void testTrim_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), MarketUtils.trim("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#trim(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#trim(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.trim(byte[])"})
  public void testTrim_whenEmptyArrayOfByte_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, MarketUtils.trim(new byte[] {}));
  }

  /**
   * Test {@link MarketUtils#createPairKey(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#createPairKey(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairKey(byte[], byte[])"})
  public void testCreatePairKey_whenAxaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualCreatePairKeyResult =
        MarketUtils.createPairKey("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A',
          'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        },
        actualCreatePairKeyResult);
  }

  /**
   * Test {@link MarketUtils#comparePrice(MarketPrice, MarketPrice)} with {@code price1}, {@code
   * price2}.
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(MarketPrice, MarketPrice)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(MarketPrice, MarketPrice)"})
  public void testComparePriceWithPrice1Price2() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        MarketUtils.comparePrice(
            MarketPrice.getDefaultInstance(), MarketPrice.getDefaultInstance()));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)} with {@code price1SellQuantity},
   * {@code price1BuyQuantity}, {@code price2SellQuantity}, {@code price2BuyQuantity}.
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void
      testComparePriceWithPrice1SellQuantityPrice1BuyQuantityPrice2SellQuantityPrice2BuyQuantity() {
    // Arrange and Act
    int actualComparePriceResult = MarketUtils.comparePrice(5L, 5L, 5L, 5L);

    // Assert
    assertEquals(0, actualComparePriceResult);
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)} with {@code price1SellQuantity},
   * {@code price1BuyQuantity}, {@code price2SellQuantity}, {@code price2BuyQuantity}.
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void
      testComparePriceWithPrice1SellQuantityPrice1BuyQuantityPrice2SellQuantityPrice2BuyQuantity2() {
    // Arrange and Act
    int actualComparePriceResult = MarketUtils.comparePrice(1L, 5L, 5L, 5L);

    // Assert
    assertEquals(1, actualComparePriceResult);
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)} with {@code price1SellQuantity},
   * {@code price1BuyQuantity}, {@code price2SellQuantity}, {@code price2BuyQuantity}.
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void
      testComparePriceWithPrice1SellQuantityPrice1BuyQuantityPrice2SellQuantityPrice2BuyQuantity3() {
    // Arrange and Act
    int actualComparePriceResult = MarketUtils.comparePrice(0L, 5L, 5L, 5L);

    // Assert
    assertEquals(1, actualComparePriceResult);
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)} with {@code price1SellQuantity},
   * {@code price1BuyQuantity}, {@code price2SellQuantity}, {@code price2BuyQuantity}.
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void
      testComparePriceWithPrice1SellQuantityPrice1BuyQuantityPrice2SellQuantityPrice2BuyQuantity4() {
    // Arrange and Act
    int actualComparePriceResult = MarketUtils.comparePrice(-1L, 5L, 5L, 5L);

    // Assert
    assertEquals(1, actualComparePriceResult);
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)} with {@code price1SellQuantity},
   * {@code price1BuyQuantity}, {@code price2SellQuantity}, {@code price2BuyQuantity}.
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void
      testComparePriceWithPrice1SellQuantityPrice1BuyQuantityPrice2SellQuantityPrice2BuyQuantity5() {
    // Arrange and Act
    int actualComparePriceResult = MarketUtils.comparePrice(Long.MAX_VALUE, 5L, 5L, 5L);

    // Assert
    assertEquals(-1, actualComparePriceResult);
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)} with {@code price1SellQuantity},
   * {@code price1BuyQuantity}, {@code price2SellQuantity}, {@code price2BuyQuantity}.
   *
   * <p>Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void
      testComparePriceWithPrice1SellQuantityPrice1BuyQuantityPrice2SellQuantityPrice2BuyQuantity6() {
    // Arrange and Act
    int actualComparePriceResult = MarketUtils.comparePrice(5L, Long.MAX_VALUE, 5L, 5L);

    // Assert
    assertEquals(1, actualComparePriceResult);
  }

  /**
   * Test {@link MarketUtils#isLowerPrice(MarketPrice, MarketPrice)}.
   *
   * <p>Method under test: {@link MarketUtils#isLowerPrice(MarketPrice, MarketPrice)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketUtils.isLowerPrice(MarketPrice, MarketPrice)"})
  public void testIsLowerPrice() {
    // Arrange, Act and Assert
    assertFalse(
        MarketUtils.isLowerPrice(
            MarketPrice.getDefaultInstance(), MarketPrice.getDefaultInstance()));
  }

  /**
   * Test {@link MarketUtils#priceMatch(MarketPrice, MarketPrice)}.
   *
   * <p>Method under test: {@link MarketUtils#priceMatch(MarketPrice, MarketPrice)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketUtils.priceMatch(MarketPrice, MarketPrice)"})
  public void testPriceMatch() {
    // Arrange, Act and Assert
    assertTrue(
        MarketUtils.priceMatch(MarketPrice.getDefaultInstance(), MarketPrice.getDefaultInstance()));
  }

  /**
   * Test {@link MarketUtils#updateOrderState(MarketOrderCapsule, State, MarketAccountStore)}.
   *
   * <ul>
   *   <li>When {@code ACTIVE}.
   *   <li>Then calls {@link MarketOrderCapsule#setState(State)}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#updateOrderState(MarketOrderCapsule, State,
   * MarketAccountStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MarketUtils.updateOrderState(MarketOrderCapsule, State, MarketAccountStore)"
  })
  public void testUpdateOrderState_whenActive_thenCallsSetState() throws ItemNotFoundException {
    // Arrange
    MarketOrderCapsule orderCapsule = mock(MarketOrderCapsule.class);
    doNothing().when(orderCapsule).setState(Mockito.<State>any());

    // Act
    MarketUtils.updateOrderState(orderCapsule, State.ACTIVE, null);

    // Assert
    verify(orderCapsule).setState(State.ACTIVE);
  }

  /**
   * Test {@link MarketUtils#multiplyAndDivide(long, long, long)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#multiplyAndDivide(long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.multiplyAndDivide(long, long, long)"})
  public void testMultiplyAndDivide_whenFive_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5L, MarketUtils.multiplyAndDivide(5L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#multiplyAndDivide(long, long, long)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#multiplyAndDivide(long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.multiplyAndDivide(long, long, long)"})
  public void testMultiplyAndDivide_whenMax_value_thenReturnMax_value() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE, MarketUtils.multiplyAndDivide(Long.MAX_VALUE, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#multiplyAndDivide(long, long, long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#multiplyAndDivide(long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.multiplyAndDivide(long, long, long)"})
  public void testMultiplyAndDivide_whenMinusOne_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, MarketUtils.multiplyAndDivide(-1L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#multiplyAndDivide(long, long, long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#multiplyAndDivide(long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.multiplyAndDivide(long, long, long)"})
  public void testMultiplyAndDivide_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1L, MarketUtils.multiplyAndDivide(1L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#multiplyAndDivide(long, long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#multiplyAndDivide(long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.multiplyAndDivide(long, long, long)"})
  public void testMultiplyAndDivide_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, MarketUtils.multiplyAndDivide(0L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#checkTokenValid(byte[])}.
   *
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#checkTokenValid(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketUtils.checkTokenValid(byte[])"})
  public void testCheckTokenValid_when0xaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(MarketUtils.checkTokenValid("0XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#checkTokenValid(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#checkTokenValid(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketUtils.checkTokenValid(byte[])"})
  public void testCheckTokenValid_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(MarketUtils.checkTokenValid("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#checkTokenValid(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#checkTokenValid(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketUtils.checkTokenValid(byte[])"})
  public void testCheckTokenValid_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertFalse(MarketUtils.checkTokenValid(new byte[] {}));
  }

  /**
   * Test {@link MarketUtils#checkTokenValid(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#checkTokenValid(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketUtils.checkTokenValid(byte[])"})
  public void testCheckTokenValid_whenXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(MarketUtils.checkTokenValid("\bXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#checkPairValid(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#checkPairValid(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketUtils.checkPairValid(byte[], byte[])"})
  public void testCheckPairValid_when0xaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            MarketUtils.checkPairValid("0XAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#checkPairValid(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#checkPairValid(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketUtils.checkPairValid(byte[], byte[])"})
  public void testCheckPairValid_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            MarketUtils.checkPairValid("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#checkPairValid(byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#checkPairValid(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketUtils.checkPairValid(byte[], byte[])"})
  public void testCheckPairValid_whenEmptyArrayOfByte()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () -> MarketUtils.checkPairValid(new byte[] {}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#checkPairValid(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketUtils#checkPairValid(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketUtils.checkPairValid(byte[], byte[])"})
  public void testCheckPairValid_whenXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(
        BadItemException.class,
        () ->
            MarketUtils.checkPairValid(
                "\bXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
  }
}
