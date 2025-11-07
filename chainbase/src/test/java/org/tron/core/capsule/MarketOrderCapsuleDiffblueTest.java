package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.MarketOrderStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.MarketOrder;
import org.tron.protos.Protocol.MarketOrder.State;
import org.tron.protos.contract.MarketContract;
import org.tron.protos.contract.MarketContract.MarketSellAssetContract;

public class MarketOrderCapsuleDiffblueTest {
  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_when2xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("2XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 8XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_when8xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("8XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWith2AndZero_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithAAndMinusOne() {
    // Arrange, Act and Assert
    assertNull(
        (new MarketOrderCapsule(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1}))
            .getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithLfAndZero_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithMin_valueAndX() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code "} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithQuotationMarkAndZero() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithTwentyFourAndX() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[], MarketSellAssetContract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return BuyTokenQuantity is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[], MarketSellAssetContract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[], MarketSellAssetContract)"})
  public void testNewMarketOrderCapsule_whenDefaultInstance_thenReturnBuyTokenQuantityIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] id = "AXAXAXAX".getBytes("UTF-8");

    // Act
    MarketOrderCapsule actualMarketOrderCapsule = new MarketOrderCapsule(id,
        MarketSellAssetContract.getDefaultInstance());

    // Assert
    assertEquals(0L, actualMarketOrderCapsule.getBuyTokenQuantity());
    assertEquals(0L, actualMarketOrderCapsule.getCreateTime());
    assertEquals(0L, actualMarketOrderCapsule.getSellTokenQuantity());
    assertEquals(0L, actualMarketOrderCapsule.getSellTokenQuantityRemain());
    assertEquals(0L, actualMarketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(State.ACTIVE, actualMarketOrderCapsule.getSt());
    assertTrue(actualMarketOrderCapsule.isActive());
    assertTrue(actualMarketOrderCapsule.isNextNull());
    assertTrue(actualMarketOrderCapsule.isPreNull());
    byte[] buyTokenId = actualMarketOrderCapsule.getBuyTokenId();
    assertSame(buyTokenId, actualMarketOrderCapsule.getNext());
    assertSame(buyTokenId, actualMarketOrderCapsule.getPrev());
    assertSame(buyTokenId, actualMarketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\n\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualMarketOrderCapsule.getData());
    assertArrayEquals(new byte[]{}, buyTokenId);
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return BuyTokenQuantity is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenEmptyArrayOfByte_thenReturnBuyTokenQuantityIsZero() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Assert
    assertEquals(0L, actualMarketOrderCapsule.getBuyTokenQuantity());
    assertEquals(0L, actualMarketOrderCapsule.getCreateTime());
    assertEquals(0L, actualMarketOrderCapsule.getSellTokenQuantity());
    assertEquals(0L, actualMarketOrderCapsule.getSellTokenQuantityRemain());
    assertEquals(0L, actualMarketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(State.ACTIVE, actualMarketOrderCapsule.getSt());
    assertTrue(actualMarketOrderCapsule.isActive());
    assertTrue(actualMarketOrderCapsule.isNextNull());
    assertTrue(actualMarketOrderCapsule.isPreNull());
    byte[] buyTokenId = actualMarketOrderCapsule.getBuyTokenId();
    assertSame(buyTokenId, actualMarketOrderCapsule.getNext());
    assertSame(buyTokenId, actualMarketOrderCapsule.getPrev());
    assertSame(buyTokenId, actualMarketOrderCapsule.getSellTokenId());
    assertArrayEquals(new byte[]{}, buyTokenId);
    assertArrayEquals(new byte[]{}, actualMarketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When {@code HXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenHxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("HXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When {@code "XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("\"XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When {@code (XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("(XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#getID()}.
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of {@code byte}.</li>
   *   <li>Then return {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getID()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString MarketOrderCapsule.getID()"})
  public void testGetID_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte_thenReturnEmpty() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    ByteString actualID = marketOrderCapsule.getID();

    // Assert
    ByteString byteString = actualID.EMPTY;
    assertSame(byteString, actualID);
    assertSame(byteString, marketOrderCapsule.getOwnerAddress());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getOrderId());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setID(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setID(ByteString)"})
  public void testSetID() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    marketOrderCapsule.setID(mock(ByteString.class));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setID(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setID(ByteString)"})
  public void testSetID2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setID(mock(ByteString.class));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("", buyTokenId.toStringUtf8());
    assertFalse(buyTokenId.iterator().hasNext());
    assertTrue(buyTokenId.isEmpty());
    MarketOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(buyTokenId, defaultInstanceForType.getBuyTokenId());
    assertSame(buyTokenId, instance.getNext());
    assertSame(buyTokenId, defaultInstanceForType.getNext());
    assertSame(buyTokenId, defaultInstanceForType.getOrderId());
    assertSame(buyTokenId, defaultInstanceForType.getOwnerAddress());
    assertSame(buyTokenId, instance.getPrev());
    assertSame(buyTokenId, defaultInstanceForType.getPrev());
    assertSame(buyTokenId, instance.getSellTokenId());
    assertSame(buyTokenId, defaultInstanceForType.getSellTokenId());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setID(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setID(ByteString)"})
  public void testSetID3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    ByteString expectedBuyTokenId = id.EMPTY;
    assertSame(expectedBuyTokenId, marketOrderCapsule.getInstance().getBuyTokenId());
    assertArrayEquals(new byte[]{'\n', 0, '"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setID(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setID(ByteString)"})
  public void testSetID4() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Act
    marketOrderCapsule.setID(mock(ByteString.class));

    // Assert
    assertEquals(4, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setID(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setID(ByteString)"})
  public void testSetID5() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Act
    marketOrderCapsule.setID(mock(ByteString.class));

    // Assert
    assertEquals(4, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setID(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setID(ByteString)"})
  public void testSetID6() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Act
    marketOrderCapsule.setID(mock(ByteString.class));

    // Assert
    assertEquals(4, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setID(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setID(ByteString)"})
  public void testSetID7() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setID(mock(ByteString.class));

    // Assert
    assertArrayEquals(new byte[]{'\n', 0, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setID(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setID(ByteString)"})
  public void testSetID8() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setID(mock(ByteString.class));

    // Assert
    assertEquals(4, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setID(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setID(ByteString)"})
  public void testSetID9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    ByteString expectedBuyTokenId = id.EMPTY;
    assertSame(expectedBuyTokenId, marketOrderCapsule.getInstance().getBuyTokenId());
    assertArrayEquals(new byte[]{'\n', 0, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setID(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setID(ByteString)"})
  public void testSetID10() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));
    ByteString id = mock(ByteString.class);

    // Act
    marketOrderCapsule.setID(id);

    // Assert
    ByteString expectedBuyTokenId = id.EMPTY;
    assertSame(expectedBuyTokenId, marketOrderCapsule.getInstance().getBuyTokenId());
    assertArrayEquals(new byte[]{'\n', 0, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setID(ByteString)}.
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of {@code byte} CreateTime is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#setID(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setID(ByteString)"})
  public void testSetID_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByteCreateTimeIsTen() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setID(mock(ByteString.class));

    // Assert
    assertEquals(4, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getOwnerAddress()}.
   * <ul>
   *   <li>Then {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of {@code byte} ID is {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getOwnerAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString MarketOrderCapsule.getOwnerAddress()"})
  public void testGetOwnerAddress_thenMarketOrderCapsuleWithDataIsEmptyArrayOfByteIdIsEmpty() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    ByteString actualOwnerAddress = marketOrderCapsule.getOwnerAddress();

    // Assert
    ByteString byteString = actualOwnerAddress.EMPTY;
    assertSame(byteString, marketOrderCapsule.getID());
    assertSame(byteString, actualOwnerAddress);
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertSame(byteString, instance.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, instance.getOrderId());
    assertSame(byteString, instance.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, instance.getSellTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setOwnerAddress(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setOwnerAddress(ByteString)"})
  public void testSetOwnerAddress() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{18, 0}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setOwnerAddress(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setOwnerAddress(ByteString)"})
  public void testSetOwnerAddress2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setID(mock(ByteString.class));
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString buyTokenId = instance.getBuyTokenId();
    assertEquals("", buyTokenId.toStringUtf8());
    assertFalse(buyTokenId.iterator().hasNext());
    assertTrue(buyTokenId.isEmpty());
    ByteString byteString = address.EMPTY;
    MarketOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, defaultInstanceForType.getNext());
    assertSame(byteString, defaultInstanceForType.getOrderId());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, defaultInstanceForType.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(byteString, defaultInstanceForType.getSellTokenId());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setOwnerAddress(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setOwnerAddress(ByteString)"})
  public void testSetOwnerAddress3() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(10L);
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    ByteString byteString = address.EMPTY;
    MarketOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, defaultInstanceForType.getNext());
    assertSame(byteString, defaultInstanceForType.getOrderId());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, defaultInstanceForType.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(byteString, defaultInstanceForType.getSellTokenId());
    assertArrayEquals(new byte[]{18, 0, 24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setOwnerAddress(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setOwnerAddress(ByteString)"})
  public void testSetOwnerAddress4() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    ByteString byteString = address.EMPTY;
    MarketOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, defaultInstanceForType.getNext());
    assertSame(byteString, defaultInstanceForType.getOrderId());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, defaultInstanceForType.getPrev());
    assertSame(byteString, defaultInstanceForType.getSellTokenId());
    assertArrayEquals(new byte[]{18, 0, '"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setOwnerAddress(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setOwnerAddress(ByteString)"})
  public void testSetOwnerAddress5() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantity(2L);
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    ByteString byteString = address.EMPTY;
    MarketOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, defaultInstanceForType.getNext());
    assertSame(byteString, defaultInstanceForType.getOrderId());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, defaultInstanceForType.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(byteString, defaultInstanceForType.getSellTokenId());
    assertArrayEquals(new byte[]{18, 0, '(', 2}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setOwnerAddress(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setOwnerAddress(ByteString)"})
  public void testSetOwnerAddress6() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityRemain(2L);
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    ByteString byteString = address.EMPTY;
    MarketOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, defaultInstanceForType.getNext());
    assertSame(byteString, defaultInstanceForType.getOrderId());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, defaultInstanceForType.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(byteString, defaultInstanceForType.getSellTokenId());
    assertArrayEquals(new byte[]{18, 0, 'H', 2}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setOwnerAddress(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setOwnerAddress(ByteString)"})
  public void testSetOwnerAddress7() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityReturn(2L);
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    ByteString byteString = address.EMPTY;
    MarketOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, defaultInstanceForType.getNext());
    assertSame(byteString, defaultInstanceForType.getOrderId());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, defaultInstanceForType.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(byteString, defaultInstanceForType.getSellTokenId());
    assertArrayEquals(new byte[]{18, 0, 'P', 2}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setOwnerAddress(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setOwnerAddress(ByteString)"})
  public void testSetOwnerAddress8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    ByteString byteString = address.EMPTY;
    MarketOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, defaultInstanceForType.getNext());
    assertSame(byteString, defaultInstanceForType.getOrderId());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, defaultInstanceForType.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(byteString, defaultInstanceForType.getSellTokenId());
    assertArrayEquals(new byte[]{18, 0, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setOwnerAddress(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setOwnerAddress(ByteString)"})
  public void testSetOwnerAddress9() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenQuantity(42L);
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    ByteString byteString = address.EMPTY;
    MarketOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, defaultInstanceForType.getNext());
    assertSame(byteString, defaultInstanceForType.getOrderId());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, defaultInstanceForType.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(byteString, defaultInstanceForType.getSellTokenId());
    assertArrayEquals(new byte[]{18, 0, '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setOwnerAddress(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setOwnerAddress(ByteString)"})
  public void testSetOwnerAddress10() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    ByteString byteString = address.EMPTY;
    MarketOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getBuyTokenId());
    assertSame(byteString, defaultInstanceForType.getNext());
    assertSame(byteString, defaultInstanceForType.getOrderId());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, instance.getPrev());
    assertSame(byteString, defaultInstanceForType.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(byteString, defaultInstanceForType.getSellTokenId());
    assertArrayEquals(new byte[]{18, 0, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setOwnerAddress(ByteString)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setOwnerAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setOwnerAddress(ByteString)"})
  public void testSetOwnerAddress11() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));
    ByteString address = mock(ByteString.class);

    // Act
    marketOrderCapsule.setOwnerAddress(address);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    ByteString byteString = address.EMPTY;
    MarketOrder defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getBuyTokenId());
    assertSame(byteString, instance.getNext());
    assertSame(byteString, defaultInstanceForType.getNext());
    assertSame(byteString, defaultInstanceForType.getOrderId());
    assertSame(byteString, defaultInstanceForType.getOwnerAddress());
    assertSame(byteString, defaultInstanceForType.getPrev());
    assertSame(byteString, instance.getSellTokenId());
    assertSame(byteString, defaultInstanceForType.getSellTokenId());
    assertArrayEquals(new byte[]{18, 0, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getCreateTime()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getCreateTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketOrderCapsule.getCreateTime()"})
  public void testGetCreateTime_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketOrderCapsule(new byte[]{})).getCreateTime());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime3() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{18, 0, 24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime4() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{24, '\n', '"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime5() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantity(4L);

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, '\n', '(', 4}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime6() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityRemain(4L);

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, '\n', 'H', 4}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime7() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityReturn(4L);

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, '\n', 'P', 4}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{24, '\n', '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime9() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, '\n', '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime10() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{24, '\n', 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime11() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{24, '\n', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getSellTokenId()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getSellTokenId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getSellTokenId()"})
  public void testGetSellTokenId_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualSellTokenId = marketOrderCapsule.getSellTokenId();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSellTokenId);
  }

  /**
   * Test {@link MarketOrderCapsule#getSellTokenId()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getSellTokenId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getSellTokenId()"})
  public void testGetSellTokenId_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new MarketOrderCapsule(new byte[]{})).getSellTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertFalse(sellTokenId.isEmpty());
    ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    assertArrayEquals(new byte[]{'\n', 0, '"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertFalse(sellTokenId.isEmpty());
    ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    assertArrayEquals(new byte[]{18, 0, '"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId4() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertFalse(sellTokenId.isEmpty());
    ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    assertArrayEquals(new byte[]{24, '\n', '"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantity(8L);

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertFalse(sellTokenId.isEmpty());
    ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAX(\b".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityRemain(8L);

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertFalse(sellTokenId.isEmpty());
    ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAXH\b".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId7() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityReturn(8L);

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertFalse(sellTokenId.isEmpty());
    ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAXP\b".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAX2\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString sellTokenId = instance.getSellTokenId();
    assertEquals("AXAXAXAX", sellTokenId.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertFalse(sellTokenId.isEmpty());
    ByteIterator iteratorResult = sellTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAX8*".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId10() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAXj\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId11() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAXb\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getSellTokenQuantity()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getSellTokenQuantity()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketOrderCapsule.getSellTokenQuantity()"})
  public void testGetSellTokenQuantity_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketOrderCapsule(new byte[]{})).getSellTokenQuantity());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'(', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity3() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{18, 0, '(', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity4() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, '\n', '(', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '(', 1},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity6() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityRemain(16L);

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'(', 1, 'H', 16}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity7() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityReturn(16L);

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'(', 1, 'P', 16}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'(', 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity9() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'(', 1, '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity10() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'(', 1, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity11() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'(', 1, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getSellTokenQuantityRemain()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getSellTokenQuantityRemain()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketOrderCapsule.getSellTokenQuantityRemain()"})
  public void testGetSellTokenQuantityRemain_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketOrderCapsule(new byte[]{})).getSellTokenQuantityRemain());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain3() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{18, 0, 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain4() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, '\n', 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', 1},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain6() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantity(128L);

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'(', Byte.MIN_VALUE, 1, 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain7() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityReturn(128L);

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'H', 1, 'P', Byte.MIN_VALUE, 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', 1},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain9() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'8', '*', 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain10() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'H', 1, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain11() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'H', 1, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getSellTokenQuantityReturn()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getSellTokenQuantityReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketOrderCapsule.getSellTokenQuantityReturn()"})
  public void testGetSellTokenQuantityReturn_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketOrderCapsule(new byte[]{})).getSellTokenQuantityReturn());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertTrue(instance.getAllFields().isEmpty());
    assertArrayEquals(new byte[]{}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn3() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{18, 0}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn4() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    byte[] expectedData = "\"\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn6() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantity(256L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'(', Byte.MIN_VALUE, 2}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn7() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityRemain(256L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(256L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(256L, instance.getSellTokenQuantityReturn());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'H', Byte.MIN_VALUE, 2, 'P', Byte.MIN_VALUE, 2}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    byte[] expectedData = "2\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn9() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn10() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    byte[] expectedData = "j\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn11() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    byte[] expectedData = "b\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong3() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{18, 0, 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong4() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, '\n', 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'P', 1},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong6() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantity(256L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'(', Byte.MIN_VALUE, 2, 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong7() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityRemain(256L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(5, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'H', Byte.MIN_VALUE, 2, 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'P', 1},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong9() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'8', '*', 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong10() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'P', 1, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong11() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'P', 1, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getBuyTokenId()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getBuyTokenId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getBuyTokenId()"})
  public void testGetBuyTokenId_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualBuyTokenId = marketOrderCapsule.getBuyTokenId();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBuyTokenId);
  }

  /**
   * Test {@link MarketOrderCapsule#getBuyTokenId()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getBuyTokenId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getBuyTokenId()"})
  public void testGetBuyTokenId_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new MarketOrderCapsule(new byte[]{})).getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    byte[] expectedData = "2\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
    assertArrayEquals(new byte[]{'\n', 0, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
    assertArrayEquals(new byte[]{18, 0, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId4() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
    assertArrayEquals(new byte[]{24, '\n', '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
    byte[] expectedSellTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSellTokenId, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "\"\bAXAXAXAX2\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantity(32L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedData = "( 2\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId7() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityRemain(32L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedData = "2\bAXAXAXAXH ".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityReturn(32L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedData = "2\bAXAXAXAXP ".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedData = "2\bAXAXAXAX8*".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId10() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] prev = marketOrderCapsule.getPrev();
    assertSame(prev, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "2\bAXAXAXAXj\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
    assertArrayEquals(new byte[]{}, prev);
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId11() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedData = "2\bAXAXAXAXb\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedBuyTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBuyTokenId, marketOrderCapsule.getBuyTokenId());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
  }

  /**
   * Test {@link MarketOrderCapsule#getBuyTokenQuantity()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getBuyTokenQuantity()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long MarketOrderCapsule.getBuyTokenQuantity()"})
  public void testGetBuyTokenQuantity_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MarketOrderCapsule(new byte[]{})).getBuyTokenQuantity());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity3() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{18, 0, '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity4() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{24, '\n', '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    byte[] expectedData = "\"\bAXAXAXAX8*".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantity(64L);

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    byte[] expectedData = "(@8*".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity7() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityRemain(64L);

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    byte[] expectedData = "8*H@".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityReturn(64L);

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    byte[] expectedData = "8*P@".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    byte[] expectedData = "2\bAXAXAXAX8*".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity10() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    byte[] expectedData = "8*j\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity11() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    byte[] expectedData = "8*b\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getSt()}.
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of {@code byte}.</li>
   *   <li>Then return {@code ACTIVE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getSt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"State MarketOrderCapsule.getSt()"})
  public void testGetSt_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte_thenReturnActive() {
    // Arrange, Act and Assert
    assertEquals(State.ACTIVE, (new MarketOrderCapsule(new byte[]{})).getSt());
  }

  /**
   * Test {@link MarketOrderCapsule#isActive()}.
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of {@code byte}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketOrderCapsule.isActive()"})
  public void testIsActive_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new MarketOrderCapsule(new byte[]{})).isActive());
  }

  /**
   * Test {@link MarketOrderCapsule#getNext()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getNext()"})
  public void testGetNext_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualNext = marketOrderCapsule.getNext();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNext);
  }

  /**
   * Test {@link MarketOrderCapsule#getNext()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getNext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getNext()"})
  public void testGetNext_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new MarketOrderCapsule(new byte[]{})).getNext());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    byte[] expectedData = "j\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertTrue(next.iterator().hasNext());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{'\n', 0, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertTrue(next.iterator().hasNext());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{18, 0, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext4() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertTrue(next.iterator().hasNext());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{24, '\n', 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    byte[] expectedData = "\"\bAXAXAXAXj\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantity(2048L);

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertTrue(next.iterator().hasNext());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{'(', Byte.MIN_VALUE, 16, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext7() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityRemain(2048L);

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertTrue(next.iterator().hasNext());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{'H', Byte.MIN_VALUE, 16, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityReturn(2048L);

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    assertEquals(13, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertTrue(next.iterator().hasNext());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{'P', Byte.MIN_VALUE, 16, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] prev = marketOrderCapsule.getPrev();
    assertSame(prev, marketOrderCapsule.getSellTokenId());
    byte[] expectedData = "2\bAXAXAXAXj\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    assertArrayEquals(new byte[]{}, prev);
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext10() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString next = instance.getNext();
    assertEquals("AXAXAXAX", next.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertEquals(2, instance.getAllFields().size());
    assertFalse(next.isEmpty());
    assertTrue(next.iterator().hasNext());
    byte[] expectedData = "8*j\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext11() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedNext = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedNext, marketOrderCapsule.getNext());
    byte[] expectedData = "b\bAXAXAXAXj\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getPrev()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getPrev()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getPrev()"})
  public void testGetPrev_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualPrev = marketOrderCapsule.getPrev();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPrev);
  }

  /**
   * Test {@link MarketOrderCapsule#getPrev()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getPrev()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getPrev()"})
  public void testGetPrev_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new MarketOrderCapsule(new byte[]{})).getPrev());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    byte[] expectedData = "b\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setID(mock(ByteString.class));

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertFalse(prev.isEmpty());
    ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(new byte[]{'\n', 0, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setOwnerAddress(mock(ByteString.class));

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertFalse(prev.isEmpty());
    ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(new byte[]{18, 0, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev4() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertFalse(prev.isEmpty());
    ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(new byte[]{24, '\n', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    byte[] expectedData = "\"\bAXAXAXAXb\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantity(1024L);

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    assertEquals(13, instance.getSerializedSize());
    assertFalse(prev.isEmpty());
    ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(new byte[]{'(', Byte.MIN_VALUE, '\b', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev7() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityRemain(1024L);

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    assertEquals(13, instance.getSerializedSize());
    assertFalse(prev.isEmpty());
    ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(new byte[]{'H', Byte.MIN_VALUE, '\b', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityReturn(1024L);

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    assertEquals(13, instance.getSerializedSize());
    assertFalse(prev.isEmpty());
    ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    assertArrayEquals(new byte[]{'P', Byte.MIN_VALUE, '\b', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedData = "2\bAXAXAXAXb\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev10() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    ByteString prev = instance.getPrev();
    assertEquals("AXAXAXAX", prev.toStringUtf8());
    assertEquals(12, instance.getSerializedSize());
    assertFalse(prev.isEmpty());
    ByteIterator iteratorResult = prev.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedData = "8*b\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   * <p>
   * Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev11() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    byte[] expectedPrev = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPrev, marketOrderCapsule.getPrev());
    byte[] expectedData = "b\bAXAXAXAXj\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#isPreNull()}.
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of {@code byte}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#isPreNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketOrderCapsule.isPreNull()"})
  public void testIsPreNull_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new MarketOrderCapsule(new byte[]{})).isPreNull());
  }

  /**
   * Test {@link MarketOrderCapsule#isPreNull()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#isPreNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketOrderCapsule.isPreNull()"})
  public void testIsPreNull_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(marketOrderCapsule.isPreNull());
  }

  /**
   * Test {@link MarketOrderCapsule#isNextNull()}.
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of {@code byte}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#isNextNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketOrderCapsule.isNextNull()"})
  public void testIsNextNull_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new MarketOrderCapsule(new byte[]{})).isNextNull());
  }

  /**
   * Test {@link MarketOrderCapsule#isNextNull()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#isNextNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MarketOrderCapsule.isNextNull()"})
  public void testIsNextNull_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(marketOrderCapsule.isNextNull());
  }

  /**
   * Test {@link MarketOrderCapsule#getPrevCapsule(MarketOrderStore)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getPrevCapsule(MarketOrderStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MarketOrderCapsule MarketOrderCapsule.getPrevCapsule(MarketOrderStore)"})
  public void testGetPrevCapsule_thenReturnNull() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{})).getPrevCapsule(null));
  }

  /**
   * Test {@link MarketOrderCapsule#getNextCapsule(MarketOrderStore)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getNextCapsule(MarketOrderStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MarketOrderCapsule MarketOrderCapsule.getNextCapsule(MarketOrderStore)"})
  public void testGetNextCapsule_thenReturnNull() throws ItemNotFoundException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule(new byte[]{})).getNextCapsule(null));
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isEmpty()} return {@code true}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_givenByteStringIsEmptyReturnTrue_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new MarketOrderCapsule(new byte[]{})).getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return 2 backspace AXAXAXAX Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturn2BackspaceAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals("2\bAXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code 8} and {@code *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWith8AndAsterisk() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setBuyTokenQuantity(42L);
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'8', '*'}, actualData);
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code H} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithHAndMinusOne() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityRemain(-1L);
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'H', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code (} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithLeftParenthesisAndMinusOne() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantity(-1L);
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'(', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code P} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithPAndMinusOne() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenQuantityReturn(-1L);
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'P', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndLf() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(10L);
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, '\n'}, actualData);
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndMinusOne() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setCreateTime(Long.MAX_VALUE);
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return b backspace AXAXAXAX Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnBBackspaceAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals("b\bAXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return &quot; backspace AXAXAXAX Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnBackspaceAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals("\"\bAXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   * <ul>
   *   <li>Then return j backspace AXAXAXAX Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnJBackspaceAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString id = mock(ByteString.class);
    when(id.isEmpty()).thenReturn(true);
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[]{});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));
    marketOrderCapsule.setOwnerAddress(address);
    marketOrderCapsule.setID(id);

    // Act
    byte[] actualData = marketOrderCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(id, atLeast(1)).isEmpty();
    assertArrayEquals("j\bAXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test {@link MarketOrderCapsule#getInstance()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarketOrderCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MarketOrder MarketOrderCapsule.getInstance()"})
  public void testGetInstance_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new MarketOrderCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }
}
