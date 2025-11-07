package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.DelegatedResource;

public class DelegatedResourceCapsuleDiffblueTest {
  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(ByteString, ByteString)}.
   * <ul>
   *   <li>Then return ExpireTimeForBandwidth is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(ByteString, ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(ByteString, ByteString)"})
  public void testNewDelegatedResourceCapsule_thenReturnExpireTimeForBandwidthIsZero() {
    // Arrange
    ByteString from = mock(ByteString.class);
    ByteString resultTo = mock(ByteString.class);

    // Act
    DelegatedResourceCapsule actualDelegatedResourceCapsule = new DelegatedResourceCapsule(from, resultTo);

    // Assert
    assertEquals(0L, actualDelegatedResourceCapsule.getExpireTimeForBandwidth());
    assertEquals(0L, actualDelegatedResourceCapsule.getExpireTimeForEnergy());
    assertEquals(0L, actualDelegatedResourceCapsule.getFrozenBalanceForBandwidth());
    assertEquals(0L, actualDelegatedResourceCapsule.getFrozenBalanceForEnergy());
    assertSame(from, actualDelegatedResourceCapsule.getFrom());
    assertSame(resultTo, actualDelegatedResourceCapsule.getTo());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, actualDelegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>Then return ExpireTimeForBandwidth is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_thenReturnExpireTimeForBandwidthIsZero2() {
    // Arrange and Act
    DelegatedResourceCapsule actualDelegatedResourceCapsule = new DelegatedResourceCapsule(new byte[]{});

    // Assert
    assertEquals(0L, actualDelegatedResourceCapsule.getExpireTimeForBandwidth());
    assertEquals(0L, actualDelegatedResourceCapsule.getExpireTimeForEnergy());
    assertEquals(0L, actualDelegatedResourceCapsule.getFrozenBalanceForBandwidth());
    assertEquals(0L, actualDelegatedResourceCapsule.getFrozenBalanceForEnergy());
    assertArrayEquals(new byte[]{}, actualDelegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_when0xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule("0XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithLfAndZero() {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-four and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithTwentyFourAndX() {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(new byte[]{24, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenArrayOfByteWithZeroAndX() {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule(" XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>When {@code (XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule("(XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#DelegatedResourceCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#createDbKey(byte[], byte[])} with {@code byte[]}, {@code byte[]}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#createDbKey(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.createDbKey(byte[], byte[])"})
  public void testCreateDbKeyWithByteByte() throws UnsupportedEncodingException {
    // Arrange
    byte[] from = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualCreateDbKeyResult = DelegatedResourceCapsule.createDbKey(from, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAXAXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Test {@link DelegatedResourceCapsule#createDbKey()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAXAXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnAxaxaxaxaxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString from = mock(ByteString.class);
    when(from.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    ByteString resultTo = mock(ByteString.class);
    when(resultTo.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = (new DelegatedResourceCapsule(from, resultTo)).createDbKey();

    // Assert
    verify(from).toByteArray();
    verify(resultTo).toByteArray();
    assertArrayEquals("AXAXAXAXAXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Test {@link DelegatedResourceCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with space and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithSpaceAndOne() {
    // Arrange
    ByteString from = mock(ByteString.class);
    when(from.isEmpty()).thenReturn(true);
    ByteString resultTo = mock(ByteString.class);
    when(resultTo.isEmpty()).thenReturn(true);

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(from, resultTo);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Act
    byte[] actualData = delegatedResourceCapsule.getData();

    // Assert
    verify(from, atLeast(1)).isEmpty();
    verify(resultTo, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{' ', 1, '0', 1}, actualData);
  }

  /**
   * Test {@link DelegatedResourceCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndMinusOne() {
    // Arrange
    ByteString from = mock(ByteString.class);
    when(from.isEmpty()).thenReturn(true);
    ByteString resultTo = mock(ByteString.class);
    when(resultTo.isEmpty()).thenReturn(true);

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(from, resultTo);
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(Long.MAX_VALUE, -1L);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Act
    byte[] actualData = delegatedResourceCapsule.getData();

    // Assert
    verify(from, atLeast(1)).isEmpty();
    verify(resultTo, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE, ' ', 1, '(', -1, -1, -1, -1, -1,
        -1, -1, -1, -1, 1, '0', 1}, actualData);
  }

  /**
   * Test {@link DelegatedResourceCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndOne() {
    // Arrange
    ByteString from = mock(ByteString.class);
    when(from.isEmpty()).thenReturn(true);
    ByteString resultTo = mock(ByteString.class);
    when(resultTo.isEmpty()).thenReturn(true);

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(from, resultTo);
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, -1L);
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Act
    byte[] actualData = delegatedResourceCapsule.getData();

    // Assert
    verify(from, atLeast(1)).isEmpty();
    verify(resultTo, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, 1, ' ', 1, '(', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '0', 1}, actualData);
  }

  /**
   * Test {@link DelegatedResourceCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-four and two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentyFourAndTwo() {
    // Arrange
    ByteString from = mock(ByteString.class);
    when(from.isEmpty()).thenReturn(true);
    ByteString resultTo = mock(ByteString.class);
    when(resultTo.isEmpty()).thenReturn(true);

    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(from, resultTo);
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(2L, 1L);

    // Act
    byte[] actualData = delegatedResourceCapsule.getData();

    // Assert
    verify(from, atLeast(1)).isEmpty();
    verify(resultTo, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{24, 2, '(', 1}, actualData);
  }

  /**
   * Test {@link DelegatedResourceCapsule#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString from = mock(ByteString.class);
    when(from.isEmpty()).thenReturn(true);
    ByteString resultTo = mock(ByteString.class);
    when(resultTo.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new DelegatedResourceCapsule(from, resultTo)).getData();

    // Assert
    verify(from, atLeast(1)).isEmpty();
    verify(resultTo, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link DelegatedResourceCapsule#getInstance()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegatedResource DelegatedResourceCapsule.getInstance()"})
  public void testGetInstance_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link DelegatedResourceCapsule#createDbKeyV2(byte[], byte[], boolean)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return array of {@code byte} with one and {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#createDbKeyV2(byte[], byte[], boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.createDbKeyV2(byte[], byte[], boolean)"})
  public void testCreateDbKeyV2_whenA_thenReturnArrayOfByteWithOneAndA() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        DelegatedResourceCapsule.createDbKeyV2(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, false));
  }

  /**
   * Test {@link DelegatedResourceCapsule#createDbKeyV2(byte[], byte[], boolean)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return array of {@code byte} with two and {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#createDbKeyV2(byte[], byte[], boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceCapsule.createDbKeyV2(byte[], byte[], boolean)"})
  public void testCreateDbKeyV2_whenAxaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithTwoAndA()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] from = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(new byte[]{2, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        DelegatedResourceCapsule.createDbKeyV2(from, "AXAXAXAX".getBytes("UTF-8"), true));
  }

  /**
   * Test {@link DelegatedResourceCapsule#getFrom()}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getFrom()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString DelegatedResourceCapsule.getFrom()"})
  public void testGetFrom() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    ByteString actualFrom = delegatedResourceCapsule.getFrom();

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualFrom.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    DelegatedResource defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getFrom());
    assertSame(byteString, defaultInstanceForType.getTo());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getTo()}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getTo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString DelegatedResourceCapsule.getTo()"})
  public void testGetTo() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    ByteString actualTo = delegatedResourceCapsule.getTo();

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualTo.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, fields.get(1).getDefaultValue());
    DelegatedResource defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getFrom());
    assertSame(byteString, defaultInstanceForType.getTo());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getFrozenBalanceForEnergy()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getFrozenBalanceForEnergy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DelegatedResourceCapsule.getFrozenBalanceForEnergy()"})
  public void testGetFrozenBalanceForEnergy_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DelegatedResourceCapsule(mock(ByteString.class), mock(ByteString.class))).getFrozenBalanceForEnergy());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForEnergy(long, long)"})
  public void testSetFrozenBalanceForEnergy() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    delegatedResourceCapsule.setFrozenBalanceForEnergy(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(4, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, ' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForEnergy(long, long)"})
  public void testSetFrozenBalanceForEnergy2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[]{});

    // Act
    delegatedResourceCapsule.setFrozenBalanceForEnergy(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForEnergy(long, long)"})
  public void testSetFrozenBalanceForEnergy3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));
    delegatedResourceCapsule.addFrozenBalanceForEnergy(8L, 8L);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForEnergy(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(4, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, ' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForEnergy(long, long)"})
  public void testSetFrozenBalanceForEnergy4() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, 8L);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForEnergy(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertEquals(6, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 24, 3, ' ', 1, '(', '\b', '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForEnergy(long, long)"})
  public void testAddFrozenBalanceForEnergy() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getFrozenBalanceForEnergy());
    assertEquals(4, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, ' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForEnergy(long, long)"})
  public void testAddFrozenBalanceForEnergy2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[]{});

    // Act
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{' ', 1, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForEnergy(long, long)"})
  public void testAddFrozenBalanceForEnergy3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));
    delegatedResourceCapsule.addFrozenBalanceForEnergy(8L, 8L);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(4, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertEquals(9L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    assertEquals(9L, instance.getFrozenBalanceForEnergy());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, ' ', '\t', '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForEnergy(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForEnergy(long, long)"})
  public void testAddFrozenBalanceForEnergy4() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, 8L);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForEnergy(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForEnergy());
    assertEquals(1L, instance.getFrozenBalanceForEnergy());
    assertEquals(6, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 24, 3, ' ', 1, '(', '\b', '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getFrozenBalanceForBandwidth()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getFrozenBalanceForBandwidth()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DelegatedResourceCapsule.getFrozenBalanceForBandwidth()"})
  public void testGetFrozenBalanceForBandwidth_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DelegatedResourceCapsule(mock(ByteString.class), mock(ByteString.class))).getFrozenBalanceForBandwidth());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getFrozenBalance(boolean)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getFrozenBalance(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DelegatedResourceCapsule.getFrozenBalance(boolean)"})
  public void testGetFrozenBalance_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DelegatedResourceCapsule(mock(ByteString.class), mock(ByteString.class))).getFrozenBalance(true));
  }

  /**
   * Test {@link DelegatedResourceCapsule#getFrozenBalance(boolean)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getFrozenBalance(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DelegatedResourceCapsule.getFrozenBalance(boolean)"})
  public void testGetFrozenBalance_thenReturnZero2() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DelegatedResourceCapsule(mock(ByteString.class), mock(ByteString.class))).getFrozenBalance(false));
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForBandwidth(long, long)"})
  public void testSetFrozenBalanceForBandwidth() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(4, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 24, 1, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForBandwidth(long, long)"})
  public void testSetFrozenBalanceForBandwidth2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[]{});

    // Act
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, 1, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForBandwidth(long, long)"})
  public void testSetFrozenBalanceForBandwidth3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));
    delegatedResourceCapsule.addFrozenBalanceForEnergy(4L, 4L);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertEquals(6, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 24, 1, ' ', 4, '(', 1, '0', 4}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setFrozenBalanceForBandwidth(long, long)"})
  public void testSetFrozenBalanceForBandwidth4() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, 4L);

    // Act
    delegatedResourceCapsule.setFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(4, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 24, 1, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForBandwidth(long, long)"})
  public void testAddFrozenBalanceForBandwidth() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1L, instance.getFrozenBalanceForBandwidth());
    assertEquals(4, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 24, 1, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForBandwidth(long, long)"})
  public void testAddFrozenBalanceForBandwidth2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[]{});

    // Act
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{24, 1, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForBandwidth(long, long)"})
  public void testAddFrozenBalanceForBandwidth3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));
    delegatedResourceCapsule.addFrozenBalanceForEnergy(4L, 4L);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(12, instance.getSerializedSize());
    assertEquals(1L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    assertEquals(1L, instance.getFrozenBalanceForBandwidth());
    assertEquals(6, instance.getAllFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 24, 1, ' ', 4, '(', 1, '0', 4}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#addFrozenBalanceForBandwidth(long, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.addFrozenBalanceForBandwidth(long, long)"})
  public void testAddFrozenBalanceForBandwidth4() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, 4L);

    // Act
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(1L, 1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(4, instance.getAllFields().size());
    assertEquals(4L, delegatedResourceCapsule.getFrozenBalanceForBandwidth());
    assertEquals(4L, instance.getFrozenBalanceForBandwidth());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 24, 4, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getExpireTimeForBandwidth()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getExpireTimeForBandwidth()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DelegatedResourceCapsule.getExpireTimeForBandwidth()"})
  public void testGetExpireTimeForBandwidth_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DelegatedResourceCapsule(mock(ByteString.class), mock(ByteString.class))).getExpireTimeForBandwidth());
  }

  /**
   * Test {@link DelegatedResourceCapsule#getExpireTimeForEnergy(DynamicPropertiesStore)} with {@code DynamicPropertiesStore}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getExpireTimeForEnergy(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DelegatedResourceCapsule.getExpireTimeForEnergy(DynamicPropertiesStore)"})
  public void testGetExpireTimeForEnergyWithDynamicPropertiesStore_thenReturnZero() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[]{});
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(1L);

    // Act
    long actualExpireTimeForEnergy = delegatedResourceCapsule.getExpireTimeForEnergy(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowMultiSign();
    assertEquals(0L, actualExpireTimeForEnergy);
  }

  /**
   * Test {@link DelegatedResourceCapsule#getExpireTimeForEnergy(DynamicPropertiesStore)} with {@code DynamicPropertiesStore}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getExpireTimeForEnergy(DynamicPropertiesStore)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DelegatedResourceCapsule.getExpireTimeForEnergy(DynamicPropertiesStore)"})
  public void testGetExpireTimeForEnergyWithDynamicPropertiesStore_thenReturnZero2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[]{});
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getAllowMultiSign()).thenReturn(0L);

    // Act
    long actualExpireTimeForEnergy = delegatedResourceCapsule.getExpireTimeForEnergy(dynamicPropertiesStore);

    // Assert
    verify(dynamicPropertiesStore).getAllowMultiSign();
    assertEquals(0L, actualExpireTimeForEnergy);
  }

  /**
   * Test {@link DelegatedResourceCapsule#getExpireTimeForEnergy()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#getExpireTimeForEnergy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DelegatedResourceCapsule.getExpireTimeForEnergy()"})
  public void testGetExpireTimeForEnergy_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DelegatedResourceCapsule(mock(ByteString.class), mock(ByteString.class))).getExpireTimeForEnergy());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForEnergy(long)"})
  public void testSetExpireTimeForEnergy() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    delegatedResourceCapsule.setExpireTimeForEnergy(1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForEnergy(long)"})
  public void testSetExpireTimeForEnergy2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[]{});

    // Act
    delegatedResourceCapsule.setExpireTimeForEnergy(1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForEnergy(long)"})
  public void testSetExpireTimeForEnergy3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));
    delegatedResourceCapsule.addFrozenBalanceForEnergy(32L, 32L);

    // Act
    delegatedResourceCapsule.setExpireTimeForEnergy(1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(4, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, ' ', ' ', '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setExpireTimeForEnergy(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForEnergy(long)"})
  public void testSetExpireTimeForEnergy4() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, 32L);

    // Act
    delegatedResourceCapsule.setExpireTimeForEnergy(1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(10, instance.getSerializedSize());
    assertEquals(5, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 24, 3, '(', ' ', '0', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForBandwidth(long)"})
  public void testSetExpireTimeForBandwidth() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));

    // Act
    delegatedResourceCapsule.setExpireTimeForBandwidth(1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, '(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForBandwidth(long)"})
  public void testSetExpireTimeForBandwidth2() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(new byte[]{});

    // Act
    delegatedResourceCapsule.setExpireTimeForBandwidth(1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'(', 1}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForBandwidth(long)"})
  public void testSetExpireTimeForBandwidth3() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));
    delegatedResourceCapsule.addFrozenBalanceForEnergy(16L, 16L);

    // Act
    delegatedResourceCapsule.setExpireTimeForBandwidth(1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(10, instance.getSerializedSize());
    assertEquals(5, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, ' ', 16, '(', 1, '0', 16}, delegatedResourceCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}.
   * <p>
   * Method under test: {@link DelegatedResourceCapsule#setExpireTimeForBandwidth(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceCapsule.setExpireTimeForBandwidth(long)"})
  public void testSetExpireTimeForBandwidth4() {
    // Arrange
    DelegatedResourceCapsule delegatedResourceCapsule = new DelegatedResourceCapsule(mock(ByteString.class),
        mock(ByteString.class));
    delegatedResourceCapsule.addFrozenBalanceForBandwidth(3L, 16L);

    // Act
    delegatedResourceCapsule.setExpireTimeForBandwidth(1L);

    // Assert
    DelegatedResource instance = delegatedResourceCapsule.getInstance();
    assertEquals(4, instance.getAllFields().size());
    assertEquals(6, instance.getDescriptorForType().getFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 24, 3, '(', 1}, delegatedResourceCapsule.getData());
  }
}
