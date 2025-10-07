package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.exception.ItemNotFoundException;
import org.tron.core.store.MarketOrderStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.MarketOrder;
import org.tron.protos.Protocol.MarketOrder.State;
import org.tron.protos.contract.MarketContract;
import org.tron.protos.contract.MarketContract.MarketSellAssetContract;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MarketOrderCapsuleDiffblueTest {
  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[], MarketSellAssetContract)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[],
   * MarketSellAssetContract)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[], MarketSellAssetContract)"})
  public void testNewMarketOrderCapsule() throws UnsupportedEncodingException {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule =
        new MarketOrderCapsule(
            "AXAXAXAX".getBytes("UTF-8"), MarketSellAssetContract.getDefaultInstance());

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
    assertArrayEquals("\n\bAXAXAXAX".getBytes("UTF-8"), actualMarketOrderCapsule.getData());
    assertArrayEquals(new byte[] {}, buyTokenId);
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_when2xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketOrderCapsule("2XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWith2AndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule =
        new MarketOrderCapsule(new byte[] {'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 8} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWith8AndMinusOne() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule =
        new MarketOrderCapsule(
            new byte[] {'8', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Assert
    assertNull(actualMarketOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithAAndMinusOne() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule =
        new MarketOrderCapsule(
            new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Assert
    assertNull(actualMarketOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule =
        new MarketOrderCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule =
        new MarketOrderCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithLfAndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule =
        new MarketOrderCapsule(new byte[] {'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithMin_valueAndX() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule =
        new MarketOrderCapsule(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule =
        new MarketOrderCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code "} and zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithQuotationMarkAndZero() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule =
        new MarketOrderCapsule(new byte[] {'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithTwentyFourAndX() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule =
        new MarketOrderCapsule(new byte[] {24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule =
        new MarketOrderCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualMarketOrderCapsule.getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketOrderCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return BuyTokenQuantity is zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenEmptyArrayOfByte_thenReturnBuyTokenQuantityIsZero() {
    // Arrange and Act
    MarketOrderCapsule actualMarketOrderCapsule = new MarketOrderCapsule(new byte[] {});

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
    assertArrayEquals(new byte[] {}, buyTokenId);
    assertArrayEquals(new byte[] {}, actualMarketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketOrderCapsule("\nXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code "XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketOrderCapsule("\"XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code (XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketOrderCapsule("(XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#MarketOrderCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.<init>(byte[])"})
  public void testNewMarketOrderCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketOrderCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link MarketOrderCapsule#getID()}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of
   *       {@code byte}.
   *   <li>Then return {@link ByteString#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getID()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString MarketOrderCapsule.getID()"})
  public void testGetID_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte_thenReturnEmpty() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, marketOrderCapsule.getID());
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
   * Test {@link MarketOrderCapsule#getOwnerAddress()}.
   *
   * <ul>
   *   <li>Then {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of
   *       {@code byte} ID is {@link ByteString#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getOwnerAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString MarketOrderCapsule.getOwnerAddress()"})
  public void testGetOwnerAddress_thenMarketOrderCapsuleWithDataIsEmptyArrayOfByteIdIsEmpty() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act
    ByteString actualOwnerAddress = marketOrderCapsule.getOwnerAddress();

    // Assert
    ByteString byteString = ByteString.EMPTY;
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
   * Test {@link MarketOrderCapsule#getCreateTime()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getCreateTime()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long MarketOrderCapsule.getCreateTime()"})
  public void testGetCreateTime_thenReturnZero() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, marketOrderCapsule.getCreateTime());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act
    marketOrderCapsule.setCreateTime(10L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {24, '\n', '"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime3() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {24, '\n', '(', 4}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime4() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {24, '\n', 'H', 4}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime5() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {24, '\n', 'P', 4}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {24, '\n', '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime7() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {24, '\n', '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {24, '\n', 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setCreateTime(long)"})
  public void testSetCreateTime9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {24, '\n', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getSellTokenId()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getSellTokenId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getSellTokenId()"})
  public void testGetSellTokenId_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getSellTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#getSellTokenId()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getSellTokenId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getSellTokenId()"})
  public void testGetSellTokenId_thenReturnEmptyArrayOfByte() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, marketOrderCapsule.getSellTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getSellTokenId());
    assertArrayEquals("\"\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getSellTokenId());
    assertArrayEquals(
        new byte[] {24, '\n', '"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getSellTokenId());
    assertArrayEquals("\"\bAXAXAXAX(\b".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId4() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getSellTokenId());
    assertArrayEquals("\"\bAXAXAXAXH\b".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getSellTokenId());
    assertArrayEquals("\"\bAXAXAXAXP\b".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getSellTokenId());
    assertArrayEquals("\"\bAXAXAXAX2\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId7() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getSellTokenId());
    assertArrayEquals("\"\bAXAXAXAX8*".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getSellTokenId());
    assertArrayEquals("\"\bAXAXAXAXj\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenId(byte[])"})
  public void testSetSellTokenId9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getSellTokenId());
    assertArrayEquals("\"\bAXAXAXAXb\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getSellTokenQuantity()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getSellTokenQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long MarketOrderCapsule.getSellTokenQuantity()"})
  public void testGetSellTokenQuantity_thenReturnZero() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantity());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act
    marketOrderCapsule.setSellTokenQuantity(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'(', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {24, '\n', '(', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {'"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '(', 1},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity4() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {'(', 1, 'H', 16}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity5() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {'(', 1, 'P', 16}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {'(', 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity7() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {'(', 1, '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {'(', 1, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantity(long)"})
  public void testSetSellTokenQuantity9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {'(', 1, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getSellTokenQuantityRemain()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getSellTokenQuantityRemain()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long MarketOrderCapsule.getSellTokenQuantityRemain()"})
  public void testGetSellTokenQuantityRemain_thenReturnZero() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityRemain());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {24, '\n', 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {'"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', 1},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain4() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {'(', Byte.MIN_VALUE, 1, 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain5() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {'H', 1, 'P', Byte.MIN_VALUE, 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {'2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', 1},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain7() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {'8', '*', 'H', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {'H', 1, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {'H', 1, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityRemain(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityRemain(long)"})
  public void testSetSellTokenQuantityRemain10() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setState(State.INACTIVE);

    // Act
    marketOrderCapsule.setSellTokenQuantityRemain(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'H', 1, 'X', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getSellTokenQuantityReturn()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getSellTokenQuantityReturn()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long MarketOrderCapsule.getSellTokenQuantityReturn()"})
  public void testGetSellTokenQuantityReturn_thenReturnZero() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertTrue(instance.getAllFields().isEmpty());
    assertArrayEquals(new byte[] {}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertArrayEquals("\"\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn4() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenQuantity(256L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(3, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'(', Byte.MIN_VALUE, 2}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn5() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenQuantityRemain(256L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(256L, marketOrderCapsule.getSellTokenQuantityReturn());
    assertEquals(256L, instance.getSellTokenQuantityReturn());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'H', Byte.MIN_VALUE, 2, 'P', Byte.MIN_VALUE, 2}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertArrayEquals("2\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn7() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertArrayEquals("j\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertArrayEquals("b\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn()}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn()"})
  public void testSetSellTokenQuantityReturn10() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setState(State.INACTIVE);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn();

    // Assert that nothing has changed
    assertEquals(0L, marketOrderCapsule.getSellTokenQuantityReturn());
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(0L, instance.getSellTokenQuantityReturn());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'X', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {24, '\n', 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {'"', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'P', 1},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong4() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {'(', Byte.MIN_VALUE, 2, 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong5() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {'H', Byte.MIN_VALUE, 2, 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {'2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'P', 1},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong7() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {'8', '*', 'P', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {'P', 1, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(
        new byte[] {'P', 1, 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)} with {@code long}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setSellTokenQuantityReturn(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setSellTokenQuantityReturn(long)"})
  public void testSetSellTokenQuantityReturnWithLong10() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setState(State.INACTIVE);

    // Act
    marketOrderCapsule.setSellTokenQuantityReturn(1L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'P', 1, 'X', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getBuyTokenId()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getBuyTokenId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getBuyTokenId()"})
  public void testGetBuyTokenId_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#getBuyTokenId()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getBuyTokenId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getBuyTokenId()"})
  public void testGetBuyTokenId_thenReturnEmptyArrayOfByte() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertArrayEquals("2\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setCreateTime(10L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getBuyTokenId());
    assertArrayEquals(
        new byte[] {24, '\n', '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getBuyTokenId());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getSellTokenId());
    assertArrayEquals("\"\bAXAXAXAX2\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId4() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenQuantity(32L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("( 2\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenQuantityRemain(32L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("2\bAXAXAXAXH ".getBytes("UTF-8"), marketOrderCapsule.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenQuantityReturn(32L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("2\bAXAXAXAXP ".getBytes("UTF-8"), marketOrderCapsule.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId7() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(12, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("2\bAXAXAXAX8*".getBytes("UTF-8"), marketOrderCapsule.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getBuyTokenId());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] prev = marketOrderCapsule.getPrev();
    assertSame(prev, marketOrderCapsule.getSellTokenId());
    assertArrayEquals("2\bAXAXAXAXj\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getBuyTokenId());
    assertArrayEquals(new byte[] {}, prev);
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenId(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenId(byte[])"})
  public void testSetBuyTokenId9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("2\bAXAXAXAXb\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getBuyTokenId());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getPrev());
  }

  /**
   * Test {@link MarketOrderCapsule#getBuyTokenQuantity()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getBuyTokenQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long MarketOrderCapsule.getBuyTokenQuantity()"})
  public void testGetBuyTokenQuantity_thenReturnZero() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, marketOrderCapsule.getBuyTokenQuantity());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(1, descriptorForType.getEnumTypes().size());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(12, descriptorForType.getFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity2() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals(new byte[] {24, '\n', '8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("\"\bAXAXAXAX8*".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity4() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("(@8*".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("8*H@".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("8*P@".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity7() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("2\bAXAXAXAX8*".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("8*j\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setBuyTokenQuantity(long)}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setBuyTokenQuantity(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setBuyTokenQuantity(long)"})
  public void testSetBuyTokenQuantity9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("8*b\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getSt()}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of
   *       {@code byte}.
   *   <li>Then return {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getSt()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"State MarketOrderCapsule.getSt()"})
  public void testGetSt_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte_thenReturnActive() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertEquals(State.ACTIVE, marketOrderCapsule.getSt());
  }

  /**
   * Test {@link MarketOrderCapsule#getSt()}.
   *
   * <ul>
   *   <li>Then return {@code CANCELED}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getSt()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"State MarketOrderCapsule.getSt()"})
  public void testGetSt_thenReturnCanceled() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setState(State.CANCELED);

    // Act and Assert
    assertEquals(State.CANCELED, marketOrderCapsule.getSt());
  }

  /**
   * Test {@link MarketOrderCapsule#getSt()}.
   *
   * <ul>
   *   <li>Then return {@code INACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getSt()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"State MarketOrderCapsule.getSt()"})
  public void testGetSt_thenReturnInactive() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setState(State.INACTIVE);

    // Act and Assert
    assertEquals(State.INACTIVE, marketOrderCapsule.getSt());
  }

  /**
   * Test {@link MarketOrderCapsule#isActive()}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of
   *       {@code byte} State is {@code CANCELED}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketOrderCapsule.isActive()"})
  public void testIsActive_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByteStateIsCanceled() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setState(State.CANCELED);

    // Act and Assert
    assertFalse(marketOrderCapsule.isActive());
  }

  /**
   * Test {@link MarketOrderCapsule#isActive()}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of
   *       {@code byte} State is {@code INACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketOrderCapsule.isActive()"})
  public void testIsActive_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByteStateIsInactive() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setState(State.INACTIVE);

    // Act and Assert
    assertFalse(marketOrderCapsule.isActive());
  }

  /**
   * Test {@link MarketOrderCapsule#isActive()}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of
   *       {@code byte}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketOrderCapsule.isActive()"})
  public void testIsActive_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte_thenReturnTrue() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertTrue(marketOrderCapsule.isActive());
  }

  /**
   * Test {@link MarketOrderCapsule#getNext()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getNext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getNext()"})
  public void testGetNext_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getNext());
  }

  /**
   * Test {@link MarketOrderCapsule#getNext()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getNext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getNext()"})
  public void testGetNext_thenReturnEmptyArrayOfByte() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, marketOrderCapsule.getNext());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getNext());
    assertArrayEquals("j\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getNext());
    assertArrayEquals(
        new byte[] {24, '\n', 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getNext());
    assertArrayEquals("\"\bAXAXAXAXj\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext4() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getNext());
    assertArrayEquals(
        new byte[] {'(', Byte.MIN_VALUE, 16, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getNext());
    assertArrayEquals(
        new byte[] {'H', Byte.MIN_VALUE, 16, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getNext());
    assertArrayEquals(
        new byte[] {'P', Byte.MIN_VALUE, 16, 'j', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext7() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] prev = marketOrderCapsule.getPrev();
    assertSame(prev, marketOrderCapsule.getSellTokenId());
    assertArrayEquals("2\bAXAXAXAXj\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getNext());
    assertArrayEquals(new byte[] {}, prev);
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("8*j\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getNext());
  }

  /**
   * Test {@link MarketOrderCapsule#setNext(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setNext(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setNext(byte[])"})
  public void testSetNext9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getNext());
    assertArrayEquals("b\bAXAXAXAXj\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getPrev()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getPrev()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getPrev()"})
  public void testGetPrev_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getPrev());
  }

  /**
   * Test {@link MarketOrderCapsule#getPrev()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getPrev()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getPrev()"})
  public void testGetPrev_thenReturnEmptyArrayOfByte() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, marketOrderCapsule.getPrev());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MarketOrder instance = marketOrderCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getPrev());
    assertArrayEquals("b\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev2() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getPrev());
    assertArrayEquals(
        new byte[] {24, '\n', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev3() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getPrev());
    assertArrayEquals("\"\bAXAXAXAXb\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev4() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getPrev());
    assertArrayEquals(
        new byte[] {'(', Byte.MIN_VALUE, '\b', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev5() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getPrev());
    assertArrayEquals(
        new byte[] {'H', Byte.MIN_VALUE, '\b', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev6() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getPrev());
    assertArrayEquals(
        new byte[] {'P', Byte.MIN_VALUE, '\b', 'b', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev7() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("2\bAXAXAXAXb\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getPrev());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev8() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
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
    assertArrayEquals("8*b\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getPrev());
  }

  /**
   * Test {@link MarketOrderCapsule#setPrev(byte[])}.
   *
   * <p>Method under test: {@link MarketOrderCapsule#setPrev(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarketOrderCapsule.setPrev(byte[])"})
  public void testSetPrev9() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(20, marketOrderCapsule.getInstance().getSerializedSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getPrev());
    assertArrayEquals("b\bAXAXAXAXj\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#isPreNull()}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of
   *       {@code byte}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#isPreNull()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketOrderCapsule.isPreNull()"})
  public void testIsPreNull_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte_thenReturnTrue() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertTrue(marketOrderCapsule.isPreNull());
  }

  /**
   * Test {@link MarketOrderCapsule#isPreNull()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#isPreNull()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketOrderCapsule.isPreNull()"})
  public void testIsPreNull_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(marketOrderCapsule.isPreNull());
  }

  /**
   * Test {@link MarketOrderCapsule#isNextNull()}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of
   *       {@code byte}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#isNextNull()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketOrderCapsule.isNextNull()"})
  public void testIsNextNull_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte_thenReturnTrue() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertTrue(marketOrderCapsule.isNextNull());
  }

  /**
   * Test {@link MarketOrderCapsule#isNextNull()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#isNextNull()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MarketOrderCapsule.isNextNull()"})
  public void testIsNextNull_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertFalse(marketOrderCapsule.isNextNull());
  }

  /**
   * Test {@link MarketOrderCapsule#getPrevCapsule(MarketOrderStore)}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of
   *       {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getPrevCapsule(MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MarketOrderCapsule MarketOrderCapsule.getPrevCapsule(MarketOrderStore)"})
  public void testGetPrevCapsule_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte()
      throws ItemNotFoundException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertNull(marketOrderCapsule.getPrevCapsule(null));
  }

  /**
   * Test {@link MarketOrderCapsule#getPrevCapsule(MarketOrderStore)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MarketOrderStore} {@link MarketOrderStore#get(byte[])} return {@code null}.
   *   <li>Then calls {@link MarketOrderStore#get(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getPrevCapsule(MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MarketOrderCapsule MarketOrderCapsule.getPrevCapsule(MarketOrderStore)"})
  public void testGetPrevCapsule_givenNull_whenMarketOrderStoreGetReturnNull_thenCallsGet()
      throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    MarketOrderStore orderStore = mock(MarketOrderStore.class);
    when(orderStore.get(Mockito.<byte[]>any())).thenReturn(null);

    // Act
    MarketOrderCapsule actualPrevCapsule = marketOrderCapsule.getPrevCapsule(orderStore);

    // Assert
    verify(orderStore).get(isA(byte[].class));
    assertNull(actualPrevCapsule);
  }

  /**
   * Test {@link MarketOrderCapsule#getNextCapsule(MarketOrderStore)}.
   *
   * <ul>
   *   <li>Given {@link MarketOrderCapsule#MarketOrderCapsule(byte[])} with data is empty array of
   *       {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getNextCapsule(MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MarketOrderCapsule MarketOrderCapsule.getNextCapsule(MarketOrderStore)"})
  public void testGetNextCapsule_givenMarketOrderCapsuleWithDataIsEmptyArrayOfByte()
      throws ItemNotFoundException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertNull(marketOrderCapsule.getNextCapsule(null));
  }

  /**
   * Test {@link MarketOrderCapsule#getNextCapsule(MarketOrderStore)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MarketOrderStore} {@link MarketOrderStore#get(byte[])} return {@code null}.
   *   <li>Then calls {@link MarketOrderStore#get(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getNextCapsule(MarketOrderStore)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MarketOrderCapsule MarketOrderCapsule.getNextCapsule(MarketOrderStore)"})
  public void testGetNextCapsule_givenNull_whenMarketOrderStoreGetReturnNull_thenCallsGet()
      throws UnsupportedEncodingException, ItemNotFoundException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    MarketOrderStore orderStore = mock(MarketOrderStore.class);
    when(orderStore.get(Mockito.<byte[]>any())).thenReturn(null);

    // Act
    MarketOrderCapsule actualNextCapsule = marketOrderCapsule.getNextCapsule(orderStore);

    // Assert
    verify(orderStore).get(isA(byte[].class));
    assertNull(actualNextCapsule);
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return 2 backspace AXAXAXAX Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturn2BackspaceAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setBuyTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("2\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code 8} and {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWith8AndAsterisk() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setBuyTokenQuantity(42L);

    // Act and Assert
    assertArrayEquals(new byte[] {'8', '*'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code H} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithHAndMinusOne() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenQuantityRemain(-1L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'H', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code (} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithLeftParenthesisAndMinusOne() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenQuantity(-1L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'(', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code P} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithPAndMinusOne() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenQuantityReturn(-1L);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'P', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and lf.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndLf() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setCreateTime(10L);

    // Act and Assert
    assertArrayEquals(new byte[] {24, '\n'}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and minus one.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndMinusOne() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setCreateTime(Long.MAX_VALUE);

    // Act and Assert
    assertArrayEquals(
        new byte[] {24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE},
        marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code X} and one.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithXAndOne() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setState(State.INACTIVE);

    // Act and Assert
    assertArrayEquals(new byte[] {'X', 1}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return b backspace AXAXAXAX Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnBBackspaceAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setPrev("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("b\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return &quot; backspace AXAXAXAX Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnBackspaceAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setSellTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("\"\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return j backspace AXAXAXAX Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MarketOrderCapsule.getData()"})
  public void testGetData_thenReturnJBackspaceAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    MarketOrderCapsule marketOrderCapsule = new MarketOrderCapsule(new byte[] {});
    marketOrderCapsule.setNext("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertArrayEquals("j\bAXAXAXAX".getBytes("UTF-8"), marketOrderCapsule.getData());
  }

  /**
   * Test {@link MarketOrderCapsule#getInstance()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarketOrderCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MarketOrder MarketOrderCapsule.getInstance()"})
  public void testGetInstance_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new MarketOrderCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }
}
