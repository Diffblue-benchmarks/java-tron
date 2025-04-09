package org.tron.core.capsule.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.tron.core.capsule.MarketAccountOrderCapsule;
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
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return array of {@code byte} with {@code q} and {@code d}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#calculateOrderId(ByteString, byte[], byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.calculateOrderId(ByteString, byte[], byte[], long)"})
  public void testCalculateOrderId_givenAxaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithQAndD()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualCalculateOrderIdResult = MarketUtils.calculateOrderId(address, sellTokenId,
        "AXAXAXAX".getBytes("UTF-8"), 3L);

    // Assert
    verify(address).toByteArray();
    assertArrayEquals(new byte[]{'q', 'd', '\f', 'd', 'v', 'l', ' ', '_', '#', -121, Byte.MAX_VALUE, 'H', -104, -33,
        -59, '\'', -22, 25, 'z', '+', -121, -11, -49, -21, -70, -14, '8', -95, 'R', -88, 'C', -72},
        actualCalculateOrderIdResult);
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#findGCD(long, long)}
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
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenMinusOne_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1L, MarketUtils.findGCD(-1L, 5L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#findGCD(long, long)}
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
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, MarketUtils.findGCD(0L, 5L));
  }

  /**
   * Test {@link MarketUtils#findGCD(long, long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketUtils.findGCD(long, long)"})
  public void testFindGCD_whenZero_thenReturnZero2() {
    // Arrange, Act and Assert
    assertEquals(0L, MarketUtils.findGCD(5L, 0L));
  }

  /**
   * Test {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKey(byte[], byte[], long, long)"})
  public void testCreatePairPriceKey_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        MarketUtils.createPairPriceKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 1L, 1L));
  }

  /**
   * Test {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKey(byte[], byte[], long, long)"})
  public void testCreatePairPriceKey_whenZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        MarketUtils.createPairPriceKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 0L, 1L));
  }

  /**
   * Test {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKey(byte[], byte[], long, long)"})
  public void testCreatePairPriceKey_whenZero2() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        MarketUtils.createPairPriceKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 1L, 0L));
  }

  /**
   * Test {@link MarketUtils#createPairPriceKeyNoGCD(byte[], byte[], long, long)}.
   * <p>
   * Method under test: {@link MarketUtils#createPairPriceKeyNoGCD(byte[], byte[], long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairPriceKeyNoGCD(byte[], byte[], long, long)"})
  public void testCreatePairPriceKeyNoGCD() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        MarketUtils.createPairPriceKeyNoGCD(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 1L, 1L));
  }

  /**
   * Test {@link MarketUtils#getPairPriceHeadKey(byte[], byte[])}.
   * <p>
   * Method under test: {@link MarketUtils#getPairPriceHeadKey(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.getPairPriceHeadKey(byte[], byte[])"})
  public void testGetPairPriceHeadKey() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        MarketUtils.getPairPriceHeadKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#expandTokenIdToPriceArray(byte[])}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#expandTokenIdToPriceArray(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.expandTokenIdToPriceArray(byte[])"})
  public void testExpandTokenIdToPriceArray_thenReturnArrayOfByteWithAAndX() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        MarketUtils.expandTokenIdToPriceArray("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#trim(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code AXAXAXA} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#trim(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.trim(byte[])"})
  public void testTrim_whenA_thenReturnAxaxaxaBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualTrimResult = MarketUtils.trim(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0});

    // Assert
    assertArrayEquals("AXAXAXA".getBytes("UTF-8"), actualTrimResult);
  }

  /**
   * Test {@link MarketUtils#trim(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#trim(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.trim(byte[])"})
  public void testTrim_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualTrimResult = MarketUtils.trim("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualTrimResult);
  }

  /**
   * Test {@link MarketUtils#trim(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#trim(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.trim(byte[])"})
  public void testTrim_whenEmptyArrayOfByte_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, MarketUtils.trim(new byte[]{}));
  }

  /**
   * Test {@link MarketUtils#createPairKey(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#createPairKey(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketUtils.createPairKey(byte[], byte[])"})
  public void testCreatePairKey_whenAxaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        MarketUtils.createPairKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#comparePrice(MarketPrice, MarketPrice)} with {@code price1}, {@code price2}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(MarketPrice, MarketPrice)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(MarketPrice, MarketPrice)"})
  public void testComparePriceWithPrice1Price2_whenDefaultInstance_thenReturnZero() {
    // Arrange
    MarketPrice price1 = MarketPrice.getDefaultInstance();

    // Act and Assert
    assertEquals(0, MarketUtils.comparePrice(price1, MarketPrice.getDefaultInstance()));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)} with {@code price1SellQuantity}, {@code price1BuyQuantity}, {@code price2SellQuantity}, {@code price2BuyQuantity}.
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePriceWithPrice1SellQuantityPrice1BuyQuantityPrice2SellQuantityPrice2BuyQuantity() {
    // Arrange, Act and Assert
    assertEquals(0, MarketUtils.comparePrice(5L, 5L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)} with {@code price1SellQuantity}, {@code price1BuyQuantity}, {@code price2SellQuantity}, {@code price2BuyQuantity}.
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePriceWithPrice1SellQuantityPrice1BuyQuantityPrice2SellQuantityPrice2BuyQuantity2() {
    // Arrange, Act and Assert
    assertEquals(1, MarketUtils.comparePrice(1L, 5L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)} with {@code price1SellQuantity}, {@code price1BuyQuantity}, {@code price2SellQuantity}, {@code price2BuyQuantity}.
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePriceWithPrice1SellQuantityPrice1BuyQuantityPrice2SellQuantityPrice2BuyQuantity3() {
    // Arrange, Act and Assert
    assertEquals(1, MarketUtils.comparePrice(0L, 5L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)} with {@code price1SellQuantity}, {@code price1BuyQuantity}, {@code price2SellQuantity}, {@code price2BuyQuantity}.
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePriceWithPrice1SellQuantityPrice1BuyQuantityPrice2SellQuantityPrice2BuyQuantity4() {
    // Arrange, Act and Assert
    assertEquals(1, MarketUtils.comparePrice(-1L, 5L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)} with {@code price1SellQuantity}, {@code price1BuyQuantity}, {@code price2SellQuantity}, {@code price2BuyQuantity}.
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePriceWithPrice1SellQuantityPrice1BuyQuantityPrice2SellQuantityPrice2BuyQuantity5() {
    // Arrange, Act and Assert
    assertEquals(-1, MarketUtils.comparePrice(Long.MAX_VALUE, 5L, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#comparePrice(long, long, long, long)} with {@code price1SellQuantity}, {@code price1BuyQuantity}, {@code price2SellQuantity}, {@code price2BuyQuantity}.
   * <p>
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MarketUtils.comparePrice(long, long, long, long)"})
  public void testComparePriceWithPrice1SellQuantityPrice1BuyQuantityPrice2SellQuantityPrice2BuyQuantity6() {
    // Arrange, Act and Assert
    assertEquals(1, MarketUtils.comparePrice(5L, Long.MAX_VALUE, 5L, 5L));
  }

  /**
   * Test {@link MarketUtils#isLowerPrice(MarketPrice, MarketPrice)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#isLowerPrice(MarketPrice, MarketPrice)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketUtils.isLowerPrice(MarketPrice, MarketPrice)"})
  public void testIsLowerPrice_whenDefaultInstance_thenReturnFalse() {
    // Arrange
    MarketPrice price1 = MarketPrice.getDefaultInstance();

    // Act and Assert
    assertFalse(MarketUtils.isLowerPrice(price1, MarketPrice.getDefaultInstance()));
  }

  /**
   * Test {@link MarketUtils#priceMatch(MarketPrice, MarketPrice)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#priceMatch(MarketPrice, MarketPrice)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketUtils.priceMatch(MarketPrice, MarketPrice)"})
  public void testPriceMatch_whenDefaultInstance_thenReturnTrue() {
    // Arrange
    MarketPrice takerPrice = MarketPrice.getDefaultInstance();

    // Act and Assert
    assertTrue(MarketUtils.priceMatch(takerPrice, MarketPrice.getDefaultInstance()));
  }

  /**
   * Test {@link MarketUtils#updateOrderState(MarketOrderCapsule, State, MarketAccountStore)}.
   * <p>
   * Method under test: {@link MarketUtils#updateOrderState(MarketOrderCapsule, State, MarketAccountStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketUtils.updateOrderState(MarketOrderCapsule, State, MarketAccountStore)"})
  public void testUpdateOrderState() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule orderCapsule = mock(MarketOrderCapsule.class);
    when(orderCapsule.getID()).thenReturn(null);
    when(orderCapsule.getOwnerAddress()).thenReturn(byteString);
    doNothing().when(orderCapsule).setState(Mockito.<State>any());
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(address);
    marketAccountOrderCapsule.addOrders(mock(ByteString.class));
    MarketAccountStore marketAccountStore = mock(MarketAccountStore.class);
    doNothing().when(marketAccountStore).put(Mockito.<byte[]>any(), Mockito.<MarketAccountOrderCapsule>any());
    when(marketAccountStore.get(Mockito.<byte[]>any())).thenReturn(marketAccountOrderCapsule);

    // Act
    MarketUtils.updateOrderState(orderCapsule, State.INACTIVE, marketAccountStore);

    // Assert
    verify(byteString).toByteArray();
    verify(address).toByteArray();
    verify(orderCapsule).getID();
    verify(orderCapsule).getOwnerAddress();
    verify(orderCapsule).setState(eq(State.INACTIVE));
    verify(marketAccountStore).put(isA(byte[].class), isA(MarketAccountOrderCapsule.class));
    verify(marketAccountStore).get(isA(byte[].class));
  }

  /**
   * Test {@link MarketUtils#updateOrderState(MarketOrderCapsule, State, MarketAccountStore)}.
   * <ul>
   *   <li>Given {@link MarketAccountOrderCapsule#MarketAccountOrderCapsule(ByteString)} with address is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#updateOrderState(MarketOrderCapsule, State, MarketAccountStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketUtils.updateOrderState(MarketOrderCapsule, State, MarketAccountStore)"})
  public void testUpdateOrderState_givenMarketAccountOrderCapsuleWithAddressIsByteString()
      throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule orderCapsule = mock(MarketOrderCapsule.class);
    when(orderCapsule.getID()).thenReturn(null);
    when(orderCapsule.getOwnerAddress()).thenReturn(byteString);
    doNothing().when(orderCapsule).setState(Mockito.<State>any());
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(address);
    MarketAccountStore marketAccountStore = mock(MarketAccountStore.class);
    doNothing().when(marketAccountStore).put(Mockito.<byte[]>any(), Mockito.<MarketAccountOrderCapsule>any());
    when(marketAccountStore.get(Mockito.<byte[]>any())).thenReturn(marketAccountOrderCapsule);

    // Act
    MarketUtils.updateOrderState(orderCapsule, State.INACTIVE, marketAccountStore);

    // Assert
    verify(byteString).toByteArray();
    verify(address).toByteArray();
    verify(orderCapsule).getID();
    verify(orderCapsule).getOwnerAddress();
    verify(orderCapsule).setState(eq(State.INACTIVE));
    verify(marketAccountStore).put(isA(byte[].class), isA(MarketAccountOrderCapsule.class));
    verify(marketAccountStore).get(isA(byte[].class));
  }

  /**
   * Test {@link MarketUtils#updateOrderState(MarketOrderCapsule, State, MarketAccountStore)}.
   * <ul>
   *   <li>Then calls {@link MarketAccountOrderCapsule#createDbKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#updateOrderState(MarketOrderCapsule, State, MarketAccountStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketUtils.updateOrderState(MarketOrderCapsule, State, MarketAccountStore)"})
  public void testUpdateOrderState_thenCallsCreateDbKey() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule orderCapsule = mock(MarketOrderCapsule.class);
    when(orderCapsule.getID()).thenReturn(null);
    when(orderCapsule.getOwnerAddress()).thenReturn(byteString);
    doNothing().when(orderCapsule).setState(Mockito.<State>any());
    MarketAccountOrderCapsule marketAccountOrderCapsule = mock(MarketAccountOrderCapsule.class);
    when(marketAccountOrderCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(marketAccountOrderCapsule).removeOrder(Mockito.<ByteString>any());
    MarketAccountStore marketAccountStore = mock(MarketAccountStore.class);
    doNothing().when(marketAccountStore).put(Mockito.<byte[]>any(), Mockito.<MarketAccountOrderCapsule>any());
    when(marketAccountStore.get(Mockito.<byte[]>any())).thenReturn(marketAccountOrderCapsule);

    // Act
    MarketUtils.updateOrderState(orderCapsule, State.INACTIVE, marketAccountStore);

    // Assert
    verify(byteString).toByteArray();
    verify(marketAccountOrderCapsule).createDbKey();
    verify(marketAccountOrderCapsule).removeOrder(isNull());
    verify(orderCapsule).getID();
    verify(orderCapsule).getOwnerAddress();
    verify(orderCapsule).setState(eq(State.INACTIVE));
    verify(marketAccountStore).put(isA(byte[].class), isA(MarketAccountOrderCapsule.class));
    verify(marketAccountStore).get(isA(byte[].class));
  }

  /**
   * Test {@link MarketUtils#updateOrderState(MarketOrderCapsule, State, MarketAccountStore)}.
   * <ul>
   *   <li>When {@code ACTIVE}.</li>
   *   <li>Then calls {@link MarketOrderCapsule#setState(State)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#updateOrderState(MarketOrderCapsule, State, MarketAccountStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketUtils.updateOrderState(MarketOrderCapsule, State, MarketAccountStore)"})
  public void testUpdateOrderState_whenActive_thenCallsSetState() throws ItemNotFoundException {
    // Arrange
    MarketOrderCapsule orderCapsule = mock(MarketOrderCapsule.class);
    doNothing().when(orderCapsule).setState(Mockito.<State>any());

    // Act
    MarketUtils.updateOrderState(orderCapsule, State.ACTIVE, null);

    // Assert
    verify(orderCapsule).setState(eq(State.ACTIVE));
  }

  /**
   * Test {@link MarketUtils#multiplyAndDivide(long, long, long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#multiplyAndDivide(long, long, long)}
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
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#multiplyAndDivide(long, long, long)}
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
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#multiplyAndDivide(long, long, long)}
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
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#multiplyAndDivide(long, long, long)}
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
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#multiplyAndDivide(long, long, long)}
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
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#checkTokenValid(byte[])}
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
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#checkTokenValid(byte[])}
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
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#checkTokenValid(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketUtils.checkTokenValid(byte[])"})
  public void testCheckTokenValid_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertFalse(MarketUtils.checkTokenValid(new byte[]{}));
  }

  /**
   * Test {@link MarketUtils#checkTokenValid(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#checkTokenValid(byte[])}
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
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#checkPairValid(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketUtils.checkPairValid(byte[], byte[])"})
  public void testCheckPairValid_when0xaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, BadItemException {
    // Arrange
    byte[] sellTokenId = "0XAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(BadItemException.class, () -> MarketUtils.checkPairValid(sellTokenId, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#checkPairValid(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#checkPairValid(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketUtils.checkPairValid(byte[], byte[])"})
  public void testCheckPairValid_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, BadItemException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(BadItemException.class, () -> MarketUtils.checkPairValid(sellTokenId, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#checkPairValid(byte[], byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#checkPairValid(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketUtils.checkPairValid(byte[], byte[])"})
  public void testCheckPairValid_whenEmptyArrayOfByte() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> MarketUtils.checkPairValid(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MarketUtils#checkPairValid(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketUtils#checkPairValid(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketUtils.checkPairValid(byte[], byte[])"})
  public void testCheckPairValid_whenXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException, BadItemException {
    // Arrange
    byte[] sellTokenId = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(BadItemException.class, () -> MarketUtils.checkPairValid(sellTokenId, "AXAXAXAX".getBytes("UTF-8")));
  }
}
