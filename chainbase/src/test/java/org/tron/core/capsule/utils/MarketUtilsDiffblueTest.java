package org.tron.core.capsule.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.MarketAccountOrderCapsule;
import org.tron.core.capsule.MarketOrderCapsule;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.AssetIssueStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.store.MarketAccountStore;
import org.tron.protos.Protocol;

@RunWith(MockitoJUnitRunner.class)
public class MarketUtilsDiffblueTest {
  @InjectMocks
  private MarketUtils marketUtils;

  /**
   * Method under test:
   * {@link MarketUtils#calculateOrderId(ByteString, byte[], byte[], long)}
   */
  @Test
  public void testCalculateOrderId() throws UnsupportedEncodingException {
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
   * Method under test: {@link MarketUtils#findGCD(long, long)}
   */
  @Test
  public void testFindGCD() {
    // Arrange, Act and Assert
    assertEquals(5L, MarketUtils.findGCD(5L, 5L));
    assertEquals(1L, MarketUtils.findGCD(1L, 5L));
    assertEquals(0L, MarketUtils.findGCD(0L, 5L));
    assertEquals(-1L, MarketUtils.findGCD(-1L, 5L));
    assertEquals(0L, MarketUtils.findGCD(5L, 0L));
  }

  /**
   * Method under test:
   * {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  public void testCreatePairPriceKey() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        MarketUtils.createPairPriceKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 1L, 1L));
  }

  /**
   * Method under test:
   * {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  public void testCreatePairPriceKey2() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        MarketUtils.createPairPriceKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 0L, 1L));
  }

  /**
   * Method under test:
   * {@link MarketUtils#createPairPriceKey(byte[], byte[], long, long)}
   */
  @Test
  public void testCreatePairPriceKey3() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        MarketUtils.createPairPriceKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8"), 1L, 0L));
  }

  /**
   * Method under test:
   * {@link MarketUtils#createPairPriceKeyNoGCD(byte[], byte[], long, long)}
   */
  @Test
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
   * Method under test: {@link MarketUtils#getPairPriceHeadKey(byte[], byte[])}
   */
  @Test
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
   * Method under test: {@link MarketUtils#expandTokenIdToPriceArray(byte[])}
   */
  @Test
  public void testExpandTokenIdToPriceArray() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        MarketUtils.expandTokenIdToPriceArray("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link MarketUtils#trim(byte[])}
   */
  @Test
  public void testTrim() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualTrimResult = MarketUtils.trim("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualTrimResult);
  }

  /**
   * Method under test: {@link MarketUtils#trim(byte[])}
   */
  @Test
  public void testTrim2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualTrimResult = MarketUtils.trim(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0});

    // Assert
    assertArrayEquals("AXAXAXA".getBytes("UTF-8"), actualTrimResult);
  }

  /**
   * Method under test: {@link MarketUtils#trim(byte[])}
   */
  @Test
  public void testTrim3() {
    // Arrange, Act and Assert
    assertEquals(0, MarketUtils.trim(new byte[]{}).length);
  }

  /**
   * Method under test: {@link MarketUtils#createPairKey(byte[], byte[])}
   */
  @Test
  public void testCreatePairKey() throws UnsupportedEncodingException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'A', 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        MarketUtils.createPairKey(sellTokenId, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link MarketUtils#comparePrice(long, long, long, long)}
   */
  @Test
  public void testComparePrice() {
    // Arrange, Act and Assert
    assertEquals(0, MarketUtils.comparePrice(5L, 5L, 5L, 5L));
    assertEquals(1, MarketUtils.comparePrice(1L, 5L, 5L, 5L));
    assertEquals(1, MarketUtils.comparePrice(0L, 5L, 5L, 5L));
    assertEquals(1, MarketUtils.comparePrice(-1L, 5L, 5L, 5L));
    assertEquals(-1, MarketUtils.comparePrice(Long.MAX_VALUE, 5L, 5L, 5L));
    assertEquals(1, MarketUtils.comparePrice(5L, Long.MAX_VALUE, 5L, 5L));
  }

  /**
   * Method under test:
   * {@link MarketUtils#comparePrice(Protocol.MarketPrice, Protocol.MarketPrice)}
   */
  @Test
  public void testComparePrice2() {
    // Arrange
    Protocol.MarketPrice price1 = Protocol.MarketPrice.getDefaultInstance();

    // Act and Assert
    assertEquals(0, MarketUtils.comparePrice(price1, Protocol.MarketPrice.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link MarketUtils#isLowerPrice(Protocol.MarketPrice, Protocol.MarketPrice)}
   */
  @Test
  public void testIsLowerPrice() {
    // Arrange
    Protocol.MarketPrice price1 = Protocol.MarketPrice.getDefaultInstance();

    // Act and Assert
    assertFalse(MarketUtils.isLowerPrice(price1, Protocol.MarketPrice.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link MarketUtils#priceMatch(Protocol.MarketPrice, Protocol.MarketPrice)}
   */
  @Test
  public void testPriceMatch() {
    // Arrange
    Protocol.MarketPrice takerPrice = Protocol.MarketPrice.getDefaultInstance();

    // Act and Assert
    assertTrue(MarketUtils.priceMatch(takerPrice, Protocol.MarketPrice.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link MarketUtils#updateOrderState(MarketOrderCapsule, Protocol.MarketOrder.State, MarketAccountStore)}
   */
  @Test
  public void testUpdateOrderState() throws ItemNotFoundException {
    // Arrange
    Protocol.MarketOrder order = Protocol.MarketOrder.getDefaultInstance();
    MarketOrderCapsule orderCapsule = new MarketOrderCapsule(order);

    // Act
    MarketUtils.updateOrderState(orderCapsule, Protocol.MarketOrder.State.ACTIVE, null);

    // Assert
    assertEquals(order, orderCapsule.getInstance());
  }

  /**
   * Method under test:
   * {@link MarketUtils#updateOrderState(MarketOrderCapsule, Protocol.MarketOrder.State, MarketAccountStore)}
   */
  @Test
  public void testUpdateOrderState2() throws ItemNotFoundException {
    // Arrange
    MarketOrderCapsule orderCapsule = mock(MarketOrderCapsule.class);
    doNothing().when(orderCapsule).setState(Mockito.<Protocol.MarketOrder.State>any());

    // Act
    MarketUtils.updateOrderState(orderCapsule, Protocol.MarketOrder.State.ACTIVE, null);

    // Assert that nothing has changed
    verify(orderCapsule).setState(eq(Protocol.MarketOrder.State.ACTIVE));
  }

  /**
   * Method under test:
   * {@link MarketUtils#updateOrderState(MarketOrderCapsule, Protocol.MarketOrder.State, MarketAccountStore)}
   */
  @Test
  public void testUpdateOrderState3() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule orderCapsule = mock(MarketOrderCapsule.class);
    when(orderCapsule.getID()).thenReturn(null);
    when(orderCapsule.getOwnerAddress()).thenReturn(byteString);
    doNothing().when(orderCapsule).setState(Mockito.<Protocol.MarketOrder.State>any());
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(address);
    MarketAccountStore marketAccountStore = mock(MarketAccountStore.class);
    doNothing().when(marketAccountStore).put(Mockito.<byte[]>any(), Mockito.<MarketAccountOrderCapsule>any());
    when(marketAccountStore.get(Mockito.<byte[]>any())).thenReturn(marketAccountOrderCapsule);

    // Act
    MarketUtils.updateOrderState(orderCapsule, Protocol.MarketOrder.State.INACTIVE, marketAccountStore);

    // Assert
    verify(byteString).toByteArray();
    verify(address).toByteArray();
    verify(orderCapsule).getID();
    verify(orderCapsule).getOwnerAddress();
    verify(orderCapsule).setState(eq(Protocol.MarketOrder.State.INACTIVE));
    verify(marketAccountStore).put(isA(byte[].class), isA(MarketAccountOrderCapsule.class));
    verify(marketAccountStore).get(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link MarketUtils#updateOrderState(MarketOrderCapsule, Protocol.MarketOrder.State, MarketAccountStore)}
   */
  @Test
  public void testUpdateOrderState4() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule orderCapsule = mock(MarketOrderCapsule.class);
    when(orderCapsule.getID()).thenReturn(null);
    when(orderCapsule.getOwnerAddress()).thenReturn(byteString);
    doNothing().when(orderCapsule).setState(Mockito.<Protocol.MarketOrder.State>any());
    MarketAccountStore marketAccountStore = mock(MarketAccountStore.class);
    doNothing().when(marketAccountStore).put(Mockito.<byte[]>any(), Mockito.<MarketAccountOrderCapsule>any());
    when(marketAccountStore.get(Mockito.<byte[]>any()))
        .thenReturn(new MarketAccountOrderCapsule(Protocol.MarketAccountOrder.getDefaultInstance()));

    // Act
    MarketUtils.updateOrderState(orderCapsule, Protocol.MarketOrder.State.INACTIVE, marketAccountStore);

    // Assert
    verify(byteString).toByteArray();
    verify(orderCapsule).getID();
    verify(orderCapsule).getOwnerAddress();
    verify(orderCapsule).setState(eq(Protocol.MarketOrder.State.INACTIVE));
    verify(marketAccountStore).put(isA(byte[].class), isA(MarketAccountOrderCapsule.class));
    verify(marketAccountStore).get(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link MarketUtils#updateOrderState(MarketOrderCapsule, Protocol.MarketOrder.State, MarketAccountStore)}
   */
  @Test
  public void testUpdateOrderState5() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule orderCapsule = mock(MarketOrderCapsule.class);
    when(orderCapsule.getID()).thenReturn(null);
    when(orderCapsule.getOwnerAddress()).thenReturn(byteString);
    doNothing().when(orderCapsule).setState(Mockito.<Protocol.MarketOrder.State>any());
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    MarketAccountOrderCapsule marketAccountOrderCapsule = new MarketAccountOrderCapsule(address);
    marketAccountOrderCapsule.addOrders(mock(ByteString.class));
    MarketAccountStore marketAccountStore = mock(MarketAccountStore.class);
    doNothing().when(marketAccountStore).put(Mockito.<byte[]>any(), Mockito.<MarketAccountOrderCapsule>any());
    when(marketAccountStore.get(Mockito.<byte[]>any())).thenReturn(marketAccountOrderCapsule);

    // Act
    MarketUtils.updateOrderState(orderCapsule, Protocol.MarketOrder.State.INACTIVE, marketAccountStore);

    // Assert
    verify(byteString).toByteArray();
    verify(address).toByteArray();
    verify(orderCapsule).getID();
    verify(orderCapsule).getOwnerAddress();
    verify(orderCapsule).setState(eq(Protocol.MarketOrder.State.INACTIVE));
    verify(marketAccountStore).put(isA(byte[].class), isA(MarketAccountOrderCapsule.class));
    verify(marketAccountStore).get(isA(byte[].class));
  }

  /**
   * Method under test:
   * {@link MarketUtils#updateOrderState(MarketOrderCapsule, Protocol.MarketOrder.State, MarketAccountStore)}
   */
  @Test
  public void testUpdateOrderState6() throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    MarketOrderCapsule orderCapsule = mock(MarketOrderCapsule.class);
    when(orderCapsule.getID()).thenReturn(null);
    when(orderCapsule.getOwnerAddress()).thenReturn(byteString);
    doNothing().when(orderCapsule).setState(Mockito.<Protocol.MarketOrder.State>any());
    MarketAccountOrderCapsule marketAccountOrderCapsule = mock(MarketAccountOrderCapsule.class);
    when(marketAccountOrderCapsule.createDbKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(marketAccountOrderCapsule).removeOrder(Mockito.<ByteString>any());
    MarketAccountStore marketAccountStore = mock(MarketAccountStore.class);
    doNothing().when(marketAccountStore).put(Mockito.<byte[]>any(), Mockito.<MarketAccountOrderCapsule>any());
    when(marketAccountStore.get(Mockito.<byte[]>any())).thenReturn(marketAccountOrderCapsule);

    // Act
    MarketUtils.updateOrderState(orderCapsule, Protocol.MarketOrder.State.INACTIVE, marketAccountStore);

    // Assert that nothing has changed
    verify(byteString).toByteArray();
    verify(marketAccountOrderCapsule).createDbKey();
    verify(marketAccountOrderCapsule).removeOrder(isNull());
    verify(orderCapsule).getID();
    verify(orderCapsule).getOwnerAddress();
    verify(orderCapsule).setState(eq(Protocol.MarketOrder.State.INACTIVE));
    verify(marketAccountStore).put(isA(byte[].class), isA(MarketAccountOrderCapsule.class));
    verify(marketAccountStore).get(isA(byte[].class));
  }

  /**
   * Method under test: {@link MarketUtils#multiplyAndDivide(long, long, long)}
   */
  @Test
  public void testMultiplyAndDivide() {
    // Arrange, Act and Assert
    assertEquals(5L, MarketUtils.multiplyAndDivide(5L, 5L, 5L));
    assertEquals(1L, MarketUtils.multiplyAndDivide(1L, 5L, 5L));
    assertEquals(0L, MarketUtils.multiplyAndDivide(0L, 5L, 5L));
    assertEquals(-1L, MarketUtils.multiplyAndDivide(-1L, 5L, 5L));
    assertEquals(Long.MAX_VALUE, MarketUtils.multiplyAndDivide(Long.MAX_VALUE, 5L, 5L));
  }

  /**
   * Method under test:
   * {@link MarketUtils#returnSellTokenRemain(MarketOrderCapsule, AccountCapsule, DynamicPropertiesStore, AssetIssueStore)}
   */
  @Test
  public void testReturnSellTokenRemain() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule orderCapsule = mock(MarketOrderCapsule.class);
    doNothing().when(orderCapsule).setSellTokenQuantityRemain(anyLong());
    when(orderCapsule.getSellTokenId()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(orderCapsule.getSellTokenQuantityRemain()).thenReturn(1L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.addAssetAmountV2(Mockito.<byte[]>any(), anyLong(), Mockito.<DynamicPropertiesStore>any(),
        Mockito.<AssetIssueStore>any())).thenReturn(true);

    // Act
    MarketUtils.returnSellTokenRemain(orderCapsule, accountCapsule, null, null);

    // Assert that nothing has changed
    verify(accountCapsule).addAssetAmountV2(isA(byte[].class), eq(1L), isNull(), isNull());
    verify(orderCapsule).getSellTokenId();
    verify(orderCapsule).getSellTokenQuantityRemain();
    verify(orderCapsule).setSellTokenQuantityRemain(eq(0L));
  }

  /**
   * Method under test: {@link MarketUtils#checkTokenValid(byte[])}
   */
  @Test
  public void testCheckTokenValid() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(MarketUtils.checkTokenValid("AXAXAXAX".getBytes("UTF-8")));
    assertFalse(MarketUtils.checkTokenValid("\bXAXAXAX".getBytes("UTF-8")));
    assertFalse(MarketUtils.checkTokenValid("0XAXAXAX".getBytes("UTF-8")));
    assertFalse(MarketUtils.checkTokenValid(new byte[]{}));
  }

  /**
   * Method under test: {@link MarketUtils#checkPairValid(byte[], byte[])}
   */
  @Test
  public void testCheckPairValid() throws UnsupportedEncodingException, BadItemException {
    // Arrange
    byte[] sellTokenId = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(BadItemException.class, () -> MarketUtils.checkPairValid(sellTokenId, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link MarketUtils#checkPairValid(byte[], byte[])}
   */
  @Test
  public void testCheckPairValid2() throws UnsupportedEncodingException, BadItemException {
    // Arrange
    byte[] sellTokenId = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(BadItemException.class, () -> MarketUtils.checkPairValid(sellTokenId, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link MarketUtils#checkPairValid(byte[], byte[])}
   */
  @Test
  public void testCheckPairValid3() throws UnsupportedEncodingException, BadItemException {
    // Arrange
    byte[] sellTokenId = "0XAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(BadItemException.class, () -> MarketUtils.checkPairValid(sellTokenId, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link MarketUtils#checkPairValid(byte[], byte[])}
   */
  @Test
  public void testCheckPairValid4() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> MarketUtils.checkPairValid(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }
}
