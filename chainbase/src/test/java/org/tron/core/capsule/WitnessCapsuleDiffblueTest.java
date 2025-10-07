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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
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
   * Test {@link WitnessCapsule#WitnessCapsule(ByteString, long, String)}.
   *
   * <ul>
   *   <li>Then return Url is {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(ByteString, long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(ByteString, long, String)"})
  public void testNewWitnessCapsule_thenReturnUrlIsHttpsExampleOrgExample() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act
    WitnessCapsule actualWitnessCapsule =
        new WitnessCapsule(address, 3L, "https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", actualWitnessCapsule.getUrl());
    assertEquals(0L, actualWitnessCapsule.getLatestBlockNum());
    assertEquals(0L, actualWitnessCapsule.getLatestSlotNum());
    assertEquals(0L, actualWitnessCapsule.getTotalMissed());
    assertEquals(0L, actualWitnessCapsule.getTotalProduced());
    assertEquals(3L, actualWitnessCapsule.getVoteCount());
    assertFalse(actualWitnessCapsule.getIsJobs());
    assertSame(address, actualWitnessCapsule.getAddress());
    assertArrayEquals(
        new byte[] {
          '\n', 0, 16, 3, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p',
          'l', 'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'
        },
        actualWitnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(ByteString, String)}.
   *
   * <ul>
   *   <li>Then return Url is {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(ByteString, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(ByteString, String)"})
  public void testNewWitnessCapsule_thenReturnUrlIsHttpsExampleOrgExample2()
      throws UnsupportedEncodingException {
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
    assertArrayEquals(
        new byte[] {
          '\n', 21, 'A', 19, -117, -77, 'l', 'I', -90, ')', -16, 27, '!', 'a', '+', 17, 'Q', -31,
          -24, -124, '5', -121, -26, 26, 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e',
          'x', 'a', 'm', 'p', 'l', 'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'
        },
        actualWitnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 0XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_when0xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new WitnessCapsule("0XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 8XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_when8xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new WitnessCapsule("8XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenAAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new WitnessCapsule("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new WitnessCapsule("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code " A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new WitnessCapsule("\"\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithAAndLf_thenReturnInstanceIsNull() {
    // Arrange and Act
    WitnessCapsule actualWitnessCapsule =
        new WitnessCapsule(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 0, '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualWitnessCapsule.getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    WitnessCapsule actualWitnessCapsule =
        new WitnessCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualWitnessCapsule.getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithSixteenAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    WitnessCapsule actualWitnessCapsule =
        new WitnessCapsule(new byte[] {16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualWitnessCapsule.getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithTwentySixAndLf_thenReturnInstanceIsNull() {
    // Arrange and Act
    WitnessCapsule actualWitnessCapsule =
        new WitnessCapsule(
            new byte[] {
              26, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualWitnessCapsule.getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithTwentySixAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    WitnessCapsule actualWitnessCapsule =
        new WitnessCapsule(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualWitnessCapsule.getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange and Act
    WitnessCapsule actualWitnessCapsule =
        new WitnessCapsule(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualWitnessCapsule.getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    WitnessCapsule actualWitnessCapsule =
        new WitnessCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualWitnessCapsule.getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new WitnessCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(ByteString)}.
   *
   * <ul>
   *   <li>When {@link ByteString}.
   *   <li>Then return Url is empty string.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals(new byte[] {'\n', 0}, actualWitnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Url is empty string.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenEmptyArrayOfByte_thenReturnUrlIsEmptyString() {
    // Arrange and Act
    WitnessCapsule actualWitnessCapsule = new WitnessCapsule(new byte[] {});

    // Assert
    assertEquals("", actualWitnessCapsule.getUrl());
    assertEquals(0L, actualWitnessCapsule.getLatestBlockNum());
    assertEquals(0L, actualWitnessCapsule.getLatestSlotNum());
    assertEquals(0L, actualWitnessCapsule.getTotalMissed());
    assertEquals(0L, actualWitnessCapsule.getTotalProduced());
    assertEquals(0L, actualWitnessCapsule.getVoteCount());
    assertFalse(actualWitnessCapsule.getIsJobs());
    assertArrayEquals(new byte[] {}, actualWitnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code "XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new WitnessCapsule("\"XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code (XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new WitnessCapsule("(XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code @XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new WitnessCapsule("@XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#WitnessCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#WitnessCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.<init>(byte[])"})
  public void testNewWitnessCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new WitnessCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link WitnessCapsule#compareTo(WitnessCapsule)} with {@code WitnessCapsule}.
   *
   * <p>Method under test: {@link WitnessCapsule#compareTo(WitnessCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int WitnessCapsule.compareTo(WitnessCapsule)"})
  public void testCompareToWithWitnessCapsule() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    int actualCompareToResult =
        witnessCapsule.compareTo(new WitnessCapsule(mock(ByteString.class)));

    // Assert
    assertEquals(0, actualCompareToResult);
  }

  /**
   * Test {@link WitnessCapsule#getAddress()}.
   *
   * <p>Method under test: {@link WitnessCapsule#getAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString WitnessCapsule.getAddress()"})
  public void testGetAddress() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.getAddress();

    // Assert
    Witness instance = witnessCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(9, fields.size());
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    Witness defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(byteString, defaultInstanceForType.getAddress());
    assertSame(byteString, instance.getPubKey());
    assertSame(byteString, defaultInstanceForType.getPubKey());
  }

  /**
   * Test {@link WitnessCapsule#createDbKey()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#createDbKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] WitnessCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = new WitnessCapsule(address).createDbKey();

    // Assert
    verify(address).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Test {@link WitnessCapsule#createDbKey()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#createDbKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] WitnessCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnEmptyArrayOfByte() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, witnessCapsule.createDbKey());
  }

  /**
   * Test {@link WitnessCapsule#createReadableString()}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#toByteArray()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#createReadableString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String WitnessCapsule.createReadableString()"})
  public void testCreateReadableString_givenByteStringToByteArrayReturnNull() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn(null);

    // Act
    String actualCreateReadableStringResult = new WitnessCapsule(address).createReadableString();

    // Assert
    verify(address).toByteArray();
    assertEquals("", actualCreateReadableStringResult);
  }

  /**
   * Test {@link WitnessCapsule#createReadableString()}.
   *
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#createReadableString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String WitnessCapsule.createReadableString()"})
  public void testCreateReadableString_givenWitnessCapsuleWithDataIsEmptyArrayOfByte() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(new byte[] {});

    // Act and Assert
    assertEquals("", witnessCapsule.createReadableString());
  }

  /**
   * Test {@link WitnessCapsule#createReadableString()}.
   *
   * <ul>
   *   <li>Then return {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#createReadableString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String WitnessCapsule.createReadableString()"})
  public void testCreateReadableString_thenReturn4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualCreateReadableStringResult = new WitnessCapsule(address).createReadableString();

    // Assert
    verify(address).toByteArray();
    assertEquals("4158415841584158", actualCreateReadableStringResult);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#size()} return zero.
   *   <li>Then return array of {@code byte} with lf and zero.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_givenByteStringSizeReturnZero_thenReturnArrayOfByteWithLfAndZero() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.size()).thenReturn(0);
    when(address.isEmpty()).thenReturn(false);

    ByteString pubKey = mock(ByteString.class);
    when(pubKey.isEmpty()).thenReturn(true);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    verify(address, atLeast(1)).size();
    assertArrayEquals(new byte[] {'\n', 0}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link WitnessCapsule#WitnessCapsule(ByteString)} with address is {@link
   *       ByteString}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_givenWitnessCapsuleWithAddressIsByteString() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = new WitnessCapsule(address).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return {@code "6https://example.org/examplehttps://example.org/example} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals(
        "\"6https://example.org/examplehttps://example.org/example".getBytes("UTF-8"), actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code 0} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals(new byte[] {'0', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code 8} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals(new byte[] {'8', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code @} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals(new byte[] {'@', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code H} and one.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals(new byte[] {'H', 1}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code (} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals(new byte[] {'(', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code "} and twenty-seven.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals(
        new byte[] {
          '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e', '.',
          'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'
        },
        actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with sixteen and minus one.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals(new byte[] {16, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with sixteen and three.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals(new byte[] {16, 3}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] WitnessCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentySixAndZero() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ByteString pubKey = mock(ByteString.class);
    when(pubKey.size()).thenReturn(0);
    when(pubKey.isEmpty()).thenReturn(false);

    WitnessCapsule witnessCapsule = new WitnessCapsule(address);
    witnessCapsule.setPubKey(pubKey);

    // Act
    byte[] actualData = witnessCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).isEmpty();
    verify(pubKey, atLeast(1)).size();
    assertArrayEquals(new byte[] {26, 0}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link WitnessCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertArrayEquals(new byte[] {}, actualData);
  }

  /**
   * Test {@link WitnessCapsule#getInstance()}.
   *
   * <p>Method under test: {@link WitnessCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Witness WitnessCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    Witness actualInstance = new WitnessCapsule(mock(ByteString.class)).getInstance();

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
   *
   * <p>Method under test: {@link WitnessCapsule#setPubKey(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertSame(ByteString.EMPTY, defaultInstanceForType.getPubKey());
    assertSame(pubKey, instance.getPubKey());
    assertArrayEquals(new byte[] {'\n', 0, 26, 0}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getVoteCount()}.
   *
   * <p>Method under test: {@link WitnessCapsule#getVoteCount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long WitnessCapsule.getVoteCount()"})
  public void testGetVoteCount() {
    // Arrange, Act and Assert
    assertEquals(0L, new WitnessCapsule(mock(ByteString.class)).getVoteCount());
  }

  /**
   * Test {@link WitnessCapsule#setVoteCount(long)}.
   *
   * <p>Method under test: {@link WitnessCapsule#setVoteCount(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.setVoteCount(long)"})
  public void testSetVoteCount() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setVoteCount(3L);

    // Assert
    Witness instance = witnessCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(3L, witnessCapsule.getVoteCount());
    assertEquals(3L, instance.getVoteCount());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\n', 0, 16, 3}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getTotalProduced()}.
   *
   * <p>Method under test: {@link WitnessCapsule#getTotalProduced()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long WitnessCapsule.getTotalProduced()"})
  public void testGetTotalProduced() {
    // Arrange, Act and Assert
    assertEquals(0L, new WitnessCapsule(mock(ByteString.class)).getTotalProduced());
  }

  /**
   * Test {@link WitnessCapsule#setTotalProduced(long)}.
   *
   * <p>Method under test: {@link WitnessCapsule#setTotalProduced(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.setTotalProduced(long)"})
  public void testSetTotalProduced() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setTotalProduced(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalProduced());
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalProduced());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\n', 0, '(', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getTotalMissed()}.
   *
   * <p>Method under test: {@link WitnessCapsule#getTotalMissed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long WitnessCapsule.getTotalMissed()"})
  public void testGetTotalMissed() {
    // Arrange, Act and Assert
    assertEquals(0L, new WitnessCapsule(mock(ByteString.class)).getTotalMissed());
  }

  /**
   * Test {@link WitnessCapsule#setTotalMissed(long)}.
   *
   * <p>Method under test: {@link WitnessCapsule#setTotalMissed(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.setTotalMissed(long)"})
  public void testSetTotalMissed() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setTotalMissed(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getTotalMissed());
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getTotalMissed());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\n', 0, '0', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getLatestBlockNum()}.
   *
   * <p>Method under test: {@link WitnessCapsule#getLatestBlockNum()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long WitnessCapsule.getLatestBlockNum()"})
  public void testGetLatestBlockNum() {
    // Arrange, Act and Assert
    assertEquals(0L, new WitnessCapsule(mock(ByteString.class)).getLatestBlockNum());
  }

  /**
   * Test {@link WitnessCapsule#setLatestBlockNum(long)}.
   *
   * <p>Method under test: {@link WitnessCapsule#setLatestBlockNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.setLatestBlockNum(long)"})
  public void testSetLatestBlockNum() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setLatestBlockNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestBlockNum());
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestBlockNum());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\n', 0, '8', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getLatestSlotNum()}.
   *
   * <p>Method under test: {@link WitnessCapsule#getLatestSlotNum()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long WitnessCapsule.getLatestSlotNum()"})
  public void testGetLatestSlotNum() {
    // Arrange, Act and Assert
    assertEquals(0L, new WitnessCapsule(mock(ByteString.class)).getLatestSlotNum());
  }

  /**
   * Test {@link WitnessCapsule#setLatestSlotNum(long)}.
   *
   * <p>Method under test: {@link WitnessCapsule#setLatestSlotNum(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.setLatestSlotNum(long)"})
  public void testSetLatestSlotNum() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setLatestSlotNum(1L);

    // Assert
    assertEquals(1L, witnessCapsule.getLatestSlotNum());
    Witness instance = witnessCapsule.getInstance();
    assertEquals(1L, instance.getLatestSlotNum());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\n', 0, '@', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getIsJobs()}.
   *
   * <p>Method under test: {@link WitnessCapsule#getIsJobs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WitnessCapsule.getIsJobs()"})
  public void testGetIsJobs() {
    // Arrange, Act and Assert
    assertFalse(new WitnessCapsule(mock(ByteString.class)).getIsJobs());
  }

  /**
   * Test {@link WitnessCapsule#setIsJobs(boolean)}.
   *
   * <p>Method under test: {@link WitnessCapsule#setIsJobs(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertTrue(witnessCapsule.getIsJobs());
    assertTrue(instance.getIsJobs());
    assertArrayEquals(new byte[] {'\n', 0, 'H', 1}, witnessCapsule.getData());
  }

  /**
   * Test {@link WitnessCapsule#getUrl()}.
   *
   * <p>Method under test: {@link WitnessCapsule#getUrl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String WitnessCapsule.getUrl()"})
  public void testGetUrl() {
    // Arrange, Act and Assert
    assertEquals("", new WitnessCapsule(mock(ByteString.class)).getUrl());
  }

  /**
   * Test {@link WitnessCapsule#setUrl(String)}.
   *
   * <p>Method under test: {@link WitnessCapsule#setUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessCapsule.setUrl(String)"})
  public void testSetUrl() {
    // Arrange
    WitnessCapsule witnessCapsule = new WitnessCapsule(mock(ByteString.class));

    // Act
    witnessCapsule.setUrl("https://example.org/example");

    // Assert
    Witness instance = witnessCapsule.getInstance();
    ByteString urlBytes = instance.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", witnessCapsule.getUrl());
    assertEquals("https://example.org/example", instance.getUrl());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(31, instance.getSerializedSize());
    assertFalse(urlBytes.isEmpty());
    ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('t', iteratorResult.next().byteValue());
    assertArrayEquals(
        new byte[] {
          '\n', 0, '"', 27, 'h', 't', 't', 'p', 's', ':', '/', '/', 'e', 'x', 'a', 'm', 'p', 'l',
          'e', '.', 'o', 'r', 'g', '/', 'e', 'x', 'a', 'm', 'p', 'l', 'e'
        },
        witnessCapsule.getData());
  }
}
