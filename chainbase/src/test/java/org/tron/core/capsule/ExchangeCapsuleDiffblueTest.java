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
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.store.AssetIssueStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Exchange;

public class ExchangeCapsuleDiffblueTest {
  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_when2xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("2XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 8XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_when8xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("8XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWith2AndZero_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code B} and zero.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithBAndZero_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{'B', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithEighteenAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithTwentyFourAndX() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When {@code BXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenBxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("BXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(ByteString, long, long, byte[], byte[])}.
   * <ul>
   *   <li>When {@link ByteString}.</li>
   *   <li>Then return FirstTokenBalance is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(ByteString, long, long, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(ByteString, long, long, byte[], byte[])"})
  public void testNewExchangeCapsule_whenByteString_thenReturnFirstTokenBalanceIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ExchangeCapsule actualExchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0L, actualExchangeCapsule.getFirstTokenBalance());
    assertEquals(0L, actualExchangeCapsule.getSecondTokenBalance());
    assertEquals(1L, actualExchangeCapsule.getCreateTime());
    assertEquals(1L, actualExchangeCapsule.getID());
    assertSame(address, actualExchangeCapsule.getCreatorAddress());
    byte[] expectedFirstTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedFirstTokenId, actualExchangeCapsule.getFirstTokenId());
    byte[] expectedSecondTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSecondTokenId, actualExchangeCapsule.getSecondTokenId());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'B', '\b',
        'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualExchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return CreateTime is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenEmptyArrayOfByte_thenReturnCreateTimeIsZero() {
    // Arrange and Act
    ExchangeCapsule actualExchangeCapsule = new ExchangeCapsule(new byte[]{});

    // Assert
    assertEquals(0L, actualExchangeCapsule.getCreateTime());
    assertEquals(0L, actualExchangeCapsule.getFirstTokenBalance());
    assertEquals(0L, actualExchangeCapsule.getID());
    assertEquals(0L, actualExchangeCapsule.getSecondTokenBalance());
    byte[] firstTokenId = actualExchangeCapsule.getFirstTokenId();
    assertSame(firstTokenId, actualExchangeCapsule.getSecondTokenId());
    assertArrayEquals(new byte[]{}, actualExchangeCapsule.getData());
    assertArrayEquals(new byte[]{}, firstTokenId);
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When {@code HXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenHxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("HXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("\bXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#ExchangeCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#ExchangeCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.<init>(byte[])"})
  public void testNewExchangeCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link ExchangeCapsule#calculateDbKey(long)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#calculateDbKey(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.calculateDbKey(long)"})
  public void testCalculateDbKey() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1}, ExchangeCapsule.calculateDbKey(1L));
  }

