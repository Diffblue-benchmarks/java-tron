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
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Witness;

public class WitnessCapsuleDiffblueTest {
  /**
   * Test {@link WitnessCapsule#WitnessCapsule(ByteString, String)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(ByteString, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(ByteString, String)"})
  public void testNewWitnessCapsule_givenA() {
    // Arrange
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.toByteArray()).thenReturn(new byte[]{4, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    WitnessCapsule actualWitnessCapsule = new WitnessCapsule(pubKey, "https://example.org/example");

    // Assert
    verify(pubKey).toByteArray();
    assertEquals("https://example.org/example", actualWitnessCapsule.getUrl());
    assertEquals(0L, actualWitnessCapsule.getLatestBlockNum());
    assertEquals(0L, actualWitnessCapsule.getLatestSlotNum());
    assertEquals(0L, actualWitnessCapsule.getTotalMissed());
    assertEquals(0L, actualWitnessCapsule.getTotalProduced());
    assertEquals(0L, actualWitnessCapsule.getVoteCount());
    assertFalse(actualWitnessCapsule.getIsJobs());
    assertArrayEquals(new byte[]{'\n', 21, 'A', 19, -117, -77, 'l', 'I', -90, ')', -16, 27, '!', 'a', '+', 17, 'Q', -31,
        -24, -124, '5', -121, -26, 26, 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, actualWitnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(ByteString, String)}.
   * <ul>
   *   <li>Then return Url is {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(ByteString, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(ByteString, String)"})
  public void testNewWitnessCapsule_thenReturnUrlIsHttpsExampleOrgExample() throws UnsupportedEncodingException {
    // Arrange
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    WitnessCapsule actualWitnessCapsule = new WitnessCapsule(pubKey, "https://example.org/example");

    // Assert
    verify(pubKey).toByteArray();
    assertEquals("https://example.org/example", actualWitnessCapsule.getUrl());
    assertEquals(0L, actualWitnessCapsule.getLatestBlockNum());
    assertEquals(0L, actualWitnessCapsule.getLatestSlotNum());
    assertEquals(0L, actualWitnessCapsule.getTotalMissed());
    assertEquals(0L, actualWitnessCapsule.getTotalProduced());
    assertEquals(0L, actualWitnessCapsule.getVoteCount());
    assertFalse(actualWitnessCapsule.getIsJobs());
    assertArrayEquals(new byte[]{'\n', 21, 'A', 19, -117, -77, 'l', 'I', -90, ')', -16, 27, '!', 'a', '+', 17, 'Q', -31,
        -24, -124, '5', -121, -26, 26, 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, actualWitnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_when0xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("0XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 8XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_when8xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("8XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithLfAndZero_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code "} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithQuotationMarkAndZero() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithSixteenAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithTwentySixAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(ByteString)}.
   * <ul>
   *   <li>When {@link ByteString}.</li>
   *   <li>Then return Url is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(ByteString)"})
  public void testNewWitnessCapsule_whenByteString_thenReturnUrlIsEmptyString() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act
    WitnessCapsule actualWitnessCapsule = new WitnessCapsule(address);

    // Assert
    assertEquals("", actualWitnessCapsule.getUrl());
    assertEquals(0L, actualWitnessCapsule.getLatestBlockNum());
    assertEquals(0L, actualWitnessCapsule.getLatestSlotNum());
    assertEquals(0L, actualWitnessCapsule.getTotalMissed());
    assertEquals(0L, actualWitnessCapsule.getTotalProduced());
    assertEquals(0L, actualWitnessCapsule.getVoteCount());
    assertFalse(actualWitnessCapsule.getIsJobs());
    assertSame(address, actualWitnessCapsule.getAddress());
    assertArrayEquals(new byte[]{'\n', 0}, actualWitnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(ByteString, long, String)}.
   * <ul>
   *   <li>When {@link ByteString}.</li>
   *   <li>Then return Url is {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(ByteString, long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(ByteString, long, String)"})
  public void testNewWitnessCapsule_whenByteString_thenReturnUrlIsHttpsExampleOrgExample() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act
    WitnessCapsule actualWitnessCapsule = new WitnessCapsule(address, 3L, "https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", actualWitnessCapsule.getUrl());
    assertEquals(0L, actualWitnessCapsule.getLatestBlockNum());
    assertEquals(0L, actualWitnessCapsule.getLatestSlotNum());
    assertEquals(0L, actualWitnessCapsule.getTotalMissed());
    assertEquals(0L, actualWitnessCapsule.getTotalProduced());
    assertEquals(3L, actualWitnessCapsule.getVoteCount());
    assertFalse(actualWitnessCapsule.getIsJobs());
    assertSame(address, actualWitnessCapsule.getAddress());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm',
        'p', 'l', 'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, actualWitnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Url is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenEmptyArrayOfByte_thenReturnUrlIsEmptyString() {
    // Arrange and Act
    WitnessCapsule actualWitnessCapsule = new WitnessCapsule(new byte[]{});

    // Assert
    assertEquals("", actualWitnessCapsule.getUrl());
    assertEquals(0L, actualWitnessCapsule.getLatestBlockNum());
    assertEquals(0L, actualWitnessCapsule.getLatestSlotNum());
    assertEquals(0L, actualWitnessCapsule.getTotalMissed());
    assertEquals(0L, actualWitnessCapsule.getTotalProduced());
    assertEquals(0L, actualWitnessCapsule.getVoteCount());
    assertFalse(actualWitnessCapsule.getIsJobs());
    assertArrayEquals(new byte[]{}, actualWitnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When {@code HXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenHxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("HXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When {@code "XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("\"XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When {@code (XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("(XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When {@code @XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull4()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("@XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new WitnessCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#compareTo(WitnessCapsule)} with {@code WitnessCapsule}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#compareTo(WitnessCapsule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int WitnessCapsule.compareTo(WitnessCapsule)"})
  public void testCompareToWithWitnessCapsule_thenReturnZero() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act and Assert
    assertEquals(0, witnessCapsule.compareTo(new WitnessCapsule(mock(ByteString.class))));
  }

  /**
   * Test {@link WitnessCapsule#getAddress()}.
   * <p>
   * Method under test: {@link WitnessCapsule#getAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString WitnessCapsule.getAddress()"})
  public void testGetAddress() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    ByteString actualAddress = witnessCapsule.getAddress();

    // Assert
    Witness instance = witnessCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(9, fields.size());
    ByteString byteString = actualAddress.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAddress());
    assertSame(byteString, instance.getPubKey());
    assertSame(byteString, defaultInstanceForType.getPubKey());
  }

  /**
   * Test {@link WitnessCapsule#createDbKey()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = (new WitnessCapsule(address)).createDbKey();

    // Assert
    verify(address).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Test {@link WitnessCapsule#createDbKey()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new WitnessCapsule(new byte[]{})).createDbKey());
  }

  /**
   * Test {@link WitnessCapsule#createReadableString()}.
   * <ul>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#createReadableString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String WitnessCapsule.createReadableString()"})
  public void testCreateReadableString_thenReturn4158415841584158() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualCreateReadableStringResult = (new WitnessCapsule(address)).createReadableString();

    // Assert
    verify(address).toByteArray();
    assertEquals("4158415841584158", actualCreateReadableStringResult);
  }

  /**
   * Test {@link WitnessCapsule#createReadableString()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#createReadableString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String WitnessCapsule.createReadableString()"})
  public void testCreateReadableString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new WitnessCapsule(new byte[]{})).createReadableString());
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_givenWitnessCapsuleWithAddressIsByteString() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new WitnessCapsule(address)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(byte[])} with data is empty array of {@code byte} PubKey is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_givenWitnessCapsuleWithDataIsEmptyArrayOfBytePubKeyIsByteString() {
    // Arrange
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   * <ul>
   *   <li>Then return {@code "6https://example.org/examplehttps://example.org/example} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_thenReturn6httpsExampleOrgExamplehttpsExampleOrgExampleBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setUrl("https://example.org/examplehttps://example.org/example");
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals("\"6https://example.org/examplehttps://example.org/example".getBytes("UTF-8"), actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code 0} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWith0AndMinusOne() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setTotalMissed(-1L);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'0', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code 8} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWith8AndMinusOne() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setLatestBlockNum(-1L);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'8', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code @} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithCommercialAtAndMinusOne() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setLatestSlotNum(-1L);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'@', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code H} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithHAndOne() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setIsJobs(true);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'H', 1}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code (} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithLeftParenthesisAndMinusOne() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setTotalProduced(-1L);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'(', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@code "} and twenty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithQuotationMarkAndTwentySeven() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setUrl("https://example.org/example");
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{'"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e',
        '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with sixteen and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithSixteenAndMinusOne() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setVoteCount(Long.MAX_VALUE);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{16, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with sixteen and three.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithSixteenAndThree() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setVoteCount(3L);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{16, 3}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);
    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getInstance()}.
   * <p>
   * Method under test: {@link WitnessCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Witness WitnessCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    Witness actualInstance = (new WitnessCapsule(mock(ByteString.class))).getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals("", actualInstance.getUrl());
    assertEquals(0L, actualInstance.getLatestBlockNum());
    assertEquals(0L, actualInstance.getLatestSlotNum());
    assertEquals(0L, actualInstance.getTotalMissed());
    assertEquals(0L, actualInstance.getTotalProduced());
    assertEquals(0L, actualInstance.getVoteCount());
    assertEquals(1, actualInstance.getAllFields().size());
    assertEquals(2, actualInstance.getSerializedSize());
    assertFalse(actualInstance.getIsJobs());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    assertTrue(actualInstance.isInitialized());
  }

  /**
   * Test {@link WitnessCapsule#setPubKey(ByteString)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setPubKey(ByteString)"})
  public void testSetPubKey() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    ByteString address = defaultInstanceForType.getAddress();
    assertEquals("", address.toStringUtf8());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertFalse(address.iterator().hasNext());
    assertTrue(address.isEmpty());
    ByteString expectedPubKey = pubKey.EMPTY;
    assertSame(expectedPubKey, defaultInstanceForType.getPubKey());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setPubKey(ByteString)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setPubKey(ByteString)"})
  public void testSetPubKey2() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    ByteString address = defaultInstanceForType.getAddress();
    assertEquals("", address.toStringUtf8());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertFalse(address.iterator().hasNext());
    assertTrue(address.isEmpty());
    ByteString expectedPubKey = pubKey.EMPTY;
    assertSame(expectedPubKey, defaultInstanceForType.getPubKey());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm',
        'p', 'l', 'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setPubKey(ByteString)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setPubKey(ByteString)"})
  public void testSetPubKey3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    ByteString expectedPubKey = pubKey.EMPTY;
    assertSame(expectedPubKey, instance.getDefaultInstanceForType().getPubKey());
    assertArrayEquals(new byte[]{26, 0}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setPubKey(ByteString)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setPubKey(ByteString)"})
  public void testSetPubKey4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    ByteString expectedPubKey = pubKey.EMPTY;
    assertSame(expectedPubKey, instance.getDefaultInstanceForType().getPubKey());
    assertArrayEquals(
        new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setPubKey(ByteString)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} IsJobs is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setPubKey(ByteString)"})
  public void testSetPubKey_givenWitnessCapsuleWithAddressIsByteStringIsJobsIsTrue() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    ByteString address = defaultInstanceForType.getAddress();
    assertEquals("", address.toStringUtf8());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(address.iterator().hasNext());
    assertTrue(address.isEmpty());
    ByteString expectedPubKey = pubKey.EMPTY;
    assertSame(expectedPubKey, defaultInstanceForType.getPubKey());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setPubKey(ByteString)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} LatestBlockNum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setPubKey(ByteString)"})
  public void testSetPubKey_givenWitnessCapsuleWithAddressIsByteStringLatestBlockNumIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    ByteString address = defaultInstanceForType.getAddress();
    assertEquals("", address.toStringUtf8());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(address.iterator().hasNext());
    assertTrue(address.isEmpty());
    ByteString expectedPubKey = pubKey.EMPTY;
    assertSame(expectedPubKey, defaultInstanceForType.getPubKey());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, '8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setPubKey(ByteString)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} LatestSlotNum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setPubKey(ByteString)"})
  public void testSetPubKey_givenWitnessCapsuleWithAddressIsByteStringLatestSlotNumIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    ByteString address = defaultInstanceForType.getAddress();
    assertEquals("", address.toStringUtf8());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(address.iterator().hasNext());
    assertTrue(address.isEmpty());
    ByteString expectedPubKey = pubKey.EMPTY;
    assertSame(expectedPubKey, defaultInstanceForType.getPubKey());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setPubKey(ByteString)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} TotalMissed is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setPubKey(ByteString)"})
  public void testSetPubKey_givenWitnessCapsuleWithAddressIsByteStringTotalMissedIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    ByteString address = defaultInstanceForType.getAddress();
    assertEquals("", address.toStringUtf8());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(address.iterator().hasNext());
    assertTrue(address.isEmpty());
    ByteString expectedPubKey = pubKey.EMPTY;
    assertSame(expectedPubKey, defaultInstanceForType.getPubKey());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, '0', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setPubKey(ByteString)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} TotalProduced is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setPubKey(ByteString)"})
  public void testSetPubKey_givenWitnessCapsuleWithAddressIsByteStringTotalProducedIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    ByteString address = defaultInstanceForType.getAddress();
    assertEquals("", address.toStringUtf8());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(address.iterator().hasNext());
    assertTrue(address.isEmpty());
    ByteString expectedPubKey = pubKey.EMPTY;
    assertSame(expectedPubKey, defaultInstanceForType.getPubKey());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, '(', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setPubKey(ByteString)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} VoteCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setPubKey(ByteString)"})
  public void testSetPubKey_givenWitnessCapsuleWithAddressIsByteStringVoteCountIsThree() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);
    ByteString pubKey = mock(ByteString.class);

    // Act
    witnessCapsule.setPubKey(pubKey);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    ByteString address = defaultInstanceForType.getAddress();
    assertEquals("", address.toStringUtf8());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(address.iterator().hasNext());
    assertTrue(address.isEmpty());
    ByteString expectedPubKey = pubKey.EMPTY;
    assertSame(expectedPubKey, defaultInstanceForType.getPubKey());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, 26, 0}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getVoteCount()}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getVoteCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long WitnessCapsule.getVoteCount()"})
  public void testGetVoteCount_givenWitnessCapsuleWithAddressIsByteString_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new WitnessCapsule(mock(ByteString.class))).getVoteCount());
  }

  /**
   * Test {@link WitnessCapsule#setVoteCount(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setVoteCount(long)"})
  public void testSetVoteCount() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setVoteCount(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setVoteCount(long)"})
  public void testSetVoteCount2() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm',
        'p', 'l', 'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setVoteCount(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setVoteCount(long)"})
  public void testSetVoteCount3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{16, 3}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setVoteCount(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setVoteCount(long)"})
  public void testSetVoteCount4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{16, 3, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setVoteCount(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} IsJobs is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setVoteCount(long)"})
  public void testSetVoteCount_givenWitnessCapsuleWithAddressIsByteStringIsJobsIsTrue() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setVoteCount(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} LatestBlockNum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setVoteCount(long)"})
  public void testSetVoteCount_givenWitnessCapsuleWithAddressIsByteStringLatestBlockNumIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, '8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setVoteCount(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} LatestSlotNum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setVoteCount(long)"})
  public void testSetVoteCount_givenWitnessCapsuleWithAddressIsByteStringLatestSlotNumIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setVoteCount(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} PubKey is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setVoteCount(long)"})
  public void testSetVoteCount_givenWitnessCapsuleWithAddressIsByteStringPubKeyIsByteString() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, 26, 0}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setVoteCount(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} TotalMissed is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setVoteCount(long)"})
  public void testSetVoteCount_givenWitnessCapsuleWithAddressIsByteStringTotalMissedIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, '0', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setVoteCount(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} TotalProduced is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setVoteCount(long)"})
  public void testSetVoteCount_givenWitnessCapsuleWithAddressIsByteStringTotalProducedIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, '(', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getTotalProduced()}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getTotalProduced()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long WitnessCapsule.getTotalProduced()"})
  public void testGetTotalProduced_givenWitnessCapsuleWithAddressIsByteString_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new WitnessCapsule(mock(ByteString.class))).getTotalProduced());
  }

  /**
   * Test {@link WitnessCapsule#setTotalProduced(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalProduced(long)"})
  public void testSetTotalProduced() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalProduced(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalProduced(long)"})
  public void testSetTotalProduced2() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, '(', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalProduced(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalProduced(long)"})
  public void testSetTotalProduced3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1, '8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalProduced(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalProduced(long)"})
  public void testSetTotalProduced4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1, '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalProduced(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalProduced(long)"})
  public void testSetTotalProduced5() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', '(', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalProduced(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalProduced(long)"})
  public void testSetTotalProduced6() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'(', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalProduced(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalProduced(long)"})
  public void testSetTotalProduced7() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'(', 1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalProduced(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} IsJobs is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalProduced(long)"})
  public void testSetTotalProduced_givenWitnessCapsuleWithAddressIsByteStringIsJobsIsTrue() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalProduced(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} TotalMissed is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalProduced(long)"})
  public void testSetTotalProduced_givenWitnessCapsuleWithAddressIsByteStringTotalMissedIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1, '0', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalProduced(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} VoteCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalProduced(long)"})
  public void testSetTotalProduced_givenWitnessCapsuleWithAddressIsByteStringVoteCountIsThree() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, '(', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getTotalMissed()}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getTotalMissed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long WitnessCapsule.getTotalMissed()"})
  public void testGetTotalMissed_givenWitnessCapsuleWithAddressIsByteString_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new WitnessCapsule(mock(ByteString.class))).getTotalMissed());
  }

  /**
   * Test {@link WitnessCapsule#setTotalMissed(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalMissed(long)"})
  public void testSetTotalMissed() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '0', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalMissed(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalMissed(long)"})
  public void testSetTotalMissed2() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', '0', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalMissed(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalMissed(long)"})
  public void testSetTotalMissed3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'0', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalMissed(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalMissed(long)"})
  public void testSetTotalMissed4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'0', 1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalMissed(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} IsJobs is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalMissed(long)"})
  public void testSetTotalMissed_givenWitnessCapsuleWithAddressIsByteStringIsJobsIsTrue() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '0', 1, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalMissed(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} LatestBlockNum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalMissed(long)"})
  public void testSetTotalMissed_givenWitnessCapsuleWithAddressIsByteStringLatestBlockNumIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '0', 1, '8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalMissed(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} LatestSlotNum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalMissed(long)"})
  public void testSetTotalMissed_givenWitnessCapsuleWithAddressIsByteStringLatestSlotNumIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '0', 1, '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalMissed(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} PubKey is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalMissed(long)"})
  public void testSetTotalMissed_givenWitnessCapsuleWithAddressIsByteStringPubKeyIsByteString() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, '0', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalMissed(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} TotalProduced is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalMissed(long)"})
  public void testSetTotalMissed_givenWitnessCapsuleWithAddressIsByteStringTotalProducedIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1, '0', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setTotalMissed(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} VoteCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setTotalMissed(long)"})
  public void testSetTotalMissed_givenWitnessCapsuleWithAddressIsByteStringVoteCountIsThree() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, '0', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getLatestBlockNum()}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getLatestBlockNum()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long WitnessCapsule.getLatestBlockNum()"})
  public void testGetLatestBlockNum_givenWitnessCapsuleWithAddressIsByteString_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new WitnessCapsule(mock(ByteString.class))).getLatestBlockNum());
  }

  /**
   * Test {@link WitnessCapsule#setLatestBlockNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestBlockNum(long)"})
  public void testSetLatestBlockNum() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestBlockNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestBlockNum(long)"})
  public void testSetLatestBlockNum2() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, '8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestBlockNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestBlockNum(long)"})
  public void testSetLatestBlockNum3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1, '8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestBlockNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestBlockNum(long)"})
  public void testSetLatestBlockNum4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '8', 1, '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestBlockNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestBlockNum(long)"})
  public void testSetLatestBlockNum5() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', '8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestBlockNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestBlockNum(long)"})
  public void testSetLatestBlockNum6() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestBlockNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestBlockNum(long)"})
  public void testSetLatestBlockNum7() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'8', 1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestBlockNum(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} IsJobs is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestBlockNum(long)"})
  public void testSetLatestBlockNum_givenWitnessCapsuleWithAddressIsByteStringIsJobsIsTrue() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '8', 1, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestBlockNum(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} TotalMissed is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestBlockNum(long)"})
  public void testSetLatestBlockNum_givenWitnessCapsuleWithAddressIsByteStringTotalMissedIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '0', 1, '8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestBlockNum(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} VoteCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestBlockNum(long)"})
  public void testSetLatestBlockNum_givenWitnessCapsuleWithAddressIsByteStringVoteCountIsThree() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, '8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getLatestSlotNum()}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getLatestSlotNum()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long WitnessCapsule.getLatestSlotNum()"})
  public void testGetLatestSlotNum_givenWitnessCapsuleWithAddressIsByteString_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new WitnessCapsule(mock(ByteString.class))).getLatestSlotNum());
  }

  /**
   * Test {@link WitnessCapsule#setLatestSlotNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestSlotNum(long)"})
  public void testSetLatestSlotNum() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestSlotNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestSlotNum(long)"})
  public void testSetLatestSlotNum2() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestSlotNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestSlotNum(long)"})
  public void testSetLatestSlotNum3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1, '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestSlotNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestSlotNum(long)"})
  public void testSetLatestSlotNum4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '8', 1, '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestSlotNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestSlotNum(long)"})
  public void testSetLatestSlotNum5() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestSlotNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestSlotNum(long)"})
  public void testSetLatestSlotNum6() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestSlotNum(long)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestSlotNum(long)"})
  public void testSetLatestSlotNum7() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'@', 1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestSlotNum(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} IsJobs is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestSlotNum(long)"})
  public void testSetLatestSlotNum_givenWitnessCapsuleWithAddressIsByteStringIsJobsIsTrue() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '@', 1, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestSlotNum(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} TotalMissed is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestSlotNum(long)"})
  public void testSetLatestSlotNum_givenWitnessCapsuleWithAddressIsByteStringTotalMissedIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '0', 1, '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setLatestSlotNum(long)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} VoteCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setLatestSlotNum(long)"})
  public void testSetLatestSlotNum_givenWitnessCapsuleWithAddressIsByteStringVoteCountIsThree() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getIsJobs()}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getIsJobs()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessCapsule.getIsJobs()"})
  public void testGetIsJobs_givenWitnessCapsuleWithAddressIsByteString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new WitnessCapsule(mock(ByteString.class))).getIsJobs());
  }

  /**
   * Test {@link WitnessCapsule#getIsJobs()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getIsJobs()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WitnessCapsule.getIsJobs()"})
  public void testGetIsJobs_thenReturnTrue() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act and Assert
    assertTrue(witnessCapsule.getIsJobs());
  }

  /**
   * Test {@link WitnessCapsule#setIsJobs(boolean)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setIsJobs(boolean)"})
  public void testSetIsJobs() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setIsJobs(boolean)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setIsJobs(boolean)"})
  public void testSetIsJobs2() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setUrl("https://example.org/example");

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setIsJobs(boolean)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setIsJobs(boolean)"})
  public void testSetIsJobs3() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setIsJobs(boolean)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setIsJobs(boolean)"})
  public void testSetIsJobs4() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{'H', 1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setIsJobs(boolean)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} LatestBlockNum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setIsJobs(boolean)"})
  public void testSetIsJobs_givenWitnessCapsuleWithAddressIsByteStringLatestBlockNumIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '8', 1, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setIsJobs(boolean)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} LatestSlotNum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setIsJobs(boolean)"})
  public void testSetIsJobs_givenWitnessCapsuleWithAddressIsByteStringLatestSlotNumIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '@', 1, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setIsJobs(boolean)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} PubKey is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setIsJobs(boolean)"})
  public void testSetIsJobs_givenWitnessCapsuleWithAddressIsByteStringPubKeyIsByteString() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setIsJobs(boolean)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} TotalMissed is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setIsJobs(boolean)"})
  public void testSetIsJobs_givenWitnessCapsuleWithAddressIsByteStringTotalMissedIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '0', 1, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setIsJobs(boolean)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} TotalProduced is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setIsJobs(boolean)"})
  public void testSetIsJobs_givenWitnessCapsuleWithAddressIsByteStringTotalProducedIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '(', 1, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setIsJobs(boolean)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} VoteCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setIsJobs(boolean)"})
  public void testSetIsJobs_givenWitnessCapsuleWithAddressIsByteStringVoteCountIsThree() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);

    // Act
    witnessCapsule.setIsJobs(true);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getUrl()}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#getUrl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String WitnessCapsule.getUrl()"})
  public void testGetUrl_givenWitnessCapsuleWithAddressIsByteString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new WitnessCapsule(mock(ByteString.class))).getUrl());
  }

  /**
   * Test {@link WitnessCapsule#setUrl(String)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setUrl(String)"})
  public void testSetUrl() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[]{});

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(29, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e',
        '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setUrl(String)}.
   * <p>
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setUrl(String)"})
  public void testSetUrl2() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(45, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e',
        '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X',
        'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setUrl(String)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} IsJobs is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setUrl(String)"})
  public void testSetUrl_givenWitnessCapsuleWithAddressIsByteStringIsJobsIsTrue() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setIsJobs(true);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setUrl(String)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} LatestBlockNum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setUrl(String)"})
  public void testSetUrl_givenWitnessCapsuleWithAddressIsByteStringLatestBlockNumIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestBlockNum(1L);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', '8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setUrl(String)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} LatestSlotNum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setUrl(String)"})
  public void testSetUrl_givenWitnessCapsuleWithAddressIsByteStringLatestSlotNumIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setLatestSlotNum(1L);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setUrl(String)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} PubKey is {@link ByteString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setUrl(String)"})
  public void testSetUrl_givenWitnessCapsuleWithAddressIsByteStringPubKeyIsByteString() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setPubKey(mock(ByteString.class));

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm',
        'p', 'l', 'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setUrl(String)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} TotalMissed is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setUrl(String)"})
  public void testSetUrl_givenWitnessCapsuleWithAddressIsByteStringTotalMissedIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalMissed(1L);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', '0', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setUrl(String)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} TotalProduced is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setUrl(String)"})
  public void testSetUrl_givenWitnessCapsuleWithAddressIsByteStringTotalProducedIsOne() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setTotalProduced(1L);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', '(', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setUrl(String)}.
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} VoteCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setUrl(String)"})
  public void testSetUrl_givenWitnessCapsuleWithAddressIsByteStringVoteCountIsThree() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));
    witnessCapsule.setVoteCount(3L);

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(33, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 16, 3, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm',
        'p', 'l', 'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#setUrl(String)}.
   * <ul>
   *   <li>Then {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link ByteString} Instance AllFields size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WitnessCapsule.setUrl(String)"})
  public void testSetUrl_thenWitnessCapsuleWithAddressIsByteStringInstanceAllFieldsSizeIsTwo() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(31, instance.getSerializedSize());
    assertEquals(9, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
        'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'}, witnessCapsule.getData());
  }
}