  /**
   * Test {@link ExchangeCapsule#getID()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#getID()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeCapsule.getID()"})
  public void testGetID_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1L, (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).getID());
  }

  /**
   * Test {@link ExchangeCapsule#setID(long)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setID(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setID(long)"})
  public void testSetID() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.setID(1L);

    // Assert that nothing has changed
    assertEquals(1L, exchangeCapsule.getID());
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(26, instance.getSerializedSize());
    assertEquals(5, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'B', '\b',
        'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setID(long)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setID(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setID(long)"})
  public void testSetID2() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[]{});

    // Act
    exchangeCapsule.setID(1L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, exchangeCapsule.getID());
    assertEquals(1L, instance.getExchangeId());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\b', 1}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setID(long)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setID(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setID(long)"})
  public void testSetID3() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    exchangeCapsule.setID(1L);

    // Assert that nothing has changed
    assertEquals(1L, exchangeCapsule.getID());
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1L, instance.getExchangeId());
    assertEquals(30, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '8', '*',
        'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getCreatorAddress()}.
   * <p>
   * Method under test: {@link ExchangeCapsule#getCreatorAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString ExchangeCapsule.getCreatorAddress()"})
  public void testGetCreatorAddress() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    ByteString actualCreatorAddress = exchangeCapsule.getCreatorAddress();

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(7, fields.size());
    ByteString byteString = actualCreatorAddress.EMPTY;
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, fields.get(5).getDefaultValue());
    Exchange defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getCreatorAddress());
    assertSame(byteString, defaultInstanceForType.getFirstTokenId());
    assertSame(byteString, defaultInstanceForType.getSecondTokenId());
  }

  /**
   * Test {@link ExchangeCapsule#setExchangeAddress(ByteString)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setExchangeAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setExchangeAddress(ByteString)"})
  public void testSetExchangeAddress() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));
    ByteString address2 = mock(ByteString.class);

    // Act
    exchangeCapsule.setExchangeAddress(address2);

    // Assert that nothing has changed
    Exchange instance = exchangeCapsule.getInstance();
    ByteString firstTokenId = instance.getFirstTokenId();
    assertEquals("AXAXAXAX", firstTokenId.toStringUtf8());
    assertEquals(26, instance.getSerializedSize());
    assertEquals(5, instance.getAllFields().size());
    assertFalse(firstTokenId.isEmpty());
    assertTrue(firstTokenId.iterator().hasNext());
    assertEquals(firstTokenId, instance.getSecondTokenId());
    ByteString byteString = address2.EMPTY;
    Exchange defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getCreatorAddress());
    assertSame(byteString, defaultInstanceForType.getFirstTokenId());
    assertSame(byteString, defaultInstanceForType.getSecondTokenId());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'B', '\b',
        'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setExchangeAddress(ByteString)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setExchangeAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setExchangeAddress(ByteString)"})
  public void testSetExchangeAddress2() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[]{});
    ByteString address = mock(ByteString.class);

    // Act
    exchangeCapsule.setExchangeAddress(address);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    ByteString firstTokenId = instance.getFirstTokenId();
    assertEquals("", firstTokenId.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(firstTokenId.iterator().hasNext());
    assertTrue(firstTokenId.isEmpty());
    ByteString byteString = address.EMPTY;
    Exchange defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getCreatorAddress());
    assertSame(byteString, defaultInstanceForType.getFirstTokenId());
    assertSame(byteString, instance.getSecondTokenId());
    assertSame(byteString, defaultInstanceForType.getSecondTokenId());
    assertArrayEquals(new byte[]{18, 0}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setExchangeAddress(ByteString)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setExchangeAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setExchangeAddress(ByteString)"})
  public void testSetExchangeAddress3() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));
    exchangeCapsule.setBalance(42L, 42L);
    ByteString address2 = mock(ByteString.class);

    // Act
    exchangeCapsule.setExchangeAddress(address2);

    // Assert that nothing has changed
    Exchange instance = exchangeCapsule.getInstance();
    ByteString firstTokenId = instance.getFirstTokenId();
    assertEquals("AXAXAXAX", firstTokenId.toStringUtf8());
    assertEquals(30, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertFalse(firstTokenId.isEmpty());
    assertTrue(firstTokenId.iterator().hasNext());
    assertEquals(firstTokenId, instance.getSecondTokenId());
    ByteString byteString = address2.EMPTY;
    Exchange defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getCreatorAddress());
    assertSame(byteString, defaultInstanceForType.getFirstTokenId());
    assertSame(byteString, defaultInstanceForType.getSecondTokenId());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '8', '*',
        'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setBalance(long, long)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setBalance(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setBalance(long, long)"})
  public void testSetBalance() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.setBalance(42L, 42L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(30, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '8', '*',
        'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setBalance(long, long)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setBalance(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setBalance(long, long)"})
  public void testSetBalance2() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[]{});

    // Act
    exchangeCapsule.setBalance(42L, 42L);

    // Assert
    assertEquals(7, exchangeCapsule.getInstance().getDescriptorForType().getFields().size());
    byte[] expectedData = "8*H*".getBytes("UTF-8");
    assertArrayEquals(expectedData, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setBalance(long, long)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setBalance(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setBalance(long, long)"})
  public void testSetBalance3() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Act
    exchangeCapsule.setBalance(42L, 42L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(30, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '8', '*',
        'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setBalance(long, long)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setBalance(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setBalance(long, long)"})
  public void testSetBalance4() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[]{});
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 16L, true);

    // Act
    exchangeCapsule.setBalance(42L, 42L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    byte[] expectedData = "8*H*".getBytes("UTF-8");
    assertArrayEquals(expectedData, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getCreateTime()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#getCreateTime()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeCapsule.getCreateTime()"})
  public void testGetCreateTime_thenReturnOne() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1L,
        (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).getCreateTime());
  }

  /**
   * Test {@link ExchangeCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setCreateTime(long)"})
  public void testSetCreateTime() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(26, instance.getSerializedSize());
    assertEquals(5, instance.getAllFields().size());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, '\n', '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'B', '\b',
        'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setCreateTime(long)"})
  public void testSetCreateTime2() {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[]{});

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, '\n'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setCreateTime(long)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setCreateTime(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setCreateTime(long)"})
  public void testSetCreateTime3() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    exchangeCapsule.setCreateTime(10L);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(30, instance.getSerializedSize());
    assertEquals(7, instance.getDescriptorForType().getFields().size());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, '\n', '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '8', '*',
        'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getFirstTokenId()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#getFirstTokenId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.getFirstTokenId()"})
  public void testGetFirstTokenId_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualFirstTokenId = (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8")))
        .getFirstTokenId();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualFirstTokenId);
  }

  /**
   * Test {@link ExchangeCapsule#getFirstTokenId()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#getFirstTokenId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.getFirstTokenId()"})
  public void testGetFirstTokenId_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new ExchangeCapsule(new byte[]{})).getFirstTokenId());
  }

  /**
   * Test {@link ExchangeCapsule#setFirstTokenId(byte[])}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setFirstTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setFirstTokenId(byte[])"})
  public void testSetFirstTokenId() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.setFirstTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    Exchange instance = exchangeCapsule.getInstance();
    ByteString firstTokenId = instance.getFirstTokenId();
    assertEquals("AXAXAXAX", firstTokenId.toStringUtf8());
    assertEquals(26, instance.getSerializedSize());
    assertEquals(5, instance.getAllFields().size());
    assertFalse(firstTokenId.isEmpty());
    ByteIterator iteratorResult = firstTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedFirstTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedFirstTokenId, exchangeCapsule.getFirstTokenId());
    byte[] expectedSecondTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSecondTokenId, exchangeCapsule.getSecondTokenId());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'B', '\b',
        'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setFirstTokenId(byte[])}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setFirstTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setFirstTokenId(byte[])"})
  public void testSetFirstTokenId2() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[]{});

    // Act
    exchangeCapsule.setFirstTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    ByteString firstTokenId = instance.getFirstTokenId();
    assertEquals("AXAXAXAX", firstTokenId.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertFalse(firstTokenId.isEmpty());
    ByteIterator iteratorResult = firstTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedData = "2\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, exchangeCapsule.getData());
    byte[] expectedFirstTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedFirstTokenId, exchangeCapsule.getFirstTokenId());
    assertArrayEquals(new byte[]{}, exchangeCapsule.getSecondTokenId());
  }

  /**
   * Test {@link ExchangeCapsule#setFirstTokenId(byte[])}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setFirstTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setFirstTokenId(byte[])"})
  public void testSetFirstTokenId3() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    exchangeCapsule.setFirstTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    Exchange instance = exchangeCapsule.getInstance();
    ByteString firstTokenId = instance.getFirstTokenId();
    assertEquals("AXAXAXAX", firstTokenId.toStringUtf8());
    assertEquals(30, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    assertFalse(firstTokenId.isEmpty());
    ByteIterator iteratorResult = firstTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedFirstTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedFirstTokenId, exchangeCapsule.getFirstTokenId());
    byte[] expectedSecondTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSecondTokenId, exchangeCapsule.getSecondTokenId());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '8', '*',
        'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getSecondTokenId()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#getSecondTokenId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.getSecondTokenId()"})
  public void testGetSecondTokenId_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualSecondTokenId = (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8")))
        .getSecondTokenId();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualSecondTokenId);
  }

  /**
   * Test {@link ExchangeCapsule#getSecondTokenId()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#getSecondTokenId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.getSecondTokenId()"})
  public void testGetSecondTokenId_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new ExchangeCapsule(new byte[]{})).getSecondTokenId());
  }

  /**
   * Test {@link ExchangeCapsule#setSecondTokenId(byte[])}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setSecondTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setSecondTokenId(byte[])"})
  public void testSetSecondTokenId() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.setSecondTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(26, instance.getSerializedSize());
    assertEquals(5, instance.getAllFields().size());
    byte[] expectedSecondTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSecondTokenId, exchangeCapsule.getSecondTokenId());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'B', '\b',
        'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setSecondTokenId(byte[])}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setSecondTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setSecondTokenId(byte[])"})
  public void testSetSecondTokenId2() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[]{});

    // Act
    exchangeCapsule.setSecondTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    ByteString secondTokenId = instance.getSecondTokenId();
    assertEquals("AXAXAXAX", secondTokenId.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10, instance.getSerializedSize());
    assertFalse(secondTokenId.isEmpty());
    ByteIterator iteratorResult = secondTokenId.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals('X', iteratorResult.next().byteValue());
    byte[] expectedSecondTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSecondTokenId, exchangeCapsule.getSecondTokenId());
    byte[] expectedData = "B\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#setSecondTokenId(byte[])}.
   * <p>
   * Method under test: {@link ExchangeCapsule#setSecondTokenId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.setSecondTokenId(byte[])"})
  public void testSetSecondTokenId3() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    exchangeCapsule.setSecondTokenId("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(30, instance.getSerializedSize());
    assertEquals(7, instance.getAllFields().size());
    byte[] expectedSecondTokenId = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedSecondTokenId, exchangeCapsule.getSecondTokenId());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '8', '*',
        'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#getFirstTokenBalance()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#getFirstTokenBalance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeCapsule.getFirstTokenBalance()"})
  public void testGetFirstTokenBalance_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L,
        (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).getFirstTokenBalance());
  }

  /**
   * Test {@link ExchangeCapsule#getSecondTokenBalance()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#getSecondTokenBalance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeCapsule.getSecondTokenBalance()"})
  public void testGetSecondTokenBalance_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0L,
        (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).getSecondTokenBalance());
  }

  /**
   * Test {@link ExchangeCapsule#createDbKey()}.
   * <ul>
   *   <li>Then return array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnArrayOfByteWithZeroAndZero() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1},
        (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).createDbKey());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    assertEquals(1L, exchangeCapsule.getFirstTokenBalance());
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1L, instance.getFirstTokenBalance());
    assertEquals(28, instance.getSerializedSize());
    assertEquals(6, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '8', 1, 'B',
        '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction2() throws UnsupportedEncodingException {
    // Arrange
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(new byte[]{});

    // Act
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    assertEquals(0L, exchangeCapsule.getFirstTokenBalance());
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(0L, instance.getFirstTokenBalance());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, exchangeCapsule.getSecondTokenBalance());
    assertEquals(1L, instance.getSecondTokenBalance());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'H', 1}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   * <p>
   * Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction3() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, true);

    // Assert
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(30, instance.getSerializedSize());
    assertEquals(43L, exchangeCapsule.getFirstTokenBalance());
    assertEquals(43L, instance.getFirstTokenBalance());
    assertEquals(7, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '8', '+',
        'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', '*'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#transaction(byte[], long, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#transaction(byte[], long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ExchangeCapsule.transaction(byte[], long, boolean)"})
  public void testTransaction_whenFalse() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");
    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    exchangeCapsule.transaction("AXAXAXAX".getBytes("UTF-8"), 1L, false);

    // Assert
    assertEquals(1L, exchangeCapsule.getFirstTokenBalance());
    Exchange instance = exchangeCapsule.getInstance();
    assertEquals(1L, instance.getFirstTokenBalance());
    assertEquals(28, instance.getSerializedSize());
    assertEquals(6, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\b', 1, 18, 0, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '8', 1, 'B',
        '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, exchangeCapsule.getData());
  }

  /**
   * Test {@link ExchangeCapsule#resetTokenWithID(AssetIssueStore, DynamicPropertiesStore)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link DynamicPropertiesStore#getAllowSameTokenName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#resetTokenWithID(AssetIssueStore, DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExchangeCapsule.resetTokenWithID(AssetIssueStore, DynamicPropertiesStore)"})
  public void testResetTokenWithID_givenOne_thenCallsGetAllowSameTokenName() throws UnsupportedEncodingException {
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
   * <p>
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualData = (new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'B', '\b', 'A', 'X',
        'A', 'X', 'A', 'X', 'A', 'X'}, actualData);
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   * <p>
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData2() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualData = (new ExchangeCapsule(address, 1L, 0L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'B', '\b', 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualData);
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   * <p>
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData3() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ExchangeCapsule(address, 1L, 1L, new byte[]{}, "AXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, 24, 1, 'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualData);
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   * <p>
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData4() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new ExchangeCapsule(address, 1L, 1L, "AXAXAXAX".getBytes("UTF-8"), new byte[]{})).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualData);
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   * <p>
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData5() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    ExchangeCapsule exchangeCapsule = new ExchangeCapsule(address, 1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"));
    exchangeCapsule.setBalance(42L, 42L);

    // Act
    byte[] actualData = exchangeCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', 1, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', '8', '*', 'B', '\b',
        'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'H', '*'}, actualData);
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and {@link Byte#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithBackspaceAndMin_value() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualData = (new ExchangeCapsule(address, 1000000000000000000L, 1L, firstTokenID,
        "AXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', Byte.MIN_VALUE, Byte.MIN_VALUE, -112, -69, -70, -42, -83, -16, '\r', 24, 1, '2',
        '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualData);
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithBackspaceAndMinusOne() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualData = (new ExchangeCapsule(address, -1L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A',
        'X', 'A', 'X', 'B', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, actualData);
  }

  /**
   * Test {@link ExchangeCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ExchangeCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndOne() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    byte[] firstTokenID = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualData = (new ExchangeCapsule(address, 0L, 1L, firstTokenID, "AXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, 1, '2', '\b', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'B', '\b', 'A', 'X', 'A',
        'X', 'A', 'X', 'A', 'X'}, actualData);
  }

  /**
   * Test {@link ExchangeCapsule#getInstance()}.
   * <ul>
   *   <li>Given {@link ExchangeCapsule#ExchangeCapsule(byte[])} with data is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExchangeCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Exchange ExchangeCapsule.getInstance()"})
  public void testGetInstance_givenExchangeCapsuleWithDataIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new ExchangeCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }
}
